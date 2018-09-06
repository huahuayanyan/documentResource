package com.huateng.scf.bas.lan.dao.model;

import java.math.BigDecimal;
import java.util.Date;


public class ThreeChargeOffVO {
	private String debetNo;//借据号
	private String debetId;//借据号

	private String mastContno;//合同号
	private String appno;//审批编号
	private String lnciType;//出账品种
	private BigDecimal lnciAmt;//借据金额
	private BigDecimal lnciBal;//借据余额
	private String startDate;//出账日期
	private String endDate;//结束日期
	private String mgrno;
	private String curcd;//币种
	private String commonDate;//确认收款日期
	private String confirmStatus;//收款状态
	private BigDecimal bailAmount;//初始保证金
	private BigDecimal amountIn;//剩余提货金额		
	private BigDecimal amountOut;//累计提货金额
	private BigDecimal firstBailRatio;//初始保证金比率
	private String  protocolNo;//协议号
	private String bailAccount;
	private BigDecimal addBailAmount;//追加保证金
	private String slaveLimit;//填平敞口期限
	private BigDecimal addCashEqtAmt;// 追加现金等价物金额
	private BigDecimal initCashEqtAmt;// 初始现金等价物金额
	private String custcd;//经销商
	private Date insertDate;//提货日期
	private String productId;//产品编号
	private BigDecimal rate;//利率
	
	

	private String coreCustcd;//核心厂商
	private String fouCd;//回购商
	private BigDecimal currDeliveryAmt;//提货金额
	private Date limitDate;//最迟应赎完货/单日期
	private BigDecimal  openAmount;//敞口金额
	private BigDecimal refundAmount;//累计还款金额
	private String  dept;//机构
	private String  mgno;//客户经理
	private BigDecimal contAmount;//合同金额
	private String loanWay;//出账品种
	private String brcode;//机构
	private String coreAccount;//核心厂商结算账号
	private String balanceAccount;//
	private BigDecimal riskamt;
	private String mortBillAccountNo;//现金等价物质押物编号
	private BigDecimal mortBillAmount;//质押存单金额
	private BigDecimal sumMortBillAmount;//质押现金等价物金额
	private BigDecimal bailRate;//现金等价物质押率
	private BigDecimal sumTransBillAmount;//累计质押现金等价物金额
	private String bailType;//质押物类型
	private String thrCd;//收款人
	private String bailAccountno;//保证金账号
	private BigDecimal sumBailAmount;//sumBailAmount
	private BigDecimal sumTransBailAmount;//累计转入保证金金额
	private String description;//备注
	private String custno;
	private BigDecimal amount;
	
	private String cname;//经销商
	private String coreCName;//核心厂商
	
	//*****显示机构信息********//
	private String tlrno;
	private String tlrName;
	private String brcodeName;

	
	private String protocolCode;	// 先票/款后货协议号
	private String productName;	// 先票/款后货协议号
	private BigDecimal totBailAmount; //保证金额(初始+追加)
	private BigDecimal totCashEqtAmt; //现金等价物金额(初始+追加)
	
