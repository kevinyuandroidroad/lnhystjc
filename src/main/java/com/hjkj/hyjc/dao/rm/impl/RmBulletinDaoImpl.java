package com.hjkj.hyjc.dao.rm.impl;

import java.util.List;
import java.lang.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.rm.IRmBulletinDao;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.model.rm.RmBulletin;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmBulletinQuery;
/**
 * 环境公报Dao
 * Table: T_RM_BULLETIN - 环境公报
 *
 * @since ${.now}
 */
@Repository
public class RmBulletinDaoImpl  extends BaseDaoImpl implements IRmBulletinDao{
	@Override
    public ResponsePage queryList(RmBulletinQuery modelQuery) {
        StringBuffer hql = new StringBuffer("select r from RmBulletin r ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> param = new HashMap<String, Object>();       
        ResponsePage responsePage = findPageList(hql.append(sqlWhere).toString(), modelQuery.getStart().intValue(),
                modelQuery.getLength().intValue(), param);
        return responsePage;
    }

}