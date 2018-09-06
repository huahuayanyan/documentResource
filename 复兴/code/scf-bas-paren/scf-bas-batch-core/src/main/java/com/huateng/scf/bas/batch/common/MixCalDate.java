/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Farly.yu
 * @desc: 计算两日期之间相差的年、月与实际天数
 * @date: 2007-03-12
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MixCalDate {
	private int intStartDate;
	private int intEndDate;
	 
	private int cyear=0;
	private int cmonth=0;
	private int cday=0;
	
	private final String DATE_NUMBER_PATTERN = "yyyyMMdd";
	
	
	public MixCalDate() {
	}
	
	/**
	 * 
	 * @param int startDate 20060101
	 * @param int endDate   20070201
	 */
	public MixCalDate(int startDate,int endDate) throws Exception {
		intStartDate = startDate;
		intEndDate = endDate;
		init();
	} 
	
	/**
	 * 
	 * @param Date startDate 
	 * @param Date endDate
	 */
	public MixCalDate(Date startDate, Date endDate) throws Exception {

		SimpleDateFormat simpleDateFormat =	new SimpleDateFormat(DATE_NUMBER_PATTERN);
		intStartDate = Integer.parseInt(simpleDateFormat.format(startDate));
		intEndDate = Integer.parseInt(simpleDateFormat.format(endDate));
		
		init();
	}

	/**
	 * 
	 * @param startDate "2006-01-01"
	 * @param endDate   "2007-02-01"
	 * @throws Exception
	 */
	public MixCalDate(String startDate, String endDate) throws Exception{

		intStartDate =
			Integer.parseInt(
				startDate.substring(0, 4).concat(
				startDate.substring(5, 7)).concat(
				startDate.substring(8, 10)));
		intEndDate =
			Integer.parseInt(
				endDate.substring(0, 4).concat(
				endDate.substring(5, 7)).concat(
				endDate.substring(8, 10)));
		init();
	}
	
	/**
	 * 交换大小日期值及计算年月日
	 *
	 */
	private void init() throws Exception {
		if (intStartDate > intEndDate) {
			int swapDate = intStartDate;
			intStartDate = intEndDate;
			intEndDate = swapDate;
		}
		
		if (!verifyDate(intStartDate)) {
			throw new Exception ("起期有误: 起期[" + Integer.toString(intStartDate) + "]");
		}
		if (!verifyDate(intEndDate)) {
			throw new Exception ("止期有误: 止期[" + Integer.toString(intEndDate) + "]");
		}

		calculateday();
	}
	
	
	/**
	 * 检查日期是否合法
	 * @param int date 20060101
	 * @return
	 */
	private boolean verifyDate(int date) {
		if (date <= 1000*10000) {
			return false;
		}
		
		int y = date / 10000;
		int m = date / 100 - y *100;
		int d = date - y * 10000 - m * 100;
		
		if (y < 1000) return false;
		if (m > 12 || m < 1 ) return false;
		if (d >31 || d < 1 ) return false;
		
		switch (m) {
			case 2:
				if (checkyeartype(y)) {
					if (d>29) return false;
				} else {
					if (d>28) return false;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (d>30) return false;
				break;
		}
		return true;
	}

	/**
	 * 判断是否为闰年
	 * @param year
	 * @return
	 */
	private boolean checkyeartype(int year){
		boolean yeartype = false;
		if((year % 4 == 0)&&(year % 100 != 0)){
			yeartype = true;
		}
		if(year % 400 == 0){
			yeartype = true;
		}
		return yeartype;
	}
	
	
	/**
	 * 判断日期是否为月末
	 * @param date
	 * @return boolean
	 */
	private boolean checkmonthend(int date){
		int year = date / 10000;
		int month = date / 100 - year * 100;
		int day = date - year * 10000 - month * 100;
		boolean yeartype = checkyeartype(year);
		switch(month)
		{
			case 1:
				if(day == 31) return true;
				break;
			case 2:
				if(yeartype){
					if(day == 29) return true;
				}
				else{
					if(day == 28) return true;	
				}
				break;
			case 3:
				if(day == 31) return true;
				break;
			case 4:
				if(day == 30) return true;
				break;
			case 5:
				if(day == 31) return true;
				break;
			case 6:
				if(day == 30) return true;
				break;
			case 7:
				if(day == 31) return true;
				break;
			case 8:
				if(day == 31) return true;	
				break;
			case 9:	
				if(day == 30) return true;
				break;
			case 10:
				if(day == 31) return true;
				break;
			case 11:
				if(day == 30) return true;
				break;
			case 12:
				if(day == 31) return true;
				break;
		}
		return false;		
	}
	
	
	/**
	 * 获得日期当前月的最大天数
	 * @param date
	 * @return
	 */
	private int getmonthmaxday(int date){
		int year = date / 10000;
		int month = date / 100 - year * 100;
		boolean yeartype = checkyeartype(year);	
		int days = 0;
		switch(month)
		{
			case 1:
				days = 31; break;
			case 2:
				if(yeartype){
					days = 29;
				}
				else{
					days = 28;
				}
				break;
			case 3:
				days = 31; break;
			case 4:
				days = 30; break;
			case 5:
				days = 31; break;
			case 6:
				days = 30; break;
			case 7:
				days = 31; break;
			case 8:
				days = 31; break;
			case 9:	
				days = 30; break;
			case 10:
				days = 31; break;
			case 11:
				days = 30; break;
			case 12:
				days = 31; break;
		}
		return days;
	}
	
	/**
	 * 计算两日期相差的年、月与天数
	 *
	 */
	private void calculateday(){
		int begyear = intStartDate / 10000;
		int begmonth = intStartDate / 100 - begyear * 100;
		int begday = intStartDate - begyear * 10000 - begmonth * 100;
		
		int endyear = intEndDate / 10000;
		int endmonth = intEndDate / 100 - endyear * 100;
		int endday = intEndDate - endyear * 10000 - endmonth * 100;
		
		boolean begmonthendflg = checkmonthend(intStartDate);
		boolean endmonthendflg = checkmonthend(intEndDate);
		
		cyear = endyear - begyear;
		
		if (endmonth < begmonth) {
			endmonth += 12;
			cyear--;
		}
		cmonth = endmonth - begmonth;
		
		//假如两日期日相等或都为月末或 起期日大于止期日并且止期日是月末，则天数为0
		if((begday == endday)||(begmonthendflg&&endmonthendflg)
			||(begday >= endday && endmonthendflg)){
			cday = 0;
			return;
		}
		
		//假如起期日为月末，止期日不为月末时
		if(begmonthendflg && !endmonthendflg){
			if (cmonth <= 0) {
				cyear--;
				cmonth += 12;
			}
			cmonth -= 1;
			cday = endday;
			return;
		}
		
		//假如起期日小于止期日，则计算实际天数
		if(begday < endday){
			cday = endday - begday;
			return;
		}
		
		
		if(begday > endday){
			if (cmonth <= 0) {
				cyear--;
				cmonth += 12;
			}
			cmonth -= 1;
			int temp = getmonthmaxday(intStartDate);
			
			if (temp < begday) {
				cday = endday;
			} else {
				cday = temp - begday + endday;
			}
			/* 结果同上一样
			cday = temp - begday;
			if(cday < 0)
				cday = 0;
			cday += endday;
			*/
			return;
		} 
		return;
	}


	/**
	 * 获得两日期相差年数
	 * @return int cyear
	 */
	public int getSubYear() {
		return cyear;
	}
	
	/**
	 * 获得两日期相差月份数
	 * @return int cmonth
	 */
	public int getSubMonth() {
		return cmonth;
	}
	
	/**
	 * 获得两日期除了整年整月后相差的实际天数，该天数计算与现实实际计算天数有区别
	 * @return int cday
	 */
	public int getSubDay() {
		return cday;
	}
	/*
	public static void main(String[] args) throws Exception {
		MixCalDate mxd = new MixCalDate(20080130,20080327);
		mxd.calculateday();
		System.out.println(mxd.cyear);
		System.out.println(mxd.cmonth);
		System.out.println(mxd.cday);
	}
	*/
}
