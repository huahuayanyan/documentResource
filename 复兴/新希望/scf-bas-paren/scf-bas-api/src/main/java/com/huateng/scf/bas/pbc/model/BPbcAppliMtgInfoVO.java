package com.huateng.scf.bas.pbc.model;

import java.math.BigDecimal;

public class BPbcAppliMtgInfoVO extends BPbcAppliMtgInfo {
	private static final long serialVersionUID = 1L;

	private String billcode;

	/**
	 * DECIMAL(16,2)<br>
	 * 已入库未出质数量
	 */
	private BigDecimal invQuantity;

	public BigDecimal getInvQuantity() {
		return invQuantity;
	}

	public void setInvQuantity(BigDecimal invQuantity) {
		this.invQuantity = invQuantity;
	}

	public String getBillcode() {
		return billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	private String mortgageLevelOneName;
	private String mortgageLevelTwoName;

	public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}

	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}

	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}

	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}
}