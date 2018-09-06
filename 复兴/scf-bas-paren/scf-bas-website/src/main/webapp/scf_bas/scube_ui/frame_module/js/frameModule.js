
(function(){
	var dependency=[
		'common',
		'ngCookies'
	];
	window.frameModule = angular.module('frameModule',dependency).
	controller('frameController',frameController)
}());
