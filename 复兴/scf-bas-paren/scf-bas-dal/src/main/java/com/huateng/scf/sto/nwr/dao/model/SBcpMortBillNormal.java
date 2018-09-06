package com.huateng.scf.sto.nwr.dao.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <p>SBcpMortBillNormal非标准仓单信息表实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午3:57:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午3:57:42	     新增
 *
 * </pre>
 */
public class SBcpMortBillNormal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 仓单编号
     */
    private String billno;

    /**
     * VARCHAR(100)<br>
     * 仓单代码
     */
    private String billcode;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(100)<br>
     * 地址
     */
    private String address;

    /**
     * CHAR(6)<br>
     * 邮编
     */
    private String postno;

    /**
     * VARCHAR(19)<br>
     * 仓库编号
     */
    private String warehouseId;

    /**
     * VARCHAR(100)<br>
     * 存放地址
     */
    private String storageAddress;

    /**
     * DATE(7)<br>
     * 签署日期
     */
    private Date signDate;

    /**
     * VARCHAR(30)<br>
     * 电话
     */
    private String phone;

    /**
     * VARCHAR(30)<br>
     * 传真
     */
    private String fax;

    /**
     * CHAR(8)<br>
     * 开始日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 结束日期
     */
    private String endDate;

    /**
     * VARCHAR(50)<br>
     * 标准损耗
     */
    private String standLose;

    /**
     * CHAR(8)<br>
     * 监管费用到期日
     */
    private String storageCostEndDate;

    /**
     * VARCHAR(20)<br>
     * 客户经理
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(20)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(50)<br>
     * 登记批次号
     */
    private String registrationNum;

    /**
     * VARCHAR(20)<br>
     * 保管人名称
     */
    private String keeperName;

    /**
     * VARCHAR(20)<br>
     * 保险单号
     */
    private String insuranceNo;

    /**
     * VARCHAR(10)<br>
     * 仓单类型：0-电子、1-纸质
     */
    private String billType;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 仓单编号
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 仓单编号
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 仓单代码
     */
    public String getBillcode() {
        return billcode;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓单代码
     */
    public void setBillcode(String billcode) {
        this.billcode = billcode == null ? null : billcode.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 邮编
     */
    public String getPostno() {
        return postno;
    }

    /**
     * CHAR(6)<br>
     * 设置 邮编
     */
    public void setPostno(String postno) {
        this.postno = postno == null ? null : postno.trim();
    }

    /**
     * VARCHAR(19)<br>
     * 获得 仓库编号
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * VARCHAR(19)<br>
     * 设置 仓库编号
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 存放地址
     */
    public String getStorageAddress() {
        return storageAddress;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 存放地址
     */
    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress == null ? null : storageAddress.trim();
    }

    /**
     * DATE(7)<br>
     * 获得 签署日期
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * DATE(7)<br>
     * 设置 签署日期
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * VARCHAR(30)<br>
     * 获得 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 开始日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 开始日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 结束日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 结束日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 标准损耗
     */
    public String getStandLose() {
        return standLose;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 标准损耗
     */
    public void setStandLose(String standLose) {
        this.standLose = standLose == null ? null : standLose.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 监管费用到期日
     */
    public String getStorageCostEndDate() {
        return storageCostEndDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 监管费用到期日
     */
    public void setStorageCostEndDate(String storageCostEndDate) {
        this.storageCostEndDate = storageCostEndDate == null ? null : storageCostEndDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户经理
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户经理
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 主合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 主合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
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
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 登记批次号
     */
    public String getRegistrationNum() {
        return registrationNum;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 登记批次号
     */
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum == null ? null : registrationNum.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 保管人名称
     */
    public String getKeeperName() {
        return keeperName;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 保管人名称
     */
    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName == null ? null : keeperName.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 保险单号
     */
    public String getInsuranceNo() {
        return insuranceNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 保险单号
     */
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 仓单类型：0-电子、1-纸质
     */
    public String getBillType() {
        return billType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 仓单类型：0-电子、1-纸质
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
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
        sb.append(", brcode=").append(brcode);
        sb.append(", registrationNum=").append(registrationNum);
        sb.append(", keeperName=").append(keeperName);
        sb.append(", insuranceNo=").append(insuranceNo);
        sb.append(", billType=").append(billType);
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
        SBcpMortBillNormal other = (SBcpMortBillNormal) that;
        return (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
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
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getRegistrationNum() == null ? other.getRegistrationNum() == null : this.getRegistrationNum().equals(other.getRegistrationNum()))
            && (this.getKeeperName() == null ? other.getKeeperName() == null : this.getKeeperName().equals(other.getKeeperName()))
            && (this.getInsuranceNo() == null ? other.getInsuranceNo() == null : this.getInsuranceNo().equals(other.getInsuranceNo()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getRegistrationNum() == null) ? 0 : getRegistrationNum().hashCode());
        result = prime * result + ((getKeeperName() == null) ? 0 : getKeeperName().hashCode());
        result = prime * result + ((getInsuranceNo() == null) ? 0 : getInsuranceNo().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        return result;
    }
}