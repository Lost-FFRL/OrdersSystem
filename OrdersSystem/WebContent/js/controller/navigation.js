define([ "util/param", "tmpl/htmlmodel", "controller/ordersctl", "controller/desktop", "controller/user",
        "controller/product", "controller/buyer","controller/express" ], function(param, HtmlModel, ordersCtl, desktop, userCtl, productCtl,
        buyerCtl,expressCtl) {

    var dataModel = {
        1 : param.ordManager,
        2 : param.proManager,
        3 : param.buyerManager,
        4 : param.expManager,
        5 : param.userManager
    };

    function create() {
        if ($("#navigation").length > 0) {
            $("#navigation").show();
        } else {
            var html = "", index = 1;
            for (index; index < 6; index++) {
                html += HtmlModel.nvgMenu.format({
                    id : "nvg_" + index,
                    cls : "nvg_menu",
                    name : dataModel[index]
                });
            }
            html = HtmlModel.div.format({
                id : "navigation",
                cls : "navigation",
                html : html
            });
            $("#content_left_mid").append(html);
        }
    }

    function addEventListener() {
        $("#navigation div").bind("mouseover mouseout", function() {
            $(this).toggleClass("nvg_hover");
        });

        $("#navigation div").click(function(event) {
            $("#content_right_mid").children().hide();
            var index = this.id.split("_")[1];
            switch (parseInt(index)){
            case 1:
                ordersCtl.init();
                break;
            case 2:
                productCtl.init();
                break;
            case 3:
                buyerCtl.init();
                break;
            case 4:
                expressCtl.init();
                break;
            case 5:
                userCtl.init();
                break;
            default: 
                break;
            }
        });

    }

    function init() {
        create();
        addEventListener();
    }
    return {
        init : init
    };
});