package com.hjkj.hyjc.comm.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/***
 * 格式转换工具类
 * 
 * @author 张敏
 * @创建时间 2017年8月8日
 */
public class ConverterUtil {
    // 日期转换
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat();
    protected static DecimalFormat decimalFormat = new DecimalFormat();

    /***
     * String转换为日期，要求String 格式为"yyyy-MM-dd"
     * 
     * @author 张敏
     * @param date String
     * @return java.util.Date
     * @创建时间 2017年8月8日
     */
    public synchronized static Date parseStringToDate(String date) {
        return parseStringToDate(date, "yyyy-MM-dd");
    }

    /***
     * java.util.Date转换为String
     * 
     * @author 张敏
     * @param date
     * @return java.util.Date 格式为"yyyy-MM-dd"
     * @创建时间 2017年8月8日
     */
    public synchronized static String parseDateToString(Date date) {
        return parseDateToString(date, "yyyy-MM-dd");
    }

    /***
     * String转换为日期，要求String 格式为 pattern
     * 
     * @author 张敏
     * @param date String
     * @param pattern 日期格式
     * @return java.util.Date
     * @创建时间 2017年8月8日
     */
    public synchronized static Date parseStringToDate(String date, String pattern) {
        if (pattern == null || pattern.isEmpty())
            dateFormat.applyPattern("yyyy-MM-dd");
        else
            dateFormat.applyPattern(pattern);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /***
     * java.util.Date转换为String
     * 
     * @author 张敏
     * @param date 日期 java.util.Date
     * @param pattern 日期格式
     * @return String
     * @创建时间 2017年8月8日
     */
    public synchronized static String parseDateToString(Date date, String pattern) {
        if (pattern == null || pattern.isEmpty())
            dateFormat.applyPattern("yyyy-MM-dd");
        else
            dateFormat.applyPattern(pattern);
        return dateFormat.format(date);
    }

    /***
     * Double转换成百分比
     * 
     * @author 张敏
     * @param num
     * @return
     * @创建时间 2017年8月8日
     */
    public synchronized static String parseDoubleToPercentString(Double num) {
        return parseDoubleToString(num, "#0.00%");
    }

    /***
     * Double格式化
     * 
     * @author 张敏
     * @param num
     * @return
     * @创建时间 2017年8月8日
     */
    public synchronized static String parseDoubleToString(Double num) {
        return parseDoubleToString(num, null);
    }

    public synchronized static String parseDoubleToString(Double num, String pattern) {
        if (pattern == null || pattern.isEmpty())
            decimalFormat.applyPattern("#0.00");
        else
            decimalFormat.applyPattern(pattern);
        return decimalFormat.format(num);
    }

    public synchronized static Double parsePercentStringToDouble(String num) {
        return parseStringToDouble(num, "#0.00%");
    }

    public synchronized static Double parseStringToDouble(String num) {
        return parseStringToDouble(num, null);
    }

    public synchronized static Double parseStringToDouble(String num, String pattern) {
        if (pattern == null || pattern.isEmpty())
            decimalFormat.applyPattern("#0.00");
        else
            decimalFormat.applyPattern(pattern);
        try {
            return decimalFormat.parse(num).doubleValue();
        } catch (ParseException e) {
            return null;
        }
    }

    public synchronized static String parseStringListToStrForSQL(List<String> inList) {
        String rv = "";
        if (inList == null || inList.isEmpty())
            return rv;
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < inList.size(); j++) {
            sb.append("'").append(inList.get(j)).append("'").append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        rv = sb.toString();
        return rv;
    }
}
