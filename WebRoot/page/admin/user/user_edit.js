$(document).ready(function() {
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx + "/admin/user/tolist.htm";
    });
    loadDeptTree();
    $("#roleNames").select2();
    $("#user_form").validate({
        rules : {
            cname : {
                required : true,
                minlength : 2
            },
            loginName : {
                required : true
            },
            "department.deptName" : {
                required : true
            },
            "role.roleId" : {
                required : true
            },
            cname : {
                required : true
            }
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
            var dataform = $(form);
            var data = dataform.serialize();
            console.log(data);
            $.post(ctx + "/admin/user/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                console.log(data);
                if (data == 'success') {
                    showSuccessMsg();
                    location.href = ctx + "/admin/user/tolist.htm";
                } else if("exist"==data) {
                    $("#msgError").show();
                    $("#msgError").html("登录名已经存在，请修改");
                }
            }, "json");
        }
    });
});
/*******************************************************************************
 * 初始化组织机构树
 */
function loadDeptTree() {
    // 初始化树
    var setting = {
        data : {
            simpleData : {
                enable : true
            }
        },
        check : {
            enable : true,
            chkboxType : {
                "Y" : "s",
                "N" : "s"
            },
            chkStyle : "radio",
            radioType : "all"
        },
        view : {
            showIcon : true,
            fontCss : {
                size : 15
            }
        }
    };
    $.post(ctx + "/admin/dept/findTree.htm", null, function(result) {
        $.fn.zTree.init($("#deptTree"), setting, result);
    }, "json");
}
function deptModal() {
    $("#deptModal").modal('show');
}
function roleModal() {
    $("#roleModal").modal('show');
}
/*******************************************************************************
 * 完成部门选择
 * 
 * @param event
 * @param treeId
 * @param treeNode
 */
function doneDept() {
    var treeObj = $.fn.zTree.getZTreeObj("deptTree");
    var nodes = treeObj.getCheckedNodes(true);
    var deptNames = '';
    var deptIds = '';
    for ( var i in nodes) {
        deptIds += nodes[i].id;
        deptNames += nodes[i].name;
    }
    $("#deptNames").val(deptNames);
    $("#deptIds").val(deptIds);
};