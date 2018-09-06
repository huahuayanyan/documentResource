/**
 * 
 */
package com.huateng.scf.bas.lan.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月11日下午4:18:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月11日下午4:18:34              新增
 *
 * </pre>
 */
public class MortgageLnciBaseInfoVO extends BLanAppliLnciBase{
	
	private String taskComment;//审批意见
	
	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	private static final long serialVersionUID = 2131323077207824358L;
	private BigDecimal bailPercent;// 保证金比例
	private String cname;// 出质人名称
	private String mastContcode;// 信贷合同号
	private String mastContno; // 信贷合同号
	private String businessNo;// 业务合同号
	private BigDecimal contAmount;// 合同金额
	private BigDecimal avaliableRiskAmt;// 信贷合同可用敞口
	private BigDecimal contRiskAmt;// 信贷合同总敞口
	private String loanWay;// 出账方式
	private String incomeAppno;// 出账流水号，信贷系统返回
	private String appliStatusDtl;// 审批状态
	private String mastContStatus;// 信贷合同状态
	private String creditProtNo;// 额度协议流水号
	private String contStartDate; // 信贷合同生效日
	private String contEndDate; // 信贷合同到期日
	private String protocolNo; // 监管合同号
	private String protocolCode; // 纸质监管合同号
	private String slaveContcode; // 业务合同号
	private String cycle; // 额度循环标志
	private BigDecimal ration; // 质押率
	private String moniCustcd; // 监管公司客户号
	private String moniName; // 监管公司名称
	private BigDecimal mortgageTotalValue; // 现货押品总价值
	private String supplyChainPdId; //产品ID
	private BigDecimal lowPriceNew;//最低控货价值
	private String hasIndirectCredit; //预付款：间接额度类型:有、无
	private BigDecimal indirectCreaditLastAmt; //预付款:间接额度余额
	private String assureCname; //预付款：担保方名称
	private BigDecimal openAmount;   // 该笔业务合同的敞口余额
	private String appBrcode;  //申请机构号 
	private String productName;  //产品名称
	
	
	public String getAppBrcode() {
		return appBrcode;
	}


	public void setAppBrcode(String appBrcode) {
		this.appBrcode = appBrcode;
	}


	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	

	public BigDecimal getOpenAmount() {
		return openAmount;
	}


	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}


	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public BigDecimal getBailPercent() {
		return bailPercent;
	}

	public void setBailPercent(BigDecimal bailPercent) {
		this.bailPercent = bailPercent;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public BigDecimal getContAmount() {
		return contAmount;
	}

	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getIncomeAppno() {
		return incomeAppno;
	}

	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}

	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

	public String getMastContStatus() {
		return mastContStatus;
	}

	public void setMastContStatus(String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}

	public String getCreditProtNo() {
		return creditProtNo;
	}

	public void setCreditProtNo(String creditProtNo) {
		this.creditProtNo = creditProtNo;
	}

	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}

	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}

	public String getContStartDate() {
		return contStartDate;
	}

	public void setContStartDate(String contStartDate) {
		this.contStartDate = contStartDate;
	}

	public String getContEndDate() {
		return contEndDate;
	}

	public void setContEndDate(String contEndDate) {
		this.contEndDate = contEndDate;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public String getMoniName() {
		return moniName;
	}

	public void setMoniName(String moniName) {
		this.moniName = moniName;
	}

	public BigDecimal getMortgageTotalValue() {
		return mortgageTotalValue;
	}

	public void setMortgageTotalValue(BigDecimal mortgageTotalValue) {
		this.mortgageTotalValue = mortgageTotalValue;
	}

	public BigDecimal getContRiskAmt() {
		return contRiskAmt;
	}

	public void setContRiskAmt(BigDecimal contRiskAmt) {
		this.contRiskAmt = contRiskAmt;
	}

	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	public String getHasIndirectCredit() {
		return hasIndirectCredit;
	}

	public void setHasIndirectCredit(String hasIndirectCredit) {
		this.hasIndirectCredit = hasIndirectCredit;
	}

	public BigDecimal getIndirectCreaditLastAmt() {
		return indirectCreaditLastAmt;
	}

	public void setIndirectCreaditLastAmt(BigDecimal indirectCreaditLastAmt) {
		this.indirectCreaditLastAmt = indirectCreaditLastAmt;
	}

	public String getAssureCname() {
		return assureCname;
	}

	public void setAssureCname(String assureCname) {
		this.assureCname = assureCname;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}
