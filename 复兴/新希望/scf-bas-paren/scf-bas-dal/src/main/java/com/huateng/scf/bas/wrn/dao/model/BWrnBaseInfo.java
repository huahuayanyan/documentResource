package com.huateng.scf.bas.wrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BWrnBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键ID
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 预警编号
     */
    private String paramId;

    /**
     * CHAR(8) 必填<br>
     * 预警产生日期
     */
    private String warnDate;

    /**
     * CHAR(1) 必填<br>
     * 预警级别：1-高、2-中、3-低
     */
    private String warnLevel;

    /**
     * CHAR(1) 必填<br>
     * 预警状态：0-无效、1-有效、2-忽略
     */
    private String status;

    /**
     * CHAR(8)<br>
     * 忽略日期
     */
    private String suspendDate;

    /**
     * DECIMAL(22)<br>
     * 忽略天数
     */
    private BigDecimal suspendDays;

    /**
     * VARCHAR(32)<br>
     * 忽略操作员
     */
    private String suspendTlrno;

    /**
     * VARCHAR(32)<br>
     * 处理操作员
     */
    private String processTlrno;

    /**
     * CHAR(8)<br>
     * 处理日期
     */
    private String processDate;

    /**
     * VARCHAR(32)<br>
     * 客户经理
     */
    private String custManager;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * CHAR(8)<br>
     * 预警到期日
     */
    private String warnDueDate;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * VARCHAR(10)<br>
     * 产品大类：1000-存货类、2000-预付类、3000-应收类
     */
    private String topProductId;

    /**
     * VARCHAR(15)<br>
     * 预警主体的客户号
     */
    private String custcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新日期
     */
    private Date lastUpdDate;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 预警编号
     */
    public String getParamId() {
        return paramId;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 预警编号
     */
    public void setParamId(String paramId) {
        this.paramId = paramId == null ? null : paramId.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 预警产生日期
     */
    public String getWarnDate() {
        return warnDate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 预警产生日期
     */
    public void setWarnDate(String warnDate) {
        this.warnDate = warnDate == null ? null : warnDate.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 预警级别：1-高、2-中、3-低
     */
    public String getWarnLevel() {
        return warnLevel;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 预警级别：1-高、2-中、3-低
     */
    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel == null ? null : warnLevel.trim();
    }

    /**
     * CHAR(1) 必填<br>
     * 获得 预警状态：0-无效、1-有效、2-忽略
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 预警状态：0-无效、1-有效、2-忽略
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 忽略日期
     */
    public String getSuspendDate() {
        return suspendDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 忽略日期
     */
    public void setSuspendDate(String suspendDate) {
        this.suspendDate = suspendDate == null ? null : suspendDate.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 忽略天数
     */
    public BigDecimal getSuspendDays() {
        return suspendDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 忽略天数
     */
    public void setSuspendDays(BigDecimal suspendDays) {
        this.suspendDays = suspendDays;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 忽略操作员
     */
    public String getSuspendTlrno() {
        return suspendTlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 忽略操作员
     */
    public void setSuspendTlrno(String suspendTlrno) {
        this.suspendTlrno = suspendTlrno == null ? null : suspendTlrno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 处理操作员
     */
    public String getProcessTlrno() {
        return processTlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 处理操作员
     */
    public void setProcessTlrno(String processTlrno) {
        this.processTlrno = processTlrno == null ? null : processTlrno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 处理日期
     */
    public String getProcessDate() {
        return processDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 处理日期
     */
    public void setProcessDate(String processDate) {
        this.processDate = processDate == null ? null : processDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 客户经理
     */
    public String getCustManager() {
        return custManager;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 客户经理
     */
    public void setCustManager(String custManager) {
        this.custManager = custManager == null ? null : custManager.trim();
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
     * CHAR(8)<br>
     * 获得 预警到期日
     */
    public String getWarnDueDate() {
        return warnDueDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 预警到期日
     */
    public void setWarnDueDate(String warnDueDate) {
        this.warnDueDate = warnDueDate == null ? null : warnDueDate.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 产品大类：1000-存货类、2000-预付类、3000-应收类
     */
    public String getTopProductId() {
        return topProductId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 产品大类：1000-存货类、2000-预付类、3000-应收类
     */
    public void setTopProductId(String topProductId) {
        this.topProductId = topProductId == null ? null : topProductId.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 预警主体的客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 预警主体的客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新日期
     */
    public Date getLastUpdDate() {
        return lastUpdDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新日期
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
        sb.append(", paramId=").append(paramId);
        sb.append(", warnDate=").append(warnDate);
        sb.append(", warnLevel=").append(warnLevel);
        sb.append(", status=").append(status);
        sb.append(", suspendDate=").append(suspendDate);
        sb.append(", suspendDays=").append(suspendDays);
        sb.append(", suspendTlrno=").append(suspendTlrno);
        sb.append(", processTlrno=").append(processTlrno);
        sb.append(", processDate=").append(processDate);
        sb.append(", custManager=").append(custManager);
        sb.append(", brcode=").append(brcode);
        sb.append(", warnDueDate=").append(warnDueDate);
        sb.append(", productId=").append(productId);
        sb.append(", topProductId=").append(topProductId);
        sb.append(", custcd=").append(custcd);
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
        BWrnBaseInfo other = (BWrnBaseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParamId() == null ? other.getParamId() == null : this.getParamId().equals(other.getParamId()))
            && (this.getWarnDate() == null ? other.getWarnDate() == null : this.getWarnDate().equals(other.getWarnDate()))
            && (this.getWarnLevel() == null ? other.getWarnLevel() == null : this.getWarnLevel().equals(other.getWarnLevel()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSuspendDate() == null ? other.getSuspendDate() == null : this.getSuspendDate().equals(other.getSuspendDate()))
            && (this.getSuspendDays() == null ? other.getSuspendDays() == null : this.getSuspendDays().equals(other.getSuspendDays()))
            && (this.getSuspendTlrno() == null ? other.getSuspendTlrno() == null : this.getSuspendTlrno().equals(other.getSuspendTlrno()))
            && (this.getProcessTlrno() == null ? other.getProcessTlrno() == null : this.getProcessTlrno().equals(other.getProcessTlrno()))
            && (this.getProcessDate() == null ? other.getProcessDate() == null : this.getProcessDate().equals(other.getProcessDate()))
            && (this.getCustManager() == null ? other.getCustManager() == null : this.getCustManager().equals(other.getCustManager()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getWarnDueDate() == null ? other.getWarnDueDate() == null : this.getWarnDueDate().equals(other.getWarnDueDate()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getTopProductId() == null ? other.getTopProductId() == null : this.getTopProductId().equals(other.getTopProductId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getLastUpdDate() == null ? other.getLastUpdDate() == null : this.getLastUpdDate().equals(other.getLastUpdDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParamId() == null) ? 0 : getParamId().hashCode());
        result = prime * result + ((getWarnDate() == null) ? 0 : getWarnDate().hashCode());
        result = prime * result + ((getWarnLevel() == null) ? 0 : getWarnLevel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSuspendDate() == null) ? 0 : getSuspendDate().hashCode());
        result = prime * result + ((getSuspendDays() == null) ? 0 : getSuspendDays().hashCode());
        result = prime * result + ((getSuspendTlrno() == null) ? 0 : getSuspendTlrno().hashCode());
        result = prime * result + ((getProcessTlrno() == null) ? 0 : getProcessTlrno().hashCode());
        result = prime * result + ((getProcessDate() == null) ? 0 : getProcessDate().hashCode());
        result = prime * result + ((getCustManager() == null) ? 0 : getCustManager().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getWarnDueDate() == null) ? 0 : getWarnDueDate().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getTopProductId() == null) ? 0 : getTopProductId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getLastUpdDate() == null) ? 0 : getLastUpdDate().hashCode());
        return result;
    }
}