/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var debtOutPoolDtlController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var bData = dataDeliver.getter();
    var mastContno = bData.mastContno;
    $scope.otherform = bData;
    var seq;//流程节点顺序
    var processId = window.processId;//流程ID
    var process="AccountsReceivableOutPool";// 应收账款池融资出池申请
    var appno = window.appNo;
    queryTaskInfo();//任务信息
    //根据列表的条件查询出池的基本信息&出池信息
    getDebtInPoolBussInfo();
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTableDebt();
    });
    if (appno == null) {
        $scope.disableButton = true; //提交按钮只读
    } else { //流程中的处理
        $scope.hideback = true; //返回按钮隐藏
        $scope.disableButton = false;
        //通过申请编号查询申请信息获得相关的一些必须参数
      //  queryAppliBaseInfo();

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
        $scope.otherform.aging = parseFloat(ds.loanDays);//获得账期
        $scope.otherform.gracePeriod = parseFloat(ds.debtGraceDays);//获得宽限期
    };
    $scope.$watch("otherform.cnameBuyer", function () {
        $scope.buyerContent.param = {
            businessNo: mastContno,//将之前查处的业务合同号传参
            buyerName: $scope.otherform.cnameBuyer//买方名称
        }
    });
    $scope.taskform={};//任务
    //应收账款基本信息
    $scope.datasource = {//初始化表格对象
        ds: []
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
//通过申请编号获得申请相关的信息
    function queryAppliBaseInfo() {
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey", {"key": appno});
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                mastContno=data.mastContno;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }

    //获取任务信息
    function queryTaskInfo(){
        var data = {
            appno:appno,
            process:process
        };
        $common.get_asyncData("iScfWorkFlowService/findBPbcAppliBaseInfoByAppno",data).then(function (res) {
            var task;
            if (res.errorCode == "SUC") {
                task = res.contextData;
                $scope.taskform = task;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }

    //获取出池的基本信息
    function getDebtInPoolBussInfo(){
        var data = {
            debtBussInfoVO:  $scope.otherform
        };
        $common.get_asyncData("rBcpDebtInPoolAccountService/getDebtInPoolBussInfo",data).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.otherform =  data.records[0];
                $scope.otherform.mastContno = $scope.otherform.debtContno; //返回的是debtContno页面是mastContno
                //出池信息
                $scope.otherform.totalRiskAmt= $scope.otherform.poolRiskAmt; //本次出池后池敞口余额=池保证金余额
                $scope.otherform.inpoolDate = $scope.otherform.startDate;//出池日期
                $scope.otherform.totalNum =  $scope.otherform.debtNum;//总份数
                $scope.otherform.totalAmount =$scope.otherform.totalDebtAmount;//总金额
               // getDebtInPool();//出池信息
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
    //获取出池信息
    function getDebtInPool(){
        var data = {
            debtBussInfoVO:bData
        };
        var promise=$common.get_asyncData("rBcpDebtInPoolAccountService/getDebtInPoolEdit",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                // $scope.debtform=data;
                $.extend($scope.otherform,res.contextData); //合并
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
    //出池应收账款列表
    $scope.queryTableDebt = function(paramData)
    {
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            debtCommonQryVO:$scope.otherform
        };
        $common.get_asyncData("rBcpDebtOutPoolService/getInvoiceInpoolAppList", data).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
                $scope.otherform.totalNum = data.totalRecord;
                var totalAmount = 0;
                for(var i=0;i<$scope.datasource.ds.length;i++)
                {
                    var billsAmount= $scope.datasource.ds[i].remainingAmount;//应收账款余额
                    if(!isNaN(billsAmount)){
                        totalAmount = totalAmount + billsAmount;
                    }
                }
                if(totalAmount==0)
                {
                    $scope.otherform.totalAmount = "0.00";
                }
                else
                {
                    $scope.otherform.totalAmount = totalAmount;
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //实时查询
    $scope.queryBailAmount_onClick = function()
    {
        var data = {
            txnCode:"s033",
            bailAccountno:$scope.otherform.bailAcctNo
        };
        promise = $common.get_asyncData("interfaceButtonQueryService/InterfaceButtonQuery",{extInterface:data}).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.otherform.poolBailAmount = data.records[0].accountBalance;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //
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

    //添加票据信息（应收账款基本信息和业务合同号）
    $scope.add_onClick = function() {
        if($.doValidate("otherform")){

            $common.get_ngDialog('debtPoolPress/debtBaseInfoAdd.html', $scope
                ,["$scope",function(dialogScope){
                    //查询参数的组装
                    dialogScope.conditionForm={
                        mastContno:$scope.otherform.mastContno,
                        appno_Q:$scope.otherform.appno,
                        custcdSaller_Q:$scope.otherform.custcdSaller,//卖方客户号
                        custcdBuyer_Q:$scope.otherform.custcdBuyer,//买方客户号
                        bussType_Q:$scope.otherform.bussType//业务品种
                    };//初始化查询条件
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
                    //监听分页
                    dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                        dialogScope.queryTable();
                    });
                    //重置
                    dialogScope.rebort_onClick = function(){
                        dialogScope.$apply(function(){
                            dialogScope.conditionForm={
                                mastContno:$scope.otherform.mastContno,
                                appno_Q:$scope.otherform.appno,
                                custcdSaller_Q:$scope.otherform.custcdSaller,//卖方客户号
                                custcdBuyer_Q:$scope.otherform.custcdBuyer,//买方客户号
                                bussType_Q:$scope.otherform.bussType//业务品种
                            };//初始化查询条件
                            dialogScope.selected.select=[];//清空选项
                            dialogScope.queryTable();
                        })
                    };
                    //搜索
                    dialogScope.submit_onClick =function(){
                        dialogScope.queryTable();
                    };
                    dialogScope.queryTable = function(){
                        var data= {
                            pageNo: dialogScope.conf.pageNo,
                            pageSize: dialogScope.conf.pageSize,
                            debtCommonQryVO:dialogScope.conditionForm
                        };
                        var promise = $common.get_asyncData("rBcpDebtOutPoolService/getInvoiceOut",data);
                        promise.then(function(res){
                            var data;
                            if (res.errorCode =="SUC"){
                                data = res.contextData;
                                dialogScope.datasource.ds = data.records;
                                dialogScope.conf.totalRecord = data.totalRecord;
                                //选中记录
                                dialogScope.selected.select=$common.copy($scope.datasource.ds);
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    };
                    dialogScope.confirm_onClick = function(){
                        $scope.selected.select=[];
                        if(dialogScope.selected.select.length <= 0){
                            $common.get_tipDialog('请至少选择一条记录','showInform');
                            return false;
                        }
                        //转让出质总金额要判断不能大于合同的金额
                        if(totalAmount > contAmount){
                            $common.get_tipDialog('催收总金额不能大于合同金额！','showInform');
                        }else{
                            var contAmount =parseFloat($scope.otherform.contAmount);//合同金额
                            var selected=dialogScope.selected.select;
                            var totalAmount=0;//催收总金额
                            var totalNum=0;//催收份数
                            //计算票面金额的总额，计算费用。
                            for(var k in selected){
                                totalAmount=parseFloat(totalAmount)+parseFloat(selected[k].billsAmountView);
                                totalNum=totalNum+1;
                            }
                            $scope.otherform.totalAmount=totalAmount;
                            $scope.otherform.totalNum=totalNum;
                            //赋值到上一个页面
                            $scope.datasource.ds=[];
                            $scope.datasource.ds = $common.copy(dialogScope.selected.select);
                            $scope.$apply();
                            dialogScope.closeThisDialog();
                        }


                    };
                    dialogScope.closeThisDialog_onClick = function(){
                        dialogScope.closeThisDialog();
                    };
                }],"添加页面",{showClose:false});
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
                        //改变催收总金额，催收份数，费用总额，实收费用
                        $scope.otherform.totalNum = parseFloat($scope.otherform.totalNum) - 1;//催收份数减一
                        if($scope.otherform.totalNum == 0){//没有出质票据,全部置空
                            $scope.otherform.totalAmount="0.00";//催收票据总金额
                            $scope.$apply();
                        }else{
                            $scope.otherform.totalAmount = parseFloat($scope.otherform.totalAmount) - (selected.billsAmountView);//催收总金额
                            $scope.$apply();
                        }
                    }
                }
        }
    };
    //直接保存并发起流程
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            if ($scope.datasource.ds.length <= 0) {
                $common.get_tipDialog("请先添加应收账款后再提交!", 'showInform');
                return false;
            }
            $scope.savedisable= true; //点击保存之后保存按钮不可用
            var data = {
                debtBussInfoVO: $scope.otherform,
                debtBillsInfoVOList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData("rBcpDebtOutPoolService/saveDebtOutPoolWriteApply", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.otherform.appno=data.value;
                    dataDeliver.setter( $scope.otherform);
                    $scope.disableButton= false;
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    //$state.go("bsysthreeProtocol");
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
            if ($scope.datasource.ds.length <= 0) {
                $common.get_tipDialog("请先添加应收账款后再提交！", 'showInform');
                return false;
            }
            $scope.disableButton= true; //点击提交之后提交按钮不可用
            var data = {
                debtBussInfoVO: $scope.otherform,
                debtBillsInfoVOList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData("rBcpDebtOutPoolService/saveDebtOutPoolWriteSubmit", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    //$scope.queryTable();
                    //$scope.selected.select = [];
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
    //返回按钮
    $scope.back_onClick = function() {
        $state.go("debtPoolConList");
    }
};
