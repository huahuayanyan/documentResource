package com.huateng.scf.adv.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ThreeCheckStockDebetVO implements Serializable {
    private static final long serialVersionUID = 1L;
    

    
    /**B_LAN_LNCI_BASE以外新增字段*/
    
    private String num;//票/款确认函编号

    
    public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

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

 
    
}