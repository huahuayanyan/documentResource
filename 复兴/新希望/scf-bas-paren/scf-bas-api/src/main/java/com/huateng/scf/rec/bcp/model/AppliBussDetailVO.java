/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 *  业务申请流水详情VO
 *
 * @author <a href="mailto:Administrator@topscf.com">Administrator</a>
 *
 * @version Revision: 1.0  Date: 2013-6-24 上午10:28:49
 *
 */

public class AppliBussDetailVO extends RBcpAppliBussDtl{

	private static final long serialVersionUID = -1875166833241650871L;
	private BigDecimal rebatebalance;//回购、核销后应收账款余额
	private String bussContcode;//商业合同号
	private Date deadLine;//最后付款日
	private String otherWay;//其他原因、方式
	private BigDecimal financingAmount;//本次融资金额
	private String debtNo;
	private String debetId;
	private BigDecimal totalBillsAmount; //应收账款总额
	private String loanOverdueFlag;//融资状态 需要修改
	private BigDecimal totalRemainAmount;//融资余额
	private BigDecimal totalRateAmount;//应收利息总额
	private BigDecimal totalRateRemainAmount;//欠息总额
	private BigDecimal returnInterestAmount;//还息金额
	private BigDecimal returnCapitalAmount;//还本金额
	private String claimStatus;//理赔状态
	private Date confirmDate;//回执确认日期
	private BigDecimal gracePeriod;

	public BigDecimal getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(BigDecimal gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public BigDecimal getReturnInterestAmount() {
		return returnInterestAmount;
	}

	public void setReturnInterestAmount(BigDecimal returnInterestAmount) {
		this.returnInterestAmount = returnInterestAmount;
	}

	public BigDecimal getReturnCapitalAmount() {
		return returnCapitalAmount;
	}

	public void setReturnCapitalAmount(BigDecimal returnCapitalAmount) {
		this.returnCapitalAmount = returnCapitalAmount;
	}

	public BigDecimal getFinancingAmount() {
		return financingAmount;
	}

	public void setFinancingAmount(BigDecimal financingAmount) {
		this.financingAmount = financingAmount;
	}

	public String getOtherWay() {
		return otherWay;
	}

	public void setOtherWay(String otherWay) {
		this.otherWay = otherWay;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	/**
	 * @return the rebatebalance
	 */
	public BigDecimal getRebatebalance() {
		return rebatebalance;
	}

	/**
	 * @param rebatebalance the rebatebalance to set
	 */
	public void setRebatebalance(BigDecimal rebatebalance) {
		this.rebatebalance = rebatebalance;
	}

	public String getBussContcode() {
		return bussContcode;
	}

	public void setBussContcode(String bussContcode) {
		this.bussContcode = bussContcode;
	}

	public String getDebtNo() {
		return debtNo;
	}

	public void setDebtNo(String debtNo) {
		this.debtNo = debtNo;
	}

	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}

	public void setTotalBillsAmount(BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}

	public String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}

	public void setLoanOverdueFlag(String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag;
	}

	public BigDecimal getTotalRemainAmount() {
		return totalRemainAmount;
	}

	public void setTotalRemainAmount(BigDecimal totalRemainAmount) {
		this.totalRemainAmount = totalRemainAmount;
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

}
