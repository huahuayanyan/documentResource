/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var paymentApplyController =  function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.otherform={//初始化账户
        //下列这些字段都是用于之后的应收账款信息表中的字段
        cnameSeller:"",//卖方客户名称
        cnameBuyer:"",//买方客户名称
        custcdBuyer:"",//买方客户号
        custcdSaller:"",//卖方客户号
        bussTypeName:"",//业务品种名称
        bussType:"",//业务品种对应额产品号
        mastContno:"",//业务合同号
        billsType:"",//凭证类型
        curcd:"",//币种
        aging:"",//账期
        gracePeriod:""//宽限期
    };
    
    $scope.dataSource = {ds:[]};
    //卖方客户查询
    $scope.sellerContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        param:{creditFlag:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
         split:"",//分隔符*/
        extentColumn:"cname",
        column:["cname"]//展示内容
    };
    $scope.sellerExtent = function(ds){
        $scope.otherform.custcdSaller=ds.custcd;
    };
    //监听事件 ！功能简述1.当卖方客户名称，发生改变，并且点击查询按钮，则再次重新查询两个表
    $scope.$watch("otherform.cnameSeller",function(){//一旦改变开始查询业务合同
        if($scope.otherform.cnameSeller == ""){//如果卖方客户名称为空，则卖方那个客户号也是空
            $scope.otherform.custcdSaller="";
        }
        $scope.sellerContent.param ={
        	creditFlag:'1',//必须是授信客户
            cname:$scope.otherform.cnameSeller
        }
    });

    //获得之前得到的卖方客户号去查询  业务合同号，业务品种名称和id，对应的合同的币种
        //业务合同号查询 debtContno，debtContnoContent，debtContnoExtent
       $scope.debtContnoContent = {
            type:"table",//展示类型table  tree
            url:"bCntDebtInfoService/selectBCntDebtInfoByPage",//请求url
            param:{custcd:$scope.otherform.custcdSaller,factType:"1"},
            split:"",//分隔符*/
            extentColumn:"debtContno",
            column:["debtContno"]//展示内容
        };
        $scope.debtContnoExtent = function(ds){
            $scope.otherform.bussType=ds.supplyChainPdId;//业务种类对应的产品号
            $scope.otherform.bussTypeName=ds.bussTypeName;//对应的业务种类名称
            $scope.otherform.curcd=ds.curcd;//该业务合同对应的币种
            $scope.queryLoanWay(ds.debtContno,"loanWay");

        };
        //业务合同监听事件（卖方）
        $scope.$watch("otherform.cnameSeller+otherform.mastContno",function(){
            if($scope.otherform.custcdSaller ==""){//卖方客户号为空，业务合同号也为空
                $scope.otherform.mastContno="";
            }
            $scope.debtContnoContent.param ={
                custcd:$scope.otherform.custcdSaller,
                contStatus:"01",//有效合同
                factType:"1",
                debtContno:$scope.otherform.mastContno//业务合同号
            }
        });

        //买方客户查询
        $scope.buyerContent = {
            type:"table",//展示类型table  tree
            url:"bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
            param:{businessNo:$scope.otherform.mastContno},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
            split:"",//分隔符*/
            extentColumn:"buyerName",
            column:["buyerName"]//展示内容
        };
        $scope.buyerExtent = function(ds){
            $scope.otherform.custcdBuyer=ds.buyerCustcd;//获得买方客户号
        };
        $scope.$watch("otherform.mastContno+otherform.buyerContent",function(){
            $scope.buyerContent.param ={
                businessNo:$scope.otherform.mastContno,//将之前查处的业务合同号传参
                buyerName:$scope.otherform.cnameBuyer//买方名称
            }
        });
        

    $scope.queryLoanWay=function(vdebtContno,vdictCode){
		    var data= {
		        debtContno: vdebtContno,
		        dictCode: vdictCode
		    };
		    var promise = $common.get_asyncData("irBcpPaymentService/getLoanWayList",data);
		    promise.then(function(res){
		        var data;
		        if (res.errorCode =="SUC"){
		            data = res.contextData;
		            $scope.dataSource = {
		                    ds:data
		                };
		            
		        }else{
		            $common.get_tipDialog(res.errorMsg,'showError');
		        }
		    });
    };   

    //点击之后，跳转传值。(查重，去重。)
    $scope.confirm_onClick=function(){
        if($.doValidate("otherform")){
            $scope.otherform.factType = "1";
		    var data= {rBcpAppliBussInfo:$scope.otherform};
            var primise = $common.get_asyncData("irBcpPaymentService/addPaymentApply", data);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    var data = res.contextData;
            	    window.viewhide=false;
            	    window.viewdisable=false;
                    $state.go("paymentupdate",{appNo:data.value});
                	
                	
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })

            
            
        }
    }
    $scope.back_onClick = function () {
        $state.go("paymentapplylist");
    };
};
