package com.huateng.scf.bas.lan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BLanLnciBuyBiz implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 业务编号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * VARCHAR(20)<br>
     * 购销合同表主键
     */
    private String tradeContno;

    /**
     * VARCHAR(200)<br>
     * 购销合同号
     */
    private String tradeContcode;

    /**
     * CHAR(8)<br>
     * 合同生效日
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 合同到期日
     */
    private String endDate;

    /**
     * DECIMAL(16,2)<br>
     * 合同金额
     */
    private BigDecimal contAmt;

    /**
     * DECIMAL(16,2)<br>
     * 累计出账金额
     */
    private BigDecimal accuLoanAmt;

    /**
     * DECIMAL(16,2)<br>
     * 本次出账金额
     */
    private BigDecimal loanAmt;

    /**
     * CHAR(8)<br>
     * 创建日期
     */
    private String insertDate;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额
     */
    private BigDecimal accuWithdrawAmt;

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
     * 获得 业务编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
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
     * 获得 购销合同表主键
     */
    public String getTradeContno() {
        return tradeContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 购销合同表主键
     */
    public void setTradeContno(String tradeContno) {
        this.tradeContno = tradeContno == null ? null : tradeContno.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 购销合同号
     */
    public String getTradeContcode() {
        return tradeContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 购销合同号
     */
    public void setTradeContcode(String tradeContcode) {
        this.tradeContcode = tradeContcode == null ? null : tradeContcode.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 合同生效日
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 合同生效日
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 合同到期日
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 合同到期日
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 合同金额
     */
    public BigDecimal getContAmt() {
        return contAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 合同金额
     */
    public void setContAmt(BigDecimal contAmt) {
        this.contAmt = contAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计出账金额
     */
    public BigDecimal getAccuLoanAmt() {
        return accuLoanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计出账金额
     */
    public void setAccuLoanAmt(BigDecimal accuLoanAmt) {
        this.accuLoanAmt = accuLoanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次出账金额
     */
    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次出账金额
     */
    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    /**
     * CHAR(8)<br>
     * 获得 创建日期
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 创建日期
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate == null ? null : insertDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额
     */
    public BigDecimal getAccuWithdrawAmt() {
        return accuWithdrawAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额
     */
    public void setAccuWithdrawAmt(BigDecimal accuWithdrawAmt) {
        this.accuWithdrawAmt = accuWithdrawAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", tradeContno=").append(tradeContno);
        sb.append(", tradeContcode=").append(tradeContcode);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", contAmt=").append(contAmt);
        sb.append(", accuLoanAmt=").append(accuLoanAmt);
        sb.append(", loanAmt=").append(loanAmt);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", accuWithdrawAmt=").append(accuWithdrawAmt);
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
        BLanLnciBuyBiz other = (BLanLnciBuyBiz) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
            && (this.getTradeContcode() == null ? other.getTradeContcode() == null : this.getTradeContcode().equals(other.getTradeContcode()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getContAmt() == null ? other.getContAmt() == null : this.getContAmt().equals(other.getContAmt()))
            && (this.getAccuLoanAmt() == null ? other.getAccuLoanAmt() == null : this.getAccuLoanAmt().equals(other.getAccuLoanAmt()))
            && (this.getLoanAmt() == null ? other.getLoanAmt() == null : this.getLoanAmt().equals(other.getLoanAmt()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getAccuWithdrawAmt() == null ? other.getAccuWithdrawAmt() == null : this.getAccuWithdrawAmt().equals(other.getAccuWithdrawAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
        result = prime * result + ((getTradeContcode() == null) ? 0 : getTradeContcode().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getContAmt() == null) ? 0 : getContAmt().hashCode());
        result = prime * result + ((getAccuLoanAmt() == null) ? 0 : getAccuLoanAmt().hashCode());
        result = prime * result + ((getLoanAmt() == null) ? 0 : getLoanAmt().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getAccuWithdrawAmt() == null) ? 0 : getAccuWithdrawAmt().hashCode());
        return result;
    }
}