/**
 * Created by Administrator on 6/22/2016.
 */
$(document).ready(function(){
    $(".command").click(function (event) {
        // alert(event.target.id)
        var id = event.target.id
        var html="";
        $.get("/ssh/"+id, function(data){
            var device = $.parseJSON(data);
            for(key in device){
                html = html+device[key].hostname+" "+device[key].private_ip;
                html+="<input type=\"button\" onclick=\"location.href='http:\/ssh"+"\/"+id+"\/"+device[key].private_ip+"';\" value=\"连接\" \/>";
                html+="</br>";
            }
            var changid = "div"+id;
            //send post data choose the way to use.
            $("#"+changid).html(html)
        });

    })
});