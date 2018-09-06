/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var BcpBaseInfoController =  function(dialogScope,parentScope,$common,dataDeliver,$state,row){
    dialogScope.otherform=row;
    if(!dialogScope.otherform.loanPercent)
    {
        dialogScope.otherform.loanPercent = "0.00";
    }
    if(!dialogScope.otherform.remainingUseableAmount)
    {
        dialogScope.otherform.remainingUseableAmount = "0.00";
    }
    //融资模式
	 var financingType  =dataDeliver.getter();
     if(financingType=="2"){ //2-池融资
    	 //隐藏字段 融资比率，可融资余额
    	 dialogScope.poolhide =true;
     }
};
