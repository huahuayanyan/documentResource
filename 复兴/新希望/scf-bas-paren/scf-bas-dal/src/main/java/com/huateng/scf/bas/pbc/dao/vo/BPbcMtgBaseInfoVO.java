package com.huateng.scf.bas.pbc.dao.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgBaseInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String billcode;
    private String cname;
    
    public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getBillcode() {
		return billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	private String mortgageLevelOneName;
    private String mortgageLevelTwoName;
    
    public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}

	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}

	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}

	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}

	/**
     * VARCHAR(20) 必填<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String supplyChainPdId;

    /**
     * CHAR(4)<br>
     * 押品类别编号
     */
    private String mortgageClassNo;

    /**
     * CHAR(4)<br>
     * 押品适用业务类型
     */
    private String mortgageBizType;

    /**
     * CHAR(2)<br>
     * 押品大类
     */
    private String mortgageClass;

    /**
     * CHAR(4)<br>
     * 押品小类
     */
    private String mortgageSubClass;

    /**
     * VARCHAR(100)<br>
     * 质押物一级
     */
    private String mortgageLevelOne;

    /**
     * VARCHAR(100)<br>
     * 质押物二级
     */
    private String mortgageLevelTwo;

    /**
     * VARCHAR(100)<br>
     * 质押物三级
     */
    private String mortgageLevelThree;

    /**
     * VARCHAR(100)<br>
     * 质押物四级
     */
    private String mortgageLevelFour;

    /**
     * VARCHAR(100)<br>
     * 质押物五级
     */
    private String mortgageLevelFive;

    /**
     * VARCHAR(100)<br>
     * 质押物六级
     */
    private String mortgageLevelSix;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String monitorProtocolNo;

    /**
     * VARCHAR(20)<br>
     * 其他协议号
     */
    private String otherProtocolNo;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 首次申请号
     */
    private String firstAppno;

    /**
     * CHAR(8)<br>
     * 首次进入日期
     */
    private String firstStorageDate;

    /**
     * VARCHAR(15)<br>
     * 从合同出质人内部客户号
     */
    private String custcd;

    /**
     * VARCHAR(50)<br>
     * 重量单位
     */
    private String weightUnits;

    /**
     * VARCHAR(100)<br>
     * 押品名称
     */
    private String mortgageName;

    /**
     * VARCHAR(50)<br>
     * 押品单位
     */
    private String mortgageUnits;

    /**
     * DECIMAL(16,2)<br>
     * 已出质数量
     */
    private BigDecimal quantity;

    /**
     * DECIMAL(16,2)<br>
     * 原始单价
     */
    private BigDecimal originalPrice;

    /**
     * DECIMAL(16,2)<br>
     * 原始总价
     */
    private BigDecimal originalTotPrice;

    /**
     * DECIMAL(16,2)<br>
     * 成本价
     */
    private BigDecimal price;

    /**
     * DECIMAL(16,2)<br>
     * 市场价
     */
    private BigDecimal marketPrice;

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
     * CHAR(2)<br>
     * 存货库存状态
     */
    private String stockStatus;

    /**
     * VARCHAR(32)<br>
     * 最后修改人
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后修改时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 从合同号
     */
    private String slaveContno;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(200)<br>
     * 仓库编号
     */
    private String warehouseId;

    /**
     * VARCHAR(100)<br>
     * 规格/型号
     */
    private String mortgageModel;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniOfCustcd;

    /**
     * VARCHAR(80)<br>
     * 生产厂家
     */
    private String manufacturer;

    /**
     * VARCHAR(32)<br>
     * 仓单号
     */
    private String billno;

    /**
     * VARCHAR(100)<br>
     * 品牌
     */
    private String vender;

    /**
     * VARCHAR(100)<br>
     * 产地
     */
    private String productArea;

    /**
     * VARCHAR(100)<br>
     * 入库单号
     */
    private String incomeNo;

    /**
     * DECIMAL(5,2)<br>
     * 抵质押率
     */
    private BigDecimal ration;

    /**
     * VARCHAR(100)<br>
     * 包装物
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
     * VARCHAR(100)<br>
     * 年度
     */
    private String year;

    /**
     * VARCHAR(100)<br>
     * 仓单货物类别
     */
    private String billType;

    /**
     * DECIMAL(16,2)<br>
     * 总重量
     */
    private BigDecimal weightAll;

    /**
     * DECIMAL(16,2)<br>
     * 升帖水
     */
    private BigDecimal upDownMoney;

    /**
     * VARCHAR(300)<br>
     * 货物存放地点
     */
    private String warehouseAddress;

    /**
     * DECIMAL(16,2)<br>
     * 仓单数量
     */
    private BigDecimal billQuantity;

    /**
     * DECIMAL(16,2)<br>
     * 原始核定价
     */
    private BigDecimal oldConfirmPrice;

    /**
     * DECIMAL(22)<br>
     * 押品种类主键
     */
    private BigDecimal mortgageCode;

    /**
     * VARCHAR(50)<br>
     * 扩展字段1
     */
    private String ext1;

    /**
     * VARCHAR(100)<br>
     * 扩展字段2
     */
    private String ext2;

    /**
     * VARCHAR(200)<br>
     * 扩展字段3
     */
    private String ext3;

    /**
     * VARCHAR(100)<br>
     * 货区号
     */
    private String freightarea;

    /**
     * VARCHAR(100)<br>
     * 货位号
     */
    private String freightlot;

    /**
     * VARCHAR(100)<br>
     * 仓库
     */
    private String warehouse;

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
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * CHAR(1)<br>
     * 是否参与批量调价：0-否、1-是
     */
    private String joinBatch;

    /**
     * VARCHAR(100)<br>
     * 市场盯市编号
     */
    private String fixMortgageNo;

    /**
     * VARCHAR(20)<br>
     * 购销合同号
     */
    private String tradeContno;

    /**
     * CHAR(1)<br>
     * 是否锁定：0-未锁定、1-锁定
     */
    private String isLocked;

    /**
     * VARCHAR(20)<br>
     * 加锁业务申请编号
     */
    private String lockAppno;

    /**
     * CHAR(1)<br>
     * 是否二级展场:0-否;1-是
     */
    private String isSlExibition;

    /**
     * CHAR(8)<br>
     * 出厂日期
     */
    private String manufactureDate;

    /**
     * VARCHAR(50)<br>
     * 凭证号
     */
    private String documentNo;

    /**
     * VARCHAR(256)<br>
     * 押品其他描述
     */
    private String description;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(200)<br>
     * 核价依据
     */
    private String confirmAccording;

    /**
     * CHAR(2)<br>
     * 监管模式：01-自有库监管、02-输出监管
     */
    private String moniWarehouseType;

    /**
     * DECIMAL(16,2)<br>
     * 已入库未出质数量
     */
    private BigDecimal invQuantity;

    /**
     * CHAR(8)<br>
     * 市价更新日期
     */
    private String priceDate;

    /**
     * VARCHAR(50)<br>
     * 网银流水号
     */
    private String ebankAppno;

    /**
     * CHAR(1)<br>
     * 渠道标识：1-供应链、2-企业网银
     */
    private String channelFlag;

    /**
     * CHAR(2)<br>
     * 升贴水标志：00-升、01贴
     */
    private String upDownMoneyFlag;

    /**
     * VARCHAR(100)<br>
     * 货物名称
     */
    private String productName;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 押品编号
     */
    public String getMortgageNo() {
        return mortgageNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 押品编号
     */
    public void setMortgageNo(String mortgageNo) {
        this.mortgageNo = mortgageNo == null ? null : mortgageNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getSupplyChainPdId() {
        return supplyChainPdId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setSupplyChainPdId(String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 押品类别编号
     */
    public String getMortgageClassNo() {
        return mortgageClassNo;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品类别编号
     */
    public void setMortgageClassNo(String mortgageClassNo) {
        this.mortgageClassNo = mortgageClassNo == null ? null : mortgageClassNo.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 押品适用业务类型
     */
    public String getMortgageBizType() {
        return mortgageBizType;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品适用业务类型
     */
    public void setMortgageBizType(String mortgageBizType) {
        this.mortgageBizType = mortgageBizType == null ? null : mortgageBizType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 押品大类
     */
    public String getMortgageClass() {
        return mortgageClass;
    }

    /**
     * CHAR(2)<br>
     * 设置 押品大类
     */
    public void setMortgageClass(String mortgageClass) {
        this.mortgageClass = mortgageClass == null ? null : mortgageClass.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 押品小类
     */
    public String getMortgageSubClass() {
        return mortgageSubClass;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品小类
     */
    public void setMortgageSubClass(String mortgageSubClass) {
        this.mortgageSubClass = mortgageSubClass == null ? null : mortgageSubClass.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物一级
     */
    public String getMortgageLevelOne() {
        return mortgageLevelOne;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物一级
     */
    public void setMortgageLevelOne(String mortgageLevelOne) {
        this.mortgageLevelOne = mortgageLevelOne == null ? null : mortgageLevelOne.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物二级
     */
    public String getMortgageLevelTwo() {
        return mortgageLevelTwo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物二级
     */
    public void setMortgageLevelTwo(String mortgageLevelTwo) {
        this.mortgageLevelTwo = mortgageLevelTwo == null ? null : mortgageLevelTwo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物三级
     */
    public String getMortgageLevelThree() {
        return mortgageLevelThree;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物三级
     */
    public void setMortgageLevelThree(String mortgageLevelThree) {
        this.mortgageLevelThree = mortgageLevelThree == null ? null : mortgageLevelThree.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物四级
     */
    public String getMortgageLevelFour() {
        return mortgageLevelFour;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物四级
     */
    public void setMortgageLevelFour(String mortgageLevelFour) {
        this.mortgageLevelFour = mortgageLevelFour == null ? null : mortgageLevelFour.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物五级
     */
    public String getMortgageLevelFive() {
        return mortgageLevelFive;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物五级
     */
    public void setMortgageLevelFive(String mortgageLevelFive) {
        this.mortgageLevelFive = mortgageLevelFive == null ? null : mortgageLevelFive.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物六级
     */
    public String getMortgageLevelSix() {
        return mortgageLevelSix;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物六级
     */
    public void setMortgageLevelSix(String mortgageLevelSix) {
        this.mortgageLevelSix = mortgageLevelSix == null ? null : mortgageLevelSix.trim();
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
     * VARCHAR(20)<br>
     * 获得 其他协议号
     */
    public String getOtherProtocolNo() {
        return otherProtocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 其他协议号
     */
    public void setOtherProtocolNo(String otherProtocolNo) {
        this.otherProtocolNo = otherProtocolNo == null ? null : otherProtocolNo.trim();
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
     * 获得 首次申请号
     */
    public String getFirstAppno() {
        return firstAppno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 首次申请号
     */
    public void setFirstAppno(String firstAppno) {
        this.firstAppno = firstAppno == null ? null : firstAppno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 首次进入日期
     */
    public String getFirstStorageDate() {
        return firstStorageDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 首次进入日期
     */
    public void setFirstStorageDate(String firstStorageDate) {
        this.firstStorageDate = firstStorageDate == null ? null : firstStorageDate.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 从合同出质人内部客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 从合同出质人内部客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
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
     * VARCHAR(50)<br>
     * 获得 押品单位
     */
    public String getMortgageUnits() {
        return mortgageUnits;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 押品单位
     */
    public void setMortgageUnits(String mortgageUnits) {
        this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已出质数量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已出质数量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始单价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始单价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始总价
     */
    public BigDecimal getOriginalTotPrice() {
        return originalTotPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始总价
     */
    public void setOriginalTotPrice(BigDecimal originalTotPrice) {
        this.originalTotPrice = originalTotPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 成本价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 成本价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
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
     * CHAR(2)<br>
     * 获得 存货库存状态
     */
    public String getStockStatus() {
        return stockStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 存货库存状态
     */
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus == null ? null : stockStatus.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后修改人
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后修改人
     */
    public void setLastUpdTlrcd(String lastUpdTlrcd) {
        this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后修改时间
     */
    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后修改时间
     */
    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 从合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 从合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
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
     * VARCHAR(200)<br>
     * 获得 仓库编号
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 仓库编号
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 规格/型号
     */
    public String getMortgageModel() {
        return mortgageModel;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 规格/型号
     */
    public void setMortgageModel(String mortgageModel) {
        this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
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
     * VARCHAR(32)<br>
     * 获得 仓单号
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 仓单号
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 品牌
     */
    public String getVender() {
        return vender;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 品牌
     */
    public void setVender(String vender) {
        this.vender = vender == null ? null : vender.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 产地
     */
    public String getProductArea() {
        return productArea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 产地
     */
    public void setProductArea(String productArea) {
        this.productArea = productArea == null ? null : productArea.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 入库单号
     */
    public String getIncomeNo() {
        return incomeNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 入库单号
     */
    public void setIncomeNo(String incomeNo) {
        this.incomeNo = incomeNo == null ? null : incomeNo.trim();
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 抵质押率
     */
    public BigDecimal getRation() {
        return ration;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 抵质押率
     */
    public void setRation(BigDecimal ration) {
        this.ration = ration;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 包装物
     */
    public String getPackagew() {
        return packagew;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 包装物
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

    /**
     * VARCHAR(100)<br>
     * 获得 年度
     */
    public String getYear() {
        return year;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 年度
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 仓单货物类别
     */
    public String getBillType() {
        return billType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓单货物类别
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 升帖水
     */
    public BigDecimal getUpDownMoney() {
        return upDownMoney;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 升帖水
     */
    public void setUpDownMoney(BigDecimal upDownMoney) {
        this.upDownMoney = upDownMoney;
    }

    /**
     * VARCHAR(300)<br>
     * 获得 货物存放地点
     */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 货物存放地点
     */
    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress == null ? null : warehouseAddress.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 仓单数量
     */
    public BigDecimal getBillQuantity() {
        return billQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 仓单数量
     */
    public void setBillQuantity(BigDecimal billQuantity) {
        this.billQuantity = billQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始核定价
     */
    public BigDecimal getOldConfirmPrice() {
        return oldConfirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始核定价
     */
    public void setOldConfirmPrice(BigDecimal oldConfirmPrice) {
        this.oldConfirmPrice = oldConfirmPrice;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 押品种类主键
     */
    public BigDecimal getMortgageCode() {
        return mortgageCode;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 押品种类主键
     */
    public void setMortgageCode(BigDecimal mortgageCode) {
        this.mortgageCode = mortgageCode;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 扩展字段1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 扩展字段1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 扩展字段2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 扩展字段2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 扩展字段3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 扩展字段3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货区号
     */
    public String getFreightarea() {
        return freightarea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货区号
     */
    public void setFreightarea(String freightarea) {
        this.freightarea = freightarea == null ? null : freightarea.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货位号
     */
    public String getFreightlot() {
        return freightlot;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货位号
     */
    public void setFreightlot(String freightlot) {
        this.freightlot = freightlot == null ? null : freightlot.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 仓库
     */
    public String getWarehouse() {
        return warehouse;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓库
     */
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse == null ? null : warehouse.trim();
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
     * CHAR(1)<br>
     * 获得 是否参与批量调价：0-否、1-是
     */
    public String getJoinBatch() {
        return joinBatch;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否参与批量调价：0-否、1-是
     */
    public void setJoinBatch(String joinBatch) {
        this.joinBatch = joinBatch == null ? null : joinBatch.trim();
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
     * VARCHAR(20)<br>
     * 获得 购销合同号
     */
    public String getTradeContno() {
        return tradeContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 购销合同号
     */
    public void setTradeContno(String tradeContno) {
        this.tradeContno = tradeContno == null ? null : tradeContno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否锁定：0-未锁定、1-锁定
     */
    public String getIsLocked() {
        return isLocked;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否锁定：0-未锁定、1-锁定
     */
    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked == null ? null : isLocked.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 加锁业务申请编号
     */
    public String getLockAppno() {
        return lockAppno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 加锁业务申请编号
     */
    public void setLockAppno(String lockAppno) {
        this.lockAppno = lockAppno == null ? null : lockAppno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否二级展场:0-否;1-是
     */
    public String getIsSlExibition() {
        return isSlExibition;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否二级展场:0-否;1-是
     */
    public void setIsSlExibition(String isSlExibition) {
        this.isSlExibition = isSlExibition == null ? null : isSlExibition.trim();
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
     * VARCHAR(256)<br>
     * 获得 押品其他描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 押品其他描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * VARCHAR(200)<br>
     * 获得 核价依据
     */
    public String getConfirmAccording() {
        return confirmAccording;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 核价依据
     */
    public void setConfirmAccording(String confirmAccording) {
        this.confirmAccording = confirmAccording == null ? null : confirmAccording.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 监管模式：01-自有库监管、02-输出监管
     */
    public String getMoniWarehouseType() {
        return moniWarehouseType;
    }

    /**
     * CHAR(2)<br>
     * 设置 监管模式：01-自有库监管、02-输出监管
     */
    public void setMoniWarehouseType(String moniWarehouseType) {
        this.moniWarehouseType = moniWarehouseType == null ? null : moniWarehouseType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已入库未出质数量
     */
    public BigDecimal getInvQuantity() {
        return invQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已入库未出质数量
     */
    public void setInvQuantity(BigDecimal invQuantity) {
        this.invQuantity = invQuantity;
    }

    /**
     * CHAR(8)<br>
     * 获得 市价更新日期
     */
    public String getPriceDate() {
        return priceDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 市价更新日期
     */
    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate == null ? null : priceDate.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 网银流水号
     */
    public String getEbankAppno() {
        return ebankAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 网银流水号
     */
    public void setEbankAppno(String ebankAppno) {
        this.ebankAppno = ebankAppno == null ? null : ebankAppno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 渠道标识：1-供应链、2-企业网银
     */
    public String getChannelFlag() {
        return channelFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 渠道标识：1-供应链、2-企业网银
     */
    public void setChannelFlag(String channelFlag) {
        this.channelFlag = channelFlag == null ? null : channelFlag.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 升贴水标志：00-升、01贴
     */
    public String getUpDownMoneyFlag() {
        return upDownMoneyFlag;
    }

    /**
     * CHAR(2)<br>
     * 设置 升贴水标志：00-升、01贴
     */
    public void setUpDownMoneyFlag(String upDownMoneyFlag) {
        this.upDownMoneyFlag = upDownMoneyFlag == null ? null : upDownMoneyFlag.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货物名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货物名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }
}