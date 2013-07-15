define(["util/param", "tmpl/htmlmodel"], function(param,htmlModel) {

    /**
     * 数据模型
     */
    var queryDataModel = {
            queryId : "buyer_query",
            queryCls : "",
            tableCls : "query_table",
            tdCls : "query_td",
            inputCls : "query_input",
            normalBut : "normal_But",
            name : param.name,
            nameId : "name",
            phone : param.phone,
            phoneId : "phone",
            addBut : param.add,
            queryBut : param.query,
            buyerAdd : "buyer_add",
            buyerQuery : "buyer_query"
    };
    
    function create() {
        if ($("#content_3").length >= 1){
            $("#content_3").show();
        } else {
            var html = htmlModel.buyerQueTable.format(queryDataModel);
            html = htmlModel.search.format({
                        search : html
                    });
            html = htmlModel.div.format({
                    id: "content_3",
                    cls : "",
                    html : html
                });
            $("#content_right_mid").append(html);
        }
        $("#content_right_top").empty().append("<h1>"+param.buyerManager+"</h1>");
    }

    function init() {
        create();
//        addEventLister();
    }

    return {
        init : init
    };
});
