/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2017
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      fangquan
 * @version     1.0
 * Create at:   2017/7/15
 */
var AttInfoController = function($scope,$common,$state,dataDeliver){
    var data1 = dataDeliver.getter();
    var flag=data1.flag;  
    
    var bCrmBaseInfo={
            orgCode:data1.orgCode,
            moniFlag:"1"
        }
    var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:bCrmBaseInfo});
    primise.then(function(res1) {
        if (res1.errorCode == "SUC") {
            var data2 = res1.contextData;
            if (data2 != null && data2.orgCode == data1.orgCode) {//说明之前客户信息保存成功

            }else{
                $state.go("tree.add");
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == "tree.add"){
                        $scope.$parent.select(pane);
                    };
                });
                $common.get_tipDialog("请先完成客户基本信息保存！", 'showInform');
                return false;
            }
        }});
    
    $scope.datasourceFile={//初始化表格对象
            ds: []
        };
/*    $scope.confFile= {//初始化分页对象
            pageNo: 1,
            pageSize: 1000000,
            totalRecord: 0}*/
    $scope.selected={//初始化对象
            select: []
        };
    $scope.FileForm={};
    $scope.queryTable=function(){
    	$.post(_FILE_SERVER_URL+"file/viewPic.htm",{reservedValue1: data1.orgCode},function(res){
    		var res=JSON.parse(res);
    		if (res.scubeHeader.errorCode =="SUC"||res.scubeHeader.errorCode =="EXP") {
    			var list=JSON.parse(res.scubeBody.contextData.data||'[]');
    			
    			var fname= $scope.FileForm.picName;  
    			var plist=[];
    			$scope.$apply(function(){
    				if($.trim(fname)!=""){   				
	    				$.map(list,function(a){	    					
	    					if((a.picName).indexOf(fname)!=-1){
	    						plist.push(a);
	    					}
	    				});
    				 }
    				if($.trim(fname)==""){
       				   $scope.datasourceFile.ds = list;    				 
    		           //$scope.confFile.totalRecord = list.length;					
    				}else{
        			   $scope.datasourceFile.ds = plist;    				 
        		       //$scope.confFile.totalRecord = plist.length;	
    				}
    			});
	        }else{
	            $common.get_tipDialog('附件信息列表查询失败','showError');
	        }
    	});
    }
    $scope.queryTable();
    
    $scope.uploadoption = {
            inputHidden:[
                {name:'reservedValue1',value: data1.orgCode}
            ],
            callbackFun: function(res,status){
            	if (res&&res.errorCode =="SUC") {
            		$common.get_tipDialog('上传成功', 'showSuccess');
            		$scope.queryTable();
            	}else{
            		$common.get_tipDialog('上传失败','showError');
            	}
            },
            fileServerUrl:true
    };
    
    $scope.download_onClick = function(){
        if($scope.selected.select.length <= 0 || $scope.selected.select.length> 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            location.href=$scope.selected.select[0].url;
        }
    };
    
    $scope.deleteFile_onClick = function(){
        if($scope.selected.select.length <= 0 || $scope.selected.select.length> 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	$common.get_tipDialog('是否删除附件？','showTip').then(function(){
        		$.post(_FILE_SERVER_URL+"file/delete.htm",{picId:$scope.selected.select[0].picId},function(res){
            		var res=JSON.parse(res);
            		if (res.scubeHeader.errorCode =="SUC") {
                		$scope.queryTable();
                		$scope.selected.select = [];
                		$common.get_tipDialog('附件删除成功', 'showSuccess');
        	        }else{
        	            $common.get_tipDialog('附件删除失败','showError');
        	        }
            	});
        	});
        }
    };
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //重置按钮
    $scope.rebort_onClick =function(){          
        	$scope.FileForm.picName = "";
        	$scope.$apply();
    } 
    //点击取消按钮，返回原来页面，并且让原来页面刷新！
    $scope.confuse_onClick=function(){
        $state.go("base");
    }
 
};
