package com.huateng.scf.bas.qry.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OFinaStaAnalysis implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 项目id
     */
    private String projectId;

    /**
     * VARCHAR(150)<br>
     * 项目
     */
    private String project;

    /**
     * VARCHAR(4)<br>
     * 发生类型：1收入，2支出，损失金
     */
    private String finaType;

    /**
     * DECIMAL(16,2)<br>
     * 金额
     */
    private BigDecimal amount;

    /**
     * CHAR(8)<br>
     * 日期
     */
    private String finaDate;

    /**
     * VARCHAR(500)<br>
     * 
     */
    private String remark;

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
     * 获得 ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 项目id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 项目id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * VARCHAR(150)<br>
     * 获得 项目
     */
    public String getProject() {
        return project;
    }

    /**
     * VARCHAR(150)<br>
     * 设置 项目
     */
    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 发生类型：1收入，2支出，损失金
     */
    public String getFinaType() {
        return finaType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 发生类型：1收入，2支出，损失金
     */
    public void setFinaType(String finaType) {
        this.finaType = finaType == null ? null : finaType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * CHAR(8)<br>
     * 获得 日期
     */
    public String getFinaDate() {
        return finaDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 日期
     */
    public void setFinaDate(String finaDate) {
        this.finaDate = finaDate == null ? null : finaDate.trim();
    }

    /**
     * VARCHAR(500)<br>
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(500)<br>
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(", projectId=").append(projectId);
        sb.append(", project=").append(project);
        sb.append(", finaType=").append(finaType);
        sb.append(", amount=").append(amount);
        sb.append(", finaDate=").append(finaDate);
        sb.append(", remark=").append(remark);
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
        OFinaStaAnalysis other = (OFinaStaAnalysis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProject() == null ? other.getProject() == null : this.getProject().equals(other.getProject()))
            && (this.getFinaType() == null ? other.getFinaType() == null : this.getFinaType().equals(other.getFinaType()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getFinaDate() == null ? other.getFinaDate() == null : this.getFinaDate().equals(other.getFinaDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProject() == null) ? 0 : getProject().hashCode());
        result = prime * result + ((getFinaType() == null) ? 0 : getFinaType().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFinaDate() == null) ? 0 : getFinaDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}