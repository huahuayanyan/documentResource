/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var baCustProController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform={
    };

    //客户名称筛选
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.otherform.custcd=ds.custcd;
        $scope.otherform.cname=ds.cname;
        /*var bCrmBaseInfo ={
         custno:ds.custcd,
         cname:ds.cname

         }*/

    };
    $scope.$watch("otherform.cname",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            // custType:"1", //法人
            cname:$scope.otherform.cname
            //coreFlag:"1", //核心厂商
        };
    });

    $scope.$watch("otherform.custcd",function(newVal,oldVal){
        var data = {
            value : {
                custcd:$scope.otherform.custcd,
                cname:$scope.otherform.cname
            }
        };
        //if($scope.otherform.custcd!=null&&$scope.otherform.cname!=null&& newVal !== oldVal){
        if($scope.otherform.custcd!=null&&newVal !== oldVal){
            getCustbaseInfo(data);
        }

    });
	var deliverData = dataDeliver.getter();
    var stateUrl = deliverData.stateUrl;
    if(stateUrl&&stateUrl!=undefined&&stateUrl!=null&&stateUrl!=""){
        $state.go(stateUrl);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == stateUrl){
                $scope.$parent.select(pane);
            }
        });
        deliverData.stateUrl=""; //清空
        return;
    }
   if(deliverData.bCrmBaseInfo==undefined){
	   initCust(); 
   }else{
       $scope.otherform ={
           custcd:deliverData.bCrmBaseInfo.custcd,
           cname:deliverData.bCrmBaseInfo.cname
       };
	   var data = {
               value : {
               	custcd:deliverData.bCrmBaseInfo.custcd,
               	cname:deliverData.bCrmBaseInfo.cname
               }
       };
       getCustbaseInfo(data);
   }

    //默认查询一个客户
    function initCust(){
    	 var data= {
    			 pageNo:1,
    			 pageSize:10
    			 
             };
        var promise = $common.get_asyncData("bCrmBaseInfoService/selectBCrmBaseInfoByPage", data);

        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
               // $scope.datasource.ds = resData.records;
                if(resData.records.length>0){
                    $scope.otherform.custcd=resData.records[0].custcd;
                    $scope.otherform.cname=resData.records[0].cname;
                }

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }

    function getCustbaseInfo(data){
        var promise = $common.get_asyncData("statisAnalysisService/getCustbaseInfo", data);

        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                $scope.otherform =resData;
                var setdata= {
                        bCrmBaseInfo: {
                        	 custcd:$scope.otherform.custcd,
                             cname:$scope.otherform.cname
                        }
                    };
                dataDeliver.setter(setdata);
                getAnalysisChartInfo(data);
                getbuyInfo();
                getSaleInfo();

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    
    function getAnalysisChartInfo(data){
    	/*var data = {
                value : {
                	custcd:$scope.otherform.custcd,
                	cname:$scope.otherform.cname,
                	
                }
        }*/
        var promise = $common.get_asyncData("statisAnalysisService/getAnalysisChartInfo", data);

        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData; 
                initEChart(resData); //
               
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    function initEChart(values){

        var myChart = echarts.init(document.getElementById('custProChart'));

        var option = {
            title : {
                text: ''
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                orient : 'vertical',
                x : 'right',
                y : 'bottom',
                data:[]
                //data:['预算分配（Allocated Budget）','实际开销（Actual Spending）']
            },
            toolbox: {
                show : false,
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

                        { text: 'ERP使用比率', axisLabel: {show: true, textStyle: {fontSize: 14, color: '#333'}},  max: 30},
                       // { text: 'ERP使用比率', axisLabel: {show: true, textStyle: {fontSize: 14}},  max: 30},
                        { text: '逾期率', max: 20},
                        { text: '坏账率', max: 60},
                        { text: '预付款占比', max: 80},
                        { text: '应收帐款占比', max:80},
                        { text: '销售增长率', max: 30},
                        { text: '销售利润率', max: 50},
                        { text: '保证金覆盖率', max: 50},
                        { text: '关系紧密', max:60}
                    ]  ,
                    name:{   //坐标轴名称
                        show:true,//默认
                        textStyle:{
                            color:"#333"  //坐标轴名称颜色
                        }
                    },
                    splitNumber:5, //分割段数，默认为5
                    radius : 100 //	半径，支持绝对值（px）和百分比
                }
            ],
            //calculable : true, //false是否启用拖拽重计算特性，默认关闭
            series : [
                {
                    itemStyle: {
                        normal: {
                            color: '#60C0DD'
                        }
                    },
                   // name: '预算 vs 开销（Budget vs spending）',
                    type: 'radar',
                    data : values
                    	
                    	/*[
                         {
                             value : [30,0, 12, 30, 20, 36,80, 48, 12, 30, 50, 36],
                             name : ''
                         }
                    ]*/
                }
            ]
        };

        myChart.setOption(option);
    }
    $scope.buyrecords=[];
    $scope.salerecords=[];
    //采购，销售合作伙伴
    function getbuyInfo(){
    	var data = {
                value : {
                	custcd:$scope.otherform.custcd,
                	type:"1"  //采购
                	
                }
        };
    	
    	var promise = $common.get_asyncData("statisAnalysisService/getCooperPartnerInfo", data);
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                $scope.buyrecords =resData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }
    function getSaleInfo(){
    	var data = {
                value : {
                	custcd:$scope.otherform.custcd,
                	type:"2"  //销售
                	
                }
        };
    	var promise = $common.get_asyncData("statisAnalysisService/getCooperPartnerInfo", data);
        promise.then(function(res){
        	var resData;
            if (res.errorCode =="SUC"){
                resData = res.contextData;
                $scope.salerecords =resData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
       }

    $scope.cooprecordsInit=[
          {
        	  title:'',
        	  value:''
          },
          {
        	  title:'',
        	  value:''
          },
          {
        	  title:'',
        	  value:''
          }
   ];
  /*
	 * function getCooperPartnerInfo(data){
	 * 
	 * var promise =
	 * $common.get_asyncData("statisAnalysisService/getCooperPartnerInfo", data)
	 * promise.then(function(res){ var resData; if (res.errorCode =="SUC"){
	 * resData = res.contextData; }else{
	 * $common.get_tipDialog(res.errorMsg,'showError'); } return resData; });
	 *  }
	 */
    //获得全行业务汇总
 /*   function queryBusinessTotal(){
        var data ={
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryContOrProByMastContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.fourDeliveryform=data;
                queryDebtInfo();
                queryDeliveryInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
        $scope.records=[
            {
                title:'三个月日均资产',
                value:'20万'
            },
            {
                title:' 三个月日均存款',
                value:'20万'
            },
            {
                title:'时点资产',
                value:'20万'
            },
            {
                title:'时点存款',
                value:'20万'
            },
            {
                title:'三个月日均贷款（表内）',
                value:'0'
            },
            {
                title:' 三个月日均贷款（表外）',
                value:'0'
            }
        ];
        $scope.buyrecords=[
            {
                title:'A公司',
                value:'20%'
            },
            {
                title:'B公司',
                value:'5%'
            },
            {
                title:'C公司',
                value:'3%'
            }
        ];
        $scope.salerecords=[
            {
                title:'D公司',
                value:'20%'
            },
            {
                title:'E公司',
                value:'5%'
            },
            {
                title:'F公司',
                value:'3%'
            }
        ]
    }*/
};

