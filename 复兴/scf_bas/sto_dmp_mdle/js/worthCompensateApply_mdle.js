/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'worthCompensateApplyList',
            'url':'/worthCompensateApplyList',
            'default':'true',
            'templateUrl':'worthCompensateApply/worthCompensateApply_List.html',
            'controller':'worthCompensateController'
        },
        {
            'state':'mortgageRegularContSlave',
            'url':'/mortgageRegularContSlave',
            'templateUrl':'worthCompensateApply/mortgageRegularContSlave.html',
            'controller':'contSlaveController'
        },


    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntbuyindoModule',dependency,routeArry)
}());
