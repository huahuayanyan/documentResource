package com.huateng.scf.bas.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * <p>
 * 日期工具类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月10日上午9:53:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月10日上午9:53:24	                                 新增
 *
 *            </pre>
 */
public class ScfDateUtil {
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";

	/**
	 * 返回指定位数的时间字符串,不足17位则返回17位, yyyyMMddHHmmssSSS, 其余位数通过随机数生成.
	 *
	 * @param date
	 * @param length
	 * @return
	 */
	public static final String getDateUniqueString(Date date, int length) {
		String formatString = "yyyyMMddHHmmssSSS";
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		String result = format.format(date);
		int ilen = length - formatString.length();
		if (ilen <= 0) {
			Random random = new Random();
			result += StringUtil.intToFixLenString(random.nextInt((int) Math.pow(10, ilen)), ilen);
		}
		return result;

	}

	/**
	 * 字符串转日期的工具类
	 * 
	 * @param dateString
	 *            日期字符串
	 * @param format
	 *            字符串格式
	 * @return
	 * @throws ParseException
	 */
	public static final Date toDate(String dateString, String format) throws ParseException {
		SimpleDateFormat dtFormat = new SimpleDateFormat(format);
		return dtFormat.parse(dateString);
	}

	/**
	 * @param length
	 * @return
	 */
	public static final String getDateUniqueString(int length) {
		return getDateUniqueString(new Date(), length);
	}

	/**
	 * 根据给定的日期返回下一个工作日的时间零点字符串(例如:yyyyMMdd 00:00:00 000 ),
	 * 目前的格式是DateToStringUserType中定义好的[yyyyMMdd HH:mm:ss]
	 *
	 * @param Date
	 * @return yyyyMMdd 00:00:00
	 */
	public static final Date getNextDayZeroTimeDate(Date adate) {
		final long MILLSECONDS_INADAY = 24 * 60 * 60 * 1000;
		final long MILLSECONDSDIFFWITHGMT = 8 * 60 * 60 * 1000;
		long days = (adate.getTime() + MILLSECONDSDIFFWITHGMT) / MILLSECONDS_INADAY;
		adate.setTime(days * MILLSECONDS_INADAY + MILLSECONDS_INADAY - MILLSECONDSDIFFWITHGMT);
		return adate;
	}

	/**
	 * 根据给定的日期返回下一个工作日的时间零点字符串(例如:yyyyMMdd 00:00:00 000 ),
	 * 目前的格式是DateToStringUserType中定义好的[yyyyMMdd HH:mm:ss]
	 *
	 * @param Date
	 * @return yyyyMMdd 00:00:00
	 */
	public static final Date getDayZeroTimeDateForToday() {
		Date adate = new Date();
		final long MILLSECONDS_INADAY = 24 * 60 * 60 * 1000;
		final long MILLSECONDSDIFFWITHGMT = 8 * 60 * 60 * 1000;
		long days = (adate.getTime() + MILLSECONDSDIFFWITHGMT) / MILLSECONDS_INADAY;
		adate.setTime(days * MILLSECONDS_INADAY - MILLSECONDSDIFFWITHGMT);
		return adate;
	}

	/**
	 * 返回指定格式的日期
	 *
	 * @param date
	 * @param length
	 * @return
	 */
	public static final String formatDate(Date date, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		return format.format(date);

	}

	/**
	 * 返回指定格式yyyyMMdd的日期
	 *
	 * @param date
	 * @param length
	 * @return
	 */
	public static final String formatDate(Date date) {
		return formatDate(date, "yyyyMMdd");

	}

	/**
	 * 根据日期生成字符串日期格式yyyyMMdd
	 * 
	 * @param date
	 *            Date对象
	 * @return 符串日期格式yyyyMMdd
	 */
	public static final String getStringDate(Date date) {
		return formatDate(date, DATE_FORMAT_YYYYMMDD);
	}

	/**
	 * 根据日期生成字符时间HHmmss
	 * 
	 * @param date
	 *            Date对象
	 * @return字符时间HH:mm:ss
	 */
	public static final String getStringTime(Date date) {
		return formatDate(date, DATE_FORMAT_HHMMSS);
	}

