package com.hjkj.hyjc.dao.admin.impl;

// Generated 2016-7-28 23:12:26 by Hibernate Tools 3.4.0.CR1

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IRoleDao;
import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.RoleQuery;

/**
 * Home object for domain model class Role.
 * 
 * @see SysRole.easy.frame.model.Role
 * @author Hibernate Tools
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl implements IRoleDao {

    public List<SysRole> findRoleByUser(String userId) {
        // 通过hql查询菜单信息
        StringBuffer hql = new StringBuffer(
                "select r from SysRole r where r.roleId in (select roleId from SysUserRole u where u.userId=:userId)");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        return findList(hql.toString(), params);
    }

    @Transactional(readOnly = true)
    public ResponsePage queryList(RoleQuery roleQuery) {
        StringBuffer hql = new StringBuffer("select r from SysRole r ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> param = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(roleQuery.getRoleName())) {
            sqlWhere.append(" and r.roleName like :roleName");
            param.put("roleName", "%" + roleQuery.getRoleName() + "%");
        }
        StringBuffer orderSql = new StringBuffer(" ");
        if (roleQuery.getOrderColumn() != null) {
            if (roleQuery.getOrderColumn() == 0) {
                orderSql.append(" order by r.roleName " + roleQuery.getOrderDir());
            }
        }
        ResponsePage responsePage = findPageList(hql.append(sqlWhere).append(orderSql).toString(), roleQuery.getStart().intValue(),
                roleQuery.getLength().intValue(), param);
        return responsePage;
    }

    public List<SysRole> findAll() {
        return findListAll(SysRole.class);
    }

}
