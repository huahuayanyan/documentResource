/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var disputeRemoveApplyController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    var appno=dataX.debtInfo.appno;
    var seq=dataX.debtInfo.seq;
    if(seq == "1"){//第一个节点，所有的按钮可以显示
        $scope.hide=false;
    }else{//第二个节点，所有按钮隐藏
        $scope.hide=true;
    }

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

    //页面数据源
    $scope.$watch("bcpConf.pageNo",function(){
        //加载页面信息， cntDebtInfoForm，bcpDatasource
        var rBcpAppliBussInfo={
            appno:appno
        }
        var promise = $common.get_asyncData("rBcpAppliBussInfoService/findBcpAppliBussInfoByKey",{rBcpAppliBussInfo:rBcpAppliBussInfo});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.cntDebtInfoForm = res.contextData;
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
                        //关联的融资信息
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
                        })
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    });

    //--------------------------------------------点击事件------------------------------------//
// add,update,del,progress,save,submit,back
    //添加票据信息
    $scope.add_onClick = function(){
        if($.doValidate("cntDebtInfoForm")) {//校验买方客户是否已填
            var row={
                debtInfo:$scope.cntDebtInfoForm,
                bcpDatasource:$scope.bcpDatasource.ds,
            }
            $common.get_ngDialog('debtPoolTransfer/bcp_base_info_list.html', $scope
                ,["$scope",function(dialogScope){
                    BcpBaseInfoController(dialogScope,$scope,$common,dataDeliver,$state,row);
                }],"编辑凭证信息",{showClose:true});
        }else{
            $common.get_tipDialog('请选择买方客户！', 'showError');
        }
    };
    //修改票据信息
    $scope.update_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showError');
        }else{
            var row=$scope.bcpSelected.select[0];
            $common.get_ngDialog('poolDisputeRemove/dsptBillModify.html', $scope
                ,["$scope",function(dialogScope){
                    dsptBillModifyController(dialogScope,$scope,$common,dataDeliver,$state,row);
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
                if (dsArray[i].id == selected.id) {
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
            $common.get_ngDialog('manage/bcp_progress_list.html', $scope
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
                    if(!$scope.bcpDatasource.ds[k].reason || $scope.bcpDatasource.ds[k].reason==""){
                        msg =msg+"凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+" 争议解决方式不能为空！"+"\n";
                        $common.get_tipDialog(msg, 'showError');
                        msg="";
                        flag=true;
                        return false;
                    }
                }
            }
            if(flag){//保存操作
                $scope.cntDebtInfoForm.factType ="1";
                var processModel = {
                    modelId: 'DisputeInvoicRemoveApply',
                    ProcessName: '应收账款融资商业纠纷登记解除申请',
                    NodeId: 'Write',
                    startedUserId: userInfo.tlrNo,
                    bizId :'',
                    bizData: [
                        appno = "",
                        $scope.cntDebtInfoForm.custcdSaller,
                        $scope.cntDebtInfoForm.cnameSeller,
                        'DisputeInvoicRemoveApply'
                    ]
                };
                var data={
                    DebtBussInfoVO:$scope.cntDebtInfoForm,
                    rBcpDebtBussDtl:$scope.bcpDatasource.ds,
                    // processModel:processModel,
                }
                var primise=$common.get_asyncData("rBcpPoolDisputeRemoveService/PoolDisputeRemoveApplySaveUpdate",data);
                primise.then(function(res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
                    }
                });
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
                    if(!$scope.bcpDatasource.ds[k].reason || $scope.bcpDatasource.ds[k].reason==""){
                        msg =msg+"凭证编号 "+$scope.bcpDatasource.ds[k].billsNo+" 争议解决方式不能为空！"+"\n";
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
                    rBcpDebtBussDtl:$scope.bcpDatasource.ds,
                }
                var primiseX = $common.get_asyncData("rBcpPoolDisputeRemoveService/DisputeInvoiceRemoveApplyWriteSubmitUpdate",data);
                primiseX.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('流程提交成功！', 'showSuccess');
                        //跳到主页列表页面
                        $scope.hide=true
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }
        }
    }
};
