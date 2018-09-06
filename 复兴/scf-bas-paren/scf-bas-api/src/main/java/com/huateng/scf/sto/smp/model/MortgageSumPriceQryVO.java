package com.huateng.scf.sto.smp.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class MortgageSumPriceQryVO extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String monitorProtocolNo;
	private String otherProtocolNo;
	private String status;
	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}
	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}
	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}
	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
