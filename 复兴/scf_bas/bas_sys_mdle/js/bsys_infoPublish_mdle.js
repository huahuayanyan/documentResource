/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'list',
            'url':'/list',
            'default':'true',
            'templateUrl':'../html/infoPublish/infoPublish_list.html',
            'controller':'infoPublishListController'
        },
     {
         'state':'edit',
         'url':'/edit',
         'templateUrl':'../html/infoPublish/infoPublish_edit.html',
         'controller':'infoPublishEditController'
     }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bsys_infoPublish_mdle',dependency,routeArry)
}());