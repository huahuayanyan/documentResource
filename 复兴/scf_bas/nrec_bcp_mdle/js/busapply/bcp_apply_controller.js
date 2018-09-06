/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = {};
    $scope.baseinfo = dataDeliver.getter();
    $scope.source.baseinfo = $scope.baseinfo;
    window.source = $scope.source;
    $state.go("bcpApply.baseinfo");
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};
