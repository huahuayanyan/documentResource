/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var AnalListController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
       //data1:是一开始从dataDdliver中获得的 如果flag是add，那么取custcd=data2.custcd，
        // 如果flag不是add则必须data1.bCrmBaseInfo.custcd取custcd
        // data2：是当为增加页面跳转过来的时候从数据库查询出来的，这个数据里面直接就是一个bCrmBaseInfo，custcd=data2.custcd
        var data1= dataDeliver.getter();
        var bCrmBaseInfo1={
                orgCode:data1.orgCode
        }
        var custcd="";
        if(data1.flag == "add"){
                var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:bCrmBaseInfo1});
                primise.then(function(res){
                        data2 = res.contextData;
                        if(res.errorCode =="SUC"){
                        if (data2.orgCode == data1.orgCode){
                                custcd=data2.custcd;// 声明客户号
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
                                //客户分析信息查询操作
                                $scope.queryTable = function(paramData){
                                        var bCrmAnalInfo2={
                                                custcd:custcd
                                        };
                                        var data= {
                                                pageNo: $scope.conf.pageNo,
                                                pageSize: $scope.conf.pageSize,
                                                bCrmAnalInfo:bCrmAnalInfo2
                                        };
                                        var promise = $common.get_asyncData("bCrmAnalInfoService/findBCrmAnalInfoByPage",data);
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
                        }else{//未完成保存就跳转客户情况分析页面，进行提示！
                                $state.go("tree.add");
                                $scope.$parent.panes.forEach(function(pane){
                                        if (pane.uiSref == "tree.add"){
                                                $scope.$parent.select(pane);
                                        };
                                });
                                $common.get_tipDialog("请先完成客户信息保存操作！",'showError');
                        }
                        }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                        }
                });
        }else {//修改或者查看页面custcd:data1.bCrmBaseInfo.custcd客户号一定要传给弹出页面。
                if(data1.flag=="view"){
                        $scope.hide=true;
                }
                custcd=data1.bCrmBaseInfo.custcd;// 声明客户号
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
                //客户分析信息查询操作
                $scope.queryTable = function(paramData){
                        var bCrmAnalInfo2={
                                custcd:custcd
                        };
                        var data= {
                                pageNo: $scope.conf.pageNo,
                                pageSize: $scope.conf.pageSize,
                                bCrmAnalInfo:bCrmAnalInfo2
                        };
                        var promise = $common.get_asyncData("bCrmAnalInfoService/findBCrmAnalInfoByPage",data);
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
        //--------------------------点击事件-------------------------------
        //客户情况分析新增(必须传给后台客户号)
        $scope.add_onClick = function(){
                var row={
                        custcd:custcd,
                };
                $common.get_ngDialog('bcrmcredit/anal_add.html', $scope
                    ,["$scope",function(dialogScope){
                            AnalAddController(dialogScope,$scope,$common,"add",row);
                    }],"新增操作",{showClose:false});
        };
        //客户情况分析修改(根据ID来修改)
        $scope.update_onClick = function(){
                var row={};
                if($scope.selected.select.length == 1){
                        $common.get_ngDialog('bcrmcredit/anal_add.html',$scope
                            ,["$scope",function(dialogScope){
                                    AnalAddController(dialogScope,$scope,$common,"update",row);
                            }],"修改操作",{showClose:true});
                }else{
                        $common.get_tipDialog('请选择一条记录！','showInform');
                };
        };
        //客户情况分析删除（根据ID删除）
        $scope.delete_onClick = function(){
                if($scope.selected.select.length == 1 ){
                        $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                                var primise = $common.get_asyncData('bCrmAnalInfoService/delete',{key:$scope.selected.select[0].id})
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
        //查看功能
        $scope.column = function(row){
                $common.get_ngDialog('bcrmcredit/anal_add.html',$scope
                    ,["$scope",function(dialogScope){
                            AnalAddController(dialogScope,$scope,$common,"view",row);
                    }],"客户分析情况",{showClose:true});

                // console.log(JSON.stringify(row))
        }
        //返回按钮
        $scope.confuse_onClick=function(){
                $state.go("base");
        }
};



