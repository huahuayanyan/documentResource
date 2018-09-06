/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchThread;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.DateUtil;
import com.huateng.scf.bas.batch.common.log.LoggerConstants;
import com.huateng.scf.bas.batch.common.service.ServicesPool;
import com.huateng.scf.bas.batch.frame.BatchTemplet;
import com.huateng.scf.bas.batch.seq.BatchUtils;
import com.huateng.scf.bas.batch.seq.InsertHelper;
import com.huateng.scf.bas.batch.vo.BSysGlobalInfo;
import com.huateng.scf.bas.batch.vo.Holiday;
import com.huateng.scf.bas.batch.vo.ThreadVO;

/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 批量总控</p>
 * @author George.Liu
 * @version:  2004-12-8 16:23:34
 *
 * change activity:
 * @author farly.yu
 * @date: 2007-09-04
 * @description: 批量使用连接池管理连接,总控对连接池进行管理
 */

public class GeneralControl extends Thread {

	/**
	 * 是否按loaninfo筛选分行并行
	 */
	private boolean chkBranch = true;
	static private final int MAX_PARTITION = 20;
	private int SLEEP = 500; //BatchConstant.BATCH_LOOP_INTERVAL modify by weikun 2008.8.8

	private boolean singleProc = false; //是否单独运行的程序
	private int singleStepNo; //单步
	private int singleSubStepNo; //单子步
	private int singleOldStepNo; //单步跑前BH_PROC_STATUS中STEP号

	// 变量申明
	/**
	 * 是否已开始运行
	 */
	private boolean start = false;
	private Hashtable threadList = new Hashtable();
	private StringBuffer logStr = new StringBuffer(2048);
	private java.util.Date startTime;
	private Holiday holiday = null;
	/**
	 * 本次批量日期
	 */
	private String bhdate = null;
	/**
	 * 本次批量日期
	 */
	private String txdate = null;
	/**
	 * 本次批量日期
	 */
	private String lbhdate = null;
	/**
	 * 系统当前批量运行工作号
	 */
	private int jobNo;
	/**
	 * 当前运行的步骤号
	 */
	private int currStepNo;
	/**
	 * 系统当前步骤号同时运行最大线程数
	 */
	private int maxThreadNum;
	/**
	 * <p>工作队列和线程监视器，是由ThreadVO组成的列表。</p>
	 * <p>子线程运行开始，出错和结束都将更新到监视器，总控程序
	 * 通过查看子线程运行状态调度批量。</p>
	 */
	private ArrayList monitor;
	/**
	 * 当前运行的线程数量
	 */
	private int runningNum;
	/**
	 * 当前步骤中等待运行的线程数量
	 */
	private int waitingNum;
	/**
	 * 本次批量运行模式，新运行或者重新运行
	 */
	private int runningMode;
	/**
	 * 当前批量已开始运行（包括完成、出错）的线程数
	 */
	private int batchCount;
	/**
	 * 中止线程标志：标志是否需要中止该线程
	 */
	private boolean stopFlag;
	/**
	 * 重新运行批量的起始步骤号
	 */
	private int resumeStepNo;

	/**
	 * 线程记录文件日志的路径和名称
	 */
	private String logFilePathName;
	/**
	 * 总控线程日记记录器
	 */
	private Logger controlLogger;
	/**
	 * BH_PARTITION
	 */
	private Hashtable partitionMap;
	/**
	 * 批量总控状态.
	 *
	 * 2005.04.12日 liuzhongwen 增加
	 * 为了能够给拉起总控的客户端返回批量状态
	 */
	private String ctlStatus;

	/**
	 * 批量是否被允许拉起
	 */
	private boolean canRun = true;

	// 构造方法
	/**
	 * 构造方法。
	 */
	private GeneralControl() {
	}

	private static GeneralControl generalControl = null;

	/**
	 * @Title: 启动批量
	 * @Description: 启动批量
	 * @param _name
	 * @param _jobNo
	 * @return
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: May 13, 2005 1:40:40 PM
	 */
	synchronized public static GeneralControl startJob(
		String _name,
		int _jobNo)
		throws Exception {

		if (GeneralControl.generalControl == null) {
			GeneralControl.generalControl = new GeneralControl(_name, _jobNo);
		} else {
			//genc.getjob = job;
			if (GeneralControl.generalControl.isStart()//是否已开始运行,初始化为FALSE
				&& !GeneralControl.generalControl.isAlive())
				GeneralControl.generalControl =
					new GeneralControl(_name, _jobNo);
			else
				throw new Exception("批量总控程序正在运行不能创建");
		}
		GeneralControl.generalControl.start();
		return generalControl;
	}

	/**
	 * @Title: 启动单步批量
	 * @Description: 启动单步批量
	 * @param _name
	 * @param _jobNo
	 * @param _step
	 * @param _subStep
	 * @return
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: May 13, 2005 1:40:40 PM
	 */
	synchronized public static GeneralControl startSingle(
		String _name,
		int _jobNo,
		int _step,
		int _subStep)
		throws Exception {
		if (GeneralControl.generalControl == null) {
			GeneralControl.generalControl =
				new GeneralControl(_name, _jobNo, _step, _subStep);
		} else {
			//genc.getjob = job;
			if (GeneralControl.generalControl.isStart()
				&& !GeneralControl.generalControl.isAlive())
				GeneralControl.generalControl =
					new GeneralControl(_name, _jobNo, _step, _subStep);
			else
				throw new Exception("批量总控程序正在运行不能创建");
		}
		GeneralControl.generalControl.start();
		return generalControl;
	}
	/**
	 * 构造方法。指定总控线程名字和同时运行线程数
	 * @param name 线程名字
	 * @param _jobNo 当前批量工作号
	 */
	private GeneralControl(String name, int _jobNo) {
		super(name);
		this.monitor = new ArrayList();

		this.jobNo = _jobNo;
		this.maxThreadNum = BatchConstant.DEFAULT_MAX_THREAD_NUM;
		// 初始化最大同时运行线程数
		this.runningNum = 0;
		this.waitingNum = 0;
		this.runningMode = 0;
		this.batchCount = 0;
		this.stopFlag = false;
		this.resumeStepNo = -1;
		this.currStepNo = -1; // 当前运行的步骤号,初始化为－1
		this.ctlStatus = BatchConstant.THREAD_STATUS_OPEN;
		this.singleProc = false;
	}

	private GeneralControl(String name, int _jobNo, int _step, int _subStep) {
		super(name);
		this.monitor = new ArrayList();

		this.jobNo = _jobNo;
		this.maxThreadNum = BatchConstant.DEFAULT_MAX_THREAD_NUM;
		// 初始化最大同时运行线程数
		this.runningNum = 0;
		this.waitingNum = 0;
		this.runningMode = 0;
		this.batchCount = 0;
		this.stopFlag = false;
		this.resumeStepNo = -1;
		this.currStepNo = -1; // 当前运行的步骤号,初始化为－1
		this.ctlStatus = BatchConstant.THREAD_STATUS_OPEN;
		this.singleProc = true;
		this.singleStepNo = _step;
		this.singleSubStepNo = _subStep;
	}
	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {//进入run()批量运行才正式开始.
		this.start = true;

		try {
			/*
			 * 记录线程开始运行时间
			 */
			this.startTime = new java.util.Date();
			///////////////////////////////////////////////////////////////////
			/*
			 * 批量开始，创建文件日志，返回日志文件名
			 * 初始化线程监视器和工作队列
			 */
			Connection conn = BatchUtil.getConnection(); // 取得数据库连接
			try {
				BSysGlobalInfo globalInfo = BatchUtil.getGlobalInfo(conn);
				//this.bhdate = globalInfo.getBhdate();
				//this.txdate = globalInfo.getTxdate();
				//this.lbhdate = globalInfo.getLbhdate();
				//modify by davexin 20111223由于批量表中是 char(8)类型的，所以要去掉中间的'-'
				this.bhdate = globalInfo.getBhdate().replace("-", "");
				this.txdate = globalInfo.getTxdate().replace("-", "");
				this.lbhdate = globalInfo.getLbhdate().replace("-", "");

				if (!this.isSingleProc()) {
					logFilePathName =
						BatchUtil.createLogFile(
							this.bhdate,
							currentThread().getName()
								+ "_"
								+ String.valueOf(this.jobNo));
				} else {
					logFilePathName =
						BatchUtil.createLogFile(
							this.bhdate,
							currentThread().getName()
								+ "_"
								+ String.valueOf(this.jobNo)
								+ "_"
								+ String.valueOf(this.singleStepNo)
								+ "_"
								+ String.valueOf(this.singleSubStepNo));
				}
				controlLogger=LoggerConstants.getBatchLogger(logFilePathName);
				this.chkBhProcStatus(conn);
			} finally {
				conn.close();
			}

			holiday = new Holiday(bhdate);

			this.logStr.delete(0, this.logStr.length());
			this.logStr.append(
				"*******************************************************"
					+ BatchUtil.getLineSeparator());
			this.logStr.append(
				"* TXDATE:"
					+ this.txdate
					+ " BHDATE:"
					+ this.bhdate
					+ " LBHDATE:"
					+ this.lbhdate
					+ BatchUtil.getLineSeparator());
			this.logStr.append(
				"* JOBNO     : " + this.jobNo + BatchUtil.getLineSeparator());
			this.logStr.append(
				"* DATABASE  : "
					+ BatchUtil.getBatchProperty(
						BatchConstant.BATCH_PROPERTY_DB_URL,
						"")
					+ BatchUtil.getLineSeparator());
			this.logStr.append(
				"* START TIME: "
					+ DateUtil.timeToString(this.startTime)
					+ BatchUtil.getLineSeparator());
			this.logStr.append("* START MODE: ");
			if (this.runningMode == BatchConstant.BATCH_RUNNING_MODE_RESTART)
				this.logStr.append("RESTART");
			else
				this.logStr.append("NEW");
			this.logStr.append(BatchUtil.getLineSeparator());
			this.logStr.append("* BATCH MODE: ");
			if (this.isSingleProc())
				this.logStr.append("SINGLE MODE");
			else
				this.logStr.append("JOB MODE");
			this.logStr.append(BatchUtil.getLineSeparator());
			this.logStr.append(
				"*******************************************************");
			System.out.println("------logStr="+this.logStr.toString());
			controlLogger.info(this.logStr.toString());
			controlLogger.info(DateUtil.timeToString(new java.util.Date())+ ": " + this.holiday.toString());


			/*
			 * 初始化工作列表
			 */
			if (!this.isSingleProc()) {
				this.initMonitorAndWorkQueue();
			} else {
				this.initSingleMonitorAndWorkQueue();
			}

			/**
			 * 初始化连接池 add 2007-09-04 Farly.yu
			 */
			/** add by shen_antonio 20100605 JRIA: BMS-2771 begin .*/
			String connType = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE, "2");
			if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_1, connType)){//use batch database connection[no pool]
			}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_2, connType)){//use batch database connection with pool
				ServicesPool.initialize();
				System.out.println("初始化连接池成功!");
			}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_3, connType)){//use application server connection with pool
			}else{
				throw new Exception("DataBase_CONN_TYPE is " + connType + ",but it should be 1 , 2 or 3 in batch.properties,please confirm DataBase_CONN_TYPE in DataBase_CONN_TYPE");
			}
			/** add by shen_antonio 20100605 JRIA: BMS-2771 end .*/


			/*
			 * 进入批量总控程序，开始批量运行
			 */
			generalCtl();
			/////////////////////////////////////////////////////////////////

			// 正常完成线程运行任务

			/*
			 * 记数据库日志，将该批量置为已完成
			 */
			if (!this.isSingleProc()){
				this.writeCtlDBLog(
					this.bhdate,
					this.currStepNo,
					BatchConstant.THREAD_STATUS_FINISHED);
			}
			else{
				this.writeCtlDBLog(
					this.bhdate,
					this.singleOldStepNo,
					BatchConstant.THREAD_STATUS_ERROR);
			}
			/*
			 * 记录线程结束运行时间
			 */
			java.util.Date endTime = new java.util.Date();
			/*
			 * 记文件日志，记录该子步骤已完成
			 */
			this.logStr.delete(0, this.logStr.length());
			this.logStr.append(
				"*******************************************************"
					+ BatchUtil.getLineSeparator());
			this.logStr.append("* JOBNO: " + this.jobNo + " 批量运行完成,正常结束!" + BatchUtil.getLineSeparator());
			this.logStr.append(
				"* 结束时间: "
					+ DateUtil.timeToString(endTime)
					+ BatchUtil.getLineSeparator());
			this.logStr.append(
				"* 批量耗时: "
					+ (endTime.getTime() - startTime.getTime())
					+ "(毫秒) "
					+ BatchUtil.millisecondToString(
						endTime.getTime() - startTime.getTime())
					+ BatchUtil.getLineSeparator());
			this.logStr.append(
				"*******************************************************"
					+ BatchUtil.getLineSeparator());
