/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2017/1/22
 */

var scfmainController = function($scope,$common,$state,dataDeliver,$interval) {
    //获取系统时间
    var getSystime = function(){
        $common.get_asyncData("sysTimeService/selectSystemTime").then(function(res){
            if(res.errorCode=="SUC"){
                var timestamp = parseInt(res.contextData.value);
                //立即设置系统时间
                //$scope.myTime = new Date(timestamp).toLocaleString().replace(/\//g,"-")
               // $scope.myTime = new Date(timestamp).toLocaleDateString();
                var mydate = new Date(timestamp);
                var Y = mydate.getFullYear();
                var M =(mydate.getMonth()+1<10?'0'+(mydate.getMonth()+1):mydate.getMonth()+1);
                var D =mydate.getDate();
                $scope.myTime = Y+M+D;
                //每隔1秒循环系统时间(label)
                //mytimeInt = $interval(function () {
                //    timestamp+=1000;
                //    $scope.myTime = new Date(timestamp).toLocaleString().replace(/\//g,"-")
                //},1000);
                getFinaSumInfo(); //汇总
                getProductIncomeList();
                getProductPieChart();//饼图
            }
            //else {
            //    //本地时间
            //    //$scope.myTime=new Date().toLocaleString();
            //    $common.get_tipDialog(res.errorMsg||'获取系统时间失败！','showError')
            //}
        })
    }
    getSystime();
    //每隔5分钟更新系统时间
    $interval(function () {
        //取消label
        //$interval.cancel(mytimeInt)
        getSystime();
    },7200000);
    //业务处理  begin
    $scope.taskform={};
    $scope.conf={
    		pageNo:1,
    		pageSize:10
    };
    getUnTakeTask();//待办任务笔数
    queryTaskDtlCount();//获得审批通过，已驳回，已拒绝的笔数
    //查询 待办任务笔数
    function getUnTakeTask(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize
        };
        var promise = $common.get_asyncData("bSysTaskService/queryTaskListByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                //$scope.datasource.ds = data.records;
                $scope.taskform.unTake = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    function queryTaskDtlCount(){
        var data= {
        };
        var promise = $common.get_asyncData("bSysTaskService/queryTaskDtlCount",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $.extend( $scope.taskform,data); //合并
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //业务处理  end
    // 公告begin
    $scope.infoPublishform={};
    getInfoPublish();
    //获得最后发布的一条记录
    function getInfoPublish(){
        var data= {
            pageNo: 1,
            pageSize: 1
        };
        var promise = $common.get_asyncData("bSysInfoPublishMngService/findBSysInfoPublishMngByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.infoPublishform = data.records[0];

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    // 公告end
    //统计分析 begin
    
    //获得产品收入饼图
    function getProductPieChart(){
    	var data = {
                value : {
                	sumDate:$scope.myTime,
                	finaType:"1"  //收入
                	,index:6
                }

        };
    	
    	var promise = $common.get_asyncData("statisAnalysisService/getFinaProductIncome", data);
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                //判断是否有数据有初始化,无显示默认的，避免无数据时图形不显示
              	var dataValus = resData.series;
              	if(dataValus!=undefined&&dataValus.length>0){
                    initProductEChart(resData); //产品收入
              	}
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    function initProductEChart(data){
    	var theme={
 		       color : [
 		            '#2EC7C9','#B6A2DE','#60C0DD','#FFB980', '#5AB1EF','#B5C334',
 		          
 		           '#D87A80','#8D98B3','#E5CF0D'//内环
 		      
 		        ]
 		
 		    };
     		var myChart = echarts.init(document.getElementById('myChart'),theme);
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
 		            //data:['池余额','应收账款','应收租金','押品价值']
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
// 		            {
// 		                name:'', //内环
// 		                type:'pie',
// 		                center:['50%','55%'],
// 		                selectedMode: 'single',
// 		                //radius : [0, 60],
// 		                radius : [0, '30%'],
// 		
// 		                // for funnel
// 		              /*  x: '20%',
// 		                width: '40%',
// 		                funnelAlign: 'right',
// 		                max: 1148,*/
// 		
// 		                itemStyle : {
// 		                    normal : {
// 		                        //颜色
// 		
// 		                        label : {
// 		                            position : 'inner',
// 		                            textStyle:{
// 		                                fontSize:8
// 		                            } //文本标签样式
// 		
// 		                        },
// 		                        labelLine : {
// 		                            show : false
// 		                        }
// 		                    }
// 		                },
// 		                data:[
// 		                    {value:535, name:'预付类'},
// 		                    {value:679, name:'存货类'},
// 		                    {value:1148, name:'应收类'}
// 		
// 		                ]
// 		            },
// 		            {
// 		               name:'',
// 		                type:'pie',
// 		                center:['50%','55%'],
// 		                //radius : [100, 140],
// 		                radius : ['40%', '55%'],
// 		
// 		                // for funnel
// 		             /*   x: '60%',
// 		                width: '35%',
// 		                funnelAlign: 'left',
// 		                max: 234,*/
// 		
// 		                data:[
// 		                    {value:335, name:'池余额'},
// 		                    {value:310, name:'应收账款'},
// 		                    {value:234, name:'应收租金'},
// 		                    {value:135, name:'押品价值'}
// 		
// 		                ]
// 		            }
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
	                //radius :[],

	                // for funnel
//	                x: '60%',
//	                width: '35%',
//	                funnelAlign: 'left',
//	                max: 234,
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
	    		if(i==0){ //内环
	    			it.radius=[0, '30%'];
	    			it.selectedMode='single';
	    			it.itemStyle={
 		                    normal : {
		                        //颜色
		                        label : {
		                            position : 'inner',
		                            textStyle:{
		                                fontSize:8
		                            } //文本标签样式
		
		                        },
		                        labelLine : {
		                            show : false
		                        }
		                    }
		                }
	    		}
//	    		else{
//	    			it.radius=['40%', '55%'];
//	    		}
	    		//var name = dataValus[i].seriesName;
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
   
 

    //汇总信息
   $scope.otherform={};
    function getFinaSumInfo(){
        var data = {
            value : {
                sumDate:$scope.myTime
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
    //收入
    $scope.productIncomeList=[];

    //获得产品收入列表
    function getProductIncomeList(){
        var data = {
            value : {
                sumDate:$scope.myTime,
                finaType:"1"  //收入
                ,index:6//获取结果集的前几条记录

            }
        };

        var promise = $common.get_asyncData("statisAnalysisService/getFinaProductAmountInfo", data);
        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                $scope.productIncomeList=resData;//产品收入
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //统计分析 end
    //预警信息 begin
    getWarnHighCharts();
    var waringUrl =[];
    function getWarnHighCharts(){
        var data ={
        		 value : {index:5} //获取结果集的前几条记录
        };
        var promise = $common.get_asyncData("statisAnalysisService/getWarningsHighCharts", data);

        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                initWarnEChart(resData); //

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //预警信息图表展示
    function initWarnEChart(data){
        var warnChartTheme={
            color : [
                '#23bfaa','#9bbb58','#d38483'
            ]
        };
        var warnChart = echarts.init(document.getElementById('warnChart'),warnChartTheme);
        warnoption = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                itemWidth:15, //图例图像宽度 默认20
                itemHight:10, //图例图像高度 默认14
                textStyle:{
                    fontSize:8
                }, //文本标签样式
                //data:['直接访问', '邮件营销','联盟广告','视频广告','搜索引擎']
                data:['高级预警', '中级预警','低级预警']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false},//辅助线开关
                    dataView : {show: false, readOnly: false},//数据视图
                    magicType : {show: false, type: ['line', 'bar', 'stack', 'tiled']},//动态类型切换
                    restore : {show: false}, // 还原
                    saveAsImage : {show: false} //保存为图片
                }
            },
            calculable : true,
            grid:{'x':20,'x2':10},
            xAxis : [
                {
                    type : 'category',
                    // data : ['周一','周二','周三','周四','周五','周六','周日']
                   // data : ['未巡库预警','应收账款到期预警','对账不平预警','价格波动预警','敞口无法覆盖预警'],
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
                },
                    axisLabel:{
                        textStyle:{
                            fontSize:5
                        }, //文本标签样式
                        interval:0//横轴信息全部显示
                        //,rotate:30 //角度
                        ,formatter:function(value){
                       	 var newParams="";//最终拼接成的字符串
                    	 var varLength= value.length; //实际的长度
                    	 var maxLength =6;//每行能显示的字数
                    	 var rowNumber =Math.ceil(varLength/maxLength); //换行，需要显示几行，向上取整
                    	 //判断是否需要换行，需要的话，进行换行处理，不需要返回原标签
                    	 if(varLength>maxLength){
                    		 //循环每一行，p表示行
                    		 for(var p=0;p<rowNumber;p++){
                    			 var tempStr ="";//每一次截取的字符串
                    			 var start = p*maxLength; //开始
                    			 var end = start +maxLength;//结束
                    			 //此处特殊处理最后一行的索引值
                    			 if(p==rowNumber-1){
                    				 //最后一次不换行
                    				 tempStr =  value.substring(start,varLength);
                    			 }else{
                    				 //每一次拼接并换行
                    				 tempStr = value.substring(start,end)+"\n";
                    			 }
                    			 newParams +=tempStr;  //最终拼接成的字符串
                    		 }
                    		 return newParams;
                    	 }else{
                    		 return value;
                		 }
                       }
                    }

                }
            ],
            yAxis : [
                {
                    type : 'value',
                    boundaryGap: [0, 0.1],
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
                //{
                //    name:'低级预警',
                //    type:'bar',
                //    stack: '总量',
                //    itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
                //    //data:[320, 302, 301, 334, 390, 330, 320]
                //    data:[3, 2, 1, 4, 0]
                //},
                //{
                //    name:'中级预警',
                //    type:'bar',
                //    stack: '总量',
                //    itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
                //    //data:[120, 132, 101, 134, 90, 230, 210]
                //    data:[1, 1, 1, 3, 9]
                //},
                //{
                //    name:'高级预警',
                //    type:'bar',
                //    stack: '总量',
                //    barWidth:40,// 柱形宽度
                //    barGap:'10%',// 柱间距离，默认为 柱形宽度的30%
                //    itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
                //    //data:[220, 182, 191, 234, 290, 330, 310]
                //    data:[2, 8, 1, 3, 2]
                //}
            ]
        };

        // 为echarts对象加载数据
        initWarnData(warnoption,data);
        warnChart.setOption(warnoption);
        //var ecConfig = require('echarts/config');
        var ecConfig = echarts.config;
        warnChart.on(ecConfig.EVENT.CLICK, eConsole);
    }
    function initWarnData(option,data){

        var Item = function(){
            return {
                name:'',
                type:'bar',
                stack: '总量',
                barWidth:40,// 柱形宽度
                barGap:'10%',// 柱间距离，默认为 柱形宽度的30%
                //图表样式
                itemStyle:{
                    normal:{
                        label:{
                            show:false
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
                it.name = name;
                it.data = dataValus[i].seriesDataValue;
                Series.push(it);
            }
        }
        //设置X轴
        option.xAxis[0].data= data.xaxisData;
        waringUrl = data.mapParam.waringUrl;
        legends = data.legendData;
        //console.log(JSON.stringify(legends));
        //console.log(JSON.stringify(Series));
        option.legend.data=legends;
        option.series = Series;
        //重新加载图表'
    }

    function eConsole(param){
        var mes='【'+param.type +'】';
        if(typeof param.seriesIndex !='undefined'){
            if(param.type=='click'){
                var name = param.name;
                var x = param.dataIndex;
                var url = window._HTTP_IP_PORT+waringUrl[x];
                //var waringNo = waringNos[x];
                if(url.indexOf("http://")!=-1){

                    window.location.href=url+'?needBackFlag=true';
                    //window.open(url,"_blank","height="+window.screen.availHeight/1.1+",width="+window.screen.availWidth/1.2+",scrollbars=yes");
                    //window.open(url, "win");
                }else{
                    //window.parent.parent.doWork(waringNo,name,url,waringNo);
                }

            }
        }

    }
    
    //预警信息 end

    queryfinMapList();
//	initEChart("");
    //查询融资金额分布地图数据
    function queryfinMapList() {
        var data = {
            value : {index:3} //获取结果集的前几条记录
        }
        var promise = $common.get_asyncData("statisAnalysisService/queryFinAmtDistribList", data)
        promise.then(function(res) {
            var resData;
            if (res.errorCode == "SUC") {
                resData = res.contextData;
                //初始化报表
                initfinMapChart(resData);
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
    //融资金额分布 begin
    function initfinMapChart(data){
        var finMapChartTheme={
            color : [
                '#FF7F50','#87CEFA','#DA70D6'
            ]
        };
        var finMapChart = echarts.init(document.getElementById('finMapChart'),finMapChartTheme);
        finMapChartOption = {
            title : {
                text: '融资金额分布',
                subtext: '',
                x:'center'
            },
            tooltip : {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                x:'left',
               // data:['国内保理','担保提货','非标仓单']
                data:[]
            },
            dataRange: {
                min: 0,
                max: 2500,
                x: 'left',
                y: 'bottom',
                text:['高','低'],           // 文本，默认为数值文本
                calculable : true
            },
            toolbox: {
                show: true,
                orient : 'vertical',
                x: 'right',
                y: 'center',
                feature : {
                    mark : {show: false},
                    dataView : {show: false, readOnly: false},
                    restore : {show: false},
                    saveAsImage : {show: false}
                }
            },
            roamController: {
                show: false,
                x: 'right',
                mapTypeControl: {
                    'china': false
                }
            },
            series : [
               // {
                //    name: '国内保理',
                //    type: 'map',
                //    mapType: 'china',
                //    roam: false,
                //    itemStyle:{
                //        normal:{label:{show:true}},
                //        emphasis:{label:{show:true}}
                //    },
                //    data:[
                //        {name: '北京',value: Math.round(Math.random()*1000)},
                //        {name: '天津',value: Math.round(Math.random()*1000)},
                //        {name: '上海',value: Math.round(Math.random()*1000)},
                //        {name: '重庆',value: Math.round(Math.random()*1000)},
                //        {name: '河北',value: Math.round(Math.random()*1000)},
                //        {name: '河南',value: Math.round(Math.random()*1000)},
                //        {name: '云南',value: Math.round(Math.random()*1000)},
                //        {name: '辽宁',value: Math.round(Math.random()*1000)},
                //        {name: '黑龙江',value: Math.round(Math.random()*1000)},
                //        {name: '湖南',value: Math.round(Math.random()*1000)},
                //        {name: '安徽',value: Math.round(Math.random()*1000)},
                //        {name: '山东',value: Math.round(Math.random()*1000)},
                //        {name: '新疆',value: Math.round(Math.random()*1000)},
                //        {name: '江苏',value: Math.round(Math.random()*1000)},
                //        {name: '浙江',value: Math.round(Math.random()*1000)},
                //        {name: '江西',value: Math.round(Math.random()*1000)},
                //        {name: '湖北',value: Math.round(Math.random()*1000)},
                //        {name: '广西',value: Math.round(Math.random()*1000)},
                //        {name: '甘肃',value: Math.round(Math.random()*1000)},
                //        {name: '山西',value: Math.round(Math.random()*1000)},
                //        {name: '内蒙古',value: Math.round(Math.random()*1000)},
                //        {name: '陕西',value: Math.round(Math.random()*1000)},
                //        {name: '吉林',value: Math.round(Math.random()*1000)},
                //        {name: '福建',value: Math.round(Math.random()*1000)},
                //        {name: '贵州',value: Math.round(Math.random()*1000)},
                //        {name: '广东',value: Math.round(Math.random()*1000)},
                //        {name: '青海',value: Math.round(Math.random()*1000)},
                //        {name: '西藏',value: Math.round(Math.random()*1000)},
                //        {name: '四川',value: Math.round(Math.random()*1000)},
                //        {name: '宁夏',value: Math.round(Math.random()*1000)},
                //        {name: '海南',value: Math.round(Math.random()*1000)},
                //        {name: '台湾',value: Math.round(Math.random()*1000)},
                //        {name: '香港',value: Math.round(Math.random()*1000)},
                //        {name: '澳门',value: Math.round(Math.random()*1000)}
                //    ]
                //},
                //{
                //    name: '担保提货',
                //    type: 'map',
                //    mapType: 'china',
                //    itemStyle:{
                //        normal:{label:{show:true}},
                //        emphasis:{label:{show:true}}
                //    },
                //    data:[
                //        {name: '北京',value: Math.round(Math.random()*1000)},
                //        {name: '天津',value: Math.round(Math.random()*1000)},
                //        {name: '上海',value: Math.round(Math.random()*1000)},
                //        {name: '重庆',value: Math.round(Math.random()*1000)},
                //        {name: '河北',value: Math.round(Math.random()*1000)},
                //        {name: '安徽',value: Math.round(Math.random()*1000)},
                //        {name: '新疆',value: Math.round(Math.random()*1000)},
                //        {name: '浙江',value: Math.round(Math.random()*1000)},
                //        {name: '江西',value: Math.round(Math.random()*1000)},
                //        {name: '山西',value: Math.round(Math.random()*1000)},
                //        {name: '内蒙古',value: Math.round(Math.random()*1000)},
                //        {name: '吉林',value: Math.round(Math.random()*1000)},
                //        {name: '福建',value: Math.round(Math.random()*1000)},
                //        {name: '广东',value: Math.round(Math.random()*1000)},
                //        {name: '西藏',value: Math.round(Math.random()*1000)},
                //        {name: '四川',value: Math.round(Math.random()*1000)},
                //        {name: '宁夏',value: Math.round(Math.random()*1000)},
                //        {name: '香港',value: Math.round(Math.random()*1000)},
                //        {name: '澳门',value: Math.round(Math.random()*1000)}
                //    ]
                //},
                //{
                //    name: '非标仓单',
                //    type: 'map',
                //    mapType: 'china',
                //    itemStyle:{
                //        normal:{label:{show:true}},
                //        emphasis:{label:{show:true}}
                //    },
                //    data:[
                //        {name: '北京',value: Math.round(Math.random()*1000)},
                //        {name: '天津',value: Math.round(Math.random()*1000)},
                //        {name: '上海',value: Math.round(Math.random()*1000)},
                //        {name: '广东',value: Math.round(Math.random()*1000)},
                //        {name: '台湾',value: Math.round(Math.random()*1000)},
                //        {name: '香港',value: Math.round(Math.random()*1000)},
                //        {name: '澳门',value: Math.round(Math.random()*1000)}
                //    ]
                //}
            ]
        };
        // 为echarts对象加载数据
        initFinAmtDistribData(finMapChartOption,data);
        finMapChart.setOption(finMapChartOption);
    }
    /**
     * 初始地图数据
     */
    function initFinAmtDistribData(option,data){
        var Item = function(){
            return {
                name: '',
                type: 'map',
                mapType: 'china',
                roam: false,
                itemStyle:{
                    normal:{
                        label:{show:true},
                        areaStyle:{color:'#BEE9F9'}
                    },
                    emphasis:{
                        label:{show:true},
                        areaStyle:{color:'#FFB980'}
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
                it.name = name;
                it.data = dataValus[i].seriesDatas;
                Series.push(it);
            }
        }
        legends = data.legendData;
        if (Series.length <= 0) {
            var it = new Item();
            Series.push(it);
        }
        console.log(JSON.stringify(legends));
        console.log(JSON.stringify(Series));
        option.legend.data=legends;
        option.series = Series;
    }
   // 融资金额分布 end
};
