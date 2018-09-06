/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var registerGuideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.taskform = {};
    $scope.source = {};
    $scope.otherform = {};
    var appno = window.appNo;
    var appId;
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTaskForm();
    });
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("cashEqualValueRegisterService/findBPbcAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.source.applitask = data;
                appId = data.mastContno;
                $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                    var taskform;
                    if (res.errorCode == "SUC") {
                        taskform = res.contextData;
                        $scope.source.taskform = taskform;
                        $scope.queryLnCon();
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取信贷合同信息
    $scope.queryLnCon = function(paramData)
    {
        $common.get_asyncData("bCrrLnConService/findBCrrLnConByAppId", {appId:appId}).then(function (res) {
            var lncon;
            if (res.errorCode == "SUC") {
                lncon = res.contextData;
                lncon.appno = appno;
                $scope.otherform = lncon;
                $scope.queryTable();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取合同基本信息
    $scope.queryTable = function(paramData)
    {
        var data =
        {
            bCrrLnConCash:$scope.otherform
        }
        $common.get_asyncData("cashEqualValueRegisterService/ContractorQryGetter",data).then(function (res) {
            var lncon;
            if (res.errorCode =="SUC"){
                lncon = res.contextData;
                $scope.lnconform = lncon.records[0];
                $scope.source.lnconform = $scope.lnconform;
                $state.go("cashEqualValueGuide");
                window.source = $scope.source;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //表格--------结束-------------------------
};
