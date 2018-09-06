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
            'state':'infoList',
            'url':'/infoList',
            'default':'true',
            'templateUrl':'marPriAlter/marPri_infoList.html',
            'controller':'MarPricInfoListController'
        },
        {
            'state':'history',
            'url':'/history',
            'templateUrl':'marPriAlter/marPri_history.html',
            'controller':'MarPriHistoryController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('marPri_alter_mdle',dependency,routeArry);
}());