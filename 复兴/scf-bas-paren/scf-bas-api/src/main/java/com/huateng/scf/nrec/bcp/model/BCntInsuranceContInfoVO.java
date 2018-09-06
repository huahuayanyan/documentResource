package com.huateng.scf.nrec.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCntInsuranceContInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String insuranceNo;

    /**
     * VARCHAR(100)<br>
     * 保险合同编号
     */
    private String insuranceCode;

    /**
     * VARCHAR(100)<br>
     * 保险险种：1-综合保险、2-统保保险、3-特定买方保险
     */
    private String insuranceType;

    /**
     * DECIMAL(16,2)<br>
     * 保险合同金额
     */
    private BigDecimal amount;

    /**
     * VARCHAR(1000)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(20)<br>
     * 关联协议合同号
     */
    private String mastContno;

    /**
     * VARCHAR(15)<br>
     * 保险公司客户号
     */
    private String insuranceCustcd;

    /**
     * DECIMAL(16,2)<br>
     * 保险费
     */
    private BigDecimal insuranceFee;

    /**
     * DECIMAL(10,2)<br>
     * 赔款倍数
     */
    private BigDecimal reparationFactor;

    /**
     * DECIMAL(10,6)<br>
     * 赔付比例
     */
    private BigDecimal reparationPercent;

    /**
     * DECIMAL(22)<br>
     * 最长信用期限(天)
     */
    private BigDecimal creditTerm;

    /**
     * DECIMAL(16,2)<br>
     * 最高赔款金额
     */
    private BigDecimal topReparationAmt;

    /**
     * DECIMAL(16,2)<br>
     * 累计赔款金额
     */
    private BigDecimal cumulativeReparationAmt;

    /**
     * DECIMAL(22)<br>
     * 赔款期限(天)
     */
    private BigDecimal reparationTerm;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getInsuranceNo() {
        return insuranceNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 保险合同编号
     */
    public String getInsuranceCode() {
        return insuranceCode;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 保险合同编号
     */
    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode == null ? null : insuranceCode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 保险险种：1-综合保险、2-统保保险、3-特定买方保险
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 保险险种：1-综合保险、2-统保保险、3-特定买方保险
     */
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保险合同金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保险合同金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 关联协议合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联协议合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 保险公司客户号
     */
    public String getInsuranceCustcd() {
        return insuranceCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 保险公司客户号
     */
    public void setInsuranceCustcd(String insuranceCustcd) {
        this.insuranceCustcd = insuranceCustcd == null ? null : insuranceCustcd.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保险费
     */
    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保险费
     */
    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    /**
     * DECIMAL(10,2)<br>
     * 获得 赔款倍数
     */
    public BigDecimal getReparationFactor() {
        return reparationFactor;
    }

    /**
     * DECIMAL(10,2)<br>
     * 设置 赔款倍数
     */
    public void setReparationFactor(BigDecimal reparationFactor) {
        this.reparationFactor = reparationFactor;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 赔付比例
     */
    public BigDecimal getReparationPercent() {
        return reparationPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 赔付比例
     */
    public void setReparationPercent(BigDecimal reparationPercent) {
        this.reparationPercent = reparationPercent;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 最长信用期限(天)
     */
    public BigDecimal getCreditTerm() {
        return creditTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 最长信用期限(天)
     */
    public void setCreditTerm(BigDecimal creditTerm) {
        this.creditTerm = creditTerm;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 最高赔款金额
     */
    public BigDecimal getTopReparationAmt() {
        return topReparationAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 最高赔款金额
     */
    public void setTopReparationAmt(BigDecimal topReparationAmt) {
        this.topReparationAmt = topReparationAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计赔款金额
     */
    public BigDecimal getCumulativeReparationAmt() {
        return cumulativeReparationAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计赔款金额
     */
    public void setCumulativeReparationAmt(BigDecimal cumulativeReparationAmt) {
        this.cumulativeReparationAmt = cumulativeReparationAmt;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 赔款期限(天)
     */
    public BigDecimal getReparationTerm() {
        return reparationTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 赔款期限(天)
     */
    public void setReparationTerm(BigDecimal reparationTerm) {
        this.reparationTerm = reparationTerm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", insuranceNo=").append(insuranceNo);
        sb.append(", insuranceCode=").append(insuranceCode);
        sb.append(", insuranceType=").append(insuranceType);
        sb.append(", amount=").append(amount);
        sb.append(", memo=").append(memo);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", insuranceCustcd=").append(insuranceCustcd);
        sb.append(", insuranceFee=").append(insuranceFee);
        sb.append(", reparationFactor=").append(reparationFactor);
        sb.append(", reparationPercent=").append(reparationPercent);
        sb.append(", creditTerm=").append(creditTerm);
        sb.append(", topReparationAmt=").append(topReparationAmt);
        sb.append(", cumulativeReparationAmt=").append(cumulativeReparationAmt);
        sb.append(", reparationTerm=").append(reparationTerm);
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
        BCntInsuranceContInfoVO other = (BCntInsuranceContInfoVO) that;
        return (this.getInsuranceNo() == null ? other.getInsuranceNo() == null : this.getInsuranceNo().equals(other.getInsuranceNo()))
            && (this.getInsuranceCode() == null ? other.getInsuranceCode() == null : this.getInsuranceCode().equals(other.getInsuranceCode()))
            && (this.getInsuranceType() == null ? other.getInsuranceType() == null : this.getInsuranceType().equals(other.getInsuranceType()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getInsuranceCustcd() == null ? other.getInsuranceCustcd() == null : this.getInsuranceCustcd().equals(other.getInsuranceCustcd()))
            && (this.getInsuranceFee() == null ? other.getInsuranceFee() == null : this.getInsuranceFee().equals(other.getInsuranceFee()))
            && (this.getReparationFactor() == null ? other.getReparationFactor() == null : this.getReparationFactor().equals(other.getReparationFactor()))
            && (this.getReparationPercent() == null ? other.getReparationPercent() == null : this.getReparationPercent().equals(other.getReparationPercent()))
            && (this.getCreditTerm() == null ? other.getCreditTerm() == null : this.getCreditTerm().equals(other.getCreditTerm()))
            && (this.getTopReparationAmt() == null ? other.getTopReparationAmt() == null : this.getTopReparationAmt().equals(other.getTopReparationAmt()))
            && (this.getCumulativeReparationAmt() == null ? other.getCumulativeReparationAmt() == null : this.getCumulativeReparationAmt().equals(other.getCumulativeReparationAmt()))
            && (this.getReparationTerm() == null ? other.getReparationTerm() == null : this.getReparationTerm().equals(other.getReparationTerm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInsuranceNo() == null) ? 0 : getInsuranceNo().hashCode());
        result = prime * result + ((getInsuranceCode() == null) ? 0 : getInsuranceCode().hashCode());
        result = prime * result + ((getInsuranceType() == null) ? 0 : getInsuranceType().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getInsuranceCustcd() == null) ? 0 : getInsuranceCustcd().hashCode());
        result = prime * result + ((getInsuranceFee() == null) ? 0 : getInsuranceFee().hashCode());
        result = prime * result + ((getReparationFactor() == null) ? 0 : getReparationFactor().hashCode());
        result = prime * result + ((getReparationPercent() == null) ? 0 : getReparationPercent().hashCode());
        result = prime * result + ((getCreditTerm() == null) ? 0 : getCreditTerm().hashCode());
        result = prime * result + ((getTopReparationAmt() == null) ? 0 : getTopReparationAmt().hashCode());
        result = prime * result + ((getCumulativeReparationAmt() == null) ? 0 : getCumulativeReparationAmt().hashCode());
        result = prime * result + ((getReparationTerm() == null) ? 0 : getReparationTerm().hashCode());
        return result;
    }
}