/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var BcpInfoListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    $scope.conditionForm={//需要先定义业务品种对应的产品ID
        bussType:"1230010,1230020,1230030",//后台对应的业务品种字段
        //factType:"1",//应收账款融资
        flag:"01"
    };
    //业务品种筛选 bussType，conditionForm，bussTypeContent,bussTypedooextent
    $scope.bussTypeContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ tFactType:"1" },    //应收账款融资
        /*split:",",//分隔符*/
        extentColumn:"productName",
        column:["productName"]//展示内容
    };
    $scope.bussTypedooextent = function(ds){
        $scope.conditionForm.bussType=ds.productId; //业务品种
    };
    $scope.$watch("conditionForm.bussTypeName",function() {
        $scope.bussTypeContent.param = {
            productName: $scope.conditionForm.bussTypeName,
            tFactType: "1"  //应收账款融资
        };
    });
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置按钮 cnameSeller，cnameBuyer，mastContno，bussType，billsDateFrom，billsDateTo，debtEndFrom，debtEndTo
   // billsType，billsNo，status
    $scope.rebort_onClick =function(){
        $scope.conditionForm={//需要先定义业务品种对应的产品ID
            bussType:"1230010,1230020,1230030",//后台对应的业务品种字段
            flag:"01"
        };
        $scope.$apply();
    }
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoPageByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //新增应收账款信息（弹出框）
    $scope.add_onClick = function(){
        var row={};
        $common.get_ngDialog('manage/buss_choose.html', $scope
            ,["$scope",function(dialogScope){
                BussChooseController(dialogScope,$scope,$common,dataDeliver,$state,row);
            }],"合同类型选择",{showClose:true});
    };


    //应收账款信息删除操作(这里删除，只考虑了对应的应收账款信息的删除，并未级联删除！
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            if($scope.selected.select[0].status == "01"){
                if($scope.selected.select[0].isLocked == "0"){
                    $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                        var id=$scope.selected.select[0].id;
                        var primise = $common.get_asyncData('rBcpDebtBaseInfoService/deleteRBcpDebtBaseInfo',{id:id})
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                $scope.queryTable();
                                $scope.selected.select = [];
                                $common.get_tipDialog('删除成功！', 'showSuccess');
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    });
                }else{
                    $common.get_tipDialog('该信息已被锁定，无法删除！','showInform')
                }
            }else{
                $common.get_tipDialog('该记录发票状态不为“已录入”，不可删除！','showInform')
            }
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    //应收账款信息修改操作(这里必须是未锁定状态的，还有必须是"只有发票状态为‘已录入’的才允许做修改操作！") status=01
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            if($scope.selected.select[0].isLocked == "0"){
                if($scope.selected.select[0].status == "01"){
                    var data1= {
                        flag:"update",
                        rBcpDebtBaseInfo:$scope.selected.select[0],

                    };
                    dataDeliver.setter(data1);
                    $state.go("bcpInfoUpdate");
                }else{
                    $common.get_tipDialog('该记录发票状态不为“已录入”，不可修改！','showInform');
                }
            }else{
                $common.get_tipDialog('该信息已被锁定，无法修改！','showInform')
            }
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //账户信息查看操作！
    $scope.column = function(row){
        var data1= {
            flag:"view",
            rBcpDebtBaseInfo:row,

        };
        dataDeliver.setter(data1);
        $state.go("bcpInfoUpdate");
    }
    //应收账款历程信息
    $scope.progress_onClick = function(){
        if($scope.selected.select.length == 1){
                var data1= {
                    rBcpDebtBaseInfo:$scope.selected.select[0],
                };
                dataDeliver.setter(data1);
                $state.go("progress");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};
