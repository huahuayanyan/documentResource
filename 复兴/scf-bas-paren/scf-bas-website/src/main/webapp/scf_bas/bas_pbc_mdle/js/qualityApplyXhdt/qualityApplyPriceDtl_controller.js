/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var fourPledgePriceController = function($scope,$common,$state,dataDeliver) {
    $scope.datasource = {ds:[]};
    $scope.selected={//初始化对象
        select: []
    };
    $scope.otherform = {};
    $scope.productSource = {
        ds:[
            {code:"1220010",codeName:'现货静态质押'},
            {code:"1220020",codeName:'现货动态质押'},
        ]
    };
    var dataX = dataDeliver.getter();
    var appno = dataX.appno;
    $scope.otherform.appno=appno;
    var conId = dataX.conId;
    var gutId = dataX.gutId;
    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    if(window.appNo) {
        getCurrentNodeEntity();
    }
    $scope.submitdisable = true;  //提交按钮不可用
    $scope.conf = {
        pageNo:1,
        pageSize:10,
        totalRecord: 0
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //申请 -核价
    //获得当前流程节点的信息
    function getCurrentNodeEntity(){
        var data = {
            pid:processId
        };
        var promise = $common.get_asyncData("processService/getCurrentNodeEntity", data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                var flowdata = res.contextData;
                seq = parseFloat(flowdata.seq);
                if(seq==2){ //check 核价
                    $scope.hidecheck = true;
                }
                if (seq>2) {  //check 核价之后
                    $scope.hideapprove =true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

    queryMortgageInfo();//申请基本信息查询

    function queryMortgageInfo(){
        var qualityApplyDO = {conId:conId,appNo:appno};
        var data = {
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            qualityApplyDO: qualityApplyDO
        }
        var promise = $common.get_asyncData("qualityApplyService/slaveProtocontInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.otherform = res.contextData;
                $scope.otherform.appno=appno;
                $scope.otherform.slaveContno=$scope.otherform.conId;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            appno:appno
        };
        var promise = $common.get_asyncData("bPbcAppliMtgInfoService/queryNotifyMortgageListByAppno",data);
        promise.then(function(res){
            var response;
            if (res.errorCode =="SUC"){
                response = res.contextData;
                $scope.datasource.ds = response.records;
                $scope.conf.totalRecord = response.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };


    //已入库押品详情查看按钮
    $scope.enterDetail_onClick = function(){
        $common.get_ngDialog('qualityApplyXhdt/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
            dialogScope.datasource = {
                ds:[]
            };
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10,
                totalRecord:0
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

            var mortgageQryVO ={
                slaveContno:$scope.otherform.slaveContno
            };
            function queryMortgageListInfo(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageQryVO:mortgageQryVO
                };
                var promise = $common.get_asyncData("bPbcMtgBaseInfoService/getMortgageBaseInfoPageByParam", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
            }
        }
        ],"押品列表",{showClose:true});
    };
    //核价按钮
    $scope.check_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
          $common.get_ngDialog('qualityApplyXhdt/mortgagePrice.html',$scope,["$scope",function(dialogScope){
                dialogScope.mortgagePrice = {};
                dialogScope.mortgageLevelThreeSource = {
                  ds:[]
                };
              dialogScope.mortgagePrice = $common.copy($scope.selected.select[0]); //临时存储页面之前修改输入的字段
              //核价，当前市场价格
              if(!dialogScope.mortgagePrice.confirmPrice){
                  dialogScope.mortgagePrice.confirmPrice=0
              }
              if(!dialogScope.mortgagePrice.marketPrice){
                  dialogScope.mortgagePrice.marketPrice=0
              }
              mortgageLevelThreeSource();
              /* var mortgageNo = $scope.selected.select[0].mortgageNo;
                var fourDeliveryQryVO ={
                  mortgageNo:mortgageNo
                };
                var data = {fourDeliveryQryVO:fourDeliveryQryVO};
                var promise = $common.get_asyncData("fourPledgeService/queryNotifyMortgageByMortgageNo",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgagePrice = res.contextData;
                        dialogScope.mortgagePrice =  $.extend(dialogScope.mortgagePrice,dialogScope.mortgagePrice);
                        mortgageLevelThreeSource();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });*/

                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelOneSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品二级
                mortgageLevelTwoSource();
                function mortgageLevelTwoSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"2"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelTwoSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品三级
               //mortgageLevelThreeSource();
                function mortgageLevelThreeSource() {
                  //业务品种下拉框
                  var levelTwo = dialogScope.mortgagePrice.mortgageLevelTwo;
                  var dataItemsDO = {mortgageCode:levelTwo};
                  var data = {dataItemsDO:dataItemsDO};
                  var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                  promise.then(function (res) {
                      if (res.errorCode == "SUC") {
                          dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                      } else {
                          $common.get_tipDialog(res.errorMsg, 'showInform');
                      }
                  });
              }
              dialogScope.mortgageLevelOneName = function (val){
                  dialogScope.mortgagePrice.mortgageLevelTwo = "";
                  if(null != val){
                      var dataItemsDO = {mortgageCode:val};
                      var data = {dataItemsDO:dataItemsDO};
                      var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                      mortgageName.then(function(res){
                          if(res.errorCode =="SUC"){
                              dialogScope.mortgagePrice.mortgageLevelOneName = res.contextData.mortgageName;
                          }else{
                              $common.get_tipDialog(res.errorMsg,'showInform');
                          }
                      });
                      var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                      primise.then(function(res){
                          if(res.errorCode =="SUC"){
                              dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                          }else{
                              $common.get_tipDialog(res.errorMsg,'showInform');
                          }
                      });
                  }else{
                      dialogScope.mortgageLevelTwoSource.ds = [];
                  }
              };


              dialogScope.mortgageLevelTwoName = function (val){
                  dialogScope.mortgagePrice.mortgageLevelThreeSource = "";
                  if(null != val){
                      var dataItemsDO = {mortgageCode:val};
                      //var data = {dataItemsDO:dataItemsDO};
                      var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                      mortgageName.then(function(res){
                          if(res.errorCode =="SUC"){
                              dialogScope.mortgagePrice.mortgageLevelTwoName = res.contextData.mortgageName;
                          }else{
                              $common.get_tipDialog(res.errorMsg,'showInform');
                          }
                      });
                  }else{
                      dialogScope.mortgageLevelThreeSource.ds = [];
                  }
              };
              //绑定市价/取消绑定  lock 绑定
              dialogScope.bindMarketPrice_onClick=function () {
                  $common.get_ngDialog('qualityApplyXhdt/mortgagePriceList.html',$scope,["$scope",function(dialogScope2){

                      dialogScope2.datasource={ds:[]};

                      dialogScope2.selected={select:[]};

                      dialogScope2.conf={
                          pageNo:1,
                          pageSize:10,
                          totalRecord:0
                      }
                      dialogScope2.conditionForm={}
                      dialogScope2.submit_onClick = function(){
                          if($.doValidate("conditionForm")){
                              dialogScope2.queryTable();
                              dialogScope2.selected.select =[];
                              $scope.$apply();
                          }
                      }
                      dialogScope2.rebort_onClick = function(){
                          dialogScope2.conditionForm={};
                          dialogScope2.selected.select =[];
                          $scope.$apply();
                      }

                      dialogScope2.queryTable = function(){
                          var data={
                              pageNo:dialogScope2.conf.pageNo,
                              pageSize:dialogScope2.conf.pageSize,
                              commonQueryVO:dialogScope2.conditionForm
                          };

                          var url ="bPbcMtgMktPriceService/getTblMortMarPriPageForMoreCondition"
                          $common.get_asyncData(url,data).then(function(res){
                              if(res.errorCode=="SUC"){
                                  data= res.contextData;
                                  dialogScope2.datasource.ds = data.records;
                                  dialogScope2.conf.totalRecord = data.totalRecord;
                              }else{
                                  $common.get_tipDialog(res.errorMsg,"showError");
                              }
                          });
                      }
                      dialogScope2.lock_onClick = function(){
                          if(dialogScope2.selected.select.length==1){
                              //市场价格和盯市编号
                              dialogScope.mortgagePrice.marketPrice=dialogScope2.selected.select[0].price;
                              dialogScope.mortgagePrice.fixMortgageNo=dialogScope2.selected.select[0].productId;
                              dialogScope2.closeThisDialog();
                          }else{
                              $common.get_tipDialog("请选择一条记录",'showInform');
                          }
                      }
                      dialogScope2.cancel_onClick = function(){
                          dialogScope2.closeThisDialog();
                      }

                  }],'价格行情',{showClose:true});
              }
              dialogScope.unBindMarketPrice_onClick=function () {
                  dialogScope.mortgagePrice.marketPrice=0;
                  dialogScope.mortgagePrice.fixMortgageNo=null;
                  $scope.$apply();
              }
              dialogScope.save_onClick = function () {
                  if($.doValidate("mortgagePrice")) {
                      //赋值到上一个页面
                      var confirmPrice=parseFloat(dialogScope.mortgagePrice.confirmPrice);
                      var invQuantity=parseFloat(dialogScope.mortgagePrice.invQuantity);
                      dialogScope.mortgagePrice.originalTotPrice=confirmPrice*invQuantity;
                      //遍历已增加记录，修改相应的记录
                      var dsArray = $scope.datasource.ds;
                      var selected = $scope.selected.select[0];
                      for (var i = 0; i < dsArray.length; i++) {
                          if (dsArray[i].mortgageNo == selected.mortgageNo) {
                              $scope.datasource.ds[i] =$common.copy(dialogScope.mortgagePrice)
                          }
                      }
                      totalApplyAmount();
                      dialogScope.closeThisDialog();
                      $scope.selected.select=[]; //清空选中记录
                  }
              };
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };
            }],'入库押品详细信息',{showClose:true});
        }
    };

    //查看按钮
    $scope.view_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('qualityApplyXhdt/mortgagePrice.html',$scope,["$scope",function(dialogScope){
                dialogScope.mortgagePrice = {};
                dialogScope.disable = true;
                dialogScope.hide = true;
            /*    var mortgageNo = $scope.selected.select[0].mortgageNo;
                var fourDeliveryQryVO ={
                    mortgageNo:mortgageNo
                };
                var data = {fourDeliveryQryVO:fourDeliveryQryVO};*/
                var id  =  $scope.selected.select[0].id;
                var data ={key:id};

                var promise = $common.get_asyncData("bPbcAppliMtgInfoService/findBPbcAppliMtgInfoByKey",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgagePrice = res.contextData;
                        dialogScope.mortgagePrice.invQuantity =  dialogScope.mortgagePrice.quantity;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelOneSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品二级
                mortgageLevelTwoSource();
                function mortgageLevelTwoSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"2"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelTwoSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品三级
                mortgageLevelThreeSource();
                function mortgageLevelThreeSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"3"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelThreeSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };
            }],"入库押品详情",{showClose:true});
        }
    };
    //核价保存
    $scope.save_onClick = function () {
        //
        var flag = checkData();
        if(!flag){
            return false;
        }
        $scope.savedisable = true; //点击保存之后保存按钮不可用
       /* var data = {
            fourApplyVO: $scope.otherform,
            appliMtgInfoList: $scope.datasource.ds
        fourPledgeService/FHPledgeAppPricingUpdate 原来方法
        };*/
        var data = {
            SlaveProtoContInfo: $scope.otherform,
            mortgageInfoList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("qualityApplyService/saveQualityApply", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.submitdisable = false;
                $common.get_tipDialog('保存成功!', 'showInform');
                //var data1 = {appno:appno}
                //$state.go("qualityApply");//跳转
                //dataDeliver.setter(data1)//传值[可选]
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
            $scope.savedisable = false; //返回后按钮可用
        });
    };
    //提交
    $scope.submit_onClick = function(){
        var flag = checkData();
        if(!flag){
            return false;
        }
        $scope.submitdisable = true; //点击之后按钮不可用
        /*var data = {
            fourApplyVO: $scope.otherform,
            appliMtgInfoList: $scope.datasource.ds
         fourPledgeService/FHPledgeAppPricingSubmitUpdate 原来方法
        };*/
        var data = {
            SlaveProtoContInfo: $scope.otherform,
            mortgageInfoList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("qualityApplyService/QualityAppWriteSubmitUpdater", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {

                $common.get_tipDialog('提交成功!', 'showInform');
                //从待办任务进来提交之后的处理
                if(window.appNo){
                    //隐藏按钮
                    $scope.hideapprove =true;
                } else {
                    $scope.back_onClick();
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
            $scope.submitdisable = false; //返回后按钮可用
        });
    };

    //统计本次入库货物总价值和本次入库押品总价值
    function totalApplyAmount() {
        var amount=0;
        for(var x in $scope.datasource.ds){
            amount=amount+parseFloat($scope.datasource.ds[x].originalTotPrice);
        }
        $scope.otherform.amount=amount;
    }

    function checkData(){
        var flag = true;
        var msg = "";
        var records = $scope.datasource.ds;
        for (i = 0; i < records.length; i++) {
            var record = records[i];
            var confirmAccording = record.confirmAccording;
            var mortgageNo = record.mortgageNo;
            var marketPrice = record.marketPrice;
            var confirmPrice = 0;
            confirmPrice = record.confirmPrice;

            if(confirmAccording==null||""==confirmAccording||confirmAccording==undefined){
                msg="押品编号为【"+mortgageNo+"】的核价依据不能为空！";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false;
            }
            if(isNaN(confirmPrice) || confirmPrice==0){
                msg="押品编号为【"+mortgageNo+"】的核价单价必须大于0!";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false;
            }
            if(isNaN(marketPrice) || marketPrice<=0){
                msg="押品编号为【"+mortgageNo+"】的当前市场价必须大于0!";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false
             }
        }
        return flag;
    }
};
