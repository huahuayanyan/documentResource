$(function(){
	window.validate = "" ;
	var Y = window,
		N = "document",
		C = "getElementsByTagName";
	var J = function (filename) {
		var _, A, $ = Y[N][C]("script");
		for (var B = 0; B < $.length; B++) {
			_ = $[B].getAttribute("src") || "";
			_ = _.substr(0, _.toLowerCase().indexOf('common.js'));
			A = _.lastIndexOf("/");
			if (A > 0) {
				_ = _.substr(0, _.toLowerCase().indexOf("scube_ui"));
				A = _.lastIndexOf("/");
				_ = _.substring(0, A + 1);
			}
			if (_) break
		}
		return _+filename;
	}
	$.ajax({
		type :'get',
		async : false,
		data :'',
		url :J("validate.json"),
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json",
		success : function(res) {
			window.validate = res.getValidate
			console.log("validate = " +validate);
		},
		error : function(res) {
			window.validate = res.getValidate;
			console.log(res);
		}
	});
	$.ajax({
		type :'get',
		async : false,
		data :'',
		url :J("validateErrMsg.json"),
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json",
		success : function(res) {
			window.validateErrMsg = res.getValidateErrMsg
			console.log("validateErrMsg = " +validateErrMsg);
		},
		error : function(res) {
			window.validateErrMsg = res.getValidateErrMsg;
			console.log(res);
		}
	});
	//拦截form,在form提交前进行验证
	$('form').on('blur','input',beforeSubmit);

	//为带有valType属性的元素初始化提示信息并注册onblur事件
	//$.each($("[valType]"),function(i, n) {
	//$.each($("[regstring]"),function(i, n) {
	//	//判断是否有自定义msg
	//	var msg;
	//	//设置自定义错误提示信息
	//	if(validateErrMsg) {
	//		for (i = 0; i < window.validateErrMsg.length; i++) {
	//			var newArr = window.validateErrMsg[i];
	//			if (newArr.ruleName == $(n).attr('regString')+".errMsg") {
	//				var errMsg = newArr.errMsg;
	//				msg = errMsg;
	//			}
	//		}
	//	}
    //
	//	if(msg == 'undefined' || msg == null || msg == ''){
	//		if(validate) {
	//			for (i = 0; i < window.validate.length; i++) {
	//				var newArr = window.validate[i];
	//				if (newArr.ruleName == $(n).attr('regString')) {
	//					if (newArr.rule != null) {
	//						var rule = newArr.rule;
	//						var errMsg = newArr.errMsg;
	//						msg = errMsg;
	//					}
	//				}
	//			}
	//		}
	//	}
	//	$(n).poshytip({
	//		className: 'tip-yellowsimple',
	//		content: msg,
	//		showOn: 'none',
	//		alignTo: 'target',
	//		alignX: 'right',
	//		alignY: 'center',
	//		offsetX: 5,
	//		offsetY: 10
	//	});
	//	$(n).on('blur',validateBefore);
	//});

//定义一个验证器
	$.Validator=function(para) {


	}

	$.Validator.ajaxValidate=function() {
		beforeSubmit();
	}

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
		var flag=false;
		//原来的源码   --yangfan begin
		//if(para.rule=='OTHER') {//自定义的验证规则匹配
		//	flag=new RegExp(para.regString).test(para.data);
		//}
		//原来的源码 -- 杨帆 end

		//新修改的代码 测试用  --- yangfan begin
		if(para.rule=='OTHER') {//自定义的验证规则匹配
			//flag=new RegExp(para.regString).test(para.data);
			if(window.validate) {
				for (i = 0; i < window.validate.length; i++) {
					var newArr = window.validate[i];
					if (newArr.ruleName == para.regString) {
						if (newArr.rule != null) {
							var rule = newArr.rule;
							var errMsg = newArr.errMsg;
							flag = (eval(rule)).test(para.data)
						}
					}
				}
			}
		}
		//新修改的代码 测试用  -- yangfan end
		else {
			if(para.rule in defaultVal) {//默认的验证规则匹配
				flag=new RegExp(defaultVal[para.rule]).test(para.data);
			}
		}

		return flag;
	}



//为jquery扩展一个doValidate方法，对所有带有valType的元素进行表单验证，可用于ajax提交前自动对表单进行验证
	$.extend({
		doValidate: function() {
			return $.Validator.ajaxValidate();
		}
	});

});

