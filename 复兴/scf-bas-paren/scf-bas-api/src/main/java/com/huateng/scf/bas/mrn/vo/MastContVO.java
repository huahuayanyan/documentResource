package com.huateng.scf.bas.mrn.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.crr.model.BCrrLnCon;

/**
 * 主合同结果VO
 * 
 * @author <a href="mailto:xiong_xiaolong@topscf.com">xiong_xiaolong</a>
 * 
 * @version Revision: 1.0 Date: 2013-5-10 下午1:34:24
 * 
 */

public class MastContVO extends BCrrLnCon {

	private static final long serialVersionUID = -156301517378916021L;
	private String custno;// 外部客户号
	private String cname;// 客户名称
	private String appno;// 申请编号
	private String subContno;// 放款合同号
	private BigDecimal bailAmount;// 保证金金额
	private BigDecimal openAmount;// 敞口金额
	private BigDecimal amt;// 业务发生额
	private String secCustcd;// 卖方客户号
	private String secCname;// 卖方客户名称
	private String bussType;// 业务品种
	private String parentId; //业务中类
	private String loanWay;//出账方式
	
	/**
	 * 新增产品名称supplyChainPdNm
	 */
	private String supplyChainPdNm;

	public String getSupplyChainPdNm() {
		return supplyChainPdNm;
	}

	public void setSupplyChainPdNm(String supplyChainPdNm) {
		this.supplyChainPdNm = supplyChainPdNm;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getSubContno() {
		return subContno;
	}

	public void setSubContno(String subContno) {
		this.subContno = subContno;
	}

	public String getSecCustcd() {
		return secCustcd;
	}

	public void setSecCustcd(String secCustcd) {
		this.secCustcd = secCustcd;
	}

	public String getSecCname() {
		return secCname;
	}

	public void setSecCname(String secCname) {
		this.secCname = secCname;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
