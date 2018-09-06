/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'quantityNoticeBaseInfo',
            'url':'/quantityNoticeBaseInfo',
            'default':'true',
            'templateUrl':'quantityNoticeBaseInfo/quantityNoticeBaseInfo_list.html',
            'controller':'quantityNoticeBaseInfoController'
        },

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bsysthreeProtocol',dependency,routeArry)
}());
