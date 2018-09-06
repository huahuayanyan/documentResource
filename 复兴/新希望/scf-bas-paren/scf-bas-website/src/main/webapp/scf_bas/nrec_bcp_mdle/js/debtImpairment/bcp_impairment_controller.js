/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var nrecBcpImpairmentController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    var flag = $scope.otherform.flag;
    $scope.source = {};
    var appno;
    var stateUrl;
    $scope.baseurl = "";
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
    $scope.$watch("otherform.mastContno",function(){
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData)
    {
        $common.get_asyncData("ndebtImpairmentService/FactoringAllowanceApplyAddGetter", {debtBussInfoVO:$scope.otherform}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                if(data.financingType=="2")
                {//应收账款池融资  国内保理池   应收账款质押池     出口退税池   票据池      票据池
                    stateUrl = "impairment.pooledit";
                }
                else
                {//应收账款融资
                    stateUrl = "impairment.edit";
                }
                $scope.otherform = data;
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("ndebtImpairmentService/findRBcpAppliBussInfoByAppno", {appno:appno,factType:$scope.otherform.factType}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!$scope.otherform.insertDate)
                {
                    $scope.otherform.insertDate = $scope.taskform.startTaskDate;
                }
                $scope.otherform.flag = flag;
                $scope.source.otherform = $scope.otherform;
                $scope.baseurl = stateUrl;
                $state.go(stateUrl);
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
