/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillinfoController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    /**
     * 票据发票公共部分
     * @type {{}}
     */
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
    /**
     * 保证金信息
     */
    $scope.mrnFrom = {};
    $scope.datasourceinfo={//初始化保证金表格对象
        ds: []
    };
    $scope.selectedinfo={//初始化保证金对象
        select: []
    };
    $scope.confinfo= {//初始化保证金分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //全局变量
    var prdTyp = $scope.otherform.prdmd.prdTyp;
    var finUrl = $scope.otherform.prdmd.finUrl;
    var addUrl = $scope.otherform.prdmd.addUrl;
    var updUrl = $scope.otherform.prdmd.updUrl;
    var pageUrl = $scope.otherform.prdmd.pageUrl;
    var titNm = $scope.otherform.prdmd.titNm;
    var obj = $scope.otherform.prdmd.obj;
    $scope[obj] = {};
    var extId = $scope.otherform.extId;
    $scope.disableview = true;
    $scope.disable = true;
    $scope.hide = true;
    //监听分页
    if($scope.otherform.prdmd.pageUrl)
    {
        $scope.$watch("conf.pageNo+conf.pageSize",function() {
            $scope.queryTable();
        })
    }
    else
    {
        $common.get_asyncData(finUrl,{id:extId}).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope[obj] = data.record;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    $scope.queryTable = function(paramData){
        $scope.conditionForm.extId = extId;
        var data = {};
        data.pageNo = $scope.conf.pageNo;
        data.pageSize = $scope.conf.pageSize;
        data[obj]=$scope.conditionForm;
        var promise = $common.get_asyncData(pageUrl,data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
                //var list = $scope.datasource.ds;
                //var info = {
                //    pageNo : $scope.confinfo.pageNo,
                //    pageSize : $scope.confinfo.pageSize,
                //    list : list
                //};
                //var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPage"+obj,info);
                //promise.then(function(res){
                //    var data;
                //    if (res.errorCode =="SUC"){
                //        data = res.contextData;
                //        $scope.datasourceinfo.ds = data.records;
                //        $scope.confinfo.totalRecord = data.totalRecord;
                //    }else{
                //        $common.get_tipDialog(res.errorMsg,'showError');
                //    }
                //});
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //监听分页,分页查询字段为空或未定义，则执行
    $scope.$watch("confinfo.pageNo+confinfo.pageSize",function() {
        $scope.queryTableInfo();
    })
    //查找对应票据或发票信息保证金申请
    //$scope.column = function(row){
    //    $("#billinfo").css('display', '');
    //    var info = {
    //        pageNo : $scope.confinfo.pageNo,
    //        pageSize : $scope.confinfo.pageSize,
    //        list : [row]
    //    };
    //    var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPage"+obj,info);
    //    promise.then(function(res){
    //        var data;
    //        if (res.errorCode =="SUC"){
    //            data = res.contextData;
    //            $scope.datasourceinfo.ds = data.records;
    //            $scope.confinfo.totalRecord = data.totalRecord;
    //        }else{
    //            $common.get_tipDialog(res.errorMsg,'showError');
    //        }
    //    });
    //}
    //$scope.row = {};
    //$scope.viewinv_onClick = function(){
    //    if($scope.selected.select.length <= 0){
    //        $common.get_tipDialog('请至少选择一条记录！','showInform');
    //    }else{
    //        $scope.row = $scope.selected.select[0];
    //        $common.get_ngDialog('info/inv_edit.html', $scope
    //            ,["$scope",function(dialogScope){
    //                infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"view");
    //            }],"查看发票信息",{showClose:false});
    //    };
    //}
    /**
     * 票据信息button
     */
    //查看票据信息
    $scope.viewbill_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $common.get_ngDialog('info/bill_edit.html', $scope
                ,["$scope",function(dialogScope){
                    infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"view");
                }],"查看票据信息",{showClose:false});
        }
    }
    $scope.queryTableInfo = function(paramData){
    	var lnConNo;
        if(!$scope.otherform.appId)
        {
            lnConNo = $scope.otherform.conNo;
        }
        if(!$scope.otherform.conNo)
        {
            lnConNo = $scope.otherform.appId;
        }
        var data = {
            pageNo : $scope.confinfo.pageNo,
            pageSize : $scope.confinfo.pageSize,
            appId : lnConNo
        };
        var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPageConNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourceinfo.ds = data.records;
                $scope.confinfo.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //查看保证金信息
    $scope.columninfo = function(row){
        $scope.row = row;
        $common.get_ngDialog('info/mrn_edit.html', $scope
            ,["$scope",function(dialogScope){
                mrneditController(dialogScope,$scope,dataDeliver,$state,$common,"view");
            }],"查看保证金信息",{showClose:false});
    };
};
