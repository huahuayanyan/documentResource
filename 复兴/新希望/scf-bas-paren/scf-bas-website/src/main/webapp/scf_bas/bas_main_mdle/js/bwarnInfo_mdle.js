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
            'state':'warnInfoList',
            'url':'/warnInfoList',
            'default':'true',
            'templateUrl':'bmain/warnInfoList.html',
            'controller':'warnInfoListController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bwarnInfo_mdle',dependency,routeArry);
}());