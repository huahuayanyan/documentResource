package com.huateng.scf.bas.fin.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BFinCustDsExt implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(32) 必填<br>
     * 财报数据流水号
     */
    private String serialno;

    /**
     * VARCHAR(9)<br>
     * 财报科目编号
     */
    private String subjId;

    /**
     * CHAR(8)<br>
     * 分析日期
     */
    private String analyDate;

    /**
     * VARCHAR(6)<br>
     * 分析结果
     */
    private String result;

    /**
     * VARCHAR(300)<br>
     * 分析描述
     */
    private String remark;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String lastUptTlrno;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdDate;

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
     * VARCHAR(32) 必填<br>
     * 获得 财报数据流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 财报数据流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    /**
     * VARCHAR(9)<br>
     * 获得 财报科目编号
     */
    public String getSubjId() {
        return subjId;
    }

    /**
     * VARCHAR(9)<br>
     * 设置 财报科目编号
     */
    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 分析日期
     */
    public String getAnalyDate() {
        return analyDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 分析日期
     */
    public void setAnalyDate(String analyDate) {
        this.analyDate = analyDate == null ? null : analyDate.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 分析结果
     */
    public String getResult() {
        return result;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 分析结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 分析描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 分析描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUptTlrno() {
        return lastUptTlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setLastUptTlrno(String lastUptTlrno) {
        this.lastUptTlrno = lastUptTlrno == null ? null : lastUptTlrno.trim();
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
        sb.append(", id=").append(id);
        sb.append(", serialno=").append(serialno);
        sb.append(", subjId=").append(subjId);
        sb.append(", analyDate=").append(analyDate);
        sb.append(", result=").append(result);
        sb.append(", remark=").append(remark);
        sb.append(", lastUptTlrno=").append(lastUptTlrno);
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
        BFinCustDsExt other = (BFinCustDsExt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getSubjId() == null ? other.getSubjId() == null : this.getSubjId().equals(other.getSubjId()))
            && (this.getAnalyDate() == null ? other.getAnalyDate() == null : this.getAnalyDate().equals(other.getAnalyDate()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getLastUptTlrno() == null ? other.getLastUptTlrno() == null : this.getLastUptTlrno().equals(other.getLastUptTlrno()))
            && (this.getLastUpdDate() == null ? other.getLastUpdDate() == null : this.getLastUpdDate().equals(other.getLastUpdDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getSubjId() == null) ? 0 : getSubjId().hashCode());
        result = prime * result + ((getAnalyDate() == null) ? 0 : getAnalyDate().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getLastUptTlrno() == null) ? 0 : getLastUptTlrno().hashCode());
        result = prime * result + ((getLastUpdDate() == null) ? 0 : getLastUpdDate().hashCode());
        return result;
    }
}