package com.hjkj.hyjc.service.rm;

import java.util.List;
import java.lang.*;
import com.hjkj.hyjc.model.rm.RmBulletin;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmBulletinQuery;
/**
 * 环境公报Dao
 * Table: T_RM_BULLETIN - 环境公报
 *
 * @since ${.now}
 */

public interface IRmBulletinService{

  /***
     * 删除环境公报
     * @param id
     */
    public void remove(String id);

    /***
     * 根据环境公报ID获取环境公报
     * @param id
     * @return
     */
    public RmBulletin findById(String id);   

    /***
     * 查询环境公报列表
     * @param queryModel
     * @return
     */
    public ResponsePage queryList(RmBulletinQuery queryModel);

    /***
     * 保存环境公报
     * @param entity
     */
    public void save(RmBulletin entity);

    /***
     * 查询所有环境公报
     * @return
     */
    public List<RmBulletin> findAll();

}