package com.huateng.scf.adv.wrn.dao.model;

import java.io.Serializable;

public class BWanMortCheckInfo implements Serializable {
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
     * VARCHAR(15)<br>
     * 卖方客户号
     */
    private String custcdSeller;

    /**
     * VARCHAR(80)<br>
     * 卖方名称
     */
    private String cnameSeller;

    /**
     * VARCHAR(15)<br>
     * 买方客户号
     */
    private String custcdBuyer;

    /**
     * VARCHAR(80)<br>
     * 买方名称
     */
    private String cnameBuyer;

    /**
     * VARCHAR(20)<br>
     * 担保提货、先票/款后货协议
     */
    private String protocolNo;

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
     * 对账方式：01-银行发起、05-上游客户发起
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
     * VARCHAR(15)<br>
     * 获得 卖方客户号
     */
    public String getCustcdSeller() {
        return custcdSeller;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 卖方客户号
     */
    public void setCustcdSeller(String custcdSeller) {
        this.custcdSeller = custcdSeller == null ? null : custcdSeller.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 卖方名称
     */
    public String getCnameSeller() {
        return cnameSeller;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 卖方名称
     */
    public void setCnameSeller(String cnameSeller) {
        this.cnameSeller = cnameSeller == null ? null : cnameSeller.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 买方客户号
     */
    public String getCustcdBuyer() {
        return custcdBuyer;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 买方客户号
     */
    public void setCustcdBuyer(String custcdBuyer) {
        this.custcdBuyer = custcdBuyer == null ? null : custcdBuyer.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 买方名称
     */
    public String getCnameBuyer() {
        return cnameBuyer;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 买方名称
     */
    public void setCnameBuyer(String cnameBuyer) {
        this.cnameBuyer = cnameBuyer == null ? null : cnameBuyer.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 担保提货、先票/款后货协议
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 担保提货、先票/款后货协议
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
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
     * 获得 对账方式：01-银行发起、05-上游客户发起
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账方式：01-银行发起、05-上游客户发起
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
        sb.append(", custcdSeller=").append(custcdSeller);
        sb.append(", cnameSeller=").append(cnameSeller);
        sb.append(", custcdBuyer=").append(custcdBuyer);
        sb.append(", cnameBuyer=").append(cnameBuyer);
        sb.append(", protocolNo=").append(protocolNo);
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
        BWanMortCheckInfo other = (BWanMortCheckInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getCustcdSeller() == null ? other.getCustcdSeller() == null : this.getCustcdSeller().equals(other.getCustcdSeller()))
            && (this.getCnameSeller() == null ? other.getCnameSeller() == null : this.getCnameSeller().equals(other.getCnameSeller()))
            && (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
            && (this.getCnameBuyer() == null ? other.getCnameBuyer() == null : this.getCnameBuyer().equals(other.getCnameBuyer()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
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
        result = prime * result + ((getCustcdSeller() == null) ? 0 : getCustcdSeller().hashCode());
        result = prime * result + ((getCnameSeller() == null) ? 0 : getCnameSeller().hashCode());
        result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
        result = prime * result + ((getCnameBuyer() == null) ? 0 : getCnameBuyer().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getConfirmDate() == null) ? 0 : getConfirmDate().hashCode());
        result = prime * result + ((getCheckType() == null) ? 0 : getCheckType().hashCode());
        result = prime * result + ((getCheckResult() == null) ? 0 : getCheckResult().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        return result;
    }
}