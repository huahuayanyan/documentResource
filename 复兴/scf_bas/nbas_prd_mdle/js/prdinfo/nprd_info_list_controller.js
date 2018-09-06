/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var NbasPrdInfoListController = function($scope,$common,$state,dataDeliver) {
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
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm={
            productType:"002"//查询到产品小类的数据
        };
        $scope.queryTable();
    };
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
            bPrdInfoVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("nbprdInfoService/findBPrdInfoByPage",data1);
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
    //新增
    $scope.add_onClick = function(){
        $scope.row = {};
        $scope.row.flag = "add";
        $state.go("prddtl");
        dataDeliver.setter($scope.row);
    };

    //修改
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = "update";
            $state.go("prddtl");
            dataDeliver.setter($scope.row);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = "view";
            $state.go("prddtl");
            dataDeliver.setter($scope.row);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //产品信息查看操作
  $scope.column = function(row)
  {
      row.flag = "view";
      $state.go("prddtl");
      dataDeliver.setter(row);
    }

};
