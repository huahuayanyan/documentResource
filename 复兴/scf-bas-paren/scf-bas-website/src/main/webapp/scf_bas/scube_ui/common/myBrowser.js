/**
 * Created by dengqing on 16-7-27.
 */
function myBrowser(){
    var userAgent = navigator.userAgent; //ȡ���������userAgent�ַ���
    var isOpera = userAgent.indexOf("Opera") > -1; //�ж��Ƿ�Opera�����
    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //�ж��Ƿ�IE�����
    var isFF = userAgent.indexOf("Firefox") > -1; //�ж��Ƿ�Firefox�����
    //var isSafari = userAgent.indexOf("Safari") > -1; //�ж��Ƿ�Safari�����
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
