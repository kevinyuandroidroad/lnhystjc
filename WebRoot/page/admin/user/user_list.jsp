<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
 <script src="../../page/admin/user/user_list.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <div class="panel panel-default">
  <div class="panel-heading">
   <h3 class="panel-title">用户列表</h3>
  </div>
  <div class="panel-body">
   <div class="clearfix">
    <div class="pull-left">
     <button type="button" class="btn btn-outline btn-primary" id="btn_add">新增</button>
     <button type="button" class="btn btn-outline btn-primary" id="refresh_btn">刷新</button>
    </div>
    <div class="pull-right form-inline">
     <input type="text" class="form-control" id="loginName" name="loginName" placeholder="登录名" />
     <input type="text" class="form-control" id="cname" name="cname" placeholder="用户姓名" />
     <button type="button" id="search_btn" class="btn btn-outline btn-primary">查询</button>
    </div>
   </div>
   <div></div>
   <table class="table table-striped table-bordered table-hover" id="userTable">
    <tfoot>
     <tr>
      <td>
       <b>合计</b>
      </td>
      <td id="weightsum"></td>
      <td></td>
      <td></td>
     </tr>
    </tfoot>
   </table>
  </div>
 </div>
</ef:overwrite>
<jsp:include page="/common/template_list.jsp"></jsp:include>
