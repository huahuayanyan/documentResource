/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntBuyInfoList',
            'url':'/bcntBuyInfoList',
            'default':'true',
            'templateUrl':'bcntfourbuyinfo/cntInfoList.html',
            'controller':'cntInfoListController'
        },
        {
            'state':'bcntInfoAddView',
            'url':'/bcntInfoAddView',
            'templateUrl':'bcntfourbuyinfo/cntInfoAdd.html',
            'controller':'cntInfoAddController'
        },
        {
            'state':'bcntInfoUpdtView',
            'url':'/bcntInfoUpdtView',
            'templateUrl':'bcntfourbuyinfo/cntInfoAdd.html',
            'controller':'cntInfoUpdtController'

        },
        {
            'state':'bcntBuyInfoview',
            'url':'/bcntdebtview',
            'templateUrl':'bcntfourbuyinfo/cntInfoView.html',
            'controller':'cntInfoViewController'

        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntfourbuyinfoModule',dependency,routeArry)
}());
