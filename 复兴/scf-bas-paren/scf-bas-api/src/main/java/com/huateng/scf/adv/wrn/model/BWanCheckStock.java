package com.huateng.scf.adv.wrn.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWanCheckStock implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 预警主表标识
     */
    private String warnId;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(200)<br>
     * 质押合同号
     */
    private String slaveContcode;

    /**
     * VARCHAR(15)<br>
     * 出质人客户号
     */
    private String custcd;

    /**
     * VARCHAR(80)<br>
     * 出质人名称
     */
    private String cname;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniCustcd;

    /**
     * VARCHAR(80)<br>
     * 监管公司名称
     */
    private String moniCname;

    /**
     * VARCHAR(20)<br>
     * 监管合同号
     */
    private String protocolNo;

    /**
     * DECIMAL(16,2)<br>
     * 押品总价值
     */
    private BigDecimal mortAmt;

    /**
     * DECIMAL(16,2)<br>
     * 对账金额
     */
    private BigDecimal checkAmt;

    /**
     * CHAR(8)<br>
     * 对账发起日
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 对账确认日
     */
    private String confirmDate;

    /**
     * VARCHAR(10)<br>
     * 对账方式
     */
    private String checkType;

    /**
     * VARCHAR(10)<br>
     * 对账结果：01-通过、02-不通过
     */
    private String checkResult;

    /**
     * VARCHAR(10)<br>
     * 对账状态：01-对账中、02-对账完成
     */
    private String checkStatus;

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
     * VARCHAR(32)<br>
     * 获得 预警主表标识
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 预警主表标识
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId == null ? null : warnId.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 质押合同号
     */
    public String getSlaveContcode() {
        return slaveContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 质押合同号
     */
    public void setSlaveContcode(String slaveContcode) {
        this.slaveContcode = slaveContcode == null ? null : slaveContcode.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 出质人客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 出质人客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 出质人名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 出质人名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 监管公司名称
     */
    public String getMoniCname() {
        return moniCname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 监管公司名称
     */
    public void setMoniCname(String moniCname) {
        this.moniCname = moniCname == null ? null : moniCname.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管合同号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管合同号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 押品总价值
     */
    public BigDecimal getMortAmt() {
        return mortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 押品总价值
     */
    public void setMortAmt(BigDecimal mortAmt) {
        this.mortAmt = mortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 对账金额
     */
    public BigDecimal getCheckAmt() {
        return checkAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 对账金额
     */
    public void setCheckAmt(BigDecimal checkAmt) {
        this.checkAmt = checkAmt;
    }

    /**
     * CHAR(8)<br>
     * 获得 对账发起日
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 对账发起日
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 对账确认日
     */
    public String getConfirmDate() {
        return confirmDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 对账确认日
     */
    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate == null ? null : confirmDate.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 对账方式
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账方式
     */
    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 对账结果：01-通过、02-不通过
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账结果：01-通过、02-不通过
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 对账状态：01-对账中、02-对账完成
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账状态：01-对账中、02-对账完成
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warnId=").append(warnId);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", slaveContcode=").append(slaveContcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", cname=").append(cname);
        sb.append(", moniCustcd=").append(moniCustcd);
        sb.append(", moniCname=").append(moniCname);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", mortAmt=").append(mortAmt);
        sb.append(", checkAmt=").append(checkAmt);
        sb.append(", startDate=").append(startDate);
        sb.append(", confirmDate=").append(confirmDate);
        sb.append(", checkType=").append(checkType);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", checkStatus=").append(checkStatus);
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
        BWanCheckStock other = (BWanCheckStock) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getSlaveContcode() == null ? other.getSlaveContcode() == null : this.getSlaveContcode().equals(other.getSlaveContcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getMoniCustcd() == null ? other.getMoniCustcd() == null : this.getMoniCustcd().equals(other.getMoniCustcd()))
            && (this.getMoniCname() == null ? other.getMoniCname() == null : this.getMoniCname().equals(other.getMoniCname()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getMortAmt() == null ? other.getMortAmt() == null : this.getMortAmt().equals(other.getMortAmt()))
            && (this.getCheckAmt() == null ? other.getCheckAmt() == null : this.getCheckAmt().equals(other.getCheckAmt()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getConfirmDate() == null ? other.getConfirmDate() == null : this.getConfirmDate().equals(other.getConfirmDate()))
            && (this.getCheckType() == null ? other.getCheckType() == null : this.getCheckType().equals(other.getCheckType()))
            && (this.getCheckResult() == null ? other.getCheckResult() == null : this.getCheckResult().equals(other.getCheckResult()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnId() == null) ? 0 : getWarnId().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getSlaveContcode() == null) ? 0 : getSlaveContcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
        result = prime * result + ((getMoniCname() == null) ? 0 : getMoniCname().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getMortAmt() == null) ? 0 : getMortAmt().hashCode());
        result = prime * result + ((getCheckAmt() == null) ? 0 : getCheckAmt().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getConfirmDate() == null) ? 0 : getConfirmDate().hashCode());
        result = prime * result + ((getCheckType() == null) ? 0 : getCheckType().hashCode());
        result = prime * result + ((getCheckResult() == null) ? 0 : getCheckResult().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        return result;
    }
}