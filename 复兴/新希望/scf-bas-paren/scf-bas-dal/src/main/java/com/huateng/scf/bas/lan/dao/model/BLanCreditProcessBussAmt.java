package com.huateng.scf.bas.lan.dao.model;

import java.math.BigDecimal;

public class BLanCreditProcessBussAmt {
	private BigDecimal riskAmount;//敞口金额
	private BigDecimal bussAmount;//业务金额
	public BigDecimal getRiskAmount() {
		return riskAmount;
	}
	public void setRiskAmount(BigDecimal riskAmount) {
		this.riskAmount = riskAmount;
	}
	public BigDecimal getBussAmount() {
		return bussAmount;
	}
	public void setBussAmount(BigDecimal bussAmount) {
		this.bussAmount = bussAmount;
	}
}
