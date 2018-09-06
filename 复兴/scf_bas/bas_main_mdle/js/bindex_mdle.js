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
            'state':'bindex',
            'url':'/bindex',
            'default':'true',
            //'templateUrl':'bmain/main.html',
            'templateUrl':'bmain/index.html',
            'controller':'scfindexController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bindex_mdle',dependency,routeArry);
}());