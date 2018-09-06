/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.scf.bas.batch.common.log.LoggerConstants;
import com.huateng.scf.bas.batch.data.DataWriter;
import com.huateng.scf.bas.batch.report.ReportCreator;
import com.huateng.scf.bas.batch.security.CryptionData;
import com.huateng.scf.bas.batch.seq.BatchUtils;
import com.huateng.scf.bas.batch.seq.InsertHelper;
import com.huateng.scf.bas.batch.vo.BSysGlobalInfo;
import com.huateng.scf.bas.batch.vo.ThreadVO;

/**
 * <p>
 * Title: 交通银行个人贷款管理系统
 * </p>
 * <p>
 * Description: 批量程序的相关公用方法
 * </p>
 *
 * @author George.Liu
 * @version: 2004-12-20 15:09:57
 */

public class BatchUtil {

	/**
	 * 定义授信额度的状态。
	 */
	public static final int CREDIT_STATUS_INPUT = 1; // 已录入

	public static final int CREDIT_STATUS_UPLOADED = 2; // 已上传

	public static final int CREDIT_STATUS_AUDITED = 3; // 已审查

	public static final int CREDIT_STATUS_APPROVED = 4; // 已审批

	public static final int CREDIT_STATUS_LASTAPPROVED = 5; // 已终审（已启用）

	public static final int CREDIT_STATUS_REJECTED = 6; // 已拒绝

	public static final int CREDIT_STATUS_RETURNED = 7; // 已退回

	public static final int CREDIT_STATUS_APPLIED_DECREASE = 8; // 已申请缩减

	public static final int CREDIT_STATUS_APPLIED_REVOKE = 9; // 已申请收回

	public static final int CREDIT_STATUS_REVOKED = 10; // 已收回

	public static final int CREDIT_STATUS_APPLIED_FREEZE = 11; // 已申请冻结

	public static final int CREDIT_STATUS_FREEZED = 12; // 已冻结

	public static final int CREDIT_STATUS_APPLIED_UNFREEZE = 13; // 已申请解冻

	public static final int CREDIT_STATUS_OVERDUE_FREEZED = 14; // 已逾期冻结

	public static final int CREDIT_STATUS_EXPIRED = 15; // 已到期失效

	public static final int FILE_TYPE_RPT = 0; // 文件类型为0-报表
	public static final int FILE_TYPE_NET = 1; // 文件类型为1-网银
	public static final int FILE_TYPE_CORE = 2; // 文件类型为2-核心
	public static final int FILE_TYPE_ARMS = 3; // 文件类型为3-风管
	public static final int FILE_TYPE_CMSF = 4; // 文件类型为4-信贷

	public static final int DIRECTION_UPLOAD = 0;// 0-上传
	public static final int DIRECTION_DOWNLOAD = 1;// 1-下载

	/*
	 * 个人征信文件路径
	 */
	private static final String MONEY_PATTERN = "##########";

	private static Hashtable bctlHashlist = null; // 供sortByBrseq方法使用的静态对象

	/**
	 * 用于数据库连接
	 */
	private static String DBdriver = null;

	private static String DBurl = null;

	private static String DBuser = null;

	private static String DBpassword = null;

	private static final String lineSeparator = System
			.getProperty("line.separator");

	/**
	 * @Title: 取分行批量操作员
	 * @Description: 取分行批量操作员
	 * @param brcode
	 *            分行号
	 * @return String 操作员号
	 * @author Ranger.Mao
	 * @Created time: Jan 20, 2005 3:07:49 PM
	 */
	public static String getTlrno(String brcode) {
		return brcode.substring(0, 3) + "B999";
	}

	// /**
	// * 得到数据库连接
	// * @return Connection 数据库连接
	// * @throws ClassNotFoundException
	// * @throws SQLException
	// */
	// public static Connection getConnection2()
	// throws ClassNotFoundException, SQLException {
	// Connection conn = null;
	// try {
	// Class.forName("com.ibm.db2.jcc.DB2Driver");
	// } catch (ClassNotFoundException e) {
	// throw e;
	// }
	//
	// try {
	// conn =
	// DriverManager.getConnection(
	// "jdbc:db2://182.247.70.98:60016/bocomsit",
	// "plis",
	// "plis123");
	// // conn =
	// // DriverManager.getConnection(
	// // "jdbc:db2://182.247.70.93:60000/bocommig",
	// // "migrate",
	// // "mig123");
	//
	// // 182.247.70.98:60016/bocomsit
	//
	// // 182.247.70.93:60000/bocomtst
	//
	// } catch (SQLException e1) {
	// throw e1;
	// }
	// return conn;
	//
	// }

	/**
	 * 得到数据库连接 请配置batch.property modify by weikun wang 2008.7.22
	 *
	 * @return Connection 数据库连接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	/** add by shen_antonio 20100605 JRIA: BMS-2771 begin .*/
	public static Connection getBatchConnection() throws Exception {
		Connection conn = null;
		if (ApplicationContextUtils.get_context() == null) {
			BatchUtil.initBatchConfig();
		}
		if (BatchUtil.DBdriver == null) {
			BatchUtil.DBdriver = BatchUtil.getBatchProperty(
					BatchConstant.BATCH_PROPERTY_DB_DRIVER, "");
			BatchUtil.DBurl = BatchUtil.getBatchProperty(
					BatchConstant.BATCH_PROPERTY_DB_URL, "");
			BatchUtil.DBuser = BatchUtil.getBatchProperty(
					BatchConstant.BATCH_PROPERTY_DB_USER, "");
			BatchUtil.DBpassword = BatchUtil.getBatchProperty(
					BatchConstant.BATCH_PROPERTY_DB_PASSWORD, "");
			CryptionData cryptionData = new CryptionData(
					SystemConstant.DEFAULT_PASSWORD_KEY);
			BatchUtil.DBpassword = cryptionData
					.DecryptionStringData(BatchUtil.DBpassword);
		}

		try {
			Class.forName(BatchUtil.DBdriver);
		} catch (ClassNotFoundException e) {
			throw e;
		}

		try {

			conn = DriverManager.getConnection(BatchUtil.DBurl,
					BatchUtil.DBuser, BatchUtil.DBpassword);
		} catch (SQLException e1) {
			throw e1;
		}
		return conn;

	}
	public static Connection getConnection() throws Exception {
		String connType = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE, "1");

