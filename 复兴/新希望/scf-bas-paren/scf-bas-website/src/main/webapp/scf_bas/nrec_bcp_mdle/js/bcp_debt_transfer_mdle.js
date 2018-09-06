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
            'state':'list',
            'url':'/list',
            'default':'true',
            'templateUrl':'debtTransfer/transfer_apply_list.html',
            'controller':'TransferAppplyListController'
        },
        {
            'state':'transferApply',
            'url':'/transferApply',
            'templateUrl':'debtTransfer/debt_transfer.html',
            'controller':'nRDebtTransferController'
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
    scubeUI.module('bcp_debt_transfer_mdle',dependency,routeArry);
}());