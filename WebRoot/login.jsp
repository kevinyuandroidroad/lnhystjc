<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>辽宁省海洋环境监测与风险管理信息平台</title>
<!-- Bootstrap Core CSS -->
<link href="${ctx}/assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/assets/dist/css/sb-admin-2.css" rel="stylesheet" />
<style type="text/css">
</style>
</head>
<body>
 <div class="container">
  <div class="row">
   <div class="col-md-4 col-md-offset-4">
    <div class="login-panel panel panel-default">
     <div class="panel-heading">
      <h3 class="panel-title">辽宁省海洋环境监测与风险管理信息平台</h3>
     </div>
     <div class="panel-body">
      <form style="" role="form" action="${ctx}/login/loginByPassword.htm" method="post">
       <fieldset>
        <div class="form-group">
         <input class="form-control" placeholder="用户名" name="loginName" type="text" autofocus>
        </div>
        <div class="form-group">
         <input class="form-control" placeholder="密码" name="password" type="password" value="">
        </div>
        <div class="checkbox">
         <label>
          <input name="remember" type="checkbox" value="Remember Me">
          记住密码
         </label>
        </div>
        <!-- Change this to a button or input when using this as a form -->
        <input class="btn btn-lg btn-success btn-block" type="submit" value="登录" />
       </fieldset>
      </form>
     </div>
    </div>
   </div>
  </div>
 </div>
</body>
</html>
