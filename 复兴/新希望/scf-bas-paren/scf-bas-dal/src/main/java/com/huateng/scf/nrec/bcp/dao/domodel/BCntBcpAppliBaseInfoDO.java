package com.huateng.scf.nrec.bcp.dao.domodel;

import com.huateng.scf.nrec.bcp.dao.model.BCntBcpAppliBaseInfo;

public class BCntBcpAppliBaseInfoDO extends BCntBcpAppliBaseInfo{
    private static final long serialVersionUID = 1L;

    private String cname;
    private String businessCname;
    private String startTlrNm;
    private String startBrName;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getBusinessCname() {
		return businessCname;
	}
	public void setBusinessCname(String businessCname) {
		this.businessCname = businessCname;
	}
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
}