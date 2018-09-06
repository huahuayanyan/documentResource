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
            'state':'debtConList',
            'url':'/debtCon_list',
            'default':'true',
            'templateUrl':'transfer/debtConList.html',
            'controller':'DebtConListController'
        },
        {
            'state':'debtTransfer',
            'url':'/debt_transfer',
            'templateUrl':'transfer/debt_transfer.html',
            'controller':'DebtTransferController'
        },
        {
            'state':'debtApply',
            'url':'/debt_transfer_apply',
            'templateUrl':'transfer/debt_transfer_apply.html',
            'controller':'DebtTransferApplyController'
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
            'templateUrl':'transfer/bcp_base_info_list.html',
            'controller':'BcpBaseInfoController'
        },


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_info_transfer_mdle',dependency,routeArry);
}());