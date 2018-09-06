/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var NbasPrdChkdirListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
    var count = 0;
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        if(count==0)
        {
            deleteByExample($scope.baseinfo.productId);
        }
        else
        {
            $scope.queryTable();
        }
        count ++;
    });

    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bPrdChkdirInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("bprdChkdirInfoService/findBPrdChkdirInfoByPage",data).then(function(res){
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
            $common.get_ngDialog('prdinfo/nprd_chkdir_choose.html', $scope,["$scope",function(dialogScope){
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
                        bSysChkDir:dialogScope.conditionForm
                    };
                    var promiseQ = $common.get_asyncData("bSysChkDirService/findBSysChkDirByPage",data);
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
                            //            if(dialogScope.datasource.ds[x].mdlId==$scope.datasource.ds[y].mdlId)
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
                        $common.get_asyncData("bprdChkdirInfoService/saveBPrdChkdirInfo",data).then(function(res){
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
            }],"风险拦截模型选择")
        }
    };

    //修改
    $scope.update_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('prdinfo/nprd_chkdir_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mdlform = $scope.selected.select[0];
                //保存按钮
                dialogScope.save_onClick = function(){
                    if($.doValidate("mdlform"))
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
                                bPrdChkdirInfoVO:dialogScope.mdlform
                            };
                            $common.get_asyncData("bprdChkdirInfoService/updateBPrdChkdir",data).then(function(res){
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
            }],"产品风险拦截模型信息")
        }
    };

    //查看
    $scope.view_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('prdinfo/nprd_chkdir_detail.html', $scope,["$scope",function(dialogScope){
                dialogScope.otherform = $common.copy($scope.selected.select[0]);

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

                //查询操作
                dialogScope.queryTable = function(paramData){
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        bSysChkPl:dialogScope.otherform
                    };
                    $common.get_asyncData("bSysChkPlService/findBSysChkPlByPage",data).then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records||[];
                            dialogScope.conf.totalRecord = data.totalRecord;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };

                dialogScope.chkItIdsList= {
                    ds:[]
                };
                dialogScope.column = function(row)
                {
                    $common.get_asyncData("bSysChkCnfgService/findAllBSysChkCnfgList").then(function(res){
                        if (res.errorCode =="SUC"){
                            if(res.scubeBody.contextData.data!=null&&res.scubeBody.contextData.data.length>0){
                                dialogScope.chkItIdsList.ds= eval(res.scubeBody.contextData.data);
                                //alert("dialogScope.chkItIdsList.ds:  "+JSON.stringify(dialogScope.chkItIdsList.ds));

                                //跳到会话框
                                $common.get_ngDialog('prdinfo/nprd_chkdir_pldetail.html', dialogScope
                                    ,["$scope",function(secondScope){
                                        secondScope.datasourceDialog={//初始化表格对象
                                            ds: []
                                        };

                                        //初始化值
                                        secondScope.fourthform = {};

                                        secondScope.chkItIdsList={
                                            ds:[]
                                        };

                                        secondScope.selectChkPlIds={
                                            ds:[]
                                        };

                                        secondScope.chkItIdsList = dialogScope.chkItIdsList;

                                        for(var i=0;i<dialogScope.chkItIdsList.ds.length;i++){
                                            secondScope.selectChkPlIds.ds[i]={key:JSON.stringify(i),value:secondScope.chkItIdsList.ds[i].chkItId};
                                        }

                                        //secondScope.fourthform.stat=dialogScope.otherform.stat;
                                        //secondScope.fourthform.mdlId=dialogScope.otherform.mdlId;
                                        secondScope.fourthform=$common.copy(row);
                                        secondScope.disable = true;
                                        secondScope.hide = true;

                                        secondScope.closeThisDialog_onClick = function(){
                                            secondScope.closeThisDialog();
                                        };
                                    }],'查看操作',{showClose:true});
                            }
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };

                //返回按钮
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"风险拦截模型详细信息")
        }
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('bprdChkdirInfoService/deleteBPrdChkdirInfoByKey',{list:$scope.selected.select}).then(function(res){
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
        var url = "prddtl.warn";
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
        //需对调用阶段是否为空进行校验,点击下一步或完成，则删除没有调用阶段信息的风险拦截模版信息
        if($scope.datasource.ds.length>0)
        {
            for(var x in $scope.datasource.ds)
            {
                if($scope.datasource.ds[x].invokPhase==undefined||$scope.datasource.ds[x].invokPhase==null||$scope.datasource.ds[x].invokPhase=="")
                {
                    $common.get_tipDialog('风险模型调用阶段不能为空！','showInform');
                    return;
                }
            }
            var url = "prddtl.cont";
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
            var url = "prddtl.cont";
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
        $common.get_asyncData('bprdChkdirInfoService/deleteBPrdChkdirByExample',{productId:productId}).then(function(res){
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
