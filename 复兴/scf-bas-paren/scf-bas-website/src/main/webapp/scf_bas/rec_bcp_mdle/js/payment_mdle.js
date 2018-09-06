/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
(function(){

    //跳转的路由配置
    var routeArry=[
       {
           'state':'paymentapplylist',
           'url':'/paymentapplylist',
           'default':'true',
           'templateUrl':'payment/payment_apply_list.html',
           'controller':'paymentApplyListController'
       },
                   
        {
            'state':'paymentapply',
            'url':'/paymentapply',
            'templateUrl':'payment/payment_apply.html',
            'controller':'paymentApplyController'
        },
        
        {
            'state':'paymentupdate',
            'url':'/paymentupdate/:appNo',
            'templateUrl':'payment/payment_update.html',
            'controller':'paymentUpdateController'
        }



    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('payment_mdle',dependency,routeArry);
}());