package com.huateng.scf.bas.fin.util;

import java.math.BigDecimal;

public class FormulaUtil {
	/**
	 * 校验是否为数字
	 * @param str
	 * @return
	 */
	public static boolean IsNumeric(String str)
	{
		boolean flag = true;
		String regex = "+-*/%><=";
		for(int i=0;i<str.length();i++)
		{
			if(regex.indexOf(str.charAt(i))>=0)
			{
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	/**
	 * 遍历字符串，酱数字与运算符分离，并计算结果
	 * @param suffix
	 * @return
	 */
	public static BigDecimal getResult(String suffix)
	{
		BigDecimal result = null;
		boolean isNum = IsNumeric(suffix);
		if(isNum)
		{
			double num = Double.valueOf(suffix);
			return BigDecimal.valueOf(num);
		}
		int count = 0;
		char chr = "(".charAt(0);
		for(int c=0;c<suffix.length();c++)
		{
			if(suffix.charAt(c)==chr)
			{
				count ++;
			}
		}
		//计算括号内算法结果
		for(int i=0;i<count;i++)
		{
			String strs = suffix.substring(suffix.indexOf("("), suffix.indexOf(")")+1);
			String uses = strs.substring(1, strs.length()-1);
			
			String num = getNumOrYsf(uses, 0);
			String ysf = getNumOrYsf(uses, 1);
			String[] numArr = num.split(",");
			Double first = Double.valueOf(numArr[0]);
			suffix = getSuffixString(numArr, ysf, first, suffix, strs, uses);
		}
		boolean isNumother = IsNumeric(suffix);
		if(isNumother)
		{
			double num = Double.valueOf(suffix);
			return BigDecimal.valueOf(num);
		}
		String lastNum = getNumOrYsf(suffix, 0);
		String lastYsf = getNumOrYsf(suffix, 1);
		String[] lastNumArr = lastNum.split(",");
		Double first = Double.valueOf(lastNumArr[0]);
		String lastsuffix = getSuffixString(lastNumArr, lastYsf, first, suffix, suffix, suffix);
		result = BigDecimal.valueOf(Double.valueOf(lastsuffix));
		return result;
	}
	/**
	 * 分离数字与运算符
	 * @param indexStr
	 * @return
	 */
	public static String[] getStrArr(String indexStr)
	{
		//存储数字,并以","分隔
		StringBuilder sbnum = new StringBuilder();
		StringBuilder sbysf = new StringBuilder();
		for(int j=0;j<indexStr.length();j++)
		{
			//如果是运算符
			if(indexStr.charAt(j)=="+".charAt(0)||indexStr.charAt(j)=="-".charAt(0)||indexStr.charAt(j)=="*".charAt(0)||indexStr.charAt(j)=="/".charAt(0)||indexStr.charAt(j)=="%".charAt(0))
			{
				sbysf.append(indexStr.charAt(j));
				sbnum.append(",");
			}
			//不是运算符，是数字或小数点
			else
			{
				sbnum.append(indexStr.charAt(j));
			}
		}
		//数字字符串
		String num = sbnum.toString();
		//运算符字符串
		String ysf = sbysf.toString();
		String[] strArr = {num,ysf};
		return strArr;
	}
	/**
	 * 获取数据或运算符字符串
	 * @param indexStr
	 * @param place
	 * @return
	 */
	public static String getNumOrYsf(String indexStr,int place)
	{
		String[] strArr = getStrArr(indexStr);
		return strArr[place];
	}
	/**
	 * 返回一般运算计算结果
	 * @param numArr
	 * @param ysf
	 * @param first
	 * @return
	 */
	public static Double getCalResult(String[] numArr,String ysf,Double first)
	{
		Double result = null;
		for(int n=1;n<numArr.length;n++)
		{
			Double index = Double.valueOf(numArr[n]);
			if(n==1)
			{
				if(ysf.charAt(n-1)=="+".charAt(0))
				{
					result = first + index;
				}
				if(ysf.charAt(n-1)=="-".charAt(0))
				{
					result = first - index;
				}
			}
			else
			{
				if(ysf.charAt(n-1)=="+".charAt(0))
				{
					result = result + index;
				}
				if(ysf.charAt(n-1)=="-".charAt(0))
				{
					result = result - index;
				}
			}
		}
		return result;
	}
	
	/**
	 * 公式计算，返回计算后的相关字符串
	 * @param numArr
	 * @param ysf
	 * @param suffix
	 * @param first
	 * @param strs
	 * @param uses
	 * @return
	 */
	public static String getSuffixString(String[] numArr,String ysf,Double first,String suffix,String strs,String uses)
	{
		//判断运算优先级
		StringBuilder sbyouxian = new StringBuilder();
		for(int m=0;m<ysf.length();m++)
		{
			if(ysf.charAt(m)=="*".charAt(0)||ysf.charAt(m)=="/".charAt(0)||ysf.charAt(m)=="%".charAt(0))
			{
				sbyouxian.append(m).append(",");
			}
		}
		//得到优先级运算符的位置
		String yxys = sbyouxian.toString();
		if(yxys.equals("")||yxys==null)
		{
			Double result1 = getCalResult(numArr, ysf, first);
			suffix = suffix.replace(strs, result1.toString());			
		}
		else
		{
			yxys = sbyouxian.toString().substring(0, sbyouxian.toString().lastIndexOf(","));
			String[] yxysArr = yxys.split(",");
			//存储乘除法结果
			Double resultindex = null ;
			for(int y=0;y<yxysArr.length;y++)
			{
				//用于存放待替换的字符串
				String strsdal = "";
				//运算符前一个数字
				Double numindex1 = null;
				//运算符后一个数字
				Double numindex2 = null;
				int place = Integer.valueOf(yxysArr[y]);
				numindex2 = Double.valueOf(numArr[place+1]);
				//取出的优先运算符是第一个，则如下算法
				if(y==0)
				{
					numindex1 = Double.valueOf(numArr[place]);
					strsdal = numArr[place]+ysf.charAt(place)+numArr[place+1];
				}
				else
				{
					int placeold = Integer.valueOf(yxysArr[y-1]);
					if(place==placeold+1)
					{
						numindex1 = resultindex;
						strsdal = resultindex.toString()+ysf.charAt(place)+numArr[place+1];
					}
				}
				if(ysf.charAt(place)=="*".charAt(0))
				{
					resultindex = numindex1 * numindex2;
				}
				if(ysf.charAt(place)=="/".charAt(0))
				{
					resultindex = numindex1 / numindex2;
				}
				if(ysf.charAt(place)=="%".charAt(0))
				{
					resultindex = numindex1 % numindex2;
				}
				suffix = suffix.replace(strsdal,resultindex.toString());
				strs = strs.replace(strsdal, resultindex.toString());
				uses = uses.replace(strsdal, resultindex.toString());
			}
			//优先级运算完成后，运算剩余数据及新数据公式
			String newnum = getNumOrYsf(uses, 0);
			String newysf = getNumOrYsf(uses, 1);
			String[] newnumArr = newnum.split(",");
			Double newfirst = Double.valueOf(newnumArr[0]);
			Double newresult1 = getCalResult(newnumArr, newysf, newfirst);
			suffix = suffix.replace(strs, newresult1.toString());	
		}
		return suffix;
	}
	/**
	 * 平衡公式计算返回true则平衡，返回false则失衡
	 * @param suffix
	 * @return
	 */
	public static boolean getBalanceResult(String suffix)
	{
		boolean flag = false;
		String left = "";
		String right = "";
		BigDecimal num1 = null;
		BigDecimal num2 = null;
		String[] strArr = null;
		if(suffix.indexOf(">=")>=0)
		{
			strArr = suffix.split(">=");
			left = strArr[0];
			right = strArr[1];
			num1 = getResult(left);
			num2 = getResult(right);
			if(num1.doubleValue()>=num2.doubleValue())
				flag = true;
			else
				flag = false;
		}
		if(suffix.indexOf("<=")>=0)
		{
			strArr = suffix.split("<=");
			left = strArr[0];
			right = strArr[1];
			num1 = getResult(left);
			num2 = getResult(right);
			if(num1.doubleValue()<=num2.doubleValue())
				flag = true;
			else
				flag = false;
		}
		if(suffix.indexOf(">")>=0)
		{
			strArr = suffix.split(">");
			left = strArr[0];
			right = strArr[1];
			num1 = getResult(left);
			num2 = getResult(right);
			if(num1.doubleValue()>num2.doubleValue())
				flag = true;
			else
				flag = false;
		}
		if(suffix.indexOf("<")>=0)
		{
			strArr = suffix.split("<");
			left = strArr[0];
			right = strArr[1];
			num1 = getResult(left);
			num2 = getResult(right);
			if(num1.doubleValue()<num2.doubleValue())
				flag = true;
			else
				flag = false;
		}
		if(suffix.indexOf("=")>=0)
		{
			strArr = suffix.split("=");
			left = strArr[0];
			right = strArr[1];
			num1 = getResult(left);
			num2 = getResult(right);
			if(num1.doubleValue()==num2.doubleValue())
				flag = true;
			else
				flag = false;
		}
		return flag;
	}
	
}
