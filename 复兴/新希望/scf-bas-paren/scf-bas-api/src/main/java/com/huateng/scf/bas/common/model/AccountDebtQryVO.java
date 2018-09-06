/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

/**
 *  在这里添加类的文档注释
 * 
 * @author <a href="mailto:hjf@topscf.com">hjf</a>
 *
 * @version Revision: 1.0  Date: 2013-9-2 下午3:51:51 
 *
 */

public class AccountDebtQryVO extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String billsNo;
	private String bussContcode;
	private String startDate;
	private String endDate;
	private String warnNo;
	public String getBillsNo() {
		return billsNo;
	}
	public void setBillsNo(String billsNo) {
		this.billsNo = billsNo;
	}
	public String getBussContcode() {
		return bussContcode;
	}
	public void setBussContcode(String bussContcode) {
		this.bussContcode = bussContcode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getWarnNo() {
		return warnNo;
	}
	public void setWarnNo(String warnNo) {
		this.warnNo = warnNo;
	}
}
