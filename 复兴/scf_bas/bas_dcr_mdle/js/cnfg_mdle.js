/**
 * Created by htrad0027 on 2016/10/26.
 */
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
            'templateUrl':'cnfg/list.html',
            'controller':'cnfgController'
        }       
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('cnfgMdle',dependency,routeArry);
}());
