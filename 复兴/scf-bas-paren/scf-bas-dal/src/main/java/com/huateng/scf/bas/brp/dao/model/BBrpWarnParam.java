package com.huateng.scf.bas.brp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BBrpWarnParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 预警编号
     */
    private String warnNo;

    /**
     * VARCHAR(60) 必填<br>
     * 预警名称
     */
    private String warnName;

    /**
     * CHAR(1) 必填<br>
     * 预警类型
     */
    private String warnType;

    /**
     * CHAR(1)<br>
     * 是否可忽略
     */
    private String suspendFlag;

    /**
     * DECIMAL(22)<br>
     * 可忽略天数
     */
    private BigDecimal suspendDay;

    /**
     * CHAR(1)<br>
     * 预警目标类型
     */
    private String targetType;

    /**
     * VARCHAR(20)<br>
     * 目标机构级别
     */
    private String targetBrclass;

    /**
     * DECIMAL(22)<br>
     * 目标岗位
     */
    private BigDecimal targetRoleid;

    /**
     * VARCHAR(32) 默认值['1']<br>
     * 所属包编号
     */
    private String packageId;

    /**
     * VARCHAR(255)<br>
     * 预警程序
     */
    private String warnProcess;

    /**
     * VARCHAR(20)<br>
     * 低级阀值
     */
    private String warnLevelLow;

    /**
     * VARCHAR(20)<br>
     * 中级阀值
     */
    private String warnLevelMidi;

    /**
     * VARCHAR(20)<br>
     * 高级阀值
     */
    private String warnLevelHigh;

    /**
     * CHAR(4)<br>
     * 预警归属业务种类【动产/预付款/应收账款】
     */
    private String warnBussType;

    /**
     * VARCHAR(255)<br>
     * 预警明细页面的URL
     */
    private String url;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String tlrno;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 预警编号
     */
    public String getWarnNo() {
        return warnNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 预警编号
     */
    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo == null ? null : warnNo.trim();
    }

    /**
     * VARCHAR(60) 必填<br>
     * 获得 预警名称
     */
    public String getWarnName() {
        return warnName;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 预警名称
     */
    public void setWarnName(String warnName) {
        this.warnName = warnName == null ? null : warnName.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 预警类型
     */
    public String getWarnType() {
        return warnType;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 预警类型
     */
    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否可忽略
     */
    public String getSuspendFlag() {
        return suspendFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否可忽略
     */
    public void setSuspendFlag(String suspendFlag) {
        this.suspendFlag = suspendFlag == null ? null : suspendFlag.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 可忽略天数
     */
    public BigDecimal getSuspendDay() {
        return suspendDay;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 可忽略天数
     */
    public void setSuspendDay(BigDecimal suspendDay) {
        this.suspendDay = suspendDay;
    }

    /**
     * CHAR(1)<br>
     * 获得 预警目标类型
     */
    public String getTargetType() {
        return targetType;
    }

    /**
     * CHAR(1)<br>
     * 设置 预警目标类型
     */
    public void setTargetType(String targetType) {
        this.targetType = targetType == null ? null : targetType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 目标机构级别
     */
    public String getTargetBrclass() {
        return targetBrclass;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 目标机构级别
     */
    public void setTargetBrclass(String targetBrclass) {
        this.targetBrclass = targetBrclass == null ? null : targetBrclass.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 目标岗位
     */
    public BigDecimal getTargetRoleid() {
        return targetRoleid;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 目标岗位
     */
    public void setTargetRoleid(BigDecimal targetRoleid) {
        this.targetRoleid = targetRoleid;
    }

    /**
     * VARCHAR(32) 默认值['1']<br>
     * 获得 所属包编号
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * VARCHAR(32) 默认值['1']<br>
     * 设置 所属包编号
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 预警程序
     */
    public String getWarnProcess() {
        return warnProcess;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 预警程序
     */
    public void setWarnProcess(String warnProcess) {
        this.warnProcess = warnProcess == null ? null : warnProcess.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 低级阀值
     */
    public String getWarnLevelLow() {
        return warnLevelLow;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 低级阀值
     */
    public void setWarnLevelLow(String warnLevelLow) {
        this.warnLevelLow = warnLevelLow == null ? null : warnLevelLow.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 中级阀值
     */
    public String getWarnLevelMidi() {
        return warnLevelMidi;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 中级阀值
     */
    public void setWarnLevelMidi(String warnLevelMidi) {
        this.warnLevelMidi = warnLevelMidi == null ? null : warnLevelMidi.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 高级阀值
     */
    public String getWarnLevelHigh() {
        return warnLevelHigh;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 高级阀值
     */
    public void setWarnLevelHigh(String warnLevelHigh) {
        this.warnLevelHigh = warnLevelHigh == null ? null : warnLevelHigh.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 预警归属业务种类【动产/预付款/应收账款】
     */
    public String getWarnBussType() {
        return warnBussType;
    }

    /**
     * CHAR(4)<br>
     * 设置 预警归属业务种类【动产/预付款/应收账款】
     */
    public void setWarnBussType(String warnBussType) {
        this.warnBussType = warnBussType == null ? null : warnBussType.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 预警明细页面的URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 预警明细页面的URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warnNo=").append(warnNo);
        sb.append(", warnName=").append(warnName);
        sb.append(", warnType=").append(warnType);
        sb.append(", suspendFlag=").append(suspendFlag);
        sb.append(", suspendDay=").append(suspendDay);
        sb.append(", targetType=").append(targetType);
        sb.append(", targetBrclass=").append(targetBrclass);
        sb.append(", targetRoleid=").append(targetRoleid);
        sb.append(", packageId=").append(packageId);
        sb.append(", warnProcess=").append(warnProcess);
        sb.append(", warnLevelLow=").append(warnLevelLow);
        sb.append(", warnLevelMidi=").append(warnLevelMidi);
        sb.append(", warnLevelHigh=").append(warnLevelHigh);
        sb.append(", warnBussType=").append(warnBussType);
        sb.append(", url=").append(url);
        sb.append(", tlrno=").append(tlrno);
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
        BBrpWarnParam other = (BBrpWarnParam) that;
        return (this.getWarnNo() == null ? other.getWarnNo() == null : this.getWarnNo().equals(other.getWarnNo()))
            && (this.getWarnName() == null ? other.getWarnName() == null : this.getWarnName().equals(other.getWarnName()))
            && (this.getWarnType() == null ? other.getWarnType() == null : this.getWarnType().equals(other.getWarnType()))
            && (this.getSuspendFlag() == null ? other.getSuspendFlag() == null : this.getSuspendFlag().equals(other.getSuspendFlag()))
            && (this.getSuspendDay() == null ? other.getSuspendDay() == null : this.getSuspendDay().equals(other.getSuspendDay()))
            && (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
            && (this.getTargetBrclass() == null ? other.getTargetBrclass() == null : this.getTargetBrclass().equals(other.getTargetBrclass()))
            && (this.getTargetRoleid() == null ? other.getTargetRoleid() == null : this.getTargetRoleid().equals(other.getTargetRoleid()))
            && (this.getPackageId() == null ? other.getPackageId() == null : this.getPackageId().equals(other.getPackageId()))
            && (this.getWarnProcess() == null ? other.getWarnProcess() == null : this.getWarnProcess().equals(other.getWarnProcess()))
            && (this.getWarnLevelLow() == null ? other.getWarnLevelLow() == null : this.getWarnLevelLow().equals(other.getWarnLevelLow()))
            && (this.getWarnLevelMidi() == null ? other.getWarnLevelMidi() == null : this.getWarnLevelMidi().equals(other.getWarnLevelMidi()))
            && (this.getWarnLevelHigh() == null ? other.getWarnLevelHigh() == null : this.getWarnLevelHigh().equals(other.getWarnLevelHigh()))
            && (this.getWarnBussType() == null ? other.getWarnBussType() == null : this.getWarnBussType().equals(other.getWarnBussType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getTlrno() == null ? other.getTlrno() == null : this.getTlrno().equals(other.getTlrno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarnNo() == null) ? 0 : getWarnNo().hashCode());
        result = prime * result + ((getWarnName() == null) ? 0 : getWarnName().hashCode());
        result = prime * result + ((getWarnType() == null) ? 0 : getWarnType().hashCode());
        result = prime * result + ((getSuspendFlag() == null) ? 0 : getSuspendFlag().hashCode());
        result = prime * result + ((getSuspendDay() == null) ? 0 : getSuspendDay().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getTargetBrclass() == null) ? 0 : getTargetBrclass().hashCode());
        result = prime * result + ((getTargetRoleid() == null) ? 0 : getTargetRoleid().hashCode());
        result = prime * result + ((getPackageId() == null) ? 0 : getPackageId().hashCode());
        result = prime * result + ((getWarnProcess() == null) ? 0 : getWarnProcess().hashCode());
        result = prime * result + ((getWarnLevelLow() == null) ? 0 : getWarnLevelLow().hashCode());
        result = prime * result + ((getWarnLevelMidi() == null) ? 0 : getWarnLevelMidi().hashCode());
        result = prime * result + ((getWarnLevelHigh() == null) ? 0 : getWarnLevelHigh().hashCode());
        result = prime * result + ((getWarnBussType() == null) ? 0 : getWarnBussType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getTlrno() == null) ? 0 : getTlrno().hashCode());
        return result;
    }
}