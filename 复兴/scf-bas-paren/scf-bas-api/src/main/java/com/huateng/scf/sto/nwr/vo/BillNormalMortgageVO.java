package com.huateng.scf.sto.nwr.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.sto.nwr.model.SBcpMortBillNormalVO;

public class BillNormalMortgageVO extends SBcpMortBillNormalVO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appno;
	private String appliMortBizType;

	private String monitorProtocolNo;
	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private String mortgageNo;

	// fields
	private String supplyChainPdId;
	private String mortgageClassNo;
	private String mortgageBizType;
	private String mortgageClass;
	private String mortgageSubClass;
	private String mortgageLevelOne;
	private String mortgageLevelTwo;
	private String mortgageLevelThree;
	private String mortgageLevelFour;
	private String mortgageLevelFive;
	private String mortgageLevelSix;
	private String otherProtocolNo;
	private String firstAppno;
	private Date firstStorageDate;
	private String mortgageUnits;
	private BigDecimal quantity;
	private BigDecimal originalPrice;
	private BigDecimal originalTotPrice;
	private BigDecimal price;
	private BigDecimal marketPrice;
	private BigDecimal confirmPrice;
	private BigDecimal totPrice;
	private String stockStatus;
	private String lastUpdTlrcd;
	private Date lastUpdTime;
	private String curcd;
	private String warehouseId;
	private String mortgageModel;
	private String moniOfCustcd;
	private String manufacturer;
	private String vender;
	private String productArea;
	private String incomeNo;
	private BigDecimal ration;
	private String m_package;
	private String qualityLevel;
	private String sn;
	private String year;
	private String billType;
	private BigDecimal weightAll;
	private BigDecimal upDownMoney;
	private String warehouseAddress;
	private BigDecimal billQuantity;
	private BigDecimal oldConfirmPrice;
	private String ext1;
	private String ext2;
	private String ext3;
	private String weightUnits;
	private java.lang.Integer mortgageCode;
	private String mortgageName;
	private String freightarea;
	private String freightlot;
	private String warehouse;
	private String engineNo;
	private String chassisNo;
	private String certificationNo;
	private String joinBatch;
	private String fixMortgageNo;
	private String tradeContno;
	private String isLocked;
	private String lockAppno;
	private String isSlExibition;
	private Date manufactureDate;
	private String documentNo;
	private String memo;
	private String description;
	private String confirmAccording;
	private String moniWarehouseType;
	private BigDecimal invQuantity;
	private Date priceDate;  //市价更新日期
	private String ebankAppno;//网银流水号
	private String channelFlag;//渠道标识：1-供应链、2-网银


	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getMortgageClassNo() {
		return mortgageClassNo;
	}

	public void setMortgageClassNo(String mortgageClassNo) {
		this.mortgageClassNo = mortgageClassNo;
	}

	public String getMortgageBizType() {
		return mortgageBizType;
	}

	public void setMortgageBizType(String mortgageBizType) {
		this.mortgageBizType = mortgageBizType;
	}

	public String getMortgageClass() {
		return mortgageClass;
	}

	public void setMortgageClass(String mortgageClass) {
		this.mortgageClass = mortgageClass;
	}

	public String getMortgageSubClass() {
		return mortgageSubClass;
	}

	public void setMortgageSubClass(String mortgageSubClass) {
		this.mortgageSubClass = mortgageSubClass;
	}

	public String getMortgageLevelOne() {
		return mortgageLevelOne;
	}

	public void setMortgageLevelOne(String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne;
	}

	public String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}

	public void setMortgageLevelTwo(String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo;
	}

	public String getMortgageLevelThree() {
		return mortgageLevelThree;
	}

	public void setMortgageLevelThree(String mortgageLevelThree) {
		this.mortgageLevelThree = mortgageLevelThree;
	}

	public String getMortgageLevelFour() {
		return mortgageLevelFour;
	}

	public void setMortgageLevelFour(String mortgageLevelFour) {
		this.mortgageLevelFour = mortgageLevelFour;
	}

	public String getMortgageLevelFive() {
		return mortgageLevelFive;
	}

	public void setMortgageLevelFive(String mortgageLevelFive) {
		this.mortgageLevelFive = mortgageLevelFive;
	}

	public String getMortgageLevelSix() {
		return mortgageLevelSix;
	}

	public void setMortgageLevelSix(String mortgageLevelSix) {
		this.mortgageLevelSix = mortgageLevelSix;
	}

	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}

	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}

	public String getFirstAppno() {
		return firstAppno;
	}

	public void setFirstAppno(String firstAppno) {
		this.firstAppno = firstAppno;
	}

	public Date getFirstStorageDate() {
		return firstStorageDate;
	}

	public void setFirstStorageDate(Date firstStorageDate) {
		this.firstStorageDate = firstStorageDate;
	}

	public String getMortgageUnits() {
		return mortgageUnits;
	}

	public void setMortgageUnits(String mortgageUnits) {
		this.mortgageUnits = mortgageUnits;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getOriginalTotPrice() {
		return originalTotPrice;
	}

	public void setOriginalTotPrice(BigDecimal originalTotPrice) {
		this.originalTotPrice = originalTotPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getConfirmPrice() {
		return confirmPrice;
	}

	public void setConfirmPrice(BigDecimal confirmPrice) {
		this.confirmPrice = confirmPrice;
	}

	public BigDecimal getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	public void setLastUpdTlrcd(String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd;
	}

	public Date getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getMortgageModel() {
		return mortgageModel;
	}

	public void setMortgageModel(String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}

	public String getMoniOfCustcd() {
		return moniOfCustcd;
	}

	public void setMoniOfCustcd(String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVender() {
		return vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public String getIncomeNo() {
		return incomeNo;
	}

	public void setIncomeNo(String incomeNo) {
		this.incomeNo = incomeNo;
	}

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	public String getM_package() {
		return m_package;
	}

	public void setM_package(String m_package) {
		this.m_package = m_package;
	}

	public String getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(String qualityLevel) {
		this.qualityLevel = qualityLevel;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public BigDecimal getWeightAll() {
		return weightAll;
	}

	public void setWeightAll(BigDecimal weightAll) {
		this.weightAll = weightAll;
	}

	public BigDecimal getUpDownMoney() {
		return upDownMoney;
	}

	public void setUpDownMoney(BigDecimal upDownMoney) {
		this.upDownMoney = upDownMoney;
	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public BigDecimal getBillQuantity() {
		return billQuantity;
	}

	public void setBillQuantity(BigDecimal billQuantity) {
		this.billQuantity = billQuantity;
	}

	public BigDecimal getOldConfirmPrice() {
		return oldConfirmPrice;
	}

	public void setOldConfirmPrice(BigDecimal oldConfirmPrice) {
		this.oldConfirmPrice = oldConfirmPrice;
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

	public String getWeightUnits() {
		return weightUnits;
	}

	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
	}

	public java.lang.Integer getMortgageCode() {
		return mortgageCode;
	}

	public void setMortgageCode(java.lang.Integer mortgageCode) {
		this.mortgageCode = mortgageCode;
	}

	public String getMortgageName() {
		return mortgageName;
	}

	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
	}

	public String getFreightarea() {
		return freightarea;
	}

	public void setFreightarea(String freightarea) {
		this.freightarea = freightarea;
	}

	public String getFreightlot() {
		return freightlot;
	}

	public void setFreightlot(String freightlot) {
		this.freightlot = freightlot;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getCertificationNo() {
		return certificationNo;
	}

	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo;
	}

	public String getJoinBatch() {
		return joinBatch;
	}

	public void setJoinBatch(String joinBatch) {
		this.joinBatch = joinBatch;
	}

	public String getFixMortgageNo() {
		return fixMortgageNo;
	}

	public void setFixMortgageNo(String fixMortgageNo) {
		this.fixMortgageNo = fixMortgageNo;
	}

	public String getTradeContno() {
		return tradeContno;
	}

	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}

	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}

	public String getLockAppno() {
		return lockAppno;
	}

	public void setLockAppno(String lockAppno) {
		this.lockAppno = lockAppno;
	}

	public String getIsSlExibition() {
		return isSlExibition;
	}

	public void setIsSlExibition(String isSlExibition) {
		this.isSlExibition = isSlExibition;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConfirmAccording() {
		return confirmAccording;
	}

	public void setConfirmAccording(String confirmAccording) {
		this.confirmAccording = confirmAccording;
	}

	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}

	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}

	public BigDecimal getInvQuantity() {
		return invQuantity;
	}

	public void setInvQuantity(BigDecimal invQuantity) {
		this.invQuantity = invQuantity;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public String getEbankAppno() {
		return ebankAppno;
	}

	public void setEbankAppno(String ebankAppno) {
		this.ebankAppno = ebankAppno;
	}

	public String getChannelFlag() {
		return channelFlag;
	}

	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag;
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

	public String getAppliMortBizType() {
		return appliMortBizType;
	}

	public void setAppliMortBizType(String appliMortBizType) {
		this.appliMortBizType = appliMortBizType;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}


}
