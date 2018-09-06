package com.huateng.scf.bas.brp.model;

import java.io.Serializable;

public class BBrpPageParamPackage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 编号
     */
    private String id;

    /**
     * VARCHAR(60) 必填<br>
     * 分类名称
     */
    private String name;

    /**
     * VARCHAR(32)<br>
     * 上一级分类编号
     */
    private String superId;

    /**
     * VARCHAR(255)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 编号
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(60) 必填<br>
     * 获得 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 上一级分类编号
     */
    public String getSuperId() {
        return superId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 上一级分类编号
     */
    public void setSuperId(String superId) {
        this.superId = superId == null ? null : superId.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", superId=").append(superId);
        sb.append(", remark=").append(remark);
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
        BBrpPageParamPackage other = (BBrpPageParamPackage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSuperId() == null ? other.getSuperId() == null : this.getSuperId().equals(other.getSuperId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSuperId() == null) ? 0 : getSuperId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}