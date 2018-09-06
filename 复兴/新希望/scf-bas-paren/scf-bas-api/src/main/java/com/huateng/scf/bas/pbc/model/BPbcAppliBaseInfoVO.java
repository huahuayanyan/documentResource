package com.huateng.scf.bas.pbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcAppliBaseInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String startTlrNm;
	private String startBrName;
	
	public String getStartTlrNm() {
		return startTlrNm;
	}

	public void setStartTlrNm(String startTlrNm) {
		this.startTlrNm = startTlrNm;
	}

	public String getStartBrName() {
		return startBrName;
	}

	public void setStartBrName(String startBrName) {
		this.startBrName = startBrName;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 对应custcd客户名称
	 */
	private String cname;
	/**
	 * VARCHAR(20) 必填<br>
	 * 对应moniCustcd客户名称
	 */
	private String moniCname;
	/**
	 * VARCHAR(20) 必填<br>
	 * 业务品种名称
	 */
	private String supplyChainPdName;

	/**
	 * VARCHAR(20) 必填<br>
	 * 申请号
	 */
	private String appno;

	/**
	 * VARCHAR(32)<br>
	 * 工作流实例号
	 */
	private String piid;

	/**
	 * CHAR(4)<br>
	 * 申请类型
	 */
	private String appliType;

	/**
	 * VARCHAR(250)<br>
	 * 模板名
	 */
	private String processTemplateName;

	/**
	 * CHAR(2)<br>
	 * 业务编号类型：01-主合同号、02-质押合同号、03-协议编号、04-客户号
	 */
	private String businessnoType;

	/**
	 * VARCHAR(20)<br>
	 * 业务编号(根据业务编号类型存放对应的值)
	 */
	private String businessno;

	/**
	 * VARCHAR(15)<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * DECIMAL(16,2)<br>
	 * 业务金额
	 */
	private BigDecimal amt;

	/**
	 * VARCHAR(20)<br>
	 * 流程发起机构
	 */
	private String startBrcode;

	/**
	 * VARCHAR(32)<br>
	 * 流程发起人
	 */
	private String startTlrcd;

	/**
	 * CHAR(8)<br>
	 * 发起日期
	 */
	private String stratDate;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 发起时间
	 */
	private Date startTime;

	/**
	 * CHAR(2)<br>
	 * 申请类型
	 */
	private String appliStatus;

	/**
	 * VARCHAR(20)<br>
	 * 审批机构
	 */
	private String approveBrcode;

	/**
	 * VARCHAR(32)<br>
	 * 审批人
	 */
	private String approver;

	/**
	 * CHAR(8)<br>
	 * 审批日期
	 */
	private String approveDate;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 审批时间
	 */
	private Date approveTime;

	/**
	 * VARCHAR(30)<br>
	 * 工作流申请号
	 */
	private String workflowAppno;

	/**
	 * CHAR(3)<br>
	 * 申请状态
	 */
	private String appliStatusDtl;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * CHAR(8)<br>
	 * 申请日期
	 */
	private String appDate;

	/**
	 * VARCHAR(32)<br>
	 * 申请人
	 */
	private String appTlrcd;

	/**
	 * VARCHAR(20)<br>
	 * 申请机构
	 */
	private String appBrcode;

	/**
	 * DECIMAL(16,2)<br>
	 * 保证金金额
	 */
	private BigDecimal bailAmount;

	/**
	 * VARCHAR(20)<br>
	 * 抵质押合同号
	 */
	private String slaveContno;

	/**
	 * VARCHAR(20)<br>
	 * 主合同号
	 */
	private String mastContno;

	/**
	 * VARCHAR(20)<br>
	 * 协议号
	 */
	private String protocolNo;

	/**
	 * CHAR(4)<br>
	 * 供应链产品类型
	 */
	private String supplyChainPdId;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String memo;

	/**
	 * VARCHAR(50)<br>
	 * 信贷系统流水号
	 */
	private String incomeAppno;

	/**
	 * VARCHAR(15)<br>
	 * 监管公司客户号
	 */
	private String moniCustcd;

	/**
	 * CHAR(1)<br>
	 * 质押模式：1-动态、2-静态
	 */
	private String pledgeMode;

	/**
	 * VARCHAR(20)<br>
	 * 关联协议号
	 */
	private String otherProtocolNo;

	/**
	 * VARCHAR(50)<br>
	 * 扩展字段1
	 */
	private String ext1;

	/**
	 * VARCHAR(100)<br>
	 * 扩展字段2
	 */
	private String ext2;

	/**
	 * VARCHAR(200)<br>
	 * 扩展字段3
	 */
	private String ext3;

	/**
	 * VARCHAR(50)<br>
	 * 网银流水号
	 */
	private String ebankAppno;

	/**
	 * VARCHAR(200)<br>
	 * 信贷合同号
	 */
	private String mastContcode;

	/**
	 * CHAR(1)<br>
	 * 渠道标识：1-供应链、2-企业网银、3-信贷系统
	 */
	private String channelFlag;

	/**
	 * CHAR(1)<br>
	 * 流程是否结束：0-否、1-是
	 */
	private String isFlowEnd;

	/**
	 * VARCHAR(32)<br>
	 * IFSP申请号
	 */
	private String ifspAppno;

	/**
	 * VARCHAR(32)<br>
	 * IFSP订单编号
	 */
	private String ifspOrderNo;

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 申请号
	 */
	public String getAppno() {
		return appno;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 申请号
	 */
	public void setAppno(String appno) {
		this.appno = appno == null ? null : appno.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 工作流实例号
	 */
	public String getPiid() {
		return piid;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 工作流实例号
	 */
	public void setPiid(String piid) {
		this.piid = piid == null ? null : piid.trim();
	}

	/**
	 * CHAR(4)<br>
	 * 获得 申请类型
	 */
	public String getAppliType() {
		return appliType;
	}

	/**
	 * CHAR(4)<br>
	 * 设置 申请类型
	 */
	public void setAppliType(String appliType) {
		this.appliType = appliType == null ? null : appliType.trim();
	}

	/**
	 * VARCHAR(250)<br>
	 * 获得 模板名
	 */
	public String getProcessTemplateName() {
		return processTemplateName;
	}

	/**
	 * VARCHAR(250)<br>
	 * 设置 模板名
	 */
	public void setProcessTemplateName(String processTemplateName) {
		this.processTemplateName = processTemplateName == null ? null : processTemplateName.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 业务编号类型：01-主合同号、02-质押合同号、03-协议编号、04-客户号
	 */
	public String getBusinessnoType() {
		return businessnoType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 业务编号类型：01-主合同号、02-质押合同号、03-协议编号、04-客户号
	 */
	public void setBusinessnoType(String businessnoType) {
		this.businessnoType = businessnoType == null ? null : businessnoType.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 业务编号(根据业务编号类型存放对应的值)
	 */
	public String getBusinessno() {
		return businessno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 业务编号(根据业务编号类型存放对应的值)
	 */
	public void setBusinessno(String businessno) {
		this.businessno = businessno == null ? null : businessno.trim();
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
	 * DECIMAL(16,2)<br>
	 * 获得 业务金额
	 */
	public BigDecimal getAmt() {
		return amt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 业务金额
	 */
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 流程发起机构
	 */
	public String getStartBrcode() {
		return startBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 流程发起机构
	 */
	public void setStartBrcode(String startBrcode) {
		this.startBrcode = startBrcode == null ? null : startBrcode.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 流程发起人
	 */
	public String getStartTlrcd() {
		return startTlrcd;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 流程发起人
	 */
	public void setStartTlrcd(String startTlrcd) {
		this.startTlrcd = startTlrcd == null ? null : startTlrcd.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 发起日期
	 */
	public String getStratDate() {
		return stratDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 发起日期
	 */
	public void setStratDate(String stratDate) {
		this.stratDate = stratDate == null ? null : stratDate.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 发起时间
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 发起时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * CHAR(2)<br>
	 * 获得 申请类型
	 */
	public String getAppliStatus() {
		return appliStatus;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 申请类型
	 */
	public void setAppliStatus(String appliStatus) {
		this.appliStatus = appliStatus == null ? null : appliStatus.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 审批机构
	 */
	public String getApproveBrcode() {
		return approveBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 审批机构
	 */
	public void setApproveBrcode(String approveBrcode) {
		this.approveBrcode = approveBrcode == null ? null : approveBrcode.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 审批人
	 */
	public String getApprover() {
		return approver;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 审批人
	 */
	public void setApprover(String approver) {
		this.approver = approver == null ? null : approver.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 审批日期
	 */
	public String getApproveDate() {
		return approveDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 审批日期
	 */
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate == null ? null : approveDate.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 审批时间
	 */
	public Date getApproveTime() {
		return approveTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 审批时间
	 */
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	/**
	 * VARCHAR(30)<br>
	 * 获得 工作流申请号
	 */
	public String getWorkflowAppno() {
		return workflowAppno;
	}

	/**
	 * VARCHAR(30)<br>
	 * 设置 工作流申请号
	 */
	public void setWorkflowAppno(String workflowAppno) {
		this.workflowAppno = workflowAppno == null ? null : workflowAppno.trim();
	}

	/**
	 * CHAR(3)<br>
	 * 获得 申请状态
	 */
	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 申请状态
	 */
	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl == null ? null : appliStatusDtl.trim();
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
	 * CHAR(8)<br>
	 * 获得 申请日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 申请日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate == null ? null : appDate.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 申请人
	 */
	public String getAppTlrcd() {
		return appTlrcd;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 申请人
	 */
	public void setAppTlrcd(String appTlrcd) {
		this.appTlrcd = appTlrcd == null ? null : appTlrcd.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 申请机构
	 */
	public String getAppBrcode() {
		return appBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 申请机构
	 */
	public void setAppBrcode(String appBrcode) {
		this.appBrcode = appBrcode == null ? null : appBrcode.trim();
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
	 * 获得 协议号
	 */
	public String getProtocolNo() {
		return protocolNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 协议号
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo == null ? null : protocolNo.trim();
	}

	/**
	 * CHAR(4)<br>
	 * 获得 供应链产品类型
	 */
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	/**
	 * CHAR(4)<br>
	 * 设置 供应链产品类型
	 */
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
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
	 * VARCHAR(50)<br>
	 * 获得 信贷系统流水号
	 */
	public String getIncomeAppno() {
		return incomeAppno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 信贷系统流水号
	 */
	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno == null ? null : incomeAppno.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 监管公司客户号
	 */
	public String getMoniCustcd() {
		return moniCustcd;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 监管公司客户号
	 */
	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 质押模式：1-动态、2-静态
	 */
	public String getPledgeMode() {
		return pledgeMode;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 质押模式：1-动态、2-静态
	 */
	public void setPledgeMode(String pledgeMode) {
		this.pledgeMode = pledgeMode == null ? null : pledgeMode.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 关联协议号
	 */
	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 关联协议号
	 */
	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo == null ? null : otherProtocolNo.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 扩展字段1
	 */
	public String getExt1() {
		return ext1;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 扩展字段1
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1 == null ? null : ext1.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 扩展字段2
	 */
	public String getExt2() {
		return ext2;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 扩展字段2
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2 == null ? null : ext2.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 扩展字段3
	 */
	public String getExt3() {
		return ext3;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 扩展字段3
	 */
	public void setExt3(String ext3) {
		this.ext3 = ext3 == null ? null : ext3.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 网银流水号
	 */
	public String getEbankAppno() {
		return ebankAppno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 网银流水号
	 */
	public void setEbankAppno(String ebankAppno) {
		this.ebankAppno = ebankAppno == null ? null : ebankAppno.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 信贷合同号
	 */
	public String getMastContcode() {
		return mastContcode;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 信贷合同号
	 */
	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode == null ? null : mastContcode.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 渠道标识：1-供应链、2-企业网银、3-信贷系统
	 */
	public String getChannelFlag() {
		return channelFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 渠道标识：1-供应链、2-企业网银、3-信贷系统
	 */
	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag == null ? null : channelFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 流程是否结束：0-否、1-是
	 */
	public String getIsFlowEnd() {
		return isFlowEnd;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 流程是否结束：0-否、1-是
	 */
	public void setIsFlowEnd(String isFlowEnd) {
		this.isFlowEnd = isFlowEnd == null ? null : isFlowEnd.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 IFSP申请号
	 */
	public String getIfspAppno() {
		return ifspAppno;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 IFSP申请号
	 */
	public void setIfspAppno(String ifspAppno) {
		this.ifspAppno = ifspAppno == null ? null : ifspAppno.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 IFSP订单编号
	 */
	public String getIfspOrderNo() {
		return ifspOrderNo;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 IFSP订单编号
	 */
	public void setIfspOrderNo(String ifspOrderNo) {
		this.ifspOrderNo = ifspOrderNo == null ? null : ifspOrderNo.trim();
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMoniCname() {
		return moniCname;
	}

	public void setMoniCname(String moniCname) {
		this.moniCname = moniCname;
	}

	public String getSupplyChainPdName() {
		return supplyChainPdName;
	}

	public void setSupplyChainPdName(String supplyChainPdName) {
		this.supplyChainPdName = supplyChainPdName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", appno=").append(appno);
		sb.append(", piid=").append(piid);
		sb.append(", appliType=").append(appliType);
		sb.append(", processTemplateName=").append(processTemplateName);
		sb.append(", businessnoType=").append(businessnoType);
		sb.append(", businessno=").append(businessno);
		sb.append(", custcd=").append(custcd);
		sb.append(", amt=").append(amt);
		sb.append(", startBrcode=").append(startBrcode);
		sb.append(", startTlrcd=").append(startTlrcd);
		sb.append(", stratDate=").append(stratDate);
		sb.append(", startTime=").append(startTime);
		sb.append(", appliStatus=").append(appliStatus);
		sb.append(", approveBrcode=").append(approveBrcode);
		sb.append(", approver=").append(approver);
		sb.append(", approveDate=").append(approveDate);
		sb.append(", approveTime=").append(approveTime);
		sb.append(", workflowAppno=").append(workflowAppno);
		sb.append(", appliStatusDtl=").append(appliStatusDtl);
		sb.append(", curcd=").append(curcd);
		sb.append(", appDate=").append(appDate);
		sb.append(", appTlrcd=").append(appTlrcd);
		sb.append(", appBrcode=").append(appBrcode);
		sb.append(", bailAmount=").append(bailAmount);
		sb.append(", slaveContno=").append(slaveContno);
		sb.append(", mastContno=").append(mastContno);
		sb.append(", protocolNo=").append(protocolNo);
		sb.append(", supplyChainPdId=").append(supplyChainPdId);
		sb.append(", memo=").append(memo);
		sb.append(", incomeAppno=").append(incomeAppno);
		sb.append(", moniCustcd=").append(moniCustcd);
		sb.append(", pledgeMode=").append(pledgeMode);
		sb.append(", otherProtocolNo=").append(otherProtocolNo);
		sb.append(", ext1=").append(ext1);
		sb.append(", ext2=").append(ext2);
		sb.append(", ext3=").append(ext3);
		sb.append(", ebankAppno=").append(ebankAppno);
		sb.append(", mastContcode=").append(mastContcode);
		sb.append(", channelFlag=").append(channelFlag);
		sb.append(", isFlowEnd=").append(isFlowEnd);
		sb.append(", ifspAppno=").append(ifspAppno);
		sb.append(", ifspOrderNo=").append(ifspOrderNo);
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
		BPbcAppliBaseInfo other = (BPbcAppliBaseInfo) that;
		return (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
				&& (this.getPiid() == null ? other.getPiid() == null : this.getPiid().equals(other.getPiid()))
				&& (this.getAppliType() == null ? other.getAppliType() == null : this.getAppliType().equals(other.getAppliType()))
				&& (this.getProcessTemplateName() == null ? other.getProcessTemplateName() == null
						: this.getProcessTemplateName().equals(other.getProcessTemplateName()))
				&& (this.getBusinessnoType() == null ? other.getBusinessnoType() == null : this.getBusinessnoType().equals(other.getBusinessnoType()))
				&& (this.getBusinessno() == null ? other.getBusinessno() == null : this.getBusinessno().equals(other.getBusinessno()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getAmt() == null ? other.getAmt() == null : this.getAmt().equals(other.getAmt()))
				&& (this.getStartBrcode() == null ? other.getStartBrcode() == null : this.getStartBrcode().equals(other.getStartBrcode()))
				&& (this.getStartTlrcd() == null ? other.getStartTlrcd() == null : this.getStartTlrcd().equals(other.getStartTlrcd()))
				&& (this.getStratDate() == null ? other.getStratDate() == null : this.getStratDate().equals(other.getStratDate()))
				&& (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
				&& (this.getAppliStatus() == null ? other.getAppliStatus() == null : this.getAppliStatus().equals(other.getAppliStatus()))
				&& (this.getApproveBrcode() == null ? other.getApproveBrcode() == null : this.getApproveBrcode().equals(other.getApproveBrcode()))
				&& (this.getApprover() == null ? other.getApprover() == null : this.getApprover().equals(other.getApprover()))
				&& (this.getApproveDate() == null ? other.getApproveDate() == null : this.getApproveDate().equals(other.getApproveDate()))
				&& (this.getApproveTime() == null ? other.getApproveTime() == null : this.getApproveTime().equals(other.getApproveTime()))
				&& (this.getWorkflowAppno() == null ? other.getWorkflowAppno() == null : this.getWorkflowAppno().equals(other.getWorkflowAppno()))
				&& (this.getAppliStatusDtl() == null ? other.getAppliStatusDtl() == null : this.getAppliStatusDtl().equals(other.getAppliStatusDtl()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
				&& (this.getAppTlrcd() == null ? other.getAppTlrcd() == null : this.getAppTlrcd().equals(other.getAppTlrcd()))
				&& (this.getAppBrcode() == null ? other.getAppBrcode() == null : this.getAppBrcode().equals(other.getAppBrcode()))
				&& (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
				&& (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
				&& (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
				&& (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
				&& (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null
						: this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
				&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
				&& (this.getIncomeAppno() == null ? other.getIncomeAppno() == null : this.getIncomeAppno().equals(other.getIncomeAppno()))
				&& (this.getMoniCustcd() == null ? other.getMoniCustcd() == null : this.getMoniCustcd().equals(other.getMoniCustcd()))
				&& (this.getPledgeMode() == null ? other.getPledgeMode() == null : this.getPledgeMode().equals(other.getPledgeMode()))
				&& (this.getOtherProtocolNo() == null ? other.getOtherProtocolNo() == null
						: this.getOtherProtocolNo().equals(other.getOtherProtocolNo()))
				&& (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
				&& (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
				&& (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
				&& (this.getEbankAppno() == null ? other.getEbankAppno() == null : this.getEbankAppno().equals(other.getEbankAppno()))
				&& (this.getMastContcode() == null ? other.getMastContcode() == null : this.getMastContcode().equals(other.getMastContcode()))
				&& (this.getChannelFlag() == null ? other.getChannelFlag() == null : this.getChannelFlag().equals(other.getChannelFlag()))
				&& (this.getIsFlowEnd() == null ? other.getIsFlowEnd() == null : this.getIsFlowEnd().equals(other.getIsFlowEnd()))
				&& (this.getIfspAppno() == null ? other.getIfspAppno() == null : this.getIfspAppno().equals(other.getIfspAppno()))
				&& (this.getIfspOrderNo() == null ? other.getIfspOrderNo() == null : this.getIfspOrderNo().equals(other.getIfspOrderNo()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
		result = prime * result + ((getPiid() == null) ? 0 : getPiid().hashCode());
		result = prime * result + ((getAppliType() == null) ? 0 : getAppliType().hashCode());
		result = prime * result + ((getProcessTemplateName() == null) ? 0 : getProcessTemplateName().hashCode());
		result = prime * result + ((getBusinessnoType() == null) ? 0 : getBusinessnoType().hashCode());
		result = prime * result + ((getBusinessno() == null) ? 0 : getBusinessno().hashCode());
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getAmt() == null) ? 0 : getAmt().hashCode());
		result = prime * result + ((getStartBrcode() == null) ? 0 : getStartBrcode().hashCode());
		result = prime * result + ((getStartTlrcd() == null) ? 0 : getStartTlrcd().hashCode());
		result = prime * result + ((getStratDate() == null) ? 0 : getStratDate().hashCode());
		result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
		result = prime * result + ((getAppliStatus() == null) ? 0 : getAppliStatus().hashCode());
		result = prime * result + ((getApproveBrcode() == null) ? 0 : getApproveBrcode().hashCode());
		result = prime * result + ((getApprover() == null) ? 0 : getApprover().hashCode());
		result = prime * result + ((getApproveDate() == null) ? 0 : getApproveDate().hashCode());
		result = prime * result + ((getApproveTime() == null) ? 0 : getApproveTime().hashCode());
		result = prime * result + ((getWorkflowAppno() == null) ? 0 : getWorkflowAppno().hashCode());
		result = prime * result + ((getAppliStatusDtl() == null) ? 0 : getAppliStatusDtl().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
		result = prime * result + ((getAppTlrcd() == null) ? 0 : getAppTlrcd().hashCode());
		result = prime * result + ((getAppBrcode() == null) ? 0 : getAppBrcode().hashCode());
		result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
		result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
		result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
		result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
		result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
		result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
		result = prime * result + ((getIncomeAppno() == null) ? 0 : getIncomeAppno().hashCode());
		result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
		result = prime * result + ((getPledgeMode() == null) ? 0 : getPledgeMode().hashCode());
		result = prime * result + ((getOtherProtocolNo() == null) ? 0 : getOtherProtocolNo().hashCode());
		result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
		result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
		result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
		result = prime * result + ((getEbankAppno() == null) ? 0 : getEbankAppno().hashCode());
		result = prime * result + ((getMastContcode() == null) ? 0 : getMastContcode().hashCode());
		result = prime * result + ((getChannelFlag() == null) ? 0 : getChannelFlag().hashCode());
		result = prime * result + ((getIsFlowEnd() == null) ? 0 : getIsFlowEnd().hashCode());
		result = prime * result + ((getIfspAppno() == null) ? 0 : getIfspAppno().hashCode());
		result = prime * result + ((getIfspOrderNo() == null) ? 0 : getIfspOrderNo().hashCode());
		return result;
	}
}