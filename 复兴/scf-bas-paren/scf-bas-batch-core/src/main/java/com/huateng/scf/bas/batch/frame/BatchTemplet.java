/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.frame;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.BeanCopyUtil;
import com.huateng.scf.bas.batch.common.DateUtil;
import com.huateng.scf.bas.batch.common.log.LoggerConstants;
import com.huateng.scf.bas.batch.common.service.ServiceNotFoundException;
import com.huateng.scf.bas.batch.common.service.ServicesPool;
import com.huateng.scf.bas.batch.control.GeneralControl;
import com.huateng.scf.bas.batch.seq.BatchUtils;
import com.huateng.scf.bas.batch.seq.InsertHelper;
import com.huateng.scf.bas.batch.vo.BSysGlobalInfo;
import com.huateng.scf.bas.batch.vo.ThreadVO;


/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 批量模板</p>
 * @author George.Liu
 * @version:  2004-12-18 15:36:05
 *
 *  change activity:
 * @date: 2007-09-04
 * @author farly.yu
 * @description: 修改成从连接池获得连接,在总控中增加了对连接池的初始化
 */

public class BatchTemplet extends Thread {
	/**
	 * 是否已开始运行
	 */
	private boolean start = false;
	/**
	 * 是否分行并行
	 */
	private boolean branchMulit = false;
	/**
	 * 线程在批量列表中的编号
	 */
	private int id;
	/**
	 * 本线程数据信息对象
	 */
	protected ThreadVO vo;
	/**
	 * 分行号，分行并行类批量时使用。
	 */
	private String brcode;
	/**
	 * 批量日     对应GLOBALINFO表中的BHDATE批量日
	 */
	protected  String bhdate = null;
	/**
	 * 交易日     对应GLOBALINFO表中的TBSDY当前会计日期
	 */
	private  String txdate;
	/**
	 * 上一批量日  对应GLOBALINFO表中的BHDATE上一批量日
	 */
	private  String lbhdate;

	/**
	 * 数据库连接
	 */
	protected Connection conn;

	/**
	 * 线程记录文件日志的路径和名称
	 */
	private String logFilePathName;
	/**
	 * 子步骤线程日记记录器
	 */

	private Logger subStepLogger;

	/**
	 * 判断批量日期是否为核心账务系统节假日
	 */

	private boolean coreHoliday = false; //默认为非节假日

	private boolean nextDayHoliday = false;//下一工作日是否节假日
	/**
	 * @return the coreHoliday
	 */
	protected boolean isCoreHoliday() {
		return coreHoliday;
	}

	protected boolean isnextDayHoliday() {
		return nextDayHoliday;
	}

	/**
	 * 带线程id、线程名称的构造（总控拉起该批量时调用）
	 * @param _id 线程在monitor里的序号
	 * @param threadName 线程名称
	 */
	/**
	 * modify by weikun wang 2008.7.15
	 * int _id 改成Integer
	 */
	protected BatchTemplet(Integer _id, String threadName) {
		super(threadName);
		this.id = _id.intValue();
		vo = new ThreadVO();
		conn = null;
		brcode = null;
		logFilePathName = null;
	}

	/**
	 * 带线程id、线程名称和分行号的构造（总控拉起该批量时调用）
	 * @param _id 线程在monitor里的序号
	 * @param threadName 线程名称
	 * @param _brcode 分行号
	 */
	/**
	 * modify by weikun wang 2008.7.15
	 * int _id 改成Integer
	 */
	protected BatchTemplet(Integer _id, String threadName, String _brcode) {
		super(threadName);
		this.id = _id.intValue();
		vo = new ThreadVO();
		conn = null;
		brcode = _brcode;
		logFilePathName = null;
		this.branchMulit = true;
	}

