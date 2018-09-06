/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.mrn.vo;


/**
 * 文件名：CashEqualValueContractVO.java
 * 功能描述：现金等价物合同VO
 * 创建日期: 2013-6-24
 * 创建人: zhonghuabin
 * JDK版本: <1.5.0>
 * 程序版本: SupplyChainSysPortal <1.0> <br>
 * 修改历史 <br>
 *  date           | author  | desc <br>
 */
public class CashEqualValueContractVO {

	private java.lang.String contType;// 合同类型
	private java.lang.String loanWay;// 出账方式
	// TblContBaseInfo fields
	private java.lang.String supplyChainPdId;
	private java.lang.String brcode;
	private java.lang.String curcd;
	private java.lang.String custcd;
	private java.math.BigDecimal contAmount;// 合同金额
	private java.lang.String mastContStatus;
	// TblLnciBaseInfo
	private java.lang.String debetId;
	private java.lang.String mastContno;
	private java.lang.String mastContCode;
	private java.lang.String lnciType;
	private java.lang.String lnciStatus;
	private java.math.BigDecimal lnciAmt; // 借据金额
	private java.math.BigDecimal lnciBal; // 借据余额
	private java.lang.String debetNo;
	private java.lang.String creditLoanFlag;
	private java.lang.String loanType;
	private java.lang.String loanUse;
	private String endDate;
	private String startDate;
	private java.math.BigDecimal bailAmount; // 保证金金额
	private java.lang.String loanOverdueFlag;
	private java.lang.String deferStatus;
	private java.lang.String confirmStatus;
	private java.math.BigDecimal addBailAmount;
	private java.math.BigDecimal afterAddBailAmount;//本次后现金等价物抵减金额
	private java.lang.String description;
	private java.math.BigDecimal addCashEqtAmt;//追加现金等价物金额
	private java.math.BigDecimal toTCashEqtAmt;//原现金等价物抵减金额
	private java.math.BigDecimal lnciRiskBal;//借据敞口余额
	private java.math.BigDecimal afterLnciRiskBal;//本次后借据敞口余额
	private java.math.BigDecimal addAmount;//追加现金等价物价值
	
	// TblContSlaveInfo
	private java.lang.String slaveContno;
	private java.lang.String slaveContcode;
	private java.lang.String slaveContType;
	private java.lang.String type;
	private java.lang.String bussType;
	private java.lang.String appno;
	private java.lang.String protocolNo;
	
	private boolean select = false;

	public java.lang.String getContType() {
		return contType;
	}
	public void setContType(java.lang.String contType) {
		this.contType = contType;
	}
	public java.lang.String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public java.lang.String getBrcode() {
		return brcode;
	}
	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}
	public java.lang.String getCurcd() {
		return curcd;
	}
	public void setCurcd(java.lang.String curcd) {
		this.curcd = curcd;
	}
	public java.lang.String getCustcd() {
		return custcd;
	}
	public void setCustcd(java.lang.String custcd) {
		this.custcd = custcd;
	}
	public java.math.BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(java.math.BigDecimal contAmount) {
		this.contAmount = contAmount;
	}
	public java.lang.String getMastContStatus() {
		return mastContStatus;
	}
	public void setMastContStatus(java.lang.String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}
	public java.lang.String getDebetId() {
		return debetId;
	}
	public void setDebetId(java.lang.String debetId) {
		this.debetId = debetId;
	}
	public java.lang.String getMastContno() {
		return mastContno;
	}
	public void setMastContno(java.lang.String mastContno) {
		this.mastContno = mastContno;
	}
	public java.lang.String getMastContCode() {
		return mastContCode;
	}
	public void setMastContCode(java.lang.String mastContCode) {
		this.mastContCode = mastContCode;
	}
	public java.lang.String getLnciType() {
		return lnciType;
	}
	public void setLnciType(java.lang.String lnciType) {
		this.lnciType = lnciType;
	}
	public java.lang.String getLnciStatus() {
		return lnciStatus;
	}
	public void setLnciStatus(java.lang.String lnciStatus) {
		this.lnciStatus = lnciStatus;
	}
	public java.math.BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(java.math.BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public java.math.BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(java.math.BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public java.lang.String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(java.lang.String debetNo) {
		this.debetNo = debetNo;
	}
	public java.lang.String getCreditLoanFlag() {
		return creditLoanFlag;
	}
	public void setCreditLoanFlag(java.lang.String creditLoanFlag) {
		this.creditLoanFlag = creditLoanFlag;
	}
	public java.lang.String getLoanType() {
		return loanType;
	}
	public void setLoanType(java.lang.String loanType) {
		this.loanType = loanType;
	}
	public java.lang.String getLoanUse() {
		return loanUse;
	}
	public void setLoanUse(java.lang.String loanUse) {
		this.loanUse = loanUse;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public java.math.BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(java.math.BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public java.lang.String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}
	public void setLoanOverdueFlag(java.lang.String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag;
	}
	public java.lang.String getDeferStatus() {
		return deferStatus;
	}
	public void setDeferStatus(java.lang.String deferStatus) {
		this.deferStatus = deferStatus;
	}
	public java.lang.String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(java.lang.String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public java.lang.String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(java.lang.String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public java.lang.String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(java.lang.String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
	public java.lang.String getSlaveContType() {
		return slaveContType;
	}
	public void setSlaveContType(java.lang.String slaveContType) {
		this.slaveContType = slaveContType;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getBussType() {
		return bussType;
	}
	public void setBussType(java.lang.String bussType) {
		this.bussType = bussType;
	}
	public java.lang.String getAppno() {
		return appno;
	}
	public void setAppno(java.lang.String appno) {
		this.appno = appno;
	}
	public java.lang.String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(java.lang.String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public java.math.BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(java.math.BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public java.math.BigDecimal getAfterAddBailAmount() {
		return afterAddBailAmount;
	}
	public void setAfterAddBailAmount(java.math.BigDecimal afterAddBailAmount) {
		this.afterAddBailAmount = afterAddBailAmount;
	}
	public java.lang.String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(java.lang.String loanWay) {
		this.loanWay = loanWay;
	}
	public java.lang.String getDescription() {
		return description;
	}
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.math.BigDecimal getAddCashEqtAmt() {
		return addCashEqtAmt;
	}
	public void setAddCashEqtAmt(java.math.BigDecimal addCashEqtAmt) {
		this.addCashEqtAmt = addCashEqtAmt;
	}
	public java.math.BigDecimal getToTCashEqtAmt() {
		return toTCashEqtAmt;
	}
	public void setToTCashEqtAmt(java.math.BigDecimal toTCashEqtAmt) {
		this.toTCashEqtAmt = toTCashEqtAmt;
	}
	public java.math.BigDecimal getLnciRiskBal() {
		return lnciRiskBal;
	}
	public void setLnciRiskBal(java.math.BigDecimal lnciRiskBal) {
		this.lnciRiskBal = lnciRiskBal;
	}
	public java.math.BigDecimal getAfterLnciRiskBal() {
		return afterLnciRiskBal;
	}
	public void setAfterLnciRiskBal(java.math.BigDecimal afterLnciRiskBal) {
		this.afterLnciRiskBal = afterLnciRiskBal;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public java.math.BigDecimal getAddAmount() {
		return addAmount;
	}
	public void setAddAmount(java.math.BigDecimal addAmount) {
		this.addAmount = addAmount;
	}

}
