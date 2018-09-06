package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <p>系统全局信息</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月25日下午2:02:32	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月25日下午2:02:32              新增
 *
 * </pre>
 */
public class BSysGlobalInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 系统代码
     */
    private String sysCode;

    /**
     * VARCHAR(50)<br>
     * 系统简称
     */
    private String systemName;

    /**
     * CHAR(8)<br>
     * 交易日期
     */
    private String tbsdy;

    /**
     * CHAR(8)<br>
     * 批量日期
     */
    private String bhdate;

    /**
     * CHAR(8)<br>
     * 上一批量日期（换日后更新）
     */
    private String lbhdate;

    /**
     * CHAR(1)<br>
     * 系统状态：0-联机交易 1-批量状态
     */
    private String status;

    /**
     * CHAR(2)<br>
     * 系统类型
     */
    private String systemType;

    /**
     * TIMESTAMP(11,6)<br>
     * 时间戳
     */
    private Date timestamps;

    /**
     * VARCHAR(20)<br>
     * 扩展标识
     */
    private String miscflgs;

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
     * VARCHAR(20)<br>
     * 获得 系统代码
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 系统代码
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 系统简称
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 系统简称
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 交易日期
     */
    public String getTbsdy() {
        return tbsdy;
    }

    /**
     * CHAR(8)<br>
     * 设置 交易日期
     */
    public void setTbsdy(String tbsdy) {
        this.tbsdy = tbsdy == null ? null : tbsdy.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 批量日期
     */
    public String getBhdate() {
        return bhdate;
    }

    /**
     * CHAR(8)<br>
     * 设置 批量日期
     */
    public void setBhdate(String bhdate) {
        this.bhdate = bhdate == null ? null : bhdate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 上一批量日期（换日后更新）
     */
    public String getLbhdate() {
        return lbhdate;
    }

    /**
     * CHAR(8)<br>
     * 设置 上一批量日期（换日后更新）
     */
    public void setLbhdate(String lbhdate) {
        this.lbhdate = lbhdate == null ? null : lbhdate.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 系统状态：0-联机交易 1-批量状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 系统状态：0-联机交易 1-批量状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 系统类型
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * CHAR(2)<br>
     * 设置 系统类型
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 时间戳
     */
    public Date getTimestamps() {
        return timestamps;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 时间戳
     */
    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 扩展标识
     */
    public String getMiscflgs() {
        return miscflgs;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 扩展标识
     */
    public void setMiscflgs(String miscflgs) {
        this.miscflgs = miscflgs == null ? null : miscflgs.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysCode=").append(sysCode);
        sb.append(", systemName=").append(systemName);
        sb.append(", tbsdy=").append(tbsdy);
        sb.append(", bhdate=").append(bhdate);
        sb.append(", lbhdate=").append(lbhdate);
        sb.append(", status=").append(status);
        sb.append(", systemType=").append(systemType);
        sb.append(", timestamps=").append(timestamps);
        sb.append(", miscflgs=").append(miscflgs);
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
        BSysGlobalInfo other = (BSysGlobalInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysCode() == null ? other.getSysCode() == null : this.getSysCode().equals(other.getSysCode()))
            && (this.getSystemName() == null ? other.getSystemName() == null : this.getSystemName().equals(other.getSystemName()))
            && (this.getTbsdy() == null ? other.getTbsdy() == null : this.getTbsdy().equals(other.getTbsdy()))
            && (this.getBhdate() == null ? other.getBhdate() == null : this.getBhdate().equals(other.getBhdate()))
            && (this.getLbhdate() == null ? other.getLbhdate() == null : this.getLbhdate().equals(other.getLbhdate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSystemType() == null ? other.getSystemType() == null : this.getSystemType().equals(other.getSystemType()))
            && (this.getTimestamps() == null ? other.getTimestamps() == null : this.getTimestamps().equals(other.getTimestamps()))
            && (this.getMiscflgs() == null ? other.getMiscflgs() == null : this.getMiscflgs().equals(other.getMiscflgs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysCode() == null) ? 0 : getSysCode().hashCode());
        result = prime * result + ((getSystemName() == null) ? 0 : getSystemName().hashCode());
        result = prime * result + ((getTbsdy() == null) ? 0 : getTbsdy().hashCode());
        result = prime * result + ((getBhdate() == null) ? 0 : getBhdate().hashCode());
        result = prime * result + ((getLbhdate() == null) ? 0 : getLbhdate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSystemType() == null) ? 0 : getSystemType().hashCode());
        result = prime * result + ((getTimestamps() == null) ? 0 : getTimestamps().hashCode());
        result = prime * result + ((getMiscflgs() == null) ? 0 : getMiscflgs().hashCode());
        return result;
    }
}