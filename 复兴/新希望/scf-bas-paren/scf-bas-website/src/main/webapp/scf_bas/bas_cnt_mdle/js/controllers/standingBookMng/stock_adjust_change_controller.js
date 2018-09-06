/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/18
 */

var stockAdjustChangeController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    $scope.conditionForm=dataX;
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
            bCrrGntyCon:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCntStockAdjustService/getSlaveContcode", {pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                bCrrGntyCon:$scope.conditionForm});
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
    
    //库存调整
    $scope.doChange_onClick = function(){
    	if($scope.selected.select.length !=1)
    		 $common.get_tipDialog('请选择一条记录！','showInform');
    	else{
    		var data = $scope.selected.select[0];
    		data.conId=dataX.conId;
    		data.gutNm=dataX.gutNm;
    		data.strtDt=dataX.strtDt;
    		data.endDt=dataX.endDt;
    		data.gutVal=dataX.gutVal;
    		data.flag="update";
    		data.disable="true";
    		dataDeliver.setter(data);
    		$state.go("update");
    	}
    }
    
    
    
    //绑定市价
    $scope.bound_onClick = function(){
    	 $state.go("bound");
    }
    
    //取消绑定
    $scope.unBound_onClick = function(){
    	$scope.$apply(
    			$scope.otherform={
    				flag:'add',
    				curcdNm:'CNY'
    			}
    		)
    }

    //保存
    $scope.save_onClick = function(){
    	if($.doValidate("otherform")) {
    		var bPbcMtgBaseInfoDO = $scope.otherform;
    		bPbcMtgBaseInfoDO.supplyChainPdId="1210020";

            if(dataX.flag == "add"){
                var primise = $common.get_asyncData("bCntStockAdjustService/saveStockAdjust",{bPbcMtgBaseInfoDO: bPbcMtgBaseInfoDO});
            }else if (dataX.flag == "update"){
               
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    $state.go("list");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
    	}
    	
    }

    
    //页面信息实时查询加载
    function findFormInfo(){
        var data= {
            pageNo: 1,
            pageSize: 10,
            bCrrGntyCon:{conId:dataX.protocol.conId}
        };
        var promise = $common.get_asyncData("bCrrGntyConService/getSlaveContList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                if(data.records[0]){
                    $scope.otherform = data.records[0];
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

    //返回按钮
    $scope.back_onClick = function () {
        $state.go("list");
    };
};
