/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'dbrpinfoList',
            'url':'/dbrpinfoList',
            'default':'true',
            'templateUrl':'busqry/bcp_debtrepay_info.html',
            'controller':'DebtRepayListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcp_debtrepay_mdle',dependency,routeArry)
}());
