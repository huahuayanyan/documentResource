/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var tabupdateController = function($scope,$common,$state,dataDeliver){

	var data = dataDeliver.getter();
	
    $scope.updateform={};
    $scope.evalMdls=[];

    $scope.userInfo={}
    $scope.selectClientNms = {ds:[]};
    $scope.bCrmBaseInfo={ds:[]};
    $scope.selectUpdtMdlNms ={
        ds:[
        ]
    }

    $scope.thisBrNo ='';

    init();
    ////*****************初始化结束********************////

    var cardRes;
    
    function init(){
        $scope.evalMdls =
            [
                {mdlId:'1001',mdlNm:'评估模型1',salary:25000},
                {mdlId:'1002',mdlNm:'评估模型2',salary:18000},
                {mdlId:'1003',mdlNm:'评估模型3',salary:12000},
                {mdlId:'1004',mdlNm:'评估模型4',salary:9000},
                {mdlId:'1005',mdlNm:'评估模型5',salary:7000}
            ];


        for(var i = 0;i<$scope.evalMdls.length;i++){
            $scope.selectUpdtMdlNms.ds[i] = {key:JSON.stringify(i),value:$scope.evalMdls[i].mdlNm};
        }


        //$scope.updateform=$common.copy($scope.selected.select[0]);

        $scope.updateform=$common.copy(data.extBCrgEval);

        $scope.userInfo = userInfo;

        var myDate = new Date();
        var curDateStr = myDate.toISOString().split("T")[0];
        var curDateStrArray =  curDateStr.split("-");
        var curDateStrCombine ="";
        for(var i = 0;i<curDateStrArray.length;i++){
            curDateStrCombine =curDateStrCombine+ (curDateStrArray[i]);
        }


        //var tlrNoPrimise = $common.get_asyncData('iBCrgEvalRecService/getBrNo');
        //tlrNoPrimise.then(function(res){
        //    if (res.errorCode =="SUC"){
        //        //alert(JSON.stringify(res.contextData));
        //        $scope.thisBrNo = res.contextData.value;
        //
        //        $scope.updateform.lastUpdTlr = userInfo.tlrName;
        //        $scope.updateform.lstUpdBrCd = $scope.thisBrNo;
        //        $scope.updateform.lstUpdDt = curDateStrCombine;
        //        $scope.bCrmBaseInfo = $scope.bCrmBaseInfo;
        //    }else{
        //        $common.get_tipDialog(res.errorMsg,'showError');
        //    }
        //});


        for(var i=0;i<$scope.bCrmBaseInfo.ds.length;i++){
            $scope.selectClientNms.ds[i] = {value:$scope.bCrmBaseInfo.ds[i].cname,key:JSON.stringify(i+1)};
        }

        //初始化评分卡
        var tlrNoPrimise = $common.get_asyncData("iBCrgEvalRecService/findExtBCrgEvalByKey",{key:data.extBCrgEval.evalId});
        tlrNoPrimise.then(function(res){
        	if (res.errorCode =="SUC"){
        		var extdata = res.contextData;
                var extpromise = $common.get_asyncData('iBCrgEvalRecService/findBCrgEvalLevelInfo',{custNo:extdata.rltId});
                extpromise.then(function(extres){
                    if (res.errorCode =="SUC"){
                        cardRes = extdata.cardRes;
                        cardRes = JSON.parse(cardRes);
                        var data = extres.scubeBody.contextData.data;
                		data = data.replace('"{','{');
                		data = data.replace('}"','}');
                		data = JSON.parse(data);
                		var variableName = data.value.functionAction.variable.variableName;
                		var result = {};
                		var resList = [];
                		var scoreCards = data.value.scoreCard;
                		for(var i = 0 ; i < scoreCards.length; i++){
                			var resData = {};
                			var scoreCard = scoreCards[i];
                			var desc = scoreCard["@desc"];
                    		var enname = scoreCard["@name"];
                    		var remark = desc;
                    		if(desc.indexOf("#") != -1){
                    			enname = desc.split("#")[1];
                    			remark = desc.split("#")[0];
                    		}
                			resData.cn = scoreCard["@name"];
                			//resData.en = scoreCard["@id"];
                			resData.en = enname;
                			var rule = cardRes[enname];
                			if(rule !== undefined && rule !== "undefined"){
                				resData.write = rule.write;
                				if(resData.write === 'false'){
                    				resData.eval = rule.value;
                    			}
                			}
                			resData.remark = remark;
                			resData.weight = scoreCard["@percent"];
                			var contents = scoreCard.content;
                			var list = []; 
                			for(var j = 0; j < contents.length; j++){
                				var content = contents[j];
                				if(content.length === 2){
                					var rec = {};
                					var record1 = content[0];
                					rec.name = record1.value;
                					var record2 = content[1];
                					rec.value = record2.value;
                					if(resData.write == 'false'){
                						var levVal = cardRes[enname];
                						if(rec.name == levVal.value){
                							resData.score = calScore(resData.weight, rec.value);
                							rec.selected = 'true';
                						}
                					}else{
                						resData.score = parseFloat(0).toFixed(2);
                					}
                					list.push(rec);
                				}
                				if(content.length === 3){
                					var rec = {};
                					resData.flag='2';
                					var record1 = content[0];
                					var record2 = content[1];
                					var record3 = content[2];
                					var name = "【" + record1.value + "，" + record2.value + "】";
                					if(record1.value === undefined){
                						name = "【 ，" + record2.value + "】";
                					}
                					if(record2.value === undefined){
                						name = "【" + record1.value + "， 】";
                					}
                					
                					rec.name = name;
                					rec.name1 = record1.value||"";
                					rec.name2 = record2.value||"";
                					rec.value = record3.value;
                					if(resData.write == 'false'){
                						var levVal = cardRes[enname];
                						levVal = parseInt(levVal.value);
                						if(rec.name1){
                							var low = parseInt(rec.name1);
                							if(rec.name2){
                								var high = parseInt(rec.name2);
                								//值为[a,b]
                								if(levVal >= low && levVal < high){
                									resData.score = calScore(resData.weight, rec.value);
                									rec.selected = 'true';
                								}
                							}else{
                								//值为[a,]
                								if(levVal >= low){
                									resData.score = calScore(resData.weight, rec.value);
                									rec.selected = 'true';
                								}
                							}
                						}else{
                							//值为[,a]
                							var high = parseFloat(rec.name2);
                							if(levVal < low){
                								resData.score = calScore(resData.weight, rec.value);
                								rec.selected = 'true';
                							}
                						}
                					}else{
                						resData.score = parseFloat(0).toFixed(2);
                					}
                					list.push(rec);
                				}
                			}
                			resData.list = list;
                			resList.push(resData);
                		}
                		result[variableName] = resList;
                		crgveallevel(result);
                		handlerInputValue();
                		calTotalScore();
                		crgevalToValue(extdata);
                    }else{
                    	$common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
        	}else{
        		$common.get_tipDialog(res.errorMsg,'showError');
        	}
        });
    }
    
    function crgevalToValue(extBCrgEval){
    	$(".crgeval-score").text(extBCrgEval.evalScr);
    	$(".crgeval-level").text(extBCrgEval.evalRslt);
    	$(".cogn_scr").val(extBCrgEval.cognScr);
    	$.each($(".cogn_rslt option"),function(i,v){
    		if($(this).text() === extBCrgEval.cognRslt){
    			$(".cogn_rslt").val($(this).val());
    			return false;
    		}
    	});
    }
    
    //计算得分数（值*权重）
    function calScore(weight, score){
    	if(score === undefined || score === "" || score === "undefined"){
    		score = 0.00;
    	}
    	if(weight.indexOf("%") != -1){
			var index = weight.indexOf("%");
			weight = weight.substr(0,index)/100;
		}
    	score = parseFloat(score) * parseFloat(weight);
    	score = parseFloat(score).toFixed(2);
    	return score;
    }
    
    //计算得分
    function calTotalScore(callback){
        var totalScore = 0.00;//总得分
        var scores = $(".crgevalres");
        $.each(scores,function(i,v){
        	var value = $(this).text();
        	//计算得分
    		if(value === "" || value === "undefined"){
    			value = 0;
    		}
    		//计算总得分
    		totalScore = parseFloat(totalScore) + parseFloat(value);
        	
        });
        
        //赋值总等分
        $(".crgeval-score").text(parseFloat(totalScore).toFixed(2));
        
        totalScore = parseInt(totalScore);
        
        //获取评分等级
		var promiseLevel = $common.get_asyncData('iBCrgEvalRecService/getCrgEvalLevel', {totalScore:totalScore});
		promiseLevel.then(function(res){
	        if (res.errorCode =="SUC"){
	        	var crgevallevel = res.contextData.value;
	        	$(".crgeval-level").text(crgevallevel);
	        	if(callback){
	        		callback();
	        	}
	        }else{
	            $common.get_tipDialog(res.errorMsg,'showError');
	        }
	    });
                
    }
    
    //回现手动输入的值
    function handlerInputValue(){
        var rules = $("#otherform select");
        $.each(rules,function(i,v){
        	var id = $(this).parents(".form-group").siblings().first().attr("id");
        	var record = cardRes[id];
    		$(this).val(record.value);
        	//计算得分
    		var weight = $(this).parents(".form-group").prev().find("span:last").text();
    		var value = calScore(weight, record.value);
    		$(this).parents(".form-group").next().find("span:last").empty().append(value);
        });
        
        //添加高亮选中效果
        $.each(rules,function(i,v){
        	var selectedIndex = $("option:selected", this)[0].index;
    		if(selectedIndex > 0){
    			$(this).parents(".form-group").nextAll("ul").children().eq(selectedIndex).addClass("rule-selected");
    		}
        });
    }
    
    
    $("#otherform").on("change", ".form-group select", function(){
		//给选中的加分项添加样式
		$(this).parents(".form-group").nextAll("ul").children().removeClass("rule-selected");
		var selectedIndex = $("option:selected", this)[0].index;
		if(selectedIndex > 0){
			$(this).parents(".form-group").nextAll("ul").children().eq(selectedIndex).addClass("rule-selected");
		}
		
		//计算得分
		var weight = $(this).parents(".form-group").prev().find("span:last").text();
		var value = $(this).val();
		value = calScore(weight, value);
		$(this).parents(".form-group").next().find("span:last").empty().append(value);
		
		//计算总得分
		calTotalScore();
    });
    

    //*************初始化结束**************//

    $scope.confirmUpdt_onClick = function(){

        if($.doValidate("updateform") && ruleValidate()) {
        	if(!$(".crgeval-score").text()||parseFloat($(".crgeval-score").text())<=0){
        		$common.get_tipDialog("模型得分必须大于0", "showWarning");
        		return false;
        	}
        	if(!$(".crgeval-level").text()){
        		$common.get_tipDialog("信用等级不能为空", "showWarning");
        		return false;
        	}
            if($scope.updateform.stat=="004"){
                $scope.updateform.stat="005";
            }
            
            var ruleContent = getRuleJSON();
        	var bCrgEvalRec = $scope.updateform;
        	bCrgEvalRec.cardRes = ruleContent;
        	bCrgEvalRec.evalScr = $(".crgeval-score").text();
        	bCrgEvalRec.evalRslt = $(".crgeval-level").text() === "" ? "C" : $(".crgeval-level").text();
        	bCrgEvalRec.cognScr = $(".cogn_scr").val() === "" ? "" : $(".cogn_scr").val();
        	bCrgEvalRec.cognRslt = $(".cogn_rslt option:selected").text();

            var primise = $common.get_asyncData('iBCrgEvalRecService/update',{"bCrgEvalRec":bCrgEvalRec});
            primise.then(function(res){
                if (res.errorCode =="SUC"){

                   // $scope.queryTable();
                   // $scope.selected.select=[];
                   // $scope.closeThisDialog();

                    $common.get_tipDialog('更新成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };

    //****开始其他函数逻辑******
    $scope.chooseMdlNm = function(){
        var index = updateform.mdlNm.value;
        var  theMdlId = $scope.evalMdls[index].mdlId;
        $scope.updateform.mdlId = theMdlId;
    };


    $scope.updtEval_onClick = function(){

//        var index = updateform.mdlNm.value;
//        var salary = $scope.evalMdls[index].salary;
//        var primise = $common.get_asyncData('iBCrgEvalRecService/executeRules',{salary:salary});
//        primise.then(function(res){
//            if (res.errorCode =="SUC"){
//                var evalResult = res.contextData;
//                $scope.updateform.evalScr = evalResult[1];
//                $scope.updateform.evalRslt = evalResult[0];
//                $common.get_tipDialog('调用规则引擎，执行成功！','showInform');
//            }else{
//                $common.get_tipDialog(res.errorMsg,'showError');
//            }
//        });
    	calTotalScore(function(){
    		$common.get_tipDialog('评估成功！','showInform');
    	});
    }


    $scope.selectCname =function(){
        var index =otherform.cname.value;
        var cnameVal = $scope.bCrmBaseInfo.ds[index].cname;
        var custcd = $scope.bCrmBaseInfo.ds[index].custcd;
        $scope.otherform.orgCode = cnameVal;
        $scope.otherform.custcd = custcd;
    };

    
    $scope.updtSbmt_onClick = function(){
        if($.doValidate("updateform") && ruleValidate()) {
        	if(!$(".crgeval-score").text()||parseFloat($(".crgeval-score").text())<=0){
        		$common.get_tipDialog("模型得分必须大于0", "showWarning");
        		return false;
        	}
        	if(!$(".crgeval-level").text()){
        		$common.get_tipDialog("信用等级不能为空", "showWarning");
        		return false;
        	}
            if($scope.updateform.stat =="000"||!$scope.updateform.stat){
                var params ={
                    processModel:{
                        modelId: 'creditEvalPrcssCreate',
                        ProcessName: '信用评估流程创建',
                        NodeId: 'credictEvalNode1',
                        startedUserId: userInfo.tlrNo,
                        bizId: $scope.updateform.evalId,
                        bizData: [
                            $scope.updateform.evalId,
                            $scope.updateform.rltId,
                            $scope.updateform.cname,
                            'creditEvalPrcssCreate'
                        ]
                    },
                    bCrgEvalRec:$scope.updateform
                }
                var primise = $common.get_asyncData('iBCrgEvalRecService/submit', params);
                primise.then(function(res){
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('发起成功！', 'showSuccess');
                        //parentScope.queryTable();
                       // $scope.evalform.stat ="001"
                        $scope.disable2 = true;
                        //$scope.closeThisDialog();
                    } else {
                        $common.get_tipDialog('发起失败!' + res.errorMsg, 'showError');
                    }
                });
            }else{
                $common.get_tipDialog("已经提交该记录",'showInform');
            }
        }
    }
    
    $scope.confuse_onClick=function(){
        $state.go("list");
    }
    
    function ruleValidate(){
    	var flag = true;
    	$.each($(".requied"),function(i,v){
    		var value = $(v).val();
    		var name = $(v).parents(".form-group").siblings().first().find("span:eq(1)").text().substr(1);
    		if(value === "" || value === "undefined"){
    			$(this).focus();
    			$common.get_tipDialog(name + "必须有值", "showWarning");
    			flag = false;
    			return false;
    		}
    	})
    	return flag;
    }
    
    function getRuleJSON(){
    	var ruleContents = $("#otherform select");
    	var ruleJSON = {};
    	for(var k in cardRes){
    		var card = cardRes[k];
    		var key = card.key;
    		var value = card.value;
    		var rule = {key: k,write:'true',value:value};
    		ruleJSON[key] = rule;
    		
    	}
    	$.each(ruleContents, function(i,v){
    		var key = $(this).parents(".form-group").siblings().first().attr("id");
    		var canwrite = 'true';
    		var value = $(this).val();
    		var rule = {key: key,write:canwrite,value:value};
    		ruleJSON[key] = rule;
    	});
    	return ruleJSON;
    }


};
