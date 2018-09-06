/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var debtPoolConListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.conditionForm={
        factType:"2",//应收账款池融资
        financingType:"2",// 池融资
        conStatus:"01",//查有效合同
        flag:"01" //用户角色
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
   $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                factType:"2",//应收账款池融资
                financingType:"2",// 池融资
                conStatus:"01",//查有效合同
                flag:"01" //用户角色
            };
            $scope.selected.select=[];//清空选项
        })
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };
//todo
   $scope.queryTable = function(){
       var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mastContQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCntDebtInfoService/queryBCntDebtInfoListByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };

    //新增按钮
    $scope.add_onClick = function(){
        $state.go("bcntdebtpooladd");
        var data= {
            flag:"add"
        };
        dataDeliver.setter(data);
    };
	// 修改按钮
	$scope.update_onClick = function() {

		if ($scope.selected.select.length <= 0) {
			$common.get_tipDialog('请至少选择一条记录！', 'showInform');
			return false;
		}
		// 合同状态
		var contStatus = $scope.selected.select[0].contStatus;
		if (contStatus != "01") {
			$common.get_tipDialog('只有有效状态的合同才可以修改！', 'showInform');
			return false;
		}
		$state.go("bcntdebtpooladd");
		var debtContno = $scope.selected.select[0].debtContno;
		var data = {
			flag : "update",
			debtContno : debtContno
		};
		dataDeliver.setter(data);

	};
	// 终止
	$scope.delete_onClick = function() {
		if ($scope.selected.select.length <= 0) {
			$common.get_tipDialog('请至少选择一条记录！', 'showInform');
			return false;
		}
		// 合同状态
		for(i=0;i< $scope.selected.select.length;i++){
			var contStatus = $scope.selected.select[i].contStatus;
			var debtContno = $scope.selected.select[i].debtContno;
			if (contStatus != "01") {
				$common.get_tipDialog('合同'+debtContno+'的状态已为无效', 'showInform');
				return false;
			}
		}
		var data = {
			debtContVOList : $common.copy($scope.selected.select)
		};

		$common.get_tipDialog("确定删除选中的合同吗?", 'showTip').then(
				function() {
					var primise = $common.get_asyncData(
							'bCntDebtInfoService/saveCntDebtInfoDelete', data);
					primise.then(function(res) {
						if (res.errorCode == "SUC") {
							$scope.queryTable();
							$scope.selected.select = [];
							$common.get_tipDialog('删除成功！', 'showSuccess');
						} else {
							$common.get_tipDialog(res.errorMsg, 'showError');
						}
					})
				})
	};
    //查看
    $scope.column = function(row){
        $state.go("bcntdebtpoolview");
        dataDeliver.setter(row);
    };
  
    //表格--------结束-------------------------
};
