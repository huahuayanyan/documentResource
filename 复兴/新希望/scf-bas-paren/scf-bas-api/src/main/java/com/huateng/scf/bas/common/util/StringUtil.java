/**
 * 
 */
package com.huateng.scf.bas.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>字符串工具类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月10日上午9:56:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月10日上午9:56:56	                                 新增
 *
 * </pre>
 */
public class StringUtil {
	public static String amountToString(Double d) {
		DecimalFormat df = new DecimalFormat("#,##0.##");
		return df.format(d);
	}

	public static String trimLeft(String value) {
		if (value == null) {
			return "";
		}
		String result = value;
		char[] ch = result.toCharArray();
		int index = -1;
		for (int i = 0; (i < ch.length) && (Character.isWhitespace(ch[i])); i++) {
			index = i;
		}

		if (index != -1) {
			result = result.substring(index + 1);
		}
		return result;
	}

	public static String trimRight(String value) {
		if (value == null) {
			return "";
		}

		String result = value;
		char[] ch = result.toCharArray();
		int endIndex = -1;
		for (int i = ch.length - 1; (i > -1) && (Character.isWhitespace(ch[i])); i--) {
			endIndex = i;
		}

		if (endIndex != -1) {
			result = result.substring(0, endIndex);
		}
		return result;
	}

	public static String fillHeadCharsLen(String strOri, int len) {
		return fillHeadCharsLen(strOri, "0", len);
	}

	public static String fillBackCharsLen(String strOri, int len) {
		return fillBackCharsLen(strOri, "0", len);
	}

	public static String fillHeadCharsLen(String strOri, String subStr, int len) {
		if ((strOri == null) || (strOri.trim().length() == 0)) {
			strOri = "";
		}
		if (subStr == null) {
			subStr = " ";
		}
		String fillStr = "";
		for (int i = 0; i < len; i++) {
			fillStr = fillStr + subStr;
		}
		subStr = fillStr + strOri;

		return subStr.substring(subStr.length() - len, subStr.length());
	}

	public static String fillBackCharsLen(String strOri, String subStr, int len) {
		if ((strOri == null) || (strOri.trim().length() == 0)) {
			strOri = "";
		}
		if (subStr == null) {
			subStr = " ";
		}
		String fillStr = "";
		for (int i = 0; i < len; i++) {
			fillStr = fillStr + subStr;
		}
		subStr = strOri + fillStr;

		return subStr.substring(0, len);
	}

	public static String fillHeadChars(String strOri, int counter) {
		return fillHeadChars(strOri, "0", counter);
	}

	public static String fillBackChars(String strOri, int counter) {
		return fillBackChars(strOri, "0", counter);
	}

	public static String fillHeadChars(String strOri, String subStr, int counter) {
		if ((strOri == null) || (strOri.trim().length() == 0)) {
			strOri = "";
		}
		if ((counter <= 0) || (subStr == null)) {
			return strOri;
		}
		String fillStr = "";
		for (int i = 0; i < counter; i++) {
			fillStr = fillStr + subStr;
		}
		return fillStr + strOri;
	}

	public static String fillBackChars(String strOri, String subStr, int counter) {
		if ((strOri == null) || (strOri.trim().length() == 0)) {
			strOri = "";
		}
		if ((counter <= 0) || (subStr == null)) {
			return strOri;
		}
		String fillStr = "";
		for (int i = 0; i < counter; i++) {
			fillStr = fillStr + subStr;
		}
		return strOri + fillStr;
	}

	public static boolean notNullEquals(String str1, String str2) {
		if(StringUtil.isStrEmpty(str1) || StringUtil.isStrEmpty(str2)) {
			return false;
		}

		return str1.equals(str2);
	}

	public static boolean isEmpty(Object strObj) {
		return (strObj == null) || (strObj.toString().trim().length() < 1);
	}

