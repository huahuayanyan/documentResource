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
            'templateUrl':'qualityApply/mortgageContSlaveList.html',
            'controller':'fourPledgeListController'
        },
        {
            'state':'fourPledgeApply',
            'url':'/fourPledgeApply',
            'templateUrl':'qualityApply/qualityApply.html',
            'controller':'fourPledgeApplyController'
        },
        {
            'state':'fourPledgeApply.dtl',
            'url':'/fourPledgeDtl',
            'templateUrl':'qualityApply/qualityApplyDtl.html',
            'controller':'fourPledgeDtlController'
        },
        {
            'state':'fourPledgeApply.gntyconInfo',
            'url':'/gntyconInfo',
            'templateUrl':'qualityApply/gntyconInfo.html',
            'controller':'gntyconInfoController'
        },
        {
            'state':'fourPledgeApply.monitorProtocol',
            'url':'/monitorProtocol',
            'templateUrl':'qualityApply/monitorProtocol.html',
            'controller':'monitorProtocolController'
        },
        {
            'state':'fourPledgeApply.custInfo',
            'url':'/custInfo',
            'templateUrl':'qualityApply/custInfo.html',
            'controller':'custInfoController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bpbcQualityApply',dependency,routeArry)
}());
