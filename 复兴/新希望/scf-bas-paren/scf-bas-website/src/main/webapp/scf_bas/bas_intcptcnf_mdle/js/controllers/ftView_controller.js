/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var viewController = function($thisScope,parentScope,$common,flag,row) {
    //$thisScope.otherform=dataDeliver.getter();

    $thisScope.otherform=$common.copy(row);
    $thisScope.datasource = {
        ds:[]
    };

    //监听分页
    //$scope.$watch("conf.pageNo+conf.pageSize",function(){$thisScope.queryTable()});
    //
    //$thisScope.queryTable = function(paramData) {
    //
    //    var data = {
    //        pageNo: $thisScope.conf.pageNo,
    //        pageSize: $thisScope.conf.pageSize,
    //        bSysChkCnfg: $thisScope.conditionForm
    //    };
    //    var promise = $common.get_asyncData("bSysChkCnfgService/findBSysChkCnfgByPage", data);
    //    promise.then(function (res) {
    //        var data;
    //        if (res.errorCode == "SUC") {
    //            data = res.contextData;
    //            $thisScope.datasource.ds = data;
    //        } else {
    //            $common.get_tipDialog(res.errorMsg, 'showError');
    //        }
    //    });
    //
    //};
    //var promise = $common.get_asyncData("bFinCnfgClService/findBFinCnfgClByMdlId",{mdlId:$thisScope.otherform.mdlId});
    //promise.then(function(res){
    //    var data;
    //    if (res.errorCode =="SUC"){
    //        data = res.contextData;
    //        $thisScope.otherform.mdlNm = data.mdlNm;
    //    }else{
    //        $common.get_tipDialog(res.errorMsg,'showError');
    //    }
    //});
/*    $thisScope.back_onClick = function () {
        $state.go("ft");
     };*/
    $thisScope.closeThisDialog_onClick = function(){
        $thisScope.closeThisDialog();
    };

};
