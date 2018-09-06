/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var bicrinfoAddController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform={};
    $scope.selectbrNo={}; //机构
    $scope.selectArrs={}; //分项额度类型
    $scope.subCreditdatasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.subCreditselected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象已领用分项额度
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.subconf= {//初始化分页对象分项额度
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    var del_creditNo=[];
    //监听已领用分项额度分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(newVal,oldVal){
        if(newVal !=oldVal){
            $scope.queryTable();
        }
    });
    //监听已领用分项额度分页
    $scope.$watch("subconf.pageNo+subconf.pageSize",function(newVal,oldVal){
        if(newVal !=oldVal) {
            $scope.querysubTable();
        }
    });
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
        $scope.otherform.cname=ds.cname;
    };
    $scope.$watch("otherform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            cname:$scope.otherform.cname
            //custcd:$scope.otherform.custcd
        }
    });
    //监听额度总金额
  /*  $scope.$watch("otherform.upCreditAmount",function(){
        $scope.otherform.upCreditUsableAmount= $scope.otherform.upCreditAmount;
    });*/

    //额度总金额 失去焦点
    $scope.creditAmount_onBlur = function(){
        $scope.otherform.upCreditUsableAmount= $scope.otherform.upCreditAmount;
    };
    var  bData =dataDeliver.getter();
    if(bData.flag == "add"){
        //新增信息初始化
        initBIcrInfo();
    }else if (bData.flag == "update"){
        selectBIcrInfoUpdate();
        //设置只读
        $scope.cnameDisable=true;
    }
    function initBIcrInfo(){
        var data ={
        };
        var promise=$common.get_asyncData("bIcrInfoService/initBIcrInfo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
                $scope.selectbrNo.ds =data.listBctl;
                $scope.otherform.brNo=data.brcode;
                $scope.brNoDisable =true;
                $scope.queryTable();
                $scope.querysubTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    function selectBIcrInfoUpdate(){
        var data ={
            creditNo:bData.bicrInfo.creditNo
        };
        var promise=$common.get_asyncData("bIcrInfoService/findBIcrInfoByCreditNo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
                $scope.selectbrNo.ds =data.listBctl;
                $scope.otherform.brNo=data.brcode;
                $scope.brNoDisable =true;
                $scope.queryTable();
                $scope.querysubTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    $scope.queryTable = function(param){
        //以领用生效额度
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            creditNo:$scope.otherform.upCreditNo
        };
        var promise = $common.get_asyncData("bIcrInfoService/findBIcrDrawInfoByPage",data);
        promise.then(function(res){
            var resdata;
            if (res.errorCode =="SUC"){
                resdata = res.contextData;
                $scope.datasource.ds = resdata.records;
                $scope.conf.totalRecord = resdata.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    $scope.querysubTable = function(param){
        //分项额度
        var data= {
            pageNo: $scope.subconf.pageNo,
            pageSize: $scope.subconf.pageSize,
            creditNo:$scope.otherform.upCreditNo
        };
       /* if(bData.flag == "add"){
            var promise = $common.get_asyncData("bIcrInfoService/findBIcrSubInfoByPage",data);
        }else if (bData.flag=="update"){
           var promise = $common.get_asyncData("bIcrInfoService/findBIcrSubInfoByPage",data);
        }*/
        var promise = $common.get_asyncData("bIcrInfoService/findBIcrSubInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                //生成间接额度编号
                //queryManager();
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
               bicrinfosubController(dialogScope,$scope,$common,"add");
           }],"分项额度新增",{showClose:true});
      }

    };
    //修改按钮
     $scope.update_onClick = function(){
         if($scope.subCreditselected.select.length <= 0){
             $common.get_tipDialog('请至少选择一条记录！','showInform');
         }else{
             $common.get_ngDialog('bicrinfo/bicrinfoSubDialog.html',$scope
                 ,["$scope",function(dialogScope){
                     bicrinfosubController(dialogScope,$scope,$common,"update");

                 }],"分项额度修改",{showClose:true});
         }
    };

    $scope.delete_onClick = function() {
        if ($scope.subCreditselected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else {
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.subCreditdatasource.ds;
                var selected = $scope.subCreditselected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].creditNo == selected.creditNo) {
                        del_creditNo.push(selected.creditNo);
                        $scope.subCreditdatasource.ds.splice(i, 1);
                        $scope.subCreditselected.select = [];
                    }
                }
            })
        }
    };
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            var data = {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                bIcrInfo: $scope.otherform,
                delCreditNo:del_creditNo,
                subBIcrInfoList: $scope.subCreditdatasource.ds
            };
            if(bData.flag == "add"){
                //新增信息保存
                var primise = $common.get_asyncData("bIcrInfoService/saveAddInfo", data);
            }else if (bData.flag == "update"){
                var primise = $common.get_asyncData("bIcrInfoService/saveUpdateInfo", data);
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $scope.queryTable();
                    $scope.selected.select = [];
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };
    $scope.back_onClick = function () {
        $state.go("bicrinfo");
    };

    //查看已领用额度详情
    $scope.drawcolumn = function(row){
        /*$state.go("bicrinfoview");*/
        dataDeliver.setter(row);
        $common.get_ngDialog('bicrinfodrawqry/drawqryDtl.html', $scope, ["$scope", function (dialogScope) {
            //弹出层的js逻辑放到单独的controller中，然后在此如下调用：
            drawqryDtlController(dialogScope,$scope,$common,$state,dataDeliver);
        }],"",{showClose:true});
    };
    //查看
    $scope.column = function(row){
        dataDeliver.setter(row);
        $common.get_ngDialog('bicrinfo/bicrinfoSubViewDialog.html',$scope
            ,["$scope",function(dialogScope){
                bicrinfoSubViewController(dialogScope,$scope,dataDeliver,$common,bData.flag);
            }],"分项额度详情",{showClose:true});
    };
    //表格--------结束-------------------------
};
