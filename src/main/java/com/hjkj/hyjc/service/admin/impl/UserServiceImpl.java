package com.hjkj.hyjc.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.comm.util.BeanUtil;
import com.hjkj.hyjc.comm.util.Encrypt;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.admin.IUserDao;
import com.hjkj.hyjc.model.admin.SysUserDempartment;
import com.hjkj.hyjc.model.admin.SysUserRole;
import com.hjkj.hyjc.model.admin.SysUsers;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.UserQuery;
import com.hjkj.hyjc.service.admin.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    public void save(SysUsers entity) {
        if (entity.getPassWord() != null && entity.getPassWord().length() > 0) {
            entity.setPassWord(Encrypt.encodeByMD5(entity.getPassWord()));
        }
        if (StringUtil.isNotEmpty(entity.getId())) {
            SysUsers temp = userDao.findById(SysUsers.class, entity.getId());
            BeanUtil.copyBeans(entity, temp);
            userDao.update(temp);
        } else {
            userDao.save(entity);
        }
        SysUserRole role = new SysUserRole();
        if (entity.getRole() != null) {
            role.setRoleId(entity.getRole().getRoleId());
            role.setUserId(entity.getId());
            SysUserDempartment dept = new SysUserDempartment();
            dept.setDeptId(entity.getDepartment().getDeptId());
            dept.setUserId(entity.getId());
            // 保存用户角色和部门
            userDao.saveUserDept(dept);
            userDao.saveUserRole(role);
        }
    }

    @Transactional(readOnly = false)
    public void remove(String id) {
        userDao.remove(SysUsers.class, id);
    }

    public SysUsers findById(String id) {
        return userDao.findById(SysUsers.class, id);
    }

    public SysUsers login(String loginName, String password) {
        SysUsers users = new SysUsers();
        users.setLoginName(loginName);
        users.setPassWord(password);
        List<SysUsers> currentList = userDao.findByUsers(users);
        if (currentList != null && currentList.size() > 0) {
            return currentList.get(0);
        }
        return null;
    }

    public ResponsePage queryList(UserQuery query) {
        return userDao.queryList(query);
    }

    @Override
    public boolean isExist(String loginName) {

        return userDao.isExist(loginName);
    }
}
