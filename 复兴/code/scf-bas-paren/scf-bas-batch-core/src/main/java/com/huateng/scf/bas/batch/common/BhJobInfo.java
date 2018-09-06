/*
 * 创建日期 2008-1-22
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.huateng.scf.bas.batch.common;


/**
 * @author pei
 *
 * 系统信息表(BH_JOB_INFO)的映射PO
 * 
 */
public class BhJobInfo {
	
	private int jobNo; //id
	private int preJobNo;
	private String preAutoRun;
	private String systemType;
	private String runOnLine;
	private String timestamp;
	private String miscflgs;
	private String misc;

	/**
	 * @return
	 */
	public int getJobNo() {
		return jobNo;
	}

	/**
	 * @return
	 */
	public String getMisc() {
		return misc;
	}

	/**
	 * @return
	 */
	public String getMiscflgs() {
		return miscflgs;
	}
	
	/**
	 * @return
	 */
	public int getPreJobNo() {
		return preJobNo;
	}

	/**
	 * @return
	 */
	public String getRunOnLine() {
		return runOnLine;
	}

	/**
	 * @return
	 */
	public String getSystemType() {
		return systemType;
	}

	/**
	 * @return
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param integer
	 */
	public void setJobNo(int integer) {
		jobNo = integer;
	}

	/**
	 * @param string
	 */
	public void setMisc(String string) {
		misc = string;
	}

	/**
	 * @param string
	 */
	public void setMiscflgs(String string) {
		miscflgs = string;
	}

	/**
	 * @param integer
	 */
	public void setPreJobNo(int integer) {
		preJobNo = integer;
	}

	/**
	 * @param string
	 */
	public void setRunOnLine(String string) {
		runOnLine = string;
	}

	/**
	 * @param string
	 */
	public void setSystemType(String string) {
		systemType = string;
	}

	/**
	 * @param date
	 */
	public void setTimestamp(String date) {
		timestamp = date;
	}

	/**
	 * @return
	 */
	public String getPreAutoRun() {
		return preAutoRun;
	}

	/**
	 * @param string
	 */
	public void setPreAutoRun(String string) {
		preAutoRun = string;
	}

}
