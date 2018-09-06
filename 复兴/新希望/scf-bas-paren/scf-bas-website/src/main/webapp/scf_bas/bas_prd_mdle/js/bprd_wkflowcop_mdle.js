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
            'state':'prdWkflowCop',
            'url':'/prdWkflowCop',
            'default':'true',
            'templateUrl':'bcop/prd_wkflowcop_list.html',
            'controller':'PrdWkflowCopListController'
        },
        {
            'state':'prdWkflowCopAdd',
            'url':'/prdWkflowCopAdd',
            'templateUrl':'bcop/prd_wkflowcop_add.html',
            'controller':'PrdWkflowCopAddController'
        }

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bprd_wkflowcop_mdle',dependency,routeArry);
}());
