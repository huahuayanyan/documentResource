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
    var data = dataDeliver.getter();
    $scope.productSource = {
        ds:[]
    };
    var data = dataDeliver.getter();
    var appno = data.appno;
    var conId = data.conId;
    var gutId = data.gutId;
    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    if(window.appNo)
    {
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

    //出质人
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.otherform.custcd=ds.custcd;
        $scope.otherform.cname=ds.cname;
    };
    $scope.$watch("otherform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            creditFlag:"1", //授信客户
            cname:$scope.otherform.cname
        };
    });
    queryMortgageInfo();//申请基本信息查询

    function queryMortgageInfo(){
        var qualityApplyDO = {conId:conId,appno:appno};
        var data = {
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            qualityApplyDO: qualityApplyDO
        };
        var promise = $common.get_asyncData("fourPledgeService/queryFourPledgeBaseInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.otherform = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    $scope.queryTable = function(){
        var fourDeliveryQryVO ={
            appno:appno
        };
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            fourDeliveryQryVO:fourDeliveryQryVO
        };
        var promise = $common.get_asyncData("fourPledgeService/queryNotifyMortgageList",data);
        promise.then(function(res){
            var response;
            if (res.errorCode =="SUC"){
                response = res.contextData;
                if(response.records!="undefined"){
                    $scope.datasource.ds = response.records;
                }
                $scope.conf.totalRecord = response.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    productSource();
    //查询业务品种
    function productSource(){
        //业务品种下拉框
        var dataItemsDO = {};
        var data = {dataItemsDO:dataItemsDO};
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        $scope.productSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
                //$scope.protocol.productId="1220020";
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }

    //已入库押品详情查看按钮
    $scope.enterDetail_onClick = function(){
        $common.get_ngDialog('afcsfourPledge/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
            dialogScope.datasource = {ds:[]};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10,
                totalRecord:0
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

            var mortgageQryVO ={
                slaveContno:$scope.otherform.slaveContno
                ,custcd:gutId
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
                dialogScope.selected.select = [];
            }
        }
        ],"押品列表");
        /*$common.get_ngDialog('afcsfourPledge/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
         fourPledgeMortgageEditController(dialogScope,$scope,$common,"enterDetail");
         }],"押品列表",{showClose:true});*/
    };
    //核价按钮
    $scope.check_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
          $common.get_ngDialog('afcsfourPledge/mortgagePrice.html',$scope,["$scope",function(dialogScope){
                dialogScope.mortgagePrice = {};
                dialogScope.mortgageLevelThreeSource = {
                  ds:[]
                };
              dialogScope.dialogform = $common.copy($scope.selected.select[0]); //临时存储页面之前修改输入的字段
               var mortgageNo = $scope.selected.select[0].mortgageNo;
                var fourDeliveryQryVO ={
                  mortgageNo:mortgageNo
                };
                var data = {fourDeliveryQryVO:fourDeliveryQryVO};
                var promise = $common.get_asyncData("fourPledgeService/queryNotifyMortgageByMortgageNo",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgagePrice = res.contextData;
                        dialogScope.mortgagePrice =  $.extend(dialogScope.dialogform,dialogScope.mortgagePrice);
                        mortgageLevelThreeSource();
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
              dialogScope.save_onClick = function () {
                  if($.doValidate("dialogform")) {
                      //赋值到上一个页面
                      //遍历已增加记录，修改相应的记录
                      var dsArray = $scope.datasource.ds;
                      var selected = $scope.selected.select[0];
                      for (var i = 0; i < dsArray.length; i++) {
                          if (dsArray[i].mortgageNo == selected.mortgageNo) {
                              $scope.datasource.ds[i] =$common.copy(dialogScope.mortgagePrice)
                          }
                      }
                      dialogScope.closeThisDialog();
                      $scope.selected.select=[]; //清空选中记录
                  }
              };
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };

              dialogScope.bindMarketPrice_onClick = function(){
                  $common.get_ngDialog('afcsfourPledge/marPri_infoList.html',dialogScope,["$scope",function(sDialogScope){

                      sDialogScope.datasource={ds:[]};

                      sDialogScope.selected={select:[]};

                      sDialogScope.conf={
                          pageNo:1,
                          pageSize:10,
                          totalRecord:0
                      }

                      sDialogScope.conditionForm={
                      }

                      sDialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                          sDialogScope.queryTable();
                      });

                      sDialogScope.queryTable = function(){

                          var data={
                              pageNo:sDialogScope.conf.pageNo,
                              pageSize:sDialogScope.conf.pageSize,
                              commonQueryVO:sDialogScope.conditionForm
                          };

                          var url ="bPbcMtgMktPriceService/getTblMortMarPriPage"
                          $common.get_asyncData(url,data).then(function(res){
                              if(res.errorCode=="SUC"){
                                  data= res.contextData;
                                  sDialogScope.datasource.ds = data.records;
                                  sDialogScope.conf.totalRecord = data.totalRecord;
                              }else{
                                  $common.get_tipDialog(res.errorMsg,"showError");
                              }
                          });

                      }

                      sDialogScope.bound_onClick = function(){
                          if(sDialogScope.selected.select.length==1){
                              dialogScope.mortgagePrice.fixMortgageNo = sDialogScope.selected.select[0].productId;
                              dialogScope.mortgagePrice.marketPrice = sDialogScope.selected.select[0].price;
                              sDialogScope.closeThisDialog();
                          }else{
                              $common.get_tipDialog('请选择一条记录！','showInform');
                          }
                      }

                      sDialogScope.back_onClick = function(){
                          sDialogScope.closeThisDialog();
                      }

                      sDialogScope.submit_onClick = function(){
                          sDialogScope.queryTable();
                      }

                      sDialogScope.rebort_onClick = function(){
                          sDialogScope.conditionForm.productId_Q ='';
                          sDialogScope.conditionForm.productName_Q ='';
                          sDialogScope.conditionForm.mortgageLevelThreeName_Q ='';
                          sDialogScope.selected.select =[];
                          sDialogScope.queryTable();
                      }
                  }], "价格行情");
              };

              dialogScope.unBindMarketPrice_onClick = function(){
                  dialogScope.mortgagePrice.fixMortgageNo = null;
                  dialogScope.mortgagePrice.marketPrice = null;
                  dialogScope.$apply();
              };
            }]);
            /*  $common.get_ngDialog('afcsfourPledge/mortgageDetail.html',$scope,["$scope",function(dialogScope){
             fourPledgeMortgageEditController(dialogScope,$scope,$common,"update");
             }],"",{showClose:true});*/
        }
    };

    //查看按钮
    $scope.view_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('afcsfourPledge/mortgagePrice.html',$scope,["$scope",function(dialogScope){
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
            }],"入库押品详情");
            /*  $common.get_ngDialog('afcsfourPledge/mortgageDetail.html',$scope,["$scope",function(dialogScope){
             fourPledgeMortgageEditController(dialogScope,$scope,$common,"detail");
             }],"",{showClose:true});*/
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
        var data = {
            fourApplyVO: $scope.otherform,
            appliMtgInfoList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("fourPledgeService/FHPledgeAppPricingUpdate", data);
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
        var data = {
            fourApplyVO: $scope.otherform,
            appliMtgInfoList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("fourPledgeService/FHPledgeAppPricingSubmitUpdate", data);
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
    //返回
    $scope.back_onClick = function(){
        $state.go("fourPledgeList");
    };

    //统计本次入库货物总价值和本次入库押品总价值
    function totalApplyAmount() {
        var records = $scope.datasource.ds;
        var mottgageTotAmount = 0;//本次入库押品总价值
        var mottgageTotPrice = 0;//本次入库货物总价值
        var totPrice = 0;
        var totConfirmPrice = 0;
        for (i = 0; i < records.length; i++) {
            var record = records[i];
            var price = 0;
            var quantity = 0;
            var confirmPrice = 0;
            price = record.price;
            quantity = record.quantity;
            confirmPrice = record.confirmPrice;
            if (quantity != "" && price != "") {
                totPrice = parseFloat(quantity) * parseFloat(price);
            }
            totConfirmPrice = parseFloat(quantity) * parseFloat(price);
            mottgageTotAmount += parseFloat(totConfirmPrice);
            mottgageTotPrice += parseFloat(totPrice);
        }
        $scope.otherform.mottgageTotAmount = mottgageTotAmount;
        $scope.otherform.mottgageTotPrice = mottgageTotAmount;
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
           /* if(isNaN(marketPrice) || marketPrice<=0){
                msg="押品编号为【"+mortgageNo+"】的当前市场价必须大于0!";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false
             }*/

        }
        return flag;
    }
};
