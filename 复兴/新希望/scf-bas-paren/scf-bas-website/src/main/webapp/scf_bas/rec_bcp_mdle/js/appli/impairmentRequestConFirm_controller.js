/**
 * Created by htrad0039 on 2017/1/7.
 */
var impairmentRequestConFirm = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
        $scope.taskBaseInfo = {};
        $scope.baseInfo ={};
        $scope.impairmentInfo={};
        $scope.selectBuyerName={};
        $scope.otherReasonDisable=true;
        $scope.otherReasonMust= false;
        $scope.appNohide=true;
        $scope.curcdhide=true;
        var processId=window.parent.processId;
        var modelId=window.parent.modelId;
        var appno = window.parent.appNo;

        init();

    function init(){
        $scope.rBcpDebtBase={
            ds:[
            ]
        };
        $scope.bLanLnciBase={
            ds:[
            ]
        };
        $scope.selected1={
            select:[
            ]
        };
        initButton();
        initSelectBuyerName();
        initTaskBaseInfo();
        initBaseInfo();
        initImpairmentInfo();
        initBcpDebtBase();
    }
    function initButton(){
        var promise = $common.get_asyncData("iRBcpImpairmentService/getBPbcAppliBaseInfoStateByAppno",{"key":appno});
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData.value;
                if(data=="Y"){
                    $scope.buyerNameDisable=false;
                    $scope.impairmentReasonDisable=false;
                    $scope.remarkDisable=false;
                    $scope.addhide=false;
                    $scope.modifyhide=false;
                    $scope.deletehide=false;
                    $scope.savehide=false;
                    $scope.submithide=false;

                }else{
                    $scope.buyerNameDisable=true;
                    $scope.impairmentReasonDisable=true;
                    $scope.remarkDisable=true;
                    $scope.addhide=true;
                    $scope.modifyhide=true;
                    $scope.deletehide=true;
                    $scope.savehide=true;
                    $scope.submithide=true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

    function initSelectBuyerName(){
        var sb=$common.get_asyncData("iRBcpWriteoffService/selectBuyerNameTask",{"key":appno});
        sb.then(function (res) {
            var result;
            if(res.errorCode=="SUC"){
                result = res.contextData;
                $scope.selectBuyerName.ds = result;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    function initTaskBaseInfo() {
        
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey", {"key": appno});
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                var taskinfo = {};
                taskinfo.flowName = data.processTemplateName;
                taskinfo.requestTime = data.appDate;
                taskinfo.opStaff = data.appTlrcd;
                taskinfo.opOrg = data.appBrcode;
                $scope.taskBaseInfo = taskinfo;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
    function initBaseInfo() {
        var promise = $common.get_asyncData("iRBcpImpairmentService/queryBaseInfoTask", {"key": appno});
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                if(data.isPool=='2'){
                    $scope.appNohide=false;
                    $scope.curcdhide=false;
                    document.getElementById("relInfo").style.display="none";
                }
                $scope.baseInfo = data;
                $scope.baseInfo.buyerName = data.buyerCd;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
    function initImpairmentInfo() {
        var hx = $common.get_asyncData("iRBcpImpairmentService/getImpairmentInfoByAppno", {"key": appno});
        hx.then(function (res) {
            var result;
            if (res.errorCode == "SUC") {
                var wrifs = {};
                result = res.contextData;
                    wrifs.impairmentDate = result.impairmentDate;
                    wrifs.impairmentCount = result.impairmentCount;
                    wrifs.impairmentAmount = result.impairmentAmount;
                    wrifs.impairmentReason = result.impairmentReason;
                    wrifs.remark = result.remark;
                    $scope.impairmentInfo = wrifs;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
   function initBcpDebtBase() {
       $scope.conf = {pageNo: 1, pageSize: 10, totalRecord: 0};
       var data = {
           pageNo: $scope.conf.pageNo,
           pageSize: $scope.conf.pageSize,
           key: appno
       };
       var promise = $common.get_asyncData("iRBcpImpairmentService/findRBcpDebtBaseInfoPageByPage", data);
       promise.then(function (res) {
           var data;
           if (res.errorCode == "SUC") {
               data = res.contextData;
               $scope.rBcpDebtBase.ds = data.records;
               $scope.conf.totalRecord = data.totalRecord;
               $scope.submitDisable = false;

               initInvoiceRelatedFinancing();
           } else {
               $common.get_tipDialog(res.errorMsg, 'showError');
           }
       });
   }

    function initInvoiceRelatedFinancing(){
        var debtno=[];
        var debtContno='';
        var count= $scope.rBcpDebtBase.ds.length;
        if(count>0){
        for(var i=0;i<count;i++){
            debtContno =$scope.rBcpDebtBase.ds[i].mastContno;
            if($scope.rBcpDebtBase.ds[i].status=='04'){
                debtno.push($scope.rBcpDebtBase.ds[i].debetNo);
            }
        }
        }
       if(debtno.length>0) {
           var data = {
               pageNo: 1,
               pageSize: 10,
               debtContno: debtContno,
               debtno: debtno
           };
           var promise = $common.get_asyncData("iRBcpImpairmentService/getLanLnciInfoByContno", data);
           promise.then(function (res) {
               var data;
               if (res.errorCode == "SUC") {
                   data = res.contextData;
                   $scope.bLanLnciBase.ds = data.records;
                   $scope.conf.totalRecord = data.totalRecord;
               } else {
                   $common.get_tipDialog(res.errorMsg, 'showError');
               }
           });
       }
    }
    $scope.modify_onClick = function(){
        if($scope.selected1.select.length != 1){
            $common.get_tipDialog('请选择一行!','showInform');
            return
        }else{
            $common.get_ngDialog('impairment/modifyRBcpDebtBase.html',$scope,["$scope",function(dialogScope){
                dialogScope.conditionForm={};
                var rebateAmounts=0;
                var rBcpDebtBases= $scope.selected1.select[0];
                //初始化
                dialogScope.conditionForm.billsNo=rBcpDebtBases.billsNo;
                dialogScope.conditionForm.billsType=rBcpDebtBases.billsType;
                dialogScope.conditionForm.insertDate=rBcpDebtBases.insertDate;
                dialogScope.conditionForm.purchaseDate=rBcpDebtBases.purchaseDate;
                dialogScope.conditionForm.billsDate=rBcpDebtBases.billsDate;
                dialogScope.conditionForm.aging=rBcpDebtBases.aging;
                dialogScope.conditionForm.debtEnd=rBcpDebtBases.debtEnd;
                dialogScope.conditionForm.curcd=rBcpDebtBases.curcd;
                dialogScope.conditionForm.billsAmount=rBcpDebtBases.billsAmount;
                dialogScope.conditionForm.remainingAmount=rBcpDebtBases.remainingAmount;
                dialogScope.conditionForm.loanPercent=rBcpDebtBases.loanPercent;
                dialogScope.conditionForm.loanRemainingAmount=rBcpDebtBases.loanRemainingAmount;
                dialogScope.conditionForm.rebateAmount=rBcpDebtBases.rebateAmount;
                dialogScope.conditionForm.rebateAmounts=rBcpDebtBases.rebateAmounts;
                dialogScope.conditionForm.rebatebalance=rBcpDebtBases.rebatebalance;
                dialogScope.conditionForm.status=rBcpDebtBases.status;

                dialogScope.ok_onClick = function(){
                    if(dialogScope.conditionForm.rebateAmounts<=0){
                        $common.get_tipDialog('减值金额不能小于0!','showInform');
                        return
                    };
                    if(dialogScope.conditionForm.rebateAmounts>dialogScope.conditionForm.remainingAmount){
                        $common.get_tipDialog('减值金额不能大于应收账款余额!','showInform');
                        return
                    };
                    for(var i=0;i<$scope.rBcpDebtBase.ds.length;i++){
                        if(rBcpDebtBases.billsNo==$scope.rBcpDebtBase.ds[i].billsNo){
                            $scope.rBcpDebtBase.ds[i].rebateAmounts=dialogScope.conditionForm.rebateAmounts;
                            $scope.rBcpDebtBase.ds[i].rebatebalance=parseInt($scope.rBcpDebtBase.ds[i].remainingAmount)-parseInt(dialogScope.conditionForm.rebateAmounts);
                        }

                    }

                    for(var i=0;i<$scope.rBcpDebtBase.ds.length;i++){
                        rebateAmounts+=parseInt($scope.rBcpDebtBase.ds[i].rebateAmounts);
                    }
                    $scope.impairmentInfo.impairmentAmount =rebateAmounts;

                    dialogScope.closeThisDialog();
                }

            }]);
        }
    };
    $scope.save_onClick = function(){
        var data ={
            key: appno,
            taskBaseInfo: $scope.taskBaseInfo,
            baseInfo:$scope.baseInfo,
            impairmentInfo:$scope.impairmentInfo,
            rBcpDebtBaseInfo: $scope.rBcpDebtBase.ds
        };
        if( $scope.rBcpDebtBase.ds.length<=0){
            $common.get_tipDialog("请添加减值应收账款单据！",'showError');
            return
        }

        for(var i=0;i< $scope.rBcpDebtBase.ds.length ;i++){
            if( $scope.rBcpDebtBase.ds[i].rebateAmounts<=0){
                $common.get_tipDialog("凭证编号【"+$scope.rBcpDebtBase.ds[i].billsNo+"】减值金额不能为空或者0！请录入相应减值金额！",'showError');
                return
            }
        }

        var primise = $common.get_asyncData('iRBcpImpairmentService/saveImpairmentRequestInfoTask',data)
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('保存成功！', 'showSuccess');
                $state.go("impairmentList");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    $scope.add_onClick = function() {
        if($.doValidate("taskBaseInfo")&&$.doValidate("baseInfo")) {
            $common.get_ngDialog('appli/writeoffTask.html',$scope,["$scope",function(dialogScope){
                dialogScope.conf = {pageNo: 1, pageSize: 10, totalRecord: 0};
                dialogScope.conditionForm = {
                    mastContno: $scope.baseInfo.debtContno,
                    cnameSellers: $scope.baseInfo.custName,
                    isLocked: 0,
                    status: "02,04",
                    issueFlag: 0,
                    remainingAmount: 0
                };
                dialogScope.$watch("conf.pageNo+conf.pageSize", function () {
                    dialogScope.query_onClick();
                });
                dialogScope.query_onClick = function(paramData){
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        value: dialogScope.conditionForm
                    };
                    var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoPageByPage",data);
                    promise.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){//����еľ����Ҫת��������
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records;
                            dialogScope.conf.totalRecord = data.totalRecord;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };
                dialogScope.rebort_onClick = function() {
                    dialogScope.conditionForm.billsDateFrom = "";
                    dialogScope.conditionForm.billsDateTo = "";
                    dialogScope.conditionForm.debtEndFrom = "";
                    dialogScope.conditionForm.debtEndTo = "";
                    dialogScope.conditionForm.billsNo = "";
                    dialogScope.conditionForm.billsType = "";
                    dialogScope.queryTable();
                };
                dialogScope.ok_onClick = function() {
                    var rBcpDebtBaseList=dialogScope.selected.select;
                    if (rBcpDebtBaseList.length>0){

                        var hx=$common.get_asyncData("iRBcpWriteoffService/saveRBcpDebtBaseInfoTask",{ "key":appno,"rBcpDebtBaseInfo":rBcpDebtBaseList});
                        hx.then(function (res) {
                            var result;
                            if(res.errorCode=="SUC"){


                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                    dialogScope.closeThisDialog();
                    init();
                };
                dialogScope.return_onClick = function(){
                    dialogScope.closeThisDialog();
                };

            } ]);
    }
    }

    $scope.buyerNameChange = function(val){
        buyerName = val;
    };
    $scope.delete_onClick = function(){
        if($scope.selected1.select.length != 1){
            $common.get_tipDialog('请选择一条记!','showInform');
        }else{
            var id=$scope.selected1.select[0].id;
            var appNo=appno;
            var rebateAmounts=$scope.selected1.select[0].rebateAmounts;
            var impairmentCount= $scope.impairmentInfo.impairmentCount-1;
            var impairmentAmount= parseInt($scope.impairmentInfo.impairmentAmount)-parseInt(rebateAmounts);
            var primise = $common.get_asyncData('iRBcpImpairmentService/deleterBcpDebtBasebyId',{id:id,appNo:appNo,impairmentCount:impairmentCount,impairmentAmount:impairmentAmount});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('删除成功!', 'showSuccess');
                    $scope.selected1.select=[];
                    init();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    }


    $scope.submit_onClick = function(){
        var data ={
            key: appno,
            taskBaseInfo: $scope.taskBaseInfo,
            baseInfo:$scope.baseInfo,
            impairmentInfo:$scope.impairmentInfo,
            rBcpDebtBaseInfo: $scope.rBcpDebtBase.ds
        };
        if( $scope.rBcpDebtBase.ds.length<=0){
            $common.get_tipDialog("请添加减值应收账款单据！",'showError');
            return
        }

        for(var i=0;i< $scope.rBcpDebtBase.ds.length ;i++){
            if( $scope.rBcpDebtBase.ds[i].rebateAmounts<=0){
                $common.get_tipDialog("凭证编号【"+$scope.rBcpDebtBase.ds[i].billsNo+"】减值金额不能为空或者0！请录入相应减值金额！",'showError');
                return
            }
        }

        var primise = $common.get_asyncData('iRBcpImpairmentService/submitImpairmentRequestInfoTask',data)
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('提交成功！', 'showSuccess');
                initButton();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
}

