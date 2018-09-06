 
(function(){
   
    var routeArry=[
        {
            'state':'writeoffList',
            'url':'/writeoffList',
            'default':'true',
            'templateUrl':'writeoff/writeoffList.html',
            'controller':'writeoffListController'
        },
        {
            'state':'writeoffRequest',
            'url':'/writeoffRequest',
            'default':'true',
            'templateUrl':'writeoff/writeoffRequest.html',
            'controller':'writeoffRequestController'
        },
        {
            'state':'queryRBcpDebtBaseList',
            'url':'/queryRBcpDebtBaseList',
            'default':'true',
            'templateUrl':'writeoff/rBcpDebtBaseList.html',
            'controller':'queryRBcpDebtBaseList'
        }

    ];

    var dependency=[
        //todo
    ];
    scubeUI.module('rbcpinfowriteoffmdle',dependency,routeArry)
}());
