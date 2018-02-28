package com.hjkj.hyjc.service.rm;

import java.util.List;
import java.lang.*;
import com.hjkj.hyjc.model.rm.RmYearProgram;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmYearProgramQuery;
/**
 * 年度方案 表Dao
 * Table: T_RM_YEARPROGRAM - 年度方案 表
 *
 * @since ${.now}
 */

public interface IRmYearProgramService{

  /***
     * 删除年度方案 表
     * @param id
     */
    public void remove(String id);

    /***
     * 根据年度方案 表ID获取年度方案 表
     * @param id
     * @return
     */
    public RmYearProgram findById(String id);   

    /***
     * 查询年度方案 表列表
     * @param queryModel
     * @return
     */
    public ResponsePage queryList(RmYearProgramQuery queryModel);

    /***
     * 保存年度方案 表
     * @param entity
     */
    public void save(RmYearProgram entity);

    /***
     * 查询所有年度方案 表
     * @return
     */
    public List<RmYearProgram> findAll();

}