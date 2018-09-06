package com.huateng.scf.bas.pbc.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;

/**
 * 
 * <p>申请VO</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月26日下午2:55:37
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月26日下午2:55:37	     新增
 *
 * </pre>
 */
public class MortgageApplyVO extends BPbcAppliMtgInfo{
	/**
	 * 
	 */
	private String taskComment;
	public String getTaskComment() {
		return taskComment;
	}
	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}
	private static final long serialVersionUID = 1L;
	private String appno;//申请编号
	private String appliType;//申请类型
	private String slaveContno;//质押合同编号
	private String protocolNo;//协议编号
	private String mastContno;//主合同编号
	private String custcd;//客户号
	private BigDecimal amt;//金额
	private String description;//描述
	private String memo;//备注
	private String productId;//产品编号
	private String curcd;//币种
	private String moniType;//监管模式
	private String moniCustcd;//监管公司客户号
	private BigDecimal lowPriceNew;//最新监管下线
	private String joinBatch;//是否跑批
	private String id;//编号
	private String mortgageNo;//押品编号
	private String manufacturer;//生产厂商
	private String mortgageName;//押品名称
	private String mortgageModel;//规格型号
	private BigDecimal quantity;//数量/重量
	private String mortgageUnits;//数量/重量单位
	private BigDecimal weightAll;//重量
	private BigDecimal confirmPrice;//核定价格
	private BigDecimal totPrice;//总价
	private String warehouse;//仓库名称
	private String weightUnits;//重量单位
	private String freightarea;//货区号
	private String freightlot;//货位号
	private BigDecimal number;//追加数量
	private String mortgageLevelOne;//押品一级
	private String mortgageLevelTwo;//押品二级
	private String mortgageLevelThree;//押品三级
	private String confirmAccording;//核定依据
	private String fixMortgageNo;//盯市产品编号
	private BigDecimal marketPrice;//市场价
	private BigDecimal price;//买入价
	private String appliMortBizType;//押品业务申请类型
	private BigDecimal deliverValue;//提货申请金额
	private String warehouseAddress;//仓库地址
	private BigDecimal bailAmount;//追加保证金金额
	private java.util.Date appDate;//申请日期
	private java.math.BigDecimal outQuantity;
	private java.math.BigDecimal remianQuantity;
	private String certificationNo;  //合格证号
	private String chassisNo; //车架号
	private String engineNo; //发动机号
	private String isSlExibition; //是否二级展场
	private String moniWarehouseType;
	private String taskName;
	private String mortgageLevelOneName;
	private String mortgageLevelTwoName;
	private String mortgageLevelThreeName;
	private BigDecimal nowQuantity;
	private BigDecimal remainQuantity;
	public String getCertificationNo() {
		return certificationNo;
	}
	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getIsSlExibition() {
		return isSlExibition;
	}
	public void setIsSlExibition(String isSlExibition) {
		this.isSlExibition = isSlExibition;
	}
	public java.util.Date getAppDate() {
		return appDate;
	}
	public void setAppDate(java.util.Date appDate) {
		this.appDate = appDate;
	}
	public BigDecimal getDeliverValue() {
		return deliverValue;
	}
	public void setDeliverValue(BigDecimal deliverValue) {
		this.deliverValue = deliverValue;
	}
	public String getAppliMortBizType() {
		return appliMortBizType;
	}
	public void setAppliMortBizType(String appliMortBizType) {
		this.appliMortBizType = appliMortBizType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJoinBatch() {
		return joinBatch;
	}
	public void setJoinBatch(String joinBatch) {
		this.joinBatch = joinBatch;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getAppliType() {
		return appliType;
	}
	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}
	public String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public String getMoniType() {
		return moniType;
	}
	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}
	public String getMoniCustcd() {
		return moniCustcd;
	}
	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getMortgageNo() {
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMortgageName() {
		return mortgageName;
	}
	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
	}
	public String getMortgageModel() {
		return mortgageModel;
	}
	public void setMortgageModel(String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getMortgageUnits() {
		return mortgageUnits;
	}
	public void setMortgageUnits(String mortgageUnits) {
		this.mortgageUnits = mortgageUnits;
	}
	public BigDecimal getWeightAll() {
		return weightAll;
	}
	public void setWeightAll(BigDecimal weightAll) {
		this.weightAll = weightAll;
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
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getWeightUnits() {
		return weightUnits;
	}
	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
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
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
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
	public String getConfirmAccording() {
		return confirmAccording;
	}
	public void setConfirmAccording(String confirmAccording) {
		this.confirmAccording = confirmAccording;
	}
	public String getFixMortgageNo() {
		return fixMortgageNo;
	}
	public void setFixMortgageNo(String fixMortgageNo) {
		this.fixMortgageNo = fixMortgageNo;
	}
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getWarehouseAddress() {
		return warehouseAddress;
	}
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public java.math.BigDecimal getOutQuantity() {
		return outQuantity;
	}
	public void setOutQuantity(java.math.BigDecimal outQuantity) {
		this.outQuantity = outQuantity;
	}
	public java.math.BigDecimal getRemianQuantity() {
		return remianQuantity;
	}
	public void setRemianQuantity(java.math.BigDecimal remianQuantity) {
		this.remianQuantity = remianQuantity;
	}

	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}
	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}
	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}
	public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}
	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}
	public String getMortgageLevelThreeName() {
		return mortgageLevelThreeName;
	}
	public void setMortgageLevelThreeName(String mortgageLevelThreeName) {
		this.mortgageLevelThreeName = mortgageLevelThreeName;
	}
	public BigDecimal getNowQuantity() {
		return nowQuantity;
	}
	public void setNowQuantity(BigDecimal nowQuantity) {
		this.nowQuantity = nowQuantity;
	}
	public BigDecimal getRemainQuantity() {
		return remainQuantity;
	}
	public void setRemainQuantity(BigDecimal remainQuantity) {
		this.remainQuantity = remainQuantity;
	}
}
