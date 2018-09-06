/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'dsptCntLst',
            'url':'/dsptCntLst',
            'default':'true',
            'templateUrl':'dsptreg/dsptCntList.html',
            'controller':'dsptConListController'
        },
        {
            'state':'dsptRegAdd',
            'url':'/dsptRegAdd',
            'templateUrl':'dsptreg/dsptRegAdd.html',
            'controller':'dsptRegAddController'
        },

        {
            'state':'bcpBaseInfo',
            'url':'/bcp_base_info_list',
            'templateUrl':'debtPoolTransfer/bcp_base_info_list.html',
            'controller':'BcpBaseInfoController'
        },
        {
            'state':'pooldsptInvModf',
            'url':'/pooldsptInvModf',
            'templateUrl':'pooldsptreg/pooldsptInvModf.html',
            'controller':'pooldsptInvModfController'
        },
        {
            'state':'progress',
            'url':'/progress',
            'templateUrl':'manage/bcp_progress_list.html',
            'controller':'ProgressController'
        },
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntdebtModule',dependency,routeArry)
}());
