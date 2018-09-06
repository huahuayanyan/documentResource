/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var bicrinfoViewController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform={};
    $scope.selectbrNo={}; //机构

    $scope.selected={//初始化对象
        select: []
    };

    $scope.subconf= {//初始化分页对象分项额度
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听分项额度分页
    $scope.$watch("subconf.pageNo+subconf.pageSize",function(newVal,oldVal){
        if(newVal!=oldVal){
            $scope.querysubTable();
        }
    });
    var bData=dataDeliver.getter();
    selectBIcrInfoUpdate();

//间接额度客户名称筛选
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.otherform.custcd=ds.custcd;
        $scope.otherform.cname=ds.custcd;
    };
    $scope.$watch("otherform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            bCrmBaseInfo:$scope.otherform.cname
        }
    });
    //监听额度总金额
    //$scope.$watch("otherform.upCreditAmount",function(){
    //    $scope.otherform.upCreditUsableAmount= $scope.otherform.upCreditAmount;
    //});
    function selectBIcrInfoUpdate(){
        var data ={
            creditNo:bData.creditNo
        };
        var promise=$common.get_asyncData("bIcrInfoService/findBIcrInfoByCreditNo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
                $scope.selectbrNo.ds =data.listBctl;
                $scope.otherform.brNo=data.brcode;
                $scope.brNoDisable =true;
                $scope.querysubTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    $scope.querysubTable = function(param){
        //分项额度
        var data= {
            pageNo: $scope.subconf.pageNo,
            pageSize: $scope.subconf.pageSize,
            creditNo:$scope.otherform.upCreditNo
        };
        var promise = $common.get_asyncData("bIcrInfoService/findBIcrSubInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                //查询额度
                data = res.contextData;
                $scope.subCreditdatasource.ds = data.records;
                $scope.subconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //分项额度新增
    $scope.add_onClick = function(){
        if($.doValidate("otherform")){
            $common.get_ngDialog('bicrinfo/bicrinfoSubDialog.html', $scope
                ,["$scope",function(dialogScope){
                    bicrinfoSubController(dialogScope,$scope,$common,"add");
                }],"分项额度新增",{showClose:false});
        }

    };
    //修改按钮
    $scope.update_onClick = function(){
        if($scope.subCreditselected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('bicrinfo/bicrinfoSubDialog.html',$scope
                ,["$scope",function(dialogScope){
                    bicrinfoSubController(dialogScope,$scope,$common,"update");
                }],"分项额度修改",{showClose:true});
        }
    };

    $scope.delete_onClick = function() {
        if ($scope.subCreditselected.select.length <= 0) {
            $common.get_tipDialog('请至少选择一条记录！', 'showInform');
        } else {
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.subCreditdatasource.ds;
                var selected = $scope.subCreditselected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].creditNo == selected.creditNo) {
                        $scope.subCreditdatasource.ds.splice(i, 1);
                        $scope.subCreditselected.select = [];
                    }
                }
            })
        }

    };
    $scope.column = function(row){
        dataDeliver.setter(row);
        $common.get_ngDialog('bicrinfo/bicrinfoSubViewDialog.html',$scope
            ,["$scope",function(dialogScope){
                bicrinfoSubViewController(dialogScope,$scope,dataDeliver,$common,"view");
            }],"分项额度详情",{showClose:true});
    };
    $scope.back_onClick = function () {
        $state.go("bicrinfo");
    };
    //表格--------结束-------------------------
};
