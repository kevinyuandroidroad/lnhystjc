package com.hjkj.hyjc.dao.admin.impl;

// Generated 2016-7-28 23:12:26 by Hibernate Tools 3.4.0.CR1

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.dao.admin.IUserRoleDao;
import com.hjkj.hyjc.model.admin.SysUserRole;

/**
 * Home object for domain model class UserRole.
 * 
 * @see SysUserRole.easy.frame.model.UserRole
 * @author Hibernate Tools
 */
@Repository
public class UserRoleDaoImpl implements IUserRoleDao {

    private Logger log = Logger.getLogger(UserRoleDaoImpl.class);

    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.easy.frame.dao.impl.IUserRoleDao#persist(cn.easy.frame.model.UserRole)
     */
    public void persist(SysUserRole transientInstance) {
        log.debug("persisting SysUserRole instance");
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
     * @see cn.easy.frame.dao.impl.IUserRoleDao#remove(cn.easy.frame.model.UserRole)
     */
    public void remove(SysUserRole persistentInstance) {
        log.debug("removing SysUserRole instance");
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
     * @see cn.easy.frame.dao.impl.IUserRoleDao#merge(cn.easy.frame.model.UserRole)
     */
    public SysUserRole merge(SysUserRole detachedInstance) {
        log.debug("merging SysUserRole instance");
        try {
            SysUserRole result = entityManager.merge(detachedInstance);
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
     * @see cn.easy.frame.dao.impl.IUserRoleDao#findById(java.lang.Integer)
     */
    public SysUserRole findById(String id) {
        log.debug("getting SysUserRole instance with id: " + id);
        try {
            SysUserRole instance = entityManager.find(SysUserRole.class, id);
            log.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}
