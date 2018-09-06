/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var billlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={vidNo:'#'};//初始化查询条件对象
    $scope.row = {};//初始化传值参数
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
            $scope.conditionForm = {vidNo:'#'};
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
            bCrrLnCon:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrLnConService/findBCrrLnConByPage",data);
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
    $scope.source = {};
    //发起申请
    $scope.startApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
        else
        {
            $scope.flowsubmitdisable = true;
            $scope.row = $scope.selected.select[0];
            var promise = $common.get_asyncData("dismortgageBillService/StartUpdater",{bCrrLnConCash:$scope.row});
            promise.then(function(res){
                var lnapp;
                if (res.errorCode =="SUC"){
                    lnapp = res.contextData;
                    var appno = lnapp.value;
                    $scope.row.appno = appno;
                    var promise = $common.get_asyncData("dismortgageBillService/DismortgageBillWriteContGetter",{bCrrLnConCash:$scope.row});
                    promise.then(function(res){
                        var lncon;
                        if (res.errorCode =="SUC"){
                            lncon = res.contextData;
                            var lnconform = lncon.records[0];
                            $scope.lnconform = lnconform;
                            $scope.lnconform.appno = appno;
                            $scope.source.lnconform = $scope.lnconform;
                            $common.get_asyncData("dismortgageBillService/findBPbcAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
                                var applitask;
                                if (res.errorCode == "SUC") {
                                    applitask = res.contextData;
                                    $scope.source.applitask = applitask;
                                    if(!applitask.piid)
                                    {
                                        $scope.source.taskform = {};
                                        $state.go("billedit");//跳转
                                        window.source = $scope.source;
                                    }
                                    else
                                    {
                                        $common.get_asyncData("processService/getCurrentNodeEntity", {pid:applitask.piid}).then(function (res) {
                                            var taskform;
                                            if (res.errorCode == "SUC") {
                                                taskform = res.contextData;
                                                $scope.source.taskform = taskform;
                                                $state.go("billedit");//跳转
                                                window.source = $scope.source;
                                            } else {
                                                $scope.flowsubmitdisable = false;
                                                $common.get_tipDialog(res.errorMsg, 'showInform');
                                            }
                                        })
                                    }
                                } else {
                                    $scope.flowsubmitdisable = false;
                                    $common.get_tipDialog(res.errorMsg, 'showInform');
                                }
                            })
                        }else{
                            $scope.flowsubmitdisable = false;
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }else{
                    $scope.flowsubmitdisable = false;
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        };
    };
    //表格--------结束-------------------------
};
