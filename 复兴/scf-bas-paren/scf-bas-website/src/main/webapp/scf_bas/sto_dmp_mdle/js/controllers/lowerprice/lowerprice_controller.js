/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var lowerpriceController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.source = {};//初始化传值信息、
    var appno;
    var conId = $scope.otherform.conId;//抵质押合同号
    var prtclNo = $scope.otherform.prtclNo;//监管合同号（监管协议号）
    //监听分页
    $scope.$watch("conId+prtclNo",function() {
        $scope.queryLowerPrice();
    })
    //获取担保合同信息
    $scope.source.gntycon = $scope.otherform;
    //获取监管合同信息
    $scope.queryMortgageInfo = function(paramData)
    {
        $common.get_asyncData("lowerPriceService/findMonitorProtocolByProtocolNo", {protocolNo:prtclNo}).then(function (res) {
            var mortgageInfo;
            if (res.errorCode == "SUC") {
                mortgageInfo = res.contextData;
                $scope.source.mortgageInfo = mortgageInfo.records[0];
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取最低控货价值信息
    $scope.queryLowerPrice = function(paramData)
    {
        var lowerPrice = {slaveContno:conId}
        $common.get_asyncData("lowerPriceService/findSBcpAppliLowerPriceByExample", {lowerPrice:lowerPrice}).then(function (res) {
            var price ;
            if (res.errorCode == "SUC") {
                price = res.contextData;
                $scope.source.priceadjust = price;
                //$scope.priceadjust = price;
                if(!price.piid)
                {
                    $scope.source.priceadjust.supplyChainPdId = $scope.source.gntycon.vidPrdId;
                    $scope.source.priceadjust.suppProductName = $scope.source.gntycon.vidPrdNm;
                    $scope.queryMortgageInfo();
                }
                else
                {
                    appno = price.appno;
                    $scope.queryMortgageInfo();
                }

            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("lowerPriceService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    $state.go("priceedit.priceadjust");
                    window.source = $scope.source;
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            $state.go("priceedit.priceadjust");
                            window.source = $scope.source;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    })
                }
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
