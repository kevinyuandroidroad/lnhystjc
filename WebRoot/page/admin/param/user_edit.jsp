<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
 <script src="../../page/admin/user/user_edit.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="user_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="userId" value="${user.userId }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">用户编辑</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">姓名</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="userName" name="userName" value="${user.userName }"
        placeholder="请输入姓名">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">用户登录名</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" value="${user.loginName }" name="loginName" placeholder="请输入登录名">
      </div>
     </div>
    </div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">邮箱</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="userEmail" value="${user.userEmail }" name="userEmail"
        placeholder="请输入邮箱">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">手机号码</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="userTel" value="${user.userTel }" name="userTel"
        placeholder="请输入手机号码">
      </div>
     </div>
    </div>
    <c:if test="${empty user.userId }">
     <div class="row">
      <div class="form-group col-sm-6">
       <label for="lastname" class="col-sm-3 control-label">用户密码</label>
       <div class="col-sm-9">
        <input type="text" class="form-control" id="userPw" value="${user.userPw }" name="userPw" placeholder="请输入用户密码">
       </div>
      </div>
      <div class="form-group col-sm-6">
       <label for="lastname" class="col-sm-3 control-label">确认密码</label>
       <div class="col-sm-9">
        <input type="text" class="form-control" id="rePw" value="${user.userPw }" name="" placeholder="请再次输入用户密码">
       </div>
      </div>
     </div>
    </c:if>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">性别</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="gender" value="${user.gender }" name="gender" placeholder="请输入性别">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">年龄</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="gender" value="${user.gender }" name="age" placeholder="请输入年龄">
      </div>
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
