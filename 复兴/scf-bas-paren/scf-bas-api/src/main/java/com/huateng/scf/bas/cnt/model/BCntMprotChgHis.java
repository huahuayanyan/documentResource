package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.util.Date;

public class BCntMprotChgHis implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 主键协议编号
     */
    private String protocolNo;

    /**
     * VARCHAR(150) 必填<br>
     * 旧主键协议编号
     */
    private String oldProtocolNo;

    /**
     * VARCHAR(32)<br>
     * 操作员
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 时间
     */
    private Date time;

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
     * VARCHAR(20) 必填<br>
     * 获得 主键协议编号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 主键协议编号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(150) 必填<br>
     * 获得 旧主键协议编号
     */
    public String getOldProtocolNo() {
        return oldProtocolNo;
    }

    /**
     * VARCHAR(150) 必填<br>
     * 设置 旧主键协议编号
     */
    public void setOldProtocolNo(String oldProtocolNo) {
        this.oldProtocolNo = oldProtocolNo == null ? null : oldProtocolNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 操作员
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 操作员
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", oldProtocolNo=").append(oldProtocolNo);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", time=").append(time);
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
        BCntMprotChgHis other = (BCntMprotChgHis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getOldProtocolNo() == null ? other.getOldProtocolNo() == null : this.getOldProtocolNo().equals(other.getOldProtocolNo()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getOldProtocolNo() == null) ? 0 : getOldProtocolNo().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }
}