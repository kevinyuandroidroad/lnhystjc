package com.hjkj.hyjc.dao.admin;

import com.hjkj.hyjc.model.admin.SysUserRole;

public interface IUserRoleDao {

    public void persist(SysUserRole transientInstance);

    public void remove(SysUserRole persistentInstance);

    public SysUserRole merge(SysUserRole detachedInstance);

    public SysUserRole findById(String id);

}