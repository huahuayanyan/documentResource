package com.huateng.scf.nrec.bcp.dao.domodel;

import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussInfo;

public class RBcpDebtBussInfoDO extends RBcpDebtBussInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * CHAR(2)<br>
	 * 应收账款单据状态：01-已录入、02-已转让/出质、03-已核销、04-已融资
	 */
	private String status;
	
	/**
	 * VARCHAR(50)<br>
	 * 卖方客户名称
	 */
	private String cnameSeller;
	
	
	/**
	 * VARCHAR(50)<br>
	 * 买方客户名称
	 */
	private String cnameBuyer;
	
	
	/**
	 * VARCHAR(2)<br>
	 * 融资出账方式
	 */
	private String loanWay;
	
	
	/**
	 * CHAR(2)<br>
	 * 获得 应收账款单据状态：01-已录入、02-已转让/出质、03-已核销、04-已融资
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 应收账款单据状态：01-已录入、02-已转让/出质、03-已核销、04-已融资
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
	
	/**
	 * VARCHAR(50)<br>
	 * 获得 卖方客户名称
	 */
	public String getCnameSeller() {
		return cnameSeller;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 卖方客户名称
	 */
	public void setCnameSeller(String cnameSeller) {
		this.cnameSeller = cnameSeller == null ? null : cnameSeller.trim();
	}
	
	
	/**
	 * VARCHAR(50)<br>
	 * 获得 买方客户名称
	 */
	public String getCnameBuyer() {
		return cnameBuyer;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 买方客户名称
	 */
	public void setCnameBuyer(String cnameBuyer) {
		this.cnameBuyer = cnameBuyer == null ? null : cnameBuyer.trim();
	}
	
	/**
	 * VARCHAR(2)<br>
	 * 获得 融资出账方式
	 */
	public String getLoanWay() {
		return loanWay;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 融资出账方式
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay == null ? null : loanWay.trim();
	}

}
