package com.hjkj.hyjc.model.rm;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;

/**
 * <p>实体类</p>
 * <p>Table: T_RM_BULLETIN - 环境公报</p>
 *
 * @since ${.now}
 */
@Entity
@Table(name ="T_RM_BULLETIN")
public class RmBulletin implements java.io.Serializable {
 private static final long serialVersionUID = 1L;

    /** 公报ID */
    private String bulletinId;
    /** 公报名称 */
    private String bulletinName;
    /** 公报级别 */
    private String bulletinLevel;
    /** 编制单位 */
    private String editorOrg;
    /** 发布单位 */
    private String publishOrg;
    /** 主管机构 */
    private String authorityOrg;
    /** 编制时间 */
    private Date editorTime;
    /** 备注 */
    private String remarks;
    /**  */
    private String mark;
    /**  */
    private String maker;
    /**  */
    private Date maketime;
    /**  */
    private String updater;
    /**  */
    private Date updatetime;
    /**  */
    private Integer version;

	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
	@Column(name = "BULLETIN_ID",unique = true )
    public String getBulletinId(){
        return this.bulletinId;
    }
    public void setBulletinId(String bulletinId){
        this.bulletinId = bulletinId;
    }
	
	@Column(name = "BULLETIN_NAME",nullable = false)
    public String getBulletinName(){
        return this.bulletinName;
    }
    public void setBulletinName(String bulletinName){
        this.bulletinName = bulletinName;
    }
	
	@Column(name = "BULLETIN_LEVEL",nullable = false)
    public String getBulletinLevel(){
        return this.bulletinLevel;
    }
    public void setBulletinLevel(String bulletinLevel){
        this.bulletinLevel = bulletinLevel;
    }
	
	@Column(name = "EDITOR_ORG",nullable = false)
    public String getEditorOrg(){
        return this.editorOrg;
    }
    public void setEditorOrg(String editorOrg){
        this.editorOrg = editorOrg;
    }
	
	@Column(name = "PUBLISH_ORG",nullable = false)
    public String getPublishOrg(){
        return this.publishOrg;
    }
    public void setPublishOrg(String publishOrg){
        this.publishOrg = publishOrg;
    }
	
	@Column(name = "AUTHORITY_ORG",nullable = false)
    public String getAuthorityOrg(){
        return this.authorityOrg;
    }
    public void setAuthorityOrg(String authorityOrg){
        this.authorityOrg = authorityOrg;
    }
	
	@Column(name = "EDITOR_TIME",nullable = false)
    public Date getEditorTime(){
        return this.editorTime;
    }
    public void setEditorTime(Date editorTime){
        this.editorTime = editorTime;
    }
	
	@Column(name = "REMARKS",nullable = false)
    public String getRemarks(){
        return this.remarks;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
	
	@Column(name = "MARK")
    public String getMark(){
        return this.mark;
    }
    public void setMark(String mark){
        this.mark = mark;
    }
	
	@Column(name = "MAKER")
    public String getMaker(){
        return this.maker;
    }
    public void setMaker(String maker){
        this.maker = maker;
    }
	
	@Column(name = "MAKETIME")
    public Date getMaketime(){
        return this.maketime;
    }
    public void setMaketime(Date maketime){
        this.maketime = maketime;
    }
	
	@Column(name = "UPDATER")
    public String getUpdater(){
        return this.updater;
    }
    public void setUpdater(String updater){
        this.updater = updater;
    }
	
	@Column(name = "UPDATETIME")
    public Date getUpdatetime(){
        return this.updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }
	
	@Column(name = "VERSION")
    public Integer getVersion(){
        return this.version;
    }
    public void setVersion(Integer version){
        this.version = version;
    }
}