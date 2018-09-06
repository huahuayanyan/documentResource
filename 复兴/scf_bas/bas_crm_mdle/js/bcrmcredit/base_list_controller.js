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
    $scope.conditionForm={
        creditFlag:"1" //初始化查询条件对象,必须是授信客户。
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
    //点击刷新之后的搜索
    $scope.fresh_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
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
    //新增授信客户1.先弹出框输入组织机构代码 2.再跳转tab表
    $scope.add_onClick = function(){
        $common.get_ngDialog('bcrmcredit/orgcode_validate.html', $scope
            ,["$scope",function(dialogScope){
                OrgCodeController(dialogScope,$scope,$common,$state,dataDeliver);
            }],"新增授信客户",{showClose:false});
    };

    //授信客户删除操作注意点1.删除要先从其他账户信息删除，客户是h最后一个删除的。
    //2.实际上只有授信客户有删除按钮，其他是没有删除功能的。3.有账户信息（1对多），企业信息，上下游关联信息（1对多），监管公司信息，年审记录表（1对多）至少5帐表需要删除
   //这里我只做客户信息，企业信息删除，其他的需要以后完善，实在是太多了。后台很多代码还是要改，但凡是需要批量删除的后台都要改。累。
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                var bCrmBaseInfo = $scope.selected.select[0];
                bCrmBaseInfo.deleteFlag='1';
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
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    //授信客户修改操作
        $scope.update_onClick = function(){
            if($scope.selected.select.length == 1){
                var data= {
                    flag: "update",
                    bCrmBaseInfo:$scope.selected.select[0],
                    orgCode:$scope.selected.select[0].orgCode
                };
                $state.go("tree");
                dataDeliver.setter(data);
            }else{
                $common.get_tipDialog('请选择一条记录！','showInform');
            }
        };
    //授信客户查看操作！
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
        $scope.$apply();
    }
}
