/**
 * Created by htrad0036 on 2017/3/1.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntdebtList',
            'url':'/bcntdebtList',
            'default':'true',
            'templateUrl':'contractMng/debtConList.html',
            'controller':'debtConListController'
        },
        {
            'state':'conInfo',
            'url':'/conInfo',
            'templateUrl':'contractMng/debtConInfoTab.html',
            'controller':'conInfoTabController'
        },
        {
            'state':'conInfo.conTab1',
            'url':'/conTab1',
            'templateUrl':'contractMng/debtConTab1.html',
            'controller':'conInfoTab1Controller'

        },
        {
            'state':'conInfo.conTab2',
            'url':'/conTab2',
            'templateUrl':'contractMng/debtConTab2.html',
            'controller':'conInfoTab2Controller'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntdebtModule',dependency,routeArry)
}());
