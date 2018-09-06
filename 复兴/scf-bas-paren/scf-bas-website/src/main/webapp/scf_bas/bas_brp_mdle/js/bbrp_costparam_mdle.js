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
            'state':'brpCostParam',
            'url':'/brpCostParam',
            'default':'true',
            'templateUrl':'bcost/brp_cost_param_list.html',
            'controller':'BrpCostParamListController'
        },
        {
            'state':'brpCostParamAdd',
            'url':'/brpCostParamAdd',
            'templateUrl':'bcost/brp_cost_param_add.html',
            'controller':'BrpCostParamAddController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bas_brp_mdle',dependency,routeArry);
}());