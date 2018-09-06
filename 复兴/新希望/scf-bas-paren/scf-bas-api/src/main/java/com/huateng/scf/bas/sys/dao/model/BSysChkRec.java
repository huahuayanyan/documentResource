package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysChkRec implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 记录流水ID
     */
    private String recId;

    /**
     * VARCHAR(32)<br>
     * 关联流水号
     */
    private String rltNo;

    /**
     * VARCHAR(32)<br>
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
     * VARCHAR(3)<br>
     * 排序号
     */
    private String ord;

    /**
     * CHAR(2)<br>
     * 处理方式
     */
    private String deal;

    /**
     * VARCHAR(1024)<br>
     * 结果描述
     */
    private String rem;

    /**
     * CHAR(2)<br>
     * 执行结果
     */
    private String stat;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 记录流水ID
     */
    public String getRecId() {
        return recId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 记录流水ID
     */
    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 关联流水号
     */
    public String getRltNo() {
        return rltNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 关联流水号
     */
    public void setRltNo(String rltNo) {
        this.rltNo = rltNo == null ? null : rltNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 拦截方案ID
     */
    public String getChkPlId() {
        return chkPlId;
    }

    /**
     * VARCHAR(32)<br>
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
     * VARCHAR(3)<br>
     * 获得 排序号
     */
    public String getOrd() {
        return ord;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 排序号
     */
    public void setOrd(String ord) {
        this.ord = ord == null ? null : ord.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 处理方式
     */
    public String getDeal() {
        return deal;
    }

    /**
     * CHAR(2)<br>
     * 设置 处理方式
     */
    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }

    /**
     * VARCHAR(1024)<br>
     * 获得 结果描述
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(1024)<br>
     * 设置 结果描述
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 执行结果
     */
    public String getStat() {
        return stat;
    }

    /**
     * CHAR(2)<br>
     * 设置 执行结果
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
        sb.append(", recId=").append(recId);
        sb.append(", rltNo=").append(rltNo);
        sb.append(", chkPlId=").append(chkPlId);
        sb.append(", chkItId=").append(chkItId);
        sb.append(", nm=").append(nm);
        sb.append(", ord=").append(ord);
        sb.append(", deal=").append(deal);
        sb.append(", rem=").append(rem);
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
        BSysChkRec other = (BSysChkRec) that;
        return (this.getRecId() == null ? other.getRecId() == null : this.getRecId().equals(other.getRecId()))
            && (this.getRltNo() == null ? other.getRltNo() == null : this.getRltNo().equals(other.getRltNo()))
            && (this.getChkPlId() == null ? other.getChkPlId() == null : this.getChkPlId().equals(other.getChkPlId()))
            && (this.getChkItId() == null ? other.getChkItId() == null : this.getChkItId().equals(other.getChkItId()))
            && (this.getNm() == null ? other.getNm() == null : this.getNm().equals(other.getNm()))
            && (this.getOrd() == null ? other.getOrd() == null : this.getOrd().equals(other.getOrd()))
            && (this.getDeal() == null ? other.getDeal() == null : this.getDeal().equals(other.getDeal()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecId() == null) ? 0 : getRecId().hashCode());
        result = prime * result + ((getRltNo() == null) ? 0 : getRltNo().hashCode());
        result = prime * result + ((getChkPlId() == null) ? 0 : getChkPlId().hashCode());
        result = prime * result + ((getChkItId() == null) ? 0 : getChkItId().hashCode());
        result = prime * result + ((getNm() == null) ? 0 : getNm().hashCode());
        result = prime * result + ((getOrd() == null) ? 0 : getOrd().hashCode());
        result = prime * result + ((getDeal() == null) ? 0 : getDeal().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        return result;
    }
}