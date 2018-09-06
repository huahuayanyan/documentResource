package com.huateng.scf.bas.dcr.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BDcrLinInf implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 额度ID
     */
    private String linId;

    /**
     * CHAR(1)<br>
     * 类型
     */
    private String linTyp;

    /**
     * VARCHAR(60)<br>
     * 品种名称
     */
    private String busNm;

    /**
     * VARCHAR(32)<br>
     * 品种编号
     */
    private String busTyp;

    /**
     * VARCHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(14,2)<br>
     * 信贷业务额度
     */
    private BigDecimal crAmt;

    /**
     * DECIMAL(14,2)<br>
     * 信贷敞口额度
     */
    private BigDecimal riskAmt;

    /**
     * CHAR(1)<br>
     * 循环标志
     */
    private String circFlag;

    /**
     * VARCHAR(32)<br>
     * 父额度ID
     */
    private String parentId;

    /**
     * DECIMAL(22)<br>
     * 节点层级
     */
    private BigDecimal linLvl;

    /**
     * DECIMAL(14,2)<br>
     * 已占用额度
     */
    private BigDecimal usedNum;

    /**
     * DECIMAL(14,2)<br>
     * 可用额度
     */
    private BigDecimal ableNum;

    /**
     * VARCHAR(32)<br>
     * 授信协议号
     */
    private String bcCrId;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 额度ID
     */
    public String getLinId() {
        return linId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 额度ID
     */
    public void setLinId(String linId) {
        this.linId = linId == null ? null : linId.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 类型
     */
    public String getLinTyp() {
        return linTyp;
    }

    /**
     * CHAR(1)<br>
     * 设置 类型
     */
    public void setLinTyp(String linTyp) {
        this.linTyp = linTyp == null ? null : linTyp.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 品种名称
     */
    public String getBusNm() {
        return busNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 品种名称
     */
    public void setBusNm(String busNm) {
        this.busNm = busNm == null ? null : busNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 品种编号
     */
    public String getBusTyp() {
        return busTyp;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 品种编号
     */
    public void setBusTyp(String busTyp) {
        this.busTyp = busTyp == null ? null : busTyp.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 信贷业务额度
     */
    public BigDecimal getCrAmt() {
        return crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 信贷业务额度
     */
    public void setCrAmt(BigDecimal crAmt) {
        this.crAmt = crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 信贷敞口额度
     */
    public BigDecimal getRiskAmt() {
        return riskAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 信贷敞口额度
     */
    public void setRiskAmt(BigDecimal riskAmt) {
        this.riskAmt = riskAmt;
    }

    /**
     * CHAR(1)<br>
     * 获得 循环标志
     */
    public String getCircFlag() {
        return circFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 循环标志
     */
    public void setCircFlag(String circFlag) {
        this.circFlag = circFlag == null ? null : circFlag.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 父额度ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 父额度ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 节点层级
     */
    public BigDecimal getLinLvl() {
        return linLvl;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 节点层级
     */
    public void setLinLvl(BigDecimal linLvl) {
        this.linLvl = linLvl;
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 已占用额度
     */
    public BigDecimal getUsedNum() {
        return usedNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 已占用额度
     */
    public void setUsedNum(BigDecimal usedNum) {
        this.usedNum = usedNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 可用额度
     */
    public BigDecimal getAbleNum() {
        return ableNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 可用额度
     */
    public void setAbleNum(BigDecimal ableNum) {
        this.ableNum = ableNum;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 授信合同号
     */
    public String getBcCrId() {
        return bcCrId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 授信合同号
     */
    public void setBcCrId(String bcCrId) {
        this.bcCrId = bcCrId == null ? null : bcCrId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", linId=").append(linId);
        sb.append(", linTyp=").append(linTyp);
        sb.append(", busNm=").append(busNm);
        sb.append(", busTyp=").append(busTyp);
        sb.append(", curcd=").append(curcd);
        sb.append(", crAmt=").append(crAmt);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", circFlag=").append(circFlag);
        sb.append(", parentId=").append(parentId);
        sb.append(", linLvl=").append(linLvl);
        sb.append(", usedNum=").append(usedNum);
        sb.append(", ableNum=").append(ableNum);
        sb.append(", bcCrId=").append(bcCrId);
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
        BDcrLinInf other = (BDcrLinInf) that;
        return (this.getLinId() == null ? other.getLinId() == null : this.getLinId().equals(other.getLinId()))
            && (this.getLinTyp() == null ? other.getLinTyp() == null : this.getLinTyp().equals(other.getLinTyp()))
            && (this.getBusNm() == null ? other.getBusNm() == null : this.getBusNm().equals(other.getBusNm()))
            && (this.getBusTyp() == null ? other.getBusTyp() == null : this.getBusTyp().equals(other.getBusTyp()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getCrAmt() == null ? other.getCrAmt() == null : this.getCrAmt().equals(other.getCrAmt()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getCircFlag() == null ? other.getCircFlag() == null : this.getCircFlag().equals(other.getCircFlag()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getLinLvl() == null ? other.getLinLvl() == null : this.getLinLvl().equals(other.getLinLvl()))
            && (this.getUsedNum() == null ? other.getUsedNum() == null : this.getUsedNum().equals(other.getUsedNum()))
            && (this.getAbleNum() == null ? other.getAbleNum() == null : this.getAbleNum().equals(other.getAbleNum()))
            && (this.getBcCrId() == null ? other.getBcCrId() == null : this.getBcCrId().equals(other.getBcCrId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLinId() == null) ? 0 : getLinId().hashCode());
        result = prime * result + ((getLinTyp() == null) ? 0 : getLinTyp().hashCode());
        result = prime * result + ((getBusNm() == null) ? 0 : getBusNm().hashCode());
        result = prime * result + ((getBusTyp() == null) ? 0 : getBusTyp().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getCrAmt() == null) ? 0 : getCrAmt().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getCircFlag() == null) ? 0 : getCircFlag().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getLinLvl() == null) ? 0 : getLinLvl().hashCode());
        result = prime * result + ((getUsedNum() == null) ? 0 : getUsedNum().hashCode());
        result = prime * result + ((getAbleNum() == null) ? 0 : getAbleNum().hashCode());
        result = prime * result + ((getBcCrId() == null) ? 0 : getBcCrId().hashCode());
        return result;
    }
}