package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysChkCnfg implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 拦截项编号
     */
    private String chkItId;

    /**
     * VARCHAR(256)<br>
     * 拦截项描述
     */
    private String rem;

    /**
     * VARCHAR(100)<br>
     * 类名
     */
    private String clazz;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 拦截项编号
     */
    public String getChkItId() {
        return chkItId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 拦截项编号
     */
    public void setChkItId(String chkItId) {
        this.chkItId = chkItId == null ? null : chkItId.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 拦截项描述
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 拦截项描述
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 类名
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 类名
     */
    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chkItId=").append(chkItId);
        sb.append(", rem=").append(rem);
        sb.append(", clazz=").append(clazz);
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
        BSysChkCnfg other = (BSysChkCnfg) that;
        return (this.getChkItId() == null ? other.getChkItId() == null : this.getChkItId().equals(other.getChkItId()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getClazz() == null ? other.getClazz() == null : this.getClazz().equals(other.getClazz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChkItId() == null) ? 0 : getChkItId().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getClazz() == null) ? 0 : getClazz().hashCode());
        return result;
    }
}