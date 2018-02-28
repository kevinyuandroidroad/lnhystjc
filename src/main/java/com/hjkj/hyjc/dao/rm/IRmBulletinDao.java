package com.hjkj.hyjc.dao.rm;

import java.util.List;
import java.lang.*;
import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.rm.RmBulletin;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmBulletinQuery;
/**
 * 环境公报Dao
 * Table: T_RM_BULLETIN - 环境公报
 *
 * @since ${.now}
 */

public interface IRmBulletinDao extends IBaseDao{

    /***
     * 查询 环境公报列表
     * 
     * @param roleQuery
     * @return
     */
    public ResponsePage queryList(RmBulletinQuery queryModel);

}