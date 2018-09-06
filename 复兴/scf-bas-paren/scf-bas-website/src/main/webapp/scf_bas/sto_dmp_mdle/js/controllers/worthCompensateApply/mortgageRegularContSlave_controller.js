/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var contSlaveController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
        paramId_Q:"01",//现货静态产品号+01
        bussType_Q:"1220020",//现货动态

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
        $scope.conditionForm={
            paramId_Q:"01",//现货静态产品号+01
            bussType_Q:"1220020",//现货静态
        };
        $scope.selected.select=[];//清空选项
        $scope.$apply();
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            WarnQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrGntyConService/getWarnDropCtlInfoByParamForCompensate",data);
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
    //确认按钮
    $scope.confirm_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('worthCompensateApply/worthCompensateApply_Detail.html', $scope,["$scope",function(dialogScope){
                dialogScope.otherform=$scope.selected.select[0];
                var mortBalance=parseFloat($scope.selected.select[0].mortBalance);
                if(mortBalance < 0){
                    dialogScope.otherform.mortBalance=0-mortBalance;
                }
                dialogScope.save_onClick=function(){
                    if((!dialogScope.otherform.bailAmount) || dialogScope.otherform.bailAmount == ""){
                        $common.get_tipDialog("请填写[应补保证金]!",'showError');
                        return ;
                    }else{
                        var bailAmount=parseFloat(dialogScope.otherform.bailAmount);
                        var mortBalance=parseFloat(dialogScope.otherform.mortBalance);
                        if(bailAmount < mortBalance){
                            $common.get_tipDialog("应补保证金金额不足以抵消价值差额！",'showError');
                            return;
                        }else{
                            // 抵/质押合同号 conId,slaveContno,slaveContcode,监管合同号 prtclNo,protocolNo
                            // 出质人 gutId ，custcd，监管公司 moniCustcd ，moniOfCustcd,监管公司名称 moniCname，moniOfName
                            // 质押模式 moniMd，pledgeMode，当前最低控货价值 leastMortAmt，ext2Amount
                            // 价值差额 mortBalance，ext1Amount 通知书类型 noticeType 23
                            // 业务品种 1210020

                            var BNteNoticeBase={
                                slaveContno:dialogScope.otherform.conId,
                                slaveContcode:dialogScope.otherform.conId,
                                protocolNo:dialogScope.otherform.prtclNo,
                                custcd:dialogScope.otherform.gutId,
                                moniOfCustcd:dialogScope.otherform.moniCustcd,
                                moniOfName:dialogScope.otherform.moniCname,
                                pledgeMode:dialogScope.otherform.moniMd,
                                ext2Amount:dialogScope.otherform.leastMortAmt,
                                ext1Amount:dialogScope.otherform.mortAmt,
                                noticeType:23,
                                bussType:1220020,
                                bailAmount:dialogScope.otherform.bailAmount,
                                balanceAmt:dialogScope.otherform.mortBalance,
                            }
                            var promise = $common.get_asyncData("bNteNoticeBaseService/addAdvWorthCompensateNoticeInfo",{BNteNoticeBase:BNteNoticeBase});
                            promise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    $state.go("worthCompensateApplyList");
                                    $common.get_tipDialog('保存成功！', 'showSuccess');
                                    dialogScope.closeThisDialog();
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        }
                    }
                };
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"跌价补偿",{showClose:true});
        }
    };
    //返回按钮
    $scope.back_onClick = function(){
        $state.go("worthCompensateApplyList");
    };

};
