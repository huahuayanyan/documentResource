/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntdebtList',
            'url':'/bcntdebtList',
            'default':'true',
            'templateUrl':'bcntdebt/debtConList.html',
            'controller':'debtConListController'
        },
        {
            'state':'bcntdebtadd',
            'url':'/bcntdebtadd',
            'templateUrl':'bcntdebt/debtConAdd.html',
            'controller':'debtConAddController'
           /* 'views':[
             {   'view':"viewName1",
                 'templateUrl':'bcntdebt/debtConAdd.html',
                 'controller':'debtConAddController'
             },
             {   'view':"viewName2",
                 'templateUrl':'bcntdebt/costInfoList.html',
                 'controller':'costInfoListController'
             },
                {   'view':"viewName3",
                    'templateUrl':'bcntdebt/debtExtList.html',
                    'controller':'debtExtListController'
                }
             ]*/

        },
        {
            'state':'bcntdebtview',
            'url':'/bcntdebtview',
            'templateUrl':'bcntdebt/debtConView.html',
            'controller':'debtConViewController'

        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntdebtModule',dependency,routeArry)
}());
