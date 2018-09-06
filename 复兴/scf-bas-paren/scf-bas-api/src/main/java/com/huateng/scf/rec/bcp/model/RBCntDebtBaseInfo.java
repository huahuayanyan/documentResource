package com.huateng.scf.rec.bcp.model;

import java.io.Serializable;

public class RBCntDebtBaseInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String custCd;//卖方编号
    private String buyerCd;//买方编号
    private String custName;//卖方名称
    private String buyerName;//买方名称
    private String debtContno;//业务合同号
    private String supplyChainPdId;//业务品种
    private String curcd;//币种
    private String startDate;//合同生效日
    private String endDate;//合同到期日
    private String appno;//
    private String isPool;//
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getDebtContno() {
		return debtContno;
	}
	public void setDebtContno(String debtContno) {
		this.debtContno = debtContno;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCustCd() {
		return custCd;
	}
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	public String getBuyerCd() {
		return buyerCd;
	}
	public void setBuyerCd(String buyerCd) {
		this.buyerCd = buyerCd;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getIsPool() {
		return isPool;
	}
	public void setIsPool(String isPool) {
		this.isPool = isPool;
	}
    
    
}
