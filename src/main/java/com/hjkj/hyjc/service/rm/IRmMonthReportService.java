package com.hjkj.hyjc.service.rm;

import java.util.List;
import java.lang.*;
import com.hjkj.hyjc.model.rm.RmMonthReport;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmMonthReportQuery;
/**
 * Dao
 * Table: T_RM_MONTHREPORT - 
 *
 * @since ${.now}
 */

public interface IRmMonthReportService{

  /***
     * 删除
     * @param id
     */
    public void remove(String id);

    /***
     * 根据ID获取
     * @param id
     * @return
     */
    public RmMonthReport findById(String id);   

    /***
     * 查询列表
     * @param queryModel
     * @return
     */
    public ResponsePage queryList(RmMonthReportQuery queryModel);

    /***
     * 保存
     * @param entity
     */
    public void save(RmMonthReport entity);

    /***
     * 查询所有
     * @return
     */
    public List<RmMonthReport> findAll();

}