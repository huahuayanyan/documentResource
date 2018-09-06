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

    $scope.cntinfodatasource = {ds : []};

    $scope.cntinfoconf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    };
    $scope.cntinfoselected={select:[]};

    $scope.cntInfoForm = dataDeliver.getter();

    var debetNo = dataDeliver.getter().debetNo;

    //监听分页
    $scope.$watch("cntinfoconf.pageNo+cntinfoconf.pageSize",function(){
        $scope.queryBcntInfo();
    });

    $scope.back_onClick = function(){
        $state.go("fourLnciDtlList");
    };

    $scope.queryBcntInfo = function(){
        var data= {
            pageNo: $scope.cntinfoconf.pageNo,
            pageSize: $scope.cntinfoconf.pageSize,
            debetNo:debetNo
        };
        var promise = $common.get_asyncData("fourLnciDtlQueryService/getContBuyInfoByDebetNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.cntinfodatasource.ds = data.records;
                $scope.cntinfoconf.totalRecord = data.totalRecord;
                angular.extend($scope.cntInfoForm, data.records[0]);
                $scope.memoForm = data.records[0];
                $scope.queryBcntBuyInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.cntinfoselected.select=[];
    };

    $scope.mprotdatasource={ds:[]};

    $scope.mprotselected={select:[]};

    $scope.mprotConf = {
        pageNo:1,
        pageSize:10,
        totalRecord:0
    };

    //采购商品信息列表监听分页
   /* $scope.$watch("mprotConf.pageNo+mprotConf.pageSize",function(){
            $scope.queryBcntBuyInfo();
    });*/

    $scope.queryBcntBuyInfo = function() {
        data = {
            pageNo: $scope.mprotConf.pageNo,
            pageSize: $scope.mprotConf.pageSize,
            bCntBuyInfo: $scope.cntinfodatasource.ds[0]
        };
        var mprotPromise = $common.get_asyncData("iBCntMprotInfoService/findBCntMprotInfoVOByPage", data);
        mprotPromise.then(function (res) {
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.mprotdatasource.ds = data.records;
                $scope.mprotConf.totalRecord = data.totalRecord;
            }
        });
    };
};
