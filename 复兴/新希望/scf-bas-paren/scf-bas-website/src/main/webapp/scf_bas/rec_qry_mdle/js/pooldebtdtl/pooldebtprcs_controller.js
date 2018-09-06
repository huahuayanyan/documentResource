/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var pooldebtprcsController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {


    var getter = dataDeliver.getter();
    var selectRow = getter.pooldebtinfo;
    var debtId="";
    if(selectRow.appno){//如果传过来的信息有申请号，就应该用对应的debtId字段
        debtId=selectRow.debtId;
    }else{
        debtId=selectRow.id;//应收账款基本信息ID
    }
    console.log(JSON.stringify(getter));

    $scope.prcsdatasource={ds:[]};

    $scope.selected={select:[]};

    $scope.prcsconf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};



    //监听分页
    $scope.$watch("prcsconf.pageNo+prcsconf.pageSize",function(){
        $scope.queryprcstable();
    });

    $scope.dtlBack_onClick = function(){
        $state.go("pooldebtList");
    }
    var　rBcpDebtBussDtl={debtId:debtId};

    $scope.queryprcstable = function(){
        var data= {
            pageNo: $scope.prcsconf.pageNo,
            pageSize: $scope.prcsconf.pageSize,
            value:rBcpDebtBussDtl,
        };
        var promise = $common.get_asyncData("rBcpDebtBussDtlService/findRBcpDebtBussDtlPageByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.prcsdatasource.ds = data.records;
                $scope.prcsconf.totalRecord = data.totalRecord;
                console.log(JSON.stringify($scope.prcsdatasource.ds ));
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        //$scope.selected.select=[];
    };


    //表格--------结束-------------------------
};
