/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;


/**
 * 多方协议信息结果VO
 *
 * @author <a href="mailto:jianfeng.huang@topscf.com">jianfeng.huang</a>
 *
 * @version Revision: 1.0  Date: 2013-5-13 下午2:43:21
 *
 */

public class MoniProtocolVO extends BCntMprotBaseInfo {
	private static final long serialVersionUID = 2086231514162982360L;
	private java.lang.String id;
	private java.lang.String role;
	private java.lang.String custcd;
	private java.lang.String cname;
	private java.lang.String address;
	private java.lang.String legal;
	private java.lang.String actBankno;
	private java.lang.String actno;
	private java.lang.String bailActno;
	private java.lang.String attnTel;
	private java.lang.String fax;
	private java.lang.String postCode;
	private java.lang.String idno;
	private java.lang.String licenseNo;
	private java.lang.String attn;
	private java.lang.String website;
	private java.lang.String mailbox;
	private java.lang.String protocolNo;
	private java.lang.String oldProtocolNo;
	private java.lang.String moniOfCustcd;
	private java.lang.String grouped;
	private java.lang.String groupedMember;
	private java.lang.String moniType;
	private java.math.BigDecimal lowPrice;
	private java.math.BigDecimal lowPriceNew;   //汽车货押用该字段，表示最低控货值
	private java.lang.String moniWarehouseType;
	private java.lang.String moniAreaType;
	private java.lang.String logisticsMoniCondition;
	private java.lang.String warehousedress;
	private java.lang.String mortgagePayType;
	private java.lang.String specialWarehouseCondition;
	private java.lang.String costBear;
	private java.lang.String costStandard;
	private java.math.BigDecimal moniCost;
	private java.lang.String payWay;
	private java.lang.Integer payTime;
	private java.lang.String moniName;
	private java.lang.String moniTel;
	private java.lang.String moniProtocolType;
	private java.lang.String  isHighestLimit;
	private java.lang.String moniPriceModel;
	private java.lang.String  moniModel;
	private java.lang.Integer deallineRate;
	private java.lang.String  warehouseType;
	private java.lang.String  warehouseHireProtocol;
	private java.util.Date  warehouseHireStartDate;
	private java.util.Date  warehouseHireEndDate;
	private java.lang.String  otherDes;
	private java.lang.String  noticeType;
	private java.lang.String firCd;
	private java.lang.String firName;
	private java.lang.String secCd;
	private java.lang.String secCname;
	private java.lang.String thrCd;
	private java.lang.String thrName;
	private java.lang.String slaveContno;
	private java.lang.String slaveContcode;
	private java.math.BigDecimal ration;
	private java.math.BigDecimal seHighestPercent;
	private java.lang.String secName;
	private String balanceAccount;
	private String bailAccount;
	private BigDecimal slaveContAmt;  //合同金额
	private BigDecimal mortgageTotalValue; //押品总价值
	private String otherprotocolCode;
	private String isPledge;