		if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_1, connType) ||
				StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_2, connType)){//数据库连接模式为：批量联机池模式和批量联机非联机池模式
			return getBatchConnection();
		}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_3, connType)){//数据库连接模式为：联机连接池模式
			String applicationServerContextClass = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_Application_Server_Context_Class, "");
			String applicationServerDataSourceBeanName = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_Application_Server_DataSource_BeanName, "");
			if(StringUtils.isEmpty(applicationServerContextClass) || StringUtils.isEmpty(applicationServerDataSourceBeanName)){
				throw new Exception("DataBase_Application_Server_Context_Class or DataBase_Application_Server_DataSource_BeanName is empty in batch.properties,please confirm DataBase_CONN_TYPE in batch.properties");
			}else{
				try {
					Class applicationContextClass = Class.forName(applicationServerContextClass);
					if(applicationContextClass == null){
						throw new Exception("DataBase_Application_Server_Context_Class[" + applicationServerContextClass + "], class no found");
					}
					Object obj = applicationContextClass.getMethod("getBean", String.class).invoke(applicationContextClass, applicationServerDataSourceBeanName);
					if( obj == null || !(obj instanceof DataSource)){
						throw new Exception("get datasource of application server fail");
					}else{
						return ((DataSource)obj).getConnection();
					}

				} catch (Exception e) {
					throw e;
				}
			}
		}
		else{
			throw new Exception("DataBase_CONN_TYPE is " + connType + ",but it should be 1 , 2 or 3 in batch.properties,please confirm DataBase_CONN_TYPE in DataBase_CONN_TYPE");
		}

	}
	/** add by shen_antonio 20100605 JRIA: BMS-2771 end .*/


	/**
	 * 修改原文件名， 主机现在文件名规则为 例：ORGXXXXX_20070101.dat, 其中“_20070101”部分 按批量日改变
	 *
	 * @param oleFileName
	 *            指原“DATA01.ORGXXXXX.UDF999” 或新 “ORGXXXXX” 从配置文件获取
	 * @return
	 */
	public static String getNewFileName(String oldFileName, Date bhDate)
			throws Exception {
		Pattern ptn = Pattern.compile(BatchConstant.SOURCE_FILE_PATTERN);
		if (ptn.matcher(oldFileName).matches()) {
			String repStingPatern = oldFileName.substring(oldFileName
					.indexOf('{') + 1, oldFileName.indexOf('}'));
			return oldFileName.replaceAll(
					BatchConstant.REPLACE_SOURCE_FILE_PATTERN, BatchUtil
							.patrnDateToString(bhDate, repStingPatern));
		} else {
			return oldFileName;
		}
	}

	public static String getNewFileName(String oldFileName, String bhDate)
			throws Exception {
		Pattern ptn = Pattern.compile(BatchConstant.SOURCE_FILE_PATTERN);
		if (ptn.matcher(oldFileName).matches()) {
			return oldFileName.replaceAll(
					BatchConstant.REPLACE_SOURCE_FILE_PATTERN, bhDate);
		} else {
			return oldFileName;
		}
	}

	// /**
	// * 修改原文件名， 主机现在文件名规则为 例：ORGXXXXX,
	// * @param oleFileName 指原“DATA01.ORGXXXXX.UDF999”
	// * 或新 “ORGXXXXX” 从配置文件获取
	// * @return
	// */
	// public static String getNewFileName(String oldFileName) throws Exception
	// {
	//
	// if (oldFileName == null)
	// throw new Exception("输入的文件名为 null");
	//
	// String[] tmpStr = oldFileName.split("\\.");
	// String fname = "";
	// if (tmpStr.length > 1)
	// fname = tmpStr[1].trim();
	// else if (tmpStr.length == 1)
	// fname = tmpStr[0].trim();
	// else
	// fname = oldFileName;
	//
	// return fname;
	//
	// }

	/**
	 * 得到操作员的流水号
	 *
	 * @param conn
	 *            数据库连接
	 * @param tlrno
	 *            操作员号
	 * @throws Exception
	 */
	public static int getTlsrno(Connection conn, String tlrno) throws Exception {
		int tlsrno = 0; // 用户流水号
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = null; // 查询sql语句

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(80);

			sb.append("Select MSRNO from TLR_INFO_MSRNO where tlrno = '")
					.append(tlrno.trim())
					.append("' and PARTITION_KEY='999999'");

			rs = stmt.executeQuery(sb.toString());

			if (rs.next()) {
				tlsrno = rs.getInt(1);
			} else {
				tlsrno = 1;
			}

		} catch (SQLException e1) {
			throw e1;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();

		}
		return tlsrno;
	}

	/**
	 * 由日期返回yyyy-MM-dd格式的字符串
	 *
	 * @param date
	 *            Date格式日期
	 * @return String yyyy-MM-dd格式 的字符串
	 */
	public static String dateToString(java.util.Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	/**
	 * Description: 根据指定的pattern 返回字符串
	 *
	 * @param date
	 *            Date
	 * @return String
	 * @exception
	 * @author dcuser022
	 * @version v1.0,2008-9-2
	 */
	public static String patrnDateToString(java.util.Date date, String pattern) {
		if (date == null)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * 由日期返回yyyyMMdd格式的字符串
	 *
	 * @param date
	 * @return
	 */
	public static String dateToNumber(java.util.Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(date);
	}

	/**
	 * 由yyyyMMdd格式的字符串返回Date类型日期
	 *
	 * @param date
	 *            yyyyMMdd格式的字符串
	 * @return Date类型日期
	 * @throws ParseException
	 */
	public static Date numberToDate(String date) throws ParseException {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		java.sql.Date sd;
		java.util.Date ud;

		ud = simpleDateFormat.parse(date);

		sd = new java.sql.Date(ud.getTime());

		return sd;
	}

	/**
	 * 得到传入日期的yyyy年MM月dd日显示格式的字符串表达式
	 *
	 * @param date
	 *            日期
	 * @return String yyyy年MM月dd日显示格式的字符串
	 */
	public static String getDateDisp(Date date) {
		String s = dateToNumber(date);

		StringBuffer sb = new StringBuffer(32);
		sb.append(s.substring(0, 4)).append("年").append(s.substring(4, 6))
				.append("月").append(s.substring(6, 8)).append("日");

		return sb.toString();

	}

	/**
	 * 由日期返回yyyy-MM-dd HH:mm:ss格式的字符串
	 *
	 * @param date
	 *            Date格式日期
	 * @return String yyyy-MM-dd HH:mm:ss格式 的字符串
	 */
	public static String dateToStringSec(Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}

	/**
	 * 取得时间戳
	 *
	 * @return 时间戳
	 */
	public static String getTimestamp() {
		return DateUtil.getTimestamp();
	}

	public static String getTimestamp14() {
		return DateUtil.getTimestamp().substring(0, 14);
	}

	/**
	 * 由日期返回yyyy-MM-dd-HH.mm.ss.SSSSSS格式的字符串
	 *
	 * @param date
	 *            Date格式日期
	 * @return String yyyy-MM-dd-HH.mm.ss.SSSSSS格式 的字符串
	 */
	public static String getTimeStampFormat(java.util.Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd-HH.mm.ss.SSSSSS");
		return simpleDateFormat.format(date);
	}

	/**
	 *
	 * Description: TODO 返回当前机器日期yyyyMMddHHmmss格式的字符串
	 *
	 * @param
	 * @return String
	 * @exception
	 * @author Robin Suo
	 * @version v1.0,2009-8-13
	 */
	public static String getTimeStampFormat() {
		java.util.Date date = new java.util.Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		return simpleDateFormat.format(date);
	}

	/**
	 * 取得批量运行断点，如果批量断点表中无记录，那么插入一条记录，初始化断点为0
	 *
	 * @param conn
	 *            数据库连接
	 * @param stepNo
	 *            步骤号
	 * @param subStepNo
	 *            子步骤号
	 * @param jobNo
	 *            作业号
	 * @return 批量运行起始点
	 * @throws Exception
	 */
	public static String getCommit(Connection conn, String bhdate, int stepNo,
			int subStepNo, int jobNo) throws Exception {

		String commitPoint = null; // 批量运行点
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = null; // 查询sql语句

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(100);

			sb
					.append(
							"Select RESUME_POINT,PROC_VALUE from BH_PROC where bhdate='")
					.append(bhdate).append("' and jobno = ").append(jobNo)
					.append(" and step = ").append(stepNo).append(
							" and sub_step = ").append(subStepNo);

			rs = stmt.executeQuery(sb.toString());

			/*
			 * 如果找到记录，取到断点值
			 */
			if (rs.next()) {
				// 如果PROC_VALUE没有值，那么直接输出RESUME_POINT，取得批量线程断点
				if (rs.getString(2) == null
						|| rs.getString(2).trim().length() == 0) {
					commitPoint = rs.getString(1).trim();
				} else {
					/*
					 * 取得批量线程断点，以“RESUME_POINT|PROC_VALUE”形式传出
					 */
					commitPoint = rs.getString(1).trim() + "|"
							+ rs.getString(2).trim();

				}

			}
			/*
			 * 如果没找到记录，那么插入一条新纪录，初始化断点为空
			 */
			else {
				commitPoint = " ";

				sb = new StringBuffer(100); // 插入新纪录sql语句

				sb
						.append(
								"Insert into BH_PROC(BHDATE,JOBNO,STEP,SUB_STEP,RESUME_POINT,PROC_VALUE) VALUES('")
						.append(bhdate).append("',").append(jobNo).append(",")
						.append(stepNo).append(",").append(subStepNo).append(
								",'").append(commitPoint).append("','')");
				/*
				 * 执行插入操作，返回标志值，如果返回0，表示操作不成功，抛出异常。
				 */
				int flag = stmt.executeUpdate(sb.toString());
				if (flag <= 0) {
					throw new Exception("插入记录不成功");
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			throw e1;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return commitPoint;
	}

	/**
	 * 取得批量运行断点，如果批量断点表中无记录，那么从头开始
	 *
	 * @param conn
	 *            数据库连接
	 * @param stepNo
	 *            步骤号
	 * @param subStepNo
	 *            子步骤号
	 * @param jobNo
	 *            作业号
	 * @param commitStr
	 *            当前向数据库递交RESUME_POINT（和proc_value）
	 * @throws Exception
	 */
	public static void putCommit(Connection conn, String bhdate, int stepNo,
			int subStepNo, int jobNo, String commitStr) throws Exception {

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = null; // 更新断点表sql语句

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(100);

			/*
			 * 拆分传入的字符串
			 */
			String[] arr = commitStr.split("\\|");

			/*
			 * 如果是只传入RESUME_POINT值
			 */
			if (arr.length == 1) {
				sb.append("Update BH_PROC Set RESUME_POINT='").append(
						arr[0].trim()).append("' where BHDATE='")
						.append(bhdate).append("' and jobno = ").append(jobNo)
						.append(" and step = ").append(stepNo).append(
								" and sub_step = ").append(subStepNo);
			}

			/*
			 * 如果传入RESUME_POINT和proc_value
			 */
			else if (arr.length == 2) {
				sb.append("Update BH_PROC Set RESUME_POINT='").append(
						arr[0].trim()).append("' , PROC_VALUE='").append(
						arr[1].trim()).append("' where BHDATE='")
						.append(bhdate).append("' and jobno = ").append(jobNo)
						.append(" and step = ").append(stepNo).append(
								" and sub_step = ").append(subStepNo);
			}

			/*
			 * 执行修改操作，返回标志值，如果返回0，表示操作不成功，抛出异常。
			 */
			int flag = stmt.executeUpdate(sb.toString());
			if (flag <= 0) {
				// throw new Exception("修改记录不成功");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			throw e1;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	/**
	 * 设置操作流水号到用户表
	 *
	 * @param conn
	 *            数据库连接
	 * @param tlrno
	 *            操作员号
	 * @param tlrsno
	 *            流水号
	 * @throws Exception
	 */
	public static void putTlsrno(Connection conn, String tlrno, int tlrsno)
			throws Exception {

		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = null; // 更新断点表sql语句

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer();

			sb.append("Update TLR_INFO_MSRNO Set MSRNO=").append(tlrsno + 1)
					.append(", TIMESTAMP='").append(DateUtil.getTimestamp())
					.append("' where tlrno='").append(tlrno.trim()).append(
							"' and PARTITION_KEY='999999'");

			/*
			 * 执行修改操作，返回标志值，如果返回0，表示操作不成功，抛出异常。
			 */
			int flag = stmt.executeUpdate(sb.toString());
			if (flag != 1) {
				sb.delete(0, sb.length());
				sb
						.append(
								"INSERT INTO TLR_INFO_MSRNO (TLRNO,PARTITION_KEY,MSRNO,TIMESTAMP) VALUES('")
						.append(tlrno.trim()).append("','999999',").append(
								tlrsno + 1).append(",'").append(
								DateUtil.getTimestamp()).append("' )");

				flag = stmt.executeUpdate(sb.toString());
				if (flag != 1)
					throw new Exception("插入TLR_INFO_MSRNO错误");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			throw e1;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	/**
	 * 写批量子步骤数据库日志
	 *
	 * @param conn
	 *            数据库连接
	 * @param vo
	 *            该子线程数据对象
	 * @throws SQLException
	 */
	public static void writeDBLog(Connection conn, ThreadVO vo, String _bhdate,
			String _str, String _line) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sqlQuery = new StringBuffer(80); // 查询批量日志表sql语句
		StringBuffer sqlUpdate = null; // 更新批量日志表sql语句
		StringBuffer sqlInsert = null; // 插入批量日志表sql语句
		PreparedStatement ps = null;
		InsertHelper ih = null;
		try {
			stmt = conn.createStatement(); // 创建statement
			if (_bhdate == null) {
				_bhdate = BatchUtil.getGlobalInfo(conn).getBhdate().replace("-", "");
			}
			_bhdate = _bhdate.replace("-", "");
			// start modify by davexin 2011-12-22
			if(null!=_bhdate&&_bhdate.length()>8){
				_bhdate = _bhdate.substring(0, 8);
	        }
			//  end modify

			/*
			 * 首先查询日志表是否存在该子线程记录
			 */
			sqlQuery.append("Select status from BH_PROC_LOG where bhdate='")
					.append(_bhdate).append("' and jobno = ").append(
							vo.getJobNo()).append(" and step = ").append(
							vo.getStepNo()).append(" and sub_step = ").append(
							vo.getSubstepNo());
			rs = stmt.executeQuery(sqlQuery.toString());

			/*
			 * 如果存在，那么更新日志记录
			 */
			if (rs.next()) {
				sqlUpdate = new StringBuffer(100);
				sqlUpdate.append(
								"Update BH_PROC_LOG Set STATUS=?, " +
								" END_TIME= to_timestamp(?, 'yyyyMMddhh24missff')," +
								" TIMESTAMPS=to_timestamp(?, 'yyyyMMddhh24missff')," +
								" ERR_MSG=?," +
								" DESC1=?" +
								" where bhdate='")
						.append(_bhdate).append("' and jobno = ").append(
								vo.getJobNo()).append(" and step = ").append(
								vo.getStepNo()).append(" and sub_step = ")
						.append(vo.getSubstepNo());
				ps = conn.prepareStatement(sqlUpdate.toString());
				ps.setString(1, vo.getStatus().trim());
				ps.setString(2, DateUtil.getTimestamp());
				ps.setString(3, DateUtil.getTimestamp());
				ps.setString(4, BatchUtil.trim(_str));
				ps.setString(5, BatchUtil.trim(_line));
				System.out.println("------Update BH_PROC_LOG="+sqlUpdate.toString()+"   _bhdate="+_bhdate);

				ps.executeUpdate();
			}

			/*
			 * 如果不存在，那么插入新日志记录
			 */
			else {
				System.out.println(" 6  DateUtil.getTimestamp()="+DateUtil.getTimestamp());
				System.out.println(" 8  DateUtil.getTimestamp()="+DateUtil.getTimestamp());
				System.out.println("   _bhdate="+_bhdate);

				BatchUtils.setCurrentDbType();//
				ih = BatchUtils.getInsertHelper(conn, "BH_PROC_LOG");//
				ih.beginInsert();//

				sqlInsert = new StringBuffer(100);

				sqlInsert
						.append(// ID,
								"Insert into BH_PROC_LOG ( ID," +
								" BHDATE, JOBNO, STEP, SUB_STEP, PROCESS_FUNCTION, " +
								" PROCESSID, START_TIME, END_TIME, STATUS, TIMESTAMPS, ERR_MSG, DESC1) VALUES(")
						.append(getSeqValue(conn,"SEQ_BH_PROC_LOG")+",?,?,?,?,?," +
								"0,to_timestamp(?,'yyyyMMddhh24missff'),null,?,to_timestamp(?,'yyyyMMddhh24missff'),?,?)");// @identity,
				ps = ih.createPrepareStatement(sqlInsert.toString());
				// ps = conn.prepareStatement(sqlInsert.toString());
				 System.out.println("=======sqlInsert.toString()=" + sqlInsert.toString());
				ps.setString(1, _bhdate);
				ps.setInt(2, vo.getJobNo());
				ps.setInt(3, vo.getStepNo());
				ps.setInt(4, vo.getSubstepNo());
				ps.setString(5, vo.getName());
				ps.setString(6, DateUtil.getTimestamp());
				ps.setString(7, vo.getStatus().trim());
				ps.setString(8, DateUtil.getTimestamp() );
				ps.setString(9, BatchUtil.trim(_str));
				ps.setString(10, BatchUtil.trim(_line));
				ps.executeUpdate();
				ih.endInsert();//
			}
		} catch (SQLException e1) {
			throw e1;
		} finally {
			/*
			 * 关闭数据库资源
			 */
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (ps != null)
				ps.close();
			if (ih != null)
				ih.endInsert();

		}
	}

	/**
	 * 写批量子步骤数据库日志
	 *
	 * @param conn
	 *            数据库连接
	 * @param vo
	 *            该子线程数据对象
	 * @throws SQLException
	 */
	public static void writeDBLog(Connection conn, ThreadVO vo, String _bhdate,
			String str) throws Exception {
		BatchUtil.writeDBLog(conn, vo, _bhdate, str, "");
	}

	/**
	 * 写批量子步骤数据库日志
	 *
	 * @param conn
	 *            数据库连接
	 * @param vo
	 *            该子线程数据对象
	 * @throws SQLException
	 */
	public static void writeDBLog(Connection conn, ThreadVO vo, String _bhdate,
			Throwable throwable) throws Exception {
		String message = null;
		message = BatchUtil.trim(throwable.getMessage());
		if (message.length() > 1000)
			message = throwable.getMessage().substring(0, 1000);
		else
			message = throwable.getMessage();
		String line = BatchUtil.getCaller(throwable);
		if (line.length() > 1000)
			line = line.substring(0, 1000);

		BatchUtil.writeDBLog(conn, vo, _bhdate, message, line);
	}

	/**
	 * 创建日志文件
	 *
	 * @param bhdate
	 *            日期
	 * @param filename
	 *            文件名
	 * @return String 返回日志文件路径名
	 * @throws Exception
	 */
	public static String createLogFile(String bhdate, String filename)
			throws Exception {
		StringBuffer filePathName = new StringBuffer(64); // 日志文件路径及文件名称
		StringBuffer filePath = new StringBuffer(64); // 日志文件路径

		/*
		 * 拼装日志文件路径。 文件名组成：日志路径/批量日期
		 */
		String batchLogPath = getBatchLogPath();

		String fileSeparator = getFileSeparator();
        // start modify by davexin 2011-12-22
		if(null!=bhdate&&bhdate.length()>8){
        	bhdate = bhdate.substring(0, 8);
        }
		//  end modify
		filePath.append(batchLogPath).append(fileSeparator).append(bhdate);

		/*
		 * 拼装日志文件名。 文件名组成：日志路径/批量日期/线程名.log
		 */
		filePathName.append(filePath).append(fileSeparator).append(filename)
				.append(".log");

		File file = new File(filePathName.toString()); // 创建这个文件实例对象

		/*
		 * 如果文件不存在，那么创建这个文件
		 */
		if (!file.exists()) {
			File path = new File(filePath.toString());
			if (!path.exists()) {
				path.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (Exception ioe) {
				System.out.println("Create file " + filePathName.toString());
				throw ioe;
			}
		}

		return filePathName.toString();
	}

	/**
	 * @Title: 取批量配置属性
	 * @Description:
	 * @param key
	 * @param defaultValue
	 * @return
	 * @throws IOException
	 * @author Ranger.Mao
	 * @Created time: Mar 10, 2005 5:27:27 PM modified by pei 修改配置文件读入位置
	 */
	public static String getBatchProperty(String key, String defaultValue)
			throws IOException {
		String property;
		BatchUtil batchUtil = new BatchUtil();
		/*
		 * String rootDir = "/"; InputStream stream =
		 * batchUtil.getClass().getResourceAsStream( rootDir +
		 * BatchConstant.BATCH_PROPERTY_FILE);
		 */
		InputStream stream = batchUtil.getClass().getClassLoader()
				.getResourceAsStream(BatchConstant.BATCH_PROPERTY_FILE);
		try {
			Properties properties = new Properties();
			properties.load(stream);
			property = properties.getProperty(key, defaultValue);
		} finally {
			if (stream != null)
				stream.close();
		}
		return property;
	}

	/**
	 * @Title: 取批量日志文件路径
	 * @Description:
	 * @return
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: Mar 10, 2005 5:27:12 PM
	 */
	public static String getBatchLogPath() throws Exception {
		String batchLogPath = null;
		if ((batchLogPath = BatchUtil.getBatchProperty(
				BatchConstant.BATCH_LOG_PATH, "")).equals(""))
			throw new Exception(BatchConstant.BATCH_LOG_PATH + "属性未设置!");
		return batchLogPath;
	}

	/**
	 * @Title: 取系统文件分隔符
	 * @Description: 取系统文件分隔符
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Mar 9, 2005 3:33:02 PM
	 */
	public static String getFileSeparator() {
		String fileSeparator = System.getProperty("file.separator");
		if (fileSeparator == null) {
			String osName = System.getProperty("os.name");
			if (osName == null) {
				fileSeparator = "/";
			} else {
				if (osName.length() > 3
						&& osName.substring(0, 3).equalsIgnoreCase("win"))
					fileSeparator = "\\";
				else
					fileSeparator = "/";
			}
		}
		return fileSeparator;
	}

	/**
	 * 写批量文件日志 modify by weikun wang 2007.7.19
	 *
	 * @param filePathName
	 *            日志文件路径名
	 * @param msg
	 *            日志字符串描述
	 */
	public static void writeFileLog(String filePathName, String msg)
			throws Exception {
		// 记录日志信息

		Logger fileLog = LoggerConstants.getBatchLogger(filePathName);
		// modify by hui.liu 20110901 begin
//		fileLog.debug(msg);
		fileLog.info(msg);
		
	}

	public static void writeFileLog(String filePathName, StringBuffer msg)
			throws Exception {
		writeFileLog(filePathName, msg.toString());
	}

	public static BSysGlobalInfo getGlobalInfo(Connection conn) throws Exception {
		BSysGlobalInfo globalInfo = null;
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		try {
			stmt = conn.createStatement(); // 创建statement

			/*
			 * 从globalinfo表取得上一会计日，即本次批量日期
			 */
			//modify by fangquan 2017-05-27 SCF 更新 系统表名 B_SYS_GLOBAL_INFO
			 rs = stmt
			 .executeQuery("Select TBSDY,BHDATE,LBHDATE,STATUS,SYSTEM_TYPE from B_SYS_GLOBAL_INFO where id ='"
			 + BatchConstant.TABLE_GLOBAL_INFO_ID+"'");

			DateFormat ff=new SimpleDateFormat("yyyyMMdd");
			if (rs.next()) {
				globalInfo = new BSysGlobalInfo();
				globalInfo.setTxdate(dateToString(ff.parse(rs.getString(1))));
				globalInfo.setBhdate(dateToString(ff.parse(rs.getString(2))));
				globalInfo.setLbhdate(dateToString(ff.parse(rs.getString(3))));
				globalInfo.setStatus(rs.getString(4));
				globalInfo.setSystemType(rs.getString(5));
				return globalInfo;
			}

			throw new Exception("未找到globalinfo记录");

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * 通过类名、构造函数及其参数值装载一个类的实例
	 *
	 * @param strClassName
	 *            类名
	 * @param argsType
	 *            构造函数参数类型
	 * @param args
	 *            构造函数参数值
	 * @return Object 返回类的实例对象
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object loadClass(String strClassName, Class[] argsType,
			Object[] args) throws NoSuchMethodException, SecurityException,
			ClassNotFoundException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		Object returnObj = null;
		Class className = null;
		Constructor constructor = null;

		className = Class.forName(strClassName, true, Thread.currentThread()
				.getContextClassLoader());

		constructor = className.getConstructor(argsType);
		returnObj = constructor.newInstance(args);

		return returnObj;
	}

	// =========================modify by weikun wang
	// 2008.8.6==========================
	/**
	 * 根据指定路径的文件导出更新数据信息
	 *
	 * @param filePathName
	 *            导入文件路径和名称
	 * @param itemNum
	 *            导入数据每条记录的数据项数目
	 * @param logFilePathName
	 *            日志文件路径和名称
	 * @return ArrayList 成员对象：String[] 返回列表，每条列表项存放文件记录每行信息，以String[]字符串数组形式存放
	 *         各个记录字段 如果不存在导入文件，那么返回null
	 * @throws Exception
	 */
	public static ArrayList loadDataFromFile(String filePathName, int itemNum,
			String logFilePathName) throws Exception {

		String sReadLine = new String(); // 从文件中读出的一行字符串数据
		long lLineNum = 0; // 当前读取文件行数

		ArrayList dataList = null;
		// 返回列表，每条列表项存放文件记录每行信息，第一条记录存放文件头部第一行信息
		String[] strArrayOfLine = null; // 一行数据中被分隔符“:”分隔的数据
		String[] strArrayOfData = new String[itemNum]; // 存放一条地区数据对象

		/*
		 * 读取导入格式文件
		 */
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader(filePathName));

		dataList = new ArrayList();

		/*
		 * 从这里开始读取文件信息
		 */
		writeFileLog(logFilePathName, "开始读取文件。"); // 记日志
		sReadLine = bufferedReader.readLine(); // 读文件第一行

		/*
		 * 这个while循环读取文件的每一行数据信息，存放到返回列表中
		 */
		while (sReadLine != null) {
			lLineNum++; // 读取文件行数行数递增1

			// 如果碰到空行，继续读下一行
			while (sReadLine != null && sReadLine.trim().length() == 0) {
				sReadLine = bufferedReader.readLine();
				lLineNum++; // 读取文件行数递增1
			}
			// 如果碰到文件尾，退出
			if (sReadLine == null) {
				break;
			}

			// 首先分隔数据成字符串数组
			strArrayOfLine = sReadLine.split("\\:");

			// 判断该行是否不存在任何有效数据，如果是则忽略，否则将这条明细加入数据列表中
			if (sReadLine.replaceAll(":", "").trim().length() > 1) {

				// 然后检查地区数据合法性，是否具有itemNum项数据
				if (strArrayOfLine.length >= itemNum) { // TODO
					// 给strArrayOfData分配新的存储空间,否则列表中所有项都将指向最后一个字符串数组的数据
					strArrayOfData = new String[itemNum];

					// 复制strArrayOfLine 到 strArrayOfData 数组中
					System.arraycopy(strArrayOfLine, 0, strArrayOfData, 0,
							itemNum);

					// 然后将数组加入到明细列表中
					dataList.add(strArrayOfData);

				} else {
					// 首先打印出错误信息
					StringBuffer sb = new StringBuffer();
					sb.append("读取文件" + filePathName + "出错: 在第")
							.append(lLineNum);
					sb.append("行读取数据出错!数据项数量不匹配!" + itemNum);
					throw new Exception(sb.toString());
				}

			}
			// 继续读取下一行数据
			sReadLine = bufferedReader.readLine();
		} // end of ： while (sReadLine != null && sReadLine.trim().length() !=
		// 0)

		// 已经读到文件尾，结束文件读取
		writeFileLog(logFilePathName, "文件读取结束。");
		System.out.println("文件读取结束。");

		return dataList;
	}

	/**
	 * 得到机构所属分行行号
	 *
	 * @param conn
	 *            数据库联接
	 * @param brcode
	 *            机构号
	 * @return 机构所属分行行号
	 * @throws SQLException
	 */
	public static String getBranchBrcode(Connection conn, String brcode)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String branchBrcode = null; // 所属分行号
		String sqlBctl = "Select BRCLASS, BLN_BRANCH_BRCODE from BCTL WHERE BRCODE = '"
				+ brcode.trim()
				+ "' and DELETE_FLAG != '"
				+ BatchConstant.FLAG_ON + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sqlBctl);
			if (rs.next()) {
				branchBrcode = BatchUtil.trim(rs.getString(2));
				// // 返回所属分行号
				// if (brclass.equals(BatchConstant.BRCODE_CLASS_SUBBRANCH)) {
				// branchBrcode = rs.getString(2);
				// }
				// // 如果是分行，返回自己
				// else if (brclass.equals(BatchConstant.BRCODE_CLASS_BRANCH))
				// {
				// branchBrcode = brcode;
				// }
				// // 如果是总行，返回空
				// else {
				// branchBrcode = null;
				// }
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return branchBrcode;
	}

	/**
	 * 得到机构级别
	 *
	 * @param conn
	 *            数据库联接
	 * @param brcode
	 *            机构号
	 * @return 机构级别
	 * @throws SQLException
	 */
	public static String getBrclass(Connection conn, String brcode)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String brclass = null; // 级别代码
		String sqlBctl = "Select BRCLASS from BCTL WHERE BRCODE = '"
				+ brcode.trim() + "' and DELETE_FLAG != '"
				+ BatchConstant.FLAG_ON + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sqlBctl);
			if (rs.next()) {
				brclass = rs.getString(1).trim();

			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return brclass;
	}

	/**
	 * 得到总行机构号
	 *
	 * @param conn
	 *            数据库联接
	 * @return 总行机构号
	 * @author George.Liu
	 * @Created time: 2004-11-25 17:26:38
	 * @throws SQLException
	 *
	 */
	public static String getHeadBrcode(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String headBrcode = null; // 总行行号
		String sqlBctl = "Select BRCODE from BCTL WHERE BRCLASS = '"
				+ BatchConstant.BRCODE_CLASS_HEAD + "' and STATUS = '"+BatchConstant.BCTL_STATUS_VALID+"' ORDER by brcode desc ";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sqlBctl);
			if (rs.next()) {
				headBrcode = rs.getString(1).trim();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return headBrcode;
	}

	/**
	 * 根据业务指定的机构顺序进行排序 业务指定机构顺序指bctl.brseq add by 丁保健
	 *
	 * @param conn
	 *            数据库连接对象
	 * @param hashData
	 *            传入排序hash对象集,key为机构号 value为值对象
	 * @return dataList 返回排好序的value对象集(ArrayList)
	 */
	synchronized public static ArrayList sortByBrseq(Connection conn,
			Hashtable hash) throws Exception {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String[] brseqBrcode = null;
		String brseq = "";
		String key = "";
		int i = 0;
		String sql = "Select distinct brcode,brseq from bctl order by brseq";
		ArrayList dataList = new ArrayList();
		try {

			if (bctlHashlist == null) {
				bctlHashlist = new Hashtable();
				stmt = conn.createStatement(); // 创建statement
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					key = BatchUtil.trim(rs.getString("brcode"));
					brseq = BatchUtil.trim(rs.getString("brseq"));
					if ("".equals(brseq)) {
						brseq = "999999";
					}
					bctlHashlist.put(key, brseq);
				}
			}

			Enumeration keys = hash.keys();
			brseqBrcode = new String[hash.size()];
			while (keys.hasMoreElements()) {
				String keyTmp = (String) keys.nextElement();
				String value = (String) bctlHashlist
						.get(BatchUtil.trim(keyTmp));
				brseqBrcode[i] = value + ":" + keyTmp;
				i++;
			}

			Arrays.sort(brseqBrcode);

			for (int j = 0; j < brseqBrcode.length; j++) {
				String[] brcode = brseqBrcode[j].split(":");
				Object backValue = (Object) hash.get(brcode[1]);
				dataList.add(backValue);
			}

		} catch (SQLException e) {
			if (bctlHashlist != null)
				bctlHashlist.clear();
			throw new Exception("查询BCTL表出错!", e);
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
		return dataList;
	}

	/**
	 * 得到合同号所属的授信号
	 *
	 * @param conn
	 *            数据库联接
	 * @param contractno
	 *            合同号
	 * @return 授信号
	 * @throws SQLException
	 */
	public String getCreditNo(Connection conn, String contractno)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String creditno = null; // 授信号
		String sql = "Select CONTRACTNO from CONTRACTMAP WHERE COCONTRACTNO = '"
				+ contractno.trim()
				+ "' and MAPTYPE = '"
				+ BatchConstant.CONTRACTMAP_TYPE_CREDIT + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				creditno = rs.getString(1);
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return creditno;
	}

	public String dataDicMapInToOut(Connection conn, int mapType,
			String inDataNo) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String creditno = null; // 授信号
		String sql = "Select OUTCODE, OUTCODE_LEN from DATA_DIC_MAP WHERE MAP_TYPE = "
				+ mapType + " and INCODE = '" + inDataNo + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				creditno = rs.getString(1).substring(0, rs.getInt(2));
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return creditno;
	}

	/**
	 * 通过贷款产品号得到贷款产品名称
	 *
	 * @param conn
	 *            数据库连接
	 * @param lnid
	 *            贷款产品号
	 * @return String 贷款产品名称
	 */
	public static Hashtable getLnnameTable(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String lnname = "";
		String lnid = "";
		String sql = "Select LN_NAME,LNID from LOAN_PARAM WHERE brcode = '"
				+ BatchUtil.getHeadBrcode(conn) + "' AND FLAG = '"
				+ BatchConstant.FLAG_ON + "'";
		Hashtable hashtable = new Hashtable();
		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				lnname = BatchUtil.trim(rs.getString("LN_NAME"));
				lnid = BatchUtil.trim(rs.getString("LNID"));
				hashtable.put(lnid, lnname);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
		return hashtable;
	}

	/**
	 * 通过贷款产品号得到贷款产品名称
	 *
	 * @param conn
	 *            数据库连接
	 * @param lnid
	 *            贷款产品号
	 * @return String 贷款产品名称
	 */
	public static String getLnname(Connection conn, String lnid)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String lnname = "";

		if (lnid == null) {
			return lnname;
		}

		String sql = "Select LN_NAME  from LOAN_PARAM WHERE LNID = '"
				+ lnid.trim() + "' and brcode = '" + "999999"
				// + BatchUtil.getHeadBrcode(conn) TODO 写死
				+ "' AND FLAG = '" + BatchConstant.FLAG_ON + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				lnname = rs.getString(1).trim();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		if (lnname == null) {
			return "";
		}
		return lnname;
	}

	/**
	 * 通过机构号查询机构名称
	 *
	 * @param conn
	 *            数据库连接
	 * @param brcode
	 *            机构号
	 * @return String 机构名称
	 */
	public static String getBrname(Connection conn, String _brcode)
			throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String brname = null;

		String sqlBctl = "Select BRNAME from BCTL WHERE BRCODE = '"
				+ _brcode.trim() + "' and DELETE_FLAG != '"
				+ BatchConstant.FLAG_ON + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sqlBctl);
			if (rs.next()) {
				brname = rs.getString(1).trim();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		if (brname == null) {
			return "";
		}
		return brname;

	}

	/**
	 *
	 * 截取小数点后位数,被截去部位四舍五入
	 *
	 * @param d
	 *            被截去的小数
	 *
	 * @param scale
	 *            小数点后保留位数
	 *
	 * @return 被截去后的结果
	 *
	 */

	public static double floor(double d, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(d));

		return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 通过客户号（合作商id）得到客户名称（合作商名称）
	 *
	 * @param conn
	 *            数据库连接
	 * @param custcd
	 *            客户号（合作商id）
	 */
	public static String getCustName(Connection conn, String custcd)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String custName = "";

		if (custcd == null || custcd.trim().length() == 0) {
			return custName;
		}

		String sql = "Select chn_name from customer_info WHERE custcd = '"
				+ custcd.trim() + "' and status = '1'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				custName = rs.getString(1).trim();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		if (custName == null) {
			return "";
		}

		return custName;

	}

	/**
	 * 通过操作员号得到操作员名称
	 *
	 * @param conn
	 *            数据库连接
	 * @param tlrno
	 *            操作员号
	 * @return String 操作员名称
	 */
	public static String getTlrName(Connection conn, String tlrno)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String tlrName = "";

		if (tlrno == null) {
			return tlrName;
		}

		String sql = "Select tlrno_name from TLR_INFO where tlrno = '"
				+ tlrno.trim() + "' and flag ='" + BatchConstant.FLAG_ON + "'";

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				tlrName = rs.getString(1).trim();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		if (tlrName == null) {
			return "";
		}
		return tlrName;
	}

	/**
	 * 通过操作员号得到操作员名称
	 *
	 * @param conn
	 *            数据库连接
	 * @param dataTypeNo
	 *            数据字典类型代码
	 * @param dataNo
	 *            数据字典数据项代码
	 * @return String 数据字典数据项名称
	 * @throws SQLException
	 */
	public static String getDataDicName(Connection conn, int dataTypeNo,
			String dataNo) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String dataName = null;

		StringBuffer sql = new StringBuffer(100);
		sql.append("Select  DATA_NAME from DATA_DIC WHERE DATA_TYPE_NO=")
				.append(dataTypeNo).append(" AND DATA_NO ='").append(
						dataNo.trim()).append("' and flag ='").append(
						BatchConstant.FLAG_ON).append("'");

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql.toString());
			if (rs.next()) {
				dataName = rs.getString(1).trim();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		if (dataName == null) {
			return "";
		}
		return dataName;
	}

	/**
	 * @Title: 去空格
	 * @Description: 去空格
	 * @param str
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Mar 29, 2005 2:28:49 PM
	 */
	public static String trim(String str) {
		if (str == null)
			return "";

		return str.trim();
	}

	/**
	 * 得到系统状态
	 *
	 * @param conn
	 *            数据库连接
	 * @return String 系统状态标志
	 * @throws Exception
	 */
	public static String getSystemStatus(Connection conn) throws Exception {
		Statement stmt = conn.createStatement(); // 创建statement
		ResultSet rs = null; // 查询结果集
		String status = null; // 系统状态

		String sqlGlobal = null; // 查询sql语句
		//modify by hui.liu 2011-05-12 SCF 更新 系统表名 begin
		 sqlGlobal = "Select STATUS from B_SYS_GLOBAL_INFO where id ="
		 + BatchConstant.TABLE_GLOBAL_INFO_ID;

		// 2009-07-17从DB2更新到SQLSERVER GLOBALINFO改为GLOBAL_INFO
//		sqlGlobal = "Select STATUS from GLOBAL_INFO where id ="
//				+ BatchConstant.TABLE_GLOBAL_INFO_ID;
		//modify by hui.liu 2011-05-12 SCF 更新 系统表名 end

		rs = stmt.executeQuery(sqlGlobal);
		if (rs.next()) {
			status = rs.getString(1);
		} else
			throw new Exception("未找到globalinfo记录");

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return status.trim();
	}

	/**
	 * 得到当前批量状态
	 *
	 * @param Connection
	 *            conn 数据库连接
	 * @param sBhdate
	 *            批量日
	 * @param jobno
	 *            作业号
	 * @return String 批量状态标志
	 */
	public static String getBatchStatus(Connection conn, String bhdate,
			int jobno) throws Exception {

		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String _bhDate = null;
		try {
			stmt = conn.createStatement(); // 创建statement
			String status = ""; // 系统状态

			StringBuffer sqlQuery = new StringBuffer(80); // 查询sql语句

			stmt = conn.createStatement(); // 创建statement

			_bhDate = bhdate;

			/*
			 * 首先查询日志表是否存在该子线程记录
			 */
			sqlQuery.append("Select status from BH_PROC_STATUS where bhdate='")
					.append(_bhDate).append("' and jobno = ").append(jobno);
			// System.out.println(sqlQuery.toString());

			rs = stmt.executeQuery(sqlQuery.toString());
			if (rs.next()) {
				status = rs.getString(1).trim();
			}
			return status;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * @Title: 取批量文件路径,带日期
	 * @Description: 取批量文件路径,带日期
	 * @param _bhDate
	 * @return
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: Mar 31, 2005 8:15:18 PM
	 */
	public static String getLoadFilePath(java.util.Date _bhDate)
			throws Exception {
		String filePath = BatchUtil.getBatchProperty(
				BatchConstant.BATCH_PROPERTY_LOADFILE_PATH, "");
		if (filePath.equals(""))
			throw new Exception(BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_LOADFILE_PATH + "未配置!");

		return filePath + BatchUtil.getFileSeparator()
				+ BatchUtil.dateToNumber(_bhDate);
	}

	/**
	 *
	 * Description: TODO 取批量文件路径,带日期
	 *
	 * @param _bhDate
	 * @return String
	 * @exception
	 * @author Robin Suo
	 * @version v1.0,2009-8-13
	 */
	public static String getLoadFilePath(String _bhDate) throws Exception {
		String filePath = BatchUtil.getBatchProperty(
				BatchConstant.BATCH_PROPERTY_LOADFILE_PATH, "");
		if (filePath.equals(""))
			throw new Exception(BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_LOADFILE_PATH + "未配置!");

		return filePath + BatchUtil.getFileSeparator() + _bhDate;
	}

	/**
	 * @Title: 取<分行>批量文件路径,带日期
	 * @Description: 取批量文件路径,带日期
	 * @param _bhDate
	 * @return
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: Mar 31, 2005 8:15:18 PM
	 */
	public static String getBrhLoadFilePath(java.util.Date _bhDate)
			throws Exception {
		String filePath = BatchUtil.getBatchProperty(
				BatchConstant.BATCH_PROPERTY_BRH_LOADFILE_PATH, "");
		if (filePath.equals(""))
			throw new Exception(BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_BRH_LOADFILE_PATH + "未配置!");

		return filePath + BatchUtil.getFileSeparator()
				+ BatchUtil.dateToNumber(_bhDate);
	}

	/**
	 * @Title: 取银信通-贷款到期提醒提前天数 2006/03/16
	 * @Description:
	 * @return
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: Mar 31, 2005 8:15:18 PM
	 */
	public static int getSmsRepayPlanWarnDays() throws Exception {
		int warnDaysInt = 0;
		String warnDays = BatchUtil.getBatchProperty(
				BatchConstant.BATCH_PROPERTY_SMS_ALTER_DAYS, "");
		if (warnDays.trim().equals("") || 0 == warnDays.trim().length())
			throw new Exception(BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_SMS_ALTER_DAYS + "未配置!");

		// TODO: 合法性检查！ 必须是数字
		try {
			warnDaysInt = Integer.parseInt(warnDays);
		} catch (Exception e) {
			throw new Exception(BatchConstant.BATCH_PROPERTY_FILE + "中"
					+ BatchConstant.BATCH_PROPERTY_SMS_ALTER_DAYS
					+ "(贷款到期提前提醒天数)必须定义为数字!");
		}

		return warnDaysInt;
	}

	/**
	 * @Title: 解决乱码问题
	 * @Description:
	 * @param str
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Apr 1, 2005 11:40:56 AM
	 */
	public static String convert(String str) {
		return str;
		/*
		 * 已找到解决方法java -Dfile.encoding=GB18030 try { return new String(
		 * str.getBytes("GBK"), System.getProperty("file.encoding")); } catch
		 * (UnsupportedEncodingException e) { return str; }
		 */

	}

	/**
	 * 将整数类型的状态转换成一个的char类型的状态。(用于授信额度)
	 *
	 * @param iStatus
	 *            整数类型的状态
	 * @return String，char类型的状态
	 */
	public static String getStrStatus(int iStatus) {
		String strStatus = null;
		switch (iStatus) {
		case 0: {
			strStatus = "0";
			break;
		}
		case 1: {
			strStatus = "1";
			break;
		}
		case 2: {
			strStatus = "2";
			break;
		}
		case 3: {
			strStatus = "3";
			break;
		}
		case 4: {
			strStatus = "4";
			break;
		}
		case 5: {
			strStatus = "5";
			break;
		}
		case 6: {
			strStatus = "6";
			break;
		}
		case 7: {
			strStatus = "7";
			break;
		}
		case 8: {
			strStatus = "8";
			break;
		}
		case 9: {
			strStatus = "9";
			break;
		}
		case 10: {
			strStatus = "a";
			break;
		}
		case 11: {
			strStatus = "b";
			break;
		}
		case 12: {
			strStatus = "c";
			break;
		}
		case 13: {
			strStatus = "d";
			break;
		}
		case 14: {
			strStatus = "e";
			break;
		}
		case 15: {
			strStatus = "f";
			break;
		}
		case 16: {
			strStatus = "g";
			break;
		}
		case 17: {
			strStatus = "h";
			break;
		}
		default: {
			strStatus = "z";
		}
		}
		return strStatus;
	}

	/**
	 * 根据输入的字符编码的长度，返回指定长度的String(相当于c语言的printf("%-n.ns",str))
	 * 如果length小于str的长度，则截取指定长度； 如果length大于str的长度，则不足部分用空格补齐
	 *
	 * @param str
	 * @param length
	 *            长度
	 * @return
	 */
	public static String BytesLeftAlign(String str, int length) {
		if (str == null)
			return initString(' ', length);

		int len = str.getBytes().length;
		if (length < len)
			return str.substring(0, length);
		else if (length == len)
			return str;
		else
			return str + initString(' ', length - len);
	}

	/**
	 * 根据输入的字符串，返回指定长度的String(相当于c语言的printf("%-n.ns",str))
	 * 如果length小于str的长度，则截取指定长度； 如果length大于str的长度，则不足部分用空格补齐
	 *
	 * @param str
	 * @param length
	 *            长度
	 * @return
	 */
	public static String strLeftAlign(String str, int length) {
		if (str == null)
			return initString(' ', length);

		int len = str.length();
		if (length < len)
			return str.substring(0, length);
		else if (length == len)
			return str;
		else
			return str + initString(' ', length - len);
	}

	/**
	 * 返回指定长度的，由指定字符组成的字符串(相当于c语言的memset)
	 *
	 * @param ch
	 * @param length
	 * @return
	 */
	public static String initString(char ch, int length) {
		if (length <= 0)
			return "";
		char chars[] = new char[length];
		for (int i = 0; i < length; i++)
			chars[i] = ch;
		return new String(chars);
	}

	/**
	 * 将double转换为右对齐，左补0的String(相当于c语言的printf("%0m.nf",dbl))
	 *
	 * @param dbl
	 *            要转换的double
	 * @param length
	 *            小数点前长度（不包括符号位）
	 * @param precision
	 *            小数点后长度
	 * @return
	 * @throws Exception
	 */
	public static String dblRightAlign(double dbl, int length, int precision)
			throws Exception {
		if (length <= 0 || precision < 0)
			throw new Exception("数据格式不正确");

		String format = initString('0', length);
		if (precision > 0)
			format = format + "." + initString('0', precision);
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(dbl);
	}

	/**
	 * 将double转换为右对齐，左补0的String，小数四舍五入(相当于c语言的printf("%0m.0f",dbl))
	 *
	 * @param dbl
	 *            要转换的double
	 * @param length
	 *            整数长度（不包括符号位）
	 * @return
	 * @throws Exception
	 */
	public static String dblRightAlign(double dbl, int length) throws Exception {
		if (length <= 0)
			throw new Exception("数据格式不正确");

		String format = initString('0', length);
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(dbl);
	}

	/**
	 * 字符串转换为期限格式(长3位，前补0)
	 *
	 * @param term
	 * @return
	 */
	public static String stringToTerm(String term) {
		if (term == null)
			return DateUtil.TERM_PATTERN;
		DecimalFormat decimalFormat = new DecimalFormat(DateUtil.TERM_PATTERN);
		return decimalFormat.format(Integer.parseInt(term));
	}

	/**
	 * @Title: float转利率显示 2.6
	 * @Description:
	 * @param rate
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Feb 7, 2005 10:21:23 AM
	 */
	public static String floatToRate(double rate) {
		DecimalFormat decimalFormat = new DecimalFormat(DateUtil.RATE_PATTERN);
		return decimalFormat.format(rate);
	}

	/**
	 * @Title: float转比率显示3.2
	 * @Description:
	 * @param rate
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Feb 7, 2005 10:22:54 AM
	 */
	public static String floatToratio(double rate) {
		DecimalFormat decimalFormat = new DecimalFormat(DateUtil.FLOAT_PATTERN);
		return decimalFormat.format(rate);
	}

	/**
	 * 以分为单位的金额转换为带分节符的右对齐的字符串
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToCurrencyRA(double money) {
		DecimalFormat decimalFormat = new DecimalFormat(
				DateUtil.CURRENCY_PATTERN);
		String rtnValue = decimalFormat.format(money / 100);
		return initString(' ', 20 - rtnValue.length()) + rtnValue;
	}

	/**
	 * 以分为单位的金额转换为带分节符的左对齐的字符串
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToCurrencyLA(double money) {
		DecimalFormat decimalFormat = new DecimalFormat(
				DateUtil.CURRENCY_PATTERN);
		return decimalFormat.format(money / 100);
	}

	/**
	 * 以分为单位的金额转换为带分节符的左对齐的字符串
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToCurrencyLA4FiveGradeRpt(double money) {
		DecimalFormat decimalFormat = new DecimalFormat(
				DateUtil.CURRENCY_PATTERN);
		return decimalFormat.format(money);
	}

	/**
	 * 以分为单位的金额转换为带分节符的左对齐的字符串;如果为0,返回空串。
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToCurrency(double money) {
		if (money == 0) {
			return "";
		}
		return doubleToCurrencyLA(money);
	}

	/**
	 * 以分为单位的金额转换为带分节符的左对齐的字符串;如果为0,返回空串。
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToCurrency4FiveGradeRpt(double money) {
		if (money == 0) {
			return "";
		}
		return doubleToCurrencyLA4FiveGradeRpt(money);
	}

	/**
	 * 以分为单位的金额转换为不带分节符的右对齐的字符串
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToMoneyRA(double money) {
		DecimalFormat decimalFormat = new DecimalFormat(DateUtil.MONEY_PATTERN);
		String rtnValue = decimalFormat.format(money / 100);
		return initString(' ', 16 - rtnValue.length()) + rtnValue;
	}

	/**
	 * 以分为单位的金额转换为不带分节符的左对齐的字符串
	 *
	 * @param money
	 * @return
	 */
	public static String doubleToMoneyLA(double money) {
		DecimalFormat decimalFormat = new DecimalFormat(DateUtil.MONEY_PATTERN);
		return decimalFormat.format(money / 100);
	}

	/**
	 * 不带分节符的字符串类型的以元为单位的金额转换为以分为单位的金额
	 *
	 * @param money
	 * @return
	 */
	public static double moneyToDouble(String money) {
		if (money == null || money.trim().length() == 0)
			return 0.0;
		return Double.parseDouble(money) * 100;
	}

	/**
	 * 带分节符的字符串类型的以元为单位的金额转换为以分为单位的金额
	 *
	 * @param money
	 * @return
	 */
	public static double currencyToDouble(String money) {
		if (money == null || money.trim().length() == 0)
			return 0.0;
		return Double.parseDouble(money.replaceAll(",", "")) * 100;
	}

	/**
	 * 带分节符的字符串类型的以元为单位的小写金额转换为大写金额
	 *
	 * @param money
	 * @return
	 */
	final public static String currencyToChineseCurrency(String money) {
		char digital;
		StringBuffer _sbAmount = new StringBuffer();
		int _level = money.length() - 2; // 0代表0.01元，1代表0.1元，2代表1元，3代表10元，依次类推
		for (int i = 0; i < money.length(); i++) {
			digital = money.charAt(i);
			if (digital == '.' || digital == ',')
				continue;
			_sbAmount.append(toDigitalInChinese(digital));
			switch (_level) {
			case 0: {
				_sbAmount.append("分整");
				break;
			}
			case 1: {
				_sbAmount.append("角");
				break;
			}
			case 2: {
				_sbAmount.append("元");
				break;
			}
			case 3: {
				_sbAmount.append("拾");
				break;
			}
			case 4: {
				_sbAmount.append("佰");
				break;
			}
			case 5: {
				_sbAmount.append("仟");
				break;
			}
			case 6: {
				_sbAmount.append("万");
				break;
			}
			case 7: {
				_sbAmount.append("拾");
				break;
			}
			case 8: {
				_sbAmount.append("佰");
				break;
			}
			case 9: {
				_sbAmount.append("仟");
				break;
			}
			case 10: {
				_sbAmount.append("亿");
				break;
			}
			case 11: {
				_sbAmount.append("拾");
				break;
			}
			case 12: {
				_sbAmount.append("佰");
				break;
			}
			case 13: {
				_sbAmount.append("仟");
				break;
			}
			case 14: {
				_sbAmount.append("万");
				break;
			}
			case 15: {
				_sbAmount.append("拾");
				break;
			}
			case 16: {
				_sbAmount.append("佰");
				break;
			}
			case 17: {
				_sbAmount.append("仟");
				break;
			}
			case 18: {
				_sbAmount.append("亿");
				break;
			}
			default: {
				_sbAmount.append("※");
			}
			}
			_level--;
		}
		return _sbAmount.toString();
	}

	final private static String toDigitalInChinese(char digital) {
		String _result = "";
		switch (digital) {
		case '0': {
			_result = "零";
			break;
		}
		case '1': {
			_result = "壹";
			break;
		}
		case '2': {
			_result = "贰";
			break;
		}
		case '3': {
			_result = "叁";
			break;
		}
		case '4': {
			_result = "肆";
			break;
		}
		case '5': {
			_result = "伍";
			break;
		}
		case '6': {
			_result = "陆";
			break;
		}
		case '7': {
			_result = "柒";
			break;
		}
		case '8': {
			_result = "捌";
			break;
		}
		case '9': {
			_result = "玖";
			break;
		}
		default: {
			_result = "※";
		}
		}
		return _result;
	}

	/**
	 * 由yyyyMMdd格式的字符串返回日期 java.sql.Date
	 *
	 * @param date
	 * @return
	 */
	public static java.sql.Date numberToSqlDate(String string)
			throws ParseException {
		if (string == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				DateUtil.DATE_NUMBER_PATTERN);

		return new java.sql.Date(simpleDateFormat.parse(string).getTime());

	}

	/**
	 * 由yyyy-MM-dd格式的字符串返回日期
	 *
	 * @param date
	 * @return
	 */
	public static java.util.Date stringToDate(String string)
			throws ParseException {
		if (string == null)
			return null;

		if (string.trim().length() == 0)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return simpleDateFormat.parse(string);

	}

	/**
	 * 创建个人征信的文件
	 *
	 * @param fileName
	 *            文件名
	 * @return String 返回日志文件路径名
	 * @throws Exception
	 */
	public static String createPCFile(String fileName, Date bhdate)
			throws Exception {
		StringBuffer filePathName = new StringBuffer(64); // 日志文件路径及文件名称
		StringBuffer filePath = new StringBuffer(64); // 日志文件路径

		/*
		 * 拼装个人征信文件路径。 文件名组成：征信文件路径/文件名
		 */
		filePath.append(BatchUtil.getBatchProperty(
				BatchConstant.BATCH_PROPERTY_DISPENSE_DATA_PATH, ""));

		String fileSeparator = getFileSeparator();

		// 类似d:\temp\
		filePath.append(fileSeparator).append(DateUtil.dateToString(bhdate))
				.append(fileSeparator);

		/*
		 * 拼装日志文件名。 文件名组成：路径/批量日期/文件名.txt
		 */
		filePathName.append(filePath).append(fileName).append(".txt");

		File file = new File(filePathName.toString()); // 创建这个文件实例对象

		/*
		 * 如果文件不存在，那么创建这个文件
		 */
		if (!file.exists()) {
			File path = new File(filePath.toString());
			if (!path.exists()) {
				path.mkdirs();
			}
			file.createNewFile();
		}

		return filePathName.toString();
	}

	/**
	 * 格式化右对齐
	 *
	 * @param double
	 * @param 长度
	 * @return
	 */
	public static String StringToRight(double amount, int length) {
		DecimalFormat decimalFormat = new DecimalFormat(BatchUtil.MONEY_PATTERN);
		String rtnValue = decimalFormat.format(amount);
		return (initString(' ', length - rtnValue.length()) + rtnValue);
	}

	/**
	 * 格式化右对齐
	 *
	 * @param string
	 * @param 长度
	 * @return
	 */
	public static String StringToRight(String amount, int length) {
		if (amount == null) {
			amount = "";
		}
		String rtnValue = amount;
		return (initString(' ', length - rtnValue.length()) + rtnValue);
	}

	/**
	 * 格式化左对齐
	 *
	 * @param 字符串
	 * @param 长度
	 * @return
	 */
	public static String StringToLeft(String amount, int length) {
		if (amount == null) {
			amount = "";
		}
		String rtnValue = amount;
		rtnValue = rtnValue.replace('|', ' ');
		return (rtnValue + initString(' ', length - rtnValue.getBytes().length));
	}

	/**
	 * 转移状态转换
	 *
	 * @param 状态
	 * @return
	 */
	public static String trmClassConvert(String trmClass) {
		String rtnClass = null;
		switch (trmClass.charAt(0)) {
		case '0':
			rtnClass = "0";
			break;
		case '1':
			rtnClass = "1";
			break;
		case '2':
			rtnClass = "8";
			break;
		case '3':
			rtnClass = "9";
			break;
		case '4':
			rtnClass = "10";
			break;
		case '5':
			rtnClass = "11";
			break;
		}
		return (rtnClass);
	}

	public static String millisecondToString(long time) {
		long tmptime = time;
		int hh = (int) Math.floor(tmptime / (60 * 60 * 1000)); // 小时
		tmptime = tmptime % (60 * 60 * 1000);
		int mm = (int) Math.floor(tmptime / (60 * 1000)); // 分钟
		tmptime = tmptime % (60 * 1000);
		int ss = (int) Math.floor(tmptime / 1000); // 秒
		int millisecond = (int) tmptime % 1000;
		return hh + ":" + mm + ":" + ss + "." + millisecond;
	}

	/**
	 * 查询所有贷款产品列表
	 *
	 * @return ArrayList 贷款产品列表
	 */
	public static ArrayList getAllLnList(Connection conn)
			throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		ArrayList list = new ArrayList();

		String sql = "Select LNID, LN_NAME from LOAN_PARAM WHERE BRCODE = '"
				+ BatchUtil.getHeadBrcode(conn).trim() + "' and FLAG= '"
				+ BatchConstant.FLAG_ON + "' " + "order by lnid ";

		stmt = conn.createStatement(); // 创建statement
		rs = stmt.executeQuery(sql);

		StringBuffer sb = null;

		while (rs.next()) {

			sb = new StringBuffer(128);

			sb.append(BatchUtil.trim(rs.getString(1))).append(",").append(
					BatchUtil.trim(rs.getString(2)));

			list.add(sb.toString());
		}

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return list;
	}

	/**
	 * 得到某日期的七天后的日期
	 *
	 * @param date
	 * @return String
	 */
	public static String get7DaysAfter(Date date) {

		if (date == null) {
			return "";
		}

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DATE, 7);

		return dateToString(new java.sql.Date(ca.getTime().getTime()));
	}

	/**
	 * 得到传入日期的上一月的年月表达式
	 *
	 * @param date
	 * @return 形如：YYYYMM的字符串
	 */
	public static String getPrevMonth(Date date) {

		Calendar ca = Calendar.getInstance();
		java.util.Date prevMonth = null;

		ca.setTime(date);

		ca.add(Calendar.MONTH, -1);

		prevMonth = ca.getTime();

		return dateToNumber(prevMonth).substring(0, 6);
	}

	/**
	 * @Title: 得到中文贷款形态
	 * @Description: 得到中文贷款形态
	 * @param trmClass
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jun 17, 2005 9:35:07 PM
	 */
	public static String getChnTrmClass(String trmClass) {
		if (BatchConstant.TRM_CLASS_NORMAL.equals(trmClass))
			return "正常";
		else if (BatchConstant.TRM_CLASS_OVERDUE.equals(trmClass))
			return "逾期";
		else if (BatchConstant.TRM_CLASS_IDLE.equals(trmClass))
			return "呆滞";
		else if (BatchConstant.TRM_CLASS_BAD.equals(trmClass))
			return "呆帐";
		else if (BatchConstant.TRM_CLASS_CLOSE.equals(trmClass))
			return "结清";
		else if (BatchConstant.TRM_CLASS_LOSS.equals(trmClass))
			return "核销";
		else if (BatchConstant.TRM_CLASS_INVALID.equals(trmClass))
			return "无效";
		return "";
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jun 24, 2005 9:02:24 AM
	 */
	public static String getLineSeparator() {
		return lineSeparator;
	}

	public static Properties getGuatTypeMap(Connection _conn)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		try {
			Properties properties = new Properties();
			String sql = "Select INCODE,OUTCODE, OUTCODE_LEN from DATA_DIC_MAP WHERE MAP_TYPE = "
					+ BatchConstant.DATADIC_MAPTYPE_GUAT_TYPE;
			stmt = _conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String outcode = rs.getString(2).substring(0, rs.getInt(3))
						.trim();
				properties.setProperty(rs.getString("INCODE").trim(), outcode);

			}
			return properties;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}

		}
	}

	public static String getCaller(Throwable throwable) {
		int i;
		StackTraceElement stack[] = throwable.getStackTrace();
		StringBuffer strBuffer = new StringBuffer();
		for (i = 0; i < stack.length; i++) {
			StackTraceElement ste = stack[i];
			if (i != 0)
				// strBuffer.append(BatchUtil.getLineSeparator());
				strBuffer.append("\n");
			strBuffer.append(ste.getClassName() + "." + ste.getMethodName()
					+ " " + i + " " + ste.getFileName() + " "
					+ ste.getLineNumber());
		}
		return strBuffer.toString();

	}

	public static String getCaller() {
		return BatchUtil.getCaller(new Throwable());
	}

	// public static String getDbName() throws IOException {
	// String dbname = BatchUtil.getBatchProperty(
	// BatchConstant.BATCH_PROPERTY_DB_URL, "");
	// int index1 = dbname.lastIndexOf('/');
	// int index2 = dbname.lastIndexOf(':');
	// if (index1 > index2)
	// dbname = dbname.substring(index1 + 1);
	// else
	// dbname = dbname.substring(index2 + 1);
	// return dbname;
	// }

	public static String getDbName() throws IOException {
		String dbname = BatchUtil.getBatchProperty(
				BatchConstant.BATCH_PROPERTY_SHELL_DB_URL, "");
		return dbname;

	}

	/**
	 * @Title: 得到中文合作项目种类名称
	 * @Description: 得到中文合作项目种类名称
	 * @param trmClass
	 * @return
	 * @author Farly.yu
	 * @Created time: Sep 06, 2006 9:35:07 PM
	 */
	public static String getChnProjectType(String projectType) {
		if (BatchConstant.SUBCLASS_PROJ_HOUSE.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_HOUSE + "-住房";
		else if (BatchConstant.SUBCLASS_PROJ_CAR.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_CAR + "-汽车";
		else if (BatchConstant.SUBCLASS_PROJ_PRODUCT.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_PRODUCT + "-消费";
		else if (BatchConstant.SUBCLASS_PROJ_TRIP.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_TRIP + "-旅游";
		else if (BatchConstant.SUBCLASS_PROJ_EDUCATION.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_EDUCATION + "-助学";
		else if (BatchConstant.SUBCLASS_PROJ_CONSIGN.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_CONSIGN + "-委托";
		else if (BatchConstant.SUBCLASS_PROJ_HOUSE_CONSIGN.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_HOUSE_CONSIGN + "-公积金";
		else if (BatchConstant.SUBCLASS_PROJ_ASSURE.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_ASSURE + "-担保";
		else if (BatchConstant.SUBCLASS_PROJ_OTHER.equals(projectType))
			return BatchConstant.SUBCLASS_PROJ_OTHER + "-其他";
		else if (BatchConstant.SUBCLASS_PROJ_SHOP.equals(projectType)) // addedy
			// by
			// teddylu
			// 07-07-31
			return BatchConstant.SUBCLASS_PROJ_SHOP + "-商铺"; // Bocom00020768
		// 增加商铺贷款大类

		return projectType + "-未知";
	}

	/**
	 * 得到序号
	 *
	 * @param conn
	 *            数据库连接
	 * @param brcode
	 *            机构号
	 * @param valueNo
	 *            序号种类
	 * @param valueIndex
	 *            序号索引
	 * @return 当前序号
	 * @throws Exception
	 */
	public static int getSeqno(Connection conn, String brcode, String valueNo,
			String valueIndex) throws Exception {
		int seqNo = 0;
		Statement stmt = null;
		StringBuffer sb = null;
		PreparedStatement psSelSeqctl = null;
		PreparedStatement psUpdSeqctl = null;
		PreparedStatement psInsSeqctl = null;
		ResultSet rs = null;
		ResultSet rsHead = null;
		int maxValue = 0;
		int minValue = 0;
		String branch = BatchUtil.getBranchBrcode(conn, brcode);
		String head = BatchUtil.getHeadBrcode(conn);

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(BatchConstant.STRING_BUFFER_LEN_MID);

			sb.delete(0, sb.length());
			sb
					.append(
							"select VALUE as value, MAX_VALUE as maxValue, MIN_VALUE as minValue ")
					.append("from SEQCTL").append(" where BRCODE = ?").append(
							" and VALUE_NO = ?").append(" and VALUE_INDEX = ?");
			psSelSeqctl = conn.prepareStatement(sb.toString());

			sb.delete(0, sb.length());
			sb.append("update SEQCTL set VALUE = ?")
					.append(" where BRCODE = ?").append(" and VALUE_NO = ?")
					.append(" and VALUE_INDEX = ?");
			psUpdSeqctl = conn.prepareStatement(sb.toString());

			sb.delete(0, sb.length());
			sb
					.append(
							"insert into SEQCTL (ID, BRCODE, VALUE_NO, VALUE_INDEX, VALUE, MAX_VALUE, MIN_VALUE)")
					.append(
							" values (NEXT VALUE FOR SEQCTL_SEQ, ?, ?, ?, ?, ?, ?)");
			psInsSeqctl = conn.prepareStatement(sb.toString());

			psSelSeqctl.setString(1, branch);
			psSelSeqctl.setInt(2, Integer.parseInt(valueNo));
			psSelSeqctl.setString(3, valueIndex);
			rs = psSelSeqctl.executeQuery();

			if (rs.next()) {
				// 如果存在该序号记录，则取出当前序号并将序号加1
				seqNo = rs.getInt("value"); // 得到序号值
				maxValue = rs.getInt("maxValue");
				minValue = rs.getInt("minValue");
				psUpdSeqctl.setInt(1, seqNo + 1); // 序号加1
				if (seqNo + 1 > maxValue)
					psUpdSeqctl.setInt(1, minValue);
				psUpdSeqctl.setString(2, branch);
				psUpdSeqctl.setInt(3, Integer.parseInt(valueNo));
				psUpdSeqctl.setString(4, valueIndex);
				psUpdSeqctl.executeUpdate();
			} else {
				// 如果不存在这样一条记录，那么
				// 首先得到总行号，然后根据总行号、序号种类、序号索引查询对应的序号定义记录，得到默认的最大值和最小值
				// 然后根据当前机构号、序号种类、序号索引、最大值和最小值插入一条新记录，返回序号下限，序号加1
				psSelSeqctl.setString(1, head);
				psSelSeqctl.setInt(2, Integer.parseInt(valueNo));
				psSelSeqctl.setString(3, valueIndex);
				rsHead = psSelSeqctl.executeQuery();
				if (rsHead.next()) {
					seqNo = rsHead.getInt("minValue");
					psInsSeqctl.setString(1, branch);
					psInsSeqctl.setInt(2, Integer.parseInt(valueNo));
					psInsSeqctl.setString(3, valueIndex);
					psInsSeqctl.setInt(4, seqNo + 1);
					psInsSeqctl.setInt(5, rsHead.getInt("maxValue"));
					psInsSeqctl.setInt(6, rsHead.getInt("minValue"));
					psInsSeqctl.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			throw e1;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psSelSeqctl != null)
				psSelSeqctl.close();
			if (psUpdSeqctl != null)
				psUpdSeqctl.close();
			if (psInsSeqctl != null)
				psInsSeqctl.close();
			if (rsHead != null)
				rsHead.close();
		}

		return seqNo;
	}

	/**
	 * 得到申请编号
	 *
	 * @param conn
	 *            数据库连接
	 * @param brcode
	 *            机构号
	 * @param bhdate
	 *            日期
	 * @throws Exception
	 */
	public static String getAppno(Connection conn, String brcode, Date bhdate)
			throws Exception {
		String appno = null;

		try {
			DecimalFormat decimalFormat = new DecimalFormat("000000000");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			appno = brcode.substring(0, 3)
					+ simpleDateFormat.format(bhdate)
					+ decimalFormat.format(BatchUtil.getSeqno(conn, brcode,
							"1", "1"));

		} catch (SQLException e1) {
			throw e1;
		}

		return appno;
	}

	/**
	 * @Title: 根据传入日期得到五级分类表名
	 * @Description: 根据传入日期得到五级分类表名
	 * @param dDate
	 * @return tableName 表名字串
	 * @author Farly.yu
	 * @Created time: Oct 23, 2006 16:35:46 PM
	 */
	public static String getFiveRptTbNmByDate(Connection conn,
			java.util.Date dDate) throws Exception {

		String tableName = null;
		Statement stmt = null;
		StringBuffer sb = null;
		PreparedStatement psSelTbNm = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(BatchConstant.STRING_BUFFER_LEN_MID);

			sb.delete(0, sb.length());
			sb.append("select tablename from f1f2info ").append(
					" where fdate = ?");
			psSelTbNm = conn.prepareStatement(sb.toString());

			psSelTbNm.setString(1, DateUtil.dateToString(dDate));
			rs = psSelTbNm.executeQuery();

			if (rs.next()) {
				tableName = rs.getString(1);
			} else {
				// 设置一个默认表 2006-11-27
				tableName = "TEMP_TABLE";
			}

			// else throw new Exception("该日期["+ DateUtil.dateToString(dDate)
			// +"]的五级分类表名未找到,异常退出!!!!");
		} catch (SQLException e1) {
			throw e1;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psSelTbNm != null)
				psSelTbNm.close();
		}
		return BatchUtil.trim(tableName);
	}

	/**
	 * @Title: 根据数据字典类型编号、数据编号及值类型获取数据值
	 * @author Farly.yu
	 * @created time: Mar 26, 2007
	 * @param conn
	 * @param dataTypeNo
	 * @param dataNo
	 * @param valueType
	 *            1-high_limit 2-low_limit
	 * @return String dataValue
	 * @throws SQLException
	 */
	public static String getDataDicValue(Connection conn, int dataTypeNo,
			String dataNo, int valueType) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null; // 查询结果集
		String dataValue = null;

		StringBuffer sql = new StringBuffer(100);
		sql
				.append(
						"select HIGH_LIMIT, LOW_LIMIT from DATA_DIC where DATA_TYPE_NO=")
				.append(dataTypeNo).append(" AND DATA_NO ='").append(
						BatchUtil.trim(dataNo)).append("' and flag ='").append(
						BatchConstant.FLAG_ON).append("'");

		try {
			stmt = conn.createStatement(); // 创建statement
			rs = stmt.executeQuery(sql.toString());
			if (rs.next()) {
				if (valueType == 1) {
					dataValue = rs.getString(1).trim();
				} else {
					dataValue = rs.getString(2).trim();
				}
			}
		} catch (SQLException e) {
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		if (dataValue == null) {
			return "";
		}
		return dataValue;
	}

	/**
	 * 根据jobno查询表bh_job_info获得BhJobNo对象
	 *
	 * @param conn
	 * @param jobNo
	 * @return
	 * @throws Exception
	 */
	public static BhJobInfo getBhJobInfo(Connection conn, int jobNo)
			throws Exception {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select jobno, pre_jobno, pre_autorun, system_type, runonline, timestamps, miscflgs, misc from bh_job_info where jobno = "
					+ jobNo;

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			BhJobInfo bhJobInfo = new BhJobInfo();

			if (rs.next()) {

				bhJobInfo.setJobNo(rs.getInt("jobno"));
				bhJobInfo.setPreJobNo(rs.getInt("pre_jobno"));
				bhJobInfo.setPreAutoRun(rs.getString("pre_autorun"));
				bhJobInfo.setSystemType(rs.getString("system_type"));
				bhJobInfo.setRunOnLine(rs.getString("runonline"));
				bhJobInfo.setTimestamp(rs.getString("timestamps"));
				bhJobInfo.setMiscflgs(rs.getString("miscflgs"));
				bhJobInfo.setMisc(rs.getString("misc"));
			} else {
				// 该纪录不存在则抛错
				throw new Exception("该jobno号:" + jobNo + "对应的纪录不存在");
			}

			return bhJobInfo;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
	}

	/**
	 * 得到省分行对照表 KEY是指所有的分行,省辖分行 key-分行号 value-对应的省分行号
	 *
	 * @return Hashtable key-分行 value-省分行
	 */
	public static Hashtable getMngBranchMap(Connection _conn)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = _conn.createStatement();
			StringBuffer stSql = new StringBuffer();
			stSql
					.append("select brcode,BLN_MANAGE_BRCODE ")
					.append("from bctl ")
					.append("where RPT_BRCLASS in ('")
					.append(BatchConstant.RPT_BRCLASS_BRANCH)
					.append("','")
					.append(BatchConstant.RPT_BRCLASS_SUB_BRANCH_USEAS_BRANCH)
					.append(
							"') and BLN_BRANCH_BRCODE is not null and BLN_BRANCH_BRCODE<>''");
			rs = stmt.executeQuery(stSql.toString());
			Hashtable hashtable = new Hashtable();
			while (rs.next()) {
				hashtable.put(BatchUtil.trim(rs.getString("BRCODE")), BatchUtil
						.trim(rs.getString("BLN_MANAGE_BRCODE")));
			}
			return hashtable;

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	// ================================add by weikun wang
	// 2008.7.22======================================================================
	/**
	 * Description: 获得与更新SEQCTL[序号控制表]的相关信息
	 *
	 * @param
	 * @return void
	 * @exception Exception
	 * @author weikun wang
	 * @version v1.0,2008-8-7
	 */
	public static void reportProcess(DataWriter reportFile, Object file,
			String beanId, String reportName, String reportFlag)
			throws Exception {
		File fileOver = null;
		String line = null;
		if (!(file instanceof File)) {
			System.out.println("该对象不是文件对象");
		} else {
			fileOver = (File) file;
			ReportCreator repCreator = new ReportCreator(beanId, fileOver);

			// 生产报表标志
			// 1-EXCL报表 genEXCEL(tagReporName);
			// 2-PDF 报表 genPDF(tagReporName);
			// 3-HTML 报表 genHTML(tagReporName);
			// 4-RTF(WORD)报表 getRTF(tagReporName);
			// 5-CVS报表 getCSV(tagReporName);
			// 如：[1-0-1-1-0]
			// 说明产出报表1、3、4对应的报表
			if (reportFlag == null || reportFlag.length() == 0) {
				System.out.println("批处理配置表的生产报表标志设置错误！");
				return;
			}
			String report[] = reportFlag.trim().split("-");
			// 与上面注释对应
			if (report[0].trim().equals("1")) {
				repCreator
						.genEXCEL(reportFile.getReportSavePath() + reportName);
			}
			if (report[1].trim().equals("1")) {
				repCreator.genPDF(reportFile.getReportSavePath() + reportName);
			}
			if (report[2].trim().equals("1")) {
				repCreator.genHTML(reportFile.getReportSavePath() + reportName);
			}
			if (report[3].trim().equals("1")) {
				repCreator.genRTF(reportFile.getReportSavePath() + reportName);
			}
			if (report[4].trim().equals("1")) {
				repCreator.genCSV(reportFile.getReportSavePath() + reportName);
			}

			// 删除格式文件 如：BhOverTracedtlList.txt；

			boolean boo = fileOver.delete();
		}
	}

	public static void initBatchConfig() throws Exception {
		String xmlFiles = "resources/batch/managementReportContext.xml";
		ApplicationContextUtils.init(xmlFiles);
	}

	// =================================add by weikun wang
	// 2008.8.6========================
	/**
	 * Description: 获得与更新SEQCTL[序号控制表]的相关信息
	 *
	 * @param
	 * @return String
	 * @exception SQLException
	 * @author weikun wang
	 * @version v1.0,2008-8-7
	 */
	public static String getSeqnoGenerator(Connection conn, int valueNo,
			String valueIndex, boolean autoFlag) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		int currValue;
		String strCurValue = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select value_curr from SEQCTL where VALUE_NO="
							+ valueNo + " and VALUE_INDEX='" + valueIndex + "'");
			if (rs.next()) {
				currValue = rs.getInt("value_curr");
				DecimalFormat decimalFormat = new DecimalFormat("0000");
				strCurValue = decimalFormat.format(currValue);
			}
		} catch (SQLException sqlex) {
			throw sqlex;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
		if (autoFlag == true) {
			try {
				stmt = conn.createStatement();
				stmt
						.executeUpdate("update SEQCTL set value_curr=value_curr+1 where VALUE_NO="
								+ valueNo
								+ " and VALUE_INDEX='"
								+ valueIndex
								+ "'");
			} catch (SQLException se) {
				throw se;
			} finally {
				if (stmt != null)
					stmt.close();
			}
		}
		conn.commit();
		return strCurValue;
	}

	/**
	 * Description: 获得与更新SEQCTL[序号控制表]的相关信息
	 *
	 * @param
	 * @return void
	 * @exception SQLException
	 * @author weikun wang
	 * @version v1.0,2008-8-7
	 */
	public static void updateSeqCtl(Connection conn, int valueNo,
			String valueIndex, int currValue) throws SQLException {
		Statement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("update SEQCTL set value_curr=" + currValue
					+ " where VALUE_NO=" + valueNo + " and VALUE_INDEX='"
					+ valueIndex + "'");
			conn.commit();
		} catch (SQLException sqlex) {
			throw sqlex;
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	/**
	 * Description: 将数据库库表的所有记录转化为一个list
	 *
	 * @param conn
	 * @param dbTableName
	 *            数据库表名
	 * @return List
	 * @exception
	 * @author weikun wang add
	 * @version v1.0,2008-8-16
	 */
	public static List loadDataFromDBTable(Connection conn, String dbTableName)
			throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List dataList = new ArrayList();
		StringBuffer strBuf = new StringBuffer(100);
		int rsCount = 0;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			strBuf
					.append(
							"Select * from "
									+ dbTableName
									+ " where subStr(BR,4,3)!='951' and subStr(BR,4,3)!='950'")
					// and subStr(BR,4,3)!='600'")
					.append(
							" and subStr(BR,4,3)!='900' and subStr(BR,4,3)!='800' and subStr(BR,4,3)!='777' and subStr(BR,4,3)!='888'")
					.append(
							" and (CLS is null or CLS=' ' or CLS='0' or CLS='1' or CLS='2')");
			rs = stmt.executeQuery(strBuf.toString());
			rsmd = rs.getMetaData();
			String fieldName = null;
			Object fieldValue = null;
			HashMap rcdMap = null;
			while (rs.next()) {
				rsCount++;
				rcdMap = new HashMap();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					fieldName = BatchUtil.trim(rsmd.getColumnName(i));
					fieldValue = rs.getObject(fieldName);
					if (fieldValue instanceof String)
						fieldValue = BatchUtil.trim((String) fieldValue);
					rcdMap.put(fieldName, fieldValue);
				}
				dataList.add(rcdMap);
				if (rsCount % 100 == 0)
					conn.commit();
			}
			conn.commit();
			return dataList;
		} catch (SQLException sqlEcp) {
			sqlEcp.printStackTrace();
			throw sqlEcp;
		} finally {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
	}

	/**
	 * Description: 计算两个日期之间的相隔天数
	 *
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return long
	 * @exception
	 * @author weikun wang
	 * @version v1.0,2008-8-20
	 */
	public static long daysBetweenTwoDate(java.sql.Date startDate,
			java.sql.Date endDate) {
		return (endDate.getTime() - startDate.getTime() / (24 * 60 * 60 * 1000));
	}

	/**
	 * Description: ResultSet 转化为list
	 *
	 * @param
	 * @return List
	 * @exception
	 * @author weikun.wang
	 * @version v1.0,2008-9-24
	 */
	public static List rsToList(ResultSet rs) throws Exception {
		List dataList = new ArrayList();
		HashMap rcdMap = null;
		ResultSetMetaData rsmd = null;
		String fieldName = null;
		Object fieldValue = null;
		try {
			rsmd = rs.getMetaData();
			while (rs.next()) {
				rcdMap = new HashMap();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					fieldName = BatchUtil.trim(rsmd.getColumnName(i));
					fieldValue = rs.getObject(fieldName);
					if (fieldValue instanceof String)
						fieldValue = BatchUtil.trim((String) fieldValue);
					rcdMap.put(fieldName, fieldValue);
				}
				dataList.add(rcdMap);
			}
			return dataList;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public static void close(Statement stmt) throws SQLException {
		stmt.close();
	}

	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}

	public static void close(PreparedStatement ps) throws SQLException {
		ps.close();
	}

	public static void resourceClose(List openedPStmtList, List openedStmtList,
			List openedRsList) throws SQLException {
		for (int i = 0; i < openedStmtList.size(); i++) {
			BatchUtil.close((Statement) openedStmtList.get(i));
		}
		for (int i = 0; i < openedPStmtList.size(); i++) {
			BatchUtil.close((PreparedStatement) openedPStmtList.get(i));
		}
		for (int i = 0; i < openedRsList.size(); i++) {
			BatchUtil.close((ResultSet) openedRsList.get(i));
		}
	}

	// ============add by weikun.wang 2008.10.23=============
	public static String[] split(String inputStr, char pattern) {
		List outputList = new ArrayList();
		String output = "";
		for (int i = 0; i < inputStr.length(); i++) {
			char chr = inputStr.charAt(i);
			if (chr == pattern) {
				outputList.add(output);
				output = "";
			} else {
				output = output + chr;
			}
		}
		outputList.add(output);
		String[] outputArg = new String[outputList.size()];
		return (String[]) (outputList.toArray(outputArg));
	}

	/**
	 *
	 * Description: TODO 返回文件路径，以系统默认路径分割符结尾
	 *
	 * @param
	 * @return String
	 * @exception
	 * @author Robin Suo
	 * @version v1.0,2009-8-12
	 */
	public static String genLocalFilePath(int fileType, int direction)
			throws Exception {
		String sperator = getFileSeparator();
		String root = getBatchProperty(
				BatchConstant.BATCH_PROPERTY_BATCHFILE_PATH, "");
		String type = null;
		String direct = null;

		if (direction == DIRECTION_UPLOAD) {
			direct = BatchConstant.DIRECTION_UPLOAD;
		} else if (direction == DIRECTION_DOWNLOAD) {
			direct = BatchConstant.DIRECTION_DOWNLOAD;
		} else {
			throw new Exception("输入参数错误");
		}

		if (fileType == FILE_TYPE_RPT) {
			type = BatchConstant.FILE_TYPE_RPT;
		} else if (fileType == FILE_TYPE_NET) {
			type = BatchConstant.FILE_TYPE_NET;
		} else if (fileType == FILE_TYPE_CORE) {
			type = BatchConstant.FILE_TYPE_CORE;
		} else if (fileType == FILE_TYPE_ARMS) {
			type = BatchConstant.FILE_TYPE_ARMS;
		} else if (fileType == FILE_TYPE_CMSF) {
			type = BatchConstant.FILE_TYPE_CMSF;
		}else {
			throw new Exception("输入参数错误");
		}
		return root + sperator + direct + sperator + type + sperator;
	}

	//add by hui.liu 20110916 begin
	/**
	 * @desc: 获取文件管理服务器下载IP地址
	 * @return
	 * @throws Exception
	 * @return: String
	 * @Date: 2011-9-16
	 * @Author: hui.liu
	 */
	public static String getFSVRIP() throws Exception {
		String ipString = null;
		ipString = getBatchProperty(BatchConstant.CORE_FILE_PREPERT_KEY_HOST_IP, "");
		if (DataFormat.isEmpty(ipString))
			throw new Exception(BatchConstant.CORE_FILE_PREPERT_KEY_HOST_IP + "属性未设置!");
		return ipString;
	}

	/**
	 * @desc: 获取文件管理服务器下载端口号
	 * @return
	 * @throws Exception
	 * @return: int
	 * @Date: 2008-7-6
	 * @Author: farly.yu
	 */
	public static int getFSVRPort() throws Exception {
		String fsvrPort = null;
		fsvrPort = getBatchProperty(BatchConstant.CORE_FILE_PREPERT_KEY_HOST_PORT, "");
		if (DataFormat.isEmpty(fsvrPort))
			throw new Exception(BatchConstant.CORE_FILE_PREPERT_KEY_HOST_PORT + "属性未设置!");
		int port = Integer.parseInt(fsvrPort);
		return port;
	}

	/**
	 * @desc: 返回文件管理系统远程文件Base目录
	 * @throws Exception
	 * @return: String 返回文件管理系统远程文件Base目录
	 * @Date: 2008-7-29
	 * @Author: Farly.yu
	 */
	public static String getFSVRDownBasePath() throws Exception {
		String basePath = null;
		basePath = getBatchProperty(BatchConstant.CORE_FILE_PREPERT_KEY_DOWN_BASE_PATH, "");
		if (DataFormat.isEmpty(basePath))
			throw new Exception(BatchConstant.CORE_FILE_PREPERT_KEY_DOWN_BASE_PATH + "属性未设置!");
		return basePath;
	}

	//add by hui.liu 20110916 end

	/**
	 * Description: TODO 将文件转换压缩存放
	 *
	 * @param sourceFilePath
	 *            源文件路径设置值（灵活配置）
	 * @param newFilePath
	 *            新文件路径设置值（灵活配置）
	 * @param newFileName
	 *            压缩的文件名不包含 .zip
	 * @author wuzhiwei
	 * @throws Exception
	 */
	public static void mv_Compress(String sourceFilePath, String newFilePath)
			throws Exception {
		// String fileJasperPath = BatchUtil.getBatchProperty(
		// BatchConstant.BATCH_PROPERTY_REPORT_GEN_PATH, "")
		// + File.separator + sourceFilePath;
		File sourceFile = new File(sourceFilePath);
		if (!sourceFile.exists()) {
			throw new Exception("File not Exists!!");
		}
		final int BUFFER = 1024;
		byte[] bytes = new byte[BUFFER];

		// 直接在新目标路径建立i/o并打包
		System.out.println("Adding file: " + sourceFile.getName() + "to zip");

		if (sourceFile.isDirectory()) {
			String[] fl = sourceFile.list();
			for (int i = 0; i < fl.length; i++) {
				File fcur = new File(sourceFile.getAbsolutePath() + "\\"
						+ fl[i]);
				if (!fcur.isDirectory()) {
					FileInputStream fis = new FileInputStream(fcur);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ZipEntry ze = new ZipEntry(fcur.getName());
					String tagerfile = newFilePath + File.separator
							+ fcur.getName() + ".zip"; // + File.separator
					File newFileName = new File(newFilePath);
					if (!newFileName.isDirectory())
						newFileName.mkdir();
					FileOutputStream fos = new FileOutputStream(tagerfile);
					ZipOutputStream zos = new ZipOutputStream(
							new BufferedOutputStream(fos));
					zos.putNextEntry(ze);
					int count = 0;
					while ((count = bis.read(bytes)) != -1) {
						zos.write(bytes);
					}
					bis.close();
					fis.close();

					zos.close();
					fos.close();
					System.out.println("Create File:" + tagerfile);
					System.out.println("OK");
					System.out.println("Begin delete source file:"
							+ fcur.getName());
					if (fcur.delete())// 删除文件,物理操作
						System.out.println("File delete Ok!");
					else
						System.out.println("File not delete !");
				}
			}
		} else {
			FileInputStream fis = new FileInputStream(sourceFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ZipEntry ze = new ZipEntry(sourceFile.getName());
			String tagerfile = null;
			// File file = new File(newFilePath);
			// tagerfile
			// =newFilePath.substring(file.getParent().length()+1,newFilePath.length());
			// tagerfile =
			// (tagerfile.indexOf(".")!=-1?tagerfile.substring(0,tagerfile.indexOf(".")):tagerfile
			// )+ ".zip"; // + File.separator
			// tagerfile = file.getParent()+File.separator+tagerfile ;
			tagerfile = newFilePath + ".zip";
			FileOutputStream fos = new FileOutputStream(tagerfile);
			ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(
					fos));
			zos.putNextEntry(ze);
			int count = 0;
			while ((count = bis.read(bytes)) != -1) {
				zos.write(bytes);
			}
			bis.close();
			fis.close();

			zos.close();
			fos.close();
			System.out.println("Create File:" + tagerfile);
			System.out.println("OK");
			System.out.println("Begin delete source file:"
					+ sourceFile.getName());
			if (sourceFile.delete())// 删除文件,物理操作
				System.out.println("File delete Ok!");
			else
				System.out.println("File not delete !");
		}
	}

	/**
	 * 取得核算时间戳
	 *
	 * @return 时间戳
	 */
	public static String getACETimestamp() {
		return DateUtil.getACETimestamp();
	}

	/**
	 * 处理数据库插入数据不为NULL空的情况，在oracle中"" 为null，特设置为" ";
	 * @param str
	 * @return
	 */
	public static String Nulltrim(String str) {
		if (str == null)
			return " ";
		if (str.length() == 0) {
			return " ";
		}
		return str.trim();
	}

	/**
	 *
	 * @param dbtype  [Oracle   Microsoft SQL Server  DB2/LINUX]
	 * @return
	 * @throws Exception
	 */
	public static String getDbType(String dbtype) throws Exception{
		String TmpDb2="DB2";
		String TmpSqlServer="SQL";
		String TmpOracle="Oracle";
		if((dbtype.indexOf(TmpDb2))!=-1 || (dbtype.indexOf(TmpOracle))!=-1){
			return "1";  //判断数据库平台为DB2 和 ORACLE
		}else if((dbtype.indexOf(TmpSqlServer))!=-1){
			return "2";  //判断数据库平台为SQL SERVER
		}else
			return "0";  //其他平台数据库平台

	}

	/**
	 * DESCRIPTION:得到批量程序值-ID
	 * @author GUIXIU.LIU
	 * @date 2011-12-22
	 * getSeqValue 方法
	 * @param conn
	 * @param seqName
	 * @return
	 * @return
	 */
	public static Object getSeqValue(Connection conn, String seqName) {
		Statement stmt = null;
		ResultSet rs = null;
		String sqlFind = "select " + seqName + ".nextVal from dual";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlFind);
			while (rs != null && rs.next()) {
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}


	/**
	 *
	 * @Description: 获取UUID
	 * @author kangbyron
	 * @Created 2012-8-30下午05:01:09
	 * @return
	 */
	public static String getUUID(){
		return UUIDGenerator.generate();
	}
	
/**
 * 
 * @Description: 判断string是否为空
 * @author wl 
 * @Created 2013-3-22下午1:23:26
 * @param string
 * @return 如果为空则返回true，否则返回true
 */
	public static boolean isEmpty(String string) {
		if (string == null || string.trim().length() == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws Exception {
		CryptionData cryptionData = new CryptionData(
				SystemConstant.DEFAULT_PASSWORD_KEY);
		System.out.println(cryptionData.EncryptionStringData("scf"));
	}
}
