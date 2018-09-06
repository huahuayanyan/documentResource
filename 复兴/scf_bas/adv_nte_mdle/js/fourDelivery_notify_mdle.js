
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'FourDeliveryNotifyList',
            'url':'/FourDeliveryNotifyList',
            'default':'true',
            'templateUrl':'fourDeliveryNotify/fourDelivery_notify_list_qry.html',
            'controller':'FourDeliveryNotifyListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());