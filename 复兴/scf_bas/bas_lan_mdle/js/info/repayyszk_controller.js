/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var repayyszkController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
	$scope.firstform=dataDeliver.getter();//定义form对象
	$scope.otherform = $scope.firstform;
	var bbfxck = Number($scope.otherform.bbfxck);
	if(bbfxck<0)
	{
		$scope.otherform.bbfxck = 0.00;
	}
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
	//流贷--买方名称查询
	var custcd = $scope.otherform.crdtCustCd;
	$scope.cnameContent = {
		type:"table",//展示类型table  trees
		url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
		param:{custcd:custcd},//客户号
		split:"-",//分隔符*/
		extentColumn:"cname",
		column:["custcd","cname"]//展示内容
	};
	$scope.cnameExtent = function(ds){
		$scope.otherform.crdtCustCd=ds.custcd;
	};
	var seq;//流程节点顺序
	var flagg = $scope.otherform.flag;
	var flowdata;
	var processId = window.processId;//流程点
	var modelId = window.modelId;//模版
	var iddd = window.appNo;
	var prdid = $scope.otherform.prdId;

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

	/*var jjed = $scope.otherform.indrctCrdt;
	if(jjed == "0"){
		$scope.hidehide = true;
	}else{
		$scope.hidehide = false;
	}*/
	var promise = $common.get_asyncData("processService/getCurrentNodeEntity", {pid: processId});
	promise.then(function (res) {
		if (res.errorCode == "SUC") {
			$scope.sumbitdisable= true;
			flowdata = res.contextData;
			seq = parseFloat(flowdata.seq);
			if (seq == 2 && modelId == 'BCrrDuebillApp') {
				$scope.hid = false;
				$scope.disdis = false;
				if($scope.otherform.indrctCrdt == 0){
					$scope.hide = true;
				}else{
					$scope.hide = false;
					$scope.disable = false;
				}
			}else if(seq ==3 && modelId =='BCrrDuebillApp'){
				$scope.hid = true;
				$scope.disdis = true;
				$("#yincang").css('display','none');
				if($scope.otherform.indrctCrdt == 0){
					$scope.hide = true;
				}else{
					$scope.hide = false;
					$scope.disable = true;
				}
			}
			if(flagg == 'view'){
				$scope.hid = true;
				$scope.disdis = true;
				$("#yincang").css('display','none');
				//详情页面审批意见显示
				$("#showIdea").css('display','');
				if($scope.otherform.indrctCrdt == 0){
					$scope.hide = true;
				}else{
					$scope.hide = false;
					$scope.disable = true;
				}
			}
			//应收账款列表添加
			var da = {
				pageNo: $scope.conf.pageNo,
				pageSize: $scope.conf.pageSize,
				value: {appno: iddd}
			};
			//监听分页
			$scope.$watch("conf.pageNo+conf.pageSize",function(){
				$scope.queryTableys();
			});
			$scope.queryTableys = function(paramData) {
				var promise = $common.get_asyncData("rBcpAppliBussDtlService/findRBcpAppliBussDtlPageByAppno", da);
				promise.then(function (res) {
					var data2;
					if (res.errorCode == "SUC") {//数据中的经办机构要转换成中文
						data2 = res.contextData;
						$scope.datasource.ds = data2.records;
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
	flagg = $scope.otherform.flag;

	//流贷--应收账款--供应链补录保存
	$scope.ysconfirm_onClick = function() {
		//应收账款页面数值传递--otherform--datasource
		if($.doValidate("otherform")) {
			var bcrrDuebillDetail = $scope.otherform;
			var abc = $scope.datasource.ds;
			if(abc.length == 0){
				$common.get_tipDialog('请添加应收账款');
			}else {
				var krzje=parseFloat($scope.otherform.krzje);//可融资余额
				var jjje=parseFloat($scope.otherform.jjje);//借据金额
				if(jjje > krzje){
					$common.get_tipDialog("借据金额已超过可融资余额！", 'showError');
				}else{
					var data = {
						bcrrDuebillDetail: bcrrDuebillDetail,
						bussDtlList: abc
					};
					var primise = $common.get_asyncData("bLanRepaySaveService/flowCreditSave", data);
					primise.then(function (res) {
						if (res.errorCode == "SUC") {
							$common.get_tipDialog('保存成功！', 'showSuccess');
							$scope.sumbitdisable= false;
						} else {
							$common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
						}
						;
					})
				}
			}
		}
	}
	//***********************************************流贷应收账款(发票)处理*********************************************
	//新增应收账款
	var appno = window.appNo;
	$scope.addys_onClick = function(){
		var row={
			datasource:$scope.datasource.ds,
			custcd:custcd,
			vidBusTyp:$scope.otherform.vidBusTyp,
			mastContno:$scope.otherform.vidNo  //业务合同号

		}
		$common.get_ngDialog('info/dtl_add.html', $scope
			,["$scope",function(dialogScope){
				dtlInfoAddController(dialogScope,$scope,$common,$state,row);
			}],"新增应收账款",{showClose:true});
	};
	//应收账款删除
	var del_ys=[];
	$scope.deleteys_onClick = function(){
		$common.get_tipDialog('确定删除吗！','showTip').then(function(){
			var dsArray = $scope.datasource.ds;
			var selected = $scope.selected.select;
			for(var m=0;m<selected.length;m++){
				for (var i = 0; i < dsArray.length; i++) {
					if (dsArray[i].id == selected[m].id) {
						del_ys.push(selected[m].id);
						$scope.datasource.ds.splice(i, 1);
						$scope.selected.select = [];
					}
				}
			}
			var list = $scope.datasource.ds;
			var aaaa = 0;
			for(var i=0;i<list.length;i++){
				aaaa = aaaa + list[i].remainingAmount;
			}
			$scope.otherform.ysTotalAmt = aaaa;
			$scope.otherform.krzje = aaaa * ($scope.otherform.rzbl)/100;
		});
	}
	//应收账款-供应链补录-提交按钮-自定义
	$scope.yszkbltj_onClick = function(){
		if($.doValidate("otherform")) {
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
			var krzje=parseFloat($scope.otherform.krzje);//可融资余额
			var jjje=parseFloat($scope.otherform.jjje);//借据金额
			if(jjje > krzje){
				$common.get_tipDialog("借据金额已超过可融资余额！", 'showError');
			}else{
				$scope.sumbitdisable = true;
				$scope.savedisable = true;
				var bcrrDuebillDetail = $scope.otherform;
				bcrrDuebillDetail.taskComment = $scope.applyDtlForm.taskComment;
				var primise = $common.get_asyncData('bLanRepaySubmitService/flowCreditSubmit',{appno:appno,bcrrduebilldetail:bcrrDuebillDetail});
				primise.then(function (res) {
					if (res.errorCode == "SUC") {
						$common.get_tipDialog('提交成功！', 'showSuccess');
						$scope.hid=true;
					} else {
						$common.get_tipDialog(res.errorMsg, 'showError');
					}
				});
			}
		}
	}
	/**应收账款现金等价物改变同时修改其本笔风险敞口*/
	$scope.csxjdjwbl_onBlur = function(){
		var csxjdjw = Number($scope.otherform.csxjdjwbl);
		var number;
		if(csxjdjw>bbfxck)
		{
			number = 0.00;
		}
		else
		{
			number = bbfxck - csxjdjw;
		}
		$scope.$apply(
			$scope.otherform.bbfxck = number
		)
	}
};
