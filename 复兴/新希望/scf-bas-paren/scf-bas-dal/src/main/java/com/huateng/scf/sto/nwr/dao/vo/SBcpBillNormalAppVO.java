package com.huateng.scf.sto.nwr.dao.vo;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * <p>普通仓单质押申请VO</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月8日下午5:16:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月8日下午5:16:55	     新增
 *
 * </pre>
 */
public class SBcpBillNormalAppVO{
	
	private String cname;
	private BigDecimal whReceiptValue;
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

	/**
     * VARCHAR(500)<br>
     * 
     */
    private String reason;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
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

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
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

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public String getKeeperName() {
		return keeperName;
	}

	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}
}
