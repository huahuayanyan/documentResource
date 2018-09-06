/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var lanconController = function($scope,$common,$state,dataDeliver) {
	//这里有一个问题就是当为新增页面跳转过来的时候，页面的点击事件不生效，所以，这里我折衷用了另一个方法，把所有的点击事件单独放了出来。
	var data1= dataDeliver.getter();
	$scope.otherform = {};
	//-------------------页面初始化--------------
	$scope.datasource={//初始化表格对象
		ds: []
	};
	var id = window.appNo;
	var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{key:id});
	promise.then(function(res){
		var pdata;
		if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
			pdata = res.contextData;
			var contno = pdata.mastContcode;
			var promise = $common.get_asyncData("bCrrLnConInfoService/findBCrrLnConInfoByPage",{id:contno,appno:id});
			promise.then(function(res){
				var data;
				if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
					data = res.contextData;
					$scope.otherform = data[0];
					var loanWay = $scope.otherform.loanWay;
					if(loanWay=="01")
					{
						$("#intcd").css("display","");
						$common.get_asyncData('bSysLnCdService/findBSysLnCdByRatecode',{ratecode:$scope.otherform.intCd}).then(function(res){
							if (res.errorCode =="SUC"){
								var intcd = res.contextData;
								$scope.otherform.intCd = intcd.ratecode+"-"+intcd.ratename;
							}else{
								$common.get_tipDialog(res.errorMsg,'showError');
							};
						});
					}
					else
					{
						$("#intcd").css("display","none");
					}
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});
	//----------------------------------点击事件------------------------------
	//账户信息查看操作！
	$scope.column = function(row){
		$common.get_ngDialog('bcrmcredit/acc_add.html', $scope
			,["$scope",function(dialogScope){
				AccInfoAddController(dialogScope,$scope,$common,"view",row);
			}],"查看账户",{showClose:true});
	}
};
