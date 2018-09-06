package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;

public class RBcpDebtBaseInfoV extends RBcpDebtBaseInfo{
	private BigDecimal rebateAmounts;
	private BigDecimal rebatebalance;

	public BigDecimal getRebateAmounts() {
		return rebateAmounts;
	}

	public void setRebateAmounts(BigDecimal rebateAmounts) {
		this.rebateAmounts = rebateAmounts;
	}

	public BigDecimal getRebatebalance() {
		return rebatebalance;
	}

	public void setRebatebalance(BigDecimal rebatebalance) {
		this.rebatebalance = rebatebalance;
	}

}
