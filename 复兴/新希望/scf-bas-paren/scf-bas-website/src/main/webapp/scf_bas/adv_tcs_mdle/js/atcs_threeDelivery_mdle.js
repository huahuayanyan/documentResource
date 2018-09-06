/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'threeDelivery',
            'url':'/threeDelivery',
            'default':'true',
            'templateUrl':'atcsthreeDelivery/threeDelivery.html',
            'controller':'threeDeliveryController'
        },
       /* {
            'state':'add',
            'url':'/app_add',
            'default':'true',
            'templateUrl':'lnapp/app_add.html',
            'controller':'lnappaddController'
        },*/
        {
            'state':'threeDeliveryApp',
            'url':'/threeDeliveryApp',
            //'default':'true',
            'templateUrl':'atcsthreeDelivery/threeDeliveryApp.html',
           'controller':'threeDeliveryAppController'
        },
        {
            'state':'threeDeliveryApp.dtl',
            'url':'/threeDeliveryApply_dtl',
            'templateUrl':'atcsthreeDelivery/threeDeliveryDtl.html',
            'controller':'threeDeliveryDtlController'
        },
        {
            'state':'threeDeliveryApp.mrninfo',
            'url':'/threeDeliveryApply_mrninfo',
           // 'templateUrl':'../../sto_dmp_mdle/html/lowerprice/mrninfo.html',
            'templateUrl':'atcsthreeDelivery/appendBailAmount.html',
            'controller':'mrnDeliveryController'
        },
        {
            'state':'threeDeliveryApp.fileupload',
            'url':'/fileupload',
            'templateUrl':'../../sto_dmp_mdle/html/lowerprice/fileupload.html',
            'controller':'fileuploadController'
        },
        {
            'state':'threeDeliveryApp.threeProtocol',
            'url':'/threeDeliveryApply_threeProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd.html',
            'controller':'bcntThreeProtocolAddController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('atcsthreeDeliveryModule',dependency,routeArry)
}());
