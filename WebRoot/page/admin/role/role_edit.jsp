<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
 <script src="../../page/admin/role/role_edit.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="role_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="roleId" value="${record.roleId }" />
      <input type="hidden" name="mark" value="${newFlag }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
     <button type="button" id="backBtn" class="btn btn-outline btn-primary ">返回</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">角色编辑</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">角色名称<span class="c_red">*</span></label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="roleName" name="roleName" value="${record.roleName }"
        placeholder="角色名称">
      </div>
     </div>
    </div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">备注</label>
      <div class="col-sm-9">
       <textarea class="form-control" id="memo" name="memo" rows="3" placeholder="备注">${record.memo }</textarea>
      </div>
     </div>
    </div>
   </div>
  </div>
 </form>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>
