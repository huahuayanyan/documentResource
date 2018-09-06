package com.huateng.scf.bas.batch.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtil {

	private Connection conn = null;
	public static final int YEAR_BEGIN=1;
	public static final int JD_BEGIN=2;
	public static final int MONTH_BEGIN=3;
	public static final int DAY=-1;
	
	public DBUtil(Connection conn) {
		this.conn = conn;
	}

	public static int Delete(String delsql, Connection conn) throws Exception {
		Statement stmt = null;
		int i = 0;
		try {
			if (stmt == null)
				stmt = conn.createStatement();
			i = stmt.executeUpdate(delsql);
			//System.out.println("删除" + i + "条记录");
			conn.commit();
		} catch (Exception e) {
			i=-1;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			if (stmt != null)
				stmt.close();
		}
		return i;

	}
	
	public static int update(String delsql, Connection conn) throws Exception {
		Statement stmt = null;
		int i = 0;
		try {
			if (stmt == null)
				stmt = conn.createStatement();
			i = stmt.executeUpdate(delsql);
			//System.out.println("更新" + i + "条记录");
			conn.commit();
		} catch (Exception e) {
			i=-1;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			if (stmt != null)
				stmt.close();
		}
		return i;
	}
	
	/**
	 * yyyyMMdd 判断日期类型，
	 * 年初1,季度初2,月初3,其它-1
	 * @param serverdate yyyyMMdd 日期
	 * @return　日期类型 int
	 * @throws Exception
	 */
	public static int checkServerdate(String serverdate,String lastserverdate) throws Exception
	{
		if(serverdate==null||serverdate.length()!=8)
			throw new Exception("取系统报表时间出错");	
		if(lastserverdate==null||serverdate.length()!=8)
			lastserverdate=serverdate;		
		int month=Integer.parseInt(serverdate.substring(4,6));		
		int lastmonth=Integer.parseInt(lastserverdate.substring(4,6));	
		
		if(month==1&&month!=lastmonth)//年初 处理 
			return YEAR_BEGIN; //1
		else if((month-1)%3==0&&month!=lastmonth)//季度初 4月初，7月初，10月初，
		{
			return JD_BEGIN; //2
		}
		else if(month!=lastmonth)//月初　　1日
		{
			return MONTH_BEGIN;  //3
		}else //其它日期
			return DAY; //-1
	}
	
	/**
	 * 取得当前批量日的月份。
	 * @param reportdate  批量日期。
	 * @return
	 */
	public static int getReportMonth(String reportdate)
	{
		if(reportdate==null||reportdate.trim().length()!=8)
			return -1;
		int month=-1;
		try{
			month= Integer.parseInt(reportdate.substring(4,6));	
		}catch(Exception e)
		{
			month=-1;
		}
		return month;
	}
	
	/**
	 * 取得当前批量日的年份
	 * @param reportdate 批量日期。
	 * @return
	 */
	public static int getReportYear(String reportdate)
	{
		if(reportdate==null||reportdate.trim().length()!=8)
			return -1;
		int year=-1;
		try{
			year= Integer.parseInt(reportdate.substring(0,4));	
		}catch(Exception e)
		{
			year=-1;
		}
		return year;
	}
	
	/**
	 * 取得当前日期，并把日清零。reportdate.substring(0,6)+"00";
	 * @param reportdate
	 * @return
	 */
	public static String getReportStringMonth(String reportdate)
	{
		if(reportdate==null||reportdate.trim().length()!=8)
			return null;	
		return reportdate.substring(0,6)+"00";
	}
	
	/**
	 * yyyyMMddHHmmss
	 * @return
	 */
	public static String getServerTime()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(date);
		
	}
	

}
