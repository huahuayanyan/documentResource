var infoController  = function($scope,$timeout,$common,$state,dataDeliver) {

    $state.go("info.staticInfo");//跳转
    var obj = angular.fromJson(dataDeliver.getter());
    $scope.tabClose_onClick = function(){
        $state.go("debtPoolList");
    };
};