/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var billNormallistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
    });
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
        $scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            billNormalVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("sBcpMortBillNormalService/findSBcpMortBillNormalByPage",data);
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
     * 新增
     */
    $scope.add_onClick = function(){
        $common.get_ngDialog('billnormal/bill_normal_add.html', $scope,["$scope",function(dialogScope){
            dialogScope.billnormal = {};
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
                var dataItemsDO = {parentId:"1000",productId:"1202"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.productselect.ds = res.contextData||[];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            /**
             * 出质人查询加载开始
             */
            dialogScope.custcontent = {
                type:"table",//展示类型table  tree
                url:"bCrrLnAppService/queryCustSource",
                param:{},
                split:",",//分隔符
                extentColumn:"cname",
                column:["custNm","custId"]//展示内容
            };
            dialogScope.dooextend = function(ds){
                dialogScope.billnormal.cname = ds.custNm;
                dialogScope.billnormal.custcd = ds.custId;
            };
            dialogScope.$watch("billnormal.cname",function(){
                if(dialogScope.billnormal.cname!=null) dialogScope.custcontent.param ={custId:dialogScope.billnormal.cname,custNm:dialogScope.billnormal.cname};
            });
            /**
             * 出质人查询加载结束
             */
            /**
             * 抵/质押合同号筛选开始
             */
            dialogScope.slavecontent = {
                type:"table",//展示类型table  tree
                url:"bCrrGntyConService/findSlaveContnoByPageForCHL",
                param:{vidPrdId:"1202",conStat:"1",gutId:dialogScope.billnormal.custcd,gutNm:dialogScope.billnormal.cname},
                split:",",//分隔符
                extentColumn:"slaveContno",
                column:["conId"]//展示内容
            };
            dialogScope.slaveextend = function(ds){
                dialogScope.billnormal.slaveContno=ds.conId;//抵质押合同号
                dialogScope.billnormal.supplyChainPdIdName=ds.vidPrdId; //供应链业务品种
            };
            dialogScope.$watch("billnormal.custcd",function(newVal,oldVal){
                if(dialogScope.billnormal.custcd!=null)
                    dialogScope.slavecontent.param ={
                        vidPrdId:"1202",
                        conStat:"1",
                        gutId:dialogScope.billnormal.custcd,
                        gutNm:dialogScope.billnormal.cname
                    };
            });
            /**
             * 抵/质押合同号筛选结束
             */
            dialogScope.confirm_onClick = function()
            {
                if($.doValidate("billnormal")) {
                    var promise = $common.get_asyncData("sBcpMortBillNormalService/getBrName");
                    promise.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData.value;
                            var row = dialogScope.billnormal;
                            row.brcodeName = data;
                            dialogScope.closeThisDialog();
                            $state.go("editlist");
                            dataDeliver.setter(row);
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };
            };
            dialogScope.close_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"仓单信息详情")
    };
    //修改
    $scope.update_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $common.get_ngDialog('billnormal/bill_normal_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.billnormal = $scope.row;
                dialogScope.disable = true;
                dialogScope.save_onClick = function()
                {
                    if($.doValidate("billnormal")) {
                        $common.get_asyncData("sBcpMortBillNormalService/update",{billNormalVO:dialogScope.billnormal}).then(function(res){
                            if (res.errorCode =="SUC"){
                                $common.get_tipDialog("保存成功",'showSuccess');
                                dialogScope.closeThisDialog();
                                $scope.queryTable();
                                $scope.selected.select=[];
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                }
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"仓单基本信息")
        };
    };
    //查看
    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $common.get_ngDialog('billnormal/bill_normal_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.billnormal = $scope.row;
                dialogScope.disable = true;
                dialogScope.disableview = true;
                dialogScope.hide = true;
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"仓单基本信息")
        }
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var list = $scope.selected.select;
            for(var i in list){
                if(list[i].isPledge > 0){
                    $common.get_tipDialog('仓单'+ list[i].billcode + '已质押，不能删除！','showInform');
                    return;
                }
            }
            $common.get_tipDialog('此仓单下存在押品信息，是否确定删除此记录？','showTip').then(function(){
                var primise = $common.get_asyncData('sBcpMortBillNormalService/batchDelete',{list:$scope.selected.select})
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
    };
    //押品清单维护
    $scope.mortlist_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.row = $scope.selected.select[0];
            $state.go("mortlist");
            dataDeliver.setter($scope.row);
            //$common.get_ngDialog('billnormal/bill_normal_mortlist.html', $scope,["$scope",function(dialogScope){
            //    dialogScope.billnormal = $scope.row;
            //    dialogScope.hide = true;
            //    if(dialogScope.billnormal.status=="1")
            //    {
            //        dialogScope.hide = false;
            //    }
            //    else
            //    {
            //        dialogScope.hide = true;
            //    }
            //    dialogScope.datasource={//初始化表格对象
            //        ds: []
            //    };
            //    dialogScope.selected={//初始化对象
            //        select: []
            //    };
            //    dialogScope.conf= {//初始化分页对象
            //        pageNo: 1,
            //        pageSize: 10,
            //        totalRecord: 0}
            //    //监听分页
            //    dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
            //        dialogScope.queryTable();
            //    })
            //    dialogScope.queryTable = function(paramData){
            //        var data= {
            //            pageNo: $scope.conf.pageNo,
            //            pageSize: $scope.conf.pageSize,
            //            mortgageQryVO:dialogScope.billnormal
            //        };
            //        var promise = $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageBaseGetter",data);
            //        promise.then(function(res){
            //            var data;
            //            if (res.errorCode =="SUC"){
            //                data = res.contextData;
            //                dialogScope.datasource.ds = data.records;
            //                dialogScope.conf.totalRecord = data.totalRecord;
            //            }else{
            //                $common.get_tipDialog(res.errorMsg,'showError');
            //            }
            //        });
            //    };
            //    dialogScope.add_onClick = function()
            //    {
            //        $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(secondScope) {
            //            billNormalmorteditController(secondScope,dialogScope,dataDeliver,$state,$common,"add");
            //        }],"货物维护")
            //    };
            //    dialogScope.edit_onClick = function()
            //    {
            //        if(dialogScope.selected.select.length != 1){
            //            $common.get_tipDialog('请至少选择一条记录！','showInform');
            //        }else{
            //            $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(secondScope) {
            //                billNormalmorteditController(secondScope,dialogScope,dataDeliver,$state,$common,"update");
            //            }],"货物维护")
            //        }
            //    };
            //    dialogScope.delete_onClick = function()
            //    {
            //        if(dialogScope.selected.select.length != 1){
            //            $common.get_tipDialog('请至少选择一条记录！','showInform');
            //        }else{
            //            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
            //                dialogScope.mortgageInfo = dialogScope.selected.select[0];
            //                dialogScope.mortgageInfo.flag = "delete";
            //                $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageSaveUpdate",{mortgageBaseVO:secondScope.mortgageInfo}).then(function(res){
            //                    if (res.errorCode =="SUC"){
            //                        $common.get_tipDialog("删除成功",'showSuccess');
            //                        secondScope.closeThisDialog();
            //                        dialogScope.queryTable();
            //                    }else{
            //                        $common.get_tipDialog(res.errorMsg,'showError');
            //                    }
            //                });
            //            })
            //        }
            //    };
            //    dialogScope.back_onClick = function(){
            //        dialogScope.closeThisDialog();
            //    };
            //}],"押品清单维护页面")
        }
    };
    //表格--------结束-------------------------
};
