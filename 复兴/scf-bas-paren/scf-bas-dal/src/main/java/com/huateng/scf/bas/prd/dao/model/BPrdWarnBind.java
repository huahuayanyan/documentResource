package com.huateng.scf.bas.prd.dao.model;

import java.io.Serializable;

public class BPrdWarnBind implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(30) 必填<br>
     * 预警编号
     */
    private String warnNo;

    /**
     * VARCHAR(100) 必填<br>
     * 预警名称
     */
    private String warnName;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
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
     * VARCHAR(30) 必填<br>
     * 获得 预警编号
     */
    public String getWarnNo() {
        return warnNo;
    }

    /**
     * VARCHAR(30) 必填<br>
     * 设置 预警编号
     */
    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo == null ? null : warnNo.trim();
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 预警名称
     */
    public String getWarnName() {
        return warnName;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 预警名称
     */
    public void setWarnName(String warnName) {
        this.warnName = warnName == null ? null : warnName.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     * 获得 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 产品ID
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
        sb.append(", warnNo=").append(warnNo);
        sb.append(", warnName=").append(warnName);
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
        BPrdWarnBind other = (BPrdWarnBind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnNo() == null ? other.getWarnNo() == null : this.getWarnNo().equals(other.getWarnNo()))
            && (this.getWarnName() == null ? other.getWarnName() == null : this.getWarnName().equals(other.getWarnName()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnNo() == null) ? 0 : getWarnNo().hashCode());
        result = prime * result + ((getWarnName() == null) ? 0 : getWarnName().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        return result;
    }
}