/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var fourGuaBuybackDtlController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.fourGuaBuybackform={};
    var  bData =dataDeliver.getter();
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.productSource={
        ds: []
    };
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    var seq;//流程节点顺序
    var processId = window.processId;//流程点

    if(bData.flag=="task"){ //待办任务隐藏申请页面按钮
        $scope.hideback=true; //返回按钮隐藏
    }
    var appno = bData.appno;
    if(appno==null){
        $scope.sumbitdisable=true;
        queryProtocol();
    }else{ //流程中的处理
        $scope.sumbitdisable= false;
        queryThreeGuaBuyback();
        queryInvoiceBuybackAppli();
        getCurrentNodeEntity();
    }
    //获得当前流程节点的信息
    function getCurrentNodeEntity(){
        var data = {
            pid:processId
        };
        var promise = $common.get_asyncData("processService/getCurrentNodeEntity", {pid: processId});
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
               var flowdata = res.contextData;
                seq = parseFloat(flowdata.seq);
                if (seq > 1) { //提交后的流程
                //设置只读熟悉
                    $scope.taskdisable =true;
                    //按钮隐藏
                    $scope.hidetask = true;
                    $scope.hidesumbit = true;
                    $scope.hidesave = true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    //卖方名称
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmdooextent = function(ds){
        $scope.fourGuaBuybackform.coreCustcd=ds.custcd;
        $scope.fourGuaBuybackform.coreNm=ds.cname;
    };
    $scope.$watch("fourGuaBuybackform.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:"1", //核心厂商
            cname:$scope.fourGuaBuybackform.cname
            // custcd:$scope.otherform.custcd
        };

    });

    //买方客户名称下拉-begin
    $scope.sellerNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.fourGuaBuybackform.custcd=ds.custcd;
        $scope.fourGuaBuybackform.sellerNm=ds.cname;
    };
    $scope.$watch("fourGuaBuybackform.sellerNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.sellerNmContent.param ={
            creditFlag:'1',
            custType:'1',
            sellerNm:$scope.fourGuaBuybackform.cname,
            custcd:$scope.fourGuaBuybackform.custcd
        }
    });
    //买方客户名称下拉-end

    var productPar= {
        pageNo: '1',
        pageSize: '999999',
        bPrdInfo:{parentId:'2100'}
    };
    var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage",productPar);
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.productSource.ds = data.records;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    //承担方客户名称下拉-begin
    $scope.fouNameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.fouNameExtent = function(ds){
        $scope.fourGuaBuybackform.fouCd=ds.custcd;
        $scope.fourGuaBuybackform.fouName=ds.cname;
    };
    $scope.$watch("fourGuaBuybackform.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.fouNameContent.param ={
            coreFlag:'1',
            custType:'1',
            fouName:$scope.fourGuaBuybackform.fouName,
            fouCd:$scope.fourGuaBuybackform.fouCd
        }
    });
    //承担方客户名称下拉-end

    //根据协议号加载担保提货协议信息
    function queryProtocol(){
        var threeProtocolVO ={
            protocolNo:bData.protocolNo
        };
        var data = {
            threeProtocolVO:threeProtocolVO
        };
        var promise=$common.get_asyncData("threeProtocolService/queryThreeProtocolForOneObject",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.fourGuaBuybackform=data;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //根据申请编号加载差额退款基本信息
    function queryThreeGuaBuyback(){
        var threeWareQryVO ={
            appno:bData.appno
        };
        var data = {
            threeWareQryVO:threeWareQryVO
        };
        var promise=$common.get_asyncData("aTcsThreeGuaBuyBackService/getThreeBalanceRefundByAppno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.fourGuaBuybackform=data;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    /**
     * 差额退款根据申请编号加载借据列表
     */
    function queryInvoiceBuybackAppli(){
        var threeWareQryVO={
            appno:bData.appno
        };
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            threeWareQryVO:threeWareQryVO
        };
        var promise=$common.get_asyncData("aTcsThreeGuaBuyBackService/getInvoiceBuybackAppliByAppno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

    //待退款添加begin
    $scope.add_onClick = function(){
        $common.get_ngDialog('atcsthreeGuaBuyback/threeInvoiceBuybackAdd.html', $scope
            ,["$scope",function(dialogScope){
               // debtExtSelectController(dialogScope,$scope,$common,dataDeliver,"add");
                dialogScope.datasourceDialog={//初始化表格对象
                    ds:[
                    ]
                };
                dialogScope.selectedDialog={//初始化对象
                    select: []
                };
                dialogScope.confDialog= {//初始化分页对象
                    pageNo: 1,
                    pageSize: 10,
                    totalRecord: 0};

                //监听分页
                dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){
                    //alert("我是分页监听器");
                    dialogScope.queryTable();
                });

                dialogScope.queryTable = function(){
                    var threeWareQryVO={
                        protocolNo:bData.protocolNo
                    };
                    var data= {
                        pageNo: dialogScope.confDialog.pageNo,
                        pageSize:dialogScope.confDialog.pageSize,
                        threeWareQryVO:threeWareQryVO
                    };
                    var promise=$common.get_asyncData("aTcsThreeGuaBuyBackService/getBalRefundLnciByProtocolNo",data);
                    promise.then(function (res) {
                        if(res.errorCode=="SUC"){
                            data = res.contextData;
                            dialogScope.datasourceDialog.ds = data.records;
                            dialogScope.confDialog.totalRecord = data.totalRecord;
                            //选中记录
                            // dialogScope.selectedDialog.select=parentScope.debtExtdatasource.ds;
                            dialogScope.selectedDialog.select=$common.copy($scope.datasource.ds);

                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };

                dialogScope.confirm_onClick = function(){
                    if(dialogScope.selectedDialog.select.length <= 0){
                        $common.get_tipDialog('请勾选记录之后再提交！','showInform');
                        return false;
                    }
                    //赋值到上一个页面的交易对手基本信息
                    $scope.datasource.ds=[];
                    $scope.datasource.ds = $common.copy(dialogScope.selectedDialog.select);
                    dialogScope.closeThisDialog();
                };
                //返回
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"添加页面",{showClose:true});

    };

    //待退款列表删除

    $scope.delete_onClick = function() {
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else {
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.datasource.ds;
                var selected = $scope.selected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].debetId == selected.debetId) {
                        $scope.datasource.ds.splice(i, 1);
                        $scope.selected.select = [];
                    }
                }
            })
        }
    };

    //待退款添加end
    //保存
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            if ($scope.datasource.ds.length <= 0) {
                $common.get_tipDialog("待退款列表不能为空，请添加列表数据！", 'showInform');
                return false;
            }
            $scope.savedisable= true; //点击保存之后保存按钮不可用
            var data = {
                threeBalanceRefundVO: $scope.fourGuaBuybackform,
                threeBalanceRefundLnciVOList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData("aTcsThreeGuaBuyBackService/saveBuybackWriteApply", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.fourGuaBuybackform.appno=data.value;
                    $scope.sumbitdisable= false;
                    //$scope.queryTable();
                    //$scope.selected.select = [];
                    var appno={
                    		appno:$scope.fourGuaBuybackform.appno
                        };
                    $.extend(bData,appno); //合并
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    //$state.go("bsysthreeProtocol");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.savedisable= false; //返回结果后按钮可用
            });
        }
    };
    //提交
    $scope.sumbit_onClick = function(){
      if($.doValidate("otherform")) {
            if ($scope.datasource.ds.length <= 0) {
                $common.get_tipDialog("请添加退款列表数据后再提交！", 'showInform');
                return false;
            }
            $scope.sumbitdisable= true; //点击提交之后提交按钮不可用
            var data = {
                threeBalanceRefundVO: $scope.fourGuaBuybackform,
                threeBalanceRefundLnciVOList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData("aTcsThreeGuaBuyBackService/saveBuybackWriteSubmit", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    //$scope.queryTable();
                    //$scope.selected.select = [];
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    //从待办任务进来提交之后的处理
                    if(window.appNo){
                        //隐藏列表按钮
                        $scope.hidetask = true;
                        $scope.hidesave = true;
                        $scope.hidesumbit = true;
                        $scope.hideback = true;
                    } else {
                        $scope.back_onClick();
                    }
                  
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.sumbitdisable= false; //返回结果后按钮可用
            });
        }
    };
    $scope.back_onClick = function () {
        $state.go("threeGuaBuyback");
    };
    //表格--------结束-------------------------
};
