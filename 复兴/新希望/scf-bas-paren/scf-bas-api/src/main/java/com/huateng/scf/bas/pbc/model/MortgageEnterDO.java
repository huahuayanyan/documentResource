package com.huateng.scf.bas.pbc.model;

public class MortgageEnterDO extends BPbcMtgBaseInfo{
	private String cname;//出质人名称
	private String custcd;//出质人客户号
	private String moniCname;//监管公司名称
	private String moniOfCustcd;//监管公司客户号
	private String slaveContcode;//抵/质押合同号
	private String mortgageLevelOneName;//押品一级
	private String mortgageLevelTwoName;//押品二级
	private String mortgageName;//押品名称
	private String suppProductName;//业务品种
	private String monitorType;//监管模式
	private String moniModel;//货押模式
	private String protocolCode;//监管合同号
	private String productId;//业务品种
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getMoniCname() {
		return moniCname;
	}
	public void setMoniCname(String moniCname) {
		this.moniCname = moniCname;
	}
	public String getMoniOfCustcd() {
		return moniOfCustcd;
	}
	public void setMoniOfCustcd(String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}
	public String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
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
	public String getMortgageName() {
		return mortgageName;
	}
	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
	}
	public String getSuppProductName() {
		return suppProductName;
	}
	public void setSuppProductName(String suppProductName) {
		this.suppProductName = suppProductName;
	}
	public String getMonitorType() {
		return monitorType;
	}
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}
	public String getMoniModel() {
		return moniModel;
	}
	public void setMoniModel(String moniModel) {
		this.moniModel = moniModel;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "MortgageEnterDO [cname=" + cname + ", custcd=" + custcd + ", moniCname=" + moniCname + ", moniOfCustcd="
				+ moniOfCustcd + ", slaveContcode=" + slaveContcode + ", mortgageLevelOneName=" + mortgageLevelOneName
				+ ", mortgageLevelTwoName=" + mortgageLevelTwoName + ", mortgageName=" + mortgageName
				+ ", suppProductName=" + suppProductName + ", monitorType=" + monitorType + ", moniModel=" + moniModel
				+ ", protocolCode=" + protocolCode + ", productId=" + productId + "]";
	}

}
