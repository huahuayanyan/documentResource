/**
 * Filename: Description: Copyright: Copyright (c) 2013 Company: Shanghai
 * Huateng Software Systems Co., Ltd.
 *
 * @author yinyuling
 * @version 1.0 Create at: 2016/12/30
 */

var queryRBcpDebtBaseList = function(dialogScope,parentScope,$common,flag) {
    var debtContno = parentScope.otherform.mastContno;
    var custcdSaller = parentScope.otherform.custcdSaller; //卖方客户号
    //var cnameBuyer = (typeof(bData.buyerName) == 'undefined' ? "" : bData.buyerName);
    var custcdBuyer =parentScope.otherform.custcdBuyer;//买方客户号
    dialogScope.conditionForm = {
        mastContno: debtContno,
        custcdSaller:custcdSaller,
        custcdBuyer: custcdBuyer,
        isLocked: 0,
        status: "02,04",
        issueFlag: 0,
        poolFlag:0,
        remainingAmount: 0
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
        totalRecord: 0};
    dialogScope.$watch("conf.pageNo+conf.pageSize", function () {
        dialogScope.queryTable();
    });
    dialogScope.queryTable = function(paramData){
        var data= {
            pageNo: 1,
            pageSize:10,
            value: dialogScope.conditionForm
        };
        var promise = $common.get_asyncData("iRBcpWriteoffService/getInvoiceChargeOffAddQry",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//�����еľ������Ҫת��������
                data = res.contextData;
                dialogScope.datasource.ds = data.records;
                dialogScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };


    dialogScope.submit_onClick = function() {
        dialogScope.queryTable();
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
    dialogScope.confirm_onClick = function() {
        if(dialogScope.selected.select.length == 0) {
            $common.get_tipDialog("请选择数据！", 'showError');
            return false;
        }
        var selected=dialogScope.selected.select;
        var totalAmount=0;//催收总金额
        var totalNum=0;//催收份数
        //计算票面金额的总额，计算费用。
        for(var k in selected){
            totalAmount=parseFloat(totalAmount)+parseFloat(selected[k].remainingAmount);
            totalNum=totalNum+1;
        }
        parentScope.otherform.totalAmount=totalAmount;
        parentScope.otherform.totalNum=totalNum;
        //赋值到上一个页面
        parentScope.datasource.ds=[];
        parentScope.datasource.ds = $common.copy(dialogScope.selected.select);
        parentScope.$apply();
        dialogScope.closeThisDialog();

    };

    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    };
};
