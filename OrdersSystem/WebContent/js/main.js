/**
 * require定义模块 require([],function(){}); define({}); define(function);
 */
require.config({
    baseUrl : "js",
    paths : {
        jquery : "lib/jquery",
        JSON : "lib/json3",
        doT: "lib/doT"
    },
    waitSeconds : 15
});

require([ "jquery", "JSON","doT", "util/utils", "util/prototype", "controller/ordersctl", "controller/desktop",
        "controller/user", "controller/product", "controller/buyer", "core/core" ], 
        function($, JSON, doT, utils,utilProtype, ordersCtl, desktop, userCtl, productCtl, buyerCtl, core) {

    desktop.init();
    // ordersCtl.init();
    // userCtl.init();
    // productCtl.init();
    // buyerCtl.init();

});
