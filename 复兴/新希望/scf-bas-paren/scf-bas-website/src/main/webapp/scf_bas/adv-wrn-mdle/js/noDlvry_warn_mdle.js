/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'noDeliveryWarn',
            'url':'/noDeliveryWarn',
            'default':'true',
            'templateUrl':'noDeliveryWarn/noDeliveryWarnQry.html',
            'controller':'NoDeliveryWarnController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_wrn_mdle',dependency,routeArry);
}());