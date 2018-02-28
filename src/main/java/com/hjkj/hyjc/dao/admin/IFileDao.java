package com.hjkj.hyjc.dao.admin;

import java.util.List;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.admin.SysFile;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.FileQuery;

public interface IFileDao extends IBaseDao {

    public List<SysFile> getFileByPid(String pid, String tableName);

    public ResponsePage queryList(FileQuery query);

}