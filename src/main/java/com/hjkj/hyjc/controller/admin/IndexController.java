package com.hjkj.hyjc.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * 首页
 * 
 * @author Min
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /***
     * 跳转到列表页面
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        return "index";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String index2(HttpServletRequest request, Model model) {
        return "index2";
    }
}
