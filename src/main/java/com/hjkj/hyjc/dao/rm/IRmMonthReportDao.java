package com.hjkj.hyjc.dao.rm;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmMonthReportQuery;
/**
 * Dao
 * Table: T_RM_MONTHREPORT - 
 *
 * @since ${.now}
 */

public interface IRmMonthReportDao extends IBaseDao{

    /***
     * 查询 列表
     * 
     * @param roleQuery
     * @return
     */
    public ResponsePage queryList(RmMonthReportQuery queryModel);

}