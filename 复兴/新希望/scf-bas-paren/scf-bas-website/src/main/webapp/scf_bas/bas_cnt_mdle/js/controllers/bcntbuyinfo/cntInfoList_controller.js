/**
 * Created by htrad0055 on 2016/12/7.
 */

var cntInfoListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    $scope.conditionForm={
        protocolType:'07'//四方保兑仓协议
    };
    $scope.datasource = {
        ds:[]
    };
    $scope.selected={select:[]};
    $scope.conf={
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    }

    //--------------初始化-------------结束--------------//
    $scope.submit_onClick= function(){
        $scope.queryTable();
    };

    //重置 modify by huangshuidan 20170315
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                protocolType:'07'//三方保兑仓协议
            };
            $scope.selected.select=[];//清空选项
        })
    };
    $scope.$watch("conf.pageNo+conf.pageSize",function(){$scope.queryTable()});

    $scope.queryTable = function(paramData){

        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };

        var promise = $common.get_asyncData("iBCntBuyInfoService/queryBCntBuyInfoListByPage",data);
        promise.then(
            function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    $scope.datasource.ds = data.records;
                    $scope.conf.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            }
        );
    };

    $scope.cntAdd_onClick = function(){
        $state.go("bcntInfoAddView");
    };

    $scope.cntDelete_onClick = function(){

        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
            return false;
        }
        //增加校验已关联业务的购销合同
        var totAmt = parseFloat($scope.selected.select[0].totAmt);
        if(totAmt>0){
            $common.get_tipDialog('该购销合同已发生业务，不允许进行删除！','showInform');
            return false;
        }
        var data ={bCntBuyInfo:$scope.selected.select[0]};
        $common.get_tipDialog("确定删除选中的合同吗?",'showTip').then(function(){
            var promise = $common.get_asyncData("iBCntBuyInfoService/deleteByVO",data);
            promise.then(
                function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                }
            );
        });
    };


    $scope.cntUpdate_onClick = function(){

        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
            return false;
        }
        //增加校验已关联业务的购销合同
        var remainAmt = parseFloat($scope.selected.select[0].remainAmt);
        var totAmt = parseFloat($scope.selected.select[0].totAmt);
        if(remainAmt>0){
            $common.get_tipDialog('该购销合同正在出账申请中，无法修改！','showInform');
            return false;
        }
        var totAmt = parseFloat($scope.selected.select[0].totAmt);
        if(totAmt>0){
            $common.get_tipDialog('该购销合同已发生业务，无法修改！','showInform');
            return false;
        }
        var data ={cntInfoForm:$scope.selected.select[0]};
        $state.go("bcntInfoUpdtView");
        dataDeliver.setter(data);


    };


    $scope.column_click = function(row){

        $state.go("bcntBuyInfoview");

        dataDeliver.setter(row);
    };

    //表格--------结束-------------------------
};