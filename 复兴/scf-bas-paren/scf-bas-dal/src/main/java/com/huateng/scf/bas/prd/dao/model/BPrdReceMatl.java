package com.huateng.scf.bas.prd.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPrdReceMatl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(100) 必填<br>
     * 应收材料名称
     */
    private String receMatlName;

    /**
     * CHAR(1) 必填<br>
     * 应收材料类型：0-要件类，1-管理类，2-保全类，3-客户资料类
     */
    private String receMatlType;

    /**
     * CHAR(1) 必填<br>
     * 是否必需：1-是，2-否
     */
    private String isNeedFlag;

    /**
     * DECIMAL(22) 必填<br>
     * 原件份数
     */
    private BigDecimal origNum;

    /**
     * DECIMAL(22) 必填<br>
     * 复印件份数
     */
    private BigDecimal copyOrigNum;

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
     * 获得 应收材料名称
     */
    public String getReceMatlName() {
        return receMatlName;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 应收材料名称
     */
    public void setReceMatlName(String receMatlName) {
        this.receMatlName = receMatlName == null ? null : receMatlName.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 应收材料类型：0-要件类，1-管理类，2-保全类，3-客户资料类
     */
    public String getReceMatlType() {
        return receMatlType;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 应收材料类型：0-要件类，1-管理类，2-保全类，3-客户资料类
     */
    public void setReceMatlType(String receMatlType) {
        this.receMatlType = receMatlType == null ? null : receMatlType.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 是否必需：1-是，2-否
     */
    public String getIsNeedFlag() {
        return isNeedFlag;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 是否必需：1-是，2-否
     */
    public void setIsNeedFlag(String isNeedFlag) {
        this.isNeedFlag = isNeedFlag == null ? null : isNeedFlag.trim();
    }

    /**
     * DECIMAL(22) 必填<br>
     * 获得 原件份数
     */
    public BigDecimal getOrigNum() {
        return origNum;
    }

    /**
     * DECIMAL(22) 必填<br>
     * 设置 原件份数
     */
    public void setOrigNum(BigDecimal origNum) {
        this.origNum = origNum;
    }

    /**
     * DECIMAL(22) 必填<br>
     * 获得 复印件份数
     */
    public BigDecimal getCopyOrigNum() {
        return copyOrigNum;
    }

    /**
     * DECIMAL(22) 必填<br>
     * 设置 复印件份数
     */
    public void setCopyOrigNum(BigDecimal copyOrigNum) {
        this.copyOrigNum = copyOrigNum;
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
        sb.append(", receMatlName=").append(receMatlName);
        sb.append(", receMatlType=").append(receMatlType);
        sb.append(", isNeedFlag=").append(isNeedFlag);
        sb.append(", origNum=").append(origNum);
        sb.append(", copyOrigNum=").append(copyOrigNum);
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
        BPrdReceMatl other = (BPrdReceMatl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReceMatlName() == null ? other.getReceMatlName() == null : this.getReceMatlName().equals(other.getReceMatlName()))
            && (this.getReceMatlType() == null ? other.getReceMatlType() == null : this.getReceMatlType().equals(other.getReceMatlType()))
            && (this.getIsNeedFlag() == null ? other.getIsNeedFlag() == null : this.getIsNeedFlag().equals(other.getIsNeedFlag()))
            && (this.getOrigNum() == null ? other.getOrigNum() == null : this.getOrigNum().equals(other.getOrigNum()))
            && (this.getCopyOrigNum() == null ? other.getCopyOrigNum() == null : this.getCopyOrigNum().equals(other.getCopyOrigNum()))
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
        result = prime * result + ((getReceMatlName() == null) ? 0 : getReceMatlName().hashCode());
        result = prime * result + ((getReceMatlType() == null) ? 0 : getReceMatlType().hashCode());
        result = prime * result + ((getIsNeedFlag() == null) ? 0 : getIsNeedFlag().hashCode());
        result = prime * result + ((getOrigNum() == null) ? 0 : getOrigNum().hashCode());
        result = prime * result + ((getCopyOrigNum() == null) ? 0 : getCopyOrigNum().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}