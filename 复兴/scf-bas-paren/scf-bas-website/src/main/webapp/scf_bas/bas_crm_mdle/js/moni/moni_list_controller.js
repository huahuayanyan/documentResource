/**findBCrmBaseInfoByKey
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var MoniListController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
        var data1= dataDeliver.getter();
        var bCrmBaseInfo={
            orgCode:data1.orgCode,
            moniFlag:"1"
        }
       //页面属性判断
        var custcd="";//页面客户号唯一定义变量
        var bCrmMoniEvaInfo1={
            custcd:"",
        }
        if(data1.flag=="add"){
                var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:bCrmBaseInfo});
                primise.then(function(res1) {
                    if (res1.errorCode == "SUC") {
                        var data2 = res1.contextData;
                        if (data2 != null && data2.orgCode == data1.orgCode) {//说明之前客户信息保存成功
                           custcd = data2.custcd;//获得客户号
                            //初始化表格对象
                            $scope.datasource={
                                ds:[]
                            };
                            $scope.conf= {//初始化分页对象
                                pageNo: 1,
                                pageSize: 10,
                                totalRecord: 0
                            }

                            bCrmMoniEvaInfo1.custcd=custcd

                            //监听分页
                            $scope.$watch("conf.pageNo+conf.pageSize",function(){
                                $scope.queryTable();
                            });
                            //查询操作
                            $scope.queryTable = function(paramData){
                                var data2= {
                                    pageNo: $scope.conf.pageNo,
                                    pageSize: $scope.conf.pageSize,
                                    bCrmMoniEvaInfo:bCrmMoniEvaInfo1
                                };
                                var promiseA = $common.get_asyncData("bCrmMoniEvaInfoService/findBCrmMoniEvaInfoByPage",data2);
                                promiseA.then(function(resa){
                                    if (resa.errorCode =="SUC"){
                                        var data3 = resa.contextData;
                                        if(data3.records != "" && data3.records != null) {
                                            var resType = {} ;
                                            for (var k in window.dictionary) {
                                                if (dictionary[k].dictCode == 'monitortype') {
                                                    var cur = dictionary[k];
                                                    for (var x in cur.dataItems) {
                                                        var curr = cur.dataItems[x];
                                                        resType[curr.dataVal] = curr.dataTrsVal;
                                                    }
                                                }
                                            }
                                            for(var obj in data3.records){
                                                var objtemp=data3.records[obj],monitortypeval = "",
                                                    temp1=objtemp.monitortype.split(",");
                                                for (var k in temp1) {
                                                    monitortypeval = monitortypeval + resType[temp1[k]] + ",";
                                                }
                                                objtemp.monitortype=monitortypeval.substring(0, monitortypeval.length - 1);
                                            }
                                            $scope.datasource.ds = data3.records;
                                            $scope.conf.totalRecord = data3.totalRecord;
                                        }else{
                                            $scope.datasource.ds = data3.records;
                                            $scope.conf.totalRecord = data3.totalRecord;
                                        }
                                    }else{
                                        $common.get_tipDialog(resa.errorMsg,'showError');
                                    }
                                });
                            };
                            //查询监管公司信息 ，这里也可以使用bCrmMoniEvaInfo1,因为里面的字段和参数是一致的
                            var promiseT = $common.get_asyncData("bCrmMoniEntInfoService/findBCrmMoniEntInfoByKey",{bCrmMoniEntInfo:bCrmMoniEvaInfo1});
                            promiseT.then(function(res){
                                var data4;
                                if (res.errorCode =="SUC"){
                                    data4 = res.contextData;
                                    //判断，如果没有，则给空白页面一个custcd就可以了
                                    if(data4 != null && data4.custcd ==custcd ){
                                        data4.monitortype=data4.monitortype.split(",");
                                        $scope.otherform = data4
                                    }else{//给空白页面一个custcd
                                        $scope.otherform.custcd = custcd
                                    }
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        } else {
                            $state.go("tree.add");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.add"){
                                    $scope.$parent.select(pane);
                                };
                            });
                            $common.get_tipDialog("请先完成客户基本信息保存！", 'showInform');
                        }
                    } else {
                        $common.get_tipDialog(res1.errorMsg, 'showError');
                    }
                });
            }else if(data1.flag == "update"){
            custcd=data1.bCrmBaseInfo.custcd;
            //初始化表格对象
            $scope.datasource={
                ds:[]
            };
            $scope.conf= {//初始化分页对象
                pageNo: 1,
                pageSize: 10,
                totalRecord: 0
            }

            bCrmMoniEvaInfo1.custcd=custcd

            //监听分页
            $scope.$watch("conf.pageNo+conf.pageSize",function(){
                $scope.queryTable();
            });
            //查询操作
            $scope.queryTable = function(paramData){
                var data2= {
                    pageNo: $scope.conf.pageNo,
                    pageSize: $scope.conf.pageSize,
                    bCrmMoniEvaInfo:bCrmMoniEvaInfo1
                };
                var promiseA = $common.get_asyncData("bCrmMoniEvaInfoService/findBCrmMoniEvaInfoByPage",data2);
                promiseA.then(function(resa){
                    if (resa.errorCode =="SUC"){
                        var data3 = resa.contextData;
                        if(data3.records != "" && data3.records != null) {
                            var resType = {} ;
                            for (var k in window.dictionary) {
                                if (dictionary[k].dictCode == 'monitortype') {
                                    var cur = dictionary[k];
                                    for (var x in cur.dataItems) {
                                        var curr = cur.dataItems[x];
                                        resType[curr.dataVal] = curr.dataTrsVal;
                                    }
                                }
                            }
                            for(var obj in data3.records){
                                var objtemp=data3.records[obj],monitortypeval = "",
                                    temp1=objtemp.monitortype.split(",");
                                for (var k in temp1) {
                                    monitortypeval = monitortypeval + resType[temp1[k]] + ",";
                                }
                                objtemp.monitortype=monitortypeval.substring(0, monitortypeval.length - 1);
                            }
                            $scope.datasource.ds = data3.records;
                            $scope.conf.totalRecord = data3.totalRecord;
                        }else{
                            $scope.datasource.ds = data3.records;
                            $scope.conf.totalRecord = data3.totalRecord;
                        }
                    }else{
                        $common.get_tipDialog(resa.errorMsg,'showError');
                    }
                });
            };
            //查询监管公司信息 ，这里也可以使用bCrmMoniEvaInfo1,因为里面的字段和参数是一致的
            var promiseT = $common.get_asyncData("bCrmMoniEntInfoService/findBCrmMoniEntInfoByKey",{bCrmMoniEntInfo:bCrmMoniEvaInfo1});
            promiseT.then(function(res){
                var data4;
                if (res.errorCode =="SUC"){
                    data4 = res.contextData;
                    //判断，如果没有，则给空白页面一个custcd就可以了
                    if(data4 != null && data4.custcd ==custcd ){
                        data4.monitortype=data4.monitortype.split(",");
                        $scope.otherform = data4
                    }else{//给空白页面一个custcd
                        $scope.otherform.custcd = custcd
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }else if(data1.flag == "view"){
            custcd=data1.bCrmBaseInfo.custcd;
            $scope.disable=true;
            $scope.disable1=true;
            $scope.disable2=true;
            $scope.hide1=true;
            //初始化表格对象
            $scope.datasource={
                ds:[]
            };
            $scope.conf= {//初始化分页对象
                pageNo: 1,
                pageSize: 10,
                totalRecord: 0
            }

            bCrmMoniEvaInfo1.custcd=custcd

            //监听分页
            $scope.$watch("conf.pageNo+conf.pageSize",function(){
                $scope.queryTable();
            });
            //查询操作
            $scope.queryTable = function(paramData){
                var data2= {
                    pageNo: $scope.conf.pageNo,
                    pageSize: $scope.conf.pageSize,
                    bCrmMoniEvaInfo:bCrmMoniEvaInfo1
                };
                var promiseA = $common.get_asyncData("bCrmMoniEvaInfoService/findBCrmMoniEvaInfoByPage",data2);
                promiseA.then(function(resa){
                    if (resa.errorCode =="SUC"){
                        var data3 = resa.contextData;
                        if(data3.records != "" && data3.records != null) {
                            var resType = {} ;
                            for (var k in window.dictionary) {
                                if (dictionary[k].dictCode == 'monitortype') {
                                    var cur = dictionary[k];
                                    for (var x in cur.dataItems) {
                                        var curr = cur.dataItems[x];
                                        resType[curr.dataVal] = curr.dataTrsVal;
                                    }
                                }
                            }
                            for(var obj in data3.records){
                                var objtemp=data3.records[obj],monitortypeval = "",
                                    temp1=objtemp.monitortype.split(",");
                                for (var k in temp1) {
                                    monitortypeval = monitortypeval + resType[temp1[k]] + ",";
                                }
                                objtemp.monitortype=monitortypeval.substring(0, monitortypeval.length - 1);
                            }
                            $scope.datasource.ds = data3.records;
                            $scope.conf.totalRecord = data3.totalRecord;
                        }else{
                            $scope.datasource.ds = data3.records;
                            $scope.conf.totalRecord = data3.totalRecord;
                        }
                    }else{
                        $common.get_tipDialog(resa.errorMsg,'showError');
                    }
                });
            };
            //查询监管公司信息 ，这里也可以使用bCrmMoniEvaInfo1,因为里面的字段和参数是一致的
            var promiseT = $common.get_asyncData("bCrmMoniEntInfoService/findBCrmMoniEntInfoByKey",{bCrmMoniEntInfo:bCrmMoniEvaInfo1});
            promiseT.then(function(res){
                var data4;
                if (res.errorCode =="SUC"){
                    data4 = res.contextData;
                    //判断，如果没有，则给空白页面一个custcd就可以了
                    if(data4 != null && data4.custcd ==custcd ){
                        data4.monitortype=data4.monitortype.split(",");
                        $scope.otherform = data4
                    }else{//给空白页面一个custcd
                        $scope.otherform.custcd = custcd
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
//--------------------------------------------------------------------

    //页面初始化
    $scope.otherform={//页面的初始化总限额，单笔最大限额，巡查周期
        custcd:"",//初始化客户号
        parentId:"",//上级监管公司号
        parentName:"",//上级监管公司名称
        limitSum:"0.00",
        limitSingle:"0.00",
        inspectFrequence:"0",
    };
    //监管等级
    $scope.levels={
        ds:[
            {key:"A",value:'A'},
            {key:"B",value:'B'},
            {key:"C",value:'C'}
        ]
    };
    //上级监管公司初始化
    $scope.parentIdContent = {
        type: "table",//展示类型table  tree
        url: "bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{custcd:custcd2,moniFlag:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split: "-",//分隔符
        extentColumn: "cname",
        column: ["custcd", "cname"]//展示内容
    };
    $scope.dooextent = function (ds) {
        if (ds.custcd == custcd) {//上级监管公司不能是自己
            $common.get_tipDialog("上级监管公司不能与本公司相同！", 'showError');
        } else {
            $scope.otherform.parentId = ds.custcd;
        }
    };
    $scope.$watch("otherform.parentId", function () {
        $scope.parentIdContent.param = {
            cname: $scope.otherform.parentName,
            moniFlag: "1"
        }
    });
    //是否集团公司选项改变grouped_change
    $scope.grouped_change=function(val){
        //如果是单户模式 groupedMember是否集团成员0,creditType总对总标识0,parentId上级监管公司""
        //这三个都要只读 是否集团成员,上级监管公司disable1   总对总标识disable2
        if(val == 0 ){
            $scope.otherform.groupedMember="0",
            $scope.otherform.creditType="0",
            $scope.otherform.parentId="",
            $scope.otherform.parentName="",
            $scope.disable1=true;
            $scope.disable2=true
        }else{
            $scope.disable1=false;
            $scope.disable2=false
        }
    }
    //是否集团成员改变事件
    $scope.groupedMember_change=function(val){
        //如果是否集团成员1是成员，则为非总对总标识creditType0且不可读
        if(val == 1){
            $scope.creditType="0", $scope.disable2=true
        }else{
            $scope.disable2=false
        }
    }
    //页面数据格式校验
    var errorFlag=false;
    var errorMessage="";
    function checkFormRules(){
        if($scope.otherform.inspectFrequence){
            var inspectFrequence= parseFloat($scope.otherform.inspectFrequence);
            if(inspectFrequence <= 0){
                errorFlag=true;//错误标识为正确的，说明有错误
                errorMessage=errorMessage+'巡库频率必须大于零！';
            }
        }
        if(!$scope.otherform.monitortype || $scope.otherform.monitortype==""){
            errorFlag=true;//错误标识为正确的，说明有错误
            errorMessage=errorMessage+'请选择监管模式！';
        }
        //单笔监管限额 limitSingle
        if( $scope.otherform.limitSingle || $scope.otherform.limitSingle != ""){
            var limitSingle=parseFloat($scope.otherform.limitSingle);
            var limitSum=parseFloat($scope.otherform.limitSum);
            if(limitSingle > limitSum ){
                errorFlag=true;//错误标识为正确的，说明有错误
                errorMessage=errorMessage+'单笔监管限额不可超过监管总限额！';
            }
        }
    }

//-------------------------------------------点击事件----------------------------------------
    //监管公司信息保存操作,这里要判断，根据custcd去数据库里查询，如果，没有数据，就是新增操作；有数据，就修改操作
    // 这里省去里一个步骤，就是如果页面数据没有修改保存的时候，会提示，请修改数据。
    $scope.save_onClick = function() {
        if ($.doValidate("otherform")) {
            var parentId1 = $scope.otherform.parentId;
            checkFormRules();
            if(errorFlag){//页面除了上级监管公司之外的其他几个字段的数据再次校验
                $common.get_tipDialog(errorMessage, 'showError');
                errorFlag=false;
                errorMessage="";
            }else{
                if (parentId1 == custcd) {
                    $common.get_tipDialog('上级监管公司不能是本公司！', 'showError');
                } else {
                    var promise = $common.get_asyncData("bCrmMoniEntInfoService/findBCrmMoniEntInfoByKey", {bCrmMoniEntInfo:$scope.otherform});
                    promise.then(function (res) {
                        if (res.errorCode == "SUC") {//如果查询到对象，则进行修改操作，如果没有查询到对象，则进行新增操作
                            if (res.contextData != null && res.contextData.custcd == custcd) {//查询到对象，进行修改操作
                                var promise = $common.get_asyncData("bCrmMoniEntInfoService/update", {bCrmMoniEntInfo: $scope.otherform});
                                promise.then(function (res) {
                                    if (res.errorCode == "SUC") {
                                        $common.get_tipDialog('保存成功！', 'showSuccess');
                                    } else {//修稿操作失败
                                        $common.get_tipDialog(res.errorMsg, 'showError');
                                    }
                                });
                            } else {//没有查询到对象，则进行新增操作
                                var promise = $common.get_asyncData("bCrmMoniEntInfoService/add", {bCrmMoniEntInfo: $scope.otherform});
                                promise.then(function (res) {
                                    if (res.errorCode == "SUC") {
                                        $common.get_tipDialog('保存成功！', 'showSuccess');
                                    } else {//修稿操作失败
                                        $common.get_tipDialog(res.errorMsg, 'showError');
                                    }
                                });
                            }
                        } else {//查找监管公司对象失败
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                }
            }
        }
    }

        //生成监管公司年审记录操作confirm
        //1.先通过custcd去监管公司查询，查不到提示，请先保存监管公司！ 如果查到了，再通过custcd去查询年审记录，查到就修改操作，查不到就新增操作！
        $scope.confirm_onClick = function(){
            if ($.doValidate("otherform")) {
                var parentId1 = $scope.otherform.parentId;
                checkFormRules();
                if(errorFlag){//页面除了上级监管公司之外的其他几个字段的数据再次校验
                    $common.get_tipDialog(errorMessage, 'showError');
                    errorFlag=false;
                    errorMessage="";
                }else{
                    if (parentId1 == custcd) {
                        $common.get_tipDialog('上级监管公司不能是本公司！', 'showError');
                    } else {
                        //这里要注意：因为要根据等级到期日levelEndDate和客户号共同查询，如果没有，则进行新增操作。所以这里不能用原来的bCrmMoniEvaInfo1
                        //通过客户号去bCrmMoniEntInfo表中查找对应数据，查询结果要检验，只要必填的字段有没有写就报错，提示先完成保存操作
                        $common.get_tipDialog('是否已保存监管公司详细信息？','showTip').then(function() {
                            var promise1 = $common.get_asyncData("bCrmMoniEntInfoService/findBCrmMoniEntInfoByKey",{bCrmMoniEntInfo: $scope.otherform});
                            promise1.then(function(res1){
                                if (res1.errorCode =="SUC"){//对查询结果进行取值验证是否完成保存（实际上只是对没有第一次保存的校验有用，如果数据已经填写保存完毕，再次修改，没有保存
                                    //这个时候就没有办法按照这种办法进行修改了 ）
                                    if(res1.contextData != null && res1.contextData.custcd == custcd){//查询到了对应的监管公司
                                        //从数据库中查询到的监管公司的信息赋值给data5，再赋值给bCrmMoniEvaInfo传给后台
                                        var data5={
                                            custcd:custcd,//客户号
                                            levels:res1.contextData.levels,//监管方等级
                                            monitorArea: res1.contextData.monitorArea,//监管区域
                                            monitortype:res1.contextData.monitortype,//监管模式
                                            detailMonitorArea: res1.contextData.detailMonitorArea,//具体监管区域（省/市）
                                            limitSum: res1.contextData.limitSum,//监管总限额
                                            levelCogniDate: res1.contextData.levelCogniDate,//等级认定日期
                                            levelEndDate: res1.contextData.levelEndDate,//等级到期日期
                                            monitorStatus: res1.contextData.monitorStatus,//状态
                                            remark:res1.contextData.description,//备注*/
                                            createDate:res1.contextData.createDate,//监管公司的建档日期，年审记录的生成日期
                                            brcode: res1.contextData.brcode//经办机构
                                        };
                                        var bCrmMoniEvaInfo2={//根据监管公司客户号和等级到期日期一起去查询数据如果有，则修改操作，没有则新增
                                            custcd:custcd,
                                            levelEndDate:data5.levelEndDate
                                        };
                                        var promise2 = $common.get_asyncData("bCrmMoniEvaInfoService/findBCrmMoniEvaInfoByKey",{bCrmMoniEvaInfo:bCrmMoniEvaInfo2});
                                        promise2.then(function(res){
                                            if (res.errorCode =="SUC"){//如果查询到bCrmMoniEvaInfo对象，则进行修改操作，如果没有查询到对象，则进行新增操作
                                                if(res.contextData != null && res.contextData.custcd == custcd){//查询到对象，进行修改操作
                                                    //进行修改操作的时候，一定要注意，把id传过去，因为没有id，传过去是空值，会报错
                                                    var data6 ={
                                                        id:res.contextData.id,//获取查询到结果的id
                                                        tlrcd:res.contextData.tlrcd,//创建人
                                                        crtTime:res.contextData.crtTime,//创建日期
                                                        createDate:data5.createDate,//监管公司的建档日期，年审记录的生成日期
                                                        custcd:data5.custcd,//客户号
                                                        levels:data5.levels,//监管方等级
                                                        monitorArea:data5.monitorArea,//监管区域
                                                        monitortype:data5.monitortype,//监管模式
                                                        detailMonitorArea: data5.detailMonitorArea,//具体监管区域（省/市）
                                                        limitSum: data5.limitSum,//监管总限额
                                                        levelCogniDate:data5.levelCogniDate,//等级认定日期
                                                        levelEndDate: data5.levelEndDate,//等级到期日期
                                                        monitorStatus: data5.monitorStatus,//状态
                                                        remark:data5.remark,//备注*/
                                                        brcode: data5.brcode//经办机构
                                                    };
                                                    var promise3 = $common.get_asyncData("bCrmMoniEvaInfoService/update",{bCrmMoniEvaInfo:data6});
                                                    promise3.then(function(res){
                                                        if (res.errorCode =="SUC"){
                                                            $scope.queryTable();
                                                            $common.get_tipDialog('生成监管公司年审记录成功！','showSuccess');
                                                        }else{//修稿操作失败
                                                            $common.get_tipDialog(res.errorMsg,'showError');
                                                        }
                                                    });
                                                }else{//没有查询到bCrmMoniEvaInfo对象，则进行新增操作
                                                    var promise = $common.get_asyncData("bCrmMoniEvaInfoService/add",{bCrmMoniEvaInfo:data5});
                                                    promise.then(function(res){
                                                        if (res.errorCode =="SUC"){
                                                            $scope.queryTable();
                                                            $common.get_tipDialog('生成监管公司年审记录成功！','showSuccess');
                                                        }else{//修稿操作失败
                                                            $common.get_tipDialog(res.errorMsg,'showError');
                                                        }
                                                    });
                                                }
                                                /*$scope.queryTable();*/
                                            }else{//查找bCrmMoniEvaInfo对象失败
                                                $common.get_tipDialog(res.errorMsg,'showError');
                                            }
                                        });
                                    }else{//查到监管公司对象则再通过custcd去查询年审记录信息，查到了，修改操作，查不到，新增操作
                                        $common.get_tipDialog("请完成监管公司详细信息保存！",'showError');
                                    }
                                }else{//查询监管公司年审记录失败，提示信息。
                                    $common.get_tipDialog(res1.errorMsg,'showError');
                                }
                            });
                        });
                    }
                }
            }

    }
        //返回按钮
        $scope.back_onClick=function(){
                $state.go("base");
        }
};



