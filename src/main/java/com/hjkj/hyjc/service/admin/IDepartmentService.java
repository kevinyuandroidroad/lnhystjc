package com.hjkj.hyjc.service.admin;

import java.util.List;

import com.hjkj.hyjc.model.admin.SysDepartment;

public interface IDepartmentService {

    public void save(SysDepartment transientInstance);

    public void remove(String id);

    public SysDepartment findById(String id);

    public List<SysDepartment> findAll();

    public List<SysDepartment> getDeptByUserId(String userId);

    public List<SysDepartment> getDeptByParentDeptId(List<SysDepartment> pList);

    public List<SysDepartment> getChildDeptByUserId(String deptId);
}