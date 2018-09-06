/**首页 待办任务
 */
var bsysTaskMainController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    //$scope.conditionForm={};//初始化查询条件对象
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
        totalRecord: 0
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bSysTask:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bSysTaskService/queryTaskListByPage",data);
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


    $scope.column = function(row){
        $scope.row = row;
        var data= {
            appNo:row.appNo,
            pageUrl:row.pageUrl,
            taskId:row.taskId,
            processId: row.processId,
            custId:row.name2,
            custNm:row.custName,
            modelId:row.modelId,
            nodeButton:row.nodeButton
        };
        $state.go("bsystasktab",data);
    };

};
