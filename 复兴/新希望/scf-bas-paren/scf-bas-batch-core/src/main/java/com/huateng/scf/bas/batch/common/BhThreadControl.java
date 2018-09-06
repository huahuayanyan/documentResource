/*
 * Created on Dec 29, 2006
 *
 */
package com.huateng.scf.bas.batch.common;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.huateng.scf.bas.batch.frame.ThreadTemplet;
import com.huateng.scf.bas.batch.vo.ThreadVO;

/**
 * <p>线程控制器,可供批量程序调用。
 * <p>当步骤表线程并发不能满足要求时可以使用这个线程控制器对象控制多个任意线程并发。</p>
 * <p>线程控制器负责调度线程队列直至运行结束。</p>
 * <p>线程控制器只负责调度线程，各个线程的事务处理，断点故障恢复需要自己解决。</p>
 * <p>由线程控制器调度的子线程必须派生于</p>
 * @author ranger
 * @see com.huateng.scf.bas.batch.frame.ThreadTemplet
 */

public class BhThreadControl {
	private int maxThreadNum = 5; //最大线程数
	private ThreadVO generalControlThreadVO = null;
	private int sleep = 500;
	private int runningNum = 0;
	private int waitingNum = 0;
	private int totNum = 0;
	private String logName = null;
	private ArrayList threadList;
	private ArrayList threadVoList = null; //线程交互对象队列
	private int currentIndex = -1; // 在线程列表中当前线程号

	/**
	 * @param _generalControlThreadVO 总控传入的ThreadVO 若总控下达了停止运行的指令,线程控制器也会响应并终止所控制的所有线程
	 * @param _logName 日志路径
	 */
	public BhThreadControl(ThreadVO _generalControlThreadVO, String _logName) {
		this.generalControlThreadVO = _generalControlThreadVO;
		this.logName = _logName;
	}

	/**
	 * 同步调度并运行线程队列。线程名列表、线程类列表、参数列表下标必须一致
	 * 线程控制器的最大线程数见
	 * 线程队列运行出错后控制器等待其它线程运行结束后抛出异常
	 * @param threadNames 线程名列表
	 * @param classes 线程类列表
	 * @param params 参数列表，由子线程自定义
	 * @throws Exception
	 * @see #getMaxThreadNum
	 */
	public void runThreads(
		String[] threadNames,
		Class[] classes,
		Object[] params)
		throws Exception {
		if (threadNames.length != classes.length
			|| classes.length != params.length)
			throw new Exception(
				"线程名列表个数["
					+ threadNames.length
					+ "] 线程类名列表个数["
					+ classes.length
					+ "] 构造器参数列表个数["
					+ params.length
					+ "] 个数不符");

		// isAssignableFrom -- modify by yjb
		for (int cnt = 0; cnt < classes.length; cnt++) {
			if (!classes[cnt]
				.getClass()
				.isAssignableFrom(ThreadTemplet.class.getClass()))
				throw new Exception("classes中的线程必须是从ThreadTemplet派生出来的!");
		}

		this.threadList = new ArrayList();
		this.threadVoList = new ArrayList();
		this.runningNum = 0;
		this.waitingNum = this.totNum - this.runningNum;
		this.totNum = threadNames.length;
		while (true) {

			/*
			 * 如果批量被中止，那么退出循环，停止批量总控程序
			 */
			if (this.generalControlThreadVO.isStopFlag()) {
				this.output(currentIndex, "总控通知中止,等待子线程终止");
				this.waitBatchProc(currentIndex);
				throw new Exception("总控通知中止");
			}
			/*
			 * 每次进入循环，检查线程监视器，查看各子线程运行情况，并打印输出监视器
			 * 0: 正常， -1：出错、不可忽略， 1：出错、可忽略
			 */
			int monitorState = checkRunningState(currentIndex);
			if (monitorState == -1) {
				//等待其他线程结束后再跳出
				//原因:调用程序如果使用了System.exit()后java虚拟机结束运行所有批量程序同时结束
				this.waitBatchProc(currentIndex);
				throw new Exception("子线程运行出现不可忽略的错误，批量停止运行!!!");
			}
			/*
			 * 检查批量线程是否异常中断
			 * 原因:如果有异常中断将引起主控死循环
			 */
			if (this.checkError()) {
				//等待其他线程结束后再跳出
				//原因:调用程序如果使用了System.exit()后java虚拟机结束运行所有批量程序同时结束而且没有时间置bh_proc_log
				this.waitBatchProc(currentIndex);
				throw new Exception("批量程序出现严重错误未能正常结束,停止运行!!!");
			}

			// 批量结束 add by yjb
			if (currentIndex >= totNum - 1 && this.runningNum == 0 && this.waitingNum == 0)
				break;

			/*
			 * 开始线程调度
			 */
			try {
				if (runningNum >= maxThreadNum) {
					//如果当前运行线程数>=最大线程数，即已经最大线程数在运行，那么等待
					Thread.sleep(this.sleep);
				} else {

					/*
					 * 并且等待的线程数不为零，那么调度运行工作队列中当前步骤号其他等待的线程
					 */
					currentIndex =
						this.startWaitedThreads(
							threadNames,
							classes,
							params,
							currentIndex);
					Thread.sleep(this.sleep);
				}
			} catch (Exception err) {
				this.waitBatchProc(currentIndex);
				throw err;
			}
		}
	}

