package com.hjkj.hyjc.service.admin;

import java.util.List;
import java.util.Map;

import com.hjkj.hyjc.model.admin.SysFunctions;

public interface IFunctionsService {

    /***
     * 删除菜单
     * 
     * @param id
     */
    public void remove(String id);

    /***
     * 根据ID查询菜单
     * 
     * @param id
     * @return
     */
    public SysFunctions findById(String id);

    /***
     * 根据角色获取菜单
     * 
     * @param roleId
     * @return
     */
    public Map<String, SysFunctions> findFunctionsByRole(String roleId);

    /***
     * 根据角色获取菜单
     * 
     * @param roleId
     * @return
     */
    public List<SysFunctions> findFuncListByRole(String roleId);

    /***
     * 获取所有菜单
     * 
     * @return
     */
    public List<SysFunctions> findAllFunctions();

    /***
     * 保存角色菜单
     * 
     * @param id
     * @param funList
     */
    public void saveRoleFunc(String id, String funList);
}
