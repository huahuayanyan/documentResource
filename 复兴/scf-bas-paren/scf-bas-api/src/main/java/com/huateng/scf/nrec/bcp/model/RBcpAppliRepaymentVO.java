package com.huateng.scf.nrec.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>RBcpAppliRepayment实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年1月7日下午1:10:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年1月7日下午1:10:13	     新增
 *
 * </pre>
 */
public class RBcpAppliRepaymentVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 申请号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 回款流水号
     */
    private String returnId;

    /**
     * VARCHAR(20)<br>
     * 供应链借据号
     */
    private String debetNo;

    /**
     * DECIMAL(16,2)<br>
     * 溢出金额
     */
    private BigDecimal amountOver;

    /**
     * CHAR(2)<br>
     * 还款方式
     */
    private String returnType;

    /**
     * VARCHAR(1)<br>
     * 还款类型
     */
    private String returnMethod;

    /**
     * DECIMAL(16,2)<br>
     * 入结算户金额
     */
    private BigDecimal toSallerAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入现金池金额
     */
    private BigDecimal toPoolAmount;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(20)<br>
     * 贷款申请编码
     */
    private String debtAppno;

    /**
     * CHAR(3)<br>
     * 币别
     */
    private String curcd;

    /**
     * CHAR(8)<br>
     * 通用日期
     */
    private String commonDate;

    /**
     * VARCHAR(32)<br>
     * 操作员ID
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 登记机构
     */
    private String brcode;

    /**
     * DECIMAL(16,2)<br>
     * 还息金额
     */
    private BigDecimal repayIntamt;

    /**
     * DECIMAL(16,2)<br>
     * 还本金额
     */
    private BigDecimal repayBalamt;

    /**
     * DECIMAL(16,2)<br>
     * 还款金额
     */
    private BigDecimal repayAmount;

    /**
     * CHAR(8)<br>
     * 还款日期
     */
    private String repayDate;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 贷借据号
     */
    private String debetId;

    /**
     * DECIMAL(16,2)<br>
     * 入账金额
     */
    private BigDecimal payAmount;

    /**
     * VARCHAR(50)<br>
     * 保证金账号
     */
    private String accountNo;

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
     * VARCHAR(20)<br>
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 回款流水号
     */
    public String getReturnId() {
        return returnId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 回款流水号
     */
    public void setReturnId(String returnId) {
        this.returnId = returnId == null ? null : returnId.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 供应链借据号
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 供应链借据号
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 溢出金额
     */
    public BigDecimal getAmountOver() {
        return amountOver;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 溢出金额
     */
    public void setAmountOver(BigDecimal amountOver) {
        this.amountOver = amountOver;
    }

    /**
     * CHAR(2)<br>
     * 获得 还款方式
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * CHAR(2)<br>
     * 设置 还款方式
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    /**
     * VARCHAR(1)<br>
     * 获得 还款类型
     */
    public String getReturnMethod() {
        return returnMethod;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 还款类型
     */
    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod == null ? null : returnMethod.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入结算户金额
     */
    public BigDecimal getToSallerAmount() {
        return toSallerAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入结算户金额
     */
    public void setToSallerAmount(BigDecimal toSallerAmount) {
        this.toSallerAmount = toSallerAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入现金池金额
     */
    public BigDecimal getToPoolAmount() {
        return toPoolAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入现金池金额
     */
    public void setToPoolAmount(BigDecimal toPoolAmount) {
        this.toPoolAmount = toPoolAmount;
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
     * VARCHAR(20)<br>
     * 获得 贷款申请编码
     */
    public String getDebtAppno() {
        return debtAppno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 贷款申请编码
     */
    public void setDebtAppno(String debtAppno) {
        this.debtAppno = debtAppno == null ? null : debtAppno.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 币别
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * CHAR(3)<br>
     * 设置 币别
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 通用日期
     */
    public String getCommonDate() {
        return commonDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 通用日期
     */
    public void setCommonDate(String commonDate) {
        this.commonDate = commonDate == null ? null : commonDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 操作员ID
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 操作员ID
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还息金额
     */
    public BigDecimal getRepayIntamt() {
        return repayIntamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还息金额
     */
    public void setRepayIntamt(BigDecimal repayIntamt) {
        this.repayIntamt = repayIntamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还本金额
     */
    public BigDecimal getRepayBalamt() {
        return repayBalamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还本金额
     */
    public void setRepayBalamt(BigDecimal repayBalamt) {
        this.repayBalamt = repayBalamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还款金额
     */
    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还款金额
     */
    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    /**
     * CHAR(8)<br>
     * 获得 还款日期
     */
    public String getRepayDate() {
        return repayDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 还款日期
     */
    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate == null ? null : repayDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 主合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 主合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 贷借据号
     */
    public String getDebetId() {
        return debetId;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 贷借据号
     */
    public void setDebetId(String debetId) {
        this.debetId = debetId == null ? null : debetId.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入账金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入账金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
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
        sb.append(", appno=").append(appno);
        sb.append(", returnId=").append(returnId);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", amountOver=").append(amountOver);
        sb.append(", returnType=").append(returnType);
        sb.append(", returnMethod=").append(returnMethod);
        sb.append(", toSallerAmount=").append(toSallerAmount);
        sb.append(", toPoolAmount=").append(toPoolAmount);
        sb.append(", custcd=").append(custcd);
        sb.append(", debtAppno=").append(debtAppno);
        sb.append(", curcd=").append(curcd);
        sb.append(", commonDate=").append(commonDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", repayIntamt=").append(repayIntamt);
        sb.append(", repayBalamt=").append(repayBalamt);
        sb.append(", repayAmount=").append(repayAmount);
        sb.append(", repayDate=").append(repayDate);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", debetId=").append(debetId);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", accountNo=").append(accountNo);
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
        RBcpAppliRepaymentVO other = (RBcpAppliRepaymentVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getReturnId() == null ? other.getReturnId() == null : this.getReturnId().equals(other.getReturnId()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getAmountOver() == null ? other.getAmountOver() == null : this.getAmountOver().equals(other.getAmountOver()))
            && (this.getReturnType() == null ? other.getReturnType() == null : this.getReturnType().equals(other.getReturnType()))
            && (this.getReturnMethod() == null ? other.getReturnMethod() == null : this.getReturnMethod().equals(other.getReturnMethod()))
            && (this.getToSallerAmount() == null ? other.getToSallerAmount() == null : this.getToSallerAmount().equals(other.getToSallerAmount()))
            && (this.getToPoolAmount() == null ? other.getToPoolAmount() == null : this.getToPoolAmount().equals(other.getToPoolAmount()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getDebtAppno() == null ? other.getDebtAppno() == null : this.getDebtAppno().equals(other.getDebtAppno()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getRepayIntamt() == null ? other.getRepayIntamt() == null : this.getRepayIntamt().equals(other.getRepayIntamt()))
            && (this.getRepayBalamt() == null ? other.getRepayBalamt() == null : this.getRepayBalamt().equals(other.getRepayBalamt()))
            && (this.getRepayAmount() == null ? other.getRepayAmount() == null : this.getRepayAmount().equals(other.getRepayAmount()))
            && (this.getRepayDate() == null ? other.getRepayDate() == null : this.getRepayDate().equals(other.getRepayDate()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getReturnId() == null) ? 0 : getReturnId().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getAmountOver() == null) ? 0 : getAmountOver().hashCode());
        result = prime * result + ((getReturnType() == null) ? 0 : getReturnType().hashCode());
        result = prime * result + ((getReturnMethod() == null) ? 0 : getReturnMethod().hashCode());
        result = prime * result + ((getToSallerAmount() == null) ? 0 : getToSallerAmount().hashCode());
        result = prime * result + ((getToPoolAmount() == null) ? 0 : getToPoolAmount().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getDebtAppno() == null) ? 0 : getDebtAppno().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getRepayIntamt() == null) ? 0 : getRepayIntamt().hashCode());
        result = prime * result + ((getRepayBalamt() == null) ? 0 : getRepayBalamt().hashCode());
        result = prime * result + ((getRepayAmount() == null) ? 0 : getRepayAmount().hashCode());
        result = prime * result + ((getRepayDate() == null) ? 0 : getRepayDate().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }
}