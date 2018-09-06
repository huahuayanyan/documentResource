/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var BcpBaseInfoController = function(dialogScope,parentScope,$common,dataDeliver,$state,row) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    var bcpDatasource=$common.copy(row.bcpDatasource);
    var mastContno=row.debtInfo.mastContno;
    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
        mastContno:mastContno,//业务合同号
        custcdBuyer:row.debtInfo.custcdBuyer,//买方客户名称
        custcdSaller:row.debtInfo.custcdSaller,
        lockAppno:row.debtInfo.appno,
        factType:row.debtInfo.factType//应收账款池融资
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

    //监听分页
    dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
        dialogScope.queryTable();
    });
    //重置按钮 cnameSeller，cnameBuyer，mastContno，bussType，billsDateFrom，billsDateTo，debtEndFrom，debtEndTo
   // billsType，billsNo，status
    dialogScope.rebort_onClick =function(){
        dialogScope.conditionForm.billsDateFrom = "";
        dialogScope.conditionForm.billsDateTo = "";
        dialogScope.conditionForm.debtEndFrom = "";
        dialogScope.conditionForm.debtEndTo = "";
        dialogScope.conditionForm.billsNo = "";
        dialogScope.conditionForm.billsType = "";
        dialogScope.$apply();
    }
    //点击查询之后的搜索
    dialogScope.submit_onClick =function(){
        dialogScope.queryTable();
    };
    //查询操作
    dialogScope.queryTable = function(paramData){
        var data= {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            value:dialogScope.conditionForm,
            bcpDatasource:bcpDatasource
        };
        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoPageForTransfer",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                dialogScope.datasource.ds = data.records;
                dialogScope.conf.totalRecord =data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //确定按钮
    dialogScope.confirm_onClick=function(){
        if(dialogScope.selected.select.length == 0){
            $common.get_tipDialog("请选择数据！",'showError');
        }else{
            for(var x in dialogScope.selected.select){
                parentScope.bcpDatasource.ds.push(dialogScope.selected.select[x]);
            }
            var data1=parentScope.bcpDatasource.ds;
            var totalDebtAmount=0;//转让/出质总金额
            var debtNum=0;//转让出质份数
            //计算票面金额的总额，计算费用。
            for(var k in data1){
               totalDebtAmount=totalDebtAmount+data1[k].billsAmountView;
               debtNum=debtNum+1;
            }
            //费用总额=固定费用+票面金额*费用比率/100（因为费用比率是%的）。
            parentScope.otherform.totalDebtAmount=totalDebtAmount;
            parentScope.otherform.debtNum=debtNum;
            parentScope.bcpConf.totalRecord=debtNum;
            //合同的费用收取方式按年时 费用空
            if(parentScope.costDatasource.ds.length>0){
                //计算方式为固定的时候，费用固定。
                if(parentScope.costDatasource.ds[0].costCalcType == "1"){
                    parentScope.otherform.totalFee=parentScope.costDatasource.ds[0].costAmt
                    parentScope.otherform.receiveAmount=parentScope.otherform.totalFee-parentScope.otherform.totalReduce;
                }else if(parentScope.costDatasource.ds[0].costCalcType == "2"){
                    parentScope.otherform.totalFee=totalDebtAmount*(parentScope.costDatasource.ds[0].costRate/100);
                    parentScope.otherform.receiveAmount=parentScope.otherform.totalFee-parentScope.otherform.totalReduce;
                }
                //费用表中的字段要和这个字段同步 费用小计和出质费用相同，减免金额,实收费用总额
                parentScope.costDatasource.ds[0].totalAmt=parentScope.otherform.totalFee;
                parentScope.costDatasource.ds[0].receiveAmount=parentScope.otherform.receiveAmount;
            }

            dialogScope.closeThisDialog();

        }
    };
    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    }
};
