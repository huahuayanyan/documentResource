/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntMortgageEntering',
            'url':'/bcntMortgageEntering',
            'default':'true',
            'templateUrl':'mortgageEntering/bcnt_mortgageEntering.html',
            'controller':'bcntMortgageEnteringController'
        },
        {
            'state':'bcntMortgageEnteringAdd',
            'url':'/bcntMortgageEnteringAdd',
            'templateUrl':'mortgageEntering/bcnt_mortgageEnteringAdd.html',
            'controller':'bcntMortgageEnteringAddController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bcntMortgageEnteringAdd',dependency,routeArry)
}());
