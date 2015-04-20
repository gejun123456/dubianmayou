/**
 * Created by Administrator on 4/8/2015.
 */
$(document).ready(function () {
    var allmember = ['mayu','zhiyuan','me'];
    for(var i =0;i<allmember.length;i++){
        console.log(allmember[i]);

    }
    var a = 0;
    var c ="#mayu";
    $(c).html(a);
    // jQuery methods go here...
    $("#addmayu").click(function () {
        a = a+1;
        $(c).html(a);
    })
});