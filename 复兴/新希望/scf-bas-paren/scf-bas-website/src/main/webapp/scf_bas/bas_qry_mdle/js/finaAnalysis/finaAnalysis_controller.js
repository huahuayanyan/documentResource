/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var finaAnalysisController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
	   var deliverData = dataDeliver.getter();
	   $scope.otherform={
	    };
	   $scope.conditionForm ={};
	   $scope.incomedatasource = {// 初始化产品收入表格对象
		 ds : []
	   };
	   $scope.outcomedatasource = {// 初始化产品收入表格对象
		 ds : []
	 };
	   $scope.lossdatasource = {// 初始化产品收入表格对象
				 ds : []
		};
	   $scope.selected = {// 初始化对象
		 select : []
	   };
	   //系统当前日期
	    var date=new Date();
	    var y = date.getFullYear();
	    var m = date.getMonth() + 1;
	    var d = date.getDate();
	    if(m < 10){
	        m = "0" + m;
	    }
	    if(d < 10){
	        d = "0" + d;
	    }
	    var curDate = "" + y + m + d;
	    $scope.conditionForm.sumDate =curDate;
	 //进入页面时查询
	   $scope.$watch("",function() {
	        $scope.submit_onClick();
	    });
	 //点击查询之后的搜索
	    $scope.submit_onClick =function(){
	    	var sumDate= $scope.conditionForm.sumDate;
	    	if(sumDate==undefined||sumDate==""){
	    		  $common.get_tipDialog('请选择统计日期！','showInform');
	                return false;
	    	}
	    	getProductIncomeInfo();//产品收入饼图
	 	    getFinaSumInfo(); //汇总
	 	    getFinaInOutcomeBar();//收入支出矩形图
	 	    getProductIncomeList(); //产品收入列表
	 	    getProductOutcomeList(); //获得每月支出
	 	    getProductlossList();//获得损失金
	        //$scope.selected.select=[];
	    };
	    //重置按钮accountNo,accountType
	    $scope.rebort_onClick =function(){
	        $scope.$apply(function(){
	            $scope.conditionForm={};
	            $scope.selected.select=[];//清空选项s
	        })
	    };
	    
	    //获得产品收入
	    function getProductIncomeInfo(){
	    	var data = {
	                value : {
	                	sumDate:$scope.conditionForm.sumDate,
	                	finaType:"1"  //收入
	                	
	                }

	        };
	    	
	    	var promise = $common.get_asyncData("statisAnalysisService/getFinaProductIncome", data);
	        promise.then(function(res){
	        	var resData;
	            if (res.errorCode =="SUC"){
	                resData = res.contextData;
	                initProductEChart(resData); //产品收入
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	       }
	    
	    //获得汇总信息
	    function getFinaSumInfo(){
	    	var data = {
	                value : {
	                	sumDate:$scope.conditionForm.sumDate
	                	//finaType:"1"  //收入
	                	
	                }
	        };
	    	
	    	var promise = $common.get_asyncData("statisAnalysisService/getFinaSumStaAnalysisInfo", data);
	        promise.then(function(res){
	        	var resData;
	            if (res.errorCode =="SUC"){
	                resData = res.contextData;
	                $scope.otherform =resData;
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	       }
	    
	    
	    //获得收入支出
	    function getFinaInOutcomeBar(){
	    	var data = {
	                value : {
	                	sumDate:$scope.conditionForm.sumDate,
	                	finaTypes:["1","2"] //收入,支出
	                	
	                }
	        };
	    	
	    	var promise = $common.get_asyncData("statisAnalysisService/getFinaInOutcomeBar", data);
	        promise.then(function(res){
	        	var resData;
	            if (res.errorCode =="SUC"){
	                resData = res.contextData;
	                initInOutcomeEChart(resData); //收入，支出
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	       }
	    function initProductEChart(data){
	    	 var theme={

	    		       color : [
	    		           '#D87A80','#FFB980',
	    		           '#5AB1EF','#B6A2DE','#2EC7C9'//  //红，黄，蓝，紫，浅绿
	    		           ,"#B5C334",'#44ABCC','#7BC355',"#95706D" //青绿色，浅蓝，绿色，褐 
	    		           ,"#8D98B3","#CC99FF" //，灰，紫

	    		        ]

	    		    };
	    		    var myChart = echarts.init(document.getElementById('productChart'),theme);
	    		    option = {
	    		        tooltip : {
	    		            trigger: 'item',
	    		            formatter: "{a} <br/>{b} : {c} ({d}%)"
	    		        },
	    		        legend: {
	    		           // orient : 'vertical',
	    		            x : 'center',
	    		            itemWidth:15, //图例图像宽度 默认20
	    		            itemHight:10, //图例图像高度 默认14
	    		            textStyle:{
	    		                fontSize:8
	    		            }, //文本标签样式
	    		            //data:['担保贷款','应收账款抵押','应收账款质押','预付账款','设备质押']
	    		            
	    		            data:[]
	    		        },
	    		        toolbox: {
	    		            show : true,
	    		            feature : {
	    		                mark : {show: false}, //辅助线开关
	    		                dataView : {show: false, readOnly: false}, //数据视图
	    		                magicType : {   //动态类型切换
	    		                    show: false,
	    		                    type: ['pie', 'funnel']
	    		                },
	    		                restore : {show: false}, // 还原
	    		                saveAsImage : {show: false} //保存为图片
	    		            }
	    		        },
	    		        calculable : false,
	    		        series : [
	    		           /* {
	    		               name:'',
	    		                type:'pie',
	    		                center:['50%','55%'],
	    		                //radius : [100, 140],
	    		                radius : ['40%', '55%'],

	    		                // for funnel
	    		                x: '60%',
	    		                width: '35%',
	    		                funnelAlign: 'left',
	    		                max: 234,
	    		                itemStyle : {
	    		                    normal : {
	    		                        //颜色

	    		                        label : {
	    		                            position : 'inner',
	    		                            show:false,
	    		                           
	    		                        },
	    		                        labelLine : {
	    		                        	show:false
	    		                        }
	    		                    },
	    		            emphasis:{
    	                        label:{
    	                        	 position : 'center',
    	                        	 textStyle:{
 		                                fontSize:8
 		                            }, //文本标签样式
    	                            show:true
    	                        },
    	                        labelLine:{
    	                            show:false
    	                        }
    	                    }
	    		                },
	    		                
	    		                itemStyle:{
	    	                        normal:{
	    	                            llabel:{
		    	                            show:false
		    	                        },
		    	                        labelLine:{ //引导线
		    	                            show:false
		    	                        }
	    	                        },
	    	                        emphasis:{
		    	                        label:{
		    	                        	 position : 'inner',
		    	                            show:true
		    	                        },
		    	                        labelLine:{
		    	                            show:true
		    	                        }
		    	                    }
	    	                    },
	    	                   

	    		                data:[
	    		                    {value:25000, name:'担保贷款'},
	    		                    {value:10000, name:'应收账款抵押'},
	    		                    {value:25000, name:'应收账款质押'},
	    		                    {value:30000, name:'预付账款'},
	    		                    {value:4530, name:'设备质押'}

	    		                ]
	    		            }*/
	    		        ]
	    		    };
	    		    initProductData(option,data);
	    		    // 使用刚指定的配置项和数据显示图表。
	    		    myChart.setOption(option);
	    }
	    function initProductData(option,data){
	    	
	    	var Item = function(){
	    		return {
	    			 name:'',
		                type:'pie',
		                center:['50%','55%'],
		                //radius : [100, 140],
		                radius : ['40%', '55%'],

		                // for funnel
//		                x: '60%',
//		                width: '35%',
//		                funnelAlign: 'left',
//		                max: 234,
		                itemStyle:{
	                        normal:{
	                            llabel:{
 	                            show:false
 	                        },
 	                        labelLine:{ //引导线
 	                            show:false
 	                        }
	                        },
	                        emphasis:{
 	                        label:{
 	                        	 position : 'inner',
 	                            show:true
 	                        },
 	                        labelLine:{
 	                            show:true
 	                        }
 	                    }
	                    },

	    			data:[]
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
		    		//it.name = name;
		    		it.data = dataValus[i].seriesData;
		    		Series.push(it);
		    	}
	    	}
	    	
	    	legends = data.legendData;
			if (Series.length <= 0) {
				var it = new Item();
				Series.push(it);
			}
	    	//console.log(JSON.stringify(legends));
	    	//console.log(JSON.stringify(Series));
	    	option.legend.data=legends;
	    	option.series = Series;
	    	//重新加载图表'
	    	}  
	    
	    function initInOutcomeEChart(data){
	    	        var myChart = echarts.init(document.getElementById('incomeChart'));
	    	      
	    	        var option = {
	    	        	title : {
	    	                 text: '',
	    	                  x:'center' //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
	    	              },
	    	            tooltip : {
	    	                trigger: 'axis',
	    	                axisPointer:{ //坐标轴指示器，默认type为line
	    	                    type: 'none',
	    	                }    
	    	            },
	    	            color : [
	  	    	               '#60C0DD','#D87A80' //,'#9BBB59' //    蓝色，红色，绿色

	  	    	            ],
	    	            legend: {
	    	                orient : 'horizontal',//布局方式，默认为水平布局'horizontal'，可选为：'horizontal' | 'vertical'
	    	                x : 'center', 	//水平安放位置，默认为全图左对齐，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
	    	                y : 'bottom', //	垂直安放位置，默认为全图底部，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
	    	                data:['收入','支出']  //动态
	    	            
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
	    	                    // data : ['1月','2月','3月','4月','5月','6月']
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
	    	                              color: '#ccc',
	    	                              type: 'solid',
	    	                              width: 1
	    	                          }
	    	                      },
	    	                    
	    	                   data:['']  //动态X轴的定义
	    	                }
	    	            ],
	    	            yAxis : [
	    	                {
	    	                    type : 'value',
	    	                    axisLabel:{
	  	    	                	formatter:'￥{value}'
	  	    	                },
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

	    	                       /*{
	    	                            name:'收入',
	    	                            type:'bar',
	    	                            barGap:0,  //柱间距离，默认为柱形宽度的30%，可设固定值
	    	                           // barWidth:'20', //	柱条（K线蜡烛）宽度，不设时自适应
	    	                            data:[70000]
	    	                            
	    	                        },
	    	                        {
	    	                            name:'支出',
	    	                            type:'bar',
	    	                            data:[50000 ]
	    	                            
	    	                        }*/
	    	                    ]
	    	        };
	    	        // 为echarts对象加载数据
	    	        initInOutIncomeData(option,data);
	    	        myChart.setOption(option);
	    	      //console.log(JSON.stringify(option.legend.data));
	    	      //console.log(JSON.stringify(option.series));
	    }
	    function initInOutIncomeData(option,data){
	    	
	    	var Item = function(){
	    		return {
	    			name:'',
	    			type:'bar',
	    			barGap:0,  //柱间距离，默认为柱形宽度的30%，可设固定值
	    			//barWidth:'10', //	柱条（K线蜡烛）宽度，不设时自适应
	    			barMaxWidth:'40', //柱条（K线蜡烛）最大宽度，不设时自适应
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
	    	//option.xAxis[0].data= data.xaxisData;
	    	option.legend.data=legends;
	    	option.series = Series;
	    	//重新加载图表'	
	    	}  
	    
	    
	    //获得产品收入
	    function getProductIncomeList(){
	    	var data = {
	                value : {
	                	sumDate:$scope.conditionForm.sumDate,
	                	finaType:"1"  //收入
	                	
	                }
	        }
	    	
	    	var promise = $common.get_asyncData("statisAnalysisService/getFinaProductAmountInfo", data)
	        promise.then(function(res){
	        	var resData;
	            if (res.errorCode =="SUC"){
	                resData = res.contextData;
	                $scope.incomedatasource.ds=resData; //产品收入
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	       }
	    
	  //获得每月支出
	    function getProductOutcomeList(){
	    	var data = {
	                value : {
	                	sumDate:$scope.conditionForm.sumDate,
	                	finaType:"2"  //支出
	                	
	                }
	        }
	    	
	    	var promise = $common.get_asyncData("statisAnalysisService/getFinaProductInfodaList", data)
	        promise.then(function(res){
	        	var resData;
	            if (res.errorCode =="SUC"){
	                resData = res.contextData;
	                $scope.outcomedatasource.ds=resData; //支出
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	       }

	  //获得损失金
	    function getProductlossList(){
	    	var data = {
	                value : {
	                	sumDate:$scope.conditionForm.sumDate,
	                	finaType:"3"  //损失金
	                	
	                }
	        }
	    	
	    	var promise = $common.get_asyncData("statisAnalysisService/getFinaProductInfoList", data)
	        promise.then(function(res){
	        	var resData;
	            if (res.errorCode =="SUC"){
	                resData = res.contextData;
	                $scope.lossdatasource.ds=resData; //损失金
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	       }
	    
	    
	    $scope.homeBackHide =true;
	    var url = window.location.href;
	    if(url.indexOf("needBackFlag")!=-1){
	    	 $scope.homeBackHide = false;
	    }
	    //获得数据字典中配置的主页的URL
	   var mainPage ="";
	   mainPage = window.dictionary.main_pagePath.dataItems[0].dataVal;
	    //返回主页按钮
	    $scope.homeBack_onClick = function () {
	    	 if(mainPage&&mainPage!=undefined&&mainPage!=null&&mainPage!=""){
	    		//window.location.href =window._HTTP_IP_PORT+"scf_bas/bas_main_mdle/html/bmain_mdle.html";
	    		window.location.href =window._HTTP_IP_PORT+mainPage;
	    	}
	    };
};
