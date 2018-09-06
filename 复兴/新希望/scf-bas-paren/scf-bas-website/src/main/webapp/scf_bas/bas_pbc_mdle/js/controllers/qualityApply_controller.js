/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var qualityApplyController = function($scope,$common,$state,dataDeliver) {
	var data = dataDeliver.getter();
	var appno = data.appNo;
	$scope.taskform={};
	if($state.current.name=="qualityApply"){
        $state.go("qualityApply.qualityInfo");
    }else if($state.current.name=="qualityApply.qualityInfo"){
        $state.go("qualityApply.qualityInfo");
    }else if($state.current.name=="bsystasktab.qualityApplyWrite"||$state.current.name=="bsystasktab.qualityApplyWrite.qualityInfo"){
        $state.go("bsystasktab.qualityApplyWrite.qualityInfo");
    }else if($state.current.name=="bsystasktab.qualityApplyCheck"||$state.current.name=="bsystasktab.qualityApplyCheck.qualityInfo"){
        $state.go("bsystasktab.qualityApplyCheck.qualityInfo");
    }else if($state.current.name=="bsystasktab.qualityApplyApprove"||$state.current.name=="bsystasktab.qualityApplyApprove.qualityInfo"){
        $state.go("bsystasktab.qualityApplyApprove.qualityInfo");
    }else if($state.current.name=="bsystasktab.qualityApplyReceipt"||$state.current.name=="bsystasktab.qualityApplyReceipt.qualityInfo"){
        $state.go("bsystasktab.qualityApplyReceipt.qualityInfo");
    }
    //$scope.qualityApply = {};
  /*  $scope.qualityApply = {};
    var promise = $common.get_asyncData("qualityApplyService/initPageUserOrg");
    promise.then(function (res) {
        if (res.errorCode == "SUC") {
            $scope.qualityApply.processTemplateName = res.contextData.processTemplateName;
            $scope.qualityApply.startTime = res.contextData.startTime;
            $scope.qualityApply.startTlrNm = res.contextData.startTlrNm;
            $scope.qualityApply.startBrName = res.contextData.startBrName;
        } else {
            $common.get_tipDialog(res.errorMsg, 'showInform');
        }
    })
*/
  //获取任务信息
  queryTaskInfo();
  function queryTaskInfo()
  {
  	//参数
  	var data={
  			appno:appno
  	}
      $common.get_asyncData("qualityApplyService/queryTaskInfoByAppno", data).then(function (res) {
          var data;
          if (res.errorCode == "SUC") {
              data = res.contextData;
              $scope.taskform = data;
          	} else {
              $common.get_tipDialog(res.errorMsg, 'showInform');
          }
      })
  };
};
//||$state.current.name=="bsystasktab.qualityApply"