	public String getTlrno() {
		return tlrno;
	}
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	public String getTlrName() {
		return tlrName;
	}
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	public String getBrcodeName() {
		return brcodeName;
	}
	public void setBrcodeName(String brcodeName) {
		this.brcodeName = brcodeName;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCoreCName() {
		return coreCName;
	}
	public void setCoreCName(String coreCName) {
		this.coreCName = coreCName;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public String getFouCd() {
		return fouCd;
	}
	public void setFouCd(String fouCd) {
		this.fouCd = fouCd;
	}
	public BigDecimal getCurrDeliveryAmt() {
		return currDeliveryAmt;
	}
	public void setCurrDeliveryAmt(BigDecimal currDeliveryAmt) {
		this.currDeliveryAmt = currDeliveryAmt;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
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
	public Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public BigDecimal getOpenAmount() {
		return openAmount;
	}
	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
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
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getLnciType() {
		return lnciType;
	}
	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}
	public String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public String getCommonDate() {
		return commonDate;
	}
	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate;
	}
	public BigDecimal getAmountOut() {
		return amountOut;
	}
	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}
	public BigDecimal getAmountIn() {
		return amountIn;
	}
	public void setAmountIn(BigDecimal amountIn) {
		this.amountIn = amountIn;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMgno() {
		return mgno;
	}
	public void setMgno(String mgno) {
		this.mgno = mgno;
	}
	public String getSlaveLimit() {
		return slaveLimit;
	}
	public void setSlaveLimit(String slaveLimit) {
		this.slaveLimit = slaveLimit;
	}
	
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getCoreAccount() {
		return coreAccount;
	}
	public void setCoreAccount(String coreAccount) {
		this.coreAccount = coreAccount;
	}
	public String getBalanceAccount() {
		return balanceAccount;
	}
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}
	public String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public BigDecimal getRiskamt() {
		return riskamt;
	}
	public void setRiskamt(BigDecimal riskamt) {
		this.riskamt = riskamt;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getMortBillAccountNo() {
		return mortBillAccountNo;
	}
	public void setMortBillAccountNo(String mortBillAccountNo) {
		this.mortBillAccountNo = mortBillAccountNo;
	}
	public BigDecimal getMortBillAmount() {
		return mortBillAmount;
	}
	public void setMortBillAmount(BigDecimal mortBillAmount) {
		this.mortBillAmount = mortBillAmount;
	}
	public BigDecimal getSumMortBillAmount() {
		return sumMortBillAmount;
	}
	public void setSumMortBillAmount(BigDecimal sumMortBillAmount) {
		this.sumMortBillAmount = sumMortBillAmount;
	}
	public BigDecimal getBailRate() {
		return bailRate;
	}
	public void setBailRate(BigDecimal bailRate) {
		this.bailRate = bailRate;
	}
	public BigDecimal getSumTransBillAmount() {
		return sumTransBillAmount;
	}
	public void setSumTransBillAmount(BigDecimal sumTransBillAmount) {
		this.sumTransBillAmount = sumTransBillAmount;
	}
	public String getBailType() {
		return bailType;
	}
	public void setBailType(String bailType) {
		this.bailType = bailType;
	}
	public String getThrCd() {
		return thrCd;
	}
	public void setThrCd(String thrCd) {
		this.thrCd = thrCd;
	}
	public String getBailAccountno() {
		return bailAccountno;
	}
	public void setBailAccountno(String bailAccountno) {
		this.bailAccountno = bailAccountno;
	}
	public BigDecimal getSumBailAmount() {
		return sumBailAmount;
	}
	public void setSumBailAmount(BigDecimal sumBailAmount) {
		this.sumBailAmount = sumBailAmount;
	}
	public BigDecimal getSumTransBailAmount() {
		return sumTransBailAmount;
	}
	public void setSumTransBailAmount(BigDecimal sumTransBailAmount) {
		this.sumTransBailAmount = sumTransBailAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getMgrno() {
		return mgrno;
	}
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}
	public java.math.BigDecimal getAddCashEqtAmt() {
		return addCashEqtAmt;
	}
	public void setAddCashEqtAmt(java.math.BigDecimal addCashEqtAmt) {
		this.addCashEqtAmt = addCashEqtAmt;
	}
	public java.math.BigDecimal getInitCashEqtAmt() {
		return initCashEqtAmt;
	}
	public void setInitCashEqtAmt(java.math.BigDecimal initCashEqtAmt) {
		this.initCashEqtAmt = initCashEqtAmt;
	}
	public java.math.BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(java.math.BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getTotBailAmount() {
		return totBailAmount;
	}
	public void setTotBailAmount(BigDecimal totBailAmount) {
		this.totBailAmount = totBailAmount;
	}
	public BigDecimal getTotCashEqtAmt() {
		return totCashEqtAmt;
	}
	public void setTotCashEqtAmt(BigDecimal totCashEqtAmt) {
		this.totCashEqtAmt = totCashEqtAmt;
	}
	
}
