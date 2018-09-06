/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/05/03
 */

var adjustPriceApplicationMntProtocolController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
	
	var dataX = dataDeliver.getter();
	 $scope.protocolInfo={};
	 findFormInfo();
	    //页面信息实时查询加载
	    function findFormInfo(){
	            var protocolCode = dataX.protocolNo;
	            var key = {protocolCode:protocolCode}
	            var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolQuery",key);
	            primise.then(function(res){
	                if (res.errorCode =="SUC"){
	                    $scope.protocolInfo = res.contextData;
	                    thrNameInfo(res.contextData.thrCode);
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showInform');
	                }
	            })
	    }
        function thrNameInfo(ds) {
            var custCd = ds;
            var data = {key:custCd}
            var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
            promise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $scope.protocolInfo.thrName = res.contextData.thrName;
                    $scope.protocolInfo.levels = res.contextData.levels;
                    $scope.protocolInfo.monitorArea = res.contextData.monitorArea;
                    $scope.protocolInfo.monitortype = JSON.parse(res.contextData.monitortype);
                    $scope.protocolInfo.detailMonitorArea = res.contextData.detailMonitorArea;
                    $scope.protocolInfo.limitSum = res.contextData.limitSum;
                    $scope.protocolInfo.monitorStatus = res.contextData.monitorStatus;
                    $scope.protocolInfo.levelCogniDate = res.contextData.levelCogniDate;
                    $scope.protocolInfo.levelEndDate = res.contextData.levelEndDate;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            });
        }
	    
	    //业务品种下拉框
        var dataItemsDO = {parentId:"1000",productId:"1220020"};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        $scope.productSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
        
        //监管公司名称下拉框
        $scope.thrNameList ={
            type: "table",//展示类型table  tree
            url: "monitorProtocolService/getThrNamebyProtocol",//请求url
            split: "",//分隔符
            extentColumn: "codeName",
            column: ["codeName"]//展示内容
        }
        
        //出质人名称下拉框
        $scope.secNameList ={
            type: "table",//展示类型table  tree
            url: "monitorProtocolService/getSecNamebyProtocol",//请求url
            //param:{kk:"e"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
            split: "",//分隔符
            extentColumn: "codeName",
            column: ["codeName"]//展示内容
        }
        //合作机构下拉框
        $scope.cooperationBrcodeNmList = {
            type:"table",//展示类型table  tree
            url:"bSysCommonService/selectBranchInfo",//请求url
            param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
            split:"-",//分隔符
            extentColumn:"brName",
            column:["brNo","brName"]//展示内容
        };
};
