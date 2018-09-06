/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var contindexController = function($scope,$common,$location,dataDeliver,$state,$eventCommunicationChannel){
	$scope.updateForm={};
	console.log("window.parent.bcCrId信息：" + window.parent.bcCrId);
	bcCrId=window.parent.bcCrId;
    $common.get_asyncData('ibDcrLinService/findVbDcrLinByKey',{key:bcCrId}).then(function(res){
        if (res.errorCode =="SUC"){        	
      	  $scope.updateForm = res.contextData;
         // dataDeliver.setter({bcCrId:bcCrId,rootid:res.contextData.parentId});
        	window.parent.dateObject={bcCrId:bcCrId,rootid:res.contextData.parentId};

        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
	
  

     $scope.cancel_onClick = function(){
    	 window.parent.closeDialog();
     };
	 
	 

};