//输入框焦点离开后对文本框的内容进行格式验证
function validateBefore() {
	//验证通过标识
	var flag=true;
	//获取验证类型
	//var valType=$(this).attr('valType');
	//验证类型默认为OTHER
	var valType="OTHER";

	//获取自定义验证规则名称
	var regString = $(this).attr('reg-string');
	//获取验证不通过时的提示信息
	var msg;
	//
	//if(valType=='OTHER'){
	//	if(window.validate) {
	//		for (i = 0; i < window.validate.length; i++) {
	//			var newArr = window.validate[i];
	//			if (newArr.ruleName == regString) {
	//				if (newArr.rule != null) {
	//					var rule = newArr.rule;
	//					var errMsg = newArr.errMsg;
	//					msg = errMsg;
	//				}
	//			}
	//		}
	//	}
	//}else{
	//	msg = $(this).attr('msg');
	//}

	//自定义的验证字符串
	var regString;

	if(valType=='OTHER') {//如果类型是自定义，则获取自定义的验证字符串
		regString=$(this).attr('reg-string');
		//flag=$(this).val()!=''&&$.Validator.match({data:$(this).val(), rule:$(this).attr('valType'), regString:$(this).attr('regString')});
		flag=$(this).val()!=''&&$.Validator.match({data:$(this).val(), rule:"OTHER", regString:$(this).attr('reg-string')});

		////获取自定义表达式
		//if(window.validate) {
		//	for (i = 0; i < window.validate.length; i++) {
		//		var newArr = window.validate[i];
		//		if (newArr.ruleName == $(this).attr('regString')) {
		//			if (newArr.rule != null) {
		//				var rule = newArr.rule;
		//				msg = newArr.errMsg;
		//			}
		//		}
		//	}
		//}
	}
	else {//如果类型不是自定义，则匹配默认的验证规则进行验证
		if($(this).attr('valType')=='required') {//不能为空的判断
			if($(this).val()=='') {
				flag=false;
			}
		}
		else {//已定义规则的判断
			flag=$(this).val()!=''&&$.Validator.match({data:$(this).val(), rule:$(this).attr('valType')});
		}
	}
	//先清除原来的tips
	$(this).poshytip('hide');
	//如果验证没有通过，显示tips
	if(!flag) {
		$(this).poshytip('show');
	}

}

//submit之前对所有表单进行验证
function beforeSubmit() {
	var flag=true;
	//alert($("[valType]").length);
	//$.each($("[valType]"),function(i, n) {
	$.each($("[reg-string]"),function(i, n) {
		//清除可能已有的提示信息
		$(n).poshytip('hide');

		//var valType = $(n).attr("valType");

		//valType 默认为OTHER
		var valType = "OTHER";

		if(valType =='required') {//对不能为空的文本框进行验证
			if($(n).val()=='') {
				//显示tips
				$(n).poshytip('show');
				flag=false;
			}
		}
		else if(valType =='OTHER') {//对自定义的文本框进行验证
			if(!($(this).val()!=''&&$.Validator.match({data:$(this).val(), rule:"OTHER", regString:$(this).attr('reg-string')}))) {
				$(n).poshytip('show');
				flag=false;
			}
		}
		else {//对使用已定义规则的文本框进行验证
			if(!($(this).val()!=''&&$.Validator.match({data:$(this).val(), rule:$(this).attr('valType')}))) {
				$(n).poshytip('show');
				flag=false;
			}
		}
	});
	return flag;
}


//下面是测试代码，不属于验证器的功能代码之内
//用原型的方式来模拟js的类
function Validators() {

}

Validators.prototype.subByJs=function(e) {
	if($.doValidate()) {
		alert('验证通过');
		//todo
	}
}
