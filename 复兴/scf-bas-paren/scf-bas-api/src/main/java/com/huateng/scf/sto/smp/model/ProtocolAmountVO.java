package com.huateng.scf.sto.smp.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;

public class ProtocolAmountVO extends BPbcAppliBaseInfo{
	/**
	 * 
	 */
	private String moniCname;
	public String getMoniCname() {
		return moniCname;
	}
	public void setMoniCname(String moniCname) {
		this.moniCname = moniCname;
	}
	private static final long serialVersionUID = 1L;
	private String id;
	private String serialno;
	private String adviceid;
	private String  protocolCode;
	private String  slaveContcode;
	private String cname;
	private String orgCode;
	private String  idtype;
	private BigDecimal contAmount;
	private BigDecimal lowPrice;
	private BigDecimal lowPriceNew;
	private String attitude;
	private BigDecimal mortAmount;
	private BigDecimal ration;
	private BigDecimal addBailAmount;
	private BigDecimal debtAmount;
	private String coreCustcd;
	private String coreNm;
	private String description;
	private String monitorProtocolNo;
	private BigDecimal totalPrice ;
	private BigDecimal maxDeliverValue;  //可提货金额（此值不保存在数据库中，实时计算出来） add by fengjinfu
	public BigDecimal getMaxDeliverValue() {
		return maxDeliverValue;
	}
	public void setMaxDeliverValue(BigDecimal maxDeliverValue) {
		this.maxDeliverValue = maxDeliverValue;
	}
	private String  moniType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getAdviceid() {
		return adviceid;
	}
	public void setAdviceid(String adviceid) {
		this.adviceid = adviceid;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	public String getAttitude() {
		return attitude;
	}
	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}
	public BigDecimal getMortAmount() {
		return mortAmount;
	}
	public void setMortAmount(BigDecimal mortAmount) {
		this.mortAmount = mortAmount;
	}
	public BigDecimal getRation() {
		return ration;
	}
	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public BigDecimal getDebtAmount() {
		return debtAmount;
	}
	public void setDebtAmount(BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public String getCoreNm() {
		return coreNm;
	}
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}
	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getMoniType() {
		return moniType;
	}
	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}
	
}
