<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="css">
 <link href="${ctx}/assets/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" />
</ef:overwrite>
<ef:overwrite name="script">
 <script src="${ctx}/assets/ztree/jquery.ztree.core.min.js"></script>
 <script src="${ctx}/assets/ztree/jquery.ztree.excheck.min.js"></script>
 <script src="../../page/admin/role/role_func_edit.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <div class="clearfix">
  <div class="portlet-header">
   <div class="operation-btn pull-left">
    <input type="hidden" name="roleId" id="roleId" value="${record.roleId }" />
    <button type="button" id="saveBtn" class="btn btn-outline btn-primary ">保存</button>
    <button type="button" id="checkAllBtn" class="btn btn-outline btn-primary ">全选</button>
    <button type="button" id="cancelAllBtn" class="btn btn-outline btn-primary ">清空</button>
    <button type="button" id="backBtn" class="btn btn-outline btn-primary ">返回</button>
   </div>
  </div>
 </div>
 <div class="panel panel-default">
  <div class="panel-heading">
   <h3 class="panel-title">${record.roleName } 权限设置</h3>
  </div>
  <div class="panel-body">
   <div style="display: none" class="alert alert-success">提交成功</div>
   <form class="form-horizontal" role="form" id="role_form" action="">
    <input type="hidden" name="mark" value="${newFlag }" />
    <div class="panel-body">
     <ul id="treeDemo" class="ztree"></ul>
    </div>
   </form>
  </div>
 </div>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>
