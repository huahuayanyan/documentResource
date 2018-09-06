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
            'state':'bcpInfoList',
            'url':'/bcp_info_list',
            'default':'true',
            'templateUrl':'manage/bcp_info_list.html',
            'controller':'BcpInfoListController'
        },
        {
            'state':'bussChoose',
            'url':'/buss_choose',
            'templateUrl':'manage/buss_choose.html',
            'controller':'BussChooseController'
        },
        {
            'state':'bcpInfoAdd',
            'url':'/bcp_info_add',
            'templateUrl':'manage/bcp_info_add.html',
            'controller':'BcpInfoAddController'
        },
        {
            'state':'bcpInfoUpdate',
            'url':'/bcp_info_update',
            'templateUrl':'manage/bcp_info_update.html',
            'controller':'BcpInfoUpdateController'
        },
        {
            'state':'billAdd',
            'url':'/bill_add',
            'templateUrl':'manage/bill_add.html',
            'controller':'BillAddController'
        },
        {
            'state':'progress',
            'url':'/progress',
            'templateUrl':'manage/bcp_progress_list.html',
            'controller':'ProgressController'
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
        {
            'state':'debtConList',
            'url':'/debtCon_list',
            'templateUrl':'transfer/debtConList.html',
            'controller':'DebtConListController'
        },

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_info_manage_mdle',dependency,routeArry);
}());