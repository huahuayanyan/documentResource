package com.huateng.scf.nbas.prd.model;

import java.io.Serializable;

public class BPrdCostBindVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * CHAR(4)<br>
     * 费用代码
     */
    private String costCode;

    /**
     * VARCHAR(100)<br>
     * 费用名称
     */
    private String costName;

    /**
     * VARCHAR(2)<br>
     * 费用收取阶段
     */
    private String costPhase;

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
     * CHAR(4)<br>
     * 获得 费用代码
     */
    public String getCostCode() {
        return costCode;
    }

    /**
     * CHAR(4)<br>
     * 设置 费用代码
     */
    public void setCostCode(String costCode) {
        this.costCode = costCode == null ? null : costCode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 费用名称
     */
    public String getCostName() {
        return costName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 费用名称
     */
    public void setCostName(String costName) {
        this.costName = costName == null ? null : costName.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 费用收取阶段
     */
    public String getCostPhase() {
        return costPhase;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 费用收取阶段
     */
    public void setCostPhase(String costPhase) {
        this.costPhase = costPhase == null ? null : costPhase.trim();
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
        sb.append(", costCode=").append(costCode);
        sb.append(", costName=").append(costName);
        sb.append(", costPhase=").append(costPhase);
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
        BPrdCostBindVO other = (BPrdCostBindVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCostCode() == null ? other.getCostCode() == null : this.getCostCode().equals(other.getCostCode()))
            && (this.getCostName() == null ? other.getCostName() == null : this.getCostName().equals(other.getCostName()))
            && (this.getCostPhase() == null ? other.getCostPhase() == null : this.getCostPhase().equals(other.getCostPhase()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCostCode() == null) ? 0 : getCostCode().hashCode());
        result = prime * result + ((getCostName() == null) ? 0 : getCostName().hashCode());
        result = prime * result + ((getCostPhase() == null) ? 0 : getCostPhase().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        return result;
    }
}