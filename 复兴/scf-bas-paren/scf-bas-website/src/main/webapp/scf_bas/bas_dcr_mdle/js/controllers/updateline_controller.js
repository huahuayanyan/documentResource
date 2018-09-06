/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var updatelineController= function($scope,$common,$location,dataDeliver,$state,$templateCache,$eventCommunicationChannel){
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

$scope.viewhide=window.parent.viewhide;
$scope.viewdisable=window.parent.viewdisable;
$scope.selected={};

 $scope.treedata =[];
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
    
    $scope.deleteTree_onClick = function(){
    	del();
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

    //新增
    $scope.addTree_onClick = function(){
        if($scope.selected.linId== undefined||$scope.selected.linId==null){
            $common.get_tipDialog('请选择节点！','showInform');
            return;
        }
    	if($scope.selected.linTyp=='2'){
    		$common.get_tipDialog('当前为叶子节点不能添加！','showInform');
	        return;
	    }
        $common.get_ngDialog('app/addtree.html',$scope,["$scope",function(addScope){
        	addScope.disable=false;
        	addScope.busNmhide=true;
        	addScope.busTyphide=true;
        	
        	addScope.addTreeForm={
        			curcd:$scope.selected.curcd,	
        			circFlag:$scope.selected.circFlag,
        			parentId:$scope.selected.linId,
        			linLvl:$common.copy($scope.selected.linLvl)+1
        	};
        	if($scope.selected.linTyp=='1'){
        		addScope.addTreeForm.linTyp='2';
        		addScope.disable=true;
            	addScope.busTyphide=false;      		
    	    }
        	addScope.changeSelect = function(selected){
                if(selected =='1'){
                	addScope.addTreeForm.busNm = "组合额度";
                	addScope.busNmhide=false;
                	addScope.busTyphide=true;                	
                }else if(selected =='2'){
                	addScope.addTreeForm.busNm= undefined;
                	addScope.busNmhide=true;
                	addScope.busTyphide=false;                	
                }
                else{
                	addScope.addTreeForm.busNm= undefined;
                	addScope.busNmhide=true;
                	addScope.busTyphide=true;             	
                }
            };
            addScope.confirm_onClick = function(){
                if($.doValidate("addTreeForm")){

					var childrenAmt = 0;
                	//找出上一级的金额
                	for (var i = 0;i<$scope.treedata.length;i++){
                		 if($scope.treedata[i].treeId==addScope.addTreeForm.parentId){
                			 addScope.parentcrAmt=$scope.treedata[i].crAmt;
							 var children = $scope.treedata[i].children;
							 for(var j=0;j<children.length;j++)
							 {
								 childrenAmt += Number(children[j].crAmt);
							 }
                 			 break;
                		 }
                		
                	}
					var crAmt = Number(addScope.addTreeForm.crAmt);
                	if(crAmt>addScope.parentcrAmt){
                        $common.get_tipDialog('当前金额:'+crAmt+'超过上一级金额:'+ addScope.parentcrAmt+'！','showError');
                		return;
                	}
					var lastAmt = addScope.parentcrAmt - childrenAmt;
					if(crAmt>lastAmt)
					{
						$common.get_tipDialog('当前金额:'+crAmt+'超过上一级剩余金额:'+ lastAmt+'！','showError');
						return;
					}
                    var data={
                        vbDcrLinInf:addScope.addTreeForm
                    };
                    var primise = $common.get_asyncData("ibDcrLinInfService/add",data);
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('新增成功！','showSuccess');
                            $scope.flashQuery(); 
                            addScope.closeThisDialog();
                            
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                            $scope.flashQuery(); 
                        }
                    })
                };
            };
            addScope.cancel_onClick = function(){
                addScope.closeThisDialog();
            };
        }],'新增',{showClose:true},550);
    };
    
    function del(){
        if($scope.selected.linId== undefined||$scope.selected.linId==null){
            $common.get_tipDialog('请选择节点！','showInform');
        }else{
        	if($scope.selected.children.length>0){
        		 $common.get_tipDialog('请选择叶子节点！','showInform');	
        	}else{
        		if($scope.selected.linTyp=='0'){
        			 $common.get_tipDialog('当前为根节点不能删除！','showInform');
        			 return;
        		}
		        $scope.deleteObject=$scope.selected;
		        $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
		            var primise = $common.get_asyncData("ibDcrLinInfService/delete",{key:$scope.deleteObject.linId});
		            primise.then(function(res){
		                if (res.errorCode =="SUC"){
		                    $common.get_tipDialog('删除成功！','showSuccess');
		                    $scope.selected={};
		                    $scope.flashQuery(); 
		                }else{
		                    $common.get_tipDialog(res.errorMsg,'showError');
		                }
		            })
		        });
       	}
        }
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
        $common.get_ngDialog('app/updatetree.html',$scope,["$scope",function(updateScope){
        	updateScope.subbig=false;
            updateScope.updateTreeForm=$common.copy($scope.selected);
			var oldCrAmt = updateScope.updateTreeForm.crAmt;
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
					var childrenAmt = 0;
                	for (var i = 0;i<$scope.treedata.length;i++){
                		 if($scope.treedata[i].treeId==updateScope.updateTreeForm.treeParentId){
                 			 updateScope.parentcrAmt=$scope.treedata[i].crAmt;
							 var children = $scope.treedata[i].children;
							 for(var j=0;j<children.length;j++)
							 {
								 childrenAmt += Number(children[j].crAmt);
							 }
                 			 break;
                		 }
                		
                	}
					var crAmt = Number(updateScope.updateTreeForm.crAmt);
					if(crAmt>updateScope.parentcrAmt){
						$common.get_tipDialog('当前金额:'+crAmt+'超过上一级金额:'+ updateScope.parentcrAmt+'！','showError');
						return;
					}
					var lastAmt = updateScope.parentcrAmt - childrenAmt + oldCrAmt;
					if(crAmt>lastAmt)
					{
						$common.get_tipDialog('当前金额:'+crAmt+'超过上一级剩余金额:'+ lastAmt+'！','showError');
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
                            $scope.flashQuery(); 
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
          
          
          $common.get_ngDialog('app/checktreelist.html',$scope,["$scope",function(checkTreeScope){ 
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
        	   checkTreeScope.viewhide=$scope.viewhide;
         	    
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
        	        
        	        
        	        checkTreeScope.adddir_onClick = function(){
        	          $common.get_ngDialog('app/adddir.html',$scope,["$scope",function(addScope){
        	            addScope.typIdDatasource={ds: []};//初始化对象  
        	        	addScope.addForm={};
        	        	addScope.addForm.linId=$scope.selected.linId;   
        	        	addScope.typIdDatasource=checkTreeScope.typIdDatasource;
	    	            addScope.changeSelect = function(selected){
	    					for (var j = 0;j<addScope.typIdDatasource.ds.length;j++) {
	    						if(addScope.typIdDatasource.ds[j].typId == selected){
	    							addScope.addForm.rltTyp=addScope.typIdDatasource.ds[j].rltTyp; 
	    							break;
	    						}
	    					}

	    	            };
	    	        	
        	        	  addScope.confirm_onClick=function(){
        	                  if($.doValidate("addForm")){
         	     					for (var j = 0;j<checkTreeScope.treedata.length;j++) {
        	    						if(checkTreeScope.treedata[j].typId == addScope.addForm.typId){
        	    			                $common.get_tipDialog('已存在!','showInform');
        	    			                addScope.closeThisDialog();
        	    			                return;
        	    						}
        	    					}
        	                	  
        	                	  
        	                      var data={
        	                    	   vbDcrChkDir:addScope.addForm
        	                      };
        	                      var primise = $common.get_asyncData("ibDcrChkDirService/add",data);
        	                      primise.then(function(res){
        	                          if (res.errorCode =="SUC"){
        	                              addScope.closeThisDialog();      	                              
        	                              checkTreeScope.flashQuery();
        	                          }else{
        	                              $common.get_tipDialog(res.errorMsg,'showError');
        	                          }
        	                      })
        	                  };
        	              };
        	              addScope.cancel_onClick = function(){
        	            	  addScope.closeThisDialog();
        	              };          	        	  
        	          }],'新增',{showClose:true},350);       
        	    	  
        	      };        
        	  
        	      checkTreeScope.deletedir_onClick = function(){
        	            if(checkTreeScope.selectedNode== undefined||checkTreeScope.selectedNode==null){
        	                $common.get_tipDialog('请选择节点！','showInform');
        	            } else{
        	        	  checkTreeScope.deletedirObject=checkTreeScope.selectedNode;
        	              $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
        	                  var primise = $common.get_asyncData("ibDcrChkDirService/delete",{key:checkTreeScope.deletedirObject.chkDirId});
        	                  primise.then(function(res){
        	                      if (res.errorCode =="SUC"){
        	                    	  checkTreeScope.flashQuery();
        	                      }else{
        	                          $common.get_tipDialog(res.errorMsg,'showError');
        	                      }
        	                  })
        	              });
        	          }
        	    	  
        	      };
        	      
        	      
             	  checkTreeScope.adddetail_onClick = function(){
    	              if(checkTreeScope.selectedNode== undefined||checkTreeScope.selectedNode==null){
        	                $common.get_tipDialog('请选择节点！','showInform');
        	                return;
        	            }
    	              
        	          $common.get_ngDialog('app/adddetail.html',$scope,["$scope",function(addScope){ 
        	        	  
        	              if(checkTreeScope.selectedNode.rltTyp== undefined||checkTreeScope.selectedNode.rltTyp==null){
        	            	  addScope.rltVlhide=false;
        	            	  addScope.rltNmhide=true;
          	              } else{
            	        	  addScope.rltTypDictionary=checkTreeScope.selectedNode.rltTyp;     
        	            	  addScope.rltVlhide=true;
        	            	  addScope.rltNmhide=false;
          	            	  
          	              }
        	        	  
        	        	  
        	        	  addScope.addForm={};  
        	        	  addScope.addForm.chkDirId=checkTreeScope.selectedNode.chkDirId;   
        	        	  
        	        	  
        	        	  addScope.confirm_onClick=function(){
        	                  if($.doValidate("addForm")){
        	                	  
       	     					for (var j = 0;j<checkTreeScope.detaildatasource.ds.length;j++) {
    	    						if(checkTreeScope.detaildatasource.ds[j].rltNm== addScope.addForm.rltNm){
    	    			                $common.get_tipDialog('已存在!','showInform');
    	    			                addScope.closeThisDialog();
    	    			                return;
    	    						}
    	    					}
         	                      var data={
        	                    	  vbDcrChkDetail:addScope.addForm
        	                      };
        	                      var primise = $common.get_asyncData("ibDcrChkDetailService/add",data);
        	                      primise.then(function(res){
        	                          if (res.errorCode =="SUC"){
        	                              queryDetailTable();     
        	                              addScope.closeThisDialog();
        	                          }else{
        	                              $common.get_tipDialog(res.errorMsg,'showError');
        	                          }
        	                      })
        	                  };
        	              };
        	              addScope.cancel_onClick = function(){
        	            	  addScope.closeThisDialog();
        	              };          	        	  
        	          }],'新增',{showClose:true},350);       
        	    	  
        	      };     
        	    
        	      checkTreeScope.deletedetail_onClick = function(){
        	    	  
        	          if(checkTreeScope.detailselected.select.length <= 0||checkTreeScope.detailselected.select.length > 1){
        	              $common.get_tipDialog('请选择一条记录！','showInform');
        	          }else{
        	        	  checkTreeScope.deletedetailObject=$common.copy(checkTreeScope.detailselected.select[0]);
        	              $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
        	                  var primise = $common.get_asyncData("ibDcrChkDetailService/delete",{key:checkTreeScope.deletedetailObject.chkDetailId});
        	                  primise.then(function(res){
        	                      if (res.errorCode =="SUC"){
        	                          queryDetailTable(); 
        	                          checkTreeScope.detailselected.select=[];
        	                      }else{
        	                          $common.get_tipDialog(res.errorMsg,'showError');
        	                      }
        	                  })
        	              });
        	          }
        	    	  
        	      };
        	        
        	  
          }],'检查对象详情',{showClose:true},625);       
    	  
      };      
    
    
    
    $scope.flashQuery();

	$scope.cancel_onClick = function(){
		window.parent.closeDialog();
	};

};