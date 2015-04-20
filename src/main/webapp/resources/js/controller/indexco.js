/**
 * Created by Administrator on 4/8/2015.
 */
$(document).ready(function () {
    var a = 0;
    $("#countmayu").html(a);
    // jQuery methods go here...
    $("#addmayu").click(function () {
        a = a+1;
        $("#countmayu").html(a);
    })
});