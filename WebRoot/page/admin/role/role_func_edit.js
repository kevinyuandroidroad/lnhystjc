$(document).ready(function() {
	var tree;
	// 初始化树
	var setting = {
		check : {
			enable : true,
			chkboxType : {
				"Y" : "p",
				"N" : "ps"
			}
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		view : {
			showIcon : false,
			fontCss : {
				size : 15
			}
		}
	};
	$.post(ctx + "/admin/role/findTree.htm", {
		id : $("#roleId").val()
	}, function(result) {
		tree = $.fn.zTree.init($("#treeDemo"), setting, result);
	},'json');
	// 取消按钮
	$('#cancelAllBtn').click(function() {
		tree.checkAllNodes(false);
	});
	// 全选按钮
	$('#checkAllBtn').click(function() {
		tree.checkAllNodes(true);
	});
	// 全选按钮
	$('#checkAllBtn').click(function() {
		tree.checkAllNodes(true);
	});
	// 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx + "/admin/role/tolist.htm";
    });
	$('#saveBtn').click(function() {
		var nodes = tree.getCheckedNodes(true);
		var funList=[];
		for(var i in nodes){
			funList.push(nodes[i].id);
		}
		$.post(ctx + "/admin/role/saveRoleFunc.htm", {id:$("#roleId").val(),funIds:funList.toString()}, function(data) {
			$(".btn").removeAttr("disabled");
			if (data == 'success') {
				$(".alert-success").show();
				location.href = ctx + "/admin/role/tolist.htm";
			} else {
			}
		}, "json");
	});
});
