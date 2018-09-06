/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

import java.math.BigDecimal;

/**
 * 调用接口查询信息按钮返回VO
 * 
 * @author <a href="">zhonghuabin</a>
 *
 * @version Revision: 1.0  Date: 2013-8-9 下午3:46:09 
 *
 */
public class InterfaceButtonVO {

	private BigDecimal accountBalance;//帐户可用余额
	private BigDecimal avaliableRiskAmt;//可用敞口余额
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}
	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}

}
