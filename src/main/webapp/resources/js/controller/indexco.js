/**
 * Created by Administrator on 4/8/2015.
 */
$(document).ready(function () {
    $.get("vote/countAll", function (data, status) {
        var c = jQuery.parseJSON(data);
        console.log(c);
        for(var i =0;i< c.length;i++){
            var akbid = c[i].name;
            $("#"+akbid).html(c[i].count);
        }
    });
//var c = "#mayu";
//// jQuery methods go here...
//$("#addmayu").click(function () {
//    a = a + 1;
//    $(c).html(a);
//})
});