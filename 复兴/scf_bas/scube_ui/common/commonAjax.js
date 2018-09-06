/**
 * Created by wubin on 2016/12/21.
 */
function dfAjax() {
    var xmlhttp=null;
    var _param={
        type: 'post',
        url: '',
        async: true,
        data: {},
        callback: function(){},
        callbackErr: function(res){
            alert("后台服务异常或超时！\n异常信息：\n"+JSON.stringify(res));
        }
    }

    var httpInterceptor = {
        request: function(config) {
            var tempConfigUrl;
            config.tempConfigUrl=config.url;
            //config.headers.authorization=window.authorization||sessionStorage.getItem("authorization");
            tempConfigUrl = config.url;
            if( (typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN =='mock'){
                if(window._REQUEST_DSSIGN_LOGIN !==undefined && _REQUEST_DSSIGN_LOGIN.indexOf(config.url)!==-1){
                    config.url = _HTTP_IP_PORT+config.url+".htm";
                }else {
                    config.url = _JSON_URL;
                    //config.url = "http://170.252.200.36:18080/authority-app/"+config.url+".htm";
                }
            }else if((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN =='common'){
                if(config.url.indexOf("http")==-1){
                    config.url = _HTTP_IP_PORT+config.url+".htm";
                }
            } else{
                if(config.url.indexOf("http")==-1){
                    config.url = _HTTP_IP_PORT+config.url+".htm";
                }
            }
            var data = {};
            data.scubeHeader = {
                'transCode' :tempConfigUrl,
                'errorCode' :'',
                'errorMsg' :''
            };
            data.scubeBody = {
                'contextData' :{
                    'domainVilidate' :'',
                    'data' :config.data
                }
            };
            config.data = JSON.stringify({
                queryTable: data
            });
        },
        response: function(param,response) {
            response = JSON.parse(response);
            var errorCode = "";
            var errorMsg = "";
            var contextData = "";
            var sessionToken = "";
            if ((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN == "common") {
                errorCode = response.scubeHeader.errorCode;
                errorMsg = response.scubeHeader.errorMsg;
                sessionToken = response.scubeHeader.sessionToken;
                try {
                    contextData = JSON.parse(response.scubeBody.contextData.data);
                }catch (e){
                    contextData ="";
                }
            } else if ((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN == "mock") {
                if(window._REQUEST_DSSIGN_LOGIN !==undefined && _REQUEST_DSSIGN_LOGIN.indexOf(param.tempConfigUrl)!==-1){
                    errorCode = response.scubeHeader.errorCode;
                    errorMsg = response.scubeHeader.errorMsg;
                    sessionToken = response.scubeHeader.sessionToken;
                    try {
                        contextData = JSON.parse(response.scubeBody.contextData.data);
                    }catch (e){
                        contextData ="";
                    }
                }else{
                    errorCode = response[param.tempConfigUrl].scubeHeader.errorCode;
                    errorMsg = response[param.tempConfigUrl].scubeHeader.errorMsg;
                    sessionToken = response[param.tempConfigUrl].scubeHeader.sessionToken;
                    contextData = response[param.tempConfigUrl].scubeBody.contextData.data;
                }
            } else {
                errorCode = response.scubeHeader.errorCode;
                errorMsg = response.scubeHeader.errorMsg;
                sessionToken = response.scubeHeader.sessionToken;
                try {
                    contextData = JSON.parse(response.scubeBody.contextData.data);
                }catch (e){
                    contextData ="";
                }
            }
            response.errorCode = errorCode;
            try{
                if(errorCode=='UNA'){
                    var _href = window.top.location.href.split('/');
                    window.top.location.href = _href[0]+"//"+_href[2]+"/"+_href[3]+"/"+_href[4];
                    return
                };
                response.errorMsg = JSON.parse(errorMsg).error_message;
                response.r = JSON.parse(errorMsg).r;
                response.errorCD = JSON.parse(errorMsg).error_code;
            }catch (e){
                response.errorMsg = errorMsg;
            }
            if (sessionToken){response.sessionToken = sessionToken;}
            response.contextData = contextData;
            return response;
        },
        responseError: function(status,response) {
            response = JSON.parse(response);
            if (status == 401) {
                var data=''
                try {
                    data =encodeURIComponent(response.message);
                    alert(response.message);
                }catch (e){}
                if(response.redirectLoginUrl && response.redirectLoginUrl.indexOf("http")!=-1){
                    window.top.location.href =response.redirectLoginUrl+"?msg="+data;
                }else {
                    var _href = window.top.location.href;
                    if(_REQUEST_DSSIGN =='common'){
                        _href =_href.split('/');
                        window.top.location.href = _href[0]+"//"+_href[2]+"/"+_href[3]+"/";
                    }else {
                        _href = _href.substring(0,_href.indexOf("scube_ui"));
                        window.top.location.href = _href+"scube_ui/login_module/html/login.html?msg="+data;
                    }
                }
            }
            return response
        }
    }
    var getAjaxObj = function(){
        if(window.ActiveXObject){
            xmlhttp= new XDomainRequest();
        }else if (window.XMLHttpRequest) {
            xmlhttp= new XMLHttpRequest();
        }
    }
    this.ajax = function(param){
        param = $.extend({},_param,param);
        if(xmlhttp == null){
            getAjaxObj();
        }
        xmlhttp.onload=function(){
            if(xmlhttp.status==200){
                var res = httpInterceptor.response(param,xmlhttp.responseText);
                param.callback(res);
            }else {
                var res = httpInterceptor.responseError(xmlhttp.status,xmlhttp.responseText);
                param.callbackErr(res);
            }
        }
        if(param.url==undefined || param.url==null|| param.url==''){
            alert("url不能为控");
            return
        }
        httpInterceptor.request(param);
        xmlhttp.open(param.type,param.url,param.async);
        xmlhttp.setRequestHeader("authorization",window.authorization||sessionStorage.getItem("authorization"));
        xmlhttp.setRequestHeader("Content-Type",'application/json');
        try{
            if(param.type=='post'){
                xmlhttp.send(param.data);
            }else {
                xmlhttp.send();
            }
        }catch (e){
            param.callbackErr(e);
        }
    }
}
var df = new dfAjax();