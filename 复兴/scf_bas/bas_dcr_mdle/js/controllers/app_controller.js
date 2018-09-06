/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var appController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.conditionForm={};//初始化查询条件对象
    $scope.addForm={};//初始化对象
    $scope.selected={select: []};//初始化对象
    $scope.datasource={ds: []};//初始化表格对象
    $scope.conf= {pageNo: 1, pageSize: 10};//初始化分页对象
    $scope.flowsubmitdisable=false;
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        queryTable();
    });
    //搜索查询
    $scope.submit_onClick =function(){
        queryTable();
    };
    //新增
    $scope.add_onClick = function(){
        add();
    };
    $scope.update_onClick = function(){
      update();
    };
    $scope.delete_onClick = function(){
    	del();
    };
    $scope.reset_onClick = function(){      
        $scope.$apply(function(){
        	$scope.conditionForm = {};
            $scope.selected.select=[];//清空选项
        });
    };
    $scope.column = function(row){
    	doView(row);
    };


    
    function doView(dataParam){
         window.viewdisable=true;
         window.viewhide=true;
		$common.get_ngDialog('app/addguide.html',$scope,["$scope",function(guideScope){
            debugger;
			appNo=dataParam.appCrId;
		  	 window.closeDialog=function(){	            		 
		  		 guideScope.closeThisDialog();
		  		 queryTable();		            	
		  	 };

		  }],'授信额度申请',{showClose:true},850);       
    } ;
     
    function queryTable(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            vbDcrLinApp:$scope.conditionForm
        };
        var promise = $common.get_asyncData("ibDcrLinAppService/findObjectConditionByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    
    //提交
    $scope.flowsubmit_onClick = function(){
	    if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
	        $common.get_tipDialog('请选择一条记录！','showInform');
	    }
	      //判断关键字段是否有值
	      if($scope.selected.select[0].crAmt==null||$scope.selected.select[0].crAmt==undefined){       	    	  
	            $common.get_tipDialog('当前信息未保存,请检查','showInform');
	           return;        	    	  
	      }    	
	      if($scope.selected.select[0].aprvStat!='000'){       	    	  
	            $common.get_tipDialog('已在审批,不允许再次提交','showInform');
	         return;        	    	  
	      }	   
	      //调用业务拦截
         dataDeliver.setter({modelId:"DCRCHK",chkMap:$scope.selected.select[0]});//传值
    	 $common.get_ngDialog('../../bas_intcpdir_mdle/html/ft/intcpline.html',$scope,intcplineController,'业务拦截',{showClose:false},700);
    };
    
    //监听业务拦截事件
	$scope.$on('interceptEvent',function(event,data) {
	            console.log("data信息："+JSON.stringify(data));
                   //根据业务拦截处理结果，执行成功继续提交，未执行成功返回
		          if(data.checkResult!='SUC'){ 
		        	    return;
		          }
			  	    //锁定当前申请状态,防重复提交
			 	   $scope.flowsubmitdisable=true;
			        var primise = $common.get_asyncData("ibDcrLinAppService/submitFlowForBDcrLinAppStat",{key:$scope.selected.select[0].appCrId});
			       var  rs= primise.then(function(res){
			            if (res.errorCode =="SUC"){
			            	
			      	      //发起工作流
			                var data = {
			                    modelId : 'BDcrLin',
			                    ProcessName : '授信额度申请',
			                    NodeId : 'dcr_node1',
			                    startedUserId : userInfo.tlrNo,
			                    bizId : $scope.selected.select[0].appCrId,
			                    bizData : [
			                           $scope.selected.select[0].appCrId,
			                           $scope.selected.select[0].custId,
			                           $scope.selected.select[0].custNm,
			                           'BDcrLin'
			                    ]
			                };
			                var primise = $common.get_asyncData("processService/startProcess",data);
			                primise.then(function(res){
			                    if (res.errorCode =="SUC"){
			                    	$scope.selected.select=[];
			                    	$common.get_tipDialog('发起成功！','showSuccess');
			              	 	    $scope.flowsubmitdisable=false;
			              	 	    queryTable();	
			                      }else{
			                    	$common.get_tipDialog('发起失败!'+res.errorMsg,'showError');
			                   	    $scope.flowsubmitdisable=false;
			                     }
			                    
			                });
			            	
			            }else{
			                $common.get_tipDialog(res.errorMsg,'showError');
			      	 	    $scope.flowsubmitdisable=false;
			            }
			        });
						
});

    
    

    function add(){
        $common.get_ngDialog('app/add.html',$scope,["$scope",function(addScope){
        	addScope.addForm={};//清除历史   
            addScope.crDatasource={ds: []};//初始化对象  
            addScope.custcontent = {
                type:"table",//展示类型table  tree
                url:"ibDcrLinAppService/queryCustSource",
                param:{},
                split:"-",//分隔符
                extentColumn:"cname",
                column:["custcd","cname"]//展示内容
            };
            addScope.dooextent = function(ds){
            	addScope.addForm.custNm=ds.cname;
            	addScope.addForm.custId=ds.custcd;
            };   
            addScope.$watch("addForm.custNm",function(){
            	if(addScope.addForm.custNm!=null) addScope.custcontent.param ={custcd:addScope.addForm.custNm,cname:addScope.addForm.custNm};
            });    
            
            addScope.changeSelect = function(selected){
                console.log("selected："+selected); 
                var vselect =selected.split('-');
            	addScope.addForm.crId=vselect[0];
            	addScope.addForm.circFlag=vselect[1];
            	//addScope.addForm.crNm=vselect[2];
            };
            
            
            

        	addScope.queryCrNmSource = function(){
                var promise = $common.get_asyncData("ibDcrLinAppService/queryCrNmSource");
                promise.then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        addScope.crDatasource= {
                                ds:data
                            };

                        console.log("data："+JSON.stringify(data)); 
                    }else{
                        $common.get_tipDialog('服务超时','showError');

                    }
                });
            };
            
    	
            addScope.confirm_onClick = function(){
                if($.doValidate("addForm")){            	
                     var data={
                   		 vbDcrLinApp:$common.copy(addScope.addForm)
                    };
                    var vselect =addScope.addForm.crNm.split('-');
                    data.vbDcrLinApp.crNm=vselect[2];
                     var primise = $common.get_asyncData("ibDcrLinAppService/add",data);
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            console.log("res信息："+JSON.stringify(res));
                            appNo = res.contextData.value;
                            addScope.closeThisDialog();
                        window.viewdisable=false;
                         window.viewhide=false;
       		            $common.get_ngDialog('app/addguide.html',$scope,["$scope",function(guideScope){	            	 
   		            	 window.closeDialog=function(){	            		 
   		            		 guideScope.closeThisDialog();
   		            		 queryTable();		            	
   		            	 };
			  		  	window.fresh=function(){	            		 
				  		      queryTable();		            	
				  	     };
  		             }],'授信额度申请',{showClose:true},850);                       
       		    	 queryTable();	    
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                
                }
              };
            addScope.cancel_onClick = function(){
                addScope.closeThisDialog();
            };
            
            addScope.queryCrNmSource();
            
            
        }],'新增',{showClose:false},500);
    };
  
    
    

    
    function update(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{ 
        	
        	      if($scope.selected.select[0].aprvStat!='000'){       	    	  
        	            $common.get_tipDialog('已在审批,不允许修改','showInform');
                         return;        	    	  
        	      }
        	
			        window.viewdisable=false;
			        window.viewhide=false;
			        appNo=$scope.selected.select[0].appCrId;
			         $common.get_ngDialog('app/addguide.html',$scope,["$scope",function(guideScope){	            	 
			       	 window.closeDialog=function(){	            		 
			       		 guideScope.closeThisDialog();
			       		 queryTable();		            	
			       	 };
		  		  	window.fresh=function(){	            		 
			  		      queryTable();		            	
			  	     };
			       }],'授信额度申请',{showClose:false},850);  
			         $scope.selected.select=[];
               }

    };
    function del(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
  	      if($scope.selected.select[0].aprvStat!='000'){       	    	  
	            $common.get_tipDialog('已在审批,不允许删除','showInform');
               return;        	    	  
	      }
            $scope.deleteObject=$common.copy($scope.selected.select[0]);
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var primise = $common.get_asyncData("ibDcrLinAppService/deleteBdcrLinApp",{key:$scope.deleteObject.appCrId});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        queryTable();
                        $scope.selected.select=[];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            });
        }
    }
};