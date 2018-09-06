/**
 * Created by wubin on 2016/7/22.
 */

//扩展String.trim
String.prototype.trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g,"");
};
String.prototype.ltrim = function(){
    return this.replace(/(^\s*)/g,"");
};
String.prototype.rtrim = function(){
    return this.replace(/(\s*$)/g,"");
};


(function (){
    var Y = window,
        N = "document",
        C = "getElementsByTagName";
    var J = function (fileName) {
        var _, A, $ = Y[N][C]("script");
        for (var B = 0; B < $.length; B++) {
            _ = $[B].getAttribute("src") || "";
            _ = _.substr(0, _.toLowerCase().indexOf('initialize.js'));
            A = _.lastIndexOf("/");
            if (A > 0) {
                if(_.toLowerCase().indexOf("scube_ui")>-1){
                    _ = _.substr(0, _.toLowerCase().indexOf("scube_ui"));
                }else{
                    _ = _.substr(0, _.toLowerCase().indexOf("common_module"));
                    _ +='../';
                }
                A = _.lastIndexOf("/");
                _ = _.substring(0, A + 1);
            }
            if (_) break
        }
        return _+fileName
    }
    var doAjax = function(fileName){
        $.ajax({
            type :'get',
            async : false,
            data :"",
            url :J(fileName+".json"),
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            dataType : "json",
            success : function(res) {
                window[fileName] = res[fileName];
            },
            error : function(res) {
                if(res.status=='200'){
                    window[fileName] = JSON.parse(res.responseText)[fileName];
                }else {
                    console.log("ajax错误");
                }
            }
        });
    }
    doAjax('dictionary');
    doAjax('validate');
    //doAjax('validateErrMsg');
    doAjax('zValidate');

    //$('form').each(function (i,e) {
    //    $(e).on('click')
    //})
    //定义一个验证器
    $.Validator=function(para) {}
    $.Validator.ajaxValidate=function(formName) { return beforeSubmit(formName);}
    //验证的方法
    $.Validator.match=function(para) {
        //定义默认的验证规则
        var defaultVal = {
            NUMBER : "^[0-9]*$",
            TEL : "^0(10|2[0-5789]|\\d{3})-\\d{7,8}$",
            IP : "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$",
            MOBILE : "^1(3[0-9]|5[0-35-9]|8[0235-9])\\d{8}$",
            MAIL : "^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$",
            IDENTITY : "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))",
            CHINESE : "^([\u4E00-\uFA29]|[\uE7C7-\uE7F3])*$",
            URL : "^http[s]?://[\\w\\.\\-]+$"
        };
        var flag=true;
        var errMsg =[];

        //新修改的代码 测试用  --- yangfan begin
        if(para.rule=='OTHER') {//自定义的验证规则匹配
            //flag=new RegExp(para.regString).test(para.data);
            if(window.validate && window.zValidate) {

                var ruleName=para.regString.split(",");
                for (var j = 0; j < ruleName.length; j++) {
                    if (ruleName[j].indexOf("common.")>-1) {
                        var aliasName = ruleName[j].split(".")[1];
                        if(window.zValidate.ruleName.indexOf(aliasName)>-1){
                            var _flag = true;
                            if (window.zValidate[aliasName].rule != null) {
                                var rule = window.zValidate[aliasName].rule;
                                var value = para.data==null?"":para.data.trim();
                                if(rule=="IS_NOT_NULL"){
                                    if(value=="" || value=="undefined" || value=="null"){
                                        flag=_flag = false;
                                    };
                                }else {
                                    if(!(eval(rule)).test(para.data)){
                                        flag=_flag = false;
                                    };
                                }
                                if(!_flag)errMsg.push(window.zValidate[aliasName].errMsg);
                            }
                        }
                    }else {
                        for (i = 0; i < window.validate.length; i++) {
                            var _flag = true;
                            var newArr = window.validate[i];
                            if (newArr.ruleName == ruleName[j]) {
                                if (newArr.rule != null) {
                                    var rule = newArr.rule;
                                    var value = para.data==null?"":para.data.trim();
                                    if(rule=="IS_NOT_NULL"){
                                        if(value=="" || value=="undefined" || value=="null"){
                                            flag=_flag = false;
                                        };
                                    }else {
                                        if(!(eval(rule)).test(para.data)){
                                            flag=_flag = false;
                                        };
                                    }
                                    if(!_flag)errMsg.push(newArr.errMsg);
                                }else{
                                    throw Error("validate["+i+"].rule is Invalid.");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if(para.rule in defaultVal) {//默认的验证规则匹配
                flag=new RegExp(defaultVal[para.rule]).test(para.data);
            }
        }
        return {
            flag:flag,
            errMsg:errMsg
        };
    }
    //为jquery扩展一个doValidate方法，对所有的元素进行表单验证，可用于ajax提交前自动对表单进行验证
    $.extend({
        doValidate: function(formName) {
            return $.Validator.ajaxValidate(formName);
        }
    });
}())


//输入框焦点离开后对文本框的内容进行格式验证
function validateBefore() {
    if(!$(this).attr('reg-string'))return;
    //$("div").remove(".tip-yellowsimple");
    $(this).css("borderColor","#e3e3e3");
    //验证通过标识
    var flag=true;
    var data = $(this).val();
    if($(this).attr('_input_select_')&&$(this).attr('_input_select_')=="htSelect"){
        data = $(this).attr('dataVal');
    }
    var rtn=$.Validator.match({data:data,rule:"OTHER", regString:$(this).attr('reg-string')});
    flag = rtn.flag;
    var errMsg = rtn.errMsg.join(",");
    var _option = {
        className: 'tip-yellowsimple',
        content: errMsg,
        showOn: 'none',
        alignTo: 'target',
        alignX: 'right',
        alignY: 'center',
        offsetX: 5,
        offsetY: 10
    };
    if($(this).attr('poppositon')&&$(this).attr('poppositon')=="htInputExtent"){
        //先清除原来的tips
        $(this).next().poshytip('hide');
        $(this).next().poshytip(_option );
        //如果验证没有通过，显示tips
        if(!flag) {
            $(this).next().poshytip('show');
            $(this).css("borderColor","#fd8484");
        }
    }else {
        $(this).poshytip('hide');
        $(this).poshytip(_option );
        if(!flag) {
            $(this).poshytip('show');
            $(this).css("borderColor","#fd8484");
        }
    }
}

//submit之前对所有表单进行验证
function beforeSubmit(formName) {
    //$("div").remove(".tip-yellowsimple");
    var flag=true;
    $("form[name="+formName+"]").find("[reg-string]").each(function(i, n) {
        if(!$(this).attr('reg-string') ||$(this).parents("label").hasClass('ng-hide'))return;
        var _flag=true;
        var data = $(this).val();
        if($(this).attr('_input_select_')&&$(this).attr('_input_select_')=="htSelect"){
            data = $(this).attr('dataVal');
        }
        $(this).css("borderColor","#e3e3e3");

        if($(this).attr('poppositon')&&$(this).attr('poppositon')=="htInputExtent"){
            $(this).next().poshytip('hide');
        }else $(this).poshytip('hide');
        var rtn = ($.Validator.match({data:data, rule:"OTHER", regString:$(this).attr('reg-string')}));
        _flag = rtn.flag;
        if(!_flag) {
            var errMsg = rtn.errMsg.join(",");
            var _option = {
                className: 'tip-yellowsimple',
                content: errMsg,
                showOn: 'none',
                alignTo: 'target',
                alignX: 'right',
                alignY: 'center',
                offsetX: 5,
                offsetY: 10
            };
            if($(this).attr('poppositon')&&$(this).attr('poppositon')=="htInputExtent"){
                $(this).next().poshytip(_option );
                $(this).next().poshytip('show');
            }else {
                $(this).poshytip(_option );
                $(this).poshytip('show');
            }
            $(this).css("borderColor","#fd8484");
            flag=false;
        }
    });
    return flag;
}


//下面是测试代码，不属于验证器的功能代码之内
//用原型的方式来模拟js的类
function Validators() {}
Validators.prototype.subByJs=function(e) {
    if($.doValidate()) {
        alert('验证通过');
        //todo
    }
}