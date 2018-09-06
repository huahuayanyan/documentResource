/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/11/29
 */

var threeProDetailController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
	$scope.threeProtocolForm={};
	$scope.productSource={
		ds: []
	};
	$scope.selectbrcode={
		ds: []
	};
	var  bData =dataDeliver.getter();
	if(!bData){
		var  bData = window.parent.data;
	}
	//查看
	$scope.disable=true;
	$scope.sellerNmDisable = true;
	$scope.loanWay = true;
	$scope.startDate = true;
	$scope.endDate = true;
	$scope.threeProtocolStatus = true;
	$scope.cooperationBrcodeNmDisable = true;
	$scope.brcodeDisable = true;
	$scope.coreNmDisable = true;
	$scope.otherCustName = true;
	$scope.fouNameDisable = true;
	$scope.dutyAssumeType = true;
	$scope.firstBailRatio = true;
	$scope.firstBailType = true;
	$scope.otherDes = true;
	$scope.save = true;
	$scope.back=true;
	queryProtocol();
	var productPar= {
		pageNo: '1',
		pageSize: '999999',
		bPrdInfo:{parentId:'2100'}
	};
	var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage",productPar);
	promise.then(function(res){
		var data;
		if (res.errorCode =="SUC"){
			data = res.contextData;
			$scope.productSource.ds = data.records;
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});
	//买方客户名称下拉-begin
	$scope.sellerNmContent = {
		type:"table",//展示类型table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
		//param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		split:"-",//分隔符
		extentColumn:"cname",
		column:["custcd","cname"]//展示内容
	};
	$scope.dooextent = function(ds){
		$scope.threeProtocolForm.custcd=ds.custcd;
		$scope.threeProtocolForm.sellerNm=ds.cname;
	};
	$scope.$watch("threeProtocolForm.sellerNm",function(){
		//ht-input-extent  需要用监听的方式来传额外的参数
		$scope.sellerNmContent.param ={
			creditFlag:'1',
			custType:'1',
			sellerNm:$scope.threeProtocolForm.cname,
			custcd:$scope.threeProtocolForm.custcd
		}
	});
	//买方客户名称下拉-end
	//卖方客户名称下拉-begin
	$scope.coreNmContent = {
		type:"table",//展示类型table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
		//param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		split:"-",//分隔符
		extentColumn:"cname",
		column:["custcd","cname"]//展示内容
	};
	$scope.coreNmExtent = function(ds){
		$scope.threeProtocolForm.coreCustcd=ds.custcd;
		$scope.threeProtocolForm.coreNm=ds.cname;
	};
	$scope.$watch("threeProtocolForm.coreNm",function(){
		//ht-input-extent  需要用监听的方式来传额外的参数
		$scope.coreNmContent.param ={
			coreFlag:'1',
			custType:'1',
			coreNm:$scope.threeProtocolForm.coreNm,
			coreCustcd:$scope.threeProtocolForm.coreCustcd
		}
	});
	//卖方客户名称下拉-end
	//承担方客户名称下拉-begin
	$scope.fouNameContent = {
		type:"table",//展示类型table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
		//param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		split:"-",//分隔符
		extentColumn:"cname",
		column:["custcd","cname"]//展示内容
	};
	$scope.fouNameExtent = function(ds){
		$scope.threeProtocolForm.fouCd=ds.custcd;
		$scope.threeProtocolForm.fouName=ds.cname;
	};
	$scope.$watch("threeProtocolForm.coreNm",function(){
		//ht-input-extent  需要用监听的方式来传额外的参数
		$scope.fouNameContent.param ={
			coreFlag:'1',
			custType:'1',
			fouName:$scope.threeProtocolForm.fouName,
			fouCd:$scope.threeProtocolForm.fouCd
		}
	});
	//承担方客户名称下拉-end
	//合作机构下拉-begin
	$scope.cooperationBrcodeNmContent = {
		type:"table",//展示类型table  tree
		url:"bSysCommonService/selectBranchInfo",//请求url
		param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		split:"-",//分隔符
		extentColumn:"brName",
		column:["brNo","brName"]//展示内容
	};
	$scope.cooperationBrcodeNmExtent = function(ds){
		$scope.threeProtocolForm.cooperationBrcode=ds.brNo;
		$scope.threeProtocolForm.cooperationBrcodeNm=ds.brName;
	};
	$scope.$watch("threeProtocolForm.cooperationBrcodeNm",function(){
		//ht-input-extent  需要用监听的方式来传额外的参数
		$scope.cooperationBrcodeNmContent.param ={
			brNo:$scope.threeProtocolForm.cooperationBrcode,
			brName:$scope.threeProtocolForm.cooperationBrcodeNm,
			brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
		};
	});
	//合作机构下拉-end

	//根据协议号加载担保提货协议信息
	function queryProtocol(){
		var threeProtocolVO ={
			protocolNo:bData.vidNo
		};
		var data = {
			threeProtocolVO:threeProtocolVO
		}
		var promise=$common.get_asyncData("threeProtocolService/queryThreeProtocolForOneObject",data);
		promise.then(function (res) {
			if(res.errorCode=="SUC"){
				data = res.contextData;
				$scope.threeProtocolForm=data;
				$scope.selectbrcode.ds =data.listBctl;
				$scope.threeProtocolForm.brcode=data.brcode;
				$scope.threeProtocolForm.inputorgname=data.inputorgname;
				if(data.dutyAssumeType!=null){
					$scope.threeProtocolForm.dutyAssumeType=JSON.parse(data.dutyAssumeType);
				}
				if(data.loanWay!=null){
					$scope.threeProtocolForm.loanWay=JSON.parse(data.loanWay);
				}
				$scope.brcodeDisable =true;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		})
	}
	/*//保存/修改操作按钮
	$scope.save_onClick = function(){
		if($.doValidate("threeProtocolForm")) {
			var data = {
				threeProtocolVO: $scope.threeProtocolForm
			};
			if(bData.flag == "add"){
				//新增信息保存
				var primise = $common.get_asyncData("threeProtocolService/threeProtocolAdd", data);
			}else if (bData.flag == "update"){
				var primise = $common.get_asyncData("threeProtocolService/threeProtocolModify", data);
			}
			primise.then(function (res) {
				if (res.errorCode == "SUC") {
					$common.get_tipDialog('保存成功！', 'showSuccess');
					$state.go("bcntthreeProtocol");
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
			});
		}
	};*/
	$scope.back_onClick = function () {
		$state.go("bcntthreeProtocol");
	};

	//表格--------结束-------------------------
};
