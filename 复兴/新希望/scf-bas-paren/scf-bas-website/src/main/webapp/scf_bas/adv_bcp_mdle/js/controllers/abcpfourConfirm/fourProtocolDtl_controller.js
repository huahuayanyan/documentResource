/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var fourProtocolDtlController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.threeProtocolForm={};
    $scope.productSource={
        ds: []
    };
    $scope.selectbrcode={
        ds: []
    };
    var  bData =dataDeliver.getter();
    if(!bData){
        var  bData = window.parent.data;
    }
    /*   if(bData==null||bData.appno==null){
     $common.get_tipDialog('请先保存提货申请信息！', 'showInform');
     return false;
     }*/
    //查看 设置只读和按钮隐藏
    $scope.view=true;
    $scope.update=true;
    $scope.back=true;
    queryProtocol();
    var productPar= {
        pageNo: '1',
        pageSize: '999999',
        bPrdInfo:{parentId:'2100'}
    };
    var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage",productPar);
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.productSource.ds = data.records;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    //买方客户名称下拉-begin
    $scope.sellerNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.threeProtocolForm.custcd=ds.custcd;
        $scope.threeProtocolForm.sellerNm=ds.cname;
    };
    $scope.$watch("threeProtocolForm.sellerNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.sellerNmContent.param ={
            creditFlag:'1',
            custType:'1',
            sellerNm:$scope.threeProtocolForm.cname,
            custcd:$scope.threeProtocolForm.custcd
        }
    });
    //买方客户名称下拉-end
    //卖方客户名称下拉-begin
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmExtent = function(ds){
        $scope.threeProtocolForm.coreCustcd=ds.custcd;
        $scope.threeProtocolForm.coreNm=ds.cname;
    };
    $scope.$watch("threeProtocolForm.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:'1',
            custType:'1',
            coreNm:$scope.threeProtocolForm.coreNm,
            coreCustcd:$scope.threeProtocolForm.coreCustcd
        }
    });
    //卖方客户名称下拉-end
    //承担方客户名称下拉-begin
    $scope.fouNameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.fouNameExtent = function(ds){
        $scope.threeProtocolForm.fouCd=ds.custcd;
        $scope.threeProtocolForm.fouName=ds.cname;
    };
    $scope.$watch("threeProtocolForm.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.fouNameContent.param ={
            coreFlag:'1',
            custType:'1',
            fouName:$scope.threeProtocolForm.fouName,
            fouCd:$scope.threeProtocolForm.fouCd
        }
    });
    //承担方客户名称下拉-end
    //合作机构下拉-begin
    $scope.cooperationBrcodeNmContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBranchInfo",//请求url
        param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.cooperationBrcodeNmExtent = function(ds){
        $scope.threeProtocolForm.cooperationBrcode=ds.brNo;
        $scope.threeProtocolForm.cooperationBrcodeNm=ds.brName;
    };
    $scope.$watch("threeProtocolForm.cooperationBrcodeNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cooperationBrcodeNmContent.param ={
            brNo:$scope.threeProtocolForm.cooperationBrcode,
            brName:$scope.threeProtocolForm.cooperationBrcodeNm,
            brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
        };
    });
    //合作机构下拉-end
    //监管方客户名称下拉-begin
    $scope.moniNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.moniNmExtent = function(ds){
        $scope.threeProtocolForm.moniCustcd=ds.custcd;
    };

    //业务品种
    $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'}]
    };

    $scope.$watch("threeProtocolForm.moniNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.moniNmContent.param ={
            moniFlag:'1',
            custType:'1',
            custStatus:'01',
            cname:$scope.threeProtocolForm.moniNm
        }
    });
    //根据协议号加载担保提货协议信息
    function queryProtocol(){
        var deliveryQryVO ={
            protocolNo:bData.protocolNo
        };
        var data = {
            pageNo: '1',
            pageSize: '999999',
            deliveryQryVO:deliveryQryVO
        };
        var promise=$common.get_asyncData("fourProtocolService/getFranchiserProtocolQuery",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                if(data.records[0]){
                    $scope.threeProtocolForm = data.records[0];
                    if($scope.threeProtocolForm.dutyAssumeType){
                        $scope.threeProtocolForm.dutyAssumeType=($scope.threeProtocolForm.dutyAssumeType).split(",");
                    }
                    if($scope.threeProtocolForm.loanWay){
                        $scope.threeProtocolForm.loanWay=($scope.threeProtocolForm.loanWay).split(",");
                    }
                    findCrmBrInfo();
                }
                $scope.brcodeDisable =true;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //合作机构代码转译
    function translateBrInfo(){
        if($scope.threeProtocolForm.cooperationBrcode){
            var brinfo={brNo:$scope.threeProtocolForm.cooperationBrcode}
            var data={
                pageNo:1,
                pageSize:10,
                value:brinfo
            };
            var primiseB = $common.get_asyncData("bSysCommonService/selectBranchInfo",data);
            primiseB.then(function(res1){
                if (res1.errorCode =="SUC") {
                    $scope.threeProtocolForm.cooperationBrcodeNm=res1.contextData.records[0].brName;
                }else{
                    $common.get_tipDialog(res1.errorMsg,'showError');
                }
            });
        }
    }
    //经办机构，客户经理页面数据赋值
    function findCrmBrInfo(){
        var bCrmBrInfo={};
        var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
        primiseB.then(function(res1){
            if (res1.errorCode =="SUC") {
                $scope.threeProtocolForm.brName=res1.contextData.brName;
                $scope.threeProtocolForm.inputorgname=res1.contextData.brName;
                $scope.threeProtocolForm.brcode=res1.contextData.brNo;
                $scope.threeProtocolForm.tlrName=userInfo.tlrName;
                translateBrInfo();
            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    }
    $scope.back_onClick = function () {
        $state.go("bcntthreeProtocol");
    };

    //表格--------结束-------------------------
};
