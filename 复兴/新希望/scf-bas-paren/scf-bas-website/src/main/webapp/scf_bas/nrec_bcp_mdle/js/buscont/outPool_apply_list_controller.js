/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var OutPoolAppplyListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    var dataX=dataDeliver.getter();
    var appno;
    if(dataX.appno){
        appno=dataX.appno
    }
    $scope.conditionForm={
        mastContno:dataX.mastContno,
        appliType:'3267',
        appno:appno
    };
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    $scope.rebort_onClick =function(){
        $scope.conditionForm={
            mastContno:dataX.mastContno,
            appliType:'3267',
            appno:appno
        };
        $scope.selected.select=[];
        $scope.$apply();
    };
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("debtInPoolService/queryPoolBPbcAppliBaseInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //新增申请
    $scope.addApply_onClick = function(){
        var data={
            mastContno:dataX.mastContno
        };
        dataDeliver.setter(data);
        $state.go("outPool");//跳转到入池申请页面
    };
    //修改应收账款申请信息
    $scope.updateApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appliStatus;
            if(appliStatus=="01"||appliStatus=="05")
            {
                $common.get_tipDialog('该记录已提交，不可修改！','showInform');
                return;
            }
            else if(appliStatus=="02")
            {
                $common.get_tipDialog('该记录已通过，不可修改！','showInform');
                return;
            }
            else if(appliStatus=="03")
            {
                $common.get_tipDialog('该记录已拒绝，不可修改！','showInform');
                return;
            }
            var data={
                appno:row.appno,
                mastContno:row.mastContno
            };
            dataDeliver.setter(data);
            $state.go("outPool");

        }
    };
    //删除 同时删除了申请业务信息表，明细表
    $scope.deleteApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appliStatus;
            if(appliStatus=="01"||appliStatus=="05")
            {
                $common.get_tipDialog('该记录已提交，不可删除！','showInform');
                return;
            }
            else if(appliStatus=="02")
            {
                $common.get_tipDialog('该记录已通过，不可删除！','showInform');
                return;
            }
            else if(appliStatus=="03")
            {
                $common.get_tipDialog('该记录已拒绝，不可删除！','showInform');
                return;
            }
            var data1= {
               list:$scope.selected.select
            };
            var promise = $common.get_asyncData("bPbcAppliBaseInfoService/batchDeleteBPbcAppliBaseInfoAndRelated",data1);
            promise.then(function(res){
                if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                    $common.get_tipDialog('删除成功！', 'showSuccess');
                    $scope.selected.select=[];
                    $scope.queryTable();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    //查看按钮
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条数据！','showError');
        }else{
            var data1= {
                flag:"view",
                appno:$scope.selected.select[0].appno,
                mastContno:$scope.selected.select[0].mastContno
            };
            dataDeliver.setter(data1);
            $state.go("outPool");
        }
    };
    //具体申请信息查看
    $scope.column = function(row){
        var data1= {
            flag:"view",
            appno:row.appno,
            mastContno:row.mastContno
        };
        dataDeliver.setter(data1);
        $state.go("outPool");
    };
    //提交
    $scope.submitApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appliStatus;
            if(appliStatus=="01"||appliStatus=="05")
            {
                $common.get_tipDialog('该记录已提交，不可重复提交！','showInform');
                return;
            }
            else if(appliStatus=="02")
            {
                $common.get_tipDialog('该记录已通过，不可提交！','showInform');
                return;
            }
            else if(appliStatus=="03")
            {
                $common.get_tipDialog('该记录已拒绝，不可提交！','showInform');
                return;
            }
            var param = {
                productId:row.supplyChainPdId,
                invokPhase:"14"
            };
            row.invokPhase = "14";
            //获取风险拦截模型ID
            $common.get_asyncData("bprdChkdirInfoService/findBPrdChkdirInfoByParam",{omap:param}).then(function(res){
                if (res.errorCode =="SUC"){
                    var data = res.contextData;
                    var mdlId = data.mdlId;
                    if(mdlId==undefined||mdlId==""||mdlId==null)
                    {
                        $common.get_tipDialog('该业务品种对应调用阶段的风险拦截模型未绑定,请在业务配置中绑定！','showInform');
                        return;
                    }
                    //调用业务拦截
                    dataDeliver.setter({modelId:mdlId,chkMap:row});//传值
                    $common.get_ngDialog('../../bas_intcpdir_mdle/html/ft/intcpline.html',$scope,intcplineController,'业务拦截',{showClose:false},700);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }
    };
    //监听业务拦截事件
    $scope.$on('interceptEvent',function(event,data) {
        console.log("data信息："+JSON.stringify(data));
        //根据业务拦截处理结果，执行成功继续提交，未执行成功返回
        if(data.checkResult!='SUC'){
            return;
        }
        //锁定当前申请状态,防重复提交
        $scope.flowsubmitdisable=true;
        var appno=$scope.selected.select[0].appno;
        $common.get_asyncData('debtOutPoolService/submitOutPoolInfoApply',{key:appno}).then(function(res){
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                $scope.selected.select=[];
                $scope.flowsubmitdisable = false;
                $scope.queryTable();
                $common.get_tipDialog('提交成功！', 'showSuccess');
            }else{
                $scope.flowsubmitdisable = false;
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    });

    $scope.showProcess_onClick = function() {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            var appliStatus = $scope.row.appliStatus;
            if(appliStatus=="00")
            {
                $common.get_tipDialog('该记录未提交，暂无流程轨迹信息！','showInform');
                $scope.selected.select=[];
                return;
            }
            $state.go("showProcess");
            dataDeliver.setter($scope.row);
        }
    };
    //back
    $scope.back_onClick=function(){
        $state.go("list");//返回上已页面
    }
};
