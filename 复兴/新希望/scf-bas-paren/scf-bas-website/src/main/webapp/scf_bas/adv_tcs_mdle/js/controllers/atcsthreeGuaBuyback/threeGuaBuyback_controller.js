/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var threeGuaBuybackController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
        productId:"1210010",//业务品种默认值(担保提货)
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selectSource={
        ds:[{key:"1210010",value:'担保提货'}]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
   };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                productId:"1210010",//业务品种默认值(担保提货)
            };
            $scope.selected.select=[];//清空选项
        })
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
            deliveryQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("threeProtocolService/queryThreeProtocolListByPage",data);
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
    //发起申请
    $scope.apply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $state.go("threeGuaBuybackApp");
            var data= $scope.selected.select[0];
            dataDeliver.setter(data);
            //window.data =data;
        }

    };


    //表格--------结束-------------------------

};
