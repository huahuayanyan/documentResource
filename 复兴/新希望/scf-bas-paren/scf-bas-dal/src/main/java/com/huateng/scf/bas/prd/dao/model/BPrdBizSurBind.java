package com.huateng.scf.bas.prd.dao.model;

import java.io.Serializable;

public class BPrdBizSurBind implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32) 必填<br>
     * 业务调查资料ID
     */
    private String bProdBizSurId;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * CHAR(4) 必填<br>
     * 材料类型：1-业务调查资料，2-制度相关资料
     */
    private String matlType;

    
    /**
     * -----------------------------------------
     * 业务调查资料名称 不入库，用于页面展示
     */
    private String bProdBizSurName;
	
    public String getBProdBizSurName() {
		return bProdBizSurName;
	}
    
	public void setBProdBizSurName(String bProdBizSurName) {
		this.bProdBizSurName = bProdBizSurName;
	}
    
    
    
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
     * 获得 业务调查资料ID
     */
    public String getBProdBizSurId() {
        return bProdBizSurId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 业务调查资料ID
     */
    public void setBProdBizSurId(String bProdBizSurId) {
        this.bProdBizSurId = bProdBizSurId == null ? null : bProdBizSurId.trim();
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
     * CHAR(4) 必填<br>
     * 获得 材料类型：1-业务调查资料，2-制度相关资料
     */
    public String getMatlType() {
        return matlType;
    }

    /**
     * CHAR(4) 必填<br>
     * 设置 材料类型：1-业务调查资料，2-制度相关资料
     */
    public void setMatlType(String matlType) {
        this.matlType = matlType == null ? null : matlType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bProdBizSurId=").append(bProdBizSurId);
        sb.append(", productId=").append(productId);
        sb.append(", matlType=").append(matlType);
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
        BPrdBizSurBind other = (BPrdBizSurBind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBProdBizSurId() == null ? other.getBProdBizSurId() == null : this.getBProdBizSurId().equals(other.getBProdBizSurId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getMatlType() == null ? other.getMatlType() == null : this.getMatlType().equals(other.getMatlType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBProdBizSurId() == null) ? 0 : getBProdBizSurId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getMatlType() == null) ? 0 : getMatlType().hashCode());
        return result;
    }
}