/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var fourConfirmListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.conditionForm={
        protocolType:'02'
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
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
            $scope.conditionForm={
                protocolType:'02'
            };
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };
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

    $scope.queryTable = function(){
       var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            deliveryQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("aTcsThreeConfirmService/queryATcsThreeConfirmListByPage",data);
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

    //发起申请
   $scope.apply_onClick = function(){
	   if($scope.selected.select.length != 1){
           $common.get_tipDialog('请选择一条记录！','showInform');
	   }if($scope.selected.select[0].confirmStatus!="0"){
           $common.get_tipDialog('只有未收款确认才可发起申请！','showInform');
       }else{
		   $state.go("fourConfirmApply");
		   var data= $scope.selected.select[0];
	       dataDeliver.setter(data);
          // window.data =data;
	   }
	  
    };



  
    //表格--------结束-------------------------
};
