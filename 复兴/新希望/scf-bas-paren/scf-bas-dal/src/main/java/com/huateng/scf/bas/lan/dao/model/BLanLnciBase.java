package com.huateng.scf.bas.lan.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BLanLnciBase implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String debetNo;

    /**
     * VARCHAR(100) 必填<br>
     * 借据号/承兑协议号
     */
    private String debetId;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * CHAR(2)<br>
     * 借据类型：01-流动资金贷款、02-银行承兑汇票
     */
    private String lnciType;

    /**
     * CHAR(1)<br>
     * 借据状态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    private String lnciStatus;

    /**
     * DECIMAL(16,2)<br>
     * 借据金额
     */
    private BigDecimal lnciAmt;

    /**
     * DECIMAL(16,2)<br>
     * 借据余额
     */
    private BigDecimal lnciBal;

    /**
     * CHAR(8)<br>
     * 起息日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 到期日期
     */
    private String endDate;

    /**
     * VARCHAR(20)<br>
     * 客户经理
     */
    private String mgrno;

    /**
     * CHAR(2)<br>
     * 贷款五级分类
     */
    private String fivelevel;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * 通用日期，如收款确认日期
     */
    private String commonDate;

    /**
     * VARCHAR(50)<br>
     * 贷款入账账号
     */
    private String accountNo;

    /**
     * CHAR(1)<br>
     * 收款确认状态：1-已收到、0-未收到
     */
    private String confirmStatus;

    /**
     * DECIMAL(16,2)<br>
     * 初始保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * DECIMAL(16,2)<br>
     * 剩余提货金额
     */
    private BigDecimal amountIn;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额
     */
    private BigDecimal amountOut;

    /**
     * DECIMAL(22,6)<br>
     * 初始保证金比例
     */
    private BigDecimal firstBailRatio;

    /**
     * VARCHAR(20)<br>
     * 关联业务协议/合同号
     */
    private String protocolNo;

    /**
     * VARCHAR(100)<br>
     * 订单编号
     */
    private String orderNo;

    /**
     * CHAR(1)<br>
     * 出票方式
     */
    private String billType;

    /**
     * VARCHAR(50)<br>
     * 保证金账号
     */
    private String bailAccount;

    /**
     * DECIMAL(22)<br>
     * 出票笔数
     */
    private BigDecimal billNum;

    /**
     * VARCHAR(10)<br>
     * 融资期限(天)
     */
    private String loanDays;

    /**
     * DECIMAL(16,2)<br>
     * 追加保证金金额
     */
    private BigDecimal addBailAmount;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额(向核心企业)
     */
    private BigDecimal amountUpOut;

    /**
     * VARCHAR(6)<br>
     * 填平敞口期限(天)
     */
    private String slaveLimit;

    /**
     * CHAR(1)<br>
     * 锁定标识：0-未锁定;1-锁定
     */
    private String isLocked;

    /**
     * VARCHAR(20)<br>
     * 加锁业务编号
     */
    private String lockAppno;

    /**
     * DECIMAL(16,2)<br>
     * 追加现金等价物金额
     */
    private BigDecimal addCashEqtAmt;

    /**
     * DECIMAL(16,2)<br>
     * 初始现金等价物总额
     */
    private BigDecimal initCashEqtAmt;

    /**
     * VARCHAR(50)<br>
     * 贷款账号
     */
    private String loanAcctNo;

    /**
     * VARCHAR(200)<br>
     * 信贷合同编号
     */
    private String mastContcode;

    /**
     * VARCHAR(20)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String bussBrcode;

    /**
     * VARCHAR(20)<br>
     * 账务机构
     */
    private String acctBrcode;

    /**
     * VARCHAR(20)<br>
     * 业务品种
     */
    private String productId;

    /**
     * VARCHAR(10)<br>
     * 会计类别
     */
    private String accountantType;

    /**
     * CHAR(8)<br>
     * 开户日期
     */
    private String depositDate;

    /**
     * VARCHAR(20)<br>
     * 贷款形态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    private String loanType;

    /**
     * VARCHAR(10)<br>
     * 应计非应计状态：0-应计、1-非应计
     */
    private String accruedStatus;

    /**
     * VARCHAR(10)<br>
     * 贷款账户状态：0-正常、1-销户、2-已核销、3-准销户、4-录入
     */
    private String loanAcctStatus;

    /**
     * VARCHAR(10)<br>
     * 多笔贷款扣款顺序
     */
    private String loansChargeOrder;

    /**
     * DECIMAL(16,2)<br>
     * 已发放金额
     */
    private BigDecimal issuedAmt;

    /**
     * DECIMAL(16,2)<br>
     * 可发放金额
     */
    private BigDecimal avaliableAmt;

    /**
     * DECIMAL(16,2)<br>
     * 正常本金
     */
    private BigDecimal normalCapital;

    /**
     * DECIMAL(16,2)<br>
     * 逾期本金
     */
    private BigDecimal overdueCapital;

    /**
     * DECIMAL(16,2)<br>
     * 呆滞本金
     */
    private BigDecimal idleCapittal;

    /**
     * DECIMAL(16,2)<br>
     * 呆账本金
     */
    private BigDecimal badCapital;

    /**
     * DECIMAL(16,2)<br>
     * 贷款基金
     */
    private BigDecimal loanFund;

    /**
     * DECIMAL(16,2)<br>
     * 应收应计利息
     */
    private BigDecimal receivableAccuredInt;

    /**
     * DECIMAL(16,2)<br>
     * 催收应计利息
     */
    private BigDecimal collectionAccuredInt;

    /**
     * DECIMAL(16,2)<br>
     * 应收欠息
     */
    private BigDecimal receivableInt;

    /**
     * DECIMAL(16,2)<br>
     * 催收欠息
     */
    private BigDecimal collectionInt;

    /**
     * DECIMAL(16,2)<br>
     * 应收应计罚息
     */
    private BigDecimal receivableAccuredPint;

    /**
     * DECIMAL(16,2)<br>
     * 催收应计罚息
     */
    private BigDecimal collectionAccuredPint;

    /**
     * DECIMAL(16,2)<br>
     * 应收罚息
     */
    private BigDecimal receivablePunishInt;

    /**
     * DECIMAL(16,2)<br>
     * 催收罚息
     */
    private BigDecimal collectionPunishInt;

    /**
     * DECIMAL(16,2)<br>
     * 应计复息
     */
    private BigDecimal accuredCompountInt;

    /**
     * DECIMAL(16,2)<br>
     * 复息
     */
    private BigDecimal compoundInt;

    /**
     * DECIMAL(16,2)<br>
     * 应计贴息
     */
    private BigDecimal accuredDiscountInt;

    /**
     * DECIMAL(16,2)<br>
     * 应收贴息
     */
    private BigDecimal receivableDiscountInt;

    /**
     * DECIMAL(16,2)<br>
     * 待摊利息
     */
    private BigDecimal deferredInt;

    /**
     * DECIMAL(16,2)<br>
     * 核销本金
     */
    private BigDecimal verifiedCapital;

    /**
     * DECIMAL(16,2)<br>
     * 核销利息
     */
    private BigDecimal verifiedInt;

    /**
     * DECIMAL(16,2)<br>
     * 利息收入
     */
    private BigDecimal interest;

    /**
     * DECIMAL(16,2)<br>
     * 应收费用
     */
    private BigDecimal receivalbeFee;

    /**
     * DECIMAL(16,2)<br>
     * 费用收入
     */
    private BigDecimal fee;

    /**
     * DECIMAL(16,2)<br>
     * 应收罚金
     */
    private BigDecimal receivalbeFine;

    /**
     * DECIMAL(16,2)<br>
     * 罚金收入
     */
    private BigDecimal fine;

    /**
     * DECIMAL(16,2)<br>
     * 准备金
     */
    private BigDecimal reservedAmt;

    /**
     * CHAR(8)<br>
     * 最后财务交易日
     */
    private String lastAcctTxdate;

    /**
     * VARCHAR(50)<br>
     * 明细序号
     */
    private String detailNo;

    /**
     * VARCHAR(20)<br>
     * 开户机构
     */
    private String depositBrcode;

    /**
     * VARCHAR(20)<br>
     * 开户柜员
     */
    private String depositTlrno;

    /**
     * CHAR(8)<br>
     * 维护日期
     */
    private String maintenanceDate;

    /**
     * VARCHAR(20)<br>
     * 维护柜员
     */
    private String maintenanceTlrno;

    /**
     * CHAR(8)<br>
     * 销户日期
     */
    private String cancellationDate;

    /**
     * VARCHAR(20)<br>
     * 销户柜员
     */
    private String cancellationTlrno;

    /**
     * TIMESTAMP(11,6)<br>
     * 时间戳
     */
    private Date timestamps;

    /**
     * VARCHAR(10)<br>
     * 还款方式
     */
    private String repayMethod;

    /**
     * DECIMAL(22)<br>
     * 宽限期(天)
     */
    private BigDecimal graceDays;

    /**
     * VARCHAR(10)<br>
     * 利率类型
     */
    private String rateType;

    /**
     * VARCHAR(10)<br>
     * 利率浮动方式
     */
    private String rateFloatType;

    /**
     * DECIMAL(10,6)<br>
     * 利率浮动值
     */
    private BigDecimal rateFloatValue;

    /**
     * DECIMAL(10,6)<br>
     * 基准年利率
     */
    private BigDecimal baseYearRate;

    /**
     * VARCHAR(10)<br>
     * 利率调整方式
     */
    private String rateAdjustType;

    /**
     * DECIMAL(10,6)<br>
     * 执行利率
     */
    private BigDecimal rate;

    /**
     * VARCHAR(200)<br>
     * 贷款用途
     */
    private String loanUse;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date insertDate;

    /**
     * VARCHAR(20)<br>
     * 承兑机构
     */
    private String draftBrcode;

    /**
     * VARCHAR(20)<br>
     * 签发机构
     */
    private String signBrcode;

    /**
     * VARCHAR(20)<br>
     * 垫款机构
     */
    private String prePayBrcode;

    /**
     * CHAR(1)<br>
     * 电票标识：1-电票、2-纸票
     */
    private String ebFlag;

    /**
     * VARCHAR(10)<br>
     * 间接额度类型：有、无
     */
    private String hasIndirectCredit;

    /**
     * VARCHAR(40)<br>
     * 间接额度占用方客户号
     */
    private String creditCustcd;

    /**
     * VARCHAR(100)<br>
     * 原借据号
     */
    private String orgDebetId;

    /**
     * VARCHAR(50)<br>
     * 融资出账流水号
     */
    private String loanAppno;

    /**
     * VARCHAR(10)<br>
     * 产品代码
     */
    private String productCode;

    /**
     * CHAR(1)<br>
     * 记录状态：0-正常、1-删除、2-新建
     */
    private String state;

    /**
     * VARCHAR(20)<br>
     * 放款机构
     */
    private String payBrcode;

    /**
     * VARCHAR(32)<br>
     * 放款经办员
     */
    private String payTlrno;

    /**
     * VARCHAR(32)<br>
     * 放款复核员
     */
    private String payChecker;

    /**
     * CHAR(1)<br>
     * 是否已结清：0-否、1-是
     */
    private String isSettle;

    /**
     * DECIMAL(16,2)<br>
     * 累计发货金额
     */
    private BigDecimal accuSendAmt;

    /**
     * DECIMAL(16,2)<br>
     * 剩余发货金额=借据金额-累计发货金额
     */
    private BigDecimal balSendAmt;

    /**
     * CHAR(1)<br>
     * 预约还款状态：0-未发送、1-发送中、2-发送成功、3-发送失败、4-处理成功、5-处理失败
     */
    private String hasSendBp;

    /**
     * CHAR(1)<br>
     * 核心系统借据状态：0-正常、1-删除
     */
    private String coreState;

    /**
     * VARCHAR(20)<br>
     * 占用额度编号
     */
    private String creditNo;

    /**
     * VARCHAR(20)<br>
     * 营业机构
     */
    private String saleBrcode;

    /**
     * DECIMAL(16,2)<br>
     * 自有资金支付金额
     */
    private BigDecimal ownFundPayAmt;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 借据号/承兑协议号
     */
    public String getDebetId() {
        return debetId;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 借据号/承兑协议号
     */
    public void setDebetId(String debetId) {
        this.debetId = debetId == null ? null : debetId.trim();
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
     * 获得 申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 借据类型：01-流动资金贷款、02-银行承兑汇票
     */
    public String getLnciType() {
        return lnciType;
    }

    /**
     * CHAR(2)<br>
     * 设置 借据类型：01-流动资金贷款、02-银行承兑汇票
     */
    public void setLnciType(String lnciType) {
        this.lnciType = lnciType == null ? null : lnciType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 借据状态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    public String getLnciStatus() {
        return lnciStatus;
    }

    /**
     * CHAR(1)<br>
     * 设置 借据状态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    public void setLnciStatus(String lnciStatus) {
        this.lnciStatus = lnciStatus == null ? null : lnciStatus.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 借据金额
     */
    public BigDecimal getLnciAmt() {
        return lnciAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 借据金额
     */
    public void setLnciAmt(BigDecimal lnciAmt) {
        this.lnciAmt = lnciAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 借据余额
     */
    public BigDecimal getLnciBal() {
        return lnciBal;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 借据余额
     */
    public void setLnciBal(BigDecimal lnciBal) {
        this.lnciBal = lnciBal;
    }

    /**
     * CHAR(8)<br>
     * 获得 起息日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 起息日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 到期日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 到期日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户经理
     */
    public String getMgrno() {
        return mgrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户经理
     */
    public void setMgrno(String mgrno) {
        this.mgrno = mgrno == null ? null : mgrno.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 贷款五级分类
     */
    public String getFivelevel() {
        return fivelevel;
    }

    /**
     * CHAR(2)<br>
     * 设置 贷款五级分类
     */
    public void setFivelevel(String fivelevel) {
        this.fivelevel = fivelevel == null ? null : fivelevel.trim();
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
     * TIMESTAMP(11,6)<br>
     * 获得 通用日期，如收款确认日期
     */
    public String getCommonDate() {
        return commonDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 通用日期，如收款确认日期
     */
    public void setCommonDate(String commonDate) {
        this.commonDate = commonDate;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 贷款入账账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 贷款入账账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 收款确认状态：1-已收到、0-未收到
     */
    public String getConfirmStatus() {
        return confirmStatus;
    }

    /**
     * CHAR(1)<br>
     * 设置 收款确认状态：1-已收到、0-未收到
     */
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 初始保证金金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 初始保证金金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 剩余提货金额
     */
    public BigDecimal getAmountIn() {
        return amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 剩余提货金额
     */
    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额
     */
    public BigDecimal getAmountOut() {
        return amountOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额
     */
    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    /**
     * DECIMAL(22,6)<br>
     * 获得 初始保证金比例
     */
    public BigDecimal getFirstBailRatio() {
        return firstBailRatio;
    }

    /**
     * DECIMAL(22,6)<br>
     * 设置 初始保证金比例
     */
    public void setFirstBailRatio(BigDecimal firstBailRatio) {
        this.firstBailRatio = firstBailRatio;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 关联业务协议/合同号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联业务协议/合同号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 出票方式
     */
    public String getBillType() {
        return billType;
    }

    /**
     * CHAR(1)<br>
     * 设置 出票方式
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金账号
     */
    public String getBailAccount() {
        return bailAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金账号
     */
    public void setBailAccount(String bailAccount) {
        this.bailAccount = bailAccount == null ? null : bailAccount.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 出票笔数
     */
    public BigDecimal getBillNum() {
        return billNum;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 出票笔数
     */
    public void setBillNum(BigDecimal billNum) {
        this.billNum = billNum;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 融资期限(天)
     */
    public String getLoanDays() {
        return loanDays;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 融资期限(天)
     */
    public void setLoanDays(String loanDays) {
        this.loanDays = loanDays == null ? null : loanDays.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 追加保证金金额
     */
    public BigDecimal getAddBailAmount() {
        return addBailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 追加保证金金额
     */
    public void setAddBailAmount(BigDecimal addBailAmount) {
        this.addBailAmount = addBailAmount;
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
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额(向核心企业)
     */
    public BigDecimal getAmountUpOut() {
        return amountUpOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额(向核心企业)
     */
    public void setAmountUpOut(BigDecimal amountUpOut) {
        this.amountUpOut = amountUpOut;
    }

    /**
     * VARCHAR(6)<br>
     * 获得 填平敞口期限(天)
     */
    public String getSlaveLimit() {
        return slaveLimit;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 填平敞口期限(天)
     */
    public void setSlaveLimit(String slaveLimit) {
        this.slaveLimit = slaveLimit == null ? null : slaveLimit.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 锁定标识：0-未锁定;1-锁定
     */
    public String getIsLocked() {
        return isLocked;
    }

    /**
     * CHAR(1)<br>
     * 设置 锁定标识：0-未锁定;1-锁定
     */
    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked == null ? null : isLocked.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 加锁业务编号
     */
    public String getLockAppno() {
        return lockAppno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 加锁业务编号
     */
    public void setLockAppno(String lockAppno) {
        this.lockAppno = lockAppno == null ? null : lockAppno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 追加现金等价物金额
     */
    public BigDecimal getAddCashEqtAmt() {
        return addCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 追加现金等价物金额
     */
    public void setAddCashEqtAmt(BigDecimal addCashEqtAmt) {
        this.addCashEqtAmt = addCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 初始现金等价物总额
     */
    public BigDecimal getInitCashEqtAmt() {
        return initCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 初始现金等价物总额
     */
    public void setInitCashEqtAmt(BigDecimal initCashEqtAmt) {
        this.initCashEqtAmt = initCashEqtAmt;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 贷款账号
     */
    public String getLoanAcctNo() {
        return loanAcctNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 贷款账号
     */
    public void setLoanAcctNo(String loanAcctNo) {
        this.loanAcctNo = loanAcctNo == null ? null : loanAcctNo.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 信贷合同编号
     */
    public String getMastContcode() {
        return mastContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 信贷合同编号
     */
    public void setMastContcode(String mastContcode) {
        this.mastContcode = mastContcode == null ? null : mastContcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBussBrcode() {
        return bussBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBussBrcode(String bussBrcode) {
        this.bussBrcode = bussBrcode == null ? null : bussBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 账务机构
     */
    public String getAcctBrcode() {
        return acctBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 账务机构
     */
    public void setAcctBrcode(String acctBrcode) {
        this.acctBrcode = acctBrcode == null ? null : acctBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务品种
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务品种
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 会计类别
     */
    public String getAccountantType() {
        return accountantType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 会计类别
     */
    public void setAccountantType(String accountantType) {
        this.accountantType = accountantType == null ? null : accountantType.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 开户日期
     */
    public String getDepositDate() {
        return depositDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 开户日期
     */
    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate == null ? null : depositDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 贷款形态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 贷款形态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 应计非应计状态：0-应计、1-非应计
     */
    public String getAccruedStatus() {
        return accruedStatus;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 应计非应计状态：0-应计、1-非应计
     */
    public void setAccruedStatus(String accruedStatus) {
        this.accruedStatus = accruedStatus == null ? null : accruedStatus.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 贷款账户状态：0-正常、1-销户、2-已核销、3-准销户、4-录入
     */
    public String getLoanAcctStatus() {
        return loanAcctStatus;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 贷款账户状态：0-正常、1-销户、2-已核销、3-准销户、4-录入
     */
    public void setLoanAcctStatus(String loanAcctStatus) {
        this.loanAcctStatus = loanAcctStatus == null ? null : loanAcctStatus.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 多笔贷款扣款顺序
     */
    public String getLoansChargeOrder() {
        return loansChargeOrder;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 多笔贷款扣款顺序
     */
    public void setLoansChargeOrder(String loansChargeOrder) {
        this.loansChargeOrder = loansChargeOrder == null ? null : loansChargeOrder.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已发放金额
     */
    public BigDecimal getIssuedAmt() {
        return issuedAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已发放金额
     */
    public void setIssuedAmt(BigDecimal issuedAmt) {
        this.issuedAmt = issuedAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可发放金额
     */
    public BigDecimal getAvaliableAmt() {
        return avaliableAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可发放金额
     */
    public void setAvaliableAmt(BigDecimal avaliableAmt) {
        this.avaliableAmt = avaliableAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 正常本金
     */
    public BigDecimal getNormalCapital() {
        return normalCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 正常本金
     */
    public void setNormalCapital(BigDecimal normalCapital) {
        this.normalCapital = normalCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 逾期本金
     */
    public BigDecimal getOverdueCapital() {
        return overdueCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 逾期本金
     */
    public void setOverdueCapital(BigDecimal overdueCapital) {
        this.overdueCapital = overdueCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 呆滞本金
     */
    public BigDecimal getIdleCapittal() {
        return idleCapittal;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 呆滞本金
     */
    public void setIdleCapittal(BigDecimal idleCapittal) {
        this.idleCapittal = idleCapittal;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 呆账本金
     */
    public BigDecimal getBadCapital() {
        return badCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 呆账本金
     */
    public void setBadCapital(BigDecimal badCapital) {
        this.badCapital = badCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 贷款基金
     */
    public BigDecimal getLoanFund() {
        return loanFund;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 贷款基金
     */
    public void setLoanFund(BigDecimal loanFund) {
        this.loanFund = loanFund;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收应计利息
     */
    public BigDecimal getReceivableAccuredInt() {
        return receivableAccuredInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收应计利息
     */
    public void setReceivableAccuredInt(BigDecimal receivableAccuredInt) {
        this.receivableAccuredInt = receivableAccuredInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 催收应计利息
     */
    public BigDecimal getCollectionAccuredInt() {
        return collectionAccuredInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 催收应计利息
     */
    public void setCollectionAccuredInt(BigDecimal collectionAccuredInt) {
        this.collectionAccuredInt = collectionAccuredInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收欠息
     */
    public BigDecimal getReceivableInt() {
        return receivableInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收欠息
     */
    public void setReceivableInt(BigDecimal receivableInt) {
        this.receivableInt = receivableInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 催收欠息
     */
    public BigDecimal getCollectionInt() {
        return collectionInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 催收欠息
     */
    public void setCollectionInt(BigDecimal collectionInt) {
        this.collectionInt = collectionInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收应计罚息
     */
    public BigDecimal getReceivableAccuredPint() {
        return receivableAccuredPint;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收应计罚息
     */
    public void setReceivableAccuredPint(BigDecimal receivableAccuredPint) {
        this.receivableAccuredPint = receivableAccuredPint;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 催收应计罚息
     */
    public BigDecimal getCollectionAccuredPint() {
        return collectionAccuredPint;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 催收应计罚息
     */
    public void setCollectionAccuredPint(BigDecimal collectionAccuredPint) {
        this.collectionAccuredPint = collectionAccuredPint;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收罚息
     */
    public BigDecimal getReceivablePunishInt() {
        return receivablePunishInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收罚息
     */
    public void setReceivablePunishInt(BigDecimal receivablePunishInt) {
        this.receivablePunishInt = receivablePunishInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 催收罚息
     */
    public BigDecimal getCollectionPunishInt() {
        return collectionPunishInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 催收罚息
     */
    public void setCollectionPunishInt(BigDecimal collectionPunishInt) {
        this.collectionPunishInt = collectionPunishInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应计复息
     */
    public BigDecimal getAccuredCompountInt() {
        return accuredCompountInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应计复息
     */
    public void setAccuredCompountInt(BigDecimal accuredCompountInt) {
        this.accuredCompountInt = accuredCompountInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 复息
     */
    public BigDecimal getCompoundInt() {
        return compoundInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 复息
     */
    public void setCompoundInt(BigDecimal compoundInt) {
        this.compoundInt = compoundInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应计贴息
     */
    public BigDecimal getAccuredDiscountInt() {
        return accuredDiscountInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应计贴息
     */
    public void setAccuredDiscountInt(BigDecimal accuredDiscountInt) {
        this.accuredDiscountInt = accuredDiscountInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收贴息
     */
    public BigDecimal getReceivableDiscountInt() {
        return receivableDiscountInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收贴息
     */
    public void setReceivableDiscountInt(BigDecimal receivableDiscountInt) {
        this.receivableDiscountInt = receivableDiscountInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 待摊利息
     */
    public BigDecimal getDeferredInt() {
        return deferredInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 待摊利息
     */
    public void setDeferredInt(BigDecimal deferredInt) {
        this.deferredInt = deferredInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 核销本金
     */
    public BigDecimal getVerifiedCapital() {
        return verifiedCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 核销本金
     */
    public void setVerifiedCapital(BigDecimal verifiedCapital) {
        this.verifiedCapital = verifiedCapital;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 核销利息
     */
    public BigDecimal getVerifiedInt() {
        return verifiedInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 核销利息
     */
    public void setVerifiedInt(BigDecimal verifiedInt) {
        this.verifiedInt = verifiedInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 利息收入
     */
    public BigDecimal getInterest() {
        return interest;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 利息收入
     */
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收费用
     */
    public BigDecimal getReceivalbeFee() {
        return receivalbeFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收费用
     */
    public void setReceivalbeFee(BigDecimal receivalbeFee) {
        this.receivalbeFee = receivalbeFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 费用收入
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 费用收入
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收罚金
     */
    public BigDecimal getReceivalbeFine() {
        return receivalbeFine;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收罚金
     */
    public void setReceivalbeFine(BigDecimal receivalbeFine) {
        this.receivalbeFine = receivalbeFine;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 罚金收入
     */
    public BigDecimal getFine() {
        return fine;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 罚金收入
     */
    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 准备金
     */
    public BigDecimal getReservedAmt() {
        return reservedAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 准备金
     */
    public void setReservedAmt(BigDecimal reservedAmt) {
        this.reservedAmt = reservedAmt;
    }

    /**
     * CHAR(8)<br>
     * 获得 最后财务交易日
     */
    public String getLastAcctTxdate() {
        return lastAcctTxdate;
    }

    /**
     * CHAR(8)<br>
     * 设置 最后财务交易日
     */
    public void setLastAcctTxdate(String lastAcctTxdate) {
        this.lastAcctTxdate = lastAcctTxdate == null ? null : lastAcctTxdate.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 明细序号
     */
    public String getDetailNo() {
        return detailNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 明细序号
     */
    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo == null ? null : detailNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 开户机构
     */
    public String getDepositBrcode() {
        return depositBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 开户机构
     */
    public void setDepositBrcode(String depositBrcode) {
        this.depositBrcode = depositBrcode == null ? null : depositBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 开户柜员
     */
    public String getDepositTlrno() {
        return depositTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 开户柜员
     */
    public void setDepositTlrno(String depositTlrno) {
        this.depositTlrno = depositTlrno == null ? null : depositTlrno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 维护日期
     */
    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 维护日期
     */
    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate == null ? null : maintenanceDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 维护柜员
     */
    public String getMaintenanceTlrno() {
        return maintenanceTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 维护柜员
     */
    public void setMaintenanceTlrno(String maintenanceTlrno) {
        this.maintenanceTlrno = maintenanceTlrno == null ? null : maintenanceTlrno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 销户日期
     */
    public String getCancellationDate() {
        return cancellationDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 销户日期
     */
    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate == null ? null : cancellationDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 销户柜员
     */
    public String getCancellationTlrno() {
        return cancellationTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 销户柜员
     */
    public void setCancellationTlrno(String cancellationTlrno) {
        this.cancellationTlrno = cancellationTlrno == null ? null : cancellationTlrno.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 时间戳
     */
    public Date getTimestamps() {
        return timestamps;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 时间戳
     */
    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款方式
     */
    public String getRepayMethod() {
        return repayMethod;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款方式
     */
    public void setRepayMethod(String repayMethod) {
        this.repayMethod = repayMethod == null ? null : repayMethod.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 宽限期(天)
     */
    public BigDecimal getGraceDays() {
        return graceDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 宽限期(天)
     */
    public void setGraceDays(BigDecimal graceDays) {
        this.graceDays = graceDays;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率类型
     */
    public String getRateType() {
        return rateType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率类型
     */
    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率浮动方式
     */
    public String getRateFloatType() {
        return rateFloatType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率浮动方式
     */
    public void setRateFloatType(String rateFloatType) {
        this.rateFloatType = rateFloatType == null ? null : rateFloatType.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 利率浮动值
     */
    public BigDecimal getRateFloatValue() {
        return rateFloatValue;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 利率浮动值
     */
    public void setRateFloatValue(BigDecimal rateFloatValue) {
        this.rateFloatValue = rateFloatValue;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 基准年利率
     */
    public BigDecimal getBaseYearRate() {
        return baseYearRate;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 基准年利率
     */
    public void setBaseYearRate(BigDecimal baseYearRate) {
        this.baseYearRate = baseYearRate;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率调整方式
     */
    public String getRateAdjustType() {
        return rateAdjustType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率调整方式
     */
    public void setRateAdjustType(String rateAdjustType) {
        this.rateAdjustType = rateAdjustType == null ? null : rateAdjustType.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 执行利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 执行利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * VARCHAR(200)<br>
     * 获得 贷款用途
     */
    public String getLoanUse() {
        return loanUse;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 贷款用途
     */
    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 承兑机构
     */
    public String getDraftBrcode() {
        return draftBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 承兑机构
     */
    public void setDraftBrcode(String draftBrcode) {
        this.draftBrcode = draftBrcode == null ? null : draftBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 签发机构
     */
    public String getSignBrcode() {
        return signBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 签发机构
     */
    public void setSignBrcode(String signBrcode) {
        this.signBrcode = signBrcode == null ? null : signBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 垫款机构
     */
    public String getPrePayBrcode() {
        return prePayBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 垫款机构
     */
    public void setPrePayBrcode(String prePayBrcode) {
        this.prePayBrcode = prePayBrcode == null ? null : prePayBrcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 电票标识：1-电票、2-纸票
     */
    public String getEbFlag() {
        return ebFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 电票标识：1-电票、2-纸票
     */
    public void setEbFlag(String ebFlag) {
        this.ebFlag = ebFlag == null ? null : ebFlag.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 间接额度类型：有、无
     */
    public String getHasIndirectCredit() {
        return hasIndirectCredit;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 间接额度类型：有、无
     */
    public void setHasIndirectCredit(String hasIndirectCredit) {
        this.hasIndirectCredit = hasIndirectCredit == null ? null : hasIndirectCredit.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 间接额度占用方客户号
     */
    public String getCreditCustcd() {
        return creditCustcd;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 间接额度占用方客户号
     */
    public void setCreditCustcd(String creditCustcd) {
        this.creditCustcd = creditCustcd == null ? null : creditCustcd.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 原借据号
     */
    public String getOrgDebetId() {
        return orgDebetId;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 原借据号
     */
    public void setOrgDebetId(String orgDebetId) {
        this.orgDebetId = orgDebetId == null ? null : orgDebetId.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 融资出账流水号
     */
    public String getLoanAppno() {
        return loanAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 融资出账流水号
     */
    public void setLoanAppno(String loanAppno) {
        this.loanAppno = loanAppno == null ? null : loanAppno.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 产品代码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 产品代码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 记录状态：0-正常、1-删除、2-新建
     */
    public String getState() {
        return state;
    }

    /**
     * CHAR(1)<br>
     * 设置 记录状态：0-正常、1-删除、2-新建
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 放款机构
     */
    public String getPayBrcode() {
        return payBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 放款机构
     */
    public void setPayBrcode(String payBrcode) {
        this.payBrcode = payBrcode == null ? null : payBrcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 放款经办员
     */
    public String getPayTlrno() {
        return payTlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款经办员
     */
    public void setPayTlrno(String payTlrno) {
        this.payTlrno = payTlrno == null ? null : payTlrno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 放款复核员
     */
    public String getPayChecker() {
        return payChecker;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款复核员
     */
    public void setPayChecker(String payChecker) {
        this.payChecker = payChecker == null ? null : payChecker.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否已结清：0-否、1-是
     */
    public String getIsSettle() {
        return isSettle;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否已结清：0-否、1-是
     */
    public void setIsSettle(String isSettle) {
        this.isSettle = isSettle == null ? null : isSettle.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计发货金额
     */
    public BigDecimal getAccuSendAmt() {
        return accuSendAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计发货金额
     */
    public void setAccuSendAmt(BigDecimal accuSendAmt) {
        this.accuSendAmt = accuSendAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 剩余发货金额=借据金额-累计发货金额
     */
    public BigDecimal getBalSendAmt() {
        return balSendAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 剩余发货金额=借据金额-累计发货金额
     */
    public void setBalSendAmt(BigDecimal balSendAmt) {
        this.balSendAmt = balSendAmt;
    }

    /**
     * CHAR(1)<br>
     * 获得 预约还款状态：0-未发送、1-发送中、2-发送成功、3-发送失败、4-处理成功、5-处理失败
     */
    public String getHasSendBp() {
        return hasSendBp;
    }

    /**
     * CHAR(1)<br>
     * 设置 预约还款状态：0-未发送、1-发送中、2-发送成功、3-发送失败、4-处理成功、5-处理失败
     */
    public void setHasSendBp(String hasSendBp) {
        this.hasSendBp = hasSendBp == null ? null : hasSendBp.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 核心系统借据状态：0-正常、1-删除
     */
    public String getCoreState() {
        return coreState;
    }

    /**
     * CHAR(1)<br>
     * 设置 核心系统借据状态：0-正常、1-删除
     */
    public void setCoreState(String coreState) {
        this.coreState = coreState == null ? null : coreState.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 占用额度编号
     */
    public String getCreditNo() {
        return creditNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 占用额度编号
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 营业机构
     */
    public String getSaleBrcode() {
        return saleBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 营业机构
     */
    public void setSaleBrcode(String saleBrcode) {
        this.saleBrcode = saleBrcode == null ? null : saleBrcode.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 自有资金支付金额
     */
    public BigDecimal getOwnFundPayAmt() {
        return ownFundPayAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 自有资金支付金额
     */
    public void setOwnFundPayAmt(BigDecimal ownFundPayAmt) {
        this.ownFundPayAmt = ownFundPayAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", debetNo=").append(debetNo);
        sb.append(", debetId=").append(debetId);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", appno=").append(appno);
        sb.append(", lnciType=").append(lnciType);
        sb.append(", lnciStatus=").append(lnciStatus);
        sb.append(", lnciAmt=").append(lnciAmt);
        sb.append(", lnciBal=").append(lnciBal);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", mgrno=").append(mgrno);
        sb.append(", fivelevel=").append(fivelevel);
        sb.append(", curcd=").append(curcd);
        sb.append(", commonDate=").append(commonDate);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", amountIn=").append(amountIn);
        sb.append(", amountOut=").append(amountOut);
        sb.append(", firstBailRatio=").append(firstBailRatio);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", billType=").append(billType);
        sb.append(", bailAccount=").append(bailAccount);
        sb.append(", billNum=").append(billNum);
        sb.append(", loanDays=").append(loanDays);
        sb.append(", addBailAmount=").append(addBailAmount);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", amountUpOut=").append(amountUpOut);
        sb.append(", slaveLimit=").append(slaveLimit);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", lockAppno=").append(lockAppno);
        sb.append(", addCashEqtAmt=").append(addCashEqtAmt);
        sb.append(", initCashEqtAmt=").append(initCashEqtAmt);
        sb.append(", loanAcctNo=").append(loanAcctNo);
        sb.append(", mastContcode=").append(mastContcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", bussBrcode=").append(bussBrcode);
        sb.append(", acctBrcode=").append(acctBrcode);
        sb.append(", productId=").append(productId);
        sb.append(", accountantType=").append(accountantType);
        sb.append(", depositDate=").append(depositDate);
        sb.append(", loanType=").append(loanType);
        sb.append(", accruedStatus=").append(accruedStatus);
        sb.append(", loanAcctStatus=").append(loanAcctStatus);
        sb.append(", loansChargeOrder=").append(loansChargeOrder);
        sb.append(", issuedAmt=").append(issuedAmt);
        sb.append(", avaliableAmt=").append(avaliableAmt);
        sb.append(", normalCapital=").append(normalCapital);
        sb.append(", overdueCapital=").append(overdueCapital);
        sb.append(", idleCapittal=").append(idleCapittal);
        sb.append(", badCapital=").append(badCapital);
        sb.append(", loanFund=").append(loanFund);
        sb.append(", receivableAccuredInt=").append(receivableAccuredInt);
        sb.append(", collectionAccuredInt=").append(collectionAccuredInt);
        sb.append(", receivableInt=").append(receivableInt);
        sb.append(", collectionInt=").append(collectionInt);
        sb.append(", receivableAccuredPint=").append(receivableAccuredPint);
        sb.append(", collectionAccuredPint=").append(collectionAccuredPint);
        sb.append(", receivablePunishInt=").append(receivablePunishInt);
        sb.append(", collectionPunishInt=").append(collectionPunishInt);
        sb.append(", accuredCompountInt=").append(accuredCompountInt);
        sb.append(", compoundInt=").append(compoundInt);
        sb.append(", accuredDiscountInt=").append(accuredDiscountInt);
        sb.append(", receivableDiscountInt=").append(receivableDiscountInt);
        sb.append(", deferredInt=").append(deferredInt);
        sb.append(", verifiedCapital=").append(verifiedCapital);
        sb.append(", verifiedInt=").append(verifiedInt);
        sb.append(", interest=").append(interest);
        sb.append(", receivalbeFee=").append(receivalbeFee);
        sb.append(", fee=").append(fee);
        sb.append(", receivalbeFine=").append(receivalbeFine);
        sb.append(", fine=").append(fine);
        sb.append(", reservedAmt=").append(reservedAmt);
        sb.append(", lastAcctTxdate=").append(lastAcctTxdate);
        sb.append(", detailNo=").append(detailNo);
        sb.append(", depositBrcode=").append(depositBrcode);
        sb.append(", depositTlrno=").append(depositTlrno);
        sb.append(", maintenanceDate=").append(maintenanceDate);
        sb.append(", maintenanceTlrno=").append(maintenanceTlrno);
        sb.append(", cancellationDate=").append(cancellationDate);
        sb.append(", cancellationTlrno=").append(cancellationTlrno);
        sb.append(", timestamps=").append(timestamps);
        sb.append(", repayMethod=").append(repayMethod);
        sb.append(", graceDays=").append(graceDays);
        sb.append(", rateType=").append(rateType);
        sb.append(", rateFloatType=").append(rateFloatType);
        sb.append(", rateFloatValue=").append(rateFloatValue);
        sb.append(", baseYearRate=").append(baseYearRate);
        sb.append(", rateAdjustType=").append(rateAdjustType);
        sb.append(", rate=").append(rate);
        sb.append(", loanUse=").append(loanUse);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", draftBrcode=").append(draftBrcode);
        sb.append(", signBrcode=").append(signBrcode);
        sb.append(", prePayBrcode=").append(prePayBrcode);
        sb.append(", ebFlag=").append(ebFlag);
        sb.append(", hasIndirectCredit=").append(hasIndirectCredit);
        sb.append(", creditCustcd=").append(creditCustcd);
        sb.append(", orgDebetId=").append(orgDebetId);
        sb.append(", loanAppno=").append(loanAppno);
        sb.append(", productCode=").append(productCode);
        sb.append(", state=").append(state);
        sb.append(", payBrcode=").append(payBrcode);
        sb.append(", payTlrno=").append(payTlrno);
        sb.append(", payChecker=").append(payChecker);
        sb.append(", isSettle=").append(isSettle);
        sb.append(", accuSendAmt=").append(accuSendAmt);
        sb.append(", balSendAmt=").append(balSendAmt);
        sb.append(", hasSendBp=").append(hasSendBp);
        sb.append(", coreState=").append(coreState);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", saleBrcode=").append(saleBrcode);
        sb.append(", ownFundPayAmt=").append(ownFundPayAmt);
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
        BLanLnciBase other = (BLanLnciBase) that;
        return (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getLnciType() == null ? other.getLnciType() == null : this.getLnciType().equals(other.getLnciType()))
            && (this.getLnciStatus() == null ? other.getLnciStatus() == null : this.getLnciStatus().equals(other.getLnciStatus()))
            && (this.getLnciAmt() == null ? other.getLnciAmt() == null : this.getLnciAmt().equals(other.getLnciAmt()))
            && (this.getLnciBal() == null ? other.getLnciBal() == null : this.getLnciBal().equals(other.getLnciBal()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
            && (this.getFivelevel() == null ? other.getFivelevel() == null : this.getFivelevel().equals(other.getFivelevel()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getAmountIn() == null ? other.getAmountIn() == null : this.getAmountIn().equals(other.getAmountIn()))
            && (this.getAmountOut() == null ? other.getAmountOut() == null : this.getAmountOut().equals(other.getAmountOut()))
            && (this.getFirstBailRatio() == null ? other.getFirstBailRatio() == null : this.getFirstBailRatio().equals(other.getFirstBailRatio()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getBailAccount() == null ? other.getBailAccount() == null : this.getBailAccount().equals(other.getBailAccount()))
            && (this.getBillNum() == null ? other.getBillNum() == null : this.getBillNum().equals(other.getBillNum()))
            && (this.getLoanDays() == null ? other.getLoanDays() == null : this.getLoanDays().equals(other.getLoanDays()))
            && (this.getAddBailAmount() == null ? other.getAddBailAmount() == null : this.getAddBailAmount().equals(other.getAddBailAmount()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getAmountUpOut() == null ? other.getAmountUpOut() == null : this.getAmountUpOut().equals(other.getAmountUpOut()))
            && (this.getSlaveLimit() == null ? other.getSlaveLimit() == null : this.getSlaveLimit().equals(other.getSlaveLimit()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getLockAppno() == null ? other.getLockAppno() == null : this.getLockAppno().equals(other.getLockAppno()))
            && (this.getAddCashEqtAmt() == null ? other.getAddCashEqtAmt() == null : this.getAddCashEqtAmt().equals(other.getAddCashEqtAmt()))
            && (this.getInitCashEqtAmt() == null ? other.getInitCashEqtAmt() == null : this.getInitCashEqtAmt().equals(other.getInitCashEqtAmt()))
            && (this.getLoanAcctNo() == null ? other.getLoanAcctNo() == null : this.getLoanAcctNo().equals(other.getLoanAcctNo()))
            && (this.getMastContcode() == null ? other.getMastContcode() == null : this.getMastContcode().equals(other.getMastContcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getBussBrcode() == null ? other.getBussBrcode() == null : this.getBussBrcode().equals(other.getBussBrcode()))
            && (this.getAcctBrcode() == null ? other.getAcctBrcode() == null : this.getAcctBrcode().equals(other.getAcctBrcode()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getAccountantType() == null ? other.getAccountantType() == null : this.getAccountantType().equals(other.getAccountantType()))
            && (this.getDepositDate() == null ? other.getDepositDate() == null : this.getDepositDate().equals(other.getDepositDate()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getAccruedStatus() == null ? other.getAccruedStatus() == null : this.getAccruedStatus().equals(other.getAccruedStatus()))
            && (this.getLoanAcctStatus() == null ? other.getLoanAcctStatus() == null : this.getLoanAcctStatus().equals(other.getLoanAcctStatus()))
            && (this.getLoansChargeOrder() == null ? other.getLoansChargeOrder() == null : this.getLoansChargeOrder().equals(other.getLoansChargeOrder()))
            && (this.getIssuedAmt() == null ? other.getIssuedAmt() == null : this.getIssuedAmt().equals(other.getIssuedAmt()))
            && (this.getAvaliableAmt() == null ? other.getAvaliableAmt() == null : this.getAvaliableAmt().equals(other.getAvaliableAmt()))
            && (this.getNormalCapital() == null ? other.getNormalCapital() == null : this.getNormalCapital().equals(other.getNormalCapital()))
            && (this.getOverdueCapital() == null ? other.getOverdueCapital() == null : this.getOverdueCapital().equals(other.getOverdueCapital()))
            && (this.getIdleCapittal() == null ? other.getIdleCapittal() == null : this.getIdleCapittal().equals(other.getIdleCapittal()))
            && (this.getBadCapital() == null ? other.getBadCapital() == null : this.getBadCapital().equals(other.getBadCapital()))
            && (this.getLoanFund() == null ? other.getLoanFund() == null : this.getLoanFund().equals(other.getLoanFund()))
            && (this.getReceivableAccuredInt() == null ? other.getReceivableAccuredInt() == null : this.getReceivableAccuredInt().equals(other.getReceivableAccuredInt()))
            && (this.getCollectionAccuredInt() == null ? other.getCollectionAccuredInt() == null : this.getCollectionAccuredInt().equals(other.getCollectionAccuredInt()))
            && (this.getReceivableInt() == null ? other.getReceivableInt() == null : this.getReceivableInt().equals(other.getReceivableInt()))
            && (this.getCollectionInt() == null ? other.getCollectionInt() == null : this.getCollectionInt().equals(other.getCollectionInt()))
            && (this.getReceivableAccuredPint() == null ? other.getReceivableAccuredPint() == null : this.getReceivableAccuredPint().equals(other.getReceivableAccuredPint()))
            && (this.getCollectionAccuredPint() == null ? other.getCollectionAccuredPint() == null : this.getCollectionAccuredPint().equals(other.getCollectionAccuredPint()))
            && (this.getReceivablePunishInt() == null ? other.getReceivablePunishInt() == null : this.getReceivablePunishInt().equals(other.getReceivablePunishInt()))
            && (this.getCollectionPunishInt() == null ? other.getCollectionPunishInt() == null : this.getCollectionPunishInt().equals(other.getCollectionPunishInt()))
            && (this.getAccuredCompountInt() == null ? other.getAccuredCompountInt() == null : this.getAccuredCompountInt().equals(other.getAccuredCompountInt()))
            && (this.getCompoundInt() == null ? other.getCompoundInt() == null : this.getCompoundInt().equals(other.getCompoundInt()))
            && (this.getAccuredDiscountInt() == null ? other.getAccuredDiscountInt() == null : this.getAccuredDiscountInt().equals(other.getAccuredDiscountInt()))
            && (this.getReceivableDiscountInt() == null ? other.getReceivableDiscountInt() == null : this.getReceivableDiscountInt().equals(other.getReceivableDiscountInt()))
            && (this.getDeferredInt() == null ? other.getDeferredInt() == null : this.getDeferredInt().equals(other.getDeferredInt()))
            && (this.getVerifiedCapital() == null ? other.getVerifiedCapital() == null : this.getVerifiedCapital().equals(other.getVerifiedCapital()))
            && (this.getVerifiedInt() == null ? other.getVerifiedInt() == null : this.getVerifiedInt().equals(other.getVerifiedInt()))
            && (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
            && (this.getReceivalbeFee() == null ? other.getReceivalbeFee() == null : this.getReceivalbeFee().equals(other.getReceivalbeFee()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getReceivalbeFine() == null ? other.getReceivalbeFine() == null : this.getReceivalbeFine().equals(other.getReceivalbeFine()))
            && (this.getFine() == null ? other.getFine() == null : this.getFine().equals(other.getFine()))
            && (this.getReservedAmt() == null ? other.getReservedAmt() == null : this.getReservedAmt().equals(other.getReservedAmt()))
            && (this.getLastAcctTxdate() == null ? other.getLastAcctTxdate() == null : this.getLastAcctTxdate().equals(other.getLastAcctTxdate()))
            && (this.getDetailNo() == null ? other.getDetailNo() == null : this.getDetailNo().equals(other.getDetailNo()))
            && (this.getDepositBrcode() == null ? other.getDepositBrcode() == null : this.getDepositBrcode().equals(other.getDepositBrcode()))
            && (this.getDepositTlrno() == null ? other.getDepositTlrno() == null : this.getDepositTlrno().equals(other.getDepositTlrno()))
            && (this.getMaintenanceDate() == null ? other.getMaintenanceDate() == null : this.getMaintenanceDate().equals(other.getMaintenanceDate()))
            && (this.getMaintenanceTlrno() == null ? other.getMaintenanceTlrno() == null : this.getMaintenanceTlrno().equals(other.getMaintenanceTlrno()))
            && (this.getCancellationDate() == null ? other.getCancellationDate() == null : this.getCancellationDate().equals(other.getCancellationDate()))
            && (this.getCancellationTlrno() == null ? other.getCancellationTlrno() == null : this.getCancellationTlrno().equals(other.getCancellationTlrno()))
            && (this.getTimestamps() == null ? other.getTimestamps() == null : this.getTimestamps().equals(other.getTimestamps()))
            && (this.getRepayMethod() == null ? other.getRepayMethod() == null : this.getRepayMethod().equals(other.getRepayMethod()))
            && (this.getGraceDays() == null ? other.getGraceDays() == null : this.getGraceDays().equals(other.getGraceDays()))
            && (this.getRateType() == null ? other.getRateType() == null : this.getRateType().equals(other.getRateType()))
            && (this.getRateFloatType() == null ? other.getRateFloatType() == null : this.getRateFloatType().equals(other.getRateFloatType()))
            && (this.getRateFloatValue() == null ? other.getRateFloatValue() == null : this.getRateFloatValue().equals(other.getRateFloatValue()))
            && (this.getBaseYearRate() == null ? other.getBaseYearRate() == null : this.getBaseYearRate().equals(other.getBaseYearRate()))
            && (this.getRateAdjustType() == null ? other.getRateAdjustType() == null : this.getRateAdjustType().equals(other.getRateAdjustType()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getLoanUse() == null ? other.getLoanUse() == null : this.getLoanUse().equals(other.getLoanUse()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getDraftBrcode() == null ? other.getDraftBrcode() == null : this.getDraftBrcode().equals(other.getDraftBrcode()))
            && (this.getSignBrcode() == null ? other.getSignBrcode() == null : this.getSignBrcode().equals(other.getSignBrcode()))
            && (this.getPrePayBrcode() == null ? other.getPrePayBrcode() == null : this.getPrePayBrcode().equals(other.getPrePayBrcode()))
            && (this.getEbFlag() == null ? other.getEbFlag() == null : this.getEbFlag().equals(other.getEbFlag()))
            && (this.getHasIndirectCredit() == null ? other.getHasIndirectCredit() == null : this.getHasIndirectCredit().equals(other.getHasIndirectCredit()))
            && (this.getCreditCustcd() == null ? other.getCreditCustcd() == null : this.getCreditCustcd().equals(other.getCreditCustcd()))
            && (this.getOrgDebetId() == null ? other.getOrgDebetId() == null : this.getOrgDebetId().equals(other.getOrgDebetId()))
            && (this.getLoanAppno() == null ? other.getLoanAppno() == null : this.getLoanAppno().equals(other.getLoanAppno()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPayBrcode() == null ? other.getPayBrcode() == null : this.getPayBrcode().equals(other.getPayBrcode()))
            && (this.getPayTlrno() == null ? other.getPayTlrno() == null : this.getPayTlrno().equals(other.getPayTlrno()))
            && (this.getPayChecker() == null ? other.getPayChecker() == null : this.getPayChecker().equals(other.getPayChecker()))
            && (this.getIsSettle() == null ? other.getIsSettle() == null : this.getIsSettle().equals(other.getIsSettle()))
            && (this.getAccuSendAmt() == null ? other.getAccuSendAmt() == null : this.getAccuSendAmt().equals(other.getAccuSendAmt()))
            && (this.getBalSendAmt() == null ? other.getBalSendAmt() == null : this.getBalSendAmt().equals(other.getBalSendAmt()))
            && (this.getHasSendBp() == null ? other.getHasSendBp() == null : this.getHasSendBp().equals(other.getHasSendBp()))
            && (this.getCoreState() == null ? other.getCoreState() == null : this.getCoreState().equals(other.getCoreState()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getSaleBrcode() == null ? other.getSaleBrcode() == null : this.getSaleBrcode().equals(other.getSaleBrcode()))
            && (this.getOwnFundPayAmt() == null ? other.getOwnFundPayAmt() == null : this.getOwnFundPayAmt().equals(other.getOwnFundPayAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getLnciType() == null) ? 0 : getLnciType().hashCode());
        result = prime * result + ((getLnciStatus() == null) ? 0 : getLnciStatus().hashCode());
        result = prime * result + ((getLnciAmt() == null) ? 0 : getLnciAmt().hashCode());
        result = prime * result + ((getLnciBal() == null) ? 0 : getLnciBal().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
        result = prime * result + ((getFivelevel() == null) ? 0 : getFivelevel().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getAmountIn() == null) ? 0 : getAmountIn().hashCode());
        result = prime * result + ((getAmountOut() == null) ? 0 : getAmountOut().hashCode());
        result = prime * result + ((getFirstBailRatio() == null) ? 0 : getFirstBailRatio().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getBailAccount() == null) ? 0 : getBailAccount().hashCode());
        result = prime * result + ((getBillNum() == null) ? 0 : getBillNum().hashCode());
        result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
        result = prime * result + ((getAddBailAmount() == null) ? 0 : getAddBailAmount().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getAmountUpOut() == null) ? 0 : getAmountUpOut().hashCode());
        result = prime * result + ((getSlaveLimit() == null) ? 0 : getSlaveLimit().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getLockAppno() == null) ? 0 : getLockAppno().hashCode());
        result = prime * result + ((getAddCashEqtAmt() == null) ? 0 : getAddCashEqtAmt().hashCode());
        result = prime * result + ((getInitCashEqtAmt() == null) ? 0 : getInitCashEqtAmt().hashCode());
        result = prime * result + ((getLoanAcctNo() == null) ? 0 : getLoanAcctNo().hashCode());
        result = prime * result + ((getMastContcode() == null) ? 0 : getMastContcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getBussBrcode() == null) ? 0 : getBussBrcode().hashCode());
        result = prime * result + ((getAcctBrcode() == null) ? 0 : getAcctBrcode().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getAccountantType() == null) ? 0 : getAccountantType().hashCode());
        result = prime * result + ((getDepositDate() == null) ? 0 : getDepositDate().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getAccruedStatus() == null) ? 0 : getAccruedStatus().hashCode());
        result = prime * result + ((getLoanAcctStatus() == null) ? 0 : getLoanAcctStatus().hashCode());
        result = prime * result + ((getLoansChargeOrder() == null) ? 0 : getLoansChargeOrder().hashCode());
        result = prime * result + ((getIssuedAmt() == null) ? 0 : getIssuedAmt().hashCode());
        result = prime * result + ((getAvaliableAmt() == null) ? 0 : getAvaliableAmt().hashCode());
        result = prime * result + ((getNormalCapital() == null) ? 0 : getNormalCapital().hashCode());
        result = prime * result + ((getOverdueCapital() == null) ? 0 : getOverdueCapital().hashCode());
        result = prime * result + ((getIdleCapittal() == null) ? 0 : getIdleCapittal().hashCode());
        result = prime * result + ((getBadCapital() == null) ? 0 : getBadCapital().hashCode());
        result = prime * result + ((getLoanFund() == null) ? 0 : getLoanFund().hashCode());
        result = prime * result + ((getReceivableAccuredInt() == null) ? 0 : getReceivableAccuredInt().hashCode());
        result = prime * result + ((getCollectionAccuredInt() == null) ? 0 : getCollectionAccuredInt().hashCode());
        result = prime * result + ((getReceivableInt() == null) ? 0 : getReceivableInt().hashCode());
        result = prime * result + ((getCollectionInt() == null) ? 0 : getCollectionInt().hashCode());
        result = prime * result + ((getReceivableAccuredPint() == null) ? 0 : getReceivableAccuredPint().hashCode());
        result = prime * result + ((getCollectionAccuredPint() == null) ? 0 : getCollectionAccuredPint().hashCode());
        result = prime * result + ((getReceivablePunishInt() == null) ? 0 : getReceivablePunishInt().hashCode());
        result = prime * result + ((getCollectionPunishInt() == null) ? 0 : getCollectionPunishInt().hashCode());
        result = prime * result + ((getAccuredCompountInt() == null) ? 0 : getAccuredCompountInt().hashCode());
        result = prime * result + ((getCompoundInt() == null) ? 0 : getCompoundInt().hashCode());
        result = prime * result + ((getAccuredDiscountInt() == null) ? 0 : getAccuredDiscountInt().hashCode());
        result = prime * result + ((getReceivableDiscountInt() == null) ? 0 : getReceivableDiscountInt().hashCode());
        result = prime * result + ((getDeferredInt() == null) ? 0 : getDeferredInt().hashCode());
        result = prime * result + ((getVerifiedCapital() == null) ? 0 : getVerifiedCapital().hashCode());
        result = prime * result + ((getVerifiedInt() == null) ? 0 : getVerifiedInt().hashCode());
        result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
        result = prime * result + ((getReceivalbeFee() == null) ? 0 : getReceivalbeFee().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getReceivalbeFine() == null) ? 0 : getReceivalbeFine().hashCode());
        result = prime * result + ((getFine() == null) ? 0 : getFine().hashCode());
        result = prime * result + ((getReservedAmt() == null) ? 0 : getReservedAmt().hashCode());
        result = prime * result + ((getLastAcctTxdate() == null) ? 0 : getLastAcctTxdate().hashCode());
        result = prime * result + ((getDetailNo() == null) ? 0 : getDetailNo().hashCode());
        result = prime * result + ((getDepositBrcode() == null) ? 0 : getDepositBrcode().hashCode());
        result = prime * result + ((getDepositTlrno() == null) ? 0 : getDepositTlrno().hashCode());
        result = prime * result + ((getMaintenanceDate() == null) ? 0 : getMaintenanceDate().hashCode());
        result = prime * result + ((getMaintenanceTlrno() == null) ? 0 : getMaintenanceTlrno().hashCode());
        result = prime * result + ((getCancellationDate() == null) ? 0 : getCancellationDate().hashCode());
        result = prime * result + ((getCancellationTlrno() == null) ? 0 : getCancellationTlrno().hashCode());
        result = prime * result + ((getTimestamps() == null) ? 0 : getTimestamps().hashCode());
        result = prime * result + ((getRepayMethod() == null) ? 0 : getRepayMethod().hashCode());
        result = prime * result + ((getGraceDays() == null) ? 0 : getGraceDays().hashCode());
        result = prime * result + ((getRateType() == null) ? 0 : getRateType().hashCode());
        result = prime * result + ((getRateFloatType() == null) ? 0 : getRateFloatType().hashCode());
        result = prime * result + ((getRateFloatValue() == null) ? 0 : getRateFloatValue().hashCode());
        result = prime * result + ((getBaseYearRate() == null) ? 0 : getBaseYearRate().hashCode());
        result = prime * result + ((getRateAdjustType() == null) ? 0 : getRateAdjustType().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getLoanUse() == null) ? 0 : getLoanUse().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getDraftBrcode() == null) ? 0 : getDraftBrcode().hashCode());
        result = prime * result + ((getSignBrcode() == null) ? 0 : getSignBrcode().hashCode());
        result = prime * result + ((getPrePayBrcode() == null) ? 0 : getPrePayBrcode().hashCode());
        result = prime * result + ((getEbFlag() == null) ? 0 : getEbFlag().hashCode());
        result = prime * result + ((getHasIndirectCredit() == null) ? 0 : getHasIndirectCredit().hashCode());
        result = prime * result + ((getCreditCustcd() == null) ? 0 : getCreditCustcd().hashCode());
        result = prime * result + ((getOrgDebetId() == null) ? 0 : getOrgDebetId().hashCode());
        result = prime * result + ((getLoanAppno() == null) ? 0 : getLoanAppno().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPayBrcode() == null) ? 0 : getPayBrcode().hashCode());
        result = prime * result + ((getPayTlrno() == null) ? 0 : getPayTlrno().hashCode());
        result = prime * result + ((getPayChecker() == null) ? 0 : getPayChecker().hashCode());
        result = prime * result + ((getIsSettle() == null) ? 0 : getIsSettle().hashCode());
        result = prime * result + ((getAccuSendAmt() == null) ? 0 : getAccuSendAmt().hashCode());
        result = prime * result + ((getBalSendAmt() == null) ? 0 : getBalSendAmt().hashCode());
        result = prime * result + ((getHasSendBp() == null) ? 0 : getHasSendBp().hashCode());
        result = prime * result + ((getCoreState() == null) ? 0 : getCoreState().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getSaleBrcode() == null) ? 0 : getSaleBrcode().hashCode());
        result = prime * result + ((getOwnFundPayAmt() == null) ? 0 : getOwnFundPayAmt().hashCode());
        return result;
    }
}