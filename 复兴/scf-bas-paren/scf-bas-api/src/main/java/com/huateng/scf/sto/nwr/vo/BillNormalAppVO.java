package com.huateng.scf.sto.nwr.vo;

import java.util.Date;

import com.huateng.scf.bas.common.model.CommonQryVO;



/**
 *  普通仓单质押申请VO
 *
 * @author <a href="mailto:shuang.zhai@huateng.com">shuang.zhai</a>
 *
 * @version Revision: 1.0  Date: 2013-8-5 上午10:28:18
 *
 */
public class BillNormalAppVO  extends CommonQryVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// primary key
	private String id;
	private String taskComment;
	public String getTaskComment() {
		return taskComment;
	}
	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}
	// fields
	private String billno;
	private String monitorProtocolNo;
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
	private String status;
	private String reason;
	private String billcode;
	private String billType;
	// primary key
	private String appno;


	// fields
	private String piid;
	private String appliType;
	private String processTemplateName;
	private String businessnoType;
	private String businessno;
	private String custcd;
	private java.math.BigDecimal amt;
	private String startBrcode;
	private String startTlrcd;
	private Date stratDate;
	private Date startTime;
	private String appliStatus;
	private String approveBrcode;
	private String approver;
	private Date approveDate;
	private Date approveTime;
	private String description;
	private String workflowAppno;
	private String appliStatusDtl;
	private String curcd;
	private Date appDate;
	private String appTlrcd;
	private String appBrcode;
	private java.math.BigDecimal bailAmount;
	private String slaveContno;
	private String mastContno;
	private String protocolNo;
	private String supplyChainPdId;
	private Date exchangeDate;
	private java.math.BigDecimal creditamt;
	private java.math.BigDecimal stockamt;
	private java.math.BigDecimal riskamt;
	private java.math.BigDecimal lowPriceNew;
	private String memo;
	private String incomeAppno;
	private String applyid;
	private String moniCustcd;
	private String pledgeMode;
	private java.math.BigDecimal deliverValue;
	private String otherProtocolNo;
	private String ext1;
	private String ext2;
	private String ext3;
	private String ebankAppno;
	private String mastContcode;
	private String mortgageNo;
	private String keeperName;
	private String registrationNum;
	private String insuranceNo;//保险单号
	private java.math.BigDecimal contAmount;
	private java.math.BigDecimal whReceiptValue;
	private java.math.BigDecimal theRPAmount;
	private java.math.BigDecimal riskAmount;
	private java.math.BigDecimal removePledgeAmount;
	private java.math.BigDecimal removePledgeHighestAmount;
	private java.math.BigDecimal receiptPledgeAmount;
	private java.math.BigDecimal ration;

    public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	
	public java.math.BigDecimal getWhReceiptValue() {
		return whReceiptValue;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public java.math.BigDecimal getReceiptPledgeAmount() {
		return receiptPledgeAmount;
	}
	public void setReceiptPledgeAmount(java.math.BigDecimal receiptPledgeAmount) {
		this.receiptPledgeAmount = receiptPledgeAmount;
	}
	public void setWhReceiptValue(java.math.BigDecimal whReceiptValue) {
		this.whReceiptValue = whReceiptValue;
	}
	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}
	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}
	public String getMortgageNo() {
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getBillcode() {
		return billcode;
	}
	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public String getAppliType() {
		return appliType;
	}
	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}
	public String getProcessTemplateName() {
		return processTemplateName;
	}
	public void setProcessTemplateName(String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}
	public String getBusinessnoType() {
		return businessnoType;
	}
	public void setBusinessnoType(String businessnoType) {
		this.businessnoType = businessnoType;
	}
	public String getBusinessno() {
		return businessno;
	}
	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public java.math.BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}
	public String getStartBrcode() {
		return startBrcode;
	}
	public void setStartBrcode(String startBrcode) {
		this.startBrcode = startBrcode;
	}
	public String getStartTlrcd() {
		return startTlrcd;
	}
	public void setStartTlrcd(String startTlrcd) {
		this.startTlrcd = startTlrcd;
	}
	public Date getStratDate() {
		return stratDate;
	}
	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getAppliStatus() {
		return appliStatus;
	}
	public void setAppliStatus(String appliStatus) {
		this.appliStatus = appliStatus;
	}
	public String getApproveBrcode() {
		return approveBrcode;
	}
	public void setApproveBrcode(String approveBrcode) {
		this.approveBrcode = approveBrcode;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWorkflowAppno() {
		return workflowAppno;
	}
	public void setWorkflowAppno(String workflowAppno) {
		this.workflowAppno = workflowAppno;
	}
	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}
	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getAppTlrcd() {
		return appTlrcd;
	}
	public void setAppTlrcd(String appTlrcd) {
		this.appTlrcd = appTlrcd;
	}
	public String getAppBrcode() {
		return appBrcode;
	}
	public void setAppBrcode(String appBrcode) {
		this.appBrcode = appBrcode;
	}
	public java.math.BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(java.math.BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public Date getExchangeDate() {
		return exchangeDate;
	}
	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	public java.math.BigDecimal getCreditamt() {
		return creditamt;
	}
	public void setCreditamt(java.math.BigDecimal creditamt) {
		this.creditamt = creditamt;
	}
	public java.math.BigDecimal getStockamt() {
		return stockamt;
	}
	public void setStockamt(java.math.BigDecimal stockamt) {
		this.stockamt = stockamt;
	}
	public java.math.BigDecimal getRiskamt() {
		return riskamt;
	}
	public void setRiskamt(java.math.BigDecimal riskamt) {
		this.riskamt = riskamt;
	}
	public java.math.BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(java.math.BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getIncomeAppno() {
		return incomeAppno;
	}
	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}
	public String getApplyid() {
		return applyid;
	}
	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}
	public String getMoniCustcd() {
		return moniCustcd;
	}
	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}
	public String getPledgeMode() {
		return pledgeMode;
	}
	public void setPledgeMode(String pledgeMode) {
		this.pledgeMode = pledgeMode;
	}
	public java.math.BigDecimal getDeliverValue() {
		return deliverValue;
	}
	public void setDeliverValue(java.math.BigDecimal deliverValue) {
		this.deliverValue = deliverValue;
	}
	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}
	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	public String getEbankAppno() {
		return ebankAppno;
	}
	public void setEbankAppno(String ebankAppno) {
		this.ebankAppno = ebankAppno;
	}
	public String getMastContcode() {
		return mastContcode;
	}
	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}
	public java.math.BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(java.math.BigDecimal contAmount) {
		this.contAmount = contAmount;
	}
	public String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public java.math.BigDecimal getTheRPAmount() {
		return theRPAmount;
	}
	public void setTheRPAmount(java.math.BigDecimal theRPAmount) {
		this.theRPAmount = theRPAmount;
	}
	public java.math.BigDecimal getRiskAmount() {
		return riskAmount;
	}
	public void setRiskAmount(java.math.BigDecimal riskAmount) {
		this.riskAmount = riskAmount;
	}
	public java.math.BigDecimal getRemovePledgeAmount() {
		return removePledgeAmount;
	}
	public void setRemovePledgeAmount(java.math.BigDecimal removePledgeAmount) {
		this.removePledgeAmount = removePledgeAmount;
	}
	public java.math.BigDecimal getRemovePledgeHighestAmount() {
		return removePledgeHighestAmount;
	}
	public void setRemovePledgeHighestAmount(
			java.math.BigDecimal removePledgeHighestAmount) {
		this.removePledgeHighestAmount = removePledgeHighestAmount;
	}
	public java.math.BigDecimal getRation() {
		return ration;
	}
	public void setRation(java.math.BigDecimal ration) {
		this.ration = ration;
	}


}
