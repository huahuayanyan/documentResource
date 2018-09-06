/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/6/7
 */
//var SYSNAME = "消费信贷信息系统";
//var _HTTP_IP_PORT = "http://170.252.200.63:18081/authority-app/";
//var _HTTP_IP_PORT = 'http://170.252.200.36:18080/authority-app/';
//var _HTTP_IP_PORT = 'http://170.252.199.126:18080/authority/';
var _HTTP_IP_PORT = "http://127.0.0.1:8082/authority-app/";
var _JSON_URL = '../../data.json';

//'mock':请求_JSON_URL指定的本地文件;  'common':请求_HTTP_IP_PORT指定的远程接口
var _REQUEST_DSSIGN = 'common';
//当'mock'开发模式时，数组里的服务以'common'模式请求 'loginService/login',
//var _REQUEST_DSSIGN_LOGIN =['loginService/login','bdDataDictService/getDataBySysCode','bdDataDictService/getAllDefaultJsonData'];
var _REQUEST_DSSIGN_LOGIN =['loginService/login']
try {
    var _href = location.href.split('/');
    if(_REQUEST_DSSIGN!='mock'&&_href[2].indexOf("localhost")==-1){
        _HTTP_IP_PORT = _href[0]+"//"+_href[2]+"/"+_href[3]+"/"
    }
}catch (e){}