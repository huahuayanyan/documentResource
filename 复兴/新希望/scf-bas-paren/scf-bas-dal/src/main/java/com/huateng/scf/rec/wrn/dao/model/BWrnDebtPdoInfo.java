package com.huateng.scf.rec.wrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWrnDebtPdoInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 预警基表标识
     */
    private String warnId;

    /**
     * CHAR(2)<br>
     * 凭证类型
     */
    private String billsType;

    /**
     * VARCHAR(100)<br>
     * 凭证编号
     */
    private String billsNo;

    /**
     * VARCHAR(50)<br>
     * 商务合同号
     */
    private String bussContcode;

    /**
     * CHAR(8)<br>
     * 应收账款日期
     */
    private String billsDate;

    /**
     * CHAR(8)<br>
     * 到期日
     */
    private String debtEnd;

    /**
     * CHAR(8)<br>
     * 最迟付款日
     */
    private String deadline;

    /**
     * DECIMAL(16,2)<br>
     * 账面金额
     */
    private BigDecimal billsAmountView;

    /**
     * DECIMAL(16,2)<br>
     * 有效金额
     */
    private BigDecimal billsAmount;

    /**
     * DECIMAL(16,2)<br>
     * 应收账款余额
     */
    private BigDecimal remainingAmount;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(2)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

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
     * 获得 预警基表标识
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 预警基表标识
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId == null ? null : warnId.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 凭证类型
     */
    public String getBillsType() {
        return billsType;
    }

    /**
     * CHAR(2)<br>
     * 设置 凭证类型
     */
    public void setBillsType(String billsType) {
        this.billsType = billsType == null ? null : billsType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 凭证编号
     */
    public String getBillsNo() {
        return billsNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 凭证编号
     */
    public void setBillsNo(String billsNo) {
        this.billsNo = billsNo == null ? null : billsNo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 商务合同号
     */
    public String getBussContcode() {
        return bussContcode;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 商务合同号
     */
    public void setBussContcode(String bussContcode) {
        this.bussContcode = bussContcode == null ? null : bussContcode.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 应收账款日期
     */
    public String getBillsDate() {
        return billsDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 应收账款日期
     */
    public void setBillsDate(String billsDate) {
        this.billsDate = billsDate == null ? null : billsDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 到期日
     */
    public String getDebtEnd() {
        return debtEnd;
    }

    /**
     * CHAR(8)<br>
     * 设置 到期日
     */
    public void setDebtEnd(String debtEnd) {
        this.debtEnd = debtEnd == null ? null : debtEnd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 最迟付款日
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * CHAR(8)<br>
     * 设置 最迟付款日
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 账面金额
     */
    public BigDecimal getBillsAmountView() {
        return billsAmountView;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 账面金额
     */
    public void setBillsAmountView(BigDecimal billsAmountView) {
        this.billsAmountView = billsAmountView;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 有效金额
     */
    public BigDecimal getBillsAmount() {
        return billsAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 有效金额
     */
    public void setBillsAmount(BigDecimal billsAmount) {
        this.billsAmount = billsAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收账款余额
     */
    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收账款余额
     */
    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
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
     * CHAR(2)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(2)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warnId=").append(warnId);
        sb.append(", billsType=").append(billsType);
        sb.append(", billsNo=").append(billsNo);
        sb.append(", bussContcode=").append(bussContcode);
        sb.append(", billsDate=").append(billsDate);
        sb.append(", debtEnd=").append(debtEnd);
        sb.append(", deadline=").append(deadline);
        sb.append(", billsAmountView=").append(billsAmountView);
        sb.append(", billsAmount=").append(billsAmount);
        sb.append(", remainingAmount=").append(remainingAmount);
        sb.append(", curcd=").append(curcd);
        sb.append(", status=").append(status);
        sb.append(", memo=").append(memo);
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
        BWrnDebtPdoInfo other = (BWrnDebtPdoInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getBillsType() == null ? other.getBillsType() == null : this.getBillsType().equals(other.getBillsType()))
            && (this.getBillsNo() == null ? other.getBillsNo() == null : this.getBillsNo().equals(other.getBillsNo()))
            && (this.getBussContcode() == null ? other.getBussContcode() == null : this.getBussContcode().equals(other.getBussContcode()))
            && (this.getBillsDate() == null ? other.getBillsDate() == null : this.getBillsDate().equals(other.getBillsDate()))
            && (this.getDebtEnd() == null ? other.getDebtEnd() == null : this.getDebtEnd().equals(other.getDebtEnd()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getBillsAmountView() == null ? other.getBillsAmountView() == null : this.getBillsAmountView().equals(other.getBillsAmountView()))
            && (this.getBillsAmount() == null ? other.getBillsAmount() == null : this.getBillsAmount().equals(other.getBillsAmount()))
            && (this.getRemainingAmount() == null ? other.getRemainingAmount() == null : this.getRemainingAmount().equals(other.getRemainingAmount()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnId() == null) ? 0 : getWarnId().hashCode());
        result = prime * result + ((getBillsType() == null) ? 0 : getBillsType().hashCode());
        result = prime * result + ((getBillsNo() == null) ? 0 : getBillsNo().hashCode());
        result = prime * result + ((getBussContcode() == null) ? 0 : getBussContcode().hashCode());
        result = prime * result + ((getBillsDate() == null) ? 0 : getBillsDate().hashCode());
        result = prime * result + ((getDebtEnd() == null) ? 0 : getDebtEnd().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getBillsAmountView() == null) ? 0 : getBillsAmountView().hashCode());
        result = prime * result + ((getBillsAmount() == null) ? 0 : getBillsAmount().hashCode());
        result = prime * result + ((getRemainingAmount() == null) ? 0 : getRemainingAmount().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }
}