/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var unableCoverPoolOpenAmtController = function($scope,$common,$state,dataDeliver) {
    var data1= dataDeliver.getter();
    $scope.conditionForm={};//初始化条件查询框
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //查询操作brName,brNo
    $scope.queryTable = function(paramData){
        var bussContno = $scope.conditionForm.bussContno;//池合同号
        var sellerName = $scope.conditionForm.sellerName;//卖方名称
        var startYj = $scope.conditionForm.startYj;//预警日期从
        var endYj = $scope.conditionForm.endYj;//预警日期到
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bWrnRiskOfInfoDetail:{bussContno: bussContno,sellerName: sellerName,startYj: startYj,endYj: endYj},
            flag: '1'
        };
        var promise = $common.get_asyncData("rWrnBaseInfoService/findWrnRiskOfInfoByCondition",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };


    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.billsNo = "";
        $scope.conditionForm.bussContcode = "";
        $scope.conditionForm.startYj = "";
        $scope.conditionForm.endYj = "";
        $scope.queryTable();
    }
};
