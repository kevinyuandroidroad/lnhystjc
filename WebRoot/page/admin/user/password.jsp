<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="css">
 <link href="${ctx}/assets/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" />
 <link href="${ctx}/assets/select2/select2.min.css" rel="stylesheet" />
</ef:overwrite>
<ef:overwrite name="script">
 <script src="${ctx}/assets/ztree/jquery.ztree.core.min.js"></script>
 <script src="${ctx}/assets/ztree/jquery.ztree.excheck.min.js"></script>
 <script src="${ctx}/assets/select2/select2.min.js"></script>
 <script src="../../page/admin/user/password.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="user_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="id" value="${record.id }" /> <input type="hidden" name="mark" value="${newFlag }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">密码修改</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    <div class="form-group col-sm-8">
     <label for="lastname" class="col-sm-3 control-label">用户密码<span class="c_red">*</span></label>
     <div class="col-sm-9">
      <input type="password" class="form-control" id="passWord" name="passWord"
       placeholder="请输入用户密码">
     </div>
    </div>
    <div class="form-group col-sm-8">
     <label for="lastname" class="col-sm-3 control-label">确认密码<span class="c_red">*</span></label>
     <div class="col-sm-9">
      <input type="password" class="form-control" id="rePw"  name="rePw" placeholder="请再次输入用户密码">
     </div>
    </div>
    <div class="row">
     <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10"></div>
     </div>
    </div>
   </div>
  </div>
 </form>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>
