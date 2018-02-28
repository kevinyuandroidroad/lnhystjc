package com.hjkj.hyjc.comm.util;

/**
 * 提供字符串常用处理
 * @author min
 */
public class StringUtil {
    /**
     * 将一个存放数字类型主键值的数组重新组合成一个字符串
     * @param ids 主键值数组
     * @return
     */
    public String spliceIdsOfNumber(Object[] ids) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : ids) {
            sb.append(obj.toString()).append(",");
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }

    /**
     * 将一个存放字符类型主键值的数组重新组合成一个字符串
     * @param ids 主键值数组
     * @return
     */
    public String spliceIdsOfChar(Object[] ids) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : ids) {
            sb.append("'").append(obj.toString()).append("'").append(",");
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }

    public static boolean isNotEmpty(String str) {
        if (str != null && str.trim().length() > 0) {
            return true;
        }
        return false;
    }

    public static String getString(String str) {
        if (str != null && str.trim().length() > 0) {
            return str;
        }
        return "";
    }
}
