package com.huateng.scf.bas.mrn.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * <p>BMrnAppliAcctInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年1月10日下午3:58:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年1月10日下午3:58:05	     新增
 *
 * </pre>
 */
public class BMrnAppliAcctInfo extends BMrnAppliAcctExt implements Serializable {
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
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(50)<br>
     * 保证金账号
     */
    private String bailAccountno;

    /**
     * VARCHAR(2)<br>
     * 保证金等价物类型：01-存单;02-银票;03-保证金
     */
    private String bailType;

    /**
     * CHAR(2)<br>
     * 保证金及现金等价物确认状态：01-已确认;02-未确认;03-已解押;04-解押中
     */
    private String confirmStatus;

    /**
     * DECIMAL(16,2)<br>
     * 保证金或现金等价物登记金额
     */
    private BigDecimal bailAmount;

    /**
     * DECIMAL(6,2)<br>
     * 保证金比例
     */
    private BigDecimal bailRate;

    /**
     * VARCHAR(100)<br>
     * 账号名称
     */
    private String accountName;

    /**
     * CHAR(1)<br>
     * 账户类型
     */
    private String accountType;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(50)<br>
     * 账号
     */
    private String accountNo;

    /**
     * DECIMAL(16,2)<br>
     * 业务发生额
     */
    private BigDecimal amount;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String protocolNo;

    /**
     * VARCHAR(2)<br>
     * 保证金初始化类型：01-初始;02-追加;03-最高额
     */
    private String initType;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * DECIMAL(16,2)<br>
     * 入账金额
     */
    private BigDecimal payAmount;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(10)<br>
     * 保证金账户性质：活期、定期
     */
    private String bailAcctAttr;

    /**
     * DECIMAL(10,6)<br>
     * 冻结保证金比例
     */
    private BigDecimal bailFrozenPercent;

    /**
     * DECIMAL(16,2)<br>
     * 冻结保证金金额
     */
    private BigDecimal bailFrozenAmt;

    private BigDecimal npsBailAmount;

    /**
     * VARCHAR(32)<br>
     * 票据ID
     */
    private String billId;

    /**
     * VARCHAR(100)<br>
     * 票据号码
     */
    private String billNo;

    /**
     * VARCHAR(10)<br>
     * 子帐号序号
     */
    private String subAcctSeqno;

    /**
     * VARCHAR(50)<br>
     * 保证金冻结编号
     */
    private String bailFrozenNo;

