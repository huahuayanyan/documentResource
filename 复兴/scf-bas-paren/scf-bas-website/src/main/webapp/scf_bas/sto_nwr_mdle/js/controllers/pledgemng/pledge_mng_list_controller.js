/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var pledgeMnglistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
        midProductId:"1200",
        billType:"2",
        businessType:"1216"
    };//初始化查询条件对象
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
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                midProductId:"1200",
                billType:"2",
                businessType:"1216"
            };
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            pledgeContractVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("billNormalPledgeMngService/ChooseContractCommonQryGetter",data);
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
        $scope.conditionForm.custcd=ds.custId;
    };
    $scope.$watch("conditionForm.cname",function(){
        if($scope.conditionForm.cname!=null) $scope.custcontent.param ={custId:$scope.conditionForm.cname,custNm:$scope.conditionForm.cname};
    });
    /**
     * 客户名称查询加载结束
     */
    $scope.applyStart_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else {
            $scope.row = {};
            var data = {
                bussInfoVO:$scope.selected.select[0]
            }
            $common.get_asyncData("billNormalPledgeMngService/BillStandardBussInfoGetter", data).then(function (res) {
                var baseinfo;
                if (res.errorCode == "SUC") {
                    baseinfo = res.contextData;
                    $scope.row = baseinfo;
                    $state.go("mngtask");
                    dataDeliver.setter($scope.row);
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
        }
    };
    //表格--------结束-------------------------
};
