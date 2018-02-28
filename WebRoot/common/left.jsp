<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<div class="navbar-default sidebar" role="navigation"  id="leftme" style="margin-top: 0px;">
 <div class="sidebar-nav navbar-collapse" >
  <ul class="nav" id="side-menu" aria-expanded="true">
   <c:forEach var="fun" items="${sessionScope.firstFuns.subList}">
    <li ><c:choose>
      <c:when test="${sessionScope.secondFun.funId==fun.funId}">
       <a href="${ctx}/login/activeFunction.htm?funId=${fun.funId }" class="activef">
      </c:when>
      <c:otherwise>
       <a href="${ctx}/login/activeFunction.htm?funId=${fun.funId }">
      </c:otherwise>
     </c:choose> <c:if test="${not empty fun.iconStyle}">
      <i class="fa ${fun.iconStyle} fa-fw"></i>
     </c:if> <c:if test="${empty fun.iconStyle}">
      <i class=" fa fa-th-list fa-fw"></i>
     </c:if> ${fun.funName }<c:if test="${not empty fun.subList&& fun.subList.size()!=0}">
      <span class="fa arrow"></span>
     </c:if> </a> <c:if test="${not empty fun.subList&& fun.subList.size()!=0}">
      <ul class="nav nav-second-level collapse in">
       <c:forEach var="subfun" items="${fun.subList}">
        <li><c:choose>
          <c:when test="${sessionScope.thirdFun.funId==subfun.funId}">
           <a href="${ctx}/login/activeFunction.htm?funId=${subfun.funId }" class="active">
          </c:when>
          <c:when test="${sessionScope.secondFun.funId==subfun.funId}">
           <a href="${ctx}/login/activeFunction.htm?funId=${subfun.funId }" class="active">
          </c:when>
          <c:otherwise>
           <a href="${ctx}/login/activeFunction.htm?funId=${subfun.funId }">
          </c:otherwise>
         </c:choose> ${subfun.funName }</a></li>
       </c:forEach>
      </ul>
     </c:if></li>
   </c:forEach>
  </ul>
 </div>
 <!-- /.sidebar-collapse -->
</div>
