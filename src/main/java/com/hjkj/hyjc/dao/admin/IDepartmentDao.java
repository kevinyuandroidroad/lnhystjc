package com.hjkj.hyjc.dao.admin;

import java.util.List;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.admin.SysDepartment;

public interface IDepartmentDao extends IBaseDao {

    public List<SysDepartment> getDeptByUserId(String userId);

    public List<SysDepartment> getDeptByParentDeptId(List<SysDepartment> pList);

    public List<SysDepartment> getChildDeptByUserId(String deptId);

}