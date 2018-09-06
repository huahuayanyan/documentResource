/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'checkStockList',
            'url':'/checkStockList',
            'default':'true',
            'templateUrl':'checkStock/checkStockList.html',
            'controller':'checkStockListController'
        },
        {
            'state':'checkStockAdd',
            'url':'/checkStockAdd',
            'default':'true',
            'templateUrl':'checkStock/checkStockAdd.html',
            'controller':'checkStockAddController'
        },
        {
            'state':'checkStockDtl',
            'url':'/checkStockDtl',
            'default':'true',
            'templateUrl':'checkStock/threeCheckStockApplyDtl.html',
            'controller':'checkStockDtlController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('atcsthreeConfirmModule',dependency,routeArry)
}());
