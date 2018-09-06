/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpApplyGuideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    var appno = window.appNo;
    $scope.source = {};
    $scope.baseinfo = {};
    $scope.taskform = {};
    $scope.$watch("appno",function(){
        $scope.queryBaseInfo();
    });
    $scope.queryBaseInfo = function(paramData)
    {
        var data = {
            bussInfoVO:$scope.baseinfo
        }
        $common.get_asyncData("bcntBcpAppliBaseInfoService/findBCntAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
            var baseinfo;
            if (res.errorCode == "SUC") {
                baseinfo = res.contextData;
                baseinfo.flag = "view";
                $scope.baseinfo = baseinfo;
                $scope.source.baseinfo = baseinfo;
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("bcntBcpAppliBaseInfoService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                $state.go("bcpApplybaseinfo");
                window.source = $scope.source;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };

    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};
