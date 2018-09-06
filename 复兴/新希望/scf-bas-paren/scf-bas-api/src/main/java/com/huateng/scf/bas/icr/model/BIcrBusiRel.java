package com.huateng.scf.bas.icr.model;

import java.io.Serializable;

public class BIcrBusiRel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * CHAR(1) 必填<br>
     * 关联类型：1-合同、2-借据
     */
    private String relaType;

    /**
     * VARCHAR(20) 必填<br>
     * 额度编号
     */
    private String creditNo;

    /**
     * VARCHAR(100)<br>
     * 业务合同编号
     */
    private String businessNo;

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
     * CHAR(1) 必填<br>
     * 获得 关联类型：1-合同、2-借据
     */
    public String getRelaType() {
        return relaType;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 关联类型：1-合同、2-借据
     */
    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
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
     * VARCHAR(100)<br>
     * 获得 业务合同编号
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 业务合同编号
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", relaType=").append(relaType);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", businessNo=").append(businessNo);
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
        BIcrBusiRel other = (BIcrBusiRel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRelaType() == null ? other.getRelaType() == null : this.getRelaType().equals(other.getRelaType()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getBusinessNo() == null ? other.getBusinessNo() == null : this.getBusinessNo().equals(other.getBusinessNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRelaType() == null) ? 0 : getRelaType().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getBusinessNo() == null) ? 0 : getBusinessNo().hashCode());
        return result;
    }
}