/**
 * 构建桌面整体架构JS
 */
define(["tmpl/htmlmodel","controller/navigation"],function(tmpl,navigation){
    
    function init(){
        if ($("#content_area").length > 0){
            $("#content_area").show();
        } else {
            $("#container").append(tmpl.desktop);
        }
        navigation.init();
    }
    
    return {
        init : init
    };
});