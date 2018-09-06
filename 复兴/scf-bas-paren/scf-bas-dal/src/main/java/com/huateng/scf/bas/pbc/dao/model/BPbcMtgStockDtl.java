package com.huateng.scf.bas.pbc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgStockDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 流水表主键
     */
    private String pid;

    /**
     * VARCHAR(20) 必填<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * VARCHAR(100)<br>
     * 入库单号
     */
    private String incomeNo;

    /**
     * VARCHAR(300)<br>
     * 产地
     */
    private String productArea;

    /**
     * VARCHAR(15)<br>
     * 出质人客户号
     */
    private String custcd;

    /**
     * CHAR(8)<br>
     * 首次进入日期
     */
    private String firstStorageDate;

    /**
     * VARCHAR(20)<br>
     * 首次申请号
     */
    private String firstAppno;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 从合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(20)<br>
     * 其他协议号
     */
    private String otherProtocolNo;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String monitorProtocolNo;

    /**
     * VARCHAR(100)<br>
     * 质押物六级
     */
    private String mortgageLevelSix;

    /**
     * VARCHAR(100)<br>
     * 质押物五级
     */
    private String mortgageLevelFive;

    /**
     * VARCHAR(100)<br>
     * 质押物四级
     */
    private String mortgageLevelFour;

    /**
     * VARCHAR(100)<br>
     * 质押物三级
     */
    private String mortgageLevelThree;

    /**
     * VARCHAR(100)<br>
     * 质押物二级
     */
    private String mortgageLevelTwo;

    /**
     * VARCHAR(100)<br>
     * 质押物一级
     */
    private String mortgageLevelOne;

    /**
     * CHAR(4)<br>
     * 押品小类
     */
    private String mortgageSubClass;

    /**
     * CHAR(4)<br>
     * 押品大类
     */
    private String mortgageClass;

    /**
     * CHAR(2)<br>
     * 押品适用业务类型
     */
    private String mortgageBizType;

    /**
     * CHAR(4)<br>
     * 押品种类编号
     */
    private String mortgageClassNo;

    /**
     * VARCHAR(80)<br>
     * 品牌/厂家
     */
    private String vender;

    /**
     * VARCHAR(32)<br>
     * 仓单号
     */
    private String billno;

    /**
     * VARCHAR(80)<br>
     * 生产商
     */
    private String manufacturer;

    /**
     * VARCHAR(15)<br>
     * 监管客户号
     */
    private String moniOfCustcd;

    /**
     * VARCHAR(100)<br>
     * 押品模式
     */
    private String mortgageModel;

    /**
     * VARCHAR(19)<br>
     * 仓库ID
     */
    private String warehouseId;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(2)<br>
     * 存货库存状态
     */
    private String stockStatus;

    /**
     * DECIMAL(16,2)<br>
     * 总价
     */
    private BigDecimal totPrice;

    /**
     * DECIMAL(16,2)<br>
     * 核定价
     */
    private BigDecimal confirmPrice;

    /**
     * DECIMAL(16,2)<br>
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * DECIMAL(16,2)<br>
     * 成本价
     */
    private BigDecimal price;

    /**
     * DECIMAL(16,2)<br>
     * 原始总价
     */
    private BigDecimal originalTotPrice;

    /**
     * DECIMAL(16,2)<br>
     * 原始单价
     */
    private BigDecimal originalPrice;

    /**
     * DECIMAL(16,2)<br>
     * 数量
     */
    private BigDecimal quantity;

    /**
     * VARCHAR(50)<br>
     * 押品单位
     */
    private String mortgageUnits;

    /**
     * DECIMAL(16,2)<br>
     * 仓单数量
     */
    private BigDecimal billQuantity;

    /**
     * VARCHAR(300)<br>
     * 货物存放地点
     */
    private String warehouseAddress;

    /**
     * DECIMAL(16,2)<br>
     * 升贴水
     */
    private BigDecimal upDownMoney;

    /**
     * DECIMAL(16,2)<br>
     * 总重量
     */
    private BigDecimal weightAll;

    /**
     * VARCHAR(100)<br>
     * 仓单货物类别
     */
    private String billType;

    /**
     * VARCHAR(100)<br>
     * 年度
     */
    private String year;

    /**
     * VARCHAR(100)<br>
     * 货物识别码
     */
    private String sn;

    /**
     * VARCHAR(100)<br>
     * 质量等级
     */
    private String qualityLevel;

    /**
     * VARCHAR(100)<br>
     * 包装物
     */
    private String packagew;

    /**
     * DECIMAL(6,4)<br>
     * 抵质押率
     */
    private BigDecimal ration;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String bussType;

    /**
     * CHAR(2)<br>
     * 类型
     */
    private String type;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String supplyChainPdId;

    /**
     * DECIMAL(16,2)<br>
     * 原始核定价
     */
    private BigDecimal oldConfirmPrice;

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
     * VARCHAR(200)<br>
     * 核定依据
     */
    private String confirmAccording;

    /**
     * VARCHAR(2)<br>
     * 升贴水标识
     */
    private String upDownMoneyFlag;

    /**
     * DECIMAL(16,2)<br>
     * 原始数量
     */
    private BigDecimal originalQuantity;

    /**
     * CHAR(1)<br>
     * 库存冲正类型：0-新增；1-调整
     */
    private String stockAdjustType;

    /**
     * VARCHAR(32)<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date crtTime;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 流水表主键
     */
    public String getPid() {
        return pid;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 流水表主键
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

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
     * VARCHAR(300)<br>
     * 获得 产地
     */
    public String getProductArea() {
        return productArea;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 产地
     */
    public void setProductArea(String productArea) {
        this.productArea = productArea == null ? null : productArea.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 出质人客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 出质人客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
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
     * CHAR(4)<br>
     * 获得 押品大类
     */
    public String getMortgageClass() {
        return mortgageClass;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品大类
     */
    public void setMortgageClass(String mortgageClass) {
        this.mortgageClass = mortgageClass == null ? null : mortgageClass.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 押品适用业务类型
     */
    public String getMortgageBizType() {
        return mortgageBizType;
    }

    /**
     * CHAR(2)<br>
     * 设置 押品适用业务类型
     */
    public void setMortgageBizType(String mortgageBizType) {
        this.mortgageBizType = mortgageBizType == null ? null : mortgageBizType.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 押品种类编号
     */
    public String getMortgageClassNo() {
        return mortgageClassNo;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品种类编号
     */
    public void setMortgageClassNo(String mortgageClassNo) {
        this.mortgageClassNo = mortgageClassNo == null ? null : mortgageClassNo.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 品牌/厂家
     */
    public String getVender() {
        return vender;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 品牌/厂家
     */
    public void setVender(String vender) {
        this.vender = vender == null ? null : vender.trim();
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
     * VARCHAR(80)<br>
     * 获得 生产商
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 生产商
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管客户号
     */
    public String getMoniOfCustcd() {
        return moniOfCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管客户号
     */
    public void setMoniOfCustcd(String moniOfCustcd) {
        this.moniOfCustcd = moniOfCustcd == null ? null : moniOfCustcd.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 押品模式
     */
    public String getMortgageModel() {
        return mortgageModel;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品模式
     */
    public void setMortgageModel(String mortgageModel) {
        this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
    }

    /**
     * VARCHAR(19)<br>
     * 获得 仓库ID
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * VARCHAR(19)<br>
     * 设置 仓库ID
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
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
     * 获得 数量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 数量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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
     * 获得 升贴水
     */
    public BigDecimal getUpDownMoney() {
        return upDownMoney;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 升贴水
     */
    public void setUpDownMoney(BigDecimal upDownMoney) {
        this.upDownMoney = upDownMoney;
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
     * DECIMAL(6,4)<br>
     * 获得 抵质押率
     */
    public BigDecimal getRation() {
        return ration;
    }

    /**
     * DECIMAL(6,4)<br>
     * 设置 抵质押率
     */
    public void setRation(BigDecimal ration) {
        this.ration = ration;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 类型
     */
    public String getType() {
        return type;
    }

    /**
     * CHAR(2)<br>
     * 设置 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
     * VARCHAR(200)<br>
     * 获得 核定依据
     */
    public String getConfirmAccording() {
        return confirmAccording;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 核定依据
     */
    public void setConfirmAccording(String confirmAccording) {
        this.confirmAccording = confirmAccording == null ? null : confirmAccording.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 升贴水标识
     */
    public String getUpDownMoneyFlag() {
        return upDownMoneyFlag;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 升贴水标识
     */
    public void setUpDownMoneyFlag(String upDownMoneyFlag) {
        this.upDownMoneyFlag = upDownMoneyFlag == null ? null : upDownMoneyFlag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始数量
     */
    public BigDecimal getOriginalQuantity() {
        return originalQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始数量
     */
    public void setOriginalQuantity(BigDecimal originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    /**
     * CHAR(1)<br>
     * 获得 库存冲正类型：0-新增；1-调整
     */
    public String getStockAdjustType() {
        return stockAdjustType;
    }

    /**
     * CHAR(1)<br>
     * 设置 库存冲正类型：0-新增；1-调整
     */
    public void setStockAdjustType(String stockAdjustType) {
        this.stockAdjustType = stockAdjustType == null ? null : stockAdjustType.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 创建人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setLastUpdTlrcd(String lastUpdTlrcd) {
        this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdBrcode() {
        return lastUpdBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdBrcode(String lastUpdBrcode) {
        this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", incomeNo=").append(incomeNo);
        sb.append(", productArea=").append(productArea);
        sb.append(", custcd=").append(custcd);
        sb.append(", firstStorageDate=").append(firstStorageDate);
        sb.append(", firstAppno=").append(firstAppno);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", otherProtocolNo=").append(otherProtocolNo);
        sb.append(", monitorProtocolNo=").append(monitorProtocolNo);
        sb.append(", mortgageLevelSix=").append(mortgageLevelSix);
        sb.append(", mortgageLevelFive=").append(mortgageLevelFive);
        sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageSubClass=").append(mortgageSubClass);
        sb.append(", mortgageClass=").append(mortgageClass);
        sb.append(", mortgageBizType=").append(mortgageBizType);
        sb.append(", mortgageClassNo=").append(mortgageClassNo);
        sb.append(", vender=").append(vender);
        sb.append(", billno=").append(billno);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", mortgageModel=").append(mortgageModel);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", curcd=").append(curcd);
        sb.append(", stockStatus=").append(stockStatus);
        sb.append(", totPrice=").append(totPrice);
        sb.append(", confirmPrice=").append(confirmPrice);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", price=").append(price);
        sb.append(", originalTotPrice=").append(originalTotPrice);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", billQuantity=").append(billQuantity);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", upDownMoney=").append(upDownMoney);
        sb.append(", weightAll=").append(weightAll);
        sb.append(", billType=").append(billType);
        sb.append(", year=").append(year);
        sb.append(", sn=").append(sn);
        sb.append(", qualityLevel=").append(qualityLevel);
        sb.append(", packagew=").append(packagew);
        sb.append(", ration=").append(ration);
        sb.append(", bussType=").append(bussType);
        sb.append(", type=").append(type);
        sb.append(", supplyChainPdId=").append(supplyChainPdId);
        sb.append(", oldConfirmPrice=").append(oldConfirmPrice);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", ext3=").append(ext3);
        sb.append(", confirmAccording=").append(confirmAccording);
        sb.append(", upDownMoneyFlag=").append(upDownMoneyFlag);
        sb.append(", originalQuantity=").append(originalQuantity);
        sb.append(", stockAdjustType=").append(stockAdjustType);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", brcode=").append(brcode);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
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
        BPbcMtgStockDtl other = (BPbcMtgStockDtl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getIncomeNo() == null ? other.getIncomeNo() == null : this.getIncomeNo().equals(other.getIncomeNo()))
            && (this.getProductArea() == null ? other.getProductArea() == null : this.getProductArea().equals(other.getProductArea()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getFirstStorageDate() == null ? other.getFirstStorageDate() == null : this.getFirstStorageDate().equals(other.getFirstStorageDate()))
            && (this.getFirstAppno() == null ? other.getFirstAppno() == null : this.getFirstAppno().equals(other.getFirstAppno()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getOtherProtocolNo() == null ? other.getOtherProtocolNo() == null : this.getOtherProtocolNo().equals(other.getOtherProtocolNo()))
            && (this.getMonitorProtocolNo() == null ? other.getMonitorProtocolNo() == null : this.getMonitorProtocolNo().equals(other.getMonitorProtocolNo()))
            && (this.getMortgageLevelSix() == null ? other.getMortgageLevelSix() == null : this.getMortgageLevelSix().equals(other.getMortgageLevelSix()))
            && (this.getMortgageLevelFive() == null ? other.getMortgageLevelFive() == null : this.getMortgageLevelFive().equals(other.getMortgageLevelFive()))
            && (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null : this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageSubClass() == null ? other.getMortgageSubClass() == null : this.getMortgageSubClass().equals(other.getMortgageSubClass()))
            && (this.getMortgageClass() == null ? other.getMortgageClass() == null : this.getMortgageClass().equals(other.getMortgageClass()))
            && (this.getMortgageBizType() == null ? other.getMortgageBizType() == null : this.getMortgageBizType().equals(other.getMortgageBizType()))
            && (this.getMortgageClassNo() == null ? other.getMortgageClassNo() == null : this.getMortgageClassNo().equals(other.getMortgageClassNo()))
            && (this.getVender() == null ? other.getVender() == null : this.getVender().equals(other.getVender()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getStockStatus() == null ? other.getStockStatus() == null : this.getStockStatus().equals(other.getStockStatus()))
            && (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
            && (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getOriginalTotPrice() == null ? other.getOriginalTotPrice() == null : this.getOriginalTotPrice().equals(other.getOriginalTotPrice()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getBillQuantity() == null ? other.getBillQuantity() == null : this.getBillQuantity().equals(other.getBillQuantity()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getUpDownMoney() == null ? other.getUpDownMoney() == null : this.getUpDownMoney().equals(other.getUpDownMoney()))
            && (this.getWeightAll() == null ? other.getWeightAll() == null : this.getWeightAll().equals(other.getWeightAll()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getQualityLevel() == null ? other.getQualityLevel() == null : this.getQualityLevel().equals(other.getQualityLevel()))
            && (this.getPackagew() == null ? other.getPackagew() == null : this.getPackagew().equals(other.getPackagew()))
            && (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null : this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
            && (this.getOldConfirmPrice() == null ? other.getOldConfirmPrice() == null : this.getOldConfirmPrice().equals(other.getOldConfirmPrice()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
            && (this.getConfirmAccording() == null ? other.getConfirmAccording() == null : this.getConfirmAccording().equals(other.getConfirmAccording()))
            && (this.getUpDownMoneyFlag() == null ? other.getUpDownMoneyFlag() == null : this.getUpDownMoneyFlag().equals(other.getUpDownMoneyFlag()))
            && (this.getOriginalQuantity() == null ? other.getOriginalQuantity() == null : this.getOriginalQuantity().equals(other.getOriginalQuantity()))
            && (this.getStockAdjustType() == null ? other.getStockAdjustType() == null : this.getStockAdjustType().equals(other.getStockAdjustType()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getIncomeNo() == null) ? 0 : getIncomeNo().hashCode());
        result = prime * result + ((getProductArea() == null) ? 0 : getProductArea().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getFirstStorageDate() == null) ? 0 : getFirstStorageDate().hashCode());
        result = prime * result + ((getFirstAppno() == null) ? 0 : getFirstAppno().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getOtherProtocolNo() == null) ? 0 : getOtherProtocolNo().hashCode());
        result = prime * result + ((getMonitorProtocolNo() == null) ? 0 : getMonitorProtocolNo().hashCode());
        result = prime * result + ((getMortgageLevelSix() == null) ? 0 : getMortgageLevelSix().hashCode());
        result = prime * result + ((getMortgageLevelFive() == null) ? 0 : getMortgageLevelFive().hashCode());
        result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageSubClass() == null) ? 0 : getMortgageSubClass().hashCode());
        result = prime * result + ((getMortgageClass() == null) ? 0 : getMortgageClass().hashCode());
        result = prime * result + ((getMortgageBizType() == null) ? 0 : getMortgageBizType().hashCode());
        result = prime * result + ((getMortgageClassNo() == null) ? 0 : getMortgageClassNo().hashCode());
        result = prime * result + ((getVender() == null) ? 0 : getVender().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getStockStatus() == null) ? 0 : getStockStatus().hashCode());
        result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
        result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getOriginalTotPrice() == null) ? 0 : getOriginalTotPrice().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getBillQuantity() == null) ? 0 : getBillQuantity().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getUpDownMoney() == null) ? 0 : getUpDownMoney().hashCode());
        result = prime * result + ((getWeightAll() == null) ? 0 : getWeightAll().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getQualityLevel() == null) ? 0 : getQualityLevel().hashCode());
        result = prime * result + ((getPackagew() == null) ? 0 : getPackagew().hashCode());
        result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
        result = prime * result + ((getOldConfirmPrice() == null) ? 0 : getOldConfirmPrice().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        result = prime * result + ((getConfirmAccording() == null) ? 0 : getConfirmAccording().hashCode());
        result = prime * result + ((getUpDownMoneyFlag() == null) ? 0 : getUpDownMoneyFlag().hashCode());
        result = prime * result + ((getOriginalQuantity() == null) ? 0 : getOriginalQuantity().hashCode());
        result = prime * result + ((getStockAdjustType() == null) ? 0 : getStockAdjustType().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}