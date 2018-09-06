package com.huateng.scf.ods.dao.model;

import java.io.Serializable;

public class OCrmTag implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(15) 必填<br>
     * 客户号
     */
    private String custcd;

    /**
     * CHAR(8) 必填<br>
     * 创建时间
     */
    private String createTime;

    /**
     * VARCHAR(50)<br>
     * 我司关系
     */
    private String relation;

    /**
     * VARCHAR(100)<br>
     * 客户质地
     */
    private String custQuality;

    /**
     * VARCHAR(100)<br>
     * 行业前景
     */
    private String prospect;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 我司关系
     */
    public String getRelation() {
        return relation;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 我司关系
     */
    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 客户质地
     */
    public String getCustQuality() {
        return custQuality;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 客户质地
     */
    public void setCustQuality(String custQuality) {
        this.custQuality = custQuality == null ? null : custQuality.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 行业前景
     */
    public String getProspect() {
        return prospect;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 行业前景
     */
    public void setProspect(String prospect) {
        this.prospect = prospect == null ? null : prospect.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", createTime=").append(createTime);
        sb.append(", relation=").append(relation);
        sb.append(", custQuality=").append(custQuality);
        sb.append(", prospect=").append(prospect);
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
        OCrmTag other = (OCrmTag) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRelation() == null ? other.getRelation() == null : this.getRelation().equals(other.getRelation()))
            && (this.getCustQuality() == null ? other.getCustQuality() == null : this.getCustQuality().equals(other.getCustQuality()))
            && (this.getProspect() == null ? other.getProspect() == null : this.getProspect().equals(other.getProspect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRelation() == null) ? 0 : getRelation().hashCode());
        result = prime * result + ((getCustQuality() == null) ? 0 : getCustQuality().hashCode());
        result = prime * result + ((getProspect() == null) ? 0 : getProspect().hashCode());
        return result;
    }
}