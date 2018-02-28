package com.hjkj.hyjc.service.admin;

import java.util.List;

import com.hjkj.hyjc.model.admin.SysFile;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.FileQuery;

public interface IFileService {

    public void persist(SysFile transientInstance);

    public void remove(String fileId);

    public SysFile merge(SysFile detachedInstance);

    public SysFile findById(String id);

    public void saveFile(List<SysFile> fileList);

    public List<SysFile> getFileByPid(String pid, String tableName);

    public ResponsePage queryList(FileQuery query);

}