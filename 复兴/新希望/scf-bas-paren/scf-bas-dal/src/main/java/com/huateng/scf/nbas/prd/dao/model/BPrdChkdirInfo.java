package com.huateng.scf.nbas.prd.dao.model;

import java.io.Serializable;

public class BPrdChkdirInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * VARCHAR(10) 必填<br>
     * 调用阶段
     */
    private String invokPhase;

    /**
     * VARCHAR(32)<br>
     * 拦截模型ID
     */
    private String mdlId;

    /**
     * VARCHAR(100)<br>
     * 拦截模型名
     */
    private String mdlNm;

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
     * VARCHAR(10) 必填<br>
     * 获得 调用阶段
     */
    public String getInvokPhase() {
        return invokPhase;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 调用阶段
     */
    public void setInvokPhase(String invokPhase) {
        this.invokPhase = invokPhase == null ? null : invokPhase.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 拦截模型ID
     */
    public String getMdlId() {
        return mdlId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 拦截模型ID
     */
    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 拦截模型名
     */
    public String getMdlNm() {
        return mdlNm;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 拦截模型名
     */
    public void setMdlNm(String mdlNm) {
        this.mdlNm = mdlNm == null ? null : mdlNm.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", invokPhase=").append(invokPhase);
        sb.append(", mdlId=").append(mdlId);
        sb.append(", mdlNm=").append(mdlNm);
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
        BPrdChkdirInfo other = (BPrdChkdirInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getInvokPhase() == null ? other.getInvokPhase() == null : this.getInvokPhase().equals(other.getInvokPhase()))
            && (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getMdlNm() == null ? other.getMdlNm() == null : this.getMdlNm().equals(other.getMdlNm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getInvokPhase() == null) ? 0 : getInvokPhase().hashCode());
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getMdlNm() == null) ? 0 : getMdlNm().hashCode());
        return result;
    }
}