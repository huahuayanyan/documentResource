/**
 * Created by htrad0039 on 2017/1/7.
 */
var writeoffReceiptConFirm = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
        $scope.taskBaseInfo = {};
        $scope.baseInfo ={};
        $scope.writeoffInfo={};
        $scope.selectBuyerName={};
        $scope.otherReasonDisable=true;
        $scope.otherReasonMust= false;
        var processId=window.parent.processId;
        var modelId=window.parent.modelId;
        var appno = window.parent.appNo;

        init();

    function init(){
        $scope.rBcpDebtBase={
            ds:[
            ]
        };
        $scope.selected={
            select:[
            ]
        };
        //按钮初始�??
        initButton();
        initTaskBaseInfo();
        initBaseInfo();
        initWriteoffInfo();
        initBcpDebtBase();
        initSelectBuyerName();
    }
    function initButton(){
        var promise = $common.get_asyncData("iRBcpWriteoffService/getBPbcAppliBaseInfoStateByAppno",{"key":appno});
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData.value;
                if(data=="Y"){
                    $scope.buyerNameDisable=false;
                    $scope.writeoffReasonDisable=false;
                    $scope.addhide=false;
                    $scope.savehide=false;
                    $scope.submithide=false;
                    $scope.deletehide=false;
                }else{
                    $scope.buyerNameDisable=true;
                    $scope.writeoffReasonDisable=true;
                    $scope.addhide=true;
                    $scope.savehide=true;
                    $scope.submithide=true;
                    $scope.deletehide=true;
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

        var promise = $common.get_asyncData("iRBcpWriteoffService/queryBaseInfoTask", {"key": appno});
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.baseInfo = data;
                $scope.baseInfo.buyerName = data.buyerCd;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
    function initWriteoffInfo() {
        var hx = $common.get_asyncData("iRBcpWriteoffService/getWriteoffInfoByAppno", {"key": appno});
        hx.then(function (res) {
            var result;
            if (res.errorCode == "SUC") {
                var wrifs = {};
                result = res.contextData;
                    wrifs.writeoffDate = result.writeoffDate;
                    wrifs.writeoffCount = result.writeoffCount;
                    wrifs.writeoffAmount = result.writeoffAmount;
                    wrifs.writeoffReason = result.writeoffReason;
                    wrifs.otherReason = result.otherReason;
                    $scope.writeoffInfo = wrifs;
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
        var promise = $common.get_asyncData("iRBcpWriteoffService/findRBcpDebtBaseInfoPageByPage", data);
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.rBcpDebtBase.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
                $scope.submitDisable = false;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }



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
                            debugger
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
    $scope.writeoffReasonChange = function(val){
        writeoffReason =val;
        if('4'==val){
            $scope.otherReasonDisable=false;
            $scope.otherReasonMust='common.require';
        }else{
            $scope.otherReasonDisable=true;
            $scope.otherReasonMust= false;
            $scope.writeoffInfo.otherReason="";
        }
    };
    $scope.buyerNameChange = function(val){
        buyerName = val;
    };
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请�?�择�?条记�??','showInform');
        }else{
            debugger
            var id=$scope.selected.select[0].id;
            var appNo=appno;
            var remainingAmount=$scope.selected.select[0].remainingAmount;
            var writeoffCount= $scope.writeoffInfo.writeoffCount-1;
            var writeoffAmount= $scope.writeoffInfo.writeoffAmount-remainingAmount;
            var primise = $common.get_asyncData('iRBcpWriteoffService/deleterBcpDebtBasebyId',{id:id,appNo:appNo,writeoffCount:writeoffCount,writeoffAmount:writeoffAmount});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('删除成功!', 'showSuccess');
                    $scope.selected.select=[];
                    init();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    }
    $scope.save_onClick = function(){
        var data ={
            key:appno,
            baseInfo:$scope.baseInfo,
            writeoffInfo:$scope.writeoffInfo
        };
        if($scope.writeoffInfo.writeoffAmount<=0){
            $common.get_tipDialog("核销金额不能小于0，请添加应收账款单据!",'showError');
            return
        }
        var primise = $common.get_asyncData('iRBcpWriteoffService/saveWriteoffRequestInfoTask',data)
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                init();
                $common.get_tipDialog('保存成功!', 'showSuccess');

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    $scope.submit_onClick = function(){
        var data ={
            key:appno,
            baseInfo:$scope.baseInfo,
            writeoffInfo:$scope.writeoffInfo
        };
        var primise = $common.get_asyncData('iRBcpWriteoffService/submitWriteoffRequestInfoTask',data)
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                initButton();
                $common.get_tipDialog('提交成功!', 'showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
}

