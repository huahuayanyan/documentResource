/**findBCrmBaseInfoByKey
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var BcpInfoAddController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
//先将之前的数据赋值给对应的页面，底下的是没新增一个赋值给页面一个，最后是批量新增，这样的话，后台的方法就需要新增一个批量新增操作。
    var data1=dataDeliver.getter();
    data1.aging=parseFloat(data1.aging);
    $scope.otherform=data1;//将之前的数据赋值给页面。币种要赋值给下面的table
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}


    //新增应收账款凭据信息（弹出框）
    $scope.add_onClick = function(){
        if($.doValidate("otherform")){
            var row= $scope.otherform;
            $common.get_ngDialog('debtPoolManage/bill_add.html', $scope
                ,["$scope",function(dialogScope){
                    BillAddController(dialogScope,$scope,$common,"add",row);
                }],"凭证信息编辑",{showClose:true});
        }
    };

    //应收账款凭据信息删除操作
    $scope.delete_onClick = function(){
        if($scope.selected.select.length >= 1){
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.datasource.ds;
                var selected = $scope.selected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].billsNo == selected.billsNo) {
                        $scope.datasource.ds.splice(i, 1);
                        $scope.selected.select = [];
                    }
                }
                $scope.conf.totalRecord= $scope.datasource.ds.length;
            })
        }else{
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }
    }

    //应收账款单据信息修改操作
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            var row= $scope.otherform;
            $common.get_ngDialog('debtPoolManage/bill_add.html', $scope
                ,["$scope",function(dialogScope){
                    BillAddController(dialogScope,$scope,$common,"update",row);
                }],"凭证信息编辑",{showClose:true});
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //应收账款信息保存操作（批量查询，只有到后台）
    $scope.save_onClick = function(){
        if($.doValidate("otherform")){//页面必输校验
            if($scope.datasource.ds.length > 0){
                var primise2 = $common.get_asyncData('rBcpDebtBaseInfoService/batchAddRBcpDebtBaseInfo',{value:$scope.datasource.ds})
                primise2.then(function(res){
                    if (res.errorCode =="SUC"){
                        $state.go("bcpInfoList");//返回首页面
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog("请添加应收账款凭证信息！",'showError');
            }
        }
    }
    //先查询有没有重复，没有重复再保存，然后再返回保存的数据给页面，这个时候买方名称肯定是钉死的，不让客户再去改，因为改了就没有意义了。
    $scope.saveAndTransfer_onClick = function(){
        if($.doValidate("otherform")){//页面必输校验
            var aging=$scope.otherform.aging;
            if(aging <= 0){
                $common.get_tipDialog("账期必须大于零！",'showError');
            }else{
                if($scope.datasource.ds.length > 0){
                    var primise2 = $common.get_asyncData('rBcpDebtBaseInfoService/saveAndTransferRBcpDebtBaseInfo',{value:$scope.datasource.ds})
                    primise2.then(function(res){
                        if (res.errorCode =="SUC"){
                            var bcpDatasource=res.contextData
                            var dataX={
                                //这里的
                                debtInfo:$scope.otherform,
                                bcpDatasource:bcpDatasource,
                            }
                            dataDeliver.setter(dataX);
                            $state.go("debtPoolTransfer");//返回首页面
                            $common.get_tipDialog('保存成功！', 'showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }else{
                    $common.get_tipDialog("请添加应收账款凭证信息！",'showError');
                }
            }
        }
    }
    //返回按钮
    $scope.back_onClick = function(){
        $state.go("bcpInfoList");//返回首页面
    }
};



