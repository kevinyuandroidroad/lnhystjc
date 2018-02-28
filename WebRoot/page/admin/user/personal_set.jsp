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
 <script src="../../page/admin/user/personal_set.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="user_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="id" value="${user.id }" /> <input type="hidden" name="mark" value="${newFlag }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">个人设置</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">姓名<span class="c_red">*</span></label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="cname" name="cname" value="${user.cname }"
        placeholder="请输入姓名">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">用户登录名<span class="c_red">*</span></label>
      <div class="col-sm-9">
       <input type="text" class="form-control" value="${user.loginName }" readonly="readonly" name="loginName" placeholder="请输入登录名">
      </div>
     </div>
    </div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">邮箱</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="email" value="${user.email }" name="email"
        placeholder="请输入邮箱">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">手机号码</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="mobileno" value="${user.mobileno }" name="mobileno"
        placeholder="请输入手机号码">
      </div>
     </div>
    </div>
    <c:if test="${empty user.id }">
     <div class="row">
      <div class="form-group col-sm-6">
       <label for="lastname" class="col-sm-3 control-label">用户密码<span class="c_red">*</span></label>
       <div class="col-sm-9">
        <input type="text" class="form-control" id="userPw" value="${user.passWord }" name="passWord" placeholder="请输入用户密码">
       </div>
      </div>
      <div class="form-group col-sm-6">
       <label for="lastname" class="col-sm-3 control-label">确认密码<span class="c_red">*</span></label>
       <div class="col-sm-9">
        <input type="text" class="form-control" id="rePw" value="${user.passWord }" name="" placeholder="请再次输入用户密码">
       </div>
      </div>
     </div>
    </c:if>
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
