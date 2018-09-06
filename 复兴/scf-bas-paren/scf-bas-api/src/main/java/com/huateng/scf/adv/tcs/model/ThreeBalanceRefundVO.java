package com.huateng.scf.adv.tcs.model;

import java.math.BigDecimal;

/**
 * <p>差额退款VO</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月20日下午7:22:39	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月20日下午7:22:39              新增
 *
 * </pre>
 */

public class ThreeBalanceRefundVO {
	private String appno;
	private String custcd; //买方客户号
	private String coreCustcd; //卖方商客户号
	private String protocolNo;
	private String startDate;
	private String endDate;
	private BigDecimal firstBailRatio; 
	private String bailAccount; //保证金账号
	private BigDecimal addBailAmount;
	private BigDecimal totalRemainAmount; //?
	private String fouCd;// 担保方,承担方
	private String productId;// 产品种类
	private BigDecimal amount;// 差额退款金额 //
	private BigDecimal refundTerm;// 退款期限
	private String payee;// 收款人名称
	private String refundAcctNo;// 收款人账号
	private String depositBank;// 收款人开户行
	private String mastContno;// 合同号 ??
	private String paybackReason;//退款原因
	private String sellerNm;//买方名称
	private String coreNm;//卖方商名称
	private String fouName;//承担方名称
	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
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

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
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

	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}

	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}

	public String getBailAccount() {
		return bailAccount;
	}

	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}

	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}

	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}

	public BigDecimal getTotalRemainAmount() {
		return totalRemainAmount;
	}

	public void setTotalRemainAmount(BigDecimal totalRemainAmount) {
		this.totalRemainAmount = totalRemainAmount;
	}

	public String getFouCd() {
		return fouCd;
	}

	public void setFouCd(String fouCd) {
		this.fouCd = fouCd;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRefundTerm() {
		return refundTerm;
	}

	public void setRefundTerm(BigDecimal refundTerm) {
		this.refundTerm = refundTerm;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getRefundAcctNo() {
		return refundAcctNo;
	}

	public void setRefundAcctNo(String refundAcctNo) {
		this.refundAcctNo = refundAcctNo;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}

	public String getPaybackReason() {
		return paybackReason;
	}

	public void setPaybackReason(String paybackReason) {
		this.paybackReason = paybackReason;
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
	 * @return the fouName
	 */
	public String getFouName() {
		return fouName;
	}

	/**
	 * @param fouName the fouName to set
	 */
	public void setFouName(String fouName) {
		this.fouName = fouName;
	}
}
