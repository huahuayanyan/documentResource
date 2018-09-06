/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var custviewController = function($scope,$common,$stateParams,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.otherform.fin = "%"+$stateParams.mdlTyp+"%";
    $scope.otherform.finDirId = $stateParams.finDirId;
    $scope.otherform.mdlId = $stateParams.mdlId;
    $scope.otherform.delFlg = "0";
    var finStat;
    $common.get_asyncData("bFinCustDirService/findBFinCustDirByFinDirId",{finDirId:$scope.otherform.finDirId}).then(function(res){
        var finDirInfo;
        if (res.errorCode =="SUC"){
            finDirInfo = res.contextData;
            finStat = finDirInfo.finStat;
            if(finStat=="1")
            {
                $scope.flowsubmitdisable = true;
            }
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    $scope.queryBFinCnfgCl = function(){
        var data= {
        		mdlId:$scope.otherform.mdlId
        };
        var promise = $common.get_asyncData("bFinCnfgClService/findBFinCnfgClByMdlId",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
            	$scope.rheads=eval(data.rem);
            	$scope.otherform.cotes=data.cotes;
            	$scope.otherform.col=data.col;	
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    $scope.queryTable = function(paramData){
    	var primisedsis = $common.get_asyncData("bFinCustDsService/findFinCustDsIsDone",{finDirId:$scope.otherform.finDirId});
        primisedsis.then(function(res){
        	var data;
            if (res.errorCode =="SUC"){
            	data = res.contextData.value;
            	$scope.otherform.stat = data;
            	var promise;
                var flag = $scope.otherform.stat;
                if(flag=="add")
                {
                    promise = $common.get_asyncData("bFinCustDsService/findBFinCustDsByFinId",{bFinCustDs:$scope.otherform});
                    $scope.otherform.stat = "update";
                }else if(flag=="update")
                {
                    promise = $common.get_asyncData("bFinCustDsService/findBFinCustDsListByFinDirId",{finDirId:$scope.otherform.finDirId});
                }
                promise.then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                    	$scope.bFinCustDsList = res.contextData || [];
                        for(var i=0;i<$scope.bFinCustDsList.length;i++)
                        {
                            var custds = $scope.bFinCustDsList[i];
                            var val1 = custds.colVal1;
                            var val2 = custds.colVal2;
                            custds.colVal1 = checkVal(val1);
                            custds.colVal2 = checkVal(val2);
                            if(custds.child)
                            {
                                var childVal1 = custds.child.colVal1;
                                var childVal2 = custds.child.colVal2;
                                custds.child.colVal1 = checkVal(childVal1);
                                custds.child.colVal2 = checkVal(childVal2);
                            }
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };

    function checkVal(val)
    {
        if(val == undefined)
        {
            return val;
        }
        if(val!=0)
        {
            var str = val.toString();
            if(str.indexOf('.') == -1)
            {
                str += ".00";
            }
            else
            {
                var index = str.substring(str.lastIndexOf(".")+1);
                if(index.length<2)
                {
                    str = str+"0";
                }
            }
            return str;
        }
        else
        {
            val += ".00";
            return val;
        }
    }
    //初始化表头
    $scope.queryBFinCnfgCl(); 
    $scope.queryTable();
    //编辑
    //$scope.update_onClick = function(){
    //    if($scope.selected.select.length <= 0){
    //        $common.get_tipDialog('请至少选择一条记录！','showInform');
    //    }else{
    //        $common.get_ngDialog('dir/ds_edit.html',$scope
    //            ,["$scope",function(dialogScope){
    //                dseditController(dialogScope,$scope,$common,"update");
    //            }],"编辑报表数据",{showClose:true});
    //    };
    //};
    //$scope.column = function(row){
    //    $scope.row = row;
    //	$common.get_ngDialog('dir/ds_edit.html',$scope
    //            ,["$scope",function(dialogScope){
    //                dseditController(dialogScope,$scope,$common,"view");
    //            }],"编辑报表数据",{showClose:true});
    //};
    //计算结果
    $scope.calCheck_onClick = function() {
        $scope.flowsubmitdisable = true;
        if($scope.bFinCustDsList.length==0)
        {
            $common.get_tipDialog('报表信息为空，请维护报表信息！','showInform');
            $scope.flowsubmitdisable = false;
            return;
        }
        $common.get_asyncData("bFinCustDsService/getList",{list:$scope.bFinCustDsList}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.bFinCustDs = res.contextData;
                var primisecal = $common.get_asyncData("bFinCustDsService/calCheck",{list:$scope.bFinCustDs});
                primisecal.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.bFinCustDsList = res.contextData;
                        for(var i=0;i<$scope.bFinCustDsList.length;i++)
                        {
                            var custds = $scope.bFinCustDsList[i];
                            var val1 = custds.colVal1;
                            var val2 = custds.colVal2;
                            custds.colVal1 = checkVal(val1);
                            custds.colVal2 = checkVal(val2);
                            if(custds.child)
                            {
                                var childVal1 = custds.child.colVal1;
                                var childVal2 = custds.child.colVal2;
                                custds.child.colVal1 = checkVal(childVal1);
                                custds.child.colVal2 = checkVal(childVal2);
                            }
                        }
                        $common.get_tipDialog('数据计算成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                        $scope.flowsubmitdisable = false;
                    };
                    $scope.flowsubmitdisable = false;
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.flowsubmitdisable = false;
            };
            $scope.flowsubmitdisable = false;
        });
    }
    //临时保存
    $scope.save_onClick = function () {
        $scope.flowsubmitdisable = true;
        if($scope.bFinCustDsList.length==0)
        {
            $common.get_tipDialog('报表信息为空，请维护报表信息！','showInform');
            $scope.flowsubmitdisable = false;
            return;
        }
        $common.get_asyncData("bFinCustDsService/getList",{list:$scope.bFinCustDsList}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.bFinCustDs = res.contextData;
                $scope.bFinCustDsSubmitList=[];
                $scope.bFinCustDsSubmitList=new Array(0);
                setbFinCustDsList($scope.bFinCustDs,$scope.bFinCustDsSubmitList,$scope.otherform);
//                var colVal1='';
//                var colVal2='';
//                for(var i=0;i<$scope.bFinCustDs.length;i++){
//                	var custDs=$scope.bFinCustDs[i];
//                	//subjId SYB003
//                	console.log("----------subjId:"+custDs.subjId+" flagM:"+custDs.flagM);
//                	if(!custDs.flagM){//如果只读项，跳过，遍历下一条记录
//                		continue;
//                	}
//                	colVal1=document.getElementById(custDs.subjId+"1").value;
//                	colVal2=document.getElementById(custDs.subjId+"2").value;
//                	console.log("----------colVal1:"+colVal1);
//                	console.log("----------colVal2:"+colVal2);
//                	custDs.colVal1=colVal1;
//                	custDs.colVal2=colVal2;
//                	$scope.bFinCustDsSubmitList.push(custDs);
//                }

                var primise = $common.get_asyncData('bFinCustDsService/update',{list:$scope.bFinCustDsSubmitList});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('临时保存成功！','showSuccess');
                        $state.go("cust");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                        $scope.flowsubmitdisable = false;
                    };
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.flowsubmitdisable = false;
            };
            $scope.flowsubmitdisable = false;
        });
    };
    /**
     * 设置表单输入的金额，用于提交至后端服务业务处理
     * bFinCustDsSrcList-输入原list
     * bFinCustDsSubmitList-处理后数据源
     * otherform-取财报模型分类表栏位
     * add by huangshuidan 2017-06-08
     */
    function setbFinCustDsList(bFinCustDsSrcList,bFinCustDsSubmitList,otherform) {
    	 var colVal1='';
         var colVal2='';
         //undefined
         console.log("----------otherform:"+otherform);
         console.log("----------otherform.cotes:"+otherform.cotes);
         var cotes=otherform.cotes;
         for(var i=0;i<bFinCustDsSrcList.length;i++){
         	var custDs=bFinCustDsSrcList[i];
         	console.log("----------subjId:"+custDs.subjId+" flagM:"+custDs.flagM+" edTyp:"+custDs.edTyp);
         	if(!custDs.flagM && custDs.edTyp=='3'){//如果只读项/标题项，跳过，遍历下一条记录 edTyp
         		continue;
         	}
     		colVal1=document.getElementById(custDs.subjId+"1").value;//默认1栏位
         	if(cotes>1){//栏位>1才有第2个栏位
             	colVal2=document.getElementById(custDs.subjId+"2").value;
         	}
         	console.log("----------colVal1:"+colVal1);
         	console.log("----------colVal2:"+colVal2);
         	custDs.colVal1=colVal1;
         	custDs.colVal2=colVal2;
         	bFinCustDsSubmitList.push(custDs);
         }
    }
    //
    /**
     * 财务指标分析
     * add by huangshuidan 2017-06-13
     */
    $scope.analy_onClick=function(){
		var bFinCustDs = {
			finDirId : $scope.otherform.finDirId,
			rpSource:$scope.otherform.finPd,
			mdlId:$scope.otherform.mdlId
		};
		var data = {
			bFinCustDs : bFinCustDs
		}
//    	$scope.bFinCustDs.finDirId = $scope.otherform.finDirId;
//    	$scope.bFinCustDs.rpSource = $scope.otherform.finPd;
//    	$scope.bFinCustDs.mdlId = $scope.otherform.mdlId;
        var primisecal = $common.get_asyncData("bFinCustDsService/analy",data);
        primisecal.then(function(res){
        	 if (res.errorCode =="SUC"){
                 $scope.bFinCustDsList = res.contextData;
                 for(var i=0;i<$scope.bFinCustDsList.length;i++)
                 {
                     var custds = $scope.bFinCustDsList[i];
                     var val1 = custds.colVal1;
                     custds.colVal1 = checkVal(val1);
                     if(custds.child)
                     {
                         var childVal1 = custds.child.colVal1;
                         var childVal2 = custds.child.colVal2;
                         custds.child.colVal1 = checkVal(childVal1);
                         custds.child.colVal2 = checkVal(childVal2);
                     }
                 }
                 $common.get_tipDialog('数据计算成功！','showSuccess');
             }else{
                 $common.get_tipDialog(res.errorMsg,'showError');
             };
        });
    }
    //正式保存
    $scope.confirm_onClick = function () {
        $scope.flowsubmitdisable = true;
        if($scope.bFinCustDsList.length==0)
        {
            $common.get_tipDialog('报表信息为空，请维护报表信息！','showInform');
            $scope.flowsubmitdisable = false;
            return;
        }
        $common.get_asyncData("bFinCustDsService/getList",{list:$scope.bFinCustDsList}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.bFinCustDs = res.contextData;
                //设置表单输入的数据modify by huangshuidan 2017-06-08
                $scope.bFinCustDsSubmitList=[];
                $scope.bFinCustDsSubmitList=new Array(0);
                setbFinCustDsList($scope.bFinCustDs,$scope.bFinCustDsSubmitList,$scope.otherform);
                //end by huangshuidan 2017-06-08
                //计算项根据公式进行计算
                var primisecal = $common.get_asyncData("bFinCustDsService/calCheck",{list:$scope.bFinCustDsSubmitList});
                primisecal.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.bFinCustDsList = res.contextData;
                        for(var i=0;i<$scope.bFinCustDsList.length;i++)
                        {
                            var custds = $scope.bFinCustDsList[i];
                            var val1 = custds.colVal1;
                            var val2 = custds.colVal2;
                            custds.colVal1 = checkVal(val1);
                            custds.colVal2 = checkVal(val2);
                            if(custds.child)
                            {
                                var childVal1 = custds.child.colVal1;
                                var childVal2 = custds.child.colVal2;
                                custds.child.colVal1 = checkVal(childVal1);
                                custds.child.colVal2 = checkVal(childVal2);
                            }
                        }
                        $common.get_asyncData("bFinCustDsService/getList",{list:$scope.bFinCustDsList}).then(function(res){
                            if (res.errorCode =="SUC"){
                                $scope.bFinCustDs = res.contextData;
                                //设置表单输入的数据modify by huangshuidan 2017-06-08
                                $scope.bFinCustDsSubmitList=[];
                                $scope.bFinCustDsSubmitList=new Array(0);
                                setbFinCustDsList($scope.bFinCustDs,$scope.bFinCustDsSubmitList,$scope.otherform);
                                //end by huangshuidan 2017-06-08
                                var primisecal = $common.get_asyncData("bFinCustDsService/chkCheck",{list:$scope.bFinCustDsSubmitList});
                                primisecal.then(function(res){
                                    if (res.errorCode =="SUC"){
                                        var data = res.contextData.value;
                                        if(data=="false")
                                        {
                                            $common.get_tipDialog("报表数据失衡，请重新输入！",'showError');
                                            $scope.flowsubmitdisable = false;
                                        }
                                        else if(data=="true")
                                        {
                                            var primise = $common.get_asyncData('bFinCustDsService/submit',{list:$scope.bFinCustDsSubmitList});
                                            primise.then(function(res){
                                                if (res.errorCode =="SUC"){
                                                    $common.get_tipDialog('录入保存成功！','showSuccess');
                                                    $state.go("cust");
                                                }else{
                                                    $common.get_tipDialog(res.errorMsg,'showError');
                                                    $scope.flowsubmitdisable = false;
                                                };
                                            });
                                        }
                                    }else{
                                        $common.get_tipDialog(res.errorMsg,'showError');
                                        $scope.flowsubmitdisable = false;
                                    };
                                });
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                                $scope.flowsubmitdisable = false;
                            };
                            $scope.flowsubmitdisable = false;
                        });
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                        $scope.flowsubmitdisable = false;
                    };
                    $scope.flowsubmitdisable = false;
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.flowsubmitdisable = false;
            };
            $scope.flowsubmitdisable = false;
        });
        $scope.flowsubmitdisable = false;
    };
    $scope.back_onClick = function(){
        $state.go("cust");
    };

    /**
     * 失去焦点计算相关计算项值
     * @param obj
     */
    $scope.checkNum = function(obj)
    {
        var nownum1 = document.getElementById(obj.subjId+"1").value;
        var nownum2;
        obj.colVal1 = Number(nownum1);
        if(obj.mdlId!='XJLL' && obj.mdlId!='CWZB'){
        	 nownum2 = document.getElementById(obj.subjId+"2").value;
        	 obj.colVal2 = Number(nownum2);
        }
        
        $common.get_asyncData("bFinCustDsService/getList",{list:$scope.bFinCustDsList}).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.bFinCustDs = res.contextData;
                var primisecal = $common.get_asyncData("bFinCustDsService/checkNum",{list:$scope.bFinCustDs,finDs:obj});
                primisecal.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.bFinCustDsList = res.contextData;
                        for(var i=0;i<$scope.bFinCustDsList.length;i++)
                        {
                            var custds = $scope.bFinCustDsList[i];
                            var val1 = custds.colVal1;
                            var val2 = custds.colVal2;
                            custds.colVal1 = checkVal(val1);
                            custds.colVal2 = checkVal(val2);
                            if(custds.child)
                            {
                                var childVal1 = custds.child.colVal1;
                                var childVal2 = custds.child.colVal2;
                                custds.child.colVal1 = checkVal(childVal1);
                                custds.child.colVal2 = checkVal(childVal2);
                            }
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
};
