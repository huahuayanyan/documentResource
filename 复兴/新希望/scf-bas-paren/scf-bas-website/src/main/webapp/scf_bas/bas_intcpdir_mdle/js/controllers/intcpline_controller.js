/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var intcplineController = function($scope,$common,$timeout,dataDeliver,$state,$eventCommunicationChannel) {
	$scope.ds = [];
	$scope.dsindex=0;
	$scope.checkResult="SUC";
	var  rData =dataDeliver.getter();
	$scope.queryTable = function() {
		var promise = $common.get_asyncData("bSysChkControlService/queryBSysChkPlList", {modelId:rData.modelId});
		promise.then(	
				function(res) {
					if (res.errorCode == "SUC") {
						$scope.ds= res.contextData;	
						$timeout(function() {$scope.updatedata();}, 800);						
					} else {
						$common.get_tipDialog(res.errorMsg, 'showError');
					}
				});
	};
	
	$scope.updatedata = function() {
                                              if($scope.dsindex<$scope.ds.length){
													var promise = $common.get_asyncData("bSysChkControlService/executeSingleSysChk", {bSysChkRec:$scope.ds[$scope.dsindex],chkMap:rData.chkMap});
													promise.then(	
															function(res) {
																if (res.errorCode == "SUC") {
																    var result=res.contextData;	
																    for(var j=0;j<$scope.ds.length;j++){
																    	if($scope.ds[j].chkPlId==result.chkPlId){
																    		$scope.ds[j].rem=result.rem;
																    		$scope.ds[j].stat=result.stat;
																    		//存在有拦截
																    		if("3"==result.stat){
																    			$scope.checkResult="ERR";
																    		}
																    		break;
																    	}
																    	
																    }	
																	
																} 
															});						
                                              }	
                                              $scope.dsindex++;    
                                         if($scope.dsindex<$scope.ds.length){$timeout(function() {$scope.updatedata();},  800);}		
									    

		};

	    $scope.confirm_onClick =function(){
	    	if($scope.dsindex<$scope.ds.length){
	    		 $common.get_tipDialog('当前未执行完毕！', 'showError');
	    		  return;
	    	}
	    	   //通知上级作业域结果
	    	   $scope.$emit('interceptEvent', {checkResult:$scope.checkResult});
	    	   $scope.closeThisDialog();

	    };	
		
	    $scope.close_onClick =function(){
	    	   //通知上级作业域结果,返回
	    	  $scope.$emit('interceptEvent', {checkResult:'RET'});
	    	  $scope.closeThisDialog();

	    };	
				
		
	$scope.queryTable();

};
