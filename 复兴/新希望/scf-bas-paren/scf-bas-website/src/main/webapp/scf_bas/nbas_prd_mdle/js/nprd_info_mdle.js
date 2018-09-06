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
            'templateUrl':'../html/prdinfo/nprd_info_list.html',
            'controller':'NbasPrdInfoListController'
        },
        {
            'state':'prddtl',
            'url':'/prddtl',
            'default':'true',
            'templateUrl':'../html/prdinfo/nprd_info.html',
            'controller':'NbasPrdInfoController'
        },
        {
            'state':'prddtl.baseinfo',
            'url':'/prddtl.baseinfo',
            'templateUrl':'../html/prdinfo/nprd_info_edit.html',
            'controller':'NbasPrdInfoEditController'
        },
        {
            'state':'prddtl.cost',
            'url':'/prddtl.cost',
            'templateUrl':'../html/prdinfo/nprd_cost_list.html',
            'controller':'NbasPrdCostListController'
        },
        {
            'state':'prddtl.warn',
            'url':'/prddtl.warn',
            'templateUrl':'../html/prdinfo/nprd_warn_list.html',
            'controller':'NbasPrdWarnListController'
        },
        {
            'state':'prddtl.chkdir',
            'url':'/prddtl.chkdir',
            'templateUrl':'../html/prdinfo/nprd_chkdir_list.html',
            'controller':'NbasPrdChkdirListController'
        },
        {
            'state':'prddtl.cont',
            'url':'/prddtl.cont',
            'templateUrl':'../html/prdinfo/nprd_cont_list.html',
            'controller':'NbasPrdContListController'
        },
        {
            'state':'prddtl.loanway',
            'url':'/prddtl.loanway',
            'templateUrl':'../html/prdinfo/nprd_loanway_list.html',
            'controller':'NbasPrdLoanWayListController'
        },
        {
            'state':'prddtl.flwork',
            'url':'/prddtl.flwork',
            'templateUrl':'../html/prdinfo/nprd_flow_list.html',
            'controller':'NbasPrdFlowController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bas_nprdInfo_mdle',dependency,routeArry);
}());