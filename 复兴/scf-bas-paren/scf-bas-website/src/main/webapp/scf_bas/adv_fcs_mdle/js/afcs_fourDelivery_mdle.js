/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fourDelivery',
            'url':'/fourDelivery',
            'default':'true',
            'templateUrl':'afcsfourDelivery/fourDelivery.html',
            'controller':'fourDeliveryController'
        },
       /* {
            'state':'add',
            'url':'/app_add',
            'default':'true',
            'templateUrl':'lnapp/app_add.html',
            'controller':'lnappaddController'
        },*/
        {
            'state':'fourDeliveryApp',
            'url':'/fourDeliveryApp',
            //'default':'true',
            'templateUrl':'afcsfourDelivery/fourDeliveryApp.html',
           'controller':'fourDeliveryAppController'
        },
        {
            'state':'fourDeliveryApp.dtl',
            'url':'/fourDeliveryApply_dtl',
            'templateUrl':'afcsfourDelivery/fourDeliveryDtl.html',
            'controller':'fourDeliveryDtlController'
        },
        {
            'state':'fourDeliveryApp.mrninfo',
            'url':'/fourDeliveryApply_mrninfo',
           // 'templateUrl':'../../sto_dmp_mdle/html/lowerprice/mrninfo.html',
            'templateUrl':'afcsfourDelivery/appendBailAmount.html',
            'controller':'mrnDeliveryController'
        },
        {
            'state':'fourDeliveryApp.fileupload',
            'url':'/fileupload',
            'templateUrl':'../../sto_dmp_mdle/html/lowerprice/fileupload.html',
            'controller':'fileuploadController'
        },
        {
            'state':'fourDeliveryApp.monitorProtocol',
            'url':'/fourDeliveryApp.monitorProtocol',
            'templateUrl':'../html/afcsfour/monitorProtocol.html',
            'controller':'monitorProtocolController'
        },
        {
            'state':'fourDeliveryApp.gntyconInfo',
            'url':'/fourDeliveryApp.gntyconInfo',
            'templateUrl':'../html/afcsfour/gntyconInfo.html',
            'controller':'gntyconInfoController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('afcsfourDeliveryModule',dependency,routeArry)
}());
