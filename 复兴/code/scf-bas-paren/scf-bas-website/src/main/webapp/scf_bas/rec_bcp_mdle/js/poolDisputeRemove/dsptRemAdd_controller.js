/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var dsptRemAddController = function($scope,$common,dataDeliver,$state,$stateParams,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    var debtInfo=dataX.debtInfo;
    $scope.otherform={};
    $scope.otherform.ext2='应收账款池融资商业纠纷登记解除申请';
    //页面经办机构信息
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
    //争议应收账款列表初始化
    $scope.bcpDatasource={ds:[]};
    $scope.bcpSelected ={select:[]};
    $scope.bcpConf= {
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //disable为false,disable1为true,此时买方客户名称是可以修改的，提交按钮是只读的
    $scope.disable=false;
    $scope.disable1=true;

    var mastContno=debtInfo.mastContno//业务合同号
    $scope.cntDebtInfoForm =debtInfo;
    //争议日期	（为发起日期）
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
    //买方客户查询
    $scope.buyerContent = {
        type:"table",//展示类型table  tree
        url:"bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
        param:{coreFlag:"1",businessNo:mastContno},
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
            cnameBuyer=ds.buyerCustcd
        }
    };
    $scope.$watch("cntDebtInfoForm.cnameBuyer",function(){
        $scope.buyerContent.param ={
            coreFlag:"1",//必须是核心厂商
            businessNo:mastContno,//将之前查处的业务合同号传参
            buyerName:$scope.cntDebtInfoForm.cnameBuyer,//买方名称
        }
    });

    //页面几个字段的回显 totalDebtRemainAmount，poolRiskAmt，bailAcctNo， 池敞口的相关信息计算的数据源
    $scope.$watch("bcpConf.pageNo",function(){
        //如果是从单据信息页面跳转过来的，则不需要再重新去后台查询
        if( !dataX.bcpDatasource){//如果没有对应数据说明是第一次跳转过来
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
                    $scope.cntDebtInfoForm.debtNum=0;
                    $scope.cntDebtInfoForm.amount=0;
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
            $common.get_ngDialog('debtPoolTransfer/bcp_base_info_list.html', $scope
                ,["$scope",function(dialogScope){
                    BcpBaseInfoController(dialogScope,$scope,$common,dataDeliver,$state,row);
                }],"添加凭证信息",{showClose:true});
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
                    if(debtNum-1 <= 0){
                        $scope.cntDebtInfoForm.debtNum=0;
                        $scope.bcpConf.totalRecord=0;
                        $scope.cntDebtInfoForm.amount=0;
                    }else{
                        $scope.cntDebtInfoForm.debtNum=debtNum-1;
                        $scope.bcpConf.totalRecord=debtNum-1;
                        $scope.cntDebtInfoForm.amount=parseFloat($scope.cntDebtInfoForm.amount)-selected.money;
                    }
                    $scope.$apply();
                }
            }
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
    //返回按钮
    $scope.back_onClick = function(){
        $state.go("debtPoolConList");
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
                $scope.cntDebtInfoForm.factType ="8";
                $scope.cntDebtInfoForm.poolBailAmount=0.00;//实际上的池保证金余额就是0.00
                var processModel = {
                    modelId: 'DisputePoolInvoicRemoveApply',
                    ProcessName: '应收账款池融资商业纠纷登记解除申请',
                    NodeId: 'Write',
                    startedUserId: userInfo.tlrNo,
                    bizId :'',
                    bizData: [
                        appno = "",
                        $scope.cntDebtInfoForm.custcdSaller,
                        $scope.cntDebtInfoForm.cnameSeller,
                        'DisputePoolInvoicRemoveApply',
                        "",
                    ]
                };
                var data={
                    DebtBussInfoVO:$scope.cntDebtInfoForm,
                    rBcpDebtBussDtl:$scope.bcpDatasource.ds,
                    processModel:processModel,
                }
                var primise=$common.get_asyncData("rBcpPoolDisputeRemoveService/PoolDisputeRemoveApplySaveUpdate",data);
                    primise.then(function(res) {
                        if (res.errorCode == "SUC") {
                            $common.get_tipDialog('保存成功！', 'showSuccess');
                            var data3 = {
                                appno: res.contextData.appno,
                            };
                            dataDeliver.setter(data3);
                            $state.go("dsptRemAddApply");
                        } else {
                            $common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
                        }
                    });
            }else{//还要将flag还原
                flag=true;
            }
            }
        }
}

