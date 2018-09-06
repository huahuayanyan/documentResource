/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpContUnListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    var url = "";
    $scope.conditionForm={
        contStatus:"0"
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                contStatus:"0"
            };
            $scope.selected.select=[];//清空选项s
        })
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
            bCntBcpInfoVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByPage",data);
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

    //编辑
    $scope.edit_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = "edit";
            $scope.queryState($scope.row);
        }
    };

    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $scope.row.flag = "view";
            $scope.queryState($scope.row);
        }
    };

    $scope.column = function(row){
        row.flag = "view";
        $scope.queryState(row);
    };

    //打印
    $scope.print_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var param = {
                id:"1BI3IUESP000A3C7FCAA0000A54078EF",
                noticeType:"135",
                mastContno:$scope.selected.select[0].mastContno
            };
            toFactoringPrint(param);
        }
    };
    //生效
    $scope.submitApply_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            if(row.contStatus=="1")
            {
                $common.get_tipDialog('该合同已生效！','showInform');
                return;
            }
            var param = {
                productId:row.supplyChainPdId,
                invokPhase:"02"
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
                    dataDeliver.setter({modelId:mdlId,chkMap:$scope.selected.select[0]});//传值
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
        $scope.selected.select[0].contStatus = "1";
        $common.get_asyncData("bcntBcpInfoService/setContStatus",{bcntBcpInfoVO:$scope.selected.select[0]}).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('合同已生效！','showSuccess');
                $scope.queryTable();
                $scope.selected.select = [];
                $scope.flowsubmitdisable = false;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    });

    //查询对应业务品种跳转state
    $scope.queryState = function(paramData)
    {
        var data = {
            productId:paramData.supplyChainPdId,
            invokPhase:"02"
        };
        $common.get_asyncData("bprdFlowService/findBPrdFlowVOByParam",data).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                url = data.url;
                if(url==undefined||url==""||url==null)
                {
                    $common.get_tipDialog('跳转路由路径为空，请维护数据！','showInform');
                }
                else
                {
                    $common.get_asyncData("bcntBcpInfoService/findBCntBcpInfoByMastContno",{bCntBcpInfoVO:paramData}).then(function(res){
                        var cntinfo;
                        if (res.errorCode =="SUC"){
                            cntinfo = res.contextData;
                            cntinfo.flag = paramData.flag;
                            cntinfo.tlrnm = paramData.tlrnm;
                            $state.go(url);
                            dataDeliver.setter(cntinfo);
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };
    //表格--------结束-------------------------
};
