/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'triDeliveryQry',
            'url':'/triDeliveryQry',
            'default':'true',
            'templateUrl':'triDeliveryInfo/triDeliveryInfo_qry.html',
            'controller':'triDeliveryQryController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_qry_mdle',dependency,routeArry);
}());