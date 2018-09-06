/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2017/6/22
 */
var custCreditResultController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel,$q,$timeout){
	$scope.otherform={};
	var deliverData = dataDeliver.getter();
	checkLoad('custCreditChart');
    var stateUrl ="business.custCreditResult";
	getCustTagCloud();	//企业标签
	$scope.creditform={};
	var html_eleId;
	var bizFunName;
	/**
	 * 递归判断页面元素是否加载完成 加载完成，调用业务方法 未加载完成，继续递归至取到对应的标签对象后，调用业务方法
	 */
	function checkLoad(html_eleId) {
		var obj = document.getElementById(html_eleId);
		if (obj == null) {
			var deferred = $q.defer();
			var timer = $timeout(function() {
				deferred.resolve();
			}, 100, true);
			deferred.promise.then(function() {
				$timeout.cancel(timer);
				if (obj != null) {
					// 已经找到指定的html标签
					// 执行业务操作,可以考虑eval动态执行业务方法，暂时没有继续封装
					initEChart("");
				} else {
					// 递归调用，继续检查html标签是否加载完成
					checkLoad(html_eleId);
				}
			});
		} else {
			// 已经找到指定的html标签
			// 执行业务操作
			initEChart("");
			getcustCreditInfo(); //企业信用信息
		}
	}
		
    //获得客户信用评级
    function getcustCreditInfo(){
    	var data = {
                value : {
                	custcd:deliverData.bCrmBaseInfo.custcd
                }
        };
    	var promise = $common.get_asyncData("statisAnalysisService/getcustCreditInfo", data);
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                initEChart(resData); //企业分析
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    
	function initEChart(values) {
		var myChart = echarts.init(document.getElementById('custCreditChart'));
		option = {
			tooltip : {
				formatter : "{a} <br/>{b} : {c}%"
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : false
					},
					restore : {
						show : false
					},
					saveAsImage : {
						show : false
					}
				}
			},
			series : [ 
//			   {
//				name : '业务指标',
//				type : 'gauge',
//				splitNumber : 10, // 分割段数，默认为5
//				axisLine : { // 坐标轴线
//					lineStyle : { // 属性lineStyle控制线条样式
//						color : [ [ 0.2, '#2EC7C9' ], [ 0.8, '#5AB1EF' ],
//								[ 1, '#D87A80' ] ],
//						width : 8
//					}
//				},
//				axisTick : { // 坐标轴小标记
//					splitNumber : 10, // 每份split细分多少段
//					length : 12, // 属性length控制线长
//					lineStyle : { // 属性lineStyle控制线条样式
//						color : 'auto'
//					}
//				},
//				axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
//					textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
//						color : 'auto'
//					}
//				},
//				splitLine : { // 分隔线
//					show : true, // 默认显示，属性show控制显示与否
//					length : 30, // 属性length控制线长
//					lineStyle : { // 属性lineStyle（详见lineStyle）控制线条样式
//						color : 'auto'
//					}
//				},
//				pointer : {
//					width : 5
//				},
//				title : {
//					show : true,
//					offsetCenter : [ 0, '-40%' ], // x, y，单位px
//					textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
//						fontWeight : 'bolder'
//					}
//				},
//				detail : {
//					formatter : '{value}分',
//					textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
//						color : 'auto',
//						fontWeight : 'bolder'
//					}
//				},
//				data : [ {
//					value : 50,
//					name : '信用优秀'
//				} ]
//			} 
		 ]
		};
//		clearInterval(timeTicket);
//		timeTicket = setInterval(function (){
//		    option.series[0].data[0].value = (Math.random()*100).toFixed(2) - 0;
//		    myChart.setOption(option, true);
//		},2000);
//		option.series[0].data[0].value =90;
		initCustCreditData(option,values);
		myChart.setOption(option);
	}
	 /**
	  * 初始评级数据
	  */
	function initCustCreditData(option,data){
		var Item = function(){
   		return {
			name : '业务指标',
			type : 'gauge',
			splitNumber : 10, // 分割段数，默认为5
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, '#2EC7C9' ], [ 0.8, '#5AB1EF' ],
							[ 1, '#D87A80' ] ],
					width : 8
				}
			},
			axisTick : { // 坐标轴小标记
				splitNumber : 10, // 每份split细分多少段
				length : 12, // 属性length控制线长
				lineStyle : { // 属性lineStyle控制线条样式
					color : 'auto'
				}
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					color : 'auto'
				}
			},
			splitLine : { // 分隔线
				show : true, // 默认显示，属性show控制显示与否
				length : 30, // 属性length控制线长
				lineStyle : { // 属性lineStyle（详见lineStyle）控制线条样式
					color : 'auto'
				}
			},
			pointer : {
				width : 5
			},
			title : {
				show : true,
				offsetCenter : [ 0, '-40%' ], // x, y，单位px
				textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					fontWeight : 'bolder'
				}
			},
			detail : {
				formatter : '{value}分',
				textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					color : 'auto',
					fontWeight : 'bolder'
				}
			},
   			data:[]
   		}
   	};
   	//series 中的每一行为一个item,所有的属性都可在此定义
   	var Series =[];//存放图表数据
   	var dataValus = data.series;
   	if(dataValus!=undefined){
   		for(var i=0;i< dataValus.length;i++){
       		var it = new Item();
       		it.data = dataValus[i].seriesDatas;
       		Series.push(it);
       	}
   	}
   	//console.log(JSON.stringify(legends));
   	console.log(JSON.stringify(Series));
   	//option.legend.data=legends;
   	option.series = Series;
		 if(data.mapParam!=undefined){
			 $scope.creditform.creditDate =data.mapParam.creditDate;
		 }

	}
	
	
    //获得 企业云标签
    function getCustTagCloud(){
    	var data = {
                value : {
                	custcd:deliverData.bCrmBaseInfo.custcd
                }
        };
    	var promise = $common.get_asyncData("statisAnalysisService/getCustTagCloudRel", data)
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                for(var i = 0; i < resData.length; i++){
                	var tag = resData[i];
                	var colNum = i % 6 + 1;
                	var tagHtml = '<a href="#" class="acolor'+ colNum +'">'+ tag.tagCode + ':' + (tag.tagValue ? tag.tagValue : '') +'</a>';
                	$("#div1").append(tagHtml);
                }
                $("#div1").windstagball({
        			radius : 120,
        			speed : 5
        		});
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    
    //财报查看
	$scope.custFinView = function (){
		//通过cust获得客户财报记录表年报的最新的一条记录
		var data={
			custId:deliverData.bCrmBaseInfo.custcd
		};
		var promise = $common.get_asyncData("bFinCustService/findBFinCustByCustId", data);
		promise.then(function(res){
			var resData;
			if (res.errorCode =="SUC"){
				resData = res.contextData;
				//财报记录ID
				 var finId= resData.finId;
				if(finId&&finId!=undefined&&finId!=null&&finId!=""){
					$.extend(deliverData,res.contextData); //合并
					deliverData.stateUrl=stateUrl;
					$state.go("custFin");
					dataDeliver.setter(deliverData);
				}else{
					$common.get_tipDialog('该客户暂无财报相关的信息！','showInform');
					return false;
				}

			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
     };
	//财报查看
	$scope.custCreditView = function (){
		//通过custID获得评估记录
		var data={
			bCrmEntInfo:{
				custcd:deliverData.bCrmBaseInfo.custcd
			}
		};
		//获得评估流水号
		var evalId;
		var promise = $common.get_asyncData("bCrmEntInfoService/findBCrmEntInfoByKey", data);
		promise.then(function(res){
			var resData;
			if (res.errorCode =="SUC"){
				resData = res.contextData;
				evalId = resData.creditId;
				if(evalId&&evalId!=undefined&&evalId!=null&&evalId!=""){
					var value ={
						key:evalId
					};
					getCrgEvalRecinfo(value);
				}else{
					$common.get_tipDialog('该客户暂无评级相关的信息！','showInform');
					return false;
				}

			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};
	//根据评估流水号获得评估记录
	function getCrgEvalRecinfo(data){
		var promise = $common.get_asyncData("iBCrgEvalRecService/findCrgEvalRecByKey", data);
		promise.then(function(res){
			if (res.errorCode =="SUC"){
				var extBCrgEval = res.contextData;
				var setdata = {
					extBCrgEval : extBCrgEval
				};
				$.extend(deliverData,setdata); //合并
				deliverData.stateUrl=stateUrl;
				$state.go("custCrgevalView");
				dataDeliver.setter(deliverData);
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	}

	 // 返回按钮
     $scope.confuse_onClick=function(){
         $state.go("base");
     }
};
