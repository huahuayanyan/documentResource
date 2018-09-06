/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var lncimarginapplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
	$scope.updateForm={appno:null};
    $scope.infoform = dataDeliver.getter();

    $scope.back_onClick = function () {
        $state.go("lncimarginlist");
    };
    //回款保证金账号
    $scope.bailAcctNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        param:{custcd:$scope.infoform.custcd, accountType:"3" },//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.bailAcctNodooextent = function(ds){
        $scope.updateForm.bailAccountno=ds.accountNo;
        //  $scope.otherform.ID=ds.ID;
    };


    
    
    $scope.save_onClick = function(){
    	 if($.doValidate("updateForm")) {
    	        var data = {
    	          	  bmrnAppliAcctInfo: $scope.updateForm
    	          };
    	          data.bmrnAppliAcctInfo.debetNo=$scope.infoform.debetNo;
    	          data.bmrnAppliAcctInfo.custcd=$scope.infoform.custcd;
    	          data.bmrnAppliAcctInfo.mastContno=$scope.infoform.mastContcode;   	          
    	        var primise = $common.get_asyncData("incimarginService/marginApplySaveUpdate", data);
    	          primise.then(function (res) {
    	              if (res.errorCode == "SUC") {
    	                  $common.get_tipDialog('保存成功！', 'showSuccess');
    	                  $scope.updateForm.appno=res.contextData.value;
    	              } else {
    	                  $common.get_tipDialog(res.errorMsg, 'showError');
    	              }
    	          });	 
    		 
    		 
    	 }	

};   
  

//提交
$scope.flowsubmit_onClick = function(){
    if($.doValidate("updateForm")) {
        var data = {
          	  bmrnAppliAcctInfo: $scope.updateForm
          };
          data.bmrnAppliAcctInfo.debetNo=$scope.infoform.debetNo;
          data.bmrnAppliAcctInfo.custcd=$scope.infoform.custcd;
          data.bmrnAppliAcctInfo.mastContno=$scope.infoform.mastContcode;   	                  
        var primise = $common.get_asyncData("incimarginService/marginApplySubmit", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                $common.get_tipDialog('提交成功！', 'showSuccess');
                $state.go("lncimarginlist");
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
};



};