/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var fkxxController = function($scope,$common,$stateParams,dataDeliver,$state,$timeout,$compile,$eventCommunicationChannel){
    alert(JSON.stringify($stateParams))

    $eventCommunicationChannel.onEditData($scope,function(data){
        alert(data);
    });
    //$eventCommunicationChannel.editData("www");
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"displayTableOrTree/jquery",//请求url
        param:{kk:"e"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"",
        column:["jghth","jggsmc","ywpz"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.myform.jggsmc=ds.jggsmc;
    };
    $scope.selectSource = {
        ds:[
            {key:"1",value:'票据业务1'},
            {key:"2",value:'测试业务2'},
            {key:"3",value:'票据业务3'}
        ]
    };
    $scope.xthtzt_change =function(val){
        alert($scope.myform.xdhtsxr);
        if(val==3){
            var html = '<ht-input ht-id="appended" name="appended"  reg-exp="UserService.getLogin.userName" ng-model="myform.appended"></ht-input>'
            $("#wubin").append($compile(html)($scope))
            $scope.content.type="table";
            $scope.hide = true;
            $scope.disable = true;
        }
        if(val==2){
            $scope.content.type="tree";
            $scope.hide = false;
            $scope.disable = false;
        }
        if(val==1){
            $scope.content.type="";
        }
        //$common.get_tipDialog(val,'showInform')
    }
    $scope.otherform = {};
    $scope.myform={
        jggsmc:"www",
        xdhtje:"543535",
        //xdhtsxr:"20160815",
        opt:1,
        opt2:["1","3"],
        sex4: 2,
        sex3: ["2","1"],
        sqkhmc:"1",
        xthtzt:"1"
    };
    $scope.conf= { pageNo: 1, pageSize: 5};
    //$scope.$watch("conf.pageNo+conf.pageSize",queryTable)
    $scope.datasource={}
    $scope.selected={select :[]};
    $scope.xdhtsxr_onChange =function(newdate){
        debugger
        //alert("newdate: "+$scope.myform.xdhtsxr);
        console.log($scope.myform.xdhtsxr);
        $scope.$apply(function(){
            //$scope.myform.xdhtsxr=''
        })

        //$timeout(function(){
        //    $scope.myform.xdhtsxr ="";
        //},1000);

    };
    var queryTable = function (param){
        var data= {
            pageNo: 1,
            pageSize: 10,
            otherform:param
        };
        var promise = $common.get_asyncData("orgUserService/findOrgUserByPage2",data);
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
        $scope.selected.select=[];
    };

    $scope.onclickk = function(val){
        alert(val)
    }
    $scope.confirm_onClick =function(){
        $scope.myform.jggsmc = $scope.selected.select[0].jggsmc
    }
    $scope.query_onClick =function(){
        var bb={};
        queryTable(bb)
    }
    $scope.submit_onClick =function(){
        if($.doValidate("myform")&&$.doValidate("otherform")){
            $common.get_tipDialog("基本信息 ："+JSON.stringify($scope.myform),"showInform");
        }
    }

    $scope.submitid_onClick =function(){
        $timeout(function(){
            Progressbar.remove({barId:'submitid'});
        },500)
    }
}