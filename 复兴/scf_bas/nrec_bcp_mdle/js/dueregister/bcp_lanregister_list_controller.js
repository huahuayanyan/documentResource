/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpLanRegisterListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
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
        totalRecord: 0}
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
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
            rBcpDuebillRegisterVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("rbcpDuebillRegisterService/queryRBcpDuebillRegisterByPage",data);
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
        $scope.row = {
            flag:"add"
        };
        $state.go("registeredit");
        dataDeliver.setter($scope.row);
    };

    //编辑
    $scope.edit_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var state = row.state;
            if(state=="1")
            {
                $common.get_tipDialog('出账未确认，不可修改！','showInform');
                return;
            }
            else if(state=="2")
            {
                $common.get_tipDialog('已出账，不可修改！','showInform');
                return;
            }
            row = $scope.selected.select[0];
            row.flag = "update";
            $state.go("registeredit");
            dataDeliver.setter(row);
        }
    };

    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var state = row.state;
            if(state=="1")
            {
                $common.get_tipDialog('出账未确认，不可撤销！','showInform');
                return;
            }
            else if(state=="2")
            {
                $common.get_tipDialog('已出账，不可撤销！','showInform');
                return;
            }
            $common.get_tipDialog('确定撤销此记录？','showTip').then(function(){
                 $common.get_asyncData('rbcpDuebillRegisterService/delete',{rBcpDuebillRegisterVO:row}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('撤销成功！','showSuccess');
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
            $state.go("registeredit");
            dataDeliver.setter($scope.row);
        }
    };

    $scope.column = function(row)
    {
        row.flag = "view";
        $state.go("registeredit");
        dataDeliver.setter(row);
    };

    $scope.submitApply_onClick = function(row){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var state = row.state;
            if(state=="1")
            {
                $common.get_tipDialog('出账未确认，不可重复出账确认！','showInform');
                return;
            }
            else if(state=="2")
            {
                $common.get_tipDialog('已出账，不可出账确认！','showInform');
                return;
            }
            $scope.flowsubmitdisable=true;
            $common.get_asyncData('rbcpDuebillRegisterService/submit',{rBcpDuebillRegisterVO:row}).then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.queryTable();
                    $scope.selected.select=[];
                    $common.get_tipDialog('操作成功！','showSuccess');
                    $scope.flowsubmitdisable=false;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                    $scope.flowsubmitdisable=false;
                }
            })
        }
    };

    //打印
    $scope.print_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var param = {
                id:"1BI56P5PE000A3C7FCAA0000FFAA8C46",
                noticeType:"136",
                receiveNo:$scope.selected.select[0].receiveNo
            };
            toFactoringPrint(param);
        }
    };

    //银行出账
    $scope.bank_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var state = row.state;
            if(state=="0")
            {
                $common.get_tipDialog('未出账确认，不可出账！','showInform');
                return;
            }
            else if(state=="2")
            {
                $common.get_tipDialog('已出账，不可出账！','showInform');
                return;
            }
            $scope.bankdisable=true;
            $common.get_asyncData('rbcpDuebillRegisterService/BankCheckAndSendBillNo',{rBcpDuebillRegisterVO:$scope.selected.select[0]}).then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.queryTable();
                    $scope.selected.select=[];
                    $common.get_tipDialog('已出账！','showSuccess');
                    $scope.bankdisable=false;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                    $scope.bankdisable=false;
                }
            })
        }
    };
    //表格--------结束-------------------------
};
