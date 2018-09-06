package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class BillstandardAppVO extends CommonQryVO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appliStatusDtl_Q;
	private String appType_Q;
	private String billno_Q;
	private String monitorProtocolNo_Q;
	private String otherProtocolNo_Q;
	private String supplyChainPdId_Q;

	private String id;
	private String appno;
	private String mastContno;
	private String slaveContno;
	private String cname;
	private String appliStatusDtl;
	private String appliStatus;
	private String planMoniEntNm;
	private String startTlrcdNm;
	private String startBrhNm;
	private java.util.Date stratDate;
	private String appTlrNm;
	private String appBrNm;
	private java.util.Date appDate;
	private java.math.BigDecimal amt;
	private java.math.BigDecimal slaveContAmt;
	private java.math.BigDecimal contAmount;

	private String custcd;
	private String productId;
	private String dataNo;


	private java.lang.String billno;
	private java.lang.String billcode;
	private java.lang.String exchangeName;
	private java.lang.String seatcd;
	private java.lang.String tradecd;
	private java.lang.String address;
	private java.lang.String postno;
	private java.lang.String warehouseId;
	private java.lang.String storageAddress;
	private java.util.Date signDate;
	private java.lang.String phone;
	private java.lang.String fax;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.String standLose;
	private java.util.Date storageCostEndDate;
	private java.lang.String tlrcd;
	private java.lang.String gallerycd;
	private java.lang.String galleryName;
	private java.lang.String pawneeName;
	private java.lang.String specialTradeCode;
	private java.lang.String futureCustcd;
	private java.util.Date billDueDate;
	private java.lang.String brcode;
	private java.util.Date confirmDate;
	private java.lang.String reason;
	private java.lang.String status;
	private java.lang.String registrationNum;
	private java.util.Date pledgeDate;
	private java.lang.String firCd;
	private java.lang.String secCd;

	private java.lang.String piid;
	private java.lang.String appliType;
	private java.lang.String processTemplateName;
	private java.lang.String businessnoType;
	private java.lang.String businessno;
	private java.lang.String startBrcode;
	private java.lang.String startTlrcd;
	private java.util.Date startTime;
	private java.lang.String approveBrcode;
	private java.lang.String approver;
	private java.util.Date approveDate;
	private java.util.Date approveTime;
	private java.lang.String description;
	private java.lang.String workflowAppno;
	private java.lang.String curcd;
	private java.lang.String appTlrcd;
	private java.lang.String appBrcode;
	private java.math.BigDecimal bailAmount;
	private java.lang.String protocolNo;
	private java.lang.String supplyChainPdId;
	private java.util.Date exchangeDate;
	private java.math.BigDecimal creditamt;
	private java.math.BigDecimal stockamt;
	private java.math.BigDecimal riskamt;
	private java.math.BigDecimal lowPriceNew;
	private java.lang.String memo;
	private java.lang.String incomeAppno;
	private java.lang.String applyid;
	private java.lang.String moniCustcd;
	private java.lang.String pledgeMode;
	private java.math.BigDecimal deliverValue;
	private java.lang.String otherProtocolNo;
	private java.lang.String ext1;
	private java.lang.String ext2;
	private java.lang.String ext3;
	private java.lang.String ebankAppno;
	private java.lang.String mastContcode;


	private String futureCname;
	private String appliMortBizType;

	private java.util.Date insertDate;
	private java.util.Date effectDate;
	private java.lang.String type;
	private java.lang.String misc;
	private java.lang.String mortgageNo;


	public java.math.BigDecimal getContAmount() {
		return contAmount;
	}
	public void setContAmount(java.math.BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	public String getAppliStatusDtl_Q()
	{
		return appliStatusDtl_Q;
	}

	public void setAppliStatusDtl_Q(String appliStatusDtl_Q)
	{
		this.appliStatusDtl_Q = appliStatusDtl_Q;
	}

	public String getAppno()
	{
		return appno;
	}

	public void setAppno(String appno)
	{
		this.appno = appno;
	}

	public String getMastContno()
	{
		return mastContno;
	}

	public void setMastContno(String mastContno)
	{
		this.mastContno = mastContno;
	}

	public String getSlaveContno()
	{
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno)
	{
		this.slaveContno = slaveContno;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getAppliStatusDtl()
	{
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl)
	{
		this.appliStatusDtl = appliStatusDtl;
	}

	public String getAppliStatus()
	{
		return appliStatus;
	}

	public void setAppliStatus(String appliStatus)
	{
		this.appliStatus = appliStatus;
	}

	public String getPlanMoniEntNm()
	{
		return planMoniEntNm;
	}

	public void setPlanMoniEntNm(String planMoniEntNm)
	{
		this.planMoniEntNm = planMoniEntNm;
	}

	public String getStartTlrcdNm()
	{
		return startTlrcdNm;
	}

	public void setStartTlrcdNm(String startTlrcdNm)
	{
		this.startTlrcdNm = startTlrcdNm;
	}

	public String getStartBrhNm()
	{
		return startBrhNm;
	}

	public void setStartBrhNm(String startBrhNm)
	{
		this.startBrhNm = startBrhNm;
	}

	public java.util.Date getStratDate()
	{
		return stratDate;
	}

	public void setStratDate(java.util.Date stratDate)
	{
		this.stratDate = stratDate;
	}

	public String getAppTlrNm()
	{
		return appTlrNm;
	}

	public void setAppTlrNm(String appTlrNm)
	{
		this.appTlrNm = appTlrNm;
	}

	public String getAppBrNm()
	{
		return appBrNm;
	}

	public void setAppBrNm(String appBrNm)
	{
		this.appBrNm = appBrNm;
	}

	public java.util.Date getAppDate()
	{
		return appDate;
	}

	public void setAppDate(java.util.Date appDate)
	{
		this.appDate = appDate;
	}

	public java.math.BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(java.math.BigDecimal amt)
	{
		this.amt = amt;
	}

	public java.math.BigDecimal getSlaveContAmt()
	{
		return slaveContAmt;
	}

	public void setSlaveContAmt(java.math.BigDecimal slaveContAmt)
	{
		this.slaveContAmt = slaveContAmt;
	}

	public String getCustcd()
	{
		return custcd;
	}

	public void setCustcd(String custcd)
	{
		this.custcd = custcd;
	}

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getDataNo()
	{
		return dataNo;
	}

	public void setDataNo(String dataNo)
	{
		this.dataNo = dataNo;
	}
	public String getAppType_Q()
	{
		return appType_Q;
	}
	public void setAppType_Q(String appType_Q)
	{
		this.appType_Q = appType_Q;
	}
	public String getBillno_Q()
	{
		return billno_Q;
	}
	public void setBillno_Q(String billno_Q)
	{
		this.billno_Q = billno_Q;
	}
	public java.lang.String getBillno()
	{
		return billno;
	}
	public void setBillno(java.lang.String billno)
	{
		this.billno = billno;
	}
	public java.lang.String getBillcode()
	{
		return billcode;
	}
	public void setBillcode(java.lang.String billcode)
	{
		this.billcode = billcode;
	}
	public java.lang.String getExchangeName()
	{
		return exchangeName;
	}
	public void setExchangeName(java.lang.String exchangeName)
	{
		this.exchangeName = exchangeName;
	}
	public java.lang.String getSeatcd()
	{
		return seatcd;
	}
	public void setSeatcd(java.lang.String seatcd)
	{
		this.seatcd = seatcd;
	}
	public java.lang.String getTradecd()
	{
		return tradecd;
	}
	public void setTradecd(java.lang.String tradecd)
	{
		this.tradecd = tradecd;
	}
	public java.lang.String getAddress()
	{
		return address;
	}
	public void setAddress(java.lang.String address)
	{
		this.address = address;
	}
	public java.lang.String getPostno()
	{
		return postno;
	}
	public void setPostno(java.lang.String postno)
	{
		this.postno = postno;
	}
	public java.lang.String getWarehouseId()
	{
		return warehouseId;
	}
	public void setWarehouseId(java.lang.String warehouseId)
	{
		this.warehouseId = warehouseId;
	}
	public java.lang.String getStorageAddress()
	{
		return storageAddress;
	}
	public void setStorageAddress(java.lang.String storageAddress)
	{
		this.storageAddress = storageAddress;
	}
	public java.util.Date getSignDate()
	{
		return signDate;
	}
	public void setSignDate(java.util.Date signDate)
	{
		this.signDate = signDate;
	}
	public java.lang.String getPhone()
	{
		return phone;
	}
	public void setPhone(java.lang.String phone)
	{
		this.phone = phone;
	}
	public java.lang.String getFax()
	{
		return fax;
	}
	public void setFax(java.lang.String fax)
	{
		this.fax = fax;
	}
	public java.util.Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(java.util.Date startDate)
	{
		this.startDate = startDate;
	}
	public java.util.Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(java.util.Date endDate)
	{
		this.endDate = endDate;
	}
	public java.lang.String getStandLose()
	{
		return standLose;
	}
	public void setStandLose(java.lang.String standLose)
	{
		this.standLose = standLose;
	}
	public java.util.Date getStorageCostEndDate()
	{
		return storageCostEndDate;
	}
	public void setStorageCostEndDate(java.util.Date storageCostEndDate)
	{
		this.storageCostEndDate = storageCostEndDate;
	}
	public java.lang.String getTlrcd()
	{
		return tlrcd;
	}
	public void setTlrcd(java.lang.String tlrcd)
	{
		this.tlrcd = tlrcd;
	}
	public java.lang.String getGallerycd()
	{
		return gallerycd;
	}
	public void setGallerycd(java.lang.String gallerycd)
	{
		this.gallerycd = gallerycd;
	}
	public java.lang.String getGalleryName()
	{
		return galleryName;
	}
	public void setGalleryName(java.lang.String galleryName)
	{
		this.galleryName = galleryName;
	}
	public java.lang.String getPawneeName()
	{
		return pawneeName;
	}
	public void setPawneeName(java.lang.String pawneeName)
	{
		this.pawneeName = pawneeName;
	}
	public java.lang.String getSpecialTradeCode()
	{
		return specialTradeCode;
	}
	public void setSpecialTradeCode(java.lang.String specialTradeCode)
	{
		this.specialTradeCode = specialTradeCode;
	}
	public java.lang.String getFutureCustcd()
	{
		return futureCustcd;
	}
	public void setFutureCustcd(java.lang.String futureCustcd)
	{
		this.futureCustcd = futureCustcd;
	}
	public java.util.Date getBillDueDate()
	{
		return billDueDate;
	}
	public void setBillDueDate(java.util.Date billDueDate)
	{
		this.billDueDate = billDueDate;
	}
	public java.lang.String getBrcode()
	{
		return brcode;
	}
	public void setBrcode(java.lang.String brcode)
	{
		this.brcode = brcode;
	}
	public java.util.Date getConfirmDate()
	{
		return confirmDate;
	}
	public void setConfirmDate(java.util.Date confirmDate)
	{
		this.confirmDate = confirmDate;
	}
	public java.lang.String getReason()
	{
		return reason;
	}
	public void setReason(java.lang.String reason)
	{
		this.reason = reason;
	}
	public java.lang.String getStatus()
	{
		return status;
	}
	public void setStatus(java.lang.String status)
	{
		this.status = status;
	}
	public java.lang.String getRegistrationNum()
	{
		return registrationNum;
	}
	public void setRegistrationNum(java.lang.String registrationNum)
	{
		this.registrationNum = registrationNum;
	}
	public java.util.Date getPledgeDate()
	{
		return pledgeDate;
	}
	public void setPledgeDate(java.util.Date pledgeDate)
	{
		this.pledgeDate = pledgeDate;
	}
	public java.lang.String getFirCd()
	{
		return firCd;
	}
	public void setFirCd(java.lang.String firCd)
	{
		this.firCd = firCd;
	}
	public java.lang.String getPiid()
	{
		return piid;
	}
	public void setPiid(java.lang.String piid)
	{
		this.piid = piid;
	}
	public java.lang.String getAppliType()
	{
		return appliType;
	}
	public void setAppliType(java.lang.String appliType)
	{
		this.appliType = appliType;
	}
	public java.lang.String getProcessTemplateName()
	{
		return processTemplateName;
	}
	public void setProcessTemplateName(java.lang.String processTemplateName)
	{
		this.processTemplateName = processTemplateName;
	}
	public java.lang.String getBusinessnoType()
	{
		return businessnoType;
	}
	public void setBusinessnoType(java.lang.String businessnoType)
	{
		this.businessnoType = businessnoType;
	}
	public java.lang.String getBusinessno()
	{
		return businessno;
	}
	public void setBusinessno(java.lang.String businessno)
	{
		this.businessno = businessno;
	}
	public java.lang.String getStartBrcode()
	{
		return startBrcode;
	}
	public void setStartBrcode(java.lang.String startBrcode)
	{
		this.startBrcode = startBrcode;
	}
	public java.lang.String getStartTlrcd()
	{
		return startTlrcd;
	}
	public void setStartTlrcd(java.lang.String startTlrcd)
	{
		this.startTlrcd = startTlrcd;
	}
	public java.util.Date getStartTime()
	{
		return startTime;
	}
	public void setStartTime(java.util.Date startTime)
	{
		this.startTime = startTime;
	}
	public java.lang.String getApproveBrcode()
	{
		return approveBrcode;
	}
	public void setApproveBrcode(java.lang.String approveBrcode)
	{
		this.approveBrcode = approveBrcode;
	}
	public java.lang.String getApprover()
	{
		return approver;
	}
	public void setApprover(java.lang.String approver)
	{
		this.approver = approver;
	}
	public java.util.Date getApproveDate()
	{
		return approveDate;
	}
	public void setApproveDate(java.util.Date approveDate)
	{
		this.approveDate = approveDate;
	}
	public java.util.Date getApproveTime()
	{
		return approveTime;
	}
	public void setApproveTime(java.util.Date approveTime)
	{
		this.approveTime = approveTime;
	}
	public java.lang.String getDescription()
	{
		return description;
	}
	public void setDescription(java.lang.String description)
	{
		this.description = description;
	}
	public java.lang.String getWorkflowAppno()
	{
		return workflowAppno;
	}
	public void setWorkflowAppno(java.lang.String workflowAppno)
	{
		this.workflowAppno = workflowAppno;
	}
	public java.lang.String getCurcd()
	{
		return curcd;
	}
	public void setCurcd(java.lang.String curcd)
	{
		this.curcd = curcd;
	}
	public java.lang.String getAppTlrcd()
	{
		return appTlrcd;
	}
	public void setAppTlrcd(java.lang.String appTlrcd)
	{
		this.appTlrcd = appTlrcd;
	}
	public java.lang.String getAppBrcode()
	{
		return appBrcode;
	}
	public void setAppBrcode(java.lang.String appBrcode)
	{
		this.appBrcode = appBrcode;
	}
	public java.math.BigDecimal getBailAmount()
	{
		return bailAmount;
	}
	public void setBailAmount(java.math.BigDecimal bailAmount)
	{
		this.bailAmount = bailAmount;
	}
	public java.lang.String getProtocolNo()
	{
		return protocolNo;
	}
	public void setProtocolNo(java.lang.String protocolNo)
	{
		this.protocolNo = protocolNo;
	}
	public java.lang.String getSupplyChainPdId()
	{
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(java.lang.String supplyChainPdId)
	{
		this.supplyChainPdId = supplyChainPdId;
	}
	public java.util.Date getExchangeDate()
	{
		return exchangeDate;
	}
	public void setExchangeDate(java.util.Date exchangeDate)
	{
		this.exchangeDate = exchangeDate;
	}
	public java.math.BigDecimal getCreditamt()
	{
		return creditamt;
	}
	public void setCreditamt(java.math.BigDecimal creditamt)
	{
		this.creditamt = creditamt;
	}
	public java.math.BigDecimal getStockamt()
	{
		return stockamt;
	}
	public void setStockamt(java.math.BigDecimal stockamt)
	{
		this.stockamt = stockamt;
	}
	public java.math.BigDecimal getRiskamt()
	{
		return riskamt;
	}
	public void setRiskamt(java.math.BigDecimal riskamt)
	{
		this.riskamt = riskamt;
	}
	public java.math.BigDecimal getLowPriceNew()
	{
		return lowPriceNew;
	}
	public void setLowPriceNew(java.math.BigDecimal lowPriceNew)
	{
		this.lowPriceNew = lowPriceNew;
	}
	public java.lang.String getMemo()
	{
		return memo;
	}
	public void setMemo(java.lang.String memo)
	{
		this.memo = memo;
	}
	public java.lang.String getIncomeAppno()
	{
		return incomeAppno;
	}
	public void setIncomeAppno(java.lang.String incomeAppno)
	{
		this.incomeAppno = incomeAppno;
	}
	public java.lang.String getApplyid()
	{
		return applyid;
	}
	public void setApplyid(java.lang.String applyid)
	{
		this.applyid = applyid;
	}
	public java.lang.String getMoniCustcd()
	{
		return moniCustcd;
	}
	public void setMoniCustcd(java.lang.String moniCustcd)
	{
		this.moniCustcd = moniCustcd;
	}
	public java.lang.String getPledgeMode()
	{
		return pledgeMode;
	}
	public void setPledgeMode(java.lang.String pledgeMode)
	{
		this.pledgeMode = pledgeMode;
	}
	public java.math.BigDecimal getDeliverValue()
	{
		return deliverValue;
	}
	public void setDeliverValue(java.math.BigDecimal deliverValue)
	{
		this.deliverValue = deliverValue;
	}
	public java.lang.String getOtherProtocolNo()
	{
		return otherProtocolNo;
	}
	public void setOtherProtocolNo(java.lang.String otherProtocolNo)
	{
		this.otherProtocolNo = otherProtocolNo;
	}
	public java.lang.String getExt1()
	{
		return ext1;
	}
	public void setExt1(java.lang.String ext1)
	{
		this.ext1 = ext1;
	}
	public java.lang.String getExt2()
	{
		return ext2;
	}
	public void setExt2(java.lang.String ext2)
	{
		this.ext2 = ext2;
	}
	public java.lang.String getExt3()
	{
		return ext3;
	}
	public void setExt3(java.lang.String ext3)
	{
		this.ext3 = ext3;
	}
	public java.lang.String getEbankAppno()
	{
		return ebankAppno;
	}
	public void setEbankAppno(java.lang.String ebankAppno)
	{
		this.ebankAppno = ebankAppno;
	}
	public java.lang.String getMastContcode()
	{
		return mastContcode;
	}
	public void setMastContcode(java.lang.String mastContcode)
	{
		this.mastContcode = mastContcode;
	}
	public String getFutureCname()
	{
		return futureCname;
	}
	public void setFutureCname(String futureCname)
	{
		this.futureCname = futureCname;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getAppliMortBizType()
	{
		return appliMortBizType;
	}
	public void setAppliMortBizType(String appliMortBizType)
	{
		this.appliMortBizType = appliMortBizType;
	}
	public java.lang.String getSecCd()
	{
		return secCd;
	}
	public void setSecCd(java.lang.String secCd)
	{
		this.secCd = secCd;
	}
	public String getMonitorProtocolNo_Q()
	{
		return monitorProtocolNo_Q;
	}
	public void setMonitorProtocolNo_Q(String monitorProtocolNo_Q)
	{
		this.monitorProtocolNo_Q = monitorProtocolNo_Q;
	}
	public String getOtherProtocolNo_Q()
	{
		return otherProtocolNo_Q;
	}
	public void setOtherProtocolNo_Q(String otherProtocolNo_Q)
	{
		this.otherProtocolNo_Q = otherProtocolNo_Q;
	}
	public String getSupplyChainPdId_Q()
	{
		return supplyChainPdId_Q;
	}
	public void setSupplyChainPdId_Q(String supplyChainPdId_Q)
	{
		this.supplyChainPdId_Q = supplyChainPdId_Q;
	}
	public java.util.Date getInsertDate()
	{
		return insertDate;
	}
	public void setInsertDate(java.util.Date insertDate)
	{
		this.insertDate = insertDate;
	}
	public java.util.Date getEffectDate()
	{
		return effectDate;
	}
	public void setEffectDate(java.util.Date effectDate)
	{
		this.effectDate = effectDate;
	}
	public java.lang.String getType()
	{
		return type;
	}
	public void setType(java.lang.String type)
	{
		this.type = type;
	}
	public java.lang.String getMisc()
	{
		return misc;
	}
	public void setMisc(java.lang.String misc)
	{
		this.misc = misc;
	}
	public java.lang.String getMortgageNo()
	{
		return mortgageNo;
	}
	public void setMortgageNo(java.lang.String mortgageNo)
	{
		this.mortgageNo = mortgageNo;
	}

}
