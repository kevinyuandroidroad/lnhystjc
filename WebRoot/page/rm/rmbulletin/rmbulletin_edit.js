$(document).ready(function() {
 $('.form_datetime').datetimepicker({
        language : 'zh-CN',
        format : 'yyyy-mm-dd',
        autoclose : 1,
        startView : 2,
        minView : 2,
        forceParse : 0
    });
    $("#rmbulletin_form").validate({
        rules : {
           
        },
        errorPlacement : function(error, element) {
            error.appendTo(element.parent());
        },
        submitHandler : function(form) {
            var dataform = $(form);
            var data = dataform.serialize();
            $.post(ctx + "/rm/rmbulletin/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data == 'success') {
                    showSuccessMsg();
                    location.href = ctx + "/rm/rmbulletin/tolist.htm";
                } else {
                }
            }, "json");
        }
    });
    // 返回按钮
    $('#backBtn').click(function() {
        location.href = ctx +"/rm/rmbulletin/tolist.htm";
    });
});
