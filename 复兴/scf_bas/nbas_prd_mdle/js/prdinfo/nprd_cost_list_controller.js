/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var NbasPrdCostListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
        deleteByExample($scope.baseinfo.productId);
        //$scope.queryTable();
    });

    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bPrdCostBindVO:$scope.baseinfo
        };
        $common.get_asyncData("nbprdCostBindService/findBPrdCostBindByPage",data).then(function(res){
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
            $common.get_ngDialog('prdinfo/nprd_cost_choose.html', $scope,["$scope",function(dialogScope){
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
                    var promiseQ = $common.get_asyncData("bBrpCostParamService/findBBrpCostParamByPage",data);
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
                            //            if(dialogScope.datasource.ds[x].costCode==$scope.datasource.ds[y].costCode)
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
                        $common.get_asyncData("nbprdCostBindService/saveBPrdCostBind",data).then(function(res){
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
            }],"费用参数选择")
        }
    };

    //修改
    $scope.update_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('prdinfo/nprd_cost_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.costform = $scope.selected.select[0];
                //保存按钮
                dialogScope.save_onClick = function(){
                    if($.doValidate("costform"))
                    {
                        if(flag=="add")
                        {//新增时，只在页面操作
                            dialogScope.closeThisDialog();
                            $scope.selected.select = [];
                            $scope.$apply();
                        }
                        if(flag=="update")
                        {//修改时，直接操作数据库
                            var data = {
                                bPrdCostBindVO:dialogScope.costform
                            };
                            $common.get_asyncData("nbprdCostBindService/updateBPrdCostBind",data).then(function(res){
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
                    }
                };
                //返回按钮
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"产品费用信息")
        }
    };

    //查看
    $scope.view_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('prdinfo/nprd_cost_param.html', $scope,["$scope",function(dialogScope){
                dialogScope.otherform = {
                    costCode:$scope.selected.select[0].costCode
                };
                $common.get_asyncData("bBrpCostParamService/findBBrpCostParamByKey",{bBrpCostParam:dialogScope.otherform}).then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        var costClass = null;
                        if (data.costClass == "10") {
                            costClass = "1";
                        } else if (data.costClass == "01") {
                            costClass = "2";
                        } else if (data.costClass == "11") {
                            costClass = "1,2";
                        }
                        // 收取方式 第1位-先收；第2位-后收；第3位-免收
                        var costType = null;
                        if (data.costType == "100") {
                            costType = "1";
                        } else if (data.costType == "010") {
                            costType = "2";
                        } else if (data.costType == "001") {
                            costType = "3";
                        } else if (data.costType == "101") {
                            costType = "1,3";
                        } else if (data.costType == "111") {
                            costType = "1,2,3";
                        } else if (data.costType == "110") {
                            costType = "1,2";
                        } else if (data.costType == "011") {
                            costType = "2,3";
                        }
                        // 计算方式 第1位-固定、第2位-按比率
                        var costCalcType = null;
                        if (data.costCalcType == "10") {
                            costCalcType = "1";
                        } else if (data.costCalcType == "11") {
                            costCalcType = "1,2";
                        } else if (data.costCalcType == "01") {
                            costCalcType = "2";
                        }
                        // 扣取方式 第1位-外扣，第2位-内收
                        var chargeType = null;
                        if (data.chargeType == "10") {
                            chargeType = "1";
                        } else if (data.chargeType == "11") {
                            chargeType = "1,2";
                        } else if (data.chargeType == "01") {
                            chargeType = "2";
                        }
                        data.costClass = costClass.split(",");
                        data.costType = costType.split(",");
                        data.costCalcType = costCalcType.split(",");
                        data.chargeType = chargeType.split(",");
                        dialogScope.otherform = data;
                        dialogScope.$apply();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });

                //返回按钮
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"费用详情信息")
        }
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('nbprdCostBindService/deleteBPrdCostBindByKey',{list:$scope.selected.select}).then(function(res){
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
        var url = "prddtl.baseinfo";
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
        //需对费用收取阶段是否为空进行校验
        if($scope.datasource.ds.length>0)
        {
            for(var x in $scope.datasource.ds)
            {
                if($scope.datasource.ds[x].costPhase==undefined||$scope.datasource.ds[x].costPhase==null||$scope.datasource.ds[x].costPhase=="")
                {
                    $common.get_tipDialog('费用收取阶段不能为空！','showInform');
                    return;
                }
            }
            var url = "prddtl.warn";
            $state.go(url);
            $scope.$parent.panes.forEach(function(pane){
                if (pane.uiSref == url){
                    $scope.$parent.select(pane);
                }
            });
            return;
        }
        else
        {
            var url = "prddtl.warn";
            $state.go(url);
            $scope.$parent.panes.forEach(function(pane){
                if (pane.uiSref == url){
                    $scope.$parent.select(pane);
                }
            });
            return;
        }
    };

    //完成-执行相应业务逻辑
    $scope.complete_onClick = function()
    {
        //需对费用收取阶段是否为空进行校验
        if($scope.datasource.length>0)
        {
            for(var x in $scope.datasource.ds)
            {
                if($scope.datasource.ds[x].costPhase==undefined||$scope.datasource.ds[x].costPhase==null||$scope.datasource.ds[x].costPhase=="")
                {
                    $common.get_tipDialog('费用收取阶段不能为空！','showInform');
                    return;
                }
            }

            $state.go("list");
        }
        else
        {

            $state.go("list");
        }
    };

    /**
     * 根据业务品种删除没有调用阶段的风险拦截模型信息
     * @param productId
     */
    function deleteByExample(productId)
    {
        $common.get_asyncData('nbprdCostBindService/deleteBPrdCostBindByExample',{productId:productId}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.queryTable();
                //$scope.selected.select=[];
                //$common.get_tipDialog('删除成功！','showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
  //表格--------结束-------------------------
};
