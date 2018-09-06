/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var TabRelationListController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {

    var data1 = dataDeliver.getter();
    var flag = data1.flag;

    var bCrmBaseInfoVO = {
        orgCode:data1.orgCode
    }

    $scope.conditionForm = {
    };//初始化条件查询框

    $scope.datasource = {//初始化表格对象
        ds: []
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    }

    $scope.hide=false;

    var custcdVal = "";

    //if(flag =="view"){
    //
    //    $scope.disable=true;
    //    $scope.hide = true;
    //    $scope.otherform = data.bCrmBaseInfo;
    //    var qryParams={customerQryVO: {custcd:data.bCrmBaseInfo.custcd}};
    //    $common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams).then(function(res){
    //        if(res.errorCode="SUC"){
    //            $scope.otherform = res.contextData;
    //        }else{
    //            $common.get_tipDialog(res.errorMsg, 'showError');
    //        }
    //    })
    //
    //}else{
    //    if(flag=="add"){
    //        $scope.otherform.orgCode = data.orgCode;
    //        //$scope.otherform.ccmsCustcd = data.ccmsCustcd;
    //    }else if(flag="update"){
    //        $scope.otherform = data.bCrmBaseInfo;
    //        var qryParams={customerQryVO: {custcd:data.bCrmBaseInfo.custcd}};
    //        $common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams).then(function(res){
    //            if(res.errorCode="SUC"){
    //                $scope.otherform = res.contextData;
    //            }else{
    //                $common.get_tipDialog(res.errorMsg, 'showError');
    //            }
    //        })
    //    }
    //    if($scope.otherform.ccmsCustcd==null||$scope.otherform.ccmsCustcd==undefined){
    //        $common.get_asyncData("bCrmInsureCustomerService/generateCcmsCustcd").then(function(res){
    //            if(res.errorCode=="SUC") {
    //                $scope.otherform.ccmsCustcd = res.contextData.value;
    //            }
    //        });
    //    }
    //
    //}

    if(flag=="add"){

        var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey", {bCrmBaseInfo: bCrmBaseInfoVO});
        primise.then(function(res){
            var data = res.contextData;
            if(res.errorCode =="SUC"){
                if(data.orgCode==data1.orgCode){
                    $scope.$watch("conf.pageNo+conf.pageSize",function(){
                        $scope.queryTab();
                    });

                    $scope.queryTab = function(){
                        var data= {
                            pageNo: $scope.conf.pageNo,
                            pageSize: $scope.conf.pageSize,
                            customerQryVO:$scope.conditionForm
                        };
                        var promise = $common.get_asyncData("bCrmCustomerService/findFactorCustRelationPageByCust",data);
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
                }else {
                        $state.go("tree.basic");
                        $common.get_tipDialog('请先完成客户保存！', 'showInform');
                    }
            }else{
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });


    }else{
        custcdVal = data1.bCrmBaseInfo.custcd;
        if(flag=="view"){
            $scope.hide = true;
        }

        $scope.$watch("conf.pageNo+conf.pageSize",function(){
            $scope.queryTab();
        });

        $scope.queryTab = function(){

            $scope.conditionForm.custcd=custcdVal;
            var data= {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                customerQryVO:$scope.conditionForm
            };
            var promise = $common.get_asyncData("bCrmCustomerService/findFactorCustRelationPageByCust",data);
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
    }


    //重置按钮accountNo,accountType
    $scope.rebort_onClick =function(){
        $scope.conditionForm.otherCustcd_Q = "";
        $scope.conditionForm.otherCname_Q = "";
        $scope.queryTable();
    }

    $scope.add_onClick = function(){
        $scope.disable=true;
        var row={
            coreCustName:coreCustName,//核心客户名称
            coreCustcd:coreCustcd//和核心厂商客户号传给弹出页面
        };
        $common.get_ngDialog('bcrmfactor/relation_add.html', $scope
            ,["$scope",function(dialogScope){
                RelationAddController(dialogScope,$scope,$common,"add",row);
            }],"新增操作",{showClose:false});
    }

    $scope.update_onClick = function(){
        if($scope.selected.select.length==1){
            $scope.disable = true;
            $common.get_ngDialog('bcrmfactor/relation_add.html',$scope,
                ["scope",function(dialogScope){
                    RelationAddController(dialogScope,$scope,$common,"add",row);}],"更新操作",{showClose:false})
        }else{
            $common.get_tipDialog("请选择一条记录","showInfom");
        }

    }
    //返回按钮confuse
    $scope.confuse_onClick=function(){
        $state.go("base");
    }




};



