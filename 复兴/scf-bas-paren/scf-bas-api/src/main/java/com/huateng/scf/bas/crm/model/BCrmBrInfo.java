package com.huateng.scf.bas.crm.model;

import java.io.Serializable;

public class BCrmBrInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 机构号
	private String brNo;
	// 机构名称
	private String brName;
	// 客户经理号
	private String brManagerNo;
	// 客户经理名称
	private String brManagerName;
	// 工作时间
	private String txnDate;
	// 系统时间
	private String sysDate;

	public synchronized String getBrNo() {
		return brNo;
	}

	public synchronized void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public synchronized String getBrName() {
		return brName;
	}

	public synchronized void setBrName(String brName) {
		this.brName = brName;
	}

	public synchronized String getBrManagerNo() {
		return brManagerNo;
	}

	public synchronized void setBrManagerNo(String brManagerNo) {
		this.brManagerNo = brManagerNo;
	}

	public synchronized String getBrManagerName() {
		return brManagerName;
	}

	public synchronized void setBrManagerName(String brManagerName) {
		this.brManagerName = brManagerName;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getSysDate() {
		return sysDate;
	}

	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}

}