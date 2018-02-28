package com.hjkj.hyjc.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
    private String targetUrl = "";
    private String loginUserKey = "";
    private String excludeUrls = "";

    public void init(FilterConfig config) throws ServletException {
        this.targetUrl = config.getInitParameter("targetUrl");
        this.loginUserKey = config.getInitParameter("loginUserKey");
        this.excludeUrls = config.getInitParameter("excludeUrls");
        if (this.targetUrl.trim().length() == 0) {
            throw new RuntimeException("AuthFilter's param 'targetUrl' is invalid.");
        }
        if (this.loginUserKey.trim().length() == 0) {
            throw new RuntimeException("AuthFilter's param 'loginUserKey' is invalid.");
        }
    }

    public void destroy() {
        this.targetUrl = null;
        this.loginUserKey = null;
        this.excludeUrls = null;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String currentUrl = request.getServletPath();

        if (excludeUrls.trim().length() > 0 && isNotCheckedURL(excludeUrls, currentUrl)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (session == null && !targetUrl.equals(currentUrl)) {
            if (targetUrl.indexOf("/") == 0)
                response.sendRedirect(request.getContextPath() + targetUrl);
            else
                response.sendRedirect(targetUrl);
            return;
        }

        if (session.getAttribute(loginUserKey) == null) {
            response.sendRedirect(request.getContextPath() + targetUrl);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private static boolean isNotCheckedURL(String excludeUrls, String currentUrl) {
        List<Object> excludeUrlList = new ArrayList<Object>();
        if (excludeUrls == null) {
            throw new IllegalArgumentException("The param 'excludeUrls' is null.");
        }
        String[] excludeUrlsArray = excludeUrls.split(";");
        for (String url : excludeUrlsArray) {
            excludeUrlList.add(url);
        }
        return excludeUrlList.contains(currentUrl);
    }
}
