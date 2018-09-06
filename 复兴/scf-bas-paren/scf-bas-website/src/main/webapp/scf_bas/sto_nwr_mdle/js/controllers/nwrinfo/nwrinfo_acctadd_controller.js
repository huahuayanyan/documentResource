/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var nwrinfoAcctaddController = function($scope,$common,$state,dataDeliver) {
	$scope.acctinfo = {};
	$scope.source = window.source;
	$scope.baseinfo = $scope.source.baseinfo;
	$scope.baseinfo.operationType = "07";//非标仓单提货
	if($scope.baseinfo.appno == undefined||!$scope.baseinfo.appno)
	{
		$common.get_tipDialog("请先保存提货申请信息！",'showInform');
		$state.go("deliverytask.apply");
		$scope.$parent.panes.forEach(function(pane){
			if (pane.uiSref == "deliverytask.apply"){
				$scope.$parent.select(pane);
			}
		});
		return;
	}
	$scope.addDisable = window.Write;
	$scope.hide = window.Write;
	if(!$scope.baseinfo.businessNo||$scope.baseinfo.businessNo==undefined)
	{
		$scope.baseinfo.businessNo = $scope.baseinfo.slaveContno;
	}
	$common.get_asyncData("billNormalDeliveryApplyService/AppendBailAmountGetter",{deliveryQryVO:$scope.baseinfo}).then(function(res){
		var data;
		if (res.errorCode =="SUC"){
			data = res.contextData;
			$scope.acctinfo = data;
			$scope.acctinfo.operationType = "07";//非标仓单提货
			if(!$scope.acctinfo.businessNo||$scope.acctinfo.businessNo==undefined)
			{
				$scope.acctinfo.businessNo = $scope.baseinfo.slaveContno;
			}
			$scope.queryTable();
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});

	if(!$scope.acctinfo.addBailAmount)
	{
		$scope.acctinfo.addBailAmount = 0;
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
	//监听分页
	//$scope.$watch("conf.pageNo+conf.pageSize",function() {
	//	$scope.queryTable();
	//});
	$scope.queryTable = function(paramData){
		var data= {
			pageNo: $scope.conf.pageNo,
			pageSize: $scope.conf.pageSize,
			deliveryQryVO:$scope.acctinfo
		};
		var promise = $common.get_asyncData("billNormalDeliveryApplyService/DebetListGetter",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasource.ds = data.records||[];
				$scope.conf.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};

	$scope.add_onClick=function(){
		$common.get_ngDialog('nwrinfo/nwrinfo_loan_list.html',$scope,["$scope",function(dialogScope){
			dialogScope.datasource={//初始化表格对象
				ds: []
			};
			dialogScope.selected={//初始化对象
				select: []
			};
			dialogScope.conf= {//初始化分页对象
				pageNo: 1,
				pageSize: 10,
				totalRecord: 0};
			//监听分页
			dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
				dialogScope.queryTable();
			});

			//点击查询之后的搜索
			dialogScope.submit_onClick =function(){
				dialogScope.queryTable();
				dialogScope.selected.select=[];
			};

			//查询操作
			dialogScope.queryTable = function(paramData){
				var data= {
					pageNo: dialogScope.conf.pageNo,
					pageSize: dialogScope.conf.pageSize,
					deliveryQryVO:$scope.acctinfo
				};
				var promise = $common.get_asyncData("billNormalDeliveryApplyService/DebetListAddGetter",data);
				promise.then(function(res){
					var data;
					if (res.errorCode =="SUC"){
						data = res.contextData;
						dialogScope.datasource.ds = data.records||[];
						dialogScope.conf.totalRecord = data.totalRecord;
						var list =[];
						for(var x in dialogScope.datasource.ds)
						{
							var debetNoX = dialogScope.datasource.ds[x].debetNo;
							for(var y in $scope.datasource.ds)
							{
								var debetNoY = $scope.datasource.ds[y].debetNo;
								if(debetNoX==debetNoY)
								{
									list.push(dialogScope.datasource.ds[x]);
								}
							}
						}
						dialogScope.selected.select = list;
					}else{
						$common.get_tipDialog(res.errorMsg,'showError');
					}
				});
			};
			dialogScope.confirm_onClick =function(){
				if(dialogScope.selected.select.length <= 0)
				{
					$common.get_tipDialog('请至少选择一条借据记录','showInform');
				}else{
					dialogScope.closeThisDialog();
					$scope.datasource.ds = [];
					for(var x in dialogScope.selected.select){
						$scope.datasource.ds.push(dialogScope.selected.select[x]);
						$scope.conf.totalRecord ++;
					}
				}
			};
			dialogScope.cancel_onClick =function(){
				dialogScope.closeThisDialog();
			};
		}],'添加页面',{showClose:false});
	};

	$scope.update_onClick=function(){
		if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
			$common.get_tipDialog('请选择一条记录！','showInform');
			$scope.selected.select=[];

		}else{
			$common.get_ngDialog('nwrinfo/nwrinfo_loan_edit.html',$scope,["$scope",function(dialogScope){
				dialogScope.loaninfo = $scope.selected.select[0];
				dialogScope.save_onClick =function(){
					if($.doValidate("loaninfo")){
						dialogScope.closeThisDialog();
					}
				};
				dialogScope.close_onClick =function(){
					dialogScope.closeThisDialog();
				};
			}],'冻结保证金明细编辑',{showClose:false});
		}
	};
	$scope.delete_onClick = function(){
		if($scope.selected.select.length == 0){
			$common.get_tipDialog('请至少选择一条记录！','showInform');
		}else{
			var selectedList = $scope.selected.select;
			var dsArray = $scope.datasource.ds;
			$scope.selected.select = [];
			for (var i = 0; i < dsArray.length; i++)
			{
				var dsdebetno = dsArray[i].debetNo;
				for(var j = 0; j<selectedList.length; j++)
				{
					var selectdebetno = selectedList[j].debetNo;
					if (dsdebetno == selectdebetno) {
						$scope.datasource.ds.splice(i, 1);
						$scope.conf.totalRecord --;
					}
				}
			}
			for (var i = 0; i < dsArray.length; i++)
			{
				if (dsArray[i].billsNo == selected.billsNo) {
					$scope.bcpDatasource.ds.splice(i, 1);
				}
			}
			$scope.$apply();
		}
	};

	$scope.save_onClick = function()
	{
		var addBailAmount = Number($scope.acctinfo.addBailAmount);
		if(addBailAmount<=0){
			$common.get_tipDialog('追加保证金必须大于0！','showInform');
			return false;
		}
		if($scope.datasource.ds==[]||$scope.datasource.ds.length==0)
		{
			$common.get_tipDialog('冻结保证金列表记录不能为空！','showInform');
			return;
		}
		var tatolBailAmont = 0;
		var list = $scope.datasource.ds;
		var flag = 0;
		var msg ="";
		for(var x in list)
		{
			var bail = list[x];
			var debetId = bail.debetId;
			var bailAccount = bail.bailAccount;
			var addBailAmount_v = Number(bail.addBailAmount);  //追加冻结金额
			var riskAmt_v = Number(bail.riskAmt);  //敞口余额
			tatolBailAmont += addBailAmount_v;
			if(!bailAccount||bailAccount==undefined||bailAccount==null)
			{
				flag++;
				msg = msg+"借据号为【"+debetId+"】的记录【保证金账号】不能为空"+"\n";
			}
			if(addBailAmount_v<=0){
				flag++;
				msg = msg+"借据号为【"+debetId+"】的记录【追加冻结金额 】必须大于0"+"\n";
			}
			if(addBailAmount_v > riskAmt_v)
			{
				flag++;
				msg = msg+"借据号为【"+debetId+"】的记录【追加冻结金额 】必须小于等于该笔的敞口余额"+"\n";
			}
		}
		if(flag>0)
		{
			$common.get_tipDialog(msg,'showInform');
			return;
		}
		if(addBailAmount!=tatolBailAmont)
		{
			$common.get_tipDialog("【追加冻结金额总金额】必须等于【本次追加保证金总额】",'showInform');
			return;
		}
		var data = {
			appendBailAmountVO:$scope.acctinfo,
			bailList:list
		};
		$common.get_asyncData("billNormalDeliveryApplyService/AppendBailAmountUpdate",data).then(function(res){
			if (res.errorCode =="SUC"){
				$common.get_tipDialog("保存成功",'showSuccess');
				$scope.queryTable();
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	}

	$scope.assign_onClick = function()
	{
		var addBailAmount = Number($scope.acctinfo.addBailAmount);
		if(addBailAmount<0)
		{
			$common.get_tipDialog("本次追加保证金总额不能小于0！",'showInform');
			return;
		}
		var list = $scope.datasource.ds;
		var flag = 0;
		var msg ="";
		for(var x in list)
		{
			var bail = list[x];
			var riskAmt = Number(bail.riskAmt);  //敞口余额
			if(addBailAmount>0)
			{
				if(riskAmt >= addBailAmount)
				{
					bail.addBailAmount = addBailAmount;
					addBailAmount = 0;
				}
				if(riskAmt < addBailAmount)
				{
					bail.addBailAmount = riskAmt;
					addBailAmount = addBailAmount - riskAmt;
				}
			}
			else
			{
				bail.addBailAmount = 0;
			}
		}
		$scope.$apply();
	}
};
