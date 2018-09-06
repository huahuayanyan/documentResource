/**
 * 多table页控制
 * fengjie 2014-11-28
    var cTabpanelFrame = new Custom_tabpanel();
    cTabpanelFrame.init({
    	headDiv : $('#ifreameHeadDiv'), // 每次加载必填
    	config : { // 每次加载可选
			//页签是否支持关闭功能(低级别)
			closeable : true,
			//页签的方位设置,目前提供2种['top', 'bottom']（暂时不支持）
			//position : 'top',
			//滚动按钮的布局[true:右侧显示(默认) | false:两边显示]（暂时无滚动条）
			//layout : true,
			// 默认div模式，[iframe,div]，如果是div（panelType无效，asyn无效和data中的url无效）
			panelType : 'iframe',
			//页签是否为异步处理(针对url的功能是否做异步处理，如果panelType=div则只能同步处理)
			//asyn : true,
			//默认显示的页签数[0开始]
			showNum : 0
    	},
    	data : [ // 每次加载必填
			{title : '百度' , content : $('#ifreameArea0') , url : 'http://www.baidu.com' , closeable : true },
			{title : '126邮箱' , content : $('#ifreameArea1') , url : 'http://www.126.com' , closeable : true },
			{title : '新浪' , content : $('#ifreameArea2') , url : 'http://www.sina.com.cn' , closeable : false },
			{title : '迅雷看看' , content : $('#ifreameArea3') , url : 'http://www.kankan.com' , closeable : true }
    	]
    });
	//添加一个TabpanelFrame
	cTabpanelFrame.addLiFun({title : '搜狐' , content : $('#ifreameArea4') , url : 'http://www.sohu.com/' , closeable : true });
	//删除一个TabpanelFrame
	cTabpanelFrame.deleteLiFun('测试栏目4');
	// html中写法
	<div id="ifreameHeadDiv" class="tabpanel"></div>
	<iframe id="ifreameArea0" class="tabpanel_area" height="500px"></iframe>
	<iframe id="ifreameArea1" class="tabpanel_area" height="500px"></iframe>
	<iframe id="ifreameArea2" class="tabpanel_area" height="500px"></iframe>
	<iframe id="ifreameArea3" class="tabpanel_area" height="500px"></iframe>
	<iframe id="ifreameArea4" class="tabpanel_area" style="height: 500px;display: none;"></iframe>

 */
