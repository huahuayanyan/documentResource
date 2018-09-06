package com.huateng.scf.bas.pbc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgMktPrice implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * CHAR(4)<br>
     * 押品小类
     */
    private String mortgageSubClass;

    /**
     * CHAR(4)<br>
     * 押品规格型号
     */
    private String mortgageModel;

    /**
     * DECIMAL(16,2)<br>
     * 押品单价
     */
    private BigDecimal price;

    /**
     * CHAR(4)<br>
     * 押品大类编号
     */
    private String mortgageClassNo;

    /**
     * CHAR(2)<br>
     * 市价来源
     */
    private String marketPriceSrc;

    /**
     * VARCHAR(256)<br>
     * 来源描述
     */
    private String srcDescription;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(3)<br>
     * 押品单位
     */
    private String mortgageUnits;

    /**
     * VARCHAR(40)<br>
     * 产品类型
     */
    private String productId;

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
     * VARCHAR(20)<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * VARCHAR(100)<br>
     * 押品三级名称
     */
    private String mortgageThreeName;

    /**
     * VARCHAR(100)<br>
     * 产品名称
     */
    private String productName;

    /**
     * CHAR(8)<br>
     * 价格日期
     */
    private String priceDate;

    /**
     * DECIMAL(16,2)<br>
     * 涨跌
     */
    private BigDecimal upDownPrice;

    /**
     * CHAR(8)<br>
     * 添加日期
     */
    private String addDate;

    /**
     * VARCHAR(256)<br>
     * 备注描述
     */
    private String description;

    /**
     * VARCHAR(20)<br>
     * 单位名称
     */
    private String mortUnitsName;

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
     * 获得 押品规格型号
     */
    public String getMortgageModel() {
        return mortgageModel;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品规格型号
     */
    public void setMortgageModel(String mortgageModel) {
        this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
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
     * CHAR(4)<br>
     * 获得 押品大类编号
     */
    public String getMortgageClassNo() {
        return mortgageClassNo;
    }

    /**
     * CHAR(4)<br>
     * 设置 押品大类编号
     */
    public void setMortgageClassNo(String mortgageClassNo) {
        this.mortgageClassNo = mortgageClassNo == null ? null : mortgageClassNo.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 市价来源
     */
    public String getMarketPriceSrc() {
        return marketPriceSrc;
    }

    /**
     * CHAR(2)<br>
     * 设置 市价来源
     */
    public void setMarketPriceSrc(String marketPriceSrc) {
        this.marketPriceSrc = marketPriceSrc == null ? null : marketPriceSrc.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 来源描述
     */
    public String getSrcDescription() {
        return srcDescription;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 来源描述
     */
    public void setSrcDescription(String srcDescription) {
        this.srcDescription = srcDescription == null ? null : srcDescription.trim();
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
     * CHAR(3)<br>
     * 获得 押品单位
     */
    public String getMortgageUnits() {
        return mortgageUnits;
    }

    /**
     * CHAR(3)<br>
     * 设置 押品单位
     */
    public void setMortgageUnits(String mortgageUnits) {
        this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 产品类型
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 产品类型
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
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
     * VARCHAR(100)<br>
     * 获得 押品三级名称
     */
    public String getMortgageThreeName() {
        return mortgageThreeName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品三级名称
     */
    public void setMortgageThreeName(String mortgageThreeName) {
        this.mortgageThreeName = mortgageThreeName == null ? null : mortgageThreeName.trim();
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
     * 获得 涨跌
     */
    public BigDecimal getUpDownPrice() {
        return upDownPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 涨跌
     */
    public void setUpDownPrice(BigDecimal upDownPrice) {
        this.upDownPrice = upDownPrice;
    }

    /**
     * CHAR(8)<br>
     * 获得 添加日期
     */
    public String getAddDate() {
        return addDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 添加日期
     */
    public void setAddDate(String addDate) {
        this.addDate = addDate == null ? null : addDate.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 备注描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 备注描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 单位名称
     */
    public String getMortUnitsName() {
        return mortUnitsName;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 单位名称
     */
    public void setMortUnitsName(String mortUnitsName) {
        this.mortUnitsName = mortUnitsName == null ? null : mortUnitsName.trim();
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
        sb.append(", mortgageSubClass=").append(mortgageSubClass);
        sb.append(", mortgageModel=").append(mortgageModel);
        sb.append(", price=").append(price);
        sb.append(", mortgageClassNo=").append(mortgageClassNo);
        sb.append(", marketPriceSrc=").append(marketPriceSrc);
        sb.append(", srcDescription=").append(srcDescription);
        sb.append(", curcd=").append(curcd);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", productId=").append(productId);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", mortgageThreeName=").append(mortgageThreeName);
        sb.append(", productName=").append(productName);
        sb.append(", priceDate=").append(priceDate);
        sb.append(", upDownPrice=").append(upDownPrice);
        sb.append(", addDate=").append(addDate);
        sb.append(", description=").append(description);
        sb.append(", mortUnitsName=").append(mortUnitsName);
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
        BPbcMtgMktPrice other = (BPbcMtgMktPrice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMortgageSubClass() == null ? other.getMortgageSubClass() == null : this.getMortgageSubClass().equals(other.getMortgageSubClass()))
            && (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMortgageClassNo() == null ? other.getMortgageClassNo() == null : this.getMortgageClassNo().equals(other.getMortgageClassNo()))
            && (this.getMarketPriceSrc() == null ? other.getMarketPriceSrc() == null : this.getMarketPriceSrc().equals(other.getMarketPriceSrc()))
            && (this.getSrcDescription() == null ? other.getSrcDescription() == null : this.getSrcDescription().equals(other.getSrcDescription()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getMortgageThreeName() == null ? other.getMortgageThreeName() == null : this.getMortgageThreeName().equals(other.getMortgageThreeName()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getPriceDate() == null ? other.getPriceDate() == null : this.getPriceDate().equals(other.getPriceDate()))
            && (this.getUpDownPrice() == null ? other.getUpDownPrice() == null : this.getUpDownPrice().equals(other.getUpDownPrice()))
            && (this.getAddDate() == null ? other.getAddDate() == null : this.getAddDate().equals(other.getAddDate()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMortUnitsName() == null ? other.getMortUnitsName() == null : this.getMortUnitsName().equals(other.getMortUnitsName()))
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
        result = prime * result + ((getMortgageSubClass() == null) ? 0 : getMortgageSubClass().hashCode());
        result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMortgageClassNo() == null) ? 0 : getMortgageClassNo().hashCode());
        result = prime * result + ((getMarketPriceSrc() == null) ? 0 : getMarketPriceSrc().hashCode());
        result = prime * result + ((getSrcDescription() == null) ? 0 : getSrcDescription().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getMortgageThreeName() == null) ? 0 : getMortgageThreeName().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getPriceDate() == null) ? 0 : getPriceDate().hashCode());
        result = prime * result + ((getUpDownPrice() == null) ? 0 : getUpDownPrice().hashCode());
        result = prime * result + ((getAddDate() == null) ? 0 : getAddDate().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMortUnitsName() == null) ? 0 : getMortUnitsName().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}