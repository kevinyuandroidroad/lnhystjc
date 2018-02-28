package com.hjkj.hyjc.dao.admin;

import com.hjkj.hyjc.dao.IBaseDao;

public interface IRoleFunctionDao extends IBaseDao {

    /***
     * 保存角色菜单关联
     * 
     * @param id
     * @param funList
     */
    public void saveRoleFunc(String roleId, String funList);

    /***
     * 根据角色删除菜单关联
     * 
     * @param roleId
     * @return
     */
    public void deleteFuncByRoleId(String roleId);

}