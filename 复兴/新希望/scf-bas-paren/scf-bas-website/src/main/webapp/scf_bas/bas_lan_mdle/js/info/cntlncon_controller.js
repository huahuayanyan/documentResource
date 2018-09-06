/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var cntlnconController = function($scope,$common,$state,dataDeliver) {
	var data1= dataDeliver.getter();
	$scope.otherform={};
	//-------------------ҳ���ʼ��--------------
	$scope.datasource={
		ds: []
	};
	var id = window.appNo;
	var promise = $common.get_asyncData("bCrrGntyConService/findGntyConInfoByAppno",{appno:id});
	promise.then(function(res){
		var pdata;
		if (res.errorCode =="SUC"){
			pdata = res.contextData;
			$scope.otherform = pdata;
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});

};
