package com.hjkj.hyjc.comm.util;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 张敏
 * @创建时间 2017年8月8日
 */
public class StringConverter implements Converter<String, String> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.
     * Object)
     */
    @Override
    public String convert(String source) {
        if (StringUtil.isNotEmpty(source)) {
            return source;
        }
        return null;
    }

}
