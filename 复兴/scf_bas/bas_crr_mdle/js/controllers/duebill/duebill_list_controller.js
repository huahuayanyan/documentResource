/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebilllistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    /*console.log("bFinCnfgSubj信息："+JSON.stringify(userInfo));//用户信息，全局变量*/
    $scope.conditionForm={};//初始化查询条件对象
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
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        //$scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrDuebill:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrDuebillService/findBCrrDuebillByPage",data);
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
    /**
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.custNm=ds.custNm;
    };
    $scope.$watch("conditionForm.custNm",function(){
        if($scope.conditionForm.custNm!=null) $scope.custcontent.param ={custId:$scope.conditionForm.custNm,custNm:$scope.conditionForm.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var flag = "update";
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = flag;
            $common.get_asyncData('bCrrDuebillAppService/findBCrrDuebillAppById',{id:$scope.row.relaId}).then(function(res){
                var duebillapp;
                if (res.errorCode =="SUC"){
                    duebillapp = res.contextData;
                    var appId = duebillapp.appId;
                    $common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){
                        var lncon;
                        if (res.errorCode =="SUC"){
                            lncon = res.contextData;
                            $scope.row.lncon = lncon;
                            var prdId = lncon.prdId;
                            var extId = lncon.extId;
                            $scope.row.extId = extId;
                            $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                                if (res.errorCode =="SUC"){
                                    $scope.row.prdmd = res.contextData;
                                    $state.go("duebillapp");
                                    dataDeliver.setter($scope.row);
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })
        };
    };
    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var flag = "view";
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = flag;
            $common.get_asyncData('bCrrDuebillAppService/findBCrrDuebillAppById',{id:$scope.row.relaId}).then(function(res){
                var duebillapp;
                if (res.errorCode =="SUC"){
                    duebillapp = res.contextData;
                    var appId = duebillapp.appId;
                    $common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){
                        if (res.errorCode =="SUC"){
                            var lncon = res.contextData;
                            var prdId = lncon.prdId;
                            var extId = lncon.extId;
                            $scope.row.extId = extId;
                            $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                                if (res.errorCode =="SUC"){
                                    $scope.row.prdmd = res.contextData;
                                    $state.go("duebillapp");
                                    dataDeliver.setter($scope.row);
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })
        };
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗?信息删除后，出账申请需重新提交！','showTip').then(function(){
                var primise = $common.get_asyncData('bCrrDuebillService/batchDelete',{list:$scope.selected.select})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };
    $scope.column = function(row){
        var flag = "view";
        $scope.row = row;
        $scope.row.flag = flag;
        var appId = $scope.row.conNo;
        $common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){
            if (res.errorCode =="SUC"){
                var lncon = res.contextData;
                var prdId = lncon.prdId;
                var extId = lncon.extId;
                $scope.row.extId = extId;
                $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.row.prdmd = res.contextData;
                        $state.go("duebillapp");
                        dataDeliver.setter($scope.row);
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    //表格--------结束-------------------------
};
