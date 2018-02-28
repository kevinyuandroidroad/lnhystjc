package com.hjkj.hyjc.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjkj.hyjc.comm.util.BeanUtil;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.admin.IRoleDao;
import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.RoleQuery;
import com.hjkj.hyjc.service.admin.IRoleService;

/***
 * 角色管理Service
 * 
 * @author Min
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao roleDao;

    public void remove(String id) {
        roleDao.remove(SysRole.class, id);
    }

    public SysRole findById(String id) {
        return roleDao.findById(SysRole.class, id);
    }

    public List<SysRole> findRoleByUser(String userId) {
        return roleDao.findRoleByUser(userId);
    }

    public ResponsePage queryList(RoleQuery roleQuery) {
        return roleDao.queryList(roleQuery);
    }

    public void save(SysRole entity) {
        if (StringUtil.isNotEmpty(entity.getRoleId())) {
            SysRole temp = roleDao.findById(SysRole.class, entity.getRoleId());
            BeanUtil.copyBeans(entity, temp);
            roleDao.update(temp);
        } else {
            roleDao.save(entity);
        }
    }

    public List<SysRole> findAll() {
        return roleDao.findAll();
    }

}
