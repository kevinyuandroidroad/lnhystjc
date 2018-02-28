package com.hjkj.hyjc.dao.admin;

import java.util.List;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.admin.SysFunctions;

/***
 * @author Min
 */
public interface IFunctionsDao extends IBaseDao {

    /***
     * 根据菜单获取菜单
     * 
     * @param roleId
     * @return
     */
    public List<SysFunctions> findFunctionsByRole(String roleId);

    /***
     * 获取所有菜单
     * 
     * @return
     */
    public List<SysFunctions> findAllFunctions();

}