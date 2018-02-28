package com.hjkj.hyjc.comm.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hjkj.hyjc.model.admin.SysUsers;

public class GetSession {
    public static SysUsers getCurrent() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        SysUsers currentUser = (SysUsers) request.getSession(true).getAttribute("currentUser");
        return currentUser;
    }

    public static String deptChildIds() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        String childDept = (String) request.getSession(true).getAttribute("childDept");
        return childDept;
    }
}
