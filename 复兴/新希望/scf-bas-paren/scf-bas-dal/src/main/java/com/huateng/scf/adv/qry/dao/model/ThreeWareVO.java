package com.huateng.scf.adv.qry.dao.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;

/***三方协议信息VO**/

public class ThreeWareVO extends BCntMprotBaseInfo {

	private static final long serialVersionUID = 1L;
	private String custcd;//经销商
	private String cname;//经销商名称
	private String coreCustcd;//核心厂商
	private String coreName ;//核心厂商名称
	private String loanWay;//出账方式
	private Integer loanDays;//出账最高业务期限（天）
	private BigDecimal lnciAmt;//借据金额
	private BigDecimal lnciBal;//融资余额
	private BigDecimal bailAmount;//保证金金额
	private BigDecimal amount;//可提货总价值
	private BigDecimal amountIn;//剩余提货金额
	private BigDecimal amountOut;//累计提货金额
	private String bailAccount;//保证金账号
	private BigDecimal firstBailRatio;//保证金比率
	private BigDecimal totalConfirmPrice;//
	private String appno;//申请编号
	private BigDecimal bailAmt;
	private String fouCd;
	private String refundAccount;//还款金额

	private String debetId;//借据编号
	private String debetNo;//借据编号
	private String loanOverdueFlag;//票/款状态
	private String lnciType;//出账方式
	private String startDate;//发放日期
	private String endDate;//结束日期
	private String curcd;//币种
	private BigDecimal refundAmount;//赎货保证金金额
	private BigDecimal businessOpenAmount;//业务敞口金额
	private BigDecimal totalRemainAmount;//融资余额
	private BigDecimal addBailAmount;//保证金及现金等价物
	private BigDecimal cashEqtAmt;//现金等价金额汇总
	private String mastContno;//合同金额
	private String confirmStatus;//收款状态
	private BigDecimal rate;//利率
	private BigDecimal totalRateRemainAmount;//欠息总金额
	private String lnciStatus;//借据状态
	
	private String loanAppno;//出账流水号
	private String commonDate;//收款确认日
	
	private String productName;//业务品种名称
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public String getCoreName() {
		return coreName;
	}
	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public Integer getLoanDays() {
		return loanDays;
	}
	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
	}
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAmountIn() {
		return amountIn;
	}
	public void setAmountIn(BigDecimal amountIn) {
		this.amountIn = amountIn;
	}
	public BigDecimal getAmountOut() {
		return amountOut;
	}
	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}
	public String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	public BigDecimal getTotalConfirmPrice() {
		return totalConfirmPrice;
	}
	public void setTotalConfirmPrice(BigDecimal totalConfirmPrice) {
		this.totalConfirmPrice = totalConfirmPrice;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public BigDecimal getBailAmt() {
		return bailAmt;
	}
	public void setBailAmt(BigDecimal bailAmt) {
		this.bailAmt = bailAmt;
	}
	public String getFouCd() {
		return fouCd;
	}
	public void setFouCd(String fouCd) {
		this.fouCd = fouCd;
	}
	public String getRefundAccount() {
		return refundAccount;
	}
	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}
	public void setLoanOverdueFlag(String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag;
	}
	public String getLnciType() {
		return lnciType;
	}
	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
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
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public BigDecimal getBusinessOpenAmount() {
		return businessOpenAmount;
	}
	public void setBusinessOpenAmount(BigDecimal businessOpenAmount) {
		this.businessOpenAmount = businessOpenAmount;
	}
	public BigDecimal getTotalRemainAmount() {
		return totalRemainAmount;
	}
	public void setTotalRemainAmount(BigDecimal totalRemainAmount) {
		this.totalRemainAmount = totalRemainAmount;
	}
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	
	public BigDecimal getCashEqtAmt() {
		return cashEqtAmt;
	}
	public void setCashEqtAmt(BigDecimal cashEqtAmt) {
		this.cashEqtAmt = cashEqtAmt;
	}
	public String getCustcd() {
		return custcd;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}
	public void setTotalRateRemainAmount(BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}
	public String getLnciStatus() {
		return lnciStatus;
	}
	public void setLnciStatus(String lnciStatus) {
		this.lnciStatus = lnciStatus;
	}
	public String getLoanAppno() {
		return loanAppno;
	}
	public void setLoanAppno(String loanAppno) {
		this.loanAppno = loanAppno;
	}
	public String getCommonDate() {
		return commonDate;
	}
	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate;
	}




}
