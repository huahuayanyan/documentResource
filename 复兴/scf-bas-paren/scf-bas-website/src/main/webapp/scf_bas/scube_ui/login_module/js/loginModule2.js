/**
 * Created by wubin on 2016/4/18.
 */
(function () {
    if(!Array.prototype.indexOf){
        Array.prototype.indexOf = function(elt){
            var len = this.length >>> 0;
            var from = Number(arguments[1]) || 0;
            from =(from < 0)? Math.ceil(from):Math.floor(from);
            if(from< 0) from+=len;
            for(;from<len;from++){
                if(from in this && this[from]==elt){
                    return from;
                }
            }
            return -1;
        };
    };
    var dependency=[
        'common',
        'ngCookies'
    ];
    window.loginModule = angular.module('loginModule',dependency).
    controller('loginController2',loginController2)

}());
