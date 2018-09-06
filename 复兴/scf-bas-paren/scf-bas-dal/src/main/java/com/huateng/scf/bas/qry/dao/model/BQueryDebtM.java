package com.huateng.scf.bas.qry.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BQueryDebtM implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(6)<br>
     * 输入时间
     */
    private String inputdate;

    /**
     * VARCHAR(4)<br>
     * 申请类型
     */
    private String applyType;

    /**
     * VARCHAR(20)<br>
     * 卖方客户号
     */
    private String custcdSaller;

    /**
     * VARCHAR(20)<br>
     * 买方客户号
     */
    private String custcdBuyer;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * VARCHAR(120)<br>
     * 买方客户名称
     */
    private String cnameBuyer;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * DATE(7)<br>
     * 插入日期
     */
    private Date insertDate;

    /**
     * DECIMAL(22)<br>
     * 应收账款份数
     */
    private BigDecimal debtNum;

    /**
     * DECIMAL(16,2)<br>
     * 应收账款总金额
     */
    private BigDecimal totalDebtAmount;

    /**
     * DECIMAL(16,2)<br>
     * 手续费用
     */
    private BigDecimal finacingCost;

    /**
     * DECIMAL(16,2)<br>
     * 管理费
     */
    private BigDecimal cost;

    /**
     * DECIMAL(16,2)<br>
     * 处理费
     */
    private BigDecimal handlingFee;

    /**
     * DECIMAL(16,2)<br>
     * 减免金额
     */
    private BigDecimal reduceAmount;

    /**
     * DECIMAL(16,2)<br>
     * 费用总计
     */
    private BigDecimal totalFee;

    /**
     * DECIMAL(16,2)<br>
     * 减免总计
     */
    private BigDecimal totalReduce;

    /**
     * DECIMAL(16,2)<br>
     * 实收费用小计
     */
    private BigDecimal receiveAmount;

    /**
     * VARCHAR(10)<br>
     * 业务类型【供应链产品小类ID】
     */
    private String bussType;

    /**
     * VARCHAR(50)<br>
     * 贷款种类
     */
    private String loanType;

    /**
     * VARCHAR(50)<br>
     * 开户行
     */
    private String bankno;

    /**
     * DECIMAL(16,2)<br>
     * 业务金额
     */
    private BigDecimal amount;

    /**
     * DATE(7)<br>
     * 申请日期
     */
    private Date appDate;

    /**
     * DATE(7)<br>
     * 还款日期
     */
    private Date returnDate;

    /**
     * CHAR(3)<br>
     * 币别
     */
    private String curcd;

    /**
     * VARCHAR(50)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(20)<br>
     * 操作员ID
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 登记机构
     */
    private String brcodeBuss;

    /**
     * CHAR(1)<br>
     * 利率类型【1-利息，2-融资，3-融资本息，4-无】
     */
    private String returnType;

    /**
     * CHAR(1)<br>
     * 尾款是否进入卖方账户标志【1-是，2-否】
     */
    private String toSallerFlag;

    /**
     * DECIMAL(16,2)<br>
     * 还款金额
     */
    private BigDecimal returnAmount;

    /**
     * VARCHAR(50)<br>
     * 账号
     */
    private String accountNo;

    /**
     * CHAR(1)<br>
     * 还款方式【1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款】
     */
    private String returnMethod;

    /**
     * DECIMAL(16,2)<br>
     * 还息金额
     */
    private BigDecimal returnInterestAmount;

    /**
     * DECIMAL(16,2)<br>
     * 还本金额
     */
    private BigDecimal returnCapitalAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入卖方结算账号金额
     */
    private BigDecimal toSallerAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入现金池金额
     */
    private BigDecimal toPoolAmount;

    /**
     * VARCHAR(50)<br>
     * 回款账号
     */
    private String returnAccount;

    /**
     * VARCHAR(40)<br>
     * 入账交易编号
     */
    private String transactionNo;

    /**
     * DECIMAL(16,2)<br>
     * 本次入保证金金额
     */
    private BigDecimal tobailAmount;

    /**
     * DECIMAL(16,2)<br>
     * 本次核销金额
     */
    private BigDecimal rebateAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入账账户(回款账户)余额
     */
    private BigDecimal returnAccountBalance;

    /**
     * DECIMAL(16,2)<br>
     * 本次总计尾款金额
     */
    private BigDecimal totalOverAmount;

    /**
     * VARCHAR(10)<br>
     * 回款结算方式：1-票据、2-汇款
     */
    private String settleMethod;

    /**
     * CHAR(2)<br>
     * 回款用途：01-入保证金、02-还贷、03-尾款
     */
    private String repayPurpose;

    /**
     * DECIMAL(16,2)<br>
     * 转账金额
     */
    private BigDecimal transferAmt;

    /**
     * DATE(7)<br>
     * 交易日期
     */
    private Date transactionDate;

    /**
     * VARCHAR(120)<br>
     * 客户名称
     */
    private String cname;

    /**
     * VARCHAR(120)<br>
     * 客户英文名
     */
    private String ename;

    /**
     * VARCHAR(80)<br>
     * 客户别名
     */
    private String aliasName;

    /**
     * VARCHAR(10)<br>
     * 组织机构代码
     */
    private String orgCode;

    /**
     * CHAR(2)<br>
     * 客户状态(DATA_DIC.840)
     */
    private String custStatus;

    /**
     * VARCHAR(50)<br>
     * 管户员
     */
    private String mgrno;

    /**
     * CHAR(1)<br>
     * 是否核心厂商：0-否、1-是
     */
    private String coreFlag;

    /**
     * CHAR(1)<br>
     * 是否监管公司：0-否、1-是
     */
    private String moniFlag;

    /**
     * CHAR(1)<br>
     * 是否期货经纪公司；0-否、1-是
     */
    private String futuresFlag;

    /**
     * CHAR(1)<br>
     * 是否金融租赁公司：0-否、1-是
     */
    private String flcFlag;

    /**
     * VARCHAR(20)<br>
     * 管户机构
     */
    private String brcode;

    /**
     * DATE(7)<br>
     * 建档日期
     */
    private Date createDate;

    /**
     * CHAR(1)<br>
     * 授信客户标识：0-否、1-是
     */
    private String creditFlag;

    /**
     * CHAR(1)<br>
     * 黑名单标识：0-否、1-是
     */
    private String blackFlag;

    /**
     * CHAR(1)<br>
     * 是否保险公司：0-否、1-是
     */
    private String insureFlag;

    /**
     * CHAR(1)<br>
     * 是否保理商：0-否、1-是
     */
    private String factorFlag;

    /**
     * VARCHAR(50)<br>
     * 信贷客户号
     */
    private String ccmsCustcd;

    /**
     * CHAR(1)<br>
     * 是否贸融重点客户：0-否、1-是
     */
    private String importantFlag;

    /**
     * CHAR(1)<br>
     * 是否贸易对手：0-否、1-是
     */
    private String commercialFalg;

    /**
     * CHAR(1)<br>
     * 是否境外：0-否、1-是
     */
    private String overseasFlag;

    /**
     * CHAR(1)<br>
     * 是否是本行客户：0-否、1-是
     */
    private String banksCustFlag;

    /**
     * CHAR(1)<br>
     * 是否是EF进口商：0-否、1-是
     */
    private String efBuyerFlag;

    /**
     * CHAR(1)<br>
     * 是否是IF出口商：0-否、1-是
     */
    private String ifSellerFlag;

    /**
     * CHAR(1)<br>
     * 是否是银行：0-否、1-是
     */
    private String isBank;

    /**
     * VARCHAR(10)<br>
     * FCI代号
     */
    private String fciCode;

    /**
     * CHAR(1)<br>
     * 是否国际保理客户
     */
    private String isIntl;

    /**
     * CHAR(1)<br>
     * 企业类型
     */
    private String enterpriseType;

    /**
     * VARCHAR(6)<br>
     * 国标行业分类
     */
    private String industryType;

    /**
     * VARCHAR(10)<br>
     * 企业规模
     */
    private String enterpriseScope;

    /**
     * VARCHAR(2)<br>
     * 客户等级(DATA_DIC.11255)
     */
    private String custLevel;

    /**
     * VARCHAR(2)<br>
     * 厂商等级：00:全国性核心厂商，01：区域性核心厂商,02：单笔单批
     */
    private String coreLevel;

    /**
     * VARCHAR(2)<br>
     * 供应链所处地位
     */
    private String supplyPosition;

    /**
     * VARCHAR(10)<br>
     * 机构名称
     */
    private String brname;

    /**
     * CHAR(1)<br>
     * 机构级别：0-虚拟总行、1-总行、2-分行、3-一级支行、4-二级支行
     */
    private String brclass;

    /**
     * VARCHAR(60)<br>
     * 机构名称(BUSS)
     */
    private String brnameBuss;

    /**
     * VARCHAR(30)<br>
     * 操作员名称
     */
    private String tlrName;

    /**
     * VARCHAR(80)<br>
     * 产品名称
     */
    private String productName;

    /**
     * VARCHAR(20)<br>
     * 业务合同号
     */
    private String debtContno;

    /**
     * DECIMAL(9,6)<br>
     * 融资比例(%)
     */
    private BigDecimal loanPercent;

    /**
     * VARCHAR(2)<br>
     * 保理业务类别
     */
    private String factType;

    /**
     * CHAR(1)<br>
     * 融资模式：1-发票融资;2-池融资
     */
    private String financingType;

    /**
     * CHAR(2)<br>
     * 费用收取方式：01-按年，02-单笔
     */
    private String chargeType;

    /**
     * CHAR(2)<br>
     * 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    private String noticeType;

    /**
     * VARCHAR(10)<br>
     * 是否自动还款：00-否、01-是
     */
    private String isAutoPay;

    /**
     * DECIMAL(22)<br>
     * 自动提前还款天数
     */
    private BigDecimal autoPayDays;

    /**
     * VARCHAR(10)<br>
     * 服务内容：保理融资;账款管理;应收租金催收;坏账担保
     */
    private String serviceContent;

    /**
     * VARCHAR(10)<br>
     * 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    private String supplyChainPdId;

    /**
     * VARCHAR(20)<br>
     * 客户号(卖方)
     */
    private String custcdCont;

    /**
     * CHAR(3)<br>
     * 合同币种
     */
    private String curcdCont;

    /**
     * DECIMAL(16,2)<br>
     * 额度金额
     */
    private BigDecimal contAmount;

    /**
     * DATE(7)<br>
     * 合同生效日期
     */
    private Date startDate;

    /**
     * DATE(7)<br>
     * 合同到期日期
     */
    private Date endDate;

    /**
     * VARCHAR(20)<br>
     * 出账方式：01-流贷；02-承兑；03-预支价金
     */
    private String loanWay;

    /**
     * VARCHAR(20)<br>
     * 合同状态
     */
    private String contStatus;

    /**
     * VARCHAR(50)<br>
     * 结算账号
     */
    private String contAccountNo;

    /**
     * VARCHAR(20)<br>
     * 客户经理
     */
    private String mgrnoCont;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;

    /**
     * VARCHAR(20)<br>
     * 最后更新人
     */
    private String lastUpdTlrno;

    /**
     * DATE(7)<br>
     * 最后更新时间
     */
    private Date lastUpdDate;

    /**
     * VARCHAR(20)<br>
     * 经办机构号
     */
    private String brcodeCont;

    /**
     * VARCHAR(50)<br>
     * 池保证金账号
     */
    private String bailAcctNo;

    /**
     * VARCHAR(50)<br>
     * 回款专户
     */
    private String contRetuAccount;

    /**
     * VARCHAR(1)<br>
     * 有无追索权：1-有追索;2-无追索
     */
    private String recoverType;

    /**
     * VARCHAR(10)<br>
     * 回款用途:01-入借据保证金;02-还贷
     */
    private String contRepayPurpose;

    /**
     * VARCHAR(10)<br>
     * 尾款规则:01-入结算账户;02-留存回款专户
     */
    private String dueBalanceRule;

    /**
     * VARCHAR(10)<br>
     * 回款核销规则:01-先到期先核销;02-平均分配核销
     */
    private String paymentVerifyRule;

    /**
     * VARCHAR(100)<br>
     * 赔款转让协议号
     */
    private String reparationProtNo;

    /**
     * VARCHAR(10)<br>
     * 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
     */
    private String lease;

    /**
     * VARCHAR(100)<br>
     * 反转让方
     */
    private String repurchaser;

    /**
     * VARCHAR(100)<br>
     * 反转让协议号
     */
    private String repurchaseProtNo;

    /**
     * VARCHAR(20)<br>
     * 买方保理商客户号
     */
    private String factoringBrcode;

    /**
     * DECIMAL(22)<br>
     * 赔款期限(天)
     */
    private BigDecimal reparationTerm;

    /**
     * DECIMAL(10,6)<br>
     * 赔付比例(%)
     */
    private BigDecimal reparationPercent;

    /**
     * DECIMAL(16,2)<br>
     * 累计赔款金额
     */
    private BigDecimal cumulativeReparationAmt;

    /**
     * VARCHAR(2)<br>
     * 保理方式：1-明保理;2-暗保理
     */
    private String factPattern;

    /**
     * VARCHAR(20)<br>
     * 合作机构（村镇银行）
     */
    private String cooperationBrcode;

    /**
     * CHAR(1)<br>
     * 租金处理方式：1-质押、2-转让
     */
    private String rentSettleWay;

    /**
     * DECIMAL(16,2)<br>
     * 池保证金余额
     */
    private BigDecimal poolBailAmt;

    /**
     * DECIMAL(16,2)<br>
     * 有效金额
     */
    private BigDecimal sumdebtBillsAmount;

    /**
     * DECIMAL(16,2)<br>
     * 票面金额
     */
    private BigDecimal sumdebtBillsAmountView;

    /**
     * DECIMAL(16,2)<br>
     * 应收账款余额
     */
    private BigDecimal sumdebtRemainingAmount;

    /**
     * DECIMAL(16,2)<br>
     * 可用融资余额
     */
    private BigDecimal sumdebtRemainingUseableAmou;

    /**
     * DECIMAL(16,2)<br>
     * 折让金额
     */
    private BigDecimal sumdebtRebateAmount;

    /**
     * DECIMAL(16,2)<br>
     * 回购金额
     */
    private BigDecimal sumdebtBuyBackAmount;

    /**
     * DECIMAL(16,2)<br>
     * 付款金额
     */
    private BigDecimal sumdebtPayAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入账金额
     */
    private BigDecimal sumdebtRemoveAmount;

    /**
     * DECIMAL(16,2)<br>
     * 现金余额
     */
    private BigDecimal sumdebtCashRemainingAmount;

    /**
     * DECIMAL(16,2)<br>
     * 瑕疵标记：1-有瑕疵、0-无瑕疵
     */
    private BigDecimal sumamtDebtFlawFlag;

    /**
     * DECIMAL(16,2)<br>
     * 商纠状态：1-有商纠、0-无商纠
     */
    private BigDecimal sumamtDebtIssueFlag;

    /**
     * DECIMAL(16,2)<br>
     * 逾期状态：1-有、0-无
     */
    private BigDecimal sumamtDebtOverdueFlag;

    /**
     * DECIMAL(16,2)<br>
     * 是否呆账：1-有、0-无
     */
    private BigDecimal sumamtDebtBadFlag;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 输入时间
     */
    public String getInputdate() {
        return inputdate;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 输入时间
     */
    public void setInputdate(String inputdate) {
        this.inputdate = inputdate == null ? null : inputdate.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 申请类型
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 申请类型
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 卖方客户号
     */
    public String getCustcdSaller() {
        return custcdSaller;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 卖方客户号
     */
    public void setCustcdSaller(String custcdSaller) {
        this.custcdSaller = custcdSaller == null ? null : custcdSaller.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 买方客户号
     */
    public String getCustcdBuyer() {
        return custcdBuyer;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 买方客户号
     */
    public void setCustcdBuyer(String custcdBuyer) {
        this.custcdBuyer = custcdBuyer == null ? null : custcdBuyer.trim();
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
     * VARCHAR(120)<br>
     * 获得 买方客户名称
     */
    public String getCnameBuyer() {
        return cnameBuyer;
    }

    /**
     * VARCHAR(120)<br>
     * 设置 买方客户名称
     */
    public void setCnameBuyer(String cnameBuyer) {
        this.cnameBuyer = cnameBuyer == null ? null : cnameBuyer.trim();
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
     * DATE(7)<br>
     * 获得 插入日期
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * DATE(7)<br>
     * 设置 插入日期
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 应收账款份数
     */
    public BigDecimal getDebtNum() {
        return debtNum;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 应收账款份数
     */
    public void setDebtNum(BigDecimal debtNum) {
        this.debtNum = debtNum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收账款总金额
     */
    public BigDecimal getTotalDebtAmount() {
        return totalDebtAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收账款总金额
     */
    public void setTotalDebtAmount(BigDecimal totalDebtAmount) {
        this.totalDebtAmount = totalDebtAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 手续费用
     */
    public BigDecimal getFinacingCost() {
        return finacingCost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 手续费用
     */
    public void setFinacingCost(BigDecimal finacingCost) {
        this.finacingCost = finacingCost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 管理费
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 管理费
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 处理费
     */
    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 处理费
     */
    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 减免金额
     */
    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 减免金额
     */
    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 费用总计
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 费用总计
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 减免总计
     */
    public BigDecimal getTotalReduce() {
        return totalReduce;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 减免总计
     */
    public void setTotalReduce(BigDecimal totalReduce) {
        this.totalReduce = totalReduce;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 实收费用小计
     */
    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 实收费用小计
     */
    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务类型【供应链产品小类ID】
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务类型【供应链产品小类ID】
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 贷款种类
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 贷款种类
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 开户行
     */
    public String getBankno() {
        return bankno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 开户行
     */
    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 业务金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 业务金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * DATE(7)<br>
     * 获得 申请日期
     */
    public Date getAppDate() {
        return appDate;
    }

    /**
     * DATE(7)<br>
     * 设置 申请日期
     */
    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    /**
     * DATE(7)<br>
     * 获得 还款日期
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * DATE(7)<br>
     * 设置 还款日期
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
     * VARCHAR(50)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 操作员ID
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 操作员ID
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记机构
     */
    public String getBrcodeBuss() {
        return brcodeBuss;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记机构
     */
    public void setBrcodeBuss(String brcodeBuss) {
        this.brcodeBuss = brcodeBuss == null ? null : brcodeBuss.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 利率类型【1-利息，2-融资，3-融资本息，4-无】
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * CHAR(1)<br>
     * 设置 利率类型【1-利息，2-融资，3-融资本息，4-无】
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 尾款是否进入卖方账户标志【1-是，2-否】
     */
    public String getToSallerFlag() {
        return toSallerFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 尾款是否进入卖方账户标志【1-是，2-否】
     */
    public void setToSallerFlag(String toSallerFlag) {
        this.toSallerFlag = toSallerFlag == null ? null : toSallerFlag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还款金额
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还款金额
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
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
     * CHAR(1)<br>
     * 获得 还款方式【1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款】
     */
    public String getReturnMethod() {
        return returnMethod;
    }

    /**
     * CHAR(1)<br>
     * 设置 还款方式【1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款】
     */
    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod == null ? null : returnMethod.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还息金额
     */
    public BigDecimal getReturnInterestAmount() {
        return returnInterestAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还息金额
     */
    public void setReturnInterestAmount(BigDecimal returnInterestAmount) {
        this.returnInterestAmount = returnInterestAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还本金额
     */
    public BigDecimal getReturnCapitalAmount() {
        return returnCapitalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还本金额
     */
    public void setReturnCapitalAmount(BigDecimal returnCapitalAmount) {
        this.returnCapitalAmount = returnCapitalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入卖方结算账号金额
     */
    public BigDecimal getToSallerAmount() {
        return toSallerAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入卖方结算账号金额
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
     * VARCHAR(50)<br>
     * 获得 回款账号
     */
    public String getReturnAccount() {
        return returnAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 回款账号
     */
    public void setReturnAccount(String returnAccount) {
        this.returnAccount = returnAccount == null ? null : returnAccount.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 入账交易编号
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 入账交易编号
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo == null ? null : transactionNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次入保证金金额
     */
    public BigDecimal getTobailAmount() {
        return tobailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次入保证金金额
     */
    public void setTobailAmount(BigDecimal tobailAmount) {
        this.tobailAmount = tobailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次核销金额
     */
    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次核销金额
     */
    public void setRebateAmount(BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入账账户(回款账户)余额
     */
    public BigDecimal getReturnAccountBalance() {
        return returnAccountBalance;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入账账户(回款账户)余额
     */
    public void setReturnAccountBalance(BigDecimal returnAccountBalance) {
        this.returnAccountBalance = returnAccountBalance;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次总计尾款金额
     */
    public BigDecimal getTotalOverAmount() {
        return totalOverAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次总计尾款金额
     */
    public void setTotalOverAmount(BigDecimal totalOverAmount) {
        this.totalOverAmount = totalOverAmount;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 回款结算方式：1-票据、2-汇款
     */
    public String getSettleMethod() {
        return settleMethod;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 回款结算方式：1-票据、2-汇款
     */
    public void setSettleMethod(String settleMethod) {
        this.settleMethod = settleMethod == null ? null : settleMethod.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 回款用途：01-入保证金、02-还贷、03-尾款
     */
    public String getRepayPurpose() {
        return repayPurpose;
    }

    /**
     * CHAR(2)<br>
     * 设置 回款用途：01-入保证金、02-还贷、03-尾款
     */
    public void setRepayPurpose(String repayPurpose) {
        this.repayPurpose = repayPurpose == null ? null : repayPurpose.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 转账金额
     */
    public BigDecimal getTransferAmt() {
        return transferAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 转账金额
     */
    public void setTransferAmt(BigDecimal transferAmt) {
        this.transferAmt = transferAmt;
    }

    /**
     * DATE(7)<br>
     * 获得 交易日期
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * DATE(7)<br>
     * 设置 交易日期
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * VARCHAR(120)<br>
     * 获得 客户名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(120)<br>
     * 设置 客户名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * VARCHAR(120)<br>
     * 获得 客户英文名
     */
    public String getEname() {
        return ename;
    }

    /**
     * VARCHAR(120)<br>
     * 设置 客户英文名
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 客户别名
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 客户别名
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 组织机构代码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 组织机构代码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 客户状态(DATA_DIC.840)
     */
    public String getCustStatus() {
        return custStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 客户状态(DATA_DIC.840)
     */
    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus == null ? null : custStatus.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 管户员
     */
    public String getMgrno() {
        return mgrno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 管户员
     */
    public void setMgrno(String mgrno) {
        this.mgrno = mgrno == null ? null : mgrno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否核心厂商：0-否、1-是
     */
    public String getCoreFlag() {
        return coreFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否核心厂商：0-否、1-是
     */
    public void setCoreFlag(String coreFlag) {
        this.coreFlag = coreFlag == null ? null : coreFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否监管公司：0-否、1-是
     */
    public String getMoniFlag() {
        return moniFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否监管公司：0-否、1-是
     */
    public void setMoniFlag(String moniFlag) {
        this.moniFlag = moniFlag == null ? null : moniFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否期货经纪公司；0-否、1-是
     */
    public String getFuturesFlag() {
        return futuresFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否期货经纪公司；0-否、1-是
     */
    public void setFuturesFlag(String futuresFlag) {
        this.futuresFlag = futuresFlag == null ? null : futuresFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否金融租赁公司：0-否、1-是
     */
    public String getFlcFlag() {
        return flcFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否金融租赁公司：0-否、1-是
     */
    public void setFlcFlag(String flcFlag) {
        this.flcFlag = flcFlag == null ? null : flcFlag.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 管户机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 管户机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * DATE(7)<br>
     * 获得 建档日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * DATE(7)<br>
     * 设置 建档日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * CHAR(1)<br>
     * 获得 授信客户标识：0-否、1-是
     */
    public String getCreditFlag() {
        return creditFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 授信客户标识：0-否、1-是
     */
    public void setCreditFlag(String creditFlag) {
        this.creditFlag = creditFlag == null ? null : creditFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 黑名单标识：0-否、1-是
     */
    public String getBlackFlag() {
        return blackFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 黑名单标识：0-否、1-是
     */
    public void setBlackFlag(String blackFlag) {
        this.blackFlag = blackFlag == null ? null : blackFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否保险公司：0-否、1-是
     */
    public String getInsureFlag() {
        return insureFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否保险公司：0-否、1-是
     */
    public void setInsureFlag(String insureFlag) {
        this.insureFlag = insureFlag == null ? null : insureFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否保理商：0-否、1-是
     */
    public String getFactorFlag() {
        return factorFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否保理商：0-否、1-是
     */
    public void setFactorFlag(String factorFlag) {
        this.factorFlag = factorFlag == null ? null : factorFlag.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 信贷客户号
     */
    public String getCcmsCustcd() {
        return ccmsCustcd;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 信贷客户号
     */
    public void setCcmsCustcd(String ccmsCustcd) {
        this.ccmsCustcd = ccmsCustcd == null ? null : ccmsCustcd.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否贸融重点客户：0-否、1-是
     */
    public String getImportantFlag() {
        return importantFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否贸融重点客户：0-否、1-是
     */
    public void setImportantFlag(String importantFlag) {
        this.importantFlag = importantFlag == null ? null : importantFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否贸易对手：0-否、1-是
     */
    public String getCommercialFalg() {
        return commercialFalg;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否贸易对手：0-否、1-是
     */
    public void setCommercialFalg(String commercialFalg) {
        this.commercialFalg = commercialFalg == null ? null : commercialFalg.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否境外：0-否、1-是
     */
    public String getOverseasFlag() {
        return overseasFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否境外：0-否、1-是
     */
    public void setOverseasFlag(String overseasFlag) {
        this.overseasFlag = overseasFlag == null ? null : overseasFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否是本行客户：0-否、1-是
     */
    public String getBanksCustFlag() {
        return banksCustFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否是本行客户：0-否、1-是
     */
    public void setBanksCustFlag(String banksCustFlag) {
        this.banksCustFlag = banksCustFlag == null ? null : banksCustFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否是EF进口商：0-否、1-是
     */
    public String getEfBuyerFlag() {
        return efBuyerFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否是EF进口商：0-否、1-是
     */
    public void setEfBuyerFlag(String efBuyerFlag) {
        this.efBuyerFlag = efBuyerFlag == null ? null : efBuyerFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否是IF出口商：0-否、1-是
     */
    public String getIfSellerFlag() {
        return ifSellerFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否是IF出口商：0-否、1-是
     */
    public void setIfSellerFlag(String ifSellerFlag) {
        this.ifSellerFlag = ifSellerFlag == null ? null : ifSellerFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否是银行：0-否、1-是
     */
    public String getIsBank() {
        return isBank;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否是银行：0-否、1-是
     */
    public void setIsBank(String isBank) {
        this.isBank = isBank == null ? null : isBank.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 FCI代号
     */
    public String getFciCode() {
        return fciCode;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 FCI代号
     */
    public void setFciCode(String fciCode) {
        this.fciCode = fciCode == null ? null : fciCode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否国际保理客户
     */
    public String getIsIntl() {
        return isIntl;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否国际保理客户
     */
    public void setIsIntl(String isIntl) {
        this.isIntl = isIntl == null ? null : isIntl.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 企业类型
     */
    public String getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * CHAR(1)<br>
     * 设置 企业类型
     */
    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 国标行业分类
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 国标行业分类
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType == null ? null : industryType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 企业规模
     */
    public String getEnterpriseScope() {
        return enterpriseScope;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 企业规模
     */
    public void setEnterpriseScope(String enterpriseScope) {
        this.enterpriseScope = enterpriseScope == null ? null : enterpriseScope.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 客户等级(DATA_DIC.11255)
     */
    public String getCustLevel() {
        return custLevel;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 客户等级(DATA_DIC.11255)
     */
    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel == null ? null : custLevel.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 厂商等级：00:全国性核心厂商，01：区域性核心厂商,02：单笔单批
     */
    public String getCoreLevel() {
        return coreLevel;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 厂商等级：00:全国性核心厂商，01：区域性核心厂商,02：单笔单批
     */
    public void setCoreLevel(String coreLevel) {
        this.coreLevel = coreLevel == null ? null : coreLevel.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 供应链所处地位
     */
    public String getSupplyPosition() {
        return supplyPosition;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 供应链所处地位
     */
    public void setSupplyPosition(String supplyPosition) {
        this.supplyPosition = supplyPosition == null ? null : supplyPosition.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 机构名称
     */
    public String getBrname() {
        return brname;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 机构名称
     */
    public void setBrname(String brname) {
        this.brname = brname == null ? null : brname.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 机构级别：0-虚拟总行、1-总行、2-分行、3-一级支行、4-二级支行
     */
    public String getBrclass() {
        return brclass;
    }

    /**
     * CHAR(1)<br>
     * 设置 机构级别：0-虚拟总行、1-总行、2-分行、3-一级支行、4-二级支行
     */
    public void setBrclass(String brclass) {
        this.brclass = brclass == null ? null : brclass.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 机构名称(BUSS)
     */
    public String getBrnameBuss() {
        return brnameBuss;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 机构名称(BUSS)
     */
    public void setBrnameBuss(String brnameBuss) {
        this.brnameBuss = brnameBuss == null ? null : brnameBuss.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 操作员名称
     */
    public String getTlrName() {
        return tlrName;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 操作员名称
     */
    public void setTlrName(String tlrName) {
        this.tlrName = tlrName == null ? null : tlrName.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务合同号
     */
    public String getDebtContno() {
        return debtContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务合同号
     */
    public void setDebtContno(String debtContno) {
        this.debtContno = debtContno == null ? null : debtContno.trim();
    }

    /**
     * DECIMAL(9,6)<br>
     * 获得 融资比例(%)
     */
    public BigDecimal getLoanPercent() {
        return loanPercent;
    }

    /**
     * DECIMAL(9,6)<br>
     * 设置 融资比例(%)
     */
    public void setLoanPercent(BigDecimal loanPercent) {
        this.loanPercent = loanPercent;
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保理业务类别
     */
    public String getFactType() {
        return factType;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保理业务类别
     */
    public void setFactType(String factType) {
        this.factType = factType == null ? null : factType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 融资模式：1-发票融资;2-池融资
     */
    public String getFinancingType() {
        return financingType;
    }

    /**
     * CHAR(1)<br>
     * 设置 融资模式：1-发票融资;2-池融资
     */
    public void setFinancingType(String financingType) {
        this.financingType = financingType == null ? null : financingType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 费用收取方式：01-按年，02-单笔
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(2)<br>
     * 设置 费用收取方式：01-按年，02-单笔
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * CHAR(2)<br>
     * 设置 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 是否自动还款：00-否、01-是
     */
    public String getIsAutoPay() {
        return isAutoPay;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 是否自动还款：00-否、01-是
     */
    public void setIsAutoPay(String isAutoPay) {
        this.isAutoPay = isAutoPay == null ? null : isAutoPay.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 自动提前还款天数
     */
    public BigDecimal getAutoPayDays() {
        return autoPayDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 自动提前还款天数
     */
    public void setAutoPayDays(BigDecimal autoPayDays) {
        this.autoPayDays = autoPayDays;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 服务内容：保理融资;账款管理;应收租金催收;坏账担保
     */
    public String getServiceContent() {
        return serviceContent;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 服务内容：保理融资;账款管理;应收租金催收;坏账担保
     */
    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    public String getSupplyChainPdId() {
        return supplyChainPdId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    public void setSupplyChainPdId(String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户号(卖方)
     */
    public String getCustcdCont() {
        return custcdCont;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户号(卖方)
     */
    public void setCustcdCont(String custcdCont) {
        this.custcdCont = custcdCont == null ? null : custcdCont.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 合同币种
     */
    public String getCurcdCont() {
        return curcdCont;
    }

    /**
     * CHAR(3)<br>
     * 设置 合同币种
     */
    public void setCurcdCont(String curcdCont) {
        this.curcdCont = curcdCont == null ? null : curcdCont.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 额度金额
     */
    public BigDecimal getContAmount() {
        return contAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 额度金额
     */
    public void setContAmount(BigDecimal contAmount) {
        this.contAmount = contAmount;
    }

    /**
     * DATE(7)<br>
     * 获得 合同生效日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * DATE(7)<br>
     * 设置 合同生效日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * DATE(7)<br>
     * 获得 合同到期日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * DATE(7)<br>
     * 设置 合同到期日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 出账方式：01-流贷；02-承兑；03-预支价金
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 出账方式：01-流贷；02-承兑；03-预支价金
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay == null ? null : loanWay.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 合同状态
     */
    public String getContStatus() {
        return contStatus;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 合同状态
     */
    public void setContStatus(String contStatus) {
        this.contStatus = contStatus == null ? null : contStatus.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 结算账号
     */
    public String getContAccountNo() {
        return contAccountNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 结算账号
     */
    public void setContAccountNo(String contAccountNo) {
        this.contAccountNo = contAccountNo == null ? null : contAccountNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户经理
     */
    public String getMgrnoCont() {
        return mgrnoCont;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户经理
     */
    public void setMgrnoCont(String mgrnoCont) {
        this.mgrnoCont = mgrnoCont == null ? null : mgrnoCont.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdBrcode() {
        return lastUpdBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdBrcode(String lastUpdBrcode) {
        this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新人
     */
    public String getLastUpdTlrno() {
        return lastUpdTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新人
     */
    public void setLastUpdTlrno(String lastUpdTlrno) {
        this.lastUpdTlrno = lastUpdTlrno == null ? null : lastUpdTlrno.trim();
    }

    /**
     * DATE(7)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdDate() {
        return lastUpdDate;
    }

    /**
     * DATE(7)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构号
     */
    public String getBrcodeCont() {
        return brcodeCont;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构号
     */
    public void setBrcodeCont(String brcodeCont) {
        this.brcodeCont = brcodeCont == null ? null : brcodeCont.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 池保证金账号
     */
    public String getBailAcctNo() {
        return bailAcctNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 池保证金账号
     */
    public void setBailAcctNo(String bailAcctNo) {
        this.bailAcctNo = bailAcctNo == null ? null : bailAcctNo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 回款专户
     */
    public String getContRetuAccount() {
        return contRetuAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 回款专户
     */
    public void setContRetuAccount(String contRetuAccount) {
        this.contRetuAccount = contRetuAccount == null ? null : contRetuAccount.trim();
    }

    /**
     * VARCHAR(1)<br>
     * 获得 有无追索权：1-有追索;2-无追索
     */
    public String getRecoverType() {
        return recoverType;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 有无追索权：1-有追索;2-无追索
     */
    public void setRecoverType(String recoverType) {
        this.recoverType = recoverType == null ? null : recoverType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 回款用途:01-入借据保证金;02-还贷
     */
    public String getContRepayPurpose() {
        return contRepayPurpose;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 回款用途:01-入借据保证金;02-还贷
     */
    public void setContRepayPurpose(String contRepayPurpose) {
        this.contRepayPurpose = contRepayPurpose == null ? null : contRepayPurpose.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 尾款规则:01-入结算账户;02-留存回款专户
     */
    public String getDueBalanceRule() {
        return dueBalanceRule;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 尾款规则:01-入结算账户;02-留存回款专户
     */
    public void setDueBalanceRule(String dueBalanceRule) {
        this.dueBalanceRule = dueBalanceRule == null ? null : dueBalanceRule.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 回款核销规则:01-先到期先核销;02-平均分配核销
     */
    public String getPaymentVerifyRule() {
        return paymentVerifyRule;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 回款核销规则:01-先到期先核销;02-平均分配核销
     */
    public void setPaymentVerifyRule(String paymentVerifyRule) {
        this.paymentVerifyRule = paymentVerifyRule == null ? null : paymentVerifyRule.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 赔款转让协议号
     */
    public String getReparationProtNo() {
        return reparationProtNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 赔款转让协议号
     */
    public void setReparationProtNo(String reparationProtNo) {
        this.reparationProtNo = reparationProtNo == null ? null : reparationProtNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
     */
    public String getLease() {
        return lease;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
     */
    public void setLease(String lease) {
        this.lease = lease == null ? null : lease.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 反转让方
     */
    public String getRepurchaser() {
        return repurchaser;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 反转让方
     */
    public void setRepurchaser(String repurchaser) {
        this.repurchaser = repurchaser == null ? null : repurchaser.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 反转让协议号
     */
    public String getRepurchaseProtNo() {
        return repurchaseProtNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 反转让协议号
     */
    public void setRepurchaseProtNo(String repurchaseProtNo) {
        this.repurchaseProtNo = repurchaseProtNo == null ? null : repurchaseProtNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 买方保理商客户号
     */
    public String getFactoringBrcode() {
        return factoringBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 买方保理商客户号
     */
    public void setFactoringBrcode(String factoringBrcode) {
        this.factoringBrcode = factoringBrcode == null ? null : factoringBrcode.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 赔款期限(天)
     */
    public BigDecimal getReparationTerm() {
        return reparationTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 赔款期限(天)
     */
    public void setReparationTerm(BigDecimal reparationTerm) {
        this.reparationTerm = reparationTerm;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 赔付比例(%)
     */
    public BigDecimal getReparationPercent() {
        return reparationPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 赔付比例(%)
     */
    public void setReparationPercent(BigDecimal reparationPercent) {
        this.reparationPercent = reparationPercent;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计赔款金额
     */
    public BigDecimal getCumulativeReparationAmt() {
        return cumulativeReparationAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计赔款金额
     */
    public void setCumulativeReparationAmt(BigDecimal cumulativeReparationAmt) {
        this.cumulativeReparationAmt = cumulativeReparationAmt;
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保理方式：1-明保理;2-暗保理
     */
    public String getFactPattern() {
        return factPattern;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保理方式：1-明保理;2-暗保理
     */
    public void setFactPattern(String factPattern) {
        this.factPattern = factPattern == null ? null : factPattern.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 合作机构（村镇银行）
     */
    public String getCooperationBrcode() {
        return cooperationBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 合作机构（村镇银行）
     */
    public void setCooperationBrcode(String cooperationBrcode) {
        this.cooperationBrcode = cooperationBrcode == null ? null : cooperationBrcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 租金处理方式：1-质押、2-转让
     */
    public String getRentSettleWay() {
        return rentSettleWay;
    }

    /**
     * CHAR(1)<br>
     * 设置 租金处理方式：1-质押、2-转让
     */
    public void setRentSettleWay(String rentSettleWay) {
        this.rentSettleWay = rentSettleWay == null ? null : rentSettleWay.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 池保证金余额
     */
    public BigDecimal getPoolBailAmt() {
        return poolBailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 池保证金余额
     */
    public void setPoolBailAmt(BigDecimal poolBailAmt) {
        this.poolBailAmt = poolBailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 有效金额
     */
    public BigDecimal getSumdebtBillsAmount() {
        return sumdebtBillsAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 有效金额
     */
    public void setSumdebtBillsAmount(BigDecimal sumdebtBillsAmount) {
        this.sumdebtBillsAmount = sumdebtBillsAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 票面金额
     */
    public BigDecimal getSumdebtBillsAmountView() {
        return sumdebtBillsAmountView;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 票面金额
     */
    public void setSumdebtBillsAmountView(BigDecimal sumdebtBillsAmountView) {
        this.sumdebtBillsAmountView = sumdebtBillsAmountView;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收账款余额
     */
    public BigDecimal getSumdebtRemainingAmount() {
        return sumdebtRemainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收账款余额
     */
    public void setSumdebtRemainingAmount(BigDecimal sumdebtRemainingAmount) {
        this.sumdebtRemainingAmount = sumdebtRemainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可用融资余额
     */
    public BigDecimal getSumdebtRemainingUseableAmou() {
        return sumdebtRemainingUseableAmou;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可用融资余额
     */
    public void setSumdebtRemainingUseableAmou(BigDecimal sumdebtRemainingUseableAmou) {
        this.sumdebtRemainingUseableAmou = sumdebtRemainingUseableAmou;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 折让金额
     */
    public BigDecimal getSumdebtRebateAmount() {
        return sumdebtRebateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 折让金额
     */
    public void setSumdebtRebateAmount(BigDecimal sumdebtRebateAmount) {
        this.sumdebtRebateAmount = sumdebtRebateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 回购金额
     */
    public BigDecimal getSumdebtBuyBackAmount() {
        return sumdebtBuyBackAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 回购金额
     */
    public void setSumdebtBuyBackAmount(BigDecimal sumdebtBuyBackAmount) {
        this.sumdebtBuyBackAmount = sumdebtBuyBackAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 付款金额
     */
    public BigDecimal getSumdebtPayAmount() {
        return sumdebtPayAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 付款金额
     */
    public void setSumdebtPayAmount(BigDecimal sumdebtPayAmount) {
        this.sumdebtPayAmount = sumdebtPayAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入账金额
     */
    public BigDecimal getSumdebtRemoveAmount() {
        return sumdebtRemoveAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入账金额
     */
    public void setSumdebtRemoveAmount(BigDecimal sumdebtRemoveAmount) {
        this.sumdebtRemoveAmount = sumdebtRemoveAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 现金余额
     */
    public BigDecimal getSumdebtCashRemainingAmount() {
        return sumdebtCashRemainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 现金余额
     */
    public void setSumdebtCashRemainingAmount(BigDecimal sumdebtCashRemainingAmount) {
        this.sumdebtCashRemainingAmount = sumdebtCashRemainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 瑕疵标记：1-有瑕疵、0-无瑕疵
     */
    public BigDecimal getSumamtDebtFlawFlag() {
        return sumamtDebtFlawFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 瑕疵标记：1-有瑕疵、0-无瑕疵
     */
    public void setSumamtDebtFlawFlag(BigDecimal sumamtDebtFlawFlag) {
        this.sumamtDebtFlawFlag = sumamtDebtFlawFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 商纠状态：1-有商纠、0-无商纠
     */
    public BigDecimal getSumamtDebtIssueFlag() {
        return sumamtDebtIssueFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 商纠状态：1-有商纠、0-无商纠
     */
    public void setSumamtDebtIssueFlag(BigDecimal sumamtDebtIssueFlag) {
        this.sumamtDebtIssueFlag = sumamtDebtIssueFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 逾期状态：1-有、0-无
     */
    public BigDecimal getSumamtDebtOverdueFlag() {
        return sumamtDebtOverdueFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 逾期状态：1-有、0-无
     */
    public void setSumamtDebtOverdueFlag(BigDecimal sumamtDebtOverdueFlag) {
        this.sumamtDebtOverdueFlag = sumamtDebtOverdueFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 是否呆账：1-有、0-无
     */
    public BigDecimal getSumamtDebtBadFlag() {
        return sumamtDebtBadFlag;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 是否呆账：1-有、0-无
     */
    public void setSumamtDebtBadFlag(BigDecimal sumamtDebtBadFlag) {
        this.sumamtDebtBadFlag = sumamtDebtBadFlag;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", inputdate=").append(inputdate);
        sb.append(", applyType=").append(applyType);
        sb.append(", custcdSaller=").append(custcdSaller);
        sb.append(", custcdBuyer=").append(custcdBuyer);
        sb.append(", appno=").append(appno);
        sb.append(", cnameBuyer=").append(cnameBuyer);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", debtNum=").append(debtNum);
        sb.append(", totalDebtAmount=").append(totalDebtAmount);
        sb.append(", finacingCost=").append(finacingCost);
        sb.append(", cost=").append(cost);
        sb.append(", handlingFee=").append(handlingFee);
        sb.append(", reduceAmount=").append(reduceAmount);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", totalReduce=").append(totalReduce);
        sb.append(", receiveAmount=").append(receiveAmount);
        sb.append(", bussType=").append(bussType);
        sb.append(", loanType=").append(loanType);
        sb.append(", bankno=").append(bankno);
        sb.append(", amount=").append(amount);
        sb.append(", appDate=").append(appDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", curcd=").append(curcd);
        sb.append(", memo=").append(memo);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcodeBuss=").append(brcodeBuss);
        sb.append(", returnType=").append(returnType);
        sb.append(", toSallerFlag=").append(toSallerFlag);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", returnMethod=").append(returnMethod);
        sb.append(", returnInterestAmount=").append(returnInterestAmount);
        sb.append(", returnCapitalAmount=").append(returnCapitalAmount);
        sb.append(", toSallerAmount=").append(toSallerAmount);
        sb.append(", toPoolAmount=").append(toPoolAmount);
        sb.append(", returnAccount=").append(returnAccount);
        sb.append(", transactionNo=").append(transactionNo);
        sb.append(", tobailAmount=").append(tobailAmount);
        sb.append(", rebateAmount=").append(rebateAmount);
        sb.append(", returnAccountBalance=").append(returnAccountBalance);
        sb.append(", totalOverAmount=").append(totalOverAmount);
        sb.append(", settleMethod=").append(settleMethod);
        sb.append(", repayPurpose=").append(repayPurpose);
        sb.append(", transferAmt=").append(transferAmt);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", cname=").append(cname);
        sb.append(", ename=").append(ename);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", custStatus=").append(custStatus);
        sb.append(", mgrno=").append(mgrno);
        sb.append(", coreFlag=").append(coreFlag);
        sb.append(", moniFlag=").append(moniFlag);
        sb.append(", futuresFlag=").append(futuresFlag);
        sb.append(", flcFlag=").append(flcFlag);
        sb.append(", brcode=").append(brcode);
        sb.append(", createDate=").append(createDate);
        sb.append(", creditFlag=").append(creditFlag);
        sb.append(", blackFlag=").append(blackFlag);
        sb.append(", insureFlag=").append(insureFlag);
        sb.append(", factorFlag=").append(factorFlag);
        sb.append(", ccmsCustcd=").append(ccmsCustcd);
        sb.append(", importantFlag=").append(importantFlag);
        sb.append(", commercialFalg=").append(commercialFalg);
        sb.append(", overseasFlag=").append(overseasFlag);
        sb.append(", banksCustFlag=").append(banksCustFlag);
        sb.append(", efBuyerFlag=").append(efBuyerFlag);
        sb.append(", ifSellerFlag=").append(ifSellerFlag);
        sb.append(", isBank=").append(isBank);
        sb.append(", fciCode=").append(fciCode);
        sb.append(", isIntl=").append(isIntl);
        sb.append(", enterpriseType=").append(enterpriseType);
        sb.append(", industryType=").append(industryType);
        sb.append(", enterpriseScope=").append(enterpriseScope);
        sb.append(", custLevel=").append(custLevel);
        sb.append(", coreLevel=").append(coreLevel);
        sb.append(", supplyPosition=").append(supplyPosition);
        sb.append(", brname=").append(brname);
        sb.append(", brclass=").append(brclass);
        sb.append(", brnameBuss=").append(brnameBuss);
        sb.append(", tlrName=").append(tlrName);
        sb.append(", productName=").append(productName);
        sb.append(", debtContno=").append(debtContno);
        sb.append(", loanPercent=").append(loanPercent);
        sb.append(", factType=").append(factType);
        sb.append(", financingType=").append(financingType);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", isAutoPay=").append(isAutoPay);
        sb.append(", autoPayDays=").append(autoPayDays);
        sb.append(", serviceContent=").append(serviceContent);
        sb.append(", supplyChainPdId=").append(supplyChainPdId);
        sb.append(", custcdCont=").append(custcdCont);
        sb.append(", curcdCont=").append(curcdCont);
        sb.append(", contAmount=").append(contAmount);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", loanWay=").append(loanWay);
        sb.append(", contStatus=").append(contStatus);
        sb.append(", contAccountNo=").append(contAccountNo);
        sb.append(", mgrnoCont=").append(mgrnoCont);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
        sb.append(", lastUpdTlrno=").append(lastUpdTlrno);
        sb.append(", lastUpdDate=").append(lastUpdDate);
        sb.append(", brcodeCont=").append(brcodeCont);
        sb.append(", bailAcctNo=").append(bailAcctNo);
        sb.append(", contRetuAccount=").append(contRetuAccount);
        sb.append(", recoverType=").append(recoverType);
        sb.append(", contRepayPurpose=").append(contRepayPurpose);
        sb.append(", dueBalanceRule=").append(dueBalanceRule);
        sb.append(", paymentVerifyRule=").append(paymentVerifyRule);
        sb.append(", reparationProtNo=").append(reparationProtNo);
        sb.append(", lease=").append(lease);
        sb.append(", repurchaser=").append(repurchaser);
        sb.append(", repurchaseProtNo=").append(repurchaseProtNo);
        sb.append(", factoringBrcode=").append(factoringBrcode);
        sb.append(", reparationTerm=").append(reparationTerm);
        sb.append(", reparationPercent=").append(reparationPercent);
        sb.append(", cumulativeReparationAmt=").append(cumulativeReparationAmt);
        sb.append(", factPattern=").append(factPattern);
        sb.append(", cooperationBrcode=").append(cooperationBrcode);
        sb.append(", rentSettleWay=").append(rentSettleWay);
        sb.append(", poolBailAmt=").append(poolBailAmt);
        sb.append(", sumdebtBillsAmount=").append(sumdebtBillsAmount);
        sb.append(", sumdebtBillsAmountView=").append(sumdebtBillsAmountView);
        sb.append(", sumdebtRemainingAmount=").append(sumdebtRemainingAmount);
        sb.append(", sumdebtRemainingUseableAmou=").append(sumdebtRemainingUseableAmou);
        sb.append(", sumdebtRebateAmount=").append(sumdebtRebateAmount);
        sb.append(", sumdebtBuyBackAmount=").append(sumdebtBuyBackAmount);
        sb.append(", sumdebtPayAmount=").append(sumdebtPayAmount);
        sb.append(", sumdebtRemoveAmount=").append(sumdebtRemoveAmount);
        sb.append(", sumdebtCashRemainingAmount=").append(sumdebtCashRemainingAmount);
        sb.append(", sumamtDebtFlawFlag=").append(sumamtDebtFlawFlag);
        sb.append(", sumamtDebtIssueFlag=").append(sumamtDebtIssueFlag);
        sb.append(", sumamtDebtOverdueFlag=").append(sumamtDebtOverdueFlag);
        sb.append(", sumamtDebtBadFlag=").append(sumamtDebtBadFlag);
        sb.append(", custcd=").append(custcd);
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
        BQueryDebtM other = (BQueryDebtM) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInputdate() == null ? other.getInputdate() == null : this.getInputdate().equals(other.getInputdate()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
            && (this.getCustcdSaller() == null ? other.getCustcdSaller() == null : this.getCustcdSaller().equals(other.getCustcdSaller()))
            && (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCnameBuyer() == null ? other.getCnameBuyer() == null : this.getCnameBuyer().equals(other.getCnameBuyer()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getDebtNum() == null ? other.getDebtNum() == null : this.getDebtNum().equals(other.getDebtNum()))
            && (this.getTotalDebtAmount() == null ? other.getTotalDebtAmount() == null : this.getTotalDebtAmount().equals(other.getTotalDebtAmount()))
            && (this.getFinacingCost() == null ? other.getFinacingCost() == null : this.getFinacingCost().equals(other.getFinacingCost()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getHandlingFee() == null ? other.getHandlingFee() == null : this.getHandlingFee().equals(other.getHandlingFee()))
            && (this.getReduceAmount() == null ? other.getReduceAmount() == null : this.getReduceAmount().equals(other.getReduceAmount()))
            && (this.getTotalFee() == null ? other.getTotalFee() == null : this.getTotalFee().equals(other.getTotalFee()))
            && (this.getTotalReduce() == null ? other.getTotalReduce() == null : this.getTotalReduce().equals(other.getTotalReduce()))
            && (this.getReceiveAmount() == null ? other.getReceiveAmount() == null : this.getReceiveAmount().equals(other.getReceiveAmount()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getBankno() == null ? other.getBankno() == null : this.getBankno().equals(other.getBankno()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
            && (this.getReturnDate() == null ? other.getReturnDate() == null : this.getReturnDate().equals(other.getReturnDate()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcodeBuss() == null ? other.getBrcodeBuss() == null : this.getBrcodeBuss().equals(other.getBrcodeBuss()))
            && (this.getReturnType() == null ? other.getReturnType() == null : this.getReturnType().equals(other.getReturnType()))
            && (this.getToSallerFlag() == null ? other.getToSallerFlag() == null : this.getToSallerFlag().equals(other.getToSallerFlag()))
            && (this.getReturnAmount() == null ? other.getReturnAmount() == null : this.getReturnAmount().equals(other.getReturnAmount()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getReturnMethod() == null ? other.getReturnMethod() == null : this.getReturnMethod().equals(other.getReturnMethod()))
            && (this.getReturnInterestAmount() == null ? other.getReturnInterestAmount() == null : this.getReturnInterestAmount().equals(other.getReturnInterestAmount()))
            && (this.getReturnCapitalAmount() == null ? other.getReturnCapitalAmount() == null : this.getReturnCapitalAmount().equals(other.getReturnCapitalAmount()))
            && (this.getToSallerAmount() == null ? other.getToSallerAmount() == null : this.getToSallerAmount().equals(other.getToSallerAmount()))
            && (this.getToPoolAmount() == null ? other.getToPoolAmount() == null : this.getToPoolAmount().equals(other.getToPoolAmount()))
            && (this.getReturnAccount() == null ? other.getReturnAccount() == null : this.getReturnAccount().equals(other.getReturnAccount()))
            && (this.getTransactionNo() == null ? other.getTransactionNo() == null : this.getTransactionNo().equals(other.getTransactionNo()))
            && (this.getTobailAmount() == null ? other.getTobailAmount() == null : this.getTobailAmount().equals(other.getTobailAmount()))
            && (this.getRebateAmount() == null ? other.getRebateAmount() == null : this.getRebateAmount().equals(other.getRebateAmount()))
            && (this.getReturnAccountBalance() == null ? other.getReturnAccountBalance() == null : this.getReturnAccountBalance().equals(other.getReturnAccountBalance()))
            && (this.getTotalOverAmount() == null ? other.getTotalOverAmount() == null : this.getTotalOverAmount().equals(other.getTotalOverAmount()))
            && (this.getSettleMethod() == null ? other.getSettleMethod() == null : this.getSettleMethod().equals(other.getSettleMethod()))
            && (this.getRepayPurpose() == null ? other.getRepayPurpose() == null : this.getRepayPurpose().equals(other.getRepayPurpose()))
            && (this.getTransferAmt() == null ? other.getTransferAmt() == null : this.getTransferAmt().equals(other.getTransferAmt()))
            && (this.getTransactionDate() == null ? other.getTransactionDate() == null : this.getTransactionDate().equals(other.getTransactionDate()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
            && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
            && (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
            && (this.getCoreFlag() == null ? other.getCoreFlag() == null : this.getCoreFlag().equals(other.getCoreFlag()))
            && (this.getMoniFlag() == null ? other.getMoniFlag() == null : this.getMoniFlag().equals(other.getMoniFlag()))
            && (this.getFuturesFlag() == null ? other.getFuturesFlag() == null : this.getFuturesFlag().equals(other.getFuturesFlag()))
            && (this.getFlcFlag() == null ? other.getFlcFlag() == null : this.getFlcFlag().equals(other.getFlcFlag()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreditFlag() == null ? other.getCreditFlag() == null : this.getCreditFlag().equals(other.getCreditFlag()))
            && (this.getBlackFlag() == null ? other.getBlackFlag() == null : this.getBlackFlag().equals(other.getBlackFlag()))
            && (this.getInsureFlag() == null ? other.getInsureFlag() == null : this.getInsureFlag().equals(other.getInsureFlag()))
            && (this.getFactorFlag() == null ? other.getFactorFlag() == null : this.getFactorFlag().equals(other.getFactorFlag()))
            && (this.getCcmsCustcd() == null ? other.getCcmsCustcd() == null : this.getCcmsCustcd().equals(other.getCcmsCustcd()))
            && (this.getImportantFlag() == null ? other.getImportantFlag() == null : this.getImportantFlag().equals(other.getImportantFlag()))
            && (this.getCommercialFalg() == null ? other.getCommercialFalg() == null : this.getCommercialFalg().equals(other.getCommercialFalg()))
            && (this.getOverseasFlag() == null ? other.getOverseasFlag() == null : this.getOverseasFlag().equals(other.getOverseasFlag()))
            && (this.getBanksCustFlag() == null ? other.getBanksCustFlag() == null : this.getBanksCustFlag().equals(other.getBanksCustFlag()))
            && (this.getEfBuyerFlag() == null ? other.getEfBuyerFlag() == null : this.getEfBuyerFlag().equals(other.getEfBuyerFlag()))
            && (this.getIfSellerFlag() == null ? other.getIfSellerFlag() == null : this.getIfSellerFlag().equals(other.getIfSellerFlag()))
            && (this.getIsBank() == null ? other.getIsBank() == null : this.getIsBank().equals(other.getIsBank()))
            && (this.getFciCode() == null ? other.getFciCode() == null : this.getFciCode().equals(other.getFciCode()))
            && (this.getIsIntl() == null ? other.getIsIntl() == null : this.getIsIntl().equals(other.getIsIntl()))
            && (this.getEnterpriseType() == null ? other.getEnterpriseType() == null : this.getEnterpriseType().equals(other.getEnterpriseType()))
            && (this.getIndustryType() == null ? other.getIndustryType() == null : this.getIndustryType().equals(other.getIndustryType()))
            && (this.getEnterpriseScope() == null ? other.getEnterpriseScope() == null : this.getEnterpriseScope().equals(other.getEnterpriseScope()))
            && (this.getCustLevel() == null ? other.getCustLevel() == null : this.getCustLevel().equals(other.getCustLevel()))
            && (this.getCoreLevel() == null ? other.getCoreLevel() == null : this.getCoreLevel().equals(other.getCoreLevel()))
            && (this.getSupplyPosition() == null ? other.getSupplyPosition() == null : this.getSupplyPosition().equals(other.getSupplyPosition()))
            && (this.getBrname() == null ? other.getBrname() == null : this.getBrname().equals(other.getBrname()))
            && (this.getBrclass() == null ? other.getBrclass() == null : this.getBrclass().equals(other.getBrclass()))
            && (this.getBrnameBuss() == null ? other.getBrnameBuss() == null : this.getBrnameBuss().equals(other.getBrnameBuss()))
            && (this.getTlrName() == null ? other.getTlrName() == null : this.getTlrName().equals(other.getTlrName()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getDebtContno() == null ? other.getDebtContno() == null : this.getDebtContno().equals(other.getDebtContno()))
            && (this.getLoanPercent() == null ? other.getLoanPercent() == null : this.getLoanPercent().equals(other.getLoanPercent()))
            && (this.getFactType() == null ? other.getFactType() == null : this.getFactType().equals(other.getFactType()))
            && (this.getFinancingType() == null ? other.getFinancingType() == null : this.getFinancingType().equals(other.getFinancingType()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getNoticeType() == null ? other.getNoticeType() == null : this.getNoticeType().equals(other.getNoticeType()))
            && (this.getIsAutoPay() == null ? other.getIsAutoPay() == null : this.getIsAutoPay().equals(other.getIsAutoPay()))
            && (this.getAutoPayDays() == null ? other.getAutoPayDays() == null : this.getAutoPayDays().equals(other.getAutoPayDays()))
            && (this.getServiceContent() == null ? other.getServiceContent() == null : this.getServiceContent().equals(other.getServiceContent()))
            && (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null : this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
            && (this.getCustcdCont() == null ? other.getCustcdCont() == null : this.getCustcdCont().equals(other.getCustcdCont()))
            && (this.getCurcdCont() == null ? other.getCurcdCont() == null : this.getCurcdCont().equals(other.getCurcdCont()))
            && (this.getContAmount() == null ? other.getContAmount() == null : this.getContAmount().equals(other.getContAmount()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
            && (this.getContStatus() == null ? other.getContStatus() == null : this.getContStatus().equals(other.getContStatus()))
            && (this.getContAccountNo() == null ? other.getContAccountNo() == null : this.getContAccountNo().equals(other.getContAccountNo()))
            && (this.getMgrnoCont() == null ? other.getMgrnoCont() == null : this.getMgrnoCont().equals(other.getMgrnoCont()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()))
            && (this.getLastUpdTlrno() == null ? other.getLastUpdTlrno() == null : this.getLastUpdTlrno().equals(other.getLastUpdTlrno()))
            && (this.getLastUpdDate() == null ? other.getLastUpdDate() == null : this.getLastUpdDate().equals(other.getLastUpdDate()))
            && (this.getBrcodeCont() == null ? other.getBrcodeCont() == null : this.getBrcodeCont().equals(other.getBrcodeCont()))
            && (this.getBailAcctNo() == null ? other.getBailAcctNo() == null : this.getBailAcctNo().equals(other.getBailAcctNo()))
            && (this.getContRetuAccount() == null ? other.getContRetuAccount() == null : this.getContRetuAccount().equals(other.getContRetuAccount()))
            && (this.getRecoverType() == null ? other.getRecoverType() == null : this.getRecoverType().equals(other.getRecoverType()))
            && (this.getContRepayPurpose() == null ? other.getContRepayPurpose() == null : this.getContRepayPurpose().equals(other.getContRepayPurpose()))
            && (this.getDueBalanceRule() == null ? other.getDueBalanceRule() == null : this.getDueBalanceRule().equals(other.getDueBalanceRule()))
            && (this.getPaymentVerifyRule() == null ? other.getPaymentVerifyRule() == null : this.getPaymentVerifyRule().equals(other.getPaymentVerifyRule()))
            && (this.getReparationProtNo() == null ? other.getReparationProtNo() == null : this.getReparationProtNo().equals(other.getReparationProtNo()))
            && (this.getLease() == null ? other.getLease() == null : this.getLease().equals(other.getLease()))
            && (this.getRepurchaser() == null ? other.getRepurchaser() == null : this.getRepurchaser().equals(other.getRepurchaser()))
            && (this.getRepurchaseProtNo() == null ? other.getRepurchaseProtNo() == null : this.getRepurchaseProtNo().equals(other.getRepurchaseProtNo()))
            && (this.getFactoringBrcode() == null ? other.getFactoringBrcode() == null : this.getFactoringBrcode().equals(other.getFactoringBrcode()))
            && (this.getReparationTerm() == null ? other.getReparationTerm() == null : this.getReparationTerm().equals(other.getReparationTerm()))
            && (this.getReparationPercent() == null ? other.getReparationPercent() == null : this.getReparationPercent().equals(other.getReparationPercent()))
            && (this.getCumulativeReparationAmt() == null ? other.getCumulativeReparationAmt() == null : this.getCumulativeReparationAmt().equals(other.getCumulativeReparationAmt()))
            && (this.getFactPattern() == null ? other.getFactPattern() == null : this.getFactPattern().equals(other.getFactPattern()))
            && (this.getCooperationBrcode() == null ? other.getCooperationBrcode() == null : this.getCooperationBrcode().equals(other.getCooperationBrcode()))
            && (this.getRentSettleWay() == null ? other.getRentSettleWay() == null : this.getRentSettleWay().equals(other.getRentSettleWay()))
            && (this.getPoolBailAmt() == null ? other.getPoolBailAmt() == null : this.getPoolBailAmt().equals(other.getPoolBailAmt()))
            && (this.getSumdebtBillsAmount() == null ? other.getSumdebtBillsAmount() == null : this.getSumdebtBillsAmount().equals(other.getSumdebtBillsAmount()))
            && (this.getSumdebtBillsAmountView() == null ? other.getSumdebtBillsAmountView() == null : this.getSumdebtBillsAmountView().equals(other.getSumdebtBillsAmountView()))
            && (this.getSumdebtRemainingAmount() == null ? other.getSumdebtRemainingAmount() == null : this.getSumdebtRemainingAmount().equals(other.getSumdebtRemainingAmount()))
            && (this.getSumdebtRemainingUseableAmou() == null ? other.getSumdebtRemainingUseableAmou() == null : this.getSumdebtRemainingUseableAmou().equals(other.getSumdebtRemainingUseableAmou()))
            && (this.getSumdebtRebateAmount() == null ? other.getSumdebtRebateAmount() == null : this.getSumdebtRebateAmount().equals(other.getSumdebtRebateAmount()))
            && (this.getSumdebtBuyBackAmount() == null ? other.getSumdebtBuyBackAmount() == null : this.getSumdebtBuyBackAmount().equals(other.getSumdebtBuyBackAmount()))
            && (this.getSumdebtPayAmount() == null ? other.getSumdebtPayAmount() == null : this.getSumdebtPayAmount().equals(other.getSumdebtPayAmount()))
            && (this.getSumdebtRemoveAmount() == null ? other.getSumdebtRemoveAmount() == null : this.getSumdebtRemoveAmount().equals(other.getSumdebtRemoveAmount()))
            && (this.getSumdebtCashRemainingAmount() == null ? other.getSumdebtCashRemainingAmount() == null : this.getSumdebtCashRemainingAmount().equals(other.getSumdebtCashRemainingAmount()))
            && (this.getSumamtDebtFlawFlag() == null ? other.getSumamtDebtFlawFlag() == null : this.getSumamtDebtFlawFlag().equals(other.getSumamtDebtFlawFlag()))
            && (this.getSumamtDebtIssueFlag() == null ? other.getSumamtDebtIssueFlag() == null : this.getSumamtDebtIssueFlag().equals(other.getSumamtDebtIssueFlag()))
            && (this.getSumamtDebtOverdueFlag() == null ? other.getSumamtDebtOverdueFlag() == null : this.getSumamtDebtOverdueFlag().equals(other.getSumamtDebtOverdueFlag()))
            && (this.getSumamtDebtBadFlag() == null ? other.getSumamtDebtBadFlag() == null : this.getSumamtDebtBadFlag().equals(other.getSumamtDebtBadFlag()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInputdate() == null) ? 0 : getInputdate().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        result = prime * result + ((getCustcdSaller() == null) ? 0 : getCustcdSaller().hashCode());
        result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getCnameBuyer() == null) ? 0 : getCnameBuyer().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getDebtNum() == null) ? 0 : getDebtNum().hashCode());
        result = prime * result + ((getTotalDebtAmount() == null) ? 0 : getTotalDebtAmount().hashCode());
        result = prime * result + ((getFinacingCost() == null) ? 0 : getFinacingCost().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getHandlingFee() == null) ? 0 : getHandlingFee().hashCode());
        result = prime * result + ((getReduceAmount() == null) ? 0 : getReduceAmount().hashCode());
        result = prime * result + ((getTotalFee() == null) ? 0 : getTotalFee().hashCode());
        result = prime * result + ((getTotalReduce() == null) ? 0 : getTotalReduce().hashCode());
        result = prime * result + ((getReceiveAmount() == null) ? 0 : getReceiveAmount().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getBankno() == null) ? 0 : getBankno().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
        result = prime * result + ((getReturnDate() == null) ? 0 : getReturnDate().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcodeBuss() == null) ? 0 : getBrcodeBuss().hashCode());
        result = prime * result + ((getReturnType() == null) ? 0 : getReturnType().hashCode());
        result = prime * result + ((getToSallerFlag() == null) ? 0 : getToSallerFlag().hashCode());
        result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getReturnMethod() == null) ? 0 : getReturnMethod().hashCode());
        result = prime * result + ((getReturnInterestAmount() == null) ? 0 : getReturnInterestAmount().hashCode());
        result = prime * result + ((getReturnCapitalAmount() == null) ? 0 : getReturnCapitalAmount().hashCode());
        result = prime * result + ((getToSallerAmount() == null) ? 0 : getToSallerAmount().hashCode());
        result = prime * result + ((getToPoolAmount() == null) ? 0 : getToPoolAmount().hashCode());
        result = prime * result + ((getReturnAccount() == null) ? 0 : getReturnAccount().hashCode());
        result = prime * result + ((getTransactionNo() == null) ? 0 : getTransactionNo().hashCode());
        result = prime * result + ((getTobailAmount() == null) ? 0 : getTobailAmount().hashCode());
        result = prime * result + ((getRebateAmount() == null) ? 0 : getRebateAmount().hashCode());
        result = prime * result + ((getReturnAccountBalance() == null) ? 0 : getReturnAccountBalance().hashCode());
        result = prime * result + ((getTotalOverAmount() == null) ? 0 : getTotalOverAmount().hashCode());
        result = prime * result + ((getSettleMethod() == null) ? 0 : getSettleMethod().hashCode());
        result = prime * result + ((getRepayPurpose() == null) ? 0 : getRepayPurpose().hashCode());
        result = prime * result + ((getTransferAmt() == null) ? 0 : getTransferAmt().hashCode());
        result = prime * result + ((getTransactionDate() == null) ? 0 : getTransactionDate().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
        result = prime * result + ((getCoreFlag() == null) ? 0 : getCoreFlag().hashCode());
        result = prime * result + ((getMoniFlag() == null) ? 0 : getMoniFlag().hashCode());
        result = prime * result + ((getFuturesFlag() == null) ? 0 : getFuturesFlag().hashCode());
        result = prime * result + ((getFlcFlag() == null) ? 0 : getFlcFlag().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreditFlag() == null) ? 0 : getCreditFlag().hashCode());
        result = prime * result + ((getBlackFlag() == null) ? 0 : getBlackFlag().hashCode());
        result = prime * result + ((getInsureFlag() == null) ? 0 : getInsureFlag().hashCode());
        result = prime * result + ((getFactorFlag() == null) ? 0 : getFactorFlag().hashCode());
        result = prime * result + ((getCcmsCustcd() == null) ? 0 : getCcmsCustcd().hashCode());
        result = prime * result + ((getImportantFlag() == null) ? 0 : getImportantFlag().hashCode());
        result = prime * result + ((getCommercialFalg() == null) ? 0 : getCommercialFalg().hashCode());
        result = prime * result + ((getOverseasFlag() == null) ? 0 : getOverseasFlag().hashCode());
        result = prime * result + ((getBanksCustFlag() == null) ? 0 : getBanksCustFlag().hashCode());
        result = prime * result + ((getEfBuyerFlag() == null) ? 0 : getEfBuyerFlag().hashCode());
        result = prime * result + ((getIfSellerFlag() == null) ? 0 : getIfSellerFlag().hashCode());
        result = prime * result + ((getIsBank() == null) ? 0 : getIsBank().hashCode());
        result = prime * result + ((getFciCode() == null) ? 0 : getFciCode().hashCode());
        result = prime * result + ((getIsIntl() == null) ? 0 : getIsIntl().hashCode());
        result = prime * result + ((getEnterpriseType() == null) ? 0 : getEnterpriseType().hashCode());
        result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
        result = prime * result + ((getEnterpriseScope() == null) ? 0 : getEnterpriseScope().hashCode());
        result = prime * result + ((getCustLevel() == null) ? 0 : getCustLevel().hashCode());
        result = prime * result + ((getCoreLevel() == null) ? 0 : getCoreLevel().hashCode());
        result = prime * result + ((getSupplyPosition() == null) ? 0 : getSupplyPosition().hashCode());
        result = prime * result + ((getBrname() == null) ? 0 : getBrname().hashCode());
        result = prime * result + ((getBrclass() == null) ? 0 : getBrclass().hashCode());
        result = prime * result + ((getBrnameBuss() == null) ? 0 : getBrnameBuss().hashCode());
        result = prime * result + ((getTlrName() == null) ? 0 : getTlrName().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getDebtContno() == null) ? 0 : getDebtContno().hashCode());
        result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
        result = prime * result + ((getFactType() == null) ? 0 : getFactType().hashCode());
        result = prime * result + ((getFinancingType() == null) ? 0 : getFinancingType().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getNoticeType() == null) ? 0 : getNoticeType().hashCode());
        result = prime * result + ((getIsAutoPay() == null) ? 0 : getIsAutoPay().hashCode());
        result = prime * result + ((getAutoPayDays() == null) ? 0 : getAutoPayDays().hashCode());
        result = prime * result + ((getServiceContent() == null) ? 0 : getServiceContent().hashCode());
        result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
        result = prime * result + ((getCustcdCont() == null) ? 0 : getCustcdCont().hashCode());
        result = prime * result + ((getCurcdCont() == null) ? 0 : getCurcdCont().hashCode());
        result = prime * result + ((getContAmount() == null) ? 0 : getContAmount().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getContStatus() == null) ? 0 : getContStatus().hashCode());
        result = prime * result + ((getContAccountNo() == null) ? 0 : getContAccountNo().hashCode());
        result = prime * result + ((getMgrnoCont() == null) ? 0 : getMgrnoCont().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrno() == null) ? 0 : getLastUpdTlrno().hashCode());
        result = prime * result + ((getLastUpdDate() == null) ? 0 : getLastUpdDate().hashCode());
        result = prime * result + ((getBrcodeCont() == null) ? 0 : getBrcodeCont().hashCode());
        result = prime * result + ((getBailAcctNo() == null) ? 0 : getBailAcctNo().hashCode());
        result = prime * result + ((getContRetuAccount() == null) ? 0 : getContRetuAccount().hashCode());
        result = prime * result + ((getRecoverType() == null) ? 0 : getRecoverType().hashCode());
        result = prime * result + ((getContRepayPurpose() == null) ? 0 : getContRepayPurpose().hashCode());
        result = prime * result + ((getDueBalanceRule() == null) ? 0 : getDueBalanceRule().hashCode());
        result = prime * result + ((getPaymentVerifyRule() == null) ? 0 : getPaymentVerifyRule().hashCode());
        result = prime * result + ((getReparationProtNo() == null) ? 0 : getReparationProtNo().hashCode());
        result = prime * result + ((getLease() == null) ? 0 : getLease().hashCode());
        result = prime * result + ((getRepurchaser() == null) ? 0 : getRepurchaser().hashCode());
        result = prime * result + ((getRepurchaseProtNo() == null) ? 0 : getRepurchaseProtNo().hashCode());
        result = prime * result + ((getFactoringBrcode() == null) ? 0 : getFactoringBrcode().hashCode());
        result = prime * result + ((getReparationTerm() == null) ? 0 : getReparationTerm().hashCode());
        result = prime * result + ((getReparationPercent() == null) ? 0 : getReparationPercent().hashCode());
        result = prime * result + ((getCumulativeReparationAmt() == null) ? 0 : getCumulativeReparationAmt().hashCode());
        result = prime * result + ((getFactPattern() == null) ? 0 : getFactPattern().hashCode());
        result = prime * result + ((getCooperationBrcode() == null) ? 0 : getCooperationBrcode().hashCode());
        result = prime * result + ((getRentSettleWay() == null) ? 0 : getRentSettleWay().hashCode());
        result = prime * result + ((getPoolBailAmt() == null) ? 0 : getPoolBailAmt().hashCode());
        result = prime * result + ((getSumdebtBillsAmount() == null) ? 0 : getSumdebtBillsAmount().hashCode());
        result = prime * result + ((getSumdebtBillsAmountView() == null) ? 0 : getSumdebtBillsAmountView().hashCode());
        result = prime * result + ((getSumdebtRemainingAmount() == null) ? 0 : getSumdebtRemainingAmount().hashCode());
        result = prime * result + ((getSumdebtRemainingUseableAmou() == null) ? 0 : getSumdebtRemainingUseableAmou().hashCode());
        result = prime * result + ((getSumdebtRebateAmount() == null) ? 0 : getSumdebtRebateAmount().hashCode());
        result = prime * result + ((getSumdebtBuyBackAmount() == null) ? 0 : getSumdebtBuyBackAmount().hashCode());
        result = prime * result + ((getSumdebtPayAmount() == null) ? 0 : getSumdebtPayAmount().hashCode());
        result = prime * result + ((getSumdebtRemoveAmount() == null) ? 0 : getSumdebtRemoveAmount().hashCode());
        result = prime * result + ((getSumdebtCashRemainingAmount() == null) ? 0 : getSumdebtCashRemainingAmount().hashCode());
        result = prime * result + ((getSumamtDebtFlawFlag() == null) ? 0 : getSumamtDebtFlawFlag().hashCode());
        result = prime * result + ((getSumamtDebtIssueFlag() == null) ? 0 : getSumamtDebtIssueFlag().hashCode());
        result = prime * result + ((getSumamtDebtOverdueFlag() == null) ? 0 : getSumamtDebtOverdueFlag().hashCode());
        result = prime * result + ((getSumamtDebtBadFlag() == null) ? 0 : getSumamtDebtBadFlag().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        return result;
    }
}