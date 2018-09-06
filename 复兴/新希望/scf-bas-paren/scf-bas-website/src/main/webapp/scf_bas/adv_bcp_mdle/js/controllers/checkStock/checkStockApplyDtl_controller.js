
var checkStockDtlController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.baseInfo={};
    $scope.datasource={//初始化表格对象
        ds:[
        ]
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
        $scope.queryTable();
    });
    // 对账结果为不平时，不平原因为必输
    $scope.result_change =function(val){
        if(val=="02"){
            $scope.require="common.require";
        }else{
            $scope.require="";
        }
    };
    //前页面传递参数
    var param = dataDeliver.getter();
    var obj = angular.fromJson(param);
    if(obj.type=='detail') {
        $scope.disable = true;
        $scope.hideSave = true;
    }else{
        $scope.disable = false;
        $scope.hideSave = false;
    }
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };
    $scope.queryTable = function(){
        //基本信息
        $scope.baseInfo=param.baseInfo;
        //总计
        var data1= {
            conditionForm:{protocolNo:param.baseInfo.protocolNo}
        };
        var promise1 = $common.get_asyncData("checkStockService/checkStockDebtSum",data1);
        promise1.then(function(res){
            var data;
            if (res.errorCode == "SUC") {
                $scope.baseInfo.lnciAmtSum = res.contextData.lnciAmtSum;
                $scope.baseInfo.amountOutSum = res.contextData.amountOutSum;
                $scope.baseInfo.amountInSum = res.contextData.amountInSum;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });

        //提货情况
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            conditionForm:{protocolNo:param.baseInfo.protocolNo}
        };
        var promise = $common.get_asyncData("checkStockService/threeCheckStockDebetByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
        $scope.selected.select=[];
    };

    //保存
    $scope.save_onClick = function(){
        if($.doValidate("baseInfo")) {
            var data = {
                baseInfo: $scope.baseInfo
            };
            var primise = $common.get_asyncData("checkStockService/checkStockVerify", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    $state.go("checkStockList");//跳转
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };

    //返回
    $scope.return_onClick = function(){
        var data = { };
        dataDeliver.setter(data);//传值[可选]
        $state.go("checkStockList");//跳转
    };



};
