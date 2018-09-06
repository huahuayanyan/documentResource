/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpApplyListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
        totalRecord: 0};
        
    //监听分页
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    
    //重置
    $scope.rebort_onClick =function(){
        $scope.conditionForm = {};
        $scope.selected.select=[];//清空选项s
        $scope.$apply();
    };
    
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bcntBcpAppliBaseInfoService/findBCntBcpAppliBaseInfoByPage",data);
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
     *  融资企业查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag:"cont"},
        split:",",//分隔符
        extentColumn:"cname",
        column:["cname","custcd"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.cname = ds.cname;
        $scope.conditionForm.custcd = ds.custcd;
    };
    $scope.$watch("conditionForm.cname",function(){
        $scope.custcontent.param ={flag:"cont",custcd:$scope.conditionForm.cname,cname:$scope.conditionForm.cname};
    });
    /**
     *  融资企业查询加载结束
     */
    /**
     *  贸易对手查询加载结束
     */
    $scope.busiContent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag2:"cont"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符*/
        extentColumn:"businessCname",
        column:["custcd","cname"]//展示内容
    };
    $scope.busiExtent = function(ds)
    {
        $scope.conditionForm.businessCname=ds.cname;
        $scope.conditionForm.businessCustcd=ds.custcd;
    };
    $scope.$watch("conditionForm.businessCname",function(){
        $scope.busiContent.param ={
            flag2:"cont",
            cname:$scope.conditionForm.businessCname,
            custcd:$scope.conditionForm.businessCname
        }
    });
    /**
     *  贸易对手查询加载结束
     */

    /**
     * 新增
     */
    $scope.add_onClick = function(){
        $common.get_ngDialog('busapply/bcp_apply_add.html', $scope,["$scope",function(dialogScope){
            dialogScope.baseinfo = {};
            dialogScope.productselect = {//业务品种下拉框
                ds:[]
            };
            //监听分页
            dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                dialogScope.productSourceList();
            });
            //查询业务品种
            dialogScope.productSourceList = function(){
                //业务品种下拉框
                var bPrdInfo = {parentId:"3000",status:"1"};
                var data = {bPrdInfo:bPrdInfo};
                var promise = $common.get_asyncData("bcntBcpAppliBaseInfoService/getProductId",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.productselect.ds = res.contextData||[];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            };
            /**
             *  融资企业查询加载开始
             */
            dialogScope.custcontent = {
                type:"table",//展示类型table  tree
                url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
                param:{},
                split:",",//分隔符
                extentColumn:"cname",
                column:["cname","custcd"]//展示内容
            };
            dialogScope.dooextend = function(ds){
                dialogScope.baseinfo.cname = ds.cname;
                dialogScope.baseinfo.custcd = ds.custcd;
                dialogScope.busicustcontent.param = {
                    custcd :dialogScope.baseinfo.custcd,
                    coreFlag:"1"
                };
            };
            dialogScope.$watch("baseinfo.cname",function(){
                if(dialogScope.baseinfo.cname!=null) dialogScope.custcontent.param ={custcd:dialogScope.baseinfo.cname,cname:dialogScope.baseinfo.cname};
            });
            /**
             *  融资企业查询加载结束
             */

            /**
             * 客户名称查询加载开始
             */
            dialogScope.busicustcontent = {
                type:"table",//展示类型table  tree
                url:"bcntBcpAppliBaseInfoService/queryBCrmBaseBusinessInfo",
                param:{},
                split:",",//分隔符
                extentColumn:"businessCname",
                column:["cname","custcd"]//展示内容
            };
            dialogScope.busidooextend = function(ds){
                dialogScope.baseinfo.businessCname = ds.cname;
                dialogScope.baseinfo.businessCustcd = ds.custcd;
            };
            dialogScope.$watch("baseinfo.businessCname",function(){
                if(dialogScope.baseinfo.businessCname!=null)
                {
                    dialogScope.busicustcontent.param ={
                        custcd :dialogScope.baseinfo.custcd,
                        coreFlag:"1",
                        businessCustcd:dialogScope.baseinfo.businessCname,
                        businessCname:dialogScope.baseinfo.businessCname
                    };
                }
            });
            /**
             * 客户名称查询加载结束
             */

            dialogScope.confirm_onClick = function()
            {
                var custNm = dialogScope.baseinfo.cname;
                var custId = dialogScope.baseinfo.custcd;
                var bCrmBaseInfo = {custCd:custId};
                //校验输入客户名称与获取客户名是否匹配
                var primise = $common.get_asyncData('bCrmBaseInfoService/findBCrmBaseInfoByKey',{bCrmBaseInfo:bCrmBaseInfo});
                primise.then(function(res){
                    var custinfo;
                    if (res.errorCode =="SUC"){
                        custinfo = res.contextData;
                        var cname = custinfo.cname;
                        if(custNm == cname)
                        {
                            //校验输入业务品种是否完全
                            //var prdId = dialogScope.baseinfo.supplyChainPdId;
                            //if(!prdId||prdId==null||prdId=="")
                            //{
                            //    document.getElementById("supplyChainPdId").focus();
                            //    $common.get_tipDialog("未对业务品种进行选择，请重新选择",'showError');
                            //    return;
                            //}
                            if($.doValidate("baseinfo")) {
                                dialogScope.flowsubmitdisable = true;
                                var primise = $common.get_asyncData('bcntBcpAppliBaseInfoService/cachadd',{bCntBcpAppliBaseInfoVO:dialogScope.baseinfo});
                                primise.then(function(res){
                                    if (res.errorCode =="SUC"){
                                        dialogScope.closeThisDialog();
                                        dialogScope.baseinfo = res.contextData;
                                        dialogScope.baseinfo.flag = "add";
                                        dialogScope.productselect.ds;
                                        $state.go("bcpApply");
                                        dataDeliver.setter(dialogScope.baseinfo);
                                    }else{
                                        $common.get_tipDialog(res.errorMsg,'showError');
                                    }
                                });
                            }
                        }
                        else
                        {
                            document.getElementById("cname").focus();
                            $common.get_tipDialog("输入融资企业名称与融资企业客户号不匹配，请重新选择",'showError');
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            };
            dialogScope.close_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"融资企业选择",{showClose:true})
    };

    $scope.edit_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
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
            row.flag = "update";
            $state.go("bcpApply");
            dataDeliver.setter(row);
        }
    };

    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = "view";
            $state.go("bcpApply");
            dataDeliver.setter($scope.row);
        }
    };
    //查看
    $scope.column = function(row){
        row.flag = "view";
        $state.go("bcpApply");
        dataDeliver.setter(row);
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
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
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData('bcntBcpAppliBaseInfoService/delete',{appno:row.appno}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        $scope.queryTable();
                        $scope.selected.select=[];
                        var list = res.contextData||[];
                        for(var x in list)
                        {
                            $.post(_FILE_SERVER_URL+"file/delete.htm",{picId:list[x]},function(res){
                                var res=JSON.parse(res);
                                if (res.scubeHeader.errorCode =="SUC") {
                                    //$scope.queryTable();
                                    //$scope.selected.select = [];
                                    //$common.get_tipDialog('附件删除成功', 'showSuccess');
                                }else{
                                    //$common.get_tipDialog('附件删除失败','showError');
                                }
                            });
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };
    //提交
    $scope.submitApply_onClick = function()
    {
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
                invokPhase:"01"
            };
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
        $common.get_asyncData('bcntBcpAppliBaseInfoService/submitAndUpdate',{bCntBcpAppliBaseInfoVO:$scope.selected.select[0]}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.queryTable();
                $scope.selected.select=[];
                $common.get_tipDialog('提交成功！','showSuccess');
                $scope.flowsubmitdisable=false;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.flowsubmitdisable=false;
            }
        })
    });

    $scope.showProcess_onClick = function()
    {
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
            $scope.row.moniCname = $scope.row.businessCname;
            $state.go("showProcess");
            dataDeliver.setter($scope.row);
        }
    };
    //表格--------结束-------------------------
};
