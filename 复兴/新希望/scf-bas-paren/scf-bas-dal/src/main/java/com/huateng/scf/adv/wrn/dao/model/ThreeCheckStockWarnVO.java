package com.huateng.scf.adv.wrn.dao.model;

/**
 * @author htrad0055
 *
 * 担保提货发货对账不平预警
 *
 */
public class ThreeCheckStockWarnVO extends BWanMortCheckInfo{
	
	private static final long serialVersionUID = 3845328625443916844L;
	private String warnDate;
	private java.lang.String paramId;
	private java.lang.String warnLevel;
	private java.lang.String status;
	private java.util.Date suspendDate;
	private java.lang.Integer suspendDays;
	private java.lang.String suspendTlrno;
	private java.lang.String processTlrno;
	private java.util.Date processDate;
	private java.lang.String custManager;
	private java.lang.String brcode;
	private java.util.Date warnDueDate;
	private java.util.Date lastUpdDate;
	private String productId;//业务品种
	private String topProductId;//产品大类
	private String mgrName;
	private String brName;
	private String productName;
	
	public String getWarnDate() {
		return warnDate;
	}
	public void setWarnDate(String warnDate) {
		this.warnDate = warnDate;
	}
	public java.lang.String getParamId() {
		return paramId;
	}
	public void setParamId(java.lang.String paramId) {
		this.paramId = paramId;
	}
	public java.lang.String getWarnLevel() {
		return warnLevel;
	}
	public void setWarnLevel(java.lang.String warnLevel) {
		this.warnLevel = warnLevel;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.util.Date getSuspendDate() {
		return suspendDate;
	}
	public void setSuspendDate(java.util.Date suspendDate) {
		this.suspendDate = suspendDate;
	}
	public java.lang.Integer getSuspendDays() {
		return suspendDays;
	}
	public void setSuspendDays(java.lang.Integer suspendDays) {
		this.suspendDays = suspendDays;
	}
	public java.lang.String getSuspendTlrno() {
		return suspendTlrno;
	}
	public void setSuspendTlrno(java.lang.String suspendTlrno) {
		this.suspendTlrno = suspendTlrno;
	}
	public java.lang.String getProcessTlrno() {
		return processTlrno;
	}
	public void setProcessTlrno(java.lang.String processTlrno) {
		this.processTlrno = processTlrno;
	}
	public java.util.Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(java.util.Date processDate) {
		this.processDate = processDate;
	}
	public java.lang.String getCustManager() {
		return custManager;
	}
	public void setCustManager(java.lang.String custManager) {
		this.custManager = custManager;
	}
	public java.lang.String getBrcode() {
		return brcode;
	}
	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}
	public java.util.Date getWarnDueDate() {
		return warnDueDate;
	}
	public void setWarnDueDate(java.util.Date warnDueDate) {
		this.warnDueDate = warnDueDate;
	}
	public java.util.Date getLastUpdDate() {
		return lastUpdDate;
	}
	public void setLastUpdDate(java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTopProductId() {
		return topProductId;
	}
	public void setTopProductId(String topProductId) {
		this.topProductId = topProductId;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
