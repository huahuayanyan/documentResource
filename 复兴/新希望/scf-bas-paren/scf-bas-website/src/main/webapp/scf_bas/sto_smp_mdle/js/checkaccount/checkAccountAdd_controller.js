
var checkAccountAddController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={productId:"1220010"};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.productSource = {};
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
            $scope.conditionForm={productId:"1220010"};
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
            map:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bPbcCheckAccountService/getContSlaveInfoByProduct",data);
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

    //查看质押合同下押品
    $scope.detail_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        } else{
            $common.get_ngDialog('checkaccount/checkAccountSelect.html', $scope, ["$scope", function (dialogScope) {
                dialogScope.conf = {pageNo: 1, pageSize: 10, totalRecord: 0};
                dialogScope.datasource = {};
                dialogScope.$watch("conf.pageNo+conf.pageSize",queryDebt );
                function queryDebt(){
                    var data = {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        map:{protocolNo:$scope.selected.select[0].protocolNo,
                        	 conId:$scope.selected.select[0].conId,
                        	 supplyChainPdId:"1220010"
                        }
                    };
                    var promise = $common.get_asyncData("bPbcCheckAccountService/getTblMortgageBaseInfoPageByParam", data);
                    promise.then(function (res) {
                        var data;
                        if (res.errorCode == "SUC") {
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records;
                            dialogScope.conf.totalRecord = data.totalRecord;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                }

                dialogScope.closeThisDialog_onClick = function () {
                    dialogScope.closeThisDialog();
                };
            }], "库存对账清单", {showClose: true})
        }

    };
   //发起对账
    $scope.applyCheck_onClick = function() {
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            $common.get_tipDialog('是否发起对账？','showTip').then(function(){
                var primise = $common.get_asyncData("bPbcCheckAccountService/addCheckAccount", {conId:$scope.selected.select[0].conId});
                    primise.then(function (res) {
	                    if (res.errorCode == "SUC") {
	                        $common.get_tipDialog('提交成功！', 'showSuccess');
	                    } else {
	                        $common.get_tipDialog(res.errorMsg, 'showError');
	                    }
                    });
            });
        }
    };
    //返回
    $scope.return_onClick = function(){
        var data = { };
        dataDeliver.setter(data);//传值[可选]
        $state.go("checkAccountList");//跳转
    };



};
