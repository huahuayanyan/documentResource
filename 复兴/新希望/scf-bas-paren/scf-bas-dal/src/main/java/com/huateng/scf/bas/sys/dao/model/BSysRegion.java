package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysRegion implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 区域代码
     */
    private String regionCode;

    /**
     * VARCHAR(80)<br>
     * 区域名称
     */
    private String regionName;

    /**
     * VARCHAR(100)<br>
     * 区域全称
     */
    private String fullName;
    private String flag;
    private String upCode;

    public String getUpCode() {
		return upCode;
	}

	public void setUpCode(String upCode) {
		this.upCode = upCode;
	}

    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 区域代码
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 区域代码
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 区域名称
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 区域名称
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 区域全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 区域全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", regionCode=").append(regionCode);
        sb.append(", regionName=").append(regionName);
        sb.append(", fullName=").append(fullName);
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
        BSysRegion other = (BSysRegion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRegionCode() == null ? other.getRegionCode() == null : this.getRegionCode().equals(other.getRegionCode()))
            && (this.getRegionName() == null ? other.getRegionName() == null : this.getRegionName().equals(other.getRegionName()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRegionCode() == null) ? 0 : getRegionCode().hashCode());
        result = prime * result + ((getRegionName() == null) ? 0 : getRegionName().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        return result;
    }
}