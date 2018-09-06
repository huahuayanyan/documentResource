/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var impairAddController = function($scope,$common,dataDeliver,$state,$stateParams,$compile,$eventCommunicationChannel) {
    /*disable　中 disable是在提交之后的全部只读 disable1是在保存的时候提交按钮只读true disable2 点击完保存之后买方客户名称只读
    hide 中 hide是在提交之后所有的按钮全部隐藏  hide1 的是代办任务中返回按钮隐藏 true*/
    //代办任务页面
    $scope.otherform = {};
    $scope.cntDebtInfoForm={
        mastContno:"",
    }
    //公用页面初始化，调用方法
    //争议应收账款列表初始化
    $scope.bcpDatasource={ds:[]};
    $scope.bcpSelected ={select:[]};
    $scope.bcpConf= {
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //关联的融资信息
    $scope.datasource={ds:[]};
    $scope.selected ={select:[]};
    $scope.conf= {
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //页面经办机构信息
    var debtInfo;
    var bCrmBrInfo={}
    var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
    promiseA.then(function(res1){
        if(res1.errorCode =="SUC") {
            $scope.otherform.tlrName = userInfo.tlrName;//经办人
            $scope.otherform.brName = res1.contextData.brName;//经办机构
        }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    if(window.appNo){//如果有申请号
        var processId=window.processId;
        var modelId=window.modelId;
        var appno = window.appNo;
        var flowData;
        var seq;
        //获取当前节点信息
        var promiseB = $common.get_asyncData("processService/getCurrentNodeEntity",{pid:processId});
        promiseB.then(function(res){
            if (res.errorCode =="SUC") {
                flowData = res.contextData;
                seq = parseFloat(flowData.seq);
                if(seq == "1"){//第一个节点，所有的按钮可以显示
                    $scope.disable=false;
                    $scope.disable1=false;
                    $scope.disable2=true;//买方客户名称只读
                    $scope.hide=false;
                    $scope.hide1=true;//代办任务中返回按钮隐藏
                }else{//第二个节点，所有按钮隐藏
                    $scope.disable=true;
                    $scope.disable2=true;//买方客户名称只读

                    $scope.hide=true;
                    $scope.hide1=true;//代办任务中返回按钮隐藏
                }
                //通过申请编号获得申请相关的信息
                var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.otherform.ext2=res.contextData.ext2;
                        $scope.otherform.stratDate=res.contextData.stratDate;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        //加载页面信息， cntDebtInfoForm，bcpDatasource
        var rBcpAppliBussInfo={
            appno:appno
        }
        var promise = $common.get_asyncData("rBcpAppliBussInfoService/findBcpAppliBussInfoByKey",{rBcpAppliBussInfo:rBcpAppliBussInfo});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.cntDebtInfoForm = res.contextData;
                //加载页面融资关联信息
                var query={
                    custcdBuyer:$scope.cntDebtInfoForm.custcdBuyer,
                    custcdSaller:$scope.cntDebtInfoForm.custcdSaller,
                    mastContno:$scope.cntDebtInfoForm.mastContno,
                };
                var data= {
                    pageNo: $scope.conf.pageNo,
                    pageSize: $scope.conf.pageSize,
                    appliBussInfo:query
                };
                $common.get_asyncData("factoringDebtBackService/getLanLnciInfoByContno", data).then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        $scope.datasource.ds = data.records;
                        $scope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                });
                var promise2 = $common.get_asyncData("bCntDebtInfoService/findBCntDebtInfoByKey",{key:$scope.cntDebtInfoForm.mastContno});
                promise2.then(function(res1){
                    if (res1.errorCode =="SUC"){
                        $scope.cntDebtInfoForm.bussTypeName=res1.contextData.bussTypeName
                        var dataQ= {
                            pageNo:1,
                            pageSize:10,
                            value:{lockAppno:appno}
                        };
                        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoForImpair",dataQ);
                        promise.then(function(res){
                            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                                var bcpDatasource=res.contextData.records;
                                //减值后金额 rebatebalance 计算
                                for(var x in bcpDatasource){
                                    bcpDatasource[x].rebatebalance=parseFloat(bcpDatasource[x].remainingAmount)-parseFloat(bcpDatasource[x].rebateAmounts);
                                }
                                $scope.bcpDatasource.ds=bcpDatasource;
                                $scope.bcpConf.totalRecord = res.contextData.totalRecord;
                                //池信息数据查询
                                //queryPoolInfo();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }else{
                        $common.get_tipDialog(res1.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    }

    //非代办任务页面
    if(!window.appNo){
        // ext2 stratDate
        $scope.otherform.ext2="应收账款融资减值申请";
        var dataX=dataDeliver.getter();
        debtInfo=dataX.debtInfo;
        $scope.cntDebtInfoForm =debtInfo;
        //disable为false,disable1为true,此时买方客户名称是可以修改的，提交按钮是只读的
        $scope.disable=false;
        $scope.disable1=true;
        //减值申请	（为发起日期）
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
        $scope.cntDebtInfoForm.insertDate="" + y + m + d;
        $scope.otherform.stratDate="" + y + m + d; //流程发起日起
        $scope.cntDebtInfoForm.debtNum=0;
        $scope.cntDebtInfoForm.amount=0;
        //页面几个字段的回显 totalDebtRemainAmount，poolRiskAmt，bailAcctNo， 池敞口的相关信息计算的数据源
        /*$scope.$watch("bcpConf.pageNo",function(){
            queryPoolInfo();
        });*/
    }

    //买方客户查询
    $scope.buyerContent = {
        type:"table",//展示类型table  tree
        url:"bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
        param:{businessNo:$scope.cntDebtInfoForm.mastContno},
        split:"",//分隔符*/
        extentColumn:"buyerName",
        column:["buyerName"]//展示内容
    };
    //这里防止是页面刷新，将对应的买方客户置空，使底下的票据列表清空
    var cnameBuyer="";
    if($scope.cntDebtInfoForm.custcdBuyer){
        cnameBuyer=$scope.cntDebtInfoForm.custcdBuyer
    }
    $scope.buyerExtent = function(ds){
        $scope.cntDebtInfoForm.custcdBuyer=ds.buyerCustcd;//获得买方客户号
        $scope.cntDebtInfoForm.cnameBuyer=ds.buyerName;//获得买方客户号
        //当买方客户改变时，下面的票据信息要清空
        if(ds !="" && ds.buyerCustcd != cnameBuyer){
            $scope.bcpDatasource.ds=[];
            $scope.datasource.ds=[];
            cnameBuyer=ds.buyerCustcd
        }
        //关联的融资信息数据初始化,随着买方的改变而改变
        if(!ds.buyerCustcd==""){
            var query={
                custcdBuyer:ds.buyerCustcd,
                custcdSaller:$scope.cntDebtInfoForm.custcdSaller,
                mastContno:$scope.cntDebtInfoForm.mastContno,
            };
            var data= {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                appliBussInfo:query
            };
            $common.get_asyncData("factoringDebtBackService/getLanLnciInfoByContno", data).then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.datasource.ds = data.records;
                    $scope.conf.totalRecord = data.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
        }
    };
    $scope.$watch("cntDebtInfoForm.cnameBuyer",function(){
        $scope.buyerContent.param ={
            businessNo:$scope.cntDebtInfoForm.mastContno,//将之前查处的业务合同号传参
            buyerName:$scope.cntDebtInfoForm.cnameBuyer,//买方名称
        }
    });


    //池信息数据源
    /*function queryPoolInfo(){
        var data ={
            pageNo:1,
            pageSize:10,
            appno:'',
            flag:'',
            mastContno: $scope.cntDebtInfoForm.mastContno,
            custcdSaller:$scope.cntDebtInfoForm.custcdSaller,
            // custcdBuyer:$scope.cntDebtInfoForm.custcdBuyer
        };
        var primiseA = $common.get_asyncData('rBcpDebtDisputRegService/getDisputeInvoiceSetApplyAdd',data);
        primiseA.then(function(res){
            if (res.errorCode =="SUC"){
                var appliBussInfoVO = res.contextData.records[0];
                //池应收账款余额
                $scope.cntDebtInfoForm.totalDebtRemainAmount =appliBussInfoVO.totalDebtRemainAmount;
                //poolRiskAmt 池敞口余额 PoolRiskAmt
                $scope.cntDebtInfoForm.poolRiskAmt =appliBussInfoVO.poolRiskAmt;
                //bailAcctNo 池保证金账号
                $scope.cntDebtInfoForm.bailAcctNo=appliBussInfoVO.bailAcctNo;
                if(!window.appNo){
                    $scope.cntDebtInfoForm.debtNum=0;
                    $scope.cntDebtInfoForm.amount=0;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }*/
   //--------------------------------------------点击事件------------------------------------//
    //$scope.cntDebtInfoForm.poolBailAmount=10000000;
    //实时查询点击事件，池保证余额就是10000000
    $scope.queryacctamt_onClick = function(){
        $scope.$apply(function(){
            $scope.cntDebtInfoForm.poolBailAmount=10000000;
        });
    }
// add,update,del,progress,save,submit,back
    //添加票据信息
    $scope.add_onClick = function(){
        if($.doValidate("cntDebtInfoForm")) {//校验买方客户是否已填
            var row={
                debtInfo:$scope.cntDebtInfoForm,
                bcpDatasource:$scope.bcpDatasource.ds,
            }
            var pageUrl;
            if(window.appNo){
                pageUrl="../../rec_bcp_mdle/html/debtPoolTransfer/bcp_base_info_list.html"
            }else{
                pageUrl='debtPoolTransfer/bcp_base_info_list.html'
            }
            $common.get_ngDialog(pageUrl, $scope
                ,["$scope",function(dialogScope){
                    /*getDebtBaseListForPoorImpair(dialogScope,$scope,$common,dataDeliver,$state,row);*/
                    var bcpDatasource=$common.copy(row.bcpDatasource);
                    var mastContno=row.debtInfo.mastContno;
                    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
                        custcdSaller:row.debtInfo.custcdSaller,//卖方客户号
                        mastContno:mastContno,//业务合同号
                        custcdBuyer:row.debtInfo.custcdBuyer,//买方客户号
                        factType:row.debtInfo.factType,//应收账款融资
                        lockAppno:row.debtInfo.appno,
                        issueFlag:"0",//无商纠
                    };
                    dialogScope.datasource={//初始化表格对象
                        ds: []
                    };
                    dialogScope.selected={//初始化对象
                        select: []
                    };
                    dialogScope.conf= {//初始化分页对象
                        pageNo: 1,
                        pageSize: 10,
                        totalRecord: 0}

                    //监听分页
                    dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                        dialogScope.queryTable();
                    });
                    //重置按钮 cnameSeller，cnameBuyer，mastContno，bussType，billsDateFrom，billsDateTo，debtEndFrom，debtEndTo
                    // billsType，billsNo，status
                    dialogScope.rebort_onClick =function(){
                        dialogScope.conditionForm.billsDateFrom = "";
                        dialogScope.conditionForm.billsDateTo = "";
                        dialogScope.conditionForm.debtEndFrom = "";
                        dialogScope.conditionForm.debtEndTo = "";
                        dialogScope.conditionForm.billsNo = "";
                        dialogScope.conditionForm.billsType = "";
                        dialogScope.$apply();
                    }
                    //点击查询之后的搜索
                    dialogScope.submit_onClick =function(){
                        dialogScope.queryTable();
                    };
                    //查询操作
                    dialogScope.queryTable = function(paramData){
                        var data= {
                            pageNo: dialogScope.conf.pageNo,
                            pageSize: dialogScope.conf.pageSize,
                            value:dialogScope.conditionForm,
                            bcpDatasource:bcpDatasource,
                        };
                        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoForPRegister",data);
                        promise.then(function(res){
                            var data;
                            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                                data = res.contextData;
                                /*for(var x in bcpDatasource){
                                    for(var y in data.records){
                                        if(bcpDatasource[x].billsNo == data.records[y].billsNo){
                                            var n=0;
                                            for(var z in dialogScope.selected.select){
                                                if(bcpDatasource[x].billsNo ==dialogScope.selected.select[z].billsNo){
                                                    n=n+1;
                                                }
                                            }
                                            if(n==0){
                                                dialogScope.selected.select.push(data.records[y]);
                                            }
                                        }
                                    }
                                }*/
                                dialogScope.datasource.ds = data.records;
                                dialogScope.conf.totalRecord =data.totalRecord;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    };
                    /* 确定按钮*/
                    dialogScope.confirm_onClick=function(){
                        if(dialogScope.selected.select.length == 0){
                            $common.get_tipDialog("请选择数据！",'showError');
                        }else{
                            for(var x in dialogScope.selected.select){
                                $scope.bcpDatasource.ds.push(dialogScope.selected.select[x])
                            }
                            var data1=$scope.bcpDatasource.ds;
                            var debtNum=0;//争议总份数
                            var amount=0;//争议总金额
                            for(var x in data1){
                                if(data1[x].rebateAmounts){
                                    amount=amount+parseFloat(data1[x].rebateAmounts);
                                }else{
                                    data1[x].rebateAmounts=0;
                                    data1[x].rebatebalance=data1[x].remainingAmount;
                                }
                                debtNum=debtNum+1;
                            }
                            $scope.cntDebtInfoForm.debtNum=debtNum;
                            $scope.cntDebtInfoForm.amount=amount;
                            $scope.bcpDatasource.ds=data1;
                            $scope.bcpConf.totalRecord=debtNum;
                            $scope.bcpSelected.select=[];
                            dialogScope.closeThisDialog();
                        }
                    };
                    dialogScope.back_onClick = function(){
                        dialogScope.closeThisDialog();
                    }
                }],"添加凭证信息",{showClose:true});
        }
    };
    //修改票据信息
    $scope.update_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showError');
        }else{
            var pageUrl;
            if(window.appNo){
                pageUrl="../../rec_bcp_mdle/html/impairment/modifyRBcpDebtBase.html"
            }else{
                pageUrl='impairment/modifyRBcpDebtBase.html'
            }
            var row=$scope.bcpSelected.select[0];
            $common.get_ngDialog(pageUrl, $scope
                ,["$scope",function(dialogScope){
                    /*modifyPoolImpairControl(dialogScope,$scope,$common,dataDeliver,$state,row);*/
                    if(!row.rebateAmounts){
                        row.rebateAmounts=0.00;
                    }
                    if(!row.loanPercent){
                        row.loanPercent=0;
                    }
                    var rebateAmounts1=parseFloat(row.rebateAmounts);//原来的
                    if(!row.rebatebalance){
                        row.rebatebalance=row.remainingAmount;
                    }
                    if(!row.rebateAmount){
                        row.rebateAmount=0.00;
                    }
                    dialogScope.otherform=$common.copy(row);
                    var errorFlag=true;
                    function checkFormRule(){
                        var rebateAmounts=parseFloat(dialogScope.otherform.rebateAmounts);
                        var remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);
                        if(rebateAmounts <= 0){
                            $common.get_tipDialog('减值金额需大于零！','showError');
                            errorFlag=false;
                        }else{
                            if(rebateAmounts > remainingAmount ){
                                $common.get_tipDialog('减值金额不可大于应收账款余额！','showError');
                                errorFlag=false;
                            }
                        }
                    }

                    dialogScope.rebateAmounts_onBlur= function (){
                        var remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);
                        var rebateAmounts=parseFloat(dialogScope.otherform.rebateAmounts);
                        if(rebateAmounts <= 0){
                            $common.get_tipDialog('减值金额需大于零！','showError');
                            errorFlag=false;
                        }else if(rebateAmounts > remainingAmount){
                            $common.get_tipDialog('减值金额不可大于应收账款余额！','showError');
                            errorFlag=false;
                        }else{
                            dialogScope.otherform.rebatebalance=remainingAmount-rebateAmounts;
                            dialogScope.$apply();
                        }
                    }
                    dialogScope.save_onClick = function(){
                        if($.doValidate("otherform")){
                            checkFormRule();
                            if(errorFlag){
                                //$scope.bcpDatasource.ds=[];
                                var selected = $scope.bcpSelected.select[0];
                                var dsArray = $scope.bcpDatasource.ds;
                                var amount=parseFloat($scope.cntDebtInfoForm.amount);
                                var rebateAmounts2=parseFloat(dialogScope.otherform.rebateAmounts);//现在的
                                $scope.cntDebtInfoForm.amount=amount+rebateAmounts2-rebateAmounts1;
                                for (var i = 0; i < dsArray.length; i++) {
                                    if (dsArray[i].id == selected.id) {
                                        $scope.bcpDatasource.ds[i]=$common.copy(dialogScope.otherform);
                                    }
                                }
                                $scope.bcpSelected.select=[];
                                dialogScope.closeThisDialog();
                            }
                        }
                    }
                    dialogScope.back_onClick = function(){
                        dialogScope.closeThisDialog();
                    }
                }],"应收账款减值明细信息",{showClose:true});
        }
    };
    //删除票据信息
    $scope.del_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var selected = $scope.bcpSelected.select[0];
            var dsArray = $scope.bcpDatasource.ds;
            for (var i = 0; i < dsArray.length; i++) {
                if (dsArray[i].id == selected.id){
                    $scope.bcpDatasource.ds.splice(i, 1);
                    //debtNum,amount
                    var debtNum=parseFloat($scope.cntDebtInfoForm.debtNum);
                    $scope.cntDebtInfoForm.debtNum=debtNum-1;
                    $scope.bcpConf.totalRecord=debtNum-1;
                    $scope.cntDebtInfoForm.amount=parseFloat($scope.cntDebtInfoForm.amount)-selected.rebateAmounts;
                }
            }
            $scope.bcpSelected.select=[];
        }
    }
    //返回按钮
    $scope.back_onClick = function(){
        $state.go("impairConList");
    }
    //保存按钮
    $scope.save_onClick= function(){
        if($.doValidate("cntDebtInfoForm")){//实际上这里还需要再去后台检验下客户名称和客户号是否一致 todo!!!!
            if($scope.bcpDatasource.ds.length ==0){
                $common.get_tipDialog('请添加减值应收账款列表信息！', 'showError');
                return false;
            }else{
                for(var k in $scope.bcpDatasource.ds){
                    if(!$scope.bcpDatasource.ds[k].rebateAmounts || $scope.bcpDatasource.ds[k].rebateAmounts=="0.00"){
                        var msg ="凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+"减值金额不能为零！";
                        $common.get_tipDialog(msg, 'showError');
                        return false;
                    }
                }
            }
            $scope.cntDebtInfoForm.poolBailAmount=0.00;//实际上的池保证金余额就是0.00
            var processModel = {
                modelId: 'AllowanceApply',
                ProcessName: '应收账款融资减值申请',
                NodeId: 'Write',
                startedUserId: userInfo.tlrNo,
                bizId :'',
                bizData: [
                    appno = "",
                    $scope.cntDebtInfoForm.custcdSaller,
                    $scope.cntDebtInfoForm.cnameSeller,
                    'AllowanceApply',
                    "",
                ]
            };
            var data={
                DebtBussInfoVO:$scope.cntDebtInfoForm,
                RBcpAppliBussDtl:$scope.bcpDatasource.ds,
                processModel:processModel,
            }
            var primise=$common.get_asyncData("iRBcpImpairmentService/ImpairApplySaveUpdate",data);
                primise.then(function(res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                        $scope.cntDebtInfoForm.appno=res.contextData.appno;
                            $scope.disable1=false;//提交按钮显示
                        $scope.disable2=true;//买方客户名称只读
                    } else {
                        $common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
                    }
                });
            }
        }

    //点击提交操作 commit，修改下通知书和申请基本信息表
    $scope.submit_onClick=function(){
        if($.doValidate("cntDebtInfoForm")){//实际上这里还需要再去后台检验下客户名称和客户号是否一致 todo!!!!
            if($scope.bcpDatasource.ds==[]){
                $common.get_tipDialog('请添加减值应收账款列表信息！', 'showError');
                return false;
            }else{
                for(var k in $scope.bcpDatasource.ds){
                    if(!$scope.bcpDatasource.ds[k].rebateAmounts || $scope.bcpDatasource.ds[k].rebateAmounts=="0.00"){
                        var msg ="凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+"减值金额不能为零！";
                        $common.get_tipDialog(msg, 'showError');
                        return false;
                    }
                }
            }
            $scope.cntDebtInfoForm.poolBailAmount=0.00;//实际上的池保证金余额就是0.00
            var data={
                DebtBussInfoVO:$scope.cntDebtInfoForm,
                RBcpAppliBussDtl:$scope.bcpDatasource.ds,
            }
            var primiseX = $common.get_asyncData("iRBcpImpairmentService/impairApplySubmit",data);
            primiseX.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('流程提交成功！', 'showSuccess');
                    if ($state.current.name == "bsystasktab.AllowanceApply") {
                        $state.go("bsystask");
                    } else {
                        $state.go("impairConList");
                    }
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    }
}

