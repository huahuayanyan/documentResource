/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var ProgressController = function(dialogScope,parentScope,$common,dataDeliver,$state,data1) {
    var debtId="";
    if(data1.rBcpDebtBaseInfo.appno){//如果传过来的信息有申请号，就应该用对应的debtId字段
        debtId=data1.rBcpDebtBaseInfo.debtId;
    }else{
        debtId=data1.rBcpDebtBaseInfo.id;//应收账款基本信息ID
    }
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
    var　rBcpDebtBussDtl={debtId:debtId};
    //查询操作
    dialogScope.queryTable = function(paramData){
        var data= {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            value:rBcpDebtBussDtl,
        };
        var promise = $common.get_asyncData("rBcpDebtBussDtlService/findRBcpDebtBussDtlPageByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                dialogScope.datasource.ds = data.records;
                dialogScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
//back
    dialogScope.back_onClick=function(){
        dialogScope.closeThisDialog();
    }
};
