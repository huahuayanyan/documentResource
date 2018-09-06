/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var multiPriceAdjustControllerXhdt = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    //任务基本信息初始化
    $scope.taskForm = {
        ext2:"现货质押批量价格调整申请(动态)",
    };
    var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:{}});
    promiseA.then(function(res1){
        if(res1.errorCode =="SUC") {
            $scope.taskForm.tlrName = userInfo.tlrName;//经办人
            $scope.taskForm.brName = res1.contextData.brName;//经办机构
            $scope.taskForm.stratDate=res1.contextData.txnDate;//工作交易日
            $scope.applyInfo.appDate=$scope.taskForm.stratDate;
        }else{
            $common.get_tipDialog(res1.errorMsg,'showError');
        }
    });
    $scope.selectSource = {
        ds:[{key:"2",value:'批量'},]
    };
    //上面的初始化不改变
    var seq;
    if(window.appNo){//如果有申请号
        $scope.applyInfo={};
        var processId=window.processId;
        var modelId=window.modelId;
        var appno = window.appNo;
        var flowData;
        //获取当前节点信息
        var promiseB = $common.get_asyncData("processService/getCurrentNodeEntity",{pid:processId});
        promiseB.then(function(res){
            if (res.errorCode =="SUC") {
                flowData = res.contextData;
                seq = parseFloat(flowData.seq);
                if(seq == "1"){//第一个节点，所有的按钮可以显示

                }else{//第二个节点，所有按钮隐藏
                    $scope.Approve=true;
                }
                //通过申请编号获得申请相关的信息
                var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.taskForm.ext2="现货质押批量价格调整申请(动态)";
                        $scope.taskForm.stratDate=res.contextData.stratDate;
                        $scope.applyInfo.appDate=$scope.taskForm.stratDate;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        //页面信息加载
        var promise = $common.get_asyncData("bPbcAppliMtgInfoService/findBPbcAppliMtgInfoByAppno",{appno:appno});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.applyInfo=res.contextData[0];
                $scope.applyInfo.applyType="2";
                $scope.applyInfo.productId="1220020";
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    if(!window.appNo){
        $scope.applyInfo={applyType:"2",productId:"1220020"}
        $scope.submit=true;
    }
    //押品下拉菜单
    // 押品一级
    $scope.levelOneContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"1"},    //应收账款融资
        //split:"",//分隔符
        extentColumn:"mortgageName",
        column:["mortgageName"]//展示内容
    };
    $scope.levelOnedooextent = function(ds){
        $scope.applyInfo.mortgageLevelOne=ds.mortgageCode;
        $scope.applyInfo.mortgageLevelOneNm=ds.mortgageName;
        $scope.applyInfo.parentCode = ds.mortgageCode;
        //需要清空所有的二级三级押品的名称和数据
        if($scope.applyInfo.mortgageLevelTwo){
            $scope.applyInfo.mortgageLevelTwo=null;
            $scope.applyInfo.mortgageLevelTwoNm="";
            $scope.applyInfo.mortgageLevelThree=null;
            $scope.applyInfo.mortgageLevelThreeNm="";
        }
        $scope.levelTwoContent.param ={
            levels:"2",
            parentCode:$scope.applyInfo.parentCode
        }
    };
    $scope.$watch("applyInfo.mortgageLevelOneNm",function(newVal,oldVal){
        $scope.levelOneContent.param ={
            levels:"1",
            mortgageName:$scope.applyInfo.mortgageLevelOneNm
        };
    });
    //押品二级
    $scope.levelTwoContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"2",parentCode:$scope.mort.mortgageLevelOne},
        //split:"",//分隔符
        extentColumn:"mortgageName",
        column:["mortgageName"]//展示内容
    };
    $scope.levelTwodooextent = function(ds){
        $scope.applyInfo.mortgageLevelTwo=ds.mortgageCode;
        $scope.applyInfo.mortgageLevelTwoNm=ds.mortgageName;
        if($scope.applyInfo.mortgageLevelThree){
            $scope.applyInfo.mortgageLevelThree=null;
            $scope.applyInfo.mortgageLevelThreeNm="";
        }
        $scope.levelThreeContent.param ={
            levels:"3",
            ext1:ds.mortgageCode
        }
    };
    $scope.$watch("applyInfo.mortgageLevelTwoNm",function(newVal,oldVal){
        $scope.levelTwoContent.param ={
            levels:"2",
            parentCode:$scope.applyInfo.mortgageLevelOne,
            mortgageName:$scope.applyInfo.mortgageLevelTwoNm,
        };
    });
    //押品三级
    $scope.levelThreeContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"2",parentCode:$scope.mort.mortgageLevelOne},
        //split:"",//分隔符
        extentColumn:"mortgageName",
        column:["mortgageName"]//展示内容
    };
    $scope.levelThreedooextent = function(ds){
        $scope.applyInfo.mortgageLevelThree=ds.mortgageCode;
        $scope.applyInfo.mortgageLevelThreeNm=ds.mortgageName;
    };
    $scope.$watch("applyInfo.mortgageLevelThreeNm",function(newVal,oldVal){
        $scope.levelThreeContent.param ={
            levels:"3",
            ext1:$scope.applyInfo.mortgageLevelTwo,
            mortgageName:$scope.applyInfo.mortgageLevelThreeNm,
        };
    });
    //-----------------------页面点击事件-----------------------
    //页面字段校验
    function checkFormRules(){
        //一级押品
        if(!$scope.applyInfo.mortgageLevelOne || $scope.applyInfo.mortgageLevelOneNm==""){
            $common.get_tipDialog('请通过查询按钮选择押品一级！','showInform');
            return false;
        }
        //二级押品
        if(!$scope.applyInfo.mortgageLevelTwo || $scope.applyInfo.mortgageLevelTwoNm==""){
            $common.get_tipDialog('请通过查询按钮选择押品二级！','showInform');
            return false;
        }
        //三级押品
        if(!$scope.applyInfo.mortgageLevelThree || $scope.applyInfo.mortgageLevelThreeNm==""){
            $common.get_tipDialog('请通过查询按钮选择押品三级！','showInform');
            return false;
        }
    }
    //关联抵质押合同按钮
    $scope.link_onClick = function(){
        var url
        if(checkFormRules() != false){
            //三级押品名称和押品号一致性校验
            var BPbcMtgBaseInfo= {
                mortgageLevelOne:$scope.applyInfo.mortgageLevelOne,
                mortgageLevelOneName:$scope.applyInfo.mortgageLevelOneNm,
                mortgageLevelTwo:$scope.applyInfo.mortgageLevelTwo,
                mortgageLevelTwoName:$scope.applyInfo.mortgageLevelTwoNm,
                mortgageLevelThree:$scope.applyInfo.mortgageLevelThree,
                mortgageLevelThreeName:$scope.applyInfo.mortgageLevelThreeNm,
            }
            var promise = $common.get_asyncData("bPbcMtgClassService/checkInfoForThreeLevelsSelect",{BPbcMtgBaseInfo:BPbcMtgBaseInfo});
            promise.then(function(res){
                if (res.errorCode =="SUC"){
                    if(seq == "1"|| seq=="2"){
                        url='../../sto_smp_mdle/html/multiPriceAdjust/mort_cont_list.html'
                    }else{
                        url='multiPriceAdjust/mort_cont_list.html'
                    }
                    $common.get_ngDialog(url, $scope,["$scope",function(dialogScope){
                        dialogScope.datasource={//初始化表格对象
                            ds:[]
                        };
                        dialogScope.selected={//初始化对象
                            select: []
                        };
                        dialogScope.conf= {//初始化分页对象
                            pageNo: 1,
                            pageSize: 10,
                            totalRecord: 0};
                        var bPbcMtgBaseInfo={
                            supplyChainPdId:"1220020",
                            mortgageLevelOne:$scope.applyInfo.mortgageLevelOne,
                            mortgageLevelTwo:$scope.applyInfo.mortgageLevelTwo,
                            mortgageLevelThree:$scope.applyInfo.mortgageLevelThree
                        }
                        if ($scope.applyInfo.appno){
                            //如果是保存之后，则关联的合同的押品信息也可以是锁定的押品信息
                            bPbcMtgBaseInfo.channelFlag="Approve"
                        }
                        //监听分页
                        dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                            dialogScope.queryTable();
                        });
                        //查询
                        dialogScope.queryTable = function(){
                            var data= {
                                pageNo: dialogScope.conf.pageNo,
                                pageSize: dialogScope.conf.pageSize,
                                bPbcMtgBaseInfo:bPbcMtgBaseInfo
                            };
                            var promise = $common.get_asyncData("bPbcMtgBaseInfoService/getPriceAdjustSlaveContGetter",data);
                            promise.then(function(res){
                                var data;
                                if (res.errorCode =="SUC"){
                                    data = res.contextData;
                                    dialogScope.datasource.ds = data.records;
                                    dialogScope.conf.totalRecord = data.totalRecord;
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        };
                    }],"抵/质押合同列表",{showClose:true});
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    //保存按钮
    $scope.save_onClick = function(){
        if($.doValidate("applyInfo")) {
            var confirmPrice=parseFloat($scope.applyInfo.confirmPrice);
            if(confirmPrice = 0){
                $common.get_tipDialog('调整后价格不能为0！','showInform');
                return ;
            }
            if(confirmPrice.length > 22){
                $common.get_tipDialog('调整后价格不可超过15位！','showInform');
                return ;
            }
            if(checkFormRules() != false){
                var BPbcAppliMtgInfo=$scope.applyInfo;
                var promise = $common.get_asyncData("bPbcAppliBaseInfoService/saveOrUpdateMutilPriceAdjustApplyInfo",{BPbcAppliMtgInfo:BPbcAppliMtgInfo});
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.applyInfo.appno= res.contextData.value;
                        if(seq == "1"|| seq=="2"){

                        }else{
                            $scope.submit=false;
                        }
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
        }

     };
    //提交按钮
    $scope.submit_onClick = function(){
        if($.doValidate("applyInfo")) {
            var confirmPrice=parseFloat($scope.applyInfo.confirmPrice);
            if(confirmPrice = 0){
                $common.get_tipDialog('调整后价格不能为0！','showInform');
                return ;
            }
            if(confirmPrice.length > 22){
                $common.get_tipDialog('调整后价格不可超过15位！','showInform');
                return ;
            }
            if(checkFormRules() != false){
                var BPbcAppliMtgInfo=$scope.applyInfo;
                var promise = $common.get_asyncData("bPbcAppliBaseInfoService/submitMutilPriceAdjustApplyInfo",{BPbcAppliMtgInfo:BPbcAppliMtgInfo});
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('提交成功！', 'showSuccess');
                        if(seq == "1"|| seq=="2"){
                            $state.go("bsystask");
                        }else{
                            $scope.applyInfo={
                                applyType:"2",
                                productId:"1220020",
                                appDate:$scope.taskForm.stratDate}
                            $scope.submit=true;
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
        }
     };
};
