package com.hjkj.hyjc.dao.rm;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmNoticeQuery;
/**
 * 公告表Dao
 * Table: T_RM_NOTICE - 公告表
 *
 * @since ${.now}
 */

public interface IRmNoticeDao extends IBaseDao{

    /***
     * 查询 公告表列表
     * 
     * @param roleQuery
     * @return
     */
    public ResponsePage queryList(RmNoticeQuery queryModel);

}