package com.hjkj.hyjc.dao.admin;

import java.util.List;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.admin.SysUserDempartment;
import com.hjkj.hyjc.model.admin.SysUserRole;
import com.hjkj.hyjc.model.admin.SysUsers;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.UserQuery;

public interface IUserDao extends IBaseDao {

    public List<SysUsers> findByUsers(SysUsers users);

    public ResponsePage queryList(UserQuery query);

    public void saveUserDept(SysUserDempartment dept);

    public void saveUserRole(SysUserRole role);

    public boolean isExist(String loginName);

}