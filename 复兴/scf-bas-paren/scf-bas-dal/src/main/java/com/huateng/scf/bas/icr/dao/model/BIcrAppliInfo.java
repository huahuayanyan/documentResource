package com.huateng.scf.bas.icr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BIcrAppliInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID主键
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 申请号
     */
    private String appno;

    /**
     * CHAR(1)<br>
     * 额度种类：1-直接授信额度；2-第三方授信额度
     */
    private String creditClass;

    /**
     * VARCHAR(20)<br>
     * 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    private String creditType;

    /**
     * CHAR(1)<br>
     * 节点类型：1-根节点；2-子节点
     */
    private String nodeType;

    /**
     * VARCHAR(100) 必填<br>
     * 额度编号
     */
    private String creditNo;

    /**
     * VARCHAR(100)<br>
     * 上级额度编号
     */
    private String upCreditNo;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(15)<br>
     * 交易对手客户号
     */
    private String otherCustcd;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(1)<br>
     * 是否循环：0-非循环；1-循环；
     */
    private String controlType;

    /**
     * DECIMAL(16,2)<br>
     * 额度金额
     */
    private BigDecimal creditAmount;

    /**
     * DECIMAL(16,2)<br>
     * 可用额度=总额度-预占用额度-实占额度-冻结额度
     */
    private BigDecimal creditUsableAmount;

    /**
     * DECIMAL(16,2)<br>
     * 预占额度
     */
    private BigDecimal preUsedAmount;

    /**
     * DECIMAL(16,2)<br>
     * 已用额度
     */
    private BigDecimal usedAmount;

    /**
     * DECIMAL(16,2)<br>
     * 冻结额度
     */
    private BigDecimal frzAmount;

    /**
     * CHAR(1)<br>
     * 状态：1-正常，2-终止
     */
    private String status;

    /**
     * CHAR(8)<br>
     * 额度生效日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 额度到期日期
     */
    private String endDate;

    /**
     * VARCHAR(100)<br>
     * 审批书编号
     */
    private String approvalNo;

    /**
     * CHAR(1)<br>
     * 是否要求领用审批：1-是、0-否
     */
    private String isNeedAudit;

    /**
     * CHAR(1)<br>
     * 审批类型：1-直接授予、2-间接授予
     */
    private String approveType;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(20)<br>
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
     * 获得 ID主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ID主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 额度种类：1-直接授信额度；2-第三方授信额度
     */
    public String getCreditClass() {
        return creditClass;
    }

    /**
     * CHAR(1)<br>
     * 设置 额度种类：1-直接授信额度；2-第三方授信额度
     */
    public void setCreditClass(String creditClass) {
        this.creditClass = creditClass == null ? null : creditClass.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 节点类型：1-根节点；2-子节点
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * CHAR(1)<br>
     * 设置 节点类型：1-根节点；2-子节点
     */
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 额度编号
     */
    public String getCreditNo() {
        return creditNo;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 额度编号
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 上级额度编号
     */
    public String getUpCreditNo() {
        return upCreditNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 上级额度编号
     */
    public void setUpCreditNo(String upCreditNo) {
        this.upCreditNo = upCreditNo == null ? null : upCreditNo.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 交易对手客户号
     */
    public String getOtherCustcd() {
        return otherCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 交易对手客户号
     */
    public void setOtherCustcd(String otherCustcd) {
        this.otherCustcd = otherCustcd == null ? null : otherCustcd.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * CHAR(3)<br>
     * 设置 币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否循环：0-非循环；1-循环；
     */
    public String getControlType() {
        return controlType;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否循环：0-非循环；1-循环；
     */
    public void setControlType(String controlType) {
        this.controlType = controlType == null ? null : controlType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 额度金额
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 额度金额
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可用额度=总额度-预占用额度-实占额度-冻结额度
     */
    public BigDecimal getCreditUsableAmount() {
        return creditUsableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可用额度=总额度-预占用额度-实占额度-冻结额度
     */
    public void setCreditUsableAmount(BigDecimal creditUsableAmount) {
        this.creditUsableAmount = creditUsableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 预占额度
     */
    public BigDecimal getPreUsedAmount() {
        return preUsedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 预占额度
     */
    public void setPreUsedAmount(BigDecimal preUsedAmount) {
        this.preUsedAmount = preUsedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已用额度
     */
    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已用额度
     */
    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 冻结额度
     */
    public BigDecimal getFrzAmount() {
        return frzAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 冻结额度
     */
    public void setFrzAmount(BigDecimal frzAmount) {
        this.frzAmount = frzAmount;
    }

    /**
     * CHAR(1)<br>
     * 获得 状态：1-正常，2-终止
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态：1-正常，2-终止
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 额度生效日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 额度生效日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 额度到期日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 额度到期日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 审批书编号
     */
    public String getApprovalNo() {
        return approvalNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 审批书编号
     */
    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo == null ? null : approvalNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否要求领用审批：1-是、0-否
     */
    public String getIsNeedAudit() {
        return isNeedAudit;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否要求领用审批：1-是、0-否
     */
    public void setIsNeedAudit(String isNeedAudit) {
        this.isNeedAudit = isNeedAudit == null ? null : isNeedAudit.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 审批类型：1-直接授予、2-间接授予
     */
    public String getApproveType() {
        return approveType;
    }

    /**
     * CHAR(1)<br>
     * 设置 审批类型：1-直接授予、2-间接授予
     */
    public void setApproveType(String approveType) {
        this.approveType = approveType == null ? null : approveType.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(20)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(20)<br>
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
        sb.append(", appno=").append(appno);
        sb.append(", creditClass=").append(creditClass);
        sb.append(", creditType=").append(creditType);
        sb.append(", nodeType=").append(nodeType);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", upCreditNo=").append(upCreditNo);
        sb.append(", custcd=").append(custcd);
        sb.append(", otherCustcd=").append(otherCustcd);
        sb.append(", curcd=").append(curcd);
        sb.append(", controlType=").append(controlType);
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", creditUsableAmount=").append(creditUsableAmount);
        sb.append(", preUsedAmount=").append(preUsedAmount);
        sb.append(", usedAmount=").append(usedAmount);
        sb.append(", frzAmount=").append(frzAmount);
        sb.append(", status=").append(status);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", approvalNo=").append(approvalNo);
        sb.append(", isNeedAudit=").append(isNeedAudit);
        sb.append(", approveType=").append(approveType);
        sb.append(", remark=").append(remark);
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
        BIcrAppliInfo other = (BIcrAppliInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCreditClass() == null ? other.getCreditClass() == null : this.getCreditClass().equals(other.getCreditClass()))
            && (this.getCreditType() == null ? other.getCreditType() == null : this.getCreditType().equals(other.getCreditType()))
            && (this.getNodeType() == null ? other.getNodeType() == null : this.getNodeType().equals(other.getNodeType()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getUpCreditNo() == null ? other.getUpCreditNo() == null : this.getUpCreditNo().equals(other.getUpCreditNo()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getOtherCustcd() == null ? other.getOtherCustcd() == null : this.getOtherCustcd().equals(other.getOtherCustcd()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getControlType() == null ? other.getControlType() == null : this.getControlType().equals(other.getControlType()))
            && (this.getCreditAmount() == null ? other.getCreditAmount() == null : this.getCreditAmount().equals(other.getCreditAmount()))
            && (this.getCreditUsableAmount() == null ? other.getCreditUsableAmount() == null : this.getCreditUsableAmount().equals(other.getCreditUsableAmount()))
            && (this.getPreUsedAmount() == null ? other.getPreUsedAmount() == null : this.getPreUsedAmount().equals(other.getPreUsedAmount()))
            && (this.getUsedAmount() == null ? other.getUsedAmount() == null : this.getUsedAmount().equals(other.getUsedAmount()))
            && (this.getFrzAmount() == null ? other.getFrzAmount() == null : this.getFrzAmount().equals(other.getFrzAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getApprovalNo() == null ? other.getApprovalNo() == null : this.getApprovalNo().equals(other.getApprovalNo()))
            && (this.getIsNeedAudit() == null ? other.getIsNeedAudit() == null : this.getIsNeedAudit().equals(other.getIsNeedAudit()))
            && (this.getApproveType() == null ? other.getApproveType() == null : this.getApproveType().equals(other.getApproveType()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getCreditClass() == null) ? 0 : getCreditClass().hashCode());
        result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
        result = prime * result + ((getNodeType() == null) ? 0 : getNodeType().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getUpCreditNo() == null) ? 0 : getUpCreditNo().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getOtherCustcd() == null) ? 0 : getOtherCustcd().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getControlType() == null) ? 0 : getControlType().hashCode());
        result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
        result = prime * result + ((getCreditUsableAmount() == null) ? 0 : getCreditUsableAmount().hashCode());
        result = prime * result + ((getPreUsedAmount() == null) ? 0 : getPreUsedAmount().hashCode());
        result = prime * result + ((getUsedAmount() == null) ? 0 : getUsedAmount().hashCode());
        result = prime * result + ((getFrzAmount() == null) ? 0 : getFrzAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getApprovalNo() == null) ? 0 : getApprovalNo().hashCode());
        result = prime * result + ((getIsNeedAudit() == null) ? 0 : getIsNeedAudit().hashCode());
        result = prime * result + ((getApproveType() == null) ? 0 : getApproveType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}