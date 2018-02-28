package com.hjkj.hyjc.comm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.WebRequest;

/***
 * spring mvc 日期格式化
 * 
 * @author 张敏
 * @创建时间 2017年8月8日
 */
public class DateConverter {
    public void initBinder(WebDataBinder binder, WebRequest request) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }
}
