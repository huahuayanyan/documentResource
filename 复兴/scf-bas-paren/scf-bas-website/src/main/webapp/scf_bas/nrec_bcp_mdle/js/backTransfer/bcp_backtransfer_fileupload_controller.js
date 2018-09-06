/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var nrecBcpBackTransferFileUploadController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    if(window.appNo)
    {
        $scope.hideButton = true;
    }
    $scope.otherform = dataDeliver.getter();
    if(!$scope.otherform.appno)
    {
        $scope.otherform = $scope.source.otherform;
    }
    if(!$scope.otherform.appno)
    {
        $common.get_tipDialog("请先保存后上传附件！",'showInform');
        var url = "";
        if($scope.otherform.financingType=="2")
        {
            url = "backtransfer.debtbackpooledit"
        }
        else
        {
            url = "backtransfer.debtbackedit"
        }
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    }

    var flag = $scope.otherform.flag;
    if(flag)
    {
        if(flag=="add")
        {

        }
        if(flag=="update")
        {

        }
        if(flag=="view")
        {
            $scope.hide = true;
        }
    }
    else
    {
        $scope.hide = true;
        //if(window.taskId=="Write_task")
        //{
        //    $scope.hide = false;
        //}
    }

    $scope.fileupload={};//初始化查询条件对象

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
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });

    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.fileupload = {};
            $scope.selected.select=[];//清空选项s
        })
    };

    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };

    $scope.queryTable = function(paramData){
        $.post(_FILE_SERVER_URL+"file/viewPic.htm",{reservedValue1: $scope.otherform.appno},function(res){
            var res=JSON.parse(res);
            if (res.scubeHeader.errorCode =="SUC"||res.scubeHeader.errorCode =="EXP") {
                var list=JSON.parse(res.scubeBody.contextData.data||'[]');
                var fname= $scope.fileupload.picName;
                var picType = $scope.fileupload.picType;
                var listresult = [];
                if($.trim(fname)!=""&&$.trim(picType)!="")
                {
                    $.map(list,function(a){
                        if((a.picName).indexOf(fname)!=-1&&(a.picType).indexOf(picType)!=-1){
                            listresult.push(a);
                        }
                    });
                }
                else
                {
                    if($.trim(fname)!=""){
                        $.map(list,function(a){
                            if((a.picName).indexOf(fname)!=-1){
                                listresult.push(a);
                            }
                        });
                    }
                    if($.trim(picType)!=""){
                        $.map(list,function(a){
                            if((a.picType).indexOf(picType)!=-1){
                                listresult.push(a);
                            }
                        });
                    }
                }

                var result = [];
                if($.trim(fname)==""&&$.trim(picType)=="")
                {
                    result = list;
                }
                else
                {
                    result = listresult;
                }
                for(var x in result)
                {
                    var expiryDate = result[x].expiryDate;
                    expiryDate = expiryDate.substring(0,expiryDate.indexOf(" "));
                    result[x].expiryDate = expiryDate;
                }
                $scope.datasource.ds = result;
                $scope.conf.totalRecord = result.length;
                $scope.$apply();
            }else{
                $common.get_tipDialog('附件信息列表查询失败','showError');
            }
        });
    };

    //上传
    $scope.uploadoption = {
        inputHidden:[
            /* 上传到文件服务器 start 后台无需加任何代码 */
            {name:'expiryDate', value: function(){
                return getSysDate();
            }
            },//文件上传时间
            //{name:'appId', value: $scope.baseinfo.appno },//业务系统号
            //{name:'roate', value: "360"},//图片旋转角度
            {name:'reservedValue1', value: $scope.otherform.appno}
            //{name:'reservedValue2', value: "保留字段2"},
            //{name:'reservedValue3', value: "保留字段3"}
            /* 上传到文件服务器 end 后台无需加任何代码*/


            /* 上传到服务部署所在机器 start */
            //{
            //    name:'callback',
            //    value: function(){
            //        return "fileServiceSupport/upload";
            //    }
            //}
            /* 上传到服务部署所在机器 end */
        ],
        callbackFun: function(res,status){
            if (res&&res.errorCode =="SUC") {
                var picdata = res.data;
                $.post(_FILE_SERVER_URL+"file/viewPic.htm",{picId:picdata.picId},function(res){
                    var res=JSON.parse(res);
                    if (res.scubeHeader.errorCode =="SUC"||res.scubeHeader.errorCode =="EXP") {
                        var list=JSON.parse(res.scubeBody.contextData.data||'[]');
                        $common.get_asyncData('bsysUploadFileService/addBSysUploadFile',{omap:list[0]}).then(function(resf){
                            if (resf.errorCode =="SUC"){
                                $common.get_tipDialog('上传成功', 'showSuccess');
                                $scope.queryTable();
                            }else{
                                //如果新增本地数据库失败，则删除已上传文件
                                $.post(_FILE_SERVER_URL+"file/delete.htm",{picId:picdata.picId},function(ress){
                                    var res=JSON.parse(ress);
                                    if (res.scubeHeader.errorCode =="SUC") {
                                        $scope.queryTable();
                                        $scope.selected.select = [];
                                        $common.get_tipDialog(resf.errorMsg,'showError');
                                    }else{
                                        $common.get_tipDialog('附件删除失败','showError');
                                    }
                                });
                            }
                        })
                    }else{
                        $common.get_tipDialog('附件信息列表查询失败','showError');
                    }
                });
            }else{
                $common.get_tipDialog('上传失败，请检查文件名称是否过长','showError');
            }
        },
        fileServerUrl:true //true：上传到文件服务器；false：上传到服务部署所在机器
    };

    //下载
    //$scope.download_onClick = function(){
    //    if($scope.selected.select.length <= 0 || $scope.selected.select.length> 1){
    //        $common.get_tipDialog('请选择一条记录！','showInform');
    //    }else{
    //        location.href = $scope.selected.select[0].url;
    //    }
    //};

    $scope.downloadoption = {
        inputHidden:[
            /* 从文件服务器下载 start */
            {
                name:'picId', value:function()
            {
                if($scope.selected.select.length <= 0 || $scope.selected.select.length> 1){
                    return "";
                }else{
                    return $scope.selected.select[0].picId;
                }
            }
            }
            /* 从文件服务器下载 end */
            /* 从服务部署所在机器下载 start */
            //{name:'callback',value: 'fileServiceSupport/download'},
            //{name:'genFileName',value: '测试abc123.txt'}
            /* 从服务部署所在机器下载 end */
        ],
        fileServerUrl:true //true：从文件服务器下载；false：从服务部署所在机器下载
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('bsysUploadFileService/deleteBSysUploadById',{id:$scope.selected.select[0].picId}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $.post(_FILE_SERVER_URL+"file/delete.htm",{picId:$scope.selected.select[0].picId},function(res){
                            var res=JSON.parse(res);
                            if (res.scubeHeader.errorCode =="SUC") {
                                $scope.queryTable();
                                $scope.selected.select = [];
                                $common.get_tipDialog('附件删除成功', 'showSuccess');
                            }else{
                                $common.get_tipDialog('附件删除失败','showError');
                            }
                        });
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            })
        }
    };

    function getSysDate()
    {
        var date = new Date();
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        if(m < 10){m = "0" + m;}
        if(d < 10){d = "0" + d;}
        var sysDate="" + y +"-" + m +"-" + d;//当前日期
        return sysDate;
    }

    $scope.back_onClick = function()
    {
        $state.go("list");
    };
    //表格--------结束-------------------------
};
