package com.hjkj.hyjc.query.admin;

import com.hjkj.hyjc.query.PageModel;

public class FileQuery extends PageModel {
    private String tableName;
    private Integer pid;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}
