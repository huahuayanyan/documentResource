/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var TabAcctListController = function($scope,$common,$state,dataDeliver) {

    var dataGetter = dataDeliver.getter();
    var flag = dataGetter.flag;
    var orgCode = dataGetter.orgCode;

    var custcdVal ="";
    var cnameVal = "";

    $scope.datasource ={ds:[]};
    $scope.selected={select:[]};
    $scope.conf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    }

    $scope.conditionForm ={
    }

    $scope.hide = false;

    if(flag=="view"){
        $scope.hide = true;
    }

    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTabConditions();
    });

    $scope.queryTabConditions = function(){
        if(flag!="add"){
            custcdVal = dataGetter.bCrmBaseInfo.custcd;
            cnameVal = dataGetter.bCrmBaseInfo.cname;
            $scope.queryTable();
        }else{
            var data={
                bCrmBaseInfo: {
                    orgCode:orgCode
                }
            }
            var url="bCrmBaseInfoService/findBCrmBaseInfoByKey";
            $common.get_asyncData(url,data).then(function(res){
                if(res.errorCode=="SUC"){
                    data = res.contextData;
                    if(data.orgCode==orgCode){
                        custcdVal = data.custcd;
                        cnameVal = data.cname;
                        $scope.queryTable();
                    } else{
                        $state.go("tree.basic");
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "tree.basic"){
                                    $scope.$parent.select(pane);
                            };
                    });
                        $common.get_tipDialog("请先完成客户基本信息保存！",'showInform');
                    }
                }
            });
        }
    }



    $scope.queryTable = function(){
        $scope.conditionForm.custcd = custcdVal;
        $scope.conditionForm.cname = cnameVal;
        var data ={
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            bAccAccountInfo:$scope.conditionForm};
        $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByPage",data).then(function(res){
            if(res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds =data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }


    $scope.add_onClick = function(){
        var row={
            custcd:custcdVal,// 声明客户号
            cname:cnameVal// 声明客户名称
        };
        $common.get_ngDialog("bcrmflc/acct_add.html",$scope,["$scope",function(dialogScope){
            AccInfoAddController(dialogScope,$scope,$common,"add",row);
        }],"新增账户",{showClose:false});
    }

    $scope.update_onClick = function(){
        if($scope.selected.select.length ==1){
            var row = $scope.selected.select[0];

            $common.get_ngDialog("bcrmflc/acct_add.html",$scope,["$scope",function(dialogScope){
                AccInfoAddController(dialogScope,$scope,$common,"update",row);
            }],"修改账户",{showClose:false})
        }else{
            $common.get_tipDialog("请选择一条记录",'showInfo');
        }

    }

    $scope.submit_onClick = function(){
        $scope.queryTable();
    }

    $scope.rebort_onClick = function(){
        $scope.conditionForm.accountNo="";
        $scope.conditionForm.accountType="";
        $scope.selected.select = [];
        $scope.queryTable();
    }

    $scope.column = function(row){
        $common.get_ngDialog("bcrmflc/acct_add.html",$scope,["$scope",function(dialogScope){
            AccInfoAddController(dialogScope,$scope,$common,"view",row);
        }])
    }

    $scope.delete_onClick=function(){
        if($scope.selected.select.length==1){
            var row =$scope.selected.select[0];
            var acctArr = $common.copy($scope.selected.select);
            var data={idList:acctArr};
            $common.get_asyncData("bAccAccountInfoService/batchDelete",data).then(function(res){
                if(res.errorCode=="SUC"){
                    $scope.selected.select=[];
                    $scope.queryTable();
                    $common.get_tipDialog("成功删除",'showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }else{
            $common.get_tipDialog("请选择一条记录",'showInform');
        }
    }

    $scope.confuse_onClick = function(){
        $state.go("base");
    }
};
