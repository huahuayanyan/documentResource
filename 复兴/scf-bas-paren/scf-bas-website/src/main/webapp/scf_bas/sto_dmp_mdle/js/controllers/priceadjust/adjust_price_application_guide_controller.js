/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/05/03
 */

var adjustPriceApplicationGuideController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform={};
    var bdata = window.parent.data;
    var appno = window.parent.appNo;
    var process = "AdjustPriceApply";//价格调整申请
    window.source={};//初始化
    queryTaskInfo();//任务信息
    //获取任务信息
    function queryTaskInfo(){
        var data = {
            appno:appno,
            process:process
        };
        $common.get_asyncData("iScfWorkFlowService/findBPbcAppliBaseInfoByAppno",data).then(function (res) {
            var task;
            if (res.errorCode == "SUC") {
                task = res.contextData;
                $scope.taskform = task;
                window.source.taskform=task;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
    if(!appno){
        $state.go("adjustPriceApplicationAdjust");
          var flag={
              flag:"apply"
          };
          $.extend(bdata,flag);
          dataDeliver.setter(bdata);
      }else {
          var appno = window.parent.appNo;
          //通过申请编号获得申请相关的信息
          var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
          promise.then(function(res){
              var data;
              if (res.errorCode =="SUC"){
                  data = res.contextData;
                  $scope.otherform = data;
                  $scope.otherform.debetNo=data.ext1;
                  var flag={
                      flag:"task"
                  };
                  $.extend($scope.otherform,flag);
                $scope.otherform.conId=$scope.otherform.slaveContno;
               	$scope.source={otherform:$scope.otherform};
              	window.source=$scope.source;
                  /*dataDeliver.setter($scope.otherform);*/
                  $state.go("adjustPriceApplicationAdjust");
              }else{
                  $common.get_tipDialog(res.errorMsg,'showError');
              }
          });
      }
    
    
};