	public static boolean isStrNotEmpty(String str) {
		return !StringUtil.isStrEmpty(str);
	}

	public static boolean isStrEmpty(String str) {
		return (str == null) || (str.trim().length() < 1);
	}

	public static String getValue(String str) {
		if (str == null) {
			return "";
		}
		if (str.trim().length() <= 0)
			return "";
		str = "H" + str;
		str = str.trim();
		str = str.substring(1);
		return str;
	}

	public static boolean chkTextLen(String text, int len) {
		return (text != null) && (text.length() <= len);
	}

	public static boolean chkTextTrimLen(String text, int len) {
		return (text != null) && (text.trim().length() <= len);
	}

	public static boolean isStrEn(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) > '') {
				return false;
			}
		}
		return true;
	}

	public static boolean isCharNum(char ch) {
		return (ch > '/') && (ch < ':');
	}

	public static boolean isStrNum(String str) {
		if (isStrEmpty(str)) {
			return true;
		}
		boolean notNum = false;
		for (int i = 0; i < str.length(); i++) {
			if (!isCharNum(str.charAt(i))) {
				notNum = true;
			}
		}
		return !notNum;
	}

	public static boolean isNum(String strSrc) throws Exception {
		for (int i = 0; i < strSrc.length(); i++) {
			if (!isCharNum(strSrc.charAt(i)))
				return false;
		}
		return true;
	}

	public static boolean isCharLetter(char ch) {
		return (ch >= 'A') && (ch <= 'Z') && (ch >= 'a') && (ch <= 'z');
	}

	public static boolean isStrLetter(String str) {
		if (isStrEmpty(str))
			return true;
		boolean notLetter = false;
		for (int i = 0; i < str.length(); i++) {
			if (!isCharLetter(str.charAt(i))) {
				notLetter = true;
			}
		}
		return !notLetter;
	}

	public static String nullToSpace(String Content) {
		if (Content == null) {
			Content = "";
		}
		return Content;
	}

	public static char strToChar(String src) {
		src = src.trim();
		char result = src.charAt(0);
		return result;
	}

	public static String encodeSQL(String sql) {
		StringBuffer tempBuff = new StringBuffer();
		for (int i = 0; i < sql.length(); i++) {
			tempBuff.append(Integer.toHexString(sql.charAt(i)));
		}
		return tempBuff.toString();
	}

	public static String decodeSQL(String encoded) {
		StringBuffer tempBuff = new StringBuffer();
		for (int i = 0; i < encoded.length(); i += 2) {
			tempBuff.append((char) Integer.parseInt(
					encoded.substring(i, i + 2), 16));
		}
		return tempBuff.toString();
	}

	public static String getAbsolutePath(String path1, String context1) {
		int i1 = path1.indexOf(context1);
		if (i1 < 0) {
			return path1;
		}
		return path1.substring(path1.indexOf(context1) + context1.length());
	}

	public static String getSubString(String str1, int sindex, int eindex) {
		if (str1 == null) {
			return "";
		}
		if (str1.trim().length() <= 0)
			return "";
		if (str1.length() > sindex) {
			if (eindex >= 0)
				return str1.substring(sindex, eindex);
			if (eindex < 0)
				return str1.substring(sindex);
		}
		return "";
	}

	public static String[] getValues(String[] strs, int size1) {
		String[] strs1 = new String[size1];
		for (int i = 0; i < size1; i++) {
			strs1[i] = "";
		}
		if (strs == null) {
			return strs1;
		}
		if (strs.length < size1) {
			for (int i = 0; i < strs.length; i++) {
				strs1[i] = strs[i];
			}
			return strs1;
		}
		return strs;
	}

	public static String replaceStrAll(String strSource, String strFrom,
			String strTo) {
		String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;
		return strDest;
	}

	public static String replaceStr(String strTarget, String strNew) {
		int iIndex = -1;
		while (true) {
			iIndex = strTarget.indexOf('\n');

			if (iIndex < 0) {
				break;
			}
			String strTemp = null;
			strTemp = strTarget.substring(0, iIndex);

			strTarget = strTemp + strNew + strTarget.substring(iIndex + 1);
		}

		return strTarget;
	}

	public static boolean includestr(String str1, String[] strarray) {
		if ((strarray == null) || (strarray.length <= 0))
			return false;
		for (int i = 0; i < strarray.length; i++) {
			if (strarray[i] == null) {
				if (str1 == null) {
					return true;
				}

			} else if (strarray[i].trim().equals(str1)) {
				return true;
			}
		}
		return false;
	}

	public static String[] getAreaValues(String fvalue) {
		String tmpstr = fvalue;
		int i = 0;
		if (tmpstr == null) {
			return null;
		}
		if (tmpstr.trim().equals("")) {
			return null;
		}
		while (tmpstr.indexOf("\n") >= 0) {
			i++;
			tmpstr = tmpstr.substring(tmpstr.indexOf("\n") + 1);
		}

		if (tmpstr.trim().equals("")) {
			i--;
		}
		String[] fvalues = new String[i + 1];
		tmpstr = fvalue;
		i = 0;
		while (tmpstr.indexOf("\n") >= 0) {
			fvalues[i] = tmpstr.substring(0, tmpstr.indexOf("\n"));
			if (fvalues[i].indexOf("\r") >= 0)
				fvalues[i] = fvalues[i].substring(0, fvalues[i].indexOf("\r"));
			i++;
			tmpstr = tmpstr.substring(tmpstr.indexOf("\n") + 1);
		}
		if (!tmpstr.trim().equals(""))
			fvalues[i] = tmpstr;
		return fvalues;
	}

	public static String getrealAreaValues(String fvalue) {
		String tmpstr = fvalue;
		String returnstr = "";
		if (tmpstr == null) {
			return null;
		}
		if (tmpstr.trim().equals("")) {
			return "";
		}
		while (tmpstr.indexOf("|") > 0) {
			returnstr = returnstr + tmpstr.substring(0, tmpstr.indexOf("|"))
					+ "\n";
			tmpstr = tmpstr.substring(tmpstr.indexOf("|") + 1);
		}
		return returnstr;
	}

	public static int countChar(String strInput, char chr) {
		int iCount = 0;
		char chrTmp = ' ';

		if (strInput.trim().length() == 0) {
			return 0;
		}

		for (int i = 0; i < strInput.length(); i++) {
			chrTmp = strInput.charAt(i);
			if (chrTmp == chr) {
				iCount++;
			}
		}
		return iCount;
	}

	public static String strArrayToStr(String[] strs) {
		return strArrayToStr(strs, null);
	}

	public static void printStrs(String[] strs) {
		for (int i = 0; i < strs.length; i++)
			System.out.println(strs[i]);
	}

	public static void printDualStr(String[][] dualStr) {
		for (int i = 0; i < dualStr.length; i++) {
			for (int j = 0; j < dualStr[i].length; j++) {
				System.out.print(dualStr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static String[][] rowToColumn(String[][] dualStr) {
		String[][] returnDualStr = (String[][]) null;
		if (dualStr != null) {
			returnDualStr = new String[dualStr[0].length][dualStr.length];
			for (int i = 0; i < dualStr.length; i++)
				for (int j = 0; j < dualStr[0].length; j++)
					returnDualStr[j][i] = dualStr[i][j];
		}
		return returnDualStr;
	}

	public static String latinString(String inStr) {
		String res = inStr;
		if (null == res) {
			return null;
		}
		res = replaceStrAll(res, "\"", "\\\"");
		res = replaceStrAll(res, "'", "\\'");
		return res;
	}

	public static String replaceWhiteSpace(String strTarget, String strNew) {
		int iIndex = -1;
		while (true) {
			char cRep = ' ';
			iIndex = strTarget.indexOf(cRep);

			if (iIndex < 0) {
				break;
			}
			String strTemp = null;
			strTemp = strTarget.substring(0, iIndex);
			strTarget = strTemp + strNew + strTarget.substring(iIndex + 1);
		}

		return strTarget;
	}

	public static String double2str(double amount, int length) {
		String strAmt = Double.toString(amount);
		int pos = strAmt.indexOf('.');

		if ((pos != -1) && (strAmt.length() > length + pos + 1)) {
			strAmt = strAmt.substring(0, pos + length + 1);
		}

		return strAmt;
	}

	public static String[] doSplit(String str, char chr) {
		int iCount = 0;
		char chrTmp = ' ';

		for (int i = 0; i < str.length(); i++) {
			chrTmp = str.charAt(i);
			if (chrTmp == chr) {
				iCount++;
			}
		}
		String[] strArray = new String[iCount];
		for (int i = 0; i < iCount; i++) {
			int iPos = str.indexOf(chr);
			if (iPos == 0)
				strArray[i] = "";
			else {
				strArray[i] = str.substring(0, iPos);
			}
			str = str.substring(iPos + 1);
		}
		return strArray;
	}

	public static String[] strSplit(String src, String splitchar) {
		int resultSize = 0;
		int len = src.length();
		int idx = 0;
		String strTemp = "";

		for (int i = 0; i < len; i++) {
			if (src.substring(i, i + 1).equals(splitchar)) {
				resultSize++;
			}
		}

		if (((len > 1 ? 1 : 0) & (!src.substring(len - 1, len)
				.equals(splitchar) ? 1 : 0)) != 0) {
			resultSize++;
		}
		String[] result = new String[resultSize];
		for (int i = 0; i < len; i++) {
			if (src.substring(i, i + 1).equals(splitchar)) {
				result[idx] = strTemp;
				idx++;
				strTemp = "";
			} else {
				strTemp = String.valueOf(strTemp)
						+ String.valueOf(src.charAt(i));
			}
		}

		if (!strTemp.equals("")) {
			result[idx] = strTemp;
		}
		return result;
	}

	public static String[] split(String strToSplit, String strSeparator,
			int iLimit) {
		ArrayList tmpList = new ArrayList();
		int iFromIndex = 0;
		int iCurIndex = strToSplit.length();
		String strUnitInfo = "";
		int iCurCounts = 0;

		while ((iCurIndex != -1) && (iFromIndex < strToSplit.length())
				&& (iCurCounts < iLimit)) {
			iCurIndex = strToSplit.indexOf(strSeparator, iFromIndex);
			if (iCurIndex == -1) {
				strUnitInfo = strToSplit.substring(iFromIndex,
						strToSplit.length());
			} else {
				strUnitInfo = strToSplit.substring(iFromIndex, iCurIndex);
				iFromIndex = iCurIndex + 1;
			}
			tmpList.add(strUnitInfo);
			iCurCounts++;
		}

		int iCounts = tmpList.size();
		String[] tmpArray = new String[iCounts];
		for (int i = 0; i < iCounts; i++) {
			tmpArray[i] = ((String) tmpList.get(i));
		}
		return tmpArray;
	}

	public static String strIntercept(String src, int len) {
		if (src == null) {
			return "";
		}
		if (src.length() > len) {
			src = String.valueOf(String.valueOf(src.substring(0, len))).concat(
					"...");
		}
		return src;
	}

	public static String strtochn(String str_in) {
		try {
			String temp_p = str_in;
			if (temp_p == null) {
				temp_p = "";
			}
			String temp = "";
			if (!temp_p.equals("")) {
				byte[] byte1 = temp_p.getBytes("ISO8859_1");
				temp = new String(byte1);
			}
			return temp;
		} catch (Exception e) {
		}
		return "null";
	}

	public static String ISO2GBK(String strvalue) {
		try {
			if (strvalue == null) {
				return null;
			}
			strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
			return strvalue;
		} catch (Exception e) {
		}
		return null;
	}

	public String GBK2ISO(String strvalue) throws Exception {
		try {
			if (strvalue == null) {
				return null;
			}
			strvalue = new String(strvalue.getBytes("GBK"), "ISO8859_1");
			return strvalue;
		} catch (Exception e) {
		}
		return null;
	}

	public static String cnCodeTrans(String str) {
		String s = "";
		try {
			s = new String(str.getBytes("GB2312"), "8859_1");
		} catch (UnsupportedEncodingException a) {
			System.out.print("chinese thansform exception");
		}
		return s;
	}

	public static boolean judgeMatch(String strSource, String strRule) {
		int i = 0;

		if ((null == strSource) || (strSource.length() == 0)) {
			return false;
		}
		if ((null == strRule) || (strRule.length() == 0)) {
			return false;
		}
		if (strSource.length() > strRule.length()) {
			return false;
		}
		for (i = 0; i < strRule.length(); i++) {
			if (strSource.length() < i + 1) {
				break;
			}
			if ((strRule.charAt(i) != '*')
					&& (strSource.charAt(i) != strRule.charAt(i))) {
				return false;
			}
		}

		for (; i < strRule.length(); i++) {
			if (strRule.charAt(i) != '*')
				return false;
		}
		return true;
	}

	public static String column2Property(String column) {
		column = column.toLowerCase();
		int i = column.indexOf("_");
		while ((i != -1) && (i != column.length() - 1)) {
			char temp = column.charAt(i + 1);
			String strTemp = String.valueOf(temp);
			column = column.replaceFirst("_" + strTemp, strTemp.toUpperCase());
			i = column.indexOf("_");
		}

		return column;
	}

	public static String strArrayToStr(String[] strs, String separator) {
		StringBuffer returnstr = new StringBuffer("");

		if (strs == null)
			return "";
		if (separator == null) {
			separator = "";
		}
		for (int i = 0; i < strs.length; i++) {
			returnstr.append(strs[i]);
			if (i < strs.length - 1)
				returnstr.append(separator);
		}
		return returnstr.toString();
	}

	public static String objectArrayToStr(Object[] objects, String separator) {
		StringBuffer returnstr = new StringBuffer("");

		if (objects == null)
			return "";
		if (separator == null) {
			separator = "";
		}
		for (int i = 0; i < objects.length; i++) {
			returnstr.append(String.valueOf(objects[i]));
			if (i < objects.length - 1)
				returnstr.append(separator);
		}
		return returnstr.toString();
	}

	public static String listToStr(List element, String separator) {
		StringBuffer returnstr = new StringBuffer("");

		if (element == null) {
			return "";
		}
		if (separator == null) {
			separator = "";
		}

		Iterator it = element.iterator();

		while (it.hasNext()) {
			returnstr.append(String.valueOf(it.next()));
			if (it.hasNext()) {
				returnstr.append(separator);
			}
		}

		return returnstr.toString();
	}

	public static String[] listToStrArray(List element) {
		if ((element == null) || (element.size() == 0)) {
			return null;
		}

		Iterator it = element.iterator();
		String[] strArray = new String[element.size()];
		int i = 0;

		while (it.hasNext()) {
			strArray[i] = String.valueOf(it.next());
			i++;
		}
		return strArray;
	}

	public static List strToList(String str, String separator) {
		if ((str == null) || (str.equals(""))) {
			return null;
		}
		if (separator == null) {
			separator = "";
		}

		String[] strArr = str.split(separator);
		int size = strArr.length;
		List list = new ArrayList();

		for (int i = 0; i < size; i++) {
			list.add(strArr[i]);
		}
		return list;
	}

	public static StringBuffer populate(StringBuffer bf, String value,
			boolean isNotLast) {
		if (value == null) {
			return bf;
		}

		bf.append("'").append(value.replaceAll("'", "''")).append("'");
		if (isNotLast)
			bf.append(",");
		return bf;
	}

	public static boolean isExist(String str, String substr, String sepatator) {
		if ((str == null) || (str.trim().equals(""))) {
			return false;
		}
		if ((substr == null) || (substr.trim().equals(""))) {
			return false;
		}
		String[] strArr = str.split(sepatator);
		int size = strArr.length;
		for (int i = 0; i < size; i++) {
			if (strArr[i].equals(substr))
				return true;
		}
		return false;
	}

	public static String beforeOfDeletion(String str, String include) {
		return deletion(str, include, true);
	}

	public static String afterOfDeletion(String str, String include) {
		return deletion(str, include, false);
	}

	public static String deletion(String str, String include, boolean place) {
		if ((str == null) || (str.trim().equals(""))) {
			return str;
		}
		if ((include == null) || (include.equals(""))) {
			return str;
		}
		if (place) {
			if (str.startsWith(include))
				return str.substring(1);
		} else if (str.endsWith(include)) {
			return str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static boolean isExist(String str, String substr) {
		return isExist(str, substr, ",");
	}

	public static String leftInclude(String str) {
		if ((str == null) || (str.equals(""))) {
			return str;
		}
		return str + "%";
	}

	public static String rightInclude(String str) {
		if ((str == null) || (str.equals(""))) {
			return str;
		}
		return "%" + str;
	}

	public static String include(String str) {
		if ((str == null) || (str.equals(""))) {
			return str;
		}
		return "%" + str + "%";
	}

	public static String intToFixLenString(long i, int len) {
		String istr = String.valueOf(i);
		if (istr.length() >= len) {
			return istr;
		}
		StringBuffer sb = new StringBuffer("");
		for (int j = 0; j < len - istr.length(); j++) {
			sb.append("0");
		}
		sb.append(istr);
		return sb.toString();
	}

	/**
	 * map数据对象转成字符串
	 * @param object
	 * @return String
	 */
	public static String getMapString(Object object){
		return object==null?"":object.toString();
	}
	/**
	 * Object对象数据转成 BigDecimal
	 * @param object
	 * @return BigDecimal
	 */
	public static BigDecimal getMapBigDecimal(Object object){
		return object==null?new BigDecimal(0):new BigDecimal(object.toString());
	}
	/**
	 * 格式化含中文名称的模糊查询字符串
	 * 如 “华腾”，格式化后“%华腾%”
	 * @param strName
	 * 		String-名称
	 * @return String
	 */
	public static String formatQueryLike(String strName){
		return isEmpty(strName)?"":"%"+strName.toString()+"%";
	}
	/**
	 * 格式化复选框的值
	 * 1.去掉[]
	 * 2.去掉双引号
	 * @param value
	 * @return
	 */
	public static String formatCheckBoxValue(String value){
		String resultStr="";
		if(isStrEmpty(value)){
			return value;
		}
		resultStr=value.replaceAll("\\[|\\]", "");//去掉[]
		resultStr=resultStr.replaceAll("\"", "");//去掉""
		return resultStr;
	}
	/**
	 * 构造复选框字符串格式02
	 * @param chValue
	 * 		String-原字符串
	 * @return
	 */
	public static String reCheckBoxValue(String chValue){
		String resultStr="";
		if(isStrEmpty(chValue)){
			return chValue;
		}
		String[] str=new String[0];
		int n=chValue.indexOf(",");
		if(n>-1){
			str=chValue.split(",");
			if(str.length>0){
				resultStr="[";
				for(int i=0;i<str.length;i++){
					if(i==str.length-1){
						resultStr=resultStr+"\""+str[i]+"\"]";
					}else{
						resultStr=resultStr+"\""+str[i]+"\",";
					}
				}
			}
		}else{
			resultStr="[\""+chValue+"\"]";
		}
		return resultStr;
	}
}
