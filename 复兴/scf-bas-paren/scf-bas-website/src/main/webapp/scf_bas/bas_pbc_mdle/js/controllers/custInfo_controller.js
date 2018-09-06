/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var custInfoController = function($scope,$common,$state,dataDeliver) {
    $scope.custInfo={};
    var data = dataDeliver.getter();
    var appNo = data.appNo;
    var gutId = data.gutId;
    //var conId = data.conId;

    if(appNo){
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appNo});
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                gutId = data.custcd;
                queryCustInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }else{
        queryCustInfo();
    }
    queryCustInfo();
    function queryCustInfo(){
        var qualityApplyDO = {gutId:gutId};
        var data = {
            qualityApplyDO: qualityApplyDO
        };
        var promise = $common.get_asyncData("qualityApplyService/findBCrmBaseInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.custInfo = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
};
