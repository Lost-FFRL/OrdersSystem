define([ "util/param", "tmpl/htmlmodel","tmpl/commtmpl","doT" ], 
        function(param, htmlModel,commTmpl,doT) {

    var url = window.location.href + "Service/User";
    
    var dataModel = ["account","name","sex","mobile","address","remark","operate"];
    
    function addEventListener() {
        queryUser();
        addUser();
//        dataOpreate();
    }
    
    function addUser(){
    	
    	$("#user_add_btn").click(function(){
    		$("#result_container").children().hide();

    		if ($("#add_user_form").length >= 1){
    			$("#add_user_form").show();
    			return;
    		}
    		html = '<div id="add_user_form" class="form"><table>'
    			+ '<tr>'
    			+ '<td><label>姓名</label></td>'
    			+ '<td><input name="name" /></td>'
    			+ '<td><label>性别</label></td>'
    			+ '<td>'
    			+ '<input type="radio" name="sex" value="1" />男'
    			+ '<input type="radio" name="sex"  value="0"/>女'
    			+ '</td>'
    			+ '</tr><tr>'
    			+ '<td><label>帐号</label></td>'
    			+ '<td><input name="account" /></td>'
    			+ '<td><label>地址</label></td>'
    			+ '<td><input name="address" /></td>'
    			+ '</tr><tr>'
    			+ '<td><label>密码</label></td>'
    			+ '<td><input type="password" name="pwd" /></td>'
    			+ '<td><label>密码确认</label></td>'
    			+ '<td><input type="password" name="pwdConfig" /></td>'
    			+ '</tr><tr>'
    			+ '<td><label>电话</label></td>'
    			+ '<td><input name="phone" /></td>'
    			+ '<td><label>手机</label></td>'
    			+ '<td><input name="mobile" /></td>'
    			+ '</tr><tr>'
    			+ '<td><label>备注</label></td>'
    			+ '<td colspan="3" ><textarea name="remark"/></td>'
    			+ '</tr><tr>'
    			+ '<td></td>'
    			+ '<td><button id="add_user_config">提交</button></td>'
    			+ '<td><button id="add_user_cancel">清空</button></td>'
    			+ '<td></td>'
    			+ '</tr></table></div>';
    		
    		$("#result_container").append(html);
    		
    	});
    }
    
    function addUserConfig(){
    	$("#add_user_config").click(function(){
    		
    		var name = $();
    	});
    	
    }
    
    function addUserCancel(){
    	
    }
    
    /**
     * 数据绑定操作事件
     */
    function dataOpreate(){
        $("#user_query_result .opreate").on('click',function(event){
            var userId = $(this).parent().parent().attr("data_id");
            switch ($(this).index()){
            case 0:
                //详情
            	console.info("detail...");
                break;
            case 1:
                //修改
            	console.info("update");
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
        $("#user_query_btn").click(function (){
        	$("#result_container").children().hide();
        	$('.show_data').show();
        	
            var name = $("user_name").text(), 
            phone = $("#user_phone").text();
            $.post(url, {
                name : name,
                phone : phone,
                curPage : 1,
                pageSize : param.PAGE_NUM,
                type : 1
            }, function(data){showData(data);}, "json");
        });
    }

    function showData(obj) {
    	
        $("#user_query_result > tbody").empty();
        var def = {
            page : commTmpl.page
        },
        userFn = doT.compile(commTmpl.dataTbody, def),
        data = {
            data : obj.content.result,
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
//            selFn = doT.template(commTmpl.selectTd),
            butFn = doT.template(commTmpl.norBut),
            data = {
                mcId : "user_manager",
                mcCls : "",
                id : "user_query",
                resultId: "result_container",
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
                        id : "user_add_btn",
                        name : param.add
                    }),
                    second : butFn({
                        id : "user_query_btn",
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
        $("#content_right_top").empty().append("<div id='title' ><h1>" + param.userManager + "</h1></div>");
    }

    
    function init() {
        create();
        addEventListener();
    }

    return {
        init : init
    };
});
