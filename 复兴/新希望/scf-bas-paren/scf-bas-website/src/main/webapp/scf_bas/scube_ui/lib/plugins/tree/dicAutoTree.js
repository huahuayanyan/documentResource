var dicTreePicPath = '';
/**
 * 自定义树
 */
var CustomAutoTree = function() {
	this.cTreeDiv = null;	// 展示树的入口DIV
	
	this.isCheckBox = false;	// 是否加入CheckBox复选框
	
	this.isClickRow = false;	// 是否点击行触发事件，如果有CheckBox=true则必须为isClickRow=false
	this.isAllShow = false;	// 是否打开全部节点
	
	this.isAutoSelect = false;	// 是否自动勾选父子级关系
	this.selectCBox = '';	// 选中的值，以逗号隔开
	
	this.headNode = null;	// 首目录节点
	this.allChildNode = null;	// 首目录下所有的子节点
	this.firstNodeId = '-1';	// 首节点的nodeId
	
	this.customFun = null; // 自定义文字点击函数
	
	this.boxEventFun = null; // 自定义checkbox点击函数
	
	this.showBoxFun = null; // 自定义是否展示checkbox复选框
	
	this.initCheckNodes = new Array(); //保存初始化时就勾选的节点 @add by tianshuo
	this.isOptionTree = true;//是否可以操作勾选tree false是勾选框禁用和isCheckBox一起使用 @add by tianshuo
	
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
		
		if(undefined == tData['isCheckBox'] || null == tData['isCheckBox']) {
			this.isCheckBox = false;
		} else {
			this.isCheckBox = tData['isCheckBox'];	// 选中的值，以逗号隔开
		}
		
		if(undefined == tData['isOptionTree'] || null == tData['isOptionTree']) {
			this.isOptionTree = true;
		} else {
			this.isOptionTree = tData['isOptionTree'];	// 选中的值，以逗号隔开
		}
		
		this.isClickRow = tData['isClickRow'];
		this.isAutoSelect = tData['isAutoSelect'];
		this.isAllShow = tData['isAllShow'];
		
		this.firstNodeId = tData['firstNodeId'];
		this.headNode = tData['headNode'];
		this.allChildNode = tData['allChildNode'];
		
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
		if(this.isCheckBox || this.isAutoSelect) {
			// 加入自动勾选才有效
			if(!this.isOptionTree){//如果带有勾选框但是不可操作时，禁用勾选框@add by tianshuo
				this.cTreeDiv.find('input[name=treeBox]').prop("disabled","disabled");
			}else{
				this.cTreeDiv.find('input[name=treeBox]').click(function() {
					thisObj.initCheckBoxEvent($(this));
				});
			}
		}
	}
			
	/**
	 * 初始化div中的事件
	 *（提供加载子节点后注入事件）
	 * 暂时废弃
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
		}
		if(this.isAutoSelect) {	// 加入CheckBox复选框后，自动勾选才有效
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
			var tLPic = this.lastPic.replace(this.dPicUrl,'');
			if (tImgs[1].src.indexOf(tLPic) != -1) {	//目录节点是最后一级
				return;
			}
			tImgs[0].src = this.openNPic;
			tImgs[1].src = this.openPic;
			nextDiv.show();
		} else {	// 子节点已显示,需要隐藏
			var tLPic = this.lastPic.replace(this.dPicUrl,'');
			if (tImgs[1].src.indexOf(tLPic) == -1) {	//目录节点不是最后一级
				tImgs[0].src = this.closedNPic;
				tImgs[1].src = this.closedPic;
				nextDiv.hide();
			}
		}
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
		if (this.customFun) {
			var vId = rowDiv.attr("value");
			if(vId == this.headNode['vId'] ) {
				this.customFun(this.headNode );
			} else {
				for (var x in this.allChildNode) {
					var node = this.allChildNode[x];
					if (vId == node.vId) {
						this.customFun(node);
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
		var nodeHtml = this.loadHeadNode();
		if(this.isAllShow) {
			nodeHtml += this.buildChildNodeByShow();
		} else {
			nodeHtml += this.buildChildNodeByHide();
		}
		nodeHtml += '</div>';
		this.cTreeDiv.html(nodeHtml);
	}
	
	/**
	 * 写树首目录的html
	 */	
	this.loadHeadNode = function() {
		var headNodeHtml = '';
		//headNodeHtml += "<div style='width:100%;float:left;overflow-x:scroll;overflow-y:scroll';tR=" +this.headNode['vId']+ "class='commonRow dFC'>";
		headNodeHtml += '<div tR="' +this.headNode['vId']+ '" class="commonRow dFC">'
		headNodeHtml += '<img src="' +this.openNPic+ '"/><img src="' +this.openPic+ '"/>';
		if(this.isShowCheckBox(this.headNode) ) {
			var checkStyle = (this.headNode['check'] == 'true')? 'checked="checked"' : '';
			headNodeHtml += '<input type="checkbox" name="treeBox" value="' +this.headNode['vId']+ '" ' +checkStyle+ '/><span value="' +this.headNode['vId']+ '">' +this.headNode['name'];
		} else {
			headNodeHtml += '<span value="' +this.headNode['vId']+ '">' +this.headNode['name'];
		}
		headNodeHtml += '</span></div><div tR="tD' +this.headNode['vId']+ '" class="pl10">';
		return headNodeHtml;
	}	
	
	/**
	 * 修建所有节点的层级，并全部展现
	 */	
	this.buildChildNodeByShow = function() {
		var fatherNodeId = this.headNode['nId'];
		var tempLevel = parseInt(this.headNode['level']);
		var tempHtml = '';
		if(null != this.allChildNode) {
			for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
				var thisChild = this.allChildNode[i];
				var nextChild = null;
				if(i + 1 < this.allChildNode.length ) {
					nextChild = this.allChildNode[i+1];
				} else if(i + 1 == this.allChildNode.length) {
					// 最后一个节点一定是要用lastPic图片
					nextChild = new Object();
					nextChild['level'] = thisChild['level'];
				}
				if(fatherNodeId == thisChild['fId']) {
					fatherNodeId = thisChild['nId'];
				} else {
					var nLen = tempLevel - parseInt(thisChild['level']);
					for (var k = 0 ; k <= nLen ; k++ ) {
						tempHtml += '</div>';
					}
				}
				tempLevel = parseInt(thisChild['level']);
				tempHtml += '<div tR="' +thisChild['nId']+ '" ftR="' +thisChild['fId']+ '" class="commonRow dFC">';
				if( null != nextChild && thisChild['level'] >= nextChild['level']) {
					tempHtml += '<img src="' +this.openNPic+ '"/><img src="' +this.lastPic+ '"/>';
				} else {
					tempHtml += '<img src="' +this.openNPic+ '"/><img src="' +this.openPic+ '"/>';
				}
				if(this.isShowCheckBox(thisChild) ) {
					var checkStyle = (thisChild['check'] == 'true')? 'checked="checked"' : '';
					if(thisChild['check'] == 'true'){this.initCheckNodes.push(thisChild);}//@add by tianshuo
					tempHtml += '<input type="checkbox" name="treeBox" value="' +thisChild['nId']+ '" ' +checkStyle+ '/><span value="' +thisChild['nId']+ '">' +thisChild['name'];
				} else {
					tempHtml += '<span value="' +thisChild['nId']+ '">' +thisChild['name'];
				}
				tempHtml += '</span></div><div tR="tD' +thisChild['nId']+ '" ftR="' +thisChild['fId']+ '" class="pl10">';
			}
		}
		tempHtml += '</div>';
		return tempHtml;
	}
	
	/**
	 * 修建所有节点的层级，只展现第一层树节点
	 */	
	this.buildChildNodeByHide = function() {
		var fatherNodeId = '';
		var tempLevel = parseInt(this.headNode['level']);
		var tempHtml = '';
		if(null != this.allChildNode) {
			for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
				var thisChild = this.allChildNode[i];
				var nextChild = null;
				if(i + 1 < this.allChildNode.length ) {
					nextChild = this.allChildNode[i+1];
				} else if(i + 1 == this.allChildNode.length) {
					// 最后一个节点一定是要用lastPic图片
					nextChild = new Object();
					nextChild['level'] = thisChild['level'];
				}
				if(fatherNodeId == thisChild['fId']) {
					fatherNodeId = thisChild['nId'];
				} else {
					var nLen = tempLevel - parseInt(thisChild['level']);
					for (var k = 0 ; k <= nLen ; k++ ) {
						tempHtml += '</div>';
					}
				}
				tempLevel = parseInt(thisChild['level']);
				tempHtml += '<div tR="' +thisChild['nId']+ '" ftR="' +thisChild['fId']+ '" class="commonRow dFC">';
				if( null != nextChild && thisChild['level'] >= nextChild['level']) {
					tempHtml += '<img src="' +this.openNPic+ '"/><img src="' +this.lastPic+ '"/>';
				} else {
					tempHtml += '<img src="' +this.closedNPic+ '"/><img src="' +this.closedPic+ '"/>';
				}
				if(this.isShowCheckBox(thisChild) ) {
					var checkStyle = (thisChild['check'] == 'true')? 'checked="checked"' : '';
					if(thisChild['check'] == 'true'){this.initCheckNodes.push(thisChild);}//@add by tianshuo
					tempHtml += '<input type="checkbox" name="treeBox" value="' +thisChild['nId']+ '" ' +checkStyle+ '/><span value="' +thisChild['nId']+ '">' +thisChild['name'];
				} else {
					tempHtml += '<span value="' +thisChild['nId']+ '">' +thisChild['name'];
				}
				tempHtml += '</span></div><div style="display: none;" tR="tD' +thisChild['nId']+ '" ftR="' +thisChild['fId']+ '" class="pl10">';
			}
		}
		tempHtml += '</div>';
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
	 * 初始化CheckBox上下级自动勾选的事件
	 */
	this.initCheckBoxEvent = function(cBox) {
		var cBoxVal = cBox.prop('value');
		var isChoose = cBox.prop('checked');
		if(this.isAutoSelect) {
			if(isChoose) {
				// 1-父节点全部勾选
				this.cTreeDiv.find('input[value=' +cBoxVal+ ']').prop('checked',true);
				var fId = cBox.parent().attr('ftR');
				while(fId) {
					var fCBox = this.cTreeDiv.find('input[value=' +fId+ ']');
					fCBox.prop('checked',true);
					fId = fCBox.parent().attr('ftR');
				}
				// 2-子节点全部勾选
				this.cTreeDiv.find('div[tR=tD' +cBoxVal+ ']').find('input[name=treeBox]').prop('checked',true);
				this.initSelectNodeData(cBoxVal);	// 勾选节点的数据集
			} else {
				// 1-子节点全部取消勾选
				this.cTreeDiv.find('div[tR=tD' +cBoxVal+ ']').find('input[name=treeBox]').removeProp('checked');
				this.initCancelNodeData(cBoxVal);	// 取消勾选节点的数据集
			}
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
	 * 勾选节点的数据集
	 * 待扩展
	 */
	this.initSelectNodeData = function(cBoxVal){

	}
	
	/**
	 * 取消勾选节点的数据集
	 * 待扩展
	 */
	this.initCancelNodeData = function(cBoxVal){
	
	}

	/**
	 * 获取选择的复选框的值
	 */
	this.getSelectString = function() {
		this.selectCBox = '';
		var selectedArray = this.cTreeDiv.find("input[name=treeBox]:checked");
		for(var i = 0 ; i < selectedArray.length ; i ++ ) {
			this.selectCBox += selectedArray[i].value + ',';
		}
		this.selectCBox = this.selectCBox.replace(this.firstNodeId+"," , "");	// 去除首节点
		if(this.selectCBox.length > 0) {
			this.selectCBox = this.selectCBox.substring(0,this.selectCBox.length - 1);
		}
		return this.selectCBox;
	}
	/**根据ID获取选择字符串*/
	this.getSelectStringById = function(id){
		this.getSelectString();
		var selArray = new Array();
		var fSelCBox = ',' +this.selectCBox+ ',';
		for (var i = 0 ; i < this.allChildNode.length ; i++) {
			var everyChild = this.allChildNode[i];
			if( fSelCBox.indexOf(','+everyChild['nId']+',') != -1) {
				selArray.push(eval('everyChild.' + id));
			}
		}
		return selArray.join(",");
	};
	
	/**
	 * 获取选择的复选框对象
	 */
	this.getSelectArray = function() {
		this.getSelectString();
		var selArray = new Array();
		var fSelCBox = ',' +this.selectCBox+ ',';
		for (var i = 0 ; i < this.allChildNode.length ; i++ ) {
			var everyChild = this.allChildNode[i];
			if( fSelCBox.indexOf(','+everyChild['nId']+',') != -1) {
				selArray.push(everyChild);
			}
		}
		return selArray;
	}
	
	/**
	 * 判断该节点是否被勾选
	 */
	this.isSelectedByNode = function(nodeId) {
		this.getSelectString();
		var fSelCBox = ',' +this.selectCBox+ ',';
		var indexCode = fSelCBox.indexOf(',' +nodeId+ ',');
		return indexCode >= 0 ? true : false;
	}

	/**
	 * 根据selectParam值勾选树中的节点
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
	 * 根据selectParam值触发树节点勾选节点事件
	 */
	this.setSelectBoxEvent = function(selectParam) {
		this.selectCBox = selectParam;
		var selectedArray = this.selectCBox.split(',');
		for(var i = 0 ; i < selectedArray.length ; i ++ ) {
			this.cTreeDiv.find('input[value=' +selectedArray[i]+ ']').click();
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
	
	
	/**
	* 勾选全部的节点，并获取节点信息
	*/
	this.checkAllSelectBox = function(){
	   this.cTreeDiv.find('input[name=treeBox]').prop('checked','true');
	}
	
	this.showNodebyVid=function(vId){
		this.cTreeDiv.find('span').removeProp("style");
		var datas=this.cTreeDiv.find('span');
		for(var k=0;k<datas.length;k++){
			if(datas[k].value==vId){
				var t=$(datas[k]).parents("div");
				$(t[0]).find('span').css('color','#FF0000');
				$(t).css('display','block');
				for(var i=2;i<t.length-1;i++){
					var m=$(t[i]).children();
					for(var j=0;j<m.length;j++){
						if(m[j]==t[i-1]){
							var img=$(m[j-1]).find('img');
							if(img!=null&&img.length>0){
								img[0].src=this.openNPic;
							}
							break;
						}
					}
				}
				break;
			}
			
		}
	}

}