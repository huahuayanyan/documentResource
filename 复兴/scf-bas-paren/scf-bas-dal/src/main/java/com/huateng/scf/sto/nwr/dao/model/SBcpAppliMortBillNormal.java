package com.huateng.scf.sto.nwr.dao.model;

import java.io.Serializable;
import java.util.Date;

public class SBcpAppliMortBillNormal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
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
     * CHAR(15)<br>
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
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String slaveContno;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String status;

    /**
     * VARCHAR(500)<br>
     * 
     */
    private String reason;

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
     * VARCHAR(20) 必填<br>
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
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
     * CHAR(15)<br>
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * CHAR(15)<br>
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

    /**
     * VARCHAR(500)<br>
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(500)<br>
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", billno=").append(billno);
        sb.append(", billcode=").append(billcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", address=").append(address);
        sb.append(", postno=").append(postno);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", storageAddress=").append(storageAddress);
        sb.append(", signDate=").append(signDate);
        sb.append(", phone=").append(phone);
        sb.append(", fax=").append(fax);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", standLose=").append(standLose);
        sb.append(", storageCostEndDate=").append(storageCostEndDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", status=").append(status);
        sb.append(", reason=").append(reason);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SBcpAppliMortBillNormal other = (SBcpAppliMortBillNormal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getBillcode() == null ? other.getBillcode() == null : this.getBillcode().equals(other.getBillcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPostno() == null ? other.getPostno() == null : this.getPostno().equals(other.getPostno()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getStorageAddress() == null ? other.getStorageAddress() == null : this.getStorageAddress().equals(other.getStorageAddress()))
            && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getStandLose() == null ? other.getStandLose() == null : this.getStandLose().equals(other.getStandLose()))
            && (this.getStorageCostEndDate() == null ? other.getStorageCostEndDate() == null : this.getStorageCostEndDate().equals(other.getStorageCostEndDate()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getBillcode() == null) ? 0 : getBillcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPostno() == null) ? 0 : getPostno().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getStorageAddress() == null) ? 0 : getStorageAddress().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getStandLose() == null) ? 0 : getStandLose().hashCode());
        result = prime * result + ((getStorageCostEndDate() == null) ? 0 : getStorageCostEndDate().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        return result;
    }
}