    /**
     * VARCHAR(20)<br>
     * 账务机构
     */
    private String actBrCd;

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
     * VARCHAR(50)<br>
     * 获得 保证金账号
     */
    public String getBailAccountno() {
        return bailAccountno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金账号
     */
    public void setBailAccountno(String bailAccountno) {
        this.bailAccountno = bailAccountno == null ? null : bailAccountno.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保证金等价物类型：01-存单;02-银票;03-保证金
     */
    public String getBailType() {
        return bailType;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保证金等价物类型：01-存单;02-银票;03-保证金
     */
    public void setBailType(String bailType) {
        this.bailType = bailType == null ? null : bailType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 保证金及现金等价物确认状态：01-已确认;02-未确认;03-已解押;04-解押中
     */
    public String getConfirmStatus() {
        return confirmStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 保证金及现金等价物确认状态：01-已确认;02-未确认;03-已解押;04-解押中
     */
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金或现金等价物登记金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金或现金等价物登记金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }

    /**
     * DECIMAL(6,2)<br>
     * 获得 保证金比例
     */
    public BigDecimal getBailRate() {
        return bailRate;
    }

    /**
     * DECIMAL(6,2)<br>
     * 设置 保证金比例
     */
    public void setBailRate(BigDecimal bailRate) {
        this.bailRate = bailRate;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 账号名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 账号名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 账户类型
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * CHAR(1)<br>
     * 设置 账户类型
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
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
     * VARCHAR(50)<br>
     * 获得 账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 业务发生额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 业务发生额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保证金初始化类型：01-初始;02-追加;03-最高额
     */
    public String getInitType() {
        return initType;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保证金初始化类型：01-初始;02-追加;03-最高额
     */
    public void setInitType(String initType) {
        this.initType = initType == null ? null : initType.trim();
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
     * VARCHAR(20)<br>
     * 获得 抵质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 抵质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 保证金账户性质：活期、定期
     */
    public String getBailAcctAttr() {
        return bailAcctAttr;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 保证金账户性质：活期、定期
     */
    public void setBailAcctAttr(String bailAcctAttr) {
        this.bailAcctAttr = bailAcctAttr == null ? null : bailAcctAttr.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 冻结保证金比例
     */
    public BigDecimal getBailFrozenPercent() {
        return bailFrozenPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 冻结保证金比例
     */
    public void setBailFrozenPercent(BigDecimal bailFrozenPercent) {
        this.bailFrozenPercent = bailFrozenPercent;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 冻结保证金金额
     */
    public BigDecimal getBailFrozenAmt() {
        return bailFrozenAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 冻结保证金金额
     */
    public void setBailFrozenAmt(BigDecimal bailFrozenAmt) {
        this.bailFrozenAmt = bailFrozenAmt;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 票据ID
     */
    public String getBillId() {
        return billId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 票据ID
     */
    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 票据号码
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 票据号码
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 子帐号序号
     */
    public String getSubAcctSeqno() {
        return subAcctSeqno;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 子帐号序号
     */
    public void setSubAcctSeqno(String subAcctSeqno) {
        this.subAcctSeqno = subAcctSeqno == null ? null : subAcctSeqno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金冻结编号
     */
    public String getBailFrozenNo() {
        return bailFrozenNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金冻结编号
     */
    public void setBailFrozenNo(String bailFrozenNo) {
        this.bailFrozenNo = bailFrozenNo == null ? null : bailFrozenNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 账务机构
     */
    public String getActBrCd() {
        return actBrCd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 账务机构
     */
    public void setActBrCd(String actBrCd) {
        this.actBrCd = actBrCd == null ? null : actBrCd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", custcd=").append(custcd);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", bailAccountno=").append(bailAccountno);
        sb.append(", bailType=").append(bailType);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", bailRate=").append(bailRate);
        sb.append(", accountName=").append(accountName);
        sb.append(", accountType=").append(accountType);
        sb.append(", curcd=").append(curcd);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", amount=").append(amount);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", initType=").append(initType);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", bailAcctAttr=").append(bailAcctAttr);
        sb.append(", bailFrozenPercent=").append(bailFrozenPercent);
        sb.append(", bailFrozenAmt=").append(bailFrozenAmt);
        sb.append(", billId=").append(billId);
        sb.append(", billNo=").append(billNo);
        sb.append(", subAcctSeqno=").append(subAcctSeqno);
        sb.append(", bailFrozenNo=").append(bailFrozenNo);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", tlrNm=").append(tlrNm);
        sb.append(", brCd=").append(brCd);
        sb.append(", brNm=").append(brNm);
        sb.append(", inpDt=").append(inpDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdTlrNm=").append(lstUpdTlrNm);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdBrNm=").append(lstUpdBrNm);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", actBrCd=").append(actBrCd);
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
        BMrnAppliAcctInfo other = (BMrnAppliAcctInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getBailAccountno() == null ? other.getBailAccountno() == null : this.getBailAccountno().equals(other.getBailAccountno()))
            && (this.getBailType() == null ? other.getBailType() == null : this.getBailType().equals(other.getBailType()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getBailRate() == null ? other.getBailRate() == null : this.getBailRate().equals(other.getBailRate()))
            && (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getInitType() == null ? other.getInitType() == null : this.getInitType().equals(other.getInitType()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getBailAcctAttr() == null ? other.getBailAcctAttr() == null : this.getBailAcctAttr().equals(other.getBailAcctAttr()))
            && (this.getBailFrozenPercent() == null ? other.getBailFrozenPercent() == null : this.getBailFrozenPercent().equals(other.getBailFrozenPercent()))
            && (this.getBailFrozenAmt() == null ? other.getBailFrozenAmt() == null : this.getBailFrozenAmt().equals(other.getBailFrozenAmt()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()))
            && (this.getSubAcctSeqno() == null ? other.getSubAcctSeqno() == null : this.getSubAcctSeqno().equals(other.getSubAcctSeqno()))
            && (this.getBailFrozenNo() == null ? other.getBailFrozenNo() == null : this.getBailFrozenNo().equals(other.getBailFrozenNo()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdTlrNm() == null ? other.getLstUpdTlrNm() == null : this.getLstUpdTlrNm().equals(other.getLstUpdTlrNm()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdBrNm() == null ? other.getLstUpdBrNm() == null : this.getLstUpdBrNm().equals(other.getLstUpdBrNm()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getActBrCd() == null ? other.getActBrCd() == null : this.getActBrCd().equals(other.getActBrCd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getBailAccountno() == null) ? 0 : getBailAccountno().hashCode());
        result = prime * result + ((getBailType() == null) ? 0 : getBailType().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getBailRate() == null) ? 0 : getBailRate().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getInitType() == null) ? 0 : getInitType().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getBailAcctAttr() == null) ? 0 : getBailAcctAttr().hashCode());
        result = prime * result + ((getBailFrozenPercent() == null) ? 0 : getBailFrozenPercent().hashCode());
        result = prime * result + ((getBailFrozenAmt() == null) ? 0 : getBailFrozenAmt().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        result = prime * result + ((getSubAcctSeqno() == null) ? 0 : getSubAcctSeqno().hashCode());
        result = prime * result + ((getBailFrozenNo() == null) ? 0 : getBailFrozenNo().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getTlrNm() == null) ? 0 : getTlrNm().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getBrNm() == null) ? 0 : getBrNm().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdTlrNm() == null) ? 0 : getLstUpdTlrNm().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdBrNm() == null) ? 0 : getLstUpdBrNm().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getActBrCd() == null) ? 0 : getActBrCd().hashCode());
        return result;
    }

	public BigDecimal getNpsBailAmount() {
		return npsBailAmount;
	}

	public void setNpsBailAmount(BigDecimal npsBailAmount) {
		this.npsBailAmount = npsBailAmount;
	}
}