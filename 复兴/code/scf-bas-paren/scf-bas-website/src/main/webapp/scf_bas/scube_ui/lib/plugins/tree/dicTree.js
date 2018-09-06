var dicTreePicPath = '';
/**
 * 自定义树
 */
var CustomTree = function() {
	this.cTreeDiv = null;	// 展示树的入口DIV
	
	this.isCheckBox = false;	// 是否加入CheckBox复选框
	this.isClickRow = false;	// 是否点击行触发事件，如果有CheckBox=true则必须为isClickRow=false
	this.isAllShow = false;	// 是否打开全部节点
	
	this.selectCBox = '';	// 选中的值，以逗号隔开
	
	this.headNode = null;	// 首目录节点
	this.allChildNode = null;	// 首目录下所有的子节点
	this.firstNodeId = '-1';	// 首节点的nodeId
	
	this.customFun = null; // 自定义文字点击函数
	
	this.boxEventFun = null; // 自定义checkbox点击函数
	
	this.showBoxFun = null; // 自定义是否展示checkbox复选框
	
	this.dPicUrl = dicTreePicPath;	// 默认图片路径
	this.openNPic = 'Minus.gif';
	this.openPic = 'K.gif';
	this.closedNPic = 'Plus.gif';
	this.closedPic = 'J.gif';
	this.lastPic = 'Y.gif';

	/**
	 * 初始化树对象数据
	 * 主入口方向（START）
	 */
	this.initParameter = function(tData) {
		this.cTreeDiv = tData['treeDiv'];
		
		this.isCheckBox = tData['isCheckBox'];
		this.isClickRow = tData['isClickRow'];
		
		this.firstNodeId = tData['firstNodeId'];
		this.headNode = tData['headNode'];
		this.allChildNode = tData['allChildNode'];
		
		if(undefined == tData['selectCBox'] || null == tData['selectCBox']) {
			this.selectCBox = '';
		} else {
			this.selectCBox = tData['selectCBox'];	// 选中的值，以逗号隔开
		}
		
		this.customFun = tData['customFun'];
		
		this.boxEventFun = tData['boxEventFun'];
		
		this.showBoxFun = tData['showBoxFun'];
		
		this.dPicUrl = dicTreePicPath;	// 默认图片路径
		
		this.openNPic = this.dPicUrl + this.openNPic;
		this.openPic = this.dPicUrl + this.openPic;
		this.closedNPic = this.dPicUrl + this.closedNPic;
		this.closedPic = this.dPicUrl + this.closedPic;
		this.lastPic = this.dPicUrl + this.lastPic;
	}
		
	/**
	 * 初始化事件
	 */
	this.initEvent = function() {
		//this.removeAllSelectBox();
		var thisObj = this;
		this.cTreeDiv.find('img').click(function() {
			thisObj.initRowNodeEvent($(this));
		});
		this.cTreeDiv.find('div[class^=commonRow]').click(function() {
			thisObj.initChooseColor($(this));
		});
		if(this.isClickRow) {
			this.cTreeDiv.find('div span').click(function() {	// 加入点击文字事件
				thisObj.initChooseEvent($(this));
			});
		}
		if(this.isCheckBox) {	// 加入CheckBox复选框后，自动勾选才有效
			this.cTreeDiv.find('input[name=treeBox]').click(function() {
				thisObj.initCheckBoxEvent($(this));
			});
		}
	}
			
	/**
	 * 初始化div中的事件
	 *（提供加载子节点后注入事件）
	 */
	this.initCustomEvent = function(divObj) {
		var thisObj = this;
		divObj.find('img').click(function() {
			thisObj.initRowNodeEvent($(this));
		});
		divObj.find('div[class^=commonRow]').click(function() {
			thisObj.initChooseColor($(this));
		});
		if(this.isClickRow) {
			divObj.find('div span').click(function() {	// 加入点击文字事件
				thisObj.initChooseEvent($(this));
			});
			divObj.find('div span').dblclick(function() {	// 加入点击文字事件
				thisObj.dblClickEvent($(this));
			});
		}
		if(this.isCheckBox) {	// 加入CheckBox复选框后，自动勾选才有效
			divObj.find('input[name=treeBox]').click(function() {
				thisObj.initCheckBoxEvent($(this));
			});
		}
	}
		
	/**
	 * 初始化RowNode事件
	 */
	this.initRowNodeEvent = function(imgObj) {
		var fDiv = imgObj.parent();
		var tImgs = fDiv.find('img');
		var nextDiv = fDiv.next();
		if(nextDiv.css('display') == 'none' ) {	// 子节点没有显示,需要显示
			tImgs[0].src = this.openNPic;
			tImgs[1].src = this.openPic;
			nextDiv.show();
			var isLastNode = this.buildChildNode(nextDiv);
			if(isLastNode) {
				tImgs[1].src = this.lastPic;
			}
		} else {	// 子节点已显示,需要隐藏
			var tLPic = this.lastPic.replace(this.dPicUrl,'');
			if (tImgs[1].src.indexOf(tLPic) == -1) {	//目录节点不是最后一级
				tImgs[0].src = this.closedNPic;
				tImgs[1].src = this.closedPic;
				nextDiv.hide();
			}
		}
		//this.initChooseColor(fDiv);
	}	
		
	/**
	 * Row的点击样式公共方法
	 */
	this.initChooseColor = function(rowDiv) {
		this.cTreeDiv.find('div[tR]').removeClass('cFC').addClass("dFC");
		rowDiv.addClass("cFC");	// 行选择后字体变样式
	}
		
	/**
	 * Row的点击事件
	 */
	this.initChooseEvent = function(rowDiv) {
		if(this.customFun) {
			var vId = rowDiv.attr("value");
			if(vId == this.headNode['vId'] ) {
				this.customFun(this.headNode );
			} else {
				for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
					var everyChild = this.allChildNode[i];
					if(vId == everyChild['vId']) {
						this.customFun(everyChild );
						break;
					}
				}
			}
		}
	}
	this.dblClickEvent = function(rowDiv) {
		if(this.customFun) {
			var vId = rowDiv.attr("value");
			if(vId == this.headNode['vId'] ) {
				this.customFun(this.headNode );
			} else {
				for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
					var everyChild = this.allChildNode[i];
					if(vId == everyChild['vId']) {
						this.customFun(everyChild );
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 写树的html信息
	 */	
	this.buildTreeText = function() {
		this.loadHeadNode();
		if(this.isAllShow) {
			this.buildAllChildNode();
		} else {
			this.buildFirstNode();
		}
	}
	
	/**
	 * 写树首目录的html
	 */	
	this.loadHeadNode = function() {
		var tDStyle = this.isAllShow ? '' : 'style="display: none;"';
		var fSelCBox = ',' +this.selectCBox+ ',';
		var headNodeHtml = '';	
		headNodeHtml += '<div tR="' +this.headNode['vId']+ '" class="commonRow dFC">'
		headNodeHtml += '<img src="' +this.openNPic+ '"/><img src="' +this.openPic+ '"/>';
		if(this.isShowCheckBox(this.headNode) ) {
			if( fSelCBox.indexOf(','+this.headNode['nId']+',') != -1) {
				headNodeHtml += '<input type="checkbox" name="treeBox" value="' +this.headNode['vId']+ '" checked="checked" /><span value="' +this.headNode['vId']+ '">' +this.headNode['name'];
			} else {
				headNodeHtml += '<input type="checkbox" name="treeBox" value="' +this.headNode['vId']+ '"/><span value="' +this.headNode['vId']+ '">' +this.headNode['name'];
			}
		} else {
			headNodeHtml += '<span value="' +this.headNode['vId']+ '">' +this.headNode['name'];
		}
		headNodeHtml += '</span></div><div ' +tDStyle+ ' tR="tD' +this.headNode['vId']+ '" class="pl10"></div>';
		this.cTreeDiv.html(headNodeHtml);
	}	
	
	/**
	 * 修建所有节点的层级
	 * 注意：超过400节点后，性能相当低
	 */	
	this.buildAllChildNode = function() {
		// STEP-1 写树下所有节点的html
		var tDStyle = this.isAllShow ? '' : 'style="display: none;"';
		var everyChild = '';
		var tempHtml = '';
		if(null != this.allChildNode) {
			for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
				everyChild = this.allChildNode[i];
				tempHtml += '<div tR="' +everyChild['nId']+ '" ftR="' +everyChild['fId']+ '" class="commonRow dFC">'
				tempHtml += '<img src="' +this.closedNPic+ '"/><img src="' +this.closedPic+ '"/>';
				if(this.isShowCheckBox(everyChild) ) {
					tempHtml += '<input type="checkbox" name="treeBox" value="' +everyChild['vId']+ '"/><span value="' +everyChild['vId']+ '">' +everyChild['name'];
				} else {
					tempHtml += '<span value="' +everyChild['vId']+ '">' +everyChild['name'];
				}
				tempHtml += '</span></div><div ' +tDStyle+ ' tR="tD' +everyChild['nId']+ '" ftR="' +everyChild['fId']+ '" class="pl10"></div>';
			}
			this.cTreeDiv.append(tempHtml);
			// STEP-2 修建所有节点的层级
			var everyChild = '';
			for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
				everyChild = this.allChildNode[i];
				if('' != everyChild['fId']) {
					this.cTreeDiv.find('div[ftR=' +everyChild['fId']+ ']').appendTo(this.cTreeDiv.find('div[tR=tD' +everyChild['fId']+ ']'));	// node节点按层级移位
				}
			}
		}
	}
	
	/**
	 * 修建第一层树节点的层级
	 * 只排层第一层节点（适合大数据量的节点）
	 */	
	this.buildFirstNode = function() {
		var firstNodeTD = this.cTreeDiv.find('div[tR=tD' +this.firstNodeId+ ']');
		firstNodeTD.append(this.getNodeHtml(this.firstNodeId));
		firstNodeTD.show();
	}
	
	/**
	 * 修建子节点的层级，根据父节点fId
	 * 返回值：是否最后节点
	 */	
	this.buildChildNode = function(nDiv) {
		if(nDiv.children().length < 2) {	// 如果没有子节点需要加载子节点
			var fId = nDiv.attr('tR').replace('tD','');
			var tHtml = this.getNodeHtml(fId);
			if('' != tHtml) {
				nDiv.append(tHtml);
				this.initCustomEvent(nDiv);	//初始化添加的事件
			} else {	// 如果没有找到要加载的数据，返回true
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取节点下的子节点的html
	 */	
	this.getNodeHtml = function(fatherId) {
		var tDStyle = this.isAllShow ? '' : 'style="display: none;"';
		var fSelCBox = ',' +this.selectCBox+ ',';
		var everyChild = '';
		var tempHtml = '';
		if(null != this.allChildNode) {
			for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
				everyChild = this.allChildNode[i];
				if(fatherId == everyChild['fId']) {
					tempHtml += '<div tR="' +everyChild['nId']+ '" ftR="' +everyChild['fId']+ '" class="commonRow dFC">'
					tempHtml += '<img src="' +this.closedNPic+ '"/><img src="' +this.closedPic+ '"/>';
					if(this.isShowCheckBox(everyChild) ) {
						if( fSelCBox.indexOf(','+everyChild['nId']+',') != -1) {
							tempHtml += '<input type="checkbox" name="treeBox" value="' +everyChild['vId']+ '" checked="checked" /><span value="' +everyChild['vId']+ '">' +everyChild['name'];
						} else {
							tempHtml += '<input type="checkbox" name="treeBox" value="' +everyChild['vId']+ '"/><span value="' +everyChild['vId']+ '">' +everyChild['name'];
						}
					} else {
						tempHtml += '<span value="' +everyChild['vId']+ '">' +everyChild['name'];
					}
					tempHtml += '</span></div><div ' +tDStyle+ ' tR="tD' +everyChild['nId']+ '" ftR="' +everyChild['fId']+ '" class="pl10"></div>';
					//this.allChildNode.splice(0,1);
					//i--;
				}
			}
		}
		return tempHtml;
	}
	
	/**
	 * 判断是否展示checkbox的框
	 */
	this.isShowCheckBox = function(node) {
		if(this.isCheckBox) {
			if(this.showBoxFun) {
				return this.showBoxFun(node);
			}
			return true;
		} else {
			return false;
		}
	}
	
		
	/**
	 * 初始化CheckBox勾选的事件
	 */
	this.initCheckBoxEvent = function(cBox) {
		var cBoxVal = cBox.attr('value');
		var isChoose = cBox.attr('checked');
		if(isChoose) {
			if(this.selectCBox.length == 0) {
				this.selectCBox = cBoxVal;
			} else {
				this.selectCBox += ',' +cBoxVal;
			}
		} else {
			var updateSelBox = '';
			var selArray = this.selectCBox.split(',');
			for (var i = 0 ; i < selArray.length ; i++ ) {
				if(cBoxVal == selArray[i]) {
					continue;
				}
				updateSelBox += selArray[i] + ',';
			}
			this.selectCBox = updateSelBox.substring(0,updateSelBox.length - 1);
		}
		this.boxEventByOut(cBoxVal,isChoose);
	}
	
	/**
	 * checkbox勾选和取消的事件（外部扩展）
	 * vId:checkbox的value值
	 * isSelect:true勾选false取消
	 */
	this.boxEventByOut = function(vId,isSelect) {
		if(this.boxEventFun) {
			if(vId == this.headNode['vId'] ) {
				this.boxEventFun(this.headNode, isSelect);
			} else {
				for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
					var everyChild = this.allChildNode[i];
					if(vId == everyChild['vId']) {
						this.boxEventFun(everyChild ,isSelect);
						break;
					}
				}
			}
		}
	}

	/**
	 * 获取选择的复选框的值
	 */
	this.getSelectString = function() {
		return this.selectCBox;
	}

	/**
	 * 获取选择的复选框对象
	 */
	this.getSelectArray = function() {
		var selArray = new Array();
		var fSelCBox = ',' +this.selectCBox+ ',';
		if( fSelCBox.indexOf(','+this.headNode['nId']+',') != -1) {
			selArray.push(this.headNode);
			fSelCBox = fSelCBox.replace(','+this.headNode['nId'],'');
		}	
		for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
			var everyChild = this.allChildNode[i];
			if( fSelCBox.indexOf(','+everyChild['nId']+',') != -1) {
				selArray.push(everyChild);
			}
		}
		return selArray;
	}

	/**
	 * 根据selectCBox值勾选树中的节点
	 */
	this.setSelectCBox = function(selectParam) {
		this.removeAllSelectBox();
		this.selectCBox = selectParam;
		var selectedArray = this.selectCBox.split(',');
		for(var i = 0 ; i < selectedArray.length ; i ++ ) {
			this.cTreeDiv.find('input[value=' +selectedArray[i]+ ']').prop('checked',true);
		}
	}
	
	/**
	 * 清除所有选中的Box
	 */
	this.removeAllSelectBox = function() {
		this.selectCBox = '';
		this.cTreeDiv.find('input[name=treeBox]').removeProp('checked');
	}
	
	/**
	 * 添加一个节点
	 */
	this.addNode = function(node) {	
		// STEP-1 新的节点数据保存在页面的队列中
		this.allChildNode.push(node);
		var fId = node['fId'];
		// STEP-2 更新父节点的图片样式
		var tempDiv = this.cTreeDiv.find('div[tR=' +fId+ ']');
		var tImgs = tempDiv.find('img');
		var nextDiv = tempDiv.next();
		tImgs[0].src = this.openNPic;
		tImgs[1].src = this.openPic;
		nextDiv.show();
		// STEP-3 更新父节点的下的子节点页面显示
		var nDiv = this.cTreeDiv.find('div[tR=tD' +fId+ ']');
		nDiv.children().remove();
		var tHtml = this.getNodeHtml(fId);
		if('' != tHtml) {
			nDiv.append(tHtml);
			this.initCustomEvent(nDiv);	//初始化添加的事件
		}
	}
	
	/**
	 * 删除一个节点
	 */
	this.deleteNode = function(node) {
		var nId = node['nId'];
		// STEP-1 在队列中中删除的节点数据
		for (var i = 0 ; i < this.allChildNode.length ; i ++ ) {
			var tempNode = this.allChildNode[i];
			if(nId == tempNode['nId']) {
				this.allChildNode.splice(i,1);
				break;
			}
		}
		// STEP-2 页面删除该节点
		var tempDiv = this.cTreeDiv.find('div[tR=' +nId+ ']');
		tempDiv.remove();
		tempDiv.next().remove();
	}
	
	/**
	 * 修改一个节点
	 */
	this.updateNodeName = function(node) {
		var nId = node['nId'];
		// STEP-1 在队列中修改的节点名称
		for (var i = 0 ; i < this.allChildNode.length ; i ++ ) {
			var tempNode = this.allChildNode[i];
			if(nId == tempNode['nId']) {
				tempNode['name'] = node['name'];
				break;
			}
		}
		// STEP-2 修改页面节点名称
		this.cTreeDiv.find('span[value=' +nId+ ']').text(node['name']);
	}

}