$(document).ready(function() {
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx + "/admin/user/tolist.htm";
    });
    loadDeptTree();
    $("#roleNames").select2();
    $("#user_form").validate({
        rules : {
            userPw : {
                required : true,
                minlength : 6
            },
            rePw : {
                equalTo : "#passWord",
                required : true,
                minlength : 6
            }
        },
        messages : {
            rePw : {
                required : "请输入密码",
                minlength : "密码长度不能小于 6 ",
                equalTo : "两次密码输入不一致"
            }
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
            var dataform = $(form);
            var data = dataform.serialize();
            $.post(ctx + "/admin/user/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data == 'success') {
                    showSuccessMsg();
                } else {
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
            chkStyle : "radio"
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
    });
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