/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var nwrinfoSlaveController = function($scope,$common,$state,dataDeliver) {
	$scope.row = {};
	$scope.disable = true;
	var conId = window.source.baseinfo.slaveContno;
	//-------------------页面初始化--------------
	$common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
		var gnty;
		if (res.errorCode =="SUC"){
			gnty = res.contextData;
			$scope.row = gnty;
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});

	//----------------------------------点击事件------------------------------
};
