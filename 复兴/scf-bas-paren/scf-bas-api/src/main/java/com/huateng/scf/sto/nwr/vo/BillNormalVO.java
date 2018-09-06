package com.huateng.scf.sto.nwr.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 *  普通仓单质押申请VO
 *
 * @author <a href="mailto:shuang.zhai@huateng.com">shuang.zhai</a>
 *
 * @version Revision: 1.0  Date: 2013-8-5 上午10:28:18
 *
 */
public class BillNormalVO  extends CommonQryVO{
	/**
	 * 
	 */
	private String modelId;
	private String taskName;
	private BigDecimal whReceiptValue;//仓单价值
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String billno;
	private java.lang.String billType;
	private java.lang.String address;
	private java.lang.String postno;
	private java.lang.String warehouseId;
	private java.lang.String storageAddress;
	private java.util.Date signDate;
	private java.lang.String phone;
	private java.lang.String fax;
	private String startDate;
	private String startDate1;
	private String endDate1;
	private String endDate;
	private java.lang.String standLose;
	private String storageCostEndDate;
	private java.lang.String tlrcd;
	private java.lang.String status;
	private java.lang.String reason;
	private java.lang.String billcode;
	private java.lang.String processTemplateName;
	private java.lang.String businessnoType;
	private java.lang.String businessno;
	private java.lang.String custcd;
	private java.math.BigDecimal amt;
	private java.lang.String startBrcode;
	private java.lang.String startTlrcd;
	private java.util.Date startTime;
	private java.lang.String appliStatus;
	private java.lang.String approveBrcode;
	private java.lang.String approver;

	private java.lang.String appTlrcd;
	private java.lang.String slaveContno;
	private java.lang.String slaveContcode;
	private java.lang.String cname;
	private java.lang.String mastContno;
	private java.lang.String protocolNo;
	private java.lang.String supplyChainPdId;
	private java.lang.String mastContcode;
	private java.lang.String registrationNum;
	private java.lang.String brcode;
	private java.lang.String keeperName;
	private java.lang.String insuranceNo;
	private String selectId_Q;
	private String appliMortBizType_Q;
	private String appType;
	private String AppliType;
	private String AppliMortBizType;
	private String appno;
	private String Billno_Q;
	private boolean selectFlag_Q;
	private String keeperName_Q;

