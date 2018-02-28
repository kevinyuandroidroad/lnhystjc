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
 * <p>Table: T_RM_MONTHREPORT - </p>
 *
 * @since ${.now}
 */
@Entity
@Table(name ="T_RM_MONTHREPORT")
public class RmMonthReport implements java.io.Serializable {
 private static final long serialVersionUID = 1L;

    /** 月报ID */
    private String reportId;
    /** 月报名称 */
    private String reportName;
    /** 月报级别 */
    private String reportLevel;
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
    /** 月报编号 */
    private String reportNum;
    /** 时期 */
    private Short period;

	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
	@Column(name = "REPORT_ID",unique = true )
    public String getReportId(){
        return this.reportId;
    }
    public void setReportId(String reportId){
        this.reportId = reportId;
    }
	
	@Column(name = "REPORT_NAME",nullable = false)
    public String getReportName(){
        return this.reportName;
    }
    public void setReportName(String reportName){
        this.reportName = reportName;
    }
	
	@Column(name = "REPORT_LEVEL",nullable = false)
    public String getReportLevel(){
        return this.reportLevel;
    }
    public void setReportLevel(String reportLevel){
        this.reportLevel = reportLevel;
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
	
	@Column(name = "REPORT_NUM",nullable = false)
    public String getReportNum(){
        return this.reportNum;
    }
    public void setReportNum(String reportNum){
        this.reportNum = reportNum;
    }
	
	@Column(name = "PERIOD")
    public Short getPeriod(){
        return this.period;
    }
    public void setPeriod(Short period){
        this.period = period;
    }
}