/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var recoverApplyController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.otherform={
    };
	var bData =dataDeliver.getter();
    init();
    function init(){
        findBIcrInfoMain();
    }
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
   };
   $scope.$watch("otherform.cname",function(){
       //ht-input-extent  需要用监听的方式来传额外的参数
       $scope.cnameContent.param ={
    		 cname:$scope.otherform.cname,
            custcd:$scope.otherform.custcd
       }
   });
   //额度种类筛选
   $scope.creditTypeContent = {
       type:"table",//展示类型table  tree
       url:"bIcrTypeService/selectBIcrType",//请求url
       // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
       split:"-",//分隔符
       extentColumn:"creditName",
       column:["creditType","creditName"]//展示内容
   };
   $scope.creditNamedooextent = function(ds){
   	$scope.otherform.creditType=ds.creditType;
   };
   $scope.$watch("otherform.creditName+otherform.creditType",function(){
       //ht-input-extent  需要用监听的方式来传额外的参数
   	$scope.creditTypeContent.param ={
           creditType:$scope.otherform.creditType,
           creditName:$scope.otherform.creditName,
           creditClass:"3" //间接额度
       }
   });
    //交易对手筛选
    $scope.otherCnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.otherCnamedooextent = function(ds){
        $scope.otherform.otherCname=ds.cname;
        $scope.otherform.otherCustcd=ds.custcd;
    };
    $scope.$watch("otherform.otherCname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.otherCnameContent.param ={
            cname:$scope.otherform.otherCname,
            custcd: $scope.otherform.otherCustcd,
            creditFlag:"1" // 授信客户标识：0-否、1-是
        }
    });
    //查询间接额度信息
    function findBIcrInfoMain(){
        var data ={
            creditNo:bData.creditNo
        };
        var promise=$common.get_asyncData("bIcrInfoService/findBIcrInfoMainByCreditNo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            var data = {
                bIcrInfo: $scope.otherform
            };
            //校验
            var custcd =$scope.otherform.custcd; //核心客户
            var cname =$scope.otherform.cname;
            var creditcustcd = $scope.otherform.otherCustcd; //授信客户
            var otherCname =$scope.otherform.otherCname;
            var amount =$scope.otherform.amount;
            var creditUsableAmount = $scope.otherform.creditUsableAmount;//可用额度
            if(custcd==creditcustcd||otherCname==cname){
                $common.get_tipDialog('选择的交易对手与核心企业相同，请重新选择！','showInform');
                return false;
            }
            if(amount>creditUsableAmount){
                $common.get_tipDialog('本次回收额度不能大于未分配额度！','showInform');
                return false;
            }

            var primise = $common.get_asyncData("bIcrInfoService/BIcrInfoRecoverSaveUpdate", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $state.go("recoverList"); //返回查询列表
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };
    //返回
    $scope.back_onClick = function () {
        $state.go("recoverList");
    };
    //表格--------结束-------------------------
};
