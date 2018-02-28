package com.hjkj.hyjc.dao.admin.impl;

// Generated 2016-7-28 23:12:26 by Hibernate Tools 3.4.0.CR1

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IUserDao;
import com.hjkj.hyjc.model.admin.SysUserDempartment;
import com.hjkj.hyjc.model.admin.SysUserRole;
import com.hjkj.hyjc.model.admin.SysUsers;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.UserQuery;

/**
 * Home object for domain model class Users.
 * 
 * @see SysUsers.easy.frame.model.Users
 * @author Hibernate Tools
 */
@Repository
public class UsersDaoImpl extends BaseDaoImpl implements IUserDao {

    public List<SysUsers> findByUsers(SysUsers users) {
        StringBuffer hql = new StringBuffer("select u from SysUsers u where 1=1");
        Map<String, Object> param = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(users.getLoginName())) {
            hql.append(" and u.loginName=:loginName");
            param.put("loginName", users.getLoginName());
        }
        if (StringUtil.isNotEmpty(users.getPassWord())) {
            hql.append(" and u.passWord=:passWord");
            param.put("passWord", users.getPassWord());
        }
        List<SysUsers> result = findList(hql.toString(), param);
        // 给查询参数赋值
        return result;
    }

    public ResponsePage queryList(UserQuery queryModel) {
        StringBuffer hql = new StringBuffer("select u from SysUsers u ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> param = new HashMap<String, Object>();
        // 根据查询条件进行查询
        if (StringUtil.isNotEmpty(queryModel.getLoginName())) {
            sqlWhere.append(" and u.loginName like :loginName");
            param.put("loginName", "%" + queryModel.getLoginName() + "%");
        }
        if (StringUtil.isNotEmpty(queryModel.getUserName())) {
            sqlWhere.append(" and u.userName= :userName");
            param.put("userName", "%" + queryModel.getUserName() + "%");
        }
        StringBuffer orderWhere = new StringBuffer(" ");
        if (queryModel.getOrderColumn() != null) {
            if (queryModel.getOrderColumn() == 1) {
                orderWhere.append(" order by u.loginName " + queryModel.getOrderDir());
            } else if (queryModel.getOrderColumn() == 0) {
                orderWhere.append(" order by u.userName " + queryModel.getOrderDir());
            }
        }
        return findPageList(hql.append(sqlWhere.toString()).append(orderWhere).toString(), queryModel.getStart(), queryModel.getLength(),
                param);
    }

    @Override
    public boolean isExist(String loginName) {
        StringBuffer hql = new StringBuffer("select u from SysUsers u where 1=1");
        Map<String, Object> param = new HashMap<String, Object>();
        hql.append(" and u.loginName=:loginName");
        param.put("loginName", loginName);
        List<SysUsers> result = findList(hql.toString(), param);
        if (result != null && loginName.length() > 0) {
            return true;
        }
        // 给查询参数赋值
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.IUserDao#saveUserDept(com.hjkj.hyjc.model.
     * SysUserDempartment)
     */
    @Override
    public void saveUserDept(SysUserDempartment dept) {
        Map<String, Object> params = new HashMap<>();
        // 删除原有部门
        StringBuffer hql = new StringBuffer("delete from SysUserDempartment where  userId=:userId");
        params.put("userId", dept.getUserId());
        execute(hql.toString(), params);
        save(dept);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.dao.IUserDao#saveUserRole(com.hjkj.hyjc.model.SysUserRole)
     */
    @Override
    public void saveUserRole(SysUserRole role) {
        Map<String, Object> params = new HashMap<>();
        // 删除原有角色
        StringBuffer hql = new StringBuffer("delete from SysUserRole where  userId=:userId");
        params.put("userId", role.getUserId());
        execute(hql.toString(), params);
        save(role);
    }
}
