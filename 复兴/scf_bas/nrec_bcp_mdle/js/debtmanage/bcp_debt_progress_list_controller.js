/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var DebtInfoProgressController = function($scope,$common,$state,dataDeliver) {
    var data1=dataDeliver.getter();
    var debtId="";
    if(data1.rBcpDebtInfo.appno){//如果传过来的信息有申请号，就应该用对应的debtId字段
        debtId=data1.rBcpDebtInfo.debtId;
    }else{
        debtId=data1.rBcpDebtInfo.id;//应收账款基本信息ID
    }
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    var rBcpDebtBussDtl={debtId:debtId};
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            rBcpDebtBussDtl:rBcpDebtBussDtl
        };
        var promise = $common.get_asyncData("nrbcpDebtBussDtlService/findRBcpDebtBussDtlPageByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
//back
    $scope.back_onClick=function(){
        var flag = data1.flag;
        var url = "bcpInfoList";
        if(flag=="contview") {
            url = "debt";
            dataDeliver.setter(data1.baseinfo);
        }
        $state.go(url);//返回首页面
    }
};
