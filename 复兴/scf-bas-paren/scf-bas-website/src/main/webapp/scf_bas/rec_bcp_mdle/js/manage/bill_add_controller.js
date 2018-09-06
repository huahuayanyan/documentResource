/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var BillAddController =  function(dialogScope,parentScope,$common,flag,row){
    //在这里新增完毕之后，数据加载到页面，页面新增应收账款信息的时候，直接将table里面的所有数据全部新增。
    //而不是在页面拼接，是在这里就已经全部存储完毕。
    if(flag == "update"){//修改操作 billForm
        dialogScope.billForm=$common.copy(parentScope.selected.select[0]);
    }else{//新增，只将币种赋值给对应的字段
        dialogScope.billForm={
            cnameSeller:row.cnameSeller,//卖方客户名称
            cnameBuyer:row.cnameBuyer,//买方客户名称
            custcdBuyer:row.custcdBuyer,//买方客户号
            custcdSaller:row.custcdSaller,//卖方客户号
            bussTypeName:row.bussTypeName,//业务品种名称
            bussType:row.bussType,//业务品种对应额产品号
            mastContno:row.mastContno,//业务合同号
            billsType:row.billsType,//凭证类型
            curcd:row.curcd,//币种
            aging:parseFloat(row.aging),//账期
            gracePeriod:row.gracePeriod,//宽限期
            bussContcode:row.bussContcode,//业务合同号
            memo:row.memo,//备注
            factType:row.factType,//业务类别
            loanPercent:row.loanPercent,//融资比例
            billsNo:"",//凭证编号
            billsDate:"",//billsDate应收账款日期
            debtEnd:"",//应收账款到期日
            deadline:"",//最迟付款日
            billsAmountView:"",//票面金额
            billsAmount:"",//有效金额
        }
    }
    //billsNo，凭证编号，billsDate，应收账款日期，debtEnd，应收账款到期日，deadline，最迟付款日，billsAmountView，票面金额，billsAmount，有效金额
    //billsDate.setDate(billsDate.getDate()+parseInt(value));获得的时间参数的加值,aging:aging,//账期  gracePeriod:gracePeriod,//宽限期
    //凭证编号重复录入检验（页面凭证编号离焦事件，这里只是对应页面上的，后台还要校验。
    dialogScope.billsNo_onBlur=function(){//凭证编号到前台查重
        if(flag != "update"){
            if(dialogScope.billForm.billsNo != ""){
                var datasource=parentScope.datasource.ds;//取到前台table的数据，如果为空，直接过，没有则需要遍历对比判断。
                if(datasource != ""){
                    for(var k in datasource){
                        if(datasource[k].billsNo == dialogScope.billForm.billsNo ){
                            $common.get_tipDialog("该凭证编号已存在!",'showError');
                        }
                    }
                }
            }
        }
    }

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
    var sysDate="" + y + m + d;//当前日期s
    var sysDate1=parseFloat(sysDate)
    //应收账款日期离焦之后，将对应的应收账款到期日，最迟付款日自动填充

    dialogScope.billForm.startDate=row.startDate;//合同生效日
    dialogScope.billForm.endDate=row.endDate;//合同到期日
    var debtEnd;
    var endDate;
    var billsDate;
    dialogScope.billsDate_onBlur=function(){
        if(dialogScope.billForm.billsDate != ""){
            //应收账款到期日=应收账款日期+账期
            billsDate=dialogScope.billForm.billsDate;
            var dateMilli=new Date(billsDate.replace(/^(\d{4})(\d{2})(\d{2})$/,'$1/$2/$3')).getTime();
            var dayMilli=(row.aging)*24*60*60*1000;
            var dateMilliAndDayMilli=dateMilli+dayMilli;
            var date = new Date(dateMilliAndDayMilli);
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            if(m < 10){
                m = "0" + m;
            }
            if(d < 10){
                d = "0" + d;
            }
            dialogScope.billForm.debtEnd="" + y + m + d;
            debtEnd=parseFloat(dialogScope.billForm.debtEnd);//应收账款到期日
            endDate=parseFloat(dialogScope.billForm.endDate);//合同到期日
            //最迟付款日=应收账款日期+账期+宽限期
            var dateMilliAndDayMilli2=dateMilliAndDayMilli+(row.gracePeriod)*24*60*60*1000;
            var date2 = new Date(dateMilliAndDayMilli2);
            var y2 = date2.getFullYear();
            var m2 = date2.getMonth() + 1;
            var d2 = date2.getDate();
            if(m2 < 10){
                m2 = "0" + m2;
            }
            if(d2 < 10){
                d2 = "0" + d2;
            }
            dialogScope.billForm.deadline="" + y2 + m2 + d2;
            dialogScope.$apply();
        }else{//应收账款日为空，其他两个也是空
            dialogScope.billForm.debtEnd="";
            dialogScope.billForm.deadline="";
            dialogScope.$apply();
        }
    }
    //票面金额填写完毕，会自动复制赋值给有效金额，这里默认将应收账款余额等同于票面金额，三者相等
    dialogScope.billsAmountView_onBlur=function(){
        if(dialogScope.billForm.billsAmountView != ""){
            dialogScope.billForm.billsAmount=dialogScope.billForm.billsAmountView;
            dialogScope.$apply();
        }
    }
    //当客户修改有效金额，会与票面金额做对比，不可大于票面金额
    var billsAmount;
    var billsAmountView;
    dialogScope.billsAmount_onBlur=function(){
        if(dialogScope.billForm.billsAmount != ""){
            billsAmount =parseFloat(dialogScope.billForm.billsAmount);//有效金额
            billsAmountView=parseFloat(dialogScope.billForm.billsAmountView) ;//票面金额
            if(billsAmount > billsAmountView){
                $common.get_tipDialog("应收账款有效金额不能大于票面金额！",'showError');
            }else{
                dialogScope.billForm.remainingAmount=dialogScope.billForm.billsAmount;
            }
        }
    }
    //页面规则校验
    var errorflag=false;
    var errorMessage="";
    function checkFormRule(){
        // 页面存在三个教校验规则
        //1.凭证编号查重
        var datasource=parentScope.datasource.ds;//取到前台table的数据，如果为空，直接过，没有则需要遍历对比判断。
        if(flag != "update"){
            if(datasource != []){
                for(var k in datasource){
                    if(datasource[k].billsNo == dialogScope.billForm.billsNo ){
                        errorflag=true;
                        errorMessage=errorMessage+"该凭证编号已存在!";
                    }
                }
            }
        }

        //2.日期
        if(!errorflag){
            if(billsDate>sysDate1){
                errorflag=true;
                errorMessage=errorMessage+"应收账款日期须小于等于当前日期！" ;
            }else{
                if(endDate < debtEnd){
                    errorflag=true;
                    errorMessage=errorMessage+"应收账款到期日须小于等于合同到期日！" ;
                }else{
                    if(debtEnd <= sysDate1){
                        errorflag=true;
                        errorMessage=errorMessage+"应收账款到期日须大于当前日期！" ;
                    }
                }
            }
        }
        //3.金额
        if(billsAmount > billsAmountView){
            errorflag=true;
            errorMessage=errorMessage+"应收账款有效金额不能大于票面金额！" ;
        }else{
            dialogScope.billForm.remainingAmount=dialogScope.billForm.billsAmount;
            var loanPercent=parseFloat(row.loanPercent);
            dialogScope.billForm.remainingUseableAmount=parseFloat(dialogScope.billForm.billsAmount)*loanPercent/100;
        }
    }
    //点击确定，将对应的值插入前一个页面的table中
        dialogScope.confirm_onClick=function(){
            if($.doValidate("billForm")){
              //如果是修改，则需要将对应页面的那条先删除，再新增
                checkFormRule();
                if(errorflag){
                    $common.get_tipDialog(errorMessage,'showError');
                    errorflag=false;
                    errorMessage="";
                }else{
                    if(flag == "update"){
                        var dsArray = parentScope.datasource.ds;
                        var selected = parentScope.selected.select[0];
                        for (var i = 0; i < dsArray.length; i++) {
                            if (dsArray[i].billsNo == selected.billsNo) {
                                parentScope.datasource.ds.splice(i, 1);
                                parentScope.selected.select = [];
                            }
                        }
                        parentScope.datasource.ds.push(dialogScope.billForm);
                        parentScope.conf.totalRecord= parentScope.datasource.ds.length;
                        dialogScope.closeThisDialog();
                    }else if(flag == "add"){
                        parentScope.datasource.ds.push(dialogScope.billForm);
                        parentScope.conf.totalRecord= parentScope.datasource.ds.length;
                        dialogScope.closeThisDialog();
                    }
                }
            }
        }
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};
