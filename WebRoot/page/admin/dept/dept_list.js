var tree;
$(document).ready(function() {
    loadDeptTree();
    // 初始表单验证
    $("#dept_form").validate({
        rules : {
            deptName : {
                required : true,
                minlength : 2
            }
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
        	debugger
            var dataform = $(form);
            var data = dataform.serialize();
            var parentDeptId=$("#parentDeptId").val();
            var deptLevel=$("#deptLevel").val();
            if(deptLevel!=1&&(!parentDeptId||typeof(parentDeptId)=="undefined"||parentDeptId=='')){
                alert("请选择父节点");
                return;
            }
            $.post(ctx + "/admin/dept/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data == 'success') {
                    showSuccessMsg();
                    location.href = ctx + "/admin/dept/tolist.htm";
                } else {
                }
            }, "json");
        }
    });
    // 新增按钮
    $('#add_btn').click(function() {
        addBtn();
    });
    // 删除按钮
    $('#del_btn').click(function() {
        showConfirmModal($("#deptId").val());
    });
    //保存按钮
    $('#save_btn').click(function() {
        $("#dept_form").submit();
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
        view : {
            showIcon : true,
            fontCss : {
                size : 15
            }
        },
        callback : {
            onClick : deptOnClick
        }
    };
    $.post(ctx + "/admin/dept/findTree.htm", null, function(result) {
        tree = $.fn.zTree.init($("#deptTree"), setting, result);
    }, "json");
}
/*******************************************************************************
 * 节点单击时加载组织机构详细信息
 * 
 * @param event
 * @param treeId
 * @param treeNode
 */
function deptOnClick(event, treeId, treeNode) {
    $.post(ctx + "/admin/dept/findById.htm", {
        id : treeNode.id
    }, function(result) {
        $("#deptId").val(result.deptId);
        $("#deptName").val(result.deptName);
        $("#mark").val(result.mark);
        $("#parentDeptId").val(result.parentDeptId);
        $("#deptLevel").val(result.deptLevel);
        $("#deptCode").val(result.deptCode);
        $("#deptAddress").val(result.deptAddress);
        $("#deptTel").val(result.deptTel);
        $("#deptType").val(result.deptType);
        $("#ruleCode").val(result.ruleCode);
        $("#deptRange").val(result.deptRange);
        $("#deptGrade").val(result.deptGrade);
        $("input[name='status'][value='" + result.status + "']").prop(
                "checked", true);
    },"json");
};
/*******************************************************************************
 * 新增事件
 * 
 */
function addBtn() {
	debugger
    var nodes = tree.getSelectedNodes();
    if (nodes.length == 0) {
        alert("请选中父节点");
    }
    clearAll();
    console.log(nodes[0]);
    $.post(ctx + "/admin/dept/findById.htm", {
        id : nodes[0].id
    }, function(result) {
        $("#parentDeptId").val(result.deptId);
        $("#mark").val("A");
        $("#deptLevel").val(result.deptLevel+1);
    },"json");
}
function clearAll() {
    $(':input', '#dept_form').not(':button, :submit, :reset, :hidden, :radio')
            .val('');
    $("#statusY").prop("checked", true);
}
// 显示删除提示框
function showConfirmModal(id) {
    $('#recordeId').val(id);
    $('#delModal').modal('show');
}
// 删除
function deleteById() {
    $.post(ctx + "/admin/dept/delete.htm", {
        id : $('#recordeId').val()
    }, function(result) {
        showSuccessMsg();
        var nodes = tree.getSelectedNodes();
        for (var i = 0, l = nodes.length; i < l; i++) {
            tree.removeNode(nodes[i]);
        }
        clearAll();
    });
}
function showSuccessMsg() {
    $(".alert-success").show();
    setTimeout(function() {
        $(".alert-success").hide();
    }, 1000);
}
