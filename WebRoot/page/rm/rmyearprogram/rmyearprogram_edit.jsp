<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
<script src="../../page/rm/rmyearprogram/rmyearprogram_edit.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="rmyearprogram_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="programId" value="${record.programId}" />
     <input type="hidden" name="mark" value="${newFlag }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
     <button type="button" id="backBtn" class="btn btn-outline btn-primary ">返回</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">年度方案 表编辑</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>                            
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      方案名称      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="programName" name="programName" value="${record.programName}"
        placeholder="方案名称">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      方案编号      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="programCode" name="programCode" value="${record.programCode}"
        placeholder="方案编号">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      编制单位      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="editorOrg" name="editorOrg" value="${record.editorOrg}"
        placeholder="编制单位">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      发布单位      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="publishOrg" name="publishOrg" value="${record.publishOrg}"
        placeholder="发布单位">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      主管机构      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="authorityOrg" name="authorityOrg" value="${record.authorityOrg}"
        placeholder="主管机构">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      编制时间      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="editorTime" name="editorTime" value="${record.editorTime}"
        placeholder="编制时间">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      备注      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="remarks" name="remarks" value="${record.remarks}"
        placeholder="备注">
      </div>
    </div>                             
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      工作要求      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="workRequire" name="workRequire" value="${record.workRequire}"
        placeholder="工作要求">
      </div>
    </div>                                  
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      发布日期      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="publishDate" name="publishDate" value="${record.publishDate}"
        placeholder="发布日期">
      </div>
    </div>                                                      
           <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
      工作内容      <span class="c_red">*</span>      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="workContent" name="workContent" value="${record.workContent}"
        placeholder="工作内容">
      </div>
    </div>                             
        
   </div>
  </div>
 </form>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>