	public java.lang.String getOldProtocolNo() {
		return oldProtocolNo;
	}
	public void setOldProtocolNo(java.lang.String oldProtocolNo) {
		this.oldProtocolNo = oldProtocolNo;
	}
	public BigDecimal getSlaveContAmt() {
		return slaveContAmt;
	}
	public void setSlaveContAmt(BigDecimal slaveContAmt) {
		this.slaveContAmt = slaveContAmt;
	}
	public BigDecimal getMortgageTotalValue() {
		return mortgageTotalValue;
	}
	public void setMortgageTotalValue(BigDecimal mortgageTotalValue) {
		this.mortgageTotalValue = mortgageTotalValue;
	}
	public String getOtherprotocolCode() {
		return otherprotocolCode;
	}
	public void setOtherprotocolCode(String otherprotocolCode) {
		this.otherprotocolCode = otherprotocolCode;
	}
	public String getBalanceAccount() {
		return balanceAccount;
	}
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}
	public String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public java.lang.String getSecName() {
		return secName;
	}
	public void setSecName(java.lang.String secName) {
		this.secName = secName;
	}
	public java.math.BigDecimal getSeHighestPercent() {
		return seHighestPercent;
	}
	public void setSeHighestPercent(java.math.BigDecimal seHighestPercent) {
		this.seHighestPercent = seHighestPercent;
	}
	public java.lang.String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(java.lang.String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public java.lang.String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(java.lang.String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
	public java.lang.String getFirCd() {
		return firCd;
	}
	public void setFirCd(java.lang.String firCd) {
		this.firCd = firCd;
	}
	public java.lang.String getFirName() {
		return firName;
	}
	public void setFirName(java.lang.String firName) {
		this.firName = firName;
	}
	public java.lang.String getSecCd() {
		return secCd;
	}
	public void setSecCd(java.lang.String secCd) {
		this.secCd = secCd;
	}
	public java.lang.String getSecCname() {
		return secCname;
	}
	public void setSecCname(java.lang.String secCname) {
		this.secCname = secCname;
	}
	public java.lang.String getThrCd() {
		return thrCd;
	}
	public void setThrCd(java.lang.String thrCd) {
		this.thrCd = thrCd;
	}
	public java.lang.String getThrName() {
		return thrName;
	}
	public void setThrName(java.lang.String thrName) {
		this.thrName = thrName;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getRole() {
		return role;
	}
	public void setRole(java.lang.String role) {
		this.role = role;
	}
	public java.lang.String getCustcd() {
		return custcd;
	}
	public void setCustcd(java.lang.String custcd) {
		this.custcd = custcd;
	}
	public java.lang.String getCname() {
		return cname;
	}
	public void setCname(java.lang.String cname) {
		this.cname = cname;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getLegal() {
		return legal;
	}
	public void setLegal(java.lang.String legal) {
		this.legal = legal;
	}
	public java.lang.String getActBankno() {
		return actBankno;
	}
	public void setActBankno(java.lang.String actBankno) {
		this.actBankno = actBankno;
	}
	public java.lang.String getActno() {
		return actno;
	}
	public void setActno(java.lang.String actno) {
		this.actno = actno;
	}
	public java.lang.String getBailActno() {
		return bailActno;
	}
	public void setBailActno(java.lang.String bailActno) {
		this.bailActno = bailActno;
	}
	public java.lang.String getAttnTel() {
		return attnTel;
	}
	public void setAttnTel(java.lang.String attnTel) {
		this.attnTel = attnTel;
	}
	public java.lang.String getFax() {
		return fax;
	}
	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}
	public java.lang.String getPostCode() {
		return postCode;
	}
	public void setPostCode(java.lang.String postCode) {
		this.postCode = postCode;
	}
	public java.lang.String getIdno() {
		return idno;
	}
	public void setIdno(java.lang.String idno) {
		this.idno = idno;
	}
	public java.lang.String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(java.lang.String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public java.lang.String getAttn() {
		return attn;
	}
	public void setAttn(java.lang.String attn) {
		this.attn = attn;
	}
	public java.lang.String getWebsite() {
		return website;
	}
	public void setWebsite(java.lang.String website) {
		this.website = website;
	}
	public java.lang.String getMailbox() {
		return mailbox;
	}
	public void setMailbox(java.lang.String mailbox) {
		this.mailbox = mailbox;
	}
	public java.lang.String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(java.lang.String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public java.lang.String getMoniOfCustcd() {
		return moniOfCustcd;
	}
	public void setMoniOfCustcd(java.lang.String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}
	public java.lang.String getGrouped() {
		return grouped;
	}
	public void setGrouped(java.lang.String grouped) {
		this.grouped = grouped;
	}
	public java.lang.String getGroupedMember() {
		return groupedMember;
	}
	public void setGroupedMember(java.lang.String groupedMember) {
		this.groupedMember = groupedMember;
	}
	public java.lang.String getMoniType() {
		return moniType;
	}
	public void setMoniType(java.lang.String moniType) {
		this.moniType = moniType;
	}
	public java.math.BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(java.math.BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public java.math.BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(java.math.BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	public java.lang.String getMoniWarehouseType() {
		return moniWarehouseType;
	}
	public void setMoniWarehouseType(java.lang.String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}
	public java.lang.String getMoniAreaType() {
		return moniAreaType;
	}
	public void setMoniAreaType(java.lang.String moniAreaType) {
		this.moniAreaType = moniAreaType;
	}
	public java.lang.String getLogisticsMoniCondition() {
		return logisticsMoniCondition;
	}
	public void setLogisticsMoniCondition(java.lang.String logisticsMoniCondition) {
		this.logisticsMoniCondition = logisticsMoniCondition;
	}
	public java.lang.String getWarehousedress() {
		return warehousedress;
	}
	public void setWarehousedress(java.lang.String warehousedress) {
		this.warehousedress = warehousedress;
	}
	public java.lang.String getMortgagePayType() {
		return mortgagePayType;
	}
	public void setMortgagePayType(java.lang.String mortgagePayType) {
		this.mortgagePayType = mortgagePayType;
	}
	public java.lang.String getSpecialWarehouseCondition() {
		return specialWarehouseCondition;
	}
	public void setSpecialWarehouseCondition(
			java.lang.String specialWarehouseCondition) {
		this.specialWarehouseCondition = specialWarehouseCondition;
	}
	public java.lang.String getCostBear() {
		return costBear;
	}
	public void setCostBear(java.lang.String costBear) {
		this.costBear = costBear;
	}
	public java.lang.String getCostStandard() {
		return costStandard;
	}
	public void setCostStandard(java.lang.String costStandard) {
		this.costStandard = costStandard;
	}
	public java.math.BigDecimal getMoniCost() {
		return moniCost;
	}
	public void setMoniCost(java.math.BigDecimal moniCost) {
		this.moniCost = moniCost;
	}
	public java.lang.String getPayWay() {
		return payWay;
	}
	public void setPayWay(java.lang.String payWay) {
		this.payWay = payWay;
	}
	public java.lang.Integer getPayTime() {
		return payTime;
	}
	public void setPayTime(java.lang.Integer payTime) {
		this.payTime = payTime;
	}
	public java.lang.String getMoniName() {
		return moniName;
	}
	public void setMoniName(java.lang.String moniName) {
		this.moniName = moniName;
	}
	public java.lang.String getMoniTel() {
		return moniTel;
	}
	public void setMoniTel(java.lang.String moniTel) {
		this.moniTel = moniTel;
	}
	public java.lang.String getMoniProtocolType() {
		return moniProtocolType;
	}
	public void setMoniProtocolType(java.lang.String moniProtocolType) {
		this.moniProtocolType = moniProtocolType;
	}
	public java.lang.String getIsHighestLimit() {
		return isHighestLimit;
	}
	public void setIsHighestLimit(java.lang.String isHighestLimit) {
		this.isHighestLimit = isHighestLimit;
	}
	public java.lang.String getMoniPriceModel() {
		return moniPriceModel;
	}
	public void setMoniPriceModel(java.lang.String moniPriceModel) {
		this.moniPriceModel = moniPriceModel;
	}
	public java.lang.String getMoniModel() {
		return moniModel;
	}
	public void setMoniModel(java.lang.String moniModel) {
		this.moniModel = moniModel;
	}
	public java.lang.Integer getDeallineRate() {
		return deallineRate;
	}
	public void setDeallineRate(java.lang.Integer deallineRate) {
		this.deallineRate = deallineRate;
	}
	public java.lang.String getWarehouseType() {
		return warehouseType;
	}
	public void setWarehouseType(java.lang.String warehouseType) {
		this.warehouseType = warehouseType;
	}
	public java.lang.String getWarehouseHireProtocol() {
		return warehouseHireProtocol;
	}
	public void setWarehouseHireProtocol(java.lang.String warehouseHireProtocol) {
		this.warehouseHireProtocol = warehouseHireProtocol;
	}
	public java.util.Date getWarehouseHireStartDate() {
		return warehouseHireStartDate;
	}
	public void setWarehouseHireStartDate(java.util.Date warehouseHireStartDate) {
		this.warehouseHireStartDate = warehouseHireStartDate;
	}
	public java.util.Date getWarehouseHireEndDate() {
		return warehouseHireEndDate;
	}
	public void setWarehouseHireEndDate(java.util.Date warehouseHireEndDate) {
		this.warehouseHireEndDate = warehouseHireEndDate;
	}
	public java.lang.String getOtherDes() {
		return otherDes;
	}
	public void setOtherDes(java.lang.String otherDes) {
		this.otherDes = otherDes;
	}
	public java.lang.String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(java.lang.String noticeType) {
		this.noticeType = noticeType;
	}
	public java.math.BigDecimal getRation() {
		return ration;
	}
	public void setRation(java.math.BigDecimal ration) {
		this.ration = ration;
	}
	public String getIsPledge() {
		return isPledge;
	}
	public void setIsPledge(String isPledge) {
		this.isPledge = isPledge;
	}
}
