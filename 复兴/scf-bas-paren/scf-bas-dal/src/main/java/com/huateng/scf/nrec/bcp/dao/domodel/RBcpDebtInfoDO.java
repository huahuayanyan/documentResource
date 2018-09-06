package com.huateng.scf.nrec.bcp.dao.domodel;

import java.math.BigDecimal;

import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;

public class RBcpDebtInfoDO extends RBcpDebtInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * mengjiajia	start
	 */
	private BigDecimal debtNum;
	

	public BigDecimal getDebtNum() {
		return debtNum;
	}

	public void setDebtNum(BigDecimal debtNum) {
		this.debtNum = debtNum;
	}
	/**
	 * mengjiajia	end
	 */
	
	/**
	 * 借款余额
	 */
	private java.math.BigDecimal lnciBal; 
	
	/**
	 * 
	 */
	private java.lang.String mgrno;
	
	
	/**
	 * 经办机构号
	 */
	private java.lang.String brcode;
	
	/**
	 * 借据号 debetno是借据表主键
	 */
	private String debetId;
	
	/**
	 * 经办人
	 */
	private String tlrcd;
	
	
	/**
	 * 
	 */
	private String startDate;
	
	/**
	 * 
	 */
	private String endDate;
	
	
	/**
	 * 经办机构名称
	 */
	private String brcodeNm;
	
	/**
	 * 客户经理姓名
	 */
	private String tlrName;

	public java.math.BigDecimal getLnciBal() {
		return lnciBal;
	}

	public void setLnciBal(java.math.BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}

	public java.lang.String getMgrno() {
		return mgrno;
	}

	public void setMgrno(java.lang.String mgrno) {
		this.mgrno = mgrno;
	}

	public java.lang.String getBrcode() {
		return brcode;
	}

	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getTlrcd() {
		return tlrcd;
	}

	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}

	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
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
	
	
}
