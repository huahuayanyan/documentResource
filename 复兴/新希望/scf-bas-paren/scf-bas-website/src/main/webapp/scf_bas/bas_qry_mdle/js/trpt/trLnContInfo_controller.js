/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var trLnContInfoController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    $scope.trptInfoDtlForm = {};
    $scope.trptInfoDtlForm = dataDeliver.getter();

    $scope.cntinfodatasource ={ds:[]};

    $scope.cntinfoconf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    };


    $scope.cntinfoselected={select:[]};
    //$scope.cntInfoForm={};
    //
    //$scope.mprotdatasource={ds:[]};
    //
    //$scope.mprotselected={select:[]};
    //
    //$scope.mprotConf = {
    //    pageNo:1,
    //    pageSize:10,
    //    totalRecord:0
    //};

    var debetNo = $scope.trptInfoDtlForm.debetNo;

    //监听分页
    $scope.$watch("cntinfoconf.pageNo+cntinfoconf.pageSize",function(){
        $scope.queryBcntBuyInfo();
    });

    ////查询选中列表中的第一个的详情
    //$scope.$watch("$scope.cntinfoselected.select[0]",function(){
    //    $scope.queryBcntBuyInfoDtl();
    //});


    //采购商品信息列表监听分页
    //$scope.$watch("mprotConf.pageNo+mprotConf.pageSize",function(){
    //    $scope.queryBcntBuyInfo();
    //});


    $scope.cntinfoback_onClick = function(){
        $state.go("trptInfoList");
    };


    $scope.queryBcntBuyInfo = function(){
        var data= {
            pageNo: $scope.cntinfoconf.pageNo,
            pageSize: $scope.cntinfoconf.pageSize,
            debetNo:debetNo
        };
        var promise = $common.get_asyncData("bQryTripartiteDeliveryInfoService/getContBuyInfoByDebetNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.cntinfodatasource.ds = data.records;
                $scope.cntinfoconf.totalRecord = data.totalRecord;
                //for(var i=0;i<$scope.cntinfoconf.totalRecord;i++){
                //    console.log(JSON.stringify($scope.cntinfodatasource.ds[i] ));
                //}
                //console.log(JSON.stringify($scope.cntinfodatasource.ds));
                //console.log(JSON.stringify($scope.cntinfoselected));

                //$scope.cntInfoForm = $scope.cntinfodatasource.ds[0];
                //data ={pageNo:$scope.mprotConf.pageNo,pageSize:$scope.mprotConf.pageSize,bCntBuyInfo: $scope.cntInfoForm};
                //var mprotPromise = $common.get_asyncData("iBCntMprotInfoService/findBCntMprotInfoVOByPage",data);
                //mprotPromise.then(function(res){
                //    if (res.errorCode =="SUC"){
                //        data = res.contextData;
                //        $scope.mprotdatasource.ds = data.records;
                //        $scope.mprotConf.totalRecord = data.totalRecord;
                //    }
                //});
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.cntinfoselected.select=[];
    };

    $scope.queryBcntBuyInfoDtl = function(){
        $scope.cntinfoselected.select=[];
    };

    //购销合同详情 0003288
    $scope.column = function(row){
        $common.get_ngDialog('trpt/tradeConInfo.html', $scope
            ,["$scope",function(dialogScope){
                tradeConInfoController(dialogScope,$scope,$common,row);
            }],"购销合同信息",{showClose:true});
    };
    //表格--------结束-------------------------
};
