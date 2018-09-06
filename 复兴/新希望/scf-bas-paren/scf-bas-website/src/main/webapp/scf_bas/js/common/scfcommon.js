var printParam;
function toPrint(param){
	printParam=param;
    window.open("../../../scf_bas/notice/htPrintWindow.html?_="+Math.random(),"_blank","height="+window.screen.availHeight/1.1+",width="+window.screen.availWidth/1.2+",scrollbars=yes");
}
function toFactoringPrint(param){
    printParam=param;
    window.open("../../../scf_bas/report/factoringReportWindow.html?_="+Math.random(),"_blank","height="+window.screen.availHeight/1.1+",width="+window.screen.availWidth/1.2+",scrollbars=yes");
}
var reportParam;
function toReport(param){
    reportParam=param;
    window.open("../../../scf_bas/report/htReportWindow.html?_="+Math.random(),"_blank","height="+window.screen.availHeight/1.1+",width="+window.screen.availWidth/1.2+",scrollbars=yes");
}
