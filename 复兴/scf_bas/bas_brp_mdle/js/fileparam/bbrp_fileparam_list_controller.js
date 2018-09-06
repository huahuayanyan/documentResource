/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var BaseBrpFileParamListController = function($scope,$common,$state,dataDeliver) {
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
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm={};
        $scope.selected.select=[];
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
            bBrpFileParamVO:$scope.conditionForm
        };
        $common.get_asyncData("bbrpFileParamService/findBBrpFileParamByPage",data1).then(function(res){
            var data2;
            if (res.errorCode =="SUC"){
                data2 = res.contextData;
                $scope.datasource.ds = data2.records||[];
                $scope.conf.totalRecord = data2.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('fileparam/bbrp_fileparam_edit.html', $scope,["$scope",function(dialogScope){
            dialogScope.baseinfo = {};
            //保存按钮
            dialogScope.save_onClick = function(){
                if($.doValidate("baseinfo")) {
                    $common.get_asyncData("bbrpFileParamService/addBBrpFileParam",{bBrpFileParamVO:dialogScope.baseinfo}).then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('保存成功！','showSuccess');
                            $scope.queryTable();
                            $scope.selected.select=[];
                            dialogScope.closeThisDialog();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            };

            //返回按钮
            dialogScope.back_onClick = function(){
                dialogScope.closeThisDialog();
            }
        }],"合同模板信息")
    };

    //修改
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('fileparam/bbrp_fileparam_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.disable = true;
                dialogScope.baseinfo = $common.copy($scope.selected.select[0]);
                //保存按钮
                dialogScope.save_onClick = function(){
                    if($.doValidate("baseinfo")) {
                        $common.get_asyncData("bbrpFileParamService/updateBBrpFileParam",{bBrpFileParamVO:dialogScope.baseinfo}).then(function(res){
                            if (res.errorCode =="SUC"){
                                $common.get_tipDialog('保存成功！','showSuccess');
                                $scope.queryTable();
                                $scope.selected.select=[];
                                dialogScope.closeThisDialog();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                };

                //返回按钮
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                    $scope.selected.select=[];
                }
            }],"合同模板信息")
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('fileparam/bbrp_fileparam_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.disable = true;
                dialogScope.viewDisable = true;
                dialogScope.hide = true;
                dialogScope.baseinfo = $common.copy($scope.selected.select[0]);

                //返回按钮
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                    $scope.selected.select=[];
                }
            }],"合同模板信息")
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //产品信息查看操作
  $scope.column = function(row)
  {
      $common.get_ngDialog('fileparam/bbrp_fileparam_edit.html', $scope,["$scope",function(dialogScope){
          dialogScope.disable = true;
          dialogScope.viewDisable = true;
          dialogScope.hide = true;
          dialogScope.baseinfo = $common.copy(row);
          //返回按钮
          dialogScope.back_onClick = function(){
              dialogScope.closeThisDialog();
              $scope.selected.select=[];
          }
      }],"合同模板信息")
    }

};
