/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var BussChooseController =  function(dialogScope,parentScope,$common,dataDeliver,$state,row){
    var debtInfo;
    dialogScope.otherform={//初始化账户
        //下列这些字段都是用于之后的应收账款信息表中的字段
        cnameSeller:"",//卖方客户名称
        cnameBuyer:"",//买方客户名称
        custcdBuyer:"",//买方客户号
        custcdSaller:"",//卖方客户号
        bussTypeName:"",//业务品种名称
        bussType:"",//业务品种对应额产品号
        mastContno:"",//业务合同号
        billsType:"",//凭证类型
        curcd:"",//币种
        aging:"",//账期
        gracePeriod:"",//宽限期
    };
    //卖方客户查询
    dialogScope.sellerContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        param:{creditFlag:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
         split:"",//分隔符*/
        extentColumn:"cname",
        column:["cname"]//展示内容
    };
    dialogScope.sellerExtent = function(ds){
        dialogScope.otherform.custcdSaller=ds.custcd;
    };
    //监听事件 ！功能简述1.当卖方客户名称，发生改变，并且点击查询按钮，则再次重新查询两个表
    dialogScope.$watch("otherform.cnameSeller",function(){//一旦改变开始查询业务合同
        if(dialogScope.otherform.cnameSeller == ""){//如果卖方客户名称为空，则卖方那个客户号也是空
            dialogScope.otherform.custcdSaller="";
        }
        dialogScope.sellerContent.param ={
            creditFlag:"1",//授信客户
            cname:dialogScope.otherform.cnameSeller,
        }
    });

    //获得之前得到的卖方客户号去查询  业务合同号，业务品种名称和id，对应的合同的币种
        //业务合同号查询 debtContno，debtContnoContent，debtContnoExtent
       dialogScope.debtContnoContent = {
            type:"table",//展示类型table  tree
            url:"bCntDebtInfoService/selectBCntDebtInfoByPage",//请求url
            param:{custcd:dialogScope.otherform.custcdSaller,financingType:"2"},
            split:"",//分隔符*/
            extentColumn:"debtContno",
            column:["debtContno"]//展示内容
        };
        dialogScope.debtContnoExtent = function(ds){
            debtInfo=ds;
            dialogScope.otherform.bussType=ds.supplyChainPdId;//业务种类对应的产品号
            if(ds.supplyChainPdId=="1230040"){//国内保理池
                dialogScope.otherform.factType='8';
            }else if(ds.supplyChainPdId=="1230050"){//应收账款质押池
                dialogScope.otherform.factType='7';
            }else if(ds.supplyChainPdId=="1230060"){//出口退税池
                dialogScope.otherform.factType='9';
            }
            dialogScope.otherform.bussTypeName=ds.bussTypeName;//对应的业务种类名称
            dialogScope.otherform.curcd=ds.curcd;//该业务合同对应的币种

        };
        //业务合同监听事件（卖方）
        dialogScope.$watch("otherform.cnameSeller+otherform.mastContno",function(){
            if(dialogScope.otherform.custcdSaller ==""){//卖方客户号为空，业务合同号也为空
                dialogScope.otherform.mastContno="";
            }
            dialogScope.debtContnoContent.param ={
                custcd:dialogScope.otherform.custcdSaller,
                financingType:"2",//融资模式为池融资
                //factType:"8",//应收账款
                contStatus:"01",//有效合同
                debtContno:dialogScope.otherform.mastContno,//业务合同号
                mgrnoNm:"1"//仅限本用户新增的合同才可以显示
            }
        });

        //买方客户查询
        dialogScope.buyerContent = {
            type:"table",//展示类型table  tree
            url:"bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
            param:{coreFlag:"1",businessNo:dialogScope.otherform.mastContno},
            split:"",//分隔符*/
            extentColumn:"buyerName",
            column:["buyerName"]//展示内容
        };
        dialogScope.buyerExtent = function(ds){
            dialogScope.otherform.custcdBuyer=ds.buyerCustcd;//获得买方客户号
            dialogScope.otherform.aging=ds.loanDays;//获得账期
            dialogScope.otherform.gracePeriod=ds.debtGraceDays;//获得宽限期
            dialogScope.otherform.loanPercent=ds.loanPercent;//融资比例
        };
        dialogScope.$watch("otherform.mastContno+otherform.buyerContent",function(){
            /*if(dialogScope.otherform.mastContno=""){
                dialogScope.otherform.custcdBuyer="";
                dialogScope.otherform.cnameBuyer="";
            }*/
            dialogScope.buyerContent.param ={
                coreFlag:"1",//必须是核心客户号
                businessNo:dialogScope.otherform.mastContno,//将之前查处的业务合同号传参
                buyerName:dialogScope.otherform.cnameBuyer,//买方名称
            }
        });

    //点击之后，跳转传值。(查重，去重。)
    dialogScope.confirm_onClick=function(){
        if($.doValidate("otherform")){
            if(dialogScope.otherform.custcdBuyer == dialogScope.otherform.custcdSaller){
                $common.get_tipDialog("买卖双方不能为一个客户！",'showError');
            }else{
                dialogScope.otherform.startDate=debtInfo.startDate;//合同生效日
                dialogScope.otherform.endDate=debtInfo.endDate;//合同到期日
                dialogScope.otherform.contAmount=debtInfo.contAmount//合同额度
                dialogScope.otherform.loanWay=debtInfo.loanWay//出账方式
                //dialogScope.otherform.factType=debtInfo.factType//保理类型
                var data1= dialogScope.otherform;
                dataDeliver.setter(data1);
                $state.go("bcpInfoAdd");
                dialogScope.closeThisDialog();
            }
        }
    }
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};
