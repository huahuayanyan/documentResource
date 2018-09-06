package com.huateng.scf.sto.pcb.model;

import java.math.BigDecimal;

public class BPbcMtgBaseInfoVO extends com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1472911489135488595L;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMoniOfCustName() {
		return moniOfCustName;
	}
	public void setMoniOfCustName(String moniOfCustName) {
		this.moniOfCustName = moniOfCustName;
	}
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
	public String getSupplyChainPdIdName() {
		return supplyChainPdIdName;
	}
	public void setSupplyChainPdIdName(String supplyChainPdIdName) {
		this.supplyChainPdIdName = supplyChainPdIdName;
	}
	public BigDecimal getTotChangePrice() {
		return totChangePrice;
	}
	public void setTotChangePrice(BigDecimal totChangePrice) {
		this.totChangePrice = totChangePrice;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public BigDecimal getAfterConfirmPrice() {
		return afterConfirmPrice;
	}
	public void setAfterConfirmPrice(BigDecimal afterConfirmPrice) {
		this.afterConfirmPrice = afterConfirmPrice;
	}
	private String custName;
	private String moniOfCustName;
	private String mortgageLevelOneName;
	private String mortgageLevelTwoName;
	private String reason;
	private String supplyChainPdIdName;
	private BigDecimal totChangePrice;
	private BigDecimal afterConfirmPrice;//调整后价格
	

}
