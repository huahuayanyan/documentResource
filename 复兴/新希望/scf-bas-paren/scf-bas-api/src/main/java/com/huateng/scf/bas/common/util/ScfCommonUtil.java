/**
 * 
 */
package com.huateng.scf.bas.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.scf.bas.common.model.ScfBaseModel;
import com.huateng.scube.exception.ScubeBizException;

/**
 * <p>供应链公共处理</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月10日下午8:32:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月10日下午8:32:01	                                 新增
 *
 * </pre>
 */
public class ScfCommonUtil {
	
	
	/**
	 * 公共字段设置
	 * @param scfBaseModel
	 * 		ScfBaseModel-继承自ScfBaseModel对象
	 * @return ScfBaseModel对象
	 */
	
	/** 大写数字 */
	  private static final String[] NUMBERS = { "零", "壹", "贰", "叁", "肆", "伍", "陆",
	      "柒", "捌", "玖" };
	  /** 整数部分的单位 */
	  private static final String[] IUNIT = { "元", "拾", "佰", "仟", "万", "拾", "佰",
	      "仟", "亿", "拾", "佰", "仟", "万", "兆", "拾", "佰", "仟" };
	  /** 小数部分的单位 */
	  private static final String[] DUNIT = { "角", "分", "厘" };

	  /**
	   * 得到大写金额。
	   */
	public static ScfBaseModel setCommonField(ScfBaseModel scfBaseModel){
		 // 获取当前用户 
	     UserInfo user = ContextHolder.getUserInfo(); 
	     String userId= user.getTlrNo();
	     scfBaseModel.setTlrcd(userId);// 创建人
	     scfBaseModel.setLastUpdTlrcd(userId);//最后更新人
	     scfBaseModel.setCrtTime(new Date());
	     scfBaseModel.setLastUpdTime(new Date());
	     //获取机构信息
	     BctlVO BctlVO = ContextHolder.getOrgInfo();
	     String brcode = BctlVO.getBrNo();
	     scfBaseModel.setLastUpdBrcode(brcode);
		 return scfBaseModel;
	}
	/**
	 * 获取总行机构号
	 * @param scubeUserService
	 * 		ScubeUserService对象
	 * @return 总行机构号brNo
	 */
	public static String getBrManagerNo(ScubeUserService scubeUserService){
		String brManagerNo=null;
		BctlVO bctlVO = ContextHolder.getOrgInfo();
		if(null!=bctlVO){
			BctlVO bctlVOM=scubeUserService.selectBctlById(bctlVO.getBrManagerId());
			if(null!=bctlVOM){
				brManagerNo=bctlVOM.getBrNo();
			}
		}
		return brManagerNo;
	}
	
	 /**
	   * 得到大写金额。
	   */
	  public static String currencyToChineseCurrency(String str) {
	    str = str.replaceAll(",", "");// 去掉","
	    String integerStr;// 整数部分数字
	    String decimalStr;// 小数部分数字

	    // 初始化：分离整数部分和小数部分
	    if (str.indexOf(".") > 0) {
	      integerStr = str.substring(0, str.indexOf("."));
	      decimalStr = str.substring(str.indexOf(".") + 1);
	    } else if (str.indexOf(".") == 0) {
	      integerStr = "";
	      decimalStr = str.substring(1);
	    } else {
	      integerStr = str;
	      decimalStr = "";
	    }
	    // integerStr去掉首0，不必去掉decimalStr的尾0(超出部分舍去)
	    if (!integerStr.equals("")) {
	      integerStr = Long.toString(Long.parseLong(integerStr));
	      if (integerStr.equals("0")) {
	        integerStr = "";
	      }
	    }
	    // overflow超出处理能力，直接返回
	    if (integerStr.length() > IUNIT.length) {
	      System.out.println(str + ":超出处理能力");
	      return str;
	    }

	    int[] integers = toArray(integerStr);// 整数部分数字
	    boolean isMust5 = isMust5(integerStr);// 设置万单位
	    int[] decimals = toArray(decimalStr);// 小数部分数字
	    return getChineseInteger(integers, isMust5) + getChineseDecimal(decimals);
	  }
	  /**
	   * 整数部分和小数部分转换为数组，从高位至低位
	   */
	  private static int[] toArray(String number) {
	    int[] array = new int[number.length()];
	    for (int i = 0; i < number.length(); i++) {
	      array[i] = Integer.parseInt(number.substring(i, i + 1));
	    }
	    return array;
	  }

	  /**
	   * 判断第5位数字的单位"万"是否应加。
	   */
	  private static boolean isMust5(String integerStr) {
	    int length = integerStr.length();
	    if (length > 4) {
	      String subInteger = "";
	      if (length > 8) {
	        // 取得从低位数，第5到第8位的字串
	        subInteger = integerStr.substring(length - 8, length - 4);
	      } else {
	        subInteger = integerStr.substring(0, length - 4);
	      }
	      return Integer.parseInt(subInteger) > 0;
	    } else {
	      return false;
	    }
	  }

	  /**
	   * 得到中文金额的整数部分。
	   */
	  private static String getChineseInteger(int[] integers, boolean isMust5) {
	    StringBuffer chineseInteger = new StringBuffer("");
	    int length = integers.length;
	    for (int i = 0; i < length; i++) {
	      // 0出现在关键位置：1234(万)5678(亿)9012(万)3456(元)
	      // 特殊情况：10(拾元、壹拾元、壹拾万元、拾万元)
	      String key = "";
	      if (integers[i] == 0) {
	        if ((length - i) == 13)// 万(亿)(必填)
	          key = IUNIT[4];
	        else if ((length - i) == 9)// 亿(必填)
	          key = IUNIT[8];
	        else if ((length - i) == 5 && isMust5)// 万(不必填)
	          key = IUNIT[4];
	        else if ((length - i) == 1)// 元(必填)
	          key = IUNIT[0];
	        // 0遇非0时补零，不包含最后一位
	        if ((length - i) > 1 && integers[i + 1] != 0)
	          key += NUMBERS[0];
	      }
	      chineseInteger.append(integers[i] == 0 ? key
	          : (NUMBERS[integers[i]] + IUNIT[length - i - 1]));
	    }
	    return chineseInteger.toString();
	  }

	  /**
	   * 得到中文金额的小数部分。
	   */
	  private static String getChineseDecimal(int[] decimals) {
	    StringBuffer chineseDecimal = new StringBuffer("");
	    for (int i = 0; i < decimals.length; i++) {
	      // 舍去3位小数之后的
	      if (i == 3)
	        break;
	      chineseDecimal.append(decimals[i] == 0 ? ""
	          : (NUMBERS[decimals[i]] + DUNIT[i]));
	    }
	    return chineseDecimal.toString();
	  }

  	 /**
	  * yyyyMMdd 转成 yyyy-mm-dd 
	  */
	 public static String dateForm(String date){
	 	if(StringUtil.isStrEmpty(date)|| date.length() != 8){
	 		throw new ScubeBizException("参数date必须是8位:"+date);
	 	}
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" +date.substring(6, 8);
	 }
	 /**
	 * <pre>
	 * 功能: 格式化金额为千分位显示
	 * @param BigDecimal
	 * @return String
	 * </pre>
	 */
	public static String amountFormatToString(BigDecimal value) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(value);
	}
}
