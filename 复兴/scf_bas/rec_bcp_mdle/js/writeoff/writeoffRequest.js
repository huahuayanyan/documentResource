/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      yinyuling
 * @version     1.0
 * Create at:   2016/12/28
 */
var writeoffRequestController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var  bData =dataDeliver.getter();
    var mastContno = bData.mastContno;
    $scope.taskform={};
    $scope.otherform=bData;
    var rebateReason = "" ;//核销原因
    //应收账款基本信息
    $scope.datasource = {//初始化表格对象
        ds: []
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    var appno = window.appNo;
    if (appno == null) {
        $scope.disableButton = true; //提交按钮只读
    } else { //流程中的处理
        $scope.hideback = true; //返回按钮隐藏
        $scope.disableButton = false;
        //通过申请编号查询应收账款列表
        queryDebtlist();
        getCurrentNodeEntity();
    }
    //买方客户查询
    $scope.buyerContent = {
        type: "table",//展示类型table  tree
        url: "bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
        param: {businessNo: mastContno},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split: "",//分隔符*/
        extentColumn: "buyerName",
        column: ["buyerName"]//展示内容
    };
    $scope.buyerExtent = function (ds) {
        $scope.otherform.custcdBuyer = ds.buyerCustcd;//获得买方客户号
    };
    $scope.$watch("otherform.cnameBuyer", function () {
        $scope.buyerContent.param = {
            businessNo: mastContno,//将之前查处的业务合同号传参
            buyerName: $scope.otherform.cnameBuyer//买方名称
        }
    });

    //查询任务
    queryTaskInfo();
    //基本信息&核销信息
    queryBaseInfo();
    /*
     initBCntDebtInfo();
     function initBCntDebtInfo(){
     $scope.otherReasonDisable=true;
     $scope.otherReasonMust=false;
     // writeoffs

     var writeoffs={};
     var count=0;
     var amount=0;

     if(flag=='returnPage') {
     count = bData.rBcpDebtBase.length;
     if(count>0){
     for (var i = 0; i < count; i++) {
     amount += bData.rBcpDebtBase[i].remainingAmount;
     }
     $scope.rBcpDebtBase.ds = bData.rBcpDebtBase;
     }
     writeoffs.writeoffCount = count;
     writeoffs.writeoffAmount = amount;
     writeoffReason = bData.writeoffReason;
     otherReason =bData.otherReason;
     }
     var d=new Date();
     var day= d.getFullYear()+"" +d.getMonth()+1+""+ d.getDate();
     writeoffs.writeoffDate=day;
     writeoffs.writeoffCount=count;
     writeoffs.writeoffAmount=amount;
     writeoffs.writeoffReason = writeoffReason;
     writeoffs.otherReason = otherReason;
     $scope.writeoffInfo=writeoffs;

     //taskBaseInfo
     var data ={
     debtContno:bData.debtContno
     };
     /!* var taskform=$common.get_asyncData("iRBcpWriteoffService/queryTaskBaseInfo",data);
     queryTaskBaseInfo.then(function (res) {
     if(res.errorCode=="SUC"){
     data = res.contextData;
     $scope.taskBaseInfo=data;
     }else{
     $common.get_tipDialog(res.errorMsg,'showError');
     }
     });*!/
     var queryBaseInfo=$common.get_asyncData("iRBcpWriteoffService/queryBaseInfo",data);
     queryBaseInfo.then(function (res) {
     if(res.errorCode=="SUC"){
     data = res.contextData;
     if(flag=='returnPage'){
     data.buyerName=bData.custcdBuyer;
     buyerName= bData.buyerName;
     custcdBuyer=bData.custcdBuyer;
     }
     $scope.baseInfo=data;
     custName = data.custName;
     }else{
     $common.get_tipDialog(res.errorMsg,'showError');
     }
     });

     var sb=$common.get_asyncData("iRBcpWriteoffService/selectBuyerName",data);
     sb.then(function (res) {
     var result;
     if(res.errorCode=="SUC"){
     result = res.contextData;
     $scope.selectBuyerName.ds = result;
     }else{
     $common.get_tipDialog(res.errorMsg,'showError');
     }
     });

     };
     */


    //获取任务信息
    function queryTaskInfo(){
        var data ={
            appno:bData.appno,
            factType:1 //应收账款池
        };
        $common.get_asyncData("iRBcpWriteoffService/findBPbcAppliBaseInfoByAppno",data).then(function (res) {
            var task;
            if (res.errorCode == "SUC") {
                task = res.contextData;
                $scope.taskform = task;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }

    //获取基本信息
    function queryBaseInfo(){
        var data = {
            debtBussInfoVO:  $scope.otherform
        };
        $common.get_asyncData("iRBcpWriteoffService/queryBaseInfo",data).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.otherform =  data;
                $scope.otherform.mastContno = $scope.otherform.debtContno; //返回的是debtContno页面是mastContno
                //核销信息信息
                $scope.otherform.totalNum =  $scope.otherform.debtNum;//总份数
                $scope.otherform.totalAmount =$scope.otherform.totalDebtAmount;//总金额
                $scope.otherform.factType ="1";//应收账款融资
                rebateReason =  $scope.otherform.rebateReason; //核销原因
                if('4'==rebateReason){
                    $scope.otherReasonDisable=false;
                    $scope.otherReasonMust='common.require';
                }else{
                    $scope.otherReasonDisable=true;
                    $scope.otherReasonMust= false;
                    $scope.otherform.otherReason="";
                }

            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
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
                    $scope.viewdisable =true;
                    //按钮隐藏
                    $scope.viewhide = true;
                };
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }


    $scope.writeoffReasonChange = function(val){
        rebateReason =val;
        if('4'==val){
            $scope.otherReasonDisable=false;
            $scope.otherReasonMust='common.require';
        }else{
            $scope.otherReasonDisable=true;
            $scope.otherReasonMust= false;
            $scope.otherform.otherReason="";
        }
    };
    /*$scope.$watch("otherform.rebateReason", function (newVal,oldVal) {
     if(oldVal!=null&&newVal !== oldVal){
     $scope.datasource.ds=[];
     $scope.otherform.totalNum=0;
     $scope.otherform.totalAmount="0.00";
     }
     });*/
    /*
     $scope.buyerNameChange = function(val){
     custcdBuyer =val;
     var sb=$common.get_asyncData("iRBcpWriteoffService/selectCName",{"custCd":val});
     sb.then(function (res) {
     var result;
     if(res.errorCode=="SUC"){
     buyerName = res.contextData.value;
     }else{
     $common.get_tipDialog(res.errorMsg,'showError');
     }
     });
     };
     */

    //买方改变时，清空对应的列表
    $scope.$watch("otherform.custcdBuyer", function (newVal,oldVal) {
        if(oldVal!=null&&newVal !== oldVal){
            $scope.datasource.ds=[];
            $scope.otherform.totalNum=0;
            $scope.otherform.totalAmount="0.00";
        }
    });
    $scope.add_onClick = function(){
        if($.doValidate("otherform")) {
            $common.get_ngDialog('writeoff/rBcpDebtBaseList.html', $scope
                ,["$scope",function(dialogScope){
                    queryRBcpDebtBaseList(dialogScope,$scope,$common,"");
                }],"应收账款添加",{showClose:true});
        }
    };
    //删除票据信息
    $scope.delete_onClick = function() {
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            var dsArray = $scope.datasource.ds;
            var selected = $scope.selected.select[0];
            for (var i = 0; i < dsArray.length; i++) {
                if (dsArray[i].billsNo == selected.billsNo) {
                    $scope.datasource.ds.splice(i, 1);
                    $scope.selected.select = [];
                    //改变总金额，份数
                    $scope.otherform.totalNum = parseFloat($scope.otherform.totalNum) - 1;//催收份数减一
                    if($scope.otherform.totalNum == 0){//没有出质票据,全部置空
                        $scope.otherform.totalAmount="0.00";//催收票据总金额
                        $scope.$apply();
                    }else{
                        $scope.otherform.totalAmount = parseFloat($scope.otherform.totalAmount) - parseFloat(selected.billsAmountView);//催收总金额
                        $scope.$apply();
                    }
                }
            }
        }
    };

    //查询应收账款列表
    function queryDebtlist() {
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            key: appno
        };
        var promise = $common.get_asyncData("iRBcpWriteoffService/findRBcpDebtBaseInfoPageByPage", data);
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }

    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            if ($scope.otherform.totalAmount <= 0) {
                $common.get_tipDialog("核销金额不能小于0，请添加应收账款单据！", 'showError');
                return false;
            }
            $scope.savedisable= true; //点击保存之后保存按钮不可用
            var data = {
                debtBussInfoVO: $scope.otherform,
                rBcpDebtBaseInfoList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData('iRBcpWriteoffService/saveWriteoffRequestInfo', data)
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    var data=res.contextData;
                    $scope.otherform.appno = data.value;
                    dataDeliver.setter( $scope.otherform);
                    $scope.disableButton= false;
                    //$state.go("writeoffList");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.savedisable= false; //返回结果后按钮可用
            });
        }
    };
    $scope.submit_onClick = function(){
        if($.doValidate("otherform")) {
            if ($scope.otherform.totalAmount <= 0) {
                $common.get_tipDialog("核销金额不能小于0，请添加应收账款单据！", 'showError');
                return false;
            }
            $scope.disableButton= true; //点击提交之后提交按钮不可用
            var data = {
                debtBussInfoVO: $scope.otherform,
                rBcpDebtBaseInfoList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData('iRBcpWriteoffService/submitWriteoffRequestInfo', data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    //从待办任务进来提交之后的处理
                    if(window.appNo){
                        $scope.viewhide = true;
                    } else {
                        $scope.back_onClick();
                    }
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.disableButton= false; //返回结果后按钮可用
            });
        }
    };
    $scope.back_onClick = function(){
        $state.go("writeoffList");
    };
};
