/*
 * 创建日期 2007-10-10
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 贷款合同附加信息视图的VO</p>
 * @author pei
 * @version :2007-10-10 9:57:53
 */
package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.util.Date;

public class BhLoanExtInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BhLoanExtInfoVO() {
		super();
	}

	/** nullable persistent field */
	private int extCnt;

	/** nullable persistent field */
	private int deferCnt;

	/** nullable persistent field */
	private int shortenCnt;

	/** nullable persistent field */
	private int addCnt;

	/** nullable persistent field */
	private Date extEdate;

	/** nullable persistent field */
	private double extIntrate;

	/** nullable persistent field */
	private double ovdAmt;

	/** nullable persistent field */
	private double idleAmt;

	/** nullable persistent field */
	private double badAmt;

	/** nullable persistent field */
	private int dunCnt;

	/**
	 * @return
	 */
	public int getAddCnt() {
		return addCnt;
	}

	/**
	 * @return
	 */
	public double getBadAmt() {
		return badAmt;
	}

	/**
	 * @return
	 */
	public int getDeferCnt() {
		return deferCnt;
	}

	/**
	 * @return
	 */
	public int getDunCnt() {
		return dunCnt;
	}

	/**
	 * @return
	 */
	public int getExtCnt() {
		return extCnt;
	}

	/**
	 * @return
	 */
	public Date getExtEdate() {
		return extEdate;
	}

	/**
	 * @return
	 */
	public double getExtIntrate() {
		return extIntrate;
	}


	/**
	 * @return
	 */
	public double getIdleAmt() {
		return idleAmt;
	}

	/**
	 * @return
	 */
	public double getOvdAmt() {
		return ovdAmt;
	}


	/**
	 * @return
	 */
	public int getShortenCnt() {
		return shortenCnt;
	}

	/**
	 * @param i
	 */
	public void setAddCnt(int i) {
		addCnt = i;
	}

	/**
	 * @param d
	 */
	public void setBadAmt(double d) {
		badAmt = d;
	}

	/**
	 * @param i
	 */
	public void setDeferCnt(int i) {
		deferCnt = i;
	}

	/**
	 * @param i
	 */
	public void setDunCnt(int i) {
		dunCnt = i;
	}

	/**
	 * @param i
	 */
	public void setExtCnt(int i) {
		extCnt = i;
	}

	/**
	 * @param date
	 */
	public void setExtEdate(Date date) {
		extEdate = date;
	}

	/**
	 * @param d
	 */
	public void setExtIntrate(double d) {
		extIntrate = d;
	}


	/**
	 * @param d
	 */
	public void setIdleAmt(double d) {
		idleAmt = d;
	}

	/**
	 * @param d
	 */
	public void setOvdAmt(double d) {
		ovdAmt = d;
	}

	/**
	 * @param i
	 */
	public void setShortenCnt(int i) {
		shortenCnt = i;
	}

}
