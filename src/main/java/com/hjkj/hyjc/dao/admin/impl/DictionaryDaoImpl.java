package com.hjkj.hyjc.dao.admin.impl;

// default package
// Generated 2016-8-19 22:18:42 by Hibernate Tools 4.0.0

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.model.admin.SysDictionary;

/**
 * Home object for domain model class Dictionary.
 * 
 * @see .Dictionary
 * @author Hibernate Tools
 */
@Repository
public class DictionaryDaoImpl {

    private static final Log log = LogFactory.getLog(DictionaryDaoImpl.class);

    private EntityManager entityManager;

    public void persist(SysDictionary transientInstance) {
        log.debug("persisting SysDictionary instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void remove(SysDictionary persistentInstance) {
        log.debug("removing SysDictionary instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        } catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }

    public SysDictionary merge(SysDictionary detachedInstance) {
        log.debug("merging SysDictionary instance");
        try {
            SysDictionary result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public SysDictionary findById(Long id) {
        log.debug("getting SysDictionary instance with id: " + id);
        try {
            SysDictionary instance = entityManager.find(SysDictionary.class, id);
            log.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}
