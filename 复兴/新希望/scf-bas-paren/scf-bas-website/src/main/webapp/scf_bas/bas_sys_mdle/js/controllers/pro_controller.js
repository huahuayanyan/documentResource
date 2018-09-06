
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
/*    $scope.submit_onClick =function(){
            $scope.queryTable();
    }*/
    $scope.queryTable=queryTable;
    function queryTable(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            pro:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bSysGlobalInfoService/findBSysGlobalInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord=data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];//清空选项
    };

   
    $scope.update_onClick = function(){
    	
       if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('bsysglobalinfo/proDialog.html',$scope
                ,["$scope",function(dialogScope){
                   proDialogController(dialogScope,$scope,$common,"update");
                }],"修改操作",{showClose:true});
        };
    };
    //刷新
    $scope.refresh_onClick = function(){
    	 $scope.queryTable(); 
    };   
    //表格--------结束----------------------\
    
};
