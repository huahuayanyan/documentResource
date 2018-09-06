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
                menuItem={menuId:""};
            }
            arr = input.filter(function (element,index,_input) {
                return (element.menuLevel == menuLevel&&element.menuParentId ==menuItem.menuId)
            })
            return arr;
        }
    }).
    directive('sidebarUl',function () {
        return {
            restrict :'E',
            template :'<ul class="nav nav-list dropdown-menu" style="height: 250px">'+
            '<li ng-repeat="item1 in sidebarList|menu_level:1">'+
            '<a href="#"  ng-click="clickToPage(item1.menuId,item1.menuPath,item1.menuUrl)">{{item1.menuName}}</a>'+
            '<ul class="nav-list nav nav2">' +
            '<li ng-repeat="item2 in sidebarList|menu_level:2:item1">' +
            '<a>{{item2.menuName}}</a>' +
            '<ul class="nav-list nav nav3">' +
            '<li ng-repeat="item3 in sidebarList|menu_level:3:item2">' +
            '<a>{{item3.menuName}}</a>' +
            '</li></ul>' +
            '</li></ul>'+
            '</li></ul>',
            link : function (scope,elem,attrs,selfCtrl) {
                scope.clickToPage =function () {
                    var menuId =arguments[0];
                    var menuPath =arguments[1];
                    var menuUrl =arguments[2];
                    var url = menuUrl+menuPath;
                    var doms =document.getElementsByTagName('iframe');
                    var closeDiv =document.getElementById('close');
                    var hideDiv =document.getElementById('hide');
                    angular.forEach(doms,function (dom) {
                        var _dom = angular.element(dom);
                        if(_dom.attr('id') == menuId){
                            if(_dom.attr('hide') !== 'hide'){
                                _dom.attr('src',url);
                                //判断子页面加载完之后，再使用postMesssage
                                if (_dom[0].attachEvent){
                                    _dom[0].attachEvent("onload", function(){
                                        if (_REQUEST_DSSIGN == "common") {
                                            _dom[0].contentWindow.postMessage(window.originData,menuUrl);
                                        } else if (_REQUEST_DSSIGN == "mock") {
                                            _dom[0].contentWindow.postMessage(window.originData,'http://localhost:63342');
                                        } else {
                                            $common.get_tipDialog('菜单——非法请求模式！', 'showError');
                                            return;
                                        }
                                    });
                                } else {
                                    _dom[0].onload = function(){
                                        if (_REQUEST_DSSIGN == "common") {
                                            _dom[0].contentWindow.postMessage(window.originData,menuUrl);
                                        } else if (_REQUEST_DSSIGN == "mock") {
                                            _dom[0].contentWindow.postMessage(window.originData,'http://localhost:63342');
                                        } else {
                                            $common.get_tipDialog('菜单——非法请求模式！', 'showError');
                                            return;
                                        }
                                    };
                                }
                            }
                            _dom.removeClass('ng-hide');
                            angular.element(closeDiv).attr('menuId',menuId);
                            angular.element(closeDiv).attr('menuPath',menuPath);
                            angular.element(hideDiv).attr('menuId',menuId);
                            $('#opDiv').show();
                        }else {
                            $('#mainContent').hide();
                            if(_dom.attr('hide') == ''||_dom.attr('hide') == undefined){
                                _dom.attr('src','');
                            }
                            if(!_dom.hasClass('ng-hide')){
                                _dom.addClass('ng-hide');
                            }
                        }
                    })
                };
            },
            replace :true
        }
    }).
    directive('iframes',function () {
        return {
            restrict :'E',
            template :'<iframe ng-repeat="item in sidebarList" id="{{item.menuId}}" width="100%" frameborder="0" scrolling="yes" ng-show={{visible}}></iframe>',
            replace :true
        }
    }).
    directive('close',function ($compile) {
        return {
            restrict :'E',
            template :'<div id="close" style="float: right;font-weight: bold;width: 30px;margin:1px 1px; text-align:center; background-color: red;color: white; cursor:pointer;" ng-click="close()">X</div>',
            link :function (scope,elem,attrs) {
                scope.close =function () {
                    var closeDiv =document.getElementById('close');
                    if(closeDiv.hasAttribute('menuId')){
                        var menuId = closeDiv.getAttribute('menuId');
                        //删除已存在页签数组
                        var _index = scope.tabArry.indexOf(menuId);
                        if(_index >-1){
                            scope.tabArry.splice(_index,1);
                        }
                        //以下是添加到页签
                        var str='';
                        var tabDiv = angular.element(document.getElementById('tabDiv'));
                        scope.tabArry.forEach(function (_menuId) {
                            str += '<div id=tab"'+_menuId+'" style="float: left;width:auto;margin:2px 1px 0; text-align:center; background-color: lightgrey;color: white; cursor:pointer;" ng-click="clickToPage('+_menuId+')">测试菜单'+_menuId+'</div>';
                        });
                        var _str =$compile(str)(scope);
                        tabDiv.empty().append(_str);
                        //以下是缓存到主页的快照
                        scope.cacheArry.splice(0,0,menuId);//在数组头部插入一个menuId
                        if(scope.cacheArry.length >12){//限制数组最长为12
                            scope.cacheArry.splice(12,1);//删除数组最后（第13位）一个menuId
                        }
                        var cacheStr='';
                        var mainContentDiv = angular.element(document.getElementById('mainContent'));
                        var menuPath = closeDiv.getAttribute('menuPath');
                        var timer = new Date();
                        scope.cacheArry.forEach(function (_menuId) {
                            cacheStr += '<div class="mydivider" ng-click="clickToPage('+_menuId+',&apos;'+menuPath+'&apos;)">'+
                                '<p>'+_menuId+'--'+timer.toLocaleString()+'</p>'+
                                '</div>';
                        });
                        var _cacheStr = $compile(cacheStr)(scope);
                        mainContentDiv.empty().append(_cacheStr);
                        var iframe = angular.element(document.getElementById(menuId));
                        iframe.attr('src','');
                        iframe.attr('hide','');//关闭后给此菜单去除隐藏标志
                        iframe.addClass('ng-hide');
                        $('#mainContent').show();
                        closeDiv.removeAttribute('menuId');
                        $('#opDiv').hide();
                    }
                }
            },
            replace :true
        }
    }).
    directive('hide',function ($compile) {
        return {
            restrict :'E',
            template :'<div id="hide" style="float: right;font-weight: bold;width: 30px;margin:1px 0; text-align:center; background-color: lightgrey;color: white; cursor: pointer;" ng-click="hide()">--</div>',
            link :function (scope,elem,attrs) {
                scope.hide =function () {
                    debugger
                    var hideDiv =document.getElementById('hide');
                    if(hideDiv.hasAttribute('menuId')){
                        var menuId = hideDiv.getAttribute('menuId');
                        //添加页签数组
                        if(scope.tabArry.indexOf(menuId)==-1){
                            scope.tabArry.push(menuId);
                        }
                        //以下是添加到页签
                        var str='';
                        var tabDiv = angular.element(document.getElementById('tabDiv'));
                        scope.tabArry.forEach(function (_menuId) {
                            str += '<div id=tab"'+_menuId+'" style="float: left;width:auto;margin:2px 1px 0; text-align:center; background-color: lightgrey;color: white; cursor:pointer;" ng-click="clickToPage('+_menuId+')">测试菜单'+_menuId+'</div>';
                        });
                        var _str = $compile(str)(scope);
                        tabDiv.empty().append(_str);
                        //隐藏后显示主页面操作
                        var iframe = angular.element(document.getElementById(menuId));
                        iframe.attr('hide','hide');//隐藏后给此菜单添加隐藏标志
                        iframe.addClass('ng-hide');
                        $('#mainContent').show();
                        hideDiv.removeAttribute('menuId');
                        $('#opDiv').hide();
                    }
                }
            },
            replace :true
        }
    }).
    directive('mainIframe',function () {
        return {
            restrict :'E',
            templateUrl :'home.html',
            controller:function ($scope,$common,$timeout) {
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
            replace :true
        }
    })
}());