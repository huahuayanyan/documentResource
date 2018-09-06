package com.huateng.scf.bas.cnt.model;

import java.math.BigDecimal;

 
public class FourWareLoanVO extends BCntMprotDealInfo {

	private static final long serialVersionUID = -8033449740444574847L;
	
	private String id;// ID
	private String mastContno;// 主合同号
	private String mastContcode; //主合同文本编号
	private String tradeContno;// 购销合同号
	private String tradeContcode;// 购销合同编码
	private String protocolCode;// 协议编号
	private String debetNo;// 借据编号
	private String debetId;// 借据编号
	private String num;// 通知书编码
	private String noticeType;// 通知书类型
	private String applyDate;// 应用时间/签发时间
	private String custcd;// 经销商ID
	private String sellerNm;// 买方名称
	private String coreCustcd;// 核心厂商ID
	private String coreNm;// 卖方商名称
	private String bankCustcd;// 质权人ID
	private String moniCustcd;// 监管厂商ID
	private BigDecimal bailAmount;// 初始保证金金额
	private BigDecimal sumBailAmount;// 保证金及现金等价物汇总金额
	private BigDecimal addBailAmount;// 追加保证金金额
	private BigDecimal amount;// 金额、可提货金额
	private BigDecimal amt;// 合同金额
	private BigDecimal totAmt;// 累计出账金额、在押货物总价值
	private BigDecimal currOutAmt;// 本次出账金额
	private BigDecimal amountOut;// 累计提货金额
	private BigDecimal amountUpOut;// 向上游厂商累计提货金额
	private BigDecimal amountIn;// 剩余出账金额
	private BigDecimal openAmount;// 本笔风险敞口
	private String loanDate;// 放款时间
	private String endDate;// 到期日
	private String startDate;// 开始日期
	private String LimitDate;// 最迟应赎完货/单日期
	private String arrivalDate;// 到货日期
	private String deliveryTerm;// 货物交付期限（天）
	private String lnciType;// 借据类型
	private BigDecimal lnciAmt;// 借据金额
	private BigDecimal lnciBal;// 融资余额
	private String slaveLimit;// 填平敞口期限(天)
	private String brcode;// 机构
	private String mgno;// 管户员
	private String balanceAccount;// 结算账户
	private String bailAccount; // 保证金账户
	private String sellerRegAddr;// 核心厂商地址
	private String sellerContactName;// 经销商联系人
	private String coreRegAddr;// 核心厂商地址
	private String coreContactName;// 核心厂商联系人
	private String coreAccount;// 核心厂商结算账户
	private String backCustcd;// 回购厂商ID  承担方名称ID
	private String backCustName;// 回购厂商
	private String refundAccount;// 退款账号
	private String moniType;// 质押监管模式
	private String actBankno;// 开户行
	private Boolean select;
	private BigDecimal undeliveryAmt;
	private BigDecimal loanAmt;
	private String appno;
	private BigDecimal paybackTerm;
	private String payee;
	private String depositBank;
	private String paybackReason;
	private String paybackAcctNo;
	private String productId;
	private String productName;
	private String cooperationBrcode;
	private String appliStatus;
	
	private String confirmStatus; //收款确认状态
	private String commonDate; //确认日期
	private String mgrno; //客户经理
	private BigDecimal totBailAmount; //保证金额(初始+追加) 
	private BigDecimal totCashEqtAmt; //现金等价物金额(初始+追加)
	private BigDecimal totLnciAmt; //融资金额统计
	private BigDecimal totLnciBal; //融资余额统计
	private BigDecimal contAmount; //合同金额
	private BigDecimal riskAmt; // 信贷合同总敞口
	private BigDecimal avaliableRiskAmt; // 信贷合同可用敞口
	
	private BigDecimal remainAmt;//审批中出账金额
	
	private BCntMprotBaseInfo bCntMprotBaseInfo;
	private BCntMprotDealInfo bCntMprotDealInfo;

	
	private BigDecimal TotalRateRemainAmount;//欠息总额  added by 2017-04-24
	private String loanAppno;//出账流水号 added by 2017-04-24
	private String lnciStatus;//借据状态 added by 2017-04-24
	public FourWareLoanVO() {
	}

