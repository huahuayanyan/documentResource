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
            'state':'prdbcop',
            'url':'/prdbcop',
            'default':'true',
            'templateUrl':'bcop/prd_bcop_list.html',
            'controller':'PrdBcopListController'
        },
        {
            'state':'prdBcopAdd',
            'url':'/prdBcopAdd',
            'templateUrl':'bcop/prd_bcop_add.html',
            'controller':'PrdBcopAddController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bas_prd_mdle',dependency,routeArry);
}());