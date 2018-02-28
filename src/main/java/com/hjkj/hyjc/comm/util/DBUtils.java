package com.hjkj.hyjc.comm.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

/***
 * 辅助查询
 * @author Min
 */
public class DBUtils {
    /***
     * 循环添加参数
     * @param query
     * @param paramMap key为参数名称 value为参数值
     */
    public static void addParam(Query query, Map<String, Object> paramMap) {
        for (Iterator<Entry<String, Object>> iterator = paramMap.entrySet().iterator(); iterator.hasNext();) {
            Entry<String, Object> param = iterator.next();
            query.setParameter(param.getKey(), param.getValue());
        }
    }
}
