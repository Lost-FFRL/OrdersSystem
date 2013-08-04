define([ "util/param", "tmpl/htmlmodel","tmpl/commtmpl","doT" ], 
        function(param, htmlModel,commTmpl,doT) {

    var url = window.location.href + "Service/User";
    
    var dataModel = ["account","name","sex","mobile","address","remark","operate"];
    
    function addEventListener() {
        queryUser();
        
        $("#user_query_result .user_opreate").click(function(event){
            var userId = $(this).parent().attr("user_id");
            var index = $("#user_opreate > span").index(this);
            cosnole.info(userId);
            cosnole.info(event);
        });
//        delUser();
    }
    
    /**
     * 数据绑定操作事件
     */
    function dataOpreate(){
        $("#user_query_result .opreate").click(function(event){
            var userId = $(this).parent().parent().attr("data_id");
            switch ($(this).index()){
            case 0:
                //详情
                break;
            case 1:
                //修改
                break;
            case 2:
                //删除
                delUser(userId);
                break;
            default:
                break;
            }
        });
    }
    
    function delUser(ids){
        $.post(url, {
            ids : ids,
            type : 2
        },function (data){
            if(data.code == "0"){
                var id = ids.split(","),idx;
                for (idx in id){
//                    var tr = $("#user_query_result tr[data_id='" + id[idx] + "']");
//                    tr.fadeOut("4000",function(){
//                        $(this).remove();
//                    });
                    $("#user_query_result tr[data_id='" + id[idx] + "']").remove();
                }
            }else {
                //删除失败，提示
            }
        },"json");
    }

    function queryUser() {
        $("#user_query").click(function ()
        {
            var name = $("user_name").text(), 
            phone = $("#user_phone").text();
            $.post(url, {
                name : name,
                phone : phone,
                curPage : 1,
                pageSize : 5,
                type : 1
            }, function(data){showData(data);}, "json");
        });
    }
    
    

    function showData(data) {
        $("#user_query_result > tbody").empty();
        var def = {
            page : commTmpl.page
        },
        userFn = doT.compile(commTmpl.dataTbody, def),
        data = {
            data : data.content.result,
            model : dataModel,
            operate : [ param.detail, param.modified, param.del ],
            page : {
                id : "userPage",
                previous : param.previous_page,
                next : param.next_page
            }
        };
        $("#user_query_result > tbody").html(userFn(data));
        
        dataOpreate();

    }

    function create() {
        if ($("#user_manager").length >= 1) {
            $("#user_manager").show();
        } else {
            var inpFn = doT.template(commTmpl.inputTd),
            selFn = doT.template(commTmpl.selectTd),
            butFn = doT.template(commTmpl.norBut),
            data = {
                mcId : "user_manager",
                mcCls : "",
                id : "user_query",
                resultCls : "result_container",
                tableId : "user_query_result",
                list : [ {
                    first : inpFn({
                        id : "user_name",
                        name : param.name,
                        cls : ""
                    }),
                    second : inpFn({
                        id : "user_phone",
                        name : param.phone,
                        cls : ""
                    })
                }, {
                    first : butFn({
                        id : "user_add",
                        name : param.add
                    }),
                    second : butFn({
                        id : "user_query",
                        name : param.query
                    })
                } ],
                thead : [ param.user_account, param.user_name, param.user_sex, param.user_phone, param.user_address,
                        param.user_remark, param.data_manage ]
            },
            def = {
                search: commTmpl.queryTable,
                top: commTmpl.search,
                mid: commTmpl.result
            },
            fn = doT.compile(commTmpl.manageContainer, def);
            $("#content_right_mid").append(fn(data));
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
