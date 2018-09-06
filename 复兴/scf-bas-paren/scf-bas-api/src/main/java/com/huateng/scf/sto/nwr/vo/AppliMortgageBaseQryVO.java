/*
 * 功  能：简单说明该类的功能
 *
 * 文件名：AppliMortgageBaseQry.java
 *
 * 描  述：
 *
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2013-5-10   topcheer   hjf      create
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2013 topcheer All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               topcheer      │
 *└──────────────────────────────—————————————————————───┘
 */

package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 *
 * 在这里添加类的文档注释
 *
 * @author <a href="mailto:jianfeng.huang@topscf.com">jianfeng.huang</a>
 *
 * @version Revision: 1.0  Date: 2013-5-18 下午3:14:49
 *
 */

public class AppliMortgageBaseQryVO extends CommonQryVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appno_Q;
	private String appno;
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getAppno_Q() {
		return appno_Q;
	}
	public void setAppno_Q(String appno_Q) {
		this.appno_Q = appno_Q;
	}
	private String billno;
	private String appliMortBizType;
	private String status;
	private String id;
	private String monitorProtocolNo;
	private String mortgageNo;
	private String moniModel;
	private String type;
	private Boolean selectFlag;
	private String isSlExibition;   //是否二级展场
	public String getIsSlExibition() {
		return isSlExibition;
	}
	public void setIsSlExibition(String isSlExibition) {
		this.isSlExibition = isSlExibition;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getAppliMortBizType() {
		return appliMortBizType;
	}
	public void setAppliMortBizType(String appliMortBizType) {
		this.appliMortBizType = appliMortBizType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}
	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}
	public String getMortgageNo() {
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}
	public String getMoniModel() {
		return moniModel;
	}
	public void setMoniModel(String moniModel) {
		this.moniModel = moniModel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getSelectFlag() {
		return selectFlag;
	}
	public void setSelectFlag(Boolean selectFlag) {
		this.selectFlag = selectFlag;
	}
}
