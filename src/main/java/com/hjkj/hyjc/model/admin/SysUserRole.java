package com.hjkj.hyjc.model.admin;

// Generated 2016-7-28 22:05:05 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * EfUserRole generated by hbm2java
 */
@Entity
@Table(name = "T_SYS_USER_ROLE")
public class SysUserRole implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String serialId;
    private String userId;
    private String roleId;
    private String memo;

    public SysUserRole() {
    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "serial_id", unique = true, nullable = false)
    public String getSerialId() {
        return this.serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    @Column(name = "user_id", nullable = false, length = 100)
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "role_id", nullable = false, length = 100)
    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "memo", length = 500)
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
