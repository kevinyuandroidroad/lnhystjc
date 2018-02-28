package com.hjkj.hyjc.dao.rm.impl;

import java.util.List;
import java.lang.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.rm.IRmMonthReportDao;
import com.hjkj.hyjc.dao.BaseDaoImpl;
import com.hjkj.hyjc.model.rm.RmMonthReport;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmMonthReportQuery;
/**
 * Dao
 * Table: T_RM_MONTHREPORT - 
 *
 * @since ${.now}
 */
@Repository
public class RmMonthReportDaoImpl  extends BaseDaoImpl implements IRmMonthReportDao{
	@Override
    public ResponsePage queryList(RmMonthReportQuery modelQuery) {
        StringBuffer hql = new StringBuffer("select r from RmMonthReport r ");
        StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
        Map<String, Object> param = new HashMap<String, Object>();       
        ResponsePage responsePage = findPageList(hql.append(sqlWhere).toString(), modelQuery.getStart().intValue(),
                modelQuery.getLength().intValue(), param);
        return responsePage;
    }

}