/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var RelationListController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
        // 如果flag不是add则必须data1.bCrmBaseInfo.custcd取custcd
        // data2：是当为增加页面跳转过来的时候从数据库查询出来的，这个数据里面直接就是一个bCrmBaseInfo，custcd=data2.custcd
       //bCrmBaseInfo1是一开始有组织机构代码的基本客户对象用于查询是否成功保存基本客户
        var data1= dataDeliver.getter();
        var bCrmBaseInfo1={
                orgCode:data1.orgCode
        }
        //##################################主页面新增操作跳转到客户情况分析页面#######################
        if(data1.flag == "add"){
                var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:bCrmBaseInfo1});
                primise.then(function(res){
                        data2 = res.contextData;
                        if (data2.orgCode==data1.orgCode){ //判断已经完成保存！可以查到数据。
                                $scope.conditionForm={//初始化表格对象，核心客户号就是数据库保存成功的客户号
                                        coreCustcd:data2.custcd
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
                                })
                                //客户关联关系信息查询操作
                                $scope.queryTable = function(paramData){
                                        var data= {
                                                pageNo: $scope.conf.pageNo,
                                                pageSize: $scope.conf.pageSize,
                                                bCrmRelationInfo:$scope.conditionForm
                                        };
                                        var promise = $common.get_asyncData("bCrmRelationInfoService/findBCrmRelationInfoByPage",data);
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
                                //--------------------------点击事件-------------------------------
                                //客户关联关系新增
                                $scope.add_onClick = function(){
                                        var　row={
                                                coreCustcd:data2.custcd//和核心厂商客户号传给弹出页面
                                        };
                                        $common.get_ngDialog('bcrmcore/relation_add.html', $scope
                                            ,["$scope",function(dialogScope){
                                                    RelationAddController(dialogScope,$scope,$common,"add",row);
                                            }],"新增操作",{showClose:false});
                                };
                                //客户关联关系修改
                                $scope.update_onClick = function(){//修改的时候需要根据ID里修改而不是客户号
                                       var row={};
                                        if($scope.selected.select.length == 1){
                                                $common.get_ngDialog('bcrmbase/anal_add.html',$scope
                                                    ,["$scope",function(dialogScope){
                                                            RelationAddController(dialogScope,$scope,$common,"update",row);
                                                    }],"修改操作",{showClose:true});
                                        }else{
                                                $common.get_tipDialog('请选择一条记录！','showInform');
                                        };
                                };
                                //客户关联关系删除
                                $scope.delete_onClick = function(){
                                        if($scope.selected.select.length == 1 ){
                                                $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                                                        var primise = $common.get_asyncData('bCrmRelationInfoService/delete',{key:$scope.selected.select[0].id})
                                                        primise.then(function(res){
                                                                if (res.errorCode =="SUC"){
                                                                        $scope.queryTable();
                                                                        $scope.selected.select=[];
                                                                        $common.get_tipDialog('删除成功！','showSuccess');
                                                                }else{
                                                                        $common.get_tipDialog(res.errorMsg,'showError');
                                                                }
                                                        })
                                                })
                                        }else{
                                                $common.get_tipDialog('请选择一条记录！','showInform');
                                        }
                                }
                        }else{//未完成保存就跳转客户关联关系页面，进行提示！
                                $common.get_tipDialog("请先完成核心客户保存操作！",'showError');
                        }
                });
             //##################################主页面修改查看操作跳转到客户情况分析页面#######################
                //主页面修改或者查看操作跳转过来无区别，都可以操作客户关联关系表
        }else {//新增或者查看页面custcd:data1.bCrmBaseInfo.custcd
                var coreCustcd1= data1.bCrmBaseInfo.custcd;
                $scope.conditionForm={//初始化表格对象，核心客户号就是数据库保存成功的客户号
                        coreCustcd:coreCustcd1
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
                })
                //客户关联关系信息查询操作
                $scope.queryTable = function(paramData){
                        var data= {
                                pageNo: $scope.conf.pageNo,
                                pageSize: $scope.conf.pageSize,
                                bCrmRelationInfo:$scope.conditionForm
                        };
                        var promise = $common.get_asyncData("bCrmRelationInfoService/findBCrmRelationInfoByPage",data);
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
                //--------------------------点击事件-------------------------------
                //客户关联关系新增
                $scope.add_onClick = function(){
                        var　row={
                                coreCustcd:data1.bCrmBaseInfo.custcd//和核心厂商客户号传给弹出页面
                        };
                        $common.get_ngDialog('bcrmcore/relation_add.html', $scope
                            ,["$scope",function(dialogScope){
                                    RelationAddController(dialogScope,$scope,$common,"add",row);
                            }],"新增操作",{showClose:false});
                };
                //客户关联关系修改
                $scope.update_onClick = function(){//修改的时候需要根据ID里修改而不是客户号
                        var row={};
                        if($scope.selected.select.length == 1){
                                $common.get_ngDialog('bcrmcore/relation_add.html',$scope
                                    ,["$scope",function(dialogScope){
                                            RelationAddController(dialogScope,$scope,$common,"update",row);
                                    }],"修改操作",{showClose:true});
                        }else{
                                $common.get_tipDialog('请选择一条记录！','showInform');
                        };
                };
                //客户关联关系删除
                $scope.delete_onClick = function(){
                        if($scope.selected.select.length == 1 ){
                                $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                                        var primise = $common.get_asyncData('bCrmRelationInfoService/delete',{key:$scope.selected.select[0].id})
                                        primise.then(function(res){
                                                if (res.errorCode =="SUC"){
                                                        $scope.queryTable();
                                                        $scope.selected.select=[];
                                                        $common.get_tipDialog('删除成功！','showSuccess');
                                                }else{
                                                        $common.get_tipDialog(res.errorMsg,'showError');
                                                }
                                        })
                                })
                        }else{
                                $common.get_tipDialog('请选择一条记录！','showInform');
                        }
                }
                //##################################主页面查看操作跳转到客户情况分析页面#######################
        }

        //查看功能
        $scope.column = function(row){
                $common.get_ngDialog('bcrmcore/relation_add.html',$scope
                    ,["$scope",function(dialogScope){
                            RelationAddController(dialogScope,$scope,$common,"view",row);
                    }],"客户关联关系",{showClose:true});

                // console.log(JSON.stringify(row))
        }
        //表格--------结束-------------------------
        //返回按钮
        $scope.confuse_onClick=function(){
                $state.go("base");
        }
};



