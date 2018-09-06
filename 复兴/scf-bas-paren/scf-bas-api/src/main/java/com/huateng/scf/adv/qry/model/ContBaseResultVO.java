package com.huateng.scf.adv.qry.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.crr.model.BCrrLnCon;

public class ContBaseResultVO extends BCrrLnCon {
	 
	private static final long serialVersionUID = 1L;
	
	private BigDecimal bailAmount;
	private BigDecimal cashEqtAmt;
	private BigDecimal avaliableRiskAmt;
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public BigDecimal getCashEqtAmt() {
		return cashEqtAmt;
	}
	public void setCashEqtAmt(BigDecimal cashEqtAmt) {
		this.cashEqtAmt = cashEqtAmt;
	}
	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}
	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}
	
}
