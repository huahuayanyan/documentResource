package com.huateng.scf.bas.prd.model;

import java.io.Serializable;

public class BPrdMortVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(10) 必填<br>
     * 主键
     */
    private String productId;

    /**
     * CHAR(1)<br>
     * 货押模式：1-动态、2-静态
     */
    private String moniType;

    /**
     * CHAR(1)<br>
     * 库内监管
     */
    private String moniModeInside;

    /**
     * CHAR(1)<br>
     * 第三方仓库监管
     */
    private String moniModeThird;

    /**
     * CHAR(1)<br>
     * 出质人自有仓库监管
     */
    private String moniModeOwn;

    /**
     * VARCHAR(10) 必填<br>
     * 获得 主键
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 主键
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 货押模式：1-动态、2-静态
     */
    public String getMoniType() {
        return moniType;
    }

    /**
     * CHAR(1)<br>
     * 设置 货押模式：1-动态、2-静态
     */
    public void setMoniType(String moniType) {
        this.moniType = moniType == null ? null : moniType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 库内监管
     */
    public String getMoniModeInside() {
        return moniModeInside;
    }

    /**
     * CHAR(1)<br>
     * 设置 库内监管
     */
    public void setMoniModeInside(String moniModeInside) {
        this.moniModeInside = moniModeInside == null ? null : moniModeInside.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 第三方仓库监管
     */
    public String getMoniModeThird() {
        return moniModeThird;
    }

    /**
     * CHAR(1)<br>
     * 设置 第三方仓库监管
     */
    public void setMoniModeThird(String moniModeThird) {
        this.moniModeThird = moniModeThird == null ? null : moniModeThird.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 出质人自有仓库监管
     */
    public String getMoniModeOwn() {
        return moniModeOwn;
    }

    /**
     * CHAR(1)<br>
     * 设置 出质人自有仓库监管
     */
    public void setMoniModeOwn(String moniModeOwn) {
        this.moniModeOwn = moniModeOwn == null ? null : moniModeOwn.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", moniType=").append(moniType);
        sb.append(", moniModeInside=").append(moniModeInside);
        sb.append(", moniModeThird=").append(moniModeThird);
        sb.append(", moniModeOwn=").append(moniModeOwn);
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
        BPrdMortVO other = (BPrdMortVO) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getMoniType() == null ? other.getMoniType() == null : this.getMoniType().equals(other.getMoniType()))
            && (this.getMoniModeInside() == null ? other.getMoniModeInside() == null : this.getMoniModeInside().equals(other.getMoniModeInside()))
            && (this.getMoniModeThird() == null ? other.getMoniModeThird() == null : this.getMoniModeThird().equals(other.getMoniModeThird()))
            && (this.getMoniModeOwn() == null ? other.getMoniModeOwn() == null : this.getMoniModeOwn().equals(other.getMoniModeOwn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getMoniType() == null) ? 0 : getMoniType().hashCode());
        result = prime * result + ((getMoniModeInside() == null) ? 0 : getMoniModeInside().hashCode());
        result = prime * result + ((getMoniModeThird() == null) ? 0 : getMoniModeThird().hashCode());
        result = prime * result + ((getMoniModeOwn() == null) ? 0 : getMoniModeOwn().hashCode());
        return result;
    }
}