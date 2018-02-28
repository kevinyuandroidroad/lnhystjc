package com.hjkj.hyjc.service.rm;

import java.util.List;

import com.hjkj.hyjc.model.rm.RmNotice;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmNoticeQuery;
/**
 * 公告表Dao
 * Table: T_RM_NOTICE - 公告表
 *
 * @since ${.now}
 */

public interface IRmNoticeService{

  /***
     * 删除公告表
     * @param id
     */
    public void remove(String id);

    /***
     * 根据公告表ID获取公告表
     * @param id
     * @return
     */
    public RmNotice findById(String id);   

    /***
     * 查询公告表列表
     * @param queryModel
     * @return
     */
    public ResponsePage queryList(RmNoticeQuery queryModel);

    /***
     * 保存公告表
     * @param entity
     */
    public void save(RmNotice entity);

    /***
     * 查询所有公告表
     * @return
     */
    public List<RmNotice> findAll();

}