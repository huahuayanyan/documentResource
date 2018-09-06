/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var dbrtacctdtlController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var getter = dataDeliver.getter();
    $scope.dtlconditionForm = {};
    $scope.dtldatasource ={ds:[]};
    $scope.predtldatasource ={ds:[]};
    $scope.dtlconf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    }
    $scope.dtlselected={select:[]}
    $scope.dtlconditionForm.sellerCustcd = getter.cnameSeller;
    $scope.dtlconditionForm.repayAccount = getter.returnAccount;

    //监听分页
    $scope.$watch("cntinfoconf.pageNo+cntinfoconf.pageSize",function(){
        $scope.queryBcntBuyInfo();
    });

    $scope.dtlBack_onClick = function(){
        $state.go("dbrtacctList");
    }
    $scope.isQueried = false;
    $scope.queryBcntBuyInfo = function(){
        if(!$scope.isQueried){
            var data= {
                returnAccount:$scope.dtlconditionForm.repayAccount,
                pageNo:$scope.dtlconf.pageNo,
                pageSize:$scope.dtlconf.pageSize
            };
            var promise = $common.get_asyncData("rBcpDebtReturnAccntQryService/getReturnAccountImpDtl",data);
            promise.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    $scope.predtldatasource.ds = data.records;
                    $scope.isQueried = true;
                    $scope.dtldatasource.ds = $scope.predtldatasource.ds;
                    $scope.dtlconf.totalRecord = $scope.predtldatasource.ds.length;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
            $scope.dtldatasource.select=[];
        }

        if(($scope.dtlconditionForm.payDatefrom==undefined&&$scope.dtlconditionForm.payDateto==undefined)||($scope.dtlconditionForm.payDatefrom==""&&$scope.dtlconditionForm.payDateto=="")){
            $scope.$apply(function(){
                $scope.dtldatasource.ds = $scope.predtldatasource.ds;
                $scope.dtlconf.totalRecord = $scope.predtldatasource.ds.length;
            });
        }else{
            var from =parseInt($scope.dtlconditionForm.payDatefrom);
            var to =parseInt($scope.dtlconditionForm.payDateto);
            var dsList =[];
            $scope.dtldatasource.ds =[];
            $scope.dtlconf.totalRecord = 0;
            for(var i =0;i<$scope.predtldatasource.ds.length;i++){
                var dtlval = $scope.predtldatasource.ds[i];
                var returnDateVal =parseInt(dtlval.returnDate);
                if(returnDateVal<=to&&returnDateVal>=from){
                    dsList.push(dtlval);
                }
            }
            $scope.$apply(function(){
                $scope.dtldatasource.ds = dsList;
                $scope.dtlconf.totalRecord = dsList.length;
            });

        }

    };


    $scope.dtlsubmit_onClick = function(){
        $scope.queryBcntBuyInfo();
    }


    $scope.dtlrebort_onClick = function(){
        $scope.$apply(function(){
            $scope.dtlconditionForm.payDatefrom='';
            $scope.dtlconditionForm.payDateto='';
            $scope.dtlselected.select=[];//清空选项s
        })
    }

    $scope.queryBcntBuyInfoDtl = function(){
        $scope.$apply(function(){
            $scope.dtlconditionForm={};
            $scope.dtlselected.select=[];//清空选项s
        })
    }


    //表格--------结束-------------------------
};
