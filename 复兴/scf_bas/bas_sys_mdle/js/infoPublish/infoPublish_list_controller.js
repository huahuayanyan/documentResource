/**
 * Created by htrad0016 on 2016/8/23.
 */
var infoPublishListController= function ($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });


    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={};
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };


    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            publishInfoQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bSysInfoPublishMngService/findBSysInfoPublishMngByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };
    //新增按钮
    $scope.add_onClick = function(){
        $state.go("edit");
        var data= {
            flag:"add"
        };
        dataDeliver.setter(data);
    };
    //修改
    $scope.update_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else {
            $state.go("edit");
            var data= $scope.selected.select[0];
            data.flag="update";
            dataDeliver.setter(data);
        }
    };
    //删除 根据组件ID
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                var data ={
                    bSysInfoPublishMng: $scope.selected.select[0]
                };
                var primiseA = $common.get_asyncData('bSysInfoPublishMngService/deleteInfoPublish',data);
                primiseA.then(function (res) {
                    if (res.errorCode == "SUC") {//数据中的经办机构要转换成中文
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                        $scope.selected.select = [];
                        $scope.queryTable();
                        var list = res.contextData || [];  //删除镜像的文件
                        for (var x in list) {
                            var picId = list[x];
                            $.post(_FILE_SERVER_URL + "file/delete.htm", {picId: picId}, function (res) {
                                var res = JSON.parse(res);
                                if (res.scubeHeader.errorCode == "SUC") {
                                    //$scope.queryTable();
                                    //$scope.selected.select = [];
                                    //$common.get_tipDialog('附件删除成功', 'showSuccess');
                                } else {
                                    //$common.get_tipDialog('附件删除失败','showError');
                                }
                            });
                        }
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    $scope.column = function(row){
        $state.go("edit");
        row.flag="view";
        dataDeliver.setter(row);
    }
    
    $scope.homeBackHide =true;
    var url = window.location.href;
    if(url.indexOf("needBackFlag")!=-1){
    	 $scope.homeBackHide = false;
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
};