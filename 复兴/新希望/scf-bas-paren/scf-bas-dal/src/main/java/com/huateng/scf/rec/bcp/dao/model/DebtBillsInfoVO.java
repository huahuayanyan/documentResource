/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.rec.bcp.dao.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 应收账款单据VO
 *
 * @author <a href="mailto:zhangwu@topscf.com">zhangwu</a>
 *
 * @version Revision: 1.0  Date: 2013-5-7 下午03:32:55
 *
 */

public class DebtBillsInfoVO extends RBcpDebtBaseInfo{

	/** serialVersionUID of long*/
	private static final long serialVersionUID = -4641698571947031213L;
	private String debtContno;//合同号
	private String id;//编号
	private String appno;
	private String debtId;//单据编号
	private String debtNo;//单据编号
	private boolean select = false;
	private String dueTime;
	private Date finacingEndDt;//融资到期日
	private BigDecimal FinancingAmount;
	private BigDecimal rebateAmounts;//折让/减值金额
	private BigDecimal rebatebalance;
	private BigDecimal remainingAmount;
	private BigDecimal payPrincipalAmount;//还本
	private BigDecimal payRateAmount;//还息
	private BigDecimal reverseAmount;
	private BigDecimal leftingAmount;
	private Integer pressMode;//催收方式
	private BigDecimal money;//催收金额
	private String otherWay;//其他方式
	private String debetId;//借据号 debetno是借据表主键
	private java.util.Date startDate;
	private java.lang.String mgrno;
	private java.math.BigDecimal lnciBal; //借款余额
	private java.lang.String returnAccount; //回款专户
	private java.lang.String repayPurpose; //回款用途

/////////////////////// 入账记录 临时////////////////////////////////////
	private String transactionNo;//入账记录编号
	private String repayAccount;//回款专户
	private BigDecimal returnAccountBalance;//回款专户余额
	private BigDecimal receiveAmount;//入账记录 收款金额
	private String returnDate;//入账日期
	private String returnMethod;//回款方式
	private String payerName; //付款人
	private String payerAcctNo;//付款人账号
	private String payerBank;//付款银行
	private Integer seqno;//期数
	
	//*****经办机构和经办人信息*******//	
	private java.lang.String brcode;//经办机构号
	private String brcodeNm;//经办机构
	private String tlrName;//客户经理
	private String tlrNo;//客户经理编号	
	
	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getTlrNo() {
		return tlrNo;
	}

	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getReturnMethod() {
		return returnMethod;
	}

	public void setReturnMethod(String returnMethod) {
		this.returnMethod = returnMethod;
	}

	private String bussContcode;
	public String getBussContcode() {
		return bussContcode;
	}

	public void setBussContcode(String bussContcode) {
		this.bussContcode = bussContcode;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	private Date deadLine ;
public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/////////////////////////////////////////////////////////
	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getPressMode() {
		return pressMode;
	}

	public void setPressMode(Integer pressMode) {
		this.pressMode = pressMode;
	}

	public BigDecimal getLeftingAmount() {
		return leftingAmount;
	}

	public void setLeftingAmount(BigDecimal leftingAmount) {
		this.leftingAmount = leftingAmount;
	}

	/**
	 * @return the payPrincipalAmount
	 */
	public BigDecimal getPayPrincipalAmount() {
		return payPrincipalAmount;
	}

	/**
	 * @param payPrincipalAmount the payPrincipalAmount to set
	 */
	public void setPayPrincipalAmount(BigDecimal payPrincipalAmount) {
		this.payPrincipalAmount = payPrincipalAmount;
	}

	/**
	 * @return the payRateAmount
	 */
	public BigDecimal getPayRateAmount() {
		return payRateAmount;
	}

	/**
	 * @param payRateAmount the payRateAmount to set
	 */
	public void setPayRateAmount(BigDecimal payRateAmount) {
		this.payRateAmount = payRateAmount;
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

	/**
	 * @return the rebateAmounts
	 */
	public BigDecimal getRebateAmounts() {
		return rebateAmounts;
	}

	/**
	 * @param rebateAmounts the rebateAmounts to set
	 */
	public void setRebateAmounts(BigDecimal rebateAmounts) {
		this.rebateAmounts = rebateAmounts;
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
	 * @return the finacingEndDt
	 */
	public Date getFinacingEndDt() {
		return finacingEndDt;
	}

	/**
	 * @param finacingEndDt the finacingEndDt to set
	 */
	public void setFinacingEndDt(Date finacingEndDt) {
		this.finacingEndDt = finacingEndDt;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public BigDecimal getFinancingAmount() {
		return FinancingAmount;
	}

	public void setFinancingAmount(BigDecimal financingAmount) {
		FinancingAmount = financingAmount;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the debtId
	 */
	public String getDebtId() {
		return debtId;
	}

	/**
	 * @param debtId the debtId to set
	 */
	public void setDebtId(String debtId) {
		this.debtId = debtId;
	}

	public String getDebtContno() {
		return debtContno;
	}

	public void setDebtContno(String debtContno) {
		this.debtContno = debtContno;
	}

	public BigDecimal getReverseAmount() {
		return reverseAmount;
	}

	public void setReverseAmount(BigDecimal reverseAmount) {
		this.reverseAmount = reverseAmount;
	}

	public String getDebtNo() {
		return debtNo;
	}

	public void setDebtNo(String debtNo) {
		this.debtNo = debtNo;
	}

	public java.math.BigDecimal getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(java.math.BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getOtherWay() {
		return otherWay;
	}

	public void setOtherWay(String otherWay) {
		this.otherWay = otherWay;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getRepayAccount() {
		return repayAccount;
	}

	public void setRepayAccount(String repayAccount) {
		this.repayAccount = repayAccount;
	}

	public BigDecimal getReturnAccountBalance() {
		return returnAccountBalance;
	}

	public void setReturnAccountBalance(BigDecimal returnAccountBalance) {
		this.returnAccountBalance = returnAccountBalance;
	}

	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.lang.String getMgrno() {
		return mgrno;
	}

	public void setMgrno(java.lang.String mgrno) {
		this.mgrno = mgrno;
	}

	public java.math.BigDecimal getLnciBal() {
		return lnciBal;
	}

	public void setLnciBal(java.math.BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}

	public java.lang.String getBrcode() {
		return brcode;
	}

	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}

	public java.lang.String getReturnAccount() {
		return returnAccount;
	}

	public void setReturnAccount(java.lang.String returnAccount) {
		this.returnAccount = returnAccount;
	}

	public java.lang.String getRepayPurpose() {
		return repayPurpose;
	}

	public void setRepayPurpose(java.lang.String repayPurpose) {
		this.repayPurpose = repayPurpose;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerAcctNo() {
		return payerAcctNo;
	}

	public void setPayerAcctNo(String payerAcctNo) {
		this.payerAcctNo = payerAcctNo;
	}

	public String getPayerBank() {
		return payerBank;
	}

	public void setPayerBank(String payerBank) {
		this.payerBank = payerBank;
	}
	
}
