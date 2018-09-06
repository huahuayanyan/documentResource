package com.huateng.scf.bas.brp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BBrpCostParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * CHAR(4)<br>
     * 费用代码
     */
    private String costCode;

    /**
     * VARCHAR(100)<br>
     * 费用名称
     */
    private String costName;

    /**
     * CHAR(2)<br>
     * 允许收取种类：1-整体、2-单张
     */
    private String costClass;

    /**
     * CHAR(3)<br>
     * 允许第1位-先收；第2位-后收；第3位-免收
     */
    private String costType;

    /**
     * CHAR(2)<br>
     * 允许计算方式：第1位-固定、第2位-按比率
     */
    private String costCalcType;

    /**
     * DECIMAL(5,2)<br>
     * 最小比率，按比率收取时使用
     */
    private BigDecimal minRate;

    /**
     * DECIMAL(5,2)<br>
     * 最大比率，按比率收取时使用
     */
    private BigDecimal maxRate;

    /**
     * CHAR(2)<br>
     * 先收时使用
第1位-外扣，第2位-内收
     */
    private String chargeType;

    /**
     * VARCHAR(200)<br>
     * 备注
     */
    private String costDesc;

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
     * CHAR(4)<br>
     * 获得 费用代码
     */
    public String getCostCode() {
        return costCode;
    }

    /**
     * CHAR(4)<br>
     * 设置 费用代码
     */
    public void setCostCode(String costCode) {
        this.costCode = costCode == null ? null : costCode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 费用名称
     */
    public String getCostName() {
        return costName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 费用名称
     */
    public void setCostName(String costName) {
        this.costName = costName == null ? null : costName.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 允许收取种类：1-整体、2-单张
     */
    public String getCostClass() {
        return costClass;
    }

    /**
     * CHAR(2)<br>
     * 设置 允许收取种类：1-整体、2-单张
     */
    public void setCostClass(String costClass) {
        this.costClass = costClass == null ? null : costClass.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 允许第1位-先收；第2位-后收；第3位-免收
     */
    public String getCostType() {
        return costType;
    }

    /**
     * CHAR(3)<br>
     * 设置 允许第1位-先收；第2位-后收；第3位-免收
     */
    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 允许计算方式：第1位-固定、第2位-按比率
     */
    public String getCostCalcType() {
        return costCalcType;
    }

    /**
     * CHAR(2)<br>
     * 设置 允许计算方式：第1位-固定、第2位-按比率
     */
    public void setCostCalcType(String costCalcType) {
        this.costCalcType = costCalcType == null ? null : costCalcType.trim();
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 最小比率，按比率收取时使用
     */
    public BigDecimal getMinRate() {
        return minRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 最小比率，按比率收取时使用
     */
    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 最大比率，按比率收取时使用
     */
    public BigDecimal getMaxRate() {
        return maxRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 最大比率，按比率收取时使用
     */
    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    /**
     * CHAR(2)<br>
     * 获得 先收时使用
第1位-外扣，第2位-内收
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(2)<br>
     * 设置 先收时使用
第1位-外扣，第2位-内收
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 备注
     */
    public String getCostDesc() {
        return costDesc;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 备注
     */
    public void setCostDesc(String costDesc) {
        this.costDesc = costDesc == null ? null : costDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", costCode=").append(costCode);
        sb.append(", costName=").append(costName);
        sb.append(", costClass=").append(costClass);
        sb.append(", costType=").append(costType);
        sb.append(", costCalcType=").append(costCalcType);
        sb.append(", minRate=").append(minRate);
        sb.append(", maxRate=").append(maxRate);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", costDesc=").append(costDesc);
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
        BBrpCostParam other = (BBrpCostParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCostCode() == null ? other.getCostCode() == null : this.getCostCode().equals(other.getCostCode()))
            && (this.getCostName() == null ? other.getCostName() == null : this.getCostName().equals(other.getCostName()))
            && (this.getCostClass() == null ? other.getCostClass() == null : this.getCostClass().equals(other.getCostClass()))
            && (this.getCostType() == null ? other.getCostType() == null : this.getCostType().equals(other.getCostType()))
            && (this.getCostCalcType() == null ? other.getCostCalcType() == null : this.getCostCalcType().equals(other.getCostCalcType()))
            && (this.getMinRate() == null ? other.getMinRate() == null : this.getMinRate().equals(other.getMinRate()))
            && (this.getMaxRate() == null ? other.getMaxRate() == null : this.getMaxRate().equals(other.getMaxRate()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getCostDesc() == null ? other.getCostDesc() == null : this.getCostDesc().equals(other.getCostDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCostCode() == null) ? 0 : getCostCode().hashCode());
        result = prime * result + ((getCostName() == null) ? 0 : getCostName().hashCode());
        result = prime * result + ((getCostClass() == null) ? 0 : getCostClass().hashCode());
        result = prime * result + ((getCostType() == null) ? 0 : getCostType().hashCode());
        result = prime * result + ((getCostCalcType() == null) ? 0 : getCostCalcType().hashCode());
        result = prime * result + ((getMinRate() == null) ? 0 : getMinRate().hashCode());
        result = prime * result + ((getMaxRate() == null) ? 0 : getMaxRate().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getCostDesc() == null) ? 0 : getCostDesc().hashCode());
        return result;
    }
}