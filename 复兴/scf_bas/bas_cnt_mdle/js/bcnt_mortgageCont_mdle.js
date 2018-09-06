/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'mortgageContList',
            'url':'/mortgageContList',
            'default':'true',
            'templateUrl':'mortgageCont/mort_cont_list.html',
            'controller':'mortgageContListController'
        },
        {
            'state':'mortgageContAdd',
            'url':'/mortgageContAdd',
            'templateUrl':'mortgageCont/mort_cont_Add.html',
            'controller':'mortgageContAddController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bsysthreeProtocol',dependency,routeArry)
}());
