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
            'state':'prdReceMatl',
            'url':'/prdReceMatl',
            'default':'true',
            'templateUrl':'bmatl/prd_rece_matl_list.html',
            'controller':'PrdReceMatlListController'
        },
        {
            'state':'prdReceMatlAdd',
            'url':'/prdReceMatlAdd',
            'templateUrl':'bmatl/prd_rece_matl_add.html',
            'controller':'PrdReceMatlAddController'
        }

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bprd_matl_mdle',dependency,routeArry);
}());
