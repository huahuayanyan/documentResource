/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.frame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.DateUtil;
import com.huateng.scf.bas.batch.vo.BSysGlobalInfo;
import com.huateng.scf.bas.batch.vo.ThreadVO;
/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 子线程模板</p>
 * <p>支持在一个批量单步骤中的多线程并行。</p>
 * <p>业务逻辑派生于ThreadTemplet并覆盖doProcess业务逻辑方法。</p>
 * <p>线程控制器负责调度这些并发的线程。</p>
 * @author ranger
 * @version:  2006-12-31 14:00:00
 * @see com.huateng.scf.bas.batch.common.BhThreadControl
 */

public class ThreadTemplet extends Thread {
	/**
	 * 是否已开始运行
	 */
	private boolean start = false;
	/**
	 * 与线程控制器通信交互对象
	 */
	protected ThreadVO vo;
	/**
	 * 线程记录文件日志的路径和名称
	 */
	protected String logFilePathName;

	/**
	 * globalinfo信息
	 */
	protected BSysGlobalInfo globalInfo = null;

	/**
	 * 线程参数由构造器传入
	 */
	protected Object param = null;

	/**
	 * 不用的构造器
	 */
	private ThreadTemplet() {
	}

	/**
	 * 由线程控制器调用的构造器
	 * @param _vo 与线程控制器通信交互对象
	 * @param _globalInfo globalinfo信息
	 * @param _obj 子线程运行参数对象
	 */
	public ThreadTemplet(ThreadVO _vo, String _logFilePathName, Object _obj) {
		super(_vo.getName());
		vo = _vo;
		logFilePathName = _logFilePathName;
		this.param = _obj;
	}

	/**
	 * 启动线程，并调用doProcess方法
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.start = true;
		/*
		 * 从这里开始运行子线程
		 */

		/*
		 * 该run()方法一定要用try/catch所有例外，更新监视器的线程状态
		 */
		try {

			/*
			 * 记录线程开始运行时间
			 */
			this.vo.setStartTime(new java.util.Date());

			/*
			 * 批量开始，创建文件日志，返回日志文件名
			 */
			//			this.logFilePathName =//
			//				BatchUtil.createLogFile(//
			//					this.globalInfo.getBhdate(),//
			//					vo.getName().trim());

			/*
			 * 记内存，在监视器和数据库里设置该线程状态为 运行中
			 */
			this.vo.setStatus(BatchConstant.THREAD_STATUS_RUNNING);

			/*
			 * ======================================
			 * 这里做本线程的业务逻辑操作
			 */
			doProcess();

			/*
			 * 记录线程结束运行时间
			 */
			this.vo.setEndTime(new java.util.Date());
			this.vo.setStatus(BatchConstant.THREAD_STATUS_FINISHED);
			this.start = false; // modify by yjb  线程终止

		} catch (Exception e) {
			try {
				e.printStackTrace();
				this.output("线程出错:");
				//	线程运行出现异常，被迫中止，记文件日志异常堆栈
				if (logFilePathName != null) {
					PrintWriter printWriter =
						new PrintWriter(
							new BufferedWriter(
								new FileWriter(logFilePathName, true)));
					e.printStackTrace(printWriter);
					printWriter.close();
				}
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			/*
			 * 线程结束运行时间
			 */
			this.vo.setEndTime(new java.util.Date());
			this.start = false;
			vo.setErr(e);
			vo.setStatus(BatchConstant.THREAD_STATUS_ERROR);
		}
	}

	/**
	 * 业务逻辑处理 方法
	 * 覆盖此方法
	 * @throws Exception
	 */
	protected void doProcess() throws Exception {
	}

	/**
	 * 线程是否已经运行
	 * @return true:已经运行 false:未运行
	 */
	public boolean isStart() {
		return start;
	}

	/**
	 * 得到日志文件全路径
	 * @return 日志文件全路径
	 */
	public String getLogFilePathName() {
		return logFilePathName;
	}

	/**
	 * 输出至日志文件和标准输出
	 * @param str 输出字符串
	 * @throws IOException
	 */
	protected void output(String str) throws IOException {
		String tmp = DateUtil.timeToString(new java.util.Date());
		System.out.println(tmp + this.getName() + ":" + str);
		try{
		BatchUtil.writeFileLog(
			this.logFilePathName,
			tmp + this.getName() + ":" + str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 调试信息输出至日志文件和标准输出
	 * @param str 输出字符串
	 * @throws IOException
	 */
	protected void debugOutput(String str) throws IOException {
		//临时输出,上线后封掉
		this.output(str);
	}


	/**	 * @return	 */
	public ThreadVO getVo() {
		return vo;
	}


}
