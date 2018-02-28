package com.hjkj.hyjc.dao.rm;

import java.util.List;
import java.lang.*;
import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.rm.RmYearProgram;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmYearProgramQuery;
/**
 * 年度方案 表Dao
 * Table: T_RM_YEARPROGRAM - 年度方案 表
 *
 * @since ${.now}
 */

public interface IRmYearProgramDao extends IBaseDao{

    /***
     * 查询 年度方案 表列表
     * 
     * @param roleQuery
     * @return
     */
    public ResponsePage queryList(RmYearProgramQuery queryModel);

}