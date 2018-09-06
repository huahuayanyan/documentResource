package com.huateng.scf.bas.brp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BBrpPrdFactoring implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * VARCHAR(2)<br>
     * 保理业务类型：2-国内保理，默认、1-反向保理、3-行内双保理、4-信保保理、5-租赁保理、6-应收账款质押、7-应收账款质押池融资、8-保理池融资、9-出口退税池质押融资
     */
    private String factType;

    /**
     * CHAR(1)<br>
     * 1-单保理，2-双保理
     */
    private String type;

    /**
     * CHAR(1)<br>
     * 1-有追索；2-无追索
     */
    private String recoverType;

    /**
     * CHAR(1)<br>
     * 1-境内，2-境外
     */
    private String inout;

    /**
     * CHAR(1)<br>
     * 计息方式【1-应收利息，2-预收利息】
     */
    private String calcRateType;

    /**
     * CHAR(1)<br>
     * 利息摊提【1-每日，2-每月，3-每季】
     */
    private String rateShareType;

    /**
     * DECIMAL(22)<br>
     * 融资最大宽限期(天)
     */
    private BigDecimal graceDays;

    /**
     * DECIMAL(22)<br>
     * 应收账款最大宽限*期(天)
     */
    private BigDecimal debtGraceDays;

    /**
     * CHAR(1)<br>
     * 融资模式【1-发票融资，2-池融资】
     */
    private String financingType;

    /**
     * CHAR(1)<br>
     * 卖方客户类型
     */
    private String sellerType;

    /**
     * CHAR(1)<br>
     * 买方客户类型
     */
    private String buyerType;

    /**
     * CHAR(2)<br>
     * 应收账款类型
     */
    private String billsType;

    /**
     * CHAR(1)<br>
     * 是否租赁保理
     */
    private String leaseFactoringFlag;

    /**
     * CHAR(1)<br>
     * 是否售后回租
     */
    private String leasebackFlag;

    /**
     * VARCHAR(10) 必填<br>
     * 获得 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保理业务类型：2-国内保理，默认、1-反向保理、3-行内双保理、4-信保保理、5-租赁保理、6-应收账款质押、7-应收账款质押池融资、8-保理池融资、9-出口退税池质押融资
     */
    public String getFactType() {
        return factType;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保理业务类型：2-国内保理，默认、1-反向保理、3-行内双保理、4-信保保理、5-租赁保理、6-应收账款质押、7-应收账款质押池融资、8-保理池融资、9-出口退税池质押融资
     */
    public void setFactType(String factType) {
        this.factType = factType == null ? null : factType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 1-单保理，2-双保理
     */
    public String getType() {
        return type;
    }

    /**
     * CHAR(1)<br>
     * 设置 1-单保理，2-双保理
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 1-有追索；2-无追索
     */
    public String getRecoverType() {
        return recoverType;
    }

    /**
     * CHAR(1)<br>
     * 设置 1-有追索；2-无追索
     */
    public void setRecoverType(String recoverType) {
        this.recoverType = recoverType == null ? null : recoverType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 1-境内，2-境外
     */
    public String getInout() {
        return inout;
    }

    /**
     * CHAR(1)<br>
     * 设置 1-境内，2-境外
     */
    public void setInout(String inout) {
        this.inout = inout == null ? null : inout.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 计息方式【1-应收利息，2-预收利息】
     */
    public String getCalcRateType() {
        return calcRateType;
    }

    /**
     * CHAR(1)<br>
     * 设置 计息方式【1-应收利息，2-预收利息】
     */
    public void setCalcRateType(String calcRateType) {
        this.calcRateType = calcRateType == null ? null : calcRateType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 利息摊提【1-每日，2-每月，3-每季】
     */
    public String getRateShareType() {
        return rateShareType;
    }

    /**
     * CHAR(1)<br>
     * 设置 利息摊提【1-每日，2-每月，3-每季】
     */
    public void setRateShareType(String rateShareType) {
        this.rateShareType = rateShareType == null ? null : rateShareType.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 融资最大宽限期(天)
     */
    public BigDecimal getGraceDays() {
        return graceDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 融资最大宽限期(天)
     */
    public void setGraceDays(BigDecimal graceDays) {
        this.graceDays = graceDays;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 应收账款最大宽限*期(天)
     */
    public BigDecimal getDebtGraceDays() {
        return debtGraceDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 应收账款最大宽限*期(天)
     */
    public void setDebtGraceDays(BigDecimal debtGraceDays) {
        this.debtGraceDays = debtGraceDays;
    }

    /**
     * CHAR(1)<br>
     * 获得 融资模式【1-发票融资，2-池融资】
     */
    public String getFinancingType() {
        return financingType;
    }

    /**
     * CHAR(1)<br>
     * 设置 融资模式【1-发票融资，2-池融资】
     */
    public void setFinancingType(String financingType) {
        this.financingType = financingType == null ? null : financingType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 卖方客户类型
     */
    public String getSellerType() {
        return sellerType;
    }

    /**
     * CHAR(1)<br>
     * 设置 卖方客户类型
     */
    public void setSellerType(String sellerType) {
        this.sellerType = sellerType == null ? null : sellerType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 买方客户类型
     */
    public String getBuyerType() {
        return buyerType;
    }

    /**
     * CHAR(1)<br>
     * 设置 买方客户类型
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType == null ? null : buyerType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 应收账款类型
     */
    public String getBillsType() {
        return billsType;
    }

    /**
     * CHAR(2)<br>
     * 设置 应收账款类型
     */
    public void setBillsType(String billsType) {
        this.billsType = billsType == null ? null : billsType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否租赁保理
     */
    public String getLeaseFactoringFlag() {
        return leaseFactoringFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否租赁保理
     */
    public void setLeaseFactoringFlag(String leaseFactoringFlag) {
        this.leaseFactoringFlag = leaseFactoringFlag == null ? null : leaseFactoringFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否售后回租
     */
    public String getLeasebackFlag() {
        return leasebackFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否售后回租
     */
    public void setLeasebackFlag(String leasebackFlag) {
        this.leasebackFlag = leasebackFlag == null ? null : leasebackFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", factType=").append(factType);
        sb.append(", type=").append(type);
        sb.append(", recoverType=").append(recoverType);
        sb.append(", inout=").append(inout);
        sb.append(", calcRateType=").append(calcRateType);
        sb.append(", rateShareType=").append(rateShareType);
        sb.append(", graceDays=").append(graceDays);
        sb.append(", debtGraceDays=").append(debtGraceDays);
        sb.append(", financingType=").append(financingType);
        sb.append(", sellerType=").append(sellerType);
        sb.append(", buyerType=").append(buyerType);
        sb.append(", billsType=").append(billsType);
        sb.append(", leaseFactoringFlag=").append(leaseFactoringFlag);
        sb.append(", leasebackFlag=").append(leasebackFlag);
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
        BBrpPrdFactoring other = (BBrpPrdFactoring) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getFactType() == null ? other.getFactType() == null : this.getFactType().equals(other.getFactType()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRecoverType() == null ? other.getRecoverType() == null : this.getRecoverType().equals(other.getRecoverType()))
            && (this.getInout() == null ? other.getInout() == null : this.getInout().equals(other.getInout()))
            && (this.getCalcRateType() == null ? other.getCalcRateType() == null : this.getCalcRateType().equals(other.getCalcRateType()))
            && (this.getRateShareType() == null ? other.getRateShareType() == null : this.getRateShareType().equals(other.getRateShareType()))
            && (this.getGraceDays() == null ? other.getGraceDays() == null : this.getGraceDays().equals(other.getGraceDays()))
            && (this.getDebtGraceDays() == null ? other.getDebtGraceDays() == null : this.getDebtGraceDays().equals(other.getDebtGraceDays()))
            && (this.getFinancingType() == null ? other.getFinancingType() == null : this.getFinancingType().equals(other.getFinancingType()))
            && (this.getSellerType() == null ? other.getSellerType() == null : this.getSellerType().equals(other.getSellerType()))
            && (this.getBuyerType() == null ? other.getBuyerType() == null : this.getBuyerType().equals(other.getBuyerType()))
            && (this.getBillsType() == null ? other.getBillsType() == null : this.getBillsType().equals(other.getBillsType()))
            && (this.getLeaseFactoringFlag() == null ? other.getLeaseFactoringFlag() == null : this.getLeaseFactoringFlag().equals(other.getLeaseFactoringFlag()))
            && (this.getLeasebackFlag() == null ? other.getLeasebackFlag() == null : this.getLeasebackFlag().equals(other.getLeasebackFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getFactType() == null) ? 0 : getFactType().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRecoverType() == null) ? 0 : getRecoverType().hashCode());
        result = prime * result + ((getInout() == null) ? 0 : getInout().hashCode());
        result = prime * result + ((getCalcRateType() == null) ? 0 : getCalcRateType().hashCode());
        result = prime * result + ((getRateShareType() == null) ? 0 : getRateShareType().hashCode());
        result = prime * result + ((getGraceDays() == null) ? 0 : getGraceDays().hashCode());
        result = prime * result + ((getDebtGraceDays() == null) ? 0 : getDebtGraceDays().hashCode());
        result = prime * result + ((getFinancingType() == null) ? 0 : getFinancingType().hashCode());
        result = prime * result + ((getSellerType() == null) ? 0 : getSellerType().hashCode());
        result = prime * result + ((getBuyerType() == null) ? 0 : getBuyerType().hashCode());
        result = prime * result + ((getBillsType() == null) ? 0 : getBillsType().hashCode());
        result = prime * result + ((getLeaseFactoringFlag() == null) ? 0 : getLeaseFactoringFlag().hashCode());
        result = prime * result + ((getLeasebackFlag() == null) ? 0 : getLeasebackFlag().hashCode());
        return result;
    }
}