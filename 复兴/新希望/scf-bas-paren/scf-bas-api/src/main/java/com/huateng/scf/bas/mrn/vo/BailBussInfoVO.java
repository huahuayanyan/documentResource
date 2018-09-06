/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.mrn.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;


/**
 * 保证金及现金等价物流水结果VO
 * 
 * @author <a href="mailto:xiong_xiaolong@topscf.com">xiong_xiaolong</a>
 * 
 * @version Revision: 1.0 Date: 2013-5-10 下午2:23:06
 * 
 */

public class BailBussInfoVO extends BMrnAcctBussInfo {

	private static final long serialVersionUID = 5309274446918499438L;
	private String debetId;
	private String subContno;
	private boolean select;
	private BigDecimal removeAmount;
	private BigDecimal npsBailAmount;//核心返回值
	private String accountName;//户名
	private String supplyChainPdId;
	

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getSubContno() {
		return subContno;
	}

	public void setSubContno(String subContno) {
		this.subContno = subContno;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public BigDecimal getRemoveAmount() {
		return removeAmount;
	}

	public void setRemoveAmount(BigDecimal removeAmount) {
		this.removeAmount = removeAmount;
	}

	/**
	 * @return the npsBailAmount
	 */
	public BigDecimal getNpsBailAmount() {
		return npsBailAmount;
	}

	/**
	 * @param npsBailAmount the npsBailAmount to set
	 */
	public void setNpsBailAmount(BigDecimal npsBailAmount) {
		this.npsBailAmount = npsBailAmount;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the supplyChainPdId
	 */
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	/**
	 * @param supplyChainPdId the supplyChainPdId to set
	 */
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

}
