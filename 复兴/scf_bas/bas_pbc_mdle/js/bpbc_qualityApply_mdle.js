/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'qualityApplyMain',
            'url':'/qualityApplyMain',
            'default':'true',
            'templateUrl':'qualityApply/qualityApplyMain.html',
            'controller':'qualityApplyMainController'
        },
        {
            'state':'qualityApply',
            'url':'/qualityApply',
            'templateUrl':'qualityApply/qualityApply.html',
            'controller':'qualityApplyController'
        },
        {
            'state':'qualityApply.qualityInfo',
            'url':'/qualityInfo',
            'templateUrl':'qualityApply/qualityApplyInfo.html',
            'controller':'qualityApplyInfoController'
        },
        {
            'state':'qualityApply.gntyconInfo',
            'url':'/gntyconInfo',
            'templateUrl':'qualityApply/gntyconInfo.html',
            'controller':'gntyconInfoController'
        },
        {
            'state':'qualityApply.mortgageInfo',
            'url':'/mortgageInfo',
            'templateUrl':'qualityApply/mortgageInfo.html',
            'controller':'mortgageInfoController'
        },
        {
            'state':'qualityApply.custInfo',
            'url':'/custInfo',
            'templateUrl':'qualityApply/custInfo.html',
            'controller':'custInfoController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bpbcQualityApply',dependency,routeArry)
}());
