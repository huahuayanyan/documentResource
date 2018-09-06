
var checkStockListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm = {productId:"1210020"};//初始化查询条件对象
    $scope.productSource = {
    		 ds:[]
        }
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.productSource();
    });
    //树==上级机构
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"",
        column:['brName']//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.treeName=ds.brName;
        $scope.conditionForm.brcode=ds.brNo;
    };
//查询业务品种
    $scope.productSource = function(){
        //业务品种下拉框
        var dataItemsDO = {parentId:"2000",productId:"1210020"};
        var data = {dataItemsDO:dataItemsDO};
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        $scope.productSource = {
       		 ds:[]
           }
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
                $scope.conditionForm.productId="1210020";
                $scope.queryTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }

    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm = {productId:"1210020"};
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
           conditionForm:$scope.conditionForm
        };
        var promise = $common.get_asyncData("fourCheckStockService/queryFourCheckStockByPage",data);
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
    //新增
    $scope.add_onClick = function(){
        var data = { };
        dataDeliver.setter(data);//传值[可选]
        $state.go("checkStockAdd");//跳转
    };


    //对账详情
    $scope.column = function(row){
            $state.go("checkStockDtl");
            var data= {
                type:'detail',
                baseInfo:row
            } ;
            dataDeliver.setter(data);
    };
    //对账确认
    $scope.update_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else if($scope.selected.select[0].status=='02'){
            $common.get_tipDialog('对账状态已完成，无法进行对账确认！','showInform');
        } else{
            $state.go("checkStockDtl");
            var data= {
                type:'save',
                baseInfo:$scope.selected.select[0]
            } ;
            dataDeliver.setter(data);
        }
    };

  
    //表格--------结束-------------------------
};
