/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var bicrprdListController = function($scope,$common,dataDeliver,$eventCommunicationChannel) {
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
   //额度种类筛选
    $scope.creditTypeContent = {
        type:"table",//展示类型table  tree
        url:"bIcrTypeService/selectBIcrType",//请求url
       // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"creditName",
        column:["creditType","creditName"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.creditName=ds.creditName;
    };
    $scope.$watch("conditionForm.creditName",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.creditTypeContent.param ={
            creditType:$scope.conditionForm.creditType,
            creditName:$scope.conditionForm.creditName
        }
    });

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        //alert("我是分页监听器");
        $scope.queryTable();
    });
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={};
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bIcrType:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bIcrTypeService/findBIcrTypeByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                // queryManager();
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //修改按钮
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
          /*  $common.get_ngDialog('bicrprd/bicrprdBind.html',$scope,["$scope",function(updateScope){
                updateScope.otherform=$common.copy($scope.selected.select[0]);
                updateScope.creditClass=true;
                updateScope.confirm_onClick = function(){
                    if($.doValidate("otherform")){
                       // var primise = $common.get_asyncData("bIcrTypeService/update",{bIcrType:updateScope.otherform});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                $common.get_tipDialog('修改成功！','showSuccess');
                                $scope.queryTable();
                                $scope.selected.select=[];
                                updateScope.closeThisDialog();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        })
                    };
                };
                updateScope.closeThisDialog_onClick = function(){
                    updateScope.closeThisDialog();
                };
            }],'')*/
            $common.get_ngDialog('bicrprd/bicrprdBind.html',$scope
                ,["$scope",function(dialogScope){
                    dataDeliver.setter($scope.selected.select[0]);
                    bicrprdBindController(dialogScope,$scope,$common,dataDeliver);

                }],"",{showClose:true});
        }
    };
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var arrs =$common.copy($scope.selected.select);
                //var  arrs =$scope.selected.select;
                alert(arrs);
                // var primise = $common.get_asyncData('scfContractService/delete',{key:$scope.selected.select[0].id}); //单条记录
                var primise = $common.get_asyncData('bIcrTypeService/batchDelete',{voList:arrs});
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
        }
    };
    $scope.fresh_onClick = function(){
        $scope.queryTable($scope.conditionForm);
        $scope.selected.select=[];
    };
    $scope.column = function(row){
        console.log(JSON.stringify(row))
    };
    //表格--------结束-------------------------
};
