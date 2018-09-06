
var fourProtocolController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
        //productId:"1210020",//业务品种默认值
        protocolType:"02"//四方保兑仓
    };//初始化查询条件对象
    //$scope.selectSource = {
    //    ds:[{key:"1210020",value:'先票/款后货'},]
    //};
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //树==上级机构
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"treeName",
        column:['brName']//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.treeName=ds.brName;
        $scope.conditionForm.brcode=ds.brNo;
    };
    $scope.$watch("conditionForm.treeName",function(a, b){
        $scope.content.param ={
            brName:$scope.conditionForm.treeName
        };
        if($scope.conditionForm.treeName==null||$scope.conditionForm.treeName==""){
            $scope.conditionForm.brcode=null;
        }
    });

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={
            //productId:"1210020",//业务品种默认值
            protocolType:"02"//四方保兑仓
        };
        $scope.selected.select=[];//清空选项
        $scope.$apply();
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            conditionForm:$scope.conditionForm
        };
        var promise = $common.get_asyncData("franchiserProtocolMngService/queryFranchiserProtocolByPage",data);
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

    //查看对应信息
    $scope.protocolCode = function(data1){
        if(data1.dutyAssumeType){
            data1.dutyAssumeType=(data1.dutyAssumeType).split(",");
        }
        if(data1.loanWay){
            data1.loanWay=(data1.loanWay).split(",");
        }
        var data= {
            info:data1,
            flag:"view"
        };
        dataDeliver.setter(data);
        $state.go("franchiserDtl");
    }
};
