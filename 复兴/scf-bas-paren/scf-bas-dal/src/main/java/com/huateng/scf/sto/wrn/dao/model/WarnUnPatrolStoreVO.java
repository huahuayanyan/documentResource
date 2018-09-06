package com.huateng.scf.sto.wrn.dao.model;

import java.util.Date;

/**
 * @author htrad0055
 *	未询库提示
 */
/**
 * @author htrad0055
 *
 */
public class WarnUnPatrolStoreVO {
	private String slaveContcode;
	private String custcd;
	private String cname;
	private String moniCustcd;
	private String moniCname;
	private String protocolNo;
	private String inspectFrequence;
	private String lastDate;
	private String warnDate;
	private String custManager;
	private String mgrNm;
	private String brcode;
	private String brcodeNm;

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getInspectFrequence() {
		return inspectFrequence;
	}

	public void setInspectFrequence(String inspectFrequence) {
		this.inspectFrequence = inspectFrequence;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(String warnDate) {
		this.warnDate = warnDate;
	}

	public String getCustManager() {
		return custManager;
	}

	public void setCustManager(String custManager) {
		this.custManager = custManager;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
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

	public String getMgrNm() {
		return mgrNm;
	}

	public void setMgrNm(String mgrNm) {
		this.mgrNm = mgrNm;
	}

	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

}
