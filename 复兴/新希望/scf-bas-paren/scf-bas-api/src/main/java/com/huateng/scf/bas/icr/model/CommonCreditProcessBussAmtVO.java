/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.icr.model;

import java.math.BigDecimal;

/**
 *  业务处理额度金额
 *
 *
 */

public class CommonCreditProcessBussAmtVO {
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
