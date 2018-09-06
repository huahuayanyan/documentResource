package com.huateng.scf.bas.brp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BBrpFinParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(9) 必填<br>
     * 财务科目编号
     */
    private String subjId;

    /**
     * VARCHAR(60) 必填<br>
     * 预警名称
     */
    private String subjNm;

    /**
     * VARCHAR(30)<br>
     * 财务指标数据来源,01-月报；04-年报；03-半年报
     */
    private String rpSource;

    /**
     * VARCHAR(9)<br>
     * 所属标题编号
     */
    private String titleId;

    /**
     * DECIMAL(16,2)<br>
     * 同业平均值
     */
    private BigDecimal tradeAverage;

    /**
     * VARCHAR(20)<br>
     * 差阀值
     */
    private String subjLower;

    /**
     * VARCHAR(20)<br>
     * 较差阀值
     */
    private String subjLow;

    /**
     * VARCHAR(20)<br>
     * 平均阀值
     */
    private String subjMidi;

    /**
     * VARCHAR(20)<br>
     * 较好阀值
     */
    private String subjHigh;

    /**
     * VARCHAR(20)<br>
     * 较高阀值
     */
    private String subjHigher;

    /**
     * CHAR(500)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String tlrno;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdDate;

    /**
     * VARCHAR(9) 必填<br>
     * 获得 财务科目编号
     */
    public String getSubjId() {
        return subjId;
    }

    /**
     * VARCHAR(9) 必填<br>
     * 设置 财务科目编号
     */
    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    /**
     * VARCHAR(60) 必填<br>
     * 获得 预警名称
     */
    public String getSubjNm() {
        return subjNm;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 预警名称
     */
    public void setSubjNm(String subjNm) {
        this.subjNm = subjNm == null ? null : subjNm.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 财务指标数据来源,01-月报；04-年报；03-半年报
     */
    public String getRpSource() {
        return rpSource;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 财务指标数据来源,01-月报；04-年报；03-半年报
     */
    public void setRpSource(String rpSource) {
        this.rpSource = rpSource == null ? null : rpSource.trim();
    }

    /**
     * VARCHAR(9)<br>
     * 获得 所属标题编号
     */
    public String getTitleId() {
        return titleId;
    }

    /**
     * VARCHAR(9)<br>
     * 设置 所属标题编号
     */
    public void setTitleId(String titleId) {
        this.titleId = titleId == null ? null : titleId.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 同业平均值
     */
    public BigDecimal getTradeAverage() {
        return tradeAverage;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 同业平均值
     */
    public void setTradeAverage(BigDecimal tradeAverage) {
        this.tradeAverage = tradeAverage;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 差阀值
     */
    public String getSubjLower() {
        return subjLower;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 差阀值
     */
    public void setSubjLower(String subjLower) {
        this.subjLower = subjLower == null ? null : subjLower.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 较差阀值
     */
    public String getSubjLow() {
        return subjLow;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 较差阀值
     */
    public void setSubjLow(String subjLow) {
        this.subjLow = subjLow == null ? null : subjLow.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 平均阀值
     */
    public String getSubjMidi() {
        return subjMidi;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 平均阀值
     */
    public void setSubjMidi(String subjMidi) {
        this.subjMidi = subjMidi == null ? null : subjMidi.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 较好阀值
     */
    public String getSubjHigh() {
        return subjHigh;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 较好阀值
     */
    public void setSubjHigh(String subjHigh) {
        this.subjHigh = subjHigh == null ? null : subjHigh.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 较高阀值
     */
    public String getSubjHigher() {
        return subjHigher;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 较高阀值
     */
    public void setSubjHigher(String subjHigher) {
        this.subjHigher = subjHigher == null ? null : subjHigher.trim();
    }

    /**
     * CHAR(500)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * CHAR(500)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getTlrno() {
        return tlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setTlrno(String tlrno) {
        this.tlrno = tlrno == null ? null : tlrno.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdDate() {
        return lastUpdDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subjId=").append(subjId);
        sb.append(", subjNm=").append(subjNm);
        sb.append(", rpSource=").append(rpSource);
        sb.append(", titleId=").append(titleId);
        sb.append(", tradeAverage=").append(tradeAverage);
        sb.append(", subjLower=").append(subjLower);
        sb.append(", subjLow=").append(subjLow);
        sb.append(", subjMidi=").append(subjMidi);
        sb.append(", subjHigh=").append(subjHigh);
        sb.append(", subjHigher=").append(subjHigher);
        sb.append(", remark=").append(remark);
        sb.append(", tlrno=").append(tlrno);
        sb.append(", lastUpdDate=").append(lastUpdDate);
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
        BBrpFinParam other = (BBrpFinParam) that;
        return (this.getSubjId() == null ? other.getSubjId() == null : this.getSubjId().equals(other.getSubjId()))
            && (this.getSubjNm() == null ? other.getSubjNm() == null : this.getSubjNm().equals(other.getSubjNm()))
            && (this.getRpSource() == null ? other.getRpSource() == null : this.getRpSource().equals(other.getRpSource()))
            && (this.getTitleId() == null ? other.getTitleId() == null : this.getTitleId().equals(other.getTitleId()))
            && (this.getTradeAverage() == null ? other.getTradeAverage() == null : this.getTradeAverage().equals(other.getTradeAverage()))
            && (this.getSubjLower() == null ? other.getSubjLower() == null : this.getSubjLower().equals(other.getSubjLower()))
            && (this.getSubjLow() == null ? other.getSubjLow() == null : this.getSubjLow().equals(other.getSubjLow()))
            && (this.getSubjMidi() == null ? other.getSubjMidi() == null : this.getSubjMidi().equals(other.getSubjMidi()))
            && (this.getSubjHigh() == null ? other.getSubjHigh() == null : this.getSubjHigh().equals(other.getSubjHigh()))
            && (this.getSubjHigher() == null ? other.getSubjHigher() == null : this.getSubjHigher().equals(other.getSubjHigher()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTlrno() == null ? other.getTlrno() == null : this.getTlrno().equals(other.getTlrno()))
            && (this.getLastUpdDate() == null ? other.getLastUpdDate() == null : this.getLastUpdDate().equals(other.getLastUpdDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubjId() == null) ? 0 : getSubjId().hashCode());
        result = prime * result + ((getSubjNm() == null) ? 0 : getSubjNm().hashCode());
        result = prime * result + ((getRpSource() == null) ? 0 : getRpSource().hashCode());
        result = prime * result + ((getTitleId() == null) ? 0 : getTitleId().hashCode());
        result = prime * result + ((getTradeAverage() == null) ? 0 : getTradeAverage().hashCode());
        result = prime * result + ((getSubjLower() == null) ? 0 : getSubjLower().hashCode());
        result = prime * result + ((getSubjLow() == null) ? 0 : getSubjLow().hashCode());
        result = prime * result + ((getSubjMidi() == null) ? 0 : getSubjMidi().hashCode());
        result = prime * result + ((getSubjHigh() == null) ? 0 : getSubjHigh().hashCode());
        result = prime * result + ((getSubjHigher() == null) ? 0 : getSubjHigher().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTlrno() == null) ? 0 : getTlrno().hashCode());
        result = prime * result + ((getLastUpdDate() == null) ? 0 : getLastUpdDate().hashCode());
        return result;
    }
}