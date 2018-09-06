/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var ftController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    $scope.conditionForm={};//初始化查询条件对象
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
    $scope.$watch("conf.pageNo+conf.pageSize",function(){$scope.queryTable()})

    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        //$scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){

        var data= {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                bSysChkCnfg:$scope.conditionForm
          };

         var promise = $common.get_asyncData("bSysChkCnfgService/findBSysChkCnfgByPage",data);
         promise.then(
             function(res){
                 var data;
                 if (res.errorCode =="SUC"){
                     data = res.contextData;
                     $scope.datasource.ds = data.records;
                     $scope.conf.totalRecord = data.totalRecord;
                 }else{
                     $common.get_tipDialog(res.errorMsg,'showError');
                 }
             }
         );
    };
    $scope.add_onClick = function(){
        //跳到会话框
        $common.get_ngDialog('ft/ftDialog.html', $scope
            ,["$scope",function(dialogScope){
                ftDialogController(dialogScope,$scope,$common,"add",dataDeliver);
            }],"新增操作",{showClose:false});
    };
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('ft/ftDialog.html',$scope
                ,["$scope",function(dialogScope){
                    ftDialogController(dialogScope,$scope,$common,"update",dataDeliver);
                }],"修改操作",{showClose:true});
        };
    };
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bSysChkCnfgService/delete',{key:$scope.selected.select[0].chkItId})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    }
    $scope.fresh_onClick = function(){
        $scope.queryTable();
        $scope.selected.select=[];
    }


    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm.rem="";
            $scope.conditionForm.clazz="";
            $scope.conditionForm.chkItId="";
            $scope.selected.select=[];//清空选项s
        })
    }

    //$scope.column_click = function(row){
    //    //alert(JSON.stringify(row));
    //    $state.go("view");
    //    dataDeliver.setter(row);
    //
    //}
    $scope.column_click = function(row) {
        $common.get_ngDialog('ft/ftView.html', $scope
            , ["$scope", function (dialogScope) {
                viewController(dialogScope, $scope, $common, "view", row);
            }], "", {showClose: true});
    }



    //表格--------结束-------------------------
};
