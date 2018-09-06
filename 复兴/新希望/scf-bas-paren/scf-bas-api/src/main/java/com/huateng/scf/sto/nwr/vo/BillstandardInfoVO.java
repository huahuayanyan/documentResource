/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.sto.nwr.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.crr.model.BCrrGntyCon;

/**
 *  标准仓单和质押合同信息VO
 *
 * @author <a href="mailto:huangshan@topscf.com">huangshan</a>
 *
 * @version Revision: 1.0  Date: 2013-9-12 上午09:55:39
 *
 */

public class BillstandardInfoVO extends BCrrGntyCon{
	/**
	 * 
	 */
	private String cname;
	private BigDecimal whReceiptValue;
    public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	private String billType;
    
    public BigDecimal getWhReceiptValue() {
		return whReceiptValue;
	}

	public void setWhReceiptValue(BigDecimal whReceiptValue) {
		this.whReceiptValue = whReceiptValue;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String billno;
	private String billcode;
	private String exchangeName;
	private String custcd;
	private String seatcd;
	private String tradecd;
	private String address;
	private String postno;
	private String warehouseId;
	private String storageAddress;
	private Date signDate;
	private String phone;
	private String fax;
	private String startDate;
	private String endDate;
	private String standLose;
	private String storageCostEndDate;
	private String tlrcd;
	private String gallerycd;
	private String galleryName;
	private String pawneeName;
	private String specialTradeCode;
	private String futureCustcd;
	private Date billDueDate;
	private String brcode;
	private Date confirmDate;
	private String mastContno;
	private String slaveContno;
	private String status;
	private String registrationNum;
	private Date pledgeDate;
	private String firCd;
	private boolean select;
	private String m_package;
	private String insuranceNo;
	private String keeperName;

	public String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}
	public String getPackage() {
		return m_package;
	}
	public void setPackage(String m_package) {
		this.m_package = m_package;
	}
	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getBillcode() {
		return billcode;
	}
	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getSeatcd() {
		return seatcd;
	}
	public void setSeatcd(String seatcd) {
		this.seatcd = seatcd;
	}
	public String getTradecd() {
		return tradecd;
	}
	public void setTradecd(String tradecd) {
		this.tradecd = tradecd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostno() {
		return postno;
	}
	public void setPostno(String postno) {
		this.postno = postno;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getStorageAddress() {
		return storageAddress;
	}
	public void setStorageAddress(String storageAddress) {
		this.storageAddress = storageAddress;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public String getStandLose() {
		return standLose;
	}
	public void setStandLose(String standLose) {
		this.standLose = standLose;
	}
	public String getStorageCostEndDate() {
		return storageCostEndDate;
	}
	public void setStorageCostEndDate(String storageCostEndDate) {
		this.storageCostEndDate = storageCostEndDate;
	}
	public String getTlrcd() {
		return tlrcd;
	}
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}
	public String getGallerycd() {
		return gallerycd;
	}
	public void setGallerycd(String gallerycd) {
		this.gallerycd = gallerycd;
	}
	public String getGalleryName() {
		return galleryName;
	}
	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}
	public String getPawneeName() {
		return pawneeName;
	}
	public void setPawneeName(String pawneeName) {
		this.pawneeName = pawneeName;
	}
	public String getSpecialTradeCode() {
		return specialTradeCode;
	}
	public void setSpecialTradeCode(String specialTradeCode) {
		this.specialTradeCode = specialTradeCode;
	}
	public String getFutureCustcd() {
		return futureCustcd;
	}
	public void setFutureCustcd(String futureCustcd) {
		this.futureCustcd = futureCustcd;
	}
	public Date getBillDueDate() {
		return billDueDate;
	}
	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public Date getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public Date getPledgeDate() {
		return pledgeDate;
	}
	public void setPledgeDate(Date pledgeDate) {
		this.pledgeDate = pledgeDate;
	}
	public String getFirCd() {
		return firCd;
	}
	public void setFirCd(String firCd) {
		this.firCd = firCd;
	}


}
