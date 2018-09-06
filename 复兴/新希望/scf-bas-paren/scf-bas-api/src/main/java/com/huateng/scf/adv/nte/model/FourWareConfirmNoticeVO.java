package com.huateng.scf.adv.nte.model;

import java.util.Date;

import com.huateng.scf.bas.nte.model.BNteNoticeBase;

/**
 * description：四方收款确认通知书VO 
 * create date: 2017-04-27
 * 
 * @author htrad0055
 *
 */
public class FourWareConfirmNoticeVO extends BNteNoticeBase {
	private java.lang.String debetNo;
	private java.lang.String debetId;
	private java.lang.String mastContno;
	private java.lang.String lnciType;
	private java.lang.String lnciStatus;
	private java.math.BigDecimal lnciAmt;
	private java.math.BigDecimal lnciBal;
	private java.lang.String fivelevel;
	private java.lang.String creditLoanFlag;
	private java.lang.String loanType;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.String loanUse;
	private java.lang.String interestType;
	private java.lang.String interestFlag;
	private java.lang.String interestMoreFlag;
	private java.lang.String dept;
	private java.lang.String mgno;
	private java.lang.String mortgageNo;
	private java.lang.String riskLevel;
	private java.lang.String baseRateType;
	private java.lang.String rateActiveFlag;
	private java.lang.String loanIndustryType;
	private java.lang.String loanIndustryType2;
	private java.lang.String loanIndustryType3;
	private java.lang.String loanIndustryType4;
	private java.lang.String appno;
	private java.math.BigDecimal refundAmount;
	private java.math.BigDecimal totalRemainAmount;
	private java.math.BigDecimal totalRateAmount;
	private java.math.BigDecimal totalRateRemainAmount;
	private java.math.BigDecimal returnRateAmount;
	private java.lang.String curcd;
	private java.math.BigDecimal rate;
	private java.lang.String deferDate;
	private java.math.BigDecimal deferRate;
	private java.lang.String deferStatus;
	private java.util.Date insertDate;
	private java.util.Date deferEndDate;
	private java.lang.String accountNo;
	private java.lang.String loanOverdueFlag;
	private java.lang.String confirmStatus;
	private java.util.Date loanDate;
	private java.math.BigDecimal bailAmount;
	private java.math.BigDecimal amountIn;
	private java.math.BigDecimal amountOut;
	private java.math.BigDecimal amountUpOut;
	private java.math.BigDecimal firstBailRatio;
	private java.lang.String protocolNo;
	private java.math.BigDecimal addBailAmount;
	private java.lang.String billType;
	private java.lang.String bailAccount;
	private java.lang.Integer loanDays;
	private String slaveContno;// 抵质押合同号
	private String slaveLimit;
	private String isLocked;
	private String lockAppno;
	private String warnLevel; // 预警等级

	private String billNo;
	private String amount;
	private String billDate;
	private String billEndDate;
	private String drawer; // 出票人
	private String payee; // 收款人
	private String tlrName;
	private String brName;

