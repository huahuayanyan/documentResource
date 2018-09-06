/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.model;

import com.huateng.scf.bas.lan.model.BLanLnciBase;

/**
 *  保理 关于借据表的VO
 *
 * @author <a href="mailto:Administrator@topscf.com">Administrator</a>
 *
 * @version Revision: 1.0  Date: 2013-6-29 下午06:02:15
 *
 */

public class DebtLnciBaseInfoVO  extends BLanLnciBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.math.BigDecimal repayBalamt;//回款还本
	private java.math.BigDecimal repayIntamt;//回款还息
	private java.math.BigDecimal amount;// 还款金额(银承)
	private java.math.BigDecimal payAmount;//入账金额
	private java.math.BigDecimal repayAmount;//还款金额(流贷)、
	private java.math.BigDecimal amountOver;//尾款金额
	private java.lang.String  bailAccountno;//保证金账户
	private java.lang.String chargeOffAppno;//出账流水号，信贷系统返回
	private java.math.BigDecimal bailPercent;//保证金比例
	private java.lang.String cname;//客户名称
	private java.lang.String mastContcode;//信贷合同号
	private java.lang.String businessNo;//业务合同号
	private java.lang.String supplyChainPdId;//业务种类
	private java.math.BigDecimal contAmount;//合同金额
	private java.lang.String loanWay;//出账方式
	private java.lang.String incomeAppno;//出账流水号，信贷系统返回
	private java.math.BigDecimal amt;//出账金额
	private java.lang.String appliStatusDtl;//审批状态
	private java.math.BigDecimal loanPercent;//融资比例
	private java.lang.String mastContStatus;//信贷合同状态
	private java.lang.String creditProtNo;//额度协议流水号
	private java.math.BigDecimal avaliableRiskAmt;//信贷合同可用敞口
	private java.math.BigDecimal totalBillsAmount;//应收账款总额
	private java.math.BigDecimal riskAmt;//本笔风险敞口
	private java.math.BigDecimal creditUseBal;//有效间接额度可用余额
	private java.lang.String creditType;//间接额度类型
	private java.util.Date finacingStartDate;//起息日期/出票日期
	private java.util.Date finacingEndDate; //到期日期/票据到期日
	private java.lang.String custcdBuyer; //买方客户号
	private java.lang.String otherCustcd;//交易对手、买方
	private java.math.BigDecimal poolRiskAmt;//池敞口余额（核心）
	private java.lang.String cycle;//循环标志
	private java.math.BigDecimal lnciRiskAmt;//借据敞口余额
	private java.math.BigDecimal totBailAmt;//保证金冻结金额
	private java.math.BigDecimal totCashEqualAmt;//现金等价物金额
	private java.lang.String blnUpBrcode;//一级机构
	private java.math.BigDecimal inTableInt;//表内欠息
	private java.math.BigDecimal contRiskAmt;//信贷合同总敞口\
	private java.lang.String flag;
	private java.lang.String memo;//备注
	private java.lang.String appBrcode;  //申请机构
	private java.math.BigDecimal poolUseableAmount;//TBL_DEBT_POOL中可融资金额


	public java.math.BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}
	public void setPoolUseableAmount(java.math.BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}
	public java.lang.String getAppBrcode() {
		return appBrcode;
	}
	public void setAppBrcode(java.lang.String appBrcode) {
		this.appBrcode = appBrcode;
	}
	public java.lang.String getMemo() {
		return memo;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	public java.lang.String getFlag() {
		return flag;
	}
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}
	private boolean select = false;
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public java.math.BigDecimal getContRiskAmt() {
		return contRiskAmt;
	}
	public void setContRiskAmt(java.math.BigDecimal contRiskAmt) {
		this.contRiskAmt = contRiskAmt;
	}
	public java.math.BigDecimal getInTableInt() {
		return inTableInt;
	}
	public void setInTableInt(java.math.BigDecimal inTableInt) {
		this.inTableInt = inTableInt;
	}
	public java.lang.String getCycle() {
		return cycle;
	}
	public void setCycle(java.lang.String cycle) {
		this.cycle = cycle;
	}
	public java.math.BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}
	public void setPoolRiskAmt(java.math.BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}
	public java.lang.String getOtherCustcd() {
		return otherCustcd;
	}
	public void setOtherCustcd(java.lang.String otherCustcd) {
		this.otherCustcd = otherCustcd;
	}
	public java.lang.String getBailAccountno() {
		return bailAccountno;
	}
	public void setBailAccountno(java.lang.String bailAccountno) {
		this.bailAccountno = bailAccountno;
	}
	public java.math.BigDecimal getAmountOver() {
		return amountOver;
	}
	public void setAmountOver(java.math.BigDecimal amountOver) {
		this.amountOver = amountOver;
	}
	public java.math.BigDecimal getRepayBalamt() {
		return repayBalamt;
	}
	public void setRepayBalamt(java.math.BigDecimal repayBalamt) {
		this.repayBalamt = repayBalamt;
	}
	public java.math.BigDecimal getRepayIntamt() {
		return repayIntamt;
	}
	public void setRepayIntamt(java.math.BigDecimal repayIntamt) {
		this.repayIntamt = repayIntamt;
	}
	public java.math.BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	public java.math.BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public java.math.BigDecimal getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(java.math.BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}
	public java.lang.String getChargeOffAppno() {
		return chargeOffAppno;
	}
	public void setChargeOffAppno(java.lang.String chargeOffAppno) {
		this.chargeOffAppno = chargeOffAppno;
	}
	public java.math.BigDecimal getBailPercent() {
		return bailPercent;
	}
	public void setBailPercent(java.math.BigDecimal bailPercent) {
		this.bailPercent = bailPercent;
	}
	public java.lang.String getCname() {
		return cname;
	}
	public void setCname(java.lang.String cname) {
		this.cname = cname;
	}
	public java.lang.String getMastContcode() {
		return mastContcode;
	}
	public void setMastContcode(java.lang.String mastContcode) {
		this.mastContcode = mastContcode;
	}
	public java.lang.String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(java.lang.String businessNo) {
		this.businessNo = businessNo;
	}
	public java.lang.String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public java.math.BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(java.math.BigDecimal contAmount) {
		this.contAmount = contAmount;
	}
	public java.lang.String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(java.lang.String loanWay) {
		this.loanWay = loanWay;
	}
	public java.lang.String getIncomeAppno() {
		return incomeAppno;
	}
	public void setIncomeAppno(java.lang.String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}
	public java.math.BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}
	public java.lang.String getAppliStatusDtl() {
		return appliStatusDtl;
	}
	public void setAppliStatusDtl(java.lang.String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}
	public java.math.BigDecimal getLoanPercent() {
		return loanPercent;
	}
	public void setLoanPercent(java.math.BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}
	public java.lang.String getMastContStatus() {
		return mastContStatus;
	}
	public void setMastContStatus(java.lang.String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}
	public java.lang.String getCreditProtNo() {
		return creditProtNo;
	}
	public void setCreditProtNo(java.lang.String creditProtNo) {
		this.creditProtNo = creditProtNo;
	}
	public java.math.BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}
	public void setAvaliableRiskAmt(java.math.BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}
	public java.math.BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}
	public void setTotalBillsAmount(java.math.BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}
	public java.math.BigDecimal getRiskAmt() {
		return riskAmt;
	}
	public void setRiskAmt(java.math.BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}
	public java.math.BigDecimal getCreditUseBal() {
		return creditUseBal;
	}
	public void setCreditUseBal(java.math.BigDecimal creditUseBal) {
		this.creditUseBal = creditUseBal;
	}
	public java.lang.String getCreditType() {
		return creditType;
	}
	public void setCreditType(java.lang.String creditType) {
		this.creditType = creditType;
	}
	public java.util.Date getFinacingStartDate() {
		return finacingStartDate;
	}
	public void setFinacingStartDate(java.util.Date finacingStartDate) {
		this.finacingStartDate = finacingStartDate;
	}
	public java.util.Date getFinacingEndDate() {
		return finacingEndDate;
	}
	public void setFinacingEndDate(java.util.Date finacingEndDate) {
		this.finacingEndDate = finacingEndDate;
	}
	public java.lang.String getCustcdBuyer() {
		return custcdBuyer;
	}
	public void setCustcdBuyer(java.lang.String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}
	public java.math.BigDecimal getLnciRiskAmt() {
		return lnciRiskAmt;
	}
	public void setLnciRiskAmt(java.math.BigDecimal lnciRiskAmt) {
		this.lnciRiskAmt = lnciRiskAmt;
	}
	public java.math.BigDecimal getTotBailAmt() {
		return totBailAmt;
	}
	public void setTotBailAmt(java.math.BigDecimal totBailAmt) {
		this.totBailAmt = totBailAmt;
	}
	public java.math.BigDecimal getTotCashEqualAmt() {
		return totCashEqualAmt;
	}
	public void setTotCashEqualAmt(java.math.BigDecimal totCashEqualAmt) {
		this.totCashEqualAmt = totCashEqualAmt;
	}
	public java.lang.String getBlnUpBrcode() {
		return blnUpBrcode;
	}
	public void setBlnUpBrcode(java.lang.String blnUpBrcode) {
		this.blnUpBrcode = blnUpBrcode;
	}

}
