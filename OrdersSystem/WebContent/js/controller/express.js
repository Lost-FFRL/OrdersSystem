define(["util/param", "tmpl/htmlmodel"], function(param,htmlModel) {

    /**
     * 数据模型
     */
    var queryDataModel = {
            queryId : "express_query",
            queryCls : "",
            tableCls : "query_table",
            tdCls : "query_td",
            inputCls : "query_input",
            normalBut : "normal_But",
            name : param.proName,
            nameId : "proName",
            proNum : param.proNum,
            proId : "proNum",
            addBut : param.add,
            queryBut : param.query,
            expAdd : "exp_add",
            expQuery : "exp_query"
    };
    
    function create() {
        if ($("#content_4").length >= 1){
            $("#content_4").show();
        } else {
            var html = htmlModel.expQueTable.format(queryDataModel);
            html = htmlModel.search.format({
                        search : html
                    });
            html = htmlModel.div.format({
                    id: "content_4",
                    cls : "",
                    html : html
                });
            $("#content_right_mid").append(html);
        }
        $("#content_right_top").empty().append("<h1>" + param.expManager +"</h1>");
    }

    function init() {
        create();
//        addEventLister();
    }

    return {
        init : init
    };
});
