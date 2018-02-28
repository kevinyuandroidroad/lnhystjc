package com.hjkj.hyjc.dao.admin.impl;

// Generated 2016-7-28 23:12:26 by Hibernate Tools 3.4.0.CR1

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.dao.admin.IUserDempartmentDao;
import com.hjkj.hyjc.model.admin.SysUserDempartment;

/**
 * Home object for domain model class UserDempartment.
 * 
 * @see SysUserDempartment.easy.frame.model.UserDempartment
 * @author Hibernate Tools
 */
@Repository
public class UserDempartmentDaoImpl implements IUserDempartmentDao {

    private Logger log = Logger.getLogger(UserDempartmentDaoImpl.class);

    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see cn.easy.frame.dao.impl.IUserDempartmentDao#persist(cn.easy.frame.model.
     * UserDempartment)
     */
    public void persist(SysUserDempartment transientInstance) {
        log.debug("persisting SysUserDempartment instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.easy.frame.dao.impl.IUserDempartmentDao#remove(cn.easy.frame.model.
     * UserDempartment)
     */
    public void remove(SysUserDempartment persistentInstance) {
        log.debug("removing SysUserDempartment instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        } catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.easy.frame.dao.impl.IUserDempartmentDao#merge(cn.easy.frame.model.
     * UserDempartment)
     */
    public SysUserDempartment merge(SysUserDempartment detachedInstance) {
        log.debug("merging SysUserDempartment instance");
        try {
            SysUserDempartment result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.easy.frame.dao.impl.IUserDempartmentDao#findById(java.lang.Integer)
     */
    public SysUserDempartment findById(String id) {
        log.debug("getting SysUserDempartment instance with id: " + id);
        try {
            SysUserDempartment instance = entityManager.find(SysUserDempartment.class, id);
            log.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}
