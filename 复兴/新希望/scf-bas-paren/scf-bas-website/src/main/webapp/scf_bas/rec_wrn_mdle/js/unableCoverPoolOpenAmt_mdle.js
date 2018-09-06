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
            'state':'unableCoverPoolOpenAmt',
            'url':'/unableCoverPoolOpenAmt',
            'default':'true',
            'templateUrl':'wrnQry/unableCoverPoolOpenAmtQry.html',
            'controller':'unableCoverPoolOpenAmtController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rec_wrn_mdle',dependency,routeArry);
}());