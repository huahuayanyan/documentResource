package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysChkDir implements Serializable {
    
	private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 拦截模型ID
     */
    private String mdlId;

    /**
     * VARCHAR(60)<br>
     * 拦截模型名
     */
    private String mdlNm;

    /**
     * CHAR(1)<br>
     * 启用标志
     */
    private String stat;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 拦截模型ID
     */
    public String getMdlId() {
        return mdlId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 拦截模型ID
     */
    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 拦截模型名
     */
    public String getMdlNm() {
        return mdlNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 拦截模型名
     */
    public void setMdlNm(String mdlNm) {
        this.mdlNm = mdlNm == null ? null : mdlNm.trim();
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
        sb.append(", mdlId=").append(mdlId);
        sb.append(", mdlNm=").append(mdlNm);
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
        BSysChkDir other = (BSysChkDir) that;
        return (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getMdlNm() == null ? other.getMdlNm() == null : this.getMdlNm().equals(other.getMdlNm()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getMdlNm() == null) ? 0 : getMdlNm().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        return result;
    }
}