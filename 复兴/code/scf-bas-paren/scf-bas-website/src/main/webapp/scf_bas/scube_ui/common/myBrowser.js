/**
 * Created by dengqing on 16-7-27.
 */
function myBrowser(){
    var userAgent = navigator.userAgent; //»°µ√‰Ø¿¿∆˜µƒuserAgent◊÷∑˚¥Æ
    var isOpera = userAgent.indexOf("Opera") > -1; //≈–∂œ «∑ÒOpera‰Ø¿¿∆˜
    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //≈–∂œ «∑ÒIE‰Ø¿¿∆˜
    var isFF = userAgent.indexOf("Firefox") > -1; //≈–∂œ «∑ÒFirefox‰Ø¿¿∆˜
    //var isSafari = userAgent.indexOf("Safari") > -1; //≈–∂œ «∑ÒSafari‰Ø¿¿∆˜
    if (isIE) {
        //var  IE7 = IE8 = false;
        //var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        //reIE.test(userAgent);
        //var fIEVersion = parseFloat(RegExp["$1"]);
        //IE7 = fIEVersion == 7.0;
        //IE8 = fIEVersion == 8.0;
        //if (IE7) {
        //    return "IE7";
        //}
        //if (IE8) {
        //    return "IE8";
        //}
        return "IE";
    }//isIE end
    if (isFF) {
        return "FF";
    }
    if (isOpera) {
        return "Opera";
    }
}//myBrowser() end
