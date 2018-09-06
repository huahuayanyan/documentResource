/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var bicrinfosubController = function(dialogScope,parentScope,$common,flag) {
    dialogScope.subform= {
        //初始化金额
        creditAmount:0.00,
        creditUsableAmount:0.00,
        usedAmount:0.00,
        frzAmount:0.00

    };
    dialogScope.datasource={//初始化表格对象
        ds:[
        ]
    };
    dialogScope.selected={//初始化对象
        select: []
    };

    dialogScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听额度总金额
   /* dialogScope.$watch("subform.creditAmount",function(){
        dialogScope.subform.creditUsableAmount= dialogScope.subform.creditAmount;

    });
*/
    //额度总金额 失去焦点
    dialogScope.creditAmount_onBlur = function(){
        dialogScope.subform.creditUsableAmount= dialogScope.subform.creditAmount;
    };
    function genSerialNo(param){
        var data ={
            serialCode:param
        };
        var promise=$common.get_asyncData("bSysSerialNoService/genSerialNo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.subform.creditNo=data.value;
               // return data.value;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //分项额度筛选
    dialogScope.creditTypeContent = {
        type:"table",//展示类型table  tree
        url:"bIcrTypeService/selectBIcrType",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"creditName",
        column:["creditType","creditName"]//展示内容
    };
    dialogScope.creditNamedooextent = function(ds){
        dialogScope.subform.creditType=ds.creditType;
    };
    dialogScope.$watch("otherform.creditName",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        dialogScope.creditTypeContent.param ={
            creditName:dialogScope.subform.creditName,
            creditClass:"3" //间接额度
        }
    });
    //额度信息

   // if(parentScope.flag=="add"){ //额度新增
        if(flag == "add"){ //分项额度新增
            genSerialNo("CREDIT_TYPE_NO");
            dialogScope.subform=$common.copy(parentScope.otherform);
            dialogScope.selectbrNo.ds  = parentScope.selectbrNo.ds;
            dialogScope.subform.brNo= parentScope.otherform.brNo;
            //初始化金额
            dialogScope.subform.creditAmount="0.00";
            dialogScope.subform.creditUsableAmount="0.00";
            dialogScope.subform.usedAmount="0.00";
            dialogScope.subform.frzAmount="0.00";
            dialogScope.subform.remark="";
        }else if (flag == "update"){ //分项额度修改
            dialogScope.subform=$common.copy(parentScope.subCreditselected.select[0]);
            dialogScope.selectbrNo.ds  = parentScope.selectbrNo.ds;
            dialogScope.subform.brNo= parentScope.otherform.brNo;
        }
    /*else{ //额度修改
        if(flag == "add"){ //分项额度新增
            genSerialNo("CREDIT_TYPE_NO");
            //初始化金额
            dialogScope.subform.creditAmount="0.00";
            dialogScope.subform.creditUsableAmount="0.00";
            dialogScope.subform.usedAmount="0.00";
            dialogScope.subform.frzAmount="0.00";
        }else if (flag == "update"){ //分项额度修改
            selectInfoOrUp();
        }
    }*/
    function selectInfoOrUp(){
        var data ={
            creditNo:parentScope.subCreditselected.select[0].creditNo
        };
        var promise=$common.get_asyncData("bIcrInfoService/findBIcrInfoOrUpByCreditNo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.subform=data;
                dialogScope.selectbrNo.ds =data.listBctl;
                dialogScope.subform.brNo=data.brcode;
                dialogScope.brNoDisable =true;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //选择机构
    dialogScope.selectOrg_onClick = function(){
        $common.get_ngDialog('bicrinfo/selectOrg.html',parentScope
            ,["$scope",function(selectScope){
            	selectOrgController(selectScope,dialogScope,parentScope,$common,"query");
            }],"机构列表",{showClose:true});
    };
    dialogScope.confirm_onClick = function(){
        if($.doValidate("subform")) {
            var upCreditAmount =parseFloat(dialogScope.subform.upCreditAmount);
            if(parseFloat(dialogScope.subform.creditAmount)<= 0){
                $common.get_tipDialog('分项额度总额需大于0！','showInform');
                dialogScope.subform.creditAmount=0.00;
                return false;
            }
            if(parseFloat(dialogScope.subform.creditAmount)>upCreditAmount){
                $common.get_tipDialog('分项额度总额不能大于额度总额！','showInform');
                dialogScope.subform.creditAmount=0.00;
               return false;
            }
            var startDate=dialogScope.subform.startDate;
            if(startDate<parentScope.otherform.startDate || startDate > parentScope.otherform.endDate){
                $common.get_tipDialog('本分项额度生效日必须在间接额度区间内,请重新输入分项额度生效日！','showInform');
                return false;
            }
            var endDate=dialogScope.subform.endDate;

            if(endDate < parentScope.otherform.startDate || endDate >  parentScope.otherform.endDate){
                $common.get_tipDialog('本分项额度到期日必须在间接额度区间内,请重新输入分项额度到期日！','showInform');
                return false;
            }
        	/* parentScope.subCreditdatasource.ds.suitBrcode=dialogScope.subform.suitBrcode;
            parentScope.subCreditdatasource.ds.suitbrName=dialogScope.subform.suitbrName;*/
                var parentSubRecords = parentScope.subCreditdatasource.ds;
                for (i = 0; i < parentSubRecords.length;i++) {
                    var parentSubRecord = parentSubRecords[i];
                    var parentCreditType = parentSubRecord.creditType;
                    var p_s_startDate = parentSubRecord.startDate;
                    var p_s_endDate = parentSubRecord.endDate;
                    var p_s_creditNo = parentSubRecord.creditNo;
                    var creditType = dialogScope.subform.creditType;
                    var creditNo = dialogScope.subform.creditNo;
                    var startDate = dialogScope.subform.startDate;
                    var endDate = dialogScope.subform.endDate;
                    var creditType = dialogScope.subform.creditType;
                    var creditName = dialogScope.subform.creditName;


                    if(flag == "add") {
                        if (parentCreditType == creditType) {
                            if ((startDate >= p_s_startDate && startDate <= p_s_endDate) || (endDate >= p_s_startDate && endDate <= p_s_endDate) || (startDate >= p_s_startDate && endDate <= p_s_endDate)) {
                                var msg = "额度种类名称为【" + creditName + "】的额度在日期区间【" + startDate
                                    + "," + endDate + "】已存在有效或未提交的额度，请重新修改相应日期或额度种类名称";
                                $common.get_tipDialog(msg, 'showInform');
                                return false;
                            }
                        }
                    }else{
                        if (parentCreditType == creditType && p_s_creditNo != creditNo) {
                            if ((startDate >= p_s_startDate && startDate <= p_s_endDate) || (endDate >= p_s_startDate && endDate <= p_s_endDate) || (startDate >= p_s_startDate && endDate <= p_s_endDate)) {
                                var msg = "额度种类名称为【" + creditName + "】的额度在日期区间【" + startDate
                                    + "," + endDate + "】已存在有效或未提交的额度，请重新修改相应日期或额度种类名称";
                                $common.get_tipDialog(msg, 'showInform');
                                return false;
                            }
                        }
                    }
                }

            if(flag == "add"){
                //校验同一额度种类 的额度在日期区间下是否存在有效或未提交的额度
                //赋值到上一个页面的分项额度列表
                parentScope.subCreditdatasource.ds.push(dialogScope.subform);
            }else if (flag == "update"){
                //遍历已增加记录，修改相应的记录
                var dsArray = parentScope.subCreditdatasource.ds;
                var selected = parentScope.subCreditselected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].creditNo == selected.creditNo) {
                        parentScope.subCreditdatasource.ds[i] =$common.copy(dialogScope.subform)
                    }
                }
            }
        }else{
            $common.get_tipDialog('页面输入校验不通过，请检查！','showInform');
            return false;
        }
        dialogScope.closeThisDialog();

    };
    dialogScope.cancel_onClick = function(){
        dialogScope.closeThisDialog();
    };

    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};
