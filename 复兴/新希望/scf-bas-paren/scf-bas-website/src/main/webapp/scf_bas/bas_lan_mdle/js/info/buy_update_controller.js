/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var buyInfoUpdateController = function(dialogScope,parentScope,$common,dataDeliver,flag,row,appno) {
	var data = parentScope.selected.select[0];
	var tradeContno = data.tradeContno;
	var tradeContcode = data.tradeContcode;
	var startDate = data.startDate;
	var endDate = data.endDate;
	var amt = data.contAmt;
	var totAmt = data.accuLoanAmt;
	var loanAmt = data.loanAmt;

	dialogScope.otherform.tradeContno = tradeContno
	dialogScope.otherform.tradeContcode = tradeContcode;
	dialogScope.otherform.startDate = startDate;
	dialogScope.otherform.endDate = endDate;
	dialogScope.otherform.contAmt = amt;
	dialogScope.otherform.accuLoanAmt = totAmt;
	dialogScope.otherform.loanAmt = loanAmt;
	//点击确认触发按钮--添加到父页面上面
	dialogScope.confirm_onClick=function(){
		if($.doValidate("otherform")) {//校验数据格式
			var loanAmt = Number(dialogScope.otherform.loanAmt);//本次出账金额
			var contAmt = Number(dialogScope.otherform.contAmt);//合同金额
			var accuLoanAmt = Number(dialogScope.otherform.accuLoanAmt);//累计出账金额
			if(loanAmt>(contAmt-accuLoanAmt))
			{
				$common.get_tipDialog('“本次出账金额”必须小于等于（合同金额-累计出账金额）', 'showInform');
				return false;
			}
			var plist = parentScope.datasource.ds;
			for (var i = 0; i < plist.length; i++) {
				if (plist[i].tradeContno == data.tradeContno) {
					parentScope.datasource.ds[i] = $common.copy(dialogScope.otherform);
					var dataa = dialogScope.selected.select = [];
					dialogScope.closeThisDialog();
				}
			}
		}
	}
	//关闭dialog窗口
	dialogScope.closeThisDialog_onClick = function(){
		dialogScope.closeThisDialog();
	}
};
