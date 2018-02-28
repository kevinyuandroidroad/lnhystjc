package com.hjkj.hyjc.query.admin;

import com.hjkj.hyjc.query.PageModel;

/**
 * 角色查询用
 * @author Min
 */
public class RoleQuery extends PageModel {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
