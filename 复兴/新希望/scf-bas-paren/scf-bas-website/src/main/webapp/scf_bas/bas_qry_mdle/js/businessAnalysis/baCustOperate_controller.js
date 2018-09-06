/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      DouJun
 * @version     1.0
 * Create at:   2017/5/18
 */
var baCustOperateController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){

    var deliverData = dataDeliver.getter();
    getCoopPartMonthInfo();//获得采购月度信息
    getCoopPartHisYearInfo();  //获得采购历史年份信息
    getCoopPartYearInfo();  //获得销售本年度合作比
    getCoopPartMonthRadarInfo();//获得销售月度雷达图信息
    
    //获得采购月度信息
    function getCoopPartMonthInfo(){
    	var data = {
                value : {
                	custcd:deliverData.bCrmBaseInfo.custcd,
                	type:"1"  //采购
                	
                }
        };
    	
    	var promise = $common.get_asyncData("statisAnalysisService/getCoopPartMonthInfo", data);
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                initEnterpriseEChart(resData); //企业分析
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    
    //获得采购历史年份信息
    function getCoopPartHisYearInfo(){
    	var data = {
                value : {
                	custcd:deliverData.bCrmBaseInfo.custcd,
                	type:"1"  //采购
                	
                }
        };
    	
    	var promise = $common.get_asyncData("statisAnalysisService/getCoopPartHisYearInfo", data)
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                
                initIndustryEChart(resData); //行业分析
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    //获得销售本年度
    function getCoopPartYearInfo(){
    	var data = {
                value : {
                	custcd:deliverData.bCrmBaseInfo.custcd,
                	type:"2"   //销售
                	
                }
        };
    	
    	var promise = $common.get_asyncData("statisAnalysisService/getCoopPartYearInfo", data)
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                initYearAnalysisEChart(resData); //同比分析
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    //获得销售本年度月度信息
    function getCoopPartMonthRadarInfo(){
    	var data = {
                value : {
                	custcd:deliverData.bCrmBaseInfo.custcd,
                	type:"2"   //销售
                	
                }
        };
    	
    	var promise = $common.get_asyncData("statisAnalysisService/getCoopPartMonthRadarInfo", data);
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                initLinkAnalysisEChart(resData); //
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    //企业分析
    function initEnterpriseEChart(data){
        var theme={

            color : [
                //'#4F81BD','#C05061','#9BBB59','#8064A2' //蓝色，红色，绿色，紫色
               //'#8064A2','#4F81BD','#9BBB59' //紫色.蓝色，绿色
              // '#FF4C79','#2EC0E7','#E5CF0D' //    红色.蓝色，黄色  01
                //'#FF4C79','#2EC0E7','#8D98B3' //    红色.蓝色，黑  01
                '#2EC7C9','#B6A2DE','#008ACD' //浅绿、

            ]

        };
        var myChart = echarts.init(document.getElementById('enterpriseEChart'),theme);
      
        var option = {
        	title : {
                 text: '采购商集中度分析',
                  x:'center' //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
              },
            tooltip : {
                trigger: 'axis',
                axisPointer:{ //坐标轴指示器，默认type为line
                    type: 'none',
                } 
            },
            legend: {
                orient : 'vertical',//布局方式，默认为水平布局'horizontal'，可选为：'horizontal' | 'vertical'
                x : 'right', 	//水平安放位置，默认为全图左对齐，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                y : 'center', //	垂直安放位置，默认为全图底部，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
               // data:['A企业','B企业','C企业','A企业','C企业']
               // data:['A企业','B企业','C企业']  //静态
                data:[]  //动态
            
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false}, //'辅助线开关',
                    dataView : {show: false, readOnly: false}, //数据视图
                    magicType : {show: false, type: ['line', 'bar', 'stack', 'tiled']},//动态类型切换
                    restore : {show: false}, //还原
                    saveAsImage : {show: false}//保存为图片
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : true,//类目起始和结束两端空白策略，见下图，默认为true留空，false则顶头
                   axisLabel:{
                	   formatter:'{value}月'
                   },
                   axisLine : {    // 轴线
                       show: true,
                       lineStyle: {
                           color: '#ccc',
                           type: 'solid',
                           width:1
                       }
                   }
                   ,  splitLine : {
                       show:false,
                       lineStyle: {
                           color: '#333',
                           type: 'solid',
                           width: 1
                       }
                   }
                    // data : ['1月','2月','3月','4月','5月','6月']
                	//data:[]  //动态X轴的定义
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#ccc',
                            type: 'solid',
                            width:1
                        }
                    }
                }
            ],
            series : [
            /*    {
                   // name:'A企业',
                    type:'line',
                    symbol:'none', //，散点图	标志图形类型，默认自动选择（8种类型循环使用，不显示标志图形可设为'none'）
                    //stack: '总量',
                    data:[4.3, 2.5, 3.5, 4.5]
                },
                {
                   // name:'B企业',
                    type:'line',
                    symbol:'none',
                    // stack: '总量',
                    data:[2.3, 4.3, 1.8, 2.8]
                },
                {
                   // name:'C企业',
                    type:'line',
                    symbol:'none',
                    // stack: '总量',
                    data:[2,2,3,5]
                }*//*,
                {
                    name:'A企业',
                    type:'line',
                    symbol:'none',
                    stack: '总量',
                    data:[0, 0,0,0]
                },
                {
                    name:'C企业',
                    type:'line',
                    symbol:'none',
                    stack: '总量',
                    data:[0, 0,0,0]
                }*/
            ]
        };
        // 为echarts对象加载数据
        initEnterpriseData(option,data);
        myChart.setOption(option);
    }
   
    function initEnterpriseData(option,data){
    	
    	var Item = function(){
    		return {
    			name:'',
    			type:'line',
    			symbol:'none',
    			itemStyle:{
    				/*normal:{
    					areaStyle:{
    						type:'default',
    						opacity:isArea
    					}
    				},*/
    			label:{
    				normal:{
    					//show:isShowAllData,
    					position:'top'
    				}
    			},
    			markLine:{
    				data:{
    					type:'average',name:'平均值'
    				}
    			},
    			data:[]
    			}
    		}
    	};
    	//series 中的每一行为一个item,所有的属性都可在此定义
    	var legends =[];//存放图例数据
    	var Series =[];//存放图表数据
    	var dataValus = data.series;
    	if(dataValus!=undefined){
    		for(var i=0;i< dataValus.length;i++){
        		var it = new Item();
        		var name = dataValus[i].seriesName;
        		it.name = name;
        		legends.push(name);
        		it.data = dataValus[i].seriesDataValue;
        		Series.push(it);
        	}
    	}
        if (Series.length <= 0) {
            var it = new Item();
            Series.push(it);
        }
    	//legends = data.legendData;
    	//console.log(JSON.stringify(legends));
    	//console.log(JSON.stringify(Series));
    	//设置X轴
    	option.xAxis[0].data= data.xaxisData;
    	option.legend.data=legends;
    	option.series = Series;
    	//重新加载图表'	
    }   
    

  //采购方历史年份比较分析begin 
 //行业分析
    function initIndustryEChart(data){
        // 基于准备好的dom，初始化echarts图表
        var theme={
            color : [
               // '#4F81BD','#C05061','#9BBB59' //蓝色，红色，绿色
                //'#60C0DD','#D87A80','#9BBB59' //    蓝色，红色，绿色
                 '#B6A2DE','#2EC7C9','#5AB1EF' //浅紫，浅绿，绿色

            ]

        };
        var myChart = echarts.init(document.getElementById('industryEChart'),theme);
        var option = {
            title : {
                text: '采购量企业对比',
                x:'center' //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            },
            tooltip : {
                trigger: 'axis',
                axisPointer:{ //坐标轴指示器，默认type为line
                    type: 'none',
                } 
            },
            legend: {
                orient : 'vertical',//布局方式，默认为水平布局'horizontal'，可选为：'horizontal' | 'vertical'
                x : 'right', 	//水平安放位置，默认为全图左对齐，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                y : 'center', //	垂直安放位置，默认为全图底部，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                //data:['A企业','B企业','行业']
            	data:[]
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false},
                    dataView : {show: false, readOnly: false},
                    magicType : {show: false, type: ['line', 'bar']},
                    restore : {show: false},
                    saveAsImage : {show: false}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    axisLabel:{
                 	   formatter:'{value}年'
                    },
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#ccc',
                            type: 'solid',
                            width:1
                        }
                    },
                      splitLine : {
                        show:false,
                        lineStyle: {
                            color: '#333',
                            type: 'solid',
                            width: 1
                        }
                    },
                    //data:['2011年','2012','2013年','2014年']
                    
                    data:[]
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#ccc',
                            type: 'solid',
                            width:1
                        }
                    }
                }
            ],
            series : [

              /*  {
                    name:'A企业',
                    type:'bar',
                    data:[4.4, 2.5, 3.6,4.6 ],
                    barGap:0,  //柱间距离，默认为柱形宽度的30%，可设固定值
                    barWidth:'20' //	柱条（K线蜡烛）宽度，不设时自适应
                      markPoint : {
                     data : [
                     {type : 'max', name: '最大值'},
                     {type : 'min', name: '最小值'}
                     ]
                     },
                     markLine : {
                     data : [
                     {type : 'average', name: '平均值'}
                     ]
                     }
                },
                {
                    name:'B企业',
                    type:'bar',
                    data:[2.4, 4.5, 1.9,2.9 ]
                    // barCategoryGap:0  //柱间距离，默认为柱形宽度的30%，可设固定值
                         markPoint : {
                     data : [
                     {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                     {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                     ]
                     },
                     markLine : {
                     data : [
                     {type : 'average', name : '平均值'}
                     ]
                     }
                },
                {
                    name:'行业',
                    type:'bar',
                    data:[2, 2, 3,5 ]
                }*/
            ]
        };
        // 为echarts对象加载数据
        initIndustryData(option,data);
        myChart.setOption(option);
    }
    
 function initIndustryData(option,data){
    	
    	var Item = function(){
    		return {
    			name:'',
    			type:'bar',
    			barGap:0,  //柱间距离，默认为柱形宽度的30%，可设固定值
    			itemStyle:{
    				/*normal:{
    					areaStyle:{
    						type:'default',
    						opacity:isArea
    					}
    				},*/
    			label:{
    				normal:{
    					//show:isShowAllData,
    					position:'top'
    				}
    			},
    			markLine:{
    				data:{
    					type:'average',name:'平均值'
    				}
    			},
    			data:[]
    			}
    		}
    	};
    	//series 中的每一行为一个item,所有的属性都可在此定义
    	var legends =[];//存放图例数据
    	var Series =[];//存放图表数据
    	var dataValus = data.series;
    	if(dataValus!=undefined){
    		for(var i=0;i< dataValus.length;i++){
        		var it = new Item();
        		var name = dataValus[i].seriesName;
        		it.name = name;
        		legends.push(name);
        		it.data = dataValus[i].seriesDataValue;
        		Series.push(it);
        	}
    	}
     if (Series.length <= 0) {
         var it = new Item();
         Series.push(it);
     }
    	//legends = data.legendData;
    	//console.log(JSON.stringify(legends));
    	//console.log(JSON.stringify(Series));
    	option.xAxis[0].data= data.xaxisData;
    	option.legend.data=legends;
    	option.series = Series;
    	//重新加载图表'	
    	}   
    
 //采购方历史年份比较分析end
    //同比分析
    function initYearAnalysisEChart(data){
        var myChart = echarts.init(document.getElementById('yearAnalysisEChart'));
        var option = {
            title : {
                // show:true,
                text: '销售商占比',
                x:'center' //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            color : [
                     //'#4F81BD','#C05061','#9BBB59','#8064A2' //蓝色，红色，绿色，紫色
                    // '#4F81BD','#C05061','#9BBB59','#8064A2' //蓝色，红色，绿色，紫色

                    // '#D87A80','#8D98B3','#E5CF0D', //红 黑  黄
                    // '#2EC7C9',  '#B6A2DE','#60C0DD','#FFB980' //绿紫蓝黄9BBB59

                     //'#B6A2DE',  '#D87A80','#2EC7C9','#E5CF0D' //紫红蓝黄  0
                    // '#B6A2DE',  '#D87A80','#2EC7C9','#9BBB59' //紫红蓝黄  0

                     //'#60C0DD',  '#D87A80','#9BBB59' //,'#B6A2DE'//蓝色，红色，绿色，紫色
                     '#FFB980',  '#D87A80','#2EC7C9' // 浅黄、浅红、浅绿
                    // '#498DF3',  '#D34B1D','#37B845','#7200d8' //蓝色，红色，绿色，紫色

                     //'#60C0DD',  '#D87A80','#E5CF0D','#B6A2DE' //蓝色，红色，绿色，紫色
                 ],
            legend: {
                orient : 'vertical',//布局方式，默认为水平布局'horizontal'，可选为：'horizontal' | 'vertical'
                x : 'right', 	//水平安放位置，默认为全图左对齐，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                y : 'center', //	垂直安放位置，默认为全图底部，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                itemWidth: 20,//图例图形宽度 默认20
                itemHeight:14, //图例图形高度 默认14
                //data:['第一季度','第二季度','第三季度','第四季度']
                data:[]
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false}, //辅助线标志
                    dataView : {show: false, readOnly: false}, //数据视图
                    magicType : {  //动态类型切换
                        show: false,
                        type: ['pie', 'funnel']
                    },
                    restore : {show: false}, //还原
                    saveAsImage : {show: false} //保存图片
                }
            },
            calculable : false,
            series : [
			/*
                {
                    name:'',
                    type:'pie',
                    center: ['35%', '50%'], //圆心坐标
                    //radius : [100, 140],
                    //radius: ['40%', '55%'],

                    // for funnel
                    x: '60%',
                    width: '35%',
                    funnelAlign: 'left',
                    max: 234,
                    //图表样式
                    itemStyle:{
                        normal:{
                            label:{
                                show:false
                            }
                        }
                    },
                    emphasis:{
                        label:{
                            show:true
                        },
                        labelLine:{
                            show:true
                        }
                    },

                    data:[
                        {value:535, name:'第一季度'},
                        {value:234, name:'第二季度'},
                        {value:135, name:'第三季度'},
                        {value:110, name:'第四季度'}

                    ]
                }*/
            ]
        };
        initYearAnalysisData(option,data);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    
 function initYearAnalysisData(option,data) {

     var Item = function() {
         return {
             name:'',
             type:'pie',
             center: ['35%', '50%'], //圆心坐标
             //radius : [100, 140],
             //radius: ['40%', '55%'],

             // for funnel
             x: '60%',
             width: '35%',
             funnelAlign: 'left',
             max: 234,
             //图表样式
             itemStyle:{
                 normal:{
                     label:{
                         show:false
                     },
                     labelLine: {
                         show: false
                     }
                 }
             },
             emphasis: {
                 label: {
                     show: true
                 },
                 labelLine: {
                     show: true
                 }
             },

             data:[]
         }
     };
     //series 中的每一行为一个item,所有的属性都可在此定义
     var legends = [];//存放图例数据
     var Series = [];//存放图表数据
     var dataValus = data.series;
     if (dataValus != undefined) {
         for (var i = 0; i < dataValus.length; i++) {
             var it = new Item();
             var name = dataValus[i].seriesName;
             //it.name = name;
             it.data = dataValus[i].seriesData;
             Series.push(it);
         }
         legends = data.legendData;
         if (Series.length <= 0) {
             var it = new Item();
             Series.push(it);
         }
         //console.log(JSON.stringify(legends));
         //console.log(JSON.stringify(Series));
         option.legend.data = legends;
         option.series = Series;
         //重新加载图表'
     }
 }
    //环比分析
    function initLinkAnalysisEChart(data){
        var theme={

            color : [
                /*  '#D87A80','#8D98B3','#E5CF0D',
                 '#2EC7C9',  '#B6A2DE','#60C0DD','#FFB980'*/
                '#2EC7C9','#B6A2DE','#008ACD' //浅绿色，紫色，蓝色，
            ]

        };
        var myChart = echarts.init(document.getElementById('linkAnalysisEChart'),theme);
        option = {
            title : {
                text: '销售商分析',
                x:'center' ,
                subtext: ''
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                orient : 'vertical',
                x : 'right',
                y : 'center',
               // data:['行业A','行业B']
            	data:[]
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false},
                    dataView : {show: false, readOnly: false},
                    restore : {show: false},
                    saveAsImage : {show: false}
                }
            },
            polar : [
                {
                    indicator : [
                        { text: '经销量',  axisLabel: {show: true, textStyle: {fontSize: 14, color: '#333'}},max: 35},
                        { text: '利润率', max: 14},
                        { text: '应收帐款率', max: 21},
                        { text: '经营年限', max: 21},
                        { text: '资金实力', max:14},
                        { text: '合作紧密度', max:14}
                    ],
                      splitNumber:7 //分割段数，默认为5
                }
            ],
            calculable : true, //false是否启用拖拽重计算特性，默认关闭
            series : [
/* {
                	  name: '',
                    type: 'radar',
                     data : [
                        {
                            value : [33, 4, 10.5, 12, 13],
                            name : '行业A'
                        },
                        {
                            value : [12, 11, 15.5, 7, 4.5],
                            name : '行业B'
                        }
                    ]
                }*/
            ]
        };
        //var myChart = echarts.init(document.getElementById('myChart'));
        initLinkAnalysisData(option,data);
        myChart.setOption(option);
    }
    
function initLinkAnalysisData(option,data){
    	
    	var Item = function(){
    		return {
    			 name:'',
                 type:'radar',
    			data:[]
    		}
    	};
    	var legends =[];//存放图例数据
    	var Series =[];//存放图表数据
    	var dataValus = data.series;
    	if(dataValus!=undefined){
    		for(var i=0;i< dataValus.length;i++){
        		var it = new Item();
        		var name = dataValus[i].seriesName;
        		//it.name = name;  //与图例中的应不一致
        		it.data = dataValus[i].seriesData;
        		Series.push(it);
        	}	
    	}
    	legends = data.legendData;
    	//设置X轴
    	option.legend.data=legends;
    	option.series = Series;
    	//重新加载图表'
    }  
    
};
