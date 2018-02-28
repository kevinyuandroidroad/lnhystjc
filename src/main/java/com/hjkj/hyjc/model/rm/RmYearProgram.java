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
 * <p>Table: T_RM_YEARPROGRAM - 年度方案 表</p>
 *
 * @since ${.now}
 */
@Entity
@Table(name ="T_RM_YEARPROGRAM")
public class RmYearProgram implements java.io.Serializable {
 private static final long serialVersionUID = 1L;

    /** 方案ID */
    private String programId;
    /** 方案名称 */
    private String programName;
    /** 方案编号 */
    private String programCode;
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
    /** 工作要求 */
    private String workRequire;
    /** 文件表表明 */
    private String fileTable;
    /** 文件ID（对应文件表） */
    private String fileId;
    /** 发布日期 */
    private Date publishDate;
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
    /** 工作内容 */
    private String workContent;

	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
	@Column(name = "PROGRAM_ID",unique = true )
    public String getProgramId(){
        return this.programId;
    }
    public void setProgramId(String programId){
        this.programId = programId;
    }
	
	@Column(name = "PROGRAM_NAME",nullable = false)
    public String getProgramName(){
        return this.programName;
    }
    public void setProgramName(String programName){
        this.programName = programName;
    }
	
	@Column(name = "PROGRAM_CODE",nullable = false)
    public String getProgramCode(){
        return this.programCode;
    }
    public void setProgramCode(String programCode){
        this.programCode = programCode;
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
	
	@Column(name = "WORK_REQUIRE",nullable = false)
    public String getWorkRequire(){
        return this.workRequire;
    }
    public void setWorkRequire(String workRequire){
        this.workRequire = workRequire;
    }
	
	@Column(name = "FILE_TABLE",nullable = false)
    public String getFileTable(){
        return this.fileTable;
    }
    public void setFileTable(String fileTable){
        this.fileTable = fileTable;
    }
	
	@Column(name = "FILE_ID",nullable = false)
    public String getFileId(){
        return this.fileId;
    }
    public void setFileId(String fileId){
        this.fileId = fileId;
    }
	
	@Column(name = "PUBLISH_DATE",nullable = false)
    public Date getPublishDate(){
        return this.publishDate;
    }
    public void setPublishDate(Date publishDate){
        this.publishDate = publishDate;
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
	
	@Column(name = "WORK_CONTENT",nullable = false)
    public String getWorkContent(){
        return this.workContent;
    }
    public void setWorkContent(String workContent){
        this.workContent = workContent;
    }
}