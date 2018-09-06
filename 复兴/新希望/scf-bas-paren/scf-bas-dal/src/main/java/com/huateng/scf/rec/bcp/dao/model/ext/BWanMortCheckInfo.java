package com.huateng.scf.rec.bcp.dao.model.ext;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWanMortCheckInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 关联预警基本信息表
     */
    private String warnId;

    /**
     * VARCHAR(80)<br>
     * 出质人名称
     */
    private String cname;

    /**
     * VARCHAR(15)<br>
     * 出质人客户号
     */
    private String custcd;

    /**
     * VARCHAR(80)<br>
     * 监管公司名称
     */
    private String moniCname;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniCustcd;

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
     * VARCHAR(50)<br>
     * 计量单位
     */
    private String mortgageUnits;

    /**
     * VARCHAR(100)<br>
     * 规格型号
     */
    private String mortgageModel;

    /**
     * CHAR(8)<br>
     * 价格日期
     */
    private String priceDate;

    /**
     * DECIMAL(16,2)<br>
     * 原始市场价格
     */
    private BigDecimal originalMarketPrice;

    /**
     * DECIMAL(16,2)<br>
     * 市场价格
     */
    private BigDecimal marketPrice;

    /**
     * DECIMAL(16,2)<br>
     * 核定价格
     */
    private BigDecimal confirmPrice;

    /**
     * DECIMAL(10,4)<br>
     * 波动率/价格跌幅
     */
    private BigDecimal fluctuation;

    /**
     * VARCHAR(20)<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(200)<br>
     * 质押合同号
     */
    private String slaveContcode;

    /**
     * VARCHAR(20)<br>
     * 监管合同号
     */
    private String protocolNo;

    /**
     * VARCHAR(20)<br>
     * 借款合同号
     */
    private String mastContno;

    /**
     * CHAR(1)<br>
     * 预警类型：0-价格跌幅预警、1-价格异常预警
     */
    private String warnType;

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
     * 获得 关联预警基本信息表
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 关联预警基本信息表
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId == null ? null : warnId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 出质人名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 出质人名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
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
     * VARCHAR(80)<br>
     * 获得 监管公司名称
     */
    public String getMoniCname() {
        return moniCname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 监管公司名称
     */
    public void setMoniCname(String moniCname) {
        this.moniCname = moniCname == null ? null : moniCname.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
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
     * CHAR(8)<br>
     * 获得 价格日期
     */
    public String getPriceDate() {
        return priceDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 价格日期
     */
    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate == null ? null : priceDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始市场价格
     */
    public BigDecimal getOriginalMarketPrice() {
        return originalMarketPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始市场价格
     */
    public void setOriginalMarketPrice(BigDecimal originalMarketPrice) {
        this.originalMarketPrice = originalMarketPrice;
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
     * 获得 核定价格
     */
    public BigDecimal getConfirmPrice() {
        return confirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 核定价格
     */
    public void setConfirmPrice(BigDecimal confirmPrice) {
        this.confirmPrice = confirmPrice;
    }

    /**
     * DECIMAL(10,4)<br>
     * 获得 波动率/价格跌幅
     */
    public BigDecimal getFluctuation() {
        return fluctuation;
    }

    /**
     * DECIMAL(10,4)<br>
     * 设置 波动率/价格跌幅
     */
    public void setFluctuation(BigDecimal fluctuation) {
        this.fluctuation = fluctuation;
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
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 质押合同号
     */
    public String getSlaveContcode() {
        return slaveContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 质押合同号
     */
    public void setSlaveContcode(String slaveContcode) {
        this.slaveContcode = slaveContcode == null ? null : slaveContcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管合同号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管合同号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 借款合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 借款合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 预警类型：0-价格跌幅预警、1-价格异常预警
     */
    public String getWarnType() {
        return warnType;
    }

    /**
     * CHAR(1)<br>
     * 设置 预警类型：0-价格跌幅预警、1-价格异常预警
     */
    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warnId=").append(warnId);
        sb.append(", cname=").append(cname);
        sb.append(", custcd=").append(custcd);
        sb.append(", moniCname=").append(moniCname);
        sb.append(", moniCustcd=").append(moniCustcd);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", mortgageModel=").append(mortgageModel);
        sb.append(", priceDate=").append(priceDate);
        sb.append(", originalMarketPrice=").append(originalMarketPrice);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", confirmPrice=").append(confirmPrice);
        sb.append(", fluctuation=").append(fluctuation);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", slaveContcode=").append(slaveContcode);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", warnType=").append(warnType);
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
        BWanMortCheckInfo other = (BWanMortCheckInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getMoniCname() == null ? other.getMoniCname() == null : this.getMoniCname().equals(other.getMoniCname()))
            && (this.getMoniCustcd() == null ? other.getMoniCustcd() == null : this.getMoniCustcd().equals(other.getMoniCustcd()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
            && (this.getPriceDate() == null ? other.getPriceDate() == null : this.getPriceDate().equals(other.getPriceDate()))
            && (this.getOriginalMarketPrice() == null ? other.getOriginalMarketPrice() == null : this.getOriginalMarketPrice().equals(other.getOriginalMarketPrice()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
            && (this.getFluctuation() == null ? other.getFluctuation() == null : this.getFluctuation().equals(other.getFluctuation()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getSlaveContcode() == null ? other.getSlaveContcode() == null : this.getSlaveContcode().equals(other.getSlaveContcode()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getWarnType() == null ? other.getWarnType() == null : this.getWarnType().equals(other.getWarnType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnId() == null) ? 0 : getWarnId().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getMoniCname() == null) ? 0 : getMoniCname().hashCode());
        result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
        result = prime * result + ((getPriceDate() == null) ? 0 : getPriceDate().hashCode());
        result = prime * result + ((getOriginalMarketPrice() == null) ? 0 : getOriginalMarketPrice().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
        result = prime * result + ((getFluctuation() == null) ? 0 : getFluctuation().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getSlaveContcode() == null) ? 0 : getSlaveContcode().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getWarnType() == null) ? 0 : getWarnType().hashCode());
        return result;
    }
}