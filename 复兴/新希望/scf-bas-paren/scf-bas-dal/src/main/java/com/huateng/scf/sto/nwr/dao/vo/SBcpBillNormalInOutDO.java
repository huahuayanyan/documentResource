package com.huateng.scf.sto.nwr.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class SBcpBillNormalInOutDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cname;
    private String tlrname;
    public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTlrname() {
		return tlrname;
	}

	public void setTlrname(String tlrname) {
		this.tlrname = tlrname;
	}

	/**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String pid;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String billno;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String billcode;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String slaveContno;

    /**
     * VARCHAR(15)<br>
     * 
     */
    private String custcd;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String address;

    /**
     * CHAR(6)<br>
     * 
     */
    private String postno;

    /**
     * VARCHAR(19)<br>
     * 
     */
    private String warehouseId;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String storageAddress;

    /**
     * DATE(7)<br>
     * 
     */
    private Date signDate;

    /**
     * VARCHAR(30)<br>
     * 
     */
    private String phone;

    /**
     * VARCHAR(30)<br>
     * 
     */
    private String fax;

    /**
     * CHAR(8)<br>
     * 
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 
     */
    private String endDate;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String standLose;

    /**
     * CHAR(8)<br>
     * 
     */
    private String storageCostEndDate;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String status;

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getPid() {
        return pid;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getBillcode() {
        return billcode;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setBillcode(String billcode) {
        this.billcode = billcode == null ? null : billcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(15)<br>
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getAddress() {
        return address;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * CHAR(6)<br>
     */
    public String getPostno() {
        return postno;
    }

    /**
     * CHAR(6)<br>
     */
    public void setPostno(String postno) {
        this.postno = postno == null ? null : postno.trim();
    }

    /**
     * VARCHAR(19)<br>
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * VARCHAR(19)<br>
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getStorageAddress() {
        return storageAddress;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress == null ? null : storageAddress.trim();
    }

    /**
     * DATE(7)<br>
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * VARCHAR(30)<br>
     */
    public String getPhone() {
        return phone;
    }

    /**
     * VARCHAR(30)<br>
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * VARCHAR(30)<br>
     */
    public String getFax() {
        return fax;
    }

    /**
     * VARCHAR(30)<br>
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getStandLose() {
        return standLose;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setStandLose(String standLose) {
        this.standLose = standLose == null ? null : standLose.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getStorageCostEndDate() {
        return storageCostEndDate;
    }

    /**
     * CHAR(8)<br>
     */
    public void setStorageCostEndDate(String storageCostEndDate) {
        this.storageCostEndDate = storageCostEndDate == null ? null : storageCostEndDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}