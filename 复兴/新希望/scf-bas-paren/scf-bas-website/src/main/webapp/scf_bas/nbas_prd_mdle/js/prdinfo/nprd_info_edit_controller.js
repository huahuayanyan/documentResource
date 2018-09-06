/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var NbasPrdInfoEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.baseinfo = dataDeliver.getter();
    var flag = $scope.baseinfo.flag;
    if(flag == "add")
    {

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
        if(!$scope.baseinfo.productId)
        {
            $scope.datasource.ds = [];
            $scope.conf.totalRecord = 0;
            return;
        }
        var data1= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bPrdFileInfoVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("bprdFileInfoService/findBPrdFileInfoByPage",data1);
        promise.then(function(res){
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

    //选择
    $scope.choose_onClick = function()
    {
        $common.get_ngDialog('prdinfo/nprd_industry_choose.html', $scope,["$scope",function(dialogScope){
            dialogScope.conditionForm={
                industryLevel:"2"//只查询大类的行业代码
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
                totalRecord: 0}
            //监听分页
            dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                dialogScope.queryTable();
            });
            //重置按钮 industryCode,industryName
            dialogScope.rebort_onClick =function(){
                dialogScope.conditionForm.industryCode = "";
                dialogScope.conditionForm.industryName = "";
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
                    bBrpIndustryTypes:dialogScope.conditionForm
                };
                $common.get_asyncData("bBrpIndustryTypesService/findBBrpIndustryTypesByPage",data).then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records||[];
                        dialogScope.conf.totalRecord = data.totalRecord;
                        var selected = [];
                        if($scope.baseinfo.industryType)
                        {
                            var industryType = $scope.baseinfo.industryType.split(",");
                            for(var x in dialogScope.datasource.ds)
                            {
                                for(var y in industryType)
                                {
                                    if(dialogScope.datasource.ds[x].industryCode==industryType[y])
                                    {
                                        selected.push(dialogScope.datasource.ds[x]);
                                    }
                                }
                            }
                        }
                        dialogScope.selected.select = selected;
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
                    dialogScope.closeThisDialog();
                    var arrs = $common.copy(dialogScope.selected.select);
                    var industryType = "";
                    var industryTypeName="";
                    for(var k in arrs){
                        industryType = industryType + arrs[k].industryCode +",";
                        industryTypeName = industryTypeName + arrs[k].industryCode+"-"+arrs[k].industryName+",";
                    }
                    industryType = industryType.substring(0,industryType.lastIndexOf(","));
                    industryTypeName=industryTypeName.substring(0, industryTypeName.lastIndexOf(","));
                    $scope.baseinfo.industryTypeName = industryTypeName;
                    $scope.baseinfo.industryType = industryType;
                    $scope.$apply();
                }
            };
            //返回按钮
            dialogScope.back_onClick = function(){
                dialogScope.closeThisDialog();
            }
        }],"融资企业选择")
    };

    //新增
    $scope.add_onClick = function()
    {
        if($.doValidate("baseinfo")) {
            $common.get_ngDialog('prdinfo/bbrp_fileparam_choose.html', $scope,["$scope",function(dialogScope){
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
                        bBrpFileParamVO:dialogScope.conditionForm
                    };
                    var promiseQ = $common.get_asyncData("bbrpFileParamService/findBBrpFileParamByPage",data);
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
                            //            if(dialogScope.datasource.ds[x].contCode==$scope.datasource.ds[y].contCode)
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
                        if(flag=="add")
                        {//新增时，只在页面操作
                            dialogScope.closeThisDialog();
                            $scope.datasource.ds = [];
                            $scope.datasource.ds = dialogScope.selected.select;
                            $scope.selected.select = [];
                            $scope.$apply();
                        }
                        if(flag=="update")
                        {//修改时，直接操作数据库
                            var data = {
                                list:dialogScope.selected.select,
                                productId:$scope.baseinfo.productId
                            };
                            $common.get_asyncData("bprdFileInfoService/saveBPrdFileInfo",data).then(function(res){
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
            }],"融资企业选择")
        }
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                if(flag=="add")
                {
                    var selected = $scope.selected.select;
                    var datasourcelist = $scope.datasource.ds;
                    for(var x in datasourcelist)
                    {
                        for(var y in selected)
                        {
                            if(selected[y].contCode==datasourcelist[x].contCode)
                            {
                                $scope.datasource.ds.splice(x, 1);
                            }
                        }
                    }
                    $scope.$apply();
                }
                if(flag=="update")
                {
                    $common.get_asyncData('bprdFileInfoService/deleteBPrdFileInfoById',{list:$scope.selected.select}).then(function(res){
                        if (res.errorCode =="SUC"){
                            $scope.queryTable();
                            $scope.selected.select=[];
                            $common.get_tipDialog('删除成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                }
            })
        }
    };

    //下一步-只负责页面跳转
    $scope.next_onClick = function()
    {
        if($.doValidate("baseinfo")) {
            if(flag=="add")
            {
                var data = {
                    bPrdInfoVO:$scope.baseinfo,
                    list:$scope.datasource.ds||[]
                };
                $common.get_asyncData("nbprdInfoService/addBPrdInfo",data).then(function(res){
                    if (res.errorCode =="SUC"){
                        flag = "update";
                        $scope.baseinfo.flag = flag;
                        var url = "prddtl.cost";
                        $state.go(url);
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == url){
                                $scope.$parent.select(pane);
                            }
                        });
                        return;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
            else if(flag=="update")
            {
                $common.get_asyncData("nbprdInfoService/updateBPrdInfo",{bPrdInfoVO:$scope.baseinfo}).then(function(res){
                    if (res.errorCode =="SUC"){
                        var url = "prddtl.cost";
                        $state.go(url);
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == url){
                                $scope.$parent.select(pane);
                            }
                        });
                        return;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
            else
            {
                var url = "prddtl.cost";
                $state.go(url);
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == url){
                        $scope.$parent.select(pane);
                    }
                });
                return;
            }
        }
    };

    //完成-执行相应业务逻辑
    $scope.complete_onClick = function()
    {
        if($.doValidate("baseinfo")) {
            if(flag=="add")
            {
                var data = {
                    bPrdInfoVO:$scope.baseinfo,
                    list:$scope.datasource.ds
                };
                $common.get_asyncData("nbprdInfoService/addBPrdInfo",data).then(function(res){
                    if (res.errorCode =="SUC"){
                        $state.go("list");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
            else if(flag=="update")
            {
                $common.get_asyncData("nbprdInfoService/updateBPrdInfo",{bPrdInfoVO:$scope.baseinfo}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $state.go("list");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
            else
            {
                $state.go("list");
            }
        }
    };
  //表格--------结束-------------------------
};
