/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var NbasPrdFlowController = function($scope,$common,$state,dataDeliver) {
    $scope.baseinfo = dataDeliver.getter();
    var flag = $scope.baseinfo.flag;
    if(flag == "add")
    {
        $common.get_tipDialog("请先保存产品基本信息！",'showInform');
        var url = "prddtl.baseinfo";
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    if(flag == "update")
    {

    }
    if(flag == "view")
    {
        $scope.disable = true;
        $scope.hide = true;
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
        totalRecord: 0};

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    //查询操作
    $scope.queryTable = function(paramData){
        var data1= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bPrdFlowVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("bprdFlowService/findBPrdFlowServiceByPage",data1);
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
        $common.get_ngDialog('prdinfo/nprd_flow_edit.html', $scope,["$scope",function(dialogScope){

            dialogScope.flowform = {
                productId:$scope.baseinfo.productId,
                productName:$scope.baseinfo.productName
            };

            //流程配置筛选
            dialogScope.modelContent = {
                type:"table",//展示类型table  tree
                url:"bSysCommonService/selectWKFlowByPage",
                param:{},    //
                extentColumn:"modelName",
                column:["flowName","flowCopId"]//展示内容
            };
            dialogScope.modeldooextent = function(ds){
                dialogScope.flowform.modelId=ds.flowCopId;
                dialogScope.flowform.modelName=ds.flowName;
            };
            dialogScope.$watch("flowform.modelName",function() {
                dialogScope.modelContent.param = {
                    flowName: dialogScope.flowform.modelName
                };
            });

            dialogScope.confirm_onClick = function()
            {
                if($.doValidate("flowform")) {
                    if(!dialogScope.flowform.status)
                    {
                        $common.get_tipDialog('状态不能为空，请选择！','showInform');
                        return;
                    }
                    $common.get_asyncData('bprdFlowService/addBPrdFlow',{bPrdFlowVO:dialogScope.flowform}).then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.closeThisDialog();
                            $scope.selected.select = [];
                            $scope.queryTable();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            };
            dialogScope.close_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"流程配置信息")
    };

    //修改
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('prdinfo/nprd_flow_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.disable = true;
                dialogScope.flowform = $common.copy($scope.selected.select[0]);

                //流程配置筛选
                dialogScope.modelContent = {
                    type:"table",//展示类型table  tree
                    url:"bSysCommonService/selectWKFlowByPage",
                    param:{},    //
                    extentColumn:"modelName",
                    column:["flowName"]//展示内容
                };
                dialogScope.modeldooextent = function(ds){
                    dialogScope.flowform.modelId=ds.flowCopId;
                    dialogScope.flowform.modelName=ds.flowName;
                };
                dialogScope.$watch("flowform.modelName",function() {
                    dialogScope.modelContent.param = {
                        flowName: dialogScope.flowform.modelName
                    };
                });

                dialogScope.confirm_onClick = function()
                {
                    if($.doValidate("flowform")) {
                        $common.get_asyncData('bprdFlowService/updateBPrdFlow',{bPrdFlowVO:dialogScope.baseinfo}).then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.selected.select = [];
                                $scope.queryTable();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                };
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"流程配置信息")
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    $scope.copy_onClick = function()
    {
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('prdinfo/nprd_flow_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.disable = true;
                dialogScope.flowform = $common.copy($scope.selected.select[0]);

                //流程配置筛选
                dialogScope.modelContent = {
                    type:"table",//展示类型table  tree
                    url:"bSysCommonService/selectWKFlowByPage",
                    param:{},    //
                    extentColumn:"modelName",
                    column:["flowName"]//展示内容
                };
                dialogScope.modeldooextent = function(ds){
                    dialogScope.flowform.modelId=ds.flowCopId;
                    dialogScope.flowform.modelName=ds.flowName;
                };
                dialogScope.$watch("flowform.modelName",function() {
                    dialogScope.modelContent.param = {
                        flowName: dialogScope.flowform.modelName
                    };
                });

                dialogScope.confirm_onClick = function()
                {
                    if($.doValidate("flowform")) {
                        $common.get_asyncData('bprdFlowService/copyBprdFolw',{bPrdFlowVO:dialogScope.baseinfo}).then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.selected.select = [];
                                $scope.queryTable();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                };
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"流程配置信息")
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    $scope.view_onClick = function()
    {
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('prdflow/prd_flow_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.disable = true;
                dialogScope.viewDisable = true;
                dialogScope.hide = true;
                dialogScope.flowform = $scope.selected.select[0];

                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"产品配置信息")
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 0)
        {
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                $common.get_asyncData('bprdFlowService/deleteBPrdFlow', {list: $scope.selected.select}).then(function (res) {
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

    //上一步
    $scope.former_onClick = function()
    {
        var url = "prddtl.loanway";
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    };

    //完成-执行相应业务逻辑
    $scope.complete_onClick = function()
    {
        //需对费用收取阶段是否为空进行校验
        $state.go("list");
    };
};
