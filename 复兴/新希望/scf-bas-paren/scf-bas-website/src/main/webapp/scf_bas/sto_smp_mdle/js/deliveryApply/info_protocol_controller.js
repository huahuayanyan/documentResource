/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var infoProtocolController = function($scope,$common,$state,dataDeliver) {
	$scope.protocolInfo = {};
	$scope.disable = true;
	var protocolNo = window.source.baseinfo.protocolNo;
	$scope.protocolDtl = {};
	//监管公司名称下拉框
	$scope.thrNameList ={
		type: "table",//展示类型table  tree
		url: "monitorProtocolService/getThrNamebyProtocol",//请求url
		split: "",//分隔符
		extentColumn: "codeName",
		column: ["codeName"]//展示内容
	}
	//出质人名称下拉框
	$scope.secNameList ={
		type: "table",//展示类型table  tree
		url: "monitorProtocolService/getSecNamebyProtocol",//请求url
		//param:{kk:"e"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		split: "",//分隔符
		extentColumn: "codeName",
		column: ["codeName"]//展示内容
	}
	//合作机构下拉框
	$scope.cooperationBrcodeNmList = {
		type:"table",//展示类型table  tree
		url:"bSysCommonService/selectBranchInfo",//请求url
		param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		split:"-",//分隔符
		extentColumn:"brName",
		column:["brNo","brName"]//展示内容
	};
	$common.get_asyncData("monitorProtocolService/monitorProtocolQuery",{protocolCode:protocolNo}).then(function(res){
		var protocol;
		if (res.errorCode =="SUC"){
			protocol = res.contextData;
			$scope.protocolInfo = protocol;
			thrNameInfo(res.contextData.thrCode);
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});
	function thrNameInfo(ds) {
		var custCd = ds;
		var bCrmMoniEntInfo = {custcd:custCd}
		var promise = $common.get_asyncData("bCrmMoniEntInfoService/findBCrmMoniEntInfoByKey", {bCrmMoniEntInfo:bCrmMoniEntInfo});
		promise.then(function (res) {
			if (res.errorCode == "SUC") {
				$scope.protocolDtl = res.contextData;
				$scope.protocolDtl.monitortype=$scope.protocolDtl.monitortype.split(",");
			} else {
				$common.get_tipDialog(res.errorMsg, 'showInform');
			}
		});
	}
	//----------------------------------点击事件------------------------------
};
