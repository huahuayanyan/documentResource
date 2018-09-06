/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var stockImportApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.baseinfo = dataDeliver.getter();
    $scope.source = {};
    $scope.source.baseinfo = $scope.baseinfo;
    var appno;

    //获取任务信息
    $scope.queryTaskForm = function(paramData){
        $common.get_asyncData("stockListImportApplyService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                dataDeliver.getter().appno = data.appno;
                dataDeliver.getter().appliInfo = data;
                $scope.source.taskform = {};
                $state.go("stockImportApply.import");
                window.source = $scope.source;
                window.Write = false;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };

    $scope.queryTaskForm();

    $scope.back_onClick = function(){
        $state.go("stockListImportApply");
    };
    //表格--------结束-------------------------
};
