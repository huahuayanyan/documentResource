/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var debtPoolConListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.conditionForm={
        factType:"2",//应收账款池融资
        financingType:"2",// 池融资
        conStatus:'01',//有效合同
        flag:"01" //用户角色
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
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

         // $scope.conditionForm={};
        $scope.conditionForm={
                factType:"2",//应收账款池融资
                financingType:"2",// 池融资
                 conStatus:'01',//有效合同
                flag:"01" //用户角色
            };//初始化查询条件对象
        $scope.selected.select=[];//清空选项
        $scope.queryTable();
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };
//todo
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

    //发起申请
    $scope.apply_onClick = function() {
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
            return false;
        }
        /*if ($scope.selected.select[0].confirmStatus != "0") {
            $common.get_tipDialog('只有未收款确认才可发起申请！', 'showInform');
        } else {*/
            $state.go("debtOutPoolDtl");
            var debtInfo = $scope.selected.select[0];
        //申请页面值的组装
            var data= {
                cnameSeller:debtInfo.cname,//卖方名称
                custcdSaller:debtInfo.custcd,//卖方客户号
                cnameBuyer:debtInfo.buyerName,//买方客户名称
                custcdBuyer:debtInfo.buyerCustcd,//买方客户号
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
            };
            dataDeliver.setter(data);
       // }
    };
        //表格--------结束-------------------------
};
