package com.hjkj.hyjc.query.rm;
import com.hjkj.hyjc.query.PageModel;
import java.util.Date;
/**
 * <p>查询类</p>
 * <p>Table: T_RM_BULLETIN - 环境公报</p>
 *
 * @since ${.now}
 */

public class RmBulletinQuery extends PageModel {
     
  private String bulletinName;
            
  private Date editorTime;
                 
     
  public String getBulletinName(){
    return this.bulletinName;
  }
  
  public void setBulletinName(String bulletinName){
    this.bulletinName = bulletinName;
  }
            
  public Date getEditorTime(){
    return this.editorTime;
  }
  
  public void setEditorTime(Date editorTime){
    this.editorTime = editorTime;
  }
                 
 
}