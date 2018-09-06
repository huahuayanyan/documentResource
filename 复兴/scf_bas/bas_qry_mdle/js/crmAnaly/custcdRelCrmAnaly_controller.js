/**
 * @author 	wubin
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var custcdRelCrmAnalyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
   var deliverdata = dataDeliver.getter();
   $scope.conditionForm ={
		   custcd:deliverdata.custcd,
		   type:deliverdata.type,
		   coopCustcd:deliverdata.coopCustcd
   };
   $scope.otherform =$common.copy(deliverdata);


    //客户
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.cnamedooextent = function(ds){
    	$scope.otherform.custcd=ds.custcd;
    	$scope.otherform.cname=ds.cname;
    };
    $scope.$watch("otherform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
    	$scope.cnameContent.param ={
            //creditFlag:"1", //授信客户
            cname:$scope.otherform.cname
        };
    });

    //确定
    $scope.confirm_onClick = function(){
    	if($.doValidate("otherForm")){
    		 var oldcustcd = deliverdata.custcd;
    		 var oldCname = deliverdata.cname;
    		  var custcd = $scope.otherform.custcd;
    		  var cname = $scope.otherform.cname;
    		   if(oldcustcd==custcd){
     			  $common.get_tipDialog('客户没有变化，请重新选择','showError');
                   return;
     		}

    		var data = {
                custAnalysisInfo:$scope.otherform
    		};
    		var msg ="确定将客户"+oldcustcd + "的信息复制给"+cname+"吗？";
    		$common.get_tipDialog(msg,'showTip').then(function(){
                var primise = $common.get_asyncData('iCoopPartnerMngService/addCustRelCrmAnaly',data);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                    	 $common.get_tipDialog('关联成功！','showSuccess');
                    	 $scope.back_onClick();
                     
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    	  
    };
    //返回
    $scope.back_onClick = function(){
       $state.go("list");
    };
    //表格--------结束-------------------------
};
