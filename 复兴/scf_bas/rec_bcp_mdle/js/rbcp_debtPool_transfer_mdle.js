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
            'state':'debtPoolConList',
            'url':'/debtPoolConList',
            'default':'true',
            'templateUrl':'debtPoolTransfer/debtPoolConList.html',
            'controller':'DebtPoolConListController'
        },
        {
            'state':'debtPoolTransfer',
            'url':'/debtPoolTransfer',
            'templateUrl':'debtPoolTransfer/debtPool_transfer.html',
            'controller':'DebtPoolTransferController'
        },
        {
            'state':'debtPoolTransferApply',
            'url':'/debtPool_transfer_apply',
            'templateUrl':'debtPoolTransfer/debtPool_transfer_apply.html',
            'controller':'DebtPoolTransferApplyController'
        },
        {
            'state':'appliCostOut',
            'url':'/appli_cost_out',
            'templateUrl':'transfer/appli_cost_out.html',
            'controller':'AppliCostOutController'
        },
        {
            'state':'bcpBaseInfo',
            'url':'/bcp_base_info_list',
            'templateUrl':'debtPoolTransfer/bcp_base_info_list.html',
            'controller':'BcpBaseInfoController'
        },


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_debtPool_transfer_mdle',dependency,routeArry);
}());