package com.huateng.scf.bas.pbc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BPbcAppliMtgInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * CHAR(4)<br>
     * 业务申请类型
     */
    private String appliMortBizType;

    /**
     * VARCHAR(20)<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * CHAR(4)<br>
     * 押品业务类型
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
     * VARCHAR(100)<br>
     * 押品型号
     */
    private String mortgageModel;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(50)<br>
     * 押品计量单位
     */
    private String mortgageUnits;

    /**
     * DECIMAL(16,2)<br>
     * 押品数量
     */
    private BigDecimal quantity;

    /**
     * DECIMAL(16,2)<br>
     * 押品单价
     */
    private BigDecimal price;

    /**
     * DECIMAL(16,2)<br>
     * 押品总价
     */
    private BigDecimal totPrice;

    /**
     * VARCHAR(256)<br>
     * 押品其他描述
     */
    private String description;

    /**
     * VARCHAR(80)<br>
     * 生产厂家
     */
    private String manufacturer;

    /**
     * VARCHAR(200)<br>
     * 仓库编号
     */
    private String warehouseId;

    /**
     * CHAR(2)<br>
     * 押品标志：00-不可用、01-可用
     */
    private String flag;

    /**
     * DECIMAL(16,2)<br>
     * 剩余数量/提货数量
     */
    private BigDecimal balQuantity;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(100)<br>
     * 押品一级
     */
    private String mortgageLevelOne;

    /**
     * VARCHAR(100)<br>
     * 押品二级
     */
    private String mortgageLevelTwo;

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
     * VARCHAR(100)<br>
     * 押品六级
     */
    private String mortgageLevelSix;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * DECIMAL(16,2)<br>
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * DECIMAL(16,2)<br>
     * 原总价
     */
    private BigDecimal originalTotPrice;

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
     * CHAR(2)<br>
     * 库存状态
     */
    private String stockStatus;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniOfCustcd;

    /**
     * VARCHAR(100)<br>
     * 品牌
     */
    private String vender;

    /**
     * VARCHAR(100)<br>
     * 生产地区
     */
    private String productArea;

    /**
     * VARCHAR(100)<br>
     * 入库编号
     */
    private String incomeNo;

    /**
     * DECIMAL(5,2)<br>
     * 质押率
     */
    private BigDecimal ration;

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
     * 年份
     */
    private String year;

    /**
     * VARCHAR(100)<br>
     * 仓单类型
     */
    private String billType;

    /**
     * DECIMAL(16,2)<br>
     * 总重量
     */
    private BigDecimal weightAll;

    /**
     * DECIMAL(16,2)<br>
     * 升贴水
     */
    private BigDecimal upDownMoney;

    /**
     * VARCHAR(32)<br>
     * 仓单表主键
     */
    private String billno;

    /**
     * DECIMAL(16,2)<br>
     * 仓单数量
     */
    private BigDecimal billQuantity;

    /**
     * VARCHAR(12)<br>
     * 期货经纪公司客户号
     */
    private String futureCustcd;

    /**
     * CHAR(8)<br>
     * 仓单到期日
     */
    private String billDueDate;

    /**
     * VARCHAR(6)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(300)<br>
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * DECIMAL(16,2)<br>
     * 原核定价
     */
    private BigDecimal oldConfirmPrice;

    /**
     * VARCHAR(200)<br>
     * 核价依据
     */
    private String confirmAccording;

    /**
     * VARCHAR(100)<br>
     * 押品名称
     */
    private String mortgageName;

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
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(100)<br>
     * 仓库名称
     */
    private String warehouse;

    /**
     * DECIMAL(22)<br>
     * 押品类型编号
     */
    private BigDecimal mortgageCode;

    /**
     * VARCHAR(50)<br>
     * 数量/重量单位
     */
    private String weightUnits;

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
     * 登记机构
     */
    private String brcode;

    /**
     * VARCHAR(100)<br>
     * 市场盯市编号
     */
    private String fixMortgageNo;

    /**
     * CHAR(1)<br>
     * 是否参与跑批：0-否;1-是
     */
    private String joinBatch;

    /**
     * VARCHAR(2)<br>
     * 升贴水标识
     */
    private String upDownMoneyFlag;

    /**
     * VARCHAR(20)<br>
     * 购销合同号
     */
    private String tradeContno;

    /**
     * DECIMAL(16,2)<br>
     * 出库押品数量
     */
    private BigDecimal outQuantity;

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
     * CHAR(2)<br>
     * 监管模式：00-自有库监管、01-输出监管
     */
    private String moniWarehouseType;

    /**
     * VARCHAR(256)<br>
     * 通用原因，如调价原因
     */
    private String reason;

    /**
     * VARCHAR(20)<br>
     * 发货通知编号
     */
    private String deliveryNum;

    /**
     * VARCHAR(100)<br>
     * 产品名称
     */
    private String productName;

    /**
     * VARCHAR(100)<br>
     * 包装
     */
    private String packagew;

    /**
     * DECIMAL(16,2)<br>
     * 押品追加数量
     */
    private BigDecimal addQuantity;

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
     * 获得 申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 业务申请类型
     */
    public String getAppliMortBizType() {
        return appliMortBizType;
    }

    /**
     * CHAR(4)<br>
     * 设置 业务申请类型
     */
    public void setAppliMortBizType(String appliMortBizType) {
        this.appliMortBizType = appliMortBizType == null ? null : appliMortBizType.trim();
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
     * CHAR(4)<br>
     * 获得 押品业务类型
     */
    public String getMortgageBizType() {
        return mortgageBizType;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品业务类型
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
     * VARCHAR(100)<br>
     * 获得 押品型号
     */
    public String getMortgageModel() {
        return mortgageModel;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品型号
     */
    public void setMortgageModel(String mortgageModel) {
        this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 抵质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 抵质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 押品计量单位
     */
    public String getMortgageUnits() {
        return mortgageUnits;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 押品计量单位
     */
    public void setMortgageUnits(String mortgageUnits) {
        this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 押品数量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 押品数量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 押品单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 押品单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 押品总价
     */
    public BigDecimal getTotPrice() {
        return totPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 押品总价
     */
    public void setTotPrice(BigDecimal totPrice) {
        this.totPrice = totPrice;
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
     * CHAR(2)<br>
     * 获得 押品标志：00-不可用、01-可用
     */
    public String getFlag() {
        return flag;
    }

    /**
     * CHAR(2)<br>
     * 设置 押品标志：00-不可用、01-可用
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 剩余数量/提货数量
     */
    public BigDecimal getBalQuantity() {
        return balQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 剩余数量/提货数量
     */
    public void setBalQuantity(BigDecimal balQuantity) {
        this.balQuantity = balQuantity;
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
     * VARCHAR(100)<br>
     * 获得 押品六级
     */
    public String getMortgageLevelSix() {
        return mortgageLevelSix;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品六级
     */
    public void setMortgageLevelSix(String mortgageLevelSix) {
        this.mortgageLevelSix = mortgageLevelSix == null ? null : mortgageLevelSix.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 原价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原总价
     */
    public BigDecimal getOriginalTotPrice() {
        return originalTotPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原总价
     */
    public void setOriginalTotPrice(BigDecimal originalTotPrice) {
        this.originalTotPrice = originalTotPrice;
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
     * CHAR(2)<br>
     * 获得 库存状态
     */
    public String getStockStatus() {
        return stockStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 库存状态
     */
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus == null ? null : stockStatus.trim();
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
     * 获得 生产地区
     */
    public String getProductArea() {
        return productArea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 生产地区
     */
    public void setProductArea(String productArea) {
        this.productArea = productArea == null ? null : productArea.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 入库编号
     */
    public String getIncomeNo() {
        return incomeNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 入库编号
     */
    public void setIncomeNo(String incomeNo) {
        this.incomeNo = incomeNo == null ? null : incomeNo.trim();
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 质押率
     */
    public BigDecimal getRation() {
        return ration;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 质押率
     */
    public void setRation(BigDecimal ration) {
        this.ration = ration;
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
     * 获得 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 年份
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 仓单类型
     */
    public String getBillType() {
        return billType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓单类型
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
     * VARCHAR(32)<br>
     * 获得 仓单表主键
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 仓单表主键
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
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
     * VARCHAR(12)<br>
     * 获得 期货经纪公司客户号
     */
    public String getFutureCustcd() {
        return futureCustcd;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 期货经纪公司客户号
     */
    public void setFutureCustcd(String futureCustcd) {
        this.futureCustcd = futureCustcd == null ? null : futureCustcd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 仓单到期日
     */
    public String getBillDueDate() {
        return billDueDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 仓单到期日
     */
    public void setBillDueDate(String billDueDate) {
        this.billDueDate = billDueDate == null ? null : billDueDate.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 原核定价
     */
    public BigDecimal getOldConfirmPrice() {
        return oldConfirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原核定价
     */
    public void setOldConfirmPrice(BigDecimal oldConfirmPrice) {
        this.oldConfirmPrice = oldConfirmPrice;
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
     * 获得 仓库名称
     */
    public String getWarehouse() {
        return warehouse;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓库名称
     */
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse == null ? null : warehouse.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 押品类型编号
     */
    public BigDecimal getMortgageCode() {
        return mortgageCode;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 押品类型编号
     */
    public void setMortgageCode(BigDecimal mortgageCode) {
        this.mortgageCode = mortgageCode;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 数量/重量单位
     */
    public String getWeightUnits() {
        return weightUnits;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 数量/重量单位
     */
    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits == null ? null : weightUnits.trim();
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
     * 获得 登记机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
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
     * 获得 是否参与跑批：0-否;1-是
     */
    public String getJoinBatch() {
        return joinBatch;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否参与跑批：0-否;1-是
     */
    public void setJoinBatch(String joinBatch) {
        this.joinBatch = joinBatch == null ? null : joinBatch.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 出库押品数量
     */
    public BigDecimal getOutQuantity() {
        return outQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 出库押品数量
     */
    public void setOutQuantity(BigDecimal outQuantity) {
        this.outQuantity = outQuantity;
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
     * CHAR(2)<br>
     * 获得 监管模式：00-自有库监管、01-输出监管
     */
    public String getMoniWarehouseType() {
        return moniWarehouseType;
    }

    /**
     * CHAR(2)<br>
     * 设置 监管模式：00-自有库监管、01-输出监管
     */
    public void setMoniWarehouseType(String moniWarehouseType) {
        this.moniWarehouseType = moniWarehouseType == null ? null : moniWarehouseType.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 通用原因，如调价原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 通用原因，如调价原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 发货通知编号
     */
    public String getDeliveryNum() {
        return deliveryNum;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 发货通知编号
     */
    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum == null ? null : deliveryNum.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 押品追加数量
     */
    public BigDecimal getAddQuantity() {
        return addQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 押品追加数量
     */
    public void setAddQuantity(BigDecimal addQuantity) {
        this.addQuantity = addQuantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", appliMortBizType=").append(appliMortBizType);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", mortgageBizType=").append(mortgageBizType);
        sb.append(", mortgageClass=").append(mortgageClass);
        sb.append(", mortgageSubClass=").append(mortgageSubClass);
        sb.append(", monitorProtocolNo=").append(monitorProtocolNo);
        sb.append(", otherProtocolNo=").append(otherProtocolNo);
        sb.append(", mortgageModel=").append(mortgageModel);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", custcd=").append(custcd);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", totPrice=").append(totPrice);
        sb.append(", description=").append(description);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", flag=").append(flag);
        sb.append(", balQuantity=").append(balQuantity);
        sb.append(", curcd=").append(curcd);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
        sb.append(", mortgageLevelFive=").append(mortgageLevelFive);
        sb.append(", mortgageLevelSix=").append(mortgageLevelSix);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", originalTotPrice=").append(originalTotPrice);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", confirmPrice=").append(confirmPrice);
        sb.append(", stockStatus=").append(stockStatus);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", vender=").append(vender);
        sb.append(", productArea=").append(productArea);
        sb.append(", incomeNo=").append(incomeNo);
        sb.append(", ration=").append(ration);
        sb.append(", qualityLevel=").append(qualityLevel);
        sb.append(", sn=").append(sn);
        sb.append(", year=").append(year);
        sb.append(", billType=").append(billType);
        sb.append(", weightAll=").append(weightAll);
        sb.append(", upDownMoney=").append(upDownMoney);
        sb.append(", billno=").append(billno);
        sb.append(", billQuantity=").append(billQuantity);
        sb.append(", futureCustcd=").append(futureCustcd);
        sb.append(", billDueDate=").append(billDueDate);
        sb.append(", status=").append(status);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", oldConfirmPrice=").append(oldConfirmPrice);
        sb.append(", confirmAccording=").append(confirmAccording);
        sb.append(", mortgageName=").append(mortgageName);
        sb.append(", freightarea=").append(freightarea);
        sb.append(", freightlot=").append(freightlot);
        sb.append(", memo=").append(memo);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", mortgageCode=").append(mortgageCode);
        sb.append(", weightUnits=").append(weightUnits);
        sb.append(", engineNo=").append(engineNo);
        sb.append(", chassisNo=").append(chassisNo);
        sb.append(", certificationNo=").append(certificationNo);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", brcode=").append(brcode);
        sb.append(", fixMortgageNo=").append(fixMortgageNo);
        sb.append(", joinBatch=").append(joinBatch);
        sb.append(", upDownMoneyFlag=").append(upDownMoneyFlag);
        sb.append(", tradeContno=").append(tradeContno);
        sb.append(", outQuantity=").append(outQuantity);
        sb.append(", isSlExibition=").append(isSlExibition);
        sb.append(", manufactureDate=").append(manufactureDate);
        sb.append(", documentNo=").append(documentNo);
        sb.append(", moniWarehouseType=").append(moniWarehouseType);
        sb.append(", reason=").append(reason);
        sb.append(", deliveryNum=").append(deliveryNum);
        sb.append(", productName=").append(productName);
        sb.append(", packagew=").append(packagew);
        sb.append(", addQuantity=").append(addQuantity);
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
        BPbcAppliMtgInfo other = (BPbcAppliMtgInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getAppliMortBizType() == null ? other.getAppliMortBizType() == null : this.getAppliMortBizType().equals(other.getAppliMortBizType()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getMortgageBizType() == null ? other.getMortgageBizType() == null : this.getMortgageBizType().equals(other.getMortgageBizType()))
            && (this.getMortgageClass() == null ? other.getMortgageClass() == null : this.getMortgageClass().equals(other.getMortgageClass()))
            && (this.getMortgageSubClass() == null ? other.getMortgageSubClass() == null : this.getMortgageSubClass().equals(other.getMortgageSubClass()))
            && (this.getMonitorProtocolNo() == null ? other.getMonitorProtocolNo() == null : this.getMonitorProtocolNo().equals(other.getMonitorProtocolNo()))
            && (this.getOtherProtocolNo() == null ? other.getOtherProtocolNo() == null : this.getOtherProtocolNo().equals(other.getOtherProtocolNo()))
            && (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getBalQuantity() == null ? other.getBalQuantity() == null : this.getBalQuantity().equals(other.getBalQuantity()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null : this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
            && (this.getMortgageLevelFive() == null ? other.getMortgageLevelFive() == null : this.getMortgageLevelFive().equals(other.getMortgageLevelFive()))
            && (this.getMortgageLevelSix() == null ? other.getMortgageLevelSix() == null : this.getMortgageLevelSix().equals(other.getMortgageLevelSix()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getOriginalTotPrice() == null ? other.getOriginalTotPrice() == null : this.getOriginalTotPrice().equals(other.getOriginalTotPrice()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
            && (this.getStockStatus() == null ? other.getStockStatus() == null : this.getStockStatus().equals(other.getStockStatus()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getVender() == null ? other.getVender() == null : this.getVender().equals(other.getVender()))
            && (this.getProductArea() == null ? other.getProductArea() == null : this.getProductArea().equals(other.getProductArea()))
            && (this.getIncomeNo() == null ? other.getIncomeNo() == null : this.getIncomeNo().equals(other.getIncomeNo()))
            && (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
            && (this.getQualityLevel() == null ? other.getQualityLevel() == null : this.getQualityLevel().equals(other.getQualityLevel()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getWeightAll() == null ? other.getWeightAll() == null : this.getWeightAll().equals(other.getWeightAll()))
            && (this.getUpDownMoney() == null ? other.getUpDownMoney() == null : this.getUpDownMoney().equals(other.getUpDownMoney()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getBillQuantity() == null ? other.getBillQuantity() == null : this.getBillQuantity().equals(other.getBillQuantity()))
            && (this.getFutureCustcd() == null ? other.getFutureCustcd() == null : this.getFutureCustcd().equals(other.getFutureCustcd()))
            && (this.getBillDueDate() == null ? other.getBillDueDate() == null : this.getBillDueDate().equals(other.getBillDueDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getOldConfirmPrice() == null ? other.getOldConfirmPrice() == null : this.getOldConfirmPrice().equals(other.getOldConfirmPrice()))
            && (this.getConfirmAccording() == null ? other.getConfirmAccording() == null : this.getConfirmAccording().equals(other.getConfirmAccording()))
            && (this.getMortgageName() == null ? other.getMortgageName() == null : this.getMortgageName().equals(other.getMortgageName()))
            && (this.getFreightarea() == null ? other.getFreightarea() == null : this.getFreightarea().equals(other.getFreightarea()))
            && (this.getFreightlot() == null ? other.getFreightlot() == null : this.getFreightlot().equals(other.getFreightlot()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getWarehouse() == null ? other.getWarehouse() == null : this.getWarehouse().equals(other.getWarehouse()))
            && (this.getMortgageCode() == null ? other.getMortgageCode() == null : this.getMortgageCode().equals(other.getMortgageCode()))
            && (this.getWeightUnits() == null ? other.getWeightUnits() == null : this.getWeightUnits().equals(other.getWeightUnits()))
            && (this.getEngineNo() == null ? other.getEngineNo() == null : this.getEngineNo().equals(other.getEngineNo()))
            && (this.getChassisNo() == null ? other.getChassisNo() == null : this.getChassisNo().equals(other.getChassisNo()))
            && (this.getCertificationNo() == null ? other.getCertificationNo() == null : this.getCertificationNo().equals(other.getCertificationNo()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getFixMortgageNo() == null ? other.getFixMortgageNo() == null : this.getFixMortgageNo().equals(other.getFixMortgageNo()))
            && (this.getJoinBatch() == null ? other.getJoinBatch() == null : this.getJoinBatch().equals(other.getJoinBatch()))
            && (this.getUpDownMoneyFlag() == null ? other.getUpDownMoneyFlag() == null : this.getUpDownMoneyFlag().equals(other.getUpDownMoneyFlag()))
            && (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
            && (this.getOutQuantity() == null ? other.getOutQuantity() == null : this.getOutQuantity().equals(other.getOutQuantity()))
            && (this.getIsSlExibition() == null ? other.getIsSlExibition() == null : this.getIsSlExibition().equals(other.getIsSlExibition()))
            && (this.getManufactureDate() == null ? other.getManufactureDate() == null : this.getManufactureDate().equals(other.getManufactureDate()))
            && (this.getDocumentNo() == null ? other.getDocumentNo() == null : this.getDocumentNo().equals(other.getDocumentNo()))
            && (this.getMoniWarehouseType() == null ? other.getMoniWarehouseType() == null : this.getMoniWarehouseType().equals(other.getMoniWarehouseType()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getDeliveryNum() == null ? other.getDeliveryNum() == null : this.getDeliveryNum().equals(other.getDeliveryNum()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getPackagew() == null ? other.getPackagew() == null : this.getPackagew().equals(other.getPackagew()))
            && (this.getAddQuantity() == null ? other.getAddQuantity() == null : this.getAddQuantity().equals(other.getAddQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getAppliMortBizType() == null) ? 0 : getAppliMortBizType().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getMortgageBizType() == null) ? 0 : getMortgageBizType().hashCode());
        result = prime * result + ((getMortgageClass() == null) ? 0 : getMortgageClass().hashCode());
        result = prime * result + ((getMortgageSubClass() == null) ? 0 : getMortgageSubClass().hashCode());
        result = prime * result + ((getMonitorProtocolNo() == null) ? 0 : getMonitorProtocolNo().hashCode());
        result = prime * result + ((getOtherProtocolNo() == null) ? 0 : getOtherProtocolNo().hashCode());
        result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getBalQuantity() == null) ? 0 : getBalQuantity().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
        result = prime * result + ((getMortgageLevelFive() == null) ? 0 : getMortgageLevelFive().hashCode());
        result = prime * result + ((getMortgageLevelSix() == null) ? 0 : getMortgageLevelSix().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getOriginalTotPrice() == null) ? 0 : getOriginalTotPrice().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
        result = prime * result + ((getStockStatus() == null) ? 0 : getStockStatus().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getVender() == null) ? 0 : getVender().hashCode());
        result = prime * result + ((getProductArea() == null) ? 0 : getProductArea().hashCode());
        result = prime * result + ((getIncomeNo() == null) ? 0 : getIncomeNo().hashCode());
        result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
        result = prime * result + ((getQualityLevel() == null) ? 0 : getQualityLevel().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getWeightAll() == null) ? 0 : getWeightAll().hashCode());
        result = prime * result + ((getUpDownMoney() == null) ? 0 : getUpDownMoney().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getBillQuantity() == null) ? 0 : getBillQuantity().hashCode());
        result = prime * result + ((getFutureCustcd() == null) ? 0 : getFutureCustcd().hashCode());
        result = prime * result + ((getBillDueDate() == null) ? 0 : getBillDueDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getOldConfirmPrice() == null) ? 0 : getOldConfirmPrice().hashCode());
        result = prime * result + ((getConfirmAccording() == null) ? 0 : getConfirmAccording().hashCode());
        result = prime * result + ((getMortgageName() == null) ? 0 : getMortgageName().hashCode());
        result = prime * result + ((getFreightarea() == null) ? 0 : getFreightarea().hashCode());
        result = prime * result + ((getFreightlot() == null) ? 0 : getFreightlot().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getWarehouse() == null) ? 0 : getWarehouse().hashCode());
        result = prime * result + ((getMortgageCode() == null) ? 0 : getMortgageCode().hashCode());
        result = prime * result + ((getWeightUnits() == null) ? 0 : getWeightUnits().hashCode());
        result = prime * result + ((getEngineNo() == null) ? 0 : getEngineNo().hashCode());
        result = prime * result + ((getChassisNo() == null) ? 0 : getChassisNo().hashCode());
        result = prime * result + ((getCertificationNo() == null) ? 0 : getCertificationNo().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getFixMortgageNo() == null) ? 0 : getFixMortgageNo().hashCode());
        result = prime * result + ((getJoinBatch() == null) ? 0 : getJoinBatch().hashCode());
        result = prime * result + ((getUpDownMoneyFlag() == null) ? 0 : getUpDownMoneyFlag().hashCode());
        result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
        result = prime * result + ((getOutQuantity() == null) ? 0 : getOutQuantity().hashCode());
        result = prime * result + ((getIsSlExibition() == null) ? 0 : getIsSlExibition().hashCode());
        result = prime * result + ((getManufactureDate() == null) ? 0 : getManufactureDate().hashCode());
        result = prime * result + ((getDocumentNo() == null) ? 0 : getDocumentNo().hashCode());
        result = prime * result + ((getMoniWarehouseType() == null) ? 0 : getMoniWarehouseType().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getDeliveryNum() == null) ? 0 : getDeliveryNum().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getPackagew() == null) ? 0 : getPackagew().hashCode());
        result = prime * result + ((getAddQuantity() == null) ? 0 : getAddQuantity().hashCode());
        return result;
    }
}