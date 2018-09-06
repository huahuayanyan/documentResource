/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillapplistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
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
        //$scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrDuebillApp:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrDuebillAppService/findBCrrDuebillAppByPage",data);
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
        $common.get_ngDialog('duebill/app_add.html', $scope
            ,["$scope",function(dialogScope){
                duebillappaddController(dialogScope,$scope,dataDeliver,$state,$common,"add");
            }],"新增出账信息",{showClose:false},500);
    };
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].appStat!='00'){
                $common.get_tipDialog('已在审批,不允许再次修改','showInform');
                $scope.selected.select=[];
                return;
            }
            var flg = "update";
            $scope.row = $scope.selected.select[0];
            $scope.row.flg = flg;
            var appId = $scope.row.appId;
            $common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){
                if (res.errorCode =="SUC"){
                    var lncon = res.contextData;
                    var prdId = lncon.prdId;
                    var extId = lncon.extId;
                    $scope.row.extId = extId;
                    $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                        if (res.errorCode =="SUC"){
                            $scope.row.prdmd = res.contextData;
                            $state.go("duebillapp");
                            dataDeliver.setter($scope.row);
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
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
                if(appStat != "00"&&appStat != "04")
                {
                    cout ++;
                }
            }
            if(cout>0)
            {
                $common.get_tipDialog('已在审批,不允许删除，请重新选择！','showError');
                $scope.selected.select=[];
            }
            else
            {
                $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                    var primise = $common.get_asyncData('bCrrDuebillAppService/batchDelete',{list:$scope.selected.select})
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
    }
    //提交
    $scope.subapp_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.data = $scope.selected.select[0];
            if($scope.selected.select[0].appStat!='00'){
                $common.get_tipDialog('已在审批,不允许再次提交','showInform');
                $scope.selected.select=[];
                return;
            }
            //调用业务拦截
            dataDeliver.setter({modelId:"DUEBILLCHK",chkMap:$scope.selected.select[0]});//传值
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
        var lanflag = $scope.data.flag;
        if(lanflag=="1")
        {
            var vdata = {
                modelId : 'BCrrDuebillApp',
                ProcessName : '出账业务',
                NodeId : 'Approve_DuebillApp',
                startedUserId : userInfo.tlrNo,
                bizId : $scope.selected.select[0].id,
                bizData : [
                    $scope.selected.select[0].id,
                    $scope.selected.select[0].custCd,
                    $scope.selected.select[0].custNm,
                    'BCrrDuebillApp'
                ]
            };
            $common.get_asyncData("bCrrDuebillAppService/connectVid",{bCrrDuebillApp:$scope.data,processModel:vdata}).then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.queryTable();
                    $scope.selected.select=[];
                    $common.get_tipDialog('发起成功！','showSuccess');
                    submit($scope.data);
                    $scope.flowsubmitdisable=false;
                }else{
                    $common.get_tipDialog('发起失败！'+res.errorMsg,'showError');
                    $scope.flowsubmitdisable=false;
                }
            });
        }
        else
        {
            //发起工作流
            var data = {
                modelId : 'BCrrDuebillApp(XD)',
                ProcessName : '出账申请（信贷）',
                NodeId : 'BCrrDuebillApp_approve',
                startedUserId : userInfo.tlrNo,
                bizId : $scope.selected.select[0].id,
                bizData : [
                    $scope.selected.select[0].id,
                    $scope.selected.select[0].custCd,
                    $scope.selected.select[0].custNm,
                    'BCrrDuebillApp(XD)'
                ]
            };
            var primise = $common.get_asyncData("processService/startProcess",data);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.queryTable();
                    $scope.selected.select=[];
                    $common.get_tipDialog('发起成功！','showSuccess');
                    submit($scope.data);
                    $scope.flowsubmitdisable=false;
                }else{
                    $common.get_tipDialog('发起失败!'+res.errorMsg,'showError');
                    $scope.flowsubmitdisable=false;
                }
            });
        }
    });
    //提交
    function submit(data)
    {
        var primise = $common.get_asyncData("bCrrDuebillAppService/submit",{bCrrDuebillApp:data});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.flowsubmitdisable=false;
            };
            $scope.queryTable();
        });
    }

    $scope.column = function(row){
        var flg = "view";
        $scope.row = row;
        $scope.row.flg = flg;
        var appId = $scope.row.appId;
        $common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){
            if (res.errorCode =="SUC"){
                var lncon = res.contextData;
                var prdId = lncon.prdId;
                var extId = lncon.extId;
                $scope.row.extId = extId;
                $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.row.prdmd = res.contextData;
                        $state.go("duebillapp");
                        dataDeliver.setter($scope.row);
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    //表格--------结束-------------------------
};
