/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var nwrinfoSlaveMortController = function($scope,$common,$state,dataDeliver) {
	$scope.row = {};
	$scope.disable = true;
	$scope.cache = "0";
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
	/**
	 * 担保人名称查询加载开始
	 */
	$scope.gutcontent = {
		type:"table",//展示类型table  tree
		url:"bCrrLnAppService/queryCustSource",
		param:{},
		split:",",//分隔符
		extentColumn:"custNm",
		column:["custNm","custId"]//展示内容
	};
	$scope.gutextend = function(ds){
		$scope.row.gutNm = ds.custNm;
		$scope.row.gutId = ds.custId;
		$scope.row.gcrtId = ds.idno;
		$scope.row.gcrtTyp = ds.idtype;
		$scope.number = ds;
	};
	$scope.$watch("row.gutNm",function(){
		if($scope.row.gutNm!=null) $scope.gutcontent.param ={custId:$scope.row.gutNm,custNm:$scope.row.gutNm};
	});
	/**
	 * 担保人名称查询加载结束
	 */
	/**
	 * 业务品种筛选开始
	 */
	$scope.productNameContent = {
		type:"table",//展示类型table  tree
		url:"bSysCommonService/selectBusinessType",
		param:{ factType:"0" },    //应收账款融资
		split:",",//分隔符
		extentColumn:"productName",
		column:["productName","productId"]//展示内容
	};
	$scope.productNamedooextent = function(ds){
		$scope.$apply(
			$scope.row.vidPrdNm=ds.productName,
			$scope.row.vidPrdId=ds.productId //业务品种
		);
	};
	$scope.$watch("row.vidPrdId",function(newVal,oldVal){
		//ht-input-extent  需要用监听的方式来传额外的参数
		$scope.productNameContent.param ={
			tFactType:"0",  //应收账款融资
			parentId:"1000"
		};
		$scope.prtclNoContent.param ={
			productId:$scope.row.vidPrdId,
			protocolCode:$scope.row.prtclNo,
			secName:$scope.row.gutNm
		};
	});
	/**
	 * 业务品种筛选结束
	 */
	/**
	 * 监管合同筛选开始
	 */
	$scope.prtclNoContent = {
		type:"table",//展示类型table  tree
		url:"bCrrGntyConService/queryMonitorProtocolListByPageForGntyCon",
		param:{productId:$scope.row.vidPrdId},    //应收账款融资
		split:",",//分隔符
		extentColumn:"protocolNo",
		column:["protocolNo","thrName"]//展示内容
	};
	$scope.prtclNodooextent = function(ds){
		$scope.row.prtclNo=ds.protocolNo;//监管合同号
		$scope.row.prtclBrNm=ds.thrName; //监管公司名称
	};
	$scope.$watch("row.prtclNo",function(newVal,oldVal){
		//ht-input-extent  需要用监听的方式来传额外的参数
		$scope.prtclNoContent.param ={
			productId:$scope.row.vidPrdId,
			protocolCode:$scope.row.prtclNo,
			secName:$scope.row.gutNm
		};
	});
	/**
	 * 监管合同筛选结束
	 */

	/**
	 * 押品信息
	 * @type {{ds: Array}}
	 */
	$scope.mortForm = {};
	$scope.datasourcemort={//初始化表格对象
		ds: []
	};
	$scope.selectedmort={//初始化对象
		select: []
	};
	$scope.confmort= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0};
	$scope.$watch("confmort.pageNo+confmort.pageSize",function() {
		$scope.queryTablemort();
	});
	$scope.queryTablemort = function(paramData){
		$scope.mortForm.slaveContno = conId;
		var data= {
			pageNo: $scope.confmort.pageNo,
			pageSize: $scope.confmort.pageSize,
			bCntSlaveMtgRel:$scope.mortForm,
			cache:$scope.cache
		};
		var promise = $common.get_asyncData("bCntSlaveMtgRelService/findBCntSlaveMtgRelByPage",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasourcemort.ds = data.records;
				$scope.confmort.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};
	/**
	 * 质押合同保险单信息
	 * @type {{ds: Array}}
	 */
	$scope.insForm = {};
	$scope.datasourceins={//初始化表格对象
		ds: []
	};
	$scope.selectedins={//初始化对象
		select: []
	};
	$scope.confins= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0};
	$scope.$watch("confins.pageNo+confins.pageSize",function() {
		$scope.queryTableins();
	});
	$scope.queryTableins = function(paramData){
		$scope.insForm.slaveContno = conId;
		var data= {
			pageNo: $scope.confins.pageNo,
			pageSize: $scope.confins.pageSize,
			bCntInsBaseInfo:$scope.insForm,
			cache:$scope.cache
		};
		var promise = $common.get_asyncData("bCntInsuranceBaseInfoService/findBCntInsuranceBaseInfoByPage",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasourceins.ds = data.records;
				$scope.confins.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};
	//----------------------------------点击事件------------------------------
};
