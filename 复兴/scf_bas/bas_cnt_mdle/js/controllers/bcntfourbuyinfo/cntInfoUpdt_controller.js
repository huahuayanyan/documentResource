/**

 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Created by htrad0055 on 2016/12/7.
 */

var cntInfoUpdtController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.disable = true;
    var getter = dataDeliver.getter();
    var cntInfoFormData = getter.cntInfoForm;
    $scope.cntInfoForm={
/*        totAmt:'0.0',
        costMoney:'0.0'*/
    };


    $scope.supplyChainPdIdSource= {
        //ds:[{key:"1210010",value:"担保提货"}]
        ds: [{key: "1210020", value: "先票/款后货"}]
    };


    $scope.tpmprotdatasource={
        ds:[]
    };


    if(cntInfoFormData!=undefined||cntInfoFormData!=null){
        $scope.cntInfoForm = cntInfoFormData;
    }

    $scope.mprotdatasource={
        ds:[]
    };

    $scope.mprotselected ={
        select:[]
    };


    $scope.mprotConf={
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };


    $scope.tempListMprots =[];
    $scope.inserListMprots =[];
    $scope.updateListMprots =[];
    $scope.delListListMprots =[];


    //debugger;

    init();

    //初始化--------结束------------------------


     function init(){

        var data = {
            pageNo: $scope.mprotConf.pageNo,
            pageSize: $scope.mprotConf.pageSize,
            bCntBuyInfo: $scope.cntInfoForm
        };

        //debugger;
        var promise = $common.get_asyncData("iBCntMprotInfoService/findBCntMprotInfoVOByPage", data);
        promise.then(
            function (res) {
                if (res.errorCode == "SUC") {
                    //data = res.contextData;
                    //$scope.tempListMprots = res.contextData.records;

                    $scope.inserListMprots =  res.contextData.records;

                    $scope.mprotdatasource.ds =  $scope.inserListMprots;

                    //console.log(JSON.stringify($scope.inserListMprots));

                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            }
        );
    }

    //*********买方客户名称下拉-BEGIN************//
    $scope.sellerNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.cntInfoForm.custcd=ds.custcd;
        $scope.cntInfoForm.cname=ds.cname;
    };
    $scope.$watch("cntInfoForm.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.sellerNmContent.param ={
            creditFlag:'1',
            custType:'1',
            cname:$scope.cntInfoForm.cname
           // custcd:$scope.cntInfoForm.custcd
        }
        if($scope.cntInfoForm.cname ==""&& $scope.cntInfoForm.cnam ==null){
            $scope.cntInfoForm.custcd="";
            $scope.cntInfoForm.protocolNo="";
            $scope.cntInfoForm.secCname="";
            $scope.cntInfoForm.secCustcd="";
        }
        $scope.protocolNoContent.param ={
            protocolType:'02',
            protocolNo:$scope.cntInfoForm.protocolNo,
            custcd:$scope.cntInfoForm.custcd  //买方
            //coreCustcd:$scope.cntInfoForm.secCustcd   //卖方
        }
    });
    //*********买方客户名称下拉-END************//





    //************卖方客户名称下拉-BEGIN********//
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmExtent = function(ds){
        $scope.cntInfoForm.secCustcd=ds.custcd;
        $scope.cntInfoForm.secCname=ds.cname;
    };
    $scope.$watch("threeProtocolForm.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:'1',
            custType:'1',
            secCname:$scope.cntInfoForm.secCname,
            secCustcd:$scope.cntInfoForm.secCustcd
        }
    });
    //*********卖方客户名称下拉-END************//


    //************担保提货协议号-BEGIN********//
    $scope.protocolNoContent = {
        type:"table",//展示类型table  tree
        //url:"iBCntMprotBaseInfoService/selectBCntMprotBaseInfoByPage",//请求url
        url:"iBCntBuyInfoService/selectThreeProtocolList",//请求url
        //param:{protocolType: '07',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        //split:"",//分隔符
        extentColumn:"protocolNo",
        column:["protocolNo"]//展示内容
    };
    $scope.protocolNoExtent = function(ds){
        $scope.cntInfoForm.protocolNo=ds.protocolNo;
        $scope.cntInfoForm.secCname=ds.cname;
        $scope.cntInfoForm.secCustcd= ds.custcd;
        //$scope.cntInfoForm.secCname=ds.cname;
    };
    $scope.$watch("cntInfoForm.protocolNo",function(){

        if($scope.cntInfoForm.protocolNo ==""|| $scope.cntInfoForm.cname ==null){
            $scope.cntInfoForm.secCname="";
            $scope.cntInfoForm.secCustcd="";
        }
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.protocolNoContent.param ={
            protocolType:'07',
            protocolNo:$scope.cntInfoForm.protocolNo,
            custcd:$scope.cntInfoForm.custcd  //买方
            //coreCustcd:$scope.cntInfoForm.secCustcd   //卖方
        }
    });
    //*********担保提货协议号-END************//

    $scope.$watch("mprotConf.pageNo+mprotConf.pageSize",function(){$scope.queryMprotTable()});
    $scope.$watch("mprotdatasource.ds+mprotConf.totalRecord",function(){$scope.queryMprotTable()});


    $scope.queryMprotTable = function(paramData){

        $scope.mprotdatasource.ds =  $scope.inserListMprots;
        $scope.mprotConf.totalRecord= $scope.mprotdatasource.ds.length;

    };


    //添加一条质押物记录
    $scope.addMrtg_onClick= function(){
        $common.get_ngDialog('bcntbuyinfo/mprotDialog.html', $scope
            ,["$scope",function($mprotDialogScope){
                mptDlgUpdcntController($mprotDialogScope,$scope,$common,$state,dataDeliver,"add") ;
            }],"新增操作",{showClose:false});
    };

    //更新一条质押物记录
    $scope.updateMrtg_onClick= function(){
        if($scope.mprotselected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('bcntbuyinfo/mprotDialog.html', $scope
                ,["$scope",function($mprotDialogScope){
                    mptDlgUpdcntController($mprotDialogScope,$scope,$common,$state,dataDeliver,"update") ;
                }],"修改操作",{showClose:false});
            //dataDeliver.setter($scope.mprotselected.select[0]);
        }
    };


    //删除一条质押吴记录
    $scope.deleteMrtg_onClick= function(){
        if($scope.mprotselected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            //从inserListMprots中删除页面列表选中的元素
            var mprotSelected = $scope.mprotselected.select[0];
            var dtsrcList = $scope.mprotdatasource.ds;
            $scope.inserListMprots =[];

            if(mprotSelected.mortgageNo!=undefined||mprotSelected.mortgageNo!="") {
                $scope.delListListMprots.push(mprotSelected);
            }
            var index = $scope.inserListMprots.length;
            for(var i=0;i<dtsrcList.length;i++){
                if(dtsrcList[i].$$hashKey!=mprotSelected.$$hashKey){
                    $scope.inserListMprots[index] =dtsrcList[i];
                    index++;
                }
            }
            $scope.$apply(function(){
                $scope.mprotdatasource.ds = $scope.inserListMprots;
                $scope.mprotselected.select=[];
            });
        }
        console.log(JSON.stringify($scope.tempListMprots));
    };
    
    //金额校验
    $scope.amt_onBlur = function(){
        //合同金额长度校验
        var amt = $scope.cntInfoForm.amt;
        if( checkLenght(amt.toString())>16)
        {
            $common.get_tipDialog('【合同金额】系统允许最大输入长度为16位，请重新输入','showError');
            $scope.cntInfoForm.amt="";;
            return false;
        }
    }
    $scope.costMoney_onBlur = function(){
        //合同金额长度校验
        var costMoney = $scope.cntInfoForm.costMoney;
        if(costMoney!=null&&costMoney!=""&&costMoney!=undefined){
        	 if( checkLenght(costMoney.toString())>16)
             {
                 $common.get_tipDialog('【其他费用】系统允许最大输入长度为16位，请重新输入','showError');
                 $scope.cntInfoForm.costMoney="";;
                 return false;
             }
        }
       
    }

    //更新合同信息
    $scope.saveCnt_onClick = function(){
        if($.doValidate("cntInfoForm")) {
            var records = $scope.mprotdatasource.ds;
            if (records.length <= 0) {
                $common.get_tipDialog("采购商品信息列表不能为空!", 'showInform');
                return false;
            }
            //校验买方名称是否手动输入
            if( $scope.cntInfoForm.custcd==null){
                $common.get_tipDialog('请选择正确的买方名称！', 'showInform');
                return false;
            }
            //合同金额大于0
            var amt = $scope.cntInfoForm.amt;
            if(parseFloat(amt)<=0) {
                $common.get_tipDialog('合同金额必须大于0！', 'showInform');
                return false;
            }
            if( checkLenght(amt.toString())>16)
            {
                $common.get_tipDialog('“合同金额”长度大于16，请重新输入','showError');
                return false;
            }
            var costMoney = $scope.cntInfoForm.costMoney;
            if( checkLenght(costMoney.toString())>16)
            {
                $common.get_tipDialog('“其他费用”长度大于16，请重新输入','showError');
                return false;
            }
            //校验合同金额>=采购商品总价值与其他费用之和
            var contAmt = 0;//货物总金额
            for (i = 0; i < records.length; i++) {
                var record = records[i];
                var mortgageName = record.mortgageName;//货物名称
                var totPrice = record.totPrice;//货物价值
                if (!isNaN(totPrice)) {
                    contAmt = contAmt + parseFloat(totPrice);
                }
                if( checkLenght(totPrice.toString())>16)
                {
                    $common.get_tipDialog('货物名称为：【'+mortgageName+'】的记录，“总价”超过系统允许存储的最大数值长度16位，请重新输入“数量/重量 ”或“单价 ”','showError');
                    return false;
                }
            }
            var costMoney = $scope.cntInfoForm.costMoney;
            if (!isNaN(costMoney)) {
                contAmt = contAmt + parseFloat(costMoney);
            }
            if (amt < contAmt) {
                $common.get_tipDialog('合同金额必须大于等于商品总价值与其他费用之和！', 'showInform');
                return false;
            }
            var data = {
                bCntBuyInfo: $scope.cntInfoForm,
                insertList: $scope.inserListMprots,
                deleteList: $scope.delListListMprots
            };

            var promise = $common.get_asyncData("iBCntBuyInfoService/updateBCntBuyInfo", data);
            promise.then(
                function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                        $state.go("bcntBuyInfoList");
                        //$scope.queryTable();
                        //$scope.selected.select=[];
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                }
            );
        }
    };



    $scope.backToList_onClick = function(){
        $state.go("bcntBuyInfoList");
    };

    //表格--------结束-------------------------
};