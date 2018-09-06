/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var contSlvaeDetailController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    $scope.otherform={};
    findFormInfo();
    $scope.view=true;

    //页面信息实时查询加载
    function findFormInfo(){
        var data= {
            pageNo: 1,
            pageSize: 10,
            bCrrGntyCon:{
                conId:dataDeliver.getter().protocol_value.CON_ID
            }
        };
        var promise = $common.get_asyncData("bCrrGntyConService/getSlaveContList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                if(data.records[0]){
                    $scope.otherform = data.records[0];
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

    //--------------押品信息表初始化-------------
    $scope.datasourcemort={//初始化表格对象
        ds: []
    };
    $scope.selectedmort={//初始化对象
        select: []
    };
    $scope.confmort= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.$watch("otherform.conId",function() {
        $scope.queryTablemort();
    });
    $scope.queryTablemort = function(paramData){
        var data= {
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
            value:{ slaveContno:$scope.otherform.conId},
        };
        var promise = $common.get_asyncData("bCntSlaveMtgRelService/findBPbcMtgClassForMortage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcemort.ds = data.records;
                $scope.confmort.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //----------------合同下保险列表初始化----------------
    $scope.datasourceins={//初始化表格对象
        ds: []
    };
    $scope.selectedins={//初始化对象
        select: []
    };
    $scope.confins= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.$watch("otherform.conId",function() {
        $scope.queryTableins();
    });
    $scope.queryTableins = function(paramData){
        var data= {
            pageNo: $scope.confins.pageNo,
            pageSize: $scope.confins.pageSize,
            value:{ slaveContno:$scope.otherform.conId},
        };
        var promise = $common.get_asyncData("bCntInsuranceBaseInfoService/findBCntInsuranceBaseInfoByContNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourceins.ds = data.records;
                $scope.confins.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //------------------业务品种---------------
    $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'},]
    };
    //经办机构，客户经理页面数据赋值
    var bCrmBrInfo={};
    var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
    primiseB.then(function(res1){
        if (res1.errorCode =="SUC") {
            $scope.otherform.brNm=res1.contextData.brName;
            $scope.otherform.brcode=res1.contextData.brNo;
        }else{
            $common.get_tipDialog(res1.errorMsg,'showError');
        }
    });
    $scope.otherform.tlrNm=userInfo.tlrName;
    /**
     * 监管合同筛选开始 TODO!!!!!!!
     */
    $scope.prtclNoContent = {
        type:"table",//展示类型table  tree
        url:"bCrrGntyConService/queryMonitorProtocolListByPageForGntyCon",
        param:{productId:$scope.otherform.vidPrdId},
        split:"-",//分隔符
        extentColumn:"protocolNo",
        column:["protocolNo","thrName"]//展示内容
    };
    $scope.prtclNodooextent = function(ds){
        $scope.otherform.prtclNo=ds.protocolNo;//监管合同号
        $scope.otherform.prtclBrNm=ds.thrName; //监管公司名称
        $scope.otherform.gutNm=ds.secName; //出质人名称
        $scope.otherform.gutId=ds.secCd; //出质人
    };
    $scope.$watch("otherform.prtclNo",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.prtclNoContent.param ={
            productId:$scope.otherform.vidPrdId,
            protocolCode:$scope.otherform.prtclNo,
            state:"1"//查询有效的监管合同
        };
    });
};
