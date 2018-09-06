package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class BillStandardMortgageVO extends CommonQryVO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.String appno;
	private java.lang.String appliMortBizType;
	private java.lang.String mortgageNo;
	private java.lang.String mortgageBizType;
	private java.lang.String mortgageClass;
	private java.lang.String mortgageSubClass;
	private java.lang.String monitorProtocolNo;
	private java.lang.String otherProtocolNo;
	private java.lang.String mortgageModel;
	private java.lang.String slaveContno;
	private java.lang.String custcd;
	private java.lang.String mortgageUnits;
	private java.math.BigDecimal quantity;
	private java.math.BigDecimal addQuantity;
	private java.math.BigDecimal price;
	private java.math.BigDecimal totPrice;
	private java.lang.String description;
	private java.lang.String manufacturer;
	private java.lang.String warehouseId;
	private java.lang.String flag;
	private java.math.BigDecimal balQuantity;
	private java.lang.String curcd;
	private java.lang.String mortgageLevelOne;
	private java.lang.String mortgageLevelTwo;
	private java.lang.String mortgageLevelThree;
	private java.lang.String mortgageLevelFour;
	private java.lang.String mortgageLevelFive;
	private java.lang.String mortgageLevelSix;
	private java.lang.String mastContno;
	private java.math.BigDecimal originalPrice;
	private java.math.BigDecimal originalTotPrice;
	private java.math.BigDecimal marketPrice;
	private java.math.BigDecimal confirmPrice;
	private java.lang.String stockStatus;
	private java.lang.String moniOfCustcd;
	private java.lang.String vender;
	private java.lang.String productArea;
	private java.lang.String incomeNo;
	private java.math.BigDecimal ration;
	private java.lang.String wrappage;
	private java.lang.String qualityLevel;
	private java.lang.String sn;
	private java.lang.String year;
	private java.lang.String billType;
	private java.math.BigDecimal weightAll;
	private java.math.BigDecimal upDownMoney;
	private java.lang.String billno;
	private java.math.BigDecimal billQuantity;
	private java.lang.String futureCustcd;
	private java.util.Date billDueDate;
	private java.lang.String status;
	private java.lang.String warehouseAddress;
	private java.math.BigDecimal oldConfirmPrice;
	private java.lang.String confirmAccording;
	private java.lang.String mortgageName;
	private java.lang.String freightarea;
	private java.lang.String freightlot;
	private java.lang.String memo;
	private java.lang.String warehouse;
	private java.lang.Integer mortgageCode;
	private java.lang.String weightUnits;
	private java.lang.String engineNo;
	private java.lang.String chassisNo;
	private java.lang.String certificationNo;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.String brcode;
	private java.lang.String upDownMoneyFlag;
	private java.lang.String tradeContno;
	private java.math.BigDecimal outQuantity;
	private java.lang.String isSlExibition;
	private java.util.Date manufactureDate;
	private java.lang.String joinBatch;
	private java.lang.String fixMortgageNo;
	private java.lang.String documentNo;
	private java.lang.String moniWarehouseType;
	private java.lang.String reason;


	private String id;

	private String mortgageModelName;
	private String mortgageSubClassName;
	private String mortgageLevelThreeName;
	private java.math.BigDecimal beforeChangePrice;
	private java.math.BigDecimal afterChangePrice;
	private String m_package;
	private String productName;

	public String getPackage() {
		return m_package;
	}
	public void setPackage(String m_package) {
		this.m_package = m_package;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getAppno()
	{
		return appno;
	}
	public void setAppno(String appno)
	{
		this.appno = appno;
	}
	public String getAppliMortBizType()
	{
		return appliMortBizType;
	}
	public void setAppliMortBizType(String appliMortBizType)
	{
		this.appliMortBizType = appliMortBizType;
	}
	public String getMortgageNo()
	{
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo)
	{
		this.mortgageNo = mortgageNo;
	}
	public String getMortgageBizType()
	{
		return mortgageBizType;
	}
	public void setMortgageBizType(String mortgageBizType)
	{
		this.mortgageBizType = mortgageBizType;
	}
	public String getMortgageClass()
	{
		return mortgageClass;
	}
	public void setMortgageClass(String mortgageClass)
	{
		this.mortgageClass = mortgageClass;
	}
	public String getMortgageSubClass()
	{
		return mortgageSubClass;
	}
	public void setMortgageSubClass(String mortgageSubClass)
	{
		this.mortgageSubClass = mortgageSubClass;
	}
	public String getMonitorProtocolNo()
	{
		return monitorProtocolNo;
	}
	public void setMonitorProtocolNo(String monitorProtocolNo)
	{
		this.monitorProtocolNo = monitorProtocolNo;
	}
	public String getOtherProtocolNo()
	{
		return otherProtocolNo;
	}
	public void setOtherProtocolNo(String otherProtocolNo)
	{
		this.otherProtocolNo = otherProtocolNo;
	}
	public String getMortgageModel()
	{
		return mortgageModel;
	}
	public void setMortgageModel(String mortgageModel)
	{
		this.mortgageModel = mortgageModel;
	}
	public String getMortgageModelName()
	{
		return mortgageModelName;
	}
	public void setMortgageModelName(String mortgageModelName)
	{
		this.mortgageModelName = mortgageModelName;
	}
	public String getSlaveContno()
	{
		return slaveContno;
	}
	public void setSlaveContno(String slaveContno)
	{
		this.slaveContno = slaveContno;
	}
	public String getCustcd()
	{
		return custcd;
	}
	public void setCustcd(String custcd)
	{
		this.custcd = custcd;
	}
	public String getMortgageUnits()
	{
		return mortgageUnits;
	}
	public void setMortgageUnits(String mortgageUnits)
	{
		this.mortgageUnits = mortgageUnits;
	}
	public java.math.BigDecimal getQuantity()
	{
		return quantity;
	}
	public void setQuantity(java.math.BigDecimal quantity)
	{
		this.quantity = quantity;
	}
	public java.math.BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(java.math.BigDecimal price)
	{
		this.price = price;
	}
	public java.math.BigDecimal getTotPrice()
	{
		return totPrice;
	}
	public void setTotPrice(java.math.BigDecimal totPrice)
	{
		this.totPrice = totPrice;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	public String getWarehouseId()
	{
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId)
	{
		this.warehouseId = warehouseId;
	}
	public String getFlag()
	{
		return flag;
	}
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public java.math.BigDecimal getBalQuantity()
	{
		return balQuantity;
	}
	public void setBalQuantity(java.math.BigDecimal balQuantity)
	{
		this.balQuantity = balQuantity;
	}
	public String getCurcd()
	{
		return curcd;
	}
	public void setCurcd(String curcd)
	{
		this.curcd = curcd;
	}
	public String getMortgageLevelOne()
	{
		return mortgageLevelOne;
	}
	public void setMortgageLevelOne(String mortgageLevelOne)
	{
		this.mortgageLevelOne = mortgageLevelOne;
	}
	public String getMortgageName()
	{
		return mortgageName;
	}
	public void setMortgageName(String mortgageName)
	{
		this.mortgageName = mortgageName;
	}
	public String getMortgageLevelTwo()
	{
		return mortgageLevelTwo;
	}
	public void setMortgageLevelTwo(String mortgageLevelTwo)
	{
		this.mortgageLevelTwo = mortgageLevelTwo;
	}
	public String getMortgageSubClassName()
	{
		return mortgageSubClassName;
	}
	public void setMortgageSubClassName(String mortgageSubClassName)
	{
		this.mortgageSubClassName = mortgageSubClassName;
	}
	public String getMortgageLevelThree()
	{
		return mortgageLevelThree;
	}
	public void setMortgageLevelThree(String mortgageLevelThree)
	{
		this.mortgageLevelThree = mortgageLevelThree;
	}
	public String getMortgageLevelThreeName()
	{
		return mortgageLevelThreeName;
	}
	public void setMortgageLevelThreeName(String mortgageLevelThreeName)
	{
		this.mortgageLevelThreeName = mortgageLevelThreeName;
	}
	public String getMortgageLevelFour()
	{
		return mortgageLevelFour;
	}
	public void setMortgageLevelFour(String mortgageLevelFour)
	{
		this.mortgageLevelFour = mortgageLevelFour;
	}
	public String getMortgageLevelFive()
	{
		return mortgageLevelFive;
	}
	public void setMortgageLevelFive(String mortgageLevelFive)
	{
		this.mortgageLevelFive = mortgageLevelFive;
	}
	public String getMortgageLevelSix()
	{
		return mortgageLevelSix;
	}
	public void setMortgageLevelSix(String mortgageLevelSix)
	{
		this.mortgageLevelSix = mortgageLevelSix;
	}
	public String getMastContno()
	{
		return mastContno;
	}
	public void setMastContno(String mastContno)
	{
		this.mastContno = mastContno;
	}
	public java.math.BigDecimal getOriginalPrice()
	{
		return originalPrice;
	}
	public void setOriginalPrice(java.math.BigDecimal originalPrice)
	{
		this.originalPrice = originalPrice;
	}
	public java.math.BigDecimal getOriginalTotPrice()
	{
		return originalTotPrice;
	}
	public void setOriginalTotPrice(java.math.BigDecimal originalTotPrice)
	{
		this.originalTotPrice = originalTotPrice;
	}
	public java.math.BigDecimal getMarketPrice()
	{
		return marketPrice;
	}
	public void setMarketPrice(java.math.BigDecimal marketPrice)
	{
		this.marketPrice = marketPrice;
	}
	public java.math.BigDecimal getConfirmPrice()
	{
		return confirmPrice;
	}
	public void setConfirmPrice(java.math.BigDecimal confirmPrice)
	{
		this.confirmPrice = confirmPrice;
	}
	public String getStockStatus()
	{
		return stockStatus;
	}
	public void setStockStatus(String stockStatus)
	{
		this.stockStatus = stockStatus;
	}
	public String getMoniOfCustcd()
	{
		return moniOfCustcd;
	}
	public void setMoniOfCustcd(String moniOfCustcd)
	{
		this.moniOfCustcd = moniOfCustcd;
	}
	public String getVender()
	{
		return vender;
	}
	public void setVender(String vender)
	{
		this.vender = vender;
	}
	public String getProductArea()
	{
		return productArea;
	}
	public void setProductArea(String productArea)
	{
		this.productArea = productArea;
	}
	public String getIncomeNo()
	{
		return incomeNo;
	}
	public void setIncomeNo(String incomeNo)
	{
		this.incomeNo = incomeNo;
	}
	public java.math.BigDecimal getRation()
	{
		return ration;
	}
	public void setRation(java.math.BigDecimal ration)
	{
		this.ration = ration;
	}
	public String getWrappage()
	{
		return wrappage;
	}
	public void setWrappage(String wrappage)
	{
		this.wrappage = wrappage;
	}
	public String getQualityLevel()
	{
		return qualityLevel;
	}
	public void setQualityLevel(String qualityLevel)
	{
		this.qualityLevel = qualityLevel;
	}
	public String getSn()
	{
		return sn;
	}
	public void setSn(String sn)
	{
		this.sn = sn;
	}
	public String getYear()
	{
		return year;
	}
	public void setYear(String year)
	{
		this.year = year;
	}
	public String getBillType()
	{
		return billType;
	}
	public void setBillType(String billType)
	{
		this.billType = billType;
	}

	public java.math.BigDecimal getUpDownMoney()
	{
		return upDownMoney;
	}
	public void setUpDownMoney(java.math.BigDecimal upDownMoney)
	{
		this.upDownMoney = upDownMoney;
	}
	public String getUpDownMoneyFlag()
	{
		return upDownMoneyFlag;
	}
	public void setUpDownMoneyFlag(String upDownMoneyFlag)
	{
		this.upDownMoneyFlag = upDownMoneyFlag;
	}
	public String getBillno()
	{
		return billno;
	}
	public void setBillno(String billno)
	{
		this.billno = billno;
	}

	public String getFutureCustcd()
	{
		return futureCustcd;
	}
	public void setFutureCustcd(String futureCustcd)
	{
		this.futureCustcd = futureCustcd;
	}

	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getWarehouseAddress()
	{
		return warehouseAddress;
	}
	public void setWarehouseAddress(String warehouseAddress)
	{
		this.warehouseAddress = warehouseAddress;
	}
	public java.math.BigDecimal getBeforeChangePrice()
	{
		return beforeChangePrice;
	}
	public void setBeforeChangePrice(java.math.BigDecimal beforeChangePrice)
	{
		this.beforeChangePrice = beforeChangePrice;
	}
	public java.math.BigDecimal getAfterChangePrice()
	{
		return afterChangePrice;
	}
	public void setAfterChangePrice(java.math.BigDecimal afterChangePrice)
	{
		this.afterChangePrice = afterChangePrice;
	}
	public java.math.BigDecimal getOldConfirmPrice()
	{
		return oldConfirmPrice;
	}
	public void setOldConfirmPrice(java.math.BigDecimal oldConfirmPrice)
	{
		this.oldConfirmPrice = oldConfirmPrice;
	}
	public String getConfirmAccording()
	{
		return confirmAccording;
	}
	public void setConfirmAccording(String confirmAccording)
	{
		this.confirmAccording = confirmAccording;
	}
	public String getBrcode()
	{
		return brcode;
	}
	public void setBrcode(String brcode)
	{
		this.brcode = brcode;
	}
	public java.math.BigDecimal getWeightAll()
	{
		return weightAll;
	}
	public void setWeightAll(java.math.BigDecimal weightAll)
	{
		this.weightAll = weightAll;
	}
	public java.math.BigDecimal getBillQuantity()
	{
		return billQuantity;
	}
	public void setBillQuantity(java.math.BigDecimal billQuantity)
	{
		this.billQuantity = billQuantity;
	}
	public java.util.Date getBillDueDate()
	{
		return billDueDate;
	}
	public void setBillDueDate(java.util.Date billDueDate)
	{
		this.billDueDate = billDueDate;
	}
	public java.lang.String getFreightarea()
	{
		return freightarea;
	}
	public void setFreightarea(java.lang.String freightarea)
	{
		this.freightarea = freightarea;
	}
	public java.lang.String getFreightlot()
	{
		return freightlot;
	}
	public void setFreightlot(java.lang.String freightlot)
	{
		this.freightlot = freightlot;
	}
	public java.lang.String getMemo()
	{
		return memo;
	}
	public void setMemo(java.lang.String memo)
	{
		this.memo = memo;
	}
	public java.lang.String getWarehouse()
	{
		return warehouse;
	}
	public void setWarehouse(java.lang.String warehouse)
	{
		this.warehouse = warehouse;
	}
	public java.lang.Integer getMortgageCode()
	{
		return mortgageCode;
	}
	public void setMortgageCode(java.lang.Integer mortgageCode)
	{
		this.mortgageCode = mortgageCode;
	}
	public java.lang.String getWeightUnits()
	{
		return weightUnits;
	}
	public void setWeightUnits(java.lang.String weightUnits)
	{
		this.weightUnits = weightUnits;
	}
	public java.lang.String getEngineNo()
	{
		return engineNo;
	}
	public void setEngineNo(java.lang.String engineNo)
	{
		this.engineNo = engineNo;
	}
	public java.lang.String getChassisNo()
	{
		return chassisNo;
	}
	public void setChassisNo(java.lang.String chassisNo)
	{
		this.chassisNo = chassisNo;
	}
	public java.lang.String getCertificationNo()
	{
		return certificationNo;
	}
	public void setCertificationNo(java.lang.String certificationNo)
	{
		this.certificationNo = certificationNo;
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
	public java.lang.String getTradeContno()
	{
		return tradeContno;
	}
	public void setTradeContno(java.lang.String tradeContno)
	{
		this.tradeContno = tradeContno;
	}
	public java.math.BigDecimal getOutQuantity()
	{
		return outQuantity;
	}
	public void setOutQuantity(java.math.BigDecimal outQuantity)
	{
		this.outQuantity = outQuantity;
	}
	public java.lang.String getIsSlExibition()
	{
		return isSlExibition;
	}
	public void setIsSlExibition(java.lang.String isSlExibition)
	{
		this.isSlExibition = isSlExibition;
	}
	public java.util.Date getManufactureDate()
	{
		return manufactureDate;
	}
	public void setManufactureDate(java.util.Date manufactureDate)
	{
		this.manufactureDate = manufactureDate;
	}
	public java.lang.String getJoinBatch()
	{
		return joinBatch;
	}
	public void setJoinBatch(java.lang.String joinBatch)
	{
		this.joinBatch = joinBatch;
	}
	public java.lang.String getFixMortgageNo()
	{
		return fixMortgageNo;
	}
	public void setFixMortgageNo(java.lang.String fixMortgageNo)
	{
		this.fixMortgageNo = fixMortgageNo;
	}
	public java.lang.String getDocumentNo()
	{
		return documentNo;
	}
	public void setDocumentNo(java.lang.String documentNo)
	{
		this.documentNo = documentNo;
	}
	public java.lang.String getMoniWarehouseType()
	{
		return moniWarehouseType;
	}
	public void setMoniWarehouseType(java.lang.String moniWarehouseType)
	{
		this.moniWarehouseType = moniWarehouseType;
	}
	public java.lang.String getReason()
	{
		return reason;
	}
	public void setReason(java.lang.String reason)
	{
		this.reason = reason;
	}
	public java.math.BigDecimal getAddQuantity() {
		return addQuantity;
	}
	public void setAddQuantity(java.math.BigDecimal addQuantity) {
		this.addQuantity = addQuantity;
	}
	
}
