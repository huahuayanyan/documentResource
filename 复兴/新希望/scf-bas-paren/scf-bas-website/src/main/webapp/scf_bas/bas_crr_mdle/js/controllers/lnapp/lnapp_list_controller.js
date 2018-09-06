/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnapplistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    /*console.log("bFinCnfgSubj信息："+JSON.stringify(userInfo));//用户信息，全局变量*/
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrLnApp:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrLnAppService/findBCrrLnAppByPage",data);
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
    /**
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.custNm=ds.custNm;
    };
    $scope.$watch("conditionForm.custNm",function(){
        if($scope.conditionForm.custNm!=null) $scope.custcontent.param ={custId:$scope.conditionForm.custNm,custNm:$scope.conditionForm.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('lnapp/app_add.html', $scope
            ,["$scope",function(dialogScope){
                lnappaddController(dialogScope,$scope,dataDeliver,$state,$common,"add");
            }],"新增业务申请",{showClose:false},500);
    };
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].appStat!='00'){
                $common.get_tipDialog('已在审批,不允许修改','showInform');
                return;
            }
            var flag = "update";
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = flag;
            var prdId = $scope.row.prdId;
            $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.row.prdmd = res.contextData;
                    $state.go("lnapp");//跳转
                    dataDeliver.setter($scope.row);//传值[可选]
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var arrs = $common.copy($scope.selected.select);
            var cout = 0;
            for(var i=0 ; i<arrs.length ; i++)
            {
                var appStat = arrs[i].appStat;
                if(appStat != "00")
                {
                    cout ++;
                }
            }
            if(cout>0)
            {
                $common.get_tipDialog('已在审批,不允许删除','showInform');
                return;
            }
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bCrrLnAppService/batchDelete',{list:$scope.selected.select})
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
    //提交
    $scope.subapp_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
            $scope.selected.select=[];
        }else{
            if($scope.selected.select[0].appStat!='00'){
                $common.get_tipDialog('已在审批,不允许再次提交','showInform');
                return;
            }
            //调用业务拦截
            dataDeliver.setter({modelId:"LNAPPCHK",chkMap:$scope.selected.select[0]});//传值
            $common.get_ngDialog('../../bas_intcpdir_mdle/html/ft/intcpline.html',$scope,intcplineController,'业务拦截',{showClose:false},700);
        };
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
        var primise = $common.get_asyncData("bCrrLnAppService/submit",{bCrrLnApp:$scope.selected.select[0]})
        var rs = primise.then(function(res){
            if (res.errorCode =="SUC"){
                //发起工作流
                var data = {
                    modelId : 'BCrrLnApp',
                    ProcessName : '贷款业务',
                    NodeId : 'LnApp_approve',
                    startedUserId : userInfo.tlrNo,
                    bizId : $scope.selected.select[0].appId,
                    bizData : [
                        $scope.selected.select[0].appId,
                        $scope.selected.select[0].custId,
                        $scope.selected.select[0].custNm,
                        'BCrrLnApp'
                    ]
                };
                var primise = $common.get_asyncData("processService/startProcess",data);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.selected.select=[];
                        $common.get_tipDialog('发起成功！','showSuccess');
                        $scope.flowsubmitdisable=false;
                        $scope.queryTable();
                    }else{
                        $common.get_tipDialog('发起失败!'+res.errorMsg,'showError');
                        $scope.flowsubmitdisable=false;
                    }

                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.flowsubmitdisable=false;
            }
        });
    });
    $scope.column = function(row){
        var flag = "view";
        $scope.row = row;
        $scope.row.flag = flag;
        var prdId = $scope.row.prdId;
        $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.row.prdmd = res.contextData;
                $state.go("lnapp");//跳转
                dataDeliver.setter($scope.row);//传值[可选]
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    //表格--------结束-------------------------
};
