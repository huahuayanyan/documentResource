package com.huateng.scf.bas.lan.model;

import java.math.BigDecimal;

/**
 * <p>显示放款列表的VO对象，页面需要显示那些字段信息，就定义那些字段</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月10日下午2:48:41
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月10日下午2:48:41              新增
 *
 * </pre>
 */
public class LoanApplyListVO {
	private String appno; // 申请号
	private String cname; // 客户名称
	private String custcd; // 客户号
	private String incomeAppno; // 出账流水号
	private String debetId; // 借据号/承兑协议号
	private String mastContcode; // 信贷合同号
	private String mastContno; // 合同号
	private String supplyChainPdId; // 业务种类
	private String productName; // 业务种类
	private String curcd; // 币种
	private BigDecimal contAmount; // 信贷合同金额
	private String loanWay; // 出账方式
	private String appliStatusDtl; // 审批状态
	private BigDecimal riskAmt; // 信贷合同总敞口
	private BigDecimal avaliableRiskAmt; // 信贷合同可用敞口（需要实时计算）
	private BigDecimal lnciAmt;  //出账金额
	private String businessNo;  //业务合同号。现货、汽车货押存的是担保合同号
	private String slaveContcode;  //纸质业务合同号（显示用）
	private String slaveContno;  //纸质业务合同号（显示用）
	private String protocolNo; //协议信息
	private String creditCustcd; //间接额度占用方客户号(核心客户号)，此处放CUSTCD
	private String debetNo;//借据号
	private String creditUseBal;//间接额度可用额度
	private String hasIndirectCredit;//间接额度类型
	private String flag;//是否有领用额度 1，有 0无
	
	
	
	public String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}

	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getIncomeAppno() {
		return incomeAppno;
	}

	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
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

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
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

	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

	public BigDecimal getRiskAmt() {
		return riskAmt;
	}

	public void setRiskAmt(BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}

	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}

	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getCreditCustcd() {
		return creditCustcd;
	}

	public void setCreditCustcd(String creditCustcd) {
		this.creditCustcd = creditCustcd;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public String getCreditUseBal() {
		return creditUseBal;
	}

	public void setCreditUseBal(String creditUseBal) {
		this.creditUseBal = creditUseBal;
	}

	public String getHasIndirectCredit() {
		return hasIndirectCredit;
	}

	public void setHasIndirectCredit(String hasIndirectCredit) {
		this.hasIndirectCredit = hasIndirectCredit;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
