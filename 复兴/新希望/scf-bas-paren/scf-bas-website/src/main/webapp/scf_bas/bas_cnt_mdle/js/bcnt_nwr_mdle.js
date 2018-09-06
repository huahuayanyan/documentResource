/**
 * Created by mengjiajia on 2016/11/11.
 * 非标仓单监管合同
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'list',
            'url':'/list',
            'default':'true',
            'templateUrl':'../html/bcntmonitorProtocol/bcnt_monitorProtocol.html',
            'controller':'bcntNwrController'
        },
        {
            'state':'viewGntyCon',
            'url':'/viewGntyCon',
            'default':'true',
            'templateUrl':'mortgageMntProtocol/mortgage_gntycon_list.html',
            'controller':'nwrViewGntyConController'
        },
        {
            'state':'edit',
            'url':'/edit',
            'default':'true',
            'templateUrl':'../html/bcntmonitorProtocol/bcnt_monitorProtocol_gntycon_view.html',
            'controller':'viewController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bcntNwrMdle',dependency,routeArry)
}());
