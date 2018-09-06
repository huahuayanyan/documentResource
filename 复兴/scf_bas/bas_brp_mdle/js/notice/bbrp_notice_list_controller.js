/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var BbrpNoticeListController = function($scope,$common,$state,dataDeliver) {
    $scope.conditionForm={};
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bBrpNoticeModelService/findBBrpNoticeModelByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    /**
     * 通知书类型筛选
     */
    $scope.noticeTypeValContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectNoticeType",
        split:",",//分隔符
        extentColumn:"dataTrsVal",
        column:["dataTrsVal"]//展示内容
    };
    $scope.noticeTypeValdooextent = function(ds){
        $scope.conditionForm.noticeTypeVal=ds.dataTrsVal;
        $scope.conditionForm.noticeType=ds.dataVal;
    };
    $scope.$watch("conditionForm.noticeTypeVal",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        if($scope.conditionForm.noticeTypeVal!=null)
            $scope.noticeTypeValContent.param ={
                noticeTypeVal:$scope.conditionForm.noticeTypeVal
            };
    });

    //新增组件信息 新增的时候只要传过去一个flag就行了。
    $scope.upload_onClick = function(){

        var row={};
        $common.get_ngDialog('notice/bbrp_notice_upload.html', $scope
            ,["$scope",function(dialogScope){
            	BrpNoticeUploadController(dialogScope,$scope,$common,"",row);
            }],"模版上传",{showClose:true},800);

    };
     //新增组件信息 新增的时候只要传过去一个flag就行了。
    $scope.view_onClick = function(){

    	   if($scope.selected.select.length == 1){
               var row = $scope.selected.select[0];//定义选中参数id
               //var param={id:"1B905O0DK00PA2C7FCAA0000CB00BC84",noticeType:"88",appno:"FHDZ201702150000005"};
              // var param={id:"1B51VC6VU001A4C7FCAA100070ED50FC",noticeType:"81",appno:"RBB201612280000024"};
              // var param={id:"1B6QKN7UC005A3C7FCAA00008940001E",noticeType:"1",appno:"LPRCE201701190000124"};
               var param={id:row.id,noticeType:row.noticeType};
              // var param={id:"1B630NHDS0009BC7FCAA000076A81F7C",noticeType:"78",appno:"SKQRT2017011000135"};
               toPrint(param);
               //window.open("../../common_module/print/htPrintWindow.html?_="+Math.random(),"_blank","height="+window.screen.availHeight/1.5+",width="+window.screen.availWidth/1.5+",scrollbars=yes");
               // window.open("../../../scf_bas/notice/htPrintWindow.html");
              /* var primiseA = $common.get_asyncData('noticeOperationService/addPdf',{id:id});
               primiseA.then(function (res) {
                 if (res.errorCode == "SUC") {
                	var data = res.contextData;
                	// $state.go("bbrpnoticeview");
                    // dataDeliver.setter(data);
                    var url=data.url;
                	window.open("../../../scf_bas/"+url);
                   }else{
                       $common.get_tipDialog(res.errorMsg, 'showError');
                   }
               });*/
           }else{
               $common.get_tipDialog('请选择一条记录！','showInform');
           }
       };
    //删除 根据组件ID
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
            var id = $scope.selected.select[0].id;//定义选中参数id
            var primiseA = $common.get_asyncData('bBrpNoticeModelService/delete', {id: id});
            primiseA.then(function (res) {
              if (res.errorCode == "SUC") {
                  $scope.queryTable();
                  $scope.selected.select=[];
                  $common.get_tipDialog('删除成功！', 'showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    
    $scope.downloadoption = { 
    		
		    inputHidden:[ 
		        /* 从文件服务器下载 start */ 
		      /*  { 
		            name:'picId', 
		            value:function(){ 
		                return "201612011711416420000014"; 
		            } 
		        } */
		        /* 从文件服务器下载 end */ 
		        /* 从服务部署所在机器下载 start */ 
		        {name:'callback',value: 'fileServiceSupport/download'}, 
		        {name:'downloadType', value: "2001"}, 
		        {name:'genFileName',value: function(){
		            if($scope.selected.select.length == 1){
		            	return  $scope.selected.select[0].fileName+'.'+$scope.selected.select[0].fileExt;
		            }else{
		                $common.get_tipDialog('请选择一条记录！','showInform');
		            }
	
		        	
		        }},
		        {name:'id',value: function(){
		            if($scope.selected.select.length == 1){
		            	return  $scope.selected.select[0].id;
		            }else{
		                $common.get_tipDialog('请选择一条记录！','showInform');
		            }
	
		        	
		        }} 
		        /* 从服务部署所在机器下载 end */ 
		    ], 
		    fileServerUrl:false //true：从文件服务器下载；false：从服务部署所在机器下载 
		}; 
		

    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm = {

        };
        $scope.queryTable();
    }
}
