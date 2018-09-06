/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'dbrtacctList',
            'url':'/dbrtacctList',
            'default':'true',
            'templateUrl':'dbrtacct/dbrtacctList.html',
            'controller':'dbrtacctListController'
        },
        {
            'state':'dbrtacctdtl',
            'url':'/dbrtacctdtl',
            'templateUrl':'dbrtacct/dbrtacctdtl.html',
            'controller':'dbrtacctdtlController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('dbrtacct',dependency,routeArry)
}());
