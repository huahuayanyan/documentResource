/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var lowerpriceguideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = {};
    $scope.priceadjust = {};
    var conId ;
    var appno ;
    var prtclNo ;
    //基础任务信息为Tab页
    //if(window.appNo)
    //{
    //    appno = window.appNo;
    //    conId = "";
    //    //监听分页
    //    $scope.$watch("conId+appno",function() {
    //        $scope.queryLowerPrice();
    //    })
    //}
    //else
    //{
    //    $scope.source = window.source;
    //    $scope.priceadjust = $scope.source.priceadjust;
    //    $state.go("priceadjust");
    //}
    //基础任务信息不为Tab页
    if(window.appNo)
    {
        appno = window.appNo;
        conId = "";
    }
    else
    {
        appno = "";
        $scope.source.gntycon = dataDeliver.getter();
        conId = $scope.source.gntycon.conId;
    }
    $scope.$watch("conId+appno",function() {
        $scope.queryLowerPrice();
    })
    //获取最低控货价值信息
    $scope.queryLowerPrice = function(paramData)
    {
        var lowerPrice = {slaveContno:conId,appno:appno}
        $common.get_asyncData("lowerPriceService/findSBcpAppliLowerPriceByExample", {lowerPrice:lowerPrice}).then(function (res) {
            var price ;
            if (res.errorCode == "SUC") {
                price = res.contextData;
                $scope.source.priceadjust = price;
                if(price.slaveContno)
                {
                    conId = price.slaveContno;
                }
                $scope.queryGntyCon();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取担保合同信息
    $scope.queryGntyCon = function(paramData)
    {
        $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                $scope.source.gntycon = gnty;
                $scope.source.priceadjust.supplyChainPdId = $scope.source.gntycon.vidPrdId;
                $scope.source.priceadjust.suppProductName = $scope.source.gntycon.vidPrdNm;
                prtclNo = gnty.prtclNo;
                $scope.queryMortgageInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
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
                    $state.go("priceadjust");
                    window.source = $scope.source;
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            $state.go("priceadjust");
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
    $scope.back_onClick = function()
    {
        $state.go("list");
    }
    //表格--------结束-------------------------
};
