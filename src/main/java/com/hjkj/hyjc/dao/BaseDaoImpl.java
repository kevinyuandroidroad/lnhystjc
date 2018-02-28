package com.hjkj.hyjc.dao;

/**
 * @author 张敏
 * @创建时间 2017年8月9日
 */
/**
 * 
 * @author Fandy
 *
 */

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.query.ResponsePage;

@SuppressWarnings("unchecked")
@Repository(value = "baseDao")
public class BaseDaoImpl implements IBaseDao {
    @PersistenceContext
    protected EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#find(java.lang.String)
     */
    @Override
    public <T> T find(String hql) {
        List<T> list = findList(hql);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#find(java.lang.String, java.util.Map)
     */
    @Override
    public <T> T find(String hql, Map<String, Object> params) {
        List<T> list = findList(hql, params);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#find(java.lang.Class,
     * java.io.Serializable)
     */
    @Override
    public <T> T findById(Class<T> cls, Serializable id) {
        return (T) entityManager.find(cls, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findBySql(java.lang.String)
     */
    @Override
    public <T> T findBySql(String sql, Class<T> cls) {
        List<T> list = findListBySql(sql, cls);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findBySql(java.lang.String,
     * java.util.Map)
     */
    @Override
    public <T> T findBySql(String sql, Map<String, Object> params, Class<T> cls) {
        List<T> list = findListBySql(sql, params, cls);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findList(java.lang.String)
     */
    @Override
    public <T> List<T> findList(String hql) {
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findList(java.lang.String,
     * java.util.Map)
     */
    @Override
    public <T> List<T> findList(String hql, Map<String, Object> params) {
        Query query = entityManager.createQuery(hql);
        setParameter(query, params);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findList(java.lang.Class)
     */
    @Override
    public <T> List<T> findListAll(Class<T> cls) {
        String hql = "FROM " + cls.getName();
        return findList(hql);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findListBySql(java.lang.String)
     */
    @Override
    public <T> List<T> findListBySql(String sql, Class<T> cls) {
        Query query = entityManager.createNativeQuery(sql, cls);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findListBySql(java.lang.String,
     * java.util.Map)
     */
    @Override
    public <T> List<T> findListBySql(String sql, Map<String, Object> params, Class<T> cls) {
        Query query = entityManager.createNativeQuery(sql, cls);
        setParameter(query, params);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#save(T)
     */
    @Override
    public <T> void save(T entity) {
        entityManager.persist(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#update(T)
     */
    @Override
    public <T> void update(T entity) {
        entityManager.merge(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#executeSql(java.lang.String)
     */
    @Override
    public int executeSql(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#executeSql(java.lang.String,
     * java.util.Map)
     */
    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(sql);
        setParameter(query, params);
        return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#count(java.lang.String)
     */
    @Override
    public int count(String hql) {
        Session session = (Session) entityManager.getDelegate();
        org.hibernate.Query query = session.createQuery(hql);
        ScrollableResults sr = query.scroll();
        sr.last();
        return sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#count(java.lang.String, java.util.Map)
     */
    @Override
    public int count(String hql, Map<String, Object> params) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        org.hibernate.Query query = session.createQuery(hql);
        ScrollableResults sr = query.scroll();
        sr.last();
        return sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findPageList(java.lang.String, int, int)
     */
    @Override
    public ResponsePage findPageList(String hql, int start, int length) {
        Session session = (Session) entityManager.unwrap(org.hibernate.Session.class);
        org.hibernate.Query query = session.createQuery(hql);
        return findPageList(query, start, length);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findPageList(java.lang.String, int, int,
     * java.util.Map)
     */

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#findPageList(org.hibernate.Query, int,
     * int)
     */
    public ResponsePage findPageList(org.hibernate.Query query, int start, int length) {
        ScrollableResults sr = query.scroll();
        sr.last();
        int count = sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
        query.setFirstResult(start);
        query.setMaxResults(length);
        return new ResponsePage(start, length, count, query.list());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.impl.IBaseDao#setParameter(org.hibernate.Query,
     * java.util.Map)
     */
    public void setParameter(Query query, Map<String, Object> params) {
        for (Iterator<Entry<String, Object>> iterator = params.entrySet().iterator(); iterator.hasNext();) {
            Entry<String, Object> param = iterator.next();
            query.setParameter(param.getKey(), param.getValue());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.IBaseDao#findPageList(java.lang.String, int, int,
     * java.util.Map)
     */
    @Override
    public <T> ResponsePage findPageList(String hql, int start, int length, Map<String, Object> params) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        org.hibernate.Query query = session.createQuery(hql);
        setParameter(query, params);
        return findPageList(query, start, length);
    }

    private void setParameter(org.hibernate.Query query, Map<String, Object> params) {
    	  for (Iterator<Entry<String, Object>> iterator = params.entrySet().iterator(); iterator.hasNext();) {
              Entry<String, Object> param = iterator.next();
              query.setParameter(param.getKey(), param.getValue());
          }
		
	}

	/*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.IBaseDao#remove(java.lang.Object)
     */
    @Override
    public <T> void remove(Class<T> cls, Serializable id) {
        entityManager.remove(findById(cls, id));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.IBaseDao#execute(java.lang.String)
     */
    @Override
    public int execute(String hql) {
        Query query = entityManager.createQuery(hql);
        return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.IBaseDao#execute(java.lang.String, java.util.Map)
     */
    @Override
    public int execute(String hql, Map<String, Object> params) {
        Query query = entityManager.createQuery(hql);
        setParameter(query, params);
        return query.executeUpdate();
    }
}