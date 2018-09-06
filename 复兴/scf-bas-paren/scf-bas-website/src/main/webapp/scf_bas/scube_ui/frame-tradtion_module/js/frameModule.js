
(function(){
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
	var dependency=[
		'common',
		'tableHelper',
		'ngCookies'
	];
	window.frameModule = angular.module('frameModule',dependency).
	controller('frameController',frameController)
}());
