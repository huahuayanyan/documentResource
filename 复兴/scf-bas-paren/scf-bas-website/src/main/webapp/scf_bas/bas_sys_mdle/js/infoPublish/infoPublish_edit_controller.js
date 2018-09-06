/**
 * Created by htrad0016 on 2016/8/23.
 */
var infoPublishEditController= function ($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel)  {

   var deliverData = dataDeliver.getter();
    $scope.conditionForm={};//初始化查询条件对象
    $scope.otherform={};
    $scope.disable = true;//附件上传
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    var flag =  deliverData.flag;
    $scope.addhide =false;
    $scope. hide =false; //附件上传
    $scope.viewhide =false;
    var infoId = deliverData.id;
    if(flag=="add"){
        $scope.addhide =true;
        $scope. hide =true;//附件上传
    }else if(flag=="update"){
       // $scope.otherform = $common.copy(deliverData);
       // queryTable();
        queryInfoPublish();

    }else if(flag=="view"){
        $scope. hide = true;
        $scope.viewhide = true;
        $scope.viewdisable = true;
       // $scope.otherform = $common.copy(deliverData);
       // queryTable();
        queryInfoPublish();
    }

    //首页进入
    $scope.homeBackHide =true;
    var url = window.location.href;
    if(url.indexOf("needBackFlag")!=-1){
        $scope. hide = true;
        $scope.viewhide = true;
        $scope.viewdisable = true;
        $scope.homeHide = true; //返回
    	 $scope.homeBackHide = false;
    	 //获得信息ID
    	 var start = url.indexOf("&");
    	 var end = url.indexOf("#");
    	 var str = url.substring(start+1,end);//infoId串
    	 infoId =str.substring(str.indexOf("=")+1,str.length);
        queryInfoPublish();
    }
    //获得数据字典中配置的主页的URL
   var mainPage ="";
   mainPage = window.dictionary.main_pagePath.dataItems[0].dataVal;
    //返回主页按钮
    $scope.homeBack_onClick = function () {
    	 if(mainPage&&mainPage!=undefined&&mainPage!=null&&mainPage!=""){
    		//window.location.href =window._HTTP_IP_PORT+"scf_bas/bas_main_mdle/html/bmain_mdle.html";
    		window.location.href =window._HTTP_IP_PORT+mainPage;
    	}
    };    

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(newVal,oldVal) {
        if (newVal !== oldVal)queryTable();
    });
    function queryInfoPublish() {
        var data= {
            key:infoId
        };
        var promise = $common.get_asyncData("bSysInfoPublishMngService/findBSysInfoPublishMngByKey",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.otherform =data;
                queryTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    function queryTable() {
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            infoId:$scope.otherform.id
        };
        var promise = $common.get_asyncData("bsysUploadFileService/findPublishFileByInfoId",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;

                $scope.datasource.ds =  data.records;;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };
    //保存
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            var data = {
                bSysInfoPublishMng: $scope.otherform
            };
            if(flag=="add"){
                //新增信息保存
                var primise = $common.get_asyncData("bSysInfoPublishMngService/addInfoPublish", data);
            }else if(flag=="update"){
                var primise = $common.get_asyncData("bSysInfoPublishMngService/updateInfoPublish", data);
            }

            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.otherform.id=data.value;
                    var id =$scope.otherform.id
                    $scope. hide = false;

                    //if(id&&id!=undefined&&id!=null&&id!=""){
                    //    $("#fileupload").css('display',''); //显示文件上传
                    //}
                    $common.get_tipDialog('保存成功！', 'showSuccess');
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
                            {name:'reservedValue1', value: $scope.otherform.id}
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
                                        debugger;
                                        $common.get_asyncData('bsysUploadFileService/addInfoPublishFile',{omap:list[0]}).then(function(resf){
                                            if (resf.errorCode =="SUC"){
                                                $common.get_tipDialog('上传成功', 'showSuccess');
                                                queryTable();
                                            }else{
                                                //如果新增本地数据库失败，则删除已上传文件
                                                $.post(_FILE_SERVER_URL+"file/delete.htm",{picId:picdata.picId},function(ress){
                                                    var res=JSON.parse(ress);
                                                    if (res.scubeHeader.errorCode =="SUC") {
                                                        queryTable();
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
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });

        }
    };

    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('bsysUploadFileService/deleteBSysUploadById',{id:$scope.selected.select[0].id}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $.post(_FILE_SERVER_URL+"file/delete.htm",{picId:$scope.selected.select[0].id},function(res){
                            var res=JSON.parse(res);
                            if (res.scubeHeader.errorCode =="SUC") {
                                queryTable();
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

    $scope.downloadoption = {
        inputHidden:[
            /* 从文件服务器下载 start */
            {
                name:'picId', value:function()
            {
                if($scope.selected.select.length <= 0 || $scope.selected.select.length> 1){
                    return "";
                }else{
                    return $scope.selected.select[0].id;
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
            {name:'reservedValue1', value: $scope.otherform.id}
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
                        debugger;
                        $common.get_asyncData('bsysUploadFileService/addInfoPublishFile',{omap:list[0]}).then(function(resf){
                            if (resf.errorCode =="SUC"){
                                $common.get_tipDialog('上传成功', 'showSuccess');
                                queryTable();
                            }else{
                                //如果新增本地数据库失败，则删除已上传文件
                                $.post(_FILE_SERVER_URL+"file/delete.htm",{picId:picdata.picId},function(ress){
                                    var res=JSON.parse(ress);
                                    if (res.scubeHeader.errorCode =="SUC") {
                                        queryTable();
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
    $scope.back_onClick = function () {
        $state.go("list");
    };

};