/**
 * Created by htrad0055 on 2017/4/18.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'overMoniLimitAmt',
            'url':'/overMoniLimitAmt',
            'default':'true',
            'templateUrl':'../../adv-wrn-mdle/html/overMoniLimitAmt/overMoniLimitAmt.html',
            'controller':'OverMoniLimitAmtController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_wrn_mdle',dependency,routeArry);
}());