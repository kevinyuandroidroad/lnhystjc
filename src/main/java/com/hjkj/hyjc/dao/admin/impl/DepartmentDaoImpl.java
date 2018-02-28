package com.hjkj.hyjc.dao.admin.impl;

// Generated 2016-7-28 23:12:26 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IDepartmentDao;
import com.hjkj.hyjc.model.admin.SysDepartment;

/**
 * Home object for domain model class Department.
 * 
 * @see SysDepartment.easy.frame.model.Department
 * @author Hibernate Tools
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl implements IDepartmentDao {

    public List<SysDepartment> getDeptByUserId(String userId) {
        StringBuffer hql = new StringBuffer(
                "select d from SysDepartment d  where deptId in(select deptId from SysUserDempartment where userId=:userId)");
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return findList(hql.toString(), params);
    }

    /***
     * 递归查询所有子节点
     * 
     * @return
     */
    public List<SysDepartment> getDeptByParentDeptId(List<SysDepartment> pList) {
        List<SysDepartment> deptList = new ArrayList<SysDepartment>();
        return deptList;
    }

    @Override
    public List<SysDepartment> getChildDeptByUserId(String deptId) {
        return null;
    }

}
