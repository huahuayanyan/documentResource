/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var gntyconInfoController = function($scope,$common,$state,dataDeliver) {
	$scope.gntyconInfo={};
    var data = dataDeliver.getter();
    var appNo = data.appNo;
    var conId = data.conId;
    if(appNo){
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appNo});
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                conId = data.slaveContno;
                queryGntyconInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }else{
        queryGntyconInfo();
    }
    function queryGntyconInfo(){
        var qualityApplyDO = {conId:conId}
        var data = {
            qualityApplyDO: qualityApplyDO
        }
        var promise = $common.get_asyncData("qualityApplyService/findBCrrGntyCon", data);
        promise.then(function (res) {
            $scope.gntyconInfo;
            if (res.errorCode == "SUC") {
                $scope.gntyconInfo = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
    productSource();
    //查询业务品种
    function productSource(){
        //业务品种下拉框
        var dataItemsDO = {};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        $scope.productSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
                //$scope.protocol.productId="1220020";
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
};
