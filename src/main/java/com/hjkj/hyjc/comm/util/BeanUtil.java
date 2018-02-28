package com.hjkj.hyjc.comm.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hjkj.hyjc.comm.cons.Constant;
import com.hjkj.hyjc.model.admin.SysUsers;

/***
 * 实体类赋值相关操作
 * 
 * @author 张敏
 * @创建时间 2017年8月8日
 */
public class BeanUtil {
    /***
     * 实体类属性赋值
     * 
     * @author 张敏
     * @param objFrom 原实体类
     * @param objTo 目标实体类
     * @param excludeFields 排除字段
     * @创建时间 2017年8月8日
     */
    public static void copyBeans(Object objFrom, Object objTo, String[] excludeFields) {
        Class<? extends Object> classFrom = objFrom.getClass();
        Class<? extends Object> classTo = objTo.getClass();
        List<Field> fieldsFrom = getFildsArray(classFrom);
        List<Field> fieldsTo = getFildsArray(classTo);
        for (int i = 0; i < fieldsTo.size(); i++) {
            Field fieldTo = fieldsTo.get(i);
            for (int j = 0; j < fieldsFrom.size(); j++) {
                Field fieldFrom = fieldsFrom.get(j);
                if (fieldFrom.getName().equals(fieldTo.getName()) && fieldFrom.getType().equals(fieldTo.getType())) {
                    boolean isExclude = false;
                    if (excludeFields != null) {
                        for (int k = 0; k < excludeFields.length; k++) {
                            String excludeField = excludeFields[k];
                            if (fieldTo.getName().equals(excludeField)) {
                                isExclude = true;
                                break;
                            }
                        }
                    }
                    if (isExclude)
                        break;
                    Method getMethod = getMethod(classFrom, fieldFrom.getName(), "get");
                    if (getMethod == null)
                        break;
                    try {
                        Object value = getMethod.invoke(objFrom);
                        if (value == null)
                            break;
                        Method setMethod = getMethod(classTo, fieldFrom.getName(), "set");
                        if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                            break;
                        setMethod.invoke(objTo, value);
                    } catch (Exception ex) {
                        ex.toString();
                    }
                    break;
                }
            }
        }
    }

    public static void copyBeans(Object objFrom, Object objTo) {
        copyBeans(objFrom, objTo, null);
    }

    private static ArrayList<Field> getFildsArray(Class<? extends Object> objClass) {
        ArrayList<Field> al = null;
        Field[] fields = objClass.getDeclaredFields();
        al = new ArrayList<Field>();
        for (int i = 0; i < fields.length; i++) {
            al.add(fields[i]);
        }
        return al;
    }

    private static Method getMethod(Class<? extends Object> objClass, String fieldName, String prefix) {
        Method method = null;
        String methodName = "";
        Method[] methods = objClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            methodName = methods[i].getName();
            if (methodName.equals(prefix + upFirstChar(fieldName))) {
                method = methods[i];
                break;
            }
        }
        return method;
    }

    /***
     * 给实体类添加基础信息包括 标记 创建人等
     * 
     * @param objFrom
     * @param httpSession
     * @param type
     */
    public static void setBaseInfo(Object objFrom, HttpSession httpSession, String type) {
        Class<? extends Object> classFrom = objFrom.getClass();
        List<Field> fieldsFrom = getFildsArray(classFrom);
        SysUsers user = (SysUsers) httpSession.getAttribute("currentUser");
        // 取出实体类所有属性
        for (int j = 0; j < fieldsFrom.size(); j++) {
            Field fieldFrom = fieldsFrom.get(j);
            try {
                if (fieldFrom.getName().equals("mark")) {
                    Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                    if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                        break;
                    setMethod.invoke(objFrom, "M");
                }
                if (Constant.DEL_FLAG_A.equals(type)) {
                    if (fieldFrom.getName().equals("mark")) {
                        Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                        if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                            break;
                        setMethod.invoke(objFrom, "A");
                    }
                    if (fieldFrom.getName().equals("maker")) {
                        Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                        if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                            break;
                        setMethod.invoke(objFrom, user.getId().toString());
                    } else if (fieldFrom.getName().equals("maketime")) {
                        Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                        if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                            break;
                        setMethod.invoke(objFrom, new Date());
                    }else if (fieldFrom.getName().equals("version")) {
                        Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                        if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                            break;
                        setMethod.invoke(objFrom, 0);
                    }
                }
                if (fieldFrom.getName().equals("updater")) {
                    Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                    if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                        break;
                    setMethod.invoke(objFrom, user.getId().toString());
                } else if (fieldFrom.getName().equals("updatetime")) {
                    Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                    if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                        break;
                    setMethod.invoke(objFrom, new Date());
                } else if (fieldFrom.getName().equals("belongDeptId")) {
                    Method setMethod = getMethod(classFrom, fieldFrom.getName(), "set");
                    if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                        break;
                    setMethod.invoke(objFrom, Long.valueOf(user.getDepartment().getDeptId()));
                }
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /***
     * 翻译字典表
     * 
     * @param objFrom 要翻译的实体
     * @param fromPro 要翻译的属性
     * @param toPro 翻译到的属性
     * @param proName
     */
    public static void translateDic(Object objFrom, String fromPro, String dicName, String toPro) {
        try {
            Class<? extends Object> classFrom = objFrom.getClass();
            List<Field> fieldsFrom = getFildsArray(classFrom);
            for (int j = 0; j < fieldsFrom.size(); j++) {
                Field fieldFrom = fieldsFrom.get(j);
                if (fieldFrom.getName().equals(fromPro)) {
                    Method setMethod = getMethod(classFrom, toPro, "set");
                    if (setMethod == null || !Modifier.isPublic(setMethod.getModifiers()))
                        break;
                    if (DictionaryUtil.dicMap.containsKey(dicName)) {
                        Method getMethod = getMethod(classFrom, fieldFrom.getName(), "get");
                        Object value;
                        value = getMethod.invoke(objFrom);
                        if (value != null && DictionaryUtil.getDictionaryPropertyByCode(dicName, value.toString()) != null) {
                            String toValue = DictionaryUtil.getDictionaryPropertyByCode(dicName, value.toString()).getDicProTitle();
                            setMethod.invoke(objFrom, toValue);
                        }

                    }
                }
            }
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /***
     * 翻译字典表,List集合
     * 
     * @param objFrom 要翻译的实体
     * @param fromPro 要翻译的属性
     * @param toPro 翻译到的属性
     * @param proName
     */
    public static void translateDicList(List<?> objFrom, String fromPro, String dicName, String toPro) {
        for (int i = 0; i < objFrom.size(); i++) {
            translateDic(objFrom.get(i), fromPro, dicName, toPro);
        }
    }

    private static String upFirstChar(String str) {
        String first = (str.substring(0, 1)).toUpperCase();
        String other = str.substring(1);
        return first + other;
    }
}