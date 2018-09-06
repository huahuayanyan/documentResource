+(function(){
	var myBrowserType = myBrowser();
	if(myBrowserType =="IE"){
		window.console = window.console||{log:function(a){}};
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
		if(!Array.prototype.map){
			Array.prototype.map = function(callback,thisArg){
				var T, A,k = 0;
				if(this == null)
				throw new TypeError("this is null or not defined");
				if(typeof callback !== "function")
					throw new TypeError(callback + " is not a function");
				if(thisArg) T = thisArg;

				var  O = Object(this);
				var len = O.length >>> 0;
				A = new Array(len);
				while (k < len){
					var kValue, mappedValue;
					if(k in O){
						kValue = O[k];
						mappedValue = callback.call(T,kValue,k,O);
						A[k]  = mappedValue;
					}
					k++;
				}
				return A;
			};
		};
		if(!Array.prototype.filter){
			Array.prototype.filter = function(callback,thisArg){
				var T, A = [],k = 0;
				if(this == null)
					throw new TypeError("this is null or not defined");
				if(typeof callback !== "function")
					throw new TypeError(callback + " is not a function");
				if(thisArg) T = thisArg;

				var  O = Object(this);
				var len = O.length >>> 0;
				//A = new Array(len);
				while (k < len){
					var kValue, filterValue = false;
					if(k in O){
						kValue = O[k];
						filterValue = callback.call(T,kValue,k,O);
						if(filterValue){
							A.push(O[k]);
						};
					}
					k++;
				}
				return A;
			};
		};
		document.createElement("treecontrol");
		document.createElement("treeitem");
		document.createElement("ht-table");
		document.createElement("ht-column");
		document.createElement("ht-page");
		document.createElement("ht-legend");
		document.createElement("ht-form");
		document.createElement("ht-input");
		document.createElement("ht-text-area");
		document.createElement("ht-input-extent");
		document.createElement("ht-radio");
		document.createElement("ht-checkbox");
		document.createElement("ht-select");
		document.createElement("ht-button");
		document.createElement("ht-button-group");
		document.createElement("ht-tabs");
		document.createElement("ht-pane");
		document.createElement("ht-guide");
		document.createElement("ht-guide-dot");
		document.write('<script src="' + "../../scube_ui/lib/bower_components/jquery-1.10.2.js" + '"></script>');
		document.write('<script src="' + "../../scube_ui/lib/bower_components/html5shiv.js" + '"></script>');
	}else{
		document.write('<script src="' + "../../scube_ui/lib/bower_components/jquery-2.0.3.js" + '" type="text/javascript" ></script>');
	}
	var a=new Array(
		//"../../scube_ui/lib/bower_components/bootstrap.js",
		"../../scube_ui/lib/bower_components/jquery-ui-1.10.4.custom.js",
		"../../scube_ui/lib/bower_components/angular.min.js",
		"../../scube_ui/lib/bower_components/angular-ui-router.js",
		//"../../scube_ui/lib/bower_components/ui-bootstrap-tpls-0.7.js",
		"../../scube_ui/lib/plugins/jqValidate/jquery.poshytip.js",
		"../../scube_ui/common/commonAjax.js",
		"../../scube_ui/common/initialize.js",
		"../../scube_ui/lib/plugins/progressbar/custom_progressbar.js",
		"../../scube_ui/lib/plugins/echarts/dist/echarts.min.js",
		"../../scube_ui/lib/bower_components/ngDialog.js",
		"../../scube_ui/lib/angular-tree-control/angular-tree-control.js",
		//"../../scube_ui/lib/angular-file-upload-master/dist/angular-file-upload.min.js",
		"../../scube_ui/common_module/js/services/common.js",
		"../../scube_ui/common_module/js/directives/tableHelper.js",
		"../../scube_ui/common_module/js/directives/treeAuto.js",
		"../../scube_ui/lib/plugins/My97DatePicker/WdatePicker.js",
		"../../scube_ui/common/runModule.js"
	);
	for(var i=0;i<a.length;i++){
		var f=a[i];
		if(f.match(/.*\.js$/)){
			document.write('<script src="' + f + '?_='+new Date().getTime()+'" charset="utf-8"></script>');
		}
	}
})();