/**
 * @author 	huangshuidan
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2017/06/21
 */
var finAmtDistribController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform={};
    $scope.custTagform={}; 
	var deliverData = dataDeliver.getter();
	queryFinAmtDistribList();
//	initEChart("");
	 //查询融资金额分布地图数据
	 function queryFinAmtDistribList() {
		var data = {
			value : {}
		}
		var promise = $common.get_asyncData("statisAnalysisService/queryFinAmtDistribList", data)
			promise.then(function(res) {
				var resData;
				if (res.errorCode == "SUC") {
					resData = res.contextData;
					$scope.finAmtTopList=resData.finAmtTopList;
					//初始化报表
					initEChart(resData);
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
			});
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

    function initEChart(data){
        var myChart = echarts.init(document.getElementById('custProChart'));
        var option = {
        	    title : {
        	        text: '融资金额',
        	        subtext: '',
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item'
        	    },
        	    legend: {
        	        orient: 'vertical',
        	        x:'left',
//        	        data:['应收类','预付类','存货类']
        	        data:[]
        	    },
        	    dataRange: {
        	        min: 0,
        	        max: 90000000,
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
        	            'china': true
        	        }
        	    },
        	    series : [
//        	        {
//        	            name: '应收类',
//        	            type: 'map',
//        	            mapType: 'china',
//        	            roam: false,
//        	            itemStyle:{
//        	                normal:{label:{show:true}},
//        	                emphasis:{label:{show:true}}
//        	            },
//        	            data:[
//        	                {name: '北京',value: 2500.00},
//        	                {name: '天津',value: Math.round(Math.random()*1000)},
//        	                {name: '上海',value: Math.round(Math.random()*1000)},
//        	                {name: '重庆',value: Math.round(Math.random()*1000)},
//        	                {name: '河北',value: Math.round(Math.random()*1000)},
//        	                {name: '河南',value: Math.round(Math.random()*1000)},
//        	                {name: '云南',value: Math.round(Math.random()*1000)},
//        	                {name: '辽宁',value: Math.round(Math.random()*1000)},
//        	                {name: '黑龙江',value: Math.round(Math.random()*1000)},
//        	                {name: '湖南',value: Math.round(Math.random()*1000)},
//        	                {name: '安徽',value: Math.round(Math.random()*1000)},
//        	                {name: '山东',value: Math.round(Math.random()*1000)},
//        	                {name: '新疆',value: Math.round(Math.random()*1000)},
//        	                {name: '江苏',value: Math.round(Math.random()*1000)},
//        	                {name: '浙江',value: Math.round(Math.random()*1000)},
//        	                {name: '江西',value: Math.round(Math.random()*1000)},
//        	                {name: '湖北',value: Math.round(Math.random()*1000)},
//        	                {name: '广西',value: Math.round(Math.random()*1000)},
//        	                {name: '甘肃',value: Math.round(Math.random()*1000)},
//        	                {name: '山西',value: Math.round(Math.random()*1000)},
//        	                {name: '内蒙古',value: Math.round(Math.random()*1000)},
//        	                {name: '陕西',value: Math.round(Math.random()*1000)},
//        	                {name: '吉林',value: Math.round(Math.random()*1000)},
//        	                {name: '福建',value: Math.round(Math.random()*1000)},
//        	                {name: '贵州',value: Math.round(Math.random()*1000)},
//        	                {name: '广东',value: Math.round(Math.random()*1000)},
//        	                {name: '青海',value: Math.round(Math.random()*1000)},
//        	                {name: '西藏',value: Math.round(Math.random()*1000)},
//        	                {name: '四川',value: Math.round(Math.random()*1000)},
//        	                {name: '宁夏',value: Math.round(Math.random()*1000)},
//        	                {name: '海南',value: Math.round(Math.random()*1000)},
//        	                {name: '台湾',value: Math.round(Math.random()*1000)},
//        	                {name: '香港',value: Math.round(Math.random()*1000)},
//        	                {name: '澳门',value: Math.round(Math.random()*1000)}
//        	            ]
//        	        },
//        	        {
//        	            name: '预付类',
//        	            type: 'map',
//        	            mapType: 'china',
//        	            itemStyle:{
//        	                normal:{label:{show:true}},
//        	                emphasis:{label:{show:true}}
//        	            },
//        	            data:[
//        	                {name: '北京',value: 1500.00},
//        	                {name: '天津',value: Math.round(Math.random()*1000)},
//        	                {name: '上海',value: Math.round(Math.random()*1000)},
//        	                {name: '重庆',value: Math.round(Math.random()*1000)},
//        	                {name: '河北',value: Math.round(Math.random()*1000)},
//        	                {name: '安徽',value: Math.round(Math.random()*1000)},
//        	                {name: '新疆',value: Math.round(Math.random()*1000)},
//        	                {name: '浙江',value: Math.round(Math.random()*1000)},
//        	                {name: '江西',value: Math.round(Math.random()*1000)},
//        	                {name: '山西',value: Math.round(Math.random()*1000)},
//        	                {name: '内蒙古',value: Math.round(Math.random()*1000)},
//        	                {name: '吉林',value: Math.round(Math.random()*1000)},
//        	                {name: '福建',value: Math.round(Math.random()*1000)},
//        	                {name: '广东',value: Math.round(Math.random()*1000)},
//        	                {name: '西藏',value: Math.round(Math.random()*1000)},
//        	                {name: '四川',value: Math.round(Math.random()*1000)},
//        	                {name: '宁夏',value: Math.round(Math.random()*1000)},
//        	                {name: '香港',value: Math.round(Math.random()*1000)},
//        	                {name: '澳门',value: Math.round(Math.random()*1000)}
//        	            ]
//        	        },
//        	        {
//        	            name: '存货类',
//        	            type: 'map',
//        	            mapType: 'china',
//        	            itemStyle:{
//        	                normal:{label:{show:true}},
//        	                emphasis:{label:{show:true}}
//        	            },
//        	            data:[
//        	                {name: '北京',value: 500.00},
//        	                {name: '天津',value: Math.round(Math.random()*1000)},
//        	                {name: '上海',value: Math.round(Math.random()*1000)},
//        	                {name: '广东',value: Math.round(Math.random()*1000)},
//        	                {name: '台湾',value: Math.round(Math.random()*1000)},
//        	                {name: '香港',value: Math.round(Math.random()*1000)},
//        	                {name: '澳门',value: Math.round(Math.random()*1000)}
//        	            ]
//        	        }
        	    ]
        	};
        	                    
        initFinAmtDistribData(option,data);
        myChart.setOption(option);
    }
};