	/**
	 * 对日期进行计算,
	 * 
	 * @param date
	 * @param seconds
	 * @param fieldEnum
	 *            参照Calendar 中的枚举
	 * @return
	 */
	public static Date addDate(Date date, int seconds, int fieldEnum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(fieldEnum, seconds);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * 获取当前日期前一个月的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFormerMonthDate() {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.MONTH, -1); // 月份减1
		Date lastMonth = ca.getTime();
		return lastMonth;
	}

	/**
	 * 获取指定日期的Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar date2Calendar(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int diffdates(Date beginDate, Date endDate) {
		int days = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(beginDate);
		c2.setTime(endDate);

		while (c1.before(c2)) {
			days++;
			c1.add(Calendar.DAY_OF_YEAR, 1);
		}

		return days;
	}

	/**
	 * 获取当前日期之前指定的日期（以月为单位）
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPreviousMonthDate(int month) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.MONTH, -month); // 月份减month
		Date beforeMonth = ca.getTime();
		return beforeMonth;
	}

	/**
	 * 比较两个用yyMMdd格式字符串表示的日期，并未对其进行为空判断，调用时必须先对两个日期做非空判断
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int compareDateSequence(String startDate, String endDate) {
		java.util.Date start_Date = numberToDate(startDate);
		java.util.Date end_Date = numberToDate(endDate);
		int result = start_Date.compareTo(end_Date);
		return result;
	}

	/**
	 * 由yyyyMMdd格式的字符串返回日期
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date numberToDate(String dateString) {

		if ("".equals(dateString) || dateString == null) {
			return null;
		}
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("------SCFDataFormat>>StringTodate error=" + e);
		}
		return date;
	}

	/**
	 * 根据起始日期和终止日期计算期限
	 * 
	 * @param startDate
	 *            Date-起始日期
	 * @param endDate
	 *            Date-终止日期
	 * @return
	 */
	public static String getTenOr(Date startDate, Date endDate) {
		if (startDate.after(endDate)) {
			return null;
		} else {
			Calendar calS = Calendar.getInstance();
			calS.setTime(startDate);
			int startY = calS.get(Calendar.YEAR);
			int startM = calS.get(Calendar.MONTH);
			int startD = calS.get(Calendar.DATE);
			int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);
			calS.setTime(endDate);
			int endY = calS.get(Calendar.YEAR);
			int endM = calS.get(Calendar.MONTH);
			// 处理2011-01-10到2011-01-10，认为服务为一天
			// int endD = calS.get(Calendar.DATE) + 1;
			// 处理2011-01-10到2011-01-10，认为服务为0天
			int endD = calS.get(Calendar.DATE);
			int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);
			StringBuilder sBuilder = new StringBuilder();
			int lday = endD - startD;
			if (lday < 0) {
				endM = endM - 1;
				lday = startDayOfMonth + lday;
			}
			// 处理天数问题，如：2011-01-01 到 2013-12-31 2年11个月31天 实际上就是3年
			if (lday == endDayOfMonth) {
				endM = endM + 1;
				lday = 0;
			}
			int mos = (endY - startY) * 12 + (endM - startM);
			int lyear = mos / 12;
			int lmonth = mos % 12;
			if (lyear > 0) {
				if (lyear < 10) {
					sBuilder.append("0" + lyear);
				} else {
					sBuilder.append(lyear);
				}
			} else {
				sBuilder.append("00");
			}
			if (lmonth > 0) {
				if (lmonth < 10) {
					sBuilder.append("0" + lmonth);
				} else {
					sBuilder.append(lmonth);
				}
			} else {
				sBuilder.append("00");
			}
			if (lday > 0) {
				if (lday < 10) {
					sBuilder.append("0" + lday);
				} else {
					sBuilder.append(lday);
				}
			} else {
				sBuilder.append("00");
			}
			return sBuilder.toString();
		}
	}

	/**
	 * 
	 * 
	 * @param startDate
	 *            8位字符串日期
	 * @param days
	 *            要加天数
	 * @return 8位字符串日期
	 * @author lihao
	 * @date 2017年6月28日下午3:31:26
	 */
	public static String getEndDateByAddDays(String startDate, int days) {

		Calendar calendarStartDate = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
		try {
			Date startDate2 = simpleDateFormat.parse(startDate);
			calendarStartDate.setTime(startDate2);
			calendarStartDate.add(Calendar.DAY_OF_YEAR, days);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("------SCFDataFormat>>getEndDateByAddDays error=" + e);
		}
		return simpleDateFormat.format(calendarStartDate.getTime());
	}
}
