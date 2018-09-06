/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'checkAccountList',
            'url':'/checkAccountList',
            'default':'true',
            'templateUrl':'../html/checkaccount/checkAccountList.html',
            'controller':'checkAccountListController'
        },
        {
            'state':'checkAccountAdd',
            'url':'/checkAccountAdd',
            'default':'true',
            'templateUrl':'../html/checkaccount/checkAccountAdd.html',
            'controller':'checkAccountAddController'
        },
        {
            'state':'checkAccountDtl',
            'url':'/checkAccountDtl',
            'default':'true',
            'templateUrl':'../html/checkaccount/checkAccountDtl.html',
            'controller':'checkAccountDtlController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('checkAccountModule',dependency,routeArry)
}());
