package com.huateng.scf.sto.nwr.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BPbcPricingBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键ID
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 申请号
     */
    private String appno;

    /**
     * VARCHAR(20)<br>
     * 核价编号
     */
    private String pricingNo;

    /**
     * VARCHAR(20)<br>
     * 核办支行/部门
     */
    private String approveBrcode;

    /**
     * VARCHAR(15) 必填<br>
     * 授信客户号
     */
    private String custcd;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniOfCustcd;

    /**
     * VARCHAR(300)<br>
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * VARCHAR(2)<br>
     * 监管模式
     */
    private String moniModel;

    /**
     * CHAR(2)<br>
     * 核价原因
     */
    private String pricingReason;

    /**
     * CHAR(8)<br>
     * 核价日期
     */
    private String pricingDate;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String monitorProtocolNo;

    /**
     * VARCHAR(32)<br>
     * 当前已审批人员
     */
    private String approver;

    /**
     * CHAR(8)<br>
     * 审批日期
     */
    private String approveDate;

    /**
     * VARCHAR(32) 必填<br>
     * 申请人
     */
    private String appTlrcd;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 申请时间
     */
    private Date appDate;

    /**
     * VARCHAR(200)<br>
     * 
     */
    private String otherReason;

    /**
     * CHAR(4)<br>
     * 
     */
    private String appliType;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 核价编号
     */
    public String getPricingNo() {
        return pricingNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 核价编号
     */
    public void setPricingNo(String pricingNo) {
        this.pricingNo = pricingNo == null ? null : pricingNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 核办支行/部门
     */
    public String getApproveBrcode() {
        return approveBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 核办支行/部门
     */
    public void setApproveBrcode(String approveBrcode) {
        this.approveBrcode = approveBrcode == null ? null : approveBrcode.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 授信客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 授信客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniOfCustcd() {
        return moniOfCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniOfCustcd(String moniOfCustcd) {
        this.moniOfCustcd = moniOfCustcd == null ? null : moniOfCustcd.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 仓库地址
     */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 仓库地址
     */
    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress == null ? null : warehouseAddress.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 监管模式
     */
    public String getMoniModel() {
        return moniModel;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 监管模式
     */
    public void setMoniModel(String moniModel) {
        this.moniModel = moniModel == null ? null : moniModel.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 核价原因
     */
    public String getPricingReason() {
        return pricingReason;
    }

    /**
     * CHAR(2)<br>
     * 设置 核价原因
     */
    public void setPricingReason(String pricingReason) {
        this.pricingReason = pricingReason == null ? null : pricingReason.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 核价日期
     */
    public String getPricingDate() {
        return pricingDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 核价日期
     */
    public void setPricingDate(String pricingDate) {
        this.pricingDate = pricingDate == null ? null : pricingDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管协议号
     */
    public String getMonitorProtocolNo() {
        return monitorProtocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管协议号
     */
    public void setMonitorProtocolNo(String monitorProtocolNo) {
        this.monitorProtocolNo = monitorProtocolNo == null ? null : monitorProtocolNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 当前已审批人员
     */
    public String getApprover() {
        return approver;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 当前已审批人员
     */
    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 审批日期
     */
    public String getApproveDate() {
        return approveDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 审批日期
     */
    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate == null ? null : approveDate.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 申请人
     */
    public String getAppTlrcd() {
        return appTlrcd;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 申请人
     */
    public void setAppTlrcd(String appTlrcd) {
        this.appTlrcd = appTlrcd == null ? null : appTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 申请时间
     */
    public Date getAppDate() {
        return appDate;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 申请时间
     */
    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    /**
     * VARCHAR(200)<br>
     */
    public String getOtherReason() {
        return otherReason;
    }

    /**
     * VARCHAR(200)<br>
     */
    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason == null ? null : otherReason.trim();
    }

    /**
     * CHAR(4)<br>
     */
    public String getAppliType() {
        return appliType;
    }

    /**
     * CHAR(4)<br>
     */
    public void setAppliType(String appliType) {
        this.appliType = appliType == null ? null : appliType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", pricingNo=").append(pricingNo);
        sb.append(", approveBrcode=").append(approveBrcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", moniModel=").append(moniModel);
        sb.append(", pricingReason=").append(pricingReason);
        sb.append(", pricingDate=").append(pricingDate);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", monitorProtocolNo=").append(monitorProtocolNo);
        sb.append(", approver=").append(approver);
        sb.append(", approveDate=").append(approveDate);
        sb.append(", appTlrcd=").append(appTlrcd);
        sb.append(", appDate=").append(appDate);
        sb.append(", otherReason=").append(otherReason);
        sb.append(", appliType=").append(appliType);
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
        BPbcPricingBaseInfo other = (BPbcPricingBaseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getPricingNo() == null ? other.getPricingNo() == null : this.getPricingNo().equals(other.getPricingNo()))
            && (this.getApproveBrcode() == null ? other.getApproveBrcode() == null : this.getApproveBrcode().equals(other.getApproveBrcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getMoniModel() == null ? other.getMoniModel() == null : this.getMoniModel().equals(other.getMoniModel()))
            && (this.getPricingReason() == null ? other.getPricingReason() == null : this.getPricingReason().equals(other.getPricingReason()))
            && (this.getPricingDate() == null ? other.getPricingDate() == null : this.getPricingDate().equals(other.getPricingDate()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getMonitorProtocolNo() == null ? other.getMonitorProtocolNo() == null : this.getMonitorProtocolNo().equals(other.getMonitorProtocolNo()))
            && (this.getApprover() == null ? other.getApprover() == null : this.getApprover().equals(other.getApprover()))
            && (this.getApproveDate() == null ? other.getApproveDate() == null : this.getApproveDate().equals(other.getApproveDate()))
            && (this.getAppTlrcd() == null ? other.getAppTlrcd() == null : this.getAppTlrcd().equals(other.getAppTlrcd()))
            && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
            && (this.getOtherReason() == null ? other.getOtherReason() == null : this.getOtherReason().equals(other.getOtherReason()))
            && (this.getAppliType() == null ? other.getAppliType() == null : this.getAppliType().equals(other.getAppliType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getPricingNo() == null) ? 0 : getPricingNo().hashCode());
        result = prime * result + ((getApproveBrcode() == null) ? 0 : getApproveBrcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getMoniModel() == null) ? 0 : getMoniModel().hashCode());
        result = prime * result + ((getPricingReason() == null) ? 0 : getPricingReason().hashCode());
        result = prime * result + ((getPricingDate() == null) ? 0 : getPricingDate().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getMonitorProtocolNo() == null) ? 0 : getMonitorProtocolNo().hashCode());
        result = prime * result + ((getApprover() == null) ? 0 : getApprover().hashCode());
        result = prime * result + ((getApproveDate() == null) ? 0 : getApproveDate().hashCode());
        result = prime * result + ((getAppTlrcd() == null) ? 0 : getAppTlrcd().hashCode());
        result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
        result = prime * result + ((getOtherReason() == null) ? 0 : getOtherReason().hashCode());
        result = prime * result + ((getAppliType() == null) ? 0 : getAppliType().hashCode());
        return result;
    }
}