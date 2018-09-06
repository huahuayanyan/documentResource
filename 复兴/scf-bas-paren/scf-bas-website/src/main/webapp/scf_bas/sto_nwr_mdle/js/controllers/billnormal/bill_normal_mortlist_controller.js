/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var billNormalmortlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.billnormal = dataDeliver.getter();
    $scope.hide = true;
    if($scope.billnormal.status=="0")
    {
        $scope.hide = false;
    }
    else
    {
        $scope.hide = true;
    }
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
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mortgageQryVO:$scope.billnormal
        };
        var promise = $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageBaseGetter",data);
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
    $scope.add_onClick = function()
    {
        $common.get_ngDialog('billnormal/bill_normal_mortedit.html', $scope,["$scope",function(dialogScope) {
            billNormalmorteditController(dialogScope,$scope,dataDeliver,$state,$common,"add");
        }],"货物维护")
    };
    //修改
    $scope.edit_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('billnormal/bill_normal_mortedit.html', $scope,["$scope",function(secondScope) {
                billNormalmorteditController(secondScope,$scope,dataDeliver,$state,$common,"update");
            }],"货物维护")
        }
    };
    //查看
    $scope.view_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('billnormal/bill_normal_mortedit.html', $scope,["$scope",function(secondScope) {
                billNormalmorteditController(secondScope,$scope,dataDeliver,$state,$common,"view");
            }],"货物维护")
        }
    };
    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                $scope.mortgageInfo = $scope.selected.select[0];
                $scope.mortgageInfo.flag = "delete";
                $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageSaveUpdate",{mortgageBaseVO:$scope.mortgageInfo}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog("删除成功",'showSuccess');
                        $scope.queryTable();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            })
        }
    };
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};
