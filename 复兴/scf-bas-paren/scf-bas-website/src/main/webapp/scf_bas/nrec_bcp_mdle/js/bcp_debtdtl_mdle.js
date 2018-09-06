/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'pooldebtList',
            'url':'/pooldebtdtlList',
            'default':'true',
            'templateUrl':'busqry/debtdtl/debtList.html',
            'controller':'debtListController'
        },
        {
            'state':'pooldebtdtl',
            'url':'/pooldebtdtl',
            'templateUrl':'busqry/debtdtl/debtdtl.html',
            'controller':'debtdtlController'
        },
        {
            'state':'pooldebtprcs',
            'url':'/pooldebtprcs',
            'templateUrl':'busqry/debtdtl/debtprcs.html',
            'controller':'debtprcsController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcp_dbetdtl_mdle',dependency,routeArry)
}());
