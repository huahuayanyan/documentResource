/*
 * 创建日期 2007-10-10
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 客户基本信息表</p>
 * @author pei
 * @version :2007-10-10 9:38:34
 */
package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.util.Date;

public class BhCostomerInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BhCostomerInfoVO() {
		super();
	}

	/** nullable persistent field */
	private String custno;

	/** persistent field */
	private String custType;

	/** persistent field */
	private String branchBrcode;

	/** persistent field */
	private String idtype;

	/** persistent field */
	private String idno;

	/** nullable persistent field */
	private String openBrcode;

	/** nullable persistent field */
	private Date openDay;

	/** nullable persistent field */
	private Date closeDay;

	/** persistent field */
	private int creditNo;

	/** persistent field */
	private int financeNo;

	/** persistent field */
	private int infractNo;

	/** persistent field */
	private int investNo;

	/** persistent field */
	private int incomeNo;

	/**
	 * @return
	 */
	public String getBranchBrcode() {
		return branchBrcode;
	}

	/**
	 * @return
	 */
	public Date getCloseDay() {
		return closeDay;
	}

	/**
	 * @return
	 */
	public int getCreditNo() {
		return creditNo;
	}

	/**
	 * @return
	 */
	public String getCustno() {
		return custno;
	}
	
	/**
	 * @return
	 */
	public String getCustType() {
		return custType;
	}

	/**
	 * @return
	 */
	public int getFinanceNo() {
		return financeNo;
	}

	/**
	 * @return
	 */
	public String getIdno() {
		return idno;
	}

	/**
	 * @return
	 */
	public String getIdtype() {
		return idtype;
	}

	/**
	 * @return
	 */
	public int getIncomeNo() {
		return incomeNo;
	}

	/**
	 * @return
	 */
	public int getInfractNo() {
		return infractNo;
	}

	/**
	 * @return
	 */
	public int getInvestNo() {
		return investNo;
	}

	/**
	 * @return
	 */
	public String getOpenBrcode() {
		return openBrcode;
	}

	/**
	 * @return
	 */
	public Date getOpenDay() {
		return openDay;
	}

	/**
	 * @param string
	 */
	public void setBranchBrcode(String string) {
		branchBrcode = string;
	}

	/**
	 * @param date
	 */
	public void setCloseDay(Date date) {
		closeDay = date;
	}

	/**
	 * @param i
	 */
	public void setCreditNo(int i) {
		creditNo = i;
	}

	/**
	 * @param string
	 */
	public void setCustno(String string) {
		custno = string;
	}
	
	/**
	 * @param string
	 */
	public void setCustType(String string) {
		custType = string;
	}

	/**
	 * @param i
	 */
	public void setFinanceNo(int i) {
		financeNo = i;
	}

	/**
	 * @param string
	 */
	public void setIdno(String string) {
		idno = string;
	}

	/**
	 * @param string
	 */
	public void setIdtype(String string) {
		idtype = string;
	}

	/**
	 * @param i
	 */
	public void setIncomeNo(int i) {
		incomeNo = i;
	}

	/**
	 * @param i
	 */
	public void setInfractNo(int i) {
		infractNo = i;
	}

	/**
	 * @param i
	 */
	public void setInvestNo(int i) {
		investNo = i;
	}


	/**
	 * @param string
	 */
	public void setOpenBrcode(String string) {
		openBrcode = string;
	}

	/**
	 * @param date
	 */
	public void setOpenDay(Date date) {
		openDay = date;
	}
}