	/**
	 * 带线程id、线程名称和线程数据对象的构造（单独启动该批量时调用）。
	 * 仅当该批量步骤允许单独启动时需要。
	 * @param _id 线程序列号，单独启动时，设置id = -1。
	 * @param threadName 线程名称
	 * @param _vo 已经构建好的该批量步骤信息对象
	 */
	/**
	 * modify by weikun wang 2008.7.15
	 */
//	public BatchTemplet(int _id, String threadName, ThreadVO _vo) {
//		super(threadName);
//		this.id = _id;
//		vo = _vo; // 构建该批量步骤信息对象
//		conn = null;
//		logFilePathName = null;
//
//		// 初始化分行号，不足位前补零
//		DecimalFormat formatter = new DecimalFormat("000000");
//		brcode = formatter.format(vo.getSubstepNo());
//	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	public  void run() {
		this.start = true;
		/*
		 * 从这里开始运行子线程
		 */
		boolean runnable = true; // 本次批量是否可运行
		/*
		 * 该run()方法一定要用try/catch所有例外，更新监视器的线程状态
		 */
		try {

			/*
			 * 首先判断这个线程是由总控启动还是单独启动的,得到vo
			 */
			if (id >= 0) { // 由总控调起
				// 获取该线程对应内存监视器工作列表里的线程对象
				vo =
					(ThreadVO) GeneralControl
						.getGeneralControl()
						.getMonitor()
						.get(
						id);

			}
			/*
			 * 记录线程开始运行时间
			 */
			this.vo.setStartTime(new java.util.Date());

			/* =====================================
			 * 然后取得数据库连接,打开数据库连接
			 */
			//conn = BatchUtil.getConnection();
			//修改成从连接池获取连接 Add by Farly.yu 20070904
			/** add by shen_antonio 20100605 JRIA: BMS-2771 begin .*/
			String connType = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE, "2");
			if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_1, connType)){//use batch database connection[no pool]
				conn = BatchUtil.getConnection();
			}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_2, connType)){//use batch database connection with pool
				conn = ServicesPool.getConnectionPool().get();
			}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_3, connType)){//use application server connection with pool
				conn = BatchUtil.getConnection();
			}else{
				throw new Exception("DataBase_CONN_TYPE is " + connType + ",but it should be 1 , 2 or 3 in batch.properties,please confirm DataBase_CONN_TYPE in DataBase_CONN_TYPE");
			}
			/** add by shen_antonio 20100605 JRIA: BMS-2771 end.*/
			//置成手动提交方式
			conn.setAutoCommit(false);

			/*
			 * 设置批量日和交易日
			 */
			BSysGlobalInfo globalInfo = BatchUtil.getGlobalInfo(conn);
			this.bhdate = globalInfo.getBhdate();
			this.txdate = globalInfo.getTxdate();
			this.lbhdate = globalInfo.getLbhdate();



			/*
			 * 批量开始，创建文件日志，返回日志文件名
			 */
			logFilePathName =
				BatchUtil.createLogFile(this.bhdate.replace("-", ""), vo.getName().trim());
			this.subStepLogger=LoggerConstants.getBatchLogger(logFilePathName);

			/*
			 * 检查该批量是否允许运行，如果已完成或者正在运行，那么不能启动。
			 */
			runnable = this.checkRun(conn, this.bhdate.replace("-", ""), vo);
			if (runnable == false) {
				throw new Exception(
					"URL"
						+ conn.getMetaData().getURL()
						+ BatchUtil.getLineSeparator()
						+ "JOBNO["
						+ vo.getJobNo()
						+ "]STEPNO["
						+ vo.getStepNo()
						+ "]SUBSTEPNO["
						+ vo.getSubstepNo()
						+ "]"
						+ vo.getName()
						+ BatchUtil.getLineSeparator()
						+ "batch process finished,or start failed!"
						+ BatchUtil.getLineSeparator()
						+ "批量已运行完成或正在运行，启动失败！");
			}

			/*
			 * 记内存，在监视器和数据库里设置该线程状态为 运行中
			 */
			vo.setStatus(BatchConstant.THREAD_STATUS_RUNNING);

			/*
			 * 记数据库日志，将该子步骤置为运行中
			 */
			BatchUtil.writeDBLog(conn, vo, this.bhdate.replace("-", ""), "");

			/**
			 * 提交事务避免锁超时
			 */
			conn.commit();

			/*
			 * 记文件日志，记录该子步骤已开始运行
			 */
			StringBuffer log = new StringBuffer(100);
			log
				.append(
					"*******************************************************"
						+ BatchUtil.getLineSeparator())
				.append(
					"* TXDATE:"
						+ this.txdate.replace("-", "")
						+ " BHDATE:"
						+ this.bhdate.replace("-", "")
						+ " LBHDATE:"
						+ this.lbhdate.replace("-", "")
						+ BatchUtil.getLineSeparator())
				.append("* 批量开始运行,开始时间：")
				.append(
					DateUtil.timeToString(this.vo.getStartTime())
						+ BatchUtil.getLineSeparator())
				.append("*******************************************************");
			/**
			 * modify by weikun wang 2008.7.19
			 */
			writeFileLog(log.toString());

			/******* modify by hui.liu 20111105 SCF begin **********/
			/*
			 *  根据bhdate判断是否节假日

			Statement holidaySt = null;
			ResultSet holidayRs = null;
			try{
				String year = bhdate.substring(0, 4);
				String sql = " select * from HOLIDAY where YEAR = "+year;
				holidaySt = conn.createStatement();
				holidayRs = holidaySt.executeQuery(sql);
				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
				Calendar calendar = Calendar.getInstance();
				if ( holidayRs.next()){
					String buffer = holidayRs.getString("HOLIDAY_DEF");
					char[] holidayDef = buffer.toCharArray();
					Date dBhdate = formater.parse(bhdate);
					calendar.setTime(dBhdate);
					int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
					if ( holidayDef[dayOfYear-1] == '0' ){
						//如果这天状态为0;表明是节假日
						this.coreHoliday = true;
					}
				}else{
					log.setLength(0);
					log.append("未找到今年["+year+"]的节假日记录！批量继续运行！");
					System.out.println(log);
					BatchUtil.writeFileLog(this.logFilePathName, log.toString());
				}

				year = txdate.substring(0, 4);
				sql = " select * from HOLIDAY where YEAR = "+year;
				holidaySt = conn.createStatement();
				holidayRs = holidaySt.executeQuery(sql);
				if ( holidayRs.next()){
					String buffer = holidayRs.getString("HOLIDAY_DEF");
					char[] holidayDef = buffer.toCharArray();
					Date dBhdate = formater.parse(txdate);
					calendar.setTime(dBhdate);
					int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
					if ( holidayDef[dayOfYear-1] == '0' ){
						//如果这天状态为0;表明是节假日
						this.nextDayHoliday = true;
					}
				}else{
					log.setLength(0);
					log.append("未找到今年["+year+"]的节假日记录！批量继续运行！");
					System.out.println(log);
					BatchUtil.writeFileLog(this.logFilePathName, log.toString());
				}


			}catch ( Exception ex){
				ex.printStackTrace();
				log.setLength(0);
				log.append("判断节假日错误！批量继续运行");
				System.out.println(log);
				BatchUtil.writeFileLog(this.logFilePathName, log.toString());
			}finally{
				if ( holidayRs != null) holidayRs.close();
				if ( holidaySt != null) holidaySt.close();
			}
			*/
			/******* modify by hui.liu 20111105 SCF begin **********/

			/*
			 * ======================================
			 * 这里做本线程的业务逻辑操作
			 */
			doProcess();
			//doLoop();
			/*
			 * 这里结束本线程的业务逻辑操作
			 * ======================================
			 */
			ThreadVO threadVO = new ThreadVO();
			BeanCopyUtil.getInstance().copyProperties(threadVO, vo);
			threadVO.setStatus(BatchConstant.THREAD_STATUS_FINISHED);

			/*
			 * 记数据库日志，将该子步骤置为已完成
			 */
			BatchUtil.writeDBLog(conn, threadVO, this.bhdate.replace("-", ""), "");
			/**
			 * 提交事务避免锁超时
			 */
			conn.commit();

			/*
			 * 记录线程结束运行时间
			 */
			this.vo.setEndTime(new java.util.Date());
			/*
			 * 记文件日志，记录该子步骤已完成
			 */
			log = new StringBuffer(100);
			log
				.append(
					"*******************************************************"
						+ BatchUtil.getLineSeparator())
				.append("* 批量运行完成,正常结束" + BatchUtil.getLineSeparator())
				.append("* 结束时间:")
				.append(
					DateUtil.timeToString(this.vo.getEndTime())
						+ BatchUtil.getLineSeparator())
				.append("* 批量总用时:")
				.append((this.vo.getEndTime().getTime() - this.vo.getStartTime().getTime()) + "(毫秒) ")
				.append(
					BatchUtil.millisecondToString(
					this.vo.getEndTime().getTime() - this.vo.getStartTime().getTime())
						+ BatchUtil.getLineSeparator())
				.append("*******************************************************");
			/**
			 * modify by weikun wang 2008.7.19
			 */
			writeFileLog(log.toString());
			// 正常完成线程运行任务
			/*
			 * 记内存，在监视器和数据库里设置该线程状态为 完成
			 */
			vo.setStatus(BatchConstant.THREAD_STATUS_FINISHED);
