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
            'templateUrl':'debtPoolManage/bcp_info_list.html',
            'controller':'BcpInfoListController'
        },
        {
            'state':'bussChoose',
            'url':'/buss_choose',
            'templateUrl':'debtPoolManage/buss_choose.html',
            'controller':'BussChooseController'
        },
        {
            'state':'bcpInfoAdd',
            'url':'/bcp_info_add',
            'templateUrl':'debtPoolManage/bcp_info_add.html',
            'controller':'BcpInfoAddController'
        },
        {
            'state':'bcpInfoUpdate',
            'url':'/bcp_info_update',
            'templateUrl':'debtPoolManage/bcp_info_update.html',
            'controller':'BcpInfoUpdateController'
        },
        {
            'state':'billAdd',
            'url':'/bill_add',
            'templateUrl':'debtPoolManage/bill_add.html',
            'controller':'BillAddController'
        },
        {
            'state':'progress',
            'url':'/progress',
            'templateUrl':'manage/bcp_progress_list.html',
            'controller':'ProgressController'
        },
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
    scubeUI.module('rbcp_debtPool_manage_mdle',dependency,routeArry);
}());