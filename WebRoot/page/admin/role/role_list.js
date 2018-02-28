$(document).ready(function() {
    $("#btn_add").click(function() {
        window.location.href = ctx + "/admin/role/toEdit.htm";
    });
    $('#refresh_btn').click(function() {
        location.reload();
    });
    $('#search_btn').click(function() {
        loadTalble();
    });
    loadTalble();
});
function loadTalble() {
    $('#dataTables')
            .DataTable(
                    {
                        "searching" : false,
                        serverSide : true,
                        scrollCollapse : false,
                        "sPaginationType" : "full_numbers",
                        "bDestroy" : true,
                        "ordering" : false,
                        "ajax" : {
                            "url" : ctx + "/admin/role/list.htm",
                            "type" : "POST",
                            "data" : {
                                "roleName" : $("#roleName").val()
                            }
                        },
                        "columns" : [
                                {
                                    "data" : "roleName",
                                    "title" : "角色名称"
                                },
                                {
                                    "data" : "roleId",
                                    "title" : "操作",
                                    'width' : 150,
                                    'sortable' : false,
                                    'render' : function(data, type, full) {
                                        var template = '<a href="'
                                                + ctx
                                                + '/admin/role/toEdit.htm?id=DBID_" class="btn btn-outline btn-primary btn-xs">编辑</a>&nbsp;'
                                                + '<a href="'
                                                + ctx
                                                + '/admin/role/toRoleFuncEdit.htm?id=DBID_" class="btn btn-outline btn-primary btn-xs">权限设置</a>&nbsp;'
                                                + '<a href="javascript:void(0);" onclick="showConfirmModal(\'DBID_\');"  class="btn btn-outline btn-primary btn-xs">删除</a>';
                                        return template.replace(/DBID_/g, data);
                                    }
                                } ]
                    });
}
// 显示删除提示框
function showConfirmModal(id) {
    $('#recordeId').val(id);
    $('#delModal').modal('show');
}
// 删除
function deleteById() {
    $.post(ctx + "/admin/role/delete.htm", {
        id : $('#recordeId').val()
    }, function(result) {
        showSuccessMsg();
        $("#dataTables").dataTable().fnDraw();
    });
}
