package com.huateng.scf.bas.qry.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OCooperPartner implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(4)<br>
     * 类型：1采购，2销售
     */
    private String type;

    /**
     * VARCHAR(15)<br>
     * 合作客户号
     */
    private String coopCustcd;

    /**
     * DECIMAL(16,2)<br>
     * 合作占比
     */
    private BigDecimal coopRate;

    /**
     * CHAR(4)<br>
     * 所属年份
     */
    private String belongYear;

    /**
     * CHAR(2)<br>
     * 所属月份
     */
    private String belongMonth;

    /**
     * DECIMAL(16,2)<br>
     * 月比率
     */
    private BigDecimal monthRate;

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
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 类型：1采购，2销售
     */
    public String getType() {
        return type;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 类型：1采购，2销售
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 合作客户号
     */
    public String getCoopCustcd() {
        return coopCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 合作客户号
     */
    public void setCoopCustcd(String coopCustcd) {
        this.coopCustcd = coopCustcd == null ? null : coopCustcd.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 合作占比
     */
    public BigDecimal getCoopRate() {
        return coopRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 合作占比
     */
    public void setCoopRate(BigDecimal coopRate) {
        this.coopRate = coopRate;
    }

    /**
     * CHAR(4)<br>
     * 获得 所属年份
     */
    public String getBelongYear() {
        return belongYear;
    }

    /**
     * CHAR(4)<br>
     * 设置 所属年份
     */
    public void setBelongYear(String belongYear) {
        this.belongYear = belongYear == null ? null : belongYear.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 所属月份
     */
    public String getBelongMonth() {
        return belongMonth;
    }

    /**
     * CHAR(2)<br>
     * 设置 所属月份
     */
    public void setBelongMonth(String belongMonth) {
        this.belongMonth = belongMonth == null ? null : belongMonth.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 月比率
     */
    public BigDecimal getMonthRate() {
        return monthRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 月比率
     */
    public void setMonthRate(BigDecimal monthRate) {
        this.monthRate = monthRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", type=").append(type);
        sb.append(", coopCustcd=").append(coopCustcd);
        sb.append(", coopRate=").append(coopRate);
        sb.append(", belongYear=").append(belongYear);
        sb.append(", belongMonth=").append(belongMonth);
        sb.append(", monthRate=").append(monthRate);
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
        OCooperPartner other = (OCooperPartner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCoopCustcd() == null ? other.getCoopCustcd() == null : this.getCoopCustcd().equals(other.getCoopCustcd()))
            && (this.getCoopRate() == null ? other.getCoopRate() == null : this.getCoopRate().equals(other.getCoopRate()))
            && (this.getBelongYear() == null ? other.getBelongYear() == null : this.getBelongYear().equals(other.getBelongYear()))
            && (this.getBelongMonth() == null ? other.getBelongMonth() == null : this.getBelongMonth().equals(other.getBelongMonth()))
            && (this.getMonthRate() == null ? other.getMonthRate() == null : this.getMonthRate().equals(other.getMonthRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCoopCustcd() == null) ? 0 : getCoopCustcd().hashCode());
        result = prime * result + ((getCoopRate() == null) ? 0 : getCoopRate().hashCode());
        result = prime * result + ((getBelongYear() == null) ? 0 : getBelongYear().hashCode());
        result = prime * result + ((getBelongMonth() == null) ? 0 : getBelongMonth().hashCode());
        result = prime * result + ((getMonthRate() == null) ? 0 : getMonthRate().hashCode());
        return result;
    }
}