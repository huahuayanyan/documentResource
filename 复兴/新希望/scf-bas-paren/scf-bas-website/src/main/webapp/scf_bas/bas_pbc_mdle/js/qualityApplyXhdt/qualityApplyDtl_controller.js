/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var fourPledgeDtlController = function($scope,$common,$state,dataDeliver) {
    $scope.datasource = {ds:[]};
    $scope.selected={//初始化对象
        select: []
    };
    $scope.otherform = {};
    var dataX = dataDeliver.getter();
    $scope.productSource = {
        ds:[
            {code:"1220010",codeName:'现货静态质押'},
            {code:"1220020",codeName:'现货动态质押'},
        ]
    };
    var appno = dataX.appno;
    $scope.otherform.appno=appno;
    var conId = dataX.conId;
    var gutId = dataX.gutId;
    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    if(window.appNo) {
        $scope.hideback =true;
        getCurrentNodeEntity();
    }

    $scope.conf = {
        pageNo:1,
        pageSize:10,
        totalRecord: 0
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(newVal,oldVal) {
        $scope.queryTable();
    });
    if(appno){

    }else{
        $scope.submitdisable = true;
    }
    //申请 -核价
    //获得当前流程节点的信息 todo 这里顶多是第一个节点，不可能是第二个节点，看下
    function getCurrentNodeEntity(){
        var data = {
            pid:processId
        };
        var promise = $common.get_asyncData("processService/getCurrentNodeEntity", data);
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
                }else if(seq>2){   // check 核价之后
                    $scope.hidecheck = true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
    queryMortgageInfo();//申请基本信息查询

    function queryMortgageInfo(){
       /* var qualityApplyDO = {conId:conId,appno:appno};
        var data = {
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            qualityApplyDO: qualityApplyDO
        };
        var promise = $common.get_asyncData("fourPledgeService/queryFourPledgeBaseInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.otherform = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })*/
        var qualityApplyDO = {conId:conId,appNo:appno};
        var data = {
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            qualityApplyDO: qualityApplyDO
        }
        var promise = $common.get_asyncData("qualityApplyService/slaveProtocontInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.otherform = res.contextData;
                if(appno){
                    $scope.otherform.appno=appno;
                }
                var amount=0;
                for(var x in $scope.datasource.ds){
                    amount=amount+parseFloat($scope.datasource.ds[x].originalTotPrice);
                }
                $scope.otherform.amount=amount;
                $scope.otherform.slaveContno=$scope.otherform.conId;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            appno:appno
        };
        var promise = $common.get_asyncData("bPbcAppliMtgInfoService/queryNotifyMortgageListByAppno",data);
        promise.then(function(res){
            var response;
            if (res.errorCode =="SUC"){
                response = res.contextData;
                if(response != undefined && response.records != undefined)
                	$scope.datasource.ds = response.records;
                $scope.conf.totalRecord = response.totalRecord;
                //说明是从入库押品管理页面跳转过来的
                if(dataX.mortgageInfoList){
                    $scope.datasource.ds=dataX.mortgageInfoList;
                    $scope.conf.totalRecord=$scope.datasource.ds.length;
                    var amount=0;
                    for(var x in $scope.datasource.ds){
                        amount=amount+parseFloat($scope.datasource.ds[x].originalTotPrice);
                    }
                    $scope.otherform.amount=amount;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //已入库押品详情查看按钮
    $scope.enterDetail_onClick = function(){
       $common.get_ngDialog('qualityApplyXhdt/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
            dialogScope.datasource = {
                ds:[]
            };
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10,
                totalRecord:0
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

           var mortgageQryVO ={
               slaveContno:$scope.otherform.slaveContno
           };
            function queryMortgageListInfo(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageQryVO:mortgageQryVO
                };
                var promise = $common.get_asyncData("bPbcMtgBaseInfoService/getMortgageBaseInfoPageByParam", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
            }
        }
        ],"押品列表",{showClose:true});
    };

    //新增未出质押品信息
    $scope.add_onClick = function(){
       $common.get_ngDialog('qualityApplyXhdt/mortgageAdd.html',$scope,["$scope",function(dialogScope){
            mortgageLevelOneSource();
           dialogScope.conditionForm ={
               lockAppno:$scope.otherform.appno,
               slaveContno: $scope.otherform.slaveContno
           };
            dialogScope.datasource = {ds:[]};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10,
                totalRecord:0
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                querydeliveryMortInfoList();
            });
            // 押品列表获取查询
            function querydeliveryMortInfoList(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    BPbcMtgBaseInfo:  dialogScope.conditionForm,
                    list:  $scope.datasource.ds
                };
                var promise = $common.get_asyncData("qualityApplyService/MortgageEnteringAddListGettter", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
           //查询押品一级
           function mortgageLevelOneSource(){
               //业务品种下拉框
               var dataItemsDO = {levels:"1"};
               var data = {dataItemsDO:dataItemsDO};
               var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
               dialogScope.mortgageLevelOneSource = {};
               promise.then(function(res){
                   if (res.errorCode =="SUC"){
                       dialogScope.mortgageLevelOneSource.ds = res.contextData;
                   }else{
                       $common.get_tipDialog(res.errorMsg,'showInform');
                   }
               });
           }
           //联动下拉
           dialogScope.mortgageLevelTwoSource = {};
           dialogScope.mortgageLevelOneName = function (val){
               dialogScope.conditionForm.mortgageLevelTwoName = "";
               if(null != val){
                   var dataItemsDO = {mortgageCode:val};
                   var data = {dataItemsDO:dataItemsDO};
                   var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                   primise.then(function(res){
                       if(res.errorCode =="SUC"){
                           dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                       }else{
                           $common.get_tipDialog(res.errorMsg,'showInform');
                       }
                   });
               }else{
                   dialogScope.mortgageLevelTwoSource.ds = [];
               }
           };
            //查询按钮
            dialogScope.submit_onClick = function(){
                querydeliveryMortInfoList();
                dialogScope.selected.select = [];
            };
            //重置按钮
            dialogScope.reset_onClick = function(){
                $scope.$apply(function () {
                    dialogScope.conditionForm ={
                        lockAppno:$scope.otherform.appno,
                        slaveContno: $scope.otherform.slaveContno
                    };
                })
                dialogScope.selected.select = [];
            };
            //确认按钮
            dialogScope.save_onClick = function(){
                if(dialogScope.selected.select.length<1){
                    $common.get_tipDialog('请至少选择一条记录!','showInform');
                }else{
                    if( !$scope.datasource.ds){
                        $scope.datasource.ds=[];
                    }
                    for(var i=0;i<dialogScope.selected.select.length;i++){
                        $scope.datasource.ds.push(dialogScope.selected.select[i]);
                    }
                    totalApplyAmount();//计算本次入库金额
                    $scope.conf.totalRecord = $scope.datasource.ds.length;
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                }
            };
            //关闭按钮
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
        }],"新增押品列表",{showClose:true});
    };
    //查看按钮
    $scope.detail_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('qualityApplyXhdt/mortgageDetail.html',$scope,["$scope",function(dialogScope){
                dialogScope.mortgageDetail = {};
                dialogScope.disable = true;
                dialogScope.hide = true;
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var fourDeliveryQryVO ={
                    mortgageNo:mortgageNo
                };
                var data = {fourDeliveryQryVO:fourDeliveryQryVO};
                var promise = $common.get_asyncData("fourPledgeService/queryNotifyMortgageByMortgageNo",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageDetail = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelOneSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品二级
                mortgageLevelTwoSource();
                function mortgageLevelTwoSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"2"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelTwoSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品三级
                mortgageLevelThreeSource();
                function mortgageLevelThreeSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"3"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelThreeSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };
            }],'入库押品详情',{showClose:true});
        }
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length !=1){
            $common.get_tipDialog('请选择一条记录!','showInform')
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                for(var i = 0;i<$scope.selected.select.length;i++){
                    $scope.datasource.ds.splice($scope.selected.select[i], 1);
                }
                $scope.selected.select=[];
                $scope.conf.totalRecord =$scope.datasource.ds.length;
                totalApplyAmount();
            })
        }
    };
    //保存
    $scope.save_onClick = function () {
        if ($scope.datasource.ds.length < 1) {
            $common.get_tipDialog('请添加押品信息!', 'showInform');
            return false;
        }
        if($scope.otherform.lowPriceNew.length < 1){
            return false;
        }
        var data = {
            SlaveProtoContInfo: $scope.otherform,
            mortgageInfoList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("qualityApplyService/saveQualityApply", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                appno = res.contextData.value;
                $scope.otherform.appno= appno;
                $scope.submitdisable = false;
                //$scope.savedisable = true; //点击保存之后保存按钮不可用
                $common.get_tipDialog('保存成功!', 'showInform');
                var rappno ={appno:$scope.otherform.appno};
                var rdata = $.extend(dataDeliver.getter(),rappno);
                dataDeliver.setter( rdata);
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
            $scope.savedisable = false; //返回后按钮可用
        });
    };
    //提交
    $scope.submit_onClick = function(){
        if ($scope.datasource.ds.length < 1) {
            $common.get_tipDialog('请添加押品信息!', 'showInform');
            return false;
        }
        var data = {
            SlaveProtoContInfo: $scope.otherform,
            mortgageInfoList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("qualityApplyService/QualityAppWriteSubmitUpdater", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.submitdisable = true; //点击之后按钮不可用
                $common.get_tipDialog('提交成功!', 'showInform');
                //从待办任务进来提交之后的处理
                if(window.appNo){
                    //隐藏按钮
                    $scope.hidetask = true;
                } else {
                    $scope.back_onClick();
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
            $scope.submitdisable = false; //返回后按钮可用
        });
    };
    //返回
    $scope.back_onClick = function(){
        $state.go("fourPledgeList");
    };

    //统计本次入库货物总价值和本次入库押品总价值
    function totalApplyAmount() {
        var amount=0;
       for(var x in $scope.datasource.ds){
           amount=amount+parseFloat($scope.datasource.ds[x].originalTotPrice);
       }
        $scope.otherform.amount=amount;
    }
};