//			if(vo.getStatus().equals(BatchConstant.THREAD_STATUS_FINISHED)){
//				GeneralControl.getGeneralControl().notifyControlThread();
//			}
		} catch (Exception e) {

			try {
				if(conn!=null)
					conn.rollback();//add by weikun wang 2008.8.22
				e.printStackTrace();
				//	线程运行出现异常，被迫中止，记文件日志异常堆栈
				if (logFilePathName != null) {
					writeFileLog(e);
				}
				if (e instanceof java.sql.SQLException){
					java.sql.SQLException sqlE=((SQLException)e).getNextException();
					while (true){
						if (sqlE==null)
							break;
						writeFileLog(sqlE);
						sqlE=sqlE.getNextException();
					}
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}

			try {
				/*
				 * 记数据库日志，将该子步骤置为出错,停止运行
				 * 如果是因为本次批量已完成等CheckRun（）原因出现异常，那么不更新数据库日志
				 */
				ThreadVO threadVO = new ThreadVO();
				BeanUtils.copyProperties(threadVO, vo);
				threadVO.setStatus(BatchConstant.THREAD_STATUS_ERROR);
				if (runnable == true) {
					try {
						BatchUtil.writeDBLog(
							conn,
							threadVO,
							this.bhdate.replace("-", ""),
							e);

					} catch (Exception ew) {
						ew.printStackTrace();
						this.output("记批量日志时出错");
						ServicesPool.getConnectionPool().release(conn);
						conn = ServicesPool.getConnectionPool().get();
						BatchUtil.writeDBLog(conn, threadVO, this.bhdate.replace("-", ""), "");
					}

					/**
					 * 提交事务避免锁超时
					 */
					conn.commit();
				}

				/*
				 * 线程结束运行时间
				 */
				this.vo.setEndTime(new java.util.Date());
				/*
				 * 记文件日志，记录该子步骤已出错
				 */
				StringBuffer log = new StringBuffer(100);

				log
					.append(
						"*******************************************************"
							+ BatchUtil.getLineSeparator())
					.append("* 批量运行出错,异常退出" + BatchUtil.getLineSeparator())
					.append("* 退出时间:")
					.append(
						DateUtil.timeToString(this.vo.getEndTime())
							+ BatchUtil.getLineSeparator())
					.append("* 批量总用时:")
					.append((this.vo.getEndTime().getTime() - this.vo.getStartTime().getTime()) + "(毫秒) ")
					.append(
						BatchUtil.millisecondToString(
							this.vo.getEndTime().getTime() - this.vo.getStartTime().getTime())
							+ BatchUtil.getLineSeparator())
					.append("*******************************************************");

//				BatchUtil.writeFileLog(logFilePathName, log.toString());
				writeFileLog(log.toString());

			} catch (Exception e2) {
				try {
					if (logFilePathName != null) {
						writeFileLog(e);
					}
				} catch (Exception e4) {
					e.printStackTrace();
				}

			} finally {
				/*
				 * 记内存，在监视器和数据库里设置线程状态为 出错,停止运行
				 */
				vo.setErr(e);
				vo.setStatus(BatchConstant.THREAD_STATUS_ERROR);
			}
		} finally {
			/* =======================================
			 * 关闭数据库连接
			 */
			 /*
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			} */
			/** add by shen_antonio 20100605 JRIA: BMS-2771 begin .*/
			try {
				if( conn != null && !conn.isClosed()){
					String connType = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE, "2");
					if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_1, connType)){//use batch database connection[no pool]
						conn.close();
					}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_2, connType)){//use batch database connection with pool
						ServicesPool.getConnectionPool().release(conn);
					}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_3, connType)){//use application server connection with pool
						conn.close();
					}else{
					}
				}else{

				}
			} catch (ServiceNotFoundException e) {
				writeFileLog("************批量联机释放连接失败****************");
				writeFileLog(e);
			} catch (SQLException e) {
				writeFileLog("************关闭连接失败************************");
				writeFileLog(e);
			} catch (IOException e) {
				writeFileLog("************打开配置文件失败,batch.properties************************");
				writeFileLog(e);
			}
			/** add by shen_antonio 20100605 JRIA: BMS-2771 end.*/
			//释放当前连接 Add by Farly.yu 2007-09-04
			//=====================避免死锁,add by weikun wang 2008.8.4================
