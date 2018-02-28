package com.hjkj.hyjc.dao.admin.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IRoleFunctionDao;
import com.hjkj.hyjc.model.admin.SysRoleFunction;

/**
 * Home object for domain model class RoleFunction.
 * 
 * @see SysRoleFunction.easy.frame.model.RoleFunction
 * @author Hibernate Tools
 */
@Repository
public class RoleFunctionDaoImpl extends BaseDaoImpl implements IRoleFunctionDao {

    public void deleteFuncByRoleId(String roleId) {
        // 删除现有权限
        String sql = "delete from SysRoleFunction r where roleId=:roleId";
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);
        execute(sql, params);
    }

    public void saveRoleFunc(String roleId, String funList) {
        // 判断是否选择了菜单
        if (StringUtil.isNotEmpty(funList)) {
            // 根据‘,’打散菜单ID集合
            String[] funcs = funList.split(",");
            for (int i = 0; i < funcs.length; i++) {
                SysRoleFunction function = new SysRoleFunction();
                function.setFunId(funcs[i]);
                function.setRoleId(roleId);
                entityManager.persist(function);
            }
        }

    }

}
