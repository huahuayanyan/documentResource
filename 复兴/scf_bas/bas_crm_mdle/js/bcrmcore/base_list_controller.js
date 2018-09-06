/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var BaseListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    //初始化查询条件对象
    $scope.conditionForm={
       //查询条件中必须是核心公司去查询
        coreFlag:"1"
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
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
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
            bCrmBaseInfo:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByPage",data);
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
    };

    //核心客户新增1.先弹出框输入组织机构代码 2.再跳转tab表
    $scope.add_onClick = function(){
        $common.get_ngDialog('moni/orgcode_validate.html', $scope
            ,["$scope",function(dialogScope){
                OrgCodeController(dialogScope,$scope,$common,$state,dataDeliver);
            }],"新增客户",{showClose:false});
    };


    //核心客户修改操作
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0 && $scope.selected.select.length> 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var data= {
                flag: "update",
                bCrmBaseInfo:$scope.selected.select[0],
                orgCode:$scope.selected.select[0].orgCode
            };
            $state.go("tree");
            dataDeliver.setter(data);
        }
    };
    //核心客户删除操作
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            if($scope.selected.select[0].custStatus == '00'){
                $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                    var bCrmBaseInfo = $scope.selected.select[0];
                    bCrmBaseInfo.deleteFlag='2';
                    //删除企业信息（这里注意，企业信息是必然含有一个的，所以要嵌套，账户信息可能是没有的，而且是可能多条的，所以需要先查。）
                    var primise2 = $common.get_asyncData('bCrmBaseInfoService/deleteBCrmBaseInfoAndRelated', {bCrmBaseInfo: bCrmBaseInfo});
                    primise2.then(function (res) {
                        if (res.errorCode == "SUC") {//如果删除账户信息失败了，其他信息也都是会继续删除的，所以不能一个事务
                            $scope.queryTable();
                            $scope.selected.select = [];
                            $common.get_tipDialog('删除成功！', 'showSuccess');
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                });
            }else{
                $common.get_tipDialog('有效状态核心厂商客户不可删除，请先改变客户状态为无效！','showInform');
            }
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }

    //监管客户查看操作！
    $scope.column = function(row){
        var data= {
            flag: "view",
            bCrmBaseInfo:row,
            orgCode:row.orgCode
        };
        $state.go("tree");
        dataDeliver.setter(data);
    }
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.custcd = "";
        $scope.conditionForm.cname = "";
        $scope.conditionForm.custStatus = "";
        $scope.$apply();
    }
    //核心厂商状态变更（这里先去查询对应的客户号是否有对应的有效合同，如果有就不允许变更，如果没有就改变对应的铬铜状态）
    $scope.status_onClick = function() {
        if ($scope.selected.select.length == 1) {
            if ($scope.selected.select[0].custStatus == "01") {
                $common.get_tipDialog('是否要将客户状态改为无效？', 'showTip').then(function () {
                    var value = $scope.selected.select[0];
                    var primise2 = $common.get_asyncData('bCrmBaseInfoService/updataCoreCustStatus', {value:value});
                    primise2.then(function (res) {
                        if (res.errorCode == "SUC") {//如果删除账户信息失败了，其他信息也都是会继续删除的，所以不能一个事务
                            $scope.queryTable();
                            $scope.selected.select = [];
                            $common.get_tipDialog('修改状态成功！', 'showSuccess');
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                });
            } else {
                $common.get_tipDialog('是否要将客户状态改为有效？', 'showTip').then(function () {
                    var value = $scope.selected.select[0];
                    value.custStatus="01";
                    var primise2 = $common.get_asyncData('bCrmBaseInfoService/updataBCrmO', {value:value});
                    primise2.then(function (res) {
                        if (res.errorCode == "SUC") {//如果删除账户信息失败了，其他信息也都是会继续删除的，所以不能一个事务
                            $scope.queryTable();
                            $scope.selected.select = [];
                            $common.get_tipDialog('修改状态成功！', 'showSuccess');
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                });
            }
        }
    }

    //表格--------结束-------------------------
};
