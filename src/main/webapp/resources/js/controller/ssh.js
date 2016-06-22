/**
 * Created by Administrator on 6/22/2016.
 */
$(document).ready(function(){
    $(".myapp").click(function (event) {
        // alert(event.target.id)
        var id = event.target.id
        $.get("/ssh/"+id, function(data){
            alert("Data Loaded: " + data);
        });
        var changid = "div"+id;
        //send post data choose the way to use.
        // $("#"+changid).html("nimeiya")
    })
});