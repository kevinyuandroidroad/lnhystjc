<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 名称待定 -->
<title>辽宁省海洋环境监测与风险管理信息平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="${ctx}/assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/assets/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="${ctx}/assets/dist/css/timeline.css" rel="stylesheet">
<link href="${ctx}/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${ctx}/assets/dist/css/sb-admin-2.css" rel="stylesheet" />
<link href="${ctx}/assets/bootstrap/dist/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<!--[if lte IE 9]>
<script src="${ctx}/assets/bootstrap/dist/js/respond.js"></script>
<script src="${ctx}/assets/bootstrap/dist/js/html5shiv.js"></script>
<![endif]-->
<script src="${ctx}/assets/jquery/jquery.min.js"></script>
<script src="${ctx}/assets/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/metisMenu/metisMenu.min.js"></script>
<script src="${ctx}/assets/dist/js/sb-admin-2.js"></script>
<script src="${ctx}/assets/datatables/jquery.dataTables.js"></script>
<script src="${ctx}/assets/bootstrap/dist/js/dataTables.bootstrap.min.js"></script>
<script src="${ctx}/assets/datatables/dataTables_zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/assets/bootstrap/dist/js/jquery.placeholder.min.js"></script>
 <script src="${ctx}/assets/bootstrap-datetimepicker.min.js"></script>
 <script src="${ctx}/assets/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    var ctx = '<c:out value="${ctx }"></c:out>';
    $(function() {
        $('input, textarea').placeholder();
        $(".red").parent().css("background",'red');
    });
    function loadData(obj) {
        var key, value, tagName, type, arr;
        for (x in obj) {
            key = x;
            value = obj[x];
            $("[name='" + key + "'],[name='" + key + "[]']").each(function() {
                tagName = $(this)[0].tagName;
                type = $(this).attr('type');
                if (tagName == 'INPUT') {
                    if (type == 'radio') {
                        $(this).attr('checked', $(this).val() == value);
                    } else if (type == 'checkbox') {
                        arr = value.split(',');
                        for (var i = 0; i < arr.length; i++) {
                            if ($(this).val() == arr[i]) {
                                $(this).attr('checked', true);
                                break;
                            }
                        }
                    } else {
                        $(this).val(value);
                    }
                } else if (tagName == 'SELECT' || tagName == 'TEXTAREA') {
                    $(this).val(value);
                }
            });
        }
    }
</script>
