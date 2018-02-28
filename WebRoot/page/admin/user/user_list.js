$(document).ready(function() {
    $("#btn_add").click(function() {
        window.location.href = ctx + "/admin/user/toEdit.htm";
    });
    $('#refresh_btn').click(function() {
        location.reload();
    });
    $('#search_btn').click(function() {
        loadTable();
    });
    loadTable();
});
function loadTable() {
    $('#userTable')
            .DataTable(
                    {
                        "order" : [ [ 1, 'asc' ] ],
                        serverSide : true,
                        scrollCollapse : false,
                        "searching" : false,
                        "bDestroy" : true,
                        "lengthChange" : false,
                        "ordering" : true,
                        "ajax" : {
                            "url" : ctx + "/admin/user/list.htm",
                            "type" : "POST",
                            "data" : {
                                "loginName" : $("#loginName").val(),
                                "cname" : $("#cname").val()
                            }
                        },
                        "fnRowCallback" : test,
                        "columns" : [
                                {
                                    "data" : "cname",
                                    'width' : 150,
                                    "title" : "用户姓名"
                                },
                                {
                                    "data" : "loginName",
                                    'width' : 150,
                                    "title" : "登录名"
                                },
                                {
                                    "data" : "id",
                                    "title" : "操作",

                                    'width' : 70,
                                    'sortable' : false,
                                    'render' : function(data, type, full) {
                                        var template = '<a href="'
                                                + ctx
                                                + '/admin/user/toEdit.htm?id=DBID_" class="btn btn-outline btn-primary btn-xs">编辑</a>&nbsp;'
                                                + '<a href="javascript:void(0);" onclick="showConfirmModal(\'DBID_\');"  class="btn btn-outline btn-primary btn-xs">删除</a>';
                                        return template.replace(/DBID_/g, data);
                                    }
                                } ]
                    });
}

function test(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
    if (iDisplayIndex == 0)
        addd = 0;
    $("#weightsum").html(11);
    return nRow;
}
// 显示删除提示框
function showConfirmModal(id) {
    $('#recordeId').val(id);
    $('#delModal').modal('show');
}
// 删除
function deleteById() {
    $.post(ctx + "/admin/user/delete.htm", {
        id : $('#recordeId').val()
    }, function(result) {
        showSuccessMsg();
        $("#userTable").dataTable().fnDraw();
    });
}