/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntMortgageEntering',
            'url':'/bcntMortgageEntering',
            'default':'true',
            'templateUrl':'mortgageEntering/bcnt_mortgageEntering.html',
            'controller':'bcntMortgageEnteringController'
        },
        {
            'state':'fourPledgeList',
            'url':'/fourPledgeList',
            'templateUrl':'qualityApply/mortgageContSlaveList.html',
            'controller':'fourPledgeListController'
        },
        {
            'state':'bcntMortgageEnteringAdd',
            'url':'/bcntMortgageEnteringAdd',
            'templateUrl':'mortgageEntering/bcnt_mortgageEnteringAdd.html',
            'controller':'bcntMortgageEnteringAddController'
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
    

    
    scubeUI.module('bcntMortgageEnteringAdd',dependency,routeArry)
}());
