package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysSerialNo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(100) 必填<br>
     * 序号代码
     */
    private String serialCode;

    /**
     * DECIMAL(10)<br>
     * 序号值
     */
    private Long serialValue;

    /**
     * CHAR(8)<br>
     * 日期
     */
    private String preDate;

    /**
     * VARCHAR(100)<br>
     * 序号名称
     */
    private String serialName;

    /**
     * VARCHAR(60)<br>
     * 序号格式化
     */
    private String serialFormat;

    /**
     * VARCHAR(100) 必填<br>
     * 获得 序号代码
     */
    public String getSerialCode() {
        return serialCode;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 序号代码
     */
    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode == null ? null : serialCode.trim();
    }

    /**
     * DECIMAL(10)<br>
     * 获得 序号值
     */
    public Long getSerialValue() {
        return serialValue;
    }

    /**
     * DECIMAL(10)<br>
     * 设置 序号值
     */
    public void setSerialValue(Long serialValue) {
        this.serialValue = serialValue;
    }

    /**
     * CHAR(8)<br>
     * 获得 日期
     */
    public String getPreDate() {
        return preDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 日期
     */
    public void setPreDate(String preDate) {
        this.preDate = preDate == null ? null : preDate.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 序号名称
     */
    public String getSerialName() {
        return serialName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 序号名称
     */
    public void setSerialName(String serialName) {
        this.serialName = serialName == null ? null : serialName.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 序号格式化
     */
    public String getSerialFormat() {
        return serialFormat;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 序号格式化
     */
    public void setSerialFormat(String serialFormat) {
        this.serialFormat = serialFormat == null ? null : serialFormat.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialCode=").append(serialCode);
        sb.append(", serialValue=").append(serialValue);
        sb.append(", preDate=").append(preDate);
        sb.append(", serialName=").append(serialName);
        sb.append(", serialFormat=").append(serialFormat);
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
        BSysSerialNo other = (BSysSerialNo) that;
        return (this.getSerialCode() == null ? other.getSerialCode() == null : this.getSerialCode().equals(other.getSerialCode()))
            && (this.getSerialValue() == null ? other.getSerialValue() == null : this.getSerialValue().equals(other.getSerialValue()))
            && (this.getPreDate() == null ? other.getPreDate() == null : this.getPreDate().equals(other.getPreDate()))
            && (this.getSerialName() == null ? other.getSerialName() == null : this.getSerialName().equals(other.getSerialName()))
            && (this.getSerialFormat() == null ? other.getSerialFormat() == null : this.getSerialFormat().equals(other.getSerialFormat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialCode() == null) ? 0 : getSerialCode().hashCode());
        result = prime * result + ((getSerialValue() == null) ? 0 : getSerialValue().hashCode());
        result = prime * result + ((getPreDate() == null) ? 0 : getPreDate().hashCode());
        result = prime * result + ((getSerialName() == null) ? 0 : getSerialName().hashCode());
        result = prime * result + ((getSerialFormat() == null) ? 0 : getSerialFormat().hashCode());
        return result;
    }
}