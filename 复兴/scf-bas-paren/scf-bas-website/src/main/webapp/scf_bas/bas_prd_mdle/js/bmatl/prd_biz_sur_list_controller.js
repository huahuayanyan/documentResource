/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PrdBizSurListController = function($scope,$common,$state,dataDeliver) {
    $scope.conditionForm={};
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
   /* //点击刷新之后的搜索
    $scope.fresh_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };*/
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bPrdBizSurService/findBPrdBizSurByPage",data);
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
    //新增应收材料信息 新增的时候只要传过去一个flag就行了。
    $scope.add_onClick = function(){
        var row={};
        $common.get_ngDialog('bmatl/prd_biz_sur_add.html', $scope
            ,["$scope",function(dialogScope){
                PrdBizSurAddController(dialogScope,$scope,$common,"add",row);
            }],"业务调查材料信息新增",{showClose:true});

    };

    //应收材料信息删除 根据ID
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
            var id = $scope.selected.select[0].id;//定义选中组件的组件id
            var primiseA = $common.get_asyncData('bPrdBizSurService/delete', {id: id})
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
    };

    //修改操作
        $scope.update_onClick = function(){
            var row ={};
            if($scope.selected.select.length == 1){
                $common.get_ngDialog('bmatl/prd_biz_sur_add.html', $scope
                    ,["$scope",function(dialogScope){
                        PrdBizSurAddController(dialogScope,$scope,$common,"update",row);
                    }],"业务调查材料信息修改",{showClose:true});
            }else{
                $common.get_tipDialog('请选择一条记录！','showInform');
            }
        };
    //应收材料信息查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('bmatl/prd_biz_sur_add.html', $scope
            ,["$scope",function(dialogScope){
                PrdBizSurAddController(dialogScope,$scope,$common,"view",row);
            }],"查看业务调查材料信息",{showClose:true});
    }
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.matlName = "";
        $scope.conditionForm.matlType = "";
        $scope.queryTable();
    }
}
