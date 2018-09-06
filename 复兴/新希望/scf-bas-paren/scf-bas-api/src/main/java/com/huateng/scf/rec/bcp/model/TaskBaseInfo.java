package com.huateng.scf.rec.bcp.model;

import java.io.Serializable;

public class TaskBaseInfo implements Serializable{
    private static final long serialVersionUID = 1L;

	private String flowName;//流程名称
	private String requestTime;//申请发起时间
	private String opStaff;//经办人
	private String opOrg;//经办机构
	private String businessnoType;
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getOpStaff() {
		return opStaff;
	}
	public void setOpStaff(String opStaff) {
		this.opStaff = opStaff;
	}
	public String getOpOrg() {
		return opOrg;
	}
	public void setOpOrg(String opOrg) {
		this.opOrg = opOrg;
	}
	public String getBusinessnoType() {
		return businessnoType;
	}
	public void setBusinessnoType(String businessnoType) {
		this.businessnoType = businessnoType;
	}
	
}
