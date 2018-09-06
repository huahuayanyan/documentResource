/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bcntNwrController = function($scope,$common,$state,dataDeliver) {
    $scope.productSource = {
        ds:[]
    };
    $scope.selected = {select:[]};
    $scope.conf = {
        pageNo: 1,
        pageSize: 10
    };
    $scope.protocol = {
        productId:"1202"
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
    });
    $scope.queryProtocolInfo = function(dataParam) {
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            monitorProtocol:$scope.protocol
        };
        var promise = $common.get_asyncData("monitorProtocolService/queryMonitorProtocolListByPage", data);
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var dataItemsDO = {parentId:"1000",productId:"1202"};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
                $scope.protocol = {
                    productId:"1202"
                };
                $scope.queryProtocolInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };
    //查询
    $scope.submit_onClick = function(){
        $scope.queryProtocolInfo();
        $scope.selected.select = [];
    };

    //重置
    $scope.reset_onClick = function(){
        $scope.$apply(function () {
            $scope.protocol = {
                parentId:"1000",
                productId:"1202"
            };
        })
    };

    //抵/质押合同信息列表
    $scope.protocolList_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            var  bCrrGntyCon = {vidPrdId:"1202", prtclNo:$scope.selected.select[0].protocolCode, conStat:"1"};
            dataDeliver.setter(bCrrGntyCon);
            $state.go("viewGntyCon");
        }
    };

    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('bcntmonitorProtocol/monitorProtocol.html', $scope,["$scope",function(dialogScope){
            dialogScope.protocolInfo = {state:"1",curcdNm:"CNY"};
            init();
            function init(){
                var promise = $common.get_asyncData("monitorProtocolService/initPageUserOrg");
                promise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        dialogScope.protocolInfo.tlrName = res.contextData.tlrName;
                        dialogScope.protocolInfo.tlrNo = res.contextData.tlrNo;
                        dialogScope.protocolInfo.brcodeNm = res.contextData.brcodeNm;
                        dialogScope.protocolInfo.brcode = res.contextData.brcode;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            dialogScope.cancel_onClick = function () {
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
            dialogScope.confirm_onClick = function(){
                if ($.doValidate("protocolInfoForm")){
                    if(AddCheck(dialogScope.protocolInfo)==true){
                        var data = {monitorProtocolVO:dialogScope.protocolInfo}
                        var promise = $common.get_asyncData("monitorProtocolService/monitorProtocolAdd", data);
                        promise.then(function (res) {
                            if (res.errorCode == "SUC") {
                                $common.get_tipDialog('新增成功！', 'showSuccess');
                                dialogScope.closeThisDialog();
                                $scope.queryProtocolInfo();
                                $scope.selected.select = [];
                            } else {
                                $common.get_tipDialog(res.errorMsg, 'showInform');
                            }
                        })
                    }
                }
            };
            dialogScope.save_onClick = function(){
                if ($.doValidate("protocolInfoForm")){
                    if(AddCheck(dialogScope.protocolInfo)==true){
                        var data = {monitorProtocolVO:dialogScope.protocolInfo}
                        var promise = $common.get_asyncData("monitorProtocolService/monitorProtocolAdd", data);
                        promise.then(function (res) {
                            if (res.errorCode == "SUC") {
                                $common.get_tipDialog('新增成功！', 'showSuccess');
                                dialogScope.closeThisDialog();
                                $scope.queryProtocolInfo();
                                $scope.selected.select = [];
                            } else {
                                $common.get_tipDialog(res.errorMsg, 'showInform');
                            }
                        })
                    }
                }
            };
            //合作机构下拉框
            dialogScope.cooperationBrcodeNmList = {
                type:"table",//展示类型table  tree
                url:"bSysCommonService/selectBranchInfo",//请求url
                param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split:"-",//分隔符
                extentColumn:"brName",
                column:["brNo","brName"]//展示内容
            };
            dialogScope.cooperationBrcodeNm = function(ds){
                dialogScope.protocolInfo.cooperationBrcode=ds.brNo;
                dialogScope.protocolInfo.cooperationBrcodeNm=ds.brName;
            };
            dialogScope.$watch("protocolInfo.cooperationBrcodeNm",function(){
                //ht-input-extent  需要用监听的方式来传额外的参数
                dialogScope.cooperationBrcodeNm.param ={
                    brNo:dialogScope.protocolInfo.cooperationBrcode,
                    brName:dialogScope.protocolInfo.cooperationBrcodeNm,
                    brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
                };
            });
            //业务品种下拉框
            var dataItemsDO = {parentId:"1000",productId:"1202"};
            var data = {dataItemsDO:dataItemsDO};
            var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
            dialogScope.productSource = {};
            promise.then(function(res){
                if (res.errorCode =="SUC"){
                    dialogScope.productSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            dialogScope.productId = function(productId) {
                if(productId==1202){
                    dialogScope.protocolInfo.moniType = "2";
                }else{
                    dialogScope.protocolInfo.moniType = "";
                }
            };
            //出质人名称下拉框
            dialogScope.secNameList ={
                type: "table",//展示类型table  tree
                url: "monitorProtocolService/getSecNamebyProtocol",//请求url
                //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split: "",//分隔符
                extentColumn: "codeName",
                column: ["codeName"]//展示内容
            };
            dialogScope.secName = function (ds) {
                dialogScope.protocolInfo.secName = ds.codeName;
                dialogScope.protocolInfo.secCd = ds.code;
            };
            //dialogScope.$watch("protocolInfo.secName",clearMontSecInfo);
            //function clearMontSecInfo(){
            //    dialogScope.protocolInfo.secCd = null;
            //}
            //监管公司名称下拉框
            dialogScope.thrNameList ={
                type: "table",//展示类型table  tree
                url: "monitorProtocolService/getThrNamebyProtocol",//请求url
                split: "",//分隔符
                extentColumn: "codeName",
                column: ["codeName"]//展示内容
            };
            dialogScope.$watch("protocolInfo.thrName",clearMontEntInfo);
            function clearMontEntInfo(){
                if(dialogScope.protocolInfo.thrName==""){
                    dialogScope.protocolInfo.levels = "";
                    dialogScope.protocolInfo.monitorArea = "";
                    dialogScope.protocolInfo.monitortype = "";
                    dialogScope.protocolInfo.detailMonitorArea = "";
                    dialogScope.protocolInfo.limitSum = "";
                    dialogScope.protocolInfo.monitorStatus = "";
                    dialogScope.protocolInfo.levelCogniDate = "";
                    dialogScope.protocolInfo.levelEndDate = "";
                }
            }
            dialogScope.thrName = function (ds) {
                dialogScope.protocolInfo.thrName = ds.codeName;
                dialogScope.protocolInfo.thrCode = ds.code;
                var custCd = ds.code;
                var data = {key:custCd};
                var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
                promise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        dialogScope.protocolInfo.levels = res.contextData.levels;
                        dialogScope.protocolInfo.monitorArea = res.contextData.monitorArea;
                        dialogScope.protocolInfo.monitortype = JSON.parse(res.contextData.monitortype);
                        dialogScope.protocolInfo.detailMonitorArea = res.contextData.detailMonitorArea;
                        dialogScope.protocolInfo.limitSum = res.contextData.limitSum;
                        dialogScope.protocolInfo.monitorStatus = res.contextData.monitorStatus;
                        dialogScope.protocolInfo.levelCogniDate = res.contextData.levelCogniDate;
                        dialogScope.protocolInfo.levelEndDate = res.contextData.levelEndDate;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                });
            }
            }],"新增监管合同信息");
    };

    //修改
    $scope.update_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        } else {
            if($scope.selected.select[0].state == 0){
                $common.get_tipDialog('监管合同无效，无法修改！', 'showInform');
                return;
            }
            $common.get_ngDialog('bcntmonitorProtocol/monitorProtocol.html',$scope,["$scope",function(dialogScope){
                dialogScope.productId = true;
                dialogScope.secName = true;
                dialogScope.thrName = true;
                //业务品种下拉框
                var dataItemsDO = {parentId:"1000",productId:"1202"};
                var data = {dataItemsDO:dataItemsDO};
                var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
                dialogScope.productSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.productSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //监管公司名称下拉框
                dialogScope.thrNameList ={
                    type: "table",//展示类型table  tree
                    url: "monitorProtocolService/getThrNamebyProtocol",//请求url
                    split: "",//分隔符
                    extentColumn: "codeName",
                    column: ["codeName"]//展示内容
                };
                //出质人名称下拉框
                dialogScope.secNameList ={
                    type: "table",//展示类型table  tree
                    url: "monitorProtocolService/getSecNamebyProtocol",//请求url
                    //param:{kk:"e"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split: "",//分隔符
                    extentColumn: "codeName",
                    column: ["codeName"]//展示内容
                };
                //合作机构下拉框
                dialogScope.cooperationBrcodeNmList = {
                    type:"table",//展示类型table  tree
                    url:"bSysCommonService/selectBranchInfo",//请求url
                    param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split:"-",//分隔符
                    extentColumn:"brName",
                    column:["brNo","brName"]//展示内容
                };
                dialogScope.cooperationBrcodeNm = function(ds){
                    dialogScope.protocolInfo.cooperationBrcode=ds.brNo;
                    dialogScope.protocolInfo.cooperationBrcodeNm=ds.brName;
                };
                dialogScope.protocolInfo = {};
                var custCd = $scope.selected.select[0].protocolCode;
                var key = {protocolCode:custCd};
                var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolQuery",key);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.protocolInfo = res.contextData;
                        thrNameInfo(res.contextData.thrCode);
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                function thrNameInfo(ds) {
                    var custCd = ds;
                    var data = {key:custCd};
                    var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
                    promise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            dialogScope.protocolInfo.thrName = res.contextData.thrName;
                            dialogScope.protocolInfo.levels = res.contextData.levels;
                            dialogScope.protocolInfo.monitorArea = res.contextData.monitorArea;
                            dialogScope.protocolInfo.monitortype = JSON.parse(res.contextData.monitortype);
                            dialogScope.protocolInfo.detailMonitorArea = res.contextData.detailMonitorArea;
                            dialogScope.protocolInfo.limitSum = res.contextData.limitSum;
                            dialogScope.protocolInfo.monitorStatus = res.contextData.monitorStatus;
                            dialogScope.protocolInfo.levelCogniDate = res.contextData.levelCogniDate;
                            dialogScope.protocolInfo.levelEndDate = res.contextData.levelEndDate;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    });
                }
                dialogScope.confirm_onClick = function(){
                    if ($.doValidate("protocolInfoForm")){
                        if(AddCheck(dialogScope.protocolInfo)==true){
                            var data = {monitorProtocolVO:dialogScope.protocolInfo};
                            var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolUpdate",data);
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    dialogScope.closeThisDialog();
                                    $common.get_tipDialog('修改成功！','showSuccess');
                                    $scope.queryProtocolInfo();
                                    $scope.selected.select=[];
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showInform');
                                }
                            })
                        }
                    }
                };
                dialogScope.save_onClick = function(){
                    if ($.doValidate("protocolInfoForm")){
                        if(AddCheck(dialogScope.protocolInfo)==true){
                            var data = {monitorProtocolVO:dialogScope.protocolInfo};
                            var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolUpdate",data);
                            promise.then(function (res) {
                                if (res.errorCode == "SUC") {
                                    $common.get_tipDialog('修改成功！', 'showSuccess');
                                    dialogScope.closeThisDialog();
                                    $scope.queryProtocolInfo();
                                    $scope.selected.select = [];
                                } else {
                                    $common.get_tipDialog(res.errorMsg, 'showInform');
                                }
                            })
                        }
                    }
                };
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    $scope.queryProtocolInfo();
                    $scope.selected.select=[];
                };
            }],"修改合同信息")
        }
    };

    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length < 1){
            $common.get_tipDialog('请至少选择一条记录!','showInform')
        }else{
            if($scope.selected.select[0].state == 0){
                $common.get_tipDialog('监管合同已终止,无法删除！', 'showInform');
                return;
            }
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                var data = {monitorProtocolVO:$scope.selected.select};
                var primise = $common.get_asyncData('monitorProtocolService/monitorProtocolDelete',data)
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        $scope.queryProtocolInfo();
                        $scope.selected.select = [];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                })
            })
        }
    };

    //监管商变更
    $scope.protocolChange_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        } else {
            if($scope.selected.select[0].state == 0){
                $common.get_tipDialog('监管合同无效，无法变更监管商！', 'showInform');
                return;
            }
            $common.get_ngDialog('mortgageMntProtocol/mntProtocol.html',$scope,["$scope",function(dialogScope){
                dialogScope.productId = true;
                dialogScope.secName = true;
                dialogScope.sellOffFlag = true;
                dialogScope.otherprotocolNo = true;
                dialogScope.isPledge = true;
                dialogScope.cooperationBrcodeNm = true;
                dialogScope.save = true;
                //业务品种下拉框
                var dataItemsDO = {parentId:"1000",productId:"1202"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
                dialogScope.productSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.productSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //监管公司名称下拉框
                dialogScope.thrNameList ={
                    type: "table",//展示类型table  tree
                    url: "monitorProtocolService/getThrNamebyProtocol",//请求url
                    split: "",//分隔符
                    extentColumn: "codeName",
                    column: ["codeName"]//展示内容
                }
                //出质人名称下拉框
                dialogScope.secNameList ={
                    type: "table",//展示类型table  tree
                    url: "monitorProtocolService/getSecNamebyProtocol",//请求url
                    //param:{kk:"e"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split: "",//分隔符
                    extentColumn: "codeName",
                    column: ["codeName"]//展示内容
                }
                //合作机构下拉框
                dialogScope.cooperationBrcodeNmList = {
                    type:"table",//展示类型table  tree
                    url:"bSysCommonService/selectCooperationBranch",//请求url
                    param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split:"-",//分隔符
                    extentColumn:"brName",
                    column:["brNo","brName"]//展示内容
                };
                dialogScope.docooperationBrcodeNm = function(ds){
                    dialogScope.protocolInfo.cooperationBrcode=ds.brNo;
                    dialogScope.protocolInfo.cooperationBrcodeNm=ds.brName;
                };
                dialogScope.$watch("protocolInfo.cooperationBrcodeNm",function(){
                    if(!dialogScope.protocolInfo.cooperationBrcodeNm || dialogScope.protocolInfo.cooperationBrcodeNm ==""){
                        dialogScope.protocolInfo.cooperationBrcodeNm = null;
                        dialogScope.protocolInfo.cooperationBrcode = null;
                    }
                    dialogScope.cooperationBrcodeNmList.param ={
                        brNo:dialogScope.protocolInfo.cooperationBrcode,
                        brName:dialogScope.protocolInfo.cooperationBrcodeNm,
                        brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
                    };
                });

                //先票/款后货协议号下拉框
                dialogScope.otherprotocolNoList = {
                    type:"table",//展示类型table  tree
                    url:"fourProtocolService/getFranchiserProtocolQueryByMap",//请求url
                    param:{ productId:"1202",protocolType:"01"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split:"-",//分隔符
                    extentColumn:"protocolCode",
                    column:["protocolCode"]//展示内容
                };
                dialogScope.otherprotocolNodooextent = function(ds){
                    dialogScope.protocolInfo.otherprotocolNo=ds.protocolNo;
                };
                dialogScope.$watch("protocolInfo.otherprotocolNo",function(){
                    //ht-input-extent  需要用监听的方式来传额外的参数
                    dialogScope.otherprotocolNoList.param ={
                        protocolNo:dialogScope.protocolInfo.otherprotocolNo,
                        productId:"1202" ,
                        protocolType:"01"
                    };
                });

                dialogScope.protocolInfo = {};
                var custCd = $scope.selected.select[0].protocolCode;
                var key = {protocolCode:custCd}
                var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolQuery",key);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.protocolInfo = res.contextData;
                        thrNameInfo(res.contextData.thrCode);
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                })
                function thrNameInfo(ds) {
                    var custCd = ds;
                    var data = {key:custCd}
                    var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
                    promise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            dialogScope.protocolInfo.thrName = res.contextData.thrName;
                            dialogScope.protocolInfo.levels = res.contextData.levels;
                            dialogScope.protocolInfo.monitorArea = res.contextData.monitorArea;
                            dialogScope.protocolInfo.monitortype = JSON.parse(res.contextData.monitortype);
                            dialogScope.protocolInfo.detailMonitorArea = res.contextData.detailMonitorArea;
                            dialogScope.protocolInfo.limitSum = res.contextData.limitSum;
                            dialogScope.protocolInfo.monitorStatus = res.contextData.monitorStatus;
                            dialogScope.protocolInfo.levelCogniDate = res.contextData.levelCogniDate;
                            dialogScope.protocolInfo.levelEndDate = res.contextData.levelEndDate;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    });
                }
                dialogScope.thrName = function (ds) {
                    dialogScope.protocolInfo.thrName = ds.codeName;
                    dialogScope.protocolInfo.thrCode = ds.code;
                    var custCd = ds.code;
                    var data = {key:custCd}
                    var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
                    promise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            dialogScope.protocolInfo.levels = res.contextData.levels;
                            dialogScope.protocolInfo.monitorArea = res.contextData.monitorArea;
                            dialogScope.protocolInfo.monitortype = JSON.parse(res.contextData.monitortype);
                            dialogScope.protocolInfo.detailMonitorArea = res.contextData.detailMonitorArea;
                            dialogScope.protocolInfo.limitSum = res.contextData.limitSum;
                            dialogScope.protocolInfo.monitorStatus = res.contextData.monitorStatus;
                            dialogScope.protocolInfo.levelCogniDate = res.contextData.levelCogniDate;
                            dialogScope.protocolInfo.levelEndDate = res.contextData.levelEndDate;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    });
                }
                dialogScope.confirm_onClick = function(){
                    if ($.doValidate("protocolInfoForm")){
                        if(AddCheck(dialogScope.protocolInfo)==true){
                            var data = {monitorProtocolVO:dialogScope.protocolInfo}
                            var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolChangeUpdate",data);
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    dialogScope.closeThisDialog();
                                    $common.get_tipDialog('修改成功！','showSuccess');
                                    $scope.queryProtocolInfo();
                                    $scope.selected.select=[];
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showInform');
                                }
                            })
                        }
                    }
                }

                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    $scope.queryProtocolInfo();
                    $scope.selected.select=[];
                };
            }],"监管商变更")
        }
    };

    //超链接
    $scope.protocolCode = function(data1){
        $common.get_ngDialog('bcntmonitorProtocol/monitorProtocol.html',$scope,["$scope",function(dialogScope){
            dialogScope.productId = true;
            dialogScope.secName = true;
            dialogScope.thrName = true;
            dialogScope.startDate = true;
            dialogScope.endDate = true;
            dialogScope.sellOffFlag = true;
            dialogScope.isPledge = true;
            dialogScope.cooperationBrcodeNm = true;
            dialogScope.warehouseType = true;
            dialogScope.priceDropRate = true;
            dialogScope.logisticsMoniCondition = true;
            dialogScope.otherDes = true;
            dialogScope.confirm = true;
            dialogScope.save = true;
            dialogScope.protocolInfo = {};
            //业务品种下拉框
            var dataItemsDO = {parentId:"1000",productId:"1202"};
            var data = {dataItemsDO:dataItemsDO};
            var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
            dialogScope.productSource = {};
            promise.then(function(res){
                if (res.errorCode =="SUC"){
                    dialogScope.productSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            //监管公司名称下拉框
            dialogScope.thrNameList ={
                type: "table",//展示类型table  tree
                url: "monitorProtocolService/getThrNamebyProtocol",//请求url
                split: "",//分隔符
                extentColumn: "codeName",
                column: ["codeName"]//展示内容
            };
            //出质人名称下拉框
            dialogScope.secNameList ={
                type: "table",//展示类型table  tree
                url: "monitorProtocolService/getSecNamebyProtocol",//请求url
                //param:{kk:"e"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split: "",//分隔符
                extentColumn: "codeName",
                column: ["codeName"]//展示内容
            };
            //合作机构下拉框
            dialogScope.cooperationBrcodeNmList = {
                type:"table",//展示类型table  tree
                url:"bSysCommonService/selectBranchInfo",//请求url
                param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split:"-",//分隔符
                extentColumn:"brName",
                column:["brNo","brName"]//展示内容
            };
            var protocolCode = data1.protocolCode;
            var key = {protocolCode:protocolCode}
            var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolQuery",key);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    dialogScope.protocolInfo = res.contextData;
                    thrNameInfo(res.contextData.thrCode);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            })
             function thrNameInfo(ds) {
                var custCd = ds;
                var data = {key:custCd};
                var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
                promise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        dialogScope.protocolInfo.thrName = res.contextData.thrName;
                        dialogScope.protocolInfo.levels = res.contextData.levels;
                        dialogScope.protocolInfo.monitorArea = res.contextData.monitorArea;
                        dialogScope.protocolInfo.monitortype = JSON.parse(res.contextData.monitortype);
                        dialogScope.protocolInfo.detailMonitorArea = res.contextData.detailMonitorArea;
                        dialogScope.protocolInfo.limitSum = res.contextData.limitSum;
                        dialogScope.protocolInfo.monitorStatus = res.contextData.monitorStatus;
                        dialogScope.protocolInfo.levelCogniDate = res.contextData.levelCogniDate;
                        dialogScope.protocolInfo.levelEndDate = res.contextData.levelEndDate;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                });
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.queryProtocolInfo();
                $scope.selected.select=[];
            };
        }],"查看合同信息")
    };
    function AddCheck(data){
        var startDate = data.startDate;
        var endDate = data.endDate;
        var priceDropRate = data.priceDropRate;
        if(startDate>endDate){
            $common.get_tipDialog('合同生效日不能大于合同到期日!', 'showInform');
            return false;
        }else if(!(/^(\d{1,2}(\.\d{1,2})?|100)$/.test(priceDropRate))){
            $common.get_tipDialog('价格跌幅预警不符合标准!','showInform');
            return false;
        }else{
            return true;
        }
    }
};
