/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var AccInfoListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    $scope.conditionForm={};//初始化条件查询框
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
    //点击刷新之后的搜索
    $scope.fresh_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作brName,brNo
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bAccAccountInfo:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByPage",data);
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
    //新增账户信息
    $scope.add_onClick = function(){
        var row={};
        $common.get_ngDialog('baccinfo/acc_add.html', $scope
            ,["$scope",function(dialogScope){
                AccInfoAddController(dialogScope,$scope,$common,"add",row);
            }],"新增账户",{showClose:true});
    };
    //账户信息删除操作(这里删除是单条删除，但是后台要准备好多条删除。所以，应该是要传个list才对。要改)
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var arrs =$common.copy($scope.selected.select);//{voList:arrs}
                var primise = $common.get_asyncData('bAccAccountInfoService/batchDelete',{idList:arrs})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select = [];
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    //账户信息修改操作
    $scope.update_onClick = function(){
        var row ={};
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('baccinfo/acc_add.html', $scope
                ,["$scope",function(dialogScope){
                    AccInfoAddController(dialogScope,$scope,$common,"update",row);
                }],"修改账户",{showClose:true});
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //账户信息查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('baccinfo/acc_add.html', $scope
            ,["$scope",function(dialogScope){
                AccInfoAddController(dialogScope,$scope,$common,"view",row);
            }],"查看账户",{showClose:true});
    }
    //重置按钮accountNo,accountType
    $scope.rebort_onClick =function(){
        $scope.conditionForm.accountNo = "";
        $scope.conditionForm.accountType = "";
        $scope.queryTable();
    }
};
