/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var custlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.selectCust = {
        ds:[]
    };
    var promiseCust = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByBCrm");
    promiseCust.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.selectCust.ds = data;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    $scope.conditionForm={};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        //$scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bFinCust:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bFinCustService/findBFinCustByPage",data);
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

    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('cust/cust_add.html', $scope
            ,["$scope",function(dialogScope){
                custaddController(dialogScope,$scope,dataDeliver,$state,$common,"add");
            }],"新增客户财报",{showClose:false},800);
    };
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('cust/cust_add.html',$scope
                ,["$scope",function(dialogScope){
                    custaddController(dialogScope,$scope,dataDeliver,$state,$common,"update");
                }],"修改客户财报",{showClose:true},800);
        };
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var arrs = $common.copy($scope.selected.select);
                var finIds = "";
                for(var i=0 ; i<arrs.length ; i++)
                {
                    finIds += (arrs[i].finId)+",";
                }
                var primise = $common.get_asyncData('bFinCustService/batchDelete',{finIds:finIds})
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
    //刷新
    $scope.fresh_onClick = function(){
        $scope.queryTable();
        $scope.selected.select=[];
    }
    $scope.column = function(row) {
        $state.go("fin");//跳转
        dataDeliver.setter(row);//传值[可选]
    }
    //表格--------结束-------------------------
};
