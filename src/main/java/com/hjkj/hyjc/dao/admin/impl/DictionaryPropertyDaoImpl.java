package com.hjkj.hyjc.dao.admin.impl;

// default package
// Generated 2016-8-19 22:18:42 by Hibernate Tools 4.0.0

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IDictionaryPropertyDao;
import com.hjkj.hyjc.model.admin.SysDictionaryProperty;

/**
 * Home object for domain model class DictionaryProperty.
 * 
 * @see .DictionaryProperty
 * @author Hibernate Tools
 */
@Repository
public class DictionaryPropertyDaoImpl extends BaseDaoImpl implements IDictionaryPropertyDao {

    /*
     * (non-Javadoc)
     * 
     * @see cn.easy.frame.dao.impl.IDictionaryPropertyDao#getAllDictionaryProperty()
     */
    public List<SysDictionaryProperty> getAllDictionaryProperty() {
        String hql = "from SysDictionaryProperty where mark<>'D'";
        Query query = entityManager.createQuery(hql);
        @SuppressWarnings("unchecked")
        List<SysDictionaryProperty> properties = query.getResultList();
        return properties;
    }

}
