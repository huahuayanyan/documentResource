/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bcntFourProtocolController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
        productId:"1210020",//业务品种默认值
        protocolType:"02",//四方保兑仓
    };//初始化查询条件对象
    $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'},]
    };
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={
            productId:"1210020",//业务品种默认值
            protocolType:"02",//四方保兑仓
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
            deliveryQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("fourProtocolService/getFranchiserProtocolQuery",data);
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
    //协议新增按钮
    $scope.doAdd_onClick = function(){
        var data= {
            flag:"add"
        };
        dataDeliver.setter(data);
        $state.go("fourProtocolAdd");
     };
    //协议修改按钮(需要关联对应的购销合同，看是否关联业务，关联就不能修改)
    $scope.doModify_onClick = function(){
    	 if($scope.selected.select.length != 1){
             $common.get_tipDialog('请选择一条记录！','showInform');
         }else{
             var protocol=$scope.selected.select[0];
             if(protocol.state != "1"){
                 $common.get_tipDialog('此先票后货协议不是有效状态，无法修改！','showInform');
             }else{
                 var promise = $common.get_asyncData("bLanLnciBaseService/queryLnciBalByProtocolNo",{protocolNo:protocol.protocolNo});
                 promise.then(function(res){
                     if (res.errorCode =="SUC"){
                         if(parseFloat(res.contextData.value) == 0){
                             if(protocol.dutyAssumeType){
                                 protocol.dutyAssumeType=(protocol.dutyAssumeType).split(",");
                             }
                             if(protocol.loanWay){
                                 protocol.loanWay=(protocol.loanWay).split(",");
                             }
                             var data= {
                                 protocol:protocol,
                                 flag:"update"
                             };
                             dataDeliver.setter(data);
                             $state.go("fourProtocolAdd");
                         }else{
                             $common.get_tipDialog("该协议下有未结清的出账，不可修改!",'showError');
                         }
                     }else{
                         $common.get_tipDialog(res.errorMsg,'showError');
                     }
                 });
             }
         }
    };
    //删除协议按钮
    $scope.doDelete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].state !="0"){
                var protocolNo=$scope.selected.select[0].protocolNo;
                var msg='确认删除 协议编号为[' + protocolNo + "]的协议吗？"
                $common.get_tipDialog(msg,'showTip').then(function(){
                    var primise = $common.get_asyncData('threeProtocolService/threeProtocolDelete',{threeProtocolVO:{protocolNo:protocolNo}});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $scope.queryTable();
                            $scope.selected.select=[];
                            $common.get_tipDialog('删除成功！','showSuccess');
                        }else{
                            $common.get_tipDialog('先票/款后货协议删除失败！','showError');
                        }
                    });
                });
            }else{
                $common.get_tipDialog('先票/款后货协议已失效,无法删除！','showError');
            }

        }
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
            protocol:data1,
            flag:"view"
        };
        dataDeliver.setter(data);
        $state.go("fourProtocolAdd");
    }
};
