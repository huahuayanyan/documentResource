/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var costOutlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
    $scope.row = {};//初始化传值参数
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
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            costQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("costledgerQueryService/CostledgerQueryGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /**
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"cname",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.cname=ds.custNm;
        $scope.conditionForm.custcd = ds.custId;
    };
    $scope.$watch("conditionForm.cname",function(){
        if($scope.conditionForm.cname!=null) $scope.custcontent.param ={custId:$scope.conditionForm.cname,custNm:$scope.conditionForm.cname};
    });
    /**
     * 客户名称查询加载结束
     */
    $scope.costmap = {};
    //费用补录
    $scope.add_onClick = function()
    {
        $common.get_asyncData("costledgerQueryService/addCostOut").then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.costmap = data;
                $common.get_ngDialog("costledgerQuery/costOut_add.html", $scope
                    ,["$scope",function(dialogScope){
                        dialogScope.costadd = $scope.costmap;
                        dialogScope.costadd.costAmt = '0.00';
                        dialogScope.costadd.totalAmt = '0.00';
                        dialogScope.costadd.reduceAmt = '0.00';
                        dialogScope.costadd.receiveAmount = '0.00';
                        /**
                         * 客户名称查询加载开始
                         */
                        dialogScope.custcontent = {
                            type:"table",//展示类型table  tree
                            url:"bCrrLnAppService/queryCustSource",
                            param:{},
                            split:",",//分隔符
                            extentColumn:"sellerNm",
                            column:["custNm","custId"]//展示内容
                        };
                        dialogScope.custdooextend = function(ds){
                            dialogScope.costadd.sellerNm=ds.custNm;
                            dialogScope.costadd.custcd = ds.custId;
                            dialogScope.busscontent.param ={custcd:dialogScope.costadd.custcd};
                            dialogScope.costcontent.param ={custcd:dialogScope.costadd.custcd};
                        };
                        dialogScope.$watch("costadd.sellerNm",function(){
                            if(dialogScope.costadd.sellerNm!=null) dialogScope.custcontent.param ={custId:dialogScope.costadd.sellerNm,custNm:dialogScope.costadd.sellerNm};
                        });
                        /**
                         * 客户名称查询加载结束
                         */
                        /**
                         * 业务合同号查询加载开始
                         */
                        dialogScope.busscontent = {
                            type:"table",//展示类型table  tree
                            url:"costledgerQueryService/DebtContDropDownGetter",
                            param:{custcd:dialogScope.costadd.custcd},
                            split:",",//分隔符
                            extentColumn:"bussContno",
                            column:["debtContno"]//展示内容
                        };
                        dialogScope.bussdooextend = function(ds){
                            dialogScope.costadd.bussContno = ds.debtContno;
                            dialogScope.costadd.bussType = ds.supplyChainPdId;
                        };
                        dialogScope.$watch("costadd.bussContno",function(){
                            if(dialogScope.costadd.bussContno!=null)
                            {
                                dialogScope.busscontent.param ={
                                    bussContno:dialogScope.costadd.bussContno
                                };
                            }
                        });
                        /**
                         * 业务合同号查询加载结束
                         */
                        /**
                         * 扣费账号查询加载开始
                         */
                        dialogScope.costcontent = {
                            type:"table",//展示类型table  tree
                            url:"costledgerQueryService/AccountDropDownSelectGetter",
                            param:{custcd:dialogScope.costadd.custcd},
                            split:",",//分隔符
                            extentColumn:"costAccount",
                            column:["accountNo"]//展示内容
                        };
                        dialogScope.costdooextend = function(ds){
                            dialogScope.costadd.costAccount = ds.accountNo;
                        };
                        dialogScope.$watch("costadd.costAccount",function(){
                            if(dialogScope.costadd.costAccount!=null)
                            {
                                dialogScope.costcontent.param ={
                                    costAccount:dialogScope.costadd.costAccount
                                };
                            }
                        });
                        /**
                         * 扣费账号查询加载结束
                         */
                        dialogScope.totalAmt_onBlur = function()
                        {
                            var totalAmt = dialogScope.costadd.totalAmt;
                            dialogScope.$apply(
                                dialogScope.costadd.receiveAmount = totalAmt
                            )
                        }
                        //保存
                        dialogScope.save_onClick = function(){
                            if($.doValidate("costadd")) {
                                var promise = $common.get_asyncData("costledgerQueryService/CostInfoRecordUpdate",{bcpCostOut:dialogScope.costadd});
                                promise.then(function(res){
                                    var data;
                                    if (res.errorCode =="SUC"){
                                        $scope.queryTable();
                                        dialogScope.closeThisDialog();
                                    }else{
                                        $common.get_tipDialog(res.errorMsg,'showError');
                                    }
                                });
                            };
                        };
                        //返回
                        dialogScope.close_onClick = function()
                        {
                            dialogScope.closeThisDialog();;
                        }
                    }],"",{showClose:false});
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //表格--------结束-------------------------
};
