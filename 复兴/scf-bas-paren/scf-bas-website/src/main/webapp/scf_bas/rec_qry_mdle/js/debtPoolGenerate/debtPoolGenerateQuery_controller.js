
var debtPoolGenerateController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.conditionForm={
        factType:"2",//应收账款池融资
        financingType:"2",// 池融资
        flag:"01" //用户角色
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
   $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                factType:"2",//应收账款池融资
                financingType:"2",// 池融资
                flag:"01" //用户角色
            };//初始化查询条件对象
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };

   $scope.queryTable = function(){
       var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mastContQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCntDebtInfoService/queryBCntDebtInfoListByPage",data);
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
        $scope.selected.select=[];
    };


    //查看台帐
    $scope.detail_onClick = function(){

        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $state.go("info");
            dataDeliver.setter($scope.selected.select[0]);
        }

    };


  
    //表格--------结束-------------------------
};
