<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/transitional.dtd">
<html>
<head>
<jsp:include page="/common/head.jsp"></jsp:include>
<ef:block name="script" />
<script type="text/javascript">
	function showSuccessMsg() {
		$(".alert-success").show();
		setTimeout(function() {
			$(".alert-success").hide();
		}, 1000);
	}
</script>
</head>
<body>
 <div id="wrapper">
  <jsp:include page="top.jsp"></jsp:include>
  <jsp:include page="left.jsp"></jsp:include>
  <div id="page-wrapper" style="min-height: 700px;">
   <div>
    <div class="col-lg-12">
     <ol class="breadcrumb">
      <li><a href="${ctx}/login/activeFunction.htm?funId=${sessionScope.firstFuns.funId}">${sessionScope.firstFuns.funName}</a></li>
      <c:if test="${not empty sessionScope.secondFun }">
       <li><a href="${ctx}/login/activeFunction.htm?funId=${sessionScope.secondFun.funId}">${sessionScope.secondFun.funName}</a></li>
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
 <!-- 模态框（Modal） -->
 <div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
     <h4 class="modal-title" id="myModalLabel">提示信息</h4>
    </div>
    <div class="modal-body">是否删除这条记录？</div>
    <div class="modal-footer">
     <input id="recordeId" type="hidden" />
     <button type="button" onclick="deleteById()" class="btn btn-primary" data-dismiss="modal">是</button>
     <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
    </div>
   </div>
   <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
 </div>
  <!-- 模态框（Modal） -->
 <div class="modal fade" id="locationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
     <h4 class="modal-title" id="myModalLabel">定位窗口</h4>
    </div>
    <iframe frameborder="0" width="590" height="500" src="" id="localtionIframe"></iframe>
   </div>
   <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
 </div>
 <!-- /.modal -->
</body>
</html>