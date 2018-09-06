
package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.util.Date;

import com.huateng.scf.bas.batch.common.BatchConstant;

/**
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 批量线程数据信息对象</p>
 * @author 
 * @version:  
 */

public class ThreadVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 线程名称
	 */
	private String name;
	/**
	 * 线程运行步骤所属作业号
	 */
	private int jobNo;
	/**
	 * 线程运行子步骤号所属步骤号
	 */
	private int stepNo;
	/**
	 * 线程运行子步骤号
	 */
	private int substepNo;
	/**
	 * 线程状态
	 */
	private String status;
	/**
	 * 子步骤号出错可忽略标志
	 */
	private String ignoreFlag;
	/**
	 * 错误状态，如果该线程出错，标识是新出现错误还是已存在错误。
	 */
	private String errorType;

	/**
	 * 上一批量未完成尚在运行线程标志
	 */
	private boolean orphan;
	/**
	 * 中止线程标志：标志是否需要中止该线程
	 */
	private boolean stopFlag;
	/**
	 * 本步骤号允许同时运行最大线程数
	 */
	private int maxThreadNo;
	/**
	 * 运行该批量子步骤的操作员
	 */
	private String tlrno;
	/**
	 * 异常
	 */
	private Exception err;
	/**
	 * className
	 */
	private String threadClassName;
	/**
	 * 分行并行模式
	 */
	private boolean branchMode;
	/**
	 * 参数
	 */
	private String processParam;
	/**
	 * add by weikun wang
	 * 生成报表状态--2008-07-22增加
	 */
	private String reportFlag;
	/**
	 * add by weikun.wang 2008.10.30
	 * 报表空跑标志
	 */
	private String reportDataFlag;
	/**
	 * 在Monitor中的位置
	 */
	private int cntInMonitor;
	private Date startTime;
	private Date endTime;
	private boolean print=false;
	/**
	 *
	 */
	public ThreadVO() {
		super();

		this.errorType = BatchConstant.BATCH_ERROR_TYPE_NO_ERROR; // 初始化为 无错误
		this.stopFlag = false; // 初始化为 不停止该进程
		err=null;
	}

	/**
	 *
	 */
	public ThreadVO(String sName,int iJobNo,int iStepNo,int iSubstepNo,String sStatus,String sIgnoreFlag,boolean bOrphan,int iMaxThreadNo,String sTlrno) {
		this.name = sName;
		this.jobNo = iJobNo;
		this.stepNo = iStepNo;
		this.substepNo = iSubstepNo;
		this.status = sStatus;
		this.ignoreFlag = sIgnoreFlag;
		this.errorType = BatchConstant.BATCH_ERROR_TYPE_NO_ERROR; // 初始化为 无错误
		this.stopFlag = false; // 初始化为 不停止该进程
		this.orphan = bOrphan;
		this.maxThreadNo = iMaxThreadNo;
		this.tlrno = sTlrno;
		err=null;
	}

	/**
	 * @return
	 */
	public String getIgnoreFlag() {
		return ignoreFlag;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return
	 */
	public int getStepNo() {
		return stepNo;
	}

	/**
	 * @return
	 */
	public int getSubstepNo() {
		return substepNo;
	}

	/**
	 * @param string
	 */
	public void setIgnoreFlag(String string) {
		ignoreFlag = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

	/**
	 * @param i
	 */
	public void setStepNo(int i) {
		stepNo = i;
	}

	/**
	 * @param i
	 */
	public void setSubstepNo(int i) {
		substepNo = i;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(128);
		sb
			.append("{")
			.append("name=")
			.append(getName())
			.append(", jobNo=")
			.append(getJobNo())
			.append(", stepNo=")
			.append(getStepNo())
			.append(", substepNo=")
			.append(getSubstepNo())
			.append(", status=")
			.append(getStatus())
			.append(", ignoreFlag=")
			.append(getIgnoreFlag())
			.append(", errorType=")
			.append(errorType)
			.append(", orphan=")
			.append(orphan)
			.append(", stopFlag=")
			.append(stopFlag)
		.append(", maxThreadNo=")
		.append(maxThreadNo)
		.append(", tlrno=")
		.append(tlrno)
			.append("}\n");

		return sb.toString();
	}

	/**
	 * @return
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param string
	 */
	public void setErrorType(String string) {
		errorType = string;
	}

	/**
	 * @return
	 */
	public boolean isStopFlag() {
		return stopFlag;
	}

	/**
	 * @param b
	 */
	public void setStopFlag(boolean b) {
		stopFlag = b;
	}

	/**
	 * @param b
	 */
	public void setOrphan(boolean b) {
		orphan = b;
	}

	/**
	 * @return
	 */
	public int getMaxThreadNo() {
		return maxThreadNo;
	}

	/**
	 * @return
	 */
	public boolean isOrphan() {
		return orphan;
	}

	/**
	 * @param i
	 */
	public void setMaxThreadNo(int i) {
		maxThreadNo = i;
	}

	/**
	 * @return
	 */
	public int getJobNo() {
		return jobNo;
	}

	/**
	 * @param i
	 */
	public void setJobNo(int i) {
		jobNo = i;
	}

	/**
	 *
	 * @return
	 */
	public String getTlrno() {
		return tlrno;
	}

	/**
	 *
	 * @param string
	 */
	public void setTlrno(String string) {
		tlrno = string;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 11, 2005 3:56:44 PM
	 */
	public Exception getErr() {
		return err;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param exception
	 * @author Ranger.Mao
	 * @Created time: May 11, 2005 3:56:44 PM
	 */
	public void setErr(Exception exception) {
		err = exception;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 18, 2005 7:09:05 PM
	 */
	public String getThreadClassName() {
		return threadClassName;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param string
	 * @author Ranger.Mao
	 * @Created time: May 18, 2005 7:09:05 PM
	 */
	public void setThreadClassName(String string) {
		threadClassName = string;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 18, 2005 7:16:20 PM
	 */
	public boolean isBranchMode() {
		return branchMode;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param b
	 * @author Ranger.Mao
	 * @Created time: May 18, 2005 7:16:20 PM
	 */
	public void setBranchMode(boolean b) {
		branchMode = b;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: May 25, 2005 9:41:10 AM
	 */
	public String getProcessParam() {
		return processParam;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param string
	 * @author Ranger.Mao
	 * @Created time: May 25, 2005 9:41:10 AM
	 */
	public void setProcessParam(String string) {
		processParam = string;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jun 6, 2005 2:51:29 PM
	 */
	public int getCntInMonitor() {
		return cntInMonitor;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param i
	 * @author Ranger.Mao
	 * @Created time: Jun 6, 2005 2:51:30 PM
	 */
	public void setCntInMonitor(int i) {
		cntInMonitor = i;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jul 26, 2005 12:45:26 PM
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jul 26, 2005 12:45:26 PM
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param date
	 * @author Ranger.Mao
	 * @Created time: Jul 26, 2005 12:45:26 PM
	 */
	public void setEndTime(Date date) {
		endTime = date;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param date
	 * @author Ranger.Mao
	 * @Created time: Jul 26, 2005 12:45:26 PM
	 */
	public void setStartTime(Date date) {
		startTime = date;
	}

	/**
	 * @Title:
	 * @Description:
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jul 26, 2005 12:46:18 PM
	 */
	public boolean isPrint() {
		return print;
	}

	/**
	 * @Title:
	 * @Description:
	 * @param b
	 * @author Ranger.Mao
	 * @Created time: Jul 26, 2005 12:46:18 PM
	 */
	public void setPrint(boolean b) {
		print = b;
	}
	//=============================================add by weikun wang 2008.7.22==================
	/**
	 * @return reportFlag
	 * @author weikun wang
	 * create time :2008-07-122 18:23:38
	 */
	public String getReportFlag() {
		return reportFlag;
	}

	/**
	 * @param reportFlag the reportFlag to set
	 * @author weikun wang
	 * create time :2008-07-122 18:23:38
	 */
	public void setReportFlag(String reportFlag) {
		this.reportFlag = reportFlag;
	}

	/**
	 * Description: 报表空跑标志
	 * @param
	 * @return String
	 * @exception
	 * @author weikun.wang
	 * @version v1.0,2008-10-31
	 */
	public String getReportDataFlag() {
		return reportDataFlag;
	}

	public void setReportDataFlag(String reportDataFlag) {
		this.reportDataFlag = reportDataFlag;
	}

}