package com.huateng.scf.bas.prd.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BPrdBcop implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(100) 必填<br>
     * 业务组件名称
     */
    private String bcopName;

    /**
     * VARCHAR(50) 必填<br>
     * 业务组件编号
     */
    private String bcopNo;

    /**
     * VARCHAR(500) 必填<br>
     * 组件执行程序
     */
    private String bcopProg;

    /**
     * CHAR(1) 必填<br>
     * 状态：1-启用，2-停用
     */
    private String status;

    /**
     * VARCHAR(32)<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date crtTime;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
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
     * VARCHAR(100) 必填<br>
     * 获得 业务组件名称
     */
    public String getBcopName() {
        return bcopName;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 业务组件名称
     */
    public void setBcopName(String bcopName) {
        this.bcopName = bcopName == null ? null : bcopName.trim();
    }

    /**
     * VARCHAR(50) 必填<br>
     * 获得 业务组件编号
     */
    public String getBcopNo() {
        return bcopNo;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 业务组件编号
     */
    public void setBcopNo(String bcopNo) {
        this.bcopNo = bcopNo == null ? null : bcopNo.trim();
    }

    /**
     * VARCHAR(500) 必填<br>
     * 获得 组件执行程序
     */
    public String getBcopProg() {
        return bcopProg;
    }

    /**
     * VARCHAR(500) 必填<br>
     * 设置 组件执行程序
     */
    public void setBcopProg(String bcopProg) {
        this.bcopProg = bcopProg == null ? null : bcopProg.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 状态：1-启用，2-停用
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 状态：1-启用，2-停用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 创建人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
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
        sb.append(", bcopName=").append(bcopName);
        sb.append(", bcopNo=").append(bcopNo);
        sb.append(", bcopProg=").append(bcopProg);
        sb.append(", status=").append(status);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", brcode=").append(brcode);
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
        BPrdBcop other = (BPrdBcop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBcopName() == null ? other.getBcopName() == null : this.getBcopName().equals(other.getBcopName()))
            && (this.getBcopNo() == null ? other.getBcopNo() == null : this.getBcopNo().equals(other.getBcopNo()))
            && (this.getBcopProg() == null ? other.getBcopProg() == null : this.getBcopProg().equals(other.getBcopProg()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBcopName() == null) ? 0 : getBcopName().hashCode());
        result = prime * result + ((getBcopNo() == null) ? 0 : getBcopNo().hashCode());
        result = prime * result + ((getBcopProg() == null) ? 0 : getBcopProg().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}