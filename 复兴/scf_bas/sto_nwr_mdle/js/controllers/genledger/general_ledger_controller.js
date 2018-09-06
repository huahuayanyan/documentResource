/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var generalLedgerController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.baseinfo = dataDeliver.getter();
    $scope.source = {};
    $scope.source.baseinfo = $scope.baseinfo;
    window.source = $scope.source;
    $state.go("genldeger.detail");
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};
