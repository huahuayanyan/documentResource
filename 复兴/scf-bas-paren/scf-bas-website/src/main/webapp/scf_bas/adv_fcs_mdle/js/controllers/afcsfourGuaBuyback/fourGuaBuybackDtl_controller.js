/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var fourGuaBuybackDtlController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.fourGuaBuybackform={};
    var  bData =dataDeliver.getter();
    $scope.productSource={
        ds: []
    };

    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    var appno = bData.appno;
    queryFourGuaBuyback();
    if(appno==null){
        $scope.sumbitdisable=true;
    }else{
        $scope.sumbitdisable= false;

    }
    if(window.appNo){  //流程提交后的处理
        $scope.hideback=true; //返回按钮隐藏
        getCurrentNodeEntity();
    }
    //获得当前流程节点的信息
    function getCurrentNodeEntity(){
        var data = {
            pid:processId
        };
        var promise = $common.get_asyncData("processService/getCurrentNodeEntity", {pid: processId});
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
               var flowdata = res.contextData;
                seq = parseFloat(flowdata.seq);
                if (seq > 1) { //提交后的流程
                //设置只读熟悉
                    $scope.taskdisable =true;
                    //按钮隐藏
                    $scope.hidetask = true;
                    $scope.hidesumbit = true;
                    $scope.hidesave = true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    //卖方名称
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmdooextent = function(ds){
        $scope.fourGuaBuybackform.coreCustcd=ds.custcd;
        $scope.fourGuaBuybackform.coreNm=ds.cname;
    };
    $scope.$watch("fourGuaBuybackform.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:"1", //核心厂商
            cname:$scope.fourGuaBuybackform.cname
            // custcd:$scope.otherform.custcd
        };

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
        $scope.fourGuaBuybackform.custcd=ds.custcd;
        $scope.fourGuaBuybackform.sellerNm=ds.cname;
    };
    $scope.$watch("fourGuaBuybackform.sellerNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.sellerNmContent.param ={
            creditFlag:'1',
            custType:'1',
            sellerNm:$scope.fourGuaBuybackform.cname,
            custcd:$scope.fourGuaBuybackform.custcd
        }
    });
    //买方客户名称下拉-end

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
        $scope.fourGuaBuybackform.fouCd=ds.custcd;
        $scope.fourGuaBuybackform.fouName=ds.cname;
    };
    $scope.$watch("fourGuaBuybackform.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.fouNameContent.param ={
            coreFlag:'1',
            custType:'1',
            fouName:$scope.fourGuaBuybackform.fouName,
            fouCd:$scope.fourGuaBuybackform.fouCd
        }
    });
    //承担方客户名称下拉-end

    //加载差额退款基本信息
    function queryFourGuaBuyback(){
        var fourQryVO ={
            appno:bData.appno,
            protocolNo:bData.protocolNo
        };
        var data = {
            fourQryVO:fourQryVO
        };
        var promise=$common.get_asyncData("fourGuaBuyBackService/getFourGuaBuyBackInfo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.fourGuaBuybackform=data;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    //保存
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            $scope.savedisable= true; //点击保存之后保存按钮不可用
            var data = {
                fourWareLoanVO: $scope.fourGuaBuybackform
            };
            var primise = $common.get_asyncData("fourGuaBuyBackService/saveFourBuybackWriteApply", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.fourGuaBuybackform.appno=data.value;
                    $scope.sumbitdisable= false;
                    var appno={
                    		appno:$scope.fourGuaBuybackform.appno
                        };
                    $.extend(bData,appno); //合并
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.savedisable= false; //返回结果后按钮可用
            });
        }
    };
    //提交
    $scope.sumbit_onClick = function(){
      if($.doValidate("otherform")) {
            $scope.sumbitdisable= true; //点击提交之后提交按钮不可用
            var data = {
                fourWareLoanVO: $scope.fourGuaBuybackform
            };
            var primise = $common.get_asyncData("fourGuaBuyBackService/saveFourBuybackWriteSubmit", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    //$scope.queryTable();
                    //$scope.selected.select = [];
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    //从待办任务进来提交之后的处理
                    if(window.appNo){
                        //隐藏列表按钮
                        $scope.hidetask = true;
                        $scope.hidesave = true;
                        $scope.hidesumbit = true;
                        $scope.hideback = true;
                    } else {
                        $scope.back_onClick();
                    }
                  
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.sumbitdisable= false; //返回结果后按钮可用
            });
        }
    };
    $scope.back_onClick = function () {
        $state.go("fourGuaBuyback");
    };
    //表格--------结束-------------------------
};
