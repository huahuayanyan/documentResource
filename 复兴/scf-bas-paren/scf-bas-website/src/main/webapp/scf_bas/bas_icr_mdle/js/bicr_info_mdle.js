/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bicrinfo',
            'url':'/bicrinfo',
            'default':'true',
            'templateUrl':'bicrinfo/bicrinfo.html',
            'controller':'bicrinfoController'
        /* 'views':[
                {   'view':"viewName1",
                    'templateUrl':'bicrinfo/bicrinfo.html',
                    'controller':'bicrinfoController'
                },
                {   'view':"viewName2",
                    'templateUrl':'bicrinfo/flowinfo.html',
                    'controller':'flowinfoController'
                }
            ]*/
        },
        {
            'state':'bicrinfoadd',
            'url':'/bicrinfoadd',
            'templateUrl':'bicrinfo/bicrinfoAdd.html',
            'controller':'bicrinfoAddController'

        },
        {
            'state':'bicrinfoview',
            'url':'/bicrinfoview',
            'templateUrl':'bicrinfo/bicrinfoView.html',
            'controller':'bicrinfoViewController'

        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bicrinfoModule',dependency,routeArry)
}());
