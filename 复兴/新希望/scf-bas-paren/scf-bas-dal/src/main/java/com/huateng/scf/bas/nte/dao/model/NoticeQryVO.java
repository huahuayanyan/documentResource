package com.huateng.scf.bas.nte.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 通知书查询VO: 包含BNteNoticeBase所有字段和lnciType,lnciAmt,commonDateTo,
 * commonDateFrom,signDateTo,signDateFrom,confirmStatus
 * 
 * @author zhanghesheng
 * 
 */
public class NoticeQryVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键uuid
	 */
	private String id;

	/**
	 * VARCHAR(20)<br>
	 * 业务申请编号(四方保兑仓收款确认通知书)
	 */
	private String appno;
	/**
	 * VARCHAR(20)<br>
	 * 业务申请编号(先票/款后货 发货通知书)
	 */
	private String deliveryAppno;

	/**
	 * VARCHAR(20)<br>
	 * 通知书编号
	 */
	private String num;

	/**
	 * VARCHAR(20)<br>
	 * 监管协议号
	 */
	private String monitorProtocolNo;

	/**
	 * VARCHAR(100)<br>
	 * 文本协议号
	 */
	private String protocolCode;

	/**
	 * VARCHAR(20)<br>
	 * 质押合同号
	 */
	private String slaveContno;

	/**
	 * VARCHAR(100)<br>
	 * 质押合同文本编号
	 */
	private String slaveContcode;

	/**
	 * VARCHAR(15)<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * VARCHAR(15)<br>
	 * 监管客户号
	 */
	private String moniOfCustcd;

	/**
	 * VARCHAR(10)<br>
	 * 通知书类型
	 */
	private String noticeType;

	/**
	 * CHAR(2)<br>
	 * 押品变更类型
	 */
	private String mortgageChangeType;

	/**
	 * VARCHAR(20)<br>
	 * 经办机构
	 */
	private String brcode;
	/**
	 * VARCHAR(20)<br>
	 * 经办机构名称
	 */
	private String brname;

	/**
	 * CHAR(8)<br>
	 * 监管入库日期
	 */
	private String moniOfDate;

	/**
	 * CHAR(8)<br>
	 * 申请日期
	 */
	private String appliDate;

	/**
	 * VARCHAR(100)<br>
	 * 监管方名称
	 */
	private String moniOfName;

	/**
	 * VARCHAR(32)<br>
	 * 客户经理/经办人
	 */
	private String tlrn;
	/**
	 * VARCHAR(32)<br>
	 * 客户经理/经办人名称
	 */
	private String tlrname;

	/**
	 * CHAR(2)<br>
	 * 通知书状态：00-未阅、02-已阅未确认、01-已阅已确认
	 */
	private String status;

	/**
	 * DECIMAL(16,2)<br>
	 * 保证金金额
	 */
	private BigDecimal bailAmount;

	/**
	 * CHAR(1)<br>
	 * 货押模式：1-动态、2-静态
	 */
	private String pledgeMode;

	/**
	 * VARCHAR(20)<br>
	 * 主合同号
	 */
	private String mastContno;

	/**
	 * DECIMAL(16,2)<br>
	 * 通用金额
	 */
	private BigDecimal commonAmt;

	/**
	 * VARCHAR(100)<br>
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * VARCHAR(10)<br>
	 * 单据张数
	 */
	private String commonNum;

	/**
	 * VARCHAR(100)<br>
	 * 信贷合同号
	 */
	private String mastContcode;

	/**
	 * VARCHAR(80)<br>
	 * 授信客户名称
	 */
	private String custName;

	/**
	 * VARCHAR(15)<br>
	 * 其他客户号(上游厂商、保理买方等)
	 */
	private String otherCustcd;

	/**
	 * VARCHAR(80)<br>
	 * 其他客户名(上游厂商、保理买方等)
	 */
	private String otherCustName;

	/**
	 * VARCHAR(100)<br>
	 * 户名
	 */
	private String accountName;

	/**
	 * VARCHAR(50)<br>
	 * 账号
	 */
	private String accountNo;

	/**
	 * VARCHAR(12)<br>
	 * 本行开户行号
	 */
	private String depositBrcode;

	/**
	 * DECIMAL(10,6)<br>
	 * 质押率
	 */
	private BigDecimal ratio;

	/**
	 * VARCHAR(500)<br>
	 * 购销合同号
	 */
	private String tradeContno;

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
	 * VARCHAR(20)<br>
	 * 业务协议编号
	 */
	private String protocolNo;

	/**
	 * CHAR(8)<br>
	 * 签发日期
	 */
	private String signDate;

	/**
	 * CHAR(8)<br>
	 * 确认日期
	 */
	private String commonDate;

	/**
	 * DECIMAL(16,2)<br>
	 * 预留金额字段1
	 */
	private BigDecimal ext1Amount;

	/**
	 * DECIMAL(16,2)<br>
	 * 预留金额字段2
	 */
	private BigDecimal ext2Amount;

	/**
	 * VARCHAR(50)<br>
	 * 预留字符字段1
	 */
	private String ext1;

	/**
	 * VARCHAR(100)<br>
	 * 预留字符字段2
	 */
	private String ext2;

	/**
	 * VARCHAR(10)<br>
	 * 业务品种
	 */
	private String bussType;
	/**
	 * VARCHAR(10)<br>
	 * 业务品种名称
	 */
	private String bussTypeName;

	/**
	 * VARCHAR(100)<br>
	 * 收款人名称
	 */
	private String payee;

	/**
	 * VARCHAR(500)<br>
	 * 备注/退回原因
	 */
	private String remark;

	/**
	 * VARCHAR(100)<br>
	 * 本行开户行
	 */
	private String depositBrname;

	/**
	 * VARCHAR(20)<br>
	 * 我方联系人
	 */
	private String linkman;

	/**
	 * VARCHAR(30)<br>
	 * 联系电话
	 */
	private String telephone;

	/**
	 * VARCHAR(30)<br>
	 * 传真
	 */
	private String fax;

	/**
	 * DECIMAL(16,2)<br>
	 * 未发货吨数(卖方发货情况对账单回执)
	 */
	private BigDecimal tons;

	/**
	 * DECIMAL(16,2)<br>
	 * 未发货金额(卖方发货情况对账单回执)
	 */
	private BigDecimal amt;

	/**
	 * DECIMAL(16,2)<br>
	 * 本次发货数量
	 */
	private BigDecimal deliveryQuantity;

	/**
	 * DECIMAL(16,2)<br>
	 * 本次发货金额
	 */
	private BigDecimal deliveryAmt;

	/**
	 * DECIMAL(16,2)<br>
	 * 剩余发货金额
	 */
	private BigDecimal balanceAmt;

	/**
	 * DECIMAL(16,2)<br>
	 * 质物下降百分比
	 */
	private BigDecimal priceDropRate;

	/**
	 * CHAR(2)<br>
	 * 出账方式：01-流动资金贷款、02-银行承兑汇票
	 */
	private String lnciType;

	/**
	 * DECIMAL(16,2)<br>
	 * 借据金额
	 */
	private BigDecimal lnciAmt;
	/**
	 * CHAR(1)<br>
	 * 收款确认状态：1-已收到、0-未收到
	 */
	private String confirmStatus;
	/**
	 * 
	 * 剩余发货金额=借据金额-累计发货金额
	 */
	private BigDecimal balSendAmt;

	/**
	 * CHAR(8)<br>
	 * 签发日期起始
	 */
	private String signDateFrom;

	/**
	 * CHAR(8)<br>
	 * 回执日期终止
	 */
	private String signDateTo;
	/**
	 * CHAR(8)<br>
	 * 回执日期起始
	 */
	private String commonDateFrom;
	/**
	 * CHAR(8)<br>
	 * 回执日期终止
	 */
	private String commonDateTo;

	public String getLnciType() {
		return lnciType;
	}

	public void setLnciType(String lnciType) {
		this.lnciType = lnciType == null ? null : lnciType.trim();
	}

	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}

	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
	}

	public BigDecimal getBalSendAmt() {
		return balSendAmt;
	}

	public void setBalSendAmt(BigDecimal balSendAmt) {
		this.balSendAmt = balSendAmt;
	}

	public String getSignDateFrom() {
		return signDateFrom;
	}

	public void setSignDateFrom(String signDateFrom) {
		this.signDateFrom = signDateFrom == null ? null : signDateFrom.trim();
	}

	public String getSignDateTo() {
		return signDateTo;
	}

	public void setSignDateTo(String signDateTo) {
		this.signDateTo = signDateTo == null ? null : signDateTo.trim();
	}

	public String getCommonDateFrom() {
		return commonDateFrom;
	}

	public void setCommonDateFrom(String commonDateFrom) {
		this.commonDateFrom = commonDateFrom == null ? null : commonDateFrom.trim();
	}

	public String getCommonDateTo() {
		return commonDateTo;
	}

	public void setCommonDateTo(String commonDateTo) {
		this.commonDateTo = commonDateTo == null ? null : commonDateTo.trim();
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 主键uuid
	 */
	public String getId() {
		return id;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 主键uuid
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

	public String getDeliveryAppno() {
		return deliveryAppno;
	}

	public void setDeliveryAppno(String deliveryAppno) {
		this.deliveryAppno = deliveryAppno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 通知书编号
	 */
	public String getNum() {
		return num;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 通知书编号
	 */
	public void setNum(String num) {
		this.num = num == null ? null : num.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 监管协议号
	 */
	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 监管协议号
	 */
	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo == null ? null : monitorProtocolNo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 文本协议号
	 */
	public String getProtocolCode() {
		return protocolCode;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 文本协议号
	 */
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode == null ? null : protocolCode.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 质押合同号
	 */
	public String getSlaveContno() {
		return slaveContno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 质押合同号
	 */
	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno == null ? null : slaveContno.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 质押合同文本编号
	 */
	public String getSlaveContcode() {
		return slaveContcode;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 质押合同文本编号
	 */
	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode == null ? null : slaveContcode.trim();
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
	 * VARCHAR(15)<br>
	 * 获得 监管客户号
	 */
	public String getMoniOfCustcd() {
		return moniOfCustcd;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 监管客户号
	 */
	public void setMoniOfCustcd(String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd == null ? null : moniOfCustcd.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 通知书类型
	 */
	public String getNoticeType() {
		return noticeType;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 通知书类型
	 */
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType == null ? null : noticeType.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 押品变更类型
	 */
	public String getMortgageChangeType() {
		return mortgageChangeType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 押品变更类型
	 */
	public void setMortgageChangeType(String mortgageChangeType) {
		this.mortgageChangeType = mortgageChangeType == null ? null : mortgageChangeType.trim();
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

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
	}

	/**
	 * CHAR(8)<br>
	 * 获得 监管入库日期
	 */
	public String getMoniOfDate() {
		return moniOfDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 监管入库日期
	 */
	public void setMoniOfDate(String moniOfDate) {
		this.moniOfDate = moniOfDate == null ? null : moniOfDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 申请日期
	 */
	public String getAppliDate() {
		return appliDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 申请日期
	 */
	public void setAppliDate(String appliDate) {
		this.appliDate = appliDate == null ? null : appliDate.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 监管方名称
	 */
	public String getMoniOfName() {
		return moniOfName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 监管方名称
	 */
	public void setMoniOfName(String moniOfName) {
		this.moniOfName = moniOfName == null ? null : moniOfName.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 客户经理/经办人
	 */
	public String getTlrn() {
		return tlrn;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 客户经理/经办人
	 */
	public void setTlrn(String tlrn) {
		this.tlrn = tlrn == null ? null : tlrn.trim();
	}

	public String getTlrname() {
		return tlrname;
	}

	public void setTlrname(String tlrname) {
		this.tlrname = tlrname;
	}

	/**
	 * CHAR(2)<br>
	 * 获得 通知书状态：00-未阅、02-已阅未确认、01-已阅已确认
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 通知书状态：00-未阅、02-已阅未确认、01-已阅已确认
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
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
	 * CHAR(1)<br>
	 * 获得 货押模式：1-动态、2-静态
	 */
	public String getPledgeMode() {
		return pledgeMode;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 货押模式：1-动态、2-静态
	 */
	public void setPledgeMode(String pledgeMode) {
		this.pledgeMode = pledgeMode == null ? null : pledgeMode.trim();
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
	 * DECIMAL(16,2)<br>
	 * 获得 通用金额
	 */
	public BigDecimal getCommonAmt() {
		return commonAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 通用金额
	 */
	public void setCommonAmt(BigDecimal commonAmt) {
		this.commonAmt = commonAmt;
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
	 * VARCHAR(10)<br>
	 * 获得 单据张数
	 */
	public String getCommonNum() {
		return commonNum;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 单据张数
	 */
	public void setCommonNum(String commonNum) {
		this.commonNum = commonNum == null ? null : commonNum.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 信贷合同号
	 */
	public String getMastContcode() {
		return mastContcode;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 信贷合同号
	 */
	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode == null ? null : mastContcode.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 授信客户名称
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 授信客户名称
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 其他客户号(上游厂商、保理买方等)
	 */
	public String getOtherCustcd() {
		return otherCustcd;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 其他客户号(上游厂商、保理买方等)
	 */
	public void setOtherCustcd(String otherCustcd) {
		this.otherCustcd = otherCustcd == null ? null : otherCustcd.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 其他客户名(上游厂商、保理买方等)
	 */
	public String getOtherCustName() {
		return otherCustName;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 其他客户名(上游厂商、保理买方等)
	 */
	public void setOtherCustName(String otherCustName) {
		this.otherCustName = otherCustName == null ? null : otherCustName.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 户名
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 户名
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName == null ? null : accountName.trim();
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
	 * VARCHAR(12)<br>
	 * 获得 本行开户行号
	 */
	public String getDepositBrcode() {
		return depositBrcode;
	}

	/**
	 * VARCHAR(12)<br>
	 * 设置 本行开户行号
	 */
	public void setDepositBrcode(String depositBrcode) {
		this.depositBrcode = depositBrcode == null ? null : depositBrcode.trim();
	}

	/**
	 * DECIMAL(10,6)<br>
	 * 获得 质押率
	 */
	public BigDecimal getRatio() {
		return ratio;
	}

	/**
	 * DECIMAL(10,6)<br>
	 * 设置 质押率
	 */
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 购销合同号
	 */
	public String getTradeContno() {
		return tradeContno;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 购销合同号
	 */
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno == null ? null : tradeContno.trim();
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
	 * VARCHAR(20)<br>
	 * 获得 业务协议编号
	 */
	public String getProtocolNo() {
		return protocolNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 业务协议编号
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo == null ? null : protocolNo.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 签发日期
	 */
	public String getSignDate() {
		return signDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 签发日期
	 */
	public void setSignDate(String signDate) {
		this.signDate = signDate == null ? null : signDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 确认日期
	 */
	public String getCommonDate() {
		return commonDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 确认日期
	 */
	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate == null ? null : commonDate.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 预留金额字段1
	 */
	public BigDecimal getExt1Amount() {
		return ext1Amount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 预留金额字段1
	 */
	public void setExt1Amount(BigDecimal ext1Amount) {
		this.ext1Amount = ext1Amount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 预留金额字段2
	 */
	public BigDecimal getExt2Amount() {
		return ext2Amount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 预留金额字段2
	 */
	public void setExt2Amount(BigDecimal ext2Amount) {
		this.ext2Amount = ext2Amount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 预留字符字段1
	 */
	public String getExt1() {
		return ext1;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 预留字符字段1
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1 == null ? null : ext1.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 预留字符字段2
	 */
	public String getExt2() {
		return ext2;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 预留字符字段2
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2 == null ? null : ext2.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 业务品种
	 */
	public String getBussType() {
		return bussType;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 业务品种
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType == null ? null : bussType.trim();
	}

	public String getBussTypeName() {
		return bussTypeName;
	}

	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 收款人名称
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 收款人名称
	 */
	public void setPayee(String payee) {
		this.payee = payee == null ? null : payee.trim();
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 备注/退回原因
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 备注/退回原因
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 本行开户行
	 */
	public String getDepositBrname() {
		return depositBrname;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 本行开户行
	 */
	public void setDepositBrname(String depositBrname) {
		this.depositBrname = depositBrname == null ? null : depositBrname.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 我方联系人
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 我方联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman == null ? null : linkman.trim();
	}

	/**
	 * VARCHAR(30)<br>
	 * 获得 联系电话
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * VARCHAR(30)<br>
	 * 设置 联系电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	/**
	 * VARCHAR(30)<br>
	 * 获得 传真
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * VARCHAR(30)<br>
	 * 设置 传真
	 */
	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 未发货吨数(卖方发货情况对账单回执)
	 */
	public BigDecimal getTons() {
		return tons;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 未发货吨数(卖方发货情况对账单回执)
	 */
	public void setTons(BigDecimal tons) {
		this.tons = tons;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 未发货金额(卖方发货情况对账单回执)
	 */
	public BigDecimal getAmt() {
		return amt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 未发货金额(卖方发货情况对账单回执)
	 */
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 本次发货数量
	 */
	public BigDecimal getDeliveryQuantity() {
		return deliveryQuantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 本次发货数量
	 */
	public void setDeliveryQuantity(BigDecimal deliveryQuantity) {
		this.deliveryQuantity = deliveryQuantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 本次发货金额
	 */
	public BigDecimal getDeliveryAmt() {
		return deliveryAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 本次发货金额
	 */
	public void setDeliveryAmt(BigDecimal deliveryAmt) {
		this.deliveryAmt = deliveryAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 剩余发货金额
	 */
	public BigDecimal getBalanceAmt() {
		return balanceAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 剩余发货金额
	 */
	public void setBalanceAmt(BigDecimal balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 质物下降百分比
	 */
	public BigDecimal getPriceDropRate() {
		return priceDropRate;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 质物下降百分比
	 */
	public void setPriceDropRate(BigDecimal priceDropRate) {
		this.priceDropRate = priceDropRate;
	}

	@Override
	public String toString() {
		return "NoticeQryVO [id=" + id + ", appno=" + appno + ", num=" + num + ", monitorProtocolNo=" + monitorProtocolNo + ", protocolCode="
				+ protocolCode + ", slaveContno=" + slaveContno + ", slaveContcode=" + slaveContcode + ", custcd=" + custcd + ", moniOfCustcd="
				+ moniOfCustcd + ", noticeType=" + noticeType + ", mortgageChangeType=" + mortgageChangeType + ", brcode=" + brcode + ", moniOfDate="
				+ moniOfDate + ", appliDate=" + appliDate + ", moniOfName=" + moniOfName + ", tlrn=" + tlrn + ", status=" + status + ", bailAmount="
				+ bailAmount + ", pledgeMode=" + pledgeMode + ", mastContno=" + mastContno + ", commonAmt=" + commonAmt + ", orderNo=" + orderNo
				+ ", commonNum=" + commonNum + ", mastContcode=" + mastContcode + ", custName=" + custName + ", otherCustcd=" + otherCustcd
				+ ", otherCustName=" + otherCustName + ", accountName=" + accountName + ", accountNo=" + accountNo + ", depositBrcode="
				+ depositBrcode + ", ratio=" + ratio + ", tradeContno=" + tradeContno + ", debetNo=" + debetNo + ", debetId=" + debetId
				+ ", protocolNo=" + protocolNo + ", signDate=" + signDate + ", commonDate=" + commonDate + ", ext1Amount=" + ext1Amount
				+ ", ext2Amount=" + ext2Amount + ", ext1=" + ext1 + ", ext2=" + ext2 + ", bussType=" + bussType + ", payee=" + payee + ", remark="
				+ remark + ", depositBrname=" + depositBrname + ", linkman=" + linkman + ", telephone=" + telephone + ", fax=" + fax + ", tons="
				+ tons + ", amt=" + amt + ", deliveryQuantity=" + deliveryQuantity + ", deliveryAmt=" + deliveryAmt + ", balanceAmt=" + balanceAmt
				+ ", priceDropRate=" + priceDropRate + ", lnciType=" + lnciType + ", lnciAmt=" + lnciAmt + ", confirmStatus=" + confirmStatus
				+ ", signDateFrom=" + signDateFrom + ", signDateTo=" + signDateTo + ", commonDateFrom=" + commonDateFrom + ", commonDateTo="
				+ commonDateTo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		result = prime * result + ((amt == null) ? 0 : amt.hashCode());
		result = prime * result + ((appliDate == null) ? 0 : appliDate.hashCode());
		result = prime * result + ((appno == null) ? 0 : appno.hashCode());
		result = prime * result + ((bailAmount == null) ? 0 : bailAmount.hashCode());
		result = prime * result + ((balanceAmt == null) ? 0 : balanceAmt.hashCode());
		result = prime * result + ((brcode == null) ? 0 : brcode.hashCode());
		result = prime * result + ((bussType == null) ? 0 : bussType.hashCode());
		result = prime * result + ((commonAmt == null) ? 0 : commonAmt.hashCode());
		result = prime * result + ((commonDate == null) ? 0 : commonDate.hashCode());
		result = prime * result + ((commonDateFrom == null) ? 0 : commonDateFrom.hashCode());
		result = prime * result + ((commonDateTo == null) ? 0 : commonDateTo.hashCode());
		result = prime * result + ((commonNum == null) ? 0 : commonNum.hashCode());
		result = prime * result + ((confirmStatus == null) ? 0 : confirmStatus.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custcd == null) ? 0 : custcd.hashCode());
		result = prime * result + ((debetId == null) ? 0 : debetId.hashCode());
		result = prime * result + ((debetNo == null) ? 0 : debetNo.hashCode());
		result = prime * result + ((deliveryAmt == null) ? 0 : deliveryAmt.hashCode());
		result = prime * result + ((deliveryQuantity == null) ? 0 : deliveryQuantity.hashCode());
		result = prime * result + ((depositBrcode == null) ? 0 : depositBrcode.hashCode());
		result = prime * result + ((depositBrname == null) ? 0 : depositBrname.hashCode());
		result = prime * result + ((ext1 == null) ? 0 : ext1.hashCode());
		result = prime * result + ((ext1Amount == null) ? 0 : ext1Amount.hashCode());
		result = prime * result + ((ext2 == null) ? 0 : ext2.hashCode());
		result = prime * result + ((ext2Amount == null) ? 0 : ext2Amount.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkman == null) ? 0 : linkman.hashCode());
		result = prime * result + ((lnciAmt == null) ? 0 : lnciAmt.hashCode());
		result = prime * result + ((lnciType == null) ? 0 : lnciType.hashCode());
		result = prime * result + ((mastContcode == null) ? 0 : mastContcode.hashCode());
		result = prime * result + ((mastContno == null) ? 0 : mastContno.hashCode());
		result = prime * result + ((moniOfCustcd == null) ? 0 : moniOfCustcd.hashCode());
		result = prime * result + ((moniOfDate == null) ? 0 : moniOfDate.hashCode());
		result = prime * result + ((moniOfName == null) ? 0 : moniOfName.hashCode());
		result = prime * result + ((monitorProtocolNo == null) ? 0 : monitorProtocolNo.hashCode());
		result = prime * result + ((mortgageChangeType == null) ? 0 : mortgageChangeType.hashCode());
		result = prime * result + ((noticeType == null) ? 0 : noticeType.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((otherCustName == null) ? 0 : otherCustName.hashCode());
		result = prime * result + ((otherCustcd == null) ? 0 : otherCustcd.hashCode());
		result = prime * result + ((payee == null) ? 0 : payee.hashCode());
		result = prime * result + ((pledgeMode == null) ? 0 : pledgeMode.hashCode());
		result = prime * result + ((priceDropRate == null) ? 0 : priceDropRate.hashCode());
		result = prime * result + ((protocolCode == null) ? 0 : protocolCode.hashCode());
		result = prime * result + ((protocolNo == null) ? 0 : protocolNo.hashCode());
		result = prime * result + ((ratio == null) ? 0 : ratio.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((signDate == null) ? 0 : signDate.hashCode());
		result = prime * result + ((signDateFrom == null) ? 0 : signDateFrom.hashCode());
		result = prime * result + ((signDateTo == null) ? 0 : signDateTo.hashCode());
		result = prime * result + ((slaveContcode == null) ? 0 : slaveContcode.hashCode());
		result = prime * result + ((slaveContno == null) ? 0 : slaveContno.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((tlrn == null) ? 0 : tlrn.hashCode());
		result = prime * result + ((tons == null) ? 0 : tons.hashCode());
		result = prime * result + ((tradeContno == null) ? 0 : tradeContno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeQryVO other = (NoticeQryVO) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (amt == null) {
			if (other.amt != null)
				return false;
		} else if (!amt.equals(other.amt))
			return false;
		if (appliDate == null) {
			if (other.appliDate != null)
				return false;
		} else if (!appliDate.equals(other.appliDate))
			return false;
		if (appno == null) {
			if (other.appno != null)
				return false;
		} else if (!appno.equals(other.appno))
			return false;
		if (bailAmount == null) {
			if (other.bailAmount != null)
				return false;
		} else if (!bailAmount.equals(other.bailAmount))
			return false;
		if (balanceAmt == null) {
			if (other.balanceAmt != null)
				return false;
		} else if (!balanceAmt.equals(other.balanceAmt))
			return false;
		if (brcode == null) {
			if (other.brcode != null)
				return false;
		} else if (!brcode.equals(other.brcode))
			return false;
		if (bussType == null) {
			if (other.bussType != null)
				return false;
		} else if (!bussType.equals(other.bussType))
			return false;
		if (commonAmt == null) {
			if (other.commonAmt != null)
				return false;
		} else if (!commonAmt.equals(other.commonAmt))
			return false;
		if (commonDate == null) {
			if (other.commonDate != null)
				return false;
		} else if (!commonDate.equals(other.commonDate))
			return false;
		if (commonDateFrom == null) {
			if (other.commonDateFrom != null)
				return false;
		} else if (!commonDateFrom.equals(other.commonDateFrom))
			return false;
		if (commonDateTo == null) {
			if (other.commonDateTo != null)
				return false;
		} else if (!commonDateTo.equals(other.commonDateTo))
			return false;
		if (commonNum == null) {
			if (other.commonNum != null)
				return false;
		} else if (!commonNum.equals(other.commonNum))
			return false;
		if (confirmStatus == null) {
			if (other.confirmStatus != null)
				return false;
		} else if (!confirmStatus.equals(other.confirmStatus))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custcd == null) {
			if (other.custcd != null)
				return false;
		} else if (!custcd.equals(other.custcd))
			return false;
		if (debetId == null) {
			if (other.debetId != null)
				return false;
		} else if (!debetId.equals(other.debetId))
			return false;
		if (debetNo == null) {
			if (other.debetNo != null)
				return false;
		} else if (!debetNo.equals(other.debetNo))
			return false;
		if (deliveryAmt == null) {
			if (other.deliveryAmt != null)
				return false;
		} else if (!deliveryAmt.equals(other.deliveryAmt))
			return false;
		if (deliveryQuantity == null) {
			if (other.deliveryQuantity != null)
				return false;
		} else if (!deliveryQuantity.equals(other.deliveryQuantity))
			return false;
		if (depositBrcode == null) {
			if (other.depositBrcode != null)
				return false;
		} else if (!depositBrcode.equals(other.depositBrcode))
			return false;
		if (depositBrname == null) {
			if (other.depositBrname != null)
				return false;
		} else if (!depositBrname.equals(other.depositBrname))
			return false;
		if (ext1 == null) {
			if (other.ext1 != null)
				return false;
		} else if (!ext1.equals(other.ext1))
			return false;
		if (ext1Amount == null) {
			if (other.ext1Amount != null)
				return false;
		} else if (!ext1Amount.equals(other.ext1Amount))
			return false;
		if (ext2 == null) {
			if (other.ext2 != null)
				return false;
		} else if (!ext2.equals(other.ext2))
			return false;
		if (ext2Amount == null) {
			if (other.ext2Amount != null)
				return false;
		} else if (!ext2Amount.equals(other.ext2Amount))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkman == null) {
			if (other.linkman != null)
				return false;
		} else if (!linkman.equals(other.linkman))
			return false;
		if (lnciAmt == null) {
			if (other.lnciAmt != null)
				return false;
		} else if (!lnciAmt.equals(other.lnciAmt))
			return false;
		if (lnciType == null) {
			if (other.lnciType != null)
				return false;
		} else if (!lnciType.equals(other.lnciType))
			return false;
		if (mastContcode == null) {
			if (other.mastContcode != null)
				return false;
		} else if (!mastContcode.equals(other.mastContcode))
			return false;
		if (mastContno == null) {
			if (other.mastContno != null)
				return false;
		} else if (!mastContno.equals(other.mastContno))
			return false;
		if (moniOfCustcd == null) {
			if (other.moniOfCustcd != null)
				return false;
		} else if (!moniOfCustcd.equals(other.moniOfCustcd))
			return false;
		if (moniOfDate == null) {
			if (other.moniOfDate != null)
				return false;
		} else if (!moniOfDate.equals(other.moniOfDate))
			return false;
		if (moniOfName == null) {
			if (other.moniOfName != null)
				return false;
		} else if (!moniOfName.equals(other.moniOfName))
			return false;
		if (monitorProtocolNo == null) {
			if (other.monitorProtocolNo != null)
				return false;
		} else if (!monitorProtocolNo.equals(other.monitorProtocolNo))
			return false;
		if (mortgageChangeType == null) {
			if (other.mortgageChangeType != null)
				return false;
		} else if (!mortgageChangeType.equals(other.mortgageChangeType))
			return false;
		if (noticeType == null) {
			if (other.noticeType != null)
				return false;
		} else if (!noticeType.equals(other.noticeType))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (otherCustName == null) {
			if (other.otherCustName != null)
				return false;
		} else if (!otherCustName.equals(other.otherCustName))
			return false;
		if (otherCustcd == null) {
			if (other.otherCustcd != null)
				return false;
		} else if (!otherCustcd.equals(other.otherCustcd))
			return false;
		if (payee == null) {
			if (other.payee != null)
				return false;
		} else if (!payee.equals(other.payee))
			return false;
		if (pledgeMode == null) {
			if (other.pledgeMode != null)
				return false;
		} else if (!pledgeMode.equals(other.pledgeMode))
			return false;
		if (priceDropRate == null) {
			if (other.priceDropRate != null)
				return false;
		} else if (!priceDropRate.equals(other.priceDropRate))
			return false;
		if (protocolCode == null) {
			if (other.protocolCode != null)
				return false;
		} else if (!protocolCode.equals(other.protocolCode))
			return false;
		if (protocolNo == null) {
			if (other.protocolNo != null)
				return false;
		} else if (!protocolNo.equals(other.protocolNo))
			return false;
		if (ratio == null) {
			if (other.ratio != null)
				return false;
		} else if (!ratio.equals(other.ratio))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (signDate == null) {
			if (other.signDate != null)
				return false;
		} else if (!signDate.equals(other.signDate))
			return false;
		if (signDateFrom == null) {
			if (other.signDateFrom != null)
				return false;
		} else if (!signDateFrom.equals(other.signDateFrom))
			return false;
		if (signDateTo == null) {
			if (other.signDateTo != null)
				return false;
		} else if (!signDateTo.equals(other.signDateTo))
			return false;
		if (slaveContcode == null) {
			if (other.slaveContcode != null)
				return false;
		} else if (!slaveContcode.equals(other.slaveContcode))
			return false;
		if (slaveContno == null) {
			if (other.slaveContno != null)
				return false;
		} else if (!slaveContno.equals(other.slaveContno))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (tlrn == null) {
			if (other.tlrn != null)
				return false;
		} else if (!tlrn.equals(other.tlrn))
			return false;
		if (tons == null) {
			if (other.tons != null)
				return false;
		} else if (!tons.equals(other.tons))
			return false;
		if (tradeContno == null) {
			if (other.tradeContno != null)
				return false;
		} else if (!tradeContno.equals(other.tradeContno))
			return false;
		return true;
	}

}
