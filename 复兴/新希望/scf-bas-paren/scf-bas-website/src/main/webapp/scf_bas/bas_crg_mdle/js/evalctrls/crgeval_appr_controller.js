/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var EvalApprController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {

    $scope.disable1 = true;
    $scope.disable = true;

    var data = dataDeliver.getter();
    //var appNo = data.appNo;
    //var conId = data.conId;
    //var gutId = data.gutId;
    //var processId =data.processId;
    //var modelId = data.modelId;

    $scope.firstform=dataDeliver.getter();//定义form对象

    $scope.selectMdlNms ={
        ds:[
        ]
    }

    var key = window.appNo;
    
    //信用评级卡赋值
    function bcrgEvalToValue(){
	    var promise = $common.get_asyncData("iBCrgEvalRecService/findExtBCrgEvalByKey",{key:key});
	    promise.then(function(res){
	        var data;
	        if (res.errorCode =="SUC"){
	            data = res.contextData;
	            $scope.evalform = data;
	            //$scope.evalform.cname = ;
	            var value ={bCrmBaseInfo:
	                            {custcd:$scope.evalform.rltId}
	                        }
	            $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",value).then(
	                function(res){
	                    if(res.errorCode=="SUC"){
	                        data = res.contextData;
	                        $scope.evalform.cname = data.cname;
	                    }
	                }
	            )
	            
	        }else{
	            $common.get_tipDialog(res.errorMsg,'showError');
	        }
	    });
    }
    var cardRes;
    
    init();
    

    function init(){
    	
    	bcrgEvalToValue();
    	
        $scope.evalMdls = [
            {mdlId:'1001',mdlNm:'评估模型1',salary:25000},
            {mdlId:'1002',mdlNm:'评估模型2',salary:18000},
            {mdlId:'1003',mdlNm:'评估模型3',salary:12000},
            {mdlId:'1004',mdlNm:'评估模型4',salary:9000},
            {mdlId:'1005',mdlNm:'评估模型5',salary:7000},
            {mdlId:'1006',mdlNm:'评估模型6',salary:5000}
        ];
        for(var i = 0;i<$scope.evalMdls.length;i++){
            $scope.selectMdlNms.ds[i] = {key:JSON.stringify(i),value:$scope.evalMdls[i].mdlNm};
        }

        $scope.cnameContent ={
            url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",
            type:"table",
            //params :{custcd:$scope.evalform.rltId},
            split:"-",
            extentColumn:["custcd"],
            column:["cname"]
        }

        $scope.doExtent =function(ds){
            $scope.evalform.cname = ds.cname;
            $scope.evalform.rltId = ds.custcd;
        }

        $scope.$watch("evalform.cname",function(){
            $scope.cnameContent.params ={
                custcd:$scope.evalform.rltId
            };
        });
        
      //初始化评分卡
        var tlrNoPrimise = $common.get_asyncData("iBCrgEvalRecService/findExtBCrgEvalByKey",{key:key});
        tlrNoPrimise.then(function(res){
        	var extdata= res.contextData;
        	if (res.errorCode =="SUC"){
                var extpromise = $common.get_asyncData('iBCrgEvalRecService/findBCrgEvalLevelInfo',{custNo:extdata.rltId});
                extpromise.then(function(extres){
                    if (extres.errorCode =="SUC"){
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
                		setDisabled();
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
    	$(".cogn_scr").text(extBCrgEval.cognScr);
    	$(".cogn_rslt").text(extBCrgEval.cognRslt);
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
    function calTotalScore(){
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
    
    function setDisabled(){
    	 var rules = $("#otherform select");
    	 rules.attr("disabled", true);
    }

    $scope.evalform={};



//debugger;
    $scope.premEvalform = {
        processId:''
    };

    var data ={};
    $scope.handelObj = data;

    $scope.otherform={};
    var flag = $scope.firstform.flag;
    var processId;

////////////////////////////////自定义函数///////////////////////////////////////////



};
