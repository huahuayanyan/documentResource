/**
 * Filename: Description: Copyright: Copyright (c) 2013 Company: Shanghai
 * Huateng Software Systems Co., Ltd.
 * 
 * @author yinyuling
 * @version 1.0 Create at: 2016/12/30
 */

var getDebtBaseListForPoorImpair = function(dialogScope,parentScope,$common,dataDeliver,$state,row) {
    var bcpDatasource=$common.copy(row.bcpDatasource);
    var mastContno=row.debtInfo.mastContno;
    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
        isLocked:"0",//查询未锁定的票据信息
        custcdSaller:row.debtInfo.custcdSaller,//卖方客户号
        mastContno:mastContno,//业务合同号
        custcdBuyer:row.debtInfo.custcdBuyer,//买方客户号
        factType:"8",//应收账款池融资
        issueFlag:"0",//无商纠
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
            value:dialogScope.conditionForm
        };
        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseForImpair",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData.records;
                //除去parentScope页面已经有的单据信息
                for(var x in data){
                    for(var y in bcpDatasource){
                        if(bcpDatasource[y].appno){
                            if(data[x].id == bcpDatasource[y].debtId){
                                data.splice(x,1);
                            }
                        }else{
                            if(data[x].id == bcpDatasource[y].id){
                                data.splice(x,1);
                            }
                        }
                    }
                }
                dialogScope.selected.select=bcpDatasource;
                dialogScope.datasource.ds = data;
                dialogScope.conf.totalRecord = data.totalRecord;
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
            var data1=dialogScope.selected.select;
            var amount=0;//减值金额
            var debtNum=0;//减值总份数
            for(var k in data1){
                //如果没有对应的争议金额就默认为0，实际上没有争议金额应该直接报错
                if(!data1[k].rebateAmounts) {
                    data1[k].rebateAmounts=0.00
                    data1[k].rebatebalance=data1[k].remainingAmount;
                    debtNum=debtNum+1;
                }else{
                    amount=amount+data1[k].rebateAmounts;
                    debtNum=debtNum+1;
                }
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
