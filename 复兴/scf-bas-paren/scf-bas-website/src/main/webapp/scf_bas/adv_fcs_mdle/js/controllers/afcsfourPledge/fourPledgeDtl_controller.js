/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var fourPledgeDtlController = function($scope,$common,$state,dataDeliver) {
    $scope.datasource = {ds:[]};
    $scope.selected={//初始化对象
        select: []
    };
    $scope.otherform = {};
    var data = dataDeliver.getter();
    $scope.productSource = {
        ds:[]
    };
    var appno = data.appno;
    var conId = data.conId;
    var gutId = data.gutId;
    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    if(window.appNo)
    {
        $scope.hideback =true;
        getCurrentNodeEntity();
    }

    $scope.conf = {
        pageNo:1,
        pageSize:10,
        totalRecord: 0
    };
    if(appno){
        //监听分页
        $scope.$watch("conf.pageNo+conf.pageSize",function(newVal,oldVal) {
            //if(newVal !=oldVal){
            $scope.queryTable();
            // }
        });
    }else{
        $scope.submitdisable = true;
    }
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
                if (seq > 1) { //提交后的流程
                    //设置只读熟悉
                    $scope.taskdisable =true;
                    //按钮隐藏
                    $scope.hidetask = true;
                    $scope.hidesumbit = true;
                    $scope.hidesave = true;
                }else if(seq>2){   // check 核价之后
                    $scope.hidecheck = true;
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

/*   if(appno){
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                conId = data.slaveContno;
                gutId = data.custcd;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }*/
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
                $scope.datasource.ds = response.records;
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

    //新增
    $scope.add_onClick = function(){
       $common.get_ngDialog('afcsfourPledge/fourPledgeMortgageAdd.html',$scope,["$scope",function(dialogScope){
            mortgageLevelOneSource();
           dialogScope.conditionForm ={
               custcd: $scope.otherform.coreCustcd,
               slaveContno: $scope.otherform.slaveContno
           };
            dialogScope.datasource = {ds:[]};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                querydeliveryMortInfoList();
            });
            // 押品列表获取查询
            function querydeliveryMortInfoList(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    fourDeliveryQryVO:  dialogScope.conditionForm,
                    list:  $scope.datasource.ds
                };
                var promise = $common.get_asyncData("fourPledgeService/getFHPledgeDeliveryMortInfoList", data);
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
            //查询押品一级
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
            //联动下拉
            dialogScope.mortgageLevelTwoSource = {};
            dialogScope.mortgageLevelOneName = function (val){
                dialogScope.mortgageList.mortgageLevelTwoName = "";
                if(null != val){
                    var dataItemsDO = {mortgageCode:val};
                    var data = {dataItemsDO:dataItemsDO};
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
            //查询按钮
            dialogScope.submit_onClick = function(){
                dialogScope.conf.pageNo=1;
                querydeliveryMortInfoList();
                dialogScope.selected.select = [];
            };
            //重置按钮
            dialogScope.reset_onClick = function(){
                $scope.$apply(function () {
                    dialogScope.conditionForm ={
                        custcd: $scope.otherform.coreCustcd,
                        slaveContno: $scope.otherform.slaveContno
                    };
                })
            };
            //确认按钮
            dialogScope.confirm_onClick = function(){
                if(dialogScope.selected.select.length<1){
                    $common.get_tipDialog('请至少选择一条记录!','showInform');
                }else{
                   // $scope.datasource.ds.splice(0);
                    for(var i=0;i<dialogScope.selected.select.length;i++){
                        $scope.datasource.ds.push(dialogScope.selected.select[i]);
                    }
                    $scope.conf.totalRecord = dialogScope.selected.select.length;
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                    totalApplyAmount();
                }
            };
            //关闭按钮
            dialogScope.closeThisDialog_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
        }]);
     /*  $common.get_ngDialog('afcsfourPledge/fourPledgeMortgageAdd.html',$scope,["$scope",function(dialogScope){
            fourPledgeMortgageEditController(dialogScope,$scope,$common,"add");
        }],"",{showClose:true});*/
    };

    //修改按钮
    $scope.update_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
          $common.get_ngDialog('afcsfourPledge/mortgageDetail.html',$scope,["$scope",function(dialogScope){
                dialogScope.mortgageDetail = {};
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
                        dialogScope.mortgageDetail = res.contextData;
                        dialogScope.mortgageDetail =  $.extend(dialogScope.dialogform,dialogScope.mortgageDetail);
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
                  var levelTwo = dialogScope.mortgageDetail.mortgageLevelTwo;
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
                  dialogScope.mortgageDetail.mortgageLevelTwo = "";
                  if(null != val){
                      var dataItemsDO = {mortgageCode:val};
                      var data = {dataItemsDO:dataItemsDO};
                      var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                      mortgageName.then(function(res){
                          if(res.errorCode =="SUC"){
                              dialogScope.mortgageDetail.mortgageLevelOneName = res.contextData.mortgageName;
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
                  dialogScope.mortgageDetail.mortgageLevelThreeSource = "";
                  if(null != val){
                      var dataItemsDO = {mortgageCode:val};
                      //var data = {dataItemsDO:dataItemsDO};
                      var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                      mortgageName.then(function(res){
                          if(res.errorCode =="SUC"){
                              dialogScope.mortgageDetail.mortgageLevelTwoName = res.contextData.mortgageName;
                          }else{
                              $common.get_tipDialog(res.errorMsg,'showInform');
                          }
                      });
                  }else{
                      dialogScope.mortgageLevelThreeSource.ds = [];
                  }
              };
              //提货数量 失去焦点
              dialogScope.quantity_onBlur = function(){
                  var totPrice = 0;
                  var totConfirmPrice = 0;
                  var quantity =parseFloat(dialogScope.mortgageDetail.quantity);
                  var price =parseFloat(dialogScope.mortgageDetail.price);
                  dialogScope.mortgageDetail.totPrice=quantity*price;
                  totPrice = parseFloat(quantity) * parseFloat(price);
                  totConfirmPrice = parseFloat(quantity) * parseFloat(price);
                  dialogScope.mortgageDetail.confirmPrice =price;
                  dialogScope.mortgageDetail.totPrice =totPrice;
                  dialogScope.mortgageDetail.totConfirmPrice =totConfirmPrice;
                  dialogScope.$apply();
              };
              dialogScope.save_onClick = function () {
                  if($.doValidate("dialogform")) {
                      //出质入库数量不能大于剩余出质数量
                      var balQuantity =dialogScope.mortgageDetail.balQuantity;
                      var quantity =dialogScope.mortgageDetail.quantity;
                      var mortgageName =dialogScope.mortgageDetail.mortgageName;
                      if(parseFloat(quantity) > parseFloat(balQuantity) ){
                          $common.get_tipDialog("押品【"+mortgageName+"】超过发货通知中剩余未到货的数量"+balQuantity, 'showInform');
                        return false;
                      }
                      //赋值到上一个页面
                      //遍历已增加记录，修改相应的记录
                      var dsArray = $scope.datasource.ds;
                      var selected = $scope.selected.select[0];
                      for (var i = 0; i < dsArray.length; i++) {
                          if (dsArray[i].mortgageNo == selected.mortgageNo) {
                              $scope.datasource.ds[i] =$common.copy(dialogScope.mortgageDetail)
                          }
                      }
                      //统计本次入库货物总价值和本次入库押品总价值
                      totalApplyAmount();
                      dialogScope.closeThisDialog();
                      $scope.selected.select=[]; //清空选中记录
                  }
              };
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };
            }]);
            /*  $common.get_ngDialog('afcsfourPledge/mortgageDetail.html',$scope,["$scope",function(dialogScope){
             fourPledgeMortgageEditController(dialogScope,$scope,$common,"update");
             }],"",{showClose:true});*/
        }
    };

    //查看按钮
    $scope.detail_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('afcsfourPledge/mortgageDetail.html',$scope,["$scope",function(dialogScope){
                dialogScope.mortgageDetail = {};
                dialogScope.disable = true;
                dialogScope.hide = true;
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var fourDeliveryQryVO ={
                    mortgageNo:mortgageNo
                };
                var data = {fourDeliveryQryVO:fourDeliveryQryVO};
                var promise = $common.get_asyncData("fourPledgeService/queryNotifyMortgageByMortgageNo",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageDetail = res.contextData;
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
            }]);
            /*  $common.get_ngDialog('afcsfourPledge/mortgageDetail.html',$scope,["$scope",function(dialogScope){
             fourPledgeMortgageEditController(dialogScope,$scope,$common,"detail");
             }],"",{showClose:true});*/
        }
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length !=1){
            $common.get_tipDialog('请选择一条记录!','showInform')
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                for(i = 0;i<$scope.selected.select.length;i++){
                    $scope.datasource.ds.splice($scope.selected.select[i], 1);
                }
                $scope.conf.totalRecord = $scope.conf.totalRecord - $scope.selected.select.length;
                totalApplyAmount();
            })
        }
    };
    //保存
    $scope.save_onClick = function () {
        //新增申请信息
        if ($scope.datasource.ds.length < 1) {
            $common.get_tipDialog('请添加押品信息!', 'showInform');
            return false;
        }
        var quantity = $scope.otherform.quantity;
        var balQuantity = $scope.otherform.balQuantity;
        var mortgageName = $scope.otherform.mortgageName;
        if (parseFloat(quantity) > parseFloat(balQuantity)) {
            $common.get_tipDialog("押品【" + mortgageName + "】超过发货通知中剩余未到货的数量", 'showInform');
            return false;
        }
        var flag = checkData();
        if(!flag){
            return false;
        }
        $scope.savedisable = true; //点击保存之后保存按钮不可用
        var data = {
            fourApplyVO: $scope.otherform,
            fourMortgageVOList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("fourPledgeService/FHPledgeAppWriteSaveUpdate", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                appno = res.contextData.value;
                $scope.otherform.appno= appno;
                $scope.submitdisable = false;
                $common.get_tipDialog('保存成功!', 'showInform');
                var rappno ={appno:appno};
                var rdata = $.extend(dataDeliver.getter(),rappno);
                dataDeliver.setter( rdata);
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
        if ($scope.datasource.ds.length < 1) {
            $common.get_tipDialog('请添加押品信息!', 'showInform');
            return false;
        }
        var quantity = $scope.otherform.quantity;
        var balQuantity = $scope.otherform.balQuantity;
        var mortgageName = $scope.otherform.mortgageName;
        if (parseFloat(quantity) > parseFloat(balQuantity)) {
            $common.get_tipDialog("押品【" + mortgageName + "】超过发货通知中剩余未到货的数量", 'showInform');
            return false;
        }
        var flag = checkData();
        if(!flag){
            return false;
        }
        $scope.submitdisable = true; //点击之后按钮不可用
        var data = {
            fourApplyVO: $scope.otherform,
            fourMortgageVOList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData("fourPledgeService/FHPledgeAppWriteSubmitUpdate", data);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {

                $common.get_tipDialog('提交成功!', 'showInform');
                //从待办任务进来提交之后的处理
                if(window.appNo){
                    //隐藏按钮
                    $scope.hidetask = true;
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
            var quantity = record.quantity;
            var mortgageName = record.mortgageName;
            var warehouse = record.warehouse;
            var warehouseAddress = record.warehouseAddress;
            if(isNaN(quantity) || quantity==0){
                msg="押品名称【"+mortgageName+"】的本次入库的数量不能空！\n";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false;
            }
            if(warehouse==null||""==warehouse||warehouse==undefined){
                msg="押品名称【"+mortgageName+"】的仓库名称不能空！\n";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false;
            }
            if(warehouseAddress==null||""==warehouseAddress||warehouseAddress==undefined){
                msg="押品名称【"+mortgageName+"】的仓库地址不能空！\n";
                $common.get_tipDialog(msg, 'showInform');
                flag= false;
                return false
            }
        }
        return flag;
    }
};
