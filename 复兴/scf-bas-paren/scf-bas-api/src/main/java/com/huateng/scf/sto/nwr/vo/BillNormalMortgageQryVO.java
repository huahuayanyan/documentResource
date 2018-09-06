package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class BillNormalMortgageQryVO extends CommonQryVO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String billno;
	private String status;
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
