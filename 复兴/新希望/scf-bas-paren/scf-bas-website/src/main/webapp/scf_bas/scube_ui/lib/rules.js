var isLoginName = "^[A-Za-z][A-Za-z0-9\\_\\@\\.]+$";
var isFaxNumber = "^[0-9\\-]+$";
var isNumOrWord = "^[A-Za-z0-9]+$";
var isPassWord =  "^[A-Za-z0-9\\_\\@]+$";
var isNum = "^[0-9]+$";
var isNotEmpty = ".+";
var isNotSpace = "^\\S+$";
var isPositiveNumber = "^\\d+\\.?\\d*$";
var isPositiveNumber_12_2 = "^\\d{1,10}(\\.\\d{0,2}){0,1}$";
var isPositiveNumber_10_2 = "^\\d{1,8}(\\.\\d{0,2}){0,1}$";
var isPositiveNumber_11_2 = "^\\d{1,9}(\\.\\d{0,2}){0,1}$";
var isPositiveNumber_10_3 = "^\\d{1,7}(\\.\\d{0,3}){0,1}$";
var isPositiveInteger = "^\\d*[1-9]+\\d*$";
var isPositiveNumber_15_3 = "^\\d{1,12}(\\.\\d{0,3}){0,1}$";
var isPositiveNumber_16_2 = "^\\d{1,14}(\\.\\d{0,2}){0,1}$";
var isMobile = "^1\\d{10}$";
var isZipCode = "^\\d{6}$";
var isBpNumber = "^\\d{5,8}[-]?\\d{3,7}$";
var isPhoneNumber = "^[\\d-]{6,32}$";
var isFileName = "^[a-zA-Z0-9\\.-_]+$";
var isWord = "^\\w+$";
var isPidNumber = "^[1-9]\\d{14,17}[xX]?$";
var isTime="^([0-1][0-9]|[2][0-3]):([0-5][0-9])$";
var isValidDate = "^((1[6-9]|[2-9]\\d)?\\d{2})-(((0[13578]|1[02])-31)|((0[1,3-9]|1[0-2])-(29|30)))$|^(((1[6-9]|[2-9]\\d)?(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)))-(02-29)$|^((1[6-9]|[2-9]\\d)?\\d{2})-((0[1-9])|(1[0-2]))-(0[1-9]|1\\d|2[0-8])$";
var isValidDateWithTime= "^((1[6-9]|[2-9]\\d)?\\d{2})-(((0[13578]|1[02])-31)|((0[1,3-9]|1[0-2])-(29|30)))(\\s((\\b0\\d\\b)|(1\\d)|(2[0-3])):((\\b0\\d\\b)|([1-5]\\d))){0,1}$|^(((1[6-9]|[2-9]\\d)?(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)))-(02-29)(\\s((\\b0\\d\\b)|(1\\d)|(2[0-3])):((\\b0\\d\\b)|([1-5]\\d))){0,1}$|^((1[6-9]|[2-9]\\d)?\\d{2})-((0[1-9])|(1[0-2]))-(0[1-9]|1\\d|2[0-8])(\\s((\\b0\\d\\b)|(1\\d)|(2[0-3])):((\\b0\\d\\b)|([1-5]\\d))){0,1}$";
var isEmail = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
var isChineseName = "^[\u4E00-\u9FA5]{2,}$";
var isChinese= "^[\u4E00-\u9FA5]+$";
var isURL = "^(http://){0,1}.+\\..+\\..+$";
var isValidDateText="^[0-9]{4}[-\\.\/][0-1]{1}[0-9]{1}[-\\.\/][0-9]{1,2}$";
var isDbString="[^'%\"<>]+";
var isMonthDay = "^\\d{1,31}$";
//var isNumber = "[01]";
var isSpecNumber = "^\\-?\\d*[0-9]+\\d*$";
var isPosiInteger = "^\\d*[0-9]+\\d*$";
var isBillDt = "^((1[6-9]|[2-9]\\d)?\\d{2})(0[1-9]|10|11|12)$";
var isNumber1 = "^\\d{1}$";
var isNumber2 = "^\\d{2}$";
var isNumber3 = "^\\d{3}$";
var isNumber4 = "^\\d{4}$";
var isNumber5 = "^\\d{5}$";
var isNumber6 = "^\\d{6}$";
var isNumber7 = "^\\d{7}$";
var isNumber8 = "^\\d{8}$";
var isNumber9 = "^\\d{9}$";
var isNumber10 = "^\\d{10}$";
var isNumber11 = "^\\d{11}$";
var isNumber12 = "^\\d{12}$";
var isNumber13 = "^\\d{13}$";
var isPositiveNumber11 = "^\\d{11}$";
var isPassWord6 =  "^[A-Za-z0-9\\_\\@]{6}$";
var isMon = "^((\\d{1,6}\\.\\d{1,2})|(\\d{1,6}))$";
var isValidDateFormat = "(\\d{4}\\-((0[1-9])|(1[012]))\\-((0[1-9])|([1-2][0-9])|(3[01])))";
var isValidDateFormat_YYYYMMDD = "(\\d{4}\\((0[1-9])|(1[012]))\\((0[1-9])|([1-2][0-9])|(3[01])))";
var isMon14 = "^((\\d{1,12}\\.\\d{1,2})|(\\d{1,12}))$";
var isTime="^(0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})$";
var isNumber620 = "^\\d{6,20}$";
/** add by haizhou.li 20100824 BMS-2473   begin */
var isNumber015 = "^\\d{0,15}$";
/** add by haizhou.li 20100824 BMS-2473   end */
var isPosInt2 = "^\\d{1,2}$";


/*                   SEMS             .*/
var isTlrno="^\\d{8}$";
var isRate_8_6 = "^\\d{1,2}(\\.\\d{0,6}){0,1}$";
var isRate_6_2 = "^\\d{1,4}(\\.\\d{0,2}){0,1}$";
var isRate_5_2 = "^\\d{1,3}(\\.\\d{0,2}){0,1}$";
var isRate_5_4 = "^\\d{1,1}(\\.\\d{0,4}){0,1}$";
var isRate_18_2 = "^\\d{1,16}(\\.\\d{0,2}){0,1}$";
/** add by jornezhang 20091007 BMS-2042   begin */
var isShiBorRate_5_4 = "^[-]{0,1}\\d{1,1}(\\.\\d{0,4}){0,1}$";//-9.9999<=rate<=9.9999
/** add by jornezhang 20091007 BMS-2042   end */
/** modify by fanrong 20101125 BMS-2888   begin */
var isDraftNumber = "^[A-Z][A-Z]\\d{10}$|^\\d{16}$";
/** modify by fanrong 20101125 BMS-2888   end */
var isOrgCode ="^[0-9A-Z]{8}-[0-9X]$";
var isPositiveNumber_11_2 = "^\\d{1,9}(\\.\\d{0,2}){0,1}$";
var shiBorRate = "^[-]{0,1}\\d{1,4}(\\.\\d{0,2}){0,1}$";

/**add by lizh 20091125 BMS-2232 this expression function is filter Single quote ; begin */
var isNotQuote = "^[^\']*$";
/**add by lizh BMS-2232 end */

/** JIRA:2297 2009-12-03 Begin */
/** This regular expression will check the
 * illegal strings that contain %,",',\,?,/ */
var isNotSepcialMark="^[^%\"\'\\\\/\?]+$";
/** JIRA:2297 End */
/** add by henry 20110617 Begin ECDStime**/
var ecdsRules = "(^[1-9]$)|(^1[0-9]$)|(^2[0-9]$)|(^3[0-6]$)";
/** add by henry 20110617 End ECDS**/