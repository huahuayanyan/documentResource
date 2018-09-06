package com.huateng.scf.adv.wrn.dao.model;

import com.huateng.scf.bas.common.dao.model.CommonQryVO;

public class DownLowPriceNewQryVO extends CommonQryVO {

	private String startDate_Q;
	private String endDate_Q;
	private String custName_Q;
	private String slaveContcode_Q;
	private String moniCname_Q;
	private String warnNo_Q;
	private String warnLevel_Q;

	public String getStartDate_Q() {
		return startDate_Q;
	}

	public void setStartDate_Q(String startDate_Q) {
		this.startDate_Q = startDate_Q;
	}

	public String getEndDate_Q() {
		return endDate_Q;
	}

	public void setEndDate_Q(String endDate_Q) {
		this.endDate_Q = endDate_Q;
	}

	public String getCustName_Q() {
		return custName_Q;
	}

	public void setCustName_Q(String custName_Q) {
		this.custName_Q = custName_Q;
	}

	public String getSlaveContcode_Q() {
		return slaveContcode_Q;
	}

	public void setSlaveContcode_Q(String slaveContcode_Q) {
		this.slaveContcode_Q = slaveContcode_Q;
	}

	public String getMoniCname_Q() {
		return moniCname_Q;
	}

	public void setMoniCname_Q(String moniCname_Q) {
		this.moniCname_Q = moniCname_Q;
	}

	public String getWarnNo_Q() {
		return warnNo_Q;
	}

	public void setWarnNo_Q(String warnNo_Q) {
		this.warnNo_Q = warnNo_Q;
	}

	public String getWarnLevel_Q() {
		return warnLevel_Q;
	}

	public void setWarnLevel_Q(String warnLevel_Q) {
		this.warnLevel_Q = warnLevel_Q;
	}

}
