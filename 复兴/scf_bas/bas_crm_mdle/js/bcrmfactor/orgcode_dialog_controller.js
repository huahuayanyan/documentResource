/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var OrgCodeDialogController =  function(dialogScope,parentScope,$common,$state,dataDeliver){

	dialogScope.orgcodeform ={};
	dialogScope.confirm_onClick = function(){
		if($.doValidate("orgcodeform")){
			$common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoByKey",{bCrmBaseInfo:dialogScope.orgcodeform}).then(
				function(res){
					if(res.errorCode == "SUC"){
						var data = res.contextData;//查到的数据
						if (data.orgCode==dialogScope.orgcodeform.orgCode && data.factorFlag=="1" ){
							$common.get_tipDialog("该组织机构代码在系统中存在，不可以新增！",'showError');
						}else if(data.orgCode==dialogScope.orgcodeform.orgCode && data.factorFlag !="1" ) {
							$common.get_tipDialog('该组织机构代码在系统中已经存在，但并不是保理商，是否转为保理商？','showTip').then(function(){
								//if(data.ccmsCustcd==null||data.ccmsCustcd==undefined){
								//	data.ccmsCustcd = ccmsCustcdVal;
								//}
								var data1= {
									flag: "update",
									orgCode:data.orgCode,
									bCrmBaseInfo:data
								};
								$state.go("tree");
								dataDeliver.setter(data1);
							});
						}else if(data == "" || data.orgCode != dialogScope.orgcodeform.orgCode){
							var data1= {
								flag: "add",
								orgCode:dialogScope.orgcodeform.orgCode
							};
							$state.go("tree");
							dataDeliver.setter(data1);
							dialogScope.closeThisDialog();
						}
						dialogScope.closeThisDialog();
					}else{
						$common.get_tipDialog(res.errorMsg,"showError");
					}
				}
			);
		}
	};

	dialogScope.closeThisDialog_onClick = function(){
		dialogScope.closeThisDialog();
	}

};
