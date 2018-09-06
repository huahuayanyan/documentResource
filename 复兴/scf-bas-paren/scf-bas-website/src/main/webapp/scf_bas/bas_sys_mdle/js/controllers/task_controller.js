
var proController = function($scope,$common,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
      $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize:10,
        totalRecord: 0
    };
    //监听分页
    $scope.$watch("conf.pageNo",queryTable);
    //搜索
    $scope.submit_onClick =function(){
            $scope.queryTable();
    }
    $scope.queryTable=queryTable;
    function queryTable(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            jobDes:$scope.conditionForm
        };
        var promise = $common.get_asyncData("batchFileService/queryJobDesList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];//清空选项
    };

    $scope.add_onClick = function(){
        $common.get_ngDialog('bsysautotask/taskDialog.html', $scope,["$scope",function(dialogScope){
            proDialogController(dialogScope,$scope,$common,"add");
            }],"新增操作",{showClose:true});
    };
    $scope.update_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('bsysautotask/taskDialog.html',$scope
                ,["$scope",function(dialogScope){
                   proDialogController(dialogScope,$scope,$common,"update");
                }],"修改操作",{showClose:true});
        };
    };
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
            	var jobId = $scope.selected.select[0].jobId;
          alert(jobId);
                var primise = $common.get_asyncData('batchFileService/delJobDes',{jobId:jobId});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    }
    //启动操作
    $scope.start_onClick = function(){
    	if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	      $common.get_tipDialog('确定启动任务吗！','showTip').then(function(){
        	      var jobId = $scope.selected.select[0].jobId;

                  var primise = $common.get_asyncData('batchFileService/startJob',{jobId:jobId});
                  primise.then(function(res){
                      if (res.errorCode =="SUC"){
                          $scope.queryTable();
                          $scope.selected.select=[];
                          $common.get_tipDialog('启动任务成功！','showSuccess');
                      }else{
                          $common.get_tipDialog(res.errorMsg,'showError');
                      }
                  })
              })               	
        };
    };    
    //停止操作
    $scope.stop_onClick = function(){
    	if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定停止任务吗！','showTip').then(function(){
      	        var jobId = $scope.selected.select[0].jobId;
                var primise = $common.get_asyncData('batchFileService/stopJob',{jobId:jobId});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('停止任务成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })                   
        };
    };  
    //立即启动 
    $scope.startNow_onClick = function(){
    	if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	      $common.get_tipDialog('确定启动任务吗！','showTip').then(function(){
        	      var jobId = $scope.selected.select[0].jobId;

                  var primise = $common.get_asyncData('batchFileService/startJobNow',{jobId:jobId});
                  primise.then(function(res){
                      if (res.errorCode =="SUC"){
                          $scope.queryTable();
                          $scope.selected.select=[];
                          $common.get_tipDialog('启动任务成功！','showSuccess');
                      }else{
                          $common.get_tipDialog(res.errorMsg,'showError');
                      }
                  })
              })               	
        };
    };    
    $scope.column = function(row){
        console.log(JSON.stringify(row));
    }
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm.proName="";
            $scope.conditionForm.isenabled="";
            $scope.selected.select=[];//清空选项s
        })
    }
    //表格--------结束----------------------\

};
