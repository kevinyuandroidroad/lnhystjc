<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tag/efTag.tld" prefix="ef"%>
<ef:overwrite name="script">
 <script src="../../page/admin/param/param.js"></script>
</ef:overwrite>
<ef:overwrite name="content">
 <form class="form-horizontal" role="form" id="param_form" action="">
  <div class="clearfix">
   <div class="portlet-header">
    <div class="operation-btn pull-left">
     <input type="hidden" name="paramId" value="${record.paramId }" />
     <button type="submit" class="btn btn-outline btn-primary ">保存</button>
    </div>
   </div>
  </div>
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">消息有效期限</h3>
   </div>
   <div class="panel-body">
    <div style="display: none" class="alert alert-success">提交成功</div>
    <div class="row">
     <div class="form-group col-sm-9">
      <label for="firstname" class="col-sm-3 control-label">测试功能点描述</label>
      <div class="col-sm-9">
       <textarea class="form-control" id="paramDesc" name="paramDesc" rows="3" placeholder="测试功能点描述">${record.paramDesc }</textarea>
      </div>
     </div>
    </div>
    <div class="page-header">
     <h4>指标设定</h4>
    </div>
    <div class="row">
     <div class="form-group col-sm-9">
      <label class="col-sm-3 control-label">消息有效期限</label>
      <div class="col-sm-9">
       <div class="col-sm-6">
        <select class="form-control" id="pro_valid" name='pro_${record.proMap["pro_valid"].proId }'>
         <c:forEach var="pro" items="${valid_test_set }">
          <c:if test='${record.proMap["pro_valid"].proValue eq pro.dicProCode}'>
           <option value="${pro.dicProCode }" selected="selected">${pro.dicProTitle }</option>
          </c:if>
          <c:if test='${record.proMap["pro_valid"].proValue ne pro.dicProCode }'>
           <option value="${pro.dicProCode }">${pro.dicProTitle }</option>
          </c:if>
         </c:forEach>
        </select>
       </div>
      </div>
     </div>
    </div>
    <div class="row" id="pro_valid_element">
     <div class="form-group col-sm-9">
      <label class="col-sm-3 control-label">自增步长</label>
      <div class="col-sm-9">
       <div class="col-sm-6">
        <input class="form-control" id="pro_identity_value" name='pro_${record.proMap["pro_identity_value"].proId }'
         value='${record.proMap["pro_identity_value"].proValue }' type="text" placeholder="数值" />
       </div>
       <div class="col-sm-2">
        <select class="form-control" id="pro_identity_u" name='pro_${record.proMap["pro_identity_u"].proId }'>
         <c:forEach var="pro" items="${time_u }">
          <c:if test='${record.proMap["pro_identity_u"].proValue eq pro.dicProCode}'>
           <option value="${pro.dicProCode }" selected="selected">${pro.dicProTitle }</option>
          </c:if>
          <c:if test='${record.proMap["pro_identity_u"].proValue ne pro.dicProCode }'>
           <option value="${pro.dicProCode }">${pro.dicProTitle }</option>
          </c:if>
         </c:forEach>
        </select>
       </div>
      </div>
     </div>
    </div>
    <div class="row">
     <div class="form-group col-sm-9">
      <label class="col-sm-3 control-label">输出值类型</label>
      <div class="col-sm-9">
       <div class="col-sm-6">
        <select class="form-control" id="pro_out_type" name='pro_${record.proMap["pro_out_type"].proId}'>
         <c:forEach var="pro" items="${out_type }">
          <c:if test='${record.proMap["pro_out_type"].proValue eq pro.dicProCode}'>
           <option value="${pro.dicProCode }" selected="selected">${pro.dicProTitle }</option>
          </c:if>
          <c:if test='${record.proMap["pro_out_type"].proValue ne pro.dicProCode }'>
           <option value="${pro.dicProCode }">${pro.dicProTitle }</option>
          </c:if>
         </c:forEach>
        </select>
       </div>
       <div class="col-sm-2">
        <input class="form-control" id="pro_out_per" name='pro_${record.proMap["pro_out_per"].proId }'
         value='${record.proMap["pro_out_per"].proValue }' type="text" placeholder="百分比" />
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
 </form>
</ef:overwrite>
<jsp:include page="/common/template_edit.jsp"></jsp:include>
