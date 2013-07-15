define(["util/param", "tmpl/htmlmodel"], function(param,htmlModel) {

    /**
     * 数据模型
     */
    var queryDataModel = {
            queryId : "product_query",
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
            proAdd : "product_add",
            proQuery : "product_query"
    };
    
    function create() {
        if ($("#content_2").length >= 1){
            $("#content_2").show();
        } else {
            var html = htmlModel.proQueTable.format(queryDataModel);
            html = htmlModel.search.format({
                        search : html
                    });
            html = htmlModel.div.format({
                    id: "content_2",
                    cls : "",
                    html : html
                });
            $("#content_right_mid").append(html);
        }
        $("#content_right_top").empty().append("<h1>" + param.proManager+  "</h1>");
    }

    function init() {
        create();
//        addEventLister();
    }

    return {
        init : init
    };
});
