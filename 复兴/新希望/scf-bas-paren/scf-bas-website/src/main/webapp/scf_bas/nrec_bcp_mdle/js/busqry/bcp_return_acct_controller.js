/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpReturnAcctController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    //初始化查询条件对象
    $scope.conditionForm={
    //    bussType_Q:"1230040"//默认页面显示为国内保理池
    };

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
        $scope.queryTable();
    });

    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            //$scope.conditionForm={bussType_Q:"1230040"};
            $scope.selected.select=[];//清空选项s
        })
    };

    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };
//todo
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            commonQueryVO:$scope.conditionForm
        };

        var promise = $common.get_asyncData("bCntBcpInfoBussQryService/getDebtReturnAccountByPage",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
                console.log(JSON.stringify($scope.datasource.ds ));
                //for(var i=0;i<$scope.conf.totalRecord;i++){
                //    console.log(JSON.stringify($scope.datasource.ds[i] ));
                //}
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };

    //查看明细
    $scope.acctdtlcolumn = function(row){
        $state.go("dbrtacctdtl");
        dataDeliver.setter(row);
    };


    //查看购销合同
    $scope.bctbuycolumn = function(row){
        $state.go("dbrtacctdtl");
        dataDeliver.setter(row);
    };

    //$scope.debtCont={buyerCustcd:'',buyerName:''};
    //$scope.dptReg_onClick = function(){
    //    if($scope.selected.select.length <= 0){
    //        $common.get_tipDialog('请至少选择一条记录！','showInform');
    //    }else{
    //
    //        var debtCont=$scope.selected.select[0];
    //        var data = {bCntDebtInfo:debtCont};
    //
    //        $state.go("dsptRegAdd");
    //        dataDeliver.setter(data);
    //
    //
    //    }
    //}

    //$scope.regBack_onClick = function(){
    //    $state.go("dsptRegAdd");
    //}


    //表格--------结束-------------------------
};
