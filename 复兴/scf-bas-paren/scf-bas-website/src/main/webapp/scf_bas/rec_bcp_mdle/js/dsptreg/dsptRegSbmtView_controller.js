/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var dsptRegViewController = function($scope,$common,dataDeliver,$state,$stateParams,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    var appno = window.appNo;
    //争议应收账款列表初始化
    $scope.bcpDatasource={ds:[]};
    $scope.bcpSelected ={select:[]};
    $scope.bcpConf= {
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    if(dataX.bcpDatasource){//不是页面首次登录，直接登录
        $scope.bcpDatasource.ds=dataX.bcpDatasource
        $scope.cntDebtInfoForm=dataX.debtInfo

    }
    //页面几个字段的回显 totalDebtRemainAmount，poolRiskAmt，bailAcctNo， 池敞口的相关信息计算的数据源
    $scope.$watch("bcpConf.pageNo",function(){
        //通过申请编号获得申请相关的信息
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform=res.contextData;
                var bCrmBrInfo={
                    brNo:res.contextData.startBrcode
                }
                var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
                promiseA.then(function(res1){
                    if(res1.errorCode =="SUC"){
                        $scope.otherform.tlrName=userInfo.tlrName;//经办人
                        $scope.otherform.brName=res1.contextData.brName;//经办机构
                    }else{
                        $common.get_tipDialog(res1.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        //如果是从单据信息页面跳转过来的，则不需要再重新去后台查询
        if( !dataX.bcpDatasource){//页面第一次进入
            //加载页面信息， cntDebtInfoForm，bcpDatasource
            var rBcpAppliBussInfo={
                appno:appno
            }
            var promise = $common.get_asyncData("rBcpAppliBussInfoService/findBcpAppliBussInfoByKey",{rBcpAppliBussInfo:rBcpAppliBussInfo});
            promise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.cntDebtInfoForm = res.contextData;
                    var promise2 = $common.get_asyncData("bCntDebtInfoService/findBCntDebtInfoByKey",{key:$scope.cntDebtInfoForm.mastContno});
                    promise2.then(function(res1){
                        if (res1.errorCode =="SUC"){
                            $scope.cntDebtInfoForm.bussTypeName=res1.contextData.bussTypeName
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
                            var dataQ= {
                                pageNo: $scope.bcpConf.pageNo,
                                pageSize: $scope.bcpConf.pageSize,
                                value:{appno:appno}
                            };
                            var promise = $common.get_asyncData("rBcpAppliBussDtlService/findRBcpAppliBussDtlPageByPage",dataQ);
                            promise.then(function(res){
                                if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                                    $scope.bcpDatasource.ds = res.contextData.records;
                                    $scope.bcpConf.totalRecord = res.contextData.totalRecord;
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

    });

    //--------------------------------------------点击事件------------------------------------//
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
            $common.get_ngDialog('../../rec_bcp_mdle/html/debtPoolTransfer/bcp_base_info_list.html', $scope
                ,["$scope",function(dialogScope){
                    var bcpDatasource=$common.copy(row.bcpDatasource);
                    var mastContno=row.debtInfo.mastContno;
                    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
                        custcdSaller:row.debtInfo.custcdSaller,//卖方客户号
                        mastContno:mastContno,//业务合同号
                        custcdBuyer:row.debtInfo.custcdBuyer,//买方客户号
                        factType:"1",//应收账款融资
                        lockAppno:row.debtInfo.appno,
                        issueFlag:"0",//商纠
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
                                $scope.bcpDatasource.ds.push(dialogScope.selected.select[x]);
                            }
                            var data1=$scope.bcpDatasource.ds;
                            var debtNum=0;//争议总份数
                            var amount=0;//争议总金额
                            for(var x in data1){
                                if(data1[x].money){
                                    amount=amount+parseFloat(data1[x].money);
                                }else{
                                    data1[x].money=0;
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
                }],"修改凭证信息",{showClose:true});
        }
    };
    //修改票据信息
    $scope.update_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showError');
        }else{
            var row=$scope.bcpSelected.select[0];
            $common.get_ngDialog('../../rec_bcp_mdle/html/pooldsptreg/pooldsptInvModf.html', $scope
                ,["$scope",function(dialogScope){
                    pooldsptInvModfController(dialogScope,$scope,$common,dataDeliver,$state,row);
                }],"修改凭证信息",{showClose:true});
        }
    };
    //删除票据信息
    $scope.del_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var selected = $scope.bcpSelected.select[0];
            var dsArray = $scope.bcpDatasource.ds;
            $scope.bcpSelected.select=[];
            for (var i = 0; i < dsArray.length; i++) {
                if (dsArray[i].billsNo == selected.billsNo) {
                    $scope.bcpDatasource.ds.splice(i, 1);
                    //debtNum,amount
                    var debtNum=parseFloat($scope.cntDebtInfoForm.debtNum);
                    $scope.cntDebtInfoForm.debtNum=debtNum-1;
                    $scope.bcpConf.totalRecord=debtNum-1;
                    $scope.cntDebtInfoForm.amount=parseFloat($scope.cntDebtInfoForm.amount)-selected.money;
                }
            }
            $scope.$apply();
        }
    }
    //查看历程信息
    $scope.progress_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var data={
                rBcpDebtBaseInfo:$scope.bcpSelected.select[0],
            }
            $common.get_ngDialog('../../rec_bcp_mdle/html/manage/bcp_progress_list.html', $scope
                ,["$scope",function(dialogScope){
                    ProgressController(dialogScope,$scope,$common,dataDeliver,$state,data);
                }],"单据历程信息",{showClose:true});
        }
    }

    //保存按钮
    var flag=true;
    var msg="";
    $scope.save_onClick= function(){
        if($.doValidate("cntDebtInfoForm")){//实际上这里还需要再去后台检验下客户名称和客户号是否一致 todo!!!!
            if($scope.bcpDatasource.ds.length == 0){
                flag =false;
                $common.get_tipDialog('请添加争议应收账款列表信息！', 'showError');
            }else{
                for(var k in $scope.bcpDatasource.ds){
                    if(!$scope.bcpDatasource.ds[k].issueReason || $scope.bcpDatasource.ds[k].issueReason==""){
                        msg =msg+"凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+" 争议原因不能为空！"+"\n";
                        $common.get_tipDialog(msg, 'showError');
                        msg="";
                        flag=true;
                        return false;
                    }else if(!$scope.bcpDatasource.ds[k].money || $scope.bcpDatasource.ds[k].money==""){
                        msg =msg+"凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+"争议金额不能为空！"+"\n";
                        $common.get_tipDialog(msg, 'showError');
                        msg="";
                        flag=true;
                        return false;
                    }
                }
            }

            if(flag){//保存操作
                $scope.cntDebtInfoForm.factType ="1";

                var data={
                    DebtBussInfoVO:$scope.cntDebtInfoForm,
                    RBcpAppliBussDtl:$scope.bcpDatasource.ds,
                    // processModel:processModel,
                }
                var primise=$common.get_asyncData("rBcpPoolDisputeRegisterService/poolDisputeRegisterApplySaveUpdate",data);
                primise.then(function(res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
                    }
                });
            }else{//将flag还原
                flag=true;
                msg="";
            }
        }
    }
    //点击提交操作 commit，修改下通知书和申请基本信息表
    $scope.submit_onClick=function(){
        if($.doValidate("cntDebtInfoForm")){//实际上这里还需要再去后台检验下客户名称和客户号是否一致 todo!!!!
            if($scope.bcpDatasource.ds.length == 0){
                flag =false;
                $common.get_tipDialog('请添加争议应收账款列表信息！', 'showError');
            }else{
                for(var k in $scope.bcpDatasource.ds){
                    if(!$scope.bcpDatasource.ds[k].issueReason || $scope.bcpDatasource.ds[k].issueReason==""){
                        msg =msg+"凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+" 争议原因不能为空！"+"\n";
                        $common.get_tipDialog(msg, 'showError');
                        msg="";
                        flag=true;
                        return false;
                    }else if(!$scope.bcpDatasource.ds[k].money || $scope.bcpDatasource.ds[k].money==""){
                        msg =msg+"凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+"争议金额不能为空！"+"\n";
                        $common.get_tipDialog(msg, 'showError');
                        msg="";
                        flag=true;
                        return false;
                    }
                }
            }
            if(flag){
                $scope.cntDebtInfoForm.factType ="1";

                var data={
                    DebtBussInfoVO:$scope.cntDebtInfoForm,
                    RBcpAppliBussDtl:$scope.bcpDatasource.ds,
                }
                var primiseX = $common.get_asyncData("rBcpPoolDisputeRegisterService/submitPoolDisputeRegister",data);
                primiseX.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('流程提交成功！', 'showSuccess');
                        //跳到主页列表页面
                        $state.go("bsystask");
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }else{
                flag=true;
                msg="";
            }
        }
    }
}

