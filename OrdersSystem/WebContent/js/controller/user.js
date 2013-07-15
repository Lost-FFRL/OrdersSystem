define([ "util/param", "tmpl/htmlmodel", "lib/atcTemplate" ], function(param, htmlModel, atcT) {

    var url = window.location.href + "Service/User";

    /**
     * 数据模型
     */
    var queryDataModel = {
        queryId : "user_query",
        queryCls : "",
        tableCls : "query_table",
        tdCls : "query_td",
        inputCls : "query_input",
        normalBut : "normal_But",
        name : param.name,
        nameId : "user_name",
        phone : param.phone,
        phoneId : "user_phone",
        addBut : param.add,
        queryBut : param.query,
        userAdd : "user_add",
        userQuery : "user_query"
    };
    function addEventListener() {
        queryUser();
    }

    function queryUser() {
        $("#user_query").click(function ()
        {
            var name = $("user_name").text(), 
            phone = $("#user_phone").text();
            $.post(url, {
                name : name,
                phone : phone,
                pageNum : 1,
                pageSize : 10,
                type : 0,
                order : 0
            }, function(data){showData(data);}, "json");
        });
    }

    function showData(data) {
        console.info(data);
    }

    function create() {
        if ($("#content_5").length >= 1) {
            $("#content_5").show();
        } else {
            var render = atcT.compile(htmlModel.queryTable);
            var html = render({
                id : "user_query",
                cls : "",
                tableCls : "query_table",
                list : [
                        {
                            1 : "query_td",
                            2 :  param.name,
                            3 : "user_name",
                            4 : "query_input",
                            5 : "query_td",
                            6 : param.phone,
                            7 : "user_phone",
                            8 : "query_input"
                        },
                        [
                            "user_add",
                            "normal_But",
                            param.add,
                            "user_query",
                            "normal_But",
                            param.query
                        ]
                    ]
            });
            
            /*var html = htmlModel.userQueTable.format(queryDataModel);
            html = htmlModel.search.format({
                search : html
            });
            html = htmlModel.div.format({
                id : "content_5",
                cls : "",
                html : html
            });*/
            $("#content_right_mid").append(html);
        }
        $("#content_right_top").empty().append("<h1>" + param.userManager + "</h1>");
    }

    function init() {
        create();
        addEventListener();
    }

    return {
        init : init
    };
});
