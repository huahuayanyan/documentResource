/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var trptInfoDtlController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    $scope.trptInfoDtlForm = {};
    $scope.trptInfoDtlForm = dataDeliver.getter();

    $scope.clsDtlDlg_onClick = function(){
        $state.go("trptInfoList");
    }

/*    $scope.clsDtlDlg_onClick = function(){
        $scope.closeThisDialog();
    }*/


    //表格--------结束-------------------------
};
