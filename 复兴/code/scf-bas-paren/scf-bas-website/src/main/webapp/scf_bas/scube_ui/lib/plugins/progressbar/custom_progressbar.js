/**
 * 自定义进度条
 * fengjie 2014-11-26
 * 使用方式如下：
 * 1、启用进度条控件；
 		var customProgressbar = new CustomProgressbar(); // 建议在公共页面统一初始化
 * 2、设定进度条基本参数； // 建议在公共页面统一初始化
		customProgressbar.init({
	   		// 元素的不透明级别。 默认值: 1
			opacity ： 1 ,
			// 遮罩层的背景图片（设置了图片，背景颜色就无效）
			backgroundImage : '', 
			// 遮罩层的背景颜色
			backgroundColor : '#AAAAAA',
			// 进度条图片
			barImage : '宽度为22px的图片' ,
			// 遮罩层z-index设置越大越不会背其它元素遮挡
			zIndex ：'默认是9999，根据情况设置'
		});
 * 3、使用进度条详细说明；
		customProgressbar.show({
			barId : '1',	// 进度条编号（删除时区分唯一），可以为空，默认0；
			controlObj : $('#testDiv') ,  // 进度条作用域jquery对象，可以为空，默认document.body；
			showMessage : '测试1测试1测试1' ,	// 进度条上面的消息文字，可以为空，默认数据加载中，请耐心等待……；
			waitTime : 5 ,	// 进度条的加载时间，单位秒，可以为空，默认超时60秒；
			barClosedFun : barClosedFun // 进度条超时关闭时回调函数，默认空，自定义
		});
		customProgressbar.remove({
			barId : '1',	// 进度条编号（删除时区分唯一），可以为空，默认0；
		});
 * 4、进度条简单使用说明；
		customProgressbar.show();
		customProgressbar.remove();
 *
 */
CustomProgressbar = function() {

	this.config = {
		/**
		 * 元素的不透明级别。 默认值: 1
		 */
		opacity : 1,
		/**
		 * 遮罩层的背景颜色
		 */
		backgroundColor : null,
		/**
		 * 遮罩层的背景图片（设置了图片,图片高度不要超过22px，背景颜色就无效）
		 */
		backgroundImage : null,
		/**
		 * 进度条图片
		 */
		barImage : null,
		/**
		 * 遮罩层z-index设置越大越不会背其它元素遮挡
		 */
		zIndex : '9999',
		/**
		 * 进度条编号区分唯一
		 */
		barId : '0',
		/**
		 * 进度条作用域（默认整个浏览器页面）
		 */
		controlObj : null,
		/**
		 * 进度条超时，单位：秒；（默认60秒，大于0则生效）
		 */
		waitTime : 10 ,
		/**
		 * 进度条超时关闭时回调函数
		 */
		barClosedFun : null ,
		
		showMessage : '数据加载中，请耐心等待……'
	}
		
	/**
	 * 定时器设置对象
	 */
	this.timeControl = new Object();
	
	/**
	 * 显示进度条(name：进度条的名称；docObj要展示进度条的区域对象)
	 */
	this.show = function(tData) {
		var param = this.getConfig(tData);
		var width = param.controlObj[0].scrollWidth;
		var height = param.controlObj[0].scrollHeight;
		var topPercent = (height - 22)*100/(2 * height);
		if(topPercent <= 0) {
			topPercent = 50;
		}
		var bgColor = '';
		if (param.backgroundImage) {
			bgColor = 'background-image:"' +param.backgroundImage+ '"';
		} else if(param.backgroundColor) {
			bgColor = 'background-color:' +param.backgroundColor+ ';background-image:""';
		}
		// 先删除在加进度条，防止重复点击（性能考虑可以直接加进度条）
		param.controlObj.find('#progressbar_'+param.barId).remove();
		param.controlObj.prepend('<div id="progressbar_' +param.barId+ '" class="ui--progressbar" name="_ui-progressbar_" '
			+ 'style="z-index:50000;width:' +width+ 'px;height:' +height+ 'px;' +bgColor+ '" >'
			+ '<div class="ui-progressbar-subwrap" style="top:' +topPercent+ '%;width:100%;">'
			+ '<div class="ui-progressbar-content" style="top:-50%;"><span style="line-height: 22px;height:22px;">' +param.showMessage+ '</span></div></div>');
		// 判断是否有超时
		if(param.waitTime > 0 ) {
			var _this = this;
			var breakFun = function() {
				_this.remove(tData);
				if(param.barClosedFun) {
					param.barClosedFun();
				}
			};
			//this.timeControl[param.barId] = setTimeout( breakFun , param.waitTime * 1000);
		}
	}
	
	/**
	 * 隐藏进度条
	 */
	this.remove = function(tData) {
		var param = this.getConfig(tData);
		//clearTimeout(this.timeControl[param.barId]);
		if(tData && tData.barId){
			param.controlObj.find('#progressbar_'+param.barId).remove();
		}else {
			param.controlObj.find('div[name=_ui-progressbar_]').remove();
		}
	}
	
	this.getConfig = function(tData) {
		var tParam = null;
		if(!tData || !tData.controlObj) {
			this.config.controlObj = $(document.body);
		}
		return jQuery.extend(tParam, this.config, tData);
	}
	
	/**
	 * 参数配置
	 */	
	this.init = function(tData) {
		// 元素的不透明级别。 默认值: 1
		if(tData['opacity']) {
			this.config.opacity = tData['opacity'];
		}
		if(tData['backgroundImage']) {
			// 遮罩层的背景图片（设置了图片，背景颜色就无效）
			this.config.backgroundImage = tData['backgroundImage'];
		} else if(tData['backgroundColor']) {
			// 遮罩层的背景颜色
			this.config.backgroundColor = tData['backgroundColor'];
		}
		// 进度条图片
		if(tData['barImage']) {
			this.config.barImage = tData['barImage'];
		}
		// 遮罩层z-index设置越大越不会背其它元素遮挡
		if(tData['zIndex']) {
			this.config.zIndex = tData['zIndex'];
		}
	}

};
	
/**
 * 默认初始化一次
 */	
var Progressbar = new CustomProgressbar();