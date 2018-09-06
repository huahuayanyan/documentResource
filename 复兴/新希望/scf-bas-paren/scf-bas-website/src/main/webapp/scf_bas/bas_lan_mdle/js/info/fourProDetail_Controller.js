/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/11/29
 */

var fourProDetailController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
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
	//�鿴 ����ֻ���Ͱ�ť����
	$scope.view=true;
	$scope.update=true;
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
	//��ܷ��ͻ���������-begin
	$scope.moniNmContent = {
		type:"table",//չʾ����table  tree
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//����url
		//param:{creditFlag: '1',custType:'1'},//�������,�����д�����Ի���param:{},�������뵱ǰ�ֶβ�ѯ
		split:"-",//�ָ���
		extentColumn:"cname",
		column:["custcd","cname"]//չʾ����
	};
	$scope.moniNmExtent = function(ds){
		$scope.threeProtocolForm.moniCustcd=ds.custcd;
	};

	//ҵ��Ʒ��
	$scope.selectSource = {
		ds:[{key:"1210020",value:'��Ʊ/����'}]
	};

	$scope.$watch("threeProtocolForm.moniNm",function(){
		//ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
		$scope.moniNmContent.param ={
			moniFlag:'1',
			custType:'1',
			custStatus:'01',
			cname:$scope.threeProtocolForm.moniNm
		}
	});
	//����Э��ż��ص������Э����Ϣ
	function queryProtocol(){
		var deliveryQryVO ={
			protocolNo:bData.protocolNo
		};
		var data = {
			pageNo: '1',
			pageSize: '999999',
			deliveryQryVO:deliveryQryVO
		};
		var promise=$common.get_asyncData("fourProtocolService/getFranchiserProtocolQuery",data);
		promise.then(function (res) {
			if(res.errorCode=="SUC"){
				data = res.contextData;
				if(data.records[0]){
					$scope.threeProtocolForm = data.records[0];
					if($scope.threeProtocolForm.dutyAssumeType){
						$scope.threeProtocolForm.dutyAssumeType=($scope.threeProtocolForm.dutyAssumeType).split(",");
					}
					if($scope.threeProtocolForm.loanWay){
						$scope.threeProtocolForm.loanWay=($scope.threeProtocolForm.loanWay).split(",");
					}
					findCrmBrInfo();
				}
				$scope.brcodeDisable =true;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		})
	}
	//������������ת��
	function translateBrInfo(){
		if($scope.threeProtocolForm.cooperationBrcode){
			var brinfo={brNo:$scope.threeProtocolForm.cooperationBrcode}
			var data={
				pageNo:1,
				pageSize:10,
				value:brinfo
			};
			var primiseB = $common.get_asyncData("bSysCommonService/selectBranchInfo",data);
			primiseB.then(function(res1){
				if (res1.errorCode =="SUC") {
					$scope.threeProtocolForm.cooperationBrcodeNm=res1.contextData.records[0].brName;
				}else{
					$common.get_tipDialog(res1.errorMsg,'showError');
				}
			});
		}
	}
	//����������ͻ�����ҳ�����ݸ�ֵ
	function findCrmBrInfo(){
		var bCrmBrInfo={};
		var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
		primiseB.then(function(res1){
			if (res1.errorCode =="SUC") {
				$scope.threeProtocolForm.brName=res1.contextData.brName;
				$scope.threeProtocolForm.inputorgname=res1.contextData.brName;
				$scope.threeProtocolForm.brcode=res1.contextData.brNo;
				$scope.threeProtocolForm.tlrName=userInfo.tlrName;
				translateBrInfo();
			}else{
				$common.get_tipDialog(res1.errorMsg,'showError');
			}
		});
	}
	$scope.back_onClick = function () {
		$state.go("bcntthreeProtocol");
	};

	//���--------����-------------------------
};
