/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;

/**
 * <p>应收账款流水VO</p>
 *
 * @author 	huangshuidan
 * @date 2016年12月28日下午4:58:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月28日下午4:58:53              新增
 *
 * </pre>
 */

/**
 * @author htrad0055
 *
 */
public class DebtBussInfoVO extends RBcpDebtBussInfo{

	/** serialVersionUID of long */
	private static final long serialVersionUID = -2454109515797810929L;
	private String flag;
	private String taskName;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	private String debtContno;//保理业务合同号
	private Integer totalNum;//单据数
	private BigDecimal totalAmount;//回购 总金额
	private String balanceAccount;
	private Integer disputeCount;//争议笔数
	private BigDecimal disputeAmount;//争议金额
	private Integer overdueCount;//逾期笔数
	private BigDecimal overdueAmount;//逾期金额
	private BigDecimal payAmount;//还款金额
	private BigDecimal loanPercent;//融资比例
	private String startDate;//合同开始日
	private String endDate;//合同到期日
	private String rebateReason;//回购原因
	private String productId;//产品ID
	private String supplyChainPdId;
	private String payType;//还款类别
	private String description;//备注
	private String pressMode;//催收方式
	private String loanWay;// 出账方式
	private String repayPurpose;//回款用途
	private String paymentVerifyRule;//回款核销规则
	private String dueBalanceRule;//尾款规则
	private String dataNo;
	private BigDecimal totalPurCost;//
	private BigDecimal totalBillsHandingCost;//单据处理费汇总 临时
	private BigDecimal totalfinancingCost;//融资手续汇总 临时
	private BigDecimal totalCostAmount;//费用小计 临时
	private BigDecimal totalReduceAmount;//减免总额 临时
	private BigDecimal totalReceivedAmount;//实收费用小计 临时
	private String financingType;//费用收取方式 临时
	private BigDecimal finacingPoundage;//融资手续费 临时
	private String finacingCalcType;//计算方式 临时
	private BigDecimal reductionAmounted;//减免总额 临时
	private BigDecimal realPrice;//实收费用小计 临时
	private String finacingStartDt;//融资开始日 临时
	private String finacingEndDt;//融资到期日 临时
	private BigDecimal firstBailRatio;//首次保证金比例 临时
	private BigDecimal refundAmount;
	private BigDecimal returnRateAmount;
	private BigDecimal totalDebtRemainAmount;
	private BigDecimal totalCashAmount;
	private BigDecimal poolRemainingAmount;
	private BigDecimal poolUseableAmount;
	private BigDecimal totalRateRemainAmount;
	private BigDecimal totalRateAmount;
	private BigDecimal totalCapitalAmount;
	private BigDecimal rateCollectAmount;//利息余额
	private BigDecimal payPrincipalTotalAmount;//归还本金总额
	private BigDecimal payRateTotalAmount;//归还利息总额
	private BigDecimal cashRemainingAmount;//现金余额总额
	private BigDecimal remainingTotalAmount;//尾款金额
	private BigDecimal reverseTotalAmount;//冲销发票总额
	private String isInSeller;// 尾款是否划入卖方结算户
	private String billType;//出票方式
	private String bailAccount;//保证金账号
	private String bailAcctNo;
	private BigDecimal bailAmount;//保证金金额
	private Integer billNum;//出票张数
	private String loanDays;//融资天数
	private BigDecimal totalLoanRemainingAmount;//发票总融资余额
	private BigDecimal totalRemainingUseableAmount;//发票总可融资余额
	private BigDecimal repayBalamt;//回款还本
	private BigDecimal repayIntamt;//回款还息
	private java.lang.String returnId;//回款流水号
	private java.lang.String returnType;//还款类型：利息，融资，融资本息 ，无 临时
	private String repayDate;//回款日期
	private BigDecimal totalRepayAmount;//偿还融资金额
	private String dueTime;
	private String costCalcType;
	private BigDecimal costPercent;
	private String sellerCustcd;
	private String buyerCustcd;
	private BigDecimal totalBillsAmount;
	private String factType;//1：反向保理 3:行内双保理,4,信保保理,5,租赁保理,6,应收账款质押,7,应收账款质押池融资8,保理池融资;9出口退税池质押融资
	private String insuranceCustcd;//保险公司
	private String inpoolDate;//入池日期
	private BigDecimal reparationPercent;//赔付比例
	private String factoringBrcode;//买方保理商机构号
	private String poolFlag;//出入池标志
	private BigDecimal contAmount;//合同金额
	private String cnameBuyer;//买方名称
	private String cnameSeller;//卖方名称
	private BigDecimal poolRiskAmt;//池敞口
	private String mastContcode;//信贷合同号
	private String custcd;//客户号
	private String businessNo;//业务合同号
	//回款信息--借据信息，增加4个字段。 add by wangwei001 
	private String DebetId;//借据号/承兑协议号
	private String finacingEndDate;//到期日（借据）
	private String finacingStartDate;//发放日（借据）
	private BigDecimal lnciAmt;//借据金额
	private BigDecimal totalBillValue;//票据折算价值
	
