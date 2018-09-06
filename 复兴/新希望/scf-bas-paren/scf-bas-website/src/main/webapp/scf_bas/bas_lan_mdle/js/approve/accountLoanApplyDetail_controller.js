/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var accountLoanApplyDetailController = function($scope,$common,$state,dataDeliver) {
	/**查看详情按钮*/
	$scope.back_onClick = function(row){
		$state.go("accountLoanApply");//跳转
		/*dataDeliver.setter($scope.row);*/
	}
};
