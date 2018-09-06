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
            'templateUrl':'franchiserProtocolMng/fourProtocol_list.html',
            'controller':'fourProtocolController'
        },{
            'state':'franchiserDtl',
            'url':'/franchiserDtl',
            'templateUrl':'franchiserProtocolMng/fourProtocol_dtl.html',
            'controller':'fourProtocolDtlController'
        },
        {
            'state':'franchiserDtl.baseInfo',
            'url':'/baseInfo',
            'templateUrl':'franchiserProtocolMng/fourProtocol_dtl1.html',
            'controller':'baseInfoController'

        },
        {
            'state':'franchiserDtl.protocolInfo',
            'url':'/protocolInfo',
            'templateUrl':'franchiserProtocolMng/fourProtocol_dtl2.html',
            'controller':'protocolInfoController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_qry_mdle',dependency,routeArry);
}());