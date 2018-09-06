package com.huateng.scf.bas.batch.common;

/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精
 *    确的浮点数运算，包括加减乘除</p>
 * <p>Created time: 2004-11-18 15:13:01</p>
 * <p>Company:上海华腾软件系统有限公司</p>
 * <p>@author George.Liu</p>
 */

import java.math.BigDecimal;

/**
 *  在这里添加类的文档注释
 *
 * <p>
 * <a href="Arith.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:hthui@wonders.com">hthui</a>
 *
 * @version Revision: 1.0  Date: 2011-5-11 上午09:50:44
 *
 */
/**
 *  在这里添加类的文档注释
 *
 * <p>
 * <a href="Arith.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:hthui@wonders.com">hthui</a>
 *
 * @version Revision: 1.0  Date: 2011-5-11 上午09:50:46
 *
 */
/**
 *  在这里添加类的文档注释
 *
 * <p>
 * <a href="Arith.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:hthui@wonders.com">hthui</a>
 *
 * @version Revision: 1.0  Date: 2011-5-11 上午09:50:47
 *
 */
/**
 *  在这里添加类的文档注释
 *
 * <p>
 * <a href="Arith.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:hthui@wonders.com">hthui</a>
 *
 * @version Revision: 1.0  Date: 2011-5-11 上午09:50:48
 *
 */
public class Arith {

	//默认除法运算精度
	private static final int DEF_DIV_SCALE = 32;

	//这个类不能实例化
	private Arith() {

	}

	/**
	 *
	 * 提供精确的加法运算。
	 *
	 * @param v1
	 *            被加数
	 *
	 * @param v2
	 *            加数
	 *
	 * @return 两个参数的和
	 *
	 */

	public static double add(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.add(b2).doubleValue();

	}

	/**
	 *
	 * 提供精确的减法运算。
	 *
	 * @param v1
	 *            被减数
	 *
	 * @param v2
	 *            减数
	 *
	 * @return 两个参数的差
	 *
	 */

	public static double subtract(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.subtract(b2).doubleValue();

	}

	/**
	 *
	 * 提供精确的乘法运算。
	 *
	 * @param v1
	 *            被乘数
	 *
	 * @param v2
	 *            乘数
	 *
	 * @return 两个参数的积
	 *
	 */

	public static double multiply(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	/**
	 *
	 * 提供精确的乘法运算。
	 *
	 * @param v1
	 *            被乘数
	 *
	 * @param v2
	 *            乘数
	 *
	 * @param v3
	 *            乘数
	 *
	 * @return 两个参数的积
	 *
	 */

	public static double multiply(double v1, double v2, double v3) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		BigDecimal b3 = new BigDecimal(Double.toString(v3));

		return b1.multiply(b2).multiply(b3).doubleValue();
	}

	/**
	 *
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，被截去部位直接舍去,不四舍五入
	 *
	 * @param v1
	 *            被除数
	 *
	 * @param v2
	 *            除数
	 *
	 * @return 两个参数的商
	 *
	 */

	public static double divide(double v1, double v2) {

		return divide(v1, v2, DEF_DIV_SCALE);

	}

	/**
	 *
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度,
	 * 被截去部位直接舍去,不四舍五入
	 *
	 * @param v1
	 *            被除数
	 *
	 * @param v2
	 *            除数
	 *
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 *
	 * @return 两个参数的商
	 *
	 */

	public static double divide(double v1, double v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_DOWN).doubleValue();

	}

	/**
	 *
	 * 提供（相对）精确的幂运算。
	 *
	 * @param v1
	 *            底数
	 *
	 * @param v2
	 *            幂数
	 *
	 * @return 幂的结果
	 *
	 */

	public static double power(double v1, int v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal bdResult = new BigDecimal(Double.toString(1)); // 幂结果

		for (int i = 0; i < v2; i++) {
			bdResult = bdResult.multiply(b1);
		}
		return bdResult.doubleValue();

	}

	/**
	 *
	 * 截取小数点后位数,被截去部位直接舍去,不四舍五入
	 *
	 * @param v
	 *            被截去的小数
	 *
	 * @param scale
	 *            小数点后保留位数
	 *
	 * @return 被截去后的结果
	 *
	 */

	public static double setScale(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		return b.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();

	}

	/**
	 *
	 * 截取小数点后位数,被截去部位四舍五入
	 *
	 * @param v
	 *            被截去的小数
	 *
	 * @param scale
	 *            小数点后保留位数
	 *
	 * @return 被截去后的结果
	 *
	 */

	public static double floor(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}
	/**
	 *
	 * 截取小数点后位数,被截去部位四舍五入(float类型)
	 *
	 * @param v
	 *            被截去的小数
	 *
	 * @param scale
	 *            小数点后保留位数
	 *
	 * @return 被截去后的结果
	 *
	 */
	public static float floor2Float(float v, int scale) {

			if (scale < 0) {

				throw new IllegalArgumentException("The scale must be a positive integer or zero");
			}

			BigDecimal b = new BigDecimal(Float.toString(v));

			return b.setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();

		}

	/**
	 *
	 * 提供精确的乘法运算。
	 *
	 * @param v1
	 *            被乘数
	 *
	 * @param v2
	 *            乘数
	 *
	 * @return 两个参数的积
	 *
	 */

	public static float multiply(float v1, float v2) {

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		BigDecimal b2 = new BigDecimal(Float.toString(v2));

		return b1.multiply(b2).floatValue();

	}


	/**
	 *
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度,
	 * 被截去部位直接舍去,不四舍五入
	 *
	 * @param v1
	 *            被除数
	 *
	 * @param v2
	 *            除数
	 *
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 *
	 * @return 两个参数的商
	 *
	 */

	public static double divideRoundHarfUp(double v1, double v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}
}