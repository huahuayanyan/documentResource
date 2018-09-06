package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BSysChkPl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 拦截方案ID
     */
    private String chkPlId;

    /**
     * VARCHAR(32)<br>
     * 拦截项编号
     */
    private String chkItId;

    /**
     * VARCHAR(60)<br>
     * 拦截项名
     */
    private String nm;

    /**
     * VARCHAR(32)<br>
     * 拦截模型ID
     */
    private String mdlId;

    /**
     * DECIMAL(22)<br>
     * 排序号
     */
    private BigDecimal ord;

    /**
     * CHAR(1)<br>
     * 处理方式
     */
    private String deal;

    /**
     * CHAR(1)<br>
     * 启用标志
     */
    private String stat;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 拦截方案ID
     */
    public String getChkPlId() {
        return chkPlId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 拦截方案ID
     */
    public void setChkPlId(String chkPlId) {
        this.chkPlId = chkPlId == null ? null : chkPlId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 拦截项编号
     */
    public String getChkItId() {
        return chkItId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 拦截项编号
     */
    public void setChkItId(String chkItId) {
        this.chkItId = chkItId == null ? null : chkItId.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 拦截项名
     */
    public String getNm() {
        return nm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 拦截项名
     */
    public void setNm(String nm) {
        this.nm = nm == null ? null : nm.trim();
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
     * DECIMAL(22)<br>
     * 获得 排序号
     */
    public BigDecimal getOrd() {
        return ord;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 排序号
     */
    public void setOrd(BigDecimal ord) {
        this.ord = ord;
    }

    /**
     * CHAR(1)<br>
     * 获得 处理方式
     */
    public String getDeal() {
        return deal;
    }

    /**
     * CHAR(1)<br>
     * 设置 处理方式
     */
    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 启用标志
     */
    public String getStat() {
        return stat;
    }

    /**
     * CHAR(1)<br>
     * 设置 启用标志
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chkPlId=").append(chkPlId);
        sb.append(", chkItId=").append(chkItId);
        sb.append(", nm=").append(nm);
        sb.append(", mdlId=").append(mdlId);
        sb.append(", ord=").append(ord);
        sb.append(", deal=").append(deal);
        sb.append(", stat=").append(stat);
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
        BSysChkPl other = (BSysChkPl) that;
        return (this.getChkPlId() == null ? other.getChkPlId() == null : this.getChkPlId().equals(other.getChkPlId()))
            && (this.getChkItId() == null ? other.getChkItId() == null : this.getChkItId().equals(other.getChkItId()))
            && (this.getNm() == null ? other.getNm() == null : this.getNm().equals(other.getNm()))
            && (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getOrd() == null ? other.getOrd() == null : this.getOrd().equals(other.getOrd()))
            && (this.getDeal() == null ? other.getDeal() == null : this.getDeal().equals(other.getDeal()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChkPlId() == null) ? 0 : getChkPlId().hashCode());
        result = prime * result + ((getChkItId() == null) ? 0 : getChkItId().hashCode());
        result = prime * result + ((getNm() == null) ? 0 : getNm().hashCode());
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getOrd() == null) ? 0 : getOrd().hashCode());
        result = prime * result + ((getDeal() == null) ? 0 : getDeal().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        return result;
    }
}