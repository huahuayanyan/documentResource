/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PrdInfoListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    $scope.conditionForm={
        productType:"002"//查询到产品小类的数据
    };
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
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.productName = "";
        $scope.conditionForm.productId = "";
        $scope.queryTable();
    }
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data1= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bPrdInfoService/selectBPrdInfoBySelect",data1);
        promise.then(function(res){
            var data2;
            if (res.errorCode =="SUC"){
                data2 = res.contextData;
                $scope.datasource.ds = data2.records;
                $scope.conf.totalRecord = data2.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //新增产品信息 新增的时候只要传过去一个flag就行了。
    $scope.add_onClick = function(){
        var data= {
            flag: "add",
            productId:""
        };
        $state.go("tree");
        dataDeliver.setter(data);
    };

    //产品信息删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                var productId1 = $scope.selected.select[0].productId;//定义选中客户的客户号
                var primiseA = $common.get_asyncData('bPrdInfoService/delete', {productId: productId1})
                primiseA.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            });
    }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    //产品信息修改操作
        $scope.update_onClick = function(){
            if($scope.selected.select.length == 1){
                var data= {
                    flag: "update",
                    productId:$scope.selected.select[0].productId,
                    productName:$scope.selected.select[0].productName
                };
                $state.go("tree");
                dataDeliver.setter(data);
            }else{
                $common.get_tipDialog('请选择一条记录！','showInform');
            }
        };
    //产品信息查看操作
  $scope.column = function(row){
        var data= {
            flag: "view",
            productId:row.productId,
            productName:row.productName,
        };
        $state.go("prdReportInfo");
        dataDeliver.setter(data);
    }

}
