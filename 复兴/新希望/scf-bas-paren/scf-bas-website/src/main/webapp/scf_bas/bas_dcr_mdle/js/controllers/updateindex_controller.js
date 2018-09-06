/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var updateindexController = function($scope,$common,$location,dataDeliver,$stateParams,$state,$eventCommunicationChannel){
	$scope.updateForm={};
	console.log("window.parent.appNo信息：" + window.parent.appNo);
	appno=window.parent.appNo;
    $common.get_asyncData('ibDcrLinAppService/findVbDcrLinAppByKey',{key:appno}).then(function(res){
        if (res.errorCode =="SUC"){        	
      	  $scope.updateForm = res.contextData;
         //   dataDeliver.setter({appno:appno,rootid:res.contextData.parentId});
      	window.parent.dateObject={appno:appno,rootid:res.contextData.parentId};
      	  
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
	
	$scope.viewhide=window.parent.viewhide;
	$scope.viewdisable=window.parent.viewdisable;
	
	 $scope.confirm_onClick = function(){
         if($.doValidate("updateForm")){
             var crAmt = $scope.updateForm.crAmt;
             var len = crAmt.length;
             if(len>15)
             {
                 $common.get_tipDialog('"额度金额"超过限值，请重新输入','showInform');
                 return;
             }
             var data={
            		 vbDcrLinApp:$scope.updateForm
             };
             var primise = $common.get_asyncData("ibDcrLinAppService/update",data);
             primise.then(function(res){
                 if (res.errorCode =="SUC"){
                	 window.parent.dateObject.rootid=res.contextData.value;
                     $common.get_tipDialog('保存成功！','showSuccess');
                     window.parent.fresh();
                 }else{
                     $common.get_tipDialog(res.errorMsg,'showError');
                 }
             })
         };
     };
     $scope.cancel_onClick = function(){
    	 window.parent.closeDialog();
     };
	 
	 

};