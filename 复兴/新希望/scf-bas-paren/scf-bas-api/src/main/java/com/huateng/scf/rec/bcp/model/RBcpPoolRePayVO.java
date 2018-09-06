package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;

public class RBcpPoolRePayVO {
	private String cname;// 借款企业

	private String custcd;// 借款企业编号

	private String returnAccount;// 回款专户

	private String returnAmount;// 回款专户可用余额

	private BigDecimal amount;// 转出金额

	private String balanceAccount;// 客户结算帐号

	private String factType;

	private String reason;// 转账原因

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getReturnAccount() {
		return returnAccount;
	}

	public void setReturnAccount(String returnAccount) {
		this.returnAccount = returnAccount;
	}

	public String getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(String returnAmount) {
		this.returnAmount = returnAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBalanceAccount() {
		return balanceAccount;
	}

	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "RBcpPoolRePayVO [cname=" + cname + ", custcd=" + custcd + ", returnAccount=" + returnAccount
				+ ", returnAmount=" + returnAmount + ", amount=" + amount + ", balanceAccount=" + balanceAccount
				+ ", reason=" + reason + "]";
	}

}
