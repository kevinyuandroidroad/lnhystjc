package com.hjkj.hyjc.dao.admin;

import java.util.List;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.RoleQuery;

public interface IRoleDao extends IBaseDao {

    /***
     * 根据用户查询用户用户组
     * 
     * @param userId
     * @return
     */
    public List<SysRole> findRoleByUser(String userId);

    /***
     * 查询用户组列表
     * 
     * @param roleQuery
     * @return
     */
    public ResponsePage queryList(RoleQuery roleQuery);

    /**
     * 查询所有用户
     * 
     * @return
     */
    public List<SysRole> findAll();

}