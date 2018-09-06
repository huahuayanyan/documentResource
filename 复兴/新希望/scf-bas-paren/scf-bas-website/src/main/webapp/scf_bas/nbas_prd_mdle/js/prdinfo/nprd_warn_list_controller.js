/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var NbasPrdWarnListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bPrdWarnBindVO:$scope.baseinfo
        };
        $common.get_asyncData("nbprdWarnBindService/findBPrdWarnBindByPage",data).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //新增
    $scope.add_onClick = function()
    {
        if($.doValidate("baseinfo")) {
            $common.get_ngDialog('prdinfo/nprd_warn_choose.html', $scope,["$scope",function(dialogScope){
                dialogScope.conditionForm={
                };//初始化条件查询框
                dialogScope.datasource={//初始化表格对象
                    ds: []
                };
                dialogScope.selected={//初始化对象
                    select: []
                };
                dialogScope.conf= {//初始化分页对象
                    pageNo: 1,
                    pageSize: 10,
                    totalRecord: 0};
                //监听分页
                dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                    dialogScope.queryTable();
                });
                //重置按钮 industryCode,industryName
                dialogScope.rebort_onClick =function(){
                    dialogScope.conditionForm={
                    };//初始化条件查询框
                    dialogScope.queryTable();
                };
                //点击查询之后的搜索
                dialogScope.submit_onClick =function(){
                    dialogScope.queryTable();
                    dialogScope.selected.select=[];
                };
                //查询操作
                dialogScope.queryTable = function(paramData){
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        value:dialogScope.conditionForm
                    };
                    var promiseQ = $common.get_asyncData("bBrpWarnParamService/findBBrpWarnParamByPage",data);
                    promiseQ.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records||[];
                            dialogScope.conf.totalRecord = data.totalRecord;
                            //var selected = [];
                            //if($scope.datasource.ds!=[]&&dialogScope.datasource.ds!=[])
                            //{
                            //    for(var x in dialogScope.datasource.ds)
                            //    {
                            //        for(var y in $scope.datasource.ds)
                            //        {
                            //            if(dialogScope.datasource.ds[x].warnNo==$scope.datasource.ds[y].warnNo)
                            //            {
                            //                selected.push(dialogScope.datasource.ds[x]);
                            //            }
                            //        }
                            //    }
                            //}
                            //dialogScope.selected.select = selected;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };

                //保存按钮
                dialogScope.save_onClick = function(){
                    if(dialogScope.selected.select.length == 0){
                        $common.get_tipDialog('请至少选择一条记录！','showInform');
                    }else{
                        var data = {
                            list:dialogScope.selected.select,
                            productId:$scope.baseinfo.productId
                        };
                        $common.get_asyncData("nbprdWarnBindService/saveBPrdWarnBind",data).then(function(res){
                            var data;
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $common.get_tipDialog('保存成功！','showSuccess');
                                $scope.queryTable();
                                $scope.selected.select = [];
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
            }],"预警参数选择")
        }
    };

    //查看
    $scope.view_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('prdinfo/nprd_warn_param.html', $scope,["$scope",function(dialogScope){
                dialogScope.warnParamForm={};
                var bBrpWarnParam = {
                    warnNo:$scope.selected.select[0].warnNo
                };
                $common.get_asyncData("bBrpWarnParamService/findBBrpWarnParamByKey",{bBrpWarnParam:bBrpWarnParam}).then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        dialogScope.warnParamForm = data;
                        dialogScope.$apply();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });

                //返回按钮
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"预警详情信息")
        }
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('nbprdWarnBindService/deleteBPrdWarnBindByKey',{list:$scope.selected.select}).then(function(res){
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
    };

    //上一步
    $scope.former_onClick = function()
    {
        var url = "prddtl.cost";
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    };
    //下一步-只负责页面跳转
    $scope.next_onClick = function()
    {
        var url = "prddtl.chkdir";
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
        $state.go("list");
    };
  //表格--------结束-------------------------
};
