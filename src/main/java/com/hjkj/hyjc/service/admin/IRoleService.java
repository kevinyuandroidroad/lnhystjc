package com.hjkj.hyjc.service.admin;

import java.util.List;

import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.RoleQuery;

public interface IRoleService {

    /***
     * 删除角色
     * 
     * @param id
     */
    public void remove(String id);

    /***
     * 根据角色ID获取角色
     * 
     * @param id
     * @return
     */
    public SysRole findById(String id);

    /***
     * 根据用户ID获取角色信息
     * 
     * @param userId
     * @return
     */
    public List<SysRole> findRoleByUser(String userId);

    /***
     * 查询角色列表
     * 
     * @param query
     * @return
     */
    public ResponsePage queryList(RoleQuery query);

    /***
     * 保存角色
     * 
     * @param role
     */
    public void save(SysRole role);

    /***
     * 查询所有角色
     * 
     * @return
     */
    public List<SysRole> findAll();

}
