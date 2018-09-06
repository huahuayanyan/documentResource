package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgBaseInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private BigDecimal newQuantity;//调整后库存数量
    

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", supplyChainPdId=").append(supplyChainPdId);
        sb.append(", mortgageClassNo=").append(mortgageClassNo);
        sb.append(", mortgageBizType=").append(mortgageBizType);
        sb.append(", mortgageClass=").append(mortgageClass);
        sb.append(", mortgageSubClass=").append(mortgageSubClass);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
        sb.append(", mortgageLevelFive=").append(mortgageLevelFive);
        sb.append(", mortgageLevelSix=").append(mortgageLevelSix);
        sb.append(", monitorProtocolNo=").append(monitorProtocolNo);
        sb.append(", otherProtocolNo=").append(otherProtocolNo);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", firstAppno=").append(firstAppno);
        sb.append(", firstStorageDate=").append(firstStorageDate);
        sb.append(", custcd=").append(custcd);
        sb.append(", weightUnits=").append(weightUnits);
        sb.append(", mortgageName=").append(mortgageName);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", quantity=").append(quantity);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", originalTotPrice=").append(originalTotPrice);
        sb.append(", price=").append(price);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", confirmPrice=").append(confirmPrice);
        sb.append(", totPrice=").append(totPrice);
        sb.append(", stockStatus=").append(stockStatus);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", curcd=").append(curcd);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", mortgageModel=").append(mortgageModel);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", billno=").append(billno);
        sb.append(", vender=").append(vender);
        sb.append(", productArea=").append(productArea);
        sb.append(", incomeNo=").append(incomeNo);
        sb.append(", ration=").append(ration);
        sb.append(", packagew=").append(packagew);
        sb.append(", qualityLevel=").append(qualityLevel);
        sb.append(", sn=").append(sn);
        sb.append(", year=").append(year);
        sb.append(", billType=").append(billType);
        sb.append(", weightAll=").append(weightAll);
        sb.append(", upDownMoney=").append(upDownMoney);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", billQuantity=").append(billQuantity);
        sb.append(", oldConfirmPrice=").append(oldConfirmPrice);
        sb.append(", mortgageCode=").append(mortgageCode);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", ext3=").append(ext3);
        sb.append(", freightarea=").append(freightarea);
        sb.append(", freightlot=").append(freightlot);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", engineNo=").append(engineNo);
        sb.append(", chassisNo=").append(chassisNo);
        sb.append(", certificationNo=").append(certificationNo);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", brcode=").append(brcode);
        sb.append(", joinBatch=").append(joinBatch);
        sb.append(", fixMortgageNo=").append(fixMortgageNo);
        sb.append(", tradeContno=").append(tradeContno);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", lockAppno=").append(lockAppno);
        sb.append(", isSlExibition=").append(isSlExibition);
        sb.append(", manufactureDate=").append(manufactureDate);
        sb.append(", documentNo=").append(documentNo);
        sb.append(", description=").append(description);
        sb.append(", memo=").append(memo);
        sb.append(", confirmAccording=").append(confirmAccording);
        sb.append(", moniWarehouseType=").append(moniWarehouseType);
        sb.append(", invQuantity=").append(invQuantity);
        sb.append(", priceDate=").append(priceDate);
        sb.append(", ebankAppno=").append(ebankAppno);
        sb.append(", channelFlag=").append(channelFlag);
        sb.append(", upDownMoneyFlag=").append(upDownMoneyFlag);
        sb.append(", productName=").append(productName);
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
        BPbcMtgBaseInfoDO other = (BPbcMtgBaseInfoDO) that;
        return (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null : this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
            && (this.getMortgageClassNo() == null ? other.getMortgageClassNo() == null : this.getMortgageClassNo().equals(other.getMortgageClassNo()))
            && (this.getMortgageBizType() == null ? other.getMortgageBizType() == null : this.getMortgageBizType().equals(other.getMortgageBizType()))
            && (this.getMortgageClass() == null ? other.getMortgageClass() == null : this.getMortgageClass().equals(other.getMortgageClass()))
            && (this.getMortgageSubClass() == null ? other.getMortgageSubClass() == null : this.getMortgageSubClass().equals(other.getMortgageSubClass()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null : this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
            && (this.getMortgageLevelFive() == null ? other.getMortgageLevelFive() == null : this.getMortgageLevelFive().equals(other.getMortgageLevelFive()))
            && (this.getMortgageLevelSix() == null ? other.getMortgageLevelSix() == null : this.getMortgageLevelSix().equals(other.getMortgageLevelSix()))
            && (this.getMonitorProtocolNo() == null ? other.getMonitorProtocolNo() == null : this.getMonitorProtocolNo().equals(other.getMonitorProtocolNo()))
            && (this.getOtherProtocolNo() == null ? other.getOtherProtocolNo() == null : this.getOtherProtocolNo().equals(other.getOtherProtocolNo()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getFirstAppno() == null ? other.getFirstAppno() == null : this.getFirstAppno().equals(other.getFirstAppno()))
            && (this.getFirstStorageDate() == null ? other.getFirstStorageDate() == null : this.getFirstStorageDate().equals(other.getFirstStorageDate()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getWeightUnits() == null ? other.getWeightUnits() == null : this.getWeightUnits().equals(other.getWeightUnits()))
            && (this.getMortgageName() == null ? other.getMortgageName() == null : this.getMortgageName().equals(other.getMortgageName()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getOriginalTotPrice() == null ? other.getOriginalTotPrice() == null : this.getOriginalTotPrice().equals(other.getOriginalTotPrice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
            && (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
            && (this.getStockStatus() == null ? other.getStockStatus() == null : this.getStockStatus().equals(other.getStockStatus()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getVender() == null ? other.getVender() == null : this.getVender().equals(other.getVender()))
            && (this.getProductArea() == null ? other.getProductArea() == null : this.getProductArea().equals(other.getProductArea()))
            && (this.getIncomeNo() == null ? other.getIncomeNo() == null : this.getIncomeNo().equals(other.getIncomeNo()))
            && (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
            && (this.getPackagew() == null ? other.getPackagew() == null : this.getPackagew().equals(other.getPackagew()))
            && (this.getQualityLevel() == null ? other.getQualityLevel() == null : this.getQualityLevel().equals(other.getQualityLevel()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getWeightAll() == null ? other.getWeightAll() == null : this.getWeightAll().equals(other.getWeightAll()))
            && (this.getUpDownMoney() == null ? other.getUpDownMoney() == null : this.getUpDownMoney().equals(other.getUpDownMoney()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getBillQuantity() == null ? other.getBillQuantity() == null : this.getBillQuantity().equals(other.getBillQuantity()))
            && (this.getOldConfirmPrice() == null ? other.getOldConfirmPrice() == null : this.getOldConfirmPrice().equals(other.getOldConfirmPrice()))
            && (this.getMortgageCode() == null ? other.getMortgageCode() == null : this.getMortgageCode().equals(other.getMortgageCode()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
            && (this.getFreightarea() == null ? other.getFreightarea() == null : this.getFreightarea().equals(other.getFreightarea()))
            && (this.getFreightlot() == null ? other.getFreightlot() == null : this.getFreightlot().equals(other.getFreightlot()))
            && (this.getWarehouse() == null ? other.getWarehouse() == null : this.getWarehouse().equals(other.getWarehouse()))
            && (this.getEngineNo() == null ? other.getEngineNo() == null : this.getEngineNo().equals(other.getEngineNo()))
            && (this.getChassisNo() == null ? other.getChassisNo() == null : this.getChassisNo().equals(other.getChassisNo()))
            && (this.getCertificationNo() == null ? other.getCertificationNo() == null : this.getCertificationNo().equals(other.getCertificationNo()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getJoinBatch() == null ? other.getJoinBatch() == null : this.getJoinBatch().equals(other.getJoinBatch()))
            && (this.getFixMortgageNo() == null ? other.getFixMortgageNo() == null : this.getFixMortgageNo().equals(other.getFixMortgageNo()))
            && (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getLockAppno() == null ? other.getLockAppno() == null : this.getLockAppno().equals(other.getLockAppno()))
            && (this.getIsSlExibition() == null ? other.getIsSlExibition() == null : this.getIsSlExibition().equals(other.getIsSlExibition()))
            && (this.getManufactureDate() == null ? other.getManufactureDate() == null : this.getManufactureDate().equals(other.getManufactureDate()))
            && (this.getDocumentNo() == null ? other.getDocumentNo() == null : this.getDocumentNo().equals(other.getDocumentNo()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getConfirmAccording() == null ? other.getConfirmAccording() == null : this.getConfirmAccording().equals(other.getConfirmAccording()))
            && (this.getMoniWarehouseType() == null ? other.getMoniWarehouseType() == null : this.getMoniWarehouseType().equals(other.getMoniWarehouseType()))
            && (this.getInvQuantity() == null ? other.getInvQuantity() == null : this.getInvQuantity().equals(other.getInvQuantity()))
            && (this.getPriceDate() == null ? other.getPriceDate() == null : this.getPriceDate().equals(other.getPriceDate()))
            && (this.getEbankAppno() == null ? other.getEbankAppno() == null : this.getEbankAppno().equals(other.getEbankAppno()))
            && (this.getChannelFlag() == null ? other.getChannelFlag() == null : this.getChannelFlag().equals(other.getChannelFlag()))
            && (this.getUpDownMoneyFlag() == null ? other.getUpDownMoneyFlag() == null : this.getUpDownMoneyFlag().equals(other.getUpDownMoneyFlag()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
        result = prime * result + ((getMortgageClassNo() == null) ? 0 : getMortgageClassNo().hashCode());
        result = prime * result + ((getMortgageBizType() == null) ? 0 : getMortgageBizType().hashCode());
        result = prime * result + ((getMortgageClass() == null) ? 0 : getMortgageClass().hashCode());
        result = prime * result + ((getMortgageSubClass() == null) ? 0 : getMortgageSubClass().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
        result = prime * result + ((getMortgageLevelFive() == null) ? 0 : getMortgageLevelFive().hashCode());
        result = prime * result + ((getMortgageLevelSix() == null) ? 0 : getMortgageLevelSix().hashCode());
        result = prime * result + ((getMonitorProtocolNo() == null) ? 0 : getMonitorProtocolNo().hashCode());
        result = prime * result + ((getOtherProtocolNo() == null) ? 0 : getOtherProtocolNo().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getFirstAppno() == null) ? 0 : getFirstAppno().hashCode());
        result = prime * result + ((getFirstStorageDate() == null) ? 0 : getFirstStorageDate().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getWeightUnits() == null) ? 0 : getWeightUnits().hashCode());
        result = prime * result + ((getMortgageName() == null) ? 0 : getMortgageName().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getOriginalTotPrice() == null) ? 0 : getOriginalTotPrice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
        result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
        result = prime * result + ((getStockStatus() == null) ? 0 : getStockStatus().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getVender() == null) ? 0 : getVender().hashCode());
        result = prime * result + ((getProductArea() == null) ? 0 : getProductArea().hashCode());
        result = prime * result + ((getIncomeNo() == null) ? 0 : getIncomeNo().hashCode());
        result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
        result = prime * result + ((getPackagew() == null) ? 0 : getPackagew().hashCode());
        result = prime * result + ((getQualityLevel() == null) ? 0 : getQualityLevel().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getWeightAll() == null) ? 0 : getWeightAll().hashCode());
        result = prime * result + ((getUpDownMoney() == null) ? 0 : getUpDownMoney().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getBillQuantity() == null) ? 0 : getBillQuantity().hashCode());
        result = prime * result + ((getOldConfirmPrice() == null) ? 0 : getOldConfirmPrice().hashCode());
        result = prime * result + ((getMortgageCode() == null) ? 0 : getMortgageCode().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        result = prime * result + ((getFreightarea() == null) ? 0 : getFreightarea().hashCode());
        result = prime * result + ((getFreightlot() == null) ? 0 : getFreightlot().hashCode());
        result = prime * result + ((getWarehouse() == null) ? 0 : getWarehouse().hashCode());
        result = prime * result + ((getEngineNo() == null) ? 0 : getEngineNo().hashCode());
        result = prime * result + ((getChassisNo() == null) ? 0 : getChassisNo().hashCode());
        result = prime * result + ((getCertificationNo() == null) ? 0 : getCertificationNo().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getJoinBatch() == null) ? 0 : getJoinBatch().hashCode());
        result = prime * result + ((getFixMortgageNo() == null) ? 0 : getFixMortgageNo().hashCode());
        result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getLockAppno() == null) ? 0 : getLockAppno().hashCode());
        result = prime * result + ((getIsSlExibition() == null) ? 0 : getIsSlExibition().hashCode());
        result = prime * result + ((getManufactureDate() == null) ? 0 : getManufactureDate().hashCode());
        result = prime * result + ((getDocumentNo() == null) ? 0 : getDocumentNo().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getConfirmAccording() == null) ? 0 : getConfirmAccording().hashCode());
        result = prime * result + ((getMoniWarehouseType() == null) ? 0 : getMoniWarehouseType().hashCode());
        result = prime * result + ((getInvQuantity() == null) ? 0 : getInvQuantity().hashCode());
        result = prime * result + ((getPriceDate() == null) ? 0 : getPriceDate().hashCode());
        result = prime * result + ((getEbankAppno() == null) ? 0 : getEbankAppno().hashCode());
        result = prime * result + ((getChannelFlag() == null) ? 0 : getChannelFlag().hashCode());
        result = prime * result + ((getUpDownMoneyFlag() == null) ? 0 : getUpDownMoneyFlag().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        return result;
    }

	public BigDecimal getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(BigDecimal newQuantity) {
		this.newQuantity = newQuantity;
	}
}