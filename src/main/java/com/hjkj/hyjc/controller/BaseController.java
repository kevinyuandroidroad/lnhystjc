package com.hjkj.hyjc.controller;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.hjkj.hyjc.comm.cons.Constant;
import com.hjkj.hyjc.model.admin.SysUsers;

public abstract class BaseController<T, ID extends Serializable> {
    protected static final String SUCCESS = "success";
    protected static final String FAILURE = "failure";
    @Autowired
    protected ServletContext servletContext;

    /***
     * 跳转到编辑页面调用的方法
     * 
     * @param model
     * @param id
     */
    public void toEdit(Model model, ID id) {
        T record;
        if (id == null) {
            model.addAttribute("newFlag", Constant.DEL_FLAG_A);
        } else {
            record = findById(id);
            model.addAttribute("newFlag", Constant.DEL_FLAG_M);
            model.addAttribute("record", record);
        }
    }

    /***
     * 根据ID获取实体
     * 
     * @param id
     * @return
     */
    protected abstract T findById(ID id);

    public SysUsers getCurrentUser(HttpServletRequest request) {
        SysUsers user = (SysUsers) request.getSession().getAttribute("currentUser");
        return user;
    }
}
