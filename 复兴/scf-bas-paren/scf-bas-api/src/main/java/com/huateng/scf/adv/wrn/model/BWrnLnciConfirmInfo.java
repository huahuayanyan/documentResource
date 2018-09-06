package com.huateng.scf.adv.wrn.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWrnLnciConfirmInfo implements Serializable {
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
     * VARCHAR(2)<br>
     * 出账方式：01-流贷、02-银承
     */
    private String loanWay;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * VARCHAR(20)<br>
     * 借据号
     */
    private String debetId;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(16,2)<br>
     * 出账金额
     */
    private BigDecimal loanAmt;

    /**
     * CHAR(8)<br>
     * 出账日期
     */
    private String loanDate;

    /**
     * CHAR(8)<br>
     * 出账到期日
     */
    private String endDate;

    /**
     * CHAR(1)<br>
     * 收款确认状态：0-未收款确认、1-已收款确认
     */
    private String confirmStaus;

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
     * VARCHAR(2)<br>
     * 获得 出账方式：01-流贷、02-银承
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 出账方式：01-流贷、02-银承
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay == null ? null : loanWay.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 借据表主键
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 借据表主键
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 借据号
     */
    public String getDebetId() {
        return debetId;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 借据号
     */
    public void setDebetId(String debetId) {
        this.debetId = debetId == null ? null : debetId.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 出账金额
     */
    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 出账金额
     */
    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    /**
     * CHAR(8)<br>
     * 获得 出账日期
     */
    public String getLoanDate() {
        return loanDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 出账日期
     */
    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate == null ? null : loanDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 出账到期日
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 出账到期日
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 收款确认状态：0-未收款确认、1-已收款确认
     */
    public String getConfirmStaus() {
        return confirmStaus;
    }

    /**
     * CHAR(1)<br>
     * 设置 收款确认状态：0-未收款确认、1-已收款确认
     */
    public void setConfirmStaus(String confirmStaus) {
        this.confirmStaus = confirmStaus == null ? null : confirmStaus.trim();
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
        sb.append(", loanWay=").append(loanWay);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", debetId=").append(debetId);
        sb.append(", curcd=").append(curcd);
        sb.append(", loanAmt=").append(loanAmt);
        sb.append(", loanDate=").append(loanDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", confirmStaus=").append(confirmStaus);
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
        BWrnLnciConfirmInfo other = (BWrnLnciConfirmInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getCustcdSeller() == null ? other.getCustcdSeller() == null : this.getCustcdSeller().equals(other.getCustcdSeller()))
            && (this.getCnameSeller() == null ? other.getCnameSeller() == null : this.getCnameSeller().equals(other.getCnameSeller()))
            && (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
            && (this.getCnameBuyer() == null ? other.getCnameBuyer() == null : this.getCnameBuyer().equals(other.getCnameBuyer()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getLoanAmt() == null ? other.getLoanAmt() == null : this.getLoanAmt().equals(other.getLoanAmt()))
            && (this.getLoanDate() == null ? other.getLoanDate() == null : this.getLoanDate().equals(other.getLoanDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getConfirmStaus() == null ? other.getConfirmStaus() == null : this.getConfirmStaus().equals(other.getConfirmStaus()));
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
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getLoanAmt() == null) ? 0 : getLoanAmt().hashCode());
        result = prime * result + ((getLoanDate() == null) ? 0 : getLoanDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getConfirmStaus() == null) ? 0 : getConfirmStaus().hashCode());
        return result;
    }
}