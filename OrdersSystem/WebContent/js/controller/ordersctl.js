define(["util/param", "tmpl/htmlmodel"], function(param,htmlModel) {

    /**
     * 数据模型
     */
    var queryDataModel = {
            ordersQueryId : "orders_query",
            ordersCls : "",
            tableCls : "query_table",
            tdCls : "query_td",
            inputCls : "query_input",
            selCls : "query_sel",
            normalBut : "normal_But",
            name : param.name,
            nameId : "name",
            phone : param.phone,
            phoneId : "phone",
            startTime : param.startTime,
            endTime : param.endTime,
            orderNum : param.orderNum,
            orderNumId : "orderNum",
            status : param.status,
            statusId : "status",
            pleaseSel : param.pleaseSel,
            status : param.status,
            statusId : "status",
            customer : param.customer,
            customerId : "customer",
            product : param.product,
            productId : "product",
            expressType : param.expressType,
            expressId : "expressId",
            payType : param.payType,
            payTypeId : "payTypeId",
            addBut : param.add,
            queryBut : param.query,
            ordAdd : "ordAdd",
            ordQuery : "ordQuery"
    };
    
    function create() {
        if ($("#content_1").length >= 1){
            $("#content_1").show();
        } else {
            var html = htmlModel.ordQueTable.format(queryDataModel);
            html = htmlModel.search.format({
                        search : html
                    });
            html = htmlModel.div.format({
                    id: "content_1",
                    cls : "",
                    html : html
                });
            $("#content_right_mid").append(html);
        }
        $("#content_right_top").empty().append("<h1>" +param.ordManager+ "</h1>");
    }

    function init() {
        create();
//        addEventLister();
    }

    return {
        init : init
    };
});
