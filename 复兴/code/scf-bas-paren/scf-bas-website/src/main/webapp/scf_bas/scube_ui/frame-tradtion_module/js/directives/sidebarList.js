/**
 * Created by wubin on 2016/4/26.
 */
(function () {
    window.frameModule.
    filter('menu_level',function(){
        return function (input,menuLevel,menuItem){
            var arr =[],
                input=input?input:[];
            if(!menuItem){
                if(window._sidebarTopitem_){
                    menuItem = window._sidebarTopitem_
                }else {
                    menuItem={menuCode:0};
                }
            }
            arr = input.filter(function (element,index,_input) {
                return (element.menuLevel == menuLevel&&element.menuParentId ==menuItem.menuCode)
            })
            arr = arr.map(function (elem) {
                var existChild = false;
                elem.existChildren = false;
                for (var i = 0;i<input.length;i++){
                    if(input[i].menuParentId == elem.menuCode){
                        existChild = true;
                        break;
                    }
                }
                if(existChild) {
                    elem.existChildren = true
                }
                return elem;
            })
            return arr;
        }
    }).
    directive('sidebarUl',function ($interval,$window,$common,$compile) {
        return {
            restrict :'E',
            template :'<div></div>',
            link : function (scope,elem,attrs) {
                scope.creatSidebar = function(firstLevel){             
                    if(Array.isArray(scope.sidebarList)){
                        var c_temp;//临时模板对象
                        var sidebarTemp = {};//模板对象
                        var tempDiv = $('<div id="_sidebarList_" style="display: none;">');
                        var groupBy = function(objectArr,fn){
                            var result = {}
                            for(var i= 0,length = objectArr.length;i<length;i++){
                                var key = fn(objectArr[i],i);
                                if(result.hasOwnProperty(key)){
                                    result[key].push(objectArr[i]);
                                }else {
                                    result[key] = [objectArr[i]];
                                }
                            }
                            return result;
                        }
                        var _sidebarObj = groupBy(scope.sidebarList,function(value,index){
                            return value.menuParentId;
                        });
                        angular.forEach(_sidebarObj,function(value,index){
                            value.sort(function(a,b){
                                if(a.showSeq>b.showSeq){
                                    return 1;
                                }
                                if(a.showSeq<b.showSeq){
                                    return -1;
                                }
                                return 0;
                            });
                            if(index == '0' || (firstLevel != undefined && index ==firstLevel)){
                                var html = '';
                                for(var i=0;i<value.length;i++){
                                    html +='<li menucode="'+value[i].menuCode+'">' +
                                        "<a href='#' ng-click='clickToPage("+JSON.stringify(value[i])+")'>" +
                                        '<i class="'+value[i].iconName+'"></i>' +
                                        '<span class="menu-text">'+value[i].menuName+'</span></a></li>';
                                }
                            }else {
                                var html = '<ul class="submenu">';
                                for(var i=0;i<value.length;i++){
                                    html +='<li menucode="'+value[i].menuCode+'">' +
                                        "<a href='#' ng-click='clickToPage("+JSON.stringify(value[i])+")'>" +
                                        '<i class="'+value[i].iconName+'"></i>'+value[i].menuName+'</a></li>';
                                }
                                html +='</ul>';
                            }
                            sidebarTemp[index] = html;
                        });
                        do {
                            c_temp = angular.copy(sidebarTemp);
                            angular.forEach(sidebarTemp,function(value,index){
                                if(index == '0' || (firstLevel != undefined && index ==firstLevel)){
                                    tempDiv.append(value);
                                    delete sidebarTemp[index];
                                }
                                if(tempDiv.find("li[menucode="+index+"]").length==1){
                                    tempDiv.find("li[menucode="+index+"]").append(value);
                                    tempDiv.find("li[menucode="+index+"]>a").addClass('dropdown-toggle')
                                    tempDiv.find("li[menucode="+index+"]>a").append('<b class="arrow icon-angle-right"></b>');
                                    delete sidebarTemp[index];
                                }
                            })
                        }while (Object.keys(sidebarTemp).length>0 && !angular.equals(sidebarTemp,c_temp));
                        angular.element(document.body).find("#sidebarList").empty().append($compile(tempDiv.html())(scope));
                        //angular.element(elem).parent().empty().append($compile(tempDiv.html())(scope));
                        tempDiv.remove();
                    }
                };
                //----------------------------------------------------
                try {
                    var winName = JSON.parse(window.name);
                    winName._SELF = true;
                    window.name= JSON.stringify(winName);
                }catch (e){
                    window.name= JSON.stringify({"_SELF":true});
                }

                var height=($(window).height()-$("#navbar").height()-86);
                var doIframe ={
                    createIframe:function (menuCode){
                        var iframe = '<iframe id="'+menuCode+'" width="100%" frameborder="0" scrolling="yes"></iframe>';
                        $('#iframes').append(iframe);
                        $('#'+menuCode).css('height',height);
                    },
                    checkIframe:function(menuCode){
                        if($('#'+menuCode).length){
                            $('#'+menuCode).remove();
                        }
                    }
                }
                var originData = {
                    authorization:sessionStorage.getItem("authorization"),
                    _HTTP_IP_PORT:_HTTP_IP_PORT,
                    userInfo:scope.userInfo
                };
                var toSysPage = function(item){
                    var _busyDictionary = sessionStorage.busyDictionary?JSON.parse(sessionStorage.busyDictionary):{};
                    originData.appBusUrl = item.appBusUrl;//业务系统ajax请求时的url
                    var menuId =item.menuCode;
                    //var menuPath =item.menuPath;
                    //var menuUrl =item.menuUrl;
                    var menuName =item.menuName;
                    var url = item.appUiUrl+item.pagepath;//scube_ui菜单跳转时的url
                    if(item.pagepath){
                        //获取默认数据字典item.appCode
                        if((typeof _busyDictionary[item.appCode] != 'undefined') && _busyDictionary[item.appCode] != null){
                            originData.dictionary = _busyDictionary[item.appCode];
                            iframePage();
                        }else {
                            $common.get_asyncData('bdDataDictService/getDataBySysCode',{sysCode:item.appCode})
                                .then(function (res) {
                                    if(res.errorCode=='SUC'){
                                        originData.dictionary = res.contextData;//业务系统的数据字典
                                        _busyDictionary[item.appCode] = res.contextData;//缓存字典项
                                        sessionStorage.setItem('busyDictionary',JSON.stringify(_busyDictionary));
                                        iframePage();
                                    }else {
                                        $common.get_tipDialog(res.errorMsg,'showError')
                                    }
                                });
                        }
                    };
                    function iframePage(){
                        doIframe.checkIframe(menuId);
                        doIframe.createIframe(menuId);
                        var showNum = scope.cTabpanelFrame.addLiFun({title : menuName , content : $("#"+menuId) , url : url , closeable : true ,item:item });
                        //判断子页面加载完之后，再使用postMesssage
                        var frame = document.getElementById(menuId);
                        if (frame.attachEvent){
                            frame.attachEvent("onload", function(){
                                var _originData = JSON.stringify(originData);
                                if ((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN == "common") {
                                    frame.contentWindow.postMessage(_originData,item.appUiUrl);
                                } else if (typeof _REQUEST_DSSIGN !=='undefined'&& _REQUEST_DSSIGN == "mock") {
                                    frame.contentWindow.postMessage(_originData,'*');
                                } else {
                                    frame.contentWindow.postMessage(_originData,item.appUiUrl);
                                }
                            });
                        }
                        else {
                            frame.onload = function(){
                                if ((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN == "common") {
                                    frame.contentWindow.postMessage(originData,item.appUiUrl);
                                } else if (typeof _REQUEST_DSSIGN !=='undefined'&& _REQUEST_DSSIGN == "mock") {
                                    frame.contentWindow.postMessage(originData,'*');
                                } else {
                                    frame.contentWindow.postMessage(originData,item.appUiUrl);
                                }
                            };
                        }
                        scope.cTabpanelFrame.showLiFun(showNum);
                        scope.breadcrumb=[];
                        scope.bread(item);
                        scope.breadcrumb.reverse();
                    }

                }
                //过滤面包屑
                scope.bread =function(breadmenu){
                    if(breadmenu.menuLevel!=1){
                        for(var i= 0;i<scope.sidebarList.length;i++){
                            if(scope.sidebarList[i].menuCode==breadmenu.menuParentId){
                                scope.breadcrumb.push(breadmenu);
                                scope.bread(scope.sidebarList[i]);
                                break;
                            }
                        }
                    }else{
                        scope.breadcrumb.push(breadmenu);
                    }
                };
                scope.clickToPage =function (item) {
                    toSysPage(item);
                };
                function mainIsMenu(mainUrl){
                    var flag=false;
                    var item ='';
                    var menuUrl ='';
                    try {
                        for(var i=0;i<scope.sidebarList.length;i++){
                            item = scope.sidebarList[i];
                            menuUrl = item.appUiUrl+item.pagepath;
                            if(mainUrl == menuUrl){
                                flag=true;
                                break;
                            }
                        }
                        if(flag){
                            return item;
                        }else {
                            return '';
                        }
                    }catch(e){
                        return '';
                    }

                }
                //获取默认数据字典
                $common.get_asyncData('bdDataDictService/getAllDefaultJsonData').then(function (res) {
                        if(res.errorCode=='SUC'){
                            var default_dictionary = res.contextData;
                            try {
                                //判断是否显示导航栏一级菜单
                                if(default_dictionary.navMenu){
                                    var navbar = default_dictionary.navMenu.dataItems[0].dataVal;
                                }
                                document.title = default_dictionary.sysName.dataItems[0].dataTrsVal||"华腾软件系统";
                                //scope.sysName = default_dictionary.sysName.dataItems[0].dataVal||"华腾软件系统";
                                var mainObj ={};
                                var menuName = default_dictionary.main_menuName.dataItems[0].dataVal;
                                mainObj ={
                                    menuCode:'default_main',
                                    menuName:menuName||'我的主页',
                                    appCode:default_dictionary.main_appCode.dataItems[0].dataVal,
                                    appBusUrl:default_dictionary.main_appBusUrl.dataItems[0].dataVal,
                                    appUiUrl:default_dictionary.main_appUiUrl.dataItems[0].dataVal,
                                    pagepath:default_dictionary.main_pagePath.dataItems[0].dataVal
                                }
                                scope.nav_menu_bars = [];
                                if(navbar=='2'){
                                    $common.get_asyncData('funcService/getTopFunc').then(function (res) {
                                        if(res.errorCode=='SUC'){
                                            scope.nav_menu_bars = res.contextData;
                                            if(!scope.nav_menu_bars || scope.nav_menu_bars.length==0){
                                                $common.get_tipDialog("没获取到菜单数据！","showInform");
                                            }else {
                                                scope.toSideBar(scope.nav_menu_bars[0],0);
                                            }
                                        }else {
                                            $common.get_tipDialog(res.errorMsg,'showError')
                                        }
                                    });
                                    toSysPage(mainObj);
                                }else {
                                    //获取菜单
                                    var promise = $common.get_asyncData('funcService/selectAppByTlrList',{funcInfoVO:{}});
                                    promise.then(function (res) {
                                        if(res.errorCode=='SUC'){
                                            scope.sidebarList =res.contextData;
                                            if(!scope.sidebarList || scope.sidebarList.length==0){
                                                $common.get_tipDialog("没获取到菜单数据！","showInform");
                                            }else {
                                                scope.creatSidebar();
                                            }
                                            /*判断主页url是否等于某个菜单--begin*/
                                            var mainUrl= default_dictionary.main_appUiUrl.dataItems[0].dataVal+ default_dictionary.main_pagePath.dataItems[0].dataVal;
                                            var item = mainIsMenu(mainUrl);
                                            if(item!=''){
                                                toSysPage(item);
                                                return;
                                            }
                                            toSysPage(mainObj);
                                            /*判断主页url是否等于某个菜单--end*/
                                        }else {
                                            $common.get_tipDialog(res.errorMsg,'showError')
                                        }
                                    });
                                }
                            }catch (e){
                                if(navbar=='2'){
                                    $common.get_asyncData('funcService/getTopFunc').then(function (res) {
                                        if(res.errorCode=='SUC'){
                                            scope.nav_menu_bars = res.contextData;
                                            if(!scope.nav_menu_bars || scope.nav_menu_bars.length==0){
                                                $common.get_tipDialog("没获取到菜单数据！","showInform");
                                            }else {
                                                scope.toSideBar(scope.nav_menu_bars[0],0);
                                            }
                                        }else {
                                            $common.get_tipDialog(res.errorMsg,'showError')
                                        }
                                    });
                                }else {
                                    //获取菜单
                                    $common.get_asyncData('funcService/selectAppByTlrList', {funcInfoVO: {}}).then(function (res) {
                                        if (res.errorCode == 'SUC') {
                                            scope.sidebarList = res.contextData;
                                            if(!scope.sidebarList || scope.sidebarList.length==0){
                                                $common.get_tipDialog("没获取到菜单数据！","showInform");
                                            }else {
                                                scope.creatSidebar();
                                            }
                                        } else {
                                            $common.get_tipDialog(res.errorMsg, 'showError')
                                        }
                                    });
                                }
                                mainObj ={
                                    appCode:'default',menuCode:'default_main',menuName:'我的主页',
                                    appUiUrl:'',appBusUrl:'', pagepath:''
                                }
                                toSysPage(mainObj);
                            }
                        }else {
                            $common.get_tipDialog(res.errorMsg,'showError')
                        }
                    });
            },
            replace :true
        }
    }).
    directive('iframes',function () {
        return {
            restrict :'E',
            template :'<iframe ng-repeat="item in sidebarList" ng-if="item.pagepath"' +
            ' id="{{item.menuCode}}" width="100%" frameborder="0" scrolling="yes" ng-style="theight"></iframe>',
            link: function (scope,elem,attrs) {
                //$("#mybreadcrumb").height()+$("#iframeHeadDiv").height()=40+24+10+10
                scope.theight={
                    height: ($(window).height()-$("#navbar").height()-86)+"px",
                    display: "none"
                };
            },
            replace :true
        }
    }).
    directive('breadCrumb',function () {
        return {
            restrict :'E',
            template :'<div id="mybreadcrumb" class="mybreadcrumb">' +
            '<section ng-repeat="crumb in breadcrumb" ng-click="selectBread(crumb)">' +
            '<img ng-if="!$first" src="../../images/breadcrumb1.png">' +
            '<span ng-class="{\'hover\':$last}" ng-bind="crumb.menuName"></span>' +
            '<img src="../../images/breadcrumb2.png"></section>' +
            '</div>',
            link: function (scope,elem,attrs) {
                scope.selectBread = function(crumb){

                    var url = crumb.appUiUrl+crumb.pagepath;//scube_ui菜单跳转时的url
                    if(crumb.pagepath){
                        scope.breadcrumb=[];
                        scope.bread(crumb);
                        scope.breadcrumb.reverse();
                        scope.cTabpanelFrame.showLiFunByUrl(url);
                    }
                };
            },
            replace :true
        }
    }).
    directive('mainIframe',function () {
        return {
            restrict :'E',
            templateUrl :'home2.html',
            controller: function ($scope,$common) {
                $scope.conf= {
                    pageNo: 1,
                    pageSize:10
                }
                $scope.selected={
                    select :[]
                };
                $scope.mainTableLeft ={}
                $scope.conf2= {
                    pageNo: 1,
                    pageSize:10
                }
                $scope.selected2={
                    select :[]
                };
                $scope.mainTableRight ={}
                var reduceHeight=$(window).height()-110;
                $('.mainIframe-left').height(reduceHeight);
                //var promise = $common.get_asyncData("/mainTableLeft");
                //promise.then(function(res){
                //    var data;
                //    if (res.errorCode =="SUC"){
                //        data = res.contextData;
                //        $scope.mainTableLeft.ds = data.records;
                //        $scope.conf.totalRecord = data.totalRecord;
                //    }else{
                //        $common.get_tipDialog(res.errorMsg,'showError');
                //    }
                //});

                //var promise2 = $common.get_asyncData("/mainTableRight");
                //promise2.then(function(res){
                //    var data;
                //    if (res.errorCode =="SUC"){
                //        data = res.contextData;
                //        $scope.mainTableRight.ds = data.records;
                //        $scope.conf2.totalRecord = data.totalRecord;
                //    }else{
                //        $common.get_tipDialog(res.errorMsg,'showError');
                //    }
                //});
                //var promise3 = $common.get_asyncData("/getEcharts");
                //promise3.then(function(res){
                //    if (res.errorCode =="SUC"){
                //        $scope.chartData = res.contextData;
                //    }else{
                //        $common.get_tipDialog(res.errorMsg,'showError');
                //    }
                //});
            },
            /*
             controller:function ($scope,$common) {
             $scope.top = [];
             $scope.bottom = [];
             $common.get_asyncData('/top').then(function (res) {
             $scope.top = res.contextData;
             });
             $common.get_asyncData('/bottom').then(function (res) {
             $scope.bottom = res.contextData;
             });
             $scope.cart = [];
             //登陆
             if(!sessionStorage.getItem('sessionToken')){
             $scope.myLogin = function () {
             $common.get_ngDialog('login-box.html', $scope,420);
             };
             }else {
             $('.mymain-login').fadeIn();
             }
             //登出
             $scope.loginOut= function () {
             $('.mymain-login').toggle();
             };
             var ss = [];
             $scope.cart = $scope.cart.concat(ss);
             //删除
             $scope.removeTop = function (item) {
             for (var i = 0; i < $scope.top.length; i++) {
             if ($scope.top[i].className == item.className) {
             $scope.top.splice(i, 1);
             break;
             }
             }
             };
             $scope.removeBottom = function (item) {
             for (var i = 0; i < $scope.cart.length; i++) {
             if ($scope.cart[i].className == item.className) {
             $scope.cart.splice(i, 1);
             break;
             }
             }
             };
             //功能弹窗
             $scope.ngDialogOpen = function () {
             $common.get_ngDialog('ngDialog.html', $scope, 1000);
             };
             //添加
             $scope.addMark = function (item) {
             var flag = false;
             for (var index = 0; index < $scope.cart.length; index++) {
             if ($scope.cart[index].text == item.text) {
             flag = true;
             }
             }
             //如果没有，该item添加到数组中
             if (!flag) {
             item.mark = 1;
             $scope.cart.push(item);
             }
             console.log($scope.cart);
             };
             //跳转组件页面
             $scope.gotoComponent = function () {
             location.href = '../../component_module/html/component.html';
             };
             },
             */
            replace :true
        }
    })
}());