/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'debtPoolList',
            'url':'/debtPoolList',
            'default':'true',
            'templateUrl':'debtPoolGenerate/debtPoolGenerateQuery.html',
            'controller':'debtPoolGenerateController'
        },
        {
            'state':'info',
            'url':'/info',
            'templateUrl':'debtPoolGenerate/debtPoolInfo.html',
            'controller':'infoController'
        },
        {
            'state':'info.staticInfo',
            'url':'/staticInfo',
            'templateUrl':'debtPoolGenerate/debtPoolStaticInfoTab.html',
            'controller':'staticController'

        },
        {
            'state':'info.conInfo',
            'url':'/conInfo',
            'templateUrl':'debtPoolGenerate/debtPoolConInfoTab.html',
            'controller':'conController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('debtPoolList',dependency,routeArry)
}());
