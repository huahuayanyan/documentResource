package com.huateng.scf.bas.icr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BIcrDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 额度编号
     */
    private String creditNo;

    /**
     * CHAR(8)<br>
     * 交易日期
     */
    private String txdate;

    /**
     * TIMESTAMP(11,6)<br>
     * 交易时间
     */
    private Date txtime;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * CHAR(1)<br>
     * 关联类型：1-合同、2-借据
     */
    private String relaType;

    /**
     * VARCHAR(100)<br>
     * 关联合同号
     */
    private String businessno;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(4)<br>
     * 业务类型
     */
    private String applyType;

    /**
     * VARCHAR(100)<br>
     * 额度操作类型：00：生效；01：预占用；02：占用；；03：占用恢复（释放）；04：冻结；05:解冻；06：变更；07：终止08 预占用恢复（释放）
     */
    private String operType;

    /**
     * DECIMAL(16,2)<br>
     * 金额
     */
    private BigDecimal amount;

    /**
     * DECIMAL(16,2)<br>
     * 额度金额
     */
    private BigDecimal creditAmount;

    /**
     * DECIMAL(16,2)<br>
     * 预占用额度
     */
    private BigDecimal preUsedAmount;

    /**
     * DECIMAL(16,2)<br>
     * 已占额度
     */
    private BigDecimal usedAmount;

    /**
     * DECIMAL(16,2)<br>
     * 冻结额度
     */
    private BigDecimal frzAmount;

    /**
     * DECIMAL(16,2)<br>
     * 可用额度
     */
    private BigDecimal creditUsableAmount;

    /**
     * DECIMAL(16,2)<br>
     * 通用金额
     */
    private BigDecimal commonAmount;

    /**
     * CHAR(8)<br>
     * 通用日期
     */
    private String commonDate;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(20)<br>
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
     * VARCHAR(20) 必填<br>
     * 获得 额度编号
     */
    public String getCreditNo() {
        return creditNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 额度编号
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 交易日期
     */
    public String getTxdate() {
        return txdate;
    }

    /**
     * CHAR(8)<br>
     * 设置 交易日期
     */
    public void setTxdate(String txdate) {
        this.txdate = txdate == null ? null : txdate.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 交易时间
     */
    public Date getTxtime() {
        return txtime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 交易时间
     */
    public void setTxtime(Date txtime) {
        this.txtime = txtime;
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
     * CHAR(1)<br>
     * 获得 关联类型：1-合同、2-借据
     */
    public String getRelaType() {
        return relaType;
    }

    /**
     * CHAR(1)<br>
     * 设置 关联类型：1-合同、2-借据
     */
    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 关联合同号
     */
    public String getBusinessno() {
        return businessno;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 关联合同号
     */
    public void setBusinessno(String businessno) {
        this.businessno = businessno == null ? null : businessno.trim();
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
     * VARCHAR(4)<br>
     * 获得 业务类型
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 业务类型
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 额度操作类型：00：生效；01：预占用；02：占用；；03：占用恢复（释放）；04：冻结；05:解冻；06：变更；07：终止08 预占用恢复（释放）
     */
    public String getOperType() {
        return operType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 额度操作类型：00：生效；01：预占用；02：占用；；03：占用恢复（释放）；04：冻结；05:解冻；06：变更；07：终止08 预占用恢复（释放）
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 额度金额
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 额度金额
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 预占用额度
     */
    public BigDecimal getPreUsedAmount() {
        return preUsedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 预占用额度
     */
    public void setPreUsedAmount(BigDecimal preUsedAmount) {
        this.preUsedAmount = preUsedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已占额度
     */
    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已占额度
     */
    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 冻结额度
     */
    public BigDecimal getFrzAmount() {
        return frzAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 冻结额度
     */
    public void setFrzAmount(BigDecimal frzAmount) {
        this.frzAmount = frzAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可用额度
     */
    public BigDecimal getCreditUsableAmount() {
        return creditUsableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可用额度
     */
    public void setCreditUsableAmount(BigDecimal creditUsableAmount) {
        this.creditUsableAmount = creditUsableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 通用金额
     */
    public BigDecimal getCommonAmount() {
        return commonAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 通用金额
     */
    public void setCommonAmount(BigDecimal commonAmount) {
        this.commonAmount = commonAmount;
    }

    /**
     * CHAR(8)<br>
     * 获得 通用日期
     */
    public String getCommonDate() {
        return commonDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 通用日期
     */
    public void setCommonDate(String commonDate) {
        this.commonDate = commonDate == null ? null : commonDate.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(20)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(20)<br>
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
        sb.append(", creditNo=").append(creditNo);
        sb.append(", txdate=").append(txdate);
        sb.append(", txtime=").append(txtime);
        sb.append(", appno=").append(appno);
        sb.append(", relaType=").append(relaType);
        sb.append(", businessno=").append(businessno);
        sb.append(", custcd=").append(custcd);
        sb.append(", applyType=").append(applyType);
        sb.append(", operType=").append(operType);
        sb.append(", amount=").append(amount);
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", preUsedAmount=").append(preUsedAmount);
        sb.append(", usedAmount=").append(usedAmount);
        sb.append(", frzAmount=").append(frzAmount);
        sb.append(", creditUsableAmount=").append(creditUsableAmount);
        sb.append(", commonAmount=").append(commonAmount);
        sb.append(", commonDate=").append(commonDate);
        sb.append(", status=").append(status);
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
        BIcrDtl other = (BIcrDtl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getTxdate() == null ? other.getTxdate() == null : this.getTxdate().equals(other.getTxdate()))
            && (this.getTxtime() == null ? other.getTxtime() == null : this.getTxtime().equals(other.getTxtime()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getRelaType() == null ? other.getRelaType() == null : this.getRelaType().equals(other.getRelaType()))
            && (this.getBusinessno() == null ? other.getBusinessno() == null : this.getBusinessno().equals(other.getBusinessno()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
            && (this.getOperType() == null ? other.getOperType() == null : this.getOperType().equals(other.getOperType()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreditAmount() == null ? other.getCreditAmount() == null : this.getCreditAmount().equals(other.getCreditAmount()))
            && (this.getPreUsedAmount() == null ? other.getPreUsedAmount() == null : this.getPreUsedAmount().equals(other.getPreUsedAmount()))
            && (this.getUsedAmount() == null ? other.getUsedAmount() == null : this.getUsedAmount().equals(other.getUsedAmount()))
            && (this.getFrzAmount() == null ? other.getFrzAmount() == null : this.getFrzAmount().equals(other.getFrzAmount()))
            && (this.getCreditUsableAmount() == null ? other.getCreditUsableAmount() == null : this.getCreditUsableAmount().equals(other.getCreditUsableAmount()))
            && (this.getCommonAmount() == null ? other.getCommonAmount() == null : this.getCommonAmount().equals(other.getCommonAmount()))
            && (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getTxdate() == null) ? 0 : getTxdate().hashCode());
        result = prime * result + ((getTxtime() == null) ? 0 : getTxtime().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getRelaType() == null) ? 0 : getRelaType().hashCode());
        result = prime * result + ((getBusinessno() == null) ? 0 : getBusinessno().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        result = prime * result + ((getOperType() == null) ? 0 : getOperType().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
        result = prime * result + ((getPreUsedAmount() == null) ? 0 : getPreUsedAmount().hashCode());
        result = prime * result + ((getUsedAmount() == null) ? 0 : getUsedAmount().hashCode());
        result = prime * result + ((getFrzAmount() == null) ? 0 : getFrzAmount().hashCode());
        result = prime * result + ((getCreditUsableAmount() == null) ? 0 : getCreditUsableAmount().hashCode());
        result = prime * result + ((getCommonAmount() == null) ? 0 : getCommonAmount().hashCode());
        result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}