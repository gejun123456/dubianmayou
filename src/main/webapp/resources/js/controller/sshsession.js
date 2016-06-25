/**
 * Created by Administrator on 6/22/2016.
 */
$(document).ready(function(){
    //不停的去getData.
    id=$("#urlPath").html();
    $(".command").keypress(function(e) {
        if(e.which == 13) {
            console.log(e.target.value);
            $.post("/ssh/"+id+"/query",{"command":e.target.value},
            function (data) {
                if(data.isSuccess){
                    console.log("success");
                } else {
                    console.log(data.msg);
                }
            })
        }
    });

    function doPoll(id){
        $.get("/ssh/"+id+"/getData", function(data) {
            // alert(data);  // process results here
            console.log(data);
            $("#sessionText").html($("#sessionText").val()+data.msg);
            setTimeout(doPoll(id),1000);
        });
    }
    doPoll(id);

    // $.get("/ssh/"+id+"/getData", function(data){
    //     var res = $.parseJSON(data);
    //     console.log(res);
    //     //send post data choose the way to use.
    // });
});