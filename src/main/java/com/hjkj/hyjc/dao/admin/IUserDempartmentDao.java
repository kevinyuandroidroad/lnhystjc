package com.hjkj.hyjc.dao.admin;

import com.hjkj.hyjc.model.admin.SysUserDempartment;

public interface IUserDempartmentDao {

    public void persist(SysUserDempartment transientInstance);

    public void remove(SysUserDempartment persistentInstance);

    public SysUserDempartment merge(SysUserDempartment detachedInstance);

    public SysUserDempartment findById(String id);

}