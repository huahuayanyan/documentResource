package com.huateng.scf.bas.prd.model;

import java.io.Serializable;
/**应收材料关联实体类*/
public class BPrdReceMatlBind implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32) 必填<br>
     * 应收材料ID
     */
    private String receMatlId;

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
     * VARCHAR(32) 必填<br>
     * 获得 应收材料ID
     */
    public String getReceMatlId() {
        return receMatlId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 应收材料ID
     */
    public void setReceMatlId(String receMatlId) {
        this.receMatlId = receMatlId == null ? null : receMatlId.trim();
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
        sb.append(", receMatlId=").append(receMatlId);
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
        BPrdReceMatlBind other = (BPrdReceMatlBind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReceMatlId() == null ? other.getReceMatlId() == null : this.getReceMatlId().equals(other.getReceMatlId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReceMatlId() == null) ? 0 : getReceMatlId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        return result;
    }
}