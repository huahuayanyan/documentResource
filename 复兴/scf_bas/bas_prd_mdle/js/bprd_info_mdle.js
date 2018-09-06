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
            'state':'prdInfo',
            'url':'/prdInfo',
            'default':'true',
            'templateUrl':'bprd/prd_info_list.html',
            'controller':'PrdInfoListController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'bprd/tree.html',
            'controller':'TreeController'
        },
        {
            'state':'tree.prdInfoAdd',
            'url':'/prdInfoAdd',
            'templateUrl':'bprd/prd_info_add.html',
            'controller':'PrdInfoAddController'
        },
        {
            'state':'tree.prdBaseInfo',
            'url':'/prdBaseInfo',
            'templateUrl':'bprd/prd_base_info.html',
            'controller':'PrdBaseInfoController'
        },
        {
            'state':'industryChoose',
            'url':'/industryChoose',
            'templateUrl':'bprd/industry_choose.html',
            'controller':'IndustryChooseController'
        },
        {
            'state':'costBindAdd',
            'url':'/costBindAdd',
            'templateUrl':'bprd/cost_bind_add.html',
            'controller':'CostBindAddController'
        },
        {
            'state':'warnBindAdd',
            'url':'/warnBindAdd',
            'templateUrl':'bprd/warn_bind_add.html',
            'controller':'WarnBindAddController'
        },
        // TODO 新增 2016-12-7
        // tab 授信政策
        {
            'state':'tree.prdCreditPly',
            'url':'/prdCreditPly',
            'templateUrl':'bprd/prd_cret_info.html',
            'controller':'PrdCretInfoController'
        },
        {
            'state':'receMatlBindAdd',
            'url':'/receMatlBindAdd',
            'templateUrl':'bprd/rece_matl_bind_add.html',
            'controller':'ReceMatlBindAddController'
        },
        {
            'state':'bizSurBindAdd',
            'url':'/bizSurBindAdd',
            'templateUrl':'bprd/biz_sur_bind_add.html',
            'controller':'BizSurBindAddController'
        },
        // tab 额度设置
        {
            'state':'tree.prdIcrSetInfo',
            'url':'/prdIcrSetInfo',
            'templateUrl':'bprd/prd_icr_set_info.html',
            'controller':'PrdIcrSetInfoController'
        },
        {
            'state':'bPrdCreditBindAdd',
            'url':'/bPrdCreditBindAdd',
            'templateUrl':'bprd/credit_bind_add.html',
            'controller':'CreditBindAddController'
        },
        //tab 组件定义
        {
            'state':'tree.prdCopLibBind',
            'url':'/prdCopLibBind',
            'templateUrl':'bprd/prd_cop_lib_bind_info.html',
            'controller':'PrdCopLibBindInfoController'
        },
        {
            'state':'CopLibBindAdd',
            'url':'/copLibBindAdd',
            'templateUrl':'bprd/cop_lib_bind_add.html',
            'controller':'CopLibBindAddController'
        },
        //tab 产品报告
        {
            'state':'tree.prdReportInfo',
            'url':'/prdReportInfo',
            'templateUrl':'bprd/prd_report_info.html',
            'controller':'PrdReportInfoController'
        },
        // 产品报告 查看时跳转此页面
        {
            'state':'prdReportInfo',
            'url':'/prdReportInfo',
            'templateUrl':'bprd/prd_report_info.html',
            'controller':'PrdReportInfoController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bas_prd_mdle',dependency,routeArry);
}());