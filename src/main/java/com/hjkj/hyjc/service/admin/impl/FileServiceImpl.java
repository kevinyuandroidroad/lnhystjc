package com.hjkj.hyjc.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.dao.admin.IFileDao;
import com.hjkj.hyjc.model.admin.SysFile;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.FileQuery;
import com.hjkj.hyjc.service.admin.IFileService;

@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    IFileDao fileDao;

    @Override
    public void persist(SysFile transientInstance) {
        // TODO Auto-generated method stub

    }

    @Transactional(readOnly = false)
    @Override
    public void remove(String fileId) {
        fileDao.remove(SysFile.class, fileId);

    }

    @Override
    public SysFile merge(SysFile detachedInstance) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SysFile findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SysFile> getFileByPid(String pid, String tableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public void saveFile(List<SysFile> fileList) {
        for (int i = 0; i < fileList.size(); i++) {
            fileDao.save(fileList.get(i));
        }
    }

    @Override
    public ResponsePage queryList(FileQuery query) {
        return fileDao.queryList(query);
    }

}