	/**
	 * 取最大线程数
	 * @return 最大线程数
	 */
	public int getMaxThreadNum() {
		return maxThreadNum;
	}

	/**
	 * 设置最大线程数
	 * @param _maxThreadCnt 最大线程数
	 */
	public void setMaxThreadCnt(int _maxThreadNum) throws Exception {
		if (_maxThreadNum < 1)
			throw new Exception("最大线程数不能小于1");
		maxThreadNum = _maxThreadNum;
	}

	/**
	 * 输出至日志文件和标准输出
	 * @param str
	 * @throws IOException
	 */
	private void output(int currentThreadIndex, String str)
		throws IOException {
		String tmp = DateUtil.timeToString(new java.util.Date());
		System.out.println(
			tmp
				+ " CurrentThreadIndex["
				+ currentThreadIndex
				+ "] BhThreadControl: "
				+ str);
		try{
		BatchUtil.writeFileLog(
			this.logName,
			tmp
				+ " CurrentThreadIndex["
				+ currentThreadIndex
				+ "] BhThreadControl: "
				+ str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 调试输出至日志文件和标准输出
	 * @param str
	 * @throws IOException
	 */
	private void debugOutput(int currentThreadIndex, String str)
		throws IOException {
		//临时输出,上线后封掉
		this.output(currentThreadIndex, str);
	}

	/**
	 * 输出至日志文件和标准输出
	 * @param vo 线程
	 * @param str
	 * @throws IOException
	 */
	private void output(int currentThreadIndex, ThreadVO vo, String str)
		throws IOException {
		String tmp = DateUtil.timeToString(new java.util.Date());
		System.out.println(
			vo.toString()
				+ tmp
				+ " CurrentThreadIndex["
				+ currentThreadIndex
				+ "] BhThreadControl: "
				+ str);
		try{
			BatchUtil.writeFileLog(
					this.logName,
					vo.toString()
						+ tmp
						+ " CurrentThreadIndex["
						+ currentThreadIndex
						+ "] BhThreadControl: "
						+ str);
			}catch(Exception e){
				e.printStackTrace();
			}


	}

	/**
	 * 检查线程监视器，查看子线程运行情况，统计当前步骤号运行和等待的线程数，
	 * 并判断是否有线程出错，是否可忽略
	 * @param stepNo 当前运行步骤号
	 * @return int 0: 正常， -1：出错、不可忽略， 1：出错、可忽略
	 * @throws Exception
	 */
	private int checkRunningState(int _currentIndex) throws Exception {
		int stateFlag = 0; // 0: 正常， -1：出错、不可忽略， 1：出错、可忽略
		int running = 0; // 统计当前步骤号运行的线程数
		int waiting = 0; // 统计当前步骤号等待的线程数
		ThreadVO vo = null; // 被监控线程对象
		if (_currentIndex < 0) { // modify by yjb
			this.waitingNum = this.totNum;
			return 0;
		}
		for (int cnt = 0; cnt < this.threadVoList.size(); cnt++) {
			vo = (ThreadVO) this.threadVoList.get(cnt);
			/*
			 * 遍历线程监视器
			 */
			if (BatchConstant.THREAD_STATUS_FINISHED.equals(vo.getStatus())
				&& !vo.isPrint()) {
				vo.setPrint(true);
				this.output(
					cnt + 1,
					vo,
					" 耗时:"
						+ (vo.getEndTime().getTime()
							- vo.getStartTime().getTime())
						+ "(毫秒) "
						+ BatchUtil.millisecondToString(
							vo.getEndTime().getTime()
								- vo.getStartTime().getTime()));

			}
			/*
			 * 判断线程状态
			 */
			if (BatchConstant.THREAD_STATUS_RUNNING.equals(vo.getStatus())) {
				running++;
			} else if (
				BatchConstant.THREAD_STATUS_OPEN.equals(vo.getStatus())) {
				waiting++;
			} else if (
				BatchConstant.THREAD_STATUS_ERROR.equals(vo.getStatus())) {
				if (BatchConstant
					.BATCH_ERROR_IGNORE_NO
					.equals(vo.getIgnoreFlag())) {
					if (BatchConstant
						.BATCH_ERROR_TYPE_NO_ERROR
						.equals(vo.getErrorType())) {
						this.output(cnt + 1, vo, "线程出错、不可忽略");
						if (vo.getErr() != null) {
							try {
								PrintWriter printWriter =
									new PrintWriter(
										new BufferedWriter(
											new FileWriter(
												this.logName,
												true)));
								vo.getErr().printStackTrace(printWriter);
								printWriter.close();
							} catch (IOException ioe) {
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
					BatchConstant.BATCH_ERROR_IGNORE_YES.equals(
						vo.getIgnoreFlag())) {
					/*
					 * 如果发现可忽略的新错误线程出现，打印错误信息，并将该线程错误标志设为 新出现错误
					 */
					if (BatchConstant
						.BATCH_ERROR_TYPE_NO_ERROR
						.equals(vo.getErrorType())) {
						this.output(cnt + 1, vo, "线程出错、可忽略");
						vo.setErrorType(BatchConstant.BATCH_ERROR_TYPE_NEW);
						if (vo.getErr() != null) {
							try {
								PrintWriter printWriter =
									new PrintWriter(
										new BufferedWriter(
											new FileWriter(
												this.logName,
												true)));
								vo.getErr().printStackTrace(printWriter);
								printWriter.close();
							} catch (IOException ioe) {
								ioe.printStackTrace();
							}
						}
					}
					/*
					 * 检查到已经是出现过的错误，那么设置为已存在错误。
					 */
					else if (
						BatchConstant.BATCH_ERROR_TYPE_NEW.equals(
							vo.getErrorType())) {
						vo.setErrorType(BatchConstant.BATCH_ERROR_TYPE_EXISTS);
					}
					stateFlag = 1;
				}
			}
		}
		/*
		 * 将统计的运行和等待线程数更新到全局变量
		 */
		this.runningNum = running;
		this.waitingNum = waitingNum + waiting; // modify by yjb
		return stateFlag;
	}

	/**
	 * 等待运行中的线程运行结束
	 * @param _currentIndex 当前队列下标
	 * @throws Exception
	 */
	private void waitBatchProc(int _currentIndex) throws Exception {
		if (_currentIndex < 0)
			return;
		while (true) {
			this.checkRunningState(_currentIndex);
			this.checkError();
			if (this.runningNum == 0)
				return;
			Thread.sleep(this.sleep * 2);
		}
	}

	/**
	 * 检查线程是否出现ERROR
	 * @return true:出现ERROR false:未出现ERROR
	 * @throws Exception
	 */
	private boolean checkError() throws Exception {

		ThreadVO vo = null; // 被监控线程对象
		/*
		 * 遍历线程监视器
		 */
		for (int cnt = 0; cnt < this.threadVoList.size(); cnt++) {
			vo = (ThreadVO) this.threadVoList.get(cnt);
			ThreadTemplet batchThread =
				(ThreadTemplet) this.threadList.get(cnt);
			/*
			 * 判断该线程是否已经停止而没有将状态置过来,一般是由于线程出Error引起的
			 */
			if (batchThread != null
				&& batchThread.isStart()
				&& !batchThread.isAlive()
				&& !BatchConstant.THREAD_STATUS_ERROR.equals(vo.getStatus())
				&& !BatchConstant.THREAD_STATUS_FINISHED.equals(vo.getStatus())) {
				this.output(cnt, vo, "出现严重错误未能清理现场,不可忽略,帮助清理现场!");
				vo.setStatus(BatchConstant.THREAD_STATUS_FINISHED);
				return true;
			}
		}
		return false;
	}

	/**
	 * 在运行线程数量小于最大线程数前提下，运行所有等待的线程
	 * @param _threadNames 线程名
	 * @param _classes 类
	 * @param _params 参数
	 * @param _currentIndex 当前队列下标
	 * @throws Exception
	 */
	private int startWaitedThreads(
		String[] _threadNames,
		Class[] _classes,
		Object[] _params,
		int _currentIndex)
		throws Exception {

		ThreadVO threadVO = null;

		while (runningNum < maxThreadNum && waitingNum > 0) {

			/*
			 * 装载这个类，并启动线程
			 */
			_currentIndex++;
			ThreadTemplet batchThread = null;

			Class[] argsType =
				new Class[] { ThreadVO.class, String.class, Object.class };

			// 初始化 子线程的 VO  -- modify by yjb
			threadVO = new ThreadVO();
			threadVO.setStatus(BatchConstant.THREAD_STATUS_OPEN);
			threadVO.setName((String) _threadNames[_currentIndex]);
			threadVO.setJobNo(generalControlThreadVO.getJobNo());
			threadVO.setStepNo(generalControlThreadVO.getStepNo());
			threadVO.setIgnoreFlag(generalControlThreadVO.getIgnoreFlag());
			threadVO.setSubstepNo(generalControlThreadVO.getSubstepNo());

			Object[] args =
				new Object[] { threadVO, this.logName, _params[_currentIndex] };

			batchThread =
				(ThreadTemplet) BatchUtil.loadClass(
					_classes[_currentIndex].getName(),
					argsType,
					args);

			if (batchThread != null) {
				batchThread.start();
				//为了检查线程异常增加
				this.threadList.add(batchThread);
				this.threadVoList.add(batchThread.getVo());
				//				this.output(_currentIndex, batchThread.getVo(), "Start!");
			}
			runningNum++;
			waitingNum--;
		}

		return _currentIndex;
	}

	/**
	 * @return
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}

}