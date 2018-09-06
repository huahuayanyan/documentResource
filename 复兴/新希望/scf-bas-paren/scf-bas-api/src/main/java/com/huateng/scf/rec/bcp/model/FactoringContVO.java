package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.cnt.model.BCntDebtInfo;

public class FactoringContVO extends BCntDebtInfo {

	private static final long serialVersionUID = 791319611680838001L;
	// TblContDebtInfo fields

	/**
	 * mengjiajia
	 */
	private String cnameBuyer;
	private String cnameSeller;
	
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
	/**
	 * mengjiajia
	 */

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

	private String cname;
	private String financingname;
	private Date signDate;
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

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}

	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}

	//TblContLeaseInfo
	private String leaseContno;
	public String getLeaseContno() {
		return leaseContno;
	}

	public void setLeaseContno(String leaseContno) {
		this.leaseContno = leaseContno;
	}

	public String getLeaseContcode() {
		return leaseContcode;
	}

	public void setLeaseContcode(String leaseContcode) {
		this.leaseContcode = leaseContcode;
	}

	public String getLease() {
		return lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

	public String getBuyerCustcd() {
		return buyerCustcd;
	}

	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public BigDecimal getContAmt() {
		return contAmt;
	}

	public void setContAmt(BigDecimal contAmt) {
		this.contAmt = contAmt;
	}

	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}

	public BigDecimal getMortValue() {
		return mortValue;
	}

	public void setMortValue(BigDecimal mortValue) {
		this.mortValue = mortValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String leaseContcode;
	private String lease;
	private String buyerCustcd;
	private String supplier;
	private BigDecimal contAmt;
	private String repayType;
	private BigDecimal mortValue;
	private String status;
	private BigDecimal loanPercentExt;

	public String getLoanWayNm() {
		return loanWayNm;
	}

	public void setLoanWayNm(String loanWayNm) {
		this.loanWayNm = loanWayNm;
	}

	/**
	 * @return the balanceAccount
	 */
	public String getBalanceAccount() {
		return balanceAccount;
	}

	/**
	 * @param balanceAccount
	 *            the balanceAccount to set
	 */
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}

	public Integer getLoanDays() {
		return loanDays;
	}

	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSellerType() {
		return sellerType;
	}

	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}

	public String getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(String buyerType) {
		this.buyerType = buyerType;
	}

	public String getBillsType() {
		return billsType;
	}

	public void setBillsType(String billsType) {
		this.billsType = billsType;
	}

	public String getLeaseFactoringFlag() {
		return leaseFactoringFlag;
	}

	public void setLeaseFactoringFlag(String leaseFactoringFlag) {
		this.leaseFactoringFlag = leaseFactoringFlag;
	}

	public String getLeasebackFlag() {
		return leasebackFlag;
	}

	public void setLeasebackFlag(String leasebackFlag) {
		this.leasebackFlag = leasebackFlag;
	}

	public String getCustcdBuyer() {
		return custcdBuyer;
	}

	public void setCustcdBuyer(String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}

	public String getCustcdSaller() {
		return custcdSaller;
	}

	public void setCustcdSaller(String custcdSaller) {
		this.custcdSaller = custcdSaller;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAppno() {
		return appno;
	}

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
	 * @param productNm
	 *            the productNm to set
	 */
	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getInsuranceCustcd() {
		return insuranceCustcd;
	}

	public void setInsuranceCustcd(String insuranceCustcd) {
		this.insuranceCustcd = insuranceCustcd;
	}

	public String getContType() {
		return contType;
	}

	public void setContType(String contType) {
		this.contType = contType;
	}

	public BigDecimal getOverDueAmount() {
		return overDueAmount;
	}

	public void setOverDueAmount(BigDecimal overDueAmount) {
		this.overDueAmount = overDueAmount;
	}

	public BigDecimal getTotalReduce() {
		return totalReduce;
	}

	public void setTotalReduce(BigDecimal totalReduce) {
		this.totalReduce = totalReduce;
	}

	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public String getMgno() {
		return mgno;
	}

	public void setMgno(String mgno) {
		this.mgno = mgno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getFinancingname() {
		return financingname;
	}

	public void setFinancingname(String financingname) {
		this.financingname = financingname;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getMainassuretype() {
		return mainassuretype;
	}

	public void setMainassuretype(String mainassuretype) {
		this.mainassuretype = mainassuretype;
	}

	public String getRecoverType() {
		return recoverType;
	}

	public void setRecoverType(String recoverType) {
		this.recoverType = recoverType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}

	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}

	public String getTransferMode() {
		return transferMode;
	}

	public void setTransferMode(String transferMode) {
		this.transferMode = transferMode;
	}

	public String getRepayMode() {
		return repayMode;
	}

	public void setRepayMode(String repayMode) {
		this.repayMode = repayMode;
	}

	public String getOrderRepayDate() {
		return orderRepayDate;
	}

	public void setOrderRepayDate(String orderRepayDate) {
		this.orderRepayDate = orderRepayDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getGraceDays() {
		return graceDays;
	}

	public void setGraceDays(Integer graceDays) {
		this.graceDays = graceDays;
	}

	public Integer getDebtGraceDays() {
		return debtGraceDays;
	}

	public void setDebtGraceDays(Integer debtGraceDays) {
		this.debtGraceDays = debtGraceDays;
	}

	public BigDecimal getCompensatePercent() {
		return compensatePercent;
	}

	public void setCompensatePercent(BigDecimal compensatePercent) {
		this.compensatePercent = compensatePercent;
	}

	public String getDueTime() {
		return dueTime;
	}

	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCompensateLimit() {
		return compensateLimit;
	}

	public void setCompensateLimit(String compensateLimit) {
		this.compensateLimit = compensateLimit;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Integer getCreditTerm() {
		return creditTerm;
	}

	public void setCreditTerm(Integer creditTerm) {
		this.creditTerm = creditTerm;
	}

	public BigDecimal getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}

	public Integer getRiskTerm() {
		return riskTerm;
	}

	public void setRiskTerm(Integer riskTerm) {
		this.riskTerm = riskTerm;
	}

	public BigDecimal getTopReparationAmt() {
		return topReparationAmt;
	}

	public void setTopReparationAmt(BigDecimal topReparationAmt) {
		this.topReparationAmt = topReparationAmt;
	}

	public BigDecimal getTotalDebtRemainAmount() {
		return totalDebtRemainAmount;
	}

	public void setTotalDebtRemainAmount(BigDecimal totalDebtRemainAmount) {
		this.totalDebtRemainAmount = totalDebtRemainAmount;
	}

	public BigDecimal getLoanPercentExt() {
		return loanPercentExt;
	}

	public void setLoanPercentExt(BigDecimal loanPercentExt) {
		this.loanPercentExt = loanPercentExt;
	}


	
}
