define(["util/utils"],function(utils) {
    
    $("#login").click(function() {
        var xh = loadHttpRequest();
        xh.onreadystatechange = function(){
            if(this.readyState==4){
                console.info(this.responseText);
                var obj= JSON.parse(this.responseText);
                console.info(obj.desc);
            }
        };
        xh.open("POST", window.location.href + "Service/Login", true);
        xh.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        xh.setRequestHeader("Accept","text/plain");
        xh.send(utils.param({user:"FFRL_1", pwd: "123456",type:0}));
//        xh.send("user=aaa&pwd=woaiguo");
        
//        $.ajax({
//            type : "POST",
//            url : "http://localhost:8080/OrdersSystem/user",
//            data : {user:"ffrl", pwd: "woaiguo"}
//        });
        
    });

    function loadHttpRequest() {
        var xmlHttp;
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlHttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xmlHttp;
    }
});
