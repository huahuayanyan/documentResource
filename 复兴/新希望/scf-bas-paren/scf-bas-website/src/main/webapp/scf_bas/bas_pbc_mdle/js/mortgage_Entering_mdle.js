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
            'templateUrl':'mortgageEnteringXhdt/bcnt_mortgageEntering.html',
            'controller':'bcntMortgageEnteringController'
        },
        {
            'state':'fourPledgeList',
            'url':'/fourPledgeList',
            'templateUrl':'qualityApplyXhdt/mortgageContSlaveList.html',
            'controller':'fourPledgeListController'
        },
        {
            'state':'bcntMortgageEnteringAdd',
            'url':'/bcntMortgageEnteringAdd',
            'templateUrl':'mortgageEnteringXhdt/bcnt_mortgageEnteringAdd.html',
            'controller':'bcntMortgageEnteringAddController'
        },
        {
            'state':'fourPledgeApply',
            'url':'/fourPledgeApply',
            'templateUrl':'qualityApplyXhdt/qualityApply.html',
            'controller':'fourPledgeApplyController'
        },
        {
            'state':'fourPledgeApply.dtl',
            'url':'/fourPledgeDtl',
            'templateUrl':'qualityApplyXhdt/qualityApplyDtl.html',
            'controller':'fourPledgeDtlController'
        },
        {
            'state':'fourPledgeApply.gntyconInfo',
            'url':'/gntyconInfo',
            'templateUrl':'qualityApplyXhdt/gntyconInfo.html',
            'controller':'gntyconInfoController'
        },
        {
            'state':'fourPledgeApply.monitorProtocol',
            'url':'/monitorProtocol',
            'templateUrl':'qualityApplyXhdt/monitorProtocol.html',
            'controller':'monitorProtocolController'
        },
        {
            'state':'fourPledgeApply.custInfo',
            'url':'/custInfo',
            'templateUrl':'qualityApplyXhdt/custInfo.html',
            'controller':'custInfoController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bcntMortgageEnteringAdd',dependency,routeArry)
}());
