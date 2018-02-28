package com.hjkj.hyjc.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hjkj.hyjc.query.ResponsePage;

/**
 * @author 张敏
 * @创建时间 2017年8月10日
 * @param <T>
 */
public interface IBaseDao {

    /**
     * 根据hql查询实体类
     * 
     * @param hql
     * @return
     */
    <T> T find(String hql);

    /**
     * 根据hql查询实体类
     * 
     * @param hql
     * @param 参数
     * @return
     */
    <T> T find(String hql, Map<String, Object> params);

    /**
     * 根据ID查询实体类
     * 
     * @param cls
     * @param id
     * @return
     */
    <T> T findById(Class<T> cls, Serializable id);

    /**
     * 根据Sql查询实体类
     * 
     * @param sql
     * @return
     */
    <T> T findBySql(String sql, Class<T> cls);

    /**
     * 根据Sql查询实体类
     * 
     * @param sql
     * @param 参数
     * @return
     */
    <T> T findBySql(String sql, Map<String, Object> params, Class<T> cls);

    /**
     * 根据Hql查询实体类集合
     * 
     * @param hql
     * @return
     */
    <T> List<T> findList(String hql);

    /**
     * 根据Hql查询实体类集合
     * 
     * @param hql
     * @param objects 参数
     * @return
     */
    <T> List<T> findList(String hql, Map<String, Object> params);

    /**
     * 查询表中所有数据
     * 
     * @param cls
     * @return
     */
    <T> List<T> findListAll(Class<T> cls);

    /**
     * 
     * @param sql
     * @return
     */
    <T> List<T> findListBySql(String sql, Class<T> cls);

    /**
     * 
     * @param sql
     * @param objects
     * @return
     */
    <T> List<T> findListBySql(String sql, Map<String, Object> params, Class<T> cls);

    /**
     * 
     * @param obj
     */
    <T> void save(T entity);

    /**
     * 
     * @param obj
     */
    <T> void update(T entity);

    /**
     * 
     * @param hql
     * @return
     */
    int execute(String hql);

    /**
     * 
     * @param hql
     * @return
     */
    int execute(String hql, Map<String, Object> params);

    /**
     * 
     * @param sql
     * @return
     */
    int executeSql(String sql);

    /**
     * 
     * @param sql
     * @param objects
     * @return
     */
    int executeSql(String sql, Map<String, Object> params);

    /**
     * 
     * @param hql
     * @return
     */
    int count(String hql);

    /**
     * 
     * @param hql
     * @param objects
     * @return
     */
    int count(String hql, Map<String, Object> params);

    /**
     * 
     * @param hql
     * @param start
     * @param length
     * @return
     */
    <T> ResponsePage findPageList(String hql, int start, int length);

    /**
     * 
     * @param hql
     * @param start
     * @param length
     * @param objects
     * @return
     */
    <T> ResponsePage findPageList(String hql, int start, int length, Map<String, Object> params);

    public <T> void remove(Class<T> cls, Serializable id);

}