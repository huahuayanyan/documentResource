/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpLanListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
        contStatus:"1"
    };//初始化查询条件对象
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
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                contStatus:"1"
            };
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });

    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            rBcpDuebillAppVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("rbcpDuebillAppService/queryRBcpDuebillAppByPage",data);
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

    $scope.productselect = {//业务品种下拉框
        ds:[]
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
    });
    //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var bPrdInfo = {parentId:"3000",status:"1"};
        var data = {bPrdInfo:bPrdInfo};
        var promise = $common.get_asyncData("bcntBcpAppliBaseInfoService/getProductId",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productselect.ds = res.contextData||[];
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
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
        extentColumn:"businessName",
        column:["custcd","cname"]//展示内容
    };
    $scope.busiExtent = function(ds)
    {
        $scope.conditionForm.businessName=ds.cname;
        $scope.conditionForm.businessCustcd=ds.custcd;
    };
    $scope.$watch("conditionForm.businessName",function(){
        $scope.busiContent.param ={
            flag2:"cont",
            cname:$scope.conditionForm.businessName,
            custcd:$scope.conditionForm.businessName
        }
    });
    /**
     *  贸易对手查询加载结束
     */

    $scope.add_onClick = function()
    {
        $common.get_ngDialog('lanlnci/bcp_lan_add.html', $scope,["$scope",function(dialogScope){
            dialogScope.otherform = {};
            dialogScope.conditionForm={
                contStatus:"1"
            };//初始化查询条件对象
            dialogScope.datasource={//初始化表格对象
                ds: []
            };
            dialogScope.selected={//初始化对象
                select: []
            };
            dialogScope.conf= {//初始化分页对象
                pageNo: 1,
                pageSize: 10,
                totalRecord: 0};
            //监听分页
            dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                dialogScope.queryTable();
            });
            //重置
            dialogScope.rebort_onClick =function(){
                dialogScope.$apply(function(){
                    dialogScope.conditionForm = {
                        contStatus:"1"
                    };
                    dialogScope.selected.select=[];//清空选项s
                })
            };
            //搜索查询
            dialogScope.submit_onClick =function(){
                dialogScope.queryTable();
                dialogScope.selected.select=[];
            };

            dialogScope.queryTable = function(paramData){
                var data= {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    bCntBcpInfoVO:dialogScope.conditionForm
                };
                $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByPage",data).then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            };

            /**
             *  融资企业查询加载开始
             */
            dialogScope.custcontent = {
                type:"table",//展示类型table  tree
                url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
                param:{flag:"cont"},
                split:",",//分隔符
                extentColumn:"cname",
                column:["cname","custcd"]//展示内容
            };
            dialogScope.dooextend = function(ds){
                dialogScope.conditionForm.cname = ds.cname;
                dialogScope.conditionForm.custcd = ds.custcd;
            };
            dialogScope.$watch("conditionForm.cname",function(){
                dialogScope.custcontent.param ={flag:"cont",custcd:dialogScope.conditionForm.cname,cname:dialogScope.conditionForm.cname};
            });
            /**
             *  融资企业查询加载结束
             */
            /**
             *  贸易对手查询加载结束
             */
            dialogScope.busiContent = {
                type:"table",//展示类型table  tree
                url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
                param:{flag2:"cont"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
                split:"-",//分隔符*/
                extentColumn:"businessName",
                column:["custcd","cname"]//展示内容
            };
            dialogScope.busiExtent = function(ds)
            {
                dialogScope.conditionForm.businessName=ds.cname;
                dialogScope.conditionForm.businessCustcd=ds.custcd;
            };
            dialogScope.$watch("conditionForm.businessName",function(){
                dialogScope.busiContent.param ={
                    flag2:"cont",
                    cname:dialogScope.conditionForm.businessName,
                    custcd:dialogScope.conditionForm.businessName
                }
            });
            /**
             *  贸易对手查询加载结束
             */

            dialogScope.confirm_onClick = function()
            {
                if(dialogScope.selected.select.length != 1){
                    $common.get_tipDialog('请至少选择一条记录！','showInform');
                    return;
                }
                dialogScope.otherform = dialogScope.selected.select[0];
                dialogScope.otherform.custcdBuyer = dialogScope.otherform.businessCustcd;
                dialogScope.otherform.cnameSeller = dialogScope.otherform.cname;//卖方名称
                dialogScope.otherform.custcdSaller = dialogScope.otherform.custcd;//卖方客户号
                dialogScope.otherform.cnameBuyer = dialogScope.otherform.businessName;
                dialogScope.otherform.bussType = dialogScope.otherform.supplyChainPdId;
                dialogScope.otherform.appno = null;
                dialogScope.closeThisDialog();
                dialogScope.flowsubmitdisable = true;
                dialogScope.otherform.flag = "add";
                var url = "";
                if(dialogScope.otherform.financingType=="1")
                {
                    //发票融资-单笔
                    url = "lnciedit";
                }
                if(dialogScope.otherform.financingType=="2")
                {
                    url = "poollnciedit"
                }
                $state.go(url);
                dataDeliver.setter(dialogScope.otherform);
            };
            dialogScope.close_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"合同选择",{showClose:true})
    };

    //编辑
    $scope.edit_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appStat;
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
            var url = "";
            if(row.financingType=="1")
            {
                //发票融资-单笔
                url = "lnciedit";
            }
            if(row.financingType=="2")
            {
                url = "poollnciedit"
            }
            $state.go(url);
            dataDeliver.setter(row);
        }
    };

    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appStat;
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
                var primise = $common.get_asyncData('rbcpDuebillAppService/delete',{appno:row.appno})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        $scope.queryTable();
                        $scope.selected.select=[];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };

    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = "view";
            var url = "";
            if($scope.row.financingType=="1")
            {
                //发票融资-单笔
                url = "lnciedit";
            }
            if($scope.row.financingType=="2")
            {
                url = "poollnciedit"
            }
            $state.go(url);
            dataDeliver.setter($scope.row);
        }
    };

    $scope.column = function(row)
    {
        row.flag = "view";
        var url = "";
        if(row.financingType=="1")
        {
            //发票融资-单笔
            url = "lnciedit";
        }
        if(row.financingType=="2")
        {
            url = "poollnciedit"
        }
        $state.go(url);
        dataDeliver.setter(row);
    };

    $scope.submitApply_onClick = function(row){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var appliStatus = row.appStat;
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
                invokPhase:"03"
            };
            row.invokPhase = "03";
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
        $common.get_asyncData('rbcpDuebillAppService/submit',{rBcpDuebillAppVO:$scope.selected.select[0]}).then(function(res){
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

    //打印
    $scope.print_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{

        }
    };

    $scope.showProcess_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            var appliStatus = $scope.row.appStat;
            if(appliStatus=="00")
            {
                $common.get_tipDialog('该记录未提交，暂无流程轨迹信息！','showInform');
                $scope.selected.select=[];
                return;
            }
            $scope.row.moniCname = $scope.row.businessName;
            $scope.row.ext2 = $scope.row.modelName;
            $state.go("showProcess");
            dataDeliver.setter($scope.row);
        }
    };
    //表格--------结束-------------------------
};
