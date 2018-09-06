/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var queryDetailController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.baseinfo = dataDeliver.getter();//初始化查询条件对象
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
    });
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            billno:$scope.baseinfo.billno
        };
        var promise = $common.get_asyncData("billNormalQueryService/FindMortgageListMngGetter",data);
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

    $scope.viewmort_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('billnormal/bill_normal_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selected.select[0];
                dialogScope.disable = true;
                dialogScope.confirm = true;
                //查询押品一级
                dialogScope.mortgageLevelOneSource = {
                    ds:[]
                };
                dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                    dialogScope.mortgageLevelOneSourceList(1);
                    if(dialogScope.mortgageInfo.mortgageLevelOne)
                    {
                        var dataItemsDO = {mortgageCode:dialogScope.mortgageInfo.mortgageLevelOne};
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }
                });
                dialogScope.mortgageLevelOneSourceList = function(level)
                {
                    //业务品种下拉框
                    var dataItemsDO = {levels:level};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                };
                //押品二级
                dialogScope.mortgageLevelTwoSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelOneName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelTwo = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelTwoSource.ds = [];
                    }
                };
                //押品三级
                dialogScope.mortgageLevelThreeSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelTwoName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelThreeSource.ds = [];
                    }
                };
                //返回
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"普通非标准仓单下的货物详情")
        }
    };

    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};
