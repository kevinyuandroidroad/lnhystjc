$(document).ready(function() {
    $("#rmyearprogram_form").validate({
        rules : {
           
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
            var dataform = $(form);
            var data = dataform.serialize();
            $.post(ctx + "/rm/rmyearprogram/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data == 'success') {
                    showSuccessMsg();
                    location.href = ctx + "/rm/rmyearprogram/tolist.htm";
                } else {
                }
            }, "json");
        }
    });
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx +"/rm/rmyearprogram/tolist.htm";
    });
});
