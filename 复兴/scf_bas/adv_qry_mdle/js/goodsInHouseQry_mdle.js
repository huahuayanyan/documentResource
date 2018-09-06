/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'goodsInHouse',
            'url':'/goodsInHouse',
            'default':'true',
            'templateUrl':'goodsInHouse/goodsInHouse_qry.html',
            'controller':'goodsInHouseController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_qry_mdle',dependency,routeArry);
}());