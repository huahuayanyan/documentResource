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
            'state':'prdBizSur',
            'url':'/prdBizSur',
            'default':'true',
            'templateUrl':'bmatl/prd_biz_sur_list.html',
            'controller':'PrdBizSurListController'
        },
        {
            'state':'prdBizSurAdd',
            'url':'/prdBizSurAdd',
            'templateUrl':'bmatl/prd_biz_sur_add.html',
            'controller':'PrdBizSurAddController'
        }

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bprd_bizsur_mdle',dependency,routeArry);
}());
