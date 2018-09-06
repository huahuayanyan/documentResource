/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2017/01/12
 */
(function(){

    //跳转的路由配置
    var routeArry=[
       {
           'state':'paymentpoolapplylist',
           'url':'/paymentpoolapplylist',
           'default':'true',
           'templateUrl':'paymentpool/paymentpool_apply_list.html',
           'controller':'paymentPoolApplyListController'
       },
                   
        {
            'state':'paymentpoolapply',
            'url':'/paymentpoolapply',
            'templateUrl':'paymentpool/paymentpool_apply.html',
            'controller':'paymentPoolApplyController'
        },
        
        {
            'state':'paymentpoolupdate',
            'url':'/paymentpoolupdate/:appNo',
            'templateUrl':'paymentpool/paymentpool_update.html',
            'controller':'paymentPoolUpdateController'
        }



    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('paymentpool_mdle',dependency,routeArry);
}());