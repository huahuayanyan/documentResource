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
    var bcpDatasource=$common.copy(row.bcpDatasource);
    var mastContno=row.debtInfo.mastContno;
    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
        custcdSaller:row.debtInfo.custcdSaller,//卖方客户号
        mastContno:mastContno,//业务合同号
        custcdBuyer:row.debtInfo.custcdBuyer,//买方客户号
        lockAppno:row.debtInfo.appno,
        factType:"8",//应收账款池融资
        poolFlag:'1',//必须是池内的
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
        totalRecord: 0}

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
            bcpDatasource:bcpDatasource,
        };
        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoForPRegister",data);
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
    /* 确定按钮*/
    dialogScope.confirm_onClick=function(){
        if(dialogScope.selected.select.length == 0){
            $common.get_tipDialog("请选择数据！",'showError');
        }else{
            for(var x in dialogScope.selected.select){
                parentScope.bcpDatasource.ds.push(dialogScope.selected.select[x]);
            }
            var data1=parentScope.bcpDatasource.ds;
            var debtNum=0;//争议总份数
            var amount=0;//争议总金额
            for(var x in data1){
                if(data1[x].money){
                    amount=amount+parseFloat(data1[x].money);
                }else{
                    data1[x].money=0;
                }
                debtNum=debtNum+1;
            }
            parentScope.cntDebtInfoForm.debtNum=debtNum;
            parentScope.cntDebtInfoForm.amount=amount;
            parentScope.bcpDatasource.ds=data1;
            parentScope.bcpConf.totalRecord=debtNum;
            parentScope.bcpSelected.select=[];
            dialogScope.closeThisDialog();
        }
    };
    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    }
};
