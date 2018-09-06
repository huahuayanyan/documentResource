package com.huateng.scf.bas.nte.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BNteNoticeBase implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键uuid
	 */
	private String id;

	/**
	 * VARCHAR(20)<br>
	 * 业务申请编号
	 */
	private String appno;

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
	 * 客户名称
	 */
	private String cname;

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
	 * VARCHAR(10)<br>
	 * 通知书类型
	 */
	private String[] noticeTypes;

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
	private String brNm;

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
	private String tlrNm;

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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public String[] getNoticeTypes() {
		return noticeTypes;
	}

	public void setNoticeTypes(String[] noticeTypes) {
		this.noticeTypes = noticeTypes;
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

	public String getBrNm() {
		return brNm;
	}

	public void setBrNm(String brNm) {
		this.brNm = brNm;
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

	public String getTlrNm() {
		return tlrNm;
	}

	public void setTlrNm(String tlrNm) {
		this.tlrNm = tlrNm;
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
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", appno=").append(appno);
		sb.append(", num=").append(num);
		sb.append(", monitorProtocolNo=").append(monitorProtocolNo);
		sb.append(", protocolCode=").append(protocolCode);
		sb.append(", slaveContno=").append(slaveContno);
		sb.append(", slaveContcode=").append(slaveContcode);
		sb.append(", custcd=").append(custcd);
		sb.append(", moniOfCustcd=").append(moniOfCustcd);
		sb.append(", noticeType=").append(noticeType);
		sb.append(", mortgageChangeType=").append(mortgageChangeType);
		sb.append(", brcode=").append(brcode);
		sb.append(", moniOfDate=").append(moniOfDate);
		sb.append(", appliDate=").append(appliDate);
		sb.append(", moniOfName=").append(moniOfName);
		sb.append(", tlrn=").append(tlrn);
		sb.append(", status=").append(status);
		sb.append(", bailAmount=").append(bailAmount);
		sb.append(", pledgeMode=").append(pledgeMode);
		sb.append(", mastContno=").append(mastContno);
		sb.append(", commonAmt=").append(commonAmt);
		sb.append(", orderNo=").append(orderNo);
		sb.append(", commonNum=").append(commonNum);
		sb.append(", mastContcode=").append(mastContcode);
		sb.append(", custName=").append(custName);
		sb.append(", otherCustcd=").append(otherCustcd);
		sb.append(", otherCustName=").append(otherCustName);
		sb.append(", accountName=").append(accountName);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", depositBrcode=").append(depositBrcode);
		sb.append(", ratio=").append(ratio);
		sb.append(", tradeContno=").append(tradeContno);
		sb.append(", debetNo=").append(debetNo);
		sb.append(", debetId=").append(debetId);
		sb.append(", protocolNo=").append(protocolNo);
		sb.append(", signDate=").append(signDate);
		sb.append(", commonDate=").append(commonDate);
		sb.append(", ext1Amount=").append(ext1Amount);
		sb.append(", ext2Amount=").append(ext2Amount);
		sb.append(", ext1=").append(ext1);
		sb.append(", ext2=").append(ext2);
		sb.append(", bussType=").append(bussType);
		sb.append(", payee=").append(payee);
		sb.append(", remark=").append(remark);
		sb.append(", depositBrname=").append(depositBrname);
		sb.append(", linkman=").append(linkman);
		sb.append(", telephone=").append(telephone);
		sb.append(", fax=").append(fax);
		sb.append(", tons=").append(tons);
		sb.append(", amt=").append(amt);
		sb.append(", deliveryQuantity=").append(deliveryQuantity);
		sb.append(", deliveryAmt=").append(deliveryAmt);
		sb.append(", balanceAmt=").append(balanceAmt);
		sb.append(", priceDropRate=").append(priceDropRate);
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
		BNteNoticeBase other = (BNteNoticeBase) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
				&& (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
				&& (this.getMonitorProtocolNo() == null ? other.getMonitorProtocolNo() == null
						: this.getMonitorProtocolNo().equals(other.getMonitorProtocolNo()))
				&& (this.getProtocolCode() == null ? other.getProtocolCode() == null : this.getProtocolCode().equals(other.getProtocolCode()))
				&& (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
				&& (this.getSlaveContcode() == null ? other.getSlaveContcode() == null : this.getSlaveContcode().equals(other.getSlaveContcode()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
				&& (this.getNoticeType() == null ? other.getNoticeType() == null : this.getNoticeType().equals(other.getNoticeType()))
				&& (this.getMortgageChangeType() == null ? other.getMortgageChangeType() == null
						: this.getMortgageChangeType().equals(other.getMortgageChangeType()))
				&& (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
				&& (this.getMoniOfDate() == null ? other.getMoniOfDate() == null : this.getMoniOfDate().equals(other.getMoniOfDate()))
				&& (this.getAppliDate() == null ? other.getAppliDate() == null : this.getAppliDate().equals(other.getAppliDate()))
				&& (this.getMoniOfName() == null ? other.getMoniOfName() == null : this.getMoniOfName().equals(other.getMoniOfName()))
				&& (this.getTlrn() == null ? other.getTlrn() == null : this.getTlrn().equals(other.getTlrn()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
				&& (this.getPledgeMode() == null ? other.getPledgeMode() == null : this.getPledgeMode().equals(other.getPledgeMode()))
				&& (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
				&& (this.getCommonAmt() == null ? other.getCommonAmt() == null : this.getCommonAmt().equals(other.getCommonAmt()))
				&& (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
				&& (this.getCommonNum() == null ? other.getCommonNum() == null : this.getCommonNum().equals(other.getCommonNum()))
				&& (this.getMastContcode() == null ? other.getMastContcode() == null : this.getMastContcode().equals(other.getMastContcode()))
				&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
				&& (this.getOtherCustcd() == null ? other.getOtherCustcd() == null : this.getOtherCustcd().equals(other.getOtherCustcd()))
				&& (this.getOtherCustName() == null ? other.getOtherCustName() == null : this.getOtherCustName().equals(other.getOtherCustName()))
				&& (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
				&& (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
				&& (this.getDepositBrcode() == null ? other.getDepositBrcode() == null : this.getDepositBrcode().equals(other.getDepositBrcode()))
				&& (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()))
				&& (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
				&& (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
				&& (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
				&& (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
				&& (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
				&& (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
				&& (this.getExt1Amount() == null ? other.getExt1Amount() == null : this.getExt1Amount().equals(other.getExt1Amount()))
				&& (this.getExt2Amount() == null ? other.getExt2Amount() == null : this.getExt2Amount().equals(other.getExt2Amount()))
				&& (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
				&& (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
				&& (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
				&& (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getDepositBrname() == null ? other.getDepositBrname() == null : this.getDepositBrname().equals(other.getDepositBrname()))
				&& (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
				&& (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
				&& (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
				&& (this.getTons() == null ? other.getTons() == null : this.getTons().equals(other.getTons()))
				&& (this.getAmt() == null ? other.getAmt() == null : this.getAmt().equals(other.getAmt()))
				&& (this.getDeliveryQuantity() == null ? other.getDeliveryQuantity() == null
						: this.getDeliveryQuantity().equals(other.getDeliveryQuantity()))
				&& (this.getDeliveryAmt() == null ? other.getDeliveryAmt() == null : this.getDeliveryAmt().equals(other.getDeliveryAmt()))
				&& (this.getBalanceAmt() == null ? other.getBalanceAmt() == null : this.getBalanceAmt().equals(other.getBalanceAmt()))
				&& (this.getPriceDropRate() == null ? other.getPriceDropRate() == null : this.getPriceDropRate().equals(other.getPriceDropRate()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
		result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
		result = prime * result + ((getMonitorProtocolNo() == null) ? 0 : getMonitorProtocolNo().hashCode());
		result = prime * result + ((getProtocolCode() == null) ? 0 : getProtocolCode().hashCode());
		result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
		result = prime * result + ((getSlaveContcode() == null) ? 0 : getSlaveContcode().hashCode());
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
		result = prime * result + ((getNoticeType() == null) ? 0 : getNoticeType().hashCode());
		result = prime * result + ((getMortgageChangeType() == null) ? 0 : getMortgageChangeType().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getMoniOfDate() == null) ? 0 : getMoniOfDate().hashCode());
		result = prime * result + ((getAppliDate() == null) ? 0 : getAppliDate().hashCode());
		result = prime * result + ((getMoniOfName() == null) ? 0 : getMoniOfName().hashCode());
		result = prime * result + ((getTlrn() == null) ? 0 : getTlrn().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
		result = prime * result + ((getPledgeMode() == null) ? 0 : getPledgeMode().hashCode());
		result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
		result = prime * result + ((getCommonAmt() == null) ? 0 : getCommonAmt().hashCode());
		result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
		result = prime * result + ((getCommonNum() == null) ? 0 : getCommonNum().hashCode());
		result = prime * result + ((getMastContcode() == null) ? 0 : getMastContcode().hashCode());
		result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
		result = prime * result + ((getOtherCustcd() == null) ? 0 : getOtherCustcd().hashCode());
		result = prime * result + ((getOtherCustName() == null) ? 0 : getOtherCustName().hashCode());
		result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
		result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
		result = prime * result + ((getDepositBrcode() == null) ? 0 : getDepositBrcode().hashCode());
		result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
		result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
		result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
		result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
		result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
		result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
		result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
		result = prime * result + ((getExt1Amount() == null) ? 0 : getExt1Amount().hashCode());
		result = prime * result + ((getExt2Amount() == null) ? 0 : getExt2Amount().hashCode());
		result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
		result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
		result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
		result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getDepositBrname() == null) ? 0 : getDepositBrname().hashCode());
		result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
		result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
		result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
		result = prime * result + ((getTons() == null) ? 0 : getTons().hashCode());
		result = prime * result + ((getAmt() == null) ? 0 : getAmt().hashCode());
		result = prime * result + ((getDeliveryQuantity() == null) ? 0 : getDeliveryQuantity().hashCode());
		result = prime * result + ((getDeliveryAmt() == null) ? 0 : getDeliveryAmt().hashCode());
		result = prime * result + ((getBalanceAmt() == null) ? 0 : getBalanceAmt().hashCode());
		result = prime * result + ((getPriceDropRate() == null) ? 0 : getPriceDropRate().hashCode());
		return result;
	}
}