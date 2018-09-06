/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;

/**
 * <p>应收账款合同VO</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月05日.下午4:51:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月05日.下午4:51:24	     新增
 *
 * </pre>
 */
public class DebtContVO  extends BCntDebtInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8690292869193622951L;
	//debt
	private String cname;
	private String productName;
	private String cooperationBrcodeNm;//合作机构名称
	//debt_ext_info
	private String buyerCustcd;
	private String buyerName;
	private String businessNo;
	
	private Integer loanDays;

	// TblProductFactoring
	private String productId;
	private String sellerType;
	private String buyerType;
	private String billsType;
	private String leaseFactoringFlag;
	private String leasebackFlag;

	private String custcdBuyer;
	private String custcdSaller;
	private String payType;
	private String appno;
	private String productNm;
	private String balanceAccount;
	private String bussType;

	private String contType;

	// TblInsuranceContInfo
	private String insuranceCustcd;
	private String loanWayNm;// 出账方式下拉
	private BigDecimal overDueAmount;
	private BigDecimal totalReduce;
	private BigDecimal receiveAmount;
	private String mgno;

	private String financingname;
	private String signDate;
	private String mainassuretype;
	private String recoverType;
	private String type;
	private BigDecimal firstBailRatio;
	private String transferMode;
	private String repayMode;
	private String orderRepayDate;
	private String serviceType;
	private Integer graceDays;
	private Integer debtGraceDays;
	private BigDecimal compensatePercent;
	private String dueTime;
	private String paymentMode;
	private String compensateLimit;
	private String protocolNo;
	private String batchNumber;
	private Integer creditTerm;
	private BigDecimal creditAmt;
	private Integer riskTerm;
	private BigDecimal topReparationAmt;//最高赔款金额
	private BigDecimal totalDebtRemainAmount;//应收账款余额
	private BigDecimal poolRiskAmt;//池融资敞口余额
	private String dealFlag;//是否发生交易标识
	
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the buyerCustcd
	 */
	public String getBuyerCustcd() {
		return buyerCustcd;
	}
	/**
	 * @param buyerCustcd the buyerCustcd to set
	 */
	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd;
	}
	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}
	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
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
	/**
	 * @return the cooperationBrcodeNm
	 */
	public String getCooperationBrcodeNm() {
		return cooperationBrcodeNm;
	}
	/**
	 * @param cooperationBrcodeNm the cooperationBrcodeNm to set
	 */
	public void setCooperationBrcodeNm(String cooperationBrcodeNm) {
		this.cooperationBrcodeNm = cooperationBrcodeNm;
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
	/**
	 * @return the loanDays
	 */
	public Integer getLoanDays() {
		return loanDays;
	}
	/**
	 * @param loanDays the loanDays to set
	 */
	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
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
	 * @return the sellerType
	 */
	public String getSellerType() {
		return sellerType;
	}
	/**
	 * @param sellerType the sellerType to set
	 */
	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}
	/**
	 * @return the buyerType
	 */
	public String getBuyerType() {
		return buyerType;
	}
	/**
	 * @param buyerType the buyerType to set
	 */
	public void setBuyerType(String buyerType) {
		this.buyerType = buyerType;
	}
	/**
	 * @return the billsType
	 */
	public String getBillsType() {
		return billsType;
	}
	/**
	 * @param billsType the billsType to set
	 */
	public void setBillsType(String billsType) {
		this.billsType = billsType;
	}
	/**
	 * @return the leaseFactoringFlag
	 */
	public String getLeaseFactoringFlag() {
		return leaseFactoringFlag;
	}
	/**
	 * @param leaseFactoringFlag the leaseFactoringFlag to set
	 */
	public void setLeaseFactoringFlag(String leaseFactoringFlag) {
		this.leaseFactoringFlag = leaseFactoringFlag;
	}
	/**
	 * @return the leasebackFlag
	 */
	public String getLeasebackFlag() {
		return leasebackFlag;
	}
	/**
	 * @param leasebackFlag the leasebackFlag to set
	 */
	public void setLeasebackFlag(String leasebackFlag) {
		this.leasebackFlag = leasebackFlag;
	}
	/**
	 * @return the custcdBuyer
	 */
	public String getCustcdBuyer() {
		return custcdBuyer;
	}
	/**
	 * @param custcdBuyer the custcdBuyer to set
	 */
	public void setCustcdBuyer(String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}
	/**
	 * @return the custcdSaller
	 */
	public String getCustcdSaller() {
		return custcdSaller;
	}
	/**
	 * @param custcdSaller the custcdSaller to set
	 */
	public void setCustcdSaller(String custcdSaller) {
		this.custcdSaller = custcdSaller;
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
	 * @return the appno
	 */
	public String getAppno() {
		return appno;
	}
	/**
	 * @param appno the appno to set
	 */
	public void setAppno(String appno) {
		this.appno = appno;
	}
	/**
	 * @return the productNm
	 */
	public String getProductNm() {
		return productNm;
	}
	/**
	 * @param productNm the productNm to set
	 */
	public void setProductNm(String productNm) {
		this.productNm = productNm;
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
	 * @return the bussType
	 */
	public String getBussType() {
		return bussType;
	}
	/**
	 * @param bussType the bussType to set
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType;
	}
	/**
	 * @return the contType
	 */
	public String getContType() {
		return contType;
	}
	/**
	 * @param contType the contType to set
	 */
	public void setContType(String contType) {
		this.contType = contType;
	}
	/**
	 * @return the insuranceCustcd
	 */
	public String getInsuranceCustcd() {
		return insuranceCustcd;
	}
	/**
	 * @param insuranceCustcd the insuranceCustcd to set
	 */
	public void setInsuranceCustcd(String insuranceCustcd) {
		this.insuranceCustcd = insuranceCustcd;
	}
	/**
	 * @return the loanWayNm
	 */
	public String getLoanWayNm() {
		return loanWayNm;
	}
	/**
	 * @param loanWayNm the loanWayNm to set
	 */
	public void setLoanWayNm(String loanWayNm) {
		this.loanWayNm = loanWayNm;
	}
	/**
	 * @return the overDueAmount
	 */
	public BigDecimal getOverDueAmount() {
		return overDueAmount;
	}
	/**
	 * @param overDueAmount the overDueAmount to set
	 */
	public void setOverDueAmount(BigDecimal overDueAmount) {
		this.overDueAmount = overDueAmount;
	}
	/**
	 * @return the totalReduce
	 */
	public BigDecimal getTotalReduce() {
		return totalReduce;
	}
	/**
	 * @param totalReduce the totalReduce to set
	 */
	public void setTotalReduce(BigDecimal totalReduce) {
		this.totalReduce = totalReduce;
	}
	/**
	 * @return the receiveAmount
	 */
	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}
	/**
	 * @param receiveAmount the receiveAmount to set
	 */
	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
	/**
	 * @return the mgno
	 */
	public String getMgno() {
		return mgno;
	}
	/**
	 * @param mgno the mgno to set
	 */
	public void setMgno(String mgno) {
		this.mgno = mgno;
	}
	/**
	 * @return the financingname
	 */
	public String getFinancingname() {
		return financingname;
	}
	/**
	 * @param financingname the financingname to set
	 */
	public void setFinancingname(String financingname) {
		this.financingname = financingname;
	}
	/**
	 * @return the signDate
	 */
	public String getSignDate() {
		return signDate;
	}
	/**
	 * @param signDate the signDate to set
	 */
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	/**
	 * @return the mainassuretype
	 */
	public String getMainassuretype() {
		return mainassuretype;
	}
	/**
	 * @param mainassuretype the mainassuretype to set
	 */
	public void setMainassuretype(String mainassuretype) {
		this.mainassuretype = mainassuretype;
	}
	/**
	 * @return the recoverType
	 */
	public String getRecoverType() {
		return recoverType;
	}
	/**
	 * @param recoverType the recoverType to set
	 */
	public void setRecoverType(String recoverType) {
		this.recoverType = recoverType;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the firstBailRatio
	 */
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	/**
	 * @param firstBailRatio the firstBailRatio to set
	 */
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	/**
	 * @return the transferMode
	 */
	public String getTransferMode() {
		return transferMode;
	}
	/**
	 * @param transferMode the transferMode to set
	 */
	public void setTransferMode(String transferMode) {
		this.transferMode = transferMode;
	}
	/**
	 * @return the repayMode
	 */
	public String getRepayMode() {
		return repayMode;
	}
	/**
	 * @param repayMode the repayMode to set
	 */
	public void setRepayMode(String repayMode) {
		this.repayMode = repayMode;
	}
	/**
	 * @return the orderRepayDate
	 */
	public String getOrderRepayDate() {
		return orderRepayDate;
	}
	/**
	 * @param orderRepayDate the orderRepayDate to set
	 */
	public void setOrderRepayDate(String orderRepayDate) {
		this.orderRepayDate = orderRepayDate;
	}
	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * @return the graceDays
	 */
	public Integer getGraceDays() {
		return graceDays;
	}
	/**
	 * @param graceDays the graceDays to set
	 */
	public void setGraceDays(Integer graceDays) {
		this.graceDays = graceDays;
	}
	/**
	 * @return the debtGraceDays
	 */
	public Integer getDebtGraceDays() {
		return debtGraceDays;
	}
	/**
	 * @param debtGraceDays the debtGraceDays to set
	 */
	public void setDebtGraceDays(Integer debtGraceDays) {
		this.debtGraceDays = debtGraceDays;
	}
	/**
	 * @return the compensatePercent
	 */
	public BigDecimal getCompensatePercent() {
		return compensatePercent;
	}
	/**
	 * @param compensatePercent the compensatePercent to set
	 */
	public void setCompensatePercent(BigDecimal compensatePercent) {
		this.compensatePercent = compensatePercent;
	}
	/**
	 * @return the dueTime
	 */
	public String getDueTime() {
		return dueTime;
	}
	/**
	 * @param dueTime the dueTime to set
	 */
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}
	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * @return the compensateLimit
	 */
	public String getCompensateLimit() {
		return compensateLimit;
	}
	/**
	 * @param compensateLimit the compensateLimit to set
	 */
	public void setCompensateLimit(String compensateLimit) {
		this.compensateLimit = compensateLimit;
	}
	/**
	 * @return the protocolNo
	 */
	public String getProtocolNo() {
		return protocolNo;
	}
	/**
	 * @param protocolNo the protocolNo to set
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	/**
	 * @return the batchNumber
	 */
	public String getBatchNumber() {
		return batchNumber;
	}
	/**
	 * @param batchNumber the batchNumber to set
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	/**
	 * @return the creditTerm
	 */
	public Integer getCreditTerm() {
		return creditTerm;
	}
	/**
	 * @param creditTerm the creditTerm to set
	 */
	public void setCreditTerm(Integer creditTerm) {
		this.creditTerm = creditTerm;
	}
	/**
	 * @return the creditAmt
	 */
	public BigDecimal getCreditAmt() {
		return creditAmt;
	}
	/**
	 * @param creditAmt the creditAmt to set
	 */
	public void setCreditAmt(BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}
	/**
	 * @return the riskTerm
	 */
	public Integer getRiskTerm() {
		return riskTerm;
	}
	/**
	 * @param riskTerm the riskTerm to set
	 */
	public void setRiskTerm(Integer riskTerm) {
		this.riskTerm = riskTerm;
	}
	/**
	 * @return the topReparationAmt
	 */
	public BigDecimal getTopReparationAmt() {
		return topReparationAmt;
	}
	/**
	 * @param topReparationAmt the topReparationAmt to set
	 */
	public void setTopReparationAmt(BigDecimal topReparationAmt) {
		this.topReparationAmt = topReparationAmt;
	}
	/**
	 * @return the totalDebtRemainAmount
	 */
	public BigDecimal getTotalDebtRemainAmount() {
		return totalDebtRemainAmount;
	}
	/**
	 * @param totalDebtRemainAmount the totalDebtRemainAmount to set
	 */
	public void setTotalDebtRemainAmount(BigDecimal totalDebtRemainAmount) {
		this.totalDebtRemainAmount = totalDebtRemainAmount;
	}
	/**
	 * @return the poolRiskAmt
	 */
	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}
	/**
	 * @param poolRiskAmt the poolRiskAmt to set
	 */
	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}
	/**
	 * @return the dealFlag
	 */
	public String getDealFlag() {
		return dealFlag;
	}
	/**
	 * @param dealFlag the dealFlag to set
	 */
	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}
	

}
