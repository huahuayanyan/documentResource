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
            'templateUrl':'bcntbuyinfo/cntInfoList.html',
            'controller':'cntInfoListController'
        },
        {
            'state':'bcntInfoAddView',
            'url':'/bcntInfoAddView',
            'templateUrl':'bcntbuyinfo/cntInfoAdd.html',
            'controller':'cntInfoAddController'
        },
        {
            'state':'bcntInfoUpdtView',
            'url':'/bcntInfoUpdtView',
            'templateUrl':'bcntbuyinfo/cntInfoAdd.html',
            'controller':'cntInfoUpdtController'

        },
        {
            'state':'bcntBuyInfoview',
            'url':'/bcntdebtview',
            'templateUrl':'bcntbuyinfo/cntInfoView.html',
            'controller':'cntInfoViewController'

        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntbuyindoModule',dependency,routeArry)
}());