    public java.lang.String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(java.lang.String keeperName) {
		this.keeperName = keeperName;
	}
	public java.lang.String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(java.lang.String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	/**
	 * @return the keeperName_Q
	 */
	public String getKeeperName_Q() {
		return keeperName_Q;
	}
	/**
	 * @param keeperName_Q the keeperName_Q to set
	 */
	public void setKeeperName_Q(String keeperName_Q) {
		this.keeperName_Q = keeperName_Q;
	}
	public String getBillno_Q() {
		return Billno_Q;
	}
	public void setBillno_Q(String billno_Q) {
		Billno_Q = billno_Q;
	}
	public String getAppliMortBizType() {
		return AppliMortBizType;
	}
	public void setAppliMortBizType(String appliMortBizType) {
		AppliMortBizType = appliMortBizType;
	}
	public String getAppliType() {
		return AppliType;
	}
	public void setAppliType(String appliType) {
		AppliType = appliType;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getAppliMortBizType_Q() {
		return appliMortBizType_Q;
	}
	public void setAppliMortBizType_Q(String appliMortBizType_Q) {
		this.appliMortBizType_Q = appliMortBizType_Q;
	}
	public String getSelectId_Q() {
		return selectId_Q;
	}
	public void setSelectId_Q(String selectId_Q) {
		this.selectId_Q = selectId_Q;
	}
	public boolean isSelectFlag_Q() {
		return selectFlag_Q;
	}
	public void setSelectFlag_Q(boolean selectFlag_Q) {
		this.selectFlag_Q = selectFlag_Q;
	}
	public java.lang.String getBrcode() {
		return brcode;
	}
	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}
	public java.lang.String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(java.lang.String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
	public java.lang.String getCname() {
		return cname;
	}
	public void setCname(java.lang.String cname) {
		this.cname = cname;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getBillno() {
		return billno;
	}
	public void setBillno(java.lang.String billno) {
		this.billno = billno;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getPostno() {
		return postno;
	}
	public void setPostno(java.lang.String postno) {
		this.postno = postno;
	}
	public java.lang.String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(java.lang.String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public java.lang.String getStorageAddress() {
		return storageAddress;
	}
	public void setStorageAddress(java.lang.String storageAddress) {
		this.storageAddress = storageAddress;
	}
	public java.util.Date getSignDate() {
		return signDate;
	}
	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
	}
	public java.lang.String getPhone() {
		return phone;
	}
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	public java.lang.String getFax() {
		return fax;
	}
	public void setFax(java.lang.String fax) {
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
	public java.lang.String getStandLose() {
		return standLose;
	}
	public void setStandLose(java.lang.String standLose) {
		this.standLose = standLose;
	}
	public String getStorageCostEndDate() {
		return storageCostEndDate;
	}
	public void setStorageCostEndDate(String storageCostEndDate) {
		this.storageCostEndDate = storageCostEndDate;
	}
	public java.lang.String getTlrcd() {
		return tlrcd;
	}
	public void setTlrcd(java.lang.String tlrcd) {
		this.tlrcd = tlrcd;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getReason() {
		return reason;
	}
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	public java.lang.String getBillcode() {
		return billcode;
	}
	public void setBillcode(java.lang.String billcode) {
		this.billcode = billcode;
	}

	public java.lang.String getProcessTemplateName() {
		return processTemplateName;
	}
	public void setProcessTemplateName(java.lang.String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}
	public java.lang.String getBusinessnoType() {
		return businessnoType;
	}
	public void setBusinessnoType(java.lang.String businessnoType) {
		this.businessnoType = businessnoType;
	}
	public java.lang.String getBusinessno() {
		return businessno;
	}
	public void setBusinessno(java.lang.String businessno) {
		this.businessno = businessno;
	}
	public java.lang.String getCustcd() {
		return custcd;
	}
	public void setCustcd(java.lang.String custcd) {
		this.custcd = custcd;
	}
	public java.math.BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}
	public java.lang.String getStartBrcode() {
		return startBrcode;
	}
	public void setStartBrcode(java.lang.String startBrcode) {
		this.startBrcode = startBrcode;
	}
	public java.lang.String getStartTlrcd() {
		return startTlrcd;
	}
	public void setStartTlrcd(java.lang.String startTlrcd) {
		this.startTlrcd = startTlrcd;
	}
	public java.util.Date getStartTime() {
		return startTime;
	}
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	public java.lang.String getAppliStatus() {
		return appliStatus;
	}
	public void setAppliStatus(java.lang.String appliStatus) {
		this.appliStatus = appliStatus;
	}
	public java.lang.String getApproveBrcode() {
		return approveBrcode;
	}
	public void setApproveBrcode(java.lang.String approveBrcode) {
		this.approveBrcode = approveBrcode;
	}
	public java.lang.String getApprover() {
		return approver;
	}
	public void setApprover(java.lang.String approver) {
		this.approver = approver;
	}

	public java.lang.String getAppTlrcd() {
		return appTlrcd;
	}
	public void setAppTlrcd(java.lang.String appTlrcd) {
		this.appTlrcd = appTlrcd;
	}

	public java.lang.String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(java.lang.String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public java.lang.String getMastContno() {
		return mastContno;
	}
	public void setMastContno(java.lang.String mastContno) {
		this.mastContno = mastContno;
	}
	public java.lang.String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(java.lang.String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public java.lang.String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public java.lang.String getMastContcode() {
		return mastContcode;
	}
	public void setMastContcode(java.lang.String mastContcode) {
		this.mastContcode = mastContcode;
	}
	public java.lang.String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(java.lang.String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public String getStartDate1() {
		return startDate1;
	}
	public void setStartDate1(String startDate1) {
		this.startDate1 = startDate1;
	}
	public String getEndDate1() {
		return endDate1;
	}
	public void setEndDate1(String endDate1) {
		this.endDate1 = endDate1;
	}
	public java.lang.String getBillType() {
		return billType;
	}
	public void setBillType(java.lang.String billType) {
		this.billType = billType;
	}
	public BigDecimal getWhReceiptValue() {
		return whReceiptValue;
	}
	public void setWhReceiptValue(BigDecimal whReceiptValue) {
		this.whReceiptValue = whReceiptValue;
	}


}
