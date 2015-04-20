/**
 * Created by Administrator on 4/8/2015.
 */
$(document).ready(function () {
    var allmember = ['mayu', 'zhiyuan', 'me'];
    for (var i = 0; i < allmember.length; i++) {
        var akbid = allmember[i];
        console.log(akbid);
        var url = "vote/count/" + akbid;
        $.get(url, function (data, status) {
            var c = jQuery.parseJSON(data);
            var h = "#"+ c.name;
            $(h).html(c.count);
        });
    }
    //var c = "#mayu";
    //// jQuery methods go here...
    //$("#addmayu").click(function () {
    //    a = a + 1;
    //    $(c).html(a);
    //})
});