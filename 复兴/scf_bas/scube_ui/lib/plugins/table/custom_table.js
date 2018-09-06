/**
 * 分页列表JS对象
 * fengjie
 * =======================使用方式=====================
	1、初始化；
	Custom_table customTable = new Custom_table();
	customTable.init({
		//列表table展示对象（必填）
		table : this.mainform.find('#empeeTable'),
		//列表table body展示对象（必填）
		tableTbody : this.mainform.find('#empeeTableTbody'),
		//列表table page展示对象（必填）
		tablePageDiv : this.mainform.find('#empeeTablePageDiv'),
		//列表table 列数（必填）
		columnNum : 7,
		//列表行排列集函数（必填）
		processRowFun : this.processEmpeeRow,
		//初始化条件数据，返回非空条件集合则执行ajax查询函数（必填）
		initQueryDataFun : this.initQueryData,
		// 每页显示的条数，可以不设定，默认是10（可选）
		pageSize :5,
		//初始化行点击事件(可选)
		rowClickFun : null,
		//数据加载完成后执行的扩展方法(可选)
		loadEndFun : null,
		// 扩展的参数（可选）
		extConfig : {
			// 是否显示进度条
			isOnloadProgress : false,
			// 是否立即加载
			isOnload : true
		}
	});
	2、实现：初始化条件数据(给外部方法使用，里面不要有this)
	// initQueryData实现的函数返回值必须是Object对象，有且仅有url和data两个属性
	this.initQueryData = function() {
		var queryUrl = '/BaseWeb/servlet/EmpeeServlet';
		var requestObj = new Object();
		requestObj['url'] = queryUrl;
		requestObj['data'] = new Object();
		// 当前记录数开始序列，默认从0开始(必须的传递的参数)
		requestObj['data']['pageSize'] = empee_list.customTable.defaultConfig.pageSize;
		requestObj['data']['startNum'] = empee_list.customTable.defaultConfig.startNum;
		
		//定义查询条件
		requestObj['data']['EMPEE_CODE'] = EMPEE_CODE;
		requestObj['data']['EMPEE_NAME'] = EMPEE_NAME;
		…………
		return requestObj;
	}
	3、实现：处理行数据方法
	this.processEmpeeRow = function( seq , tempBean) {
		var rowHtml = '';
		// 把查询出来的集合保存下来
		empee_list.empeeTableList[tempBean.EMPEE_ID] = tempBean;
		rowHtml = '<td align="center">'+seq+ '</td>'
			+ '<td>123&nbsp;</td>'
			+ '<td>123&nbsp;</td>'
			+ '<td>13&nbsp;</td>';
		return rowHtml;
	}
	4、后台返回格式参考
	   返回格式以JSON格式{data={totleRows:25,dataList=[{EMPEE_CODE:'A001',EMPEE_NAME:'张三',EMPEE_ACCT:'zhangsan',USER_TYPE_NAME:'系统用户',EMPEE_MOB_NO:'13888888888',STATE_NAME:'有效'}]}}
 */
