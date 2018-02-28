$(document).ready(function() {
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx + "/admin/user/tolist.htm";
    });
    $("#user_form").validate({
        rules : {
            userName : {
                required : true,
                minlength : 2
            },
            loginName : {
                required : true
            },
            userName : {
                required : true
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
