/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var InsureListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    //初始化查询条件对象
    $scope.conditionForm={
        //是否为法人
        custType_Q:1,
        //是否为保险公司
        insureFlag_Q:1
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
            customerQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrmInsureCustomerService/findInsureCustomerByPage",data);
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

    //新增操作 1.先弹出框输入组织机构代码 2.再跳转tab表
    $scope.add_onClick = function(){
        $common.get_ngDialog('bcrminsure/orgcode_dialog.html', $scope
            ,["$scope",function(dialogScope){
                OrgCodeController(dialogScope,$scope,$common,$state,dataDeliver);
            }],"新增客户",{showClose:false});
    };

    //修改操作
    $scope.update_onClick = function(){

        if($scope.selected.select.length==1){
            var row = $scope.selected.select[0];
            //var bCrmBaseInfoVal ={};
            var qryParams={customerQryVO: {custcd:row.custcd}};
            $common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams).then(function(res){
                if(res.errorCode="SUC"){
                    row = res.contextData;
                    $state.go("tree");
                    var data ={
                        flag:"update",
                        bCrmBaseInfo:row
                    }
                    dataDeliver.setter(data);
                }else{
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            })
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }

    };

    //删除操作
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                var bCrmBaseInfo = $scope.selected.select[0];
                //删除企业信息（这里注意，企业信息是必然含有一个的，所以要嵌套，账户信息可能是没有的，而且是可能多条的，所以需要先查。）
                var primise2 = $common.get_asyncData('bCrmBaseInfoService/deleteBCrmBaseInfoCompletely', {bCrmBaseInfo: bCrmBaseInfo});
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

    //查看操作！
    $scope.column = function(row){
        var qryParams={customerQryVO: {custcd:row.custcd}};
        $common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams).then(function(res){
            if(res.errorCode="SUC"){
                row = res.contextData;
                $state.go("tree");
                var data ={
                    flag:"view",
                    bCrmBaseInfo:row
                }
                dataDeliver.setter(data);
            }else{
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }

    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.cname_Q = {};
        $scope.conditionForm={
            custType_Q:1,
            insureFlag_Q:1
        };
        $scope.selected=[];
        $scope.queryTable();
    }
    //表格--------结束-------------------------
};
