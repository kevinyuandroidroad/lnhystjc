package com.hjkj.hyjc.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.comm.util.BeanUtil;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.admin.IDepartmentDao;
import com.hjkj.hyjc.model.admin.SysDepartment;
import com.hjkj.hyjc.service.admin.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    IDepartmentDao departmentDao;

    @Transactional(readOnly = false)
    public void remove(String id) {
        departmentDao.remove(SysDepartment.class, id);
    }

    public List<SysDepartment> findAll() {
        return departmentDao.findListAll(SysDepartment.class);
    }

    public List<SysDepartment> getDeptByUserId(String userId) {
        return departmentDao.getDeptByUserId(userId);
    }

    public List<SysDepartment> getDeptByParentDeptId(List<SysDepartment> pList) {
        return departmentDao.getDeptByParentDeptId(pList);
    }

    @Override
    public List<SysDepartment> getChildDeptByUserId(String deptId) {
        List<SysDepartment> departments = new ArrayList<SysDepartment>();
        List<SysDepartment> deptAll = departmentDao.findListAll(SysDepartment.class);
        for (int i = 0; i < deptAll.size(); i++) {
            SysDepartment department = deptAll.get(i);
            if (department.getParentDeptId() != null) {
                if (deptId.toString().equals(department.getParentDeptId())) {
                    departments.add(department);
                    getChildDept(departments, deptAll, department);
                }
            }

        }
        return departments;
    }

    public void getChildDept(List<SysDepartment> departments, List<SysDepartment> deptAll, SysDepartment p) {
        for (int i = 0; i < deptAll.size(); i++) {
            SysDepartment department = deptAll.get(i);
            if (department.getParentDeptId() != null) {
                if (p.getDeptId().toString().equals(department.getParentDeptId())) {
                    departments.add(department);
                    getChildDept(departments, deptAll, department);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hjkj.hyjc.service.IDepartmentService#findById(java.lang.String)
     */
    @Override
    public SysDepartment findById(String id) {
        return departmentDao.findById(SysDepartment.class, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.hjkj.hyjc.service.admin.IDepartmentService#save(com.hjkj.hyjc.model.admin
     * .SysDepartment)
     */
    @Override
    public void save(SysDepartment entity) {
        if (StringUtil.isNotEmpty(entity.getDeptId())) {
            SysDepartment temp = departmentDao.findById(SysDepartment.class, entity.getDeptId());
            BeanUtil.copyBeans(entity, temp);
            departmentDao.update(temp);
        } else {
            departmentDao.save(entity);
        }

    }

}
