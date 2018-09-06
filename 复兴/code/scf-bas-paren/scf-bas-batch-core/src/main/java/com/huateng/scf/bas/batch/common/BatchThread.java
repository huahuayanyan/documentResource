package com.huateng.scf.bas.batch.common;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;

import com.huateng.scf.bas.batch.vo.ThreadVO;
/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 批量线程</p>
 * @description: 构建批处理子步骤线程
 */

public class BatchThread {

	private ThreadVO vo = null;

	public BatchThread(ThreadVO vo) {
		super();
		this.vo = vo;
	}
	/**
	 * 添加一个线程到工作队列
	 * @param threadClassName 线程所运行的类的名称
	 * @param threadCount 当前线程在工作队列的序号
	 * @param subFlag 该线程是否需要分行并行运行
	 * @param brcode 分行号
	 * @param stepNo 步骤号
	 * @param subStepNo 子步骤号
	 * @throws Exception
	 */
	public Thread newBatchThread()throws
	SecurityException,
	IllegalArgumentException,
	NoSuchMethodException,
	ClassNotFoundException,
	InstantiationException,
	IllegalAccessException,
	InvocationTargetException {
		StringBuffer threadName = new StringBuffer(64); // 线程名
		Object[] args; //  运行批量的类的构造函数的参数值数组
		/*
		 * 拼装线程名称
		 */
		threadName.append(vo.getThreadClassName())
		//需要拆
		.append("_")
		.append(vo.getJobNo())
		.append("_")
		.append(vo.getStepNo())
		.append("_")
		.append(vo.getSubstepNo());

		Class[] argsType; // 运行批量的类的构造函数的参数类型数组
		/*
		 * 装载这个类，并启动线程
		 */
		Thread batchThread = null;
		if (!vo.isOrphan()) {
			// 判断是否分行并行，以决定使用不同的构造函数
			if (vo.isBranchMode()) { // 该步骤分行并行
				/*
				 * 给构造函数参数数组赋值
				 */
				argsType =
					new Class[] { Integer.class, String.class, String.class };
				args =
					new Object[] {
						new Integer(vo.getCntInMonitor()),
						threadName.toString(),
						this.intBrcodeToString(vo.getSubstepNo())};

			} else { // 该步骤不分行并行
				argsType = new Class[] { Integer.class, String.class };
				args =
					new Object[] {
						new Integer(vo.getCntInMonitor()),
						threadName.toString()};
			}
			batchThread =
				(Thread) BatchUtil.loadClass(
					vo.getThreadClassName(),
					argsType,
					args);
		}
		return batchThread;

	}
	private String intBrcodeToString(int brcode) {
		DecimalFormat decimalFormat = new DecimalFormat("000000");
		return decimalFormat.format(brcode);
	}

}
