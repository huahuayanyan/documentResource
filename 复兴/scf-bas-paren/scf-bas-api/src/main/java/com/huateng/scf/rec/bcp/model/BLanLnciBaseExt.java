package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.lan.model.BLanLnciBase;

public class BLanLnciBaseExt extends BLanLnciBase{

	private BigDecimal totalRateRemainAmount;
	private BigDecimal avaliableRiskAmt;
	public BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}
	public void setTotalRateRemainAmount(BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}
	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}
	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}
	
}
