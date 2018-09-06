/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/05/03
 */

var adjustPriceApplicationMortgageContController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
	var dataX = dataDeliver.getter();
	 $scope.otherform={};
	 findFormInfo();
	 $scope.view=true;
    $scope.update=true;
	
	    //页面信息实时查询加载
	    function findFormInfo(){
	        var data= {
	            pageNo: 1,
	            pageSize: 10,
	            bCrrGntyCon:{conId:dataX.conId}
	        };
	        var promise = $common.get_asyncData("bCrrGntyConService/getSlaveContList",data);
	        promise.then(function(res){
	            var data;
	            if (res.errorCode =="SUC"){
	                data = res.contextData;
	                if(data.records[0]){
	                    $scope.otherform = data.records[0];
	                }
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	    }
	    //------------------业务品种---------------
	    $scope.selectSource = {
	        ds:[{key:"1220020",value:'现货动态质押'},]
	    };
};
