/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnconlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={appStat:"1"};//初始化查询条件对象
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
            $scope.conditionForm = {appStat:"1"};
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
            bCrrLnCon:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrLnConService/findBCrrLnConByPage",data);
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
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.custNm=ds.custNm;
    };
    $scope.$watch("conditionForm.custNm",function(){
        if($scope.conditionForm.custNm!=null) $scope.custcontent.param ={custId:$scope.conditionForm.custNm,custNm:$scope.conditionForm.custNm};
    });
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessTypeByPage",
        param:{ tFactType:"0" },
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.conditionForm.vidBusiTyp=ds.productId; //业务品种
    };
    $scope.$watch("conditionForm.vidPrdNm",function(newVal,oldVal){
        if($scope.conditionForm.vidPrdNm!=null) $scope.productNameContent.param ={
            productName:$scope.conditionForm.vidPrdNm,
            tFactType:"0"
        };
    });
    /**
     * 客户名称查询加载结束
     */
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessTypeByPage",
        param:{ tFactType:"0" },
        split:",",//分隔符
        extentColumn:"vidPrdNm",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.conditionForm.vidPrdNm=ds.productName;
        $scope.conditionForm.vidBusiTyp=ds.productId; //业务品种
    };
    $scope.$watch("conditionForm.vidBusiTyp",function(newVal,oldVal){
        if($scope.conditionForm.vidBusiTyp!=null) $scope.productNameContent.param ={
            productId:$scope.conditionForm.vidBusiTyp,
            productName:$scope.conditionForm.vidBusiTyp,
            tFactType:"0"
        };
    });
    /**
     * 业务品种筛选结束
     */
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var flag = "lnconview";
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = flag;
            $state.go("edit");//跳转
            dataDeliver.setter($scope.row);
        }
    };
    //编辑
    $scope.relate_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
           var BPbcAppliBaseInfo={
                mastContcode:$scope.selected.select[0].appId//信贷合同号
            }
            var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByLimits",{BPbcAppliBaseInfo:BPbcAppliBaseInfo});
            promise.then(function(res){
                if (res.errorCode =="SUC"){
                    var x=parseFloat(res.contextData.value);
                    if(x == 0){
                        var flag = "lnconedit";
                        $scope.row = $scope.selected.select[0];
                        $scope.row.flag = flag;
                        $state.go("edit");//跳转
                        dataDeliver.setter($scope.row);
                    }else{
                        $common.get_tipDialog('该信贷合同已涉及业务，无法再次关联！','showError');
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        };
    };

    $scope.column = function(row){
        var flag = "lnconview";
        $scope.row = row;
        $scope.row.flag = flag;
        $state.go("edit");//跳转
        dataDeliver.setter($scope.row);
    }
    //表格--------结束-------------------------
};
