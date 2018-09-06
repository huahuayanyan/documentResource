package com.huateng.scf.adv.fcs.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BPbcMtgChkStockDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 核库盘库表主键
     */
    private String tblId;

    /**
     * VARCHAR(100)<br>
     * 押品类型编号
     */
    private String mortgageClassNo;

    /**
     * VARCHAR(100)<br>
     * 押品规格型号
     */
    private String mortgageModel;

    /**
     * DECIMAL(16,2)<br>
     * 实物数量
     */
    private BigDecimal entityQuantity;

    /**
     * DECIMAL(16,2)<br>
     * 库存数量
     */
    private BigDecimal stockQuantity;

    /**
     * VARCHAR(20)<br>
     * 押品编号
     */
    private String mortgageNo;

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
     * VARCHAR(80)<br>
     * 品牌/厂商
     */
    private String vender;

    /**
     * VARCHAR(300)<br>
     * 生产地区
     */
    private String productArea;

    /**
     * VARCHAR(300)<br>
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * CHAR(2)<br>
     * 巡库/盘库/对账明细表类型：01-对账；02-盘库；03-首次盘库；04-巡库
     */
    private String type;

    /**
     * VARCHAR(100)<br>
     * 押品单位
     */
    private String mortgageUnits;

    /**
     * VARCHAR(20)<br>
     * 数量单位
     */
    private String quantityunit;

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
     * 获得 核库盘库表主键
     */
    public String getTblId() {
        return tblId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 核库盘库表主键
     */
    public void setTblId(String tblId) {
        this.tblId = tblId == null ? null : tblId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 押品类型编号
     */
    public String getMortgageClassNo() {
        return mortgageClassNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品类型编号
     */
    public void setMortgageClassNo(String mortgageClassNo) {
        this.mortgageClassNo = mortgageClassNo == null ? null : mortgageClassNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 押品规格型号
     */
    public String getMortgageModel() {
        return mortgageModel;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品规格型号
     */
    public void setMortgageModel(String mortgageModel) {
        this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 实物数量
     */
    public BigDecimal getEntityQuantity() {
        return entityQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 实物数量
     */
    public void setEntityQuantity(BigDecimal entityQuantity) {
        this.entityQuantity = entityQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 库存数量
     */
    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 库存数量
     */
    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
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
     * VARCHAR(80)<br>
     * 获得 品牌/厂商
     */
    public String getVender() {
        return vender;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 品牌/厂商
     */
    public void setVender(String vender) {
        this.vender = vender == null ? null : vender.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 生产地区
     */
    public String getProductArea() {
        return productArea;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 生产地区
     */
    public void setProductArea(String productArea) {
        this.productArea = productArea == null ? null : productArea.trim();
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
     * CHAR(2)<br>
     * 获得 巡库/盘库/对账明细表类型：01-对账；02-盘库；03-首次盘库；04-巡库
     */
    public String getType() {
        return type;
    }

    /**
     * CHAR(2)<br>
     * 设置 巡库/盘库/对账明细表类型：01-对账；02-盘库；03-首次盘库；04-巡库
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 押品单位
     */
    public String getMortgageUnits() {
        return mortgageUnits;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 押品单位
     */
    public void setMortgageUnits(String mortgageUnits) {
        this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 数量单位
     */
    public String getQuantityunit() {
        return quantityunit;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 数量单位
     */
    public void setQuantityunit(String quantityunit) {
        this.quantityunit = quantityunit == null ? null : quantityunit.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tblId=").append(tblId);
        sb.append(", mortgageClassNo=").append(mortgageClassNo);
        sb.append(", mortgageModel=").append(mortgageModel);
        sb.append(", entityQuantity=").append(entityQuantity);
        sb.append(", stockQuantity=").append(stockQuantity);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
        sb.append(", mortgageLevelFive=").append(mortgageLevelFive);
        sb.append(", mortgageLevelSix=").append(mortgageLevelSix);
        sb.append(", confirmPrice=").append(confirmPrice);
        sb.append(", totPrice=").append(totPrice);
        sb.append(", vender=").append(vender);
        sb.append(", productArea=").append(productArea);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", type=").append(type);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", quantityunit=").append(quantityunit);
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
        BPbcMtgChkStockDtl other = (BPbcMtgChkStockDtl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTblId() == null ? other.getTblId() == null : this.getTblId().equals(other.getTblId()))
            && (this.getMortgageClassNo() == null ? other.getMortgageClassNo() == null : this.getMortgageClassNo().equals(other.getMortgageClassNo()))
            && (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
            && (this.getEntityQuantity() == null ? other.getEntityQuantity() == null : this.getEntityQuantity().equals(other.getEntityQuantity()))
            && (this.getStockQuantity() == null ? other.getStockQuantity() == null : this.getStockQuantity().equals(other.getStockQuantity()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null : this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
            && (this.getMortgageLevelFive() == null ? other.getMortgageLevelFive() == null : this.getMortgageLevelFive().equals(other.getMortgageLevelFive()))
            && (this.getMortgageLevelSix() == null ? other.getMortgageLevelSix() == null : this.getMortgageLevelSix().equals(other.getMortgageLevelSix()))
            && (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
            && (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
            && (this.getVender() == null ? other.getVender() == null : this.getVender().equals(other.getVender()))
            && (this.getProductArea() == null ? other.getProductArea() == null : this.getProductArea().equals(other.getProductArea()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getQuantityunit() == null ? other.getQuantityunit() == null : this.getQuantityunit().equals(other.getQuantityunit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTblId() == null) ? 0 : getTblId().hashCode());
        result = prime * result + ((getMortgageClassNo() == null) ? 0 : getMortgageClassNo().hashCode());
        result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
        result = prime * result + ((getEntityQuantity() == null) ? 0 : getEntityQuantity().hashCode());
        result = prime * result + ((getStockQuantity() == null) ? 0 : getStockQuantity().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
        result = prime * result + ((getMortgageLevelFive() == null) ? 0 : getMortgageLevelFive().hashCode());
        result = prime * result + ((getMortgageLevelSix() == null) ? 0 : getMortgageLevelSix().hashCode());
        result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
        result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
        result = prime * result + ((getVender() == null) ? 0 : getVender().hashCode());
        result = prime * result + ((getProductArea() == null) ? 0 : getProductArea().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getQuantityunit() == null) ? 0 : getQuantityunit().hashCode());
        return result;
    }
}