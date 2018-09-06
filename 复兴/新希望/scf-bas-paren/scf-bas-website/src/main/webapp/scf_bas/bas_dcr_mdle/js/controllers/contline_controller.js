/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var contlineController= function($scope,$common,$location,dataDeliver,$state,$templateCache,$eventCommunicationChannel){
$templateCache.put("app/treeControlExternalTemplate.html", '<ul {{options.ulClass}}> '+
'<li ng-repeat="node in node.{{options.nodeChildren}} | filter:filterExpression:filterComparator {{options.orderBy}}"'+
       'ng-class="headClass(node)"'+
       '{{options.liClass}}'+
       'set-node-to-data>'+
       '<i class="tree-branch-head" ng-class="iBranchClass()" ng-click="selectNodeHead(node)"></i>'+
       '<i class="tree-leaf-head {{options.iLeafClass}}"></i>'+
       '<i>'+
           '<b>'+
               '<div class="tree-label {{options.labelClass}}" ng-class="[selectedClass(), unselectableClass()]"'+
                    'ng-click="selectNodeLabel(node)" tree-transclude></div>'+
           '</b>'+
       '</i>'+
       '<treeitem ng-show="nodeExpanded()"></treeitem>'+
   '</li>'+
'</ul>');	


$scope.selected={};
$scope.treedata =[];
$scope.viewhide=window.parent.viewhide;
$scope.updatehide=window.parent.updatehide;
keyobject=window.parent.dateObject;
$scope.expandedNodes =[];	
$scope.treeOptions={
            "multiSelection": false,//允许多选
            "dirSelectable": true,//允许选择目录
            "allowDeselect":false,
            templateUrl:'app/treeControlExternalTemplate.html'

       };

    $scope.showCurrValue=function (crAmt) {
    	return $common.get_currFormat(crAmt);
    };
    

    $scope.showDictionary=function(dictCode,dicVal){
    	
		if(dictionary !==''&& dictionary !==undefined){
			var dicValNm;
			
				if(dictionary[dictCode]){
					for (var j = 0;j<dictionary[dictCode].dataItems.length;j++) {
						if(dictionary[dictCode].dataItems[j].dataVal == dicVal){
							dicValNm=dictionary[dictCode].dataItems[j].dataTrsVal; 
							break;
						}
					}
			
				}
			return  dicValNm;
		 }else{
			
		}
    };
    
    $scope.showSelected = function (selectedNode) {
    	 $scope.selected=selectedNode;
         console.log("$scope.selected："+JSON.stringify($scope.selected));  
    };
    
    $scope.flashQuery= function (){   
    var primise = $common.get_asyncData("ibDcrLinInfService/selectTreeByRootId",{key:keyobject.rootid});
    primise.then(function(res){
        if (res.errorCode =="SUC"){
        	console.log("res.contextData" +JSON.stringify(res.contextData));
        	$scope.treedata =res.contextData;
            $scope.expandedNodes = [$scope.treedata[0]];       	
        }
    });
    };
    $scope.updateTree_onClick = function(){
        if($scope.selected.linId== undefined||$scope.selected.linId==null){
            $common.get_tipDialog('请选择节点！','showInform');
            return;
        }   
		if($scope.selected.linTyp=='0'){
			 $common.get_tipDialog('当前为根节点不能修改！','showInform');
			 return;
		}         
        $common.get_ngDialog('cont/updatetree.html',$scope,["$scope",function(updateScope){
        	updateScope.subbig=false;
        	updateScope.updateTreeForm=$scope.selected;          
            if(updateScope.updateTreeForm.linTyp=='1'){
            	 updateScope.busNmhide=false;
            	 updateScope.busTyphide=true;                	
            }else if(updateScope.updateTreeForm.linTyp=='2'){
            	 updateScope.busNmhide=true;
            	 updateScope.busTyphide=false;                	
            }
            updateScope.confirm_onClick = function(){
                if($.doValidate("updateTreeForm")){
                	//找出上一级的金额
                	for (var i = 0;i<$scope.treedata.length;i++){
                		 if($scope.treedata[i].treeId==updateScope.updateTreeForm.treeParentId){
                 			 updateScope.parentcrAmt=$scope.treedata[i].crAmt;
                 			 break;
                		 }
                		
                	}  
                	if(updateScope.updateTreeForm.crAmt>updateScope.parentcrAmt){
                        $common.get_tipDialog('当前金额:'+updateScope.updateTreeForm.crAmt+'超过上一级金额:'+ updateScope.parentcrAmt+'！','showError');
                		return;
                	}
                  for (var i = 0;i<updateScope.updateTreeForm.children.length;i++){
                		updateScope.subbig=false;
		             	if(updateScope.updateTreeForm.children[i].crAmt>updateScope.updateTreeForm.crAmt){
		             		updateScope.subbig=true;
		             		break;
		            	}
               	  }  
                  if(updateScope.subbig){
                      $common.get_tipDialog('存在子节点比父节点大的情况！','showError');
              		   return;
                  }
                	
                	
                	
                	
                    var primise = $common.get_asyncData("ibDcrLinInfService/update",{vbDcrLinInf:updateScope.updateTreeForm});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('修改成功！','showSuccess');
                            updateScope.closeThisDialog();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };
            };
            updateScope.cancel_onClick = function(){
                updateScope.closeThisDialog();
            };
        }],'修改',{showClose:true},450);         
      };  
    
      $scope.checkTree_onClick = function(){
          if($scope.selected.linId== undefined||$scope.selected.linId==null){
              $common.get_tipDialog('请选择节点！','showInform');
              return;
          }    
          if($scope.selected.linTyp!='2'){
              $common.get_tipDialog('请选择分项额度类型节点！','showInform');
              return;
          }     
          
          
          $common.get_ngDialog('cont/checktreelist.html',$scope,["$scope",function(checkTreeScope){ 
        	      checkTreeScope.treeOptions={
        	            "multiSelection": false,//允许多选
        	            "dirSelectable": true,//允许选择目录
        	            "allowDeselect":false,
        	             templateUrl:'app/treeControlExternalTemplate.html'
        	       };
        	  checkTreeScope.selectedNode={};
        	  checkTreeScope.treedata=[];
        	  checkTreeScope.showSelectedNode = function (node) {
        		      checkTreeScope.selectedNode=node;
        		      queryDetailTable();     		      
        	    };
        	    function queryDetailTable(){
  	            	checkTreeScope.rltTypDictionary=checkTreeScope.selectedNode.rltTyp;     
         	        var data= {
        	           // pageNo: checkTreeScope.detailconf.pageNo,
        	            pageNo: 1,
        	          //  pageSize: checkTreeScope.detailconf.pageSize,
        	            pageSize: 200,
        	            vbDcrChkDetail:{chkDirId:checkTreeScope.selectedNode.chkDirId}
        	        };
        	        var promise = $common.get_asyncData("ibDcrChkDetailService/findObjectConditionByPage",data);
        	        promise.then(function(res){
        	            var data;
        	            if (res.errorCode =="SUC"){
        	                data = res.contextData;
        	                checkTreeScope.detaildatasource.ds = data.records;
        	                //checkTreeScope.detailconf.totalRecord = data.totalRecord;
        	            }else{
        	                $common.get_tipDialog(res.errorMsg,'showError');
        	            }
        	        });
        	    };
        	    
        	    
        	    
              checkTreeScope.typIdDatasource= {
                        ds:[]
                    };
        	 
        	    checkTreeScope.flashQuery= function (){   
        	        var primise = $common.get_asyncData("ibDcrChkDirService/selectTreeByRootId",{key:$scope.selected.linId});
        	        primise.then(function(res){
        	            if (res.errorCode =="SUC"){
        	            	console.log("res.contextData" +JSON.stringify(res.contextData));
        	            	checkTreeScope.treedata =res.contextData;
        	            }
        	        });
        	        };
        	        checkTreeScope.flashQuery();
        	        checkTreeScope.queryTypId= function(){
    	                var promise = $common.get_asyncData("bDcrLinCnfgService/queryTypId");
    	                promise.then(function(res){
    	                    var data;
    	                    if (res.errorCode =="SUC"){
    	                        data = res.contextData;
    	                        checkTreeScope.typIdDatasource= {
    	                                ds:data
    	                            };

    	                        console.log("data："+JSON.stringify(data)); 
    	                    }else{
    	                        $common.get_tipDialog('服务超时','showError');

    	                    }
    	                });
    	            };      
    	            checkTreeScope.queryTypId();
        	        
        	        checkTreeScope.showTypIdNm=function(typId){
        	        	var  typIdNm;
     					for (var j = 0;j<checkTreeScope.typIdDatasource.ds.length;j++) {
    						if(checkTreeScope.typIdDatasource.ds[j].typId == typId){
    							typIdNm= checkTreeScope.typIdDatasource.ds[j].typNm; 
    							break;
    						}
    					}
                        return typIdNm;
        	        };
         	  
          }],'检查对象详情',{showClose:true},625);       
    	  
      };      
    
      $scope.viewTree_onClick = function(){
          if($scope.selected.linId== undefined||$scope.selected.linId==null){
              $common.get_tipDialog('请选择节点！','showInform');
              return;
          }     
          $common.get_ngDialog('cont/viewtree.html',$scope,["$scope",function(viewScope){
        	  viewScope.viewTreeForm=$scope.selected; 
        	  
              if(viewScope.viewTreeForm.linTyp=='1'){
            	  viewScope.busNmhide=false;
            	  viewScope.busTyphide=true;                	
             }else if(viewScope.viewTreeForm.linTyp=='2'){
            	 viewScope.busNmhide=true;
            	 viewScope.busTyphide=false;                	
             }
        	  viewScope.cancel_onClick = function(){
        		  viewScope.closeThisDialog();
              };
          }],'查看',{showClose:true},450);         
        };    
    
    $scope.flashQuery(); 

};