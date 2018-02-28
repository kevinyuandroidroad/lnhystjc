package com.hjkj.hyjc.dao.admin.impl;
// default package

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.admin.IFileDao;
import com.hjkj.hyjc.model.admin.SysFile;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.FileQuery;

/**
 * Home object for domain model class EfFile.
 * 
 * @see .EfFile
 * @author Hibernate Tools
 */
@Repository
public class FileDaoImpl extends BaseDaoImpl implements IFileDao {
    /*
     * (non-Javadoc)
     * 
     * @see #getFileByPid(java.lang.String, java.lang.String)
     */
    @Override
    public List<SysFile> getFileByPid(String pid, String tableName) {
        return null;
    }

    @Override
    public ResponsePage queryList(FileQuery queryModel) {
        StringBuffer hql = new StringBuffer("select a from SysFile a ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> params = new HashMap<String, Object>();
        // 根据查询条件进行查询
        if (StringUtil.isNotEmpty(queryModel.getTableName())) {
            sqlWhere.append(" and a.fileTable = :fileTable");
            params.put("fileTable", queryModel.getTableName());
        }
        if (queryModel.getPid() != null) {
            sqlWhere.append(" and a.filePid= :filePid");
            params.put("filePid", queryModel.getPid());
        }
        ResponsePage responsePage = findPageList(hql.toString(), queryModel.getStart(), queryModel.getLength(), params);
        return responsePage;
    }
}
