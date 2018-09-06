package com.huateng.scf.bas.prd.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BPrdCopLibBind implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32) 必填<br>
     * 关联组件ID，对应组件ID
     */
    private String relId;

    /**
     * VARCHAR(100) 必填<br>
     * 组件名称
     */
    private String copName;

    /**
     * CHAR(1) 必填<br>
     * 组件类型：1-业务组件，2-流程组件
     */
    private String copType;

    /**
     * CHAR(1) 必填<br>
     * 状态：1-启用，2-停用
     */
    private String status;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * DECIMAL(22)<br>
     * 顺序
     */
    private BigDecimal copOrder;

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
     * VARCHAR(32) 必填<br>
     * 获得 关联组件ID，对应组件ID
     */
    public String getRelId() {
        return relId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 关联组件ID，对应组件ID
     */
    public void setRelId(String relId) {
        this.relId = relId == null ? null : relId.trim();
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 组件名称
     */
    public String getCopName() {
        return copName;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 组件名称
     */
    public void setCopName(String copName) {
        this.copName = copName == null ? null : copName.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 组件类型：1-业务组件，2-流程组件
     */
    public String getCopType() {
        return copType;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 组件类型：1-业务组件，2-流程组件
     */
    public void setCopType(String copType) {
        this.copType = copType == null ? null : copType.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 状态：1-启用，2-停用
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 状态：1-启用，2-停用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    /**
     * DECIMAL(22)<br>
     * 获得 顺序
     */
    public BigDecimal getCopOrder() {
        return copOrder;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 顺序
     */
    public void setCopOrder(BigDecimal copOrder) {
        this.copOrder = copOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", relId=").append(relId);
        sb.append(", copName=").append(copName);
        sb.append(", copType=").append(copType);
        sb.append(", status=").append(status);
        sb.append(", productId=").append(productId);
        sb.append(", copOrder=").append(copOrder);
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
        BPrdCopLibBind other = (BPrdCopLibBind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRelId() == null ? other.getRelId() == null : this.getRelId().equals(other.getRelId()))
            && (this.getCopName() == null ? other.getCopName() == null : this.getCopName().equals(other.getCopName()))
            && (this.getCopType() == null ? other.getCopType() == null : this.getCopType().equals(other.getCopType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCopOrder() == null ? other.getCopOrder() == null : this.getCopOrder().equals(other.getCopOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRelId() == null) ? 0 : getRelId().hashCode());
        result = prime * result + ((getCopName() == null) ? 0 : getCopName().hashCode());
        result = prime * result + ((getCopType() == null) ? 0 : getCopType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCopOrder() == null) ? 0 : getCopOrder().hashCode());
        return result;
    }
}