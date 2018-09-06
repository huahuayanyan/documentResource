(function(){
	window.sysApp.filter("pageContent",function(){
		return function(input,startNum){
			if(input!=undefined){
				return input.slice(startNum,startNum+10);
			}
		}
	});
}());