Custom_table = function(){
	
	/**
	 * 列表table展示对象
	 */
	this.table = null;
	/**
	 * 列表table body展示对象
	 */
	this.tableTbody = null;
	/**
	 * 列表table page展示对象
	 */
	this.tablePageDiv = null;
	
	/**
	 * 列表table 数据集合（非外部传入）
	 */
	this.pageData = null;
	
	/**
	 * 列表table 列数
	 */
	this.columnNum = null;
	
	/**
	 * 列表行排列集函数
	 */
	this.processRowFun = null;
	
	/**
	 * 初始化条件函数
	 */
	this.initQueryDataFun = null;
	
	/**
	 * 初始化行点击事件(可选)
	 */
	this.rowClickFun = null;
	
	/**
	 * 数据加载完成后执行的扩展方法(可选)
	 */
	this.loadEndFun = null;
		
	/**
	 * 扩展参数
	 */
	this.extConfig = {
		// 是否显示进度条
		isOnloadProgress : true,
		// 是否立即加载
		isOnload : true
	}
	/**
	 * 初始化表格的css
	 */
	this.initCss = function(){
		$(this.tableTbody).find("tr").mouseover(function() { // 如果鼠标移到class为stripe_tb的表格的tr上时，执行函数
			$(this).addClass("over");
		}).mouseout(function() { 
			$(this).removeClass("over");
		})
		$(this.tableTbody).find("tr:even").addClass("alt"); //给class为stripe_tb的表格的偶数行添加class值为alt
	}
	/**
	 * 分页数据
	 */
	this.defaultConfig = {
		// 当前页号, 从1开始
		currentPage : 1,
		// 上一页 
		previousPage : 1,
		// 下一页
		nextPage : 1,
		// 总页数
		totlePage : 1,
		// 总记录数
		totleRows : 0,
		// 当前记录数开始序列，默认从0开始
		startNum : 0,
		// 单页显示最大数量
		pageSize : 10,
		// 单页显示数量选择集合
		selectPageSize : new Array(10,20,50,100),
		// 设置当前页
		setCurrent : function(_currentPage) {
			this.currentPage = _currentPage;
			this.previousPage = (this.currentPage == 1) ? 1 : (this.currentPage - 1);
			this.nextPage = (this.currentPage == this.totlePage) ? this.currentPage : (this.currentPage + 1);
			this.startNum = (this.currentPage - 1) * this.pageSize;
		},
		// 设置总记录数
		setTotle : function(_totleRows) {
			this.totleRows = _totleRows;
			var overNum = this.totleRows % this.pageSize;
			this.totlePage = (this.totleRows - overNum) / this.pageSize;
			if(overNum > 0 ) {
				this.totlePage ++ ;
			}
			// 第一次加载时如果有多页数据，会遇到nextPage一直为1，需要初始化一次
			this.setCurrent(this.currentPage);
		}
	}
	
	/**
	 * 针对输入自定义业务条件后查询，需要初始化到第一页(对外方法)
	 */
	this.initDefaultConfig = function() {
		// 当前页号, 从1开始
		this.defaultConfig.currentPage = 1;
		// 上一页 
		this.defaultConfig.previousPage = 1;
		// 下一页
		this.defaultConfig.nextPage = 1;
		// 总页数
		this.defaultConfig.totlePage = 1;
		// 总记录数
		this.defaultConfig.totleRows = 0;
		// 当前记录数开始序列，默认从0开始
		this.defaultConfig.startNum = 0;
	}
	
	/**
	 * 如果设置了pageSize需要初始化
	 */
	this.initPageSize = function(_pageSize) {
		this.defaultConfig.pageSize = _pageSize;
		var isDefault = false;
		for(var i = 0 ; i < this.defaultConfig.selectPageSize.length ; i ++ ) {
			if(_pageSize == this.defaultConfig.selectPageSize[i]) {
				isDefault = true;
				break;
			}
		}
		if(!isDefault) {	// 如果不是默认的需要加入selectPageSize
			this.defaultConfig.selectPageSize.unshift(_pageSize);
		}
	}
	
	/**
	 * 打开和关闭查询进度条
	 */
	this.openProgress = function() {
		if(this.extConfig.isOnloadProgress) {	// 是否显示进度条
			var _this = this;
			customProgressbar.show({
				waitTime : 30 ,	// 进度条的加载时间，单位秒，可以为空，默认超时60秒；
				barClosedFun : function() { // 进度条关闭后触发函数，默认空，自定义
					// 无记录
					var tableBody = '<tr><td colspan="' +_this.columnNum+ '" style="color: red;" align="center">查询超时，请稍后再试……</td></tr>';
					_this.tableTbody.html(tableBody);
					_this.tablePageDiv.html("");
				}
			});
		}
	}
	this.closeProgress = function() {
		if(this.extConfig.isOnloadProgress) {	// 是否显示进度条
			customProgressbar.hide();
		}
	}
	
	/**
	 * 执行后台ajax查询
	 */
	this.ajaxRequest = function(ops) {
		this.openProgress();
		var _this = this;
		$.ajax({
			url : ops["url"],
			type : 'POST',
			async : true,
			cache : false,
			data : {
				"data" : JSON.stringify(ops["data"])
			},
			dataType : 'json',
			timeout : 60000,
			success : function(responseObj) {
				var val = JSON.stringify(responseObj);
//				alert(val);
				_this.closeProgress();
				if(null != responseObj && null != responseObj.data.resultList ) {
					_this.pageData = responseObj.data.resultList;
					_this.defaultConfig.setTotle(responseObj.data.totalRecord);
					_this.writeTable();
				}
			},
			error : function() {
				_this.pageData = null;
				// 数据加载完毕后，执行扩展方法
				_this.loadEndEvent(null);
			}
		});
	}
	
	/**
	 * 初始化查询列表数据
	 */
	this.initTable = function() {
		// 初始化条件函数
		var requestObj = this.initQueryDataFun();
		if(null != requestObj ) {
			this.ajaxRequest(requestObj);
		}
	}
	
	this.writeTable = function() {
		var tableBody = '';
		if(null != this.pageData && null != this.pageData && this.pageData.length > 0 ) {
			var seqNum = this.defaultConfig.startNum + 1;	// 序号
			// 有记录
			for(var i = 0; i < this.pageData.length ; i ++ ) {
				var tempBean = this.pageData[i];
				// 执行外部封装的行处理展示对象
//				var doubleRowStyle = i % 2 == 0 ? '' : 'class="tableWRow"';
				var doubleRowStyle = '';
				tableBody = tableBody + '<tr id="tr" rowEvent="' +i+ '" ' +doubleRowStyle+ '>';
				tableBody = tableBody + this.processRowFun(seqNum + i,tempBean);
				tableBody = tableBody + '</tr>';
			}
			this.tableTbody.html(tableBody);
			// 添加行点击事件
			this.addRowClickEvent();
			// 初始化分页数据
			this.initTablePage();
			this.initCss();
			// 数据加载完毕后，执行扩展方法
			this.loadEndEvent(this.pageData);
		} else {
			// 无记录
			tableBody = '<tr>'
					+ '<td colspan="' +this.columnNum+ '" style="color: red; width:1100px; " align="center">没有相关记录</td>'
					+ '</tr>';
			this.tableTbody.html(tableBody);
			// 初始化分页数据
			this.initTablePage();
			// 数据加载完毕后，执行扩展方法
			this.loadEndEvent(null);
		}
		//this.tableTbody.find().hover(function(){ // 鼠标行进入变色
		//	$(this).addClass("tron");
		//},function(){
		//	$(thils).removeClass("tron");
		//});
	}
		
	/**
	 * 添加行点击事件
	 */
	this.addRowClickEvent = function() {
		if(this.rowClickFun) {
			var thisObj = this;
			var rows = this.tableTbody.find('tr[rowEvent]');
			rows.css({cursor:"hand"});
			rows.click(function() {
				// 行点击变色
				rows.removeClass("tableClick");
				$(this).addClass("tableClick");
				// 行点击事件
				var dataListIndex = parseInt($(this).attr("rowEvent") );
				var selRowData = thisObj.pageData[dataListIndex];
				selRowData['ROW_INDEX'] = dataListIndex;	// 行号也返回，从0开始计算
				thisObj.rowClickFun(selRowData);
			});
		}
	}
		
	/**
	 * 数据加载完毕后，执行扩展事件
	 */
	this.loadEndEvent = function(tData) {
		// 数据加载完毕后，执行扩展方法
		if(this.loadEndFun) {
			this.loadEndFun(tData);
		}
	}
		
	/**
	 * 初始化分页操作区域数据
	 */
	this.getPageControlHtml = function() {
		var  pageControlHtml = '';
		// 每页显示按钮
		//pageControlHtml += '每页显示<select name="pageSize" id="pageSize" class="input45" goToPage="' +this.defaultConfig.currentPage+ '" >';
		pageControlHtml += '<div style="display: none;">每页显示<select name="pageSize" id="pageSize" class="input45" goToPage="1" >';
		for(var i = 0 ; i < this.defaultConfig.selectPageSize.length ; i ++ ) {
			pageControlHtml += '<option ' +(this.defaultConfig.pageSize == this.defaultConfig.selectPageSize[i] ? 'selected="selected"' : '')
			+ ' >' +this.defaultConfig.selectPageSize[i]+ '</option>';
		}
		pageControlHtml += '</select>条&nbsp;&nbsp;&nbsp;&nbsp;</div>';
		// 统计数量
		pageControlHtml += '<span>总<font color="red">' +this.defaultConfig.totleRows+ '</font>条记录</span>&nbsp;';
		pageControlHtml += '<span>共<font color="red">' +this.defaultConfig.totlePage+ '</font>页</span>&nbsp;';
		pageControlHtml += '当前第<font color="red">' +this.defaultConfig.currentPage+ '</font>页&nbsp;';
		// 首页按钮
		pageControlHtml += '<a id="firstA" href="javascript:void(0);" ';
		pageControlHtml += (1 == this.defaultConfig.currentPage) ? '' : 'goToPage="1" ';
		pageControlHtml += '>首页</a>&nbsp;';
		// 上一页按钮
		pageControlHtml += '<a id="upA" href="javascript:void(0);" ';
		pageControlHtml += (this.defaultConfig.previousPage == this.defaultConfig.currentPage) ? '' : 'goToPage="' +this.defaultConfig.previousPage+ '" ';
		pageControlHtml += '>上一页</a>&nbsp;';
		// 下一页按钮
		pageControlHtml += '<a id="downA" href="javascript:void(0);" ';
		pageControlHtml += (this.defaultConfig.nextPage == this.defaultConfig.currentPage) ? '' : 'goToPage="' +this.defaultConfig.nextPage+ '" ';
		pageControlHtml += '>下一页</a>&nbsp;';
		// 尾页按钮
		pageControlHtml += '<a id="lastA" href="javascript:void(0);" ';
		pageControlHtml += (this.defaultConfig.totlePage == this.defaultConfig.currentPage) ? '' : 'goToPage="' +this.defaultConfig.totlePage+ '" ';
		pageControlHtml += '>尾页</a>&nbsp;';
		
		pageControlHtml += '<input id="curPage" name="curPage" type="hidden" value="' +this.defaultConfig.currentPage+ '" />';
		pageControlHtml += '<input name="pageNum" id="pageNum" class="page_inp" maxlength="8" />&nbsp;';
		pageControlHtml += '<a type="button" id="goButton" name="goButton" class="page_normal" goToPageByNum="">GO</a>';
		return pageControlHtml;
	}
		
	/**
	 * 初始化分页page数据
	 */
	this.initTablePage = function() {
		var thisObj = this;
		var tempPage = this.getPageControlHtml();
		this.tablePageDiv.html(tempPage);
		if(this.defaultConfig.totlePage > 0) {	// 最大页数大于0
			// 对select选择页数操钮添加事件
			var selectObject = $(this.tablePageDiv.find('select[id=pageSize]'));
			selectObject.change(function() {
				thisObj.goToPage(selectObject.attr('goToPage'));
			});
			// 对点击首页按钮添加事件
			var firstA = $(this.tablePageDiv.find('a[id=firstA]') );
			if(firstA.attr('goToPage') ) {
				firstA.click(function() {
					thisObj.goToPage(firstA.attr('goToPage'));
				});
			}
			// 对点击上一页按钮添加事件
			var upA = $(this.tablePageDiv.find('a[id=upA]') );
			if(upA.attr('goToPage') ) {
				upA.click(function() {
					thisObj.goToPage(upA.attr('goToPage'));
				});
			}
			// 对点击下一页按钮添加事件
			var downA = $(this.tablePageDiv.find('a[id=downA]') );
			if(downA.attr('goToPage') ) {
				downA.click(function() {
					thisObj.goToPage(downA.attr('goToPage'));
				});
			}
			// 对点击末页的按钮添加事件
			var lastA = $(this.tablePageDiv.find('a[id=lastA]') );
			if(lastA.attr('goToPage') ) {
				lastA.click(function() {
					thisObj.goToPage(lastA.attr('goToPage'));
				});
			}
			// 对点击GO的分页查询按钮添加事件
			this.tablePageDiv.find('#goButton').click(function() {
				thisObj.goToPageByNum();
			});
		}
	}
		
	/**
	 * 分页查询中点击翻页按钮的查询事件
	 * @param pageNum
	 */
	this.goToPage = function(pageNum) {
		//alert("goToPage======" +pageNum);
		var selectedPageSize = this.tablePageDiv.find('#pageSize').val();
		if(selectedPageSize && selectedPageSize.length > 0) {
			this.defaultConfig.pageSize = parseInt(selectedPageSize);
		}
		this.defaultConfig.setCurrent(parseInt(pageNum));
		this.tablePageDiv.find('#curPage').val(pageNum);
		this.initTable();
	}
	
	/**
	 * 分页查询中点击“Go”去指定页数的查询事件
	 */
	this.goToPageByNum = function() {
		var pageNum = this.tablePageDiv.find('#pageNum').val();
		if('' != pageNum && pageNum.match(/^[0-9]*[1-9][0-9]*$/)) {
			pageNum = parseInt(pageNum);
			if(this.defaultConfig.totlePage >= pageNum ) {
				this.defaultConfig.setCurrent(pageNum);
				this.tablePageDiv.find('#curPage').val(pageNum);
				this.initTable();
			}
		}
	}
	
	/**
	 * 校验参数是否传入完整（仅仅测试使用）
	 */
	this.checkParam = function() {
		if(!this.table) {
			alert('列表table展示对象-不能为空，请检查如何使用customTable.js代码！！');
			return false;
		} else if(!this.tableTbody) {
			alert('列表table body展示对象-不能为空，请检查如何使用customTable.js代码！！');
			return false;
		} else if(!this.tablePageDiv) {
			alert('列表table page展示对象-不能为空，请检查如何使用customTable.js代码！！');
			return false;
		} else if(!this.columnNum) {
			alert('列表table 列数-不能为空，请检查如何使用customTable.js代码！！');
			return false;
		} else if(!this.processRowFun) {
			alert('列表行排列集函数-不能为空，请检查如何使用customTable.js代码！！');
			return false;
		} else if(!this.initQueryDataFun) {
			alert('初始化条件函数-不能为空，请检查如何使用customTable.js代码！！');
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 初始化
	 */
	this.init = function(tData) {
	
		//列表table展示对象
		this.table = tData['table'];
		//列表table body展示对象
		this.tableTbody = tData['tableTbody'];
		//列表table page展示对象
		this.tablePageDiv = tData['tablePageDiv'];
		//列表table 列数
		this.columnNum = tData['columnNum'];
		//列表行排列集函数
		this.processRowFun = tData['processRowFun'];
		//初始化条件函数
		// initQueryDataFun实现的函数返回值必须是Object对象，有且仅有url和data两个属性
		this.initQueryDataFun = tData['initQueryDataFun'];
		//初始化行点击事件（可选）
		this.rowClickFun = tData['rowClickFun'];
		//数据加载完成后执行的自定义方法（可选）
		this.loadEndFun = tData['loadEndFun'];
		
		if(tData['pageSize']) {	// 如果设置了pageSize需要初始化
			this.initPageSize(tData['pageSize']);
		}
		// 初始化扩展参数
		jQuery.extend(this.extConfig, tData['extConfig']);
		
		if (this.checkParam() ) {	// 校验参数是否传入完整
			if(this.extConfig.isOnload) {	// 立即加载
				this.initTable();
			}
		}
	}
	
	/**
	 * 获取pageSize值，单页最大数量
	 */
	this.getPageSize = function() {
		return this.defaultConfig.pageSize;
	}
	
	/**
	 * 获取startNum值，默认从0开始累加
	 */
	this.getStartNum = function() {
		return this.defaultConfig.startNum;
	}

}

