/**
 * Filename:loginController.js
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/30
 */
var loginController1 = function($common,$scope,$cookieStore,$cookies,$location){
    var SYSNAME ='';
    $scope.sysName="";
    $common.get_asyncData('bdDataDictService/getAllDefaultJsonData')
        .then(function (res) {
            if(res.errorCode=='SUC'){
                var default_dictionary = res.contextData;
                try {
                    SYSNAME = default_dictionary.sysName.dataItems[0].dataVal;
                }catch (e){}
            }
            if(typeof SYSNAME =="undefined" ||SYSNAME =="null" || SYSNAME ==""){
                SYSNAME = ""
            }
            $scope.sysName = SYSNAME;
        });
    function setCookie(name, value, expires, path, domain, secure) {
        var d = new Date();

        if ( typeof(expires) == 'object' && expires.toGMTString ) {
            expires = expires.toGMTString();
        } else if ( parseInt(expires, 10) ) {
            d.setTime( d.getTime() + ( parseInt(expires, 10) * 1000 ) ); // time must be in miliseconds
            expires = d.toGMTString();
        } else {
            expires = '';
        }

        document.cookie = name + "=" + encodeURIComponent(value) +
            ((expires) ? "; expires=" + expires : "") +
            ((path) ? "; path=" + path : "") +
            ((domain) ? "; domain=" + domain : "") +
            ((secure) ? "; secure" : "");
    };
    function getCookie(name) {
        var cookie = document.cookie, e, p = name + "=", b;

        if ( !cookie )
            return;

        b = cookie.indexOf("; " + p);

        if ( b == -1 ) {
            b = cookie.indexOf(p);

            if ( b != 0 )
                return null;

        } else {
            b += 2;
        }

        e = cookie.indexOf(";", b);

        if ( e == -1 )
            e = cookie.length;

        return decodeURIComponent( cookie.substring(b + p.length, e) );
    };
    //setCook("sessionToken",1111111111, 5000,'/');
    $scope.login = function () {
        if($scope.checkLogin &&$scope.checkLogin()){return;}
        var data={
            userInfo:$scope.loginForm
        };
        var promise_login = $common.get_asyncData('loginService/login',data);
        promise_login.then(function (res) {
            if(res.errorCode=='SUC'){
                sessionStorage.setItem('authorization',res.contextData.id);

                try {
                    var winName = JSON.parse(window.name);
                    winName.authorization = res.contextData.id;
                    window.name= JSON.stringify(winName);
                }catch (e){
                    console.log(e);
                    window.name= JSON.stringify({authorization:res.contextData.id});
                }

                //localStorage.setItem('authorization',res.contextData.id);
                location.href = '../../frame-tradtion_module/html/frame.html';
                sessionStorage.setItem('userInfo',JSON.stringify(res.contextData));
            }else {
                $common.get_tipDialog(res.errorMsg,'showError')
            }
        });
    }


}