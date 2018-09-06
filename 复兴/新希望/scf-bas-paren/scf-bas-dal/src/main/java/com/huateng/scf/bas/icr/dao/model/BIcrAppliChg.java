package com.huateng.scf.bas.icr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BIcrAppliChg implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 申请号
     */
    private String appno;

    /**
     * VARCHAR(20) 必填<br>
     * 额度编号
     */
    private String creditNo;

    /**
     * DECIMAL(16,2)<br>
     * 发生额
     */
    private BigDecimal amount;

    /**
     * VARCHAR(128)<br>
     * 冻结/解冻/终止原因
     */
    private String reason;

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
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 发生额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 发生额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * VARCHAR(128)<br>
     * 获得 冻结/解冻/终止原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(128)<br>
     * 设置 冻结/解冻/终止原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", amount=").append(amount);
        sb.append(", reason=").append(reason);
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
        BIcrAppliChg other = (BIcrAppliChg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        return result;
    }
}