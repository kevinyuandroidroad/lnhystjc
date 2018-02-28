<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<ef:block name="css" />
<ef:block name="script" />
<script src="${ctx}/assets/jquery/jquery-validation/jquery.validate.min.js"></script>
<script src="${ctx}/assets/jquery/jquery-validation/messages_zh.min.js"></script>
<script type="text/javascript">
    function showSuccessMsg() {
        $(".alert-success").show();
        setTimeout(function() {
            $(".alert-success").hide();
        }, 1000);
    }
</script>
</head>
<body lang="Chinese">
 <div id="wrapper">
  <jsp:include page="top.jsp"></jsp:include>
  <jsp:include page="left.jsp"></jsp:include>
  <div id="page-wrapper">
   <div class="">
    <div class="col-lg-12">
     <ol class="breadcrumb">
      <li>
       <a href="${ctx}/login/activeFunction.htm?funId=${sessionScope.firstFuns.funId}">${sessionScope.firstFuns.funName}</a>
      </li>
      <c:if test="${not empty sessionScope.secondFun }">
       <li>
        <a href="${ctx}/login/activeFunction.htm?funId=${sessionScope.secondFun.funId}">${sessionScope.secondFun.funName}</a>
       </li>
      </c:if>
      <c:if test="${not empty sessionScope.thirdFun }">
       <li class="active">${sessionScope.thirdFun.funName}</li>
      </c:if>
     </ol>
    </div>
    <!-- /.col-lg-12 -->
   </div>
   <div class="container-fluid">
    <div class="row">
     <div class="col-lg-12">
      <ef:block name="content" />
     </div>
     <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
   </div>
   <!-- /.container-fluid -->
  </div>
  <!-- /#page-wrapper -->
 </div>
</body>
</html>