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
	//�鿴
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
	//�򷽿ͻ���������-begin
	$scope.sellerNmContent = {
		type:"table",//չʾ����table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//����url
		//param:{creditFlag: '1',custType:'1'},//�������,�����д�����Ի���param:{},�������뵱ǰ�ֶβ�ѯ
		split:"-",//�ָ���
		extentColumn:"cname",
		column:["custcd","cname"]//չʾ����
	};
	$scope.dooextent = function(ds){
		$scope.threeProtocolForm.custcd=ds.custcd;
		$scope.threeProtocolForm.sellerNm=ds.cname;
	};
	$scope.$watch("threeProtocolForm.sellerNm",function(){
		//ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
		$scope.sellerNmContent.param ={
			creditFlag:'1',
			custType:'1',
			sellerNm:$scope.threeProtocolForm.cname,
			custcd:$scope.threeProtocolForm.custcd
		}
	});
	//�򷽿ͻ���������-end
	//�����ͻ���������-begin
	$scope.coreNmContent = {
		type:"table",//չʾ����table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//����url
		//param:{creditFlag: '1',custType:'1'},//�������,�����д�����Ի���param:{},�������뵱ǰ�ֶβ�ѯ
		split:"-",//�ָ���
		extentColumn:"cname",
		column:["custcd","cname"]//չʾ����
	};
	$scope.coreNmExtent = function(ds){
		$scope.threeProtocolForm.coreCustcd=ds.custcd;
		$scope.threeProtocolForm.coreNm=ds.cname;
	};
	$scope.$watch("threeProtocolForm.coreNm",function(){
		//ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
		$scope.coreNmContent.param ={
			coreFlag:'1',
			custType:'1',
			coreNm:$scope.threeProtocolForm.coreNm,
			coreCustcd:$scope.threeProtocolForm.coreCustcd
		}
	});
	//�����ͻ���������-end
	//�е����ͻ���������-begin
	$scope.fouNameContent = {
		type:"table",//չʾ����table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//����url
		//param:{creditFlag: '1',custType:'1'},//�������,�����д�����Ի���param:{},�������뵱ǰ�ֶβ�ѯ
		split:"-",//�ָ���
		extentColumn:"cname",
		column:["custcd","cname"]//չʾ����
	};
	$scope.fouNameExtent = function(ds){
		$scope.threeProtocolForm.fouCd=ds.custcd;
		$scope.threeProtocolForm.fouName=ds.cname;
	};
	$scope.$watch("threeProtocolForm.coreNm",function(){
		//ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
		$scope.fouNameContent.param ={
			coreFlag:'1',
			custType:'1',
			fouName:$scope.threeProtocolForm.fouName,
			fouCd:$scope.threeProtocolForm.fouCd
		}
	});
	//�е����ͻ���������-end
	//������������-begin
	$scope.cooperationBrcodeNmContent = {
		type:"table",//չʾ����table  tree
		url:"bSysCommonService/selectBranchInfo",//����url
		param:{ brAttr:"1"},//�������,�����д�����Ի���param:{},�������뵱ǰ�ֶβ�ѯ
		split:"-",//�ָ���
		extentColumn:"brName",
		column:["brNo","brName"]//չʾ����
	};
	$scope.cooperationBrcodeNmExtent = function(ds){
		$scope.threeProtocolForm.cooperationBrcode=ds.brNo;
		$scope.threeProtocolForm.cooperationBrcodeNm=ds.brName;
	};
	$scope.$watch("threeProtocolForm.cooperationBrcodeNm",function(){
		//ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
		$scope.cooperationBrcodeNmContent.param ={
			brNo:$scope.threeProtocolForm.cooperationBrcode,
			brName:$scope.threeProtocolForm.cooperationBrcodeNm,
			brAttr:"1"  //�������ԣ�0-�Ǵ������С�1-��������
		};
	});
	//������������-end

	//����Э��ż��ص������Э����Ϣ
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
	/*//����/�޸Ĳ�����ť
	$scope.save_onClick = function(){
		if($.doValidate("threeProtocolForm")) {
			var data = {
				threeProtocolVO: $scope.threeProtocolForm
			};
			if(bData.flag == "add"){
				//������Ϣ����
				var primise = $common.get_asyncData("threeProtocolService/threeProtocolAdd", data);
			}else if (bData.flag == "update"){
				var primise = $common.get_asyncData("threeProtocolService/threeProtocolModify", data);
			}
			primise.then(function (res) {
				if (res.errorCode == "SUC") {
					$common.get_tipDialog('����ɹ���', 'showSuccess');
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

	//���--------����-------------------------
};
