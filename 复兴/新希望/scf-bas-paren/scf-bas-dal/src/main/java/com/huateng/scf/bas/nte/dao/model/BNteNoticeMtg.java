package com.huateng.scf.bas.nte.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BNteNoticeMtg implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * VARCHAR(20)<br>
	 * 业务申请编号
	 */
	private String appno;

	/**
	 * VARCHAR(100)<br>
	 * 押品一级
	 */
	private String mortgageLevelOne;
	/**
	 * VARCHAR(100)<br>
	 * 押品一级名称
	 */
	private String mortgageLevelOneNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品二级
	 */
	private String mortgageLevelTwo;
	/**
	 * VARCHAR(100)<br>
	 * 押品二级
	 */
	private String mortgageLevelTwoNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品三级
	 */
	private String mortgageLevelThree;

	/**
	 * VARCHAR(100)<br>
	 * 押品四级
	 */
	private String mortgageLevelFour;

	/**
	 * VARCHAR(100)<br>
	 * 押品五级
	 */
	private String mortgageLevelFive;

	/**
	 * DECIMAL(16,2)<br>
	 * 数量/重量
	 */
	private BigDecimal quantity;

	/**
	 * DECIMAL(16,2)<br>
	 * 核定价
	 */
	private BigDecimal confirmPrice;

	/**
	 * DECIMAL(16,2)<br>
	 * 总价
	 */
	private BigDecimal totPrice;

	/**
	 * VARCHAR(2)<br>
	 * 押品类型：0-新入库、1-出库
	 */
	private String mortgageType;

	/**
	 * VARCHAR(300)<br>
	 * 仓库地址
	 */
	private String warehouseAddress;

	/**
	 * VARCHAR(32)<br>
	 * 通知书基表主键
	 */
	private String pid;

	/**
	 * VARCHAR(50)<br>
	 * 计量单位
	 */
	private String mortgageUnits;

	/**
	 * VARCHAR(100)<br>
	 * 押品名称
	 */
	private String mortgageName;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String memo;

	/**
	 * VARCHAR(100)<br>
	 * 规格型号
	 */
	private String mortgageModel;

	/**
	 * VARCHAR(50)<br>
	 * 重量单位
	 */
	private String weightUnits;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * VARCHAR(100)<br>
	 * 仓库名
	 */
	private String warehouse;

	/**
	 * DECIMAL(16,2)<br>
	 * 总重量
	 */
	private BigDecimal weightAll;

	/**
	 * VARCHAR(100)<br>
	 * 发动机号
	 */
	private String engineNo;

	/**
	 * VARCHAR(200)<br>
	 * 车架号
	 */
	private String chassisNo;

	/**
	 * VARCHAR(200)<br>
	 * 合格证号
	 */
	private String certificationNo;

	/**
	 * CHAR(8)<br>
	 * 有效开始日期（合格证）
	 */
	private String startDate;

	/**
	 * CHAR(8)<br>
	 * 有效结束日期（合格证）
	 */
	private String endDate;

	/**
	 * VARCHAR(100)<br>
	 * 市场盯市编号
	 */
	private String fixMortgageNo;

	/**
	 * CHAR(1)<br>
	 * 是否参与跑批
	 */
	private String joinBatch;

	/**
	 * DECIMAL(16,2)<br>
	 * 市场价格
	 */
	private BigDecimal marketPrice;

	/**
	 * DECIMAL(16,2)<br>
	 * 买入价
	 */
	private BigDecimal price;

	/**
	 * VARCHAR(100)<br>
	 * 核价依据
	 */
	private String confirmAccording;

	/**
	 * VARCHAR(20)<br>
	 * 押品编号
	 */
	private String mortgageNo;

	/**
	 * VARCHAR(80)<br>
	 * 生产厂家
	 */
	private String manufacturer;

	/**
	 * VARCHAR(50)<br>
	 * 凭证号
	 */
	private String documentNo;

	/**
	 * CHAR(8)<br>
	 * 出厂日期
	 */
	private String manufactureDate;

	/**
	 * DECIMAL(16,2)<br>
	 * 剩余库存数量
	 */
	private BigDecimal balQuantity;

	/**
	 * VARCHAR(32)<br>
	 * 购销合同表主键
	 */
	private String tradeContno;

	/**
	 * VARCHAR(20)<br>
	 * 购销合同关联押品编号
	 */
	private String srcMortgageNo;

	/**
	 * VARCHAR(100)<br>
	 * 包装
	 */
	private String packagew;

	/**
	 * VARCHAR(100)<br>
	 * 质量等级
	 */
	private String qualityLevel;

	/**
	 * VARCHAR(100)<br>
	 * 货物识别码
	 */
	private String sn;

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 主键UUID
	 */
	public String getId() {
		return id;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 主键UUID
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 业务申请编号
	 */
	public String getAppno() {
		return appno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 业务申请编号
	 */
	public void setAppno(String appno) {
		this.appno = appno == null ? null : appno.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品一级
	 */
	public String getMortgageLevelOne() {
		return mortgageLevelOne;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品一级
	 */
	public void setMortgageLevelOne(String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne == null ? null : mortgageLevelOne.trim();
	}

	public String getMortgageLevelOneNm() {
		return mortgageLevelOneNm;
	}

	public void setMortgageLevelOneNm(String mortgageLevelOneNm) {
		this.mortgageLevelOneNm = mortgageLevelOneNm;
	}

	public String getMortgageLevelTwoNm() {
		return mortgageLevelTwoNm;
	}

	public void setMortgageLevelTwoNm(String mortgageLevelTwoNm) {
		this.mortgageLevelTwoNm = mortgageLevelTwoNm;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品二级
	 */
	public String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品二级
	 */
	public void setMortgageLevelTwo(String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo == null ? null : mortgageLevelTwo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品三级
	 */
	public String getMortgageLevelThree() {
		return mortgageLevelThree;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品三级
	 */
	public void setMortgageLevelThree(String mortgageLevelThree) {
		this.mortgageLevelThree = mortgageLevelThree == null ? null : mortgageLevelThree.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品四级
	 */
	public String getMortgageLevelFour() {
		return mortgageLevelFour;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品四级
	 */
	public void setMortgageLevelFour(String mortgageLevelFour) {
		this.mortgageLevelFour = mortgageLevelFour == null ? null : mortgageLevelFour.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品五级
	 */
	public String getMortgageLevelFive() {
		return mortgageLevelFive;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品五级
	 */
	public void setMortgageLevelFive(String mortgageLevelFive) {
		this.mortgageLevelFive = mortgageLevelFive == null ? null : mortgageLevelFive.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 数量/重量
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 数量/重量
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 核定价
	 */
	public BigDecimal getConfirmPrice() {
		return confirmPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 核定价
	 */
	public void setConfirmPrice(BigDecimal confirmPrice) {
		this.confirmPrice = confirmPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 总价
	 */
	public BigDecimal getTotPrice() {
		return totPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 总价
	 */
	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 押品类型：0-新入库、1-出库
	 */
	public String getMortgageType() {
		return mortgageType;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 押品类型：0-新入库、1-出库
	 */
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType == null ? null : mortgageType.trim();
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
	 * VARCHAR(32)<br>
	 * 获得 通知书基表主键
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 通知书基表主键
	 */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 计量单位
	 */
	public String getMortgageUnits() {
		return mortgageUnits;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 计量单位
	 */
	public void setMortgageUnits(String mortgageUnits) {
		this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品名称
	 */
	public String getMortgageName() {
		return mortgageName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品名称
	 */
	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName == null ? null : mortgageName.trim();
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 备注
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 备注
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 规格型号
	 */
	public String getMortgageModel() {
		return mortgageModel;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 规格型号
	 */
	public void setMortgageModel(String mortgageModel) {
		this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 重量单位
	 */
	public String getWeightUnits() {
		return weightUnits;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 重量单位
	 */
	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits == null ? null : weightUnits.trim();
	}

	/**
	 * CHAR(3)<br>
	 * 获得 币种
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 币种
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd == null ? null : curcd.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 仓库名
	 */
	public String getWarehouse() {
		return warehouse;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 仓库名
	 */
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse == null ? null : warehouse.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 总重量
	 */
	public BigDecimal getWeightAll() {
		return weightAll;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 总重量
	 */
	public void setWeightAll(BigDecimal weightAll) {
		this.weightAll = weightAll;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 发动机号
	 */
	public String getEngineNo() {
		return engineNo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 发动机号
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo == null ? null : engineNo.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 车架号
	 */
	public String getChassisNo() {
		return chassisNo;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 车架号
	 */
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo == null ? null : chassisNo.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 合格证号
	 */
	public String getCertificationNo() {
		return certificationNo;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 合格证号
	 */
	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo == null ? null : certificationNo.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 有效开始日期（合格证）
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 有效开始日期（合格证）
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 有效结束日期（合格证）
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 有效结束日期（合格证）
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 市场盯市编号
	 */
	public String getFixMortgageNo() {
		return fixMortgageNo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 市场盯市编号
	 */
	public void setFixMortgageNo(String fixMortgageNo) {
		this.fixMortgageNo = fixMortgageNo == null ? null : fixMortgageNo.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否参与跑批
	 */
	public String getJoinBatch() {
		return joinBatch;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否参与跑批
	 */
	public void setJoinBatch(String joinBatch) {
		this.joinBatch = joinBatch == null ? null : joinBatch.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 市场价格
	 */
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 市场价格
	 */
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 买入价
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 买入价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 核价依据
	 */
	public String getConfirmAccording() {
		return confirmAccording;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 核价依据
	 */
	public void setConfirmAccording(String confirmAccording) {
		this.confirmAccording = confirmAccording == null ? null : confirmAccording.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 押品编号
	 */
	public String getMortgageNo() {
		return mortgageNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 押品编号
	 */
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo == null ? null : mortgageNo.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 生产厂家
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 生产厂家
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer == null ? null : manufacturer.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 凭证号
	 */
	public String getDocumentNo() {
		return documentNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 凭证号
	 */
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo == null ? null : documentNo.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 出厂日期
	 */
	public String getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 出厂日期
	 */
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate == null ? null : manufactureDate.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 剩余库存数量
	 */
	public BigDecimal getBalQuantity() {
		return balQuantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 剩余库存数量
	 */
	public void setBalQuantity(BigDecimal balQuantity) {
		this.balQuantity = balQuantity;
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 购销合同表主键
	 */
	public String getTradeContno() {
		return tradeContno;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 购销合同表主键
	 */
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno == null ? null : tradeContno.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 购销合同关联押品编号
	 */
	public String getSrcMortgageNo() {
		return srcMortgageNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 购销合同关联押品编号
	 */
	public void setSrcMortgageNo(String srcMortgageNo) {
		this.srcMortgageNo = srcMortgageNo == null ? null : srcMortgageNo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 包装
	 */
	public String getPackagew() {
		return packagew;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 包装
	 */
	public void setPackagew(String packagew) {
		this.packagew = packagew == null ? null : packagew.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 质量等级
	 */
	public String getQualityLevel() {
		return qualityLevel;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 质量等级
	 */
	public void setQualityLevel(String qualityLevel) {
		this.qualityLevel = qualityLevel == null ? null : qualityLevel.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 货物识别码
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 货物识别码
	 */
	public void setSn(String sn) {
		this.sn = sn == null ? null : sn.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", appno=").append(appno);
		sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
		sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
		sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
		sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
		sb.append(", mortgageLevelFive=").append(mortgageLevelFive);
		sb.append(", quantity=").append(quantity);
		sb.append(", confirmPrice=").append(confirmPrice);
		sb.append(", totPrice=").append(totPrice);
		sb.append(", mortgageType=").append(mortgageType);
		sb.append(", warehouseAddress=").append(warehouseAddress);
		sb.append(", pid=").append(pid);
		sb.append(", mortgageUnits=").append(mortgageUnits);
		sb.append(", mortgageName=").append(mortgageName);
		sb.append(", memo=").append(memo);
		sb.append(", mortgageModel=").append(mortgageModel);
		sb.append(", weightUnits=").append(weightUnits);
		sb.append(", curcd=").append(curcd);
		sb.append(", warehouse=").append(warehouse);
		sb.append(", weightAll=").append(weightAll);
		sb.append(", engineNo=").append(engineNo);
		sb.append(", chassisNo=").append(chassisNo);
		sb.append(", certificationNo=").append(certificationNo);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", fixMortgageNo=").append(fixMortgageNo);
		sb.append(", joinBatch=").append(joinBatch);
		sb.append(", marketPrice=").append(marketPrice);
		sb.append(", price=").append(price);
		sb.append(", confirmAccording=").append(confirmAccording);
		sb.append(", mortgageNo=").append(mortgageNo);
		sb.append(", manufacturer=").append(manufacturer);
		sb.append(", documentNo=").append(documentNo);
		sb.append(", manufactureDate=").append(manufactureDate);
		sb.append(", balQuantity=").append(balQuantity);
		sb.append(", tradeContno=").append(tradeContno);
		sb.append(", srcMortgageNo=").append(srcMortgageNo);
		sb.append(", packagew=").append(packagew);
		sb.append(", qualityLevel=").append(qualityLevel);
		sb.append(", sn=").append(sn);
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
		BNteNoticeMtg other = (BNteNoticeMtg) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
				&& (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null
						: this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
				&& (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null
						: this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
				&& (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null
						: this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
				&& (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null
						: this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
				&& (this.getMortgageLevelFive() == null ? other.getMortgageLevelFive() == null
						: this.getMortgageLevelFive().equals(other.getMortgageLevelFive()))
				&& (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
				&& (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
				&& (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
				&& (this.getMortgageType() == null ? other.getMortgageType() == null : this.getMortgageType().equals(other.getMortgageType()))
				&& (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null
						: this.getWarehouseAddress().equals(other.getWarehouseAddress()))
				&& (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
				&& (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
				&& (this.getMortgageName() == null ? other.getMortgageName() == null : this.getMortgageName().equals(other.getMortgageName()))
				&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
				&& (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
				&& (this.getWeightUnits() == null ? other.getWeightUnits() == null : this.getWeightUnits().equals(other.getWeightUnits()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getWarehouse() == null ? other.getWarehouse() == null : this.getWarehouse().equals(other.getWarehouse()))
				&& (this.getWeightAll() == null ? other.getWeightAll() == null : this.getWeightAll().equals(other.getWeightAll()))
				&& (this.getEngineNo() == null ? other.getEngineNo() == null : this.getEngineNo().equals(other.getEngineNo()))
				&& (this.getChassisNo() == null ? other.getChassisNo() == null : this.getChassisNo().equals(other.getChassisNo()))
				&& (this.getCertificationNo() == null ? other.getCertificationNo() == null
						: this.getCertificationNo().equals(other.getCertificationNo()))
				&& (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
				&& (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
				&& (this.getFixMortgageNo() == null ? other.getFixMortgageNo() == null : this.getFixMortgageNo().equals(other.getFixMortgageNo()))
				&& (this.getJoinBatch() == null ? other.getJoinBatch() == null : this.getJoinBatch().equals(other.getJoinBatch()))
				&& (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
				&& (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
				&& (this.getConfirmAccording() == null ? other.getConfirmAccording() == null
						: this.getConfirmAccording().equals(other.getConfirmAccording()))
				&& (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
				&& (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
				&& (this.getDocumentNo() == null ? other.getDocumentNo() == null : this.getDocumentNo().equals(other.getDocumentNo()))
				&& (this.getManufactureDate() == null ? other.getManufactureDate() == null
						: this.getManufactureDate().equals(other.getManufactureDate()))
				&& (this.getBalQuantity() == null ? other.getBalQuantity() == null : this.getBalQuantity().equals(other.getBalQuantity()))
				&& (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
				&& (this.getSrcMortgageNo() == null ? other.getSrcMortgageNo() == null : this.getSrcMortgageNo().equals(other.getSrcMortgageNo()))
				&& (this.getPackagew() == null ? other.getPackagew() == null : this.getPackagew().equals(other.getPackagew()))
				&& (this.getQualityLevel() == null ? other.getQualityLevel() == null : this.getQualityLevel().equals(other.getQualityLevel()))
				&& (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
		result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
		result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
		result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
		result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
		result = prime * result + ((getMortgageLevelFive() == null) ? 0 : getMortgageLevelFive().hashCode());
		result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
		result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
		result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
		result = prime * result + ((getMortgageType() == null) ? 0 : getMortgageType().hashCode());
		result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
		result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
		result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
		result = prime * result + ((getMortgageName() == null) ? 0 : getMortgageName().hashCode());
		result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
		result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
		result = prime * result + ((getWeightUnits() == null) ? 0 : getWeightUnits().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getWarehouse() == null) ? 0 : getWarehouse().hashCode());
		result = prime * result + ((getWeightAll() == null) ? 0 : getWeightAll().hashCode());
		result = prime * result + ((getEngineNo() == null) ? 0 : getEngineNo().hashCode());
		result = prime * result + ((getChassisNo() == null) ? 0 : getChassisNo().hashCode());
		result = prime * result + ((getCertificationNo() == null) ? 0 : getCertificationNo().hashCode());
		result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
		result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
		result = prime * result + ((getFixMortgageNo() == null) ? 0 : getFixMortgageNo().hashCode());
		result = prime * result + ((getJoinBatch() == null) ? 0 : getJoinBatch().hashCode());
		result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
		result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
		result = prime * result + ((getConfirmAccording() == null) ? 0 : getConfirmAccording().hashCode());
		result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
		result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
		result = prime * result + ((getDocumentNo() == null) ? 0 : getDocumentNo().hashCode());
		result = prime * result + ((getManufactureDate() == null) ? 0 : getManufactureDate().hashCode());
		result = prime * result + ((getBalQuantity() == null) ? 0 : getBalQuantity().hashCode());
		result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
		result = prime * result + ((getSrcMortgageNo() == null) ? 0 : getSrcMortgageNo().hashCode());
		result = prime * result + ((getPackagew() == null) ? 0 : getPackagew().hashCode());
		result = prime * result + ((getQualityLevel() == null) ? 0 : getQualityLevel().hashCode());
		result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
		return result;
	}
}