/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var jbxxController = function($scope,$common,$stateParams,dataDeliver,$state,$eventCommunicationChannel){

    alert(JSON.stringify($stateParams))
    //$eventCommunicationChannel.onEditData($scope,function(data){
    //    alert(data);
    //});
    $eventCommunicationChannel.editData("www");
    //页面跳转+信息传递
    $scope.jdxxButton_onClick =function(){
        dataDeliver,setter("");
        $state.go("mx.fkxx");//跳转
        dataDeliver.setter({data:"sgf6d54d6"});//传值[可选]
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == "mx.fkxx"){
                $scope.$parent.select(pane);
            };
        });
    };

    $scope.conf= {pageNo: 1, pageSize: 5};
    $scope.$watch("conf.pageNo+conf.pageSize",queryTable);
    $scope.otherform={};
    $scope.selected={select: []};
    $scope.datasource={ds: []};
    $scope.submit_onClick =function(){
        queryTable();
        $scope.selected.select=[];
    };
    $scope.fresh_onClick = function(){
        $scope.otherform={};
        queryTable();
    };
    $scope.column = function(row){
        console.log(JSON.stringify(row))
    };
    function queryTable(paramData){
        var data= {
            pageNo: 1,
            pageSize: 10,
            otherform:paramData
        };
        var promise = $common.get_asyncData("orgUserService/findOrgUserByPage2",data);
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
}