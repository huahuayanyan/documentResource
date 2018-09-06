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
            'state':'overduelist',
            'url':'/overduelist',
            'default':'true',
            'templateUrl':'warnQry/overdue_list.html',
            'controller':'overdueListController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rec_wrnOverdue_mdle',dependency,routeArry);
}());