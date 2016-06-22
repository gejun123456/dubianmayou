/**
 * Created by Administrator on 6/22/2016.
 */
$(document).ready(function(){
    $(".myapp").click(function (event) {
        // alert(event.target.id)
        var changid = "div"+event.target.id;
        //send post data choose the way to use.
        $("#"+changid).html("nimeiya")
    })
});