Custom_tabpanel = function () {

	/**
	 * table多标签head对象（必填）
	 */
	this.headDiv = null;
	
	/**页签数据设置
	this.liData = [
		{title : '介绍' , content : $('#tabpanelAreaDiv1') , closeable : false },
		{title : '用法' , content : $('#tabpanelAreaDiv2') , closeable : true },
		{title : '特点及性能' , content : $('#tabpanelAreaDiv3') , closeable : true },
		{title : '历史版本及问题' , content : $('#tabpanelAreaDiv4') , closeable : true }
	];
	*/
	this.liData = new Array();
	
	/**
	 * table多标签标题参数集合
	 */
	this.defaultConfig = {
		// 页签是否支持关闭功能(低级别)
		closeable : false,
		// 页签的方位设置,目前提供2种['top', 'bottom']（暂时不支持）
		position : 'top',
		// 滚动按钮的布局[true:右侧显示(默认) | false:两边显示]（暂时无滚动条）
		layout : true,
		// 默认div模式，[iframe,div]
		panelType : 'div',
		// 页签是否为异步处理(针对url的功能是否做异步处理，如果panelType=div则只能同步处理)
		// 如果false则加载速度很慢，建议异步加载
		asyn : true,
		// 默认显示的页签数[0开始]
		showNum : 0
	};
	
	/**
	 * 初始化ul样式
	 */	
	this.initHeadDiv = function() {
		// STEP-1 初始化tabs的栏目
		var hDiv = '<ul style="margin: 0 0 10px;">';
		for(var i = 0 ; i < this.liData.length ; i ++) {
			var tLi = this.liData[i];
			var closeEventHtml = '';
			if(this.defaultConfig.closeable && tLi.closeable) {
				closeEventHtml = '<span target="' +i+ '" class="tabpanel_close" ></span>';
			}
			if(this.defaultConfig.showNum == i) {
				hDiv += '<li target="' +i+ '" ><a target="' +i+ '" class="hover" title="'+tLi.title+'" >' +tLi.title+closeEventHtml+ '</a></li>';
				tLi.content.show();
				// 如果是iframe，需要显示加载
				if(this.defaultConfig.panelType == 'iframe' ) {
					tLi.content.prop('src', tLi.url);
				}
			} else {
				hDiv += '<li target="' +i+ '" ><a target="' +i+ '"  title="'+tLi.title+'">' +tLi.title+closeEventHtml+ '</a></li>';
				tLi.content.hide();
				// 如果是iframe，且又是要求所有panel同步设置，需要隐藏加载
				if(this.defaultConfig.panelType == 'iframe' && this.defaultConfig.asyn == false) {
					tLi.content.prop('src', tLi.url);
				}
			}
		}
		hDiv += '</ul>';
		this.headDiv.html(hDiv);
		// STEP-2 初始化栏目的事件
		var thisObj = this;
		this.headDiv.find('li').mouseenter(function() {
			$(this).find('span').show();
		}).mouseleave(function() {
			$(this).find('span').hide();
		});
		this.headDiv.find('li span').click(function() {
			thisObj.selectCloseEvent($(this));
		});
		this.headDiv.find('li a').click(function() {
			thisObj.selectLiEvent($(this));
		});
	}
	
	/**
	 * 选择删除栏目的触发的事件
	 */
	this.selectCloseEvent = function(spanObj) {
		var index = spanObj.attr('target');
		//alert('selectClose' +index);
		var tArea = this.liData[index];
		// STEP-1 删除页面的中的tabpanel
		tArea.content.hide();
		tArea.content.attr('src','');
		// STEP-2 删除liData的中的tabpanel数据
		this.liData[index] = null;
		// STEP-3 如果删除的panel正好是当前打开的tabpanel，
		// 需要调整展示到相邻的左边tabpanel，如果是首个需要展示到第二个tabpanel
		if(index == this.defaultConfig.showNum) {
			var nextLi = spanObj.parent().parent().next();
			if(nextLi.length > 0 ) {
				this.selectLiEvent(nextLi.find('a'));
			} else {
				var prevLi = spanObj.parent().parent().prev();
				if(prevLi.length > 0) {
					this.selectLiEvent(prevLi.find('a'));
				}
			}
		}

		//设置headDiv的隐藏显示
		var aaa;
		for (var j=0;j<this.liData.length;j++){
			if(this.liData[j]){aaa=true}
		}
		if(!aaa){
			this.headDiv.height(0);
		}
		// STEP-4 删除页面元素li
		spanObj.parent().parent().remove();
        this.resetLiWidth("menus");
	}
	
	/**
	 * 选择栏目的触发的事件
	 */
	this.selectLiEvent = function(liA) {
		var index = liA.attr('target');
		//alert('selectLi' +index);
		if(this.liData[index]) {
			this.headDiv.find('li a').removeClass("hover");
			liA.addClass("hover");
			// STEP-1 隐藏页面的tabpanel
			for(var i = 0 ; i < this.liData.length ; i ++) {
				if(this.liData[i]) {
					this.liData[i].content.hide();
				}
			}
			// STEP-2 显示页面的tabpanel
			this.liData[index].content.show();
			if(this.defaultConfig.panelType == 'iframe' && this.defaultConfig.asyn == true) {
				var liUrl = this.liData[index].content.attr('src');
				if(null == liUrl || '' == liUrl || !liUrl) {
					this.liData[index].content.prop('src', this.liData[index].url);
				}
			}
			this.defaultConfig.showNum = parseInt(index);
		}
	}
	
	/**
	 * 动态打开一个tabpanel，按照从0开始的序列展示
	 */
	this.showLiFun = function(showNum) {
		// 选择栏目的触发的事件
		this.selectLiEvent(this.headDiv.find('li a[target=' +showNum+ ']') );
	}

	this.showLiFunByUrl = function(url) {
		var showNum;
		for(var i = 0 ; i < this.liData.length ; i ++) {
			var tLi = this.liData[i];
			if(null != tLi && tLi.url == url) {
				showNum = i;
			}
		}
		if( typeof showNum !== "undefined"){
			this.selectLiEvent(this.headDiv.find('li a[target=' +showNum+ ']') );
		}
	}
	
	/**
	 * 根据title名称找到Li所在的index
	 */
	this.getFrameNumFun = function(title) {
		// 选择栏目的触发的事件
		for(var i = 0 ; i < this.liData.length ; i ++) {
			var tLi = this.liData[i];
			if(null != tLi && tLi.title == title) {
				return i;
			}
		}
		return null;
	}
	
	/**
	 * 刷新Iframe（根据iframe的序列，从0开始）
	 */
	this.reloadIframePage = function(num) {
		if(null == num) {
			for(var i = 0 ; i < this.liData.length ; i ++) {
				var tLi = this.liData[i];
				tLi.content.prop('src', tLi.url);
			}
		} else {
			for(var i = 0 ; i < this.liData.length ; i ++) {
				var tLi = this.liData[i];
				if(null != tLi && i == num) {
					tLi.content.prop('src', tLi.url);
					return;
				}
			}
		}
	}
	
	/**
	 * 动态添加一个tabpanel
	 */
	this.addLiFun = function(liObj) {
		// STEP-1 添加页面的中的tabpanel
		liObj.content.hide();
		// 如果是iframe，且又是要求所有panel同步设置，需要隐藏加载
		if(this.defaultConfig.panelType == 'iframe' && this.defaultConfig.asyn == false ) {
			liObj.content.prop('src', liObj.url);
		}
		//判断是否存在tab li
		var arrayIndex=-1;
		for (var i=0;i<this.liData.length;i++){
			if(this.liData[i] && this.liData[i].url == liObj.url){
				arrayIndex = i;
				break;
			}
		}

		if(arrayIndex!==-1){
			this.selectCloseEvent(this.headDiv.find('li span[target=' +arrayIndex+ ']'));
			this.liData[arrayIndex] = liObj;
			//return arrayIndex;
		}else{
			// STEP-2 添加liData的中的tabpanel数据
			arrayIndex = this.liData.push(liObj) - 1;	// 从0开始计算
		}

		// STEP-3 添加页面元素li			
		var closeEventHtml = '';
		if(this.defaultConfig.closeable && liObj.closeable) {
			closeEventHtml = '<span target="' +arrayIndex+ '" class="tabpanel_close" ></span><div class="seperate"></div>';
		}
		this.headDiv.find('ul').prepend('<li target="' +arrayIndex+ '" ><a target="' +arrayIndex+ '" title="'+liObj.title+'" >' +liObj.title+closeEventHtml+ '</a></li>');
		// STEP-4 添加页面元素li事件
		var thisObj = this;
		this.headDiv.find('li[target=' +arrayIndex+ ']').mouseenter(function() {
			$(this).find('span').show();
		}).mouseleave(function() {
			$(this).find('span').hide();
		});
		this.headDiv.find('li span[target=' +arrayIndex+ ']').click(function() {
			thisObj.selectCloseEvent($(this));
		});
		this.headDiv.find('li a[target=' +arrayIndex+ ']').click(function() {
			thisObj.selectLiEvent($(this));
		});

		//设置headDiv的隐藏显示
		var aaa;
		for (var j=0;j<this.liData.length;j++){
			if(this.liData[j]){aaa=true}
		}
		if(aaa){
			this.headDiv.height(40);
		}
        this.resetLiWidth("plus");
		return arrayIndex;
	}

    /**
     * 动态改变tabpanel的width长度
     */
    this.resetLiWidth = function(type){
        var liDataLength = this.getLiLength();
        var liWidth = this.headDiv.find('li').width();
        var headDiv = this.headDiv.width();
        if(type=="menus"){
            if(liWidth < 100){
                liWidth = parseInt(headDiv)/parseInt(liDataLength);
                this.headDiv.find('li').width(liWidth);
            }
        }
        else if(type=="plus"){
            var compare = parseInt(headDiv)-parseInt(liDataLength*liWidth);
            if(compare < 0 ){
                liWidth = parseInt(headDiv)/parseInt(liDataLength);
                this.headDiv.find('li').width(liWidth);
            }
        }
        //alert(liDataLength+"+++"+liWidth+"+++"+headDiv)
    }
	
	/**
	 * 动态删除一个tabpanel
	 */
	this.deleteLiFun = function(title) {
		// STEP-1 liData中遍历出的tabpanel
		for(var i = 0 ; i < this.liData.length ; i ++) {
			if(this.liData[i] && this.liData[i].title == title) {
				// 选择删除栏目的触发的事件
				this.selectCloseEvent(this.headDiv.find('li span[target=' +i+ ']') );
				return;
			}
		}
	}
	
	/**
	 * pannel page 
	 */
	this.getLiLength = function() {
		return this.headDiv.find('li').length;
	}
	
	/**
	 * get LiData Length 
	 */
	this.getLiDataLength = function() {
		return this.liData.length;
	}
	
	/**
	 * 参数配置
	 */	
	this.init = function(tParam) {
		this.headDiv = tParam['headDiv'];
		
		jQuery.extend(this.defaultConfig, tParam['config']);
		
		if(tParam['data']) {
			this.liData = tParam['data'];
		}
		//设置headDiv的隐藏显示
		var aaa;
		for (var j=0;j<this.liData.length;j++){
			if(this.liData[j]){aaa=true}
		}
		if(aaa){
			this.headDiv.height(40);
		}else {
			this.headDiv.height(0);
		}
		// 初始化ul样式
		this.initHeadDiv();
	}
}