/**
 * Created by htrad0036 on 2017/2/23.
 */
var colligateDtlController  = function($scope,$timeout,$common,$state,dataDeliver) {

    $state.go("colligateDtl.baseInfo");//跳转
    var obj = angular.fromJson(dataDeliver.getter());
    $scope.tabClose_onClick = function(){
        $state.go("colligateQry");
    };
};