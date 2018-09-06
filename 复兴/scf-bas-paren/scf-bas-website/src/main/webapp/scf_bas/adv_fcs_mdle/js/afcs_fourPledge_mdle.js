/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fourPledgeList',
            'url':'/fourPledgeList',
            'default':'true',
            'templateUrl':'afcsfourPledge/fourPledgeList.html',
            'controller':'fourPledgeListController'
        },
        {
            'state':'fourPledgeApply',
            'url':'/fourPledgeApply',
            'templateUrl':'afcsfourPledge/fourPledgeApply.html',
            'controller':'fourPledgeApplyController'
        },
        {
            'state':'fourPledgeApply.dtl',
            'url':'/fourPledgeDtl',
            'templateUrl':'afcsfourPledge/fourPledgeDtl.html',
            'controller':'fourPledgeDtlController'
        },
        {
            'state':'fourPledgeApply.gntyconInfo',
            'url':'/gntyconInfo',
            'templateUrl':'../html/afcsfour/gntyconInfo.html',
            'controller':'gntyconInfoController'
        },
        {
            'state':'fourPledgeApply.monitorProtocol',
            'url':'/monitorProtocol',
            'templateUrl':'../html/afcsfour/monitorProtocol.html',
            'controller':'monitorProtocolController'
        },
        {
            'state':'fourPledgeApply.custInfo',
            'url':'/custInfo',
            'templateUrl':'../html/afcsfour/custInfo.html',
            'controller':'custInfoController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('afcsfourPledge',dependency,routeArry)
}());
