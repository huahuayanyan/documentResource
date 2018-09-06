/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.Date;

public class AppliBussInfoVO extends RBcpAppliBussInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startDate;
	private Date endDate;
	private Integer totalNum;// 发票份数
	private BigDecimal totalAmount;// 发票总金额
	private String pressMode;// 催收方式
	private String productId;// 产品id
	private BigDecimal acquisitionCost;
	private String insuranceCustcd;// 保险公司
	private BigDecimal returnRateAmount;
	private BigDecimal balanceBueAmount;
	private BigDecimal toSatterAmount;
	private BigDecimal loanPercent;
	private BigDecimal totalRemoveAmount;
	private BigDecimal totalDebtRemainAmount;
	private BigDecimal totalCashAmount;
	private BigDecimal poolRemainingAmount;
	private BigDecimal poolUseableAmount;
	private BigDecimal totalRateAmount;
	private BigDecimal totalRateRemainAmount;
	private BigDecimal totalCapitalAmount;
	private BigDecimal poolRiskAmt;
	private String bailAcctNo;

	public String getBailAcctNo() {
		return bailAcctNo;
	}

	public void setBailAcctNo(String bailAcctNo) {
		this.bailAcctNo = bailAcctNo;
	}

	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}

	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}

	public BigDecimal getTotalDebtRemainAmount() {
		return totalDebtRemainAmount;
	}

	public void setTotalDebtRemainAmount(BigDecimal totalDebtRemainAmount) {
		this.totalDebtRemainAmount = totalDebtRemainAmount;
	}

	public BigDecimal getTotalCashAmount() {
		return totalCashAmount;
	}

	public void setTotalCashAmount(BigDecimal totalCashAmount) {
		this.totalCashAmount = totalCashAmount;
	}

	public BigDecimal getPoolRemainingAmount() {
		return poolRemainingAmount;
	}

	public void setPoolRemainingAmount(BigDecimal poolRemainingAmount) {
		this.poolRemainingAmount = poolRemainingAmount;
	}

	public BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}

	public void setPoolUseableAmount(BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}

	public BigDecimal getTotalRateAmount() {
		return totalRateAmount;
	}

	public void setTotalRateAmount(BigDecimal totalRateAmount) {
		this.totalRateAmount = totalRateAmount;
	}

	public BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}

	public void setTotalRateRemainAmount(BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}

	public BigDecimal getTotalCapitalAmount() {
		return totalCapitalAmount;
	}

	public void setTotalCapitalAmount(BigDecimal totalCapitalAmount) {
		this.totalCapitalAmount = totalCapitalAmount;
	}

	public BigDecimal getReturnRateAmount() {
		return returnRateAmount;
	}

	public void setReturnRateAmount(BigDecimal returnRateAmount) {
		this.returnRateAmount = returnRateAmount;
	}

	public BigDecimal getBalanceBueAmount() {
		return balanceBueAmount;
	}

	public void setBalanceBueAmount(BigDecimal balanceBueAmount) {
		this.balanceBueAmount = balanceBueAmount;
	}

	public BigDecimal getToSatterAmount() {
		return toSatterAmount;
	}

	public void setToSatterAmount(BigDecimal toSatterAmount) {
		this.toSatterAmount = toSatterAmount;
	}

	public BigDecimal getLoanPercent() {
		return loanPercent;
	}

	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	public BigDecimal getTotalRemoveAmount() {
		return totalRemoveAmount;
	}

	public void setTotalRemoveAmount(BigDecimal totalRemoveAmount) {
		this.totalRemoveAmount = totalRemoveAmount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPressMode() {
		return pressMode;
	}

	public void setPressMode(String pressMode) {
		this.pressMode = pressMode;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getAcquisitionCost() {
		return acquisitionCost;
	}

	public void setAcquisitionCost(BigDecimal acquisitionCost) {
		this.acquisitionCost = acquisitionCost;
	}

	public String getInsuranceCustcd() {
		return insuranceCustcd;
	}

	public void setInsuranceCustcd(String insuranceCustcd) {
		this.insuranceCustcd = insuranceCustcd;
	}
}
