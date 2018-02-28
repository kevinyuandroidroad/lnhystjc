$(document).ready(function() {
    $("#user_form").validate({
        rules : {
            userName : {
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
            $.post(ctx + "/admin/user/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data.success) {
                    $(".alert-success").show();
                } else {
                }
            }, "json");
        }
    });
});
