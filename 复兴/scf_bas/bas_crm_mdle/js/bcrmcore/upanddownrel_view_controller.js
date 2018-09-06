/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      DouJun
 * @version     1.0
 * Create at:   2017/5/18
 */
var UpanddownrelViewController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
	
	var deliverData = dataDeliver.getter();
	var bCrmUpanddownRel = {
			bCrmUpanddownRel : {
			coreCustcd : deliverData.bCrmBaseInfo.custno
		}
	};
	var promise = $common.get_asyncData("bCrmUpanddownRelService/findBCrmUpanddownRelByBCrm", bCrmUpanddownRel);
	
	 promise.then(function(res){
         var resData;
         if (res.errorCode =="SUC"){
        	 resData = res.contextData;
        	 initEChart(resData);
         }else{
             $common.get_tipDialog(res.errorMsg,'showError');
         }
	 });

	 function initEChart(data){
		var option={nodes:[],links:[]};
		initData(option, data);
		// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('custChart'));
		option = {
			backgroundColor : 'white',
			title : {
				x : 'right',
				y : 'bottom'
			},
			tooltip : {
				trigger : 'item',
				formatter : '{a} : {b}'
			},
			toolbox : {
				show : true,
				feature : {
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			legend : {
				x : 'left',
				data : [ '上游客户', '下游客户','']
			},
			series : [ {
				type : 'force',
				name : "网络",
				ribbonType : false,
				categories : [ {
					name : '',
					itemStyle : {
						normal : {
							color : 'rgb(250, 162, 162)'
						}
					}
				}, {
					name : '下游客户',
					itemStyle : {
						normal : {
							color : 'rgb(159, 213, 248)'
						}
					}
				}, {
					name : '上游客户',
					itemStyle : {
						normal : {
							color : 'rgb(179, 242, 202)'
						}
					}
				//symbol: 'diamond'
				} ],
				itemStyle : {
					normal : {
						label : {
							show : true,
							textStyle : {
								color : '#333'
							}
						},
						nodeStyle : {
							brushType : 'both',
							borderColor : 'rgba(255,215,0,0.4)',
							borderWidth : 1
						}
					},
					emphasis : {
						label : {
							show : false
						},
						nodeStyle : {
						},
						linkStyle : {}
					}
				},
				minRadius : 15,
				maxRadius : 25,
				gravity : 1.1,
				scaling : 1.2,
				draggable : true,
				linkSymbol : 'arrow',
				steps : 10,
				coolDown : 0.9,
				nodes : option.nodes,
				links : option.links
			} ]
		};

		myChart.on("forceLayoutEnd", function() {
		});
		//为echarts对象加载数据 
		myChart.setOption(option);
	 }
	 
	 
	 function initData(option, data){
			var hcname=deliverData.bCrmBaseInfo.cname,coreNode={
					category : 0,
					name : hcname,
					value : 10,
					custNo : deliverData.bCrmBaseInfo.custno,
					symbolSize : [ 30, 30 ],
					draggable: true,
					itemStyle : {
						normal : {
							label : {
								textStyle : {
									color : 'rgb(207, 65, 78)',
									fontWeight : 'bold'
								}
							}
						}
					}
				};
			option.nodes.push(coreNode);
			$.each(data,function(k,v){
				var categ = 0;
				if(v.coreRelationFlg === '01'){
					categ = 2;
				}else if(v.coreRelationFlg === '02'){
					categ = 1;
				}
				var node={
						category : categ,
						name : v.cname,
						custNo : v.custcd,
						value : 8,
						symbolSize : [ 20, 20 ],
						itemStyle : {
							normal : {
								label : {
									textStyle : {
										color : 'rgb(51, 166, 93)',
										fontWeight : 'bold'
									}
								}
							}
						}
					},link={
						target : v.cname,
						source : hcname,
						weight : 1,
						name : v.cname,
						itemStyle : {
							normal : {
								color : 'rgb(139, 242, 176)'
							}
						}
					};
				if(v.coreRelationFlg==='02'){
					link.itemStyle={
						normal : {
							color : 'rgb(134, 190, 226)'
						}
					},
					node.itemStyle={
							normal : {
								label : {
									textStyle : {
										color : 'rgb(57, 125, 182)',
										fontWeight : 'bold'
									}
								}
							}
						};
				}
				option.nodes.push(node);
				option.links.push(link);
			});
		}
	 
	 //返回按钮
     $scope.confuse_onClick=function(){
         $state.go("base");
     }
};
