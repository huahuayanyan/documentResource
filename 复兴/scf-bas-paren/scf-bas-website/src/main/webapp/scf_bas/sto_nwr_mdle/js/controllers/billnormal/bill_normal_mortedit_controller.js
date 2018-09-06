/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var billNormalmorteditController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    dialogScope.mortgageInfo = {};
    dialogScope.billnormal = parentScope.billnormal;
    if(flag=="add")
    {
    }
    else if(flag=="update")
    {
        dialogScope.mortgageInfo = $common.copy(parentScope.selected.select[0]);
    }
    else if(flag=="view")
    {
        dialogScope.mortgageInfo = $common.copy(parentScope.selected.select[0]);
        dialogScope.disable = true;
        dialogScope.confirm = true;
    }
    parentScope.selected.select = [];
    dialogScope.mortgageInfo.curcd = "CNY";
    dialogScope.mortgageInfo.billno = dialogScope.billnormal.billno;//仓单号
    dialogScope.mortgageInfo.billType = dialogScope.billnormal.billType;//仓单类型
    dialogScope.mortgageInfo.custcd = dialogScope.billnormal.custcd;//出质人
    dialogScope.mortgageInfo.slaveContno = dialogScope.billnormal.slaveContno;//抵质押合同号
    //查询押品一级
    dialogScope.mortgageLevelOneSource = {
        ds:[]
    };
    dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
        dialogScope.mortgageLevelOneSourceList(1);
        if(dialogScope.mortgageInfo.mortgageLevelOne)
        {
            var dataItemsDO = {mortgageCode:dialogScope.mortgageInfo.mortgageLevelOne}
            var data = {dataItemsDO:dataItemsDO};
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }
    });
    dialogScope.mortgageLevelOneSourceList = function(level)
    {
        //业务品种下拉框
        var dataItemsDO = {levels:level};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                dialogScope.mortgageLevelOneSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    //押品二级
    dialogScope.mortgageLevelTwoSource = {
        ds:[]
    };
    dialogScope.mortgageLevelOneName = function (val){
        dialogScope.mortgageInfo.mortgageLevelTwo = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val}
            var data = {dataItemsDO:dataItemsDO};
            var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
            mortgageName.then(function(res){
                if(res.errorCode =="SUC"){
                    dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            dialogScope.mortgageLevelTwoSource.ds = [];
        }
    }
    //押品三级
    dialogScope.mortgageLevelThreeSource = {
        ds:[]
    };
    dialogScope.mortgageLevelTwoName = function (val){
        dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val}
            var data = {dataItemsDO:dataItemsDO};
            var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
            mortgageName.then(function(res){
                if(res.errorCode =="SUC"){
                    dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            dialogScope.mortgageLevelThreeSource.ds = [];
        }
    };
    dialogScope.quantity_onBlur = function()
    {
        checkTotalPrice();
    }
    dialogScope.confirmPrice_onBlur = function()
    {
        checkTotalPrice();
    }
    function checkTotalPrice()
    {
        var quantity = 0;
        var confirmPrice = 0;
        if(dialogScope.mortgageInfo.quantity)
        {
            quantity = Number(dialogScope.mortgageInfo.quantity);
        }
        if(dialogScope.mortgageInfo.confirmPrice)
        {
            confirmPrice = Number(dialogScope.mortgageInfo.confirmPrice);
        }
        dialogScope.$apply(
            dialogScope.mortgageInfo.totPrice = quantity*confirmPrice
        )
    }
    dialogScope.confirm_onClick = function(){
        if($.doValidate("mortgageInfo")) {
            dialogScope.mortgageInfo.flag = flag;
            $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageSaveUpdate",{mortgageBaseVO:dialogScope.mortgageInfo}).then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog("保存成功",'showSuccess');
                    dialogScope.closeThisDialog();
                    dialogScope.queryTable();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    dialogScope.cancel_onClick = function () {
        dialogScope.closeThisDialog();
    };
    //表格--------结束-------------------------
};
