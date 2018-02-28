package com.hjkj.hyjc.query.rm;
import com.hjkj.hyjc.query.PageModel;
import java.util.Date;
/**
 * <p>查询类</p>
 * <p>Table: T_RM_MONTHREPORT - </p>
 *
 * @since ${.now}
 */

public class RmMonthReportQuery extends PageModel {
       
  private String reportLevel;
                            
  private Short period;
   
       
  public String getReportLevel(){
    return this.reportLevel;
  }
  
  public void setReportLevel(String reportLevel){
    this.reportLevel = reportLevel;
  }
                            
  public Short getPeriod(){
    return this.period;
  }
  
  public void setPeriod(Short period){
    this.period = period;
  }
   
 
}