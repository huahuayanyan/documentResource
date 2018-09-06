/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var bailtransferapplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
	$scope.conditionForm={custcd:"",prdId:""};
    $scope.custcontent = {
            type:"table",//展示类型table  tree
            url:"ibDcrLinAppService/queryCustSource",
            param:{},
            split:"-",//分隔符
            extentColumn:"",
            column:["custcd","cname"]//展示内容
        };
    $scope.doextend= function(ds){
        	$scope.conditionForm.custcd=ds.custcd;
        	$scope.conditionForm.custNm=ds.cname;

        };   
      $scope.$watch("conditionForm.custnm",function(){
        	if($scope.conditionForm.custcd!=null) $scope.custcontent.param ={custcd:$scope.conditionForm.custNm,cname:$scope.conditionForm.custNm};
        });    

      
      /**
       * 业务品种筛选开始
       */
      $scope.productNameContent = {
          type:"table",//展示类型table  tree
          url:"bSysCommonService/selectBusinessTypeByPage",
          param:{ tFactType:"0" },
          split:",",//分隔符
          extentColumn:"",
          column:["productName","productId"]//展示内容
      };
      $scope.productNamedooextent = function(ds){

          $scope.conditionForm.prdNm=ds.productName;
          $scope.conditionForm.prdId=ds.productId; //业务品种
          $scope.conditionForm.parentId = ds.parentId;
      };
      
      $scope.loanContent = {
          type:"table",//展示类型table  tree
          url:"bCrrLnConService/queryBCrrLnConLst",
          param:$scope.conditionForm,
          split:",",//分隔符
          extentColumn:"",
          column:["appId","appStat"]//展示内容
      };
      $scope.doloanContent = function(ds){
          $scope.conditionForm.mastContCode=ds.appId;
       };
            
      
//提交
$scope.submit_onClick = function(){
    if($.doValidate("conditionForm")) {
	    dataDeliver.setter($scope.conditionForm);
	    $state.go("bailtransferapplyinfo");
    }
};



};