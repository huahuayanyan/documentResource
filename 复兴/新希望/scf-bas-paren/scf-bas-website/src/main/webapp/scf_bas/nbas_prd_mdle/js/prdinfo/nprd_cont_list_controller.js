/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var NbasPrdContListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
            bPrdPrintInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("bprdPrintInfoService/findBPrdPrintInfoByPage",data).then(function(res){
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

    //上传
    $scope.upload_onClick = function(){
        $common.get_ngDialog('prdinfo/nprd_print_upload.html', $scope
            ,["$scope",function(dialogScope){
                dialogScope.printform = {};
                dialogScope.uploadoption = {
                    inputHidden:[
                        /* 上传到文件服务器 start */
                        {name:'invokPhase', value: dialogScope.printform.invokPhase},
                        {name:'productId', value:$scope.baseinfo.productId},
                        /* 上传到文件服务器 end */
                        /* 上传到服务部署所在机器 start */
                        {
                            name:'callback',
                            value: function(){
                                return "fileUpAndDownLoadService/upload";
                            }
                        }
                        /* 上传到服务部署所在机器 end */
                    ],
                    callbackFun: function(res,status){
                        if (res!=null&&res!=''&&res.errorCode == "SUC") {
                            alert("上传成功！");
                            dialogScope.closeThisDialog();
                            $scope.selected.select = [];
                            $scope.queryTable();
                        }
                        else{
                            alert("上传失败，请重新上传！");
                        }
                    },
                    fileServerUrl:false //true：上传到文件服务器；false：上传到服务部署所在机器
                };

                dialogScope.changeInvokPhase = function(val)
                {
                    if(val!=null&&""!=val&&val!=undefined)
                    {
                        dialogScope.uploadoption = {
                            inputHidden:[
                                /* 上传到文件服务器 start */
                                {name:'invokPhase', value: val},
                                {name:'productId', value:$scope.baseinfo.productId},
                                /* 上传到文件服务器 end */
                                /* 上传到服务部署所在机器 start */
                                {
                                    name:'callback',
                                    value: function(){
                                        return "fileUpAndDownLoadService/upload";
                                    }
                                }
                                /* 上传到服务部署所在机器 end */
                            ],
                            callbackFun: function(res,status){
                                if (res!=null&&res!=''&&res.errorCode == "SUC") {
                                    alert("上传成功！");
                                    dialogScope.closeThisDialog();
                                    $scope.selected.select = [];
                                    $scope.queryTable();
                                }
                                else{
                                    alert("上传失败，请重新上传！");
                                }
                            },
                            fileServerUrl:false //true：上传到文件服务器；false：上传到服务部署所在机器
                        };

                    }
                };
            }],"合同模版上传",{showClose:true});
    };

    //下载
    $scope.downloadoption = {
        inputHidden:[
            /* 从文件服务器下载 start */
            /*  {
             name:'picId',
             value:function(){
             return "201612011711416420000014";
             }
             } */
            /* 从文件服务器下载 end */
            /* 从服务部署所在机器下载 start */
            {name:'callback',value: 'fileUpAndDownLoadService/download'},
            {name:'genFileName',value: function(){
                if($scope.selected.select.length == 1)
                {
                    return  $scope.selected.select[0].fileName+'.'+$scope.selected.select[0].fileExt;
                }
                else
                {
                    $common.get_tipDialog('请选择一条记录！','showInform');
                }}
            },
            {name:'id',value: function(){
                if($scope.selected.select.length == 1){
                    return  $scope.selected.select[0].id;
                }
                else
                {
                    $common.get_tipDialog('请选择一条记录！','showInform');
                }}
            }
            /* 从服务部署所在机器下载 end */
        ],
        fileServerUrl:false //true：从文件服务器下载；false：从服务部署所在机器下载
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('bprdPrintInfoService/deleteBPrdPrintInfo',{list:$scope.selected.select}).then(function(res){
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
        var url = "prddtl.chkdir";
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
        $state.go("list");
    };
  //表格--------结束-------------------------
};
