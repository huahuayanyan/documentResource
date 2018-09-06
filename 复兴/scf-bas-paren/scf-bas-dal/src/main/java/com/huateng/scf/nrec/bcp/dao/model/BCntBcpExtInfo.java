package com.huateng.scf.nrec.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCntBcpExtInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 业务合同号
     */
    private String businessNo;

    /**
     * VARCHAR(15) 必填<br>
     * 买方客户号/承租人客户号
     */
    private String businessCustcd;

    /**
     * DECIMAL(22)<br>
     * 账期(天)
     */
    private BigDecimal loanDays;

    /**
     * DECIMAL(22)<br>
     * 宽限期(天)
     */
    private BigDecimal debtGraceDays;

    /**
     * VARCHAR(100)<br>
     * 买方名称/承租人名称
     */
    private String businessName;

    /**
     * VARCHAR(50)<br>
     * 批单号码
     */
    private String batchNumber;

    /**
     * DECIMAL(22)<br>
     * 信用期限
     */
    private BigDecimal creditTerm;

    /**
     * DECIMAL(16,2)<br>
     * 信用限额
     */
    private BigDecimal creditAmt;

    /**
     * DECIMAL(22)<br>
     * 拖欠风险宽限期/信险宽限期(天)
     */
    private BigDecimal riskTerm;

    /**
     * VARCHAR(1)<br>
     * 有无追索权：1-有追索;2-无追索
     */
    private String recoverType;

    /**
     * VARCHAR(2)<br>
     * 保理方式：1-明保理;2-暗保理
     */
    private String factPattern;

    /**
     * CHAR(2)<br>
     * 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    private String noticeType;

    /**
     * DECIMAL(9,6)<br>
     * 融资比例(%)
     */
    private BigDecimal loanPercent;

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
     * VARCHAR(20) 必填<br>
     * 获得 业务合同号
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 业务合同号
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 买方客户号/承租人客户号
     */
    public String getBusinessCustcd() {
        return businessCustcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 买方客户号/承租人客户号
     */
    public void setBusinessCustcd(String businessCustcd) {
        this.businessCustcd = businessCustcd == null ? null : businessCustcd.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 账期(天)
     */
    public BigDecimal getLoanDays() {
        return loanDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 账期(天)
     */
    public void setLoanDays(BigDecimal loanDays) {
        this.loanDays = loanDays;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 宽限期(天)
     */
    public BigDecimal getDebtGraceDays() {
        return debtGraceDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 宽限期(天)
     */
    public void setDebtGraceDays(BigDecimal debtGraceDays) {
        this.debtGraceDays = debtGraceDays;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 买方名称/承租人名称
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 买方名称/承租人名称
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 批单号码
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 批单号码
     */
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 信用期限
     */
    public BigDecimal getCreditTerm() {
        return creditTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 信用期限
     */
    public void setCreditTerm(BigDecimal creditTerm) {
        this.creditTerm = creditTerm;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 信用限额
     */
    public BigDecimal getCreditAmt() {
        return creditAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 信用限额
     */
    public void setCreditAmt(BigDecimal creditAmt) {
        this.creditAmt = creditAmt;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 拖欠风险宽限期/信险宽限期(天)
     */
    public BigDecimal getRiskTerm() {
        return riskTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 拖欠风险宽限期/信险宽限期(天)
     */
    public void setRiskTerm(BigDecimal riskTerm) {
        this.riskTerm = riskTerm;
    }

    /**
     * VARCHAR(1)<br>
     * 获得 有无追索权：1-有追索;2-无追索
     */
    public String getRecoverType() {
        return recoverType;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 有无追索权：1-有追索;2-无追索
     */
    public void setRecoverType(String recoverType) {
        this.recoverType = recoverType == null ? null : recoverType.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保理方式：1-明保理;2-暗保理
     */
    public String getFactPattern() {
        return factPattern;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保理方式：1-明保理;2-暗保理
     */
    public void setFactPattern(String factPattern) {
        this.factPattern = factPattern == null ? null : factPattern.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * CHAR(2)<br>
     * 设置 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    /**
     * DECIMAL(9,6)<br>
     * 获得 融资比例(%)
     */
    public BigDecimal getLoanPercent() {
        return loanPercent;
    }

    /**
     * DECIMAL(9,6)<br>
     * 设置 融资比例(%)
     */
    public void setLoanPercent(BigDecimal loanPercent) {
        this.loanPercent = loanPercent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", businessNo=").append(businessNo);
        sb.append(", businessCustcd=").append(businessCustcd);
        sb.append(", loanDays=").append(loanDays);
        sb.append(", debtGraceDays=").append(debtGraceDays);
        sb.append(", businessName=").append(businessName);
        sb.append(", batchNumber=").append(batchNumber);
        sb.append(", creditTerm=").append(creditTerm);
        sb.append(", creditAmt=").append(creditAmt);
        sb.append(", riskTerm=").append(riskTerm);
        sb.append(", recoverType=").append(recoverType);
        sb.append(", factPattern=").append(factPattern);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", loanPercent=").append(loanPercent);
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
        BCntBcpExtInfo other = (BCntBcpExtInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBusinessNo() == null ? other.getBusinessNo() == null : this.getBusinessNo().equals(other.getBusinessNo()))
            && (this.getBusinessCustcd() == null ? other.getBusinessCustcd() == null : this.getBusinessCustcd().equals(other.getBusinessCustcd()))
            && (this.getLoanDays() == null ? other.getLoanDays() == null : this.getLoanDays().equals(other.getLoanDays()))
            && (this.getDebtGraceDays() == null ? other.getDebtGraceDays() == null : this.getDebtGraceDays().equals(other.getDebtGraceDays()))
            && (this.getBusinessName() == null ? other.getBusinessName() == null : this.getBusinessName().equals(other.getBusinessName()))
            && (this.getBatchNumber() == null ? other.getBatchNumber() == null : this.getBatchNumber().equals(other.getBatchNumber()))
            && (this.getCreditTerm() == null ? other.getCreditTerm() == null : this.getCreditTerm().equals(other.getCreditTerm()))
            && (this.getCreditAmt() == null ? other.getCreditAmt() == null : this.getCreditAmt().equals(other.getCreditAmt()))
            && (this.getRiskTerm() == null ? other.getRiskTerm() == null : this.getRiskTerm().equals(other.getRiskTerm()))
            && (this.getRecoverType() == null ? other.getRecoverType() == null : this.getRecoverType().equals(other.getRecoverType()))
            && (this.getFactPattern() == null ? other.getFactPattern() == null : this.getFactPattern().equals(other.getFactPattern()))
            && (this.getNoticeType() == null ? other.getNoticeType() == null : this.getNoticeType().equals(other.getNoticeType()))
            && (this.getLoanPercent() == null ? other.getLoanPercent() == null : this.getLoanPercent().equals(other.getLoanPercent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBusinessNo() == null) ? 0 : getBusinessNo().hashCode());
        result = prime * result + ((getBusinessCustcd() == null) ? 0 : getBusinessCustcd().hashCode());
        result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
        result = prime * result + ((getDebtGraceDays() == null) ? 0 : getDebtGraceDays().hashCode());
        result = prime * result + ((getBusinessName() == null) ? 0 : getBusinessName().hashCode());
        result = prime * result + ((getBatchNumber() == null) ? 0 : getBatchNumber().hashCode());
        result = prime * result + ((getCreditTerm() == null) ? 0 : getCreditTerm().hashCode());
        result = prime * result + ((getCreditAmt() == null) ? 0 : getCreditAmt().hashCode());
        result = prime * result + ((getRiskTerm() == null) ? 0 : getRiskTerm().hashCode());
        result = prime * result + ((getRecoverType() == null) ? 0 : getRecoverType().hashCode());
        result = prime * result + ((getFactPattern() == null) ? 0 : getFactPattern().hashCode());
        result = prime * result + ((getNoticeType() == null) ? 0 : getNoticeType().hashCode());
        result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
        return result;
    }
}