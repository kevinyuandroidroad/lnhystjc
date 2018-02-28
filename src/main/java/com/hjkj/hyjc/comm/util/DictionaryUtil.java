package com.hjkj.hyjc.comm.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hjkj.hyjc.model.admin.SysDictionaryProperty;

public class DictionaryUtil {
    // 字典表Map
    public static Map<String, List<SysDictionaryProperty>> dicMap = new ConcurrentHashMap<String, List<SysDictionaryProperty>>();

    /***
     * 获取字典表属性
     * @param dicCode 字典表code
     * @param proCode字典表属性code
     * @return
     */
    public static SysDictionaryProperty getDictionaryPropertyByCode(String dicCode, String proCode) {
        List<SysDictionaryProperty> list = dicMap.get(dicCode);
        for (SysDictionaryProperty pro : list) {
            if (pro.getDicProCode().equals(proCode)) {
                return pro;
            }
        }
        return null;
    }
}
