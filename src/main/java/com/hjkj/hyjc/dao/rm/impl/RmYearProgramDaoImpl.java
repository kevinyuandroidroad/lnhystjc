package com.hjkj.hyjc.dao.rm.impl;

import java.util.List;
import java.lang.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.rm.IRmYearProgramDao;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.model.rm.RmYearProgram;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmYearProgramQuery;
/**
 * 年度方案 表Dao
 * Table: T_RM_YEARPROGRAM - 年度方案 表
 *
 * @since ${.now}
 */
@Repository
public class RmYearProgramDaoImpl  extends BaseDaoImpl implements IRmYearProgramDao{
	@Override
    public ResponsePage queryList(RmYearProgramQuery modelQuery) {
        StringBuffer hql = new StringBuffer("select r from RmYearProgram r ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> param = new HashMap<String, Object>();       
        ResponsePage responsePage = findPageList(hql.append(sqlWhere).toString(), modelQuery.getStart().intValue(),
                modelQuery.getLength().intValue(), param);
        return responsePage;
    }

}