/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var fourPledgeListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = {};
    $scope.otherform.flag = "lnconview";
    var sqlId = "EXT_B_CRR_GNTY_CON.getSlaveContListXPHH";
    $scope.conditionForm={
        vidPrdId:'1210020' //先票款后货
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
        totalRecord: 0};
    $scope.datasourceinfo={//初始化担保物表格对象
        ds: []
    };
    $scope.selectedinfo={//初始化担保物对象
        select: []
    };
    $scope.confinfo= {//初始化担保物分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                vidPrdId:'1210020' //先票款后货
            };
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.confinfo.pageNo=1; //点击查询按钮时查询第一页
        $scope.queryTable();
    };
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrGntyCon : $scope.conditionForm,
            sqlId : sqlId,
        };
        var promise = $common.get_asyncData("bCrrGntyConService/getSlaveContList",data);
        promise.then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                $scope.datasource.ds = gnty.records;
                $scope.conf.totalRecord = gnty.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /**
     * 担保人名称查询加载开始
     */
    $scope.gutcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.gutextend = function(ds){
        $scope.conditionForm.gutNm = ds.custNm;
    };
    $scope.$watch("conditionForm.gutNm",function(){
        if($scope.conditionForm.gutNm!=null){
            $scope.gutcontent.param ={custId:$scope.conditionForm.gutNm,custNm:$scope.conditionForm.gutNm};
        }
    });
    /**
     * 担保人名称查询加载结束
     */
    $scope.apply_onClick = function(){
        if($scope.selected.select.length!=1){
            $common.get_tipDialog('请选择一条记录!','showInform');
        }else{
            var data = $scope.selected.select[0];
            dataDeliver.setter(data);//传值[可选]
            $state.go("fourPledgeApply");
        }
    }
};
