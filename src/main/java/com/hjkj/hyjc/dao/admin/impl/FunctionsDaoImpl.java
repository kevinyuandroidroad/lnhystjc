package com.hjkj.hyjc.dao.admin.impl;

import java.util.HashMap;

// Generated 2016-7-28 23:12:26 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IFunctionsDao;
import com.hjkj.hyjc.model.admin.SysFunctions;

/**
 * Home object for domain model class Functions.
 * 
 * @see SysFunctions.easy.frame.model.Functions
 * @author Hibernate Tools
 */
@Repository
public class FunctionsDaoImpl extends BaseDaoImpl implements IFunctionsDao {

    public List<SysFunctions> findFunctionsByRole(String roleId) {
        // 通过hql查询菜单信息
        StringBuffer hql = new StringBuffer(
                "select f from SysFunctions f where f.funId in (select funId from SysRoleFunction  where roleId=:roleId) order by funIndex ");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", roleId);
        return findList(hql.toString(), params);
    }

    public List<SysFunctions> findAllFunctions() {
        StringBuffer hql = new StringBuffer("from SysFunctions where mark<>'D'");
        return findList(hql.toString());
    }
}
