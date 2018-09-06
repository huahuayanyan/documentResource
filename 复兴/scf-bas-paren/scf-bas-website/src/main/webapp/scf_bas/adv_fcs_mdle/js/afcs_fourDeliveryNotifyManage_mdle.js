/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'deliveryNotify',
            'url':'/deliveryNotify',
            'default':'true',
            'templateUrl':'fourDeliveryNotifyManage/deliveryNotify.html',
            'controller':'deliveryNotifyController'
        },
        {
            'state':'deliveryNotifyAdd',
            'url':'/deliveryNotifyAdd',
            'templateUrl':'fourDeliveryNotifyManage/deliveryNotify_Add.html',
            'controller':'deliveryNotifyAddController'
        },
        {
            'state':'deliveryNotifyConfirm',
            'url':'/deliveryNotifyConfirm',
            'templateUrl':'fourDeliveryNotifyManage/deliveryNotify_confirm.html',
            'controller':'deliveryNotifyConfirmController'

        },

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntbuyindoModule',dependency,routeArry)
}());
