/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PoolAppplyListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    var dataX=dataDeliver.getter();
    var appno;
    if(dataX.appno){
        appno=dataX.appno
    }
    $scope.conditionForm={
        mastContno:dataX.mastContno,
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
        totalRecord: 0}

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    $scope.rebort_onClick =function(){
        $scope.conditionForm={
            mastContno:dataX.mastContno,
            appno:appno
        };
        $scope.selected.select=[];
        $scope.$apply();
    }
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
    //修改应收账款申请信息
    $scope.updateApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            if($scope.selected.select[0].appliStatus!='00'&& $scope.selected.select[0].appliStatus!='04'){
                $common.get_tipDialog('只有申请状态为“未提交”或者“已退回”状态可修改！','showInform');
                return;
            }
            var data={
                appno:$scope.selected.select[0].appno,
                mastContno:$scope.selected.select[0].mastContno
        }
            dataDeliver.setter(data);
            if($scope.selected.select[0].appliType=='3266'){//入池
                $state.go("inPool");
            }else{
                $state.go("outPool");
            }

        }
    };
    //删除 同时删除了申请业务信息表，明细表
    $scope.deleteApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            if($scope.selected.select[0].appliStatus!='00'&& $scope.selected.select[0].appliStatus!='04'){
                $common.get_tipDialog('只有申请状态为“未提交”或者“已退回”状态可删除！','showInform');
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
            if($scope.selected.select[0].appliType=='3266'){//入池
                $state.go("inPool");
            }else{
                $state.go("outPool");
            }
        }
    }
    //具体申请信息查看
    $scope.column = function(row){
        var data1= {
            flag:"view",
            appno:row.appno,
            mastContno:row.mastContno
        };
        dataDeliver.setter(data1);
        if(row.appliType=='3266'){//入池
            $state.go("inPool");
        }else{
            $state.go("outPool");
        }
    }
    //提交
    $scope.submitApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].appliStatus!='00'&& $scope.selected.select[0].appliStatus!='04'){
                $common.get_tipDialog('只有申请状态为“未提交”或者“已退回”状态可提交！','showInform');
                return;
            }
            $scope.flowsubmitdisable=true;
            var appno=$scope.selected.select[0].appno;
            var url;
            if($scope.selected.select[0].appliType=='3266'){
                 url='debtInPoolService/submitInPoolInfoApply';
            }else{
                url='debtOutPoolService/submitOutPoolInfoApply';
            }
            var promise = $common.get_asyncData(url,{key:appno});
            promise.then(function(res){
                if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                    $scope.selected.select=[];
                    $scope.flowsubmitdisable = false;
                    $scope.queryTable();
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        };
    };
    $scope.showProcess_onClick = function() {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $state.go("showProcess");
            dataDeliver.setter($scope.row);
        }
    };
    //back
    $scope.back_onClick=function(){
        $state.go("debt");//返回上已页面
    }
};
