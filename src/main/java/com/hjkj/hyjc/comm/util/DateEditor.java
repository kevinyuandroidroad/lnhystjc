package com.hjkj.hyjc.comm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/***
 * spring mvc时间自定义转换器
 * 
 * @author 张敏
 * @创建时间 2017年8月8日
 */
public class DateEditor implements Converter<String, Date> {

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public Date convert(String text) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            if (text != null && text.length() > 0) {
                date = sdf.parse(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

}
