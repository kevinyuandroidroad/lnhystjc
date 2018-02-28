<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
<script src="../../page/rm/rmmonthreport/rmmonthreport_edit.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="rmmonthreport_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="reportId" value="${record.reportId}" />
     <input type="hidden" name="mark" value="${newFlag }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
     <button type="button" id="backBtn" class="btn btn-outline btn-primary ">返回</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">编辑</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    	    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      月报名称      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="reportName" name="reportName" value="${record.reportName}"
        placeholder="月报名称">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      月报级别      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="reportLevel" name="reportLevel" value="${record.reportLevel}"
        placeholder="月报级别">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      编制单位      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="editorOrg" name="editorOrg" value="${record.editorOrg}"
        placeholder="编制单位">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      发布单位      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="publishOrg" name="publishOrg" value="${record.publishOrg}"
        placeholder="发布单位">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      主管机构      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="authorityOrg" name="authorityOrg" value="${record.authorityOrg}"
        placeholder="主管机构">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      编制时间      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control form_datetime" id="editorTime" name="editorTime" value="${record.editorTime}"
        placeholder="编制时间">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      备注           </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="remarks" name="remarks" value="${record.remarks}"
        placeholder="备注">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      月报编号      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="reportNum" name="reportNum" value="${record.reportNum}"
        placeholder="月报编号">	  
      </div>
    </div>   
    	       <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      时期        <span class="c_red">*</span>     </label>
      <div class="col-sm-9">	  
       <input type="text" class="form-control " id="period" name="period" value="${record.period}"
        placeholder="时期">	  
      </div>
    </div>   
        
   </div>
  </div>
 </form>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>