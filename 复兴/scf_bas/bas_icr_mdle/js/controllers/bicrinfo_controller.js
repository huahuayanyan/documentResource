/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var bicrinfoController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
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
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        //alert("我是分页监听器");
        $scope.queryTable();
    });
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={};
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
            bIcrInfo:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bIcrInfoService/findBIcrInfoListByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                // queryManager();
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };

    //新增按钮
   $scope.add_onClick = function(){
       $state.go("bicrinfoadd");
       var data= {
           flag:"add"
       };
       dataDeliver.setter(data);
    };
    //修改按钮
    $scope.update_onClick = function(){

        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }if($scope.selected.select[0].status!="1"){
            $common.get_tipDialog('只有有效状态的额度才可以终止！','showInform');
        }else{
            $state.go("bicrinfoadd");
            var data= {
                flag:"update",
                bicrInfo:$scope.selected.select[0]
            };
            dataDeliver.setter(data);
        }

    };
    //终止
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }if($scope.selected.select[0].status!="1"){
            $common.get_tipDialog('只有有效状态的额度才可以终止！','showInform');
        }else{
            var arrs = $common.copy($scope.selected.select);
            var creditNos = "";
            for(var i=0 ; i<arrs.length ; i++)
            {
                creditNos += (arrs[i].creditNo)+",";
            }
            var msg='确认终止额度编号为[' + creditNos + "]的间接额度吗？"
            $common.get_tipDialog(msg,'showTip').then(function(){
                var primise = $common.get_asyncData('bIcrInfoService/updateBIcrInfoStatus',{creditNos:creditNos});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('终止成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };
    //查看
    $scope.column = function(row){
        $state.go("bicrinfoview");
        dataDeliver.setter(row);
    };
    //表格--------结束-------------------------
};
