package com.huateng.scf.bas.icr.dao.model;

import java.io.Serializable;

public class BIcrAppliBrcodeList implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键标识
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 额度编号
     */
    private String creditNo;

    /**
     * VARCHAR(20) 必填<br>
     * 申请编号
     */
    private String appno;

    /**
     * VARCHAR(20)<br>
     * 机构号
     */
    private String brcode;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键标识
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键标识
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
     * VARCHAR(20) 必填<br>
     * 获得 申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 机构号
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 机构号
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", appno=").append(appno);
        sb.append(", brcode=").append(brcode);
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
        BIcrAppliBrcodeList other = (BIcrAppliBrcodeList) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        return result;
    }
}