//			GeneralControl.getGeneralControl().notifyControlThread();
		}
	}

	/**
	 * 业务逻辑处理 方法
	 * @throws Exception
	 */
	protected void doProcess() throws Exception {
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 12, 2005 10:42:30 AM
	 */
	public boolean isStart() {
		return start;
	}

	/**
	 * 写批量子步骤数据库日志
	 * @param conn 数据库连接
	 * @param vo 该子线程数据对象
	 * @return boolean 如果可运行，返回true， 否则返回false
	 * @throws Exception
	 */
	private boolean checkRun(Connection conn, String _bhdate, ThreadVO _vo)
		throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sqlQuery = new StringBuffer(80); // 查询批量日志表sql语句

		try {
			stmt = conn.createStatement(); // 创建statement

			/*
			 * 首先查询日志表是否存在该子线程记录
			 */
			sqlQuery
				.append("Select status from BH_PROC_LOG where bhdate='")
				.append(_bhdate)
				.append("' and jobno = ")
				.append(_vo.getJobNo())
				.append(" and step = ")
				.append(_vo.getStepNo())
				.append(" and sub_step = ")
				.append(_vo.getSubstepNo());
			//System.out.println(sqlQuery.toString());

			rs = stmt.executeQuery(sqlQuery.toString());

			/*
			 * 如果存在，并且已完成或者正在运行，那么不能启动。
			 */
			if (rs.next()) {
				if (rs.getString(1).equals(BatchConstant.THREAD_STATUS_RUNNING)
					|| rs.getString(1).equals(
						BatchConstant.THREAD_STATUS_FINISHED)) {
					return false;
				}
			}

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

		}
		return true;
	}

	public void output(String str) throws IOException {
		String tmp = DateUtil.timeToString(new java.util.Date());
		//System.out.println(tmp+ " JOBNO["+ vo.getJobNo()+ "] STEP["+ vo.getStepNo()+ "] SUB_STEP["+ vo.getSubstepNo()+ "]: "+ str);
		/**
		 * modify by weikun wang 2008.7.19
		 */
		//writeFileLog(tmp + ": " + str);
		this.writeFileLog(tmp+ " JOBNO["+ vo.getJobNo()+ "] STEP["+ vo.getStepNo()+ "] SUB_STEP["+ vo.getSubstepNo()+ "]: "+ str);
	}

	public void debugOutput(String str) throws IOException {
		//临时输出,上线后封掉
		this.output(str);
	}
	/**
	 * @Title: 记录BH_WARNING_LOG表
	 * @Description:
	 * @param contractno
	 * @param peri
	 * @param throwable
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: Jul 14, 2005 3:29:24 PM
	 */
	public void warningDBLog(String contractno,int peri,Throwable throwable) throws Exception{
		PreparedStatement psInsert=null;
		InsertHelper ih = null;
		try{
			BatchUtils.setCurrentDbType();//
			ih = BatchUtils.getInsertHelper(conn, "BH_WARNING_LOG");//
			ih.beginInsert();//
			psInsert = ih.createPrepareStatement("insert into bh_warning_log " +
					"(ID,TXDATE,JOBNO,STEP,SUB_STEP,CONTRACTNO,PERI,MSG,LINE,TIMESTAMPS) " +
			"values(@identity,?,?,?,?,?,?,?,?,?)");
			psInsert.setString(1,this.bhdate.replace("-", ""));
			psInsert.setInt(2,this.vo.getJobNo());
			psInsert.setInt(3,this.vo.getStepNo());
			psInsert.setInt(4,this.vo.getSubstepNo());
			psInsert.setString(5,contractno);
			psInsert.setInt(6,peri);
			String msg=null;
			if (BatchUtil.trim(throwable.getMessage()).length()>1000)
				msg=BatchUtil.trim(throwable.getMessage()).substring(0,1000);
			else msg=BatchUtil.trim(throwable.getMessage());
			psInsert.setString(7,msg);
			String line=BatchUtil.getCaller(throwable);
			if (line.length()>1000)
				line=line.substring(0,1000);
			psInsert.setString(8,line);
			psInsert.setString(9,BatchUtil.getTimestamp());
			ih.endInsert();
			if (psInsert.executeUpdate()!=1)
				throw new Exception("BH_WARNING_LOG插入错误");
			this.output(msg);
		}finally{
			conn.commit();
			if (psInsert!=null)
				psInsert.close();
			if ( ih != null )ih.endInsert();//
		}
	}

	/**
	 * @Title: 记录BH_WARNING_LOG表
	 * @Description:
	 * @param contractno
	 * @param peri
	 * @param _msg
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: Jul 14, 2005 3:29:48 PM
	 */
	public void warningDBLog(String contractno,int peri,String _msg) throws Exception{
		PreparedStatement psInsert=null;
		InsertHelper ih = null;
		try{
			BatchUtils.setCurrentDbType();//
			ih = BatchUtils.getInsertHelper(conn, "BH_WARNING_LOG");//
			ih.beginInsert();//
			psInsert = ih.createPrepareStatement("insert into bh_warning_log " +
				"(ID,TXDATE,JOBNO,STEP,SUB_STEP,CONTRACTNO,PERI,MSG,LINE,TIMESTAMPS) " +
				"values(@identity,?,?,?,?,?,?,?,?,?)");
			psInsert.setString(1,this.bhdate.replace("-", ""));
			psInsert.setInt(2,this.vo.getJobNo());
			psInsert.setInt(3,this.vo.getStepNo());
			psInsert.setInt(4,this.vo.getSubstepNo());
			psInsert.setString(5,contractno);
			psInsert.setInt(6,peri);
			String msg=null;
			if (BatchUtil.trim(_msg).length()>1000)
				msg=BatchUtil.trim(_msg).substring(0,1000);
			else msg=BatchUtil.trim(_msg);
			psInsert.setString(7,msg);
			String line=BatchUtil.getCaller();
			if (line.length()>1000)
				line=line.substring(0,1000);
			psInsert.setString(8,line);
			psInsert.setString(9,BatchUtil.getTimestamp());
			if (psInsert.executeUpdate()!=1)
				throw new Exception("BH_WARNING_LOG插入错误");
			this.output(BatchUtil.trim(_msg));
		}finally{
             conn.commit();
			if (psInsert!=null)
				psInsert.close();
			if ( ih !=null ) ih.endInsert();//
		}
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jun 9, 2005 4:53:59 PM
	 */
	protected boolean isBranchMulit() {
		return branchMulit;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param b
	 * @author Ranger.Mao
	 * @Created time: Jun 9, 2005 4:53:59 PM
	 */
	protected void setBranchMulit(boolean b) {
		branchMulit = b;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Aug 9, 2005 1:39:07 PM
	 */
	//------------add by weikun wang 2008.7.15-----------------------------------------
	/**
	 * 返回线程记录文件日志的路径和名称
	 */
	public String getLogFilePathName() {
		return logFilePathName;
	}

	/**
	 * 返回本线程数据信息对象
	 */
	protected ThreadVO getVo() {
		return vo;
	}
	/**
	 * 返回分行号，分行并行类批量时使用。
	 */
	protected String getBrcode() {
		return brcode;
	}
	/**
	 * 返回批量日
	 */
	protected String getBhdate() {
		return bhdate;
	}

	/**
	 * 返回报表日期：yyyyMMdd
	 * 注意：　由于批量程序中批量日期是Date，而业务表中批量日期是yyyyMMdd,所以这里分开处理。
	 * @return
	 */
	protected String getReportDate()
	{
		return getBhdate();
	}

	/**
	 * 返回报表上一批量工作日期：yyyyMMdd
	 * 注意：　由于批量程序中批量日期是Date，而业务表中批量日期是yyyyMMdd,所以这里分开处理。
	 * @return
	 */
	protected String getPreReportDate()
	{
		return getLbhdate();
	}
	/**
	 * 返回交易日
	 */
	protected String getTxdate() {
		return txdate;
	}
	/**
	 * 返回上一批量日
	 */
	protected String getLbhdate() {
		return lbhdate;
	}
	/**
	 * 返回数据库连接对象
	 */
	protected Connection getConn() {
		return conn;
	}
	//------------add by weikun wang 2008.7.19-----------------------------------------
	/**
	 * @author　weikun wang
	 * @Description 写文件日记
	 *
	 */
	protected void writeFileLog(Object message){
		if(this.subStepLogger!=null){
			if(message instanceof Throwable){
				this.subStepLogger.info(message,(Throwable)message);
			}else{
				this.subStepLogger.info(message);
			}

		}
	}
	/**
	 * Description: 写文件日记
	 * @param
	 * @return void
	 * @exception
	 * @author weikun.wang
	 * @version v1.0,2008-10-30
	 */
	protected void DebugwriteFileLog(Object message){
		if(this.subStepLogger!=null){
			if(message instanceof Throwable){
				this.subStepLogger.debug(message,(Throwable)message);
			}else{
				this.subStepLogger.debug(message);
			}
		}
	}



	/**
	 * 作业号
	 * @return
	 */
	public int getJobNo()
	{
		return this.vo.getJobNo();
	}

	/**
	 * 子步骤号
	 * @return
	 */
	public int getSubstepJobNo(){
		return this.vo.getSubstepNo();
	}
	/**
	 * 步骤号
	 * @return
	 */
	public int getStepNo(){
		return this.vo.getStepNo();
	}

	/**
	 *　获取bh_proc_step 中param 参数
	 * @return
	 */
	public String getProcStepParam()
	{
		return this.getVo().getProcessParam();
	}
	
	/**得到批量程序值-ID
	 * @author zhoujun.hou
	 * @date 2011-12-23
	 * 编辑 getSeqValue 方法的文档注释
	 * @param conn
	 * @param seqName
	 * @return
	 */
	public Object getSeqValue(Connection conn, String seqName) {
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
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
