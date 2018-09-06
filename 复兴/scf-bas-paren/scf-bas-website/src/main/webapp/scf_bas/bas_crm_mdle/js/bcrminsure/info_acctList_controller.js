/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var AccInfoListController = function($scope,$common,$state,dataDeliver) {
    var data1= dataDeliver.getter();
    var flag = data1.flag;
    var bCrmBaseInfo2={
        orgCode:data1.orgCode
    }
    var custcd1="";
    var cname1="";

    $scope.hide =false;

    if(data1.flag == "add"){
        var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey", {bCrmBaseInfo: bCrmBaseInfo2});
        primise.then(function (res) {
            var data2 = res.contextData;
            if (res.errorCode =="SUC") {
                //先判断已经完成保存！
                if (data2.orgCode == data1.orgCode) {//查到说明数据已经保存成功
                    custcd1 = data2.custcd;// 声明客户号
                    cname1 = data2.cname;// 声明客户名称
                    $scope.conditionForm = {
                        custcd: custcd1
                    };//初始化条件查询框
                    $scope.datasource = {//初始化表格对象
                        ds: []
                    };
                    $scope.selected = {//初始化对象
                        select: []
                    };
                    $scope.conf = {//初始化分页对象
                        pageNo: 1,
                        pageSize: 10,
                        totalRecord: 0
                    }
                    //监听分页
                    $scope.$watch("conf.pageNo+conf.pageSize", function () {
                        $scope.queryTable();
                    });
                    //查询操作brName,brNo
                    $scope.queryTable = function (paramData) {
                        var data = {
                            pageNo: $scope.conf.pageNo,
                            pageSize: $scope.conf.pageSize,
                            bAccAccountInfo: $scope.conditionForm
                        };
                        var promise = $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByPage", data);
                        promise.then(function (res) {
                            var data;
                            if (res.errorCode == "SUC") {//数据中的经办机构要转换成中文
                                data = res.contextData;
                                $scope.datasource.ds = data.records;
                                $scope.conf.totalRecord = data.totalRecord;
                            } else {
                                $common.get_tipDialog(res.errorMsg, 'showError');
                            }
                        });
                    };
                } else {
                    $state.go("tree.basic");
                    $scope.$parent.panes.forEach(function(pane){
                        if (pane.uiSref == "tree.basic"){
                                $scope.$parent.select(pane);
                        };
                });
                    $common.get_tipDialog('请先完成客户基本信息保存！', 'showInform');
                }
            }else{
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }else{//修改查看页面

        if(flag=="view"){
            $scope.hide =true;
        }
        custcd1=data1.bCrmBaseInfo.custcd;
        cname1=data1.bCrmBaseInfo.cname;// 声明客户名称
        //-------------------页面初始化--------------
        $scope.conditionForm={
            custcd:custcd1
        };//初始化条件查询框

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
        //查询操作brName,brNo
        $scope.queryTable = function(paramData){
            $scope.conditionForm.custcd = custcd1;
            var data= {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                bAccAccountInfo:$scope.conditionForm
            };
            var promise = $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByPage",data);
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
    }
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

    //重置按钮accountNo,accountType
    $scope.rebort_onClick =function(){
        $scope.conditionForm.accountNo = "";
        $scope.conditionForm.accountType = "";
        $scope.selected.select =[];
        $scope.queryTable();
    }

    //----------------------------------点击事件------------------------------
    //新增账户信息
    $scope.add_onClick = function(){
        $scope.disable=false;
        var row={
            custcd:custcd1,// 声明客户号
            cname:cname1// 声明客户名称
        };
        $common.get_ngDialog('bcrmfactor/acc_add.html', $scope
            ,["$scope",function(dialogScope){
                AccInfoAddController(dialogScope,$scope,$common,"add",row);
            }],"新增账户",{showClose:false});
    };
    //账户信息删除操作(这里删除是单条删除，但是后台要准备好多条删除。所以，应该是要传个list才对。要改)
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var arrs =$common.copy($scope.selected.select);//{voList:arrs}
                var primise = $common.get_asyncData('bAccAccountInfoService/batchDelete',{idList:arrs})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select = [];
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    //账户信息修改操作
    $scope.update_onClick = function(){
        var row ={};
        if($scope.selected.select.length == 1){
            $scope.disable=true;
            $common.get_ngDialog('bcrmfactor/acc_add.html', $scope
                ,["$scope",function(dialogScope){
                    AccInfoAddController(dialogScope,$scope,$common,"update",row);
                }],"修改账户",{showClose:false});
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //账户信息查看操作！
    $scope.column = function(row){
        $scope.disable=true;
        $common.get_ngDialog('bcrmcredit/acc_add.html', $scope
            ,["$scope",function(dialogScope){
                AccInfoAddController(dialogScope,$scope,$common,"view",row);
            }],"查看账户",{showClose:false});
    }

    //返回按钮confuse
    $scope.confuse_onClick=function(){
        $state.go("base");
    }

};
