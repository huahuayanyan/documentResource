/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2017/02/20
 */
var billEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.applitask = $scope.source.applitask;
    $scope.lnconform = $scope.source.lnconform;
    var appno;
    if(window.appNo)
    {
        appno = window.appNo;
        $scope.hideButton = true;
    }
    else
    {
        appno = $scope.lnconform.appno;
        $scope.hideButton = false;
    }
    if(!$scope.lnconform.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
    }
    if($scope.lnconform.bailAmount==0)
    {
        $scope.lnconform.bailAmount = "0.00";
    }
    $scope.taskform = $scope.source.taskform;
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.Write = false;
        $scope.approve = true;
        $scope.confirm = true;
        $scope.end = true;
        $scope.backHide = true;
    }
    else
    {
        $scope.hide = true;
        if($scope.taskform.id == "Write")
        {//填写
            $scope.Write = false;
            $scope.approve = true;
            $scope.Confirm = true;
            $scope.end = true;
            $scope.backHide = true;
            $scope.hide = false;
        }
        else if($scope.taskform.id == "Approve")
        {//审批节点
            $scope.Write = true;
            $scope.approve = false;
            $scope.Confirm = true;
            $scope.end = true;
            $scope.backHide = false;
        }
        else if($scope.taskform.id== "confirm")
        {//复核
            $scope.Write = true;
            $scope.approve = true;
            $scope.Confirm = false;
            $scope.end = true;
            $scope.backHide = false;
        }
        else if($scope.taskform.id== "end")
        {//审批通过
            $scope.Write = true;
            $scope.approve = true;
            $scope.Confirm = true;
            $scope.end = false;
            $scope.backHide = false;
        }
        else
        {
            $scope.Write = true;
            $scope.approve = true;
            $scope.Confirm = true;
            $scope.end = true;
            $scope.backHide = true;
        }
    }
    //融资列表
    $scope.datasourcelnci={//初始化表格对象
        ds: []
    };
    $scope.selectedlnci={//初始化对象
        select: []
    };
    $scope.conflnci= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    $scope.$watch("conflnci.pageNo+conflnci.pageSize",function() {
        $scope.queryTablelnci();
    })
    $scope.queryTablelnci = function(paramData){
        var data= {
            pageNo: $scope.conflnci.pageNo,
            pageSize: $scope.conflnci.pageSize,
            bCrrLnConCash:$scope.lnconform
        };
        var promise = $common.get_asyncData("dismortgageBillService/DismortgageBillLnciGetter",data);
        promise.then(function(res){
            var lnci;
            if (res.errorCode =="SUC"){
                lnci = res.contextData;
                $scope.datasourcelnci.ds = lnci.records || [];
                $scope.conflnci.totalRecord = lnci.totalRecord;
                if(appno)
                {
                    var promise = $common.get_asyncData("dismortgageBillService/DismortgageBillApproveLnciGetter",data);
                    promise.then(function(res){
                        var chooseLnci;
                        if (res.errorCode =="SUC"){
                            chooseLnci = res.contextData;
                            var chooseLnciList = chooseLnci.records || [];
                            var newList = [];
                            for(var i=0;i<$scope.datasourcelnci.ds.length;i++)
                            {
                                var oldLnci = $scope.datasourcelnci.ds[i];
                                for(var j=0;j<chooseLnciList.length;j++)
                                {
                                    var lnci = chooseLnciList[j]
                                    if(oldLnci.debetNo==lnci.debetNo)
                                    {
                                        newList.push(oldLnci);
                                    }
                                }
                            }
                            $scope.selectedlnci.select = newList;
                            if(newList.length>0)
                            {
                                $scope.lnconform.debetNo = $scope.selectedlnci.select[0].debetNo;
                                $scope.queryTableCash();
                            }
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //保证金及现金等价物列表信息
    $scope.datasourcecash={//初始化表格对象
        ds: []
    };
    $scope.selectedcash={//初始化对象
        select: []
    };
    $scope.confcash= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    $scope.column = function(row)
    {
        if($scope.selectedlnci.select.length==0)
        {
            $scope.selectedlnci.select[0]=row;
            $scope.lnconform.debetNo = row.debetNo;
            $scope.queryTableCash();
        }
        else
        {
            if($scope.selectedlnci.select.length==1)
            {
                if($scope.selectedlnci.select[0]==row)
                {
                    $scope.selectedlnci.select = [];
                    $scope.selectedcash.select = [];
                    $scope.datasourcecash.ds = [];
                    $scope.confcash.totalRecord = 0;
                    $scope.selectedlnci.select[0].billsAmountView = 0;
                    $scope.lnconform.dismortBailAmount = 0;
                }
                else
                {
                    $common.get_tipDialog("只能选择一条借据",'showInform');
                }
            }
            else
            {
                $common.get_tipDialog("只能选择一条借据",'showInform');
            }
        }
    }
    $scope.queryTableCash = function(paramData){
        var data= {
            pageNo: $scope.confcash.pageNo,
            pageSize: $scope.confcash.pageSize,
            bCrrLnConCash:$scope.lnconform
        };
        var promise = $common.get_asyncData("dismortgageBillService/DismortgageBillwriteBillGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcecash.ds = data.records || [];
                $scope.confcash.totalRecord = data.totalRecord;
                for(var i=0;i<$scope.datasourcecash.ds.length;i++)
                {
                    var cash = $scope.datasourcecash.ds[i];
                    if(!cash.bailRate)
                    {
                        cash.bailRate = 0.00;
                    }
                    var bailRate = Number(cash.bailRate);
                    var bailAmount = Number(cash.bailAmount);
                    var value = bailAmount*bailRate/100;
                    cash.value = value;
                }
                if(appno)
                {
                    var promise = $common.get_asyncData("dismortgageBillService/DismortgageBillApproveBillGetter",{appno:appno});
                    promise.then(function(res){
                        var chooseCash;
                        if (res.errorCode =="SUC"){
                            chooseCash = res.contextData;
                            var chooseCashList = chooseCash.records || [];
                            var newList = [];
                            for(var i=0;i<chooseCashList.length;i++)
                            {
                                var cash = chooseCashList[i];
                                if(!cash.bailRate)
                                {
                                    cash.bailRate = 0.00;
                                }
                                var bailRate = Number(cash.bailRate);
                                var bailAmount = Number(cash.bailAmount);
                                var value = bailAmount*bailRate/100;
                                cash.value = value;
                                for(var j=0;j<$scope.datasourcecash.ds.length;j++)
                                {
                                    var oldCash = $scope.datasourcecash.ds[j];
                                    if(cash.bailRate==oldCash.bailRate&&cash.bailAccountno==oldCash.bailAccountno
                                        &&cash.bailType==oldCash.bailType&&cash.bailAmount==oldCash.bailAmount&&cash.debetNo==oldCash.debetNo
                                        &&cash.value==oldCash.value)
                                    {
                                        oldCash.accountType = cash.accountType;
                                        newList.push(oldCash);
                                    }
                                }
                            }
                            $scope.selectedcash.select = newList;
                            var dismortgageValue = 0;
                            for(var i=0;i<newList.length;i++)
                            {
                                var selectCash = newList[i];
                                var num = Number(selectCash.value);
                                dismortgageValue += num;
                            }
                            $scope.selectedlnci.select[0].billsAmountView = dismortgageValue;
                            $scope.lnconform.dismortBailAmount = dismortgageValue;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    $scope.cashColumn = function(row)
    {
        var list = $scope.selectedcash.select;
        var newlist = list;
        var oldLenght = newlist.length;
        for(var i=0;i<list.length;i++)
        {
            var cash = list[i];
            if(cash==row)
            {
                newlist.splice(i,1)
            }
        }
        var newLength = newlist.length;
        if(oldLenght==newLength)
        {
            newlist.push(row);
        }
        $scope.selectedcash.select = newlist;
        var dismortgageValue = 0;
        for(var i=0;i<newlist.length;i++)
        {
            var selectCash = newlist[i];
            var num = Number(selectCash.value);
            dismortgageValue += num;
        }
        $scope.selectedlnci.select[0].billsAmountView = dismortgageValue;
        $scope.lnconform.dismortBailAmount = dismortgageValue
    }
    $scope.edit_onClick = function()
    {
        if($scope.selectedcash.select.length != 1){
            $common.get_tipDialog('请选择一条现金等价物信息！','showInform');
        }else{
            $common.get_ngDialog("dismortgageBill/cash_edit.html", $scope
                ,["$scope",function(dialogScope){
                    dialogScope.cashadd = $scope.selectedcash.select[0];
                    dialogScope.save_onClick = function(){
                        if($.doValidate("cashadd")) {
                            dialogScope.closeThisDialog();
                            $scope.datasourcecash.ds = $common.copy($scope.datasourcecash.ds);
                            for(var j=0;j<$scope.datasourcecash.ds.length;j++){
                            		 $scope.datasourcecash.ds[j] =  $common.copy($scope.datasourcecash.ds[j]);
                            }
                            $scope.selectedlnci.select[0].billsAmountView = 0;
                            $scope.lnconform.dismortBailAmount = 0;
                        };
                    };
                }],"",{showClose:false});
        }
    }
    //提交审批
    $scope.submit_onClick = function()
    {
        if($scope.selectedlnci.select.length != 1)
        {
            $common.get_tipDialog("请选择一条借据！",'showError');
            return;
        }
        if($scope.selectedcash.select.length==0)
        {
            $common.get_tipDialog("请选择现金等价物！",'showError');
            return;
        }
        //判断解压用途及类型
        var billList = $scope.selectedcash.select;
        var billCountAmount = 0;
        for(var i=0;i<billList.length;i++)
        {
            var recordBill = billList[i];
            var num = Number(recordBill.value);
            billCountAmount += num;
            if(recordBill.accountType==null || recordBill.accountType==""){
                $common.get_tipDialog("字段[解押用途]内容不能为空！",'showError');
                return false;
            }
            if(recordBill.bailType=="01"&&(recordBill.accountType=="2"||recordBill.accountType=="3")){
                $common.get_tipDialog("现金等价物类型为存单，解押用途不能是贴现后还款或托收还款！",'showError');
                return false;
            }
            if(recordBill.bailType=="02"&&recordBill.accountType=="1"){
                $common.get_tipDialog("现金等价物为银票，解押用途不能为还款！",'showError');
                return false;
            }
        }
        var lnciCountAmount = 0;
        var lnciList = $scope.selectedlnci.select;
        for(var i=0;i<lnciList.length;i++)
        {
            var recordLnci = lnciList[i];
            if(recordLnci.billsAmountView!=null && recordLnci.billsAmountView!="" && !isNaN(recordLnci.billsAmountView)){
                var num = Number(recordLnci.billsAmountView);
                lnciCountAmount += num;
            }
        }
        if(billCountAmount!=lnciCountAmount){
            $common.get_tipDialog("借据解押金额必须和现金等价物金额相等！",'showError');
            return false;
        }
        $scope.WriteDisable = true;
        $scope.hideDisable = true;
        $scope.lnconform.mastContno = $scope.lnconform.appId;
        $scope.lnconform.custcd = $scope.lnconform.custId;
        $scope.lnconform.custId = null;
        $common.get_asyncData("dismortgageBillService/DismortgageBillWriteUpdater",{cont:$scope.lnconform,billList:$scope.selectedcash.select,lnciList:$scope.selectedlnci.select,isProcess:true}).then(function(res){
            var data ;
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('已提交！','showSuccess');
                if(window.appNo)
                {
                    $scope.Write = true;
                }
                else
                {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    //同意
    $scope.approveAgree_onClick = function()
    {
        $scope.approveDisable = true;
        $scope.backHideDisable = true;
        var primise = $common.get_asyncData("dismortgageBillService/DismortgageBillApproveUpdater",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('操作已完成','showSuccess');
                if(window.appNo)
                {
                    $scope.approve = true;
                    $scope.backHide = true;
                }
                else
                {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    $scope.confirmAgree_onClick = function()
    {
        $scope.ConfirmDisable = true;
        $scope.backHideDisable = true;
        var primise = $common.get_asyncData("dismortgageBillService/DismortgageBillConfirmUpdater",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('操作已完成','showSuccess');
                if(window.appNo)
                {
                    $scope.Confirm = true;
                    $scope.backHide = true;
                }
                else
                {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    $scope.endAgree_onClick = function()
    {
        $scope.endDisable = true;
        $scope.backHideDisable = true;
        var primise = $common.get_asyncData("dismortgageBillService/DismortgageBillPrintUpdater",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('操作已完成','showSuccess');
                if(window.appNo)
                {
                    $scope.end = true;
                    $scope.backHide = true;
                }
                else
                {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });;
    }
    //退回,直接返回上一节点，无相关业务操作
    $scope.BackToModify_onClick = function()
    {
        $scope.ReviewAgreedisable = true;
        $scope.BackToModifydisable = true;
        var primise = $common.get_asyncData("dismortgageBillService/DismortgageBillGoBackUpdater",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('已退回','showSuccess');
                if(window.appNo)
                {
                    $scope.approve = true;
                    $scope.Confirm = true;
                    $scope.end = true;
                    $scope.backHide = true;
                }
                else
                {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    $scope.back_onClick = function(){
        $state.go("list");
    };
	//表格--------结束-------------------------
};
