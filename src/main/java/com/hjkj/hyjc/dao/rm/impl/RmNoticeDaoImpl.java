package com.hjkj.hyjc.dao.rm.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.dao.rm.IRmNoticeDao;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmNoticeQuery;
/**
 * 公告表Dao
 * Table: T_RM_NOTICE - 公告表
 *
 * @since ${.now}
 */
@Repository
public class RmNoticeDaoImpl  extends BaseDaoImpl implements IRmNoticeDao{
	@Override
    public ResponsePage queryList(RmNoticeQuery modelQuery) {
        StringBuffer hql = new StringBuffer("select r from RmNotice r ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> param = new HashMap<String, Object>();       
        ResponsePage responsePage = findPageList(hql.append(sqlWhere).toString(), modelQuery.getStart().intValue(),
                modelQuery.getLength().intValue(), param);
        return responsePage;
    }

}