$(document).ready(function() {
    $("#role_form").validate({
        rules : {
            roleName : {
                required : true,
                minlength : 2
            }
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
            var dataform = $(form);
            var data = dataform.serialize();
            $.post(ctx + "/admin/role/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data == 'success') {
                    showSuccessMsg();
                    location.href = ctx + "/admin/role/tolist.htm";
                } else {
                }
            }, "json");
        }
    });
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx + "/admin/role/tolist.htm";
    });
});
