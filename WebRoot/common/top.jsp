<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<div class="navbar navbar-default navbar-static-top top" role="navigation" id="top"
 style="background-image: url('${ctx}/assets/image/topre.png');">
 <!-- /.navbar-static-side -->
 <div class="navbar-header" style="background-image: url(''); width: 500px; height: 59px; color: #fff;">
  <div style="padding: 6px 10px; font-size: 26px;font-weight:800; ">辽宁省海洋环境监测与风险管理信息平台</div>
 </div>
 <ul class="nav navbar-top-links navbar-right">
  <c:forEach var="fun" items="${sessionScope.funMap }">
   <c:if test="${fun.value.funLevel==1 }">
    <li class="dropdown">
     <a class="dropdown-toggle" href="${ctx}/login/activeFunction.htm?funId=${fun.value.funId }">
      <c:if test="${not empty fun.value.iconStyle}">
       <i class="fa ${fun.value.iconStyle}"></i>
      </c:if>
      <c:if test="${empty fun.value.iconStyle}">
       <i class=" fa fa-th-list"></i>
      </c:if>
      ${fun.value.funName }
     </a>
    </li>
   </c:if>
  </c:forEach>
  <li class="dropdown">
   <a class="dropdown-toggle" data-toggle="dropdown" href="#">
    <i class="fa fa-user"></i>${sessionScope.currentUser.cname }<i class="fa fa-caret-down"></i>
   </a>
   <ul class="dropdown-menu dropdown-user">
    <li>
     <a href="${ctx}/admin/user/toPersonalSet.htm?userId=${sessionScope.currentUser.id }">
      <i class="fa fa-user fa-fw"></i>
      个人设置
     </a>
    </li>
    <li>
     <a href="${ctx}/admin/user/toPassWord.htm?userId=${sessionScope.currentUser.id }">
      <i class="fa  fa-lock fa-fw"></i>
      密码修改
     </a>
    </li>
    <li class="divider"></li>
    <li>
     <a href="${ctx}/login/logout.htm">
      <i class="fa fa-sign-out fa-fw"></i>
      退出
     </a>
    </li>
   </ul>
   <!-- /.dropdown-user -->
  </li>
  <!-- /.dropdown -->
 </ul>
</div>
