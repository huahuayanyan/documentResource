/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var fourPledgeListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
        vidPrdId:'1220010'
    };//初始化查询条件对象
    $scope.selectSource = {
        ds:[{key:"1220010",value:'现货静态质押'},]
    };
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                vidPrdId:'1220010'
            };
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrGntyCon:$scope.conditionForm
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
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.cnameExtent = function(ds){
        $scope.conditionForm.gutId=ds.custcd;
    };
    $scope.$watch("conditionForm.cname",function(){
        $scope.cnameContent.param ={
            cname:$scope.conditionForm.gutNm,
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
