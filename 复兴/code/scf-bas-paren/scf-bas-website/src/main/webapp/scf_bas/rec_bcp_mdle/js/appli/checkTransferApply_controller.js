/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var CheckTransferApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    var data1=dataDeliver.getter();
    var appno=data1.appno;
    var debtInfo={};
    //费用信息初始化
    $scope.otherform={};//初始化页面form
    $scope.costDatasource={//初始化表格对象
        ds:[]
    };
    $scope.costSelected={//初始化对象
        select: []
    };
    $scope.costConf= {//初始化分页对象
        pageNo: 1,
        pageSize: 1,
        totalRecord: 1};
    //费用监听分页
    $scope.$watch("costConf.pageNo+costConf.pageSize",function(){
        $scope.queryCostTable();
        $scope.queryForm();
    });
    //应收账款转让表单据信息
    $scope.bcpDatasource={//初始化表格对象
        ds:[],
    };
    $scope.bcpSelected={//初始化对象
        select: []
    };
    $scope.bcpConf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //应收账款转让明细信息监听分页
    $scope.$watch("bcpConf.pageNo+bcpConf.pageSize",function(){
        $scope.queryBcpTable();
    });
    //申请基本信息查询赋值给页面,查询对应应收账款信息，查询对应的申请基本信息，如果是提交状态，将提交按钮隐藏
    $scope.queryForm = function(){
        var rBcpAppliBussInfo={
            appno:appno
        }
        var promise = $common.get_asyncData("rBcpAppliBussInfoService/findBcpAppliBussInfoByKey",{rBcpAppliBussInfo:rBcpAppliBussInfo});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform = res.contextData;
                var promise2 = $common.get_asyncData("bCntDebtInfoService/findBCntDebtInfoByKey",{key:$scope.otherform.mastContno});
                promise2.then(function(res1){
                    if (res1.errorCode =="SUC"){
                        debtInfo=res1.contextData
                        $scope.otherform.bussTypeName=res1.contextData.bussTypeName;
                        var bussType=$scope.otherform.bussType
                        //todo!!!!实际上这里应该还有4种现在只涉及2个，先这样写，以后再改
                        if(bussType=="1230040" || bussType=="1230060"||bussType=="1230050"){//国内保理池，出口退税池,应收账款质押池
                            $scope.otherform.factType="8"//保理池融资\
                            $scope.otherform.mastContno1=$scope.otherform.mastContno;
                            $scope.pool=false;
                            $scope.NoPool=true;
                        }
                        if(bussType=="1230010"||bussType=="1230020"||bussType=="1230030"){//国内保理,反向保理，应收账款质押
                            $scope.otherform.factType="1"//保理融资
                            $scope.otherform.mastContno1=$scope.otherform.mastContno;
                            $scope.pool=true;
                            $scope.NoPool=false;
                        }
                    }else{
                        $common.get_tipDialog(res1.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //费用信息查询操作
    $scope.queryCostTable = function(){
        var rBcpAppliCostOut={appno:appno}
        var promise = $common.get_asyncData("rBcpAppliCostOutService/findRBcpAppliCostOutByKey",{rBcpAppliCostOut:rBcpAppliCostOut});
        promise.then(function(res){
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                if(res.contextData.id){
                    $scope.costDatasource.ds[0]= res.contextData
                }else{
                    //没有对应的费用信息则将对应的信息隐藏掉
                    $("#costinfo").css('display','none'); //不显示费用信息
                    $("#costDatasource").css('display','none'); //不显示费用信息
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //应收账款转让明细信息查询操作
    $scope.queryBcpTable = function(){
        var data= {
            pageNo: $scope.bcpConf.pageNo,
            pageSize: $scope.bcpConf.pageSize,
            value:{appno:appno}
        };
        var promise = $common.get_asyncData("rBcpAppliBussDtlService/findRBcpAppliBussDtlPageByPage",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                $scope.bcpDatasource.ds = res.contextData.records;
                $scope.bcpConf.totalRecord = res.contextData.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //单据信息查看
    //授信客户查看操作！
   $scope.column = function(row){
	   //融资模式
	   var financingType = debtInfo.financingType;
	   dataDeliver.setter(financingType);
       var rBcpDebtBaseInfo={
           billsNo:row.billsNo
       }
       var promise = $common.get_asyncData("rBcpDebtBaseInfoService/findRBcpDebtBaseInfoByKey",{rBcpDebtBaseInfo:rBcpDebtBaseInfo});
       promise.then(function(res){
           var datas= res.contextData;
           if (res.errorCode =="SUC"){
               $common.get_ngDialog('appli/bcpBaseInfo.html', $scope
                   ,["$scope",function(dialogScope){
                       BcpBaseInfoController(dialogScope,$scope,$common,dataDeliver,$state,datas);
                   }],"应收账款单据基本信息",{showClose:true});
           }else{
               $common.get_tipDialog(res.errorMsg,'showError');
           }
       });

   };

};
