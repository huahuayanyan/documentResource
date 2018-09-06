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
           'state':'list',
           'url':'/list',
           'default':'true',
           'templateUrl':'repayment/cashpayment/payment_apply_list.html',
           'controller':'paymentApplyListController'
       },
        {
            'state':'paymentApply',
            'url':'/paymentApply',
            'templateUrl':'repayment/cashpayment/payment_apply.html',
            'controller':'paymentApplyController'
        },
        {
            'state':'showProcess',
            'url':'/showProcess',
            'default':'true',
            'templateUrl':'../html/showProcess/showProcess.html',
            'controller':'showProcessController'
        }



    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcp_cashpay_mdle',dependency,routeArry);
}());