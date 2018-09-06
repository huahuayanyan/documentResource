/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'changeMortSok',
            'url':'/changeMortSok',
            'default':'true',
            'templateUrl':'changeMortgageStockQry/changeMortSok_list.html',
            'controller':'changeMortSokController'
        },
        {
            'state':'changeMortSokDel',
            'url':'/changeMortSokDel',
            'templateUrl':'changeMortgageStockQry/changeMortSok_detail.html',
            'controller':'changeMortSokDelController'

        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('changeMortSokModule',dependency,routeArry)
}());