	public java.lang.String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(java.lang.String debetNo) {
		this.debetNo = debetNo;
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

	public java.lang.String getFivelevel() {
		return fivelevel;
	}

	public void setFivelevel(java.lang.String fivelevel) {
		this.fivelevel = fivelevel;
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

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public java.lang.String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(java.lang.String loanUse) {
		this.loanUse = loanUse;
	}

	public java.lang.String getInterestType() {
		return interestType;
	}

	public void setInterestType(java.lang.String interestType) {
		this.interestType = interestType;
	}

	public java.lang.String getInterestFlag() {
		return interestFlag;
	}

	public void setInterestFlag(java.lang.String interestFlag) {
		this.interestFlag = interestFlag;
	}

	public java.lang.String getInterestMoreFlag() {
		return interestMoreFlag;
	}

	public void setInterestMoreFlag(java.lang.String interestMoreFlag) {
		this.interestMoreFlag = interestMoreFlag;
	}

	public java.lang.String getDept() {
		return dept;
	}

	public void setDept(java.lang.String dept) {
		this.dept = dept;
	}

	public java.lang.String getMgno() {
		return mgno;
	}

	public void setMgno(java.lang.String mgno) {
		this.mgno = mgno;
	}

	public java.lang.String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(java.lang.String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

	public java.lang.String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(java.lang.String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public java.lang.String getBaseRateType() {
		return baseRateType;
	}

	public void setBaseRateType(java.lang.String baseRateType) {
		this.baseRateType = baseRateType;
	}

	public java.lang.String getRateActiveFlag() {
		return rateActiveFlag;
	}

	public void setRateActiveFlag(java.lang.String rateActiveFlag) {
		this.rateActiveFlag = rateActiveFlag;
	}

	public java.lang.String getLoanIndustryType() {
		return loanIndustryType;
	}

	public void setLoanIndustryType(java.lang.String loanIndustryType) {
		this.loanIndustryType = loanIndustryType;
	}

	public java.lang.String getLoanIndustryType2() {
		return loanIndustryType2;
	}

	public void setLoanIndustryType2(java.lang.String loanIndustryType2) {
		this.loanIndustryType2 = loanIndustryType2;
	}

	public java.lang.String getLoanIndustryType3() {
		return loanIndustryType3;
	}

	public void setLoanIndustryType3(java.lang.String loanIndustryType3) {
		this.loanIndustryType3 = loanIndustryType3;
	}

	public java.lang.String getLoanIndustryType4() {
		return loanIndustryType4;
	}

	public void setLoanIndustryType4(java.lang.String loanIndustryType4) {
		this.loanIndustryType4 = loanIndustryType4;
	}

	public java.lang.String getAppno() {
		return appno;
	}

	public void setAppno(java.lang.String appno) {
		this.appno = appno;
	}

	public java.math.BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public java.math.BigDecimal getTotalRemainAmount() {
		return totalRemainAmount;
	}

	public void setTotalRemainAmount(java.math.BigDecimal totalRemainAmount) {
		this.totalRemainAmount = totalRemainAmount;
	}

	public java.math.BigDecimal getTotalRateAmount() {
		return totalRateAmount;
	}

	public void setTotalRateAmount(java.math.BigDecimal totalRateAmount) {
		this.totalRateAmount = totalRateAmount;
	}

	public java.math.BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}

	public void setTotalRateRemainAmount(java.math.BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}

	public java.math.BigDecimal getReturnRateAmount() {
		return returnRateAmount;
	}

	public void setReturnRateAmount(java.math.BigDecimal returnRateAmount) {
		this.returnRateAmount = returnRateAmount;
	}

	public java.lang.String getCurcd() {
		return curcd;
	}

	public void setCurcd(java.lang.String curcd) {
		this.curcd = curcd;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	public java.lang.String getDeferDate() {
		return deferDate;
	}

	public void setDeferDate(java.lang.String deferDate) {
		this.deferDate = deferDate;
	}

	public java.math.BigDecimal getDeferRate() {
		return deferRate;
	}

	public void setDeferRate(java.math.BigDecimal deferRate) {
		this.deferRate = deferRate;
	}

	public java.lang.String getDeferStatus() {
		return deferStatus;
	}

	public void setDeferStatus(java.lang.String deferStatus) {
		this.deferStatus = deferStatus;
	}

	public java.util.Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}

	public java.util.Date getDeferEndDate() {
		return deferEndDate;
	}

	public void setDeferEndDate(java.util.Date deferEndDate) {
		this.deferEndDate = deferEndDate;
	}

	public java.lang.String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(java.lang.String accountNo) {
		this.accountNo = accountNo;
	}

	public java.lang.String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}

	public void setLoanOverdueFlag(java.lang.String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag;
	}

	public java.lang.String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(java.lang.String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public java.util.Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(java.util.Date loanDate) {
		this.loanDate = loanDate;
	}

	public java.math.BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(java.math.BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public java.math.BigDecimal getAmountIn() {
		return amountIn;
	}

	public void setAmountIn(java.math.BigDecimal amountIn) {
		this.amountIn = amountIn;
	}

	public java.math.BigDecimal getAmountOut() {
		return amountOut;
	}

	public void setAmountOut(java.math.BigDecimal amountOut) {
		this.amountOut = amountOut;
	}

	public java.math.BigDecimal getAmountUpOut() {
		return amountUpOut;
	}

	public void setAmountUpOut(java.math.BigDecimal amountUpOut) {
		this.amountUpOut = amountUpOut;
	}

	public java.math.BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}

	public void setFirstBailRatio(java.math.BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
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

	public java.lang.String getBillType() {
		return billType;
	}

	public void setBillType(java.lang.String billType) {
		this.billType = billType;
	}

	public java.lang.String getBailAccount() {
		return bailAccount;
	}

	public void setBailAccount(java.lang.String bailAccount) {
		this.bailAccount = bailAccount;
	}

	public java.lang.Integer getLoanDays() {
		return loanDays;
	}

	public void setLoanDays(java.lang.Integer loanDays) {
		this.loanDays = loanDays;
	}

	public String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public String getSlaveLimit() {
		return slaveLimit;
	}

	public void setSlaveLimit(String slaveLimit) {
		this.slaveLimit = slaveLimit;
	}

	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}

	public String getLockAppno() {
		return lockAppno;
	}

	public void setLockAppno(String lockAppno) {
		this.lockAppno = lockAppno;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillEndDate() {
		return billEndDate;
	}

	public void setBillEndDate(String billEndDate) {
		this.billEndDate = billEndDate;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getDrawer() {
		return drawer;
	}

	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	
}
