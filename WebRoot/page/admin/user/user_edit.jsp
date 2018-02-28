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
 <script src="../../page/admin/user/user_edit.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="user_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="id" value="${user.id}" />
     <input type="hidden" name="mark" value="${newFlag}" />
     
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
     <button type="button" id="backBtn" class="btn btn-outline btn-primary ">返回</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">用户编辑</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    <div style="display: none" id="msgError" class="alert alert-danger">提交成功</div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="firstname" class="col-sm-3 control-label">
       姓名
       <span class="c_red">*</span>
      </label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="cname" name="cname" value="${user.cname}" placeholder="请输入姓名">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">
       用户登录名
       <span class="c_red">*</span>
      </label>
      <div class="col-sm-9">
       <c:if test="${empty user.id }">
        <input type="text" class="form-control" value="${user.loginName }" name="loginName" placeholder="请输入登录名">
       </c:if>
       <c:if test="${not empty user.id }">
        <input type="text" class="form-control" readonly="readonly" value="${user.loginName }" name="loginName" placeholder="请输入登录名">
       </c:if>
      </div>
     </div>
    </div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">
       组织机构
       <span class="c_red">*</span>
      </label>
      <div class="col-sm-9 ">
       <input type="text" readonly="readonly" onclick="deptModal(); " class="form-control" id="deptNames"
        value="${user.department.deptName}" name="department.deptName" placeholder="请选择组织机构">
       <input type="hidden" class="form-control" id="deptIds" value="${user.department.deptId}" name="department.deptId">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">
       用户角色
       <span class="c_red">*</span>
      </label>
      <div class="col-sm-9">
       <select class="form-control" id="roleNames" name="role.roleId">
        <c:forEach var="role" items="${roleList}">
         <c:if test="${role.roleId eq user.role.roleId }">
          <option selected="selected" value="${role.roleId }">${role.roleName }</option>
         </c:if>
         <c:if test="${role.roleId ne user.role.roleId }">
          <option value="${role.roleId }">${role.roleName }</option>
         </c:if>
        </c:forEach>
       </select>
      </div>
     </div>
    </div>
    <div class="row">
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">邮箱</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="email" value="${user.email }" name="email" placeholder="请输入邮箱">
      </div>
     </div>
     <div class="form-group col-sm-6">
      <label for="lastname" class="col-sm-3 control-label">手机号码</label>
      <div class="col-sm-9">
       <input type="text" class="form-control" id="mobileno" value="${user.mobileno }" name="mobileno" placeholder="请输入手机号码">
      </div>
     </div>
    </div>
    <c:if test="${empty user.id }">
     <div class="row">
      <div class="form-group col-sm-6">
       <label for="lastname" class="col-sm-3 control-label">
        用户密码
        <span class="c_red">*</span>
       </label>
       <div class="col-sm-9">
        <input type="text" class="form-control" id="passWord" value="${user.passWord }" name="passWord" placeholder="请输入用户密码">
       </div>
      </div>
      <div class="form-group col-sm-6">
       <label for="lastname" class="col-sm-3 control-label">
        确认密码
        <span class="c_red">*</span>
       </label>
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
 </form>
 <!-- 模态框（Modal） -->
 <div class="modal fade" id="deptModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
     <h4 class="modal-title" id="myModalLabel">组织机构选择</h4>
    </div>
    <div class="modal-body">
     <ul id="deptTree" class="ztree"></ul>
    </div>
    <div class="modal-footer">
     <input id="runRecordeId" type="hidden" />
     <button type="button" onclick="doneDept()" class="btn btn-primary" data-dismiss="modal">确定</button>
     <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
    </div>
   </div>
   <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
 </div>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>
