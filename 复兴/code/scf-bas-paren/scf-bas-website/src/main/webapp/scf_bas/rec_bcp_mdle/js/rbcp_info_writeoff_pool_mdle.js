 
(function(){
   
    var routeArry=[
        {
            'state':'writeoffList',
            'url':'/writeoffList',
            'default':'true',
            'templateUrl':'writeoffPool/writeoffList.html',
            'controller':'writeoffListController'
        },
        {
            'state':'writeoffRequest',
            'url':'/writeoffRequest',
            'default':'true',
            'templateUrl':'writeoffPool/writeoffRequest.html',
            'controller':'writeoffRequestController'
        },
        {
            'state':'queryRBcpDebtBaseList',
            'url':'/queryRBcpDebtBaseList',
            'default':'true',
            'templateUrl':'writeoffPool/rBcpDebtBaseList.html',
            'controller':'queryRBcpDebtBaseList'
        }

    ];

    var dependency=[
        //todo
    ];
    scubeUI.module('rbcpinfowriteoffmdle',dependency,routeArry)
}());
