/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

/**
 * 客户账户信息查询VO
 * 
 * @author <a href="mailto:xiong_xiaolong@topscf.com">xiong_xiaolong</a>
 * 
 * @version Revision: 1.0 Date: 2013-5-13 下午5:22:34
 * 
 */

public class CustAccountQryVO extends CommonQryVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id_Q;
	private String cust_Q;
	private String curcd_Q; //币种
	private String accountType_Q;
	private String accountNo_Q;
	private String accountName_Q;
	private String value;
	
	public CustAccountQryVO(){}
	
	public String getCurcd_Q() {
		return curcd_Q;
	}

	public void setCurcd_Q(String curcd_Q) {
		this.curcd_Q = curcd_Q;
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}

	public String getCust_Q() {
		return cust_Q;
	}

	public void setCust_Q(String cust_Q) {
		this.cust_Q = cust_Q;
	}

	public String getAccountType_Q() {
		return accountType_Q;
	}

	public void setAccountType_Q(String accountType_Q) {
		this.accountType_Q = accountType_Q;
	}

	public String getAccountNo_Q() {
		return accountNo_Q;
	}

	public void setAccountNo_Q(String accountNo_Q) {
		this.accountNo_Q = accountNo_Q;
	}

	public String getAccountName_Q() {
		return accountName_Q;
	}

	public void setAccountName_Q(String accountName_Q) {
		this.accountName_Q = accountName_Q;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
