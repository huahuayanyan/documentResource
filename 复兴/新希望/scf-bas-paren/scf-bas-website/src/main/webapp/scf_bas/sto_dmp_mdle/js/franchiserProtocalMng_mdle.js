/**
 * Created by htrad0036 on 2017/4/17.
 */


(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'franchiserQry',
            'url':'/franchiserQry',
            'default':'true',
            'templateUrl':'../html/franchiserProtocolMng/fourProtocol_list.html',
            'controller':'fourProtocolController'
        },{
            'state':'franchiserDtl',
            'url':'/franchiserDtl',
            'templateUrl':'../html/franchiserProtocolMng/fourProtocol_dtl.html',
            'controller':'fourProtocolDtlController'
        },
        {
            'state':'franchiserDtl.baseInfo',
            'url':'/baseInfo',
            'templateUrl':'../html/franchiserProtocolMng/fourProtocol_dtl1.html',
            'controller':'baseInfoController'

        },
        {
            'state':'franchiserDtl.mortgageCont',
            'url':'/franchiserDtl_mortgageCont',
            'templateUrl':'../html/franchiserProtocolMng/fourProtocol_dtl2.html',
            'controller':'mortgageContController'
        },
        {
            'state':'franchiserDtl.mntProtocol',
            'url':'/franchiserDtl_mntProtocol',
            'templateUrl':'../html/franchiserProtocolMng/fourProtocol_dtl3.html',
            'controller':'mntProtocolController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_dmp_mdle',dependency,routeArry);
}());