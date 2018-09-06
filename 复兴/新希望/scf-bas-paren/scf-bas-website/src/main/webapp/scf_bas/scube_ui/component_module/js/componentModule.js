/**
 * Created by wubin on 2016/7/23.
 */
(function () {
    var dependency=[
        'treeControl',
        'angularFileUpload',
        'tableHelper',
        'common'
    ];
    angular.module('componentModule',dependency).
    controller('componentController',function($scope,$common,$timeout){
        init();
        function init(){
            //queryTable();
        }
        $common.get_asyncData('/select',{}).then(function(res){
            $scope.doubleSelect=res.contextData;
        })
        $common.get_asyncData('/guide',{}).then(function(res){
            $scope.guide= res.contextData;
        })
        //分页--------开始-------------------------
        $scope.conf= {//
            pageNo: 1,
            pageSize: 10
        }
        $scope.$watch("conf.pageNo+conf.pageSize",queryTable($scope.conf))
        //分页------结束-------------------------
        //表格--------开始-------------------------
        function queryTable(paramData){
            var data= {
                pageNo: 1,
                pageSize: 10,
                data:paramData
            }
            var promise = $common.get_asyncData("orgUserService/findOrgUserByPage",data);
            promise.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    $scope.datasource = data.records;
                    $scope.conf.totalRecord = data.totalRecord;

                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })
        };
        $scope.add_onClick = function(){
            $scope.orgUser={}
            $common.get_ngDialog('addDialog.html',$scope).then(function(){
                var primise = $common.get_asyncData("add/",$scope.orgUser);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('新增成功！','showSuccess');
                        queryTable();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
                console.log($scope.orgUser)
            })
        }
        $scope.update_onClick = function(){
            if($scope.selected.length <= 0){
                $common.get_tipDialog('请至少选择一条记录！','showInform');
            }else{
                $scope.orgUser=$scope.selected[0]
                $common.get_ngDialog('addDialog.html',$scope).then(function(){
                    var primise = $common.get_asyncData('update/',$scope.orgUser);
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('更新成功！','showSuccess');
                            queryTable();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                })
            }
        }
        $scope.delete_onClick = function(){
            if($scope.selected.length <= 0){
                $common.get_tipDialog('请至少选择一条记录！','showInform');
            }else{
                $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                    var primise = $common.get_asyncData('delete/',{key:$scope.selected[0].id})
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('删除成功！','showSuccess');
                            queryTable();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                })
            }
        }
        $scope.detail_onClick = function(){
            if($scope.selected.length <= 0){
                $common.get_tipDialog('请至少选择一条记录！','showInform');
            }else{
                $scope.orgUser=$scope.selected[0];
                $common.get_ngDialog('detailDialog.html' ,$scope)
            }
        }
        $scope.orgUser={}
        $scope.searchFunction = function () {
            queryTable();
        };
        //表格--------结束-------------------------

        $scope.leftOptions=["111","222","333","444","555","666"];

        //表单--------开始-------------------------
        $scope.change =function(val){
            $common.get_tipDialog(JSON.stringify(val.dataTrsVal),'showInform')
        }
        $scope.d234_id_onBlur =function(){
            alert(JSON.stringify($scope.myform))
        }
        $scope.submit_onClick =function(){
            if($.doValidate("myform")){//验证表单是否通过
                alert("submit_onClick "+JSON.stringify($scope.myform))
            }
        }
        //表单--------结束-------------------------

        //按钮--------开始-------------------------
        $scope.button_onClick =function(){
            $common.get_tipDialog('根据唯一ID响应点击事件。','showInform');
        }
        $scope.button2_onClick =function(){
            $common.get_tipDialog('恭喜，成功了。','showSuccess');
        }
        $scope.button3_onClick =function(){
            $common.get_tipDialog('哎呀，失败了。','showError');
        }
        $scope.button4_onClick =function(){
            $common.get_tipDialog('注意，这是警告。','showWarning');
        }
        $scope.button5_onClick =function(){
            $common.get_tipDialog('这是提示信息。','showInform');
        }
        $scope.button6_onClick =function(){
            $common.get_tipDialog('请确认。','showTip').then(function (res) {
                if(res){
                    $common.get_tipDialog('谢谢。','showInform');
                }
            });
        }
        //按钮--------结束-------------------------

        //$scope.conf={
        //    currentPage: 1,
        //    itemsPerPage: 5
        //}
        //$scope.datasource=[
        //    {},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},
        //    {},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},
        //    {},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},
        //    {},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}
        //]

        //树--------开始-------------------------
        $scope.dataForTheTree =
            [
                { "name" : "A", "age" : "21","type":"folder", "children" :
                    [
                        { "name" : "B", "age" : "42","type":"folder", "children" :
                            [
                                { "name" : "C", "age" : "21","type":"folder", "children" :
                                    [
                                        { "name" : "D", "age" : "23","type":"folder", "children" :
                                            [
                                                { "name" : "pic", "age" : "32","type":"pic"},
                                                { "name" : "doc", "age" : "34","type":"doc"},
                                                { "name" : "file", "age" : "34","type":"file"},
                                                { "name" : "movie", "age" : "34","type":"movie"},
                                                { "name" : "email", "age" : "34","type":"email"},
                                                { "name" : "home", "age" : "34","type":"home"},
                                                { "name" : "trash", "age" : "34","type":"trash"}
                                            ]}
                                    ]}

                            ]},
                    ]},
                { "name" : "A", "age" : "33","type":"folder", "children" : [
                    { "name" : "B", "age" : "42","type":"folder", "children":[
                        { "name" : "pic", "age" : "32","type":"pic"},
                        { "name" : "doc", "age" : "34","type":"doc"},
                        { "name" : "file", "age" : "34","type":"file"}
                    ]}
                ] },
                { "name" : "file", "age" : "34","type":"file"},
                { "name" : "A", "age" : "29","type":"folder", "children" : [
                    { "name" : "B", "age" : "42","type":"folder", "children":[
                        { "name" : "pic", "age" : "32","type":"pic"},
                        { "name" : "doc", "age" : "34","type":"doc"},
                        { "name" : "file", "age" : "34","type":"file"}
                    ]}
                ] }
            ];
        $scope.showSelected = function(selectedNode){
            $scope.selectedNode = selectedNode;
        }
        //树--------结束-------------------------

        //确认对话
        $scope.openConfirmDialog = function(msg,dialogType){
            $scope.msg = msg;
            $scope.dialogType = dialogType;
            ngDialog.openConfirm({
                //template: '<div class="ngdialog-message"><h3>Please enter your name</h3><p>User Name:<input ng-model="userName"></input></p></div><div class="ngdialog-buttons"><button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="closeThisDialog(userName)">Cancel</button><button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="confirm(userName)">Confirm</button></div>',
//                  template: 'mx/ngConfirmDialog.html',
                template: 'mx/ngDialog.html',
                plain: false,//判断是否使用html页作为模板，false-使用html页模�?
                className: 'ngdialog-theme-default',
                scope:$scope //将scope传给ngDialog.html,以便判断类型
            }).then(
                function(value){
                    console.log('confirmed, value - ', value);
                },
                function(reason){
                    console.log('rejected, reason - ', reason);
                }
            );
        };

        /////////----------------------进度条------开始-------------------
        var t =0;
        var myInterval =function (){
            t +=5;
            $scope.percent =t;
            console.log($scope.percent)
        }
        var timer = $timeout(myInterval,500);
        $scope.$watch('percent',function(newval,oldval){
            if(newval!==oldval &&newval!==100){
                timer=$timeout(myInterval,500);
            }
        })
        /////////----------------------进度条------结束--------------------

        /////////----------------------按钮式菜单------开始--------------------
        $scope.menu = [
            {name:'java',code:'_java'},
            {name:'c',code:'_java'},
            {name:'oracle',code:'_java'},
            {name:'javascript',code:'_java'}
        ]
        $scope.selectedMenu = function(item){
            alert("选择的是 "+JSON.stringify(item));
        }
        /////////----------------------按钮式菜单------结束--------------------

        /////////----------------------导航------开始--------------------
        $scope.selectedNav = function(item){
            alert("选择的是 "+JSON.stringify(item));
        }
        /////////----------------------导航------结束--------------------
    })
}());