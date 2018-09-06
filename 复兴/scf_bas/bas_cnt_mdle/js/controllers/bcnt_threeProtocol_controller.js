/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bcntThreeProtocolController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
            productId:"1210010",//业务品种默认值(担保提货)
    };//初始化查询条件对象
    $scope.selectSource = {
            ds:[{key:"1210010",value:'担保提货'},]
        };
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
        totalRecord: 0
   };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                    productId:"1210010",//业务品种默认值(担保提货)
            };
            $scope.selected.select=[];//清空选项
        })
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
            deliveryQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("threeProtocolService/queryThreeProtocolListByPage",data);
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
    //担保提货协议新增按钮
    $scope.doAdd_onClick = function(){
        $state.go("bcntThreeProtocolAdd");
        var data= {
            flag:"add"
        };
        dataDeliver.setter(data);
     };
    //担保提货协议修改按钮
    $scope.doModify_onClick = function(){
    	 if($scope.selected.select.length != 1){
             $common.get_tipDialog('只能选择一条记录！','showInform');
         }else{
        	 var protocolNo=$scope.selected.select[0].protocolNo;
        	 $state.go("bcntThreeProtocolModify");
             var data= {
            	protocolNo:protocolNo,
            	flag:"update"
             };
             dataDeliver.setter(data);
         }
    };
    //删除提货协议修改按钮
    $scope.doDelete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	var protocolNo=$scope.selected.select[0].protocolNo;
            var msg='确认删除 协议编号为[' + protocolNo + "]的担保提货协议吗？"
            $common.get_tipDialog(msg,'showTip').then(function(){
                var primise = $common.get_asyncData('threeProtocolService/threeProtocolDelete',{threeProtocolVO:{protocolNo:protocolNo}});
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

    $scope.fresh_onClick = function(){
        $scope.queryTable($scope.conditionForm);
        $scope.selected.select=[];
    };
    $scope.column = function(row){
        console.log(JSON.stringify(row));
    };
    //表格--------结束-------------------------

    $scope.protocolCode = function(data1){
        $common.get_ngDialog('bcntthreeProtocol/bcnt_threeProtocolAdd.html',$scope,["$scope",function(dialogScope){
            dialogScope.sellerNmDisable = true;
            dialogScope.loanWay = true;
            dialogScope.startDate = true;
            dialogScope.endDate = true;
            dialogScope.threeProtocolStatus = true;
            dialogScope.cooperationBrcodeNmDisable = true;
            dialogScope.brcodeDisable = true;
            dialogScope.coreNmDisable = true;
            dialogScope.otherCustName = true;
            dialogScope.fouNameDisable = true;
            dialogScope.dutyAssumeType = true;
            dialogScope.firstBailRatio = true;
            dialogScope.firstBailType = true;
            dialogScope.otherDes = true;
            dialogScope.save = true;
            var protocolCode = data1.protocolCode;
            var threeProtocolVO ={
                protocolNo:protocolCode
            };
            var data = {
                threeProtocolVO:threeProtocolVO
            };
            dialogScope.threeProtocolForm = {};
            dialogScope.selectbrcode = {};
            var promise=$common.get_asyncData("threeProtocolService/queryThreeProtocolForOneObject",data);
            promise.then(function (res) {
                if(res.errorCode=="SUC"){
                    data = res.contextData;
                    dialogScope.threeProtocolForm=data;
                    dialogScope.selectbrcode.ds =data.listBctl;
                    dialogScope.threeProtocolForm.brcode=data.brcode;
                    dialogScope.threeProtocolForm.inputorgname=data.inputorgname;
                    if(data.dutyAssumeType!=null){
                        dialogScope.threeProtocolForm.dutyAssumeType=JSON.parse(data.dutyAssumeType);
                    }
                    if(data.loanWay!=null){
                        dialogScope.threeProtocolForm.loanWay=JSON.parse(data.loanWay);
                    }
                    dialogScope.brcodeDisable =true;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })
            dialogScope.back_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.queryTable();
                $scope.selected.select=[];
            };
            //合作机构下拉-begin
            dialogScope.cooperationBrcodeNmContent = {
                type:"table",//展示类型table  tree
                url:"bSysCommonService/selectBranchInfo",//请求url
                param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split:"-",//分隔符
                extentColumn:"brName",
                column:["brNo","brName"]//展示内容
            };
            dialogScope.cooperationBrcodeNmExtent = function(ds){
                dialogScope.threeProtocolForm.cooperationBrcode=ds.brNo;
                dialogScope.threeProtocolForm.cooperationBrcodeNm=ds.brName;
            };
            //承担方客户名称下拉-begin
            dialogScope.fouNameContent = {
                type:"table",//展示类型table  tree
                url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
                //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split:"-",//分隔符
                extentColumn:"cname",
                column:["custcd","cname"]//展示内容
            };
            dialogScope.fouNameExtent = function(ds){
                dialogScope.threeProtocolForm.fouCd=ds.custcd;
                dialogScope.threeProtocolForm.fouName=ds.cname;
            };
            //卖方客户名称下拉-begin
            dialogScope.coreNmContent = {
                type:"table",//展示类型table  tree
                url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
                //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split:"-",//分隔符
                extentColumn:"cname",
                column:["custcd","cname"]//展示内容
            };
            dialogScope.coreNmExtent = function(ds){
                dialogScope.threeProtocolForm.coreCustcd=ds.custcd;
                dialogScope.threeProtocolForm.coreNm=ds.cname;
            };
            //买方客户名称下拉-begin
            dialogScope.sellerNmContent = {
                type:"table",//展示类型table  tree
                url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
                //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                split:"-",//分隔符
                extentColumn:"cname",
                column:["custcd","cname"]//展示内容
            };
            dialogScope.dooextent = function(ds){
                dialogScope.threeProtocolForm.custcd=ds.custcd;
                dialogScope.threeProtocolForm.sellerNm=ds.cname;
            };
            var productPar= {
                pageNo: '1',
                pageSize: '999999',
                bPrdInfo:{parentId:'2100'}
            };
            //业务品种
            product();
            dialogScope.productSource = {};
            function product(){
                var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage",productPar);
                promise.then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        dialogScope.productSource.ds = data.records;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
        }],"查看合同信息")
    }
};
