/**
 * require定义模块 require([],function(){}); define({}); define(function);
 */
require.config({
    baseUrl : "js",
    paths : {
        jquery : "lib/jquery",
        JSON : "lib/json3"
    },
    waitSeconds : 15
});

require([ "jquery", "JSON", "lib/atcTemplate", "util/utils", "util/prototype", "controller/ordersctl", "controller/desktop",
        "controller/user", "controller/product", "controller/buyer", "core/core" ], 
        function($, JSON, atcTmpl, utils,utilProtype, ordersCtl, desktop, userCtl, productCtl, buyerCtl, core) {

    desktop.init();
    // ordersCtl.init();
    // userCtl.init();
    // productCtl.init();
    // buyerCtl.init();

});
