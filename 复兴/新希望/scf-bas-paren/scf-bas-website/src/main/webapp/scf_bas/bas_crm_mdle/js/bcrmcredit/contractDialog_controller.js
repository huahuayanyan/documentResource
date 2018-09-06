var cntDialogController = function(dialogScope,parentScope,$common,flag) {
        dialogScope.datasourceDialog={//初始化表格对象
            ds: []
        };
        dialogScope.selectedDialog={//初始化对象
            select: []
        };
        dialogScope.confDialog = {//初始化分页对象
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        };
    
    if(flag == "cntadd"){
        dialogScope.cntform={};//定义form对象
        dialogScope.disable=false;
    }else if (flag == "cntupdate"){
    	dialogScope.cntform=$common.copy(parentScope.selected.select[0]);
        dialogScope.disable=true;
    };
     
    var errorFlag=false;//默认为false，无错误信息
    var errorMessage="";
    function  checkContact(){
        //电话号码校验
        if(dialogScope.cntform.contactTel){
            var contactTel=dialogScope.cntform.contactTel;
            if(contactTel.length > 0){
                var regTel = new RegExp(/^1\d{10}$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/);
                var r = regTel.test(contactTel);
                if(!r){
                    errorFlag=true;
                    errorMessage=errorMessage+"请输入正确的电话号码！"+"\n";
                }
            }
        }
        //邮箱校验
        if(dialogScope.cntform.email){
            var email=dialogScope.cntform.email;
            if(email.length > 0){
                var regTel = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
                var r = regTel.test(email);
                if(!r){
                    errorFlag=true;
                    errorMessage=errorMessage+"请输入正确的邮箱！"+"\n";
                }
            }
        }       
        if(dialogScope.cntform.idno && dialogScope.cntform.idno !=""&& (!dialogScope.cntform.idtype || dialogScope.cntform.idtype=="")){
            //证件号码不为空，证件类型丢失
            errorFlag=true;
            errorMessage=errorMessage+"请选择证件类型！"+"\n";
        }
    	var idno=dialogScope.cntform.idno;
        if(dialogScope.cntform.idtype == "01"){
            var regTel = new RegExp(/^[A-Za-z0-9]{8}-[A-Za-z0-9]{1}$/);
            var r = regTel.test(idno);
            if(!r){
                errorFlag=true;
                errorMessage=errorMessage+"“组织机构代码”证件号码格式应为8位数字或者英文字母+'-'+1位数字或者英文字母！"+"\n";
            }
        }
        if(dialogScope.cntform.idtype == "02"){
            var regTel = new RegExp(/^\d{15}$/);
            var r = regTel.test(idno);
            if(!r){
                errorFlag=true;
                errorMessage=errorMessage+"“营业执照”证件号码格式应为15位数字！"+"\n";
            }
        }
        if(dialogScope.cntform.idtype == "03"){
            var regTel = new RegExp(/^[A-Za-z0-9]{1,32}$/);
            var r = regTel.test(idno);
            if(!r){
                errorFlag=true;
                errorMessage=errorMessage+"“其他企业证件”证件号码格式默认为32位内数字或者英文字母或者组合！"+"\n";
            }
        }
        if(dialogScope.cntform.idtype == "04"){
            var regTel = new RegExp(/^[0-9A-Z]{18}$/);
            var r = regTel.test(idno);
            if(!r){
                errorFlag=true;
                errorMessage=errorMessage+"“社会信用代码证”证件号码格式应为18位数字或者英文字母或者组合！"+"\n";
            }
        }
        if(dialogScope.cntform.idtype == "05"){
            var regTel = new RegExp(/^([0-9]{15})|([0-9]{17}([0-9]|X))$/);
            var r = regTel.test(idno);
            if(!r){
                errorFlag=true;
                errorMessage=errorMessage+"“个人身份证”证件号码格式错误！"+"\n";
            }
          }   
    	
    }
   
    dialogScope.confirm_onClick = function(){
        if($.doValidate("cntform")) {
        	checkContact();
            if(errorFlag){
                var length = errorMessage.lastIndexOf("\n")-1;
                errorMessage.substring(length);
                $common.get_tipDialog(errorMessage,'showError');
                errorMessage="";
                errorFlag=false;
            }else{
	            if(flag =="cntadd"){
	            	dialogScope.cntform.custcd=parentScope.otherform.custcd;
	                var primise = $common.get_asyncData("bCrmContactsInfoService/add",{bCrmContactsInfo:dialogScope.cntform});
	                primise.then(function(res){
	                    if (res.errorCode =="SUC"){
	                        parentScope.queryTable();
	                        parentScope.selected.select=[];
	                        dialogScope.closeThisDialog();
	                        $common.get_tipDialog('新增成功！','showSuccess');
	                    }else{
	                        $common.get_tipDialog(res.errorMsg,'showError');
	                    };
	                });
	            }else if(flag == "cntupdate"){
	                var primise = $common.get_asyncData('bCrmContactsInfoService/update',{bCrmContactsInfo:dialogScope.cntform});
	                primise.then(function(res){
	                    if (res.errorCode =="SUC"){
	                        parentScope.queryTable();
	                        parentScope.selected.select=[];
	                        dialogScope.closeThisDialog();
	                        $common.get_tipDialog('更新成功！','showSuccess');
	                    }else{
	                        $common.get_tipDialog(res.errorMsg,'showError');
	                    };
	                });
	            };
           }
        };
    };
   
    
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };

};