//			BatchUtil.writeFileLog(logFilePathName, this.logStr.toString());
			controlLogger.info(this.logStr.toString());
			/*
			 * 2005.04.12日增加
			 * 记总控状态标志为已完成。
			 * 为了能够给拉起总控的客户端返回批量状态
			 */
			GeneralControl.generalControl = null;
			this.ctlStatus = BatchConstant.THREAD_STATUS_FINISHED;
		} catch (Exception e) {
			try {
				e.printStackTrace();
				//	线程运行出现异常，被迫中止，记文件日志异常堆栈
				controlLogger.error(e.toString());
			}
			catch (Exception e3) {
				e.printStackTrace();
			}

			try {
				/*
				 * 记数据库日志，将该子步骤置为出错,停止运行
				 */
				if (this.canRun == true) {
					if (!this.isSingleProc()){
						this.writeCtlDBLog(
							this.bhdate,
							this.currStepNo,
							BatchConstant.THREAD_STATUS_ERROR);
					}
					else{
						this.writeCtlDBLog(
							this.bhdate,
							this.singleOldStepNo,
							BatchConstant.THREAD_STATUS_ERROR);
					}
				}

				/*
				 * 线程结束运行时间
				 */
				java.util.Date endTime = new java.util.Date();
				/*
				 * 记文件日志，记录批量总用时
				 */
				this.logStr.delete(0, this.logStr.length());
				this.logStr.append(
					"*******************************************************"
						+ BatchUtil.getLineSeparator());
				this.logStr.append(
					"* JOBNO: " + this.jobNo + " 批量运行出错,异常退出!" + BatchUtil.getLineSeparator());
				this.logStr.append(
					"* 退出时间: "
						+ DateUtil.timeToString(endTime)
						+ BatchUtil.getLineSeparator());
				this.logStr.append(
					"* 批量耗时: "
						+ (endTime.getTime() - startTime.getTime())
						+ "(毫秒) "
						+ BatchUtil.millisecondToString(
							endTime.getTime() - startTime.getTime())
						+ BatchUtil.getLineSeparator());
				this.logStr.append(
					"*******************************************************");
				/** add by hui.liu 20111111 批次运行出错提示 begin **/
				System.out.println("批量运行出错,异常退出,请联系系统管理员。");
				/** add by hui.liu 20111111 批次运行出错提示 end **/
				controlLogger.error(this.logStr.toString());
			} catch (Exception e2) {
				try {
					controlLogger.error(e.toString());
				} catch (Exception e4) {
					e.printStackTrace();
				}
			}
			/*
			 * 2005.04.12日增加
			 * 记总控状态标志为已出错。
			 * 为了能够给拉起总控的客户端返回批量状态
			 */

			GeneralControl.generalControl = null;
			this.ctlStatus = BatchConstant.THREAD_STATUS_ERROR;
		} finally {
			/** add by shen_antonio 20100605 JRIA: BMS-2771 begin .*/
			try {
				String connType = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE, "2");
				if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_1, connType)){//use batch database connection[no pool]

				}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_2, connType)){//use batch database connection with pool
					//释放连接池
					try {
						ServicesPool.destroyConnectionPool();
						System.out.println("连接池资源已释放!");
					} catch (Exception e) {
						System.err.println("连接池资源释放出错!");
						e.printStackTrace();
					}
//					System.out.println("初始化连接池成功!");
				}else if(StringUtils.equals(BatchConstant.BATCH_PROPERTY_DataBase_CONN_TYPE_3, connType)){//use application server connection with pool
				}else{
					System.err.println("DataBase_CONN_TYPE is " + connType + ",but it should be 1 , 2 or 3 in batch.properties,please confirm DataBase_CONN_TYPE in DataBase_CONN_TYPE");
				}
			} catch (IOException e) {
				System.err.println("************打开配置文件失败,batch.properties************************");
				e.printStackTrace();
			}
			/** add by shen_antonio 20100605 JRIA: BMS-2771 end .*/
			/** add by hui.liu 20111111 批次正常结束返回0 begin **/
			if(BatchConstant.THREAD_STATUS_FINISHED.equals(ctlStatus)){
				System.out.println(BatchConstant.THREAD_STATUS_SUCCESS);
			}
			/** add by hui.liu 20111111 批次正常结束返回0 end **/
		}
	}

	/**
	 * 批量总控，负责批量控制和线程调度
	 * @throws Exception
	 */
	private  void generalCtl() throws Exception {
		/*
		 * 线程监视器状态标志
		 *  0: 正常，
		 * -1：出错、不可忽略
		 *  1：出错、可忽略
		 */
		int monitorState = 0;
		ArrayList curMonitor;

		/**
		 * 得到partition表,在线程调度中进行partition均匀分配
		 */
//		this.partitionMap = this.getPartitionMap();//HashTable放的是分行号以及该分行所对应的区号的键值对. modify by weikun.wang 2008.11.4 不要分行并行
		/*
		 * 获取批量开始运行步骤号，如果是新运行，那么取得队列的第一个步骤号，
		 * 如果是重新运行，那么取得重新运行的步骤号
		 */
		if (this.runningMode == BatchConstant.BATCH_RUNNING_MODE_NEW) {


			this.currStepNo = this.getNextStepNo(this.currStepNo);//默认返回0
		} else if (
			this.runningMode == BatchConstant.BATCH_RUNNING_MODE_RESTART) {


			this.currStepNo = this.resumeStepNo;
			for (int ii = 0; ii < monitor.size(); ii++) {
				ThreadVO vo = (ThreadVO) monitor.get(ii);
				if (vo.getStepNo() == this.resumeStepNo) {
					/*
					 * 设置该步骤最大运行线程数
					 */
					if (maxThreadNum != vo.getMaxThreadNo()) {
						maxThreadNum = vo.getMaxThreadNo();
					}
					break;
				}
			}
		}


		curMonitor = this.getMonitorList(this.currStepNo);//取出当前step下的所有子步骤．　
		int printCnt = 0;
		java.util.Date tmpStartTime,tmpEndTime;
		tmpStartTime=new java.util.Date();
		while (true) {

			/*
			 * 如果批量被中止，那么退出循环，停止批量总控程序
			 */
			if (stopFlag == true) {
				this.writeLog("批量程序被强行停止,等待程序终止");
				this.waitBatchProc(currStepNo);//等其他批量运行完
				throw new Exception("批量程序被强行停止,批量停止运行!!!");
			}
			printCnt++;

			/*
			 * 每次进入循环，检查线程监视器，查看各子线程运行情况，并打印输出监视器
			 */
			monitorState = checkRunningState(currStepNo);
			/*
			 * :生产环境下可能不需要文件日志里打印monitor，因为内容太多！
			 */
			//BatchUtil.writeFileLog(logFilePathName, monitor.toString());
			/*
			 * 如果其中有子线程出现不可忽略的错误，立即跳出循环，中止总控程序，停止批量。
			 */
			/* ============================
			 * 刘仲文2005.03.23修改。
			 * 出现不可忽略的错误应该抛出异常，让总控的run方法抓住异常，记数据库status表为出错！
			 * ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
			 */
			if (monitorState == -1) {
				//等待其他线程结束后再跳出
				//原因:调用程序如果使用了System.exit()后java虚拟机结束运行所有批量程序同时结束而且没有时间置bh_proc_log
				this.waitBatchProc(currStepNo);
				throw new Exception("批量运行出现不可忽略的错误，批量停止运行!!!");
			}
			/*
			 * 检查批量线程是否异常中断
			 * 原因:如果有异常中断将引起主控死循环
			 */
			if (this.checkError(currStepNo)) {
				//等待其他线程结束后再跳出
				//原因:调用程序如果使用了System.exit()后java虚拟机结束运行所有批量程序同时结束而且没有时间置bh_proc_log
				this.waitBatchProc(currStepNo);
				throw new Exception("批量程序出现严重错误未能正常结束,停止运行!!!");
			}
			if (printCnt == 800) {
				printCnt = 0;
				this.outPutLoop();
			}

			/*
			 * 这里开始线程调度
			 */
			try {
				/*
				 * 1：如果当前运行线程数>=最大线程数，即已经最大线程数在运行，那么等待
				 */
				if (runningNum >= maxThreadNum) {
					Thread.sleep(this.SLEEP);
					/**
					 * modify by weikun wang 2008.7.19
					 */
//					this.waitControlThread();

				}
				/*
				 * 2：如果当前运行线程数大于零 并小于 最大线程数
				 */
				else if (runningNum < maxThreadNum && runningNum > 0) {
					/*
					 * 并且等待的线程数不为零，那么调度运行工作队列中当前步骤号其他等待的线程
					 */
					if (waitingNum > 0) {
						printCnt = 0;
						/*
						 * 运行当前步骤号其他等待的线程
						 */
						this.startWaitedThreads(curMonitor);
						Thread.sleep(this.SLEEP);
//						this.waitControlThread();
					}
					/*
					 * 如果不存在等待的队列，那么总控线程等待其他线程运行完进入下一步骤号
					 */
					else if (waitingNum == 0) {
						Thread.sleep(this.SLEEP);
//						this.waitControlThread();
					}

				}
				/*
				 * 3：如果当前运行的线程数为0
				 */
				else if (runningNum == 0) {
					/*
					 * 但是等待的线程数不为零，那么同样调度运行工作队列中当前步骤号其他等待的线程
					 */
					if (waitingNum > 0) {
						printCnt = 0;
						this.startWaitedThreads(curMonitor);
						Thread.sleep(this.SLEEP);
//						this.waitControlThread();
					}
					/*
					 * 并且等待的线程也是0，说明当前步骤运行结束，立刻进入下一步骤
					 */
					else if (waitingNum == 0) {

						tmpEndTime = new java.util.Date();
						this.writeLog("JOB["+this.jobNo+"] STEP["+this.currStepNo+"] 耗时:"+
						(tmpEndTime.getTime() - tmpStartTime.getTime()) + "(毫秒) "+
						BatchUtil.millisecondToString(tmpEndTime.getTime() - tmpStartTime.getTime()));
						tmpStartTime=new java.util.Date();
						printCnt = 0;

						/*
						 * 取得下一步骤号
						 */
						int tmpNextStepNo = this.getNextStepNo(currStepNo);
						/*
						 * 将当前运行的步骤号设置为下一步骤号
						 */
						if (tmpNextStepNo != -1) {
							currStepNo = tmpNextStepNo;
							curMonitor = this.getMonitorList(currStepNo);
						}
						/*
						 * 如果下一步骤为空，那么整个批量结束，退出循环
						 */
						else {
							break;
						}
					}
				}
			} catch (Exception err) {
				this.waitBatchProc(currStepNo);
				throw err;
			}
		}
	}

	/**
	 * 在运行线程数量小于最大线程数前提下，运行所有当前步骤等待的线程
	 * @param currStepNo 当前运行步骤号
	 * @@throws Exception
	 */
	private void startWaitedThreads(ArrayList curMonitorList)
		throws Exception {
		/*
		 * 在运行线程数量小于最大线程数前提下，运行所有当前步骤等待的线程
		 */
		int[] runningMap = null;
		int[] waitingMap = null;
		while (runningNum < maxThreadNum && waitingNum > 0) {
			Thread batch = null;
			ThreadVO vo = null;
			if (((ThreadVO) curMonitorList.get(0)).isBranchMode()) {
				//分行并行 按PARTITION负载进行分配决策
				if (runningMap == null) {
					runningMap = new int[MAX_PARTITION];
					waitingMap = new int[MAX_PARTITION];
					for (int cnt = 0; cnt < runningMap.length; cnt++) {
						runningMap[cnt] = 0;
						waitingMap[cnt] = 0;
					}
					for (int cnt = 0; cnt < curMonitorList.size(); cnt++) {
						ThreadVO tmpVO = (ThreadVO) curMonitorList.get(cnt);
						int part =
							this.getPartition(
								this.intBrcodeToString(tmpVO.getSubstepNo()));
						if (BatchConstant
							.THREAD_STATUS_RUNNING
							.equals(tmpVO.getStatus())) {
							runningMap[part]++;
						} else if (
							BatchConstant.THREAD_STATUS_OPEN.equals(
								tmpVO.getStatus())) {
							waitingMap[part]++;
						}
					}
				}
				int min = -1;
				//找到当前最小的来运行．哪个区运行的少就运行哪个那个区的等待线程．
				for (int cnt = 0; cnt < runningMap.length; cnt++) {
					if (waitingMap[cnt] > 0) {
						if (min == -1)
							min = cnt;
						else if (runningMap[cnt] < runningMap[min])
							min = cnt;
					}
				}
				/*
				 * modify by weikun wang可以做优化
				 */
				for (int cnt = 0; cnt < curMonitorList.size(); cnt++) {
					vo = (ThreadVO) curMonitorList.get(cnt);
					if (BatchConstant.THREAD_STATUS_OPEN.equals(vo.getStatus())
						&& min//区号相等
							== this.getPartition(
								this.intBrcodeToString(vo.getSubstepNo()))) {
						runningMap[min]++;
						waitingMap[min]--;
						break;
					}
					vo = null;
				}
				if (vo == null)
					throw new Exception(
						"均衡负载分配策略错误 StepNo:"
							+ this.currStepNo
							+ " PARTITION_GROUP:"//区号
							+ min
							+ " runningNum:"
							+ runningNum
							+ "maxThreadNum:"
							+ maxThreadNum
							+ "waitingNum:"
							+ waitingNum);

			} else {
				vo = (ThreadVO) this.monitor.get(this.batchCount);
			}
			if (vo.getStepNo() != this.currStepNo) {
				this.writeLog("工作队列中下一线程所属步骤号与取得的下一步骤号不一致，批量停止运行!!!");
				throw new Exception("步骤号不一致！");
			}
			/**
			 * modify by weikun wang 2008.7.15
			 */
			batch=new BatchThread(vo).newBatchThread();
			vo.setStatus(BatchConstant.THREAD_STATUS_RUNNING);

			if (batch != null) {
				batch.start();
				//为了检查线程异常增加
				this.threadList.put(
					String.valueOf(vo.getStepNo())
						+ "."
						+ String.valueOf(vo.getSubstepNo()),
					batch);
				this.writeLog(vo, "Start!");
			}
			this.batchCount++;

			runningNum++;
			waitingNum--;
		}
	}

	/**
	 * 检查线程监视器，查看子线程运行情况，统计当前步骤号运行和等待的线程数，
	 * 并判断是否有线程出错，是否可忽略
	 * @param stepNo 当前运行步骤号
	 * @return int 0: 正常， -1：出错、不可忽略， 1：出错、可忽略
	 * @throws Exception
	 */
	private int checkRunningState(int stepNo) throws Exception {
		int stateFlag = 0; // 0: 正常， -1：出错、不可忽略， 1：出错、可忽略
		int running = 0; // 统计当前步骤号运行的线程数
		int waiting = 0; // 统计当前步骤号等待的线程数
		ThreadVO vo = null; // 被监控线程对象

		/*
		 * 遍历线程监视器
		 */
		for (Iterator iter = monitor.iterator(); iter.hasNext();) {
			vo = (ThreadVO) iter.next();

			// 只检测当前步骤号的线程运行情况
			if (vo.getStepNo() == stepNo) {
				/*
				 * 判断该线程是否是孤立不受控的线程，
				 * 如果是并且正在运行，则从每次检查要从数据库里读出它的运行状态
				 */
				if (vo.isOrphan()
					&& vo.getStatus().equals(
						BatchConstant.THREAD_STATUS_RUNNING)) {
					String state =
						getOrphanedThreadState(
							vo.getStepNo(),
							vo.getSubstepNo());
					vo.setStatus(state);
				}

				if (vo
					.getStatus()
					.equals(BatchConstant.THREAD_STATUS_FINISHED)&&!vo.isPrint()) {

					vo.setPrint(true);

					if (vo.getStartTime()!=null){

						if (vo.getEndTime()==null)
							vo.setEndTime(new java.util.Date());

						this.writeLog(vo,"耗时:"+
						(vo.getEndTime().getTime() - vo.getStartTime().getTime()) + "(毫秒) "+
						BatchUtil.millisecondToString(
							vo.getEndTime().getTime() - vo.getStartTime().getTime()));
					}
				}
				/*
				 * 判断线程状态
				 */
				if (vo
					.getStatus()
					.equals(BatchConstant.THREAD_STATUS_RUNNING)) {
					running++;
				} else if (
					vo.getStatus().equals(BatchConstant.THREAD_STATUS_OPEN)) {
					waiting++;
				} else if (
					vo.getStatus().equals(BatchConstant.THREAD_STATUS_ERROR)) {
					if (vo
						.getIgnoreFlag()
						.equals(BatchConstant.BATCH_ERROR_IGNORE_NO)) {

						if (vo
							.getErrorType()
							.equals(BatchConstant.BATCH_ERROR_TYPE_NO_ERROR)) {

							this.writeLog(vo, "线程出错、不可忽略");

							if (vo.getErr() != null) {
								try {
									controlLogger.error(vo.getErr());
								} catch (Exception ioe) {
									ioe.printStackTrace();
								}
							}

							vo.setErrorType(BatchConstant.BATCH_ERROR_TYPE_NEW);

						}
						stateFlag = -1;
					}
					/*
					 * 该线程出现错误，但是可忽略
					 */
					else if (
						vo.getIgnoreFlag().equals(
							BatchConstant.BATCH_ERROR_IGNORE_YES)) {
						/*
						 * 如果发现可忽略的新错误线程出现，打印错误信息，并将该线程错误标志设为 新出现错误
						 */
						if (vo
							.getErrorType()
							.equals(BatchConstant.BATCH_ERROR_TYPE_NO_ERROR)) {
							this.writeLog(vo, "线程出错、可忽略");
							vo.setErrorType(BatchConstant.BATCH_ERROR_TYPE_NEW);
							if (vo.getErr() != null) {
								try {
									controlLogger.error(vo.getErr());
								} catch (Exception ioe) {
									ioe.printStackTrace();
								}
								try{
									this.warningDBLog(vo,vo.getErr());
								}catch (Exception e){
									e.printStackTrace();
								}
							}
						}
						/*
						 * 检查到已经是出现过的错误，那么设置为已存在错误。
						 */
						else if (
							vo.getErrorType().equals(
								BatchConstant.BATCH_ERROR_TYPE_NEW)) {
							vo.setErrorType(
								BatchConstant.BATCH_ERROR_TYPE_EXISTS);
						}
						stateFlag = 1;
					}
				}
			}

			/*
			 * 如果读到步骤号大于当前步骤号，停止检查监视器
			 */
			else if (vo.getStepNo() > stepNo) {
				break;
			}

		}
		/*
		 * 将统计的运行和等待线程数更新到全局变量
		 */
		this.runningNum = running;
		this.waitingNum = waiting;

		return stateFlag;
	}

	/**
	 * 根据步骤号和子步骤号从数据库批量日志表里取出该孤立不受控线程的运行状态
	 * @param stepNo
	 * @param subStepNo
	 * @throws Exception
	 */
	private String getOrphanedThreadState(int stepNo, int subStepNo)
		throws Exception {
		String status = null; // 线程状态
		Connection conn = BatchUtil.getConnection(); // 得到数据库连接
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = null; // 查询sql语句

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(100);

			sb
				.append("Select status from BH_PROC_LOG where bhdate='")
				.append(bhdate)
				.append("' and jobno = ")
				.append(jobNo)
				.append(" and step = ")
				.append(stepNo)
				.append(" and sub_step = ")
				.append(subStepNo);

			rs = stmt.executeQuery(sb.toString());

			if (rs.next()) {
				status = rs.getString(1).trim(); // 取得线程状态
			}
			return status;

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
			if (conn != null) {
				conn.close();
			}
//			return status;   modify by weikun wang 2008.8.8
		}
	}

	/**
	 * 取得下一个批量步骤号
	 * @param stepNo 当前批量步骤号
	 * @return int 下一批量步骤号。如果批量完成，返回-1.
	 * @throws Exception
	 */
	private int getNextStepNo(int stepNo) throws Exception {
		/*
		 * 首先判断是不是已经完成批量了
		 */

		if (this.monitor.size() - this.batchCount <= 0) {
			return -1;
		}

		int nextStepNo = 0; // 期望获得的下一步骤号
		ThreadVO vo = null;

		/*
		 * 首先取到监视器里当前步骤号下面一个比自己大的步骤号，
		 * 也就是我们要的下一步骤号，停止循环
		 */
		int i, j;

		for (i = 0; i < monitor.size(); i++) {
			vo = (ThreadVO) monitor.get(i);
			if (vo.getStepNo() > stepNo) {
				nextStepNo = vo.getStepNo();
				/*
				 * 设置该步骤最大运行线程数
				 */
				if (maxThreadNum != vo.getMaxThreadNo()) {
					maxThreadNum = vo.getMaxThreadNo();
				}

				break;
			}
		}

		/*
		 * 继续检查监视器列表里剩余对象，查看是否还有比当前取到的步骤号还小的步骤号
		 * 如果有的话，其实监视器队列已经紊乱了！系统运行将会出错！！！
		 */
		for (j = i; j < monitor.size(); j++) {
			vo = (ThreadVO) monitor.get(j);
			if (vo.getStepNo() < nextStepNo) {
				this.writeLog("线程监视器工作队列排序紊乱!!!");
				throw new Exception("线程监视器工作队列排序紊乱");
			}
		}
		return nextStepNo;
	}

	private ArrayList getMonitorList(int stepNo) throws Exception {
		ArrayList list = new ArrayList();
		boolean isFind = false;
		boolean isBranchMode = false;
		for (int i = 0; i < monitor.size(); i++) {
			ThreadVO vo = (ThreadVO) monitor.get(i);
			if (vo.getStepNo() == stepNo) {
				if (isFind && isBranchMode != vo.isBranchMode())
					throw new Exception("批量步聚表配置错误,分行并行标志错乱,StepNo:" + stepNo);
				isFind = true;
				isBranchMode = vo.isBranchMode();
				list.add(vo);
			}
		}
		return list;
	}
	/**
	 * 初始化线程监视器和工作队列
	 * 这里做批量运行前的准备工作
	 */
	private void initMonitorAndWorkQueue() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		/*
		 * 本次批量开始运行的步骤号
		 * 如果是新运行批量，则从头开始运行，如果是重新运行批量，那么从出错的步骤号开始
		 */
		int startStepNo = -1;
		try {

			conn = BatchUtil.getConnection(); // 取得数据库连接
			stmt = conn.createStatement(); // 创建statement
			Hashtable lnBranchList = null;
			/**
			 * modify by weikun wang 2008.7.15
			 */
//			lnBranchList = this.getLoaninfoBranchList(conn);
			ArrayList errorStepThreadVOList = new ArrayList();
			// 存放日志表里出错步骤号的所有子步骤线程信息

			/*
			 * 如果存在记录，那么说明是重新运行批量
			 * 设置重新开始运行步骤号
			 */
			if (this.runningMode == BatchConstant.BATCH_RUNNING_MODE_RESTART) {

				ThreadVO vo = null; // 用来存放日志表里线程信息对象（包括步骤号、子步骤号和状态等）

				startStepNo = this.currStepNo; // 设置出错步骤号

				/*
				 * 从批量日志表取得该出错步骤的所有已开始运行子步骤状态
				 */
				StringBuffer sqlLog = new StringBuffer(140); // 查询批量日志出错步骤sql语句
				sqlLog
					.append("Select step,sub_step,process_function,status  from BH_PROC_LOG where bhdate = '")
					.append(bhdate)
					.append("' and jobno = ")
					.append(jobNo)
					.append(" and step = ")
					.append(startStepNo);

				rs = stmt.executeQuery(sqlLog.toString());
				/*
				 * 将日志表里取得的该出错步骤信息保存到errorStepThreadVOList
				 */
				while (rs.next()) {
					vo = new ThreadVO();
					vo.setStepNo(rs.getInt(1));
					vo.setSubstepNo(rs.getInt(2));
					vo.setName(rs.getString(3).trim());
					vo.setStatus(rs.getString(4).trim());
					vo.setJobNo(jobNo);
					errorStepThreadVOList.add(vo);
				}
			} else { // 如果没找到记录，说明新运行批量
				/**
				 * modify by weikun wang 2008.7.15
				 */
//				this.updBhProcBrList(conn, lnBranchList);
			}

			/*
			 * 4：从bh_proc_step 和 bctl表读出这次批量需要运行的步骤号和子步骤号，
			 *    如果是重新运行批量，那么读出出错步骤的所有子步骤号，包括可能已运行完的步骤。
			 *    我们在取出记录后再判断是否需要放入线程队列。
			 */

			StringBuffer sqlStep = new StringBuffer(500); // 查询批量步骤号和子步骤号sql语句

			/*
			 * 构造查询语句。
			 * 这里查询出的结果对出错步骤startStepNo未作任何处理，为全部该步骤号的子步骤。
			 * 如果有分行并行批量，这里查询出的分行号强制转为整形数，所以分行号前面的0被自动舍去，
			 * 例如：“021999”查询出为“21999”。需要在传参数进子线程时重新转为6位的字符串。
			 */
			//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
			sqlStep
				.append("Select  s.step, s.sub_step,s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2  from BH_PROC_STEP  s")
				.append(" where s.jobno = ")
				.append(jobNo)
				.append(" and s.step >=")
				.append(startStepNo)
				.append(" and s.sub_flag != '")
				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
				.append("' and s.temp_flag != '")
				.append(BatchConstant.TEMP_FLAG_TRUE)
				/*.append("' union ")
				.append(" Select s.step, CAST(b.br  as INTEGER)  sub_step, s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2 from BH_PROC_STEP  s, ")
 				.append(" (select BRCODE as br from BCTL WHERE BRCODE = BLN_BRANCH_BRCODE and brclass = '")
				.append(BatchConstant.BRCLASS_BRANCH)
//				.append("'  and DELETE_FLAG = '")
//				.append(SystemConstant.FLAG_OFF)
				.append("'  and STATUS = '")
				.append(BatchConstant.FLAG_ON)
				.append("')  b")
				.append(" where s.jobno = ")
				.append(jobNo)
				.append(" and s.step >=")
				.append(startStepNo)
				.append(" and s.sub_flag = '")
				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
				.append("' and s.temp_flag != '")
				.append(BatchConstant.TEMP_FLAG_TRUE)*/
				.append("'  order by step,sub_step ");

//			2009-07-17从DB2更新到SQLSERVER BCTL改为BRANCH_INFO
//			sqlStep
//				.append("Select  s.step, s.sub_step,s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2  from BH_PROC_STEP  s")
//				.append(" where s.jobno = ")
//				.append(jobNo)
//				.append(" and s.step >=")
//				.append(startStepNo)
//				.append(" and s.sub_flag != '")
//				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
//				.append("' and s.temp_flag != '")
//				.append(BatchConstant.TEMP_FLAG_TRUE)
//				.append("' union ")
//				.append(" Select s.step,b.ID  sub_step, s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2 from BH_PROC_STEP  s, ")
//				.append(" (select ID from BRANCH_INFO WHERE ID = BLN_UP_BRH_ID and BRH_CLASS = '")
//				.append(BatchConstant.BRCLASS_BRANCH)
//				.append("'  and STATUS = '")
//				.append(BatchConstant.FLAG_ON)
//				.append("') b")
//				.append(" where s.jobno = ")
//				.append(jobNo)
//				.append(" and s.step >=")
//				.append(startStepNo)
//				.append(" and s.sub_flag = '")
//				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
//				.append("' and s.temp_flag != '")
//				.append(BatchConstant.TEMP_FLAG_TRUE)
//				.append("'  order by step,sub_step ");
			//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end

			System.out.println("GeneralControl:initMonitorAndWorkQueue:1198==sql["+sqlStep.toString());
			this.getMonitorAndWorkQueue(
				conn,
				sqlStep.toString(),
				startStepNo,
				errorStepThreadVOList,
				lnBranchList);

		} finally {

			if (rs!=null)
				rs.close();

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

	}

	/**
	 * 初始化线程监视器和工作队列 批量单步
	 * 这里做批量运行前的准备工作
	 */
	private void initSingleMonitorAndWorkQueue() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		/*
		 * 本次批量开始运行的步骤号
		 * 如果是新运行批量，则从头开始运行，如果是重新运行批量，那么从出错的步骤号开始
		 */
		try {

			conn = BatchUtil.getConnection(); // 取得数据库连接
			stmt = conn.createStatement(); // 创建statement
			Hashtable lnBranchList = null;
			/*
			 * modify by weikun wang 2008.7.15
			 */
//			lnBranchList = this.getLoaninfoBranchList(conn);
			ArrayList errorStepThreadVOList = new ArrayList();
			// 存放日志表里出错步骤号的所有子步骤线程信息

			if (this.runningMode == BatchConstant.BATCH_RUNNING_MODE_RESTART) {

				ThreadVO vo = null; // 用来存放日志表里线程信息对象（包括步骤号、子步骤号和状态等）
				/*
				 * 从批量日志表取得该出错步骤的所有已开始运行子步骤状态
				 */
				StringBuffer sqlLog = new StringBuffer(140); // 查询批量日志出错步骤sql语句
				sqlLog
					.append("Select step,sub_step,process_function,status  from BH_PROC_LOG where bhdate = '")
					.append(this.bhdate)
					.append("' and jobno = ")
					.append(this.jobNo)
					.append(" and step = ")
					.append(this.singleStepNo);

				rs = stmt.executeQuery(sqlLog.toString());
				/*
				 * 将日志表里取得的该出错步骤信息保存到errorStepThreadVOList
				 */
				while (rs.next()) {
					vo = new ThreadVO();
					vo.setStepNo(rs.getInt(1));
					vo.setSubstepNo(rs.getInt(2));
					vo.setName(rs.getString(3).trim());
					vo.setStatus(rs.getString(4).trim());
					vo.setJobNo(jobNo);
					errorStepThreadVOList.add(vo);
				}
			} else { // 如果没找到记录，说明新运行批量
				/*
				 * modify by weikun wang 2008.7.15
				 */
//				this.updBhProcBrList(conn, lnBranchList);
			}

			/*
			 * 4：从bh_proc_step 和 bctl表读出这次批量需要运行的步骤号和子步骤号，
			 *    如果是重新运行批量，那么读出出错步骤的所有子步骤号，包括可能已运行完的步骤。
			 *    我们在取出记录后再判断是否需要放入线程队列。
			 */

			StringBuffer sqlStep = new StringBuffer(500); // 查询批量步骤号和子步骤号sql语句

			/*
			 * 构造查询语句。
			 * 这里查询出的结果对出错步骤startStepNo未作任何处理，为全部该步骤号的子步骤。
			 * 如果有分行并行批量，这里查询出的分行号强制转为整形数，所以分行号前面的0被自动舍去，
			 * 例如：“021999”查询出为“21999”。需要在传参数进子线程时重新转为6位的字符串。
			 */
			//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//原程序
			sqlStep
				.append("Select  s.step, s.sub_step,s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2  from BH_PROC_STEP  s")
				.append(" where s.jobno = ")
				.append(jobNo)
				.append(" and s.step =")
				.append(this.singleStepNo)
				.append(" and s.sub_step=")
				.append(this.singleSubStepNo)
				.append(" and s.sub_flag != '")
				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
				/*.append("' union ")
				.append(" Select s.step, CAST(b.brcode as INTEGER)  sub_step, s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2 from BH_PROC_STEP  s, ")
				.append(" (select BRCODE from BCTL WHERE BRCODE = BLN_BRANCH_BRCODE and brclass = '")
				.append(BatchConstant.BRCLASS_BRANCH)
//				.append("'  and DELETE_FLAG = '")
//				.append(BatchConstant.FLAG_OFF)
				.append("'  and STATUS = '")
				.append(BatchConstant.FLAG_ON)
				.append("')  b")
				.append(" where s.jobno = ")
				.append(jobNo)
				.append(" and s.step =")
				.append(this.singleStepNo)
				.append(" and s.sub_step=")
				.append(this.singleSubStepNo)
				.append(" and s.sub_flag = '")
				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
				*/
				.append("'  order by step,sub_step ");

//2009-07-17从DB2更新到SQLSERVER BCTL改为BRANCH_INFO
//			sqlStep
//				.append("Select  s.step, s.sub_step,s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2  from BH_PROC_STEP  s")
//				.append(" where s.jobno = ")
//				.append(jobNo)
//				.append(" and s.step =")
//				.append(this.singleStepNo)
//				.append(" and s.sub_step=")
//				.append(this.singleSubStepNo)
//				.append(" and s.sub_flag != '")
//				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
//				.append("' union ")
//				.append(" Select s.step,b.ID  sub_step, s.suspend,s.maxproc, s.runtime,s.sub_flag,s.process_function,s.process_param,s.process_tlrno,s.REPORT_FLAG,s.REPORT_DATA_FLAG,s.DESC1,s.DESC2 from BH_PROC_STEP  s, ")
//				.append(" (select ID from BRANCH_INFO WHERE ID = BLN_UP_BRH_ID and BRH_CLASS = '")
//				.append(BatchConstant.BRCLASS_BRANCH)
//				.append("'  and STATUS = '")
//				.append(BatchConstant.FLAG_ON)
//				.append("')  b")
//				.append(" where s.jobno = ")
//				.append(jobNo)
//				.append(" and s.step =")
//				.append(this.singleStepNo)
//				.append(" and s.sub_step=")
//				.append(this.singleSubStepNo)
//				.append(" and s.sub_flag = '")
//				.append(BatchConstant.BRANCH_PARALLEL_BATCH_TRUE)
//				.append("'  order by step,sub_step ");
			//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
			System.out.println("初始化线程 取批量数据表BH_PROC_STEP:"+sqlStep.toString());
			this.getMonitorAndWorkQueue(
				conn,
				sqlStep.toString(),
				this.singleStepNo,
				errorStepThreadVOList,
				lnBranchList);
		} finally {
			if (rs!=null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	private String getThreadName(
		String _className,
		int _jobNo,
		int _step,
		int _subStep) {
		/*
		 * 拼装线程名称,然后设置到vo
		 */
		StringBuffer threadName = new StringBuffer(64);

		String[] tempArr = _className.trim().split("\\.");
		// 类的全名（包括包名）被“.”分割的数组
		String className = tempArr[tempArr.length - 1];
		// 数组中最后一个字符串，就是这个类的类名
		if (this.isSingleProc())
			threadName
				.append(className)
				.append("_SINGLE")
				.append("_")
				.append(_jobNo)
				.append("_")
				.append(_step)
				.append("_")
				.append(_subStep);
		else
			threadName
				.append(className)
				.append("_")
				.append(_jobNo)
				.append("_")
				.append(_step)
				.append("_")
				.append(_subStep);
		return threadName.toString();
	}
	/**
	 * @Title: 根据提供的sql生成工作任务
	 * @Description:
	 * @param conn
	 * @param sqlStr 任务列表sql
	 * @param holidayArray 节假日数据
	 * @param startStepNo 起始stepNo
	 * @param errorStepThreadVOList 过滤的错误
	 * @throws SQLException
	 * @throws Exception
	 * @author Ranger.Mao
	 * @Created time: May 13, 2005 3:13:38 PM
	 */
	private void getMonitorAndWorkQueue(
		Connection conn,
		String sqlStr,
		int startStepNo,
		ArrayList errorStepThreadVOList,
		Hashtable lnBranchList)
		throws SQLException, Exception {

		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement psSelBhProcLog = null;

		try {
			psSelBhProcLog =
				conn.prepareStatement(
					"select STATUS from BH_PROC_LOG where BHDATE='"
						+ this.bhdate
						+ "' and JOBNO=? and STEP=? and SUB_STEP=? ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlStr);

			/*
			 * 这个循环逐条检查查询出的子步骤号是否需要导入本次批量线程队列。
			 * 首先每个子步骤必须根据holidayArray检查当日是否需要运行。
			 * 特别的，对于出错步骤，根据日志表记录该子步骤线程状态，需要做如下分析：
			 *   1：完成，那么不导入线程队列。
			 *   2：运行，那么检查当前该线程此刻是否仍旧运行，做不同处理。
			 *   3：出错，那么检查该线程是否可忽略，如果是，那么不导入；如果不可忽略，那么导入线程队列。
			 */
			int threadCount = 0; // 批量子步骤总计数器，用来确保线程监视器和工作队列的线程保持一致性
			/**
			 * modify by weikun wang 可以做优化
			 */
			while (rs.next()) {
				String runtime = BatchUtil.trim(rs.getString("RUNTIME")); // 该子步骤运行时刻
				int currStepNo = rs.getInt("STEP"); // 该子步骤所属步骤号
				int currSubStepNo = rs.getInt("SUB_STEP"); // 该子步骤号
				String subFlag = rs.getString("SUB_FLAG").trim();
				String desc1 = BatchUtil.trim(rs.getString("DESC1"));
				// 该子步骤分行标志，是否需要分行并行处理
				psSelBhProcLog.setInt(1, jobNo);
				psSelBhProcLog.setInt(2, currStepNo);
				psSelBhProcLog.setInt(3, currSubStepNo);
				ResultSet psRs = null;
				try {
					psRs = psSelBhProcLog.executeQuery();
					if (psRs.next())
						if (BatchConstant
							.THREAD_STATUS_FINISHED
							.equals(psRs.getString("STATUS")))
							continue;
					//已经运行完成的不再运行

				} finally {
					if (psRs != null)
						psRs.close();
				}

				if (this.chkBranch
					&& BatchConstant.FLAG_ON.equals(
						BatchUtil.trim(rs.getString("SUB_FLAG")))) {
					//分行并行过滤
					if (lnBranchList.get(new Integer(rs.getInt("SUB_STEP")))
						== null)
						continue;
					//DESC1 !非
					if (desc1.startsWith("!")) {
						desc1 = desc1.substring(1);
						if (desc1.length() != 0) {
							String[] param = desc1.split(",");
							int ii = 0;
							for (ii = 0; ii < param.length; ii++) {
								if (Integer.parseInt(param[ii])
									== rs.getInt("SUB_STEP"))
									break;
							}
							if (ii < param.length)
								continue;
						}
					}
				}

				/*
				 * 如果该批量日不需要运行该子步骤，取下一条记录
				 * 2005-3-29 Ranger 改为continue
				 */
				if (!this.holiday.checkRun(runtime))
					continue;

				/*
				 * 如果当前批量是重新运行，并且该子步骤所属步骤号为上次出错步骤号，
				 * 那么需要做特别分析处理
				 */
				if (this.runningMode
					== BatchConstant.BATCH_RUNNING_MODE_RESTART
					&& currStepNo == startStepNo) {
					if (this
						.loadErrorStep(
							rs,
							threadCount,
							subFlag,
							currStepNo,
							currSubStepNo,
							errorStepThreadVOList))
						// 如果该子步骤被导入到监视器和队列
						threadCount++; // 子步骤数加1

				} else { // 其他情况下直接导入到线程监视器和工作队列
					ThreadVO vo = new ThreadVO();

					vo.setIgnoreFlag(rs.getString("SUSPEND").trim());
					vo.setMaxThreadNo(rs.getInt("MAXPROC"));
					vo.setTlrno(rs.getString("PROCESS_TLRNO").trim());
					// 设置批量操作员号

					vo.setOrphan(false);
					vo.setStatus(BatchConstant.THREAD_STATUS_OPEN);
					vo.setStepNo(currStepNo);
					vo.setSubstepNo(currSubStepNo);
					vo.setJobNo(jobNo);
					//增加导出报表功能　add by weikun wang 2008.7.22
					vo.setReportFlag(BatchUtil.trim(rs.getString("REPORT_FLAG")));
					vo.setReportDataFlag(BatchUtil.trim(rs.getString("REPORT_DATA_FLAG")));//add by weikun.wang 2008.10.30
					vo.setThreadClassName(
						rs.getString("PROCESS_FUNCTION").trim());
					vo.setProcessParam(
						BatchUtil.trim(rs.getString("PROCESS_PARAM")));
					if (BatchConstant.FLAG_ON.equals(subFlag))
						vo.setBranchMode(true);
					else
						vo.setBranchMode(false);
					vo.setName(
						this.getThreadName(
							vo.getThreadClassName(),
							vo.getJobNo(),
							vo.getStepNo(),
							vo.getSubstepNo()));

					/*
					 * 将子步骤信息加入到线程监视器
					 */
					vo.setCntInMonitor(threadCount);
					monitor.add(threadCount, vo);

					threadCount++; // 子步骤数加1
				}
			}
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psSelBhProcLog != null)
				psSelBhProcLog.close();
		}
	}
	/**
	 * 导入出错步骤的子步骤到线程监视器和工作队列
	 * @param rs 该子步骤结果集
	 * @param threadCount 当前线程在工作队列的序号
	 * @param subFlag 该线程是否需要分行并行运行
	 * @param brcode 分行号
	 * @param stepNo 步骤号
	 * @param subStepNo 子步骤号
	 * @param errorStepThreadVOList 出错步骤记录在日志表的状态信息
	 * @return int 导入子步骤标志，返回true 导入该子步骤；返回false标志不导入该子步骤
	 * @throws Exception
	 */
	private boolean loadErrorStep(
		ResultSet rs,
		int threadCount,
		String subFlag,
		int stepNo,
		int subStepNo,
		ArrayList errorStepThreadVOList)
		throws Exception {

		String logStatus = null; // 日志表记录的该线程状态
		String logThreadName = null; // 日志表记录的该线程名称

		/*
		 * 在errorStepThreadVOList 查询出该子步骤的状态
		 */
		for (int cnt = 0; cnt < errorStepThreadVOList.size(); cnt++) {
			ThreadVO vo = (ThreadVO) errorStepThreadVOList.get(cnt);
			if (vo.getStepNo() == stepNo && vo.getSubstepNo() == subStepNo) {
				logStatus = vo.getStatus().trim();
				logThreadName = vo.getName();
				break;
			}
		}

		/*
		 * 以下根据不同情况决定是否需要将该子步骤导入。
		 *
		 * 1：如果查询到日志中有该记录，并且状态为已完成，
		 * 那么不导入
		 */
		if (logStatus != null
			&& logStatus.equals(BatchConstant.THREAD_STATUS_FINISHED)) {
			return false;
		}
		/*
		 * 2：如果查询到日志记录中该子步骤状态为：出错，
		 * 并且该步骤可忽略，
		 * 那么不导入
		 */
		else if (
			logStatus != null
				&& logStatus.equals(BatchConstant.THREAD_STATUS_ERROR)
				&& rs.getString("SUSPEND").trim().equals(BatchConstant.FLAG_ON)
				&& !this.isSingleProc()){
				return false;
		}
		/*
		 * 3：如果查询到日志记录中该子步骤状态为：运行中，
		 * 并且查询到该线程已不存在，
		 * 并且该线程可忽略，
		 * 那么不导入
		 */
		else if (
			logStatus != null
				&& logStatus.equals(BatchConstant.THREAD_STATUS_RUNNING)
				&& !checkThreadAlive(logThreadName)
				&& rs.getString("SUSPEND").trim().equals(BatchConstant.FLAG_ON)) {
			this.writeLog(logThreadName + " BH_PROC_LOG中正在运行,线程已不存在,被忽略");
			return false;
		}
		/*
		 * 4：如果查询到日志记录中该子步骤状态为：运行中，
		 * 并且查询到该线程还在运行，
		 * 那么导入到线程监视器，置其状态为：运行中,置其标志为游离态！。 导入工作队列一个null对象
		 */
		else if (
			logStatus != null
				&& logStatus.equals(BatchConstant.THREAD_STATUS_RUNNING)
				&& checkThreadAlive(logThreadName)) {

			ThreadVO vo = new ThreadVO();

			vo.setIgnoreFlag(rs.getString("SUSPEND").trim());
			vo.setMaxThreadNo(rs.getInt("MAXPROC"));
			vo.setTlrno(rs.getString("PROCESS_TLRNO").trim()); // 设置批量操作员号

			vo.setOrphan(true); // 置其标志为游离态
			vo.setStatus(BatchConstant.THREAD_STATUS_RUNNING); // 置其状态为运行中
			vo.setStepNo(stepNo);
			vo.setSubstepNo(subStepNo);
			vo.setJobNo(jobNo);
			vo.setThreadClassName(rs.getString("PROCESS_FUNCTION").trim());
			vo.setProcessParam(BatchUtil.trim(rs.getString("PROCESS_PARAM")));
			vo.setReportFlag(BatchUtil.trim(rs.getString("REPORT_FLAG")));//add by weikun.wang 2008.10.30
			vo.setReportDataFlag(BatchUtil.trim(rs.getString("REPORT_DATA_FLAG")));//add by weikun.wang 2008.10.30
			if (BatchConstant.FLAG_ON.equals(subFlag))
				vo.setBranchMode(true);
			else
				vo.setBranchMode(false);
			vo.setName(
				this.getThreadName(
					vo.getThreadClassName(),
					vo.getJobNo(),
					vo.getStepNo(),
					vo.getSubstepNo()));

			/*
			 * 将子步骤信息加入到线程监视器
			 */
			vo.setCntInMonitor(threadCount);
			monitor.add(threadCount, vo);
			throw new Exception(
				logThreadName + " BH_PROC_LOG中正在运行,线程存在,不允许游离态的线程存在");
		}
		/*
		 * 5：其他情况下
		 * 导入子步骤到线程监视器，导入线程到工作队列
		 */
		else {
			ThreadVO vo = new ThreadVO();

			vo.setIgnoreFlag(rs.getString("SUSPEND").trim());
			vo.setMaxThreadNo(rs.getInt("MAXPROC"));
			vo.setTlrno(rs.getString("PROCESS_TLRNO").trim()); // 设置批量操作员号

			vo.setOrphan(false);
			vo.setStatus(BatchConstant.THREAD_STATUS_OPEN);
			vo.setStepNo(stepNo);
			vo.setSubstepNo(subStepNo);
			vo.setJobNo(jobNo);
			vo.setThreadClassName(rs.getString("PROCESS_FUNCTION").trim());
			vo.setProcessParam(BatchUtil.trim(rs.getString("PROCESS_PARAM")));
			vo.setReportFlag(BatchUtil.trim(rs.getString("REPORT_FLAG")));// add by weikun.wang 2008.10.30
			vo.setReportDataFlag(BatchUtil.trim(rs.getString("REPORT_DATA_FLAG")));//add by weikun.wang 2008.10.30
			if (BatchConstant.FLAG_ON.equals(subFlag))
				vo.setBranchMode(true);
			else
				vo.setBranchMode(false);
			vo.setName(
				this.getThreadName(
					vo.getThreadClassName(),
					vo.getJobNo(),
					vo.getStepNo(),
					vo.getSubstepNo()));

			/*
			 * 将子步骤信息加入到线程监视器
			 */
			vo.setCntInMonitor(threadCount);
			monitor.add(threadCount, vo);

		}

		return true;
	}

	/**
	 * 查看某线程是否正在系统中运行
	 * @param logThreadName 线程名称
	 * @return boolean 线程存在并运行中，返回真
	 */
	private boolean checkThreadAlive(String logThreadName) {
		Thread[] arr = new Thread[30]; // 初始化一个线程数组，从来存放当前线程组中的线程
		int num = Thread.enumerate(arr); // 返回当前线程组线程个数

		System.out.println("num=" + num);

		for (int i = 0; i < num; i++) {
			// test
			if (arr[i] != null) {
				System.out.println(
					"arr[" + i + "].getName()=" + arr[i].getName() + "  !ARR!");
			}
			if (arr[i].getName().equals(logThreadName)) {
				return true;
			}
		}

		return false;
	}
	/**
	 * 停止当前批量程序
	 */
	public void stopBatch() {
		System.out.println(
			BatchUtil.getLineSeparator()
				+ BatchUtil.getLineSeparator()
				+ "Enter stopBatch()"
				+ BatchUtil.getLineSeparator()
				+ BatchUtil.getLineSeparator()
				+ BatchUtil.getLineSeparator());
		/*
		 * 首先将总控线程停止
		 */
		stopFlag = true;
		/*
		 * 然后将线程监控器里所有子线程停止
		 */
		for (Iterator iter = monitor.iterator(); iter.hasNext();) {
			ThreadVO vo = (ThreadVO) iter.next();
			vo.setStopFlag(true);
		}

		System.out.println(
			BatchUtil.getLineSeparator()
				+ BatchUtil.getLineSeparator()
				+ "Exit stopBatch()"
				+ BatchUtil.getLineSeparator()
				+ BatchUtil.getLineSeparator()
				+ BatchUtil.getLineSeparator());

	}

	/**
	 * 停止某批量子步骤
	 * @param stepNo 步骤号
	 * @param subStepNo 子步骤号
	 */
	public void stopOneThread(int jobNo, int stepNo, int subStepNo) {
		if (this.jobNo != jobNo)
			return;
		for (Iterator iter = monitor.iterator(); iter.hasNext();) {
			ThreadVO vo = (ThreadVO) iter.next();
			// 找到该子步骤
			if (vo.getStepNo() == stepNo && vo.getSubstepNo() == subStepNo) {
				if (vo
					.getStatus()
					.equals(BatchConstant.THREAD_STATUS_RUNNING)) {
					vo.setStopFlag(true);
				}
				break;
			}
		}
	}

	/**
	 * 写批量总控数据库日志，记录到BH_PROC_STATUS表
	 * @param String status 总控线程状态
	 * @throws SQLException
	 */
	private void writeCtlDBLog(String _bhdate, int _step, String status)
		throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = BatchUtil.getConnection();
			stmt = conn.createStatement(); // 创建statement
			/*
			 * 更新status表中记录批量状态为运行中
			 */
			StringBuffer sqlUpdate = new StringBuffer(100);

			sqlUpdate
				.append("Update BH_PROC_STATUS Set STATUS='")
				.append(status)
				.append("', STEP=")
				.append(_step)
				.append(", END_TIME='")
				.append(BatchUtil.getTimestamp())
				.append("' where bhdate='")
				.append(_bhdate)
				.append("' and jobno = ")
				.append(this.jobNo);

			stmt.executeUpdate(sqlUpdate.toString());

		} finally {
			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 12, 2005 10:41:29 AM
	 */
	private boolean isStart() {
		return start;
	}

	private boolean checkError(int stepNo) throws Exception {
		ThreadVO vo = null; // 被监控线程对象

		/*
		 * 遍历线程监视器
		 */
		for (int cnt = 0; cnt < monitor.size(); cnt++) {
			vo = (ThreadVO) monitor.get(cnt);

			// 只检测当前步骤号的线程运行情况
			if (vo.getStepNo() == stepNo) {
				String key =
					String.valueOf(vo.getStepNo() + "." + vo.getSubstepNo());
				BatchTemplet batchThread =
					(BatchTemplet) this.threadList.get(key);
				/*
				 * 判断该线程是否已经停止而没有将状态置过来,一般是由于线程突出Error引起的
				 */
				if (batchThread != null
				&& !vo.isOrphan()
				&& batchThread.isStart()
				&& !batchThread.isAlive()
				&& !BatchConstant.THREAD_STATUS_ERROR.equals(vo.getStatus())
				&& !BatchConstant.THREAD_STATUS_FINISHED.equals(
				vo.getStatus())) {

					this.writeLog(vo," 出现严重错误未能清理现场,不可忽略,帮助清理现场!");
					this.writeLog(vo," 线程状态 orphan["+vo.isOrphan()+"] start["+batchThread.isStart()+"] alive["+batchThread.isAlive()
					+"] status["+BatchUtil.trim(vo.getStatus())+"] thread_name["+batchThread.getName()+"]");

					vo.setStatus(BatchConstant.THREAD_STATUS_ERROR);
					vo.setEndTime(new java.util.Date());

					Connection conn = null;
					try {
						conn = BatchUtil.getConnection();
						BatchUtil.writeDBLog(
							conn,
							vo,
							this.bhdate,
							"出现严重错误未能清理现场,总控帮助清理现场");
					} finally {
						if (conn != null)
							conn.close();
					}
					vo.setStatus(BatchConstant.THREAD_STATUS_FINISHED);
					return true;
				}

			}

		}
		return false;
	}

	private void waitBatchProc(int stepNo) throws Exception {
		int printCnt = 0;
		while (true) {
			printCnt++;
			if (printCnt == 800) {
				printCnt = 0;
				this.outPutLoop();
			}
			this.checkRunningState(stepNo);
			this.checkError(stepNo);
			if (this.runningNum == 0)
				return;
			Thread.sleep(this.SLEEP * 2);
			//			this.waitControlThread();modify by weikun wang 2008.8.8
		}
	}

	/**
	 * @Title: 返回线程状态
	 * @Description: 返回线程状态
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 12, 2005 3:54:00 PM
	 */
	public String getCtlStatus() {
		if (this.isStart()
			&& !this.isAlive()
			&& !BatchConstant.THREAD_STATUS_ERROR.equals(this.ctlStatus)
			&& !BatchConstant.THREAD_STATUS_FINISHED.equals(this.ctlStatus))
			return BatchConstant.THREAD_STATUS_UNKNOWE_ERROR;
		return ctlStatus;
	}
	private void writeLog(ThreadVO vo, String str) throws IOException {
		this.writeLog(
			"JOB["
				+ vo.getJobNo()
				+ "] STEP["
				+ vo.getStepNo()
				+ "] SUB_STEP["
				+ vo.getSubstepNo()
				+ "] NAME["
				+ vo.getName()
				+ "] "
				+ str);
	}
	private void writeLog(String str) throws IOException {
		String tmp = DateUtil.timeToString(new java.util.Date());
		System.out.println(tmp + " GeneralControl: " + str);
		//BatchUtil.writeFileLog(this.logFilePathName, tmp + ": " + str);
		this.controlLogger.info(tmp + " GeneralControl: " + str);
	}

	private void updBhProcBrList(Connection conn, Hashtable lnBranchList)
		throws Exception {
		PreparedStatement ps = null;
		try {
			StringBuffer branchListSb = new StringBuffer();
			if (lnBranchList!=null)
				for (Iterator iter = lnBranchList.values().iterator();
					iter.hasNext();
					) {
					if (branchListSb.length() > 0)
						branchListSb.append(",");
					branchListSb.append((String) iter.next());
				}

			StringBuffer sqlUpdate = new StringBuffer(100);
			sqlUpdate
				.append("UPDATE BH_PROC_STATUS ")
				.append("set BRANCHLIST=? ")
				.append("where BHDATE=? and JOBNO=? ");
			ps = conn.prepareStatement(sqlUpdate.toString());
			ps.setString(1, branchListSb.toString());
			ps.setString(2, this.bhdate);
			ps.setInt(3, this.jobNo);
			if (ps.executeUpdate() != 1)
				throw new Exception("BH_PROC_STATUS更新错误");
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	private void insBhProcStatus(Connection conn, Hashtable lnBranchList)
		throws Exception {
		PreparedStatement ps = null;
		InsertHelper ih  = null;
		try {
			StringBuffer branchListSb = new StringBuffer();
			if (lnBranchList!=null)
				for (Iterator iter = lnBranchList.values().iterator();
					iter.hasNext();
					) {
					if (branchListSb.length() > 0)
						branchListSb.append(",");
					branchListSb.append((String) iter.next());
				}

			BatchUtils.setCurrentDbType();//
			ih = BatchUtils.getInsertHelper(conn, "BH_PROC_STATUS");//
			ih.beginInsert();//


			StringBuffer sqlInsert = new StringBuffer(100);
			sqlInsert
				.append("INSERT into BH_PROC_STATUS ")
				.append("( ID,")
				.append("BHDATE, JOBNO, STEP, SUB_STEP, PROCESS_FUNCTION,")
				.append("PROCESSID, START_TIME, END_TIME, SUB_FLAG, STATUS,")
				.append("TIMESTAMPS,BRANCHLIST,DESC1,DESC2")
				//.append(") VALUES(@identity,")
				.append(") VALUES("+getSeqValue(conn, "SCF_BATCH_SEQ")+",")
				.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		//	ps = conn.prepareStatement(sqlInsert.toString());
			ps = ih.createPrepareStatement(sqlInsert.toString());
			 // start modify by davexin 2011-12-22
			if(null!=bhdate&&bhdate.length()>8){
	        	bhdate = bhdate.substring(0, 8);
	        }
			//  end modify
			ps.setString(1, this.bhdate);
			ps.setInt(2, this.jobNo);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setString(5, "");
			ps.setInt(6, 0);
			ps.setString(7, DateUtil.getTimestamp());
			ps.setTimestamp(8, null);
			ps.setString(9, BatchConstant.FLAG_ON);
			ps.setString(10, BatchConstant.THREAD_STATUS_RUNNING);
			ps.setString(11, DateUtil.getTimestamp());
			ps.setString(12, branchListSb.toString());
			ps.setString(13, "");
			ps.setString(14, "");
			if (ps.executeUpdate() != 1)
				throw new Exception("BH_PROC_STATUS插入错误");
			ih.endInsert();
		} finally {
			if (ps != null)
				ps.close();
			if ( ih != null) ih.endInsert();
		}
	}

	private String intBrcodeToString(int brcode) {
		DecimalFormat decimalFormat = new DecimalFormat("000000");
		return decimalFormat.format(brcode);
	}
	private Hashtable getLoaninfoBranchList(Connection _conn)
		throws SQLException, IOException {
		Statement stmt = null;
		ResultSet rs = null;
		Hashtable hashtable = null;
		try {
			stmt = _conn.createStatement();
			this.writeLog("取分行列表......");
			rs = stmt.executeQuery(
				//"select distinct bctl.BLN_BRANCH_BRCODE from loaninfo ln,bctl where ln.brcode=bctl.brcode"
	"select distinct PARTITION_KEY from loaninfo ");
			hashtable = new Hashtable();
			while (rs.next()) {
				String brcode = BatchUtil.trim(rs.getString(1));
				hashtable.put(Integer.valueOf(brcode), brcode);
			}
			return hashtable;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
	}
	/**
	 * @Title: 返回静态的GeneralControl
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 13, 2005 11:23:49 AM
	 */
	public static final GeneralControl getGeneralControl() {
		return GeneralControl.generalControl;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 13, 2005 11:36:18 AM
	 */
	public ArrayList getMonitor() {
		return monitor;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 13, 2005 1:37:24 PM
	 */
	private boolean isSingleProc() {
		return singleProc;
	}

	private void outPutLoop() throws IOException {
		Runtime runtime = Runtime.getRuntime();
		this.writeLog(
			"currJobNo="
				+ jobNo
				+ "currStepNo="
				+ currStepNo
				+ ", running="
				+ runningNum
				+ ", waiting="
				+ waitingNum
				+ ", MaxMem="
				+ runtime.maxMemory() / 1024 / 1024
				+ ", TotMem="
				+ runtime.totalMemory() / 1024 / 1024
				+ ", FreeMem="
				+ runtime.freeMemory() / 1024 / 1024);
	}

	private Hashtable getPartitionMap() throws IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Hashtable hashtable = new Hashtable();
		try {
			conn = BatchUtil.getConnection();
			stmt = conn.createStatement();
//			String sql =
//				"select a.BRCODE BRCODE,b.PARTITION_GROUP PARTITION_GROUP from "
//					+ "(select distinct(bln_branch_brcode) BRCODE "
//					+ "from BCTL where BCTL.bln_branch_brcode<>'') a,BH_PARTITION b "
//					+ "where a.BRCODE>=b.PARTITION_S and a.BRCODE<=b.PARTITION_E";

//			2009-07-17从DB2更新到SQLSERVER BCTL改为BRANCH_INFO
			String sql =
				"select a.BRCODE BRCODE,b.PARTITION_GROUP PARTITION_GROUP from "
					+ "(select distinct(BLN_UP_BRH_ID) ID "
					+ "from BRANCH_INFO where BRANCH_INFO.BLN_UP_BRH_ID<>'') a,BH_PARTITION b "
					+ "where a.ID>=b.PARTITION_S and a.ID<=b.PARTITION_E";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer partitionGroup =
					new Integer(rs.getInt("PARTITION_GROUP"));
				String branchBrcode = rs.getString("BRCODE");
				hashtable.put(branchBrcode, partitionGroup);
			}
		} catch (Exception e) {
			this.writeLog(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return hashtable;
	}

	private int getPartition(String str) throws IOException {
		Integer integer = (Integer) this.partitionMap.get(str);
		if (integer == null) {
			this.writeLog(str + " PARTITION配置未设置");
			integer = new Integer(1);
		}
		if (integer.intValue() + 1 > MAX_PARTITION) {
			this.writeLog(str + " PARTITION配置超过" + MAX_PARTITION);
			integer = new Integer(1);
		}
		return integer.intValue();
	}

	public void warningDBLog(ThreadVO _vo,Throwable throwable) throws Exception{
		PreparedStatement psInsert=null;
		Connection conn=null;
		InsertHelper ih = null;
		try{
			conn=BatchUtil.getConnection();
			BatchUtils.setCurrentDbType();//
			ih = BatchUtils.getInsertHelper(conn, "BH_WARNING_LOG");//
			ih.beginInsert();//
			psInsert=ih.createPrepareStatement("insert into bh_warning_log " +
				"(ID,TXDATE,JOBNO,STEP,SUB_STEP,CONTRACTNO,PERI,MSG,LINE,TIMESTAMPS) " +
				"values(@identity,?,?,?,?,?,?,?,?,?)");
			psInsert.setString(1,this.bhdate);
			psInsert.setInt(2,_vo.getJobNo());
			psInsert.setInt(3,_vo.getStepNo());
			psInsert.setInt(4,_vo.getSubstepNo());
			psInsert.setString(5,"");
			psInsert.setInt(6,-1);
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
			if (psInsert.executeUpdate()!=1)
				throw new Exception("BH_WARNING_LOG插入错误");
		}finally{
			if (psInsert!=null)
				psInsert.close();
			if (ih != null ) ih.endInsert();
		}
	}

	public void chkBhProcStatus(Connection _conn) throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		try{
			stmt=_conn.createStatement();
			if (this.isSingleProc()){
				String sqlProcStep =
					"select AUTO from BH_PROC_STEP where JOBNO="
						+ this.jobNo
						+ " and STEP="
						+ this.singleStepNo
						+ " and SUB_STEP="
						+ this.singleSubStepNo;
				rs = stmt.executeQuery(sqlProcStep);
				if (rs.next()) {
					if (rs
						.getString("AUTO")
						.trim()
						.equals(BatchConstant.FLAG_OFF)) {
						this.canRun = false; //批量不允许被拉起
						throw new Exception(
							"JOB["
								+ jobNo
								+ "] STEP["
								+ this.singleStepNo
								+ "] SUB_STEP["
								+ this.singleSubStepNo
								+ "] 不能单独启动");
					}
				} else {
					this.canRun = false; //批量不允许被拉起
					throw new Exception(
						"JOB["
							+ jobNo
							+ "] STEP["
							+ this.singleStepNo
							+ "] SUB_STEP["
							+ this.singleSubStepNo
							+ "] 无该步骤");
				}
				rs.close();
			}

			String sqlStatus =
				"Select step,sub_step,status from BH_PROC_STATUS where jobno = "
					+ jobNo
					+ " and BHDATE='"
					+ bhdate
					+ "' ";

			rs = stmt.executeQuery(sqlStatus);
			if (rs.next()) {
				//modify by hui.liu 20111129 在主批跑完后允许单独拉起
 				if (rs
 					.getString(3)
 					.trim()
 					.equals(BatchConstant.THREAD_STATUS_FINISHED)) {
 					this.canRun = false; //批量不允许被拉起
 					throw new Exception(
 						"JOB["
 							+ jobNo
 							+ "]Batch finished,can't run again"
 							+ BatchUtil.getLineSeparator()
 							+ "批量已完成！不能再运行！");
 				}

				if (rs
					.getString(3)
					.trim()
					.equals(BatchConstant.THREAD_STATUS_RUNNING)) {
					this.canRun = false; //批量不允许被拉起
					throw new Exception(
						"JOB["
							+ jobNo
							+ "]Batch running,can't run again"
							+ BatchUtil.getLineSeparator()
							+ "批量正在运行！不能重复运行！");
				}

				this.runningMode = BatchConstant.BATCH_RUNNING_MODE_RESTART;
				// 设置批量运行模式

				if (this.isSingleProc()){
					this.singleOldStepNo=rs.getInt("STEP");
					this.resumeStepNo = this.singleStepNo; // 设置全局变量 批量重新运行步骤
					System.out.println("------bhdate55555555555555555555555552="+bhdate);
					this.writeCtlDBLog(
						this.bhdate,
						this.singleOldStepNo,
						BatchConstant.THREAD_STATUS_RUNNING);

				}else{
					this.currStepNo = rs.getInt(1);
					this.resumeStepNo = this.currStepNo; // 设置全局变量 批量重新运行步骤
					System.out.println("------bhdate66666666666666666666666666="+bhdate);
					this.writeCtlDBLog(
						this.bhdate,
						this.currStepNo,
						BatchConstant.THREAD_STATUS_RUNNING);
				}


			} else { // 如果没找到记录，说明新运行批量
				this.runningMode = BatchConstant.BATCH_RUNNING_MODE_NEW;
				// 向status表插入新记录
				this.insBhProcStatus(_conn, null);
			}
		}finally{
			if (stmt!=null)
				stmt.close();
			if (rs!=null)
				rs.close();
		}
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



}
