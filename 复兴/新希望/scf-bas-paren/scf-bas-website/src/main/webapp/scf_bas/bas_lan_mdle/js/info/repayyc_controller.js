/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var repayycController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
	$scope.firstform=dataDeliver.getter();//定义form对象
	$scope.otherform = $scope.firstform;
	$scope.datasource={//初始化表格对象
		ds: []
	};
	$scope.selected={//初始化对象
		select: []
	};
	$scope.conf= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0}

	var seq;//流程节点顺序
	var flagg = $scope.otherform.flag;
	var flowdata;
	var processId = window.processId;//流程点
	var modelId = window.modelId;//模版
	var iddd = window.appNo;
	var prdid = $scope.otherform.prdId;
	//-----间接额度判断----
	var jjed = $scope.otherform.indrctCrdt;
	if(jjed == "0"){
		$scope.hidehide = true;
	}else{
		$scope.hidehide = false;
	}

	$scope.applyDtlForm = {};
	$scope.datasourcetask={//初始化表格对象
		ds:[
		]
	};
	$scope.selectedtask={//初始化对象
		select: []
	};
	$scope.conftask= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0
	};

	$scope.applyDtlForm={
		taskComment:''
	}

	//监听分页
	$scope.$watch("conftask.pageNo+conftask.pageSize",function(){
		$scope.queryTabletask();
	});

	//查询
	$scope.queryTabletask = function(){
		var data= {
			processId:processId,
			pageNo: $scope.conftask.pageNo,
			pageSize: $scope.conftask.pageSize
		};
		var promise = $common.get_asyncData("taskService/getDoneTask",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasourcetask.ds = data.records;
				$scope.conftask.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};

	var promise = $common.get_asyncData("processService/getCurrentNodeEntity", {pid: processId});
	promise.then(function (res) {
		if (res.errorCode == "SUC") {
			$scope.sumbitdisable= true;
			flowdata = res.contextData;
			seq = parseFloat(flowdata.seq);
			if (seq == 2 && modelId == 'BCrrDuebillApp') {
				$scope.disable = false;
			}else if(seq ==3 && (modelId =='BCrrDuebillApp' || modelId == 'ThreeBillChargeOffApply')){
				$scope.disable = true;
				$scope.hid = true;
				$("#yincang").css('display','none');
			}
			if(flagg =='view'){
				$scope.disable = true;
				$scope.hid = true;
				$("#yincang").css('display','none');
				//详情页面审批意见显示
				$("#showIdea").css('display','');
			}
			//购销合同列表添加
			var da = {
				pageNo: $scope.conf.pageNo,
				pageSize: $scope.conf.pageSize,
				value: {appno: iddd}
			};
			//监听分页
			$scope.$watch("conf.pageNo+conf.pageSize",function(){
				$scope.queryTable();
			});
			$scope.queryTable = function(paramData) {
				var promise = $common.get_asyncData("bLanLnciBuyBizService/findBLanLnciBuyBizByPage", da);
				promise.then(function (res) {
					var data2;
					if (res.errorCode == "SUC") {//数据中的经办机构要转换成中文
						data2 = res.contextData;
						$scope.datasource.ds = data2.records||[];
						$scope.conf.totalRecord = data2.totalRecord;
					} else {
						$common.get_tipDialog(res.errorMsg, 'showError');
					}
				});
			}
		} else {
			$common.get_tipDialog(res.errorMsg, 'showError');
		}
	});

	//银承--供应链添加购销合同--赎货期限保存按钮
	$scope.ycconfirm_onClick = function() {
		//购销合同添加
		if($.doValidate("otherform")) {
			var buyinfoArray = $scope.datasource.ds;
			if(buyinfoArray == null || buyinfoArray == ''){
				$common.get_tipDialog('购销合同不能为空', 'showInform');
				return false;
			}
			var totalLoanAmount = 0.00;
			for (var i = 0; i < buyinfoArray.length; i++) {
				if (buyinfoArray[i].loanAmt == '' || buyinfoArray[i].loanAmt == null ||buyinfoArray[i].loanAmt == undefined) {
					$common.get_tipDialog('购销合同号为：'+buyinfoArray[i].tradeContcode+'的记录“本次出账金额”不能为空', 'showInform');
					return false;
				}
				
				if(parseFloat(buyinfoArray[i].loanAmt)>(parseFloat(buyinfoArray[i].contAmt)-parseFloat(buyinfoArray[i].accuLoanAmt)))
				{
					$common.get_tipDialog('购销合同号为：'+buyinfoArray[i].tradeContcode+'的记录，“本次出账金额”必须小于等于（合同金额-累计出账金额）', 'showInform');
					return false;
				}
				totalLoanAmount = parseFloat(totalLoanAmount) + parseFloat(buyinfoArray[i].loanAmt);
			}
			var bcrrDuebillDetail = $scope.otherform;
			if(parseFloat(totalLoanAmount) != bcrrDuebillDetail.jjje){
				$common.get_tipDialog('“出票总金额”必须等于购销合同列表的“本次出账金额”累加！', 'showInform');
				return false;
			}
			var primise = $common.get_asyncData("bLanRepayYcSaveService/saveYc", {
				buyinfoArray: buyinfoArray,
				bcrrDuebillDetail: bcrrDuebillDetail
			});
			primise.then(function (res) {
				if (res.errorCode == "SUC") {
					$scope.queryTable();
					$scope.selected.select = [];
					$common.get_tipDialog('保存成功！', 'showSuccess');
					$scope.sumbitdisable= false;
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
			});
		}
	}
	//***********************************银承购销合同处理***********************************
	var appno = window.appNo;
	var vidNo = $scope.otherform.vidNo;
	//新增购销合同
	$scope.add_onClick = function(){
		var row={};
		$common.get_ngDialog('info/buy_add.html', $scope
			,["$scope",function(dialogScope){
				buyInfoAddController(dialogScope,$scope,$common,$state,appno,vidNo);
			}],"新增购销合同",{showClose:true});
	};
	//修改购销合同
	$scope.update_onClick = function(){
		var row ={};
		if($scope.selected.select.length == 1){
			$common.get_ngDialog('info/buy_update.html', $scope
				,["$scope",function(dialogScope){
					buyInfoUpdateController(dialogScope,$scope,$common,"update",row,appno);
				}],"修改购销合同",{showClose:true});
		}else{
			$common.get_tipDialog('请选择一条记录！','showInform');
		}
	};
	//购销合同删除
	var del_gx=[];
	$scope.delete_onClick = function(){
		$common.get_tipDialog('确定删除吗！','showTip').then(function(){
			var dsArray = $scope.datasource.ds;
			var selected = $scope.selected.select;
			for(var m=0;m<selected.length;m++){
				for (var i = 0; i < dsArray.length; i++) {
					if (dsArray[i].tradeContcode == selected[m].tradeContcode) {
						del_gx.push(selected[m].tradeContcode);
						$scope.datasource.ds.splice(i, 1);
						$scope.selected.select = [];
					}
				}
			}
		});
	}
	//银承-供应链补录-提交按钮-自定义
	$scope.ycbltj_onClick = function(){
		var comment = $scope.applyDtlForm.taskComment;
		if(comment!=null&&comment!=undefined)
		{
			var realLen = 0;
			var len = comment.length;
			var charCode = -1;
			for(var i=0;i<len;i++)
			{
				charCode = comment.charCodeAt(i);
				if(charCode>=0&&charCode<=128)
				{
					realLen += 1;
				}
				else
				{
					realLen += 3;
				}
			}
			if(realLen>255)
			{
				$common.get_tipDialog('“审批意见”长度超过限值，请重新输入……','showError');
				return;
			}
		}
		$scope.sumbitdisable = true;
		$scope.savedisable = true;
		var bcrrDuebillDetail = $scope.otherform;
		bcrrDuebillDetail.taskComment = $scope.applyDtlForm.taskComment;
		var buyinfoArray = $scope.datasource.ds;
		var data = {
			buyinfoArray: buyinfoArray,
			bcrrDuebillDetail: bcrrDuebillDetail
		}
		var primise = $common.get_asyncData('bLanRepayYcSubmitService/ycSubmit',data);
		primise.then(function (res) {
			if (res.errorCode == "SUC") {
				$common.get_tipDialog('提交成功！', 'showSuccess');
				$scope.hid=true;
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
	}
};
