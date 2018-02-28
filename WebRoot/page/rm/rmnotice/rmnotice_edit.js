$(document).ready(function() {
    $("#rmnotice_form").validate({
        rules : {
           
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
            var dataform = $(form);
            var data = dataform.serialize();
            $.post(ctx + "/rm/rmnotice/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data == 'success') {
                    showSuccessMsg();
                    location.href = ctx + "/rm/rmnotice/tolist.htm";
                } else {
                }
            }, "json");
        }
    });
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx + ctx + "/rm/rmnotice/tolist.htm";
    });
});
