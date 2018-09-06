/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var MarPriHistoryController = function($scope,$common,$state,dataDeliver) {
    var row =dataDeliver.getter();

    $scope.datasource={ds:[]};

    $scope.selected={select:[]};

    $scope.conf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    }

    $scope.conditionForm={
    }

    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    $scope.queryTable = function(){

        var data={
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            commonQueryVO:{productId_Q:row.productId}
        };
        var url ="bPbcMtgMktPriceService/getMortMarketPriceHandHisInfoPage"
        $common.get_asyncData(url,data).then(function(res){
            if(res.errorCode=="SUC"){
                data= res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,"showError");
            }
        });

    }

    $scope.back_onClick = function(){
        $state.go("infoList");
    }

};
