/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      mengjiajia
 * @version     1.0
 * Create at:   2016/11/01
 */
var debtInPoolListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.conditionForm={
        factType:"2",//应收账款池融资
        financingType:"2",//融资模式是发票融资
        conStatus:"01",//查有效合同
        flag:"01"//客户类型为法人才可以
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
   $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                factType:"2",//应收账款池融资
                financingType:"2",//融资模式是发票融资
                conStatus:"01",//查有效合同
                flag:"01"//客户类型为法人才可以
            };//初始化查询条件对象
            $scope.selected.select=[];//清空选项
            $scope.queryTable();
        })
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };
   $scope.queryTable = function(){
       var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mastContQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCntDebtInfoService/queryBCntDebtInfoListByPage",data);
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
        $scope.selected.select=[];
    };

    //入池申请,因为用的是别人的代码，这里的字段不对应并且还少一些，还的到数据库里查询下。
    $scope.source = {};
    $scope.apply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var debtInfo=$scope.selected.select[0];
            //这里的后台代码，抛异常的常量没有配置好。todo!!!
            var data1= {
                cnameSeller:debtInfo.cname,//卖方名称
                custcdSaller:debtInfo.custcd,//卖方客户号
                //cnameBuyer:debtInfo.buyerName,//买方客户名称
                //custcdBuyer:debtInfo.buyerCustcd,//买方客户号
                contAmount:debtInfo.contAmount,//应收账款合同额度
                contStatus:debtInfo.contStatus,//合同状态
                curcd:debtInfo.curcd,//币种
                mastContno:debtInfo.debtContno,//业务合同号
                bussTypeName:debtInfo.productName,//业务品种名称
                startDate:debtInfo.startDate,//合同生效日
                endDate:debtInfo.endDate,//合同到期日
                factType:debtInfo.factType,//保理种类（有些地方写的是融资xx）,这里是国内保理
                financingType:debtInfo.financingType,//融资模式
                mgrno:debtInfo.mgrno,//管户员，这里应该是要判断现在的操作员有没有权限 todo!!!!
                bussType:debtInfo.supplyChainPdId//业务品种对应的产品ID
            }
            $common.get_asyncData("rBcpDebtInPoolAccountService/getDebtInPoolBussInfo", {debtBussInfoVO:data1}).then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.otherform2 = data.records[0];
                    var appno;
                    $common.get_asyncData("rBcpDebtInPoolAccountService/findBPbcAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
                        var data;
                        if (res.errorCode == "SUC") {
                            data = res.contextData;
                            $scope.source.applitask = data;
                            $scope.otherform2.insertDate = data.startTaskDate;
                            $scope.source.otherform = $scope.otherform2;
                            if(!data.piid)
                            {
                                $scope.source.taskform = {};
                                $state.go("debtinpooledit");
                                window.source = $scope.source;
                            }
                            else
                            {
                                $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                                    var taskform;
                                    if (res.errorCode == "SUC") {
                                        taskform = res.contextData;
                                        $scope.source.taskform = taskform;
                                        $state.go("debtinpooledit");
                                        window.source = $scope.source;
                                    } else {
                                        $common.get_tipDialog(res.errorMsg, 'showInform');
                                    }
                                })
                            }
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    })
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
        }
    };
};
