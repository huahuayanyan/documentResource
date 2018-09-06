package com.huateng.scf.sto.nwr.model;

import java.io.Serializable;

public class SBcpProductBillVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * CHAR(1)<br>
     * 仓单类型：1-标准仓单、2-非标准仓单
     */
    private String billType;

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
     * CHAR(1)<br>
     * 获得 仓单类型：1-标准仓单、2-非标准仓单
     */
    public String getBillType() {
        return billType;
    }

    /**
     * CHAR(1)<br>
     * 设置 仓单类型：1-标准仓单、2-非标准仓单
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", billType=").append(billType);
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
        SBcpProductBillVO other = (SBcpProductBillVO) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        return result;
    }
}