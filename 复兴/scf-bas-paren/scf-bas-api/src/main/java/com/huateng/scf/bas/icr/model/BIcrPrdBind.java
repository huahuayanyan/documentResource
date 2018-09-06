package com.huateng.scf.bas.icr.model;

import java.io.Serializable;

public class BIcrPrdBind implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 额度类型
     */
    private String creditType;

    /**
     * VARCHAR(20) 必填<br>
     * 产品类型
     */
    private String productId;

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
     * 获得 额度类型
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 额度类型
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 产品类型
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 产品类型
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creditType=").append(creditType);
        sb.append(", productId=").append(productId);
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
        BIcrPrdBind other = (BIcrPrdBind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreditType() == null ? other.getCreditType() == null : this.getCreditType().equals(other.getCreditType()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        return result;
    }
}