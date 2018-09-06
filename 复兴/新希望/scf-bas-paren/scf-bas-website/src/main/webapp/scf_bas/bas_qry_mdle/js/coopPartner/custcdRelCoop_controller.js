/**
 * @author 	wubin
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var custcdRelCoopController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
   var deliverdata = dataDeliver.getter();
   $scope.conditionForm ={
		   custcd:deliverdata.custcd,
		   type:deliverdata.type,
		   coopCustcd:deliverdata.coopCustcd
   }
   $scope.otherform =$common.copy(deliverdata);
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
   /* $scope.$watch("conf.pageNo+conf.pageSize",function() {
    	
    });*/
    findCoopTypeDtlList();
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
    //合作客户
    $scope.coopNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coopNmdooextent = function(ds){
    	$scope.otherform.coopCustcd=ds.custcd;
    	$scope.otherform.coopNm=ds.cname;
    };
    $scope.$watch("otherform.coopNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
    	$scope.coopNmContent.param ={
            cname:$scope.otherform.coopNm
        };
    });
    function findCoopTypeDtlList(){
        var data= {
            //pageNo: $scope.conf.pageNo,
            //pageSize: $scope.conf.pageSize,
            cooperPartnerInfo:$scope.conditionForm
        };
        var promise = $common.get_asyncData("iCoopPartnerMngService/findCoopTypeDtlList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data;
               // $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //确定
    $scope.confirm_onClick = function(){
    	if($.doValidate("otherForm")){
    		 var oldcustcd = deliverdata.custcd;
    		 var oldCname = deliverdata.cname;
    		 var oldcoopCustcd = deliverdata.coopCustcd;
    		 var oldcoopNm = deliverdata.coopNm;
    		  var custcd = $scope.otherform.custcd;
    		  var cname = $scope.otherform.cname;
    		  var coopCustcd = $scope.otherform.coopCustcd;
    		  var coopNm = $scope.otherform.coopNm;
    		   if(oldcustcd==custcd&&oldcoopCustcd==coopCustcd){
     			  $common.get_tipDialog('客户及其合作伙伴的没有变化，请重新选择','showError');
                   return;
     		}
    		if(custcd==coopCustcd){
    			  $common.get_tipDialog('客户和其合作客户不可相同！','showError');
                  return;
    		}
    		var data = {
    				cooperPartnerInfo:$scope.otherform,
    		        list:$scope.datasource.ds
    		}
    		var msg ="确定将客户和其合作伙伴的相关数据" + "复制给"+cname+"和"+coopNm+"吗？";
    		$common.get_tipDialog(msg,'showTip').then(function(){
                var primise = $common.get_asyncData('iCoopPartnerMngService/addCustRelCoop',data);
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
