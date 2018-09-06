/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var infolistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    if($scope.otherform.flag == "add"){
        $common.get_tipDialog("请先维护业务申请信息！",'showInform');
        var baseparam = $scope.otherform.baseparam;
        $state.go(baseparam);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == baseparam){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
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
    var  trmMo =$scope.otherform.trmMo; //期限(月)
    var  trmDay =$scope.otherform.trmMo;//期限(日)
    var obj = $scope.otherform.prdmd.obj;
    $scope[obj] = {};
    var flag = $scope.otherform.flag;
    var flg;
    var extId = $scope.otherform.extId;
    //监听分页
    if($scope.otherform.prdmd.pageUrl)
    {
        $scope.$watch("conf.pageNo+conf.pageSize",function() {
            $scope.queryTable();
        })
        if(!$scope.otherform.flag)
        {
            $scope.disableview = true;
            $scope.disable = true;
            $scope.hide = true;
        }
        else
        {
            if(flag=="view"||flag=="lnconview"||flag=="lnconedit")
            {
                $scope.disableview = true;
                $scope.disable = true;
                $scope.hide = true;
            }
        }
    }
    else
    {
        $common.get_asyncData(finUrl,{id:extId}).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope[obj] = data.record;
                flg = data.flag.relaNo;
                if(!$scope.otherform.flag)
                {
                    $scope.disableview = true;
                    $scope.disable = true;
                    $scope.hide = true;
                }
                else
                {
                    if(flag=="view"||flag=="lnconview"||flag=="lnconedit")
                    {
                        $scope.disableview = true;
                        $scope.disable = true;
                        $scope.hide = true;
                    }
                    else
                    {
                        if(flg=="add")
                        {
                            $scope.disable = false;
                            $scope.hide = false;
                        }
                        else if(flg=="update")
                        {
                            $scope.disable = true;
                            $scope.hide = false;
                        }
                    }
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    //监听分页,分页查询字段为空或未定义，则执行
    $scope.$watch("confinfo.pageNo+confinfo.pageSize",function() {
        $scope.queryTableInfo();
    })
    //页面字段长度校验
    var errorFlag=false;
    function checkFormRule(){
        if($scope.bCrrLcInfo.iseStat.length > 80){
            $common.get_tipDialog("开证地址过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.iseBak.length > 80){
            $common.get_tipDialog("开征行行名过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.prps.length > 200){
            $common.get_tipDialog("用途内容过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.lcTrm.length > 22){
            $common.get_tipDialog("付款期限过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.bnfcyNm.length > 80){
            $common.get_tipDialog("受益人名称过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.bnfcyAds.length > 200){
            $common.get_tipDialog("受益人地址名称过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.aplatNm.length > 80){
            $common.get_tipDialog("开证申请人名称过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.aplatAds.length >200){
            $common.get_tipDialog("开证申请人地址名称过长！",'showError');
            return errorFlag=true;
        }else if($scope.bCrrLcInfo.destArea.length > 60){
            $common.get_tipDialog("货物运输目的地名称过长！",'showError');
            return errorFlag=true;
        } else if($scope.bCrrLcInfo.loadArea.length > 60){
                $common.get_tipDialog("装运地名称过长！",'showError');
                return errorFlag=true;
        }
    }
    $scope.confirm_onClick = function(){
        if($.doValidate(""+obj)) {
            checkFormRule();
            if(!errorFlag){
                if($scope[obj].lcTrm)
                {
                    var lcTrm = Number($scope[obj].lcTrm);
                    if(lcTrm<=0)
                    {
                        $common.get_tipDialog('付款期限必须大于零，请重新输入！','showInform');
                        return false;
                    }
                }
                if(flg=="add")
                {
                    $scope[obj].id = extId;
                    var data={};
                    //动态key值
                    data[obj]=$scope[obj];
                    var primise = $common.get_asyncData(addUrl,data);
                    primise.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            $scope[obj] = data;
                            flg = "update";
                            $common.get_tipDialog('新增成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
                }
                else if(flg="update")
                {
                    var data={};
                    //动态key值
                    data[obj]=$scope[obj];
                    var primise = $common.get_asyncData(updUrl,data);
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('更新成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
                }
            };
            }

    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
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
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
                if(obj=="bCrrBillInfo")
                {
                    var lnAmt = 0;
                    for(var i=0;i<$scope.datasource.ds.length;i++)
                    {
                        var billObj = $scope.datasource.ds[i];
                        var billSum = Number(billObj.billSum);
                        lnAmt += billSum;
                    }
                    $scope.otherform.lnAmt = lnAmt;
                    dataDeliver.setter($scope.otherform);
                    $common.get_asyncData('bCrrLnAppService/update',{bCrrLnApp:$scope.otherform}).then(function(res){
                        if (res.errorCode =="SUC"){

                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //查找对应票据或发票信息保证金申请
    $scope.column = function(row){
        $("#billinfo").css('display', '');
        var info = {
            pageNo : $scope.confinfo.pageNo,
            pageSize : $scope.confinfo.pageSize,
            list : [row]
        };
        var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPage"+obj,info);
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
    }
    /**
     * 发票信息button
     */
    //新增
    $scope.addinv_onClick = function(){
        $common.get_ngDialog('info/inv_edit.html', $scope
            ,["$scope",function(dialogScope){
                infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"add");
            }],"新增发票信息",{showClose:false});
    };
    //编辑
    $scope.updateinv_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('info/inv_edit.html', $scope
                ,["$scope",function(dialogScope){
                    infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"update");
                }],"修改发票信息",{showClose:false});
        };
    };
    //删除
    $scope.deleteinv_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bCrrInvInfoService/batchDelete',{list:$scope.selected.select})
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
    }
    $scope.row = {};
    $scope.viewinv_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $common.get_ngDialog('info/inv_edit.html', $scope
                ,["$scope",function(dialogScope){
                    infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"view");
                }],"查看发票信息",{showClose:false});
        };
    }
    /**
     * 票据信息button
     */
        //新增
    $scope.addbill_onClick = function(){
        $common.get_ngDialog('info/bill_edit.html', $scope
            ,["$scope",function(dialogScope){
                infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"add");
            }],"新增票据信息",{showClose:false});
    };
    //编辑
    $scope.updatebill_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('info/bill_edit.html', $scope
                ,["$scope",function(dialogScope){
                    infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"update");
                }],"修改票据信息",{showClose:false});
        };
    };
    //删除
    $scope.deletebill_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bCrrBillInfoService/batchDelete',{list:$scope.selected.select})
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
    }
    //查看票据信息
    $scope.viewbill_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $common.get_ngDialog('info/bill_edit.html', $scope
                ,["$scope",function(dialogScope){
                    infoeditController(dialogScope,$scope,dataDeliver,$state,$common,"view");
                }],"查看票据信息",{showClose:false});
        }
    }
    $scope.queryTableInfo = function(paramData){
        if(flag=="lnconview"||flag=="lnconedit")
        {
            $scope.mrnFrom.appno = $scope.otherform.relaId;
        }
        else
        {
            $scope.mrnFrom.appno = $scope.otherform.appId;
        }
        var data = {
            pageNo : $scope.confinfo.pageNo,
            pageSize : $scope.confinfo.pageSize,
            bMrnAppliAcctInfo : $scope.mrnFrom
        };
        var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPage",data);
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
    //新增保证金
    $scope.addinfo_onClick = function(){
        var row = {};
        $common.get_ngDialog('info/mrn_edit.html', $scope
            ,["$scope",function(dialogScope){
                mrneditController(dialogScope,$scope,dataDeliver,$state,$common,"add",row);
            }],"新增保证金信息",{showClose:false});
    };
    //编辑保证金
    $scope.updateinfo_onClick = function(){
        if($scope.selectedinfo.select.length != 1){
            $common.get_tipDialog('请至少选择一条保证金记录！','showInform');
        }else{
            var row = $scope.selectedinfo.select[0];
            $common.get_ngDialog('info/mrn_edit.html', $scope
                ,["$scope",function(dialogScope){
                    mrneditController(dialogScope,$scope,dataDeliver,$state,$common,"update",row);
                }],"更新保证金信息",{showClose:false});
        };
    };
    //删除保证金
    $scope.deleteinfo_onClick = function(){
        if($scope.selectedinfo.select.length <= 0){
            $common.get_tipDialog('请至少选择一条保证金记录！','showInform');
        }else{
            var arrs = $common.copy($scope.selected.select);
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bMrnAppliAcctInfoService/batchDelete',{list:$scope.selectedinfo.select})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTableInfo();
                        $scope.selectedinfo.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };
    //查看保证金信息
    $scope.columninfo = function(row){
        $scope.row = row;
        $common.get_ngDialog('info/mrn_edit.html', $scope
            ,["$scope",function(dialogScope){
                mrneditController(dialogScope,$scope,dataDeliver,$state,$common,"view");
            }],"查看保证金信息",{showClose:false});
    };
    /**
     * 计算期限
     */
    $scope.wrtDt_onChange = function(val)
    {
        if($scope[obj].mtrDt)
        {
            var end = $scope[obj].mtrDt;
            checkTrm(val,end);
        }
    }
    $scope.mtrDt_onChange = function(val)
    {
        if($scope[obj].wrtDt)
        {
            var start = $scope[obj].wrtDt;
            checkTrm(start,val);
        }
    }
    function checkTrm(start,end){
        var startYear = start.substring(0,4);
        var startMon = start.substring(4,6);
        var startDay = start.substring(6,8);
        var endYear = end.substring(0,4);
        var endMon = end.substring(4,6);
        var endDay = end.substring(6,8);
        //间隔的年数
        var year = endYear - startYear;
        //间隔月数
        var mon = endMon - startMon;
        if(mon<0)
        {
            year = year - 1;
            mon = mon + 12;
        }
        //间隔天数
        var day = endDay - startDay;
        //每月的天数
        var monday;
        if(endMon=="01"||endMon=="03"||endMon=="05"||endMon=="07"||endMon=="08"||endMon=="10"||endMon=="12")
        {
            monday = 31;
        }
        if(endMon=="04"||endMon=="06"||endMon=="09"||endMon=="11")
        {
            monday = 30;
        }
        if(endMon=="02")
        {
            var sum = endYear%4;
            if(sum==0)
            {
                monday = 28;
            }
            else
            {
                monday = 29;
            }
        }
        if(day<0)
        {
            day = day + monday;
            mon = mon - 1;
            if(mon<0)
            {
                mon = mon + 12;
                year = year - 1;
            }
        }
        $scope[obj].trm = year +"年"+ mon +"月"+ day +"日";
    }
};
