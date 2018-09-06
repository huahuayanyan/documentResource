/**
 * Created by htrad0036 on 2017/2/23.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'colligateQry',
            'url':'/colligateQry',
            'default':'true',
            'templateUrl':'threeWareColligate/threeWareColligate_qry.html',
            'controller':'colligateQryController'
        },{
            'state':'colligateDtl',
            'url':'/colligateDtl',
            'templateUrl':'threeWareColligate/threeWareColligate_dtl.html',
            'controller':'colligateDtlController'
        },
        {
            'state':'colligateDtl.baseInfo',
            'url':'/baseInfo',
            'templateUrl':'threeWareColligate/threeWareColligate_dtl1.html',
            'controller':'baseInfoController'

        },
        {
            'state':'colligateDtl.protocolInfo',
            'url':'/protocolInfo',
            'templateUrl':'threeWareColligate/threeWareColligate_dtl2.html',
            'controller':'protocolInfoController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_qry_mdle',dependency,routeArry);
}());