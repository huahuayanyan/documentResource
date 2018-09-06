package com.huateng.scf.ods.dao.model;

import java.io.Serializable;
import java.util.Date;

public class OdsTopCityLine implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(100) 必填<br>
     * 热门城市
     */
    private String topCityId;

    /**
     * VARCHAR(100)<br>
     *  流向城市
     */
    private String endArea;

    /**
     * VARCHAR(100)<br>
     *  流向城市名称
     */
    private String endAreanm;

    /**
     * VARCHAR(32)<br>
     * 最后更新人
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;

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
     * VARCHAR(100) 必填<br>
     * 获得 热门城市
     */
    public String getTopCityId() {
        return topCityId;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 热门城市
     */
    public void setTopCityId(String topCityId) {
        this.topCityId = topCityId == null ? null : topCityId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得  流向城市
     */
    public String getEndArea() {
        return endArea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置  流向城市
     */
    public void setEndArea(String endArea) {
        this.endArea = endArea == null ? null : endArea.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得  流向城市名称
     */
    public String getEndAreanm() {
        return endAreanm;
    }

    /**
     * VARCHAR(100)<br>
     * 设置  流向城市名称
     */
    public void setEndAreanm(String endAreanm) {
        this.endAreanm = endAreanm == null ? null : endAreanm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新人
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新人
     */
    public void setLastUpdTlrcd(String lastUpdTlrcd) {
        this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdBrcode() {
        return lastUpdBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdBrcode(String lastUpdBrcode) {
        this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", topCityId=").append(topCityId);
        sb.append(", endArea=").append(endArea);
        sb.append(", endAreanm=").append(endAreanm);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
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
        OdsTopCityLine other = (OdsTopCityLine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTopCityId() == null ? other.getTopCityId() == null : this.getTopCityId().equals(other.getTopCityId()))
            && (this.getEndArea() == null ? other.getEndArea() == null : this.getEndArea().equals(other.getEndArea()))
            && (this.getEndAreanm() == null ? other.getEndAreanm() == null : this.getEndAreanm().equals(other.getEndAreanm()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTopCityId() == null) ? 0 : getTopCityId().hashCode());
        result = prime * result + ((getEndArea() == null) ? 0 : getEndArea().hashCode());
        result = prime * result + ((getEndAreanm() == null) ? 0 : getEndAreanm().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}