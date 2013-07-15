define(function(){
    
    /**
     * 将obj对象转换成ajax请求的参数
     */
    function param(val){
        if (val){
            var p = [];
            for (var temp in val){
                p.push(encodeURIComponent(temp) + "=" + encodeURIComponent(val[temp]));
            }
            return p.join("&");
        } else {
            return "";
        }
    }
    
    return {
        param : param
    };
});