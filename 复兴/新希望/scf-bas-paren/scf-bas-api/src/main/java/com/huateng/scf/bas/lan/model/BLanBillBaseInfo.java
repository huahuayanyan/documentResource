package com.huateng.scf.bas.lan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BLanBillBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 业务申请编号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 外系统票据标识
     */
    private String billId;

    /**
     * VARCHAR(100)<br>
     * 票据号码
     */
    private String billNo;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * CHAR(8)<br>
     * 创建日期
     */
    private String insertDate;

    /**
     * VARCHAR(10)<br>
     * 出票期限
     */
    private String loanDays;

    /**
     * CHAR(8)<br>
     * 出票日期
     */
    private String billDate;

    /**
     * CHAR(8)<br>
     * 票据到期日
     */
    private String billEndDate;

    /**
     * DECIMAL(16,2)<br>
     * 出票金额
     */
    private BigDecimal amount;

    /**
     * CHAR(8)<br>
     * 通用日期
     */
    private String commonDate;

    /**
     * VARCHAR(32)<br>
     * 经办人
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(15)<br>
     * 收款人客户号
     */
    private String receiver;

    /**
     * VARCHAR(80)<br>
     * 收款人名称
     */
    private String receiverName;

    /**
     * VARCHAR(100)<br>
     * 收款人开户行
     */
    private String brcodeName;

    /**
     * VARCHAR(50)<br>
     * 收款人账号
     */
    private String receiverAccount;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * VARCHAR(100)<br>
     * 出票人名称
     */
    private String drawer;

    /**
     * CHAR(1)<br>
     * 电票标识：1-纸票、2-电票
     */
    private String elecFlag;

    /**
     * VARCHAR(20)<br>
     * 借据号
     */
    private String debetId;

    /**
     * CHAR(1)<br>
     * 票据类型：1-银票、2-商票
     */
    private String billType;

    /**
     * VARCHAR(12)<br>
     * 收款人开户行行号
     */
    private String payeeBankno;

    /**
     * VARCHAR(100)<br>
     * 承兑人名称
     */
    private String acceptor;

    /**
     * VARCHAR(12)<br>
     * 承兑人开户行行号
     */
    private String acceptorBankno;

    /**
     * VARCHAR(50)<br>
     * 出票人开户帐户
     */
    private String drawerAccount;

    /**
     * VARCHAR(12)<br>
     * 出票人开户行行号
     */
    private String drawerBankno;

    /**
     * VARCHAR(50)<br>
     * 贸易合同号
     */
    private String bussContno;

    /**
     * CHAR(1)<br>
     * 是否票据池：0-否、1-是
     */
    private String poolFlag;

    /**
     * VARCHAR(40)<br>
     * 票据批次号
     */
    private String batchNo;

    /**
     * CHAR(1)<br>
     * 票据出入池状态 0-未入池;1-已入池;2-已出池
     */
    private String poolStatus;

    /**
     * CHAR(1)<br>
     * 票据业务标识：1-承兑、2-质押、3-贴现
     */
    private String busiFlag;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * VARCHAR(100)<br>
     * 付款行名称
     */
    private String payBank;

    /**
     * CHAR(1)<br>
     * 是否锁定：0-否、1-是
     */
    private String isLocked;

    /**
     * VARCHAR(20)<br>
     * 锁定业务申请号
     */
    private String lockAppno;

    /**
     * VARCHAR(40)<br>
     * 放款申请核心标识
     */
    private String loanNo;

    /**
     * DECIMAL(16,2)<br>
     * 折算价值
     */
    private BigDecimal conversionValue;

    /**
     * DECIMAL(9,6)<br>
     * 折算率（%）
     */
    private BigDecimal conversionRate;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 外系统票据标识
     */
    public String getBillId() {
        return billId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 外系统票据标识
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
     * VARCHAR(10)<br>
     * 获得 出票期限
     */
    public String getLoanDays() {
        return loanDays;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 出票期限
     */
    public void setLoanDays(String loanDays) {
        this.loanDays = loanDays == null ? null : loanDays.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 出票日期
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 出票日期
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 票据到期日
     */
    public String getBillEndDate() {
        return billEndDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 票据到期日
     */
    public void setBillEndDate(String billEndDate) {
        this.billEndDate = billEndDate == null ? null : billEndDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 出票金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 出票金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * 获得 经办人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 经办人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
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

    /**
     * CHAR(1)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 收款人客户号
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 收款人客户号
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 收款人名称
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 收款人名称
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 收款人开户行
     */
    public String getBrcodeName() {
        return brcodeName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 收款人开户行
     */
    public void setBrcodeName(String brcodeName) {
        this.brcodeName = brcodeName == null ? null : brcodeName.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 收款人账号
     */
    public String getReceiverAccount() {
        return receiverAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 收款人账号
     */
    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount == null ? null : receiverAccount.trim();
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
     * 获得 保证金金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 出票人名称
     */
    public String getDrawer() {
        return drawer;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 出票人名称
     */
    public void setDrawer(String drawer) {
        this.drawer = drawer == null ? null : drawer.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 电票标识：1-纸票、2-电票
     */
    public String getElecFlag() {
        return elecFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 电票标识：1-纸票、2-电票
     */
    public void setElecFlag(String elecFlag) {
        this.elecFlag = elecFlag == null ? null : elecFlag.trim();
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
     * CHAR(1)<br>
     * 获得 票据类型：1-银票、2-商票
     */
    public String getBillType() {
        return billType;
    }

    /**
     * CHAR(1)<br>
     * 设置 票据类型：1-银票、2-商票
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    /**
     * VARCHAR(12)<br>
     * 获得 收款人开户行行号
     */
    public String getPayeeBankno() {
        return payeeBankno;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 收款人开户行行号
     */
    public void setPayeeBankno(String payeeBankno) {
        this.payeeBankno = payeeBankno == null ? null : payeeBankno.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 承兑人名称
     */
    public String getAcceptor() {
        return acceptor;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 承兑人名称
     */
    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor == null ? null : acceptor.trim();
    }

    /**
     * VARCHAR(12)<br>
     * 获得 承兑人开户行行号
     */
    public String getAcceptorBankno() {
        return acceptorBankno;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 承兑人开户行行号
     */
    public void setAcceptorBankno(String acceptorBankno) {
        this.acceptorBankno = acceptorBankno == null ? null : acceptorBankno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 出票人开户帐户
     */
    public String getDrawerAccount() {
        return drawerAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 出票人开户帐户
     */
    public void setDrawerAccount(String drawerAccount) {
        this.drawerAccount = drawerAccount == null ? null : drawerAccount.trim();
    }

    /**
     * VARCHAR(12)<br>
     * 获得 出票人开户行行号
     */
    public String getDrawerBankno() {
        return drawerBankno;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 出票人开户行行号
     */
    public void setDrawerBankno(String drawerBankno) {
        this.drawerBankno = drawerBankno == null ? null : drawerBankno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 贸易合同号
     */
    public String getBussContno() {
        return bussContno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 贸易合同号
     */
    public void setBussContno(String bussContno) {
        this.bussContno = bussContno == null ? null : bussContno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否票据池：0-否、1-是
     */
    public String getPoolFlag() {
        return poolFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否票据池：0-否、1-是
     */
    public void setPoolFlag(String poolFlag) {
        this.poolFlag = poolFlag == null ? null : poolFlag.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 票据批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 票据批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 票据出入池状态 0-未入池;1-已入池;2-已出池
     */
    public String getPoolStatus() {
        return poolStatus;
    }

    /**
     * CHAR(1)<br>
     * 设置 票据出入池状态 0-未入池;1-已入池;2-已出池
     */
    public void setPoolStatus(String poolStatus) {
        this.poolStatus = poolStatus == null ? null : poolStatus.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 票据业务标识：1-承兑、2-质押、3-贴现
     */
    public String getBusiFlag() {
        return busiFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 票据业务标识：1-承兑、2-质押、3-贴现
     */
    public void setBusiFlag(String busiFlag) {
        this.busiFlag = busiFlag == null ? null : busiFlag.trim();
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
     * VARCHAR(100)<br>
     * 获得 付款行名称
     */
    public String getPayBank() {
        return payBank;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 付款行名称
     */
    public void setPayBank(String payBank) {
        this.payBank = payBank == null ? null : payBank.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否锁定：0-否、1-是
     */
    public String getIsLocked() {
        return isLocked;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否锁定：0-否、1-是
     */
    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked == null ? null : isLocked.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 锁定业务申请号
     */
    public String getLockAppno() {
        return lockAppno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 锁定业务申请号
     */
    public void setLockAppno(String lockAppno) {
        this.lockAppno = lockAppno == null ? null : lockAppno.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 放款申请核心标识
     */
    public String getLoanNo() {
        return loanNo;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 放款申请核心标识
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 折算价值
     */
    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 折算价值
     */
    public void setConversionValue(BigDecimal conversionValue) {
        this.conversionValue = conversionValue;
    }

    /**
     * DECIMAL(9,6)<br>
     * 获得 折算率（%）
     */
    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    /**
     * DECIMAL(9,6)<br>
     * 设置 折算率（%）
     */
    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", billId=").append(billId);
        sb.append(", billNo=").append(billNo);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", loanDays=").append(loanDays);
        sb.append(", billDate=").append(billDate);
        sb.append(", billEndDate=").append(billEndDate);
        sb.append(", amount=").append(amount);
        sb.append(", commonDate=").append(commonDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", memo=").append(memo);
        sb.append(", status=").append(status);
        sb.append(", receiver=").append(receiver);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", brcodeName=").append(brcodeName);
        sb.append(", receiverAccount=").append(receiverAccount);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", drawer=").append(drawer);
        sb.append(", elecFlag=").append(elecFlag);
        sb.append(", debetId=").append(debetId);
        sb.append(", billType=").append(billType);
        sb.append(", payeeBankno=").append(payeeBankno);
        sb.append(", acceptor=").append(acceptor);
        sb.append(", acceptorBankno=").append(acceptorBankno);
        sb.append(", drawerAccount=").append(drawerAccount);
        sb.append(", drawerBankno=").append(drawerBankno);
        sb.append(", bussContno=").append(bussContno);
        sb.append(", poolFlag=").append(poolFlag);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", poolStatus=").append(poolStatus);
        sb.append(", busiFlag=").append(busiFlag);
        sb.append(", productId=").append(productId);
        sb.append(", payBank=").append(payBank);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", lockAppno=").append(lockAppno);
        sb.append(", loanNo=").append(loanNo);
        sb.append(", conversionValue=").append(conversionValue);
        sb.append(", conversionRate=").append(conversionRate);
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
        BLanBillBaseInfo other = (BLanBillBaseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getLoanDays() == null ? other.getLoanDays() == null : this.getLoanDays().equals(other.getLoanDays()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getBillEndDate() == null ? other.getBillEndDate() == null : this.getBillEndDate().equals(other.getBillEndDate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getReceiverName() == null ? other.getReceiverName() == null : this.getReceiverName().equals(other.getReceiverName()))
            && (this.getBrcodeName() == null ? other.getBrcodeName() == null : this.getBrcodeName().equals(other.getBrcodeName()))
            && (this.getReceiverAccount() == null ? other.getReceiverAccount() == null : this.getReceiverAccount().equals(other.getReceiverAccount()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getDrawer() == null ? other.getDrawer() == null : this.getDrawer().equals(other.getDrawer()))
            && (this.getElecFlag() == null ? other.getElecFlag() == null : this.getElecFlag().equals(other.getElecFlag()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getPayeeBankno() == null ? other.getPayeeBankno() == null : this.getPayeeBankno().equals(other.getPayeeBankno()))
            && (this.getAcceptor() == null ? other.getAcceptor() == null : this.getAcceptor().equals(other.getAcceptor()))
            && (this.getAcceptorBankno() == null ? other.getAcceptorBankno() == null : this.getAcceptorBankno().equals(other.getAcceptorBankno()))
            && (this.getDrawerAccount() == null ? other.getDrawerAccount() == null : this.getDrawerAccount().equals(other.getDrawerAccount()))
            && (this.getDrawerBankno() == null ? other.getDrawerBankno() == null : this.getDrawerBankno().equals(other.getDrawerBankno()))
            && (this.getBussContno() == null ? other.getBussContno() == null : this.getBussContno().equals(other.getBussContno()))
            && (this.getPoolFlag() == null ? other.getPoolFlag() == null : this.getPoolFlag().equals(other.getPoolFlag()))
            && (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
            && (this.getPoolStatus() == null ? other.getPoolStatus() == null : this.getPoolStatus().equals(other.getPoolStatus()))
            && (this.getBusiFlag() == null ? other.getBusiFlag() == null : this.getBusiFlag().equals(other.getBusiFlag()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPayBank() == null ? other.getPayBank() == null : this.getPayBank().equals(other.getPayBank()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getLockAppno() == null ? other.getLockAppno() == null : this.getLockAppno().equals(other.getLockAppno()))
            && (this.getLoanNo() == null ? other.getLoanNo() == null : this.getLoanNo().equals(other.getLoanNo()))
            && (this.getConversionValue() == null ? other.getConversionValue() == null : this.getConversionValue().equals(other.getConversionValue()))
            && (this.getConversionRate() == null ? other.getConversionRate() == null : this.getConversionRate().equals(other.getConversionRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getBillEndDate() == null) ? 0 : getBillEndDate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getReceiverName() == null) ? 0 : getReceiverName().hashCode());
        result = prime * result + ((getBrcodeName() == null) ? 0 : getBrcodeName().hashCode());
        result = prime * result + ((getReceiverAccount() == null) ? 0 : getReceiverAccount().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getDrawer() == null) ? 0 : getDrawer().hashCode());
        result = prime * result + ((getElecFlag() == null) ? 0 : getElecFlag().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getPayeeBankno() == null) ? 0 : getPayeeBankno().hashCode());
        result = prime * result + ((getAcceptor() == null) ? 0 : getAcceptor().hashCode());
        result = prime * result + ((getAcceptorBankno() == null) ? 0 : getAcceptorBankno().hashCode());
        result = prime * result + ((getDrawerAccount() == null) ? 0 : getDrawerAccount().hashCode());
        result = prime * result + ((getDrawerBankno() == null) ? 0 : getDrawerBankno().hashCode());
        result = prime * result + ((getBussContno() == null) ? 0 : getBussContno().hashCode());
        result = prime * result + ((getPoolFlag() == null) ? 0 : getPoolFlag().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getPoolStatus() == null) ? 0 : getPoolStatus().hashCode());
        result = prime * result + ((getBusiFlag() == null) ? 0 : getBusiFlag().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPayBank() == null) ? 0 : getPayBank().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getLockAppno() == null) ? 0 : getLockAppno().hashCode());
        result = prime * result + ((getLoanNo() == null) ? 0 : getLoanNo().hashCode());
        result = prime * result + ((getConversionValue() == null) ? 0 : getConversionValue().hashCode());
        result = prime * result + ((getConversionRate() == null) ? 0 : getConversionRate().hashCode());
        return result;
    }
}