	public FourWareLoanVO(String custcd, String balanceAccount,
			String bailAccount, String sellerRegAddr, String sellerContactName,
			String actBankno, String coreCustcd, String coreAccount,
			String coreRegAddr, String coreContactName, String backCustcd,
			String refundAccount, String moniCustcd,
			BCntMprotBaseInfo BCntMprotBaseInfo,
			BCntMprotDealInfo BCntMprotDealInfo, BCntMprotBaseInfo bCntMprotBaseInfo, BCntMprotDealInfo bCntMprotDealInfo) {
		this.custcd = custcd;
		this.balanceAccount = balanceAccount;
		this.bailAccount = bailAccount;
		this.sellerRegAddr = sellerRegAddr;
		this.sellerContactName = sellerContactName;
		this.actBankno = actBankno;
		this.coreCustcd = coreCustcd;
		this.coreAccount = coreAccount;
		this.coreRegAddr = coreRegAddr;
		this.coreContactName = coreContactName;
		this.backCustcd = backCustcd;
		this.refundAccount = refundAccount;
		this.moniCustcd = moniCustcd;
		this.bCntMprotBaseInfo = bCntMprotBaseInfo;
		this.bCntMprotDealInfo = bCntMprotDealInfo;
	}

	public BigDecimal getTotalRateRemainAmount() {
		return TotalRateRemainAmount;
	}

	public void setTotalRateRemainAmount(BigDecimal totalRateRemainAmount) {
		TotalRateRemainAmount = totalRateRemainAmount;
	}

	public String getLoanAppno() {
		return loanAppno;
	}

	public void setLoanAppno(String loanAppno) {
		this.loanAppno = loanAppno;
	}

	public String getLnciStatus() {
		return lnciStatus;
	}

	public void setLnciStatus(String lnciStatus) {
		this.lnciStatus = lnciStatus;
	}

	public BCntMprotBaseInfo getBCntMprotBaseInfo() {
		return bCntMprotBaseInfo;
	}

	public void setBCntMprotBaseInfo(BCntMprotBaseInfo bCntMprotBaseInfo) {
		this.bCntMprotBaseInfo = bCntMprotBaseInfo;
	}

	public BCntMprotDealInfo getBCntMprotDealInfo() {
		return bCntMprotDealInfo;
	}

	public void setBCntMprotDealInfo(BCntMprotDealInfo bCntMprotDealInfo) {
		this.bCntMprotDealInfo = bCntMprotDealInfo;
	}

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
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

	public String getLnciType() {
		return lnciType;
	}

	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
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

	public java.lang.String getMgno() {
		return mgno;
	}

	public void setMgno(java.lang.String mgno) {
		this.mgno = mgno;
	}

	public String getLimitDate() {
		return LimitDate;
	}

	public void setLimitDate(String limitDate) {
		LimitDate = limitDate;
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

	public String getSellerRegAddr() {
		return sellerRegAddr;
	}

	public void setSellerRegAddr(String sellerRegAddr) {
		this.sellerRegAddr = sellerRegAddr;
	}

	public String getSellerContactName() {
		return sellerContactName;
	}

	public void setSellerContactName(String sellerContactName) {
		this.sellerContactName = sellerContactName;
	}

	public String getCoreRegAddr() {
		return coreRegAddr;
	}

	public void setCoreRegAddr(String coreRegAddr) {
		this.coreRegAddr = coreRegAddr;
	}

	public String getCoreContactName() {
		return coreContactName;
	}

	public void setCoreContactName(String coreContactName) {
		this.coreContactName = coreContactName;
	}

	public String getCoreAccount() {
		return coreAccount;
	}

	public void setCoreAccount(String coreAccount) {
		this.coreAccount = coreAccount;
	}

	public String getBackCustcd() {
		return backCustcd;
	}

	public void setBackCustcd(String backCustcd) {
		this.backCustcd = backCustcd;
	}

	public String getBackCustName() {
		return backCustName;
	}

	public void setBackCustName(String backCustName) {
		this.backCustName = backCustName;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}

	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}

	public BigDecimal getAmountUpOut() {
		return amountUpOut;
	}

	public void setAmountUpOut(BigDecimal amountUpOut) {
		this.amountUpOut = amountUpOut;
	}

	public String getBankCustcd() {
		return bankCustcd;
	}

	public void setBankCustcd(String bankCustcd) {
		this.bankCustcd = bankCustcd;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public java.lang.String getMoniType() {
		return moniType;
	}

	public void setMoniType(java.lang.String moniType) {
		this.moniType = moniType;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public String getTradeContno() {
		return tradeContno;
	}

	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}

	public String getTradeContcode() {
		return tradeContcode;
	}

	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public BigDecimal getTotAmt() {
		return totAmt;
	}

	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}

	public BigDecimal getCurrOutAmt() {
		return currOutAmt;
	}

	public void setCurrOutAmt(BigDecimal currOutAmt) {
		this.currOutAmt = currOutAmt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.Boolean getSelect() {
		return select;
	}

	public void setSelect(java.lang.Boolean select) {
		this.select = select;
	}

	public String getActBankno() {
		return actBankno;
	}

	public void setActBankno(String actBankno) {
		this.actBankno = actBankno;
	}

	public BigDecimal getSumBailAmount() {
		return sumBailAmount;
	}

	public void setSumBailAmount(BigDecimal sumBailAmount) {
		this.sumBailAmount = sumBailAmount;
	}

	public BigDecimal getUndeliveryAmt() {
		return undeliveryAmt;
	}

	public void setUndeliveryAmt(BigDecimal undeliveryAmt) {
		this.undeliveryAmt = undeliveryAmt;
	}

	public BigDecimal getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public BigDecimal getPaybackTerm() {
		return paybackTerm;
	}

	public void setPaybackTerm(BigDecimal paybackTerm) {
		this.paybackTerm = paybackTerm;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getPaybackReason() {
		return paybackReason;
	}

	public void setPaybackReason(String paybackReason) {
		this.paybackReason = paybackReason;
	}

	public String getPaybackAcctNo() {
		return paybackAcctNo;
	}

	public void setPaybackAcctNo(String paybackAcctNo) {
		this.paybackAcctNo = paybackAcctNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCooperationBrcode() {
		return cooperationBrcode;
	}

	public void setCooperationBrcode(String cooperationBrcode) {
		this.cooperationBrcode = cooperationBrcode;
	}

	public String getAppliStatus() {
		return appliStatus;
	}

	public void setAppliStatus(String appliStatus) {
		this.appliStatus = appliStatus;
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

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
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

	public BigDecimal getTotLnciAmt() {
		return totLnciAmt;
	}

	public void setTotLnciAmt(BigDecimal totLnciAmt) {
		this.totLnciAmt = totLnciAmt;
	}

	public BigDecimal getTotLnciBal() {
		return totLnciBal;
	}

	public void setTotLnciBal(BigDecimal totLnciBal) {
		this.totLnciBal = totLnciBal;
	}

	public String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}

	public BigDecimal getContAmount() {
		return contAmount;
	}

	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	public BigDecimal getRiskAmt() {
		return riskAmt;
	}

	public void setRiskAmt(BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}

	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}

	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}

	public BigDecimal getRemainAmt() {
		return remainAmt;
	}

	public void setRemainAmt(BigDecimal remainAmt) {
		this.remainAmt = remainAmt;
	}

	/**
	 * @return the sellerNm
	 */
	public String getSellerNm() {
		return sellerNm;
	}

	/**
	 * @param sellerNm the sellerNm to set
	 */
	public void setSellerNm(String sellerNm) {
		this.sellerNm = sellerNm;
	}

	/**
	 * @return the coreNm
	 */
	public String getCoreNm() {
		return coreNm;
	}

	/**
	 * @param coreNm the coreNm to set
	 */
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

}
