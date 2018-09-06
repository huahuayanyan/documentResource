/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/19
 */

var MarPricInfoListController = function(sDialogScope,$common,$state,dataDeliver) {

    sDialogScope.datasource={ds:[]};

    sDialogScope.selected={select:[]};

    sDialogScope.conf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    }

    sDialogScope.conditionForm={
    }

    sDialogScope.$watch("conf.pageNo+conf.pageSize",function(){
        sDialogScope.queryTable();
    });

    sDialogScope.queryTable = function(){

        var data={
            pageNo:sDialogScope.conf.pageNo,
            pageSize:sDialogScope.conf.pageSize,
            commonQueryVO:sDialogScope.conditionForm
        };

        var url ="bPbcMtgMktPriceService/getTblMortMarPriPage"
        $common.get_asyncData(url,data).then(function(res){
            if(res.errorCode=="SUC"){
                data= res.contextData;
                sDialogScope.datasource.ds = data.records;
                sDialogScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,"showError");
            }
        });

    }

    sDialogScope.bound_onClick = function(){
    	if(sDialogScope.selected.select.length==1){
    		var otherform = dataDeliver.getter();
    		otherform.fixMortgageNo = sDialogScope.selected.select[0].productId;
    		otherform.marketPrice = sDialogScope.selected.select[0].price;
        	dataDeliver.setter(otherform);
        	 $state.go("edit");
    	}else{
    		 $common.get_tipDialog('请至少选择一条记录！','showInform');
    	}
    }

    sDialogScope.back_onClick = function(){
        	$state.go("edit");
    }

    sDialogScope.submit_onClick = function(){
        sDialogScope.queryTable();
    }

    sDialogScope.rebort_onClick = function(){
        sDialogScope.conditionForm.productId_Q ='';
        sDialogScope.conditionForm.productName_Q ='';
        sDialogScope.conditionForm.mortgageLevelThreeName_Q ='';
        sDialogScope.selected.select =[];
        sDialogScope.queryTable();
    }

};
