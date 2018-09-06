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
			var orgCodeVal = dialogScope.orgcodeform.orgCode;
			$common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoByKey",{bCrmBaseInfo:dialogScope.orgcodeform}).then(function(res){
				if(res.errorCode=="SUC"){
					var data = res.contextData;
					if(data.orgCode == orgCodeVal&&data.flcFlag =='1'){
						$common.get_tipDialog("该组织机构代码在系统中存在，不可以新增！",'showInform');
					}else if(data.orgCode == orgCodeVal&&data.flcFlag !='1'){
						$common.get_tipDialog("该组织机构代码在系统中已经存在，但并不是金融租赁公司，是否转为金融租赁公司？",'showTip').then(
							function(){
								var deliverData ={
									flag:"update",
									orgCode:orgCodeVal,
									bCrmBaseInfo:data
								};
								$state.go("tree");
								dataDeliver.setter(deliverData);
							}
						)
					}else if(data.orgCode==""||data.orgCode==undefined||data.orgCode!=orgCodeVal){
						dataForm ={
							tlrName:data.tlrName,
							brName:data.brName,
							ccmsCustcd:data.ccmsCustcd,
							orgCode:orgCodeVal,
							flcFlag:'1'
						}
						var deliverData ={
							flag:"add",
							orgCode:orgCodeVal,
							bCrmBaseInfo:dataForm
						};
						$state.go("tree");
						dataDeliver.setter(deliverData);
					}
					dialogScope.closeThisDialog();
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
		}else{
			$common.get_tipDialog("数据未输入完整",'showError');
		}

	};

	dialogScope.closeThisDialog_onClick = function(){
		dialogScope.closeThisDialog();
	}

};
