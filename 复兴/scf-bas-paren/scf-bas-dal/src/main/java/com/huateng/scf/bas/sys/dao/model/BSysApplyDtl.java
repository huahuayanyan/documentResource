package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BSysApplyDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(30)<br>
     * 业务编号
     */
    private String transno;

    /**
     * VARCHAR(20)<br>
     * 工作流申请号
     */
    private String appno;

    /**
     * CHAR(8)<br>
     * 交易日期
     */
    private String txdate;

    /**
     * VARCHAR(20)<br>
     * 机构号
     */
    private String brhno;

    /**
     * VARCHAR(32)<br>
     * 操作员号
     */
    private String oprno;

    /**
     * VARCHAR(20)<br>
     * 操作流水号
     */
    private String tlsrno;

    /**
     * VARCHAR(25)<br>
     * 交易时间
     */
    private String txtime;

    /**
     * VARCHAR(22)<br>
     * 功能代码
     */
    private String funcCode;

    /**
     * VARCHAR(4)<br>
     * 业务类型
     */
    private String bussType;

    /**
     * VARCHAR(500)<br>
     * 审批意见
     */
    private String attitude;

    /**
     * DECIMAL(22)<br>
     * 岗位编号/角色ID
     */
    private BigDecimal roleId;

    /**
     * VARCHAR(1)<br>
     * 岗位类型
     */
    private String roleType;

    /**
     * VARCHAR(4000)<br>
     * 审批留言
     */
    private String reason;

    /**
     * TIMESTAMP(11,6)<br>
     * 时间戳
     */
    private Date timestamps;

    /**
     * VARCHAR(20)<br>
     * 备注标识
     */
    private String miscflgs;

    /**
     * VARCHAR(1024)<br>
     * 备注
     */
    private String misc;
    
    private String oprName;//经办人名称

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
     * VARCHAR(30)<br>
     * 获得 业务编号
     */
    public String getTransno() {
        return transno;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 业务编号
     */
    public void setTransno(String transno) {
        this.transno = transno == null ? null : transno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 工作流申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 工作流申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 交易日期
     */
    public String getTxdate() {
        return txdate;
    }

    /**
     * CHAR(8)<br>
     * 设置 交易日期
     */
    public void setTxdate(String txdate) {
        this.txdate = txdate == null ? null : txdate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 机构号
     */
    public String getBrhno() {
        return brhno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 机构号
     */
    public void setBrhno(String brhno) {
        this.brhno = brhno == null ? null : brhno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 操作员号
     */
    public String getOprno() {
        return oprno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 操作员号
     */
    public void setOprno(String oprno) {
        this.oprno = oprno == null ? null : oprno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 操作流水号
     */
    public String getTlsrno() {
        return tlsrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 操作流水号
     */
    public void setTlsrno(String tlsrno) {
        this.tlsrno = tlsrno == null ? null : tlsrno.trim();
    }

    /**
     * VARCHAR(25)<br>
     * 获得 交易时间
     */
    public String getTxtime() {
        return txtime;
    }

    /**
     * VARCHAR(25)<br>
     * 设置 交易时间
     */
    public void setTxtime(String txtime) {
        this.txtime = txtime == null ? null : txtime.trim();
    }

    /**
     * VARCHAR(22)<br>
     * 获得 功能代码
     */
    public String getFuncCode() {
        return funcCode;
    }

    /**
     * VARCHAR(22)<br>
     * 设置 功能代码
     */
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode == null ? null : funcCode.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 业务类型
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 业务类型
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 审批意见
     */
    public String getAttitude() {
        return attitude;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 审批意见
     */
    public void setAttitude(String attitude) {
        this.attitude = attitude == null ? null : attitude.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 岗位编号/角色ID
     */
    public BigDecimal getRoleId() {
        return roleId;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 岗位编号/角色ID
     */
    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    /**
     * VARCHAR(1)<br>
     * 获得 岗位类型
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 岗位类型
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 审批留言
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 审批留言
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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
     * 获得 备注标识
     */
    public String getMiscflgs() {
        return miscflgs;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 备注标识
     */
    public void setMiscflgs(String miscflgs) {
        this.miscflgs = miscflgs == null ? null : miscflgs.trim();
    }

    /**
     * VARCHAR(1024)<br>
     * 获得 备注
     */
    public String getMisc() {
        return misc;
    }

    /**
     * VARCHAR(1024)<br>
     * 设置 备注
     */
    public void setMisc(String misc) {
        this.misc = misc == null ? null : misc.trim();
    }
    
    

    /**
	 * @return the oprName
	 */
	public String getOprName() {
		return oprName;
	}

	/**
	 * @param oprName the oprName to set
	 */
	public void setOprName(String oprName) {
		this.oprName = oprName;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", transno=").append(transno);
        sb.append(", appno=").append(appno);
        sb.append(", txdate=").append(txdate);
        sb.append(", brhno=").append(brhno);
        sb.append(", oprno=").append(oprno);
        sb.append(", tlsrno=").append(tlsrno);
        sb.append(", txtime=").append(txtime);
        sb.append(", funcCode=").append(funcCode);
        sb.append(", bussType=").append(bussType);
        sb.append(", attitude=").append(attitude);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleType=").append(roleType);
        sb.append(", reason=").append(reason);
        sb.append(", timestamps=").append(timestamps);
        sb.append(", miscflgs=").append(miscflgs);
        sb.append(", misc=").append(misc);
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
        BSysApplyDtl other = (BSysApplyDtl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransno() == null ? other.getTransno() == null : this.getTransno().equals(other.getTransno()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getTxdate() == null ? other.getTxdate() == null : this.getTxdate().equals(other.getTxdate()))
            && (this.getBrhno() == null ? other.getBrhno() == null : this.getBrhno().equals(other.getBrhno()))
            && (this.getOprno() == null ? other.getOprno() == null : this.getOprno().equals(other.getOprno()))
            && (this.getTlsrno() == null ? other.getTlsrno() == null : this.getTlsrno().equals(other.getTlsrno()))
            && (this.getTxtime() == null ? other.getTxtime() == null : this.getTxtime().equals(other.getTxtime()))
            && (this.getFuncCode() == null ? other.getFuncCode() == null : this.getFuncCode().equals(other.getFuncCode()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getAttitude() == null ? other.getAttitude() == null : this.getAttitude().equals(other.getAttitude()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getRoleType() == null ? other.getRoleType() == null : this.getRoleType().equals(other.getRoleType()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getTimestamps() == null ? other.getTimestamps() == null : this.getTimestamps().equals(other.getTimestamps()))
            && (this.getMiscflgs() == null ? other.getMiscflgs() == null : this.getMiscflgs().equals(other.getMiscflgs()))
            && (this.getMisc() == null ? other.getMisc() == null : this.getMisc().equals(other.getMisc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTransno() == null) ? 0 : getTransno().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getTxdate() == null) ? 0 : getTxdate().hashCode());
        result = prime * result + ((getBrhno() == null) ? 0 : getBrhno().hashCode());
        result = prime * result + ((getOprno() == null) ? 0 : getOprno().hashCode());
        result = prime * result + ((getTlsrno() == null) ? 0 : getTlsrno().hashCode());
        result = prime * result + ((getTxtime() == null) ? 0 : getTxtime().hashCode());
        result = prime * result + ((getFuncCode() == null) ? 0 : getFuncCode().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getAttitude() == null) ? 0 : getAttitude().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getRoleType() == null) ? 0 : getRoleType().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getTimestamps() == null) ? 0 : getTimestamps().hashCode());
        result = prime * result + ((getMiscflgs() == null) ? 0 : getMiscflgs().hashCode());
        result = prime * result + ((getMisc() == null) ? 0 : getMisc().hashCode());
        return result;
    }
}