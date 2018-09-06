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
            'state':'acc',
            'url':'/acc_list',
            'default':'true',
            'templateUrl':'baccinfo/acc_list.html',
            'controller':'AccInfoListController'
        },
        {
            'state':'accAdd',
            'url':'/acc_add',
            'templateUrl':'baccinfo/acc_add.html',
            'controller':'AccInfoAddController'
        },


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bacc_info_mdle',dependency,routeArry);
}());