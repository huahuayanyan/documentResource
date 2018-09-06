/**
 * Created by wubin on 2016/8/4.
 */

(function (){
    //var trustedOrigin = 'http://localhost:63342';
    try {
        var __SELF = JSON.parse(window.top.name);
        if(typeof __SELF=='object' && !__SELF.hasOwnProperty("_SELF")){
            __SELF._SELF = false;
        }
    }catch (e){
        var __SELF = {
            _SELF : false
        }
    }
    function messageHanler(ev) {
        //if(__SELF._SELF){
            //if(ev.origin == trustedOrigin){
            //跨域接收信息
            var originObject = ev.data;
            try{
                originObject =JSON.parse(originObject);
            }catch (e){
                originObject =originObject;
            }
            window.userInfo = originObject.userInfo;
            window.authorization=originObject.authorization;
            window.httpIpPort = originObject._HTTP_IP_PORT;
            //window.redirectLoginUrl = originObject.redirectLoginUrl;
            if(originObject.dictionary){
                window.dictionary = originObject.dictionary;
            }
            if(originObject.appBusUrl){
                window._HTTP_IP_PORT = originObject.appBusUrl;
            }
            //手动拉起angular应用程序
            angular.element(document).ready(function() {
                angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
            });
//    }else {
//        alert("接收的消息不是来自可信的源！！！");
//    }
//        }
    }
    function loadHanler() {
        //if(!__SELF._SELF){
        //    //window.userInfo = {};
        //    window.authorization=__SELF.authorization;
        //    df.ajax({
        //        url: "commonService/getInitData",
        //        data:{url:"http://170.252.200.62:18081/authority-app/"},
        //        callback:function(res){
        //            if (res.errorCode == 'SUC') {
        //                window.httpIpPort = res.contextData.appBusUrl;
        //                if(res.contextData.appBusUrl){
        //                    window._HTTP_IP_PORT = res.contextData.appBusUrl;
        //                }
        //                window.dictionary = res.contextData.dictMap;//业务系统的数据字典
        //                window.userInfo = res.contextData.userInfo;
        //                //手动拉起angular应用程序
        //                angular.element(document).ready(function() {
        //                    angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
        //                });
        //            }
        //        }
        //    })
        //}
    }
    function addEvent(obj,trigger,fun) {
        if(obj.addEventListener){
            obj.addEventListener(trigger,fun,false);
        }else if (obj.attachEvent){
            obj.attachEvent('on'+trigger,fun);
        }else{
            obj['on'+trigger] = fun;
        }
    }
    addEvent(window,'message',messageHanler);
    addEvent(window,'load',loadHanler);
})()
var _scubeUI = function(){
    this.moduleName;
    var default_dependency=[
        'ui.router',
        'treeControl',
        //'angularFileUpload',
        'autoTree',
        'tableHelper',
        'common'
    ];
    var merge = function (arr1,arr2){
        var arr = arr1.concat(arr2);
        var lastArr = [];
        for(var i = 0;i<arr.length;i++)
        {
            if(! unique(arr[i],lastArr))
            {
                lastArr.push(arr[i]);
            }
        }
        return lastArr;
    };
    var unique = function (n,arr){
        for(var i=0;i<arr.length;i++)
        {
            if(n==arr[i]){
                return true;
            }
        }
        return false;
    };
    this.module = function (moduleName,dependency,routeArry) {
        this.moduleName = moduleName;
        moduleName = moduleName||"";
        dependency = merge(default_dependency,dependency);
        routeArry = routeArry||[];
        angular.module(moduleName,dependency).
        config(function($stateProvider,$urlRouterProvider){
            for(var i=0;i<routeArry.length;i++){
                if(routeArry[i]["default"] == "true"){
                    $urlRouterProvider.when("",routeArry[i].url);
                }
                if(routeArry[i].views==undefined){
                    $stateProvider.state(routeArry[i].state,{
                        url:routeArry[i].url,
                        templateUrl:routeArry[i].templateUrl,
                        controller:routeArry[i].controller
                    });
                }else{
                    var views = {};
                    for(var j=0;j<routeArry[i].views.length;j++){
                        views[routeArry[i].views[j].view]={
                            templateUrl:routeArry[i].views[j].templateUrl,
                            controller:routeArry[i].views[j].controller
                        };
                    };
                    $stateProvider.state(routeArry[i].state,{
                        url:routeArry[i].url,
                        views:views
                    });
                }
            };
        });
        //for(var i=0;i<routeArry.length;i++){
        //    if(routeArry[i].controller){
        //        angular.module(moduleName).
        //        controller(routeArry[i].controller,eval(routeArry[i].controller))
        //    }
        //};
        //手动拉起angular应用程序
        //angular.element(document).ready(function() {
        //    angular.bootstrap(document.getElementsByTagName("body"),[moduleName]);
        //});
    }
}
var scubeUI = new _scubeUI();