	private String productNm;
	
	private String bussTypeName;//业务品种名称
	
	public String getBussTypeName() {
		return bussTypeName;
	}
	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}
	/**
	 * @return the debetId
	 */
	public String getDebetId() {
		return DebetId;
	}
	/**
	 * @param debetId the debetId to set
	 */
	public void setDebetId(String debetId) {
		DebetId = debetId;
	}
	/**
	 * @return the finacingEndDate
	 */
	public String getFinacingEndDate() {
		return finacingEndDate;
	}
	/**
	 * @param finacingEndDate the finacingEndDate to set
	 */
	public void setFinacingEndDate(String finacingEndDate) {
		this.finacingEndDate = finacingEndDate;
	}
	/**
	 * @return the finacingStartDate
	 */
	public String getFinacingStartDate() {
		return finacingStartDate;
	}
	/**
	 * @param finacingStartDate the finacingStartDate to set
	 */
	public void setFinacingStartDate(String finacingStartDate) {
		this.finacingStartDate = finacingStartDate;
	}
	/**
	 * @return the lnciAmt
	 */
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	/**
	 * @param lnciAmt the lnciAmt to set
	 */
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	/**
	 * @return the mastContcode
	 */
	public String getMastContcode() {
		return mastContcode;
	}
	/**
	 * @param mastContcode the mastContcode to set
	 */
	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}
	/**
	 * @return the custcd
	 */
	public String getCustcd() {
		return custcd;
	}
	/**
	 * @param custcd the custcd to set
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	/**
	 * @return the businessNo
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * @param businessNo the businessNo to set
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	//回款信息，增加如下5个字段。add by fengjinfu 20131025
	private java.lang.String payer;
	private java.lang.String payerAcctNo;
	private java.lang.String payerBank;
	private BigDecimal transferAmt;     
	
 	public java.lang.String getPayer() {
		return payer;
	}
	public void setPayer(java.lang.String payer) {
		this.payer = payer;
	}
	public java.lang.String getPayerAcctNo() {
		return payerAcctNo;
	}
	public void setPayerAcctNo(java.lang.String payerAcctNo) {
		this.payerAcctNo = payerAcctNo;
	}
	public java.lang.String getPayerBank() {
		return payerBank;
	}
	public void setPayerBank(java.lang.String payerBank) {
		this.payerBank = payerBank;
	}
	public BigDecimal getTransferAmt() {
		return transferAmt;
	}
	public void setTransferAmt(BigDecimal transferAmt) {
		this.transferAmt = transferAmt;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}
	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}
	public String getCnameBuyer() {
		return cnameBuyer;
	}
	public void setCnameBuyer(String cnameBuyer) {
		this.cnameBuyer = cnameBuyer;
	}
	public String getCnameSeller() {
		return cnameSeller;
	}
	public void setCnameSeller(String cnameSeller) {
		this.cnameSeller = cnameSeller;
	}
	public String getInpoolDate() {
		return inpoolDate;
	}
	public void setInpoolDate(String inpoolDate) {
		this.inpoolDate = inpoolDate;
	}
	public java.math.BigDecimal getTotalRepayAmount() {
		return totalRepayAmount;
	}
	public void setTotalRepayAmount(java.math.BigDecimal totalRepayAmount) {
		this.totalRepayAmount = totalRepayAmount;
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
	public java.lang.String getReturnId() {
		return returnId;
	}
	public void setReturnId(java.lang.String returnId) {
		this.returnId = returnId;
	}
	public java.lang.String getReturnType() {
		return returnType;
	}
	public void setReturnType(java.lang.String returnType) {
		this.returnType = returnType;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public Integer getBillNum() {
		return billNum;
	}
	public void setBillNum(Integer billNum) {
		this.billNum = billNum;
	}
	public String getLoanDays() {
		return loanDays;
	}
	public void setLoanDays(String loanDays) {
		this.loanDays = loanDays;
	}
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	public String getFinacingStartDt() {
		return finacingStartDt;
	}
	public void setFinacingStartDt(String finacingStartDt) {
		this.finacingStartDt = finacingStartDt;
	}
	public String getFinacingEndDt() {
		return finacingEndDt;
	}
	public void setFinacingEndDt(String finacingEndDt) {
		this.finacingEndDt = finacingEndDt;
	}
	public BigDecimal getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}
	public String getFinancingType() {
		return financingType;
	}
	public void setFinancingType(String financingType) {
		this.financingType = financingType;
	}
	public BigDecimal getFinacingPoundage() {
		return finacingPoundage;
	}
	public void setFinacingPoundage(BigDecimal finacingPoundage) {
		this.finacingPoundage = finacingPoundage;
	}
	public String getFinacingCalcType() {
		return finacingCalcType;
	}
	public void setFinacingCalcType(String finacingCalcType) {
		this.finacingCalcType = finacingCalcType;
	}
	public BigDecimal getReductionAmounted() {
		return reductionAmounted;
	}
	public void setReductionAmounted(BigDecimal reductionAmounted) {
		this.reductionAmounted = reductionAmounted;
	}
	public BigDecimal getTotalfinancingCost() {
		return totalfinancingCost;
	}
	public void setTotalfinancingCost(BigDecimal totalfinancingCost) {
		this.totalfinancingCost = totalfinancingCost;
	}
	public BigDecimal getTotalCostAmount() {
		return totalCostAmount;
	}
	public void setTotalCostAmount(BigDecimal totalCostAmount) {
		this.totalCostAmount = totalCostAmount;
	}
	public BigDecimal getTotalReduceAmount() {
		return totalReduceAmount;
	}
	public void setTotalReduceAmount(BigDecimal totalReduceAmount) {
		this.totalReduceAmount = totalReduceAmount;
	}
	public BigDecimal getTotalReceivedAmount() {
		return totalReceivedAmount;
	}
	public void setTotalReceivedAmount(BigDecimal totalReceivedAmount) {
		this.totalReceivedAmount = totalReceivedAmount;
	}
	public BigDecimal getTotalPurCost() {
		return totalPurCost;
	}
	public void setTotalPurCost(BigDecimal totalPurCost) {
		this.totalPurCost = totalPurCost;
	}
	public BigDecimal getTotalBillsHandingCost() {
		return totalBillsHandingCost;
	}
	public void setTotalBillsHandingCost(BigDecimal totalBillsHandingCost) {
		this.totalBillsHandingCost = totalBillsHandingCost;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public String getPressMode() {
		return pressMode;
	}
	public void setPressMode(String pressMode) {
		this.pressMode = pressMode;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the loanPercent
	 */
	public BigDecimal getLoanPercent() {
		return loanPercent;
	}
	/**
	 * @param loanPercent the loanPercent to set
	 */
	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}
	/**
	 * @return the payAmount
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * @return the overdueCount
	 */
	public Integer getOverdueCount() {
		return overdueCount;
	}
	/**
	 * @param overdueCount the overdueCount to set
	 */
	public void setOverdueCount(Integer overdueCount) {
		this.overdueCount = overdueCount;
	}
	/**
	 * @return the overdueAmount
	 */
	public BigDecimal getOverdueAmount() {
		return overdueAmount;
	}
	/**
	 * @param overdueAmount the overdueAmount to set
	 */
	public void setOverdueAmount(BigDecimal overdueAmount) {
		this.overdueAmount = overdueAmount;
	}
	/**
	 * @return the totalNum
	 */
	public Integer getTotalNum() {
		return totalNum;
	}
	/**
	 * @param totalNum the totalNum to set
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * @return the balanceAccount
	 */
	public String getBalanceAccount() {
		return balanceAccount;
	}
	/**
	 * @param balanceAccount the balanceAccount to set
	 */
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}
	/**
	 * @return the disputeCount
	 */
	public Integer getDisputeCount() {
		return disputeCount;
	}
	/**
	 * @param disputeCount the disputeCount to set
	 */
	public void setDisputeCount(Integer disputeCount) {
		this.disputeCount = disputeCount;
	}
	/**
	 * @return the disputeAmount
	 */
	public BigDecimal getDisputeAmount() {
		return disputeAmount;
	}
	/**
	 * @param disputeAmount the disputeAmount to set
	 */
	public void setDisputeAmount(BigDecimal disputeAmount) {
		this.disputeAmount = disputeAmount;
	}
	
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the rebateReason
	 */
	public String getRebateReason() {
		return rebateReason;
	}
	/**
	 * @param rebateReason the rebateReason to set
	 */
	public void setRebateReason(String rebateReason) {
		this.rebateReason = rebateReason;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the debtContno
	 */
	public String getDebtContno() {
		return debtContno;
	}
	/**
	 * @param debtContno the debtContno to set
	 */
	public void setDebtContno(String debtContno) {
		this.debtContno = debtContno;
	}
	public String getDataNo() {
		return dataNo;
	}
	public void setDataNo(String dataNo) {
		this.dataNo = dataNo;
	}
	public String getRepayPurpose() {
		return repayPurpose;
	}
	public void setRepayPurpose(String repayPurpose) {
		this.repayPurpose = repayPurpose;
	}
	public java.math.BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public java.math.BigDecimal getReturnRateAmount() {
		return returnRateAmount;
	}
	public void setReturnRateAmount(java.math.BigDecimal returnRateAmount) {
		this.returnRateAmount = returnRateAmount;
	}
	public java.math.BigDecimal getTotalDebtRemainAmount() {
		return totalDebtRemainAmount;
	}
	public void setTotalDebtRemainAmount(java.math.BigDecimal totalDebtRemainAmount) {
		this.totalDebtRemainAmount = totalDebtRemainAmount;
	}
	public java.math.BigDecimal getTotalCashAmount() {
		return totalCashAmount;
	}
	public void setTotalCashAmount(java.math.BigDecimal totalCashAmount) {
		this.totalCashAmount = totalCashAmount;
	}
	public java.math.BigDecimal getPoolRemainingAmount() {
		return poolRemainingAmount;
	}
	public void setPoolRemainingAmount(java.math.BigDecimal poolRemainingAmount) {
		this.poolRemainingAmount = poolRemainingAmount;
	}
	public java.math.BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}
	public void setPoolUseableAmount(java.math.BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}
	public java.math.BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}
	public void setTotalRateRemainAmount(java.math.BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}
	public java.math.BigDecimal getTotalRateAmount() {
		return totalRateAmount;
	}
	public void setTotalRateAmount(java.math.BigDecimal totalRateAmount) {
		this.totalRateAmount = totalRateAmount;
	}
	public java.math.BigDecimal getTotalCapitalAmount() {
		return totalCapitalAmount;
	}
	public void setTotalCapitalAmount(java.math.BigDecimal totalCapitalAmount) {
		this.totalCapitalAmount = totalCapitalAmount;
	}
	public BigDecimal getRateCollectAmount() {
		return rateCollectAmount;
	}
	public void setRateCollectAmount(BigDecimal rateCollectAmount) {
		this.rateCollectAmount = rateCollectAmount;
	}
	public BigDecimal getPayPrincipalTotalAmount() {
		return payPrincipalTotalAmount;
	}
	public void setPayPrincipalTotalAmount(BigDecimal payPrincipalTotalAmount) {
		this.payPrincipalTotalAmount = payPrincipalTotalAmount;
	}
	public BigDecimal getPayRateTotalAmount() {
		return payRateTotalAmount;
	}
	public void setPayRateTotalAmount(BigDecimal payRateTotalAmount) {
		this.payRateTotalAmount = payRateTotalAmount;
	}
	public BigDecimal getCashRemainingAmount() {
		return cashRemainingAmount;
	}
	public void setCashRemainingAmount(BigDecimal cashRemainingAmount) {
		this.cashRemainingAmount = cashRemainingAmount;
	}
	public BigDecimal getRemainingTotalAmount() {
		return remainingTotalAmount;
	}
	public void setRemainingTotalAmount(BigDecimal remainingTotalAmount) {
		this.remainingTotalAmount = remainingTotalAmount;
	}
	public BigDecimal getReverseTotalAmount() {
		return reverseTotalAmount;
	}
	public void setReverseTotalAmount(BigDecimal reverseTotalAmount) {
		this.reverseTotalAmount = reverseTotalAmount;
	}
	public String getIsInSeller() {
		return isInSeller;
	}
	public void setIsInSeller(String isInSeller) {
		this.isInSeller = isInSeller;
	}
	public BigDecimal getTotalLoanRemainingAmount() {
		return totalLoanRemainingAmount;
	}
	public void setTotalLoanRemainingAmount(BigDecimal totalLoanRemainingAmount) {
		this.totalLoanRemainingAmount = totalLoanRemainingAmount;
	}
	public BigDecimal getTotalRemainingUseableAmount() {
		return totalRemainingUseableAmount;
	}
	public void setTotalRemainingUseableAmount(
			BigDecimal totalRemainingUseableAmount) {
		this.totalRemainingUseableAmount = totalRemainingUseableAmount;
	}
	public String getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}
	public String getDueTime() {
		return dueTime;
	}
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}
	public String getCostCalcType() {
		return costCalcType;
	}
	public void setCostCalcType(String costCalcType) {
		this.costCalcType = costCalcType;
	}
	public BigDecimal getCostPercent() {
		return costPercent;
	}
	public void setCostPercent(BigDecimal costPercent) {
		this.costPercent = costPercent;
	}
	public String getSellerCustcd() {
		return sellerCustcd;
	}
	public void setSellerCustcd(String sellerCustcd) {
		this.sellerCustcd = sellerCustcd;
	}
	public String getBuyerCustcd() {
		return buyerCustcd;
	}
	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd;
	}
	public BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}
	public void setTotalBillsAmount(BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}
	public String getFactType() {
		return factType;
	}
	public void setFactType(String factType) {
		this.factType = factType;
	}
	public String getPaymentVerifyRule() {
		return paymentVerifyRule;
	}
	public void setPaymentVerifyRule(String paymentVerifyRule) {
		this.paymentVerifyRule = paymentVerifyRule;
	}
	public String getDueBalanceRule() {
		return dueBalanceRule;
	}
	public void setDueBalanceRule(String dueBalanceRule) {
		this.dueBalanceRule = dueBalanceRule;
	}
	public String getInsuranceCustcd() {
		return insuranceCustcd;
	}
	public void setInsuranceCustcd(String insuranceCustcd) {
		this.insuranceCustcd = insuranceCustcd;
	}
	public BigDecimal getReparationPercent() {
		return reparationPercent;
	}
	public void setReparationPercent(BigDecimal reparationPercent) {
		this.reparationPercent = reparationPercent;
	}
	public String getFactoringBrcode() {
		return factoringBrcode;
	}
	public void setFactoringBrcode(String factoringBrcode) {
		this.factoringBrcode = factoringBrcode;
	}
	public String getPoolFlag() {
		return poolFlag;
	}
	public void setPoolFlag(String poolFlag) {
		this.poolFlag = poolFlag;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public String getBailAcctNo() {
		return bailAcctNo;
	}
	public void setBailAcctNo(String bailAcctNo) {
		this.bailAcctNo = bailAcctNo;
	}
	public BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}
	/**
	 * @return the totalBillValue
	 */
	public BigDecimal getTotalBillValue() {
		return totalBillValue;
	}
	/**
	 * @param totalBillValue the totalBillValue to set
	 */
	public void setTotalBillValue(BigDecimal totalBillValue) {
		this.totalBillValue = totalBillValue;
	}
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}

	
}
