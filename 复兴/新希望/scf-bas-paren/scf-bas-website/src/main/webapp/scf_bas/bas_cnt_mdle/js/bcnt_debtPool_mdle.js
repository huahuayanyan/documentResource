/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntdebtpoolList',
            'url':'/bcntdebtpoolList',
            'default':'true',
            'templateUrl':'bcntdebtpool/debtPoolConList.html',
            'controller':'debtPoolConListController'
        },
        {
            'state':'bcntdebtpooladd',
            'url':'/bcntdebtpooladd',
            'templateUrl':'bcntdebtpool/debtPoolConAdd.html',
            'controller':'debtPoolConAddController'
        },
        {
            'state':'bcntdebtpoolview',
            'url':'/bcntdebtpoolview',
            'templateUrl':'bcntdebtpool/debtPoolConView.html',
            'controller':'debtPoolConViewController'

        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntdebtpoolModule',dependency,routeArry)
}());
