/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var historyQueryController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var productId=dataDeliver.getter();
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
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:{productId:productId}
        };
        var promise = $common.get_asyncData("bPbcMtgMktPriceHisService/getMortMarketPriByProId",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //返回按钮
    $scope.back_onClick = function(){
        $state.go("marketPriceQuery");
    };

};
