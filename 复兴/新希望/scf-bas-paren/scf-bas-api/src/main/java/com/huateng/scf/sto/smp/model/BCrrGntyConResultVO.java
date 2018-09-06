package com.huateng.scf.sto.smp.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.crr.model.BCrrGntyCon;

/**
 * 现货静态台帐综合查询VO
 * @author htrad0079
 *
 */
public class BCrrGntyConResultVO extends BCrrGntyCon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060784161611300791L;

	private BigDecimal openAmount;//敞口金额
	private BigDecimal mortgageAmount;//在押库品总价值
	private BigDecimal totalLnciAmt; //质押合同下出账总金额
	private BigDecimal deliveryAmt;//可提货金额
	private String checkFlag;  //控制监管合同号、质押率、市值警戒线（%）是否可修改    


	public BigDecimal getTotalLnciAmt() {
		return totalLnciAmt;
	}

	public void setTotalLnciAmt(BigDecimal totalLnciAmt) {
		this.totalLnciAmt = totalLnciAmt;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public BigDecimal getMortgageAmount() {
		return mortgageAmount;
	}

	public void setMortgageAmount(BigDecimal mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}

	public BigDecimal getDeliveryAmt() {
		return deliveryAmt;
	}

	public void setDeliveryAmt(BigDecimal deliveryAmt) {
		this.deliveryAmt = deliveryAmt;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
	
}
