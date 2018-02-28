$(document).ready(function() {
    $("#param_form").validate({
        rules : {
            paramDesc : {
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
            $.post(ctx + "/admin/param/save.htm", data, function(data) {
                $(".btn").removeAttr("disabled");
                if (data) {
                    showSuccessMsg();
                } else {
                }
            }, "json");
        }
    });
    showPer();
    $("#pro_out_type").change(function() {
        showPer();
    });
    showPer();
    $("#pro_valid").change(function() {
        showValid();
    });
});
function showPer() {
    if ($("#pro_out_type").val() == 'per') {
        $("#pro_out_per").show();
    } else {
        $("#pro_out_per").hide();
        $("#pro_out_per").val('');
    }

}
function showValid() {
    if ($("#pro_valid").val() == 'identity') {
        $("#pro_valid_element").show();
    } else {
        $("#pro_valid_element").hide();
        $("#pro_identity_value").val('');
        $("#pro_identity_u").val('');
    }
}
