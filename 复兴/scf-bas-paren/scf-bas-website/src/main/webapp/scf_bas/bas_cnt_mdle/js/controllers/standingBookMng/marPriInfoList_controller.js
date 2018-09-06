/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/19
 */

var MarPricInfoListController = function($scope,$common,$state,dataDeliver) {

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
            commonQueryVO:$scope.conditionForm
        };

        var url ="bPbcMtgMktPriceService/getTblMortMarPriPage"
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

    $scope.bound_onClick = function(){
    	if($scope.selected.select.length==1){
    		var otherform = dataDeliver.getter();
    		otherform.fixMortgageNo = $scope.selected.select[0].productId;
    		otherform.marketPrice = $scope.selected.select[0].price;
        	dataDeliver.setter(otherform);
        	 $state.go("edit");
    	}else{
    		 $common.get_tipDialog('请至少选择一条记录！','showInform');
    	}
    }
    
    $scope.back_onClick = function(){
        	$state.go("edit");
    }

    $scope.submit_onClick = function(){
        $scope.queryTable();
    }

    $scope.rebort_onClick = function(){
        $scope.conditionForm.productId_Q ='';
        $scope.conditionForm.productName_Q ='';
        $scope.conditionForm.mortgageLevelThreeName_Q ='';
        $scope.selected.select =[];
        $scope.queryTable();
    }

};
