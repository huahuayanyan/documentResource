/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var InPoolAppplyListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    var dataX=dataDeliver.getter();
    var appno;
    if(dataX.appno){
        appno=dataX.appno
    }
    $scope.conditionForm={
        mastContno:dataX.mastContno,
        appliType:'3266',
        appno:appno
    };
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
    $scope.rebort_onClick =function(){
        $scope.conditionForm={
            mastContno:dataX.mastContno,
            appliType:'3266',
            appno:appno
        };
        $scope.selected.select=[];
        $scope.$apply();
    };
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("debtInPoolService/queryPoolBPbcAppliBaseInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //新增申请
    $scope.addApply_onClick = function(){
        var data={
            mastContno:dataX.mastContno
        };
        dataDeliver.setter(data);
        $state.go("inPool");//跳转到入池申请页面
    };
    //修改应收账款申请信息
    $scope.updateApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appliStatus;
            if(appliStatus=="01"||appliStatus=="05")
            {
                $common.get_tipDialog('该记录已提交，不可修改！','showInform');
                return;
            }
            else if(appliStatus=="02")
            {
                $common.get_tipDialog('该记录已通过，不可修改！','showInform');
                return;
            }
            else if(appliStatus=="03")
            {
                $common.get_tipDialog('该记录已拒绝，不可修改！','showInform');
                return;
            }
            var data={
                appno:row.appno,
                mastContno:row.mastContno
            };
            dataDeliver.setter(data);
            $state.go("inPool");
        }
    };
    //删除 同时删除了申请业务信息表，明细表
    $scope.deleteApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appliStatus;
            if(appliStatus=="01"||appliStatus=="05")
            {
                $common.get_tipDialog('该记录已提交，不可删除！','showInform');
                return;
            }
            else if(appliStatus=="02")
            {
                $common.get_tipDialog('该记录已通过，不可删除！','showInform');
                return;
            }
            else if(appliStatus=="03")
            {
                $common.get_tipDialog('该记录已拒绝，不可删除！','showInform');
                return;
            }
            var data1= {
               list:$scope.selected.select
            };
            var promise = $common.get_asyncData("bPbcAppliBaseInfoService/batchDeleteBPbcAppliBaseInfoAndRelated",data1);
            promise.then(function(res){
                if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                    $common.get_tipDialog('删除成功！', 'showSuccess');
                    $scope.selected.select=[];
                    $scope.queryTable();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    //查看按钮
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            var data1= {
                flag:"view",
                appno:$scope.selected.select[0].appno,
                mastContno:$scope.selected.select[0].mastContno
            };
            dataDeliver.setter(data1);
            $state.go("inPool");
        }
    };
    //具体申请信息查看
    $scope.column = function(row){
        var data1= {
            flag:"view",
            appno:row.appno,
            mastContno:row.mastContno
        };
        dataDeliver.setter(data1);
        $state.go("inPool");
    };
    //提交
    $scope.submitApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appliStatus;
            if(appliStatus=="01"||appliStatus=="05")
            {
                $common.get_tipDialog('该记录已提交，不可重复提交！','showInform');
                return;
            }
            else if(appliStatus=="02")
            {
                $common.get_tipDialog('该记录已通过，不可提交！','showInform');
                return;
            }
            else if(appliStatus=="03")
            {
                $common.get_tipDialog('该记录已拒绝，不可提交！','showInform');
                return;
            }
            $scope.flowsubmitdisable=true;
            var appno=$scope.selected.select[0].appno;
            $common.get_asyncData('debtInPoolService/submitInPoolInfoApply',{key:appno}).then(function(res){
                if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                    $scope.selected.select=[];
                    $scope.flowsubmitdisable = false;
                    $scope.queryTable();
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                }else{
                    $scope.flowsubmitdisable = false;
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    $scope.showProcess_onClick = function() {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            var appliStatus = $scope.row.appliStatus;
            if(appliStatus=="00")
            {
                $common.get_tipDialog('该记录未提交，暂无流程轨迹信息！','showInform');
                $scope.selected.select=[];
                return;
            }
            $state.go("showProcess");
            dataDeliver.setter($scope.row);
        }
    };
    //back
    $scope.back_onClick=function(){
        $state.go("list");//返回上已页面
    }
};
