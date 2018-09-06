package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BCntCostInfo extends ScfBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * CHAR(1)<br>
     * 关联类型
     */
    private String relaType;

    /**
     * VARCHAR(20)<br>
     * 关联业务合同号/协议号
     */
    private String relaNo;

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
     * CHAR(1)<br>
     * 费用收取种类
     */
    private String costClass;

    /**
     * CHAR(1)<br>
     * 收取方式
     */
    private String costType;

    /**
     * CHAR(1)<br>
     * 扣取方式
     */
    private String chargeType;

    /**
     * CHAR(1)<br>
     * 计算方式
     */
    private String costCalcType;

    /**
     * DECIMAL(5,2)<br>
     * 费用比率(%)
     */
    private BigDecimal costRate;

    /**
     * DECIMAL(16,2)<br>
     * 固定费用
     */
    private BigDecimal costAmt;

    /**
     * VARCHAR(2)<br>
     * 费用收取阶段
     */
    private String costPhase;

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
     * CHAR(1)<br>
     * 获得 关联类型
     */
    public String getRelaType() {
        return relaType;
    }

    /**
     * CHAR(1)<br>
     * 设置 关联类型
     */
    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 关联业务合同号/协议号
     */
    public String getRelaNo() {
        return relaNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联业务合同号/协议号
     */
    public void setRelaNo(String relaNo) {
        this.relaNo = relaNo == null ? null : relaNo.trim();
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
     * CHAR(1)<br>
     * 获得 费用收取种类
     */
    public String getCostClass() {
        return costClass;
    }

    /**
     * CHAR(1)<br>
     * 设置 费用收取种类
     */
    public void setCostClass(String costClass) {
        this.costClass = costClass == null ? null : costClass.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 收取方式
     */
    public String getCostType() {
        return costType;
    }

    /**
     * CHAR(1)<br>
     * 设置 收取方式
     */
    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 扣取方式
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(1)<br>
     * 设置 扣取方式
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 计算方式
     */
    public String getCostCalcType() {
        return costCalcType;
    }

    /**
     * CHAR(1)<br>
     * 设置 计算方式
     */
    public void setCostCalcType(String costCalcType) {
        this.costCalcType = costCalcType == null ? null : costCalcType.trim();
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 费用比率(%)
     */
    public BigDecimal getCostRate() {
        return costRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 费用比率(%)
     */
    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 固定费用
     */
    public BigDecimal getCostAmt() {
        return costAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 固定费用
     */
    public void setCostAmt(BigDecimal costAmt) {
        this.costAmt = costAmt;
    }

    /**
     * VARCHAR(2)<br>
     * 获得 费用收取阶段
     */
    public String getCostPhase() {
        return costPhase;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 费用收取阶段
     */
    public void setCostPhase(String costPhase) {
        this.costPhase = costPhase == null ? null : costPhase.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", relaType=").append(relaType);
        sb.append(", relaNo=").append(relaNo);
        sb.append(", costCode=").append(costCode);
        sb.append(", costName=").append(costName);
        sb.append(", costClass=").append(costClass);
        sb.append(", costType=").append(costType);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", costCalcType=").append(costCalcType);
        sb.append(", costRate=").append(costRate);
        sb.append(", costAmt=").append(costAmt);
        sb.append(", costPhase=").append(costPhase);
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
        BCntCostInfo other = (BCntCostInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRelaType() == null ? other.getRelaType() == null : this.getRelaType().equals(other.getRelaType()))
            && (this.getRelaNo() == null ? other.getRelaNo() == null : this.getRelaNo().equals(other.getRelaNo()))
            && (this.getCostCode() == null ? other.getCostCode() == null : this.getCostCode().equals(other.getCostCode()))
            && (this.getCostName() == null ? other.getCostName() == null : this.getCostName().equals(other.getCostName()))
            && (this.getCostClass() == null ? other.getCostClass() == null : this.getCostClass().equals(other.getCostClass()))
            && (this.getCostType() == null ? other.getCostType() == null : this.getCostType().equals(other.getCostType()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getCostCalcType() == null ? other.getCostCalcType() == null : this.getCostCalcType().equals(other.getCostCalcType()))
            && (this.getCostRate() == null ? other.getCostRate() == null : this.getCostRate().equals(other.getCostRate()))
            && (this.getCostAmt() == null ? other.getCostAmt() == null : this.getCostAmt().equals(other.getCostAmt()))
            && (this.getCostPhase() == null ? other.getCostPhase() == null : this.getCostPhase().equals(other.getCostPhase()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRelaType() == null) ? 0 : getRelaType().hashCode());
        result = prime * result + ((getRelaNo() == null) ? 0 : getRelaNo().hashCode());
        result = prime * result + ((getCostCode() == null) ? 0 : getCostCode().hashCode());
        result = prime * result + ((getCostName() == null) ? 0 : getCostName().hashCode());
        result = prime * result + ((getCostClass() == null) ? 0 : getCostClass().hashCode());
        result = prime * result + ((getCostType() == null) ? 0 : getCostType().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getCostCalcType() == null) ? 0 : getCostCalcType().hashCode());
        result = prime * result + ((getCostRate() == null) ? 0 : getCostRate().hashCode());
        result = prime * result + ((getCostAmt() == null) ? 0 : getCostAmt().hashCode());
        result = prime * result + ((getCostPhase() == null) ? 0 : getCostPhase().hashCode());
        return result;
    }
}