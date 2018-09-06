+(function(){
	var a=new Array(
		"../../scube_ui/css/bootstrap.css" ,
		"../../scube_ui/css/jquery-ui/jquery-ui-1.10.4.custom.css" ,
		"../../scube_ui/css/ace.min.css",
		"../../scube_ui/lib/plugins/progressbar/css/custom_progressbar.css",
		"../../scube_ui/lib/plugins/tree/dicTree.css",
		"../../scube_ui/css/ngDialog.css" ,
		"../../scube_ui/css/ngDialog-theme-default.css" ,
		"../../scube_ui/css/ngDialog-theme-plain.css" ,
		"../../scube_ui/lib/plugins/jqValidate/tip-yellowsimple/tip-yellowsimple.css",
		"../../scube_ui/lib/angular-tree-control/css/tree-control.css",
		"../../scube_ui/css/components-green.css",
		"../../scube_ui/css/public.css"
	);
	for(var i=0;i<a.length;i++){
		var f=a[i];
		if(f.match(/.*\.css$/)){
			document.write('<link href="' + f + '?_='+new Date().getTime()+'" rel="stylesheet" >'+'</link>');
		}
	}
})();