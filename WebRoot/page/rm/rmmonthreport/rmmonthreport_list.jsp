<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
 <script src="../../page/rm/rmmonthreport/rmmonthreport_list.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <div class="panel panel-default">
  <div class="panel-heading">
   <h3 class="panel-title">列表</h3>
  </div>
  <div class="panel-body">
   <div style="display: none" class="alert alert-success">操作成功</div>
   <div class="clearfix">
    <div class="pull-left">
     <button type="button" class="btn btn-outline btn-primary" id="btn_add">新增</button>
     <button type="button" class="btn btn-outline btn-primary" id="refresh_btn">刷新</button>
    </div>
    <div class="pull-right form-inline">
    	 	 	 	 	 	 <input type="text" class="form-control "" id="reportLevel" name="loginName" placeholder="月报级别" />
	 
	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 <input type="text" class="form-control "" id="period" name="loginName" placeholder="时期" />
	 
	 	      <button type="button" class="btn btn-outline btn-primary" id="search_btn">查询</button>
    </div>
   </div>
   <div></div>
   <table class="table table-striped table-bordered table-hover" id="dataTables">
   </table>
  </div>
 </div>
</ef:overwrite>
<jsp:include page="/common/template_list.jsp"></jsp:include>
