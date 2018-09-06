/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var CheckTransferController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = {};
    var processId=window.parent.processId;
    var modelId=window.parent.modelId;
    var appno = window.parent.appNo;
    //通过申请编号获得申请相关的信息
    var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
    promise.then(function(res){
        if (res.errorCode =="SUC"){
            $scope.otherform=res.contextData;
            var bCrmBrInfo={
                brNo:res.contextData.startBrcode
            }
            var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
            promiseA.then(function(res1){
                if(res1.errorCode =="SUC"){
                    $scope.otherform.tlrName=userInfo.tlrName;//经办人
                    $scope.otherform.brName=res1.contextData.brName;//经办机构
                    $scope.otherform.processId=processId;
                    $scope.otherform.modelId=modelId;
                    $state.go("checkTransferApply");
                    $.extend($scope.otherform);
                    dataDeliver.setter( $scope.otherform);
                }else{
                    $common.get_tipDialog(res1.errorMsg,'showError');
                }
            });
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    //表格--------结束-------------------------
};

