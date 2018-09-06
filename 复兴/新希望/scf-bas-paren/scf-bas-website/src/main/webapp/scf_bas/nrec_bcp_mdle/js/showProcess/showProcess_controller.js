/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2017/1/12
 */
var showProcessController =  function($scope,$timeout,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.otherform = dataDeliver.getter();
    initData();//初始化数据
    function initData(){
        var promise = $common.get_asyncData("websiteService/getProcessRunTrail",{processId:$scope.otherform.piid,top:50},null);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                var property = {
                    haveHead: true,
                    headBtns: [],
                    editable: false,
                    haveDetail: true,
                    height: 300,
                    workWidth: data.workWidth,
                    //nodeDetail: "<input id='text' />",
                    //<input id='test' type='text'/>
                    detailHeight: 100

                };
                //var ele = $(".ngdialog-content").find("div#processView").createGooFlow(property);
                // Gooflow 属性及默认值可参考js/GooFlow/GooFlow.js中的1766行
                var processView = $('#processView').createGooFlow(property);
                processView.clearData();
                processView.loadData(data);
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

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
        totalRecord: 0
    };

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    //查询
    $scope.queryTable = function(){
        if(!$scope.otherform.piid)
        {
            $scope.datasource.ds = [];
            $scope.conf.totalRecord = 0;
        }
        else
        {
            var param = {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                appno:$scope.otherform.appno,
                flag:"1"
            };
            $common.get_asyncData("bSysTaskService/getBaseNodeAttitudeByAppno",param).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    $scope.datasource.ds = data.records;
                    $scope.conf.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    $scope.confirm_onClick = function(){
        $scope.selected.select=[];
        $state.go("list");
    }
};
