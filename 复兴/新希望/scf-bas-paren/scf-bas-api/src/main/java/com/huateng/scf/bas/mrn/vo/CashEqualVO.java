package com.huateng.scf.bas.mrn.vo;

import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;

/**
 *  在这里添加类的文档注释
 * 
 * @author <a href="mailto:Administrator@topscf.com">Administrator</a>
 *
 * @version Revision: 1.0  Date: 2014年2月21日 下午10:57:39 
 *
 */

public class CashEqualVO extends BMrnAcctBussInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.math.BigDecimal npsBailAmount;//核心返回值
	private java.math.BigDecimal value;//价值
	
	public java.math.BigDecimal getValue() {
		return value;
	}

	public void setValue(java.math.BigDecimal value) {
		this.value = value;
	}

	public java.math.BigDecimal getNpsBailAmount() {
		return npsBailAmount;
	}

	public void setNpsBailAmount(java.math.BigDecimal npsBailAmount) {
		this.npsBailAmount = npsBailAmount;
	}
}
