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
    $scope.otherform.ext2='应收账款融资商业纠纷登记解除申请';
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

    //关联的融资信息
    $scope.datasource={ds:[]};
    $scope.selected ={select:[]};
    $scope.conf= {
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
    $scope.cntDebtInfoForm.debtNum=0;//争议总份数
    $scope.cntDebtInfoForm.amount=0;//争议总金额

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
    $scope.buyerExtent = function(ds){
        $scope.cntDebtInfoForm.custcdBuyer=ds.buyerCustcd;//获得买方客户号
        $scope.cntDebtInfoForm.cnameBuyer=ds.buyerName;//获得买方客户号
        //当买方客户改变时，下面的票据信息要清空
        if(ds !="" && ds.buyerCustcd != cnameBuyer){
           //两个表的数据要清空
            $scope.bcpDatasource.ds=[];
            $scope.datasource.ds=[];
            cnameBuyer=ds.buyerCustcd
        }
    };
    $scope.$watch("cntDebtInfoForm.cnameBuyer",function(){
        $scope.buyerContent.param ={
            coreFlag:"1",//必须是核心厂商
            businessNo:mastContno,//将之前查处的业务合同号传参
            buyerName:$scope.cntDebtInfoForm.cnameBuyer//买方名称
        }
    });

    //关联融资信息
    $scope.queryTableLnci = function(paramData)
    {
        if($scope.cntDebtInfoForm.debetNo==undefined||$scope.cntDebtInfoForm.debetNo==null||
            $scope.cntDebtInfoForm.debetNo==""||!$scope.cntDebtInfoForm.debetNo)
        {
            $scope.datasource.ds = [];
            $scope.conf.totalRecord = 0;
        }
        else
        {
            var data= {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                appliBussInfo:$scope.cntDebtInfoForm
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
   //--------------------------------------------点击事件------------------------------------//
// add,update,del,progress,save,submit,back
    //添加票据信息
    $scope.add_onClick = function(){
        if($.doValidate("cntDebtInfoForm")) {//校验买方客户是否已填
            var row={
                debtInfo:$scope.cntDebtInfoForm,
                bcpDatasource:$scope.bcpDatasource.ds
            }
            $common.get_ngDialog('debtPoolTransfer/bcp_base_info_list.html', $scope
                ,["$scope",function(dialogScope){
                    BcpBaseInfoController(dialogScope,$scope,$common,dataDeliver,$state,row);
                }],"编辑凭证信息",{showClose:true});
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
            var debetNo = "";
            for(var k in $scope.bcpDatasource.ds){
                var debet = $scope.bcpDatasource.ds[k];
                if(debet.debetNo)
                {
                    debetNo = debetNo + debet.debetNo+"/f";
                }
            }
            $scope.cntDebtInfoForm.debetNo = debetNo;
            $scope.queryTableLnci();
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
        $state.go("debtConList");
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
                        'DisputeInvoicRemoveApply',
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
            }else{
                flag=true;
            }
            }
        }
}

