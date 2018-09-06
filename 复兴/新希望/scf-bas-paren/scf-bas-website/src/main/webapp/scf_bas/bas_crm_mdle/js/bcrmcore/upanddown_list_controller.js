/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var UpanddownListController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
        // 如果flag不是add则必须data.bCrmBaseInfo.custcd取custcd
        // data2：是当为增加页面跳转过来的时候从数据库查询出来的，这个数据里面直接就是一个bCrmBaseInfo，custcd=data2.custcd
       //bCrmBaseInfo是一开始有组织机构代码的基本客户对象用于查询是否成功保存基本客户
        var data= dataDeliver.getter();
        var bCrmBaseInfo={
                orgCode:data.orgCode
        }
        var coreCustcd="";
        var coreCustName=""
        //##################################主页面新增操作跳转到上下游客户关联关系页面#######################
        if(data.flag == "add"){
                var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:bCrmBaseInfo});
                primise.then(function(res){
                var data2 = res.contextData;
                if (data2 != null && data2.orgCode==data.orgCode){ //判断已经完成保存！可以查到数据。
                        coreCustcd=data2.custcd;//赋值给核心客户号和客户名称
                        coreCustName=data2.cname;
                        $scope.conditionForm={
                                coreCustcd:coreCustcd
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
                        $scope.$watch("conf.pageNo+conf.pageSize",function() {
                                $scope.queryTable();
                        })
                        //上下游客户信息查询操作
                        $scope.queryTable = function(paramData){
                                var data1= {
                                        pageNo: $scope.conf.pageNo,
                                        pageSize: $scope.conf.pageSize,
                                        bCrmUpanddownRel:$scope.conditionForm
                                };
                                var promise = $common.get_asyncData("bCrmUpanddownRelService/findBCrmUpanddownRelByPage",data1);
                                promise.then(function(res){
                                        var data3;
                                        if (res.errorCode =="SUC"){
                                                data3 = res.contextData;
                                                $scope.datasource.ds = data3.records;
                                                $scope.conf.totalRecord = data3.totalRecord;
                                        }else{
                                                $common.get_tipDialog(res.errorMsg,'showError');
                                        }
                                });

                        };
                }else{//未完成保存就跳转客户关联关系页面，进行提示！
                        $state.go("tree.add");//直接跳转到新增页面
                        $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.add"){
                                        $scope.$parent.select(pane);
                                };
                        });
                        $common.get_tipDialog("请先完成核心客户保存操作！",'showError');
                }
                });
        }else {//修改或者查看页面custcd:data.bCrmBaseInfo.custcd
                if(data.flag=="view"){
                        $scope.hide=true;
                }
                coreCustcd= data.bCrmBaseInfo.custcd;
                coreCustName=data.bCrmBaseInfo.cname;
                $scope.conditionForm={
                        coreCustcd:coreCustcd
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
                $scope.$watch("conf.pageNo+conf.pageSize",function() {
                        $scope.queryTable();
                })
                //上下游客户信息查询操作
                $scope.queryTable = function(paramData){
                        var data1= {
                                pageNo: $scope.conf.pageNo,
                                pageSize: $scope.conf.pageSize,
                                bCrmUpanddownRel:$scope.conditionForm
                        };
                        var promise = $common.get_asyncData("bCrmUpanddownRelService/findBCrmUpanddownRelByPage",data1);
                        promise.then(function(res){
                                var data3;
                                if (res.errorCode =="SUC"){
                                        data3 = res.contextData;
                                        $scope.datasource.ds = data3.records;
                                        $scope.conf.totalRecord = data3.totalRecord;
                                }else{
                                        $common.get_tipDialog(res.errorMsg,'showError');
                                }
                        });

                };

        }

//------------------------------------------点击事件-------------------------------
        //点击查询之后的搜索
        $scope.submit_onClick =function(){
                $scope.queryTable();
                $scope.selected.select=[];
        };
        //重置按钮
        $scope.rebort_onClick =function(){
                $scope.conditionForm.custcd = "";
                $scope.$apply();
        }
        //上下游客户关联关系新增
        $scope.add_onClick = function(){
                $scope.disable=true;
                var　row={
                        coreCustName:coreCustName,//核心客户名称
                        coreCustcd:coreCustcd//和核心厂商客户号传给弹出页面
                };
                $common.get_ngDialog('bcrmcore/upanddown_add.html', $scope
                    ,["$scope",function(dialogScope){
                            UpanddownAddController(dialogScope,$scope,$common,"add",row);
                    }],"新增操作",{showClose:false});
        };
        //客户关联关系删除
        $scope.delete_onClick = function(){
                if($scope.selected.select.length == 1 ){
                        $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                                var primise = $common.get_asyncData('bCrmUpanddownRelService/delete',{key:$scope.selected.select[0].id})
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
        //客户关联关系修改
        $scope.update_onClick = function(){//这里修改是根据ID
                var row={};
                if($scope.selected.select.length == 1){
                        $scope.disable=true;
                        $common.get_ngDialog('bcrmcore/upanddown_add.html',$scope
                            ,["$scope",function(dialogScope){
                                    UpanddownAddController(dialogScope,$scope,$common,"update",row);
                            }],"修改操作",{showClose:false});
                }else{
                        $common.get_tipDialog('请选择一条记录！','showInform');
                };
        };
        //查看功能
        $scope.column = function(row){//custcd,cname,orgCode,coreRelationFlg,state,coreCustName,coreCustcd，tlrName，brName
                $scope.disable=true;
                $common.get_ngDialog('bcrmcore/upanddown_add.html',$scope
                    ,["$scope",function(dialogScope){
                            UpanddownAddController(dialogScope,$scope,$common,"view",row);
                    }],"上下游客户关联关系",{showClose:false});
        }
        //返回按钮
        $scope.confuse_onClick=function(){
                $state.go("base");
        }
};



