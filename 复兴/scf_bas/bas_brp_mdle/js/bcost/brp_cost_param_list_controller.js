/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var BrpCostParamListController = function($scope,$common,$state,dataDeliver) {
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
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
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
        var promise = $common.get_asyncData("bBrpCostParamService/findBBrpCostParamByPage",data);
                promise.then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                data = res.contextData;
                if(data.records != "" && data.records != null) {
                    //将表中查出的数据转换为数据字典的数据，并完成字符串拼接
                    for(var obj in data.records){
                        var objtemp=data.records[obj];
                        // 收取种类：1-整体、2-单张
                        if(objtemp.costClass=="10"){
                            objtemp.costClass="整体";
                        }else if(objtemp.costClass=="01"){
                            objtemp.costClass="单张";
                        }else if(objtemp.costClass=="11"){
                            objtemp.costClass="整体,单张";
                        }
                        // 收取方式 第1位-先收；第2位-后收；第3位-免收
                        if(objtemp.costType=="100"){
                            objtemp.costType="先收";
                        }else if(objtemp.costType=="010"){
                            objtemp.costType="后收";
                        }else if(objtemp.costType=="001"){
                            objtemp.costType="免收";
                        }else if(objtemp.costType=="101"){
                            objtemp.costType="先收,免收";
                        }else if(objtemp.costType=="111"){
                            objtemp.costType="先收,后收,免收";
                        }else if(objtemp.costType=="110"){
                            objtemp.costType="先收,后收";
                        }else if(objtemp.costType=="011"){
                            objtemp.costType="后收,免收";
                        }
                        // 计算方式 第1位-固定、第2位-按比率
                        if(objtemp.costCalcType=="10"){
                            objtemp.costCalcType="固定";
                        }else if(objtemp.costCalcType=="11"){
                            objtemp.costCalcType="固定,按比率";
                        }else if(objtemp.costCalcType=="01"){
                            objtemp.costCalcType="按比率";
                        }
                        // 扣取方式 第1位-外扣，第2位-内收
                        if(objtemp.chargeType=="10"){
                            objtemp.chargeType="外扣";
                        }else if(objtemp.chargeType=="11"){
                            objtemp.chargeType="外扣,内收";
                        }else if(objtemp.chargeType=="01"){
                            objtemp.chargeType="内收";
                        }
                    }
                    $scope.datasource.ds = data.records;
                    $scope.conf.totalRecord = data.totalRecord;
                } else{
                    $scope.datasource.ds = data.records;
                    $scope.conf.totalRecord = data.totalRecord;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //新增费用参数信息 新增的时候只要传过去一个flag就行了。
    $scope.add_onClick = function(){
        var row={};
        $common.get_ngDialog('bcost/brp_cost_param_add.html', $scope
            ,["$scope",function(dialogScope){
                BrpCostParamAddController(dialogScope,$scope,$common,"add",row);
            }],"新增费用参数信息",{showClose:true},800);

    };

    //费用参数信息删除 根据组件ID
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
            var id = $scope.selected.select[0].id;//定义选中费用参数id
            var primiseA = $common.get_asyncData('bBrpCostParamService/delete', {id: id});
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

    //组件信息修改操作
        $scope.update_onClick = function(){
            var row ={};
            if($scope.selected.select.length == 1){
                $common.get_ngDialog('bcost/brp_cost_param_add.html', $scope
                    ,["$scope",function(dialogScope){
                        BrpCostParamAddController(dialogScope,$scope,$common,"update",row);
                    }],"修改费用参数信息",{showClose:true});
            }else{
                $common.get_tipDialog('请选择一条记录！','showInform');
            }
        };
    //授信客户查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('bcost/brp_cost_param_add.html', $scope
            ,["$scope",function(dialogScope){
                BrpCostParamAddController(dialogScope,$scope,$common,"view",row);
            }],"查看费用参数信息",{showClose:true});
    };
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.costCode = "";
        $scope.conditionForm.costName = "";
        $scope.queryTable();
    };
};
