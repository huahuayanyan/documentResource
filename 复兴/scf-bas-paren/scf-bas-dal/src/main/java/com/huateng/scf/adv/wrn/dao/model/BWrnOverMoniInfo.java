package com.huateng.scf.adv.wrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWrnOverMoniInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 预警主表标识
     */
    private String warnId;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniCustcd;

    /**
     * VARCHAR(80)<br>
     * 监管公司名称
     */
    private String moniCname;

    /**
     * VARCHAR(2)<br>
     * 监管方等级
     */
    private String levels;

    /**
     * VARCHAR(1)<br>
     * 监管区域
     */
    private String monitorArea;

    /**
     * VARCHAR(100)<br>
     * 具体监管区域（省/市）
     */
    private String detailMonitorArea;

    /**
     * DECIMAL(16,2)<br>
     * 监管限额
     */
    private BigDecimal limitSum;

    /**
     * DECIMAL(16,2)<br>
     * 监管押品总价值
     */
    private BigDecimal mortAmt;

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
     * VARCHAR(32)<br>
     * 获得 预警主表标识
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 预警主表标识
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId == null ? null : warnId.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 监管公司名称
     */
    public String getMoniCname() {
        return moniCname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 监管公司名称
     */
    public void setMoniCname(String moniCname) {
        this.moniCname = moniCname == null ? null : moniCname.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 监管方等级
     */
    public String getLevels() {
        return levels;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 监管方等级
     */
    public void setLevels(String levels) {
        this.levels = levels == null ? null : levels.trim();
    }

    /**
     * VARCHAR(1)<br>
     * 获得 监管区域
     */
    public String getMonitorArea() {
        return monitorArea;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 监管区域
     */
    public void setMonitorArea(String monitorArea) {
        this.monitorArea = monitorArea == null ? null : monitorArea.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 具体监管区域（省/市）
     */
    public String getDetailMonitorArea() {
        return detailMonitorArea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 具体监管区域（省/市）
     */
    public void setDetailMonitorArea(String detailMonitorArea) {
        this.detailMonitorArea = detailMonitorArea == null ? null : detailMonitorArea.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 监管限额
     */
    public BigDecimal getLimitSum() {
        return limitSum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 监管限额
     */
    public void setLimitSum(BigDecimal limitSum) {
        this.limitSum = limitSum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 监管押品总价值
     */
    public BigDecimal getMortAmt() {
        return mortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 监管押品总价值
     */
    public void setMortAmt(BigDecimal mortAmt) {
        this.mortAmt = mortAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warnId=").append(warnId);
        sb.append(", moniCustcd=").append(moniCustcd);
        sb.append(", moniCname=").append(moniCname);
        sb.append(", levels=").append(levels);
        sb.append(", monitorArea=").append(monitorArea);
        sb.append(", detailMonitorArea=").append(detailMonitorArea);
        sb.append(", limitSum=").append(limitSum);
        sb.append(", mortAmt=").append(mortAmt);
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
        BWrnOverMoniInfo other = (BWrnOverMoniInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getMoniCustcd() == null ? other.getMoniCustcd() == null : this.getMoniCustcd().equals(other.getMoniCustcd()))
            && (this.getMoniCname() == null ? other.getMoniCname() == null : this.getMoniCname().equals(other.getMoniCname()))
            && (this.getLevels() == null ? other.getLevels() == null : this.getLevels().equals(other.getLevels()))
            && (this.getMonitorArea() == null ? other.getMonitorArea() == null : this.getMonitorArea().equals(other.getMonitorArea()))
            && (this.getDetailMonitorArea() == null ? other.getDetailMonitorArea() == null : this.getDetailMonitorArea().equals(other.getDetailMonitorArea()))
            && (this.getLimitSum() == null ? other.getLimitSum() == null : this.getLimitSum().equals(other.getLimitSum()))
            && (this.getMortAmt() == null ? other.getMortAmt() == null : this.getMortAmt().equals(other.getMortAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnId() == null) ? 0 : getWarnId().hashCode());
        result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
        result = prime * result + ((getMoniCname() == null) ? 0 : getMoniCname().hashCode());
        result = prime * result + ((getLevels() == null) ? 0 : getLevels().hashCode());
        result = prime * result + ((getMonitorArea() == null) ? 0 : getMonitorArea().hashCode());
        result = prime * result + ((getDetailMonitorArea() == null) ? 0 : getDetailMonitorArea().hashCode());
        result = prime * result + ((getLimitSum() == null) ? 0 : getLimitSum().hashCode());
        result = prime * result + ((getMortAmt() == null) ? 0 : getMortAmt().hashCode());
        return result;
    }
}