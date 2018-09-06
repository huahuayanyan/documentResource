/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var lncimarginapplyController = function($scope,$common,$stateParams,dataDeliver,$state,$eventCommunicationChannel){
	//任务节点按钮属性初始化
	if($stateParams.nodeButton==null||$stateParams.nodeButton==undefined||$stateParams.nodeButton==""){ 
		   $scope.nodeButton={};
	  }else{
		  $scope.nodeButton=eval("("+$stateParams.nodeButton+")");
	  }
	
	if($scope.nodeButton.viewhide==null||$scope.nodeButton.viewhide==undefined){
		$scope.viewhide=true;
	}else{
		$scope.viewhide=$scope.nodeButton.viewhide;
	}
	if($scope.nodeButton.viewdisable==null||$scope.nodeButton.viewdisable==undefined){
		$scope.viewdisable=true;
	}else{
		$scope.viewdisable=$scope.nodeButton.viewdisable;
	}	

	$scope.updateForm={appno:$stateParams.appNo};
	$scope.infoform={};
    $scope.save_onClick = function(){
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
   


$scope.queryincimarginloan=function(){
    var data= {appno:$stateParams.appNo};
    var promise = $common.get_asyncData("incimarginService/queryIncimarginLoan",data);
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.infoform=data;

        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
};  



$scope.queryIncimargin=function(){
    var data= {appno:$stateParams.appNo};
    var promise = $common.get_asyncData("incimarginService/queryIncimargin",data);
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.updateForm=data;

        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
};  
$scope.queryincimarginloan();
$scope.queryIncimargin();

};