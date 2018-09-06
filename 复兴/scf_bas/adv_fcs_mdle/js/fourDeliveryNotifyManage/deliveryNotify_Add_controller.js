/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var deliveryNotifyAddController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    $scope.otherform={};
    var pid;
    if(dataX.flag=="add"){
    //因为页面数据都是不会修改的，所以可以直接取值前一页面的数据
        $scope.otherform=dataX.deliveryNotify;
        $scope.otherform.appno=null;//前一个页面传过来是有appno的，需要清楚掉
        //剩余发货金额 balSendAmt  balanceAmt两个字段不一致
        $scope.otherform.balanceAmt=dataX.deliveryNotify.balSendAmt;
        $scope.otherform.deliveryQuantity=0;//本次发货数量 0
        $scope.otherform.deliveryAmt=0.00;//本次发货总价值 0
    }else if(dataX.flag=="view"){
        $scope.otherform=dataX.deliveryNotify;
        pid=$scope.otherform.id;
        $scope.view=true;
    }else if(dataX.flag=="update"){
        $scope.otherform=dataX.deliveryNotify;
        //这里要转下，从首页过来的appno是收款确认的申请号，传过来的deliveryAppno，才是发货申请号
        $scope.otherform.appno=$scope.otherform.deliveryAppno;
        pid=$scope.otherform.id;
    }
    //页面剩余发货金额实时查询 debetId
    $scope.$watch("otherform.debetId",function() {
        var promise = $common.get_asyncData("bLanLnciBaseService/findBLanLnciBaseByDebtId",{debtId:$scope.otherform.debetId});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform.balanceAmt=res.contextData.balSendAmt;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    });
    //-------------发货明细信息表初始化-------------
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.$watch("otherform.id",function() {
        if(dataX.flag != "add"){
            $scope.queryTablemort();
        }
    });
    $scope.queryTablemort = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            pid:pid
        };
        var promise = $common.get_asyncData("bNteNoticeMtgService/findBNteNoticeMtgByPid",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                for(var x in data.records ){
                    data.records[x].deliveryAmt=data.records[x].totPrice;
                }
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //------------------------------发货明细信息新增---------------------------------------
    $scope.doAdd_onClick = function(){
        $common.get_ngDialog('fourDeliveryNotifyManage/buyMprotInfo.html', $scope,["$scope",function(dialogScope){
            dialogScope.datasource={//初始化表格对象
                ds: []
            };
            dialogScope.selected={//初始化对象
                select: []
            };
            dialogScope.conf= {//初始化分页对象
                pageNo: 1,
                pageSize: 10,
                totalRecord: 0};
            //根据先票款后货协议号查询对应的购销合同
            var data= {
                pageNo:1,
                pageSize: 10,
                value:$scope.otherform.tradeContno
            };
            var promise = $common.get_asyncData("iBCntBuyInfoService/getDeliveryNotifyBuycontInfo",data);
            promise.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    for(var x in data.records){
                        for(var y in $scope.datasource.ds){
                            //押品编号一样就是重复了
                            if(data.records[x].mortgageNo== $scope.datasource.ds[y].mortgageNo){
                                data.records.splice(x,1);
                            }
                        }
                    }
                    dialogScope.datasource.ds = data.records;
                    dialogScope.conf.totalRecord =  data.records.length;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
            dialogScope.save_onClick = function(){
                if(dialogScope.selected.select.length != 1){
                    $common.get_tipDialog('请选择一条数据！','showInform');
                }else{
                    var price=parseFloat(dialogScope.selected.select[0].price);
                    var quantity=parseFloat(dialogScope.selected.select[0].quantity);
                    dialogScope.selected.select[0].deliveryAmt=price*quantity;//发货总金额
                   //页面发货数量，发货总金额要计算下
                    var deliveryQuantity=parseFloat($scope.otherform.deliveryQuantity);
                    $scope.otherform.deliveryQuantity=deliveryQuantity+parseFloat(dialogScope.selected.select[0].quantity);
                    var deliveryAmt=parseFloat($scope.otherform.deliveryAmt)+(price*quantity);
                    $scope.otherform.deliveryAmt=deliveryAmt;
                    //注意，这里要把购销合同的押品号设置进去
                    dialogScope.selected.select[0].srcMortgageNo=dialogScope.selected.select[0].mortgageNo;
                    $scope.datasource.ds.push(dialogScope.selected.select[0]);
                    $scope.conf.totalRecord = $scope.datasource.ds.length;
                    dialogScope.closeThisDialog();
                }
            }
            dialogScope.back_onClick = function(){
                dialogScope.closeThisDialog();
            }
        }],"押品列表",{showClose:true});
    };
    $scope.doUpdate_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条发货明细信息！','showInform');
        }else{
            $common.get_ngDialog('fourDeliveryNotifyManage/buyMprotInfo_Detil.html', $scope,["$scope",function(dialogScope){
                dialogScope.otherform=$common.copy($scope.selected.select[0]);
                dialogScope.otherform.curcd="CNY";
                //页面金额计算，离焦事件
                //quantity ,数量/重量 price,买入单价  deliveryAmt,发货金额
                dialogScope.quantity_onBlur=function(){
                    if(dialogScope.otherform.quantity ==""){
                        dialogScope.otherform.deliveryAmt=0.00;
                    }else{
                        if(dialogScope.otherform.price ==""){
                            dialogScope.otherform.deliveryAmt=0.00;
                        }else{
                            var quantity=parseFloat(dialogScope.otherform.quantity);
                            var price=parseFloat(dialogScope.otherform.price);
                            dialogScope.otherform.deliveryAmt=quantity*price;
                            dialogScope.otherform.totPrice=dialogScope.otherform.deliveryAmt;
                            $scope.$apply();
                        }
                    }
                }
                dialogScope.price_onBlur=function(){
                    if(dialogScope.otherform.quantity ==""){
                        dialogScope.otherform.deliveryAmt=0.00;
                    }else{
                        if(dialogScope.otherform.price ==""){
                            dialogScope.otherform.deliveryAmt=0.00;
                        }else{
                            var quantity=parseFloat(dialogScope.otherform.quantity);
                            var price=parseFloat(dialogScope.otherform.price);
                            dialogScope.otherform.deliveryAmt=quantity*price;
                            dialogScope.otherform.totPrice=dialogScope.otherform.deliveryAmt;
                            $scope.$apply();
                        }
                    }
                }
                //押品二级
                dialogScope.levelTwoContent = {
                    type:"table",//展示类型table  tree
                    url:"bPbcMtgClassService/findBPbcMtgClassForTwoLevelSelect",
                    //param:{levels:"2",parentCode:dialogScope.mort.mortgageLevelOne},
                    //split:"",//分隔符
                    extentColumn:"mortgageName",
                    column:["mortgageName"]//展示内容
                };
                dialogScope.levelTwodooextent = function(ds){
                    dialogScope.otherform.mortgageLevelTwo=ds.mortgageCode;
                    dialogScope.otherform.mortgageLevelTwoNm=ds.mortgageName;
                };
                dialogScope.$watch("otherform.mortgageLevelOne",function(newVal,oldVal){
                    dialogScope.levelTwoContent.param ={
                        levels:"2",
                        parentCode:dialogScope.otherform.mortgageLevelOne,
                        mortgageName:dialogScope.otherform.mortgageLevelTwoNm,
                    };
                });
                dialogScope.save_onClick = function(){
                    if((!dialogScope.otherform.manufacturer) || dialogScope.otherform.manufacturer == ""){
                        $common.get_tipDialog('请填写[生产厂家]！','showInform');
                        return ;
                    }
                    if((!dialogScope.otherform.manufactureDate) || dialogScope.otherform.manufactureDate == ""){
                        $common.get_tipDialog('请填写[出厂日期]！','showInform');
                        return ;
                    }
                    //计算页面数据 deliveryQuantity  deliveryAmt
                    var deliveryAmt1=parseFloat($scope.selected.select[0].deliveryAmt);//原来的发货总金额
                    var deliveryAmt2=parseFloat(dialogScope.otherform.deliveryAmt);//现在的发货总金额
                    var deliveryAmtX=parseFloat($scope.otherform.deliveryAmt);//页面上的总的发货总金额
                    $scope.otherform.deliveryAmt=deliveryAmtX-deliveryAmt1+deliveryAmt2;
                    var quantity1=parseFloat($scope.selected.select[0].quantity);//原来的货物数量
                    var quantity12=parseFloat(dialogScope.otherform.quantity);//现在的货物数量
                    var deliveryQuantity=parseFloat($scope.otherform.deliveryQuantity);//页面上的总的发货数量
                    $scope.otherform.deliveryQuantity=deliveryQuantity-quantity1+quantity12;
                    for(var x in $scope.datasource.ds){
                        if($scope.datasource.ds[x].mortgageNo==dialogScope.otherform.mortgageNo){
                            $scope.datasource.ds[x]=$common.copy(dialogScope.otherform);
                        }
                    }
                    $scope.selected.select=[];
                    dialogScope.closeThisDialog();
                }
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"发货明细",{showClose:true});
        }
    };
    $scope.doDelete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条押品信息！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function() {
                var array=$scope.selected.select[0];
                var list=$scope.datasource.ds;
                for(var x in list){
                    if(array.tradeContno ==list[x].tradeContno){
                        $scope.datasource.ds.splice(x,1);
                    }
                }
                //页面数据计算
                var price=parseFloat(array.price);
                var quantity=parseFloat(array.quantity);
                var deliveryQuantity=parseFloat($scope.otherform.deliveryQuantity);
                $scope.otherform.deliveryQuantity=deliveryQuantity-quantity;
                var deliveryAmt=parseFloat($scope.otherform.deliveryAmt)-(price*quantity);
                $scope.otherform.deliveryAmt=deliveryAmt;
                $scope.selected.select=[];
                $scope.conf.totalRecord=$scope.datasource.ds.length;
                $scope.$apply();
            });
        }
    };

    //保存/修改操作按钮 otherform.gutNm otherform.prtclBrNm
    var errorFlag=true;
    function checkFormRules(){
        //发货明细信息
        if($scope.datasource.ds.length == 0){
            $common.get_tipDialog('发货明细信息不可为空！', 'showInform');
            errorFlag=false;
            return ;
        }
        var list=$scope.datasource.ds;
        for(var x in list){
            //mortgageName 货品名称 manufacturer 生产厂家  manufactureDate 出厂日期
            if((!list[x].manufacturer) || list[x].manufacturer == ""){
                var mortgageName=list[x].mortgageName;
                $common.get_tipDialog("货品名称为"+mortgageName+"的发货明细信息[生产厂家]不可为空！", 'showInform');
                errorFlag=false;
                return ;
            }
            if((!list[x].manufactureDate) || list[x].manufactureDate == ""){
                var mortgageName=list[x].mortgageName;
                $common.get_tipDialog("货品名称为"+mortgageName+"的发货明细信息[出场日期]不可为空！", 'showInform');
                errorFlag=false;
                return ;
            }
        }
        // 剩余发货金额 balanceAmt 本次发货数量 deliveryQuantity 本次发货总价值 deliveryAmt
        var balanceAmt=parseFloat($scope.otherform.balanceAmt);//剩余发货金额
        var deliveryAmt=parseFloat($scope.otherform.deliveryAmt);//本次发货总价值
        if(deliveryAmt > balanceAmt){
            $common.get_tipDialog("本次发货总价值不能大于剩余发货金额！", 'showInform');
            errorFlag=false;
            return ;
        }
        //发货日 不能小于当前日期
        //系统当前日期
        var date=new Date();
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        if(m < 10){
            m = "0" + m;
        }
        if(d < 10){
            d = "0" + d;
        }
        $scope.otherform.sysDate="" + y + m + d;
        var sysDate=parseFloat($scope.otherform.sysDate);//当前日期
        var appliDate=parseFloat($scope.otherform.appliDate);//发货日
        if(appliDate < sysDate){
            $common.get_tipDialog("发货日期不可小于当前日期！", 'showInform');
            errorFlag=false;
            return ;
        }
        //收款确认日不能大于发货日
        var commonDate=parseFloat($scope.otherform.commonDate);//收款确认日
        if(commonDate > appliDate ){
            $common.get_tipDialog("收款确认日不能大于发货日！", 'showInform');
            errorFlag=false;
            return ;
        }

    }

    $scope.save_onClick = function(){
        //页面字段规则校验
        if($.doValidate("otherform")) {
            checkFormRules();
            if(errorFlag){
                var data={
                    BNteNoticeBase:$scope.otherform,
                    BNteNoticeMtg:$scope.datasource.ds
                };
                var primise = $common.get_asyncData("bNteNoticeBaseService/saveDeliveryNotify",data);
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $scope.otherform=res.contextData;
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }else{
                errorFlag=true;
            }
        }
    };
    //保存并提交按钮  saveAndSubmit
    $scope.saveAndSubmit_onClick = function(){
        //页面字段规则校验
        if($.doValidate("otherform")) {
            checkFormRules();
            if(errorFlag){
                //发货剩余金额此时就要计算好
                var balanceAmt=parseFloat($scope.otherform.balanceAmt);
                var deliveryAmt=parseFloat($scope.otherform.deliveryAmt);
                $scope.otherform.balanceAmt=balanceAmt-deliveryAmt;
                var data={
                    BNteNoticeBase:$scope.otherform,
                    BNteNoticeMtg:$scope.datasource.ds
                };
                var primise = $common.get_asyncData("bNteNoticeBaseService/submitDeliveryNotify",data);
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存并提交成功！', 'showSuccess');
                        $state.go("deliveryNotify");
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }else{
                errorFlag=true;
            }
        }
    };
    //返回按钮
    $scope.back_onClick = function () {
        if(dataX.flag=="add"){
            $state.go("deliveryNotifyConfirm");
        }else{
            $state.go("deliveryNotify");
        }
    };
};
