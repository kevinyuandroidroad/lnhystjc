<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="css">
 <link href="${ctx}/assets/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" />
</ef:overwrite>
<ef:overwrite name="script">
 <script src="${ctx}/assets/ztree/jquery.ztree.core.min.js"></script>
 <script src="${ctx}/assets/ztree/jquery.ztree.excheck.min.js"></script>
 <script src="../../page/admin/dept/dept_list.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <div class="panel panel-default">
  <div class="panel-heading">
   <h3 class="panel-title">机构管理</h3>
  </div>
  <div class="panel-body">
   <div class="row">
    <div class="col-sm-3">
     <div class="panel panel-default" style="min-height: 500px;">
      <div class="panel-heading">
       <h3 class="panel-title">机构组</h3>
      </div>
      <div class="panel-body">
       <ul id="deptTree" class="ztree"></ul>
      </div>
     </div>
    </div>
    <div class="col-sm-9">
     <div class="clearfix">
      <div class="pull-left">
       <button type="button" class="btn btn-outline btn-primary" id="add_btn">新增</button>
       <button type="button" class="btn btn-outline btn-primary" id="save_btn">保存</button>
       <button type="button" class="btn btn-outline btn-primary" id="del_btn">删除</button>
      </div>
     </div>
     <div class="panel panel-default" style="min-height: 454px;">
      <div class="panel-body">
       <div style="display: none" class="alert alert-success">提交成功</div>
       <form class="form-horizontal" role="form" id="dept_form" action="">
        <input type="hidden" name="mark" id="mark" />
        <input type="hidden" name="parentDeptId" id="parentDeptId" />
        <input type="hidden" name="deptLevel" id="deptLevel" />
        <div class="row">
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">用户组编码</label>
          <div class="col-sm-9">
           <input type="text" class="form-control" readonly="readonly" id="deptId" name="deptId" placeholder="用户组编码">
          </div>
         </div>
        </div>
        <div class="row">
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">机构名称<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="deptName" name="deptName" placeholder="机构名称">
          </div>
         </div>
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">组织代码<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="deptCode" name="deptCode" placeholder="组织代码">
          </div>
         </div>
        </div>
        <div class="row">
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">机构地址<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="deptAddress" name="deptAddress" placeholder="机构地址">
          </div>
         </div>
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">机构电话<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="deptTel" name="deptTel" placeholder="机构电话">
          </div>
         </div>
        </div>
        <div class="row">
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">机构类型<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <select  class="form-control" id="deptType" name="deptType">
			<option>1类</option>
			<option>2类</option>
			<option>3类</option>
			<option>4类</option>
			<option>5类</option>
			</select>
          </div>
         </div>
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">规则编码<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="ruleCode" name="ruleCode" placeholder="规则编码">
          </div>
         </div>
        </div>
        
        <div class="row">
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">组织等级<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="deptGrade" name="deptGrade" placeholder="组织等级">
          </div>
         </div>
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">组织范围<span class="c_red">*</span></label>
          <div class="col-sm-9">
           <input type="text" class="form-control" id="deptRange" name="deptRange" placeholder="组织范围">
          </div>
         </div>
        </div>
        <div class="row">
         <div class="form-group col-sm-6">
          <label for="firstname" class="col-sm-3 control-label">是否启用</label>
          <div class="col-sm-9">
           <label class="radio-inline"> <input name="status" id="statusY" value="Y" checked="checked"
            type="radio">是
           </label> <label class="radio-inline"> <input name="status" id="statusN" value="N" type="radio">否
           </label>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
    </div>
   </div>
  </div>
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
 <!-- /